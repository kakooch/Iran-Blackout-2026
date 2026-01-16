package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class SetPinMessageInput {
    public ActionEnum action;
    public Long message_id;
    public String object_guid;

    public enum ActionEnum {
        Pin,
        Unpin,
        UnpinAllMessages
    }
}
