package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzgw implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzhn zzb;

    zzgw(zzhn zzhnVar, long j) {
        this.zzb = zzhnVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzG(this.zza, true);
        this.zzb.zzx.zzy().zzv(new AtomicReference<>());
    }
}
