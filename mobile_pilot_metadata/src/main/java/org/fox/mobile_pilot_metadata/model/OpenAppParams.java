package org.fox.mobile_pilot_metadata.model;

/**
 * {@code open_app} action parameters.
 *
 * <p>{@code appPackage} accepts a literal package alias (e.g. {@code "wechat"})
 * or a {@code #{config.xxx}} expression that the runner evaluates at runtime.
 */
public class OpenAppParams {

    private String appPackage;
    /** Optional seconds to sleep after launch. */
    private Integer delay;

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }
}