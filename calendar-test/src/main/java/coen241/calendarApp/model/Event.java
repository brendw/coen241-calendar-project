package coen241.calendarApp.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Entity
@Table(name="Events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long eventId;
    @Column(name = "event_name")
    String eventName;
    @Column(name = "publisher")
    String publisher;
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
    @Column(name = "url")
    String url;

//    ArrayList<Integer> tags; //list of tagIds associated with this event
//    ArrayList<Integer> RSVPs; //list of userIds of users who are registered


    protected Event() {}
    public Event(String eventName, String publisher, String image, String description, String location,
            Date eventDate, Time startTime, Time endTime, Integer valid, String url) {

    }

    @Override
    public String toString() {
        return "Event [eventId=" + eventId + ", eventName=" + eventName + ", publisher=" + publisher + ", location=" + location
                + ", eventDate=" + eventDate + ", startTime=" + startTime + ", endTime=" + endTime + ", valid=" + valid + ", url=" + url + "]";
    }


//    public void formatTime() {
//        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
//        String new_time = timeFormat.format(this.startTime);
//    }


    //---------------------------------------------------------------------------

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
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
    public String getUrl() {return this.url;}
    public void setURL(String url) {this.url = url;}

}
