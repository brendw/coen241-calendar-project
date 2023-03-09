package coen241.calendarApp.Service;

import coen241.calendarApp.model.Event;
import coen241.calendarApp.repository.EventRepository;
import coen241.calendarApp.repository.UserRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class EventServiceTest {

    private final EventRepository eventRepository;
//    @Autowired
    public EventServiceTest(EventRepository eventRepository) { this.eventRepository = eventRepository; }

    @Test
    public List<Event> getEventsByParamsTest() {

        Map<String, List<String>> params = new HashMap<>();
        params.put("Date", new ArrayList<>(Arrays.asList("2023-02-22")));
        params.put("Location", new ArrayList<>(Arrays.asList("Clubs")));
        params.put("Tag", new ArrayList<>());

        List<String> dates = new ArrayList<String>();
        List<String> locations = new ArrayList<String>();
        List<String> tags = new ArrayList<String>();

        Iterator<Map.Entry<String, List<String>>> itr = params.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<String, List<String>> entry = itr.next();
            if (entry.getKey()=="Date") { dates = entry.getValue();}
            else if (entry.getKey()=="Location") { locations = entry.getValue();}
            else if (entry.getKey()=="Tag") { tags = entry.getValue();}
        }

        return eventRepository.findByEventDateAndLocationAndTag(dates, locations, tags);
    }

}
