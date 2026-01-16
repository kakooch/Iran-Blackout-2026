package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzfw implements Runnable {
    final /* synthetic */ zzas zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzgd zzc;

    zzfw(zzgd zzgdVar, zzas zzasVar, zzp zzpVar) {
        this.zzc = zzgdVar;
        this.zza = zzasVar;
        this.zzb = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzas zzasVarZzb = this.zzc.zzb(this.zza, this.zzb);
        this.zzc.zza.zzK();
        this.zzc.zza.zzB(zzasVarZzb, this.zzb);
    }
}
