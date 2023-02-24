package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.Message;
import ltd.newbee.mall.entity.NewBeeMallOrderItem;
import ltd.newbee.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewbeeMallMessageMapper {
    int insertBatch(@Param("messageList") List<Message> messageList);

    int getTotalNewBeeMallMessages(PageQueryUtil pageUtil);

    List<Message> findNewBeeMallMessageList(PageQueryUtil pageUtil);
}
