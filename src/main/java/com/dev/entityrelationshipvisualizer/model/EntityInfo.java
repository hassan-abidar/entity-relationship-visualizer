package com.dev.entityrelationshipvisualizer.model;

import java.util.ArrayList;
import java.util.List;

public class EntityInfo {

    private final String name;
    private final List<FieldInfo> fields = new ArrayList<>();

    public EntityInfo(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public List<FieldInfo> getFields() { return fields; }
}
