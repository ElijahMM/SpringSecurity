package com.example.Repos;

import com.example.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by mihai on 29.03.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(nativeQuery = true, value = "SELECT  * from user u where u.username LIKE (:username) AND u.password LIKE (:password)")
    User getUser(@Param("username") String username, @Param("password") String password);

    @Query(nativeQuery = true, value = "SELECT  * from user u where u.username LIKE (:username)")
    User getUserByName(@Param("username") String username);

    @Query(nativeQuery = true, value = "SELECT u.username from user u")
    List<String> getAllUserNames();

    User findOneByUsername(String name);

}
