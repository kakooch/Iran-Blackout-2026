package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.UserInfoFromServer;

/* loaded from: classes3.dex */
public class UpdateUserUsernameOutput {
    public StatusEnum status;
    public long timestamp;
    public UserInfoFromServer user;

    public enum StatusEnum {
        OK,
        UsernameExist
    }
}
