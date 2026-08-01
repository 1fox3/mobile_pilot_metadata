package org.fox.mobile_pilot_metadata.model;

/**
 * {@code take_screenshot} action parameters.
 *
 * <p>When the step runs, the runner writes the screenshot's URL and path
 * into state under {@code imageUrlKey} / {@code imagePathKey} (both default
 * to {@code image_url} / {@code image_path} if not specified).
 */
public class TakeScreenshotParams {

    private Boolean compress;
    private String imageUrlKey;
    private String imagePathKey;

    public Boolean getCompress() {
        return compress;
    }

    public void setCompress(Boolean compress) {
        this.compress = compress;
    }

    public String getImageUrlKey() {
        return imageUrlKey;
    }

    public void setImageUrlKey(String imageUrlKey) {
        this.imageUrlKey = imageUrlKey;
    }

    public String getImagePathKey() {
        return imagePathKey;
    }

    public void setImagePathKey(String imagePathKey) {
        this.imagePathKey = imagePathKey;
    }
}