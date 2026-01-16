package com.google.android.gms.internal.gtm;

/* loaded from: classes3.dex */
final class zzbk implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ Runnable zzb;
    final /* synthetic */ zzbq zzc;

    zzbk(zzbq zzbqVar, String str, Runnable runnable) {
        this.zzc = zzbqVar;
        this.zza = str;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzn(this.zza);
        this.zzb.run();
    }
}
