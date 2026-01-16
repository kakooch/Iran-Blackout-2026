package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzip implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzjb zzb;

    zzip(zzjb zzjbVar, zzp zzpVar) {
        this.zzb = zzjbVar;
        this.zza = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdz zzdzVar = this.zzb.zzb;
        if (zzdzVar == null) {
            this.zzb.zzx.zzat().zzb().zza("Failed to send consent settings to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzdzVar.zzu(this.zza);
            this.zzb.zzP();
        } catch (RemoteException e) {
            this.zzb.zzx.zzat().zzb().zzb("Failed to send consent settings to the service", e);
        }
    }
}
