package ir.resaneh1.iptv.model;

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
