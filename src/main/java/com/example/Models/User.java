package com.example.Models;

import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mihai on 29.03.2017.
 */
@Entity
@Table
public class User {

    @PodamExclude
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private Date createdAt;

    @PodamExclude
    @Column String token;
    /**
     * cascade - daca stergi user ->stergi profil
     * optional - false nu permiti ca un user sa raman fara profil
     * fetch - modul cum sunt cautate date e.g. fetch = FetchType.EAGER -> cand cauti un user, profilul pentru acel user este cautat automant
     * orphanRemoval - daca un profil nu are User, acesta va fi sters
     */
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    private Profile profile;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToMany
    private Idea idea;

    public long getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
