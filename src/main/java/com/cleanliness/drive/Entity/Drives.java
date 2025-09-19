package com.cleanliness.drive.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table
public class Drives {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date date;
    private String description;
    private String status;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Users creator;
    @ManyToMany(mappedBy = "enrolledIn")
    private List<Users> enrolled;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Users> getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(List<Users> enrolled) {
        this.enrolled = enrolled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Users getCreator() {
        return creator;
    }

    public void setCreator(Users creator) {
        this.creator = creator;
    }
}
