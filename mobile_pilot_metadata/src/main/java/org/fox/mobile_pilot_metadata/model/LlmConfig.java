package org.fox.mobile_pilot_metadata.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Typed view of {@code runtime.llm}.
 *
 * <p>Both {@link #getTextModel()} and {@link #getVisionModel()} can be
 * {@code null} when the caller only uses one modality. Extra vendor
 * parameters (e.g. temperature, context length) land in {@link #getExtras()}.
 */
public class LlmConfig {

    /** E.g. {@code "qwen3.5:9b"}, {@code "gpt-4o"}, or {@code null} to fall back to project default. */
    private String textModel;
    /** E.g. {@code "qwen2.5vl:7b"} or {@code null}. */
    private String visionModel;

    private Map<String, Object> extras = new LinkedHashMap<>();

    public String getTextModel() {
        return textModel;
    }

    public void setTextModel(String textModel) {
        this.textModel = textModel;
    }

    public String getVisionModel() {
        return visionModel;
    }

    public void setVisionModel(String visionModel) {
        this.visionModel = visionModel;
    }

    public Map<String, Object> getExtras() {
        return extras;
    }

    public void setExtras(Map<String, Object> extras) {
        this.extras = extras;
    }
}
