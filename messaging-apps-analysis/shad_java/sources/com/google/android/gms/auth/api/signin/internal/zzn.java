package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes.dex */
abstract class zzn<R extends Result> extends BaseImplementation$ApiMethodImpl<R, zzf> {
    public zzn(GoogleApiClient googleApiClient) {
        super(Auth.GOOGLE_SIGN_IN_API, googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder
    public /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((zzn<R>) obj);
    }
}
