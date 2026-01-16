package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes3.dex */
final class zzbc extends zzbg {
    final /* synthetic */ zzbi zza;
    final /* synthetic */ zzbr zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbc(zzbr zzbrVar, zzbi zzbiVar) {
        super(zzbrVar, true);
        this.zzb = zzbrVar;
        this.zza = zzbiVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    final void zza() throws RemoteException {
        this.zzb.zzk.registerOnMeasurementEventListener(this.zza);
    }
}
