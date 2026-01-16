package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class LoginDisableTwoStepInput {
    public String email_code;
    public String forget_password_code_hash;
    public String phone_number;

    public LoginDisableTwoStepInput(String str, String str2, String str3) {
        this.phone_number = str;
        this.forget_password_code_hash = str2;
        this.email_code = str3;
    }
}
