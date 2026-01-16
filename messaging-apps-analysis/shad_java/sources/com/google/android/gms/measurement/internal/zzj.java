package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
/* loaded from: classes3.dex */
final class zzj implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzs zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ AppMeasurementDynamiteService zze;

    zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzs zzsVar, String str, String str2, boolean z) {
        this.zze = appMeasurementDynamiteService;
        this.zza = zzsVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zze.zza.zzy().zzr(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
