package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes3.dex */
final class zzas extends zzbg {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzm zzd;
    final /* synthetic */ zzbr zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzas(zzbr zzbrVar, String str, String str2, boolean z, zzm zzmVar) {
        super(zzbrVar, true);
        this.zze = zzbrVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzmVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    final void zza() throws RemoteException {
        this.zze.zzk.getUserProperties(this.zza, this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    protected final void zzb() {
        this.zzd.zzb(null);
    }
}
