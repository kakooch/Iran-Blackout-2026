package com.google.android.gms.internal.gtm;

import android.content.Context;
import ir.nasim.AbstractC3795Cj5;

/* loaded from: classes3.dex */
public final class zzbw {
    private final Context zza;
    private final Context zzb;

    public zzbw(Context context) {
        AbstractC3795Cj5.j(context);
        Context applicationContext = context.getApplicationContext();
        AbstractC3795Cj5.k(applicationContext, "Application context can't be null");
        this.zza = applicationContext;
        this.zzb = applicationContext;
    }

    public final Context zza() {
        return this.zza;
    }

    public final Context zzb() {
        return this.zzb;
    }
}
