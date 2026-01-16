package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes3.dex */
final class zzaz extends zzbg {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzbr zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaz(zzbr zzbrVar, boolean z) {
        super(zzbrVar, true);
        this.zzb = zzbrVar;
        this.zza = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    final void zza() throws RemoteException {
        this.zzb.zzk.setDataCollectionEnabled(this.zza);
    }
}
