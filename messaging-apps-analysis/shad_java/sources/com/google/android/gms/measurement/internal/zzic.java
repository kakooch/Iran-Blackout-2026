package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzic implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzp zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzs zze;
    final /* synthetic */ zzjb zzf;

    zzic(zzjb zzjbVar, String str, String str2, zzp zzpVar, boolean z, com.google.android.gms.internal.measurement.zzs zzsVar) {
        this.zzf = zzjbVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzpVar;
        this.zzd = z;
        this.zze = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Bundle bundle;
        RemoteException e;
        Bundle bundle2 = new Bundle();
        try {
            zzdz zzdzVar = this.zzf.zzb;
            if (zzdzVar == null) {
                this.zzf.zzx.zzat().zzb().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                this.zzf.zzx.zzl().zzai(this.zze, bundle2);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            List<zzkg> listZzo = zzdzVar.zzo(this.zza, this.zzb, this.zzd, this.zzc);
            bundle = new Bundle();
            if (listZzo != null) {
                for (zzkg zzkgVar : listZzo) {
                    String str = zzkgVar.zze;
                    if (str != null) {
                        bundle.putString(zzkgVar.zzb, str);
                    } else {
                        Long l = zzkgVar.zzd;
                        if (l != null) {
                            bundle.putLong(zzkgVar.zzb, l.longValue());
                        } else {
                            Double d = zzkgVar.zzg;
                            if (d != null) {
                                bundle.putDouble(zzkgVar.zzb, d.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                try {
                    this.zzf.zzP();
                    this.zzf.zzx.zzl().zzai(this.zze, bundle);
                } catch (RemoteException e2) {
                    e = e2;
                    this.zzf.zzx.zzat().zzb().zzc("Failed to get user properties; remote exception", this.zza, e);
                    this.zzf.zzx.zzl().zzai(this.zze, bundle);
                }
            } catch (Throwable th) {
                th = th;
                bundle2 = bundle;
                this.zzf.zzx.zzl().zzai(this.zze, bundle2);
                throw th;
            }
        } catch (RemoteException e3) {
            bundle = bundle2;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            this.zzf.zzx.zzl().zzai(this.zze, bundle2);
            throw th;
        }
    }
}
