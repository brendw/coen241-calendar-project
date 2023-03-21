package coen241.calendarApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan("coen241.calendarApp.model")
public class CalendarTestApplication {

    public static void main(String[] args) {

        SpringApplication.run(CalendarTestApplication.class, args);

    }


}
