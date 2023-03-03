package coen241.calendarApp.repository;

import coen241.calendarApp.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;


public interface EventRepository extends CrudRepository<Event, Integer> {

    List<Event> findAll();
    Event findByEventId(long eventId);
    List<Event> findByPublisherId(long publisherId);
    List<Event> findByLocation(String location);
    List<Event> findByEventDate(Date date);
    List<Event> findByValid(long valid);

//    @Query("SELECT e FROM com.example.calendartest.model.Event e WHERE e.startTime BETWEEN ?1 AND ?2")
//    List<Event> findByLevelBetween(int start, int end);

//    @Transactional
//    @Modifying
//    @Query("UPDATE Events e SET e.valid=0 WHERE e.event_id=?1")
//    int unpublishEvent(Long id);


}
