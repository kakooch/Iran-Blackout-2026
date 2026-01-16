package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.MessageParamUpdateTimeObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class MessageUpdateObject {
    public Action action;
    public Message message;
    public long message_id;
    public String object_guid;
    public long prev_message_id;
    public String state;
    public long timestamp;
    public ChatType type;
    public ArrayList<MessageParamUpdateTimeObject.UpdateParameterEnum> updated_parameters;

    public enum Action {
        New,
        Edit,
        Delete
    }
}
