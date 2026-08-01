package org.fox.mobile_pilot_metadata.model;

import java.util.Objects;

/**
 * One node in a {@link Workflow}'s graph.
 *
 * <p>Mirrors a JSON entry under {@code nodes[*]}. Position is preserved as
 * an untyped map so the runner / editor stays free to use any coordinate
 * layout.
 */
public class WorkflowNode {

    private String id;
    private NodeType type;

    /** Editor-only coordinates; the runner ignores them. */
    private Position position;

    private NodeData data = new NodeData();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public NodeData getData() {
        return data;
    }

    public void setData(NodeData data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkflowNode)) return false;
        WorkflowNode other = (WorkflowNode) o;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
