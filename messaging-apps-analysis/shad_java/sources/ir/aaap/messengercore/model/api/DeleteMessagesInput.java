package ir.aaap.messengercore.model.api;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class DeleteMessagesInput {
    public ArrayList<Long> message_ids;
    public String object_guid;
    public DeleteMessagesType type = DeleteMessagesType.Local;

    public enum DeleteMessagesType {
        Local,
        Global
    }
}
