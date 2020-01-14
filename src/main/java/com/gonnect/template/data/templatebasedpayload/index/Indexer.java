package com.gonnect.template.data.templatebasedpayload.index;

import com.gonnect.template.data.templatebasedpayload.document.enroll.Enrollment;
import com.gonnect.template.data.templatebasedpayload.document.payload.Payload;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Indexer {
    private final MongoTemplate mongoTemplate;
    private final MongoMappingContext mongoMappingContext;

    @EventListener(ApplicationReadyEvent.class)
    public void triggerIndexing() {

        doResolveIndexFor(Enrollment.class);
        doResolveIndexFor(Payload.class);
    }

    private void doResolveIndexFor(Class<?> klass) {
        IndexOperations indexOperations = mongoTemplate.indexOps(klass);
        IndexResolver indexResolver = new MongoPersistentEntityIndexResolver(mongoMappingContext);
        indexResolver.resolveIndexFor(klass).forEach(indexOperations::ensureIndex);
    }

}
