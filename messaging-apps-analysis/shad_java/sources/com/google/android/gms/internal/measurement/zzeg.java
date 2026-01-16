package com.google.android.gms.internal.measurement;

import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzeg extends zzhs<zzeg, zzec> implements zziy {
    private static final zzeg zzk;
    private int zza;
    private int zze;
    private zzhz<zzeg> zzf = zzhs.zzbE();
    private String zzg = BuildConfig.FLAVOR;
    private String zzh = BuildConfig.FLAVOR;
    private boolean zzi;
    private double zzj;

    static {
        zzeg zzegVar = new zzeg();
        zzk = zzegVar;
        zzhs.zzby(zzeg.class, zzegVar);
    }

    private zzeg() {
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zza", "zze", zzef.zzb(), "zzf", zzeg.class, "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzeg();
        }
        zzdv zzdvVar = null;
        if (i2 == 4) {
            return new zzec(zzdvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzk;
    }
}
