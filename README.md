# Entity Relationship Visualizer for Spring Boot

![ER Diagram Example](target/entity-diagram.png)

Automatically generate clean, modern, Figma-style Entity Relationship Diagrams (ERDs) from your Spring Boot JPA entities.

---

## 📦 How It Works

1. The tool scans your Spring Boot project for classes annotated with `@Entity`.
2. Extracts fields and relational mappings.
3. Converts this metadata into a **Figma-inspired PlantUML** script.
4. Renders the diagram as a PNG or SVG file in your `target/` folder.

---

## 🔧 Getting Started

### Requirements

- Java 17+
- Spring Boot 3+
- Maven build system



