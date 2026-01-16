package ir.aaap.messengercore.model;

import ir.aaap.messengercore.MessageUtils;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class LoadMessagesIntervalResult {
    public String chatId;
    public ChatType chatType;
    public Object extraInfo;
    public MessageUtils.FilterTypeEnum filterType;
    public boolean isFromDb;
    public ArrayList<Message> messages;
    public long middleId;
    public long newMinDate;
    public boolean new_has_continue;
    public long new_min_id;
    public long oldMaxDate;
    public boolean old_has_continue;
    public long old_max_id;
}
