package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class RegisterDeviceInput {
    public String app_version;
    public String device_hash;
    public String device_model;
    public boolean is_multi_account;
    public String lang_code;
    public String phone_number;
    public String system_version;
    public String token;
    public TokenTypeEnum token_type = TokenTypeEnum.Firebase;

    public enum TokenTypeEnum {
        APNS,
        Firebase,
        Web
    }
}
