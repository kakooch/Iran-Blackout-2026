package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzit implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzp zzc;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzs zzd;
    final /* synthetic */ zzjb zze;

    zzit(zzjb zzjbVar, String str, String str2, zzp zzpVar, com.google.android.gms.internal.measurement.zzs zzsVar) {
        this.zze = zzjbVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzpVar;
        this.zzd = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfl zzflVar;
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            try {
                zzdz zzdzVar = this.zze.zzb;
                if (zzdzVar == null) {
                    this.zze.zzx.zzat().zzb().zzc("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                    zzflVar = this.zze.zzx;
                } else {
                    Preconditions.checkNotNull(this.zzc);
                    arrayList = zzkk.zzak(zzdzVar.zzq(this.zza, this.zzb, this.zzc));
                    this.zze.zzP();
                    zzflVar = this.zze.zzx;
                }
            } catch (RemoteException e) {
                this.zze.zzx.zzat().zzb().zzd("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
                zzflVar = this.zze.zzx;
            }
            zzflVar.zzl().zzaj(this.zzd, arrayList);
        } catch (Throwable th) {
            this.zze.zzx.zzl().zzaj(this.zzd, arrayList);
            throw th;
        }
    }
}
