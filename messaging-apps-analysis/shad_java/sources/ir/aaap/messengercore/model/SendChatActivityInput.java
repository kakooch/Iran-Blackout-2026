package ir.aaap.messengercore.model;

/* loaded from: classes3.dex */
public class SendChatActivityInput {
    public ActivityEnum activity;
    public String object_guid;

    public enum ActivityEnum {
        Typing,
        Uploading,
        Recording
    }
}
