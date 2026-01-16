package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhj implements Runnable {
    final /* synthetic */ zzaf zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzhn zze;

    zzhj(zzhn zzhnVar, zzaf zzafVar, int i, long j, boolean z) {
        this.zze = zzhnVar;
        this.zza = zzafVar;
        this.zzb = i;
        this.zzc = j;
        this.zzd = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzr(this.zza);
        zzhn.zzW(this.zze, this.zza, this.zzb, this.zzc, false, this.zzd);
    }
}
