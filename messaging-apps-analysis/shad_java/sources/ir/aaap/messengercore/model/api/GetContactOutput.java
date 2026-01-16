package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.UserInfoFromServer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetContactOutput {
    public boolean has_continue;
    public String next_start_id;
    public String state;
    public long timestamp;
    public ArrayList<UserInfoFromServer> users;
}
