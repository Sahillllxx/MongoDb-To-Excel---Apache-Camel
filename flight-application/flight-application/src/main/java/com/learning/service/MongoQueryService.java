package com.learning.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MongoQueryService {

    private final MongoClient mongoClient;

    public List<Document> findDocuments(String dbName, String collectionName, Map<String, Object> filter) {
        MongoDatabase database = mongoClient.getDatabase(dbName);
        MongoCollection<Document> collection = database.getCollection(collectionName);

        Document query = new Document(filter);
        return collection.find(query).into(new ArrayList<>());
    }
}
