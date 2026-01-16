package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes3.dex */
public abstract class zzdh {

    @VisibleForTesting
    static final zzbg zzb = new zzbg();

    public static void zza(String str) {
        Log.e("GoogleTagManager", str);
    }

    public static void zzc(String str) {
        Log.w("GoogleTagManager", str);
    }

    public static void zzd(String str, Throwable th) {
        Log.w("GoogleTagManager", str, th);
    }
}
