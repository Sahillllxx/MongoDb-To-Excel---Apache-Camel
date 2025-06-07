package com.learning.process;

import com.learning.service.MongoQueryService;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class MongoQueryProcessor implements Processor {

    private final MongoQueryService mongoQueryService;

    @Override
    public void process(Exchange exchange) throws Exception {
        Map<String, Object> criteria = exchange.getIn().getBody(Map.class);
        List<Document> results = mongoQueryService.findDocuments("flight-database", "flight-dataset", criteria);
        exchange.getIn().setBody(results);
    }
}
