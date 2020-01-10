package com.gonnect.template.data.templatebasedpayload.repository;

import com.gonnect.template.data.templatebasedpayload.model.enroll.Enrollment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends ReactiveMongoRepository<Enrollment, String> {
}
