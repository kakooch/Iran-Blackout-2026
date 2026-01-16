package com.google.android.gms.internal.measurement;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzbw extends zzhs<zzbw, zzbv> implements zziy {
    private static final zzbw zzm;
    private int zza;
    private int zze;
    private String zzf = BuildConfig.FLAVOR;
    private zzhz<zzby> zzg = zzhs.zzbE();
    private boolean zzh;
    private zzcd zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        zzbw zzbwVar = new zzbw();
        zzm = zzbwVar;
        zzhs.zzby(zzbw.class, zzbwVar);
    }

    private zzbw() {
    }

    public static zzbv zzn() {
        return zzm.zzbt();
    }

    static /* synthetic */ void zzp(zzbw zzbwVar, String str) {
        zzbwVar.zza |= 2;
        zzbwVar.zzf = str;
    }

    static /* synthetic */ void zzq(zzbw zzbwVar, int i, zzby zzbyVar) {
        zzbyVar.getClass();
        zzhz<zzby> zzhzVar = zzbwVar.zzg;
        if (!zzhzVar.zza()) {
            zzbwVar.zzg = zzhs.zzbF(zzhzVar);
        }
        zzbwVar.zzg.set(i, zzbyVar);
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final List<zzby> zzd() {
        return this.zzg;
    }

    public final int zze() {
        return this.zzg.size();
    }

    public final zzby zzf(int i) {
        return this.zzg.get(i);
    }

    public final boolean zzg() {
        return (this.zza & 8) != 0;
    }

    public final zzcd zzh() {
        zzcd zzcdVar = this.zzi;
        return zzcdVar == null ? zzcd.zzk() : zzcdVar;
    }

    public final boolean zzi() {
        return this.zzj;
    }

    public final boolean zzj() {
        return this.zzk;
    }

    public final boolean zzk() {
        return (this.zza & 64) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zzm, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zza", "zze", "zzf", "zzg", zzby.class, "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zzbw();
        }
        zzbs zzbsVar = null;
        if (i2 == 4) {
            return new zzbv(zzbsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzm;
    }

    public final boolean zzm() {
        return this.zzl;
    }
}
