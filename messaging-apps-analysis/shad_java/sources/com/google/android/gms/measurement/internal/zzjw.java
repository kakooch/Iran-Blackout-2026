package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzjw implements Runnable {
    final /* synthetic */ zzke zza;
    final /* synthetic */ zzkd zzb;

    zzjw(zzkd zzkdVar, zzke zzkeVar) {
        this.zzb = zzkdVar;
        this.zza = zzkeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkd.zzaa(this.zzb, this.zza);
        this.zzb.zzc();
    }
}
