package ltd.newbee.mall.controller.vo;

import java.io.Serializable;
import java.util.Date;

public class MessageVo implements Serializable {
    private long id;
    private long fromId;
    private long toId;
    private String content;
    private long goodsId;
    private Date createTime;

    public MessageVo(long id, long fromId, long toId, String content, long goodsId, Date createTime) {
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.content = content;
        this.goodsId = goodsId;
        this.createTime = createTime;
    }

    public MessageVo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFromId() {
        return fromId;
    }

    public void setFromId(long fromId) {
        this.fromId = fromId;
    }

    public long getToId() {
        return toId;
    }

    public void setToId(long toId) {
        this.toId = toId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
