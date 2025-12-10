package com.dev.entityrelationshipvisualizer.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Product {

    @Id
    private Long id;

    private String name;

    private Double price;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders = new HashSet<>();

    @ManyToOne
    private Category category;

    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getPrice() { return price; }
    public Set<Order> getOrders() { return orders; }
    public Category getCategory() { return category; }
}
