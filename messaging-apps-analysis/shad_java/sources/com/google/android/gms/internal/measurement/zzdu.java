package com.google.android.gms.internal.measurement;

import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzdu extends zzhs<zzdu, zzdt> implements zziy {
    private static final zzdu zzk;
    private int zza;
    private long zze;
    private String zzf = BuildConfig.FLAVOR;
    private String zzg = BuildConfig.FLAVOR;
    private long zzh;
    private float zzi;
    private double zzj;

    static {
        zzdu zzduVar = new zzdu();
        zzk = zzduVar;
        zzhs.zzby(zzdu.class, zzduVar);
    }

    private zzdu() {
    }

    public static zzdt zzj() {
        return zzk.zzbt();
    }

    static /* synthetic */ void zzm(zzdu zzduVar, long j) {
        zzduVar.zza |= 1;
        zzduVar.zze = j;
    }

    static /* synthetic */ void zzn(zzdu zzduVar, String str) {
        str.getClass();
        zzduVar.zza |= 2;
        zzduVar.zzf = str;
    }

    static /* synthetic */ void zzo(zzdu zzduVar, String str) {
        str.getClass();
        zzduVar.zza |= 4;
        zzduVar.zzg = str;
    }

    static /* synthetic */ void zzp(zzdu zzduVar) {
        zzduVar.zza &= -5;
        zzduVar.zzg = zzk.zzg;
    }

    static /* synthetic */ void zzq(zzdu zzduVar, long j) {
        zzduVar.zza |= 8;
        zzduVar.zzh = j;
    }

    static /* synthetic */ void zzr(zzdu zzduVar) {
        zzduVar.zza &= -9;
        zzduVar.zzh = 0L;
    }

    static /* synthetic */ void zzs(zzdu zzduVar, double d) {
        zzduVar.zza |= 32;
        zzduVar.zzj = d;
    }

    static /* synthetic */ void zzt(zzdu zzduVar) {
        zzduVar.zza &= -33;
        zzduVar.zzj = 0.0d;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final long zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return (this.zza & 4) != 0;
    }

    public final String zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        return (this.zza & 8) != 0;
    }

    public final long zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        return (this.zza & 32) != 0;
    }

    public final double zzi() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zza", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzdu();
        }
        zzcs zzcsVar = null;
        if (i2 == 4) {
            return new zzdt(zzcsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzk;
    }
}
