package org.fox.mobile_pilot_metadata.model;

/**
 * Parameters for {@code click_by_text} and {@code click_by_desc}.
 *
 * <p>For {@code click_by_text} use {@link #getText()}; for {@code click_by_desc}
 * use {@link #getDesc()}.
 */
public class ClickByTextParams {

    private String text;
    /** Optional lookup key in {@code taskConfig}; takes a back seat to {@code text}. */
    private String textKey;
    private String desc;
    private Integer delay;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextKey() {
        return textKey;
    }

    public void setTextKey(String textKey) {
        this.textKey = textKey;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }
}