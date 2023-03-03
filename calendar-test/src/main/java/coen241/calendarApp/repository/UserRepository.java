package coen241.calendarApp.repository;

import coen241.calendarApp.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAll();
    User findById(long id);
    User findByUsername(String username);
    User findByEmail(String email);
    void deleteById(Long id);

    @Query("SELECT u.password FROM Users u WHERE u.username = :username")
    public String getUserPassword(@Param("username") String username);

//    @Query("SELECT u.password FROM com.example.calendartest.model.User u WHERE u.username = :username")
//    public String getUserPassword(@Param("username") String username);

//    @Modifying
//    @Query(value="INSERT INTO Users (username, password, email) values (:username, :password, :email)", nativeQuery = true)
//    void saveUser(@Param("username") String username, @Param("password") String password, @Param("email") String email);




//    @Modifying(clearAutomatically = true)
//    @Query("UPDATE User u SET u.password = :password  WHERE u.id =:id")
//    void updateUserPasswordForId(@Param("password") String password, @Param("id") int id);

}
