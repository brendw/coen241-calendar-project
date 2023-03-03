package coen241.calendarApp.controller;

import coen241.calendarApp.model.User;
import coen241.calendarApp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }


    @GetMapping("/users")
    public List<User> getAllUser()
    {
        return userService.getAllUser();
    }
    @GetMapping("/users/{id}")
    public User get(@PathVariable Long id) {
        User user = userService.getUser(id);
        if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return user;
    }

//    @GetMapping(value="/add-user", method= RequestMethod.POST)
//    public void addUser(@RequestBody User user)
//    {
//        userService.addUser(user);
//    }

}
