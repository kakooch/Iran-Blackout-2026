package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes3.dex */
final class zzbo extends zzbg {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzm zzb;
    final /* synthetic */ zzbq zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbo(zzbq zzbqVar, Activity activity, zzm zzmVar) {
        super(zzbqVar.zza, true);
        this.zzc = zzbqVar;
        this.zza = activity;
        this.zzb = zzmVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    final void zza() throws RemoteException {
        this.zzc.zza.zzk.onActivitySaveInstanceState(ObjectWrapper.wrap(this.zza), this.zzb, this.zzi);
    }
}
