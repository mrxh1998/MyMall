package ltd.newbee.mall.service;

import ltd.newbee.mall.entity.Message;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

import java.util.List;

public interface NewBeeMallMessageService {
    public void saveMessages(List<Message> messageList);

    public PageResult getMyMessage(PageQueryUtil pageQueryUtil);
}
