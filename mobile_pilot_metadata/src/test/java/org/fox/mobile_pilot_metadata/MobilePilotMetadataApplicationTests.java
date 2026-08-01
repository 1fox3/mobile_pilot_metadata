package org.fox.mobile_pilot_metadata;

import org.fox.mobile_pilot_metadata.controller.MetadataItemController;
import org.fox.mobile_pilot_metadata.model.MetadataItem;
import org.fox.mobile_pilot_metadata.repository.MetadataItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MobilePilotMetadataApplicationTests {

    @Autowired
    private MetadataItemController controller;
    @Autowired
    private MetadataItemRepository metadataItemRepository;

    @BeforeEach
    void setUp() {
        metadataItemRepository.deleteAll();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void crudFlowWorks() throws Exception {
        MetadataItem request = new MetadataItem();
        request.setTitle("first title");
        request.setContent("first content");

        MetadataItem created = controller.create(request);
        assertNotNull(created.getId());
        assertEquals("first title", created.getTitle());
        assertEquals(1, controller.list().size());

        MetadataItem fetched = controller.getById(created.getId());
        assertEquals(created.getId(), fetched.getId());

        MetadataItem updateRequest = new MetadataItem();
        updateRequest.setTitle("updated title");
        updateRequest.setContent("updated content");
        MetadataItem updated = controller.update(created.getId(), updateRequest);
        assertEquals("updated title", updated.getTitle());
        assertEquals("updated content", updated.getContent());

        controller.delete(created.getId());
        assertTrue(controller.list().isEmpty());
    }
}
