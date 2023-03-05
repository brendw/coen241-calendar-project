package coen241.calendarApp.service;

import coen241.calendarApp.model.User;
import coen241.calendarApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public User saveUser(User userWnullID) {
        System.out.println("before save: " + userWnullID);
//        User user = new User();
//        user.setUsername(savedUser.getUsername());
//        user.setPassword(savedUser.getPassword());
//        user.setEmail(savedUser.getEmail());
        User new_user = userRepository.save(userWnullID);
        System.out.println("after save: " + new_user);
        return new_user;
    }


    public List<User> getAllUser() { return userRepository.findAll(); }
    public User getUser(Long id) { return userRepository.findById(id); }


//    public User updateUser(User user, Long id) {
//        return null;
//    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }



}
