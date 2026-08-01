package org.fox.mobile_pilot_metadata.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The {@code runtime} block of a {@link Workflow}.
 *
 * <p>Contains the LLM defaults, per-task configuration (the {@code config}
 * namespace referenced by {@code #{config.xxx}}), and a list of required
 * keys used by the runner to validate that the config is complete.
 *
 * <p>Less-frequent fields ({@code initialState}, {@code modelRegistry},
 * {@code actionDefaults}) are kept under {@link #getExtras()} so we do not
 * have to expand the model every time the runner grows new knobs.
 */
public class WorkflowRuntime {

    private LlmConfig llm;
    /** Free-form task configuration accessed in expressions as {@code #{config.xxx}}. */
    private Map<String, Object> taskConfig = new LinkedHashMap<>();
    /**
     * Override the literal block name used in expressions. Defaults to
     * {@code "taskConfig"} in the runner.
     */
    private String taskConfigKey;
    /** Optional explicit list of keys that must be present in {@link #getTaskConfig()}. */
    private List<String> requiredConfigKeys;

    private Map<String, Object> extras = new LinkedHashMap<>();

    public LlmConfig getLlm() {
        return llm;
    }

    public void setLlm(LlmConfig llm) {
        this.llm = llm;
    }

    public Map<String, Object> getTaskConfig() {
        return taskConfig;
    }

    public void setTaskConfig(Map<String, Object> taskConfig) {
        this.taskConfig = taskConfig;
    }

    public String getTaskConfigKey() {
        return taskConfigKey;
    }

    public void setTaskConfigKey(String taskConfigKey) {
        this.taskConfigKey = taskConfigKey;
    }

    public List<String> getRequiredConfigKeys() {
        return requiredConfigKeys;
    }

    public void setRequiredConfigKeys(List<String> requiredConfigKeys) {
        this.requiredConfigKeys = requiredConfigKeys;
    }

    public Map<String, Object> getExtras() {
        return extras;
    }

    public void setExtras(Map<String, Object> extras) {
        this.extras = extras;
    }
}
