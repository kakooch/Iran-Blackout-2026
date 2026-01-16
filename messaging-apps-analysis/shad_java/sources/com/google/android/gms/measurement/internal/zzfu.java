package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzfu implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzgd zzb;

    zzfu(zzgd zzgdVar, zzp zzpVar) {
        this.zzb = zzgdVar;
        this.zza = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzK();
        this.zzb.zza.zzt(this.zza);
    }
}
