package coen241.calendarApp.repository;

import coen241.calendarApp.model.Event;
import coen241.calendarApp.model.RSVP;
import coen241.calendarApp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RSVPRepository extends CrudRepository<RSVP, Integer> {

    List<RSVP> findAll();
    RSVP findByRsvpId(long rsvp_id);
    List<RSVP> findByUsername(String username);
    List<RSVP> findByEventId(long event_id);
    void deleteByRsvpId(long rsvp_id);

}
