package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class VerifyDeleteAccountOutput {
    public StatusEnum status;

    public enum StatusEnum {
        IsValid,
        NotValid,
        Expired,
        Used
    }
}
