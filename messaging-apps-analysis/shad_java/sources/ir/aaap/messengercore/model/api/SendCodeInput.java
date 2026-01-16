package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class SendCodeInput {
    public String pass_key;
    public String phone_number;
    public SendType send_type = SendType.SMS;

    public enum SendType {
        SMS,
        Internal,
        CallCode
    }
}
