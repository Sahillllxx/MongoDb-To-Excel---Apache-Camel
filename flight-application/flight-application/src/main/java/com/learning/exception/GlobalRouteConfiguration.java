package com.learning.exception;

import org.apache.camel.builder.RouteConfigurationBuilder;

public class GlobalRouteConfiguration extends RouteConfigurationBuilder {

    public static final String GLOBAL_CONFIG_ID = "global-error-config";

    @Override
    public void configuration() {
        routeConfiguration(GLOBAL_CONFIG_ID)
                .errorHandler(
                        deadLetterChannel("log:dead-letter?level=ERROR")
                                .useOriginalMessage()
                                .logHandled(true)
                                .maximumRedeliveries(3)
                                .redeliveryDelay(2000)
                );
    }
}