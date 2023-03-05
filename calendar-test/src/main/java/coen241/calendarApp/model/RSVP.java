package coen241.calendarApp.model;

import jakarta.persistence.*;

@Entity
@Table(name="RSVP")
public class RSVP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long rsvpId;
    @Column(name = "event_id")
    Long eventId;
    @Column(name = "user_id")
    Long userId;

    protected RSVP() {}
    public RSVP(Long event_id, Long user_id) {
        this.eventId = event_id;
        this.userId = user_id;
    }
    @Override
    public String toString() {
        return String.format( "EventTag[id=%d, event_id='%s', user_id='%s']", rsvpId, eventId, userId);
    }

    public Long getRsvpId() {
        return rsvpId;
    }

    public void setRsvpId(Long rsvp_id) {
        this.rsvpId = rsvpId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
