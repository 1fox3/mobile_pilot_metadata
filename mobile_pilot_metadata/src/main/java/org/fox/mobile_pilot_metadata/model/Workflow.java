package org.fox.mobile_pilot_metadata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Declarative ReactFlow-style workflow document persisted in MongoDB.
 *
 * <p>The shape mirrors the JSON files under
 * {@code mobile_pilot/configs/workflow/*.reactflow.json}:
 * <ul>
 *     <li>{@code id / name / description} — workflow identifiers</li>
 *     <li>{@link #getNodes()} — typed list of {@link WorkflowNode}
 *         (each carries id, {@link NodeType}, position, and a
 *         {@link NodeData} with label / params / cases)</li>
 *     <li>{@link #getEdges()} — typed list of {@link WorkflowEdge}
 *         (id, source, target, optional label / sourceHandle / targetHandle)</li>
 *     <li>{@link #getRuntime()} — typed {@link WorkflowRuntime}
 *         (LLM defaults, {@code taskConfig}, optional {@code requiredConfigKeys})</li>
 * </ul>
 *
 * <p>As the runner grows new node / action variants, prefer adding typed
 * payload classes (see {@code *Params.java}) rather than reintroducing
 * raw {@code Map} types.
 */
@Document(collection = "workflows")
public class Workflow {

    @Id
    private String id;

    private String name;
    private String description;

    private List<WorkflowNode> nodes = new ArrayList<>();
    private List<WorkflowEdge> edges = new ArrayList<>();
    private WorkflowRuntime runtime = new WorkflowRuntime();

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

    public List<WorkflowNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<WorkflowNode> nodes) {
        this.nodes = nodes;
    }

    public List<WorkflowEdge> getEdges() {
        return edges;
    }

    public void setEdges(List<WorkflowEdge> edges) {
        this.edges = edges;
    }

    public WorkflowRuntime getRuntime() {
        return runtime;
    }

    public void setRuntime(WorkflowRuntime runtime) {
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
