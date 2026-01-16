package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes3.dex */
final class zzbn extends zzbg {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzbq zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbn(zzbq zzbqVar, Activity activity) {
        super(zzbqVar.zza, true);
        this.zzb = zzbqVar;
        this.zza = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    final void zza() throws RemoteException {
        this.zzb.zza.zzk.onActivityStopped(ObjectWrapper.wrap(this.zza), this.zzi);
    }
}
