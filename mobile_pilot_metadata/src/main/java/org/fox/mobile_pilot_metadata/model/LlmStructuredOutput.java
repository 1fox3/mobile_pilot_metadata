package org.fox.mobile_pilot_metadata.model;

/**
 * Fully-typed view of an {@code llm_structured_output} action's payload.
 *
 * <p>Exposed as a separate object (instead of a flat {@code Map}) so the
 * metadata UI can render the structured fields, model name, defaults, and
 * the multi-modal message list without having to navigate a generic map.
 *
 * <p>Fields not enumerated here (LLM-vendor knobs, prompt caching, etc.)
 * can be added to {@link #getExtras()} as needed.
 */
public class LlmStructuredOutput {

    /** Either {@code "vision"} / {@code "text"} (named LLM) or a state key. */
    private String llm;
    /** Optional model name to forward to the LLM provider (e.g. {@code gpt-4o}). */
    private String model;

    private java.util.List<LlmMessage> msg = new java.util.ArrayList<>();
    private OutputSchema outputSchema;

    /** Keys to copy from the LLM response into state. */
    private java.util.List<String> resultKeys = new java.util.ArrayList<>();
    /** Fallback result used when the LLM call fails. */
    private java.util.Map<String, Object> defaultResult = new java.util.LinkedHashMap<>();
    /** Upper bounds applied to numeric result fields. */
    private java.util.Map<String, Object> maxValues = new java.util.LinkedHashMap<>();
    /** Optional rename map from model field name → state key. */
    private java.util.Map<String, String> stateKeyMap = new java.util.LinkedHashMap<>();

    /** Escape hatch for properties we have not typed yet. */
    private java.util.Map<String, Object> extras = new java.util.LinkedHashMap<>();

    public String getLlm() {
        return llm;
    }

    public void setLlm(String llm) {
        this.llm = llm;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public java.util.List<LlmMessage> getMsg() {
        return msg;
    }

    public void setMsg(java.util.List<LlmMessage> msg) {
        this.msg = msg;
    }

    public OutputSchema getOutputSchema() {
        return outputSchema;
    }

    public void setOutputSchema(OutputSchema outputSchema) {
        this.outputSchema = outputSchema;
    }

    public java.util.List<String> getResultKeys() {
        return resultKeys;
    }

    public void setResultKeys(java.util.List<String> resultKeys) {
        this.resultKeys = resultKeys;
    }

    public java.util.Map<String, Object> getDefaultResult() {
        return defaultResult;
    }

    public void setDefaultResult(java.util.Map<String, Object> defaultResult) {
        this.defaultResult = defaultResult;
    }

    public java.util.Map<String, Object> getMaxValues() {
        return maxValues;
    }

    public void setMaxValues(java.util.Map<String, Object> maxValues) {
        this.maxValues = maxValues;
    }

    public java.util.Map<String, String> getStateKeyMap() {
        return stateKeyMap;
    }

    public void setStateKeyMap(java.util.Map<String, String> stateKeyMap) {
        this.stateKeyMap = stateKeyMap;
    }

    public java.util.Map<String, Object> getExtras() {
        return extras;
    }

    public void setExtras(java.util.Map<String, Object> extras) {
        this.extras = extras;
    }
}