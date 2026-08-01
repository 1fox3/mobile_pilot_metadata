package org.fox.mobile_pilot_metadata.model;

import java.util.Objects;

/**
 * One edge in a {@link Workflow}'s graph.
 *
 * <p>For {@code route} nodes the runner resolves the outgoing case name
 * by checking, in order: {@link #getLabel()},
 * {@link #getSourceHandle()}, {@link #getTargetHandle()}, then
 * the {@code ::caseName} suffix on {@link #getId()}.
 */
public class WorkflowEdge {

    private String id;
    private String source;
    private String target;

    /** Most-common way to label a route case on an outgoing edge. */
    private String label;
    /** ReactFlow editor handle IDs (alt case naming convention). */
    private String sourceHandle;
    private String targetHandle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSourceHandle() {
        return sourceHandle;
    }

    public void setSourceHandle(String sourceHandle) {
        this.sourceHandle = sourceHandle;
    }

    public String getTargetHandle() {
        return targetHandle;
    }

    public void setTargetHandle(String targetHandle) {
        this.targetHandle = targetHandle;
    }

    /**
     * Resolves the case name used by the runner to pick which outgoing edge
     * to follow from a {@code route} node. Falls back to the suffix after the
     * last {@code ::} in the edge id, matching the runner's lookup order.
     */
    public String resolveCaseName() {
        if (label != null && !label.isBlank()) {
            return label;
        }
        if (sourceHandle != null && !sourceHandle.isBlank()) {
            return sourceHandle;
        }
        if (targetHandle != null && !targetHandle.isBlank()) {
            return targetHandle;
        }
        if (id != null) {
            int idx = id.lastIndexOf("::");
            if (idx >= 0 && idx + 2 < id.length()) {
                return id.substring(idx + 2);
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkflowEdge)) return false;
        WorkflowEdge other = (WorkflowEdge) o;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
