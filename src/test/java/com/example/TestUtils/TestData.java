package com.example.TestUtils;

import com.example.Models.Idea;
import com.example.Models.Profile;
import com.example.Models.User;

import java.util.Random;

/**
 * Created by mihai on 10.04.2017.
 */
public class TestData {

    public static User getDummyUser() {
        User model = new User();
        Idea idea = new Idea();
        Profile profile = new Profile();
        Random random = new Random();

        model.setUsername("user" + "1");
        model.setPassword("123");

        idea.setTitle("Title");
        idea.setDescription("Description");
        model.setIdea(idea);

        profile.setAge(20);
        profile.setCnp("123456788");
        profile.setFirstname("Mihai");
        profile.setLastname("Ignat");
        profile.setGender("male");
        profile.setPreference("prefs");
        model.setProfile(profile);

        return model;
    }
}
