package org.fox.mobile_pilot_metadata.repository;

import org.fox.mobile_pilot_metadata.model.MetadataItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MetadataItemRepository extends MongoRepository<MetadataItem, String> {
}
