package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzjq extends zzf {
    protected final zzjp zza;
    protected final zzjo zzb;
    protected final zzjm zzc;
    private Handler zzd;

    zzjq(zzfl zzflVar) {
        super(zzflVar);
        this.zza = new zzjp(this);
        this.zzb = new zzjo(this);
        this.zzc = new zzjm(this);
    }

    static /* synthetic */ void zzh(zzjq zzjqVar, long j) {
        zzjqVar.zzg();
        zzjqVar.zzl();
        zzjqVar.zzx.zzat().zzk().zzb("Activity resumed, time", Long.valueOf(j));
        zzae zzaeVarZzc = zzjqVar.zzx.zzc();
        zzdv<Boolean> zzdvVar = zzdw.zzat;
        if (zzaeVarZzc.zzn(null, zzdvVar)) {
            if (zzjqVar.zzx.zzc().zzt() || zzjqVar.zzx.zzd().zzq.zza()) {
                zzjqVar.zzb.zza(j);
            }
            zzjqVar.zzc.zza();
        } else {
            zzjqVar.zzc.zza();
            if (zzjqVar.zzx.zzc().zzt()) {
                zzjqVar.zzb.zza(j);
            }
        }
        zzjp zzjpVar = zzjqVar.zza;
        zzjpVar.zza.zzg();
        if (zzjpVar.zza.zzx.zzF()) {
            if (!zzjpVar.zza.zzx.zzc().zzn(null, zzdvVar)) {
                zzjpVar.zza.zzx.zzd().zzq.zzb(false);
            }
            zzjpVar.zzb(zzjpVar.zza.zzx.zzax().currentTimeMillis(), false);
        }
    }

    static /* synthetic */ void zzi(zzjq zzjqVar, long j) {
        zzjqVar.zzg();
        zzjqVar.zzl();
        zzjqVar.zzx.zzat().zzk().zzb("Activity paused, time", Long.valueOf(j));
        zzjqVar.zzc.zzb(j);
        if (zzjqVar.zzx.zzc().zzt()) {
            zzjqVar.zzb.zzb(j);
        }
        zzjp zzjpVar = zzjqVar.zza;
        if (zzjpVar.zza.zzx.zzc().zzn(null, zzdw.zzat)) {
            return;
        }
        zzjpVar.zza.zzx.zzd().zzq.zzb(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new com.google.android.gms.internal.measurement.zzl(Looper.getMainLooper());
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zze() {
        return false;
    }
}
