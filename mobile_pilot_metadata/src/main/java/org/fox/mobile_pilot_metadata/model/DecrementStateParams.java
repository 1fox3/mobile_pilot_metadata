package org.fox.mobile_pilot_metadata.model;

/**
 * {@code decrement_state} action parameters.
 *
 * <p>{@code key} names the state slot to mutate and {@code delta} is the
 * amount to subtract (defaults to 1 in the runner).
 */
public class DecrementStateParams {

    private String key;
    private Integer delta;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getDelta() {
        return delta;
    }

    public void setDelta(Integer delta) {
        this.delta = delta;
    }
}