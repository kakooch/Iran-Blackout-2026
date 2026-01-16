package com.google.android.gms.internal.measurement;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzck extends zzhs<zzck, zzcg> implements zziy {
    private static final zzck zzi;
    private int zza;
    private int zze;
    private boolean zzg;
    private String zzf = BuildConfig.FLAVOR;
    private zzhz<String> zzh = zzhs.zzbE();

    static {
        zzck zzckVar = new zzck();
        zzi = zzckVar;
        zzhs.zzby(zzck.class, zzckVar);
    }

    private zzck() {
    }

    public static zzck zzi() {
        return zzi;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final zzcj zzb() {
        zzcj zzcjVarZza = zzcj.zza(this.zze);
        return zzcjVarZza == null ? zzcj.UNKNOWN_MATCH_TYPE : zzcjVarZza;
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

    public final boolean zzf() {
        return this.zzg;
    }

    public final List<String> zzg() {
        return this.zzh;
    }

    public final int zzh() {
        return this.zzh.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zza", "zze", zzcj.zzb(), "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzck();
        }
        zzbs zzbsVar = null;
        if (i2 == 4) {
            return new zzcg(zzbsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzi;
    }
}
