package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzfn implements Runnable {
    final /* synthetic */ zzaa zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzgd zzc;

    zzfn(zzgd zzgdVar, zzaa zzaaVar, zzp zzpVar) {
        this.zzc = zzgdVar;
        this.zza = zzaaVar;
        this.zzb = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzK();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zzW(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzU(this.zza, this.zzb);
        }
    }
}
