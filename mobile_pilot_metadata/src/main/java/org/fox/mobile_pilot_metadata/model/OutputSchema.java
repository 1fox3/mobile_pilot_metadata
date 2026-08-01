package org.fox.mobile_pilot_metadata.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Inline definition of a dynamic Pydantic model used by the
 * {@code llm_structured_output} action.
 *
 * <p>Carried verbatim on the wire; the runner looks up {@link #getName()}
 * first in {@code runtime.modelRegistry} and falls back to constructing a
 * one-off model from {@link #getFields()}.
 */
public class OutputSchema {

    private String name;
    /** Map of field name → field definition. Insertion order is preserved. */
    private Map<String, SchemaField> fields = new LinkedHashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, SchemaField> getFields() {
        return fields;
    }

    public void setFields(Map<String, SchemaField> fields) {
        this.fields = fields;
    }
}