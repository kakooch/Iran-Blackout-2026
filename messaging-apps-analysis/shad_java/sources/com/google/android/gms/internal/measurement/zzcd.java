package com.google.android.gms.internal.measurement;

import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzcd extends zzhs<zzcd, zzbz> implements zziy {
    private static final zzcd zzj;
    private int zza;
    private int zze;
    private boolean zzf;
    private String zzg = BuildConfig.FLAVOR;
    private String zzh = BuildConfig.FLAVOR;
    private String zzi = BuildConfig.FLAVOR;

    static {
        zzcd zzcdVar = new zzcd();
        zzj = zzcdVar;
        zzhs.zzby(zzcd.class, zzcdVar);
    }

    private zzcd() {
    }

    public static zzcd zzk() {
        return zzj;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final zzcc zzb() {
        zzcc zzccVarZza = zzcc.zza(this.zze);
        return zzccVarZza == null ? zzcc.UNKNOWN_COMPARISON_TYPE : zzccVarZza;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final boolean zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zza & 4) != 0;
    }

    public final String zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zza & 8) != 0;
    }

    public final String zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        return (this.zza & 16) != 0;
    }

    public final String zzj() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zza", "zze", zzcc.zzb(), "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzcd();
        }
        zzbs zzbsVar = null;
        if (i2 == 4) {
            return new zzbz(zzbsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzj;
    }
}
