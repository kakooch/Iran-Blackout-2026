package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
/* loaded from: classes3.dex */
final class zzi implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzs zza;
    final /* synthetic */ zzas zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzs zzsVar, zzas zzasVar, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzsVar;
        this.zzb = zzasVar;
        this.zzc = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzd.zza.zzy().zzG(this.zza, this.zzb, this.zzc);
    }
}
