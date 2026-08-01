package org.fox.mobile_pilot_metadata.controller;

import org.fox.mobile_pilot_metadata.model.Workflow;
import org.fox.mobile_pilot_metadata.repository.WorkflowRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * REST controller for declarative ReactFlow-style workflows.
 *
 * Each request body matches the shape of the JSON files under
 * mobile_pilot/configs/workflow/*.reactflow.json (id, name, description,
 * nodes, edges, runtime). Workflows are persisted to MongoDB so the runner
 * can pick them up by id without re-reading the on-disk JSON.
 */
@RestController
@RequestMapping("/api/metadata")
public class MetadataItemController {

    private final WorkflowRepository workflowRepository;

    public MetadataItemController(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Workflow create(@RequestBody Workflow workflow) {
        Instant now = Instant.now();
        workflow.setId(null);
        workflow.setVersion(null);
        workflow.setCreatedAt(now);
        workflow.setUpdatedAt(now);
        return workflowRepository.save(workflow);
    }

    @GetMapping
    public List<Workflow> list() {
        return workflowRepository.findAll();
    }

    @GetMapping("/{id}")
    public Workflow getById(@PathVariable String id) {
        return workflowRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Workflow not found"));
    }

    @PutMapping("/{id}")
    public Workflow update(@PathVariable String id, @RequestBody Workflow request) {
        Workflow existing = workflowRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Workflow not found"));

        if (!Objects.equals(existing.getVersion(), request.getVersion())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Workflow version mismatch: expected " + existing.getVersion()
                            + " but got " + request.getVersion());
        }

        existing.setName(request.getName());
        existing.setDescription(request.getDescription());
        existing.setNodes(request.getNodes());
        existing.setEdges(request.getEdges());
        existing.setRuntime(request.getRuntime());
        existing.setUpdatedAt(Instant.now());

        return workflowRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        if (!workflowRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Workflow not found");
        }
        workflowRepository.deleteById(id);
    }
}