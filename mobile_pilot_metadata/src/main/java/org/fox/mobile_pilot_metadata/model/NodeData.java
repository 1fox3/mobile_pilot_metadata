package org.fox.mobile_pilot_metadata.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Carries the JSON inside {@code node.data}.
 *
 * <p>Common fields are typed: {@link #getLabel()} is the human-readable
 * caption, {@link #getParams()} is the typed list of {@link ActionStep}
 * for {@code mobile} / {@code llm} / {@code function} nodes, and
 * {@link #getCases()} is the list of {@link RouteCase} for {@code route}
 * nodes. Anything else (rare custom data) goes in {@link #getExtras()}.
 */
public class NodeData {

    private String label;

    /** Ordered action steps for {@code mobile} / {@code llm} / {@code function}. */
    private List<ActionStep> params = new ArrayList<>();

    /** Branch definitions for {@code route} nodes. */
    private List<RouteCase> cases = new ArrayList<>();

    /** Escape hatch for fields we have not typed yet. */
    private Map<String, Object> extras = new LinkedHashMap<>();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ActionStep> getParams() {
        return params;
    }

    public void setParams(List<ActionStep> params) {
        this.params = params;
    }

    public List<RouteCase> getCases() {
        return cases;
    }

    public void setCases(List<RouteCase> cases) {
        this.cases = cases;
    }

    public Map<String, Object> getExtras() {
        return extras;
    }

    public void setExtras(Map<String, Object> extras) {
        this.extras = extras;
    }
}
