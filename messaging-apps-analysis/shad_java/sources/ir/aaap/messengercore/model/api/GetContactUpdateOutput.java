package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.UserInfoFromServer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetContactUpdateOutput {
    public ArrayList<UserInfoFromServer> deleted_users;
    public String new_state;
    public Status status;
    public long timestamp;
    public ArrayList<UserInfoFromServer> users;

    public enum Status {
        OK,
        OldState
    }
}
