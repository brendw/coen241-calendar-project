package coen241.calendarApp.model;

import org.springframework.data.domain.Persistable;

//import org.springframework.data.relational.core.mapping.Table;
//import javax.persistence.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false, unique = true)
    private String email;

//    @OneToMany
//    @JoinColumn(name="user_id")
//    List reservedEvents = new ArrayList();
//    ArrayList<Integer> pastEvents;
//    @OneToMany
//    @JoinColumn(name="publisher_id")
//    List postedEvents = new ArrayList();


    protected User() {}

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, username='%s', password='%s', email='%s']",
                id, username, password, email);
    }

    public void register() {

    }
    public void login(String user, String pw) {

    }
    public void logout() {

    }
    public void postEvent() {

    }
    public void registerEvent() {

    }
    public void editEvent() {

    }

    public String getUserPassword(String username) {
        return this.password;
    }

    //---------------------------------------

    public Long getUserId() { return this.id; }
    public void setUserId(Long id) { this.id = id; }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

//    public List getReservedEvents() { return this.reservedEvents; }
//    public List getPostedEvents() {
//        return this.postedEvents;
//    }
//
//
//    public void addReservedEvent(int eventId) {
//        this.reservedEvents.add(eventId);
//    }
//    public ArrayList<Integer> getPastEvents() {
//        return this.pastEvents;
//    }
//    public void addPastEvent(int eventId) {
//        this.pastEvents.add(eventId);
//    }
//
//    public void addPostedEvent(int eventId) {
//        this.postedEvents.add(eventId);
//    }
}
