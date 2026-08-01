package org.fox.mobile_pilot_metadata.model;

/**
 * Action step types used inside {@code node.data.params[*].type}.
 *
 * <p>Each entry corresponds to a registered handler in the Python runner
 * ({@code mobile_pilot/workflow/reactflow_runner.py}). The list is kept in
 * sync with {@code configs/workflow/README.md §6}.
 */
public enum ActionType {
    /** Open an app by package alias. */
    OPEN_APP("open_app"),
    /** Tap an element matched by its accessibility / uiautomator {@code desc}. */
    CLICK_BY_DESC("click_by_desc"),
    /** Tap an element whose visible text matches. */
    CLICK_BY_TEXT("click_by_text"),
    /** Swipe from {@code from} to {@code to} (pixel ints or 0-1 floats). */
    SWIPE("swipe"),
    /** Press the system back button. */
    BACK("back"),
    /** Tap at an absolute or normalised coordinate. */
    CLICK_BY_POS("click_by_pos"),
    /** Variant of {@link #CLICK_BY_POS} that resolves the key against {@code taskConfig}. */
    CLICK_BY_CONFIG_POS("click_by_config_pos"),
    /** Capture a screenshot and write its URL/path into state. */
    TAKE_SCREENSHOT("take_screenshot"),
    /** Merge arbitrary values into state. */
    SET_STATE_VALUES("set_state_values"),
    /** Decrement a numeric state value by 1 (or an explicit delta). */
    DECREMENT_STATE("decrement_state"),
    /** Send a prompt to the LLM and parse a structured response into state. */
    LLM_STRUCTURED_OUTPUT("llm_structured_output"),
    /** Convenience: swipe then click. */
    SWIPE_AND_CLICK("swipe_and_click"),
    /** Convenience: click then press back. */
    CLICK_THEN_BACK("click_then_back"),
    /** Shortcut for detecting task / collected counts on a task-list screen. */
    VISION_DETECT_TASK_COUNTS("vision_detect_task_counts"),
    /** Shortcut for "enter task -> back -> collect" loops. */
    LOOP_CLICK_BACK_COLLECT("loop_click_back_collect"),
    /** Import and call a function from a legacy Python module. */
    INVOKE_LEGACY_NODE("invoke_legacy_node");

    private final String wireName;

    ActionType(String wireName) {
        this.wireName = wireName;
    }

    /** The string value used inside {@code params[*].type} on the wire. */
    public String getWireName() {
        return wireName;
    }

    /** Resolve a wire name (case-insensitive) back to the enum constant. */
    public static ActionType fromWireName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("action type is null");
        }
        for (ActionType a : values()) {
            if (a.wireName.equalsIgnoreCase(name)) {
                return a;
            }
        }
        throw new IllegalArgumentException("Unknown action type: " + name);
    }
}