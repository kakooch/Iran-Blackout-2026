package com.google.android.gms.tagmanager;

/* loaded from: classes3.dex */
final class zzba implements Runnable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ zzbe zzb;

    zzba(zzbe zzbeVar, zzaw zzawVar) {
        this.zzb = zzbeVar;
        this.zza = zzawVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza(zzbe.zzf(this.zzb));
    }
}
