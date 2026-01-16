package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class VerifyRecoveryEmailOutput {
    public StatusEnum status;
    public TwoStepStatusObject two_step_status;

    public enum StatusEnum {
        IsValid,
        NotValid,
        Expired
    }
}
