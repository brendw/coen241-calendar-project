package coen241.calendarApp.controller;

import coen241.calendarApp.model.User;
import coen241.calendarApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }


    @GetMapping("/")
    public List<User> getAllUser()
    {
        return userService.getAllUser();
    }
    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        User user = userService.getUser(id);
        if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return user;
    }

//    @PathMapping(value="/users/add")
//    public String addUser()
//    {
//        //userService.saveUser(user);
//        return "Add user ~";
//    }
    @RequestMapping("/goodbye")
    public String helloWorld(){
        return "Goodbye from Spring Boot";
    }

    @PostMapping("/testAdd")
    public String addUser() {
        System.out.println("inside testAdd");
        User user = new User("intellij", "password", "intellij@intellij.com");
        System.out.println(user);
        User new_user = userService.saveUser(user);
        return "added a user";
    }

    @PostMapping("/addTest")
    public String addUser(@RequestBody User user) {
        //userService.saveUser(user);
        return "user Added Successfully.";
    }


//    @RequestMapping(method = {POST}, path = "/users/add", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public User saveUser(@Valid @RequestBody User user){
//        return userService.saveUser(user);
//    }

}
