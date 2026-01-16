package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.wearable.internal.zzaa;
import com.google.android.gms.wearable.internal.zzaj;
import com.google.android.gms.wearable.internal.zzbv;
import com.google.android.gms.wearable.internal.zzbw;
import com.google.android.gms.wearable.internal.zzeu;
import com.google.android.gms.wearable.internal.zzez;
import com.google.android.gms.wearable.internal.zzfg;
import com.google.android.gms.wearable.internal.zzgi;
import com.google.android.gms.wearable.internal.zzh;
import com.google.android.gms.wearable.internal.zzhg;
import com.google.android.gms.wearable.internal.zzhq;

/* loaded from: classes3.dex */
public class Wearable {

    @Deprecated
    public static final Api<WearableOptions> API;
    private static final Api.AbstractClientBuilder<zzhg, WearableOptions> CLIENT_BUILDER;
    private static final Api.ClientKey<zzhg> CLIENT_KEY;

    public static final class WearableOptions implements Api.ApiOptions {
        private WearableOptions(Builder builder) {
            Looper unused = builder.zzac;
        }

        public static class Builder {
            private Looper zzac;
        }

        /* synthetic */ WearableOptions(Builder builder, zzj zzjVar) {
            this(builder);
        }
    }

    public static MessageClient getMessageClient(Context context) {
        return new zzez(context, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public static CapabilityClient getCapabilityClient(Context context) {
        return new zzaa(context, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    static {
        new zzbw();
        new com.google.android.gms.wearable.internal.zzo();
        new zzeu();
        new zzfg();
        new zzaj();
        new com.google.android.gms.wearable.internal.zzk();
        new zzh();
        new zzbv();
        new zzgi();
        new zzhq();
        Api.ClientKey<zzhg> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        zzj zzjVar = new zzj();
        CLIENT_BUILDER = zzjVar;
        API = new Api<>("Wearable.API", zzjVar, clientKey);
    }
}
