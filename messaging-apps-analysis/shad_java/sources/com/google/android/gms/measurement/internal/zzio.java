package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzio implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzjb zzb;

    zzio(zzjb zzjbVar, zzp zzpVar) {
        this.zzb = zzjbVar;
        this.zza = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdz zzdzVar = this.zzb.zzb;
        if (zzdzVar == null) {
            this.zzb.zzx.zzat().zzb().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzdzVar.zzh(this.zza);
            this.zzb.zzP();
        } catch (RemoteException e) {
            this.zzb.zzx.zzat().zzb().zzb("Failed to send measurementEnabled to the service", e);
        }
    }
}
