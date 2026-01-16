package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class ActionOnStickersInput {
    public ActionOnStickersEnum action;
    public String sticker_set_id;

    public enum ActionOnStickersEnum {
        Archive,
        Add,
        Remove
    }

    public ActionOnStickersInput(String str, ActionOnStickersEnum actionOnStickersEnum) {
        this.sticker_set_id = str;
        this.action = actionOnStickersEnum;
    }
}
