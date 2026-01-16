package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
/* loaded from: classes3.dex */
final class zzm implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzs zza;
    final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzm(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzs zzsVar) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzl().zzah(this.zza, this.zzb.zza.zzE());
    }
}
