package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.api.SendCodeInput;

/* loaded from: classes3.dex */
public class SendCodeOutput {
    public String caller_id_contain_string;
    public int code_digits_count;
    public boolean has_confirmed_recovery_email;
    public String hint_pass_key;
    public String no_recovery_alert;
    public String phone_code_hash;
    public SendCodeInput.SendType send_type;
    public Status status;

    public enum Status {
        OK,
        SendPassKey,
        InvalidPassKey
    }
}
