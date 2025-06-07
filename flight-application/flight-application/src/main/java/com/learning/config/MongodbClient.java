package com.learning.config;

import com.mongodb.client.MongoClient;

import org.apache.camel.component.mongodb.MongoDbComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MongodbClient {

    @Bean("mongo-config")
    public MongoDbComponent mongoDbComponent(MongoClient mongoClient) {
        MongoDbComponent component = new MongoDbComponent();
        component.setMongoConnection(mongoClient);
        component.setAutowiredEnabled(true);
        return component;
    }

}
