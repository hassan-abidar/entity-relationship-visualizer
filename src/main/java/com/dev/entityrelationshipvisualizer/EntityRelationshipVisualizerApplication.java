package com.dev.entityrelationshipvisualizer;

import com.dev.entityrelationshipvisualizer.generator.FigmaUmlGenerator;
import com.dev.entityrelationshipvisualizer.scanner.EntityScanner;
import com.dev.entityrelationshipvisualizer.writer.HtmlWriter;
import com.dev.entityrelationshipvisualizer.writer.PngWriter;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EntityRelationshipVisualizerApplication {

    private final EntityScanner scanner;
    private final HtmlWriter writer;
    private final FigmaUmlGenerator figmaUmlGenerator;
    private final PngWriter pngWriter;

    public EntityRelationshipVisualizerApplication(EntityScanner scanner,
                                                   HtmlWriter writer, FigmaUmlGenerator figmaUmlGenerator, PngWriter pngWriter) {
        this.scanner = scanner;
        this.writer = writer;
        this.figmaUmlGenerator = figmaUmlGenerator;
        this.pngWriter = pngWriter;
    }

    public static void main(String[] args) {
        SpringApplication.run(EntityRelationshipVisualizerApplication.class, args);
    }

    @PostConstruct
    public void run() {
        var entities = scanner.scan();

        var figmaUml = figmaUmlGenerator.generate(entities);
        pngWriter.writePng(figmaUml);

        System.out.println("Entity relationship PNG diagram generated!");
    }

}

