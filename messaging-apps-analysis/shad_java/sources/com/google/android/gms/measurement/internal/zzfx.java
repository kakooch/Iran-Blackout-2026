package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzfx implements Runnable {
    final /* synthetic */ zzas zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgd zzc;

    zzfx(zzgd zzgdVar, zzas zzasVar, String str) {
        this.zzc = zzgdVar;
        this.zza = zzasVar;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzK();
        this.zzc.zza.zzz(this.zza, this.zzb);
    }
}
