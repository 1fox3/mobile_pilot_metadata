package org.fox.mobile_pilot_metadata;

import org.fox.mobile_pilot_metadata.controller.MetadataItemController;
import org.fox.mobile_pilot_metadata.model.Workflow;
import org.fox.mobile_pilot_metadata.repository.WorkflowRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MobilePilotMetadataApplicationTests {

    @Autowired
    private MetadataItemController controller;
    @Autowired
    private WorkflowRepository workflowRepository;

    @BeforeEach
    void setUp() {
        workflowRepository.deleteAll();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void crudFlowWorks() throws Exception {
        Workflow request = new Workflow();
        request.setName("jd-bean-workflow");
        request.setDescription("Workflow wrapper that invokes legacy JDBean nodes");
        request.setNodes(List.of(
                Map.of(
                        "id", "start",
                        "type", "start",
                        "position", Map.of("x", 0, "y", 0),
                        "data", Map.of("label", "Start")
                )
        ));
        request.setEdges(List.of(
                Map.of("id", "e1", "source", "start", "target", "open_app_jd")
        ));
        request.setRuntime(Map.of(
                "llm", Map.of("text_model", "qwen3.5:9b", "vision_model", "qwen2.5vl:7b"),
                "taskConfig", Map.of("app_package", "com.jingdong.app.mall")
        ));

        Workflow created = controller.create(request);
        assertNotNull(created.getId());
        assertNotNull(created.getVersion());
        assertEquals("jd-bean-workflow", created.getName());
        assertNotNull(created.getCreatedAt());
        assertNotNull(created.getUpdatedAt());
        assertEquals(1, controller.list().size());

        Workflow fetched = controller.getById(created.getId());
        assertEquals(created.getId(), fetched.getId());
        assertEquals(created.getVersion(), fetched.getVersion());
        assertEquals("Workflow wrapper that invokes legacy JDBean nodes", fetched.getDescription());
        assertEquals(1, fetched.getNodes().size());
        assertEquals("start", fetched.getNodes().get(0).get("id"));

        Workflow updateRequest = new Workflow();
        updateRequest.setVersion(created.getVersion());
        updateRequest.setName("jd-bean-workflow-renamed");
        updateRequest.setDescription("updated description");
        updateRequest.setNodes(request.getNodes());
        updateRequest.setEdges(request.getEdges());
        updateRequest.setRuntime(request.getRuntime());

        Workflow updated = controller.update(created.getId(), updateRequest);
        assertEquals("jd-bean-workflow-renamed", updated.getName());
        assertEquals("updated description", updated.getDescription());
        assertNotNull(updated.getUpdatedAt());
        assertNotNull(updated.getVersion());
        org.junit.jupiter.api.Assertions.assertNotEquals(created.getVersion(), updated.getVersion());

        // Replaying the old version must be rejected with 409 Conflict.
        Workflow stale = new Workflow();
        stale.setVersion(created.getVersion());
        stale.setName("stale-attempt");
        stale.setDescription("should be rejected");
        org.junit.jupiter.api.Assertions.assertThrows(
                org.springframework.web.server.ResponseStatusException.class,
                () -> controller.update(created.getId(), stale));

        controller.delete(created.getId());
        assertTrue(controller.list().isEmpty());
    }
}