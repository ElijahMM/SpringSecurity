package com.example.Models;

import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mihai on 29.03.2017.
 */
@Entity
@Table
public class Idea {
    @PodamExclude
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Date cretedAt;

    public long getId() {
        return id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCretedAt() {
        return cretedAt;
    }

    public void setCretedAt(Date cretedAt) {
        this.cretedAt = cretedAt;
    }
}
