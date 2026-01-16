package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzgs implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzhn zzb;

    zzgs(zzhn zzhnVar, long j) {
        this.zzb = zzhnVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzx.zzd().zzk.zzb(this.zza);
        this.zzb.zzx.zzat().zzj().zzb("Session timeout duration set", Long.valueOf(this.zza));
    }
}
