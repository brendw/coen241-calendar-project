package coen241.calendarApp.service;

import coen241.calendarApp.model.User;
import coen241.calendarApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    // TODO: check that email or username is not already in use (duplicated unique keys return error)
    public User saveUser(User user) { return userRepository.save(user); }


    public List<User> getAllUser() { return userRepository.findAll(); }
    public User getUser(Long id) { return userRepository.findById(id); }


//    public User updateUser(User user, Long id) {
//        return null;
//    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }



}
