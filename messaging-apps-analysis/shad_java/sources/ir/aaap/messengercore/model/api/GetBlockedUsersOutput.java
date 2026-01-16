package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChatAbsObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetBlockedUsersOutput {
    public ArrayList<ChatAbsObject> abs_users;
    public boolean has_continue;
    public String next_start_id;
    public long timestamp;
}
