package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class RequestChangePhoneNumberOutput {
    public int code_digits_count;
    public String hash;
    public Status status;

    public enum Status {
        OK,
        Same,
        Exist
    }
}
