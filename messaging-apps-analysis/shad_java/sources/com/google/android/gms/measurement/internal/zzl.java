package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
/* loaded from: classes3.dex */
final class zzl implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzs zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzs zzsVar, String str, String str2) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzsVar;
        this.zzb = str;
        this.zzc = str2;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzd.zza.zzy().zzo(this.zza, this.zzb, this.zzc);
    }
}
