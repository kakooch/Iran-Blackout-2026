package com.google.android.gms.internal.measurement;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzdf extends zzhs<zzdf, zzde> implements zziy {
    private static final zzdf zzk;
    private int zza;
    private long zzg;
    private float zzh;
    private double zzi;
    private String zze = BuildConfig.FLAVOR;
    private String zzf = BuildConfig.FLAVOR;
    private zzhz<zzdf> zzj = zzhs.zzbE();

    static {
        zzdf zzdfVar = new zzdf();
        zzk = zzdfVar;
        zzhs.zzby(zzdf.class, zzdfVar);
    }

    private zzdf() {
    }

    public static zzde zzn() {
        return zzk.zzbt();
    }

    static /* synthetic */ void zzp(zzdf zzdfVar, String str) {
        str.getClass();
        zzdfVar.zza |= 1;
        zzdfVar.zze = str;
    }

    static /* synthetic */ void zzq(zzdf zzdfVar, String str) {
        str.getClass();
        zzdfVar.zza |= 2;
        zzdfVar.zzf = str;
    }

    static /* synthetic */ void zzr(zzdf zzdfVar) {
        zzdfVar.zza &= -3;
        zzdfVar.zzf = zzk.zzf;
    }

    static /* synthetic */ void zzs(zzdf zzdfVar, long j) {
        zzdfVar.zza |= 4;
        zzdfVar.zzg = j;
    }

    static /* synthetic */ void zzt(zzdf zzdfVar) {
        zzdfVar.zza &= -5;
        zzdfVar.zzg = 0L;
    }

    static /* synthetic */ void zzu(zzdf zzdfVar, double d) {
        zzdfVar.zza |= 16;
        zzdfVar.zzi = d;
    }

    static /* synthetic */ void zzv(zzdf zzdfVar) {
        zzdfVar.zza &= -17;
        zzdfVar.zzi = 0.0d;
    }

    static /* synthetic */ void zzw(zzdf zzdfVar, zzdf zzdfVar2) {
        zzdfVar2.getClass();
        zzdfVar.zzz();
        zzdfVar.zzj.add(zzdfVar2);
    }

    static /* synthetic */ void zzx(zzdf zzdfVar, Iterable iterable) {
        zzdfVar.zzz();
        zzgb.zzbs(iterable, zzdfVar.zzj);
    }

    private final void zzz() {
        zzhz<zzdf> zzhzVar = this.zzj;
        if (zzhzVar.zza()) {
            return;
        }
        this.zzj = zzhs.zzbF(zzhzVar);
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final String zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zza & 4) != 0;
    }

    public final long zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zza & 8) != 0;
    }

    public final float zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        return (this.zza & 16) != 0;
    }

    public final double zzj() {
        return this.zzi;
    }

    public final List<zzdf> zzk() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zza", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzdf.class});
        }
        if (i2 == 3) {
            return new zzdf();
        }
        zzcs zzcsVar = null;
        if (i2 == 4) {
            return new zzde(zzcsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzk;
    }

    public final int zzm() {
        return this.zzj.size();
    }
}
