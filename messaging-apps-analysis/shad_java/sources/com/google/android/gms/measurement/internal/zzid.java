package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzid implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzkg zzc;
    final /* synthetic */ zzjb zzd;

    zzid(zzjb zzjbVar, zzp zzpVar, boolean z, zzkg zzkgVar) {
        this.zzd = zzjbVar;
        this.zza = zzpVar;
        this.zzb = z;
        this.zzc = zzkgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdz zzdzVar = this.zzd.zzb;
        if (zzdzVar == null) {
            this.zzd.zzx.zzat().zzb().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        this.zzd.zzk(zzdzVar, this.zzb ? null : this.zzc, this.zza);
        this.zzd.zzP();
    }
}
