package org.fox.mobile_pilot_metadata.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * One step inside {@code node.data.params[*]}.
 *
 * <p>The runner dispatches on {@link #getType()} (an {@link ActionType}).
 * The handful of well-understood actions also expose their structured
 * fields ({@link #getOpenApp()}, {@link #getLlm()}, etc.); everything else
 * stays in {@link #getParams()} as a raw map so we do not have to keep
 * updating the model every time someone adds a new action variant.
 *
 * <p>The runner is the source of truth for what each parameter means.
 */
public class ActionStep {

    private ActionType type;

    /** Typed payload for {@link ActionType#OPEN_APP}. */
    private OpenAppParams openApp;
    /** Typed payload for {@link ActionType#SWIPE}. */
    private SwipeParams swipe;
    /** Typed payload for {@link ActionType#CLICK_BY_POS} / {@link ActionType#CLICK_BY_CONFIG_POS}. */
    private ClickByPosParams clickByPos;
    /** Typed payload for {@link ActionType#CLICK_BY_TEXT} / {@link ActionType#CLICK_BY_DESC}. */
    private ClickByTextParams clickByText;
    /** Typed payload for {@link ActionType#TAKE_SCREENSHOT}. */
    private TakeScreenshotParams takeScreenshot;
    /** Typed payload for {@link ActionType#SET_STATE_VALUES}. */
    private SetStateValuesParams setStateValues;
    /** Typed payload for {@link ActionType#DECREMENT_STATE}. */
    private DecrementStateParams decrementState;
    /** Typed payload for {@link ActionType#BACK}. */
    private BackParams back;
    /** Typed payload for {@link ActionType#LLM_STRUCTURED_OUTPUT}. */
    private LlmStructuredOutput llm;
    /** Typed payload for {@link ActionType#INVOKE_LEGACY_NODE}. */
    private InvokeLegacyNodeParams invokeLegacyNode;

    /**
     * Raw parameter map. Always populated by the JSON deserialiser (Spring
     * Data MongoDB will copy every field of the on-disk step here), so
     * downstream code can reach into it for un-typed actions like
     * {@code swipe_and_click} / {@code loop_click_back_collect}.
     */
    private Map<String, Object> params = new LinkedHashMap<>();

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public OpenAppParams getOpenApp() {
        return openApp;
    }

    public void setOpenApp(OpenAppParams openApp) {
        this.openApp = openApp;
    }

    public SwipeParams getSwipe() {
        return swipe;
    }

    public void setSwipe(SwipeParams swipe) {
        this.swipe = swipe;
    }

    public ClickByPosParams getClickByPos() {
        return clickByPos;
    }

    public void setClickByPos(ClickByPosParams clickByPos) {
        this.clickByPos = clickByPos;
    }

    public ClickByTextParams getClickByText() {
        return clickByText;
    }

    public void setClickByText(ClickByTextParams clickByText) {
        this.clickByText = clickByText;
    }

    public TakeScreenshotParams getTakeScreenshot() {
        return takeScreenshot;
    }

    public void setTakeScreenshot(TakeScreenshotParams takeScreenshot) {
        this.takeScreenshot = takeScreenshot;
    }

    public SetStateValuesParams getSetStateValues() {
        return setStateValues;
    }

    public void setSetStateValues(SetStateValuesParams setStateValues) {
        this.setStateValues = setStateValues;
    }

    public DecrementStateParams getDecrementState() {
        return decrementState;
    }

    public void setDecrementState(DecrementStateParams decrementState) {
        this.decrementState = decrementState;
    }

    public BackParams getBack() {
        return back;
    }

    public void setBack(BackParams back) {
        this.back = back;
    }

    public LlmStructuredOutput getLlm() {
        return llm;
    }

    public void setLlm(LlmStructuredOutput llm) {
        this.llm = llm;
    }

    public InvokeLegacyNodeParams getInvokeLegacyNode() {
        return invokeLegacyNode;
    }

    public void setInvokeLegacyNode(InvokeLegacyNodeParams invokeLegacyNode) {
        this.invokeLegacyNode = invokeLegacyNode;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}