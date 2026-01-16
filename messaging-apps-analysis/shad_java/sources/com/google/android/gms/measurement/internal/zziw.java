package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zziw implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzja zzb;

    zziw(zzja zzjaVar, ComponentName componentName) {
        this.zzb = zzjaVar;
        this.zza = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjb.zzJ(this.zzb.zza, this.zza);
    }
}
