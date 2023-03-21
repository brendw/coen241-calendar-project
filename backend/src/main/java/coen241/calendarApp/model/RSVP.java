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
    @Column(name = "username")
    String username;

    protected RSVP() {}
    public RSVP(Long eventId, String username) {
        this.eventId = eventId;
        this.username = username;
    }
    @Override
    public String toString() {
        return String.format( "EventTag[id=%d, event_id='%s', username='%s']", rsvpId, eventId, username);
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
