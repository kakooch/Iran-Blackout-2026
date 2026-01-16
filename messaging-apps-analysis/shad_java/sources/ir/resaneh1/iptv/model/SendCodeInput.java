package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class SendCodeInput {
    public String pass_key;
    public String phone_number;
    public SendType send_type;

    public enum SendType {
        SMS,
        Internal
    }
}
