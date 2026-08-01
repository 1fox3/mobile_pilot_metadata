package org.fox.mobile_pilot_metadata.model;

/**
 * Role values used inside {@code llm_structured_output.msg[*].role}.
 *
 * <p>Aligns with OpenAI-compatible chat message roles. {@link #ASSISTANT}
 * is included for completeness even though no current config emits it.
 */
public enum LlmRole {
    SYSTEM("system"),
    USER("user"),
    ASSISTANT("assistant");

    private final String wireName;

    LlmRole(String wireName) {
        this.wireName = wireName;
    }

    public String getWireName() {
        return wireName;
    }

    public static LlmRole fromWireName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("role is null");
        }
        for (LlmRole r : values()) {
            if (r.wireName.equalsIgnoreCase(name)) {
                return r;
            }
        }
        throw new IllegalArgumentException("Unknown LLM role: " + name);
    }
}