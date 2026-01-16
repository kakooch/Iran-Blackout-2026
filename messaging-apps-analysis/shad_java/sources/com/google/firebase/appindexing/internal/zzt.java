package com.google.firebase.appindexing.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.internal.icing.zzf;
import com.google.firebase.FirebaseExceptionMapper;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes3.dex */
final class zzt extends GoogleApi<Api.ApiOptions.NoOptions> {
    zzt(Context context) {
        super(context, zzf.zza, Api.ApiOptions.NO_OPTIONS, new FirebaseExceptionMapper());
    }
}
