package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class PrivacySettings {
    public AccessLevelEnum can_called_by;
    public AccessLevelEnum can_join_chat_by;
    public int count_active_sessions;
    public int count_blocked_user;
    public int delete_account_not_active_months;
    public AccessLevelEnum link_forward_message;
    public AccessLevelEnum show_my_last_online;
    public AccessLevelEnum show_my_phone_number;
    public AccessLevelEnum show_my_profile_photo;
    public SignInTypeEnum sign_in_type;

    public enum AccessLevelEnum {
        Everybody,
        MyContacts,
        Nobody
    }

    public enum SignInTypeEnum {
        Simple,
        TwoStep
    }
}
