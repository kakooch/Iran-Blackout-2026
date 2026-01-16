package com.google.android.gms.internal.measurement;

import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzby extends zzhs<zzby, zzbx> implements zziy {
    private static final zzby zzi;
    private int zza;
    private zzck zze;
    private zzcd zzf;
    private boolean zzg;
    private String zzh = BuildConfig.FLAVOR;

    static {
        zzby zzbyVar = new zzby();
        zzi = zzbyVar;
        zzhs.zzby(zzby.class, zzbyVar);
    }

    private zzby() {
    }

    public static zzby zzi() {
        return zzi;
    }

    static /* synthetic */ void zzk(zzby zzbyVar, String str) {
        zzbyVar.zza |= 8;
        zzbyVar.zzh = str;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final zzck zzb() {
        zzck zzckVar = this.zze;
        return zzckVar == null ? zzck.zzi() : zzckVar;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final zzcd zzd() {
        zzcd zzcdVar = this.zzf;
        return zzcdVar == null ? zzcd.zzk() : zzcdVar;
    }

    public final boolean zze() {
        return (this.zza & 4) != 0;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zza & 8) != 0;
    }

    public final String zzh() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zza", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzby();
        }
        zzbs zzbsVar = null;
        if (i2 == 4) {
            return new zzbx(zzbsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzi;
    }
}
