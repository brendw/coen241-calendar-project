package coen241.calendarApp.model;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

@Entity
@Table(name="Events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long eventId;
    @Column(name = "event_name")
    String eventName;
    @Column(name = "publisher_id")
    int publisherId;
    @Column(name = "image")
    String image; //url
    @Column(name = "description")
    String description;
    @Column(name = "location")
    String location;
    @Column(name = "create_date")
    Timestamp createDate;
    @Column(name = "event_date")
    Date eventDate;
    @Column(name = "start_time")
    Time startTime;
    @Column(name = "end_time")
    Time endTime;
    @Column(name = "valid")
    Integer valid;

//    ArrayList<Integer> tags; //list of tagIds associated with this event
//    ArrayList<Integer> RSVPs; //list of userIds of users who are registered


    protected Event() {}
    public Event(String eventName, int publisherId, String image, String description, String location,
            Date eventDate, Time startTime, Time endTime, Integer valid) {

    }

    @Override
    public String toString() {
        return "Event [eventId=" + eventId + ", eventName=" + eventName + ", publisherId=" + publisherId + ", location=" + location
                + ", eventDate=" + eventDate + ", startTime=" + startTime + ", endTime=" + endTime + ", valid=" + valid + "]";
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public void publishEvent() {

    }
    public void editEvent() {

    }
    public void deleteEvent() {

    }

}
