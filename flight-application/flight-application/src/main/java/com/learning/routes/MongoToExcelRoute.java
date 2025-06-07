package com.learning.routes;

import com.learning.config.MongoProperties;
import com.learning.exception.MongoException;
import com.learning.process.ExcelGeneratorProcessor;
import com.learning.process.MongoQueryProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.endpoint.StaticEndpointBuilders;
import org.springframework.stereotype.Component;

import static com.learning.exception.GlobalRouteConfiguration.GLOBAL_CONFIG_ID;
import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.direct;

@RequiredArgsConstructor
@Component
public class MongoToExcelRoute extends RouteBuilder {

    private final ExcelGeneratorProcessor excelGeneratorProcessor;

    private final MongoProperties properties;

    private final MongoQueryProcessor mongoQueryProcessor;

    @Override
    public void configure() {

        onException(MongoException.class)
                .handled(true)
                .log("MongoDB Exception occurred: ${exception.message}")
                .setBody().constant("Failed to fetch data from MongoDB")
                .setHeader("CamelHttpResponseCode", constant(500));

        from(direct("generateExcel"))

                .routeId("generate-excel-route")
                .routeConfigurationId(GLOBAL_CONFIG_ID)
                .setHeader("CamelMongoDbOperation", constant(properties.getOperation()))

                .process(mongoQueryProcessor)
                .log("MongoDB results: ${body}")

                .log("Flight Details retrieving !....")
                .process(excelGeneratorProcessor)

                .log("Flight Details retrieved !....")
                .log("Excel file generated at: ${body.absolutePath}")
                .end();
    }
}
