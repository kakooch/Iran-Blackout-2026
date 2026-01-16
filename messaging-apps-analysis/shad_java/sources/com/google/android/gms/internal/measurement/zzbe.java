package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes3.dex */
final class zzbe extends zzbg {
    final /* synthetic */ Long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ boolean zzf;
    final /* synthetic */ zzbr zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbe(zzbr zzbrVar, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzbrVar, true);
        this.zzg = zzbrVar;
        this.zza = l;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bundle;
        this.zze = z;
        this.zzf = z2;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    final void zza() throws RemoteException {
        Long l = this.zza;
        this.zzg.zzk.logEvent(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, l == null ? this.zzh : l.longValue());
    }
}
