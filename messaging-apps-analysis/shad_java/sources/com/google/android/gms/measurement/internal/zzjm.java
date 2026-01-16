package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzjm {
    final /* synthetic */ zzjq zza;
    private zzjl zzb;

    zzjm(zzjq zzjqVar) {
        this.zza = zzjqVar;
    }

    final void zza() {
        this.zza.zzg();
        if (this.zzb != null) {
            this.zza.zzd.removeCallbacks(this.zzb);
        }
        if (this.zza.zzx.zzc().zzn(null, zzdw.zzat)) {
            this.zza.zzx.zzd().zzq.zzb(false);
        }
    }

    final void zzb(long j) {
        this.zzb = new zzjl(this, this.zza.zzx.zzax().currentTimeMillis(), j);
        this.zza.zzd.postDelayed(this.zzb, 2000L);
    }
}
