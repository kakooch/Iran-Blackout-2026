package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhz implements Runnable {
    final /* synthetic */ zzhu zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzib zzc;

    zzhz(zzib zzibVar, zzhu zzhuVar, long j) {
        this.zzc = zzibVar;
        this.zza = zzhuVar;
        this.zzb = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzC(this.zza, false, this.zzb);
        zzib zzibVar = this.zzc;
        zzibVar.zza = null;
        zzibVar.zzx.zzy().zzz(null);
    }
}
