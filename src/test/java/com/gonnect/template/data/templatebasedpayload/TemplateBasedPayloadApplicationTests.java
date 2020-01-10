package com.gonnect.template.data.templatebasedpayload;

import com.gonnect.template.data.templatebasedpayload.model.enroll.*;
import com.gonnect.template.data.templatebasedpayload.model.payload.Payload;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;

@SpringBootTest
class TemplateBasedPayloadApplicationTests {

    @Autowired
    private ReactiveMongoTemplate template;


    @Test
    public void shouldInsertAndCountData() {

        Enrollment enrollment = new Enrollment();
        enrollment.setService(new Service());
        enrollment.getService().setServiceDefinition(new ServiceDefinition());
        enrollment.getService().setUserDefinition(new UserDefinition());
        enrollment.getService().getServiceDefinition().setUserDefinition(new UserDefinition());
        enrollment.getService().getServiceDefinition().setTemplateDefinition(new TemplateDefinition());

        Structure structure1 = new Structure();
        structure1.setColumnName("name");
        structure1.setPk(false);
        structure1.setValidationModule("stringValidation");

        Structure structure2 = new Structure();
        structure2.setColumnName("mobile");
        structure2.setPk(true);
        structure2.setValidationModule("mobileValidation");



        enrollment.getService().getServiceDefinition().getTemplateDefinition().setStructure(Arrays.asList(structure1,structure2));


        Mono<Long> countEnrollment = template.count(new Query(), Enrollment.class) //
                .doOnNext(System.out::println) //
                .thenMany(template.insertAll(Arrays.asList(enrollment))) //
                .last() //
                .flatMap(v -> template.count(new Query(), Enrollment.class)) //
                .doOnNext(System.out::println);//

        StepVerifier.create(countEnrollment).expectNext(1L).verifyComplete();

        Payload payload = new Payload();
        payload.add("name","Gaurav");
        payload.add("mobile","123");

        payload.setEnrollmentId(enrollment.get_id());

        Mono<Long> countPayload = template.count(new Query(), Payload.class) //
                .doOnNext(System.out::println) //
                .thenMany(template.insertAll(Arrays.asList(payload))) //
                .last() //
                .flatMap(v -> template.count(new Query(), Payload.class)) //
                .doOnNext(System.out::println);//

        StepVerifier.create(countPayload).expectNext(1L).verifyComplete();
    }


}
