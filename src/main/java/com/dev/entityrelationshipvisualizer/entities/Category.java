package com.dev.entityrelationshipvisualizer.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Category {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    public Long getId() { return id; }
    public String getName() { return name; }
    public List<Product> getProducts() { return products; }
}
