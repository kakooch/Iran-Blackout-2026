package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes3.dex */
final class zzan extends zzbg {
    final /* synthetic */ zzm zza;
    final /* synthetic */ zzbr zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzan(zzbr zzbrVar, zzm zzmVar) {
        super(zzbrVar, true);
        this.zzb = zzbrVar;
        this.zza = zzmVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    final void zza() throws RemoteException {
        this.zzb.zzk.getGmpAppId(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    protected final void zzb() {
        this.zza.zzb(null);
    }
}
