package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.api.PrivacySettings;

/* loaded from: classes3.dex */
public class TwoStepStatusObject {
    public String confirmed_recovery_email;
    public boolean has_confirmed_recovery_email;
    public boolean has_pending_recovery_email;
    public String hint;
    public String pending_recovery_email;
    public PrivacySettings.SignInTypeEnum sign_in_type;
}
