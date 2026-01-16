package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.UserInfoFromServer;

/* loaded from: classes3.dex */
public class VerifyChangePhoneNumberOutput {
    public Status status;
    public long timestamp;
    public UserInfoFromServer user;

    public enum Status {
        IsValid,
        NotValid,
        Expired,
        Used
    }
}
