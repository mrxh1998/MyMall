package ltd.newbee.mall.entity;

import java.util.Date;

public class Message {
    private long id;
    private long fromId;
    private long toId;
    private String conversationId;
    private String messageContent;
    private int status;
    private Date createTime;

    public Message() {
    }

    public Message(long id, long fromId, long toId, String conversationId, String content, int status, Date createTime) {
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.conversationId = conversationId;
        this.messageContent = content;
        this.status = status;
        this.createTime = createTime;
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

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getContent() {
        return messageContent;
    }

    public void setContent(String content) {
        this.messageContent = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
