package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.UserInfoFromServer;

/* loaded from: classes3.dex */
public class SignInOutput {
    public String auth;
    public Status status;
    public long timeStamp;
    public UserInfoFromServer user;

    public enum Status {
        OK,
        CodeIsUsed,
        CodeIsExpired,
        CodeIsInvalid
    }
}
