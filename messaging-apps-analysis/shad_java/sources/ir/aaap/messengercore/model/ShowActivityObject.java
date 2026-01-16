package ir.aaap.messengercore.model;

/* loaded from: classes3.dex */
public class ShowActivityObject {
    public String object_guid;
    public ChatType object_type;
    public Type type;
    public String user_activity_guid;

    public enum Type {
        Typing,
        Uploading,
        Recording
    }
}
