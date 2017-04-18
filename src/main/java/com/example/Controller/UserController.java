package com.example.Controller;

import com.example.Models.PublicUser;
import com.example.Models.User;
import com.example.Repos.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mihai on 29.03.2017.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user) {

        List<String> users=userRepository.getAllUserNames();
        if(users.contains(user.getUsername())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already registered");
        }
        User model = new User();
        model.setUsername(user.getUsername());
        model.setPassword(user.getPassword());
        model.setCreatedAt(new Date());
        user.getIdea().setCretedAt(new Date());
        model.setIdea(user.getIdea());
        model.setProfile(user.getProfile());

        userRepository.saveAndFlush(model);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created");
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAllUsers() {

        List<User> allUsers = userRepository.findAll();
        List<PublicUser> publicUsers = new ArrayList<>();
        for (User u : allUsers) {
            PublicUser publicUser = new PublicUser();
            publicUser.setUid(u.getUid());
            publicUser.setUsername(u.getUsername());
            publicUser.setProfile(u.getProfile());
            publicUser.setIdea(u.getIdea());
            publicUsers.add(publicUser);
        }
        return ResponseEntity.status(HttpStatus.OK).body(publicUsers);
    }

    @RequestMapping(value = "/byID/{id}", method = RequestMethod.GET)
    public ResponseEntity getUserByID(@PathVariable("id") Long uid){
        User u = userRepository.findOne(uid);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user with such id");
        }
        PublicUser publicUser = new PublicUser();
        publicUser.setUid(u.getUid());
        publicUser.setUsername(u.getUsername());
        publicUser.setProfile(u.getProfile());
        publicUser.setIdea(u.getIdea());
        User user = userRepository.findOneByUsername(u.getUsername());
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@PathVariable("id") Long uid, @RequestBody User user) {
        User localUser = userRepository.findOne(uid);
        if (localUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user with such id");
        }
        BeanUtils.copyProperties(user, localUser);
        userRepository.saveAndFlush(localUser);
        return ResponseEntity.status(HttpStatus.OK).body("Update Successful");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("id") Long uid) {
        User localUser = userRepository.findOne(uid);
        if (localUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user with such id");
        }

        userRepository.delete(uid);
        return ResponseEntity.status(HttpStatus.OK).body("User removed");
    }

}

