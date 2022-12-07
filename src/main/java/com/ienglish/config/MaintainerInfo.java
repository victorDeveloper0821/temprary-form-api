package com.ienglish.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = {"classpath:swagger-api.properties"})
@ConfigurationProperties(prefix = "swagger")
@Component
@Data
public class MaintainerInfo {
    private String title;
    private String description;
    private String version;
    private String name;
    private String email;

}
