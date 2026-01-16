package com.google.android.gms.internal.gtm;

/* loaded from: classes3.dex */
final class zzbo implements Runnable {
    final /* synthetic */ zzcz zza;
    final /* synthetic */ zzbq zzb;

    zzbo(zzbq zzbqVar, zzcz zzczVar) {
        this.zzb = zzbqVar;
        this.zza = zzczVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzf(this.zza);
    }
}
