package com.dev.entityrelationshipvisualizer.scanner;

import com.dev.entityrelationshipvisualizer.config.VisualizerConfig;
import com.dev.entityrelationshipvisualizer.model.EntityInfo;
import com.dev.entityrelationshipvisualizer.model.FieldInfo;
import jakarta.persistence.*;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;

@Component
public class EntityScanner {

    private final VisualizerConfig config;

    public EntityScanner(VisualizerConfig config) {
        this.config = config;
    }

    public List<EntityInfo> scan() {
        Reflections reflections = new Reflections(config.scanPackage);

        Set<Class<?>> entities = reflections.getTypesAnnotatedWith(Entity.class);
        List<EntityInfo> results = new ArrayList<>();

        for (Class<?> type : entities) {
            EntityInfo entityInfo = new EntityInfo(type.getSimpleName());

            for (Field field : type.getDeclaredFields()) {
                FieldInfo info = new FieldInfo(field.getName(), field.getType().getSimpleName());

                if (field.isAnnotationPresent(OneToOne.class)) {
                    info.setRelation("OneToOne");
                }
                if (field.isAnnotationPresent(OneToMany.class)) {
                    info.setRelation("OneToMany");
                }
                if (field.isAnnotationPresent(ManyToOne.class)) {
                    info.setRelation("ManyToOne");
                }
                if (field.isAnnotationPresent(ManyToMany.class)) {
                    info.setRelation("ManyToMany");
                }

                entityInfo.getFields().add(info);
            }

            results.add(entityInfo);
        }

        return results;
    }
}
