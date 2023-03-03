package coen241.calendarApp.service;

import coen241.calendarApp.model.User;
import coen241.calendarApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    @Override
    public User getUser(Long id) { return userRepository.findById(id); }

    @Override
    public User updateUser(User user, Long id) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
