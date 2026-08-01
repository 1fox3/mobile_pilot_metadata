package org.fox.mobile_pilot_metadata.model;

import java.util.List;

/**
 * Parameters for {@code click_by_pos} and {@code click_by_config_pos}.
 *
 * <p>{@code clickPos} is the literal coordinate list (pixel ints or 0..1 floats).
 * {@code clickPosKey} is used by {@code click_by_config_pos} to look the
 * position up by name in {@code runtime.taskConfig}.
 */
public class ClickByPosParams {

    private List<Object> clickPos;
    private String clickPosKey;
    private Integer delay;

    public List<Object> getClickPos() {
        return clickPos;
    }

    public void setClickPos(List<Object> clickPos) {
        this.clickPos = clickPos;
    }

    public String getClickPosKey() {
        return clickPosKey;
    }

    public void setClickPosKey(String clickPosKey) {
        this.clickPosKey = clickPosKey;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }
}