package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.api.SearchChatMessagesInput;

/* loaded from: classes3.dex */
public class SearchGlobalMessagesInput {
    public String search_text;
    public String start_id;
    public SearchChatMessagesInput.SearchMessageTypeEnum type = SearchChatMessagesInput.SearchMessageTypeEnum.Text;
}
