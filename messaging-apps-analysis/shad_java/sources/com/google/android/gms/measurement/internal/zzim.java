package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzim implements Runnable {
    final /* synthetic */ zzas zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzs zzc;
    final /* synthetic */ zzjb zzd;

    zzim(zzjb zzjbVar, zzas zzasVar, String str, com.google.android.gms.internal.measurement.zzs zzsVar) {
        this.zzd = zzjbVar;
        this.zza = zzasVar;
        this.zzb = str;
        this.zzc = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfl zzflVar;
        byte[] bArrZzj = null;
        try {
            try {
                zzdz zzdzVar = this.zzd.zzb;
                if (zzdzVar == null) {
                    this.zzd.zzx.zzat().zzb().zza("Discarding data. Failed to send event to service to bundle");
                    zzflVar = this.zzd.zzx;
                } else {
                    bArrZzj = zzdzVar.zzj(this.zza, this.zzb);
                    this.zzd.zzP();
                    zzflVar = this.zzd.zzx;
                }
            } catch (RemoteException e) {
                this.zzd.zzx.zzat().zzb().zzb("Failed to send event to the service to bundle", e);
                zzflVar = this.zzd.zzx;
            }
            zzflVar.zzl().zzag(this.zzc, bArrZzj);
        } catch (Throwable th) {
            this.zzd.zzx.zzl().zzag(this.zzc, bArrZzj);
            throw th;
        }
    }
}
