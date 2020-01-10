package com.gonnect.template.data.templatebasedpayload.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.LoggingEventListener;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * MongoDB configuration
 */
@Configuration
@EnableReactiveMongoRepositories
public class MongoConfiguration {

    @Bean
    public LoggingEventListener mongoEventListener() {
        return new LoggingEventListener();
    }
}
