package com.google.android.gms.internal.measurement;

import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzdd extends zzhs<zzdd, zzdc> implements zziy {
    private static final zzdd zzg;
    private int zza;
    private String zze = BuildConfig.FLAVOR;
    private long zzf;

    static {
        zzdd zzddVar = new zzdd();
        zzg = zzddVar;
        zzhs.zzby(zzdd.class, zzddVar);
    }

    private zzdd() {
    }

    public static zzdc zza() {
        return zzg.zzbt();
    }

    static /* synthetic */ void zzc(zzdd zzddVar, String str) {
        str.getClass();
        zzddVar.zza |= 1;
        zzddVar.zze = str;
    }

    static /* synthetic */ void zzd(zzdd zzddVar, long j) {
        zzddVar.zza |= 2;
        zzddVar.zzf = j;
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zza", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzdd();
        }
        zzcs zzcsVar = null;
        if (i2 == 4) {
            return new zzdc(zzcsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzg;
    }
}
