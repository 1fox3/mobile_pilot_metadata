package org.fox.mobile_pilot_metadata.model;

/**
 * {@code invoke_legacy_node} action parameters.
 *
 * <p>Bridges the declarative graph to an existing Python implementation in
 * {@code mobile_pilot.langgraph.*}. The runner imports {@link #getModule()}
 * by string, then calls {@link #getFunction()} which must have signature
 * {@code func(state) -> dict | None}.
 */
public class InvokeLegacyNodeParams {

    private String module;
    private String function;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}