package org.fox.mobile_pilot_metadata.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * One chat message inside an {@code llm_structured_output.msg} array.
 *
 * <p>The {@code content} of a real config is usually a list of mixed text
 * and image parts (e.g. {@code [{"type":"text",...},{"type":"image_url",...}]}),
 * so it stays as a raw list of maps. Only {@link #getRole()} is typed via
 * {@link LlmRole}.
 */
public class LlmMessage {

    private LlmRole role;
    /** String for text-only prompts; list of typed parts for multimodal prompts. */
    private Object content;

    public LlmRole getRole() {
        return role;
    }

    public void setRole(LlmRole role) {
        this.role = role;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    /** Convenience: human-readable single-line preview for logs / UI. */
    @Override
    public String toString() {
        return "LlmMessage{" + role + ": "
                + (content instanceof String ? (String) content : "<multimodal>") + "}";
    }
}