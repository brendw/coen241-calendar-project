package coen241.calendarApp.repository;

import coen241.calendarApp.model.EventTag;
import coen241.calendarApp.model.RSVP;
import coen241.calendarApp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventTagRepository extends CrudRepository<EventTag, Integer> {

    List<EventTag> findAll();
    User findByEventTagId(long event_tag_id);
    User findByTag(String tag);
    User findByEventId(long event_id);
    void deleteByEventTagId(long event_tag_id);
}
