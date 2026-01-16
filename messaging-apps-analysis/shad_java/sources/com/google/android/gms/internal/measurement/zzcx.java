package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzcx extends zzhs<zzcx, zzcw> implements zziy {
    private static final zzcx zzi;
    private int zza;
    private int zze;
    private zzdq zzf;
    private zzdq zzg;
    private boolean zzh;

    static {
        zzcx zzcxVar = new zzcx();
        zzi = zzcxVar;
        zzhs.zzby(zzcx.class, zzcxVar);
    }

    private zzcx() {
    }

    public static zzcw zzh() {
        return zzi.zzbt();
    }

    static /* synthetic */ void zzj(zzcx zzcxVar, int i) {
        zzcxVar.zza |= 1;
        zzcxVar.zze = i;
    }

    static /* synthetic */ void zzk(zzcx zzcxVar, zzdq zzdqVar) {
        zzdqVar.getClass();
        zzcxVar.zzf = zzdqVar;
        zzcxVar.zza |= 2;
    }

    static /* synthetic */ void zzm(zzcx zzcxVar, zzdq zzdqVar) {
        zzcxVar.zzg = zzdqVar;
        zzcxVar.zza |= 4;
    }

    static /* synthetic */ void zzn(zzcx zzcxVar, boolean z) {
        zzcxVar.zza |= 8;
        zzcxVar.zzh = z;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final zzdq zzc() {
        zzdq zzdqVar = this.zzf;
        return zzdqVar == null ? zzdq.zzm() : zzdqVar;
    }

    public final boolean zzd() {
        return (this.zza & 4) != 0;
    }

    public final zzdq zze() {
        zzdq zzdqVar = this.zzg;
        return zzdqVar == null ? zzdq.zzm() : zzdqVar;
    }

    public final boolean zzf() {
        return (this.zza & 8) != 0;
    }

    public final boolean zzg() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zza", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzcx();
        }
        zzcs zzcsVar = null;
        if (i2 == 4) {
            return new zzcw(zzcsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzi;
    }
}
