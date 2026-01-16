package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChatFromServer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetChatsUpdatesOutput {
    public ArrayList<ChatFromServer> chats;
    public ArrayList<String> deleted_chats;
    public String new_state;
    public GetChatsUpdatesStatus status;
    public long timestamp;

    public enum GetChatsUpdatesStatus {
        OK,
        OldState
    }
}
