package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class SetPinChatInFolderInput {
    public Action action;
    public String folder_id;
    public String object_guid;

    public enum Action {
        Pin,
        Unpin
    }
}
