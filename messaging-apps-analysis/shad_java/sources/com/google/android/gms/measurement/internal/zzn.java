package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
/* loaded from: classes3.dex */
final class zzn implements zzgl {
    public final com.google.android.gms.internal.measurement.zzv zza;
    final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzn(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzv zzvVar) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzvVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
        try {
            this.zza.zzd(str, str2, bundle, j);
        } catch (RemoteException e) {
            zzfl zzflVar = this.zzb.zza;
            if (zzflVar != null) {
                zzflVar.zzat().zze().zzb("Event interceptor threw exception", e);
            }
        }
    }
}
