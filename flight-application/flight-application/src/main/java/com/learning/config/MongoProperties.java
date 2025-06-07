package com.learning.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mongo")
public class MongoProperties {
    private String database;
    private String collection;
    private String operation;
}
