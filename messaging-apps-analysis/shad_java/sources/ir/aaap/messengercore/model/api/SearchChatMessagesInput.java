package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class SearchChatMessagesInput {
    public String object_guid;
    public String search_text;
    public SearchMessageTypeEnum type;

    public enum SearchMessageTypeEnum {
        Text,
        Hashtag
    }
}
