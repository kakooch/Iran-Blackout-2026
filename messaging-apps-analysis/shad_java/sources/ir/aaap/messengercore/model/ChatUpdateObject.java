package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.ChatParamUpdateTimeObject;

/* loaded from: classes3.dex */
public class ChatUpdateObject {
    public ChatUpdateAction action;
    public ChatFromServer chat;
    public String object_guid;
    public long timestamp;
    public ChatParamUpdateTimeObject.Params[] updated_parameters;

    public enum ChatUpdateAction {
        New,
        Edit,
        Delete
    }
}
