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
        enrollment.getService().getServiceDefinition().setTemplateDefinitions(Arrays.asList(new TemplateDefinition()));

        Structure structure1 = new Structure();
        structure1.setColumnName("name");
        structure1.setPk(false);
        ValidationModule vm1 = new ValidationModule();
        vm1.setName("stringValidation");
        vm1.addArg("length", "10");
        vm1.addArg("regExp", "[abc]");
        structure1.setValidationModule(vm1);

        Structure structure2 = new Structure();
        structure2.setColumnName("mobile");
        structure2.setPk(true);
        ValidationModule vm2 = new ValidationModule();
        vm2.setName("mobileValidation");
        vm2.addArg("length", "9");
        vm2.addArg("regExp", "[0..9]");
        structure1.setValidationModule(vm2);
        structure2.setValidationModule(vm2);


        enrollment.getService().getServiceDefinition().getTemplateDefinitions().get(0).setStructure(Arrays.asList(structure1, structure2));


        Mono<Long> countEnrollment = template.count(new Query(), Enrollment.class) //
                .doOnNext(System.out::println) //
                .thenMany(template.insertAll(Arrays.asList(enrollment))) //
                .last() //
                .flatMap(v -> template.count(new Query(), Enrollment.class)) //
                .doOnNext(System.out::println);//

        StepVerifier.create(countEnrollment).expectNext(1L).verifyComplete();

        Payload payload = new Payload();
        payload.add("name", "Gaurav");
        payload.add("mobile", "123");

        payload.addNewRow("name", "Shikha");
        payload.add("mobile", "456");

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
