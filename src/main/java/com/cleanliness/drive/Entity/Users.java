package com.cleanliness.drive.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String username;
    private String password;
    private String roles;
    @OneToMany(mappedBy = "creator")
    private List<Drives> drivesList;
    @ManyToMany
    @JoinTable(
            name = "enrolled_drives",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "drive_id")
    )
    private List<Drives> enrolledIn;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Drives> getEnrolledIn() {
        return enrolledIn;
    }

    public void setEnrolledIn(List<Drives> enrolledIn) {
        this.enrolledIn = enrolledIn;
    }

    public List<Drives> getDrivesList() {
        return drivesList;
    }

    public void setDrivesList(List<Drives> drivesList) {
        this.drivesList = drivesList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }


}
