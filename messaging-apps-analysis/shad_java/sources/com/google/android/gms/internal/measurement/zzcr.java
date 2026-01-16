package com.google.android.gms.internal.measurement;

import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzcr extends zzhs<zzcr, zzcq> implements zziy {
    private static final zzcr zzg;
    private int zza;
    private String zze = BuildConfig.FLAVOR;
    private String zzf = BuildConfig.FLAVOR;

    static {
        zzcr zzcrVar = new zzcr();
        zzg = zzcrVar;
        zzhs.zzby(zzcr.class, zzcrVar);
    }

    private zzcr() {
    }

    public final String zza() {
        return this.zze;
    }

    public final String zzb() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zza", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzcr();
        }
        zzcl zzclVar = null;
        if (i2 == 4) {
            return new zzcq(zzclVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzg;
    }
}
