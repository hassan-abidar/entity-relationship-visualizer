package com.dev.entityrelationshipvisualizer.writer;

import com.dev.entityrelationshipvisualizer.config.VisualizerConfig;
import net.sourceforge.plantuml.SourceStringReader;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;

@Component
public class PngWriter {

    private final VisualizerConfig config;

    public PngWriter(VisualizerConfig config) {
        this.config = config;
    }

    public void writePng(String plantUmlSource) {
        try {
            String outputPath = "target/" + config.output.replace(".md", ".png");

            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                SourceStringReader reader = new SourceStringReader(plantUmlSource);
                reader.outputImage(fos).getDescription();
            }

            System.out.println("PNG diagram generated: " + outputPath);

        } catch (Exception e) {
            throw new RuntimeException("Error generating PNG diagram", e);
        }
    }
}

