package com.google.android.gms.internal.gtm;

import android.os.Looper;

/* loaded from: classes3.dex */
final class zzcv implements Runnable {
    final /* synthetic */ zzcw zza;

    zzcv(zzcw zzcwVar) {
        this.zza = zzcwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.zza.zzb.zzd().f(this);
            return;
        }
        boolean zZzh = this.zza.zzh();
        this.zza.zzd = 0L;
        if (zZzh) {
            this.zza.zza();
        }
    }
}
