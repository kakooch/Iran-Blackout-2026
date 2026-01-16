package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzfo implements Runnable {
    final /* synthetic */ zzaa zza;
    final /* synthetic */ zzgd zzb;

    zzfo(zzgd zzgdVar, zzaa zzaaVar) {
        this.zzb = zzgdVar;
        this.zza = zzaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzK();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzV(this.zza);
        } else {
            this.zzb.zza.zzT(this.zza);
        }
    }
}
