package com.dev.entityrelationshipvisualizer.generator;

import com.dev.entityrelationshipvisualizer.model.EntityInfo;
import com.dev.entityrelationshipvisualizer.model.FieldInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FigmaUmlGenerator {

    public String generate(List<EntityInfo> entities) {

        StringBuilder sb = new StringBuilder();

        sb.append("""
            @startuml
            skinparam backgroundColor #f7f8fa

            skinparam class {
              BackgroundColor #ffffff
              BackgroundColor<<entity>> #ffffff90
              BorderColor #d0d4dc
              FontColor #2b2e34
              FontSize 16
              BorderThickness 1.5
              RoundCorner 20
              Shadowing true
            }

            skinparam ArrowColor #c0c4cc
            skinparam ArrowThickness 1.2

            skinparam Shadowing true
            skinparam dpi 260
            skinparam Padding 8
            skinparam DefaultFontName "Inter"

            hide empty members
            """);

        // Entities
        for (EntityInfo entity : entities) {
            sb.append("class ").append(entity.getName()).append(" <<entity>> {\n");
            for (FieldInfo field : entity.getFields()) {
                sb.append("  ").append(field.getName())
                        .append(" : ").append(field.getType()).append("\n");
            }
            sb.append("}\n\n");
        }

        // Relations
        for (EntityInfo entity : entities) {
            for (FieldInfo field : entity.getFields()) {
                if (field.getRelation() == null) continue;

                String arrow = arrow(field.getRelation());

                sb.append(entity.getName())
                        .append(" ")
                        .append(arrow)
                        .append(" ")
                        .append(field.getType())
                        .append(" : ")
                        .append(field.getRelation())
                        .append("\n");
            }
        }

        sb.append("\n@enduml");
        return sb.toString();
    }

    private String arrow(String rel) {
        return switch (rel) {
            case "OneToOne" -> "\"1\" -- \"1\"";
            case "OneToMany" -> "\"1\" -- \"*\"";
            case "ManyToOne" -> "\"*\" -- \"1\"";
            case "ManyToMany" -> "\"*\" -- \"*\"";
            default -> "--";
        };
    }
}

