package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzji implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzjq zzb;

    zzji(zzjq zzjqVar, long j) {
        this.zzb = zzjqVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjq.zzh(this.zzb, this.zza);
    }
}
