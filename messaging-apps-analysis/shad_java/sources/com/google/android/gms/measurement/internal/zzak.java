package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzak implements Runnable {
    final /* synthetic */ zzgg zza;
    final /* synthetic */ zzal zzb;

    zzak(zzal zzalVar, zzgg zzggVar) {
        this.zzb = zzalVar;
        this.zza = zzggVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zza.zzas();
        if (zzz.zza()) {
            this.zza.zzau().zzh(this);
            return;
        }
        boolean zZzc = this.zzb.zzc();
        zzal.zze(this.zzb, 0L);
        if (zZzc) {
            this.zzb.zza();
        }
    }
}
