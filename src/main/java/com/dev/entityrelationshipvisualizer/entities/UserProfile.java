package com.dev.entityrelationshipvisualizer.entities;

import jakarta.persistence.*;

@Entity
public class UserProfile {

    @Id
    private Long id;

    private String fullName;

    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getPhoneNumber() { return phoneNumber; }
    public User getUser() { return user; }
}
