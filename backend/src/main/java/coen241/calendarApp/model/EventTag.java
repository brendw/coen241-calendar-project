package coen241.calendarApp.model;

import jakarta.persistence.*;

@Entity
@Table(name="EventTags")
public class EventTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long eventTagId;
    @Column(name = "event_id")
    Long eventId;
    @Column(name = "tag")
    String tag;

    protected EventTag() {}
    public EventTag(Long eventId, String tag) {
        this.eventId = eventId;
        this.tag = tag;
    }
    @Override
    public String toString() {
        return String.format( "EventTag[id=%d, event_id='%s', tag='%s']", eventTagId, eventId, tag);
    }

    public Long getEventTagId() {
        return eventTagId;
    }

    public void setEventTagId(Long event_tag_id) {
        this.eventTagId = event_tag_id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
