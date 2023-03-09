package coen241.calendarApp.repository;

import coen241.calendarApp.model.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class EventRepositoryTest {


    private final EventRepository eventRepository;
    @Autowired
    public EventRepositoryTest(EventRepository eventRepository) { this.eventRepository = eventRepository;  }

    @Test
    public void searchByParamsMethod() {

        List<String> dates = new ArrayList<String>();
        List<String> locations = new ArrayList<String>();
        List<String> tags = new ArrayList<String>();

        dates.add("2023-02-22");
        tags.add("Clubs");

        List<Event> events = eventRepository.findByEventDateAndLocationAndTag(dates,locations,tags);
        for (Event e : events) {
            System.out.println(e);
        }
    }

}
