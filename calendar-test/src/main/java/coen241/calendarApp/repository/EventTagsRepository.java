package coen241.calendarApp.repository;

import coen241.calendarApp.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTagsRepository extends CrudRepository<Event, Integer> {
}
