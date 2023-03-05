package coen241.calendarApp.repository;

import coen241.calendarApp.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

    List<Event> findAll();
    Event findByEventId(long event_id);
    List<Event> findByPublisher(String publisher);
    List<Event> findByLocation(String location);
    List<Event> findByEventDate(Date date);
    List<Event> findByValid(long valid);

    List<Event> findByEventDateAndLocation(Date date, String location);

    List<Event> findByTag(String tag);
    
    void deleteByEventId(long event_id);

    //Event save(Event event); //return new event object with the id

//    @Query("SELECT e FROM com.example.calendartest.model.Event e WHERE e.startTime BETWEEN ?1 AND ?2")
//    List<Event> findByLevelBetween(int start, int end);

//    @Transactional
//    @Modifying
//    @Query("UPDATE Events e SET e.valid=0 WHERE e.event_id=?1")
//    int unpublishEvent(Long id);


}
