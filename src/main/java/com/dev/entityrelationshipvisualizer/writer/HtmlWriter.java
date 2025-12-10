package com.dev.entityrelationshipvisualizer.writer;

import com.dev.entityrelationshipvisualizer.config.VisualizerConfig;
import org.springframework.stereotype.Component;

import java.io.FileWriter;

@Component
public class HtmlWriter {

    private final VisualizerConfig config;

    public HtmlWriter(VisualizerConfig config) {
        this.config = config;
    }

    public void write(String content) {
        try (FileWriter writer = new FileWriter("target/" + config.output.replace(".html", ".md"))) {
            writer.write(content);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
