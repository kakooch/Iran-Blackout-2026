package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class DisableTwoStepByForgetPasswordOutput {
    public StatusEnum status;

    public enum StatusEnum {
        IsValid,
        NotValid,
        Expired
    }
}
