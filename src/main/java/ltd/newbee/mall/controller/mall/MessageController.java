package ltd.newbee.mall.controller.mall;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.controller.vo.NewBeeMallUserVO;
import ltd.newbee.mall.entity.MallUser;
import ltd.newbee.mall.service.NewBeeMallMessageService;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class MessageController {
    @Autowired
    private NewBeeMallMessageService newBeeMallMessageService;
    @GetMapping("/messages")
    public String messagePage(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpSession httpSession) {
        NewBeeMallUserVO user = (NewBeeMallUserVO) httpSession.getAttribute(Constants.MALL_USER_SESSION_KEY);
        params.put("userId", user.getUserId());
        params.putIfAbsent("page", 1);
        params.put("limit", Constants.ORDER_SEARCH_PAGE_LIMIT);
        //封装我的消息数据
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        request.setAttribute("messagePageResult", newBeeMallMessageService.getMyMessage(pageUtil));
        request.setAttribute("path", "messages");
        return "mall/my-messages";
    }
}
