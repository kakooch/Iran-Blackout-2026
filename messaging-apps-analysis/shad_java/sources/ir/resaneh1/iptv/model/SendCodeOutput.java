package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class SendCodeOutput {
    public int code_digits_count;
    public boolean has_confirmed_recovery_email;
    public String hint_pass_key;
    public String phone_code_hash;
    public Status status;

    public enum Status {
        OK,
        SendPassKey,
        InvalidPassKey
    }
}
