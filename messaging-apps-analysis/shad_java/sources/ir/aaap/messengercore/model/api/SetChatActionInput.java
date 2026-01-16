package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class SetChatActionInput {
    public ChatAction action;
    public String object_guid;

    public enum ChatAction {
        Mute,
        Unmute,
        Pin,
        Unpin
    }
}
