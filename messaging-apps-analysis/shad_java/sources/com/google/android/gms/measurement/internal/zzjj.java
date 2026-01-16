package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzjj implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzjq zzb;

    zzjj(zzjq zzjqVar, long j) {
        this.zzb = zzjqVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjq.zzi(this.zzb, this.zza);
    }
}
