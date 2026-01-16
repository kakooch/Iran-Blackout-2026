package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzkc {
    com.google.android.gms.internal.measurement.zzdj zza;
    List<Long> zzb;
    List<com.google.android.gms.internal.measurement.zzdb> zzc;
    long zzd;
    final /* synthetic */ zzkd zze;

    /* synthetic */ zzkc(zzkd zzkdVar, zzjw zzjwVar) {
        this.zze = zzkdVar;
    }

    private static final long zzb(com.google.android.gms.internal.measurement.zzdb zzdbVar) {
        return ((zzdbVar.zzf() / 1000) / 60) / 60;
    }

    public final boolean zza(long j, com.google.android.gms.internal.measurement.zzdb zzdbVar) {
        Preconditions.checkNotNull(zzdbVar);
        if (this.zzc == null) {
            this.zzc = new ArrayList();
        }
        if (this.zzb == null) {
            this.zzb = new ArrayList();
        }
        if (this.zzc.size() > 0 && zzb(this.zzc.get(0)) != zzb(zzdbVar)) {
            return false;
        }
        long jZzbw = this.zzd + zzdbVar.zzbw();
        this.zze.zzd();
        if (jZzbw >= Math.max(0, zzdw.zzh.zzb(null).intValue())) {
            return false;
        }
        this.zzd = jZzbw;
        this.zzc.add(zzdbVar);
        this.zzb.add(Long.valueOf(j));
        int size = this.zzc.size();
        this.zze.zzd();
        return size < Math.max(1, zzdw.zzi.zzb(null).intValue());
    }
}
