package org.fox.mobile_pilot_metadata.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@code set_state_values} action parameters. The map values may be
 * literal JSON or expressions of the form {@code #{state.x}}.
 */
public class SetStateValuesParams {

    private Map<String, Object> values = new LinkedHashMap<>();

    public Map<String, Object> getValues() {
        return values;
    }

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }
}