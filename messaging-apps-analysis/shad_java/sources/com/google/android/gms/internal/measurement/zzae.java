package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes3.dex */
final class zzae extends zzbg {
    final /* synthetic */ Activity zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzbr zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzae(zzbr zzbrVar, Activity activity, String str, String str2) {
        super(zzbrVar, true);
        this.zzd = zzbrVar;
        this.zza = activity;
        this.zzb = str;
        this.zzc = str2;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    final void zza() throws RemoteException {
        this.zzd.zzk.setCurrentScreen(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, this.zzh);
    }
}
