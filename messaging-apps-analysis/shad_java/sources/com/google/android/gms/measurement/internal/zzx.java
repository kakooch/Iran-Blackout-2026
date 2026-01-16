package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzlo;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzx extends zzw {
    final /* synthetic */ zzy zza;
    private final com.google.android.gms.internal.measurement.zzcf zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzx(zzy zzyVar, String str, int i, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        super(str, i);
        this.zza = zzyVar;
        this.zzh = zzcfVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzw
    final int zza() {
        return this.zzh.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzw
    final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzw
    final boolean zzc() {
        return false;
    }

    final boolean zzd(Long l, Long l2, com.google.android.gms.internal.measurement.zzdu zzduVar, boolean z) {
        zzlo.zzb();
        boolean zZzn = this.zza.zzx.zzc().zzn(this.zzb, zzdw.zzY);
        boolean zZze = this.zzh.zze();
        boolean zZzf = this.zzh.zzf();
        boolean zZzh = this.zzh.zzh();
        boolean z2 = zZze || zZzf || zZzh;
        Boolean boolZze = null;
        boolZze = null;
        boolZze = null;
        boolZze = null;
        boolZze = null;
        if (z && !z2) {
            this.zza.zzx.zzat().zzk().zzc("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzc), this.zzh.zza() ? Integer.valueOf(this.zzh.zzb()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.zzby zzbyVarZzd = this.zzh.zzd();
        boolean zZzf2 = zzbyVarZzd.zzf();
        if (zzduVar.zzf()) {
            if (zzbyVarZzd.zzc()) {
                boolZze = zzw.zze(zzw.zzg(zzduVar.zzg(), zzbyVarZzd.zzd()), zZzf2);
            } else {
                this.zza.zzx.zzat().zze().zzb("No number filter for long property. property", this.zza.zzx.zzm().zze(zzduVar.zzc()));
            }
        } else if (zzduVar.zzh()) {
            if (zzbyVarZzd.zzc()) {
                boolZze = zzw.zze(zzw.zzh(zzduVar.zzi(), zzbyVarZzd.zzd()), zZzf2);
            } else {
                this.zza.zzx.zzat().zze().zzb("No number filter for double property. property", this.zza.zzx.zzm().zze(zzduVar.zzc()));
            }
        } else if (!zzduVar.zzd()) {
            this.zza.zzx.zzat().zze().zzb("User property has no value, property", this.zza.zzx.zzm().zze(zzduVar.zzc()));
        } else if (zzbyVarZzd.zza()) {
            boolZze = zzw.zze(zzw.zzf(zzduVar.zze(), zzbyVarZzd.zzb(), this.zza.zzx.zzat()), zZzf2);
        } else if (!zzbyVarZzd.zzc()) {
            this.zza.zzx.zzat().zze().zzb("No string or number filter defined. property", this.zza.zzx.zzm().zze(zzduVar.zzc()));
        } else if (zzkf.zzl(zzduVar.zze())) {
            boolZze = zzw.zze(zzw.zzi(zzduVar.zze(), zzbyVarZzd.zzd()), zZzf2);
        } else {
            this.zza.zzx.zzat().zze().zzc("Invalid user property value for Numeric number filter. property, value", this.zza.zzx.zzm().zze(zzduVar.zzc()), zzduVar.zze());
        }
        this.zza.zzx.zzat().zzk().zzb("Property filter result", boolZze == null ? "null" : boolZze);
        if (boolZze == null) {
            return false;
        }
        this.zzd = Boolean.TRUE;
        if (zZzh && !boolZze.booleanValue()) {
            return true;
        }
        if (!z || this.zzh.zze()) {
            this.zze = boolZze;
        }
        if (boolZze.booleanValue() && z2 && zzduVar.zza()) {
            long jZzb = zzduVar.zzb();
            if (l != null) {
                jZzb = l.longValue();
            }
            if (zZzn && this.zzh.zze() && !this.zzh.zzf() && l2 != null) {
                jZzb = l2.longValue();
            }
            if (this.zzh.zzf()) {
                this.zzg = Long.valueOf(jZzb);
            } else {
                this.zzf = Long.valueOf(jZzb);
            }
        }
        return true;
    }
}
