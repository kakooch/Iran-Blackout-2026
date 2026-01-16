package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
/* loaded from: classes3.dex */
final class zzh implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzs zza;
    final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzh(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzs zzsVar) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zza.zzy().zzx(this.zza);
    }
}
