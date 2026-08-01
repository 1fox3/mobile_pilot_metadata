package org.fox.mobile_pilot_metadata.model;

/**
 * One field inside an {@code llm_structured_output.output_schema}.
 *
 * <p>The runner translates this into a Pydantic field when materialising the
 * dynamic model. {@link #getDescription()} is passed through as the field
 * description (helps the LLM emit the right value).
 */
public class SchemaField {

    private String name;
    private SchemaFieldType type;
    private String description;

    public SchemaField() {
    }

    public SchemaField(String name, SchemaFieldType type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SchemaFieldType getType() {
        return type;
    }

    public void setType(SchemaFieldType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}