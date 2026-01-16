package com.google.android.gms.internal.icing;

import com.google.android.gms.common.api.Api;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes.dex */
public final class zzf {
    public static final Api<Api.ApiOptions.NoOptions> zza;
    private static final Api.ClientKey<zzah> zzb;
    private static final Api.AbstractClientBuilder<zzah, Api.ApiOptions.NoOptions> zzc;

    static {
        Api.ClientKey<zzah> clientKey = new Api.ClientKey<>();
        zzb = clientKey;
        zze zzeVar = new zze();
        zzc = zzeVar;
        zza = new Api<>("AppDataSearch.LIGHTWEIGHT_API", zzeVar, clientKey);
        new zzaj();
    }
}
