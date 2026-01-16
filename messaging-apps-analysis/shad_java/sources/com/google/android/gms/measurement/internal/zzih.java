package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzlc;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzih implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzs zzb;
    final /* synthetic */ zzjb zzc;

    zzih(zzjb zzjbVar, zzp zzpVar, com.google.android.gms.internal.measurement.zzs zzsVar) {
        this.zzc = zzjbVar;
        this.zza = zzpVar;
        this.zzb = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfl zzflVar;
        String strZzl = null;
        try {
            try {
                zzlc.zzb();
                if (!this.zzc.zzx.zzc().zzn(null, zzdw.zzaw) || this.zzc.zzx.zzd().zzi().zzh()) {
                    zzdz zzdzVar = this.zzc.zzb;
                    if (zzdzVar == null) {
                        this.zzc.zzx.zzat().zzb().zza("Failed to get app instance id");
                        zzflVar = this.zzc.zzx;
                    } else {
                        Preconditions.checkNotNull(this.zza);
                        strZzl = zzdzVar.zzl(this.zza);
                        if (strZzl != null) {
                            this.zzc.zzx.zzk().zzE(strZzl);
                            this.zzc.zzx.zzd().zzj.zzb(strZzl);
                        }
                        this.zzc.zzP();
                        zzflVar = this.zzc.zzx;
                    }
                } else {
                    this.zzc.zzx.zzat().zzh().zza("Analytics storage consent denied; will not get app instance id");
                    this.zzc.zzx.zzk().zzE(null);
                    this.zzc.zzx.zzd().zzj.zzb(null);
                    zzflVar = this.zzc.zzx;
                }
            } catch (RemoteException e) {
                this.zzc.zzx.zzat().zzb().zzb("Failed to get app instance id", e);
                zzflVar = this.zzc.zzx;
            }
            zzflVar.zzl().zzad(this.zzb, strZzl);
        } catch (Throwable th) {
            this.zzc.zzx.zzl().zzad(this.zzb, null);
            throw th;
        }
    }
}
