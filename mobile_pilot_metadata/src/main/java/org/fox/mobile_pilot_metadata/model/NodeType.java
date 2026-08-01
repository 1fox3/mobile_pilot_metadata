package org.fox.mobile_pilot_metadata.model;

/**
 * Top-level node types recognised by the ReactFlow runner.
 *
 * <p>Mirrors the {@code type} field on every node in
 * {@code mobile_pilot/configs/workflow/*.reactflow.json}.
 */
public enum NodeType {
    /** Workflow entry point. Exactly one per workflow. */
    START("start"),
    /** Workflow exit point. Multiple allowed. */
    END("end"),
    /** Executes one or more mobile UI actions. */
    MOBILE("mobile"),
    /** Calls an LLM (text or vision) and writes the structured result to state. */
    LLM("llm"),
    /** Branches on {@code route.cases[*].when} expressions and routes via edge labels. */
    ROUTE("route"),
    /** Bridges to a legacy Python node via {@code invoke_legacy_node}. */
    FUNCTION("function");

    private final String wireName;

    NodeType(String wireName) {
        this.wireName = wireName;
    }

    /** The string value used in the JSON config files. */
    public String getWireName() {
        return wireName;
    }

    /** Resolve a wire name (case-insensitive) back to the enum constant. */
    public static NodeType fromWireName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("node type is null");
        }
        for (NodeType t : values()) {
            if (t.wireName.equalsIgnoreCase(name)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown node type: " + name);
    }
}