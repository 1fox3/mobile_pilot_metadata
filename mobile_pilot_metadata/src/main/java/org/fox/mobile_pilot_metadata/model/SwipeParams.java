package org.fox.mobile_pilot_metadata.model;

import java.util.List;

/**
 * {@code swipe} action parameters. Coordinates are stored as raw lists
 * (the runner already supports both pixel ints and 0..1 floats).
 */
public class SwipeParams {

    private List<Object> from;
    private List<Object> to;
    /** Optional duration in milliseconds. */
    private Integer duration;
    private Integer delay;

    public List<Object> getFrom() {
        return from;
    }

    public void setFrom(List<Object> from) {
        this.from = from;
    }

    public List<Object> getTo() {
        return to;
    }

    public void setTo(List<Object> to) {
        this.to = to;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }
}