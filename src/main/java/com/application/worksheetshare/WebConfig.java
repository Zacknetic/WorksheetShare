package com.application.worksheetshare; // Replace with your package name

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply CORS to all endpoints
                .allowedOrigins("http://192.168.50.12:3000") // URL of your React app
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP methods
                .allowedHeaders("*") // Optional: Allow all headers
                .allowCredentials(true); // Optional: Depending on your requirements
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Windows path
        String externalImagePath = "file:///C:/Users/zack/Pictures/WorksheetShare/";

        registry.addResourceHandler("/getImage/**")
                .addResourceLocations(externalImagePath);
    }
}
