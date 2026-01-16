package com.google.android.gms.internal.measurement;

import ir.nasim.Rr8;

/* loaded from: classes3.dex */
public final class D extends P0 implements Rr8 {
    private static final D zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        D d = new D();
        zza = d;
        P0.s(D.class, d);
    }

    private D() {
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new D();
        }
        A a = null;
        if (i2 == 4) {
            return new C(a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
