package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.MessageUtils;

/* loaded from: classes3.dex */
public class GetMessagesInput {
    public MessageUtils.FilterTypeEnum filter_type;
    public String object_guid;
    public Long min_id = null;
    public Long max_id = null;
    public Long middle_message_id = null;
    public int limit = 50;
    public MessageUtils.SortType sort = null;
}
