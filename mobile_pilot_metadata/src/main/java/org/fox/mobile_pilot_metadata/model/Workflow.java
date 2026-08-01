package org.fox.mobile_pilot_metadata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * Declarative ReactFlow-style workflow document persisted in MongoDB.
 *
 * The shape mirrors the JSON files under mobile_pilot/configs/workflow/*.reactflow.json:
 *   - id / name / description : workflow identifiers
 *   - nodes                   : list of node definitions (id, type, position, data)
 *   - edges                   : list of connections (id, source, target, optional label)
 *   - runtime                 : runtime config (llm, taskConfig, requiredConfigKeys, ...)
 *
 * `nodes`, `edges` and `runtime` are kept as raw structures so each workflow
 * can carry its own action params / LLM schemas / task config without
 * forcing the model to know every variant.
 */
@Document(collection = "workflows")
public class Workflow {

    @Id
    private String id;

    private String name;
    private String description;

    private List<Map<String, Object>> nodes;
    private List<Map<String, Object>> edges;
    private Map<String, Object> runtime;

    @Version
    private Long version;

    private Instant createdAt;
    private Instant updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Map<String, Object>> getNodes() {
        return nodes;
    }

    public void setNodes(List<Map<String, Object>> nodes) {
        this.nodes = nodes;
    }

    public List<Map<String, Object>> getEdges() {
        return edges;
    }

    public void setEdges(List<Map<String, Object>> edges) {
        this.edges = edges;
    }

    public Map<String, Object> getRuntime() {
        return runtime;
    }

    public void setRuntime(Map<String, Object> runtime) {
        this.runtime = runtime;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}