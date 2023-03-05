package coen241.calendarApp.repository;

import coen241.calendarApp.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {


    private final UserRepository userRepository;
    @Autowired
    public UserRepositoryTest(UserRepository userRepository) { this.userRepository = userRepository;  }

    @Test
    public void saveMethod() {

        User user = new User("eclipse", "pass", "eclipse@yahoo.com");
        User savedUser =  userRepository.save(user);
        System.out.println(savedUser.getUserId());
        System.out.println(savedUser.toString());
    }

}
