package com.dev.entityrelationshipvisualizer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VisualizerConfig {

    @Value("${erv.scan-package}")
    public String scanPackage;

    @Value("${erv.output}")
    public String output;
}
