package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes.dex */
public class GoogleSignInResult implements Result {
    private Status mStatus;
    private GoogleSignInAccount zzcc;

    public GoogleSignInAccount getSignInAccount() {
        return this.zzcc;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.mStatus;
    }
}
