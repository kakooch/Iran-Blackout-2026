package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzfz implements Runnable {
    final /* synthetic */ zzkg zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzgd zzc;

    zzfz(zzgd zzgdVar, zzkg zzkgVar, zzp zzpVar) {
        this.zzc = zzgdVar;
        this.zza = zzkgVar;
        this.zzb = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzK();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzO(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzN(this.zza, this.zzb);
        }
    }
}
