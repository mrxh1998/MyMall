package ltd.newbee.mall.Event;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.entity.Event;
import ltd.newbee.mall.entity.Message;
import ltd.newbee.mall.service.NewBeeMallMessageService;
import org.apache.ibatis.type.JdbcType;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EventConsumer {
    private final static Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    @Autowired
    NewBeeMallMessageService messageService;

    @KafkaListener(topics = {Constants.TOPIC_CUT_PRICE})
    public void handleCommentMessage(ConsumerRecord record){
        if(record == null || record.value()==null){
            logger.error("消息内容为空！");
            return;
        }

        Event event= JSONObject.parseObject(record.value().toString(),Event.class);
        if(event == null){
            logger.error("消息格式错误！");
            return;
        }
        List<Message> messageList = Lists.newArrayList();
        for(long userId : event.getEntityUserIds()){
            Message message = new Message();
            message.setToId(userId);
            message.setFromId(event.getUserId());
            message.setCreateTime(new Date());
            message.setConversationId(event.getTopic());
            Map<String,Object> content = new HashMap<>();
            if(!event.getMap().isEmpty()){
                for(Map.Entry<String,Object> map : event.getMap().entrySet()){
                    content.put(map.getKey(),map.getValue());
                }
            }
            message.setContent(JSONObject.toJSONString(content));
            messageList.add(message);
        }
        messageService.saveMessages(messageList);
    }
}
