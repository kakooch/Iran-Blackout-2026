package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChatFromServer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetChatsOutput {
    public ArrayList<ChatFromServer> chats;
    public boolean has_continue;
    public String next_start_id;
    public String state;
    public long timestamp;
}
