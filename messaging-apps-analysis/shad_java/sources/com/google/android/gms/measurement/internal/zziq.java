package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zziq implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzas zzc;
    final /* synthetic */ zzjb zze;

    zziq(zzjb zzjbVar, boolean z, zzp zzpVar, boolean z2, zzas zzasVar, String str) {
        this.zze = zzjbVar;
        this.zza = zzpVar;
        this.zzb = z2;
        this.zzc = zzasVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdz zzdzVar = this.zze.zzb;
        if (zzdzVar == null) {
            this.zze.zzx.zzat().zzb().zza("Discarding data. Failed to send event to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        this.zze.zzk(zzdzVar, this.zzb ? null : this.zzc, this.zza);
        this.zze.zzP();
    }
}
