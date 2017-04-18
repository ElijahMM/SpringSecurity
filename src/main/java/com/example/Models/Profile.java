package com.example.Models;

import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.*;

/**
 * Created by mihai on 29.03.2017.
 */
@Entity
@Table
public class Profile {
    @PodamExclude
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pid;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private Integer age;

    @Column
    private String gender;

    @Column
    private String cnp;

    @Column
    private String preference;

    public long getPid() {
        return pid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
