package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhy implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzib zzb;

    zzhy(zzib zzibVar, long j) {
        this.zzb = zzibVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzx.zzB().zzc(this.zza);
        this.zzb.zza = null;
    }
}
