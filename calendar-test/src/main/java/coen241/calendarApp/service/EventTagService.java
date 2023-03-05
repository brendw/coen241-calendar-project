package coen241.calendarApp.service;
import coen241.calendarApp.model.EventTag;
import coen241.calendarApp.repository.EventTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventTagService {

    private final EventTagRepository eventTagRepository;
    @Autowired
    public EventTagService(EventTagRepository eventTagRepository) { this.eventTagRepository = eventTagRepository; }

    public EventTag saveEventTag(EventTag eventtag) {
        return eventTagRepository.save(eventtag);
    }
    public List<EventTag> getAllEventTag() {
        return eventTagRepository.findAll();
    }
}
