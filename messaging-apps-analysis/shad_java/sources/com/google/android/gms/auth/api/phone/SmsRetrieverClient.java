package com.google.android.gms.auth.api.phone;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.internal.p001authapiphone.zzx;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.0 */
/* loaded from: classes.dex */
public abstract class SmsRetrieverClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    private static final Api.ClientKey<zzx> zza;
    private static final Api.AbstractClientBuilder<zzx, Api.ApiOptions.NoOptions> zzb;
    private static final Api<Api.ApiOptions.NoOptions> zzc;

    public SmsRetrieverClient(Context context) {
        super(context, zzc, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public abstract Task<Void> startSmsRetriever();

    static {
        Api.ClientKey<zzx> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zza zzaVar = new zza();
        zzb = zzaVar;
        zzc = new Api<>("SmsRetriever.API", zzaVar, clientKey);
    }
}
