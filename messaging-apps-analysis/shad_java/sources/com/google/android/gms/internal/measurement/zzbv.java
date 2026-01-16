package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzbv extends zzho<zzbw, zzbv> implements zziy {
    private zzbv() {
        super(zzbw.zzm);
    }

    /* synthetic */ zzbv(zzbs zzbsVar) {
        super(zzbw.zzm);
    }

    public final String zza() {
        return ((zzbw) this.zza).zzc();
    }

    public final zzbv zzb(String str) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzbw.zzp((zzbw) this.zza, str);
        return this;
    }

    public final int zzc() {
        return ((zzbw) this.zza).zze();
    }

    public final zzby zzd(int i) {
        return ((zzbw) this.zza).zzf(i);
    }

    public final zzbv zze(int i, zzby zzbyVar) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzbw.zzq((zzbw) this.zza, i, zzbyVar);
        return this;
    }
}
