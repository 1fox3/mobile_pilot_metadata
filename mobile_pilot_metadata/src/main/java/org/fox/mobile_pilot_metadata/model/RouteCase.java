package org.fox.mobile_pilot_metadata.model;

import java.util.Objects;

/**
 * One entry in {@code route.data.cases[*]}.
 *
 * <p>The runner evaluates each {@link #getWhen()} against the current state
 * and picks the first matching case; the resulting case name is matched
 * against the outgoing edge label (or {@code sourceHandle}).
 */
public class RouteCase {

    /** Logical branch name (must match the edge label that consumes it). */
    private String caseName;
    /** Expression of the form {@code #{state.xxx > 0}}. */
    private String when;

    public RouteCase() {
    }

    public RouteCase(String caseName, String when) {
        this.caseName = caseName;
        this.when = when;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RouteCase)) return false;
        RouteCase other = (RouteCase) o;
        return Objects.equals(caseName, other.caseName) && Objects.equals(when, other.when);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseName, when);
    }
}