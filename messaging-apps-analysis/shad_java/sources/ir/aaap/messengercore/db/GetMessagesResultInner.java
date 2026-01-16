package ir.aaap.messengercore.db;

import ir.aaap.messengercore.model.Message;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetMessagesResultInner {
    public boolean hasJustLocal;
    public boolean isExistInDB;
    public ArrayList<Message> justLocalMessages;
    public ArrayList<Message> messages;
    public long newMaxId;
    public long newMinId;
    public boolean hasContinue = false;
    public boolean olderHasContinue = false;
    public boolean newerHasContinue = false;
}
