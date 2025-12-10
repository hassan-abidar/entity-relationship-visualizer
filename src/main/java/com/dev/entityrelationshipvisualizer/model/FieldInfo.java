package com.dev.entityrelationshipvisualizer.model;

public class FieldInfo {
    private final String name;
    private final String type;
    private String relation;

    public FieldInfo(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void setRelation(String relation) { this.relation = relation; }

    public String getName() { return name; }

    public String getType() { return type; }

    public String getRelation() { return relation; }
}

