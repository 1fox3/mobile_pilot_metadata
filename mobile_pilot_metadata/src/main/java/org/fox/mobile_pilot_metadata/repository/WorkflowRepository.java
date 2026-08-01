package org.fox.mobile_pilot_metadata.repository;

import org.fox.mobile_pilot_metadata.model.Workflow;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkflowRepository extends MongoRepository<Workflow, String> {
}