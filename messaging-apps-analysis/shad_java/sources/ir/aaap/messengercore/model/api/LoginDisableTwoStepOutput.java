package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class LoginDisableTwoStepOutput {
    public StatusEnum status;

    public enum StatusEnum {
        OK,
        CodeIsUsed,
        CodeIsExpired,
        CodeIsInvalid
    }
}
