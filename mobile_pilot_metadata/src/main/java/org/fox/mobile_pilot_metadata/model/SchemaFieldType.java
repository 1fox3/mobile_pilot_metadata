package org.fox.mobile_pilot_metadata.model;

/**
 * Primitive types allowed inside an {@code llm_structured_output.output_schema.fields}
 * definition.
 *
 * <p>The runner maps these onto Pydantic field types when materialising the
 * dynamic model. {@link #STRING} and {@link #LIST} are kept for forward
 * compatibility even though the current configs only emit {@code int} and
 * {@code bool}.
 */
public enum SchemaFieldType {
    INT("int"),
    BOOL("bool"),
    FLOAT("float"),
    STRING("str"),
    OBJECT("dict"),
    LIST("list");

    private final String wireName;

    SchemaFieldType(String wireName) {
        this.wireName = wireName;
    }

    public String getWireName() {
        return wireName;
    }

    public static SchemaFieldType fromWireName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("schema field type is null");
        }
        for (SchemaFieldType t : values()) {
            if (t.wireName.equalsIgnoreCase(name)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unknown schema field type: " + name);
    }
}