package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.Message;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetMessagesIntervalOutput {
    public ArrayList<Message> messages;
    public boolean new_has_continue;
    public long new_min_id;
    public boolean old_has_continue;
    public long old_max_id;
    public String state;
    public long timestamp;
}
