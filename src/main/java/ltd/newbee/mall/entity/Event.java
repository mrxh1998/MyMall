package ltd.newbee.mall.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Event {
    private String topic;
    private long userId;
    private long entityId;
    private long entityType;

    public Set<Long> getEntityUserIds() {
        return entityUserIds;
    }

    public Event setEntityUserIds(Set<Long> entityUserIds) {
        this.entityUserIds = entityUserIds;
        return this;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    private long entityUserId;
    private Set<Long> entityUserIds;
    private Map<String,Object> map = new HashMap<>();

    public String getTopic() {
        return topic;
    }

    public Event setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public Event setUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public long getEntityId() {
        return entityId;
    }

    public Event setEntityId(long entityId) {
        this.entityId = entityId;
        return this;
    }

    public long getEntityType() {
        return entityType;
    }

    public Event setEntityType(long entityType) {
        this.entityType = entityType;
        return this;
    }

    public long getEntityUserId() {
        return entityUserId;
    }

    public Event setEntityUserId(long entityUserId) {
        this.entityUserId = entityUserId;
        return this;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public Event setMap(String key,Object value) {
        this.map.put(key,value);
        return this;
    }
}
