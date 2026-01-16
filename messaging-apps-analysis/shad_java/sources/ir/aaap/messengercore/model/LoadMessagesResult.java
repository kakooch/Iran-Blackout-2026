package ir.aaap.messengercore.model;

import ir.aaap.messengercore.MessageUtils;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class LoadMessagesResult {
    public String chatId;
    public ChatType chatType;
    public Object extraInfo;
    public MessageUtils.FilterTypeEnum filterType;
    public boolean hasContinue;
    public boolean isFromDb;
    public long maxDate;
    public long maxId;
    public ArrayList<Message> messages;
    public long minDate;
    public long minId;
    public long newMaxDate;
    public long newMaxId;
    public long newMinDate;
    public long newMinId;
}
