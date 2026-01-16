package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzjf implements Runnable {
    final /* synthetic */ zzkd zza;
    final /* synthetic */ Runnable zzb;

    zzjf(zzjh zzjhVar, zzkd zzkdVar, Runnable runnable) {
        this.zza = zzkdVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzK();
        this.zza.zzJ(this.zzb);
        this.zza.zzF();
    }
}
