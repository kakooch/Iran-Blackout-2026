package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzfk implements Runnable {
    final /* synthetic */ zzgn zza;
    final /* synthetic */ zzfl zzb;

    zzfk(zzfl zzflVar, zzgn zzgnVar) {
        this.zzb = zzflVar;
        this.zza = zzgnVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws ClassNotFoundException {
        zzfl.zzO(this.zzb, this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}
