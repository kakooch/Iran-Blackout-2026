package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzlx;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzjo {
    protected long zza;
    protected long zzb;
    final /* synthetic */ zzjq zzc;
    private final zzal zzd;

    public zzjo(zzjq zzjqVar) {
        this.zzc = zzjqVar;
        this.zzd = new zzjn(this, zzjqVar.zzx);
        long jElapsedRealtime = zzjqVar.zzx.zzax().elapsedRealtime();
        this.zza = jElapsedRealtime;
        this.zzb = jElapsedRealtime;
    }

    final void zza(long j) {
        this.zzc.zzg();
        this.zzd.zzd();
        this.zza = j;
        this.zzb = j;
    }

    final void zzb(long j) {
        this.zzd.zzd();
    }

    final void zzc() {
        this.zzd.zzd();
        this.zza = 0L;
        this.zzb = 0L;
    }

    public final boolean zzd(boolean z, boolean z2, long j) {
        this.zzc.zzg();
        this.zzc.zzb();
        zzlx.zzb();
        if (!this.zzc.zzx.zzc().zzn(null, zzdw.zzao) || this.zzc.zzx.zzF()) {
            this.zzc.zzx.zzd().zzo.zzb(this.zzc.zzx.zzax().currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (!z && j2 < 1000) {
            this.zzc.zzx.zzat().zzk().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
            return false;
        }
        if (!z2) {
            j2 = j - this.zzb;
            this.zzb = j;
        }
        this.zzc.zzx.zzat().zzk().zzb("Recording user engagement, ms", Long.valueOf(j2));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j2);
        zzib.zzm(this.zzc.zzx.zzx().zzh(!this.zzc.zzx.zzc().zzt()), bundle, true);
        zzae zzaeVarZzc = this.zzc.zzx.zzc();
        zzdv<Boolean> zzdvVar = zzdw.zzT;
        if (!zzaeVarZzc.zzn(null, zzdvVar) && z2) {
            bundle.putLong("_fr", 1L);
        }
        if (!this.zzc.zzx.zzc().zzn(null, zzdvVar) || !z2) {
            this.zzc.zzx.zzk().zzs("auto", "_e", bundle);
        }
        this.zza = j;
        this.zzd.zzd();
        this.zzd.zzb(3600000L);
        return true;
    }
}
