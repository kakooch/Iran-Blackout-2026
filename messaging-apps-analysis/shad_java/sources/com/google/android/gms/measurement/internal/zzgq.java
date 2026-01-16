package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzgq implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzhn zzb;

    zzgq(zzhn zzhnVar, boolean z) {
        this.zzb = zzhnVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        boolean zZzF = this.zzb.zzx.zzF();
        boolean zZzE = this.zzb.zzx.zzE();
        this.zzb.zzx.zzD(this.zza);
        if (zZzE == this.zza) {
            this.zzb.zzx.zzat().zzk().zzb("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzx.zzF() == zZzF || this.zzb.zzx.zzF() != this.zzb.zzx.zzE()) {
            this.zzb.zzx.zzat().zzh().zzc("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zZzF));
        }
        this.zzb.zzZ();
    }
}
