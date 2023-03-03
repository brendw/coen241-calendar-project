package coen241.calendarApp.service;

import coen241.calendarApp.model.User;

import java.util.List;


public interface UserService {

    // save operation
    void saveUser(User user);

    // read operation
    List<User> getAllUser();
    User getUser(Long id);

    // update operation
    User updateUser(User user, Long id);

    // delete operation
    void deleteUserById(Long id);


}
