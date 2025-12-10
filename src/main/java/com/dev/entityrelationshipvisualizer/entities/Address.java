package com.dev.entityrelationshipvisualizer.entities;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    private Long id;

    private String street;
    private String city;
    private String country;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() { return id; }
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getCountry() { return country; }
    public User getUser() { return user; }
}

