package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.MessageUpdateObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetMessagesUpdatesOutput {
    public String new_state;
    public Status status;
    public long timestamp;
    public ArrayList<MessageUpdateObject> updated_messages;

    public enum Status {
        OK,
        OldState
    }
}
