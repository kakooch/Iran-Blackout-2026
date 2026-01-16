package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zziv implements Runnable {
    final /* synthetic */ zzdz zza;
    final /* synthetic */ zzja zzb;

    zziv(zzja zzjaVar, zzdz zzdzVar) {
        this.zzb = zzjaVar;
        this.zza = zzdzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            zzja.zzd(this.zzb, false);
            if (!this.zzb.zza.zzh()) {
                this.zzb.zza.zzx.zzat().zzk().zza("Connected to service");
                this.zzb.zza.zzE(this.zza);
            }
        }
    }
}
