package com.dev.entityrelationshipvisualizer.entities;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "orders") // optional, to avoid reserved keyword issues
public class Order {

    @Id
    private Long id;

    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

    public Long getId() { return id; }
    public Double getTotalAmount() { return totalAmount; }
    public User getUser() { return user; }
    public Set<Product> getProducts() { return products; }
}
