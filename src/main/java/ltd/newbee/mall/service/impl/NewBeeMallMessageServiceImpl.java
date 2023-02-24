package ltd.newbee.mall.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.controller.vo.MessageVo;
import ltd.newbee.mall.dao.NewbeeMallMessageMapper;
import ltd.newbee.mall.entity.Message;
import ltd.newbee.mall.service.NewBeeMallMessageService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class NewBeeMallMessageServiceImpl implements NewBeeMallMessageService {
    @Autowired
    NewbeeMallMessageMapper messageMapper;

    @Override
    public void saveMessages(List<Message> messageList) {
        if (!CollectionUtils.isEmpty(messageList)) {
            messageMapper.insertBatch(messageList);
        }
    }

    @Override
    public PageResult getMyMessage(PageQueryUtil pageQueryUtil) {
        int total = messageMapper.getTotalNewBeeMallMessages(pageQueryUtil);
        List<Message> newBeeMallMessages = messageMapper.findNewBeeMallMessageList(pageQueryUtil);
        Map<Long, Message> goodsMap = newBeeMallMessages.stream()
                .collect(Collectors
                        .toMap(Message::getId, Function.identity(), (o1, o2) -> o1));
        List<MessageVo> messageVoList = Lists.newArrayList();
        if (total > 0) {
            // 数据转换 将实体类转成vo
            messageVoList = BeanUtil.copyList(newBeeMallMessages, MessageVo.class);
            // 设置订单状态中文显示值
            for (MessageVo messageVO : messageVoList) {
                messageVO.setContent(Constants.CUT_PRICE_CONTENT);
                Message message = goodsMap.get(messageVO.getId());
                long goodsId = (Integer)JSON.parseObject(message.getContent(), HashMap.class).get("goodsId");
                messageVO.setGoodsId(goodsId);
            }
        }
        return new PageResult(messageVoList, total, pageQueryUtil.getLimit(), pageQueryUtil.getPage());
    }
}
