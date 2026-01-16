package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class SearchChatMessagesInput {
    public String object_guid;
    public String search_text;
    public Type type;

    public enum Type {
        Text,
        Hashtag
    }
}
