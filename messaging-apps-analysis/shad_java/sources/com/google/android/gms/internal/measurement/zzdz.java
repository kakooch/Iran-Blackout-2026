package com.google.android.gms.internal.measurement;

import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzdz extends zzhs<zzdz, zzdy> implements zziy {
    private static final zzdz zzg;
    private int zza;
    private String zze = BuildConfig.FLAVOR;
    private zzhz<zzeg> zzf = zzhs.zzbE();

    static {
        zzdz zzdzVar = new zzdz();
        zzg = zzdzVar;
        zzhs.zzby(zzdz.class, zzdzVar);
    }

    private zzdz() {
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zza", "zze", "zzf", zzeg.class});
        }
        if (i2 == 3) {
            return new zzdz();
        }
        zzdv zzdvVar = null;
        if (i2 == 4) {
            return new zzdy(zzdvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzg;
    }
}
