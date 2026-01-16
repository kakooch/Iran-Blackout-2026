package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.Message;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetMessagesOutput {
    public boolean has_continue;
    public ArrayList<Message> messages;
    public long new_max_id;
    public long new_min_id;
    public String state;
    public long timestamp;
}
