package com.google.android.gms.internal.measurement;

import ir.nasim.Rr8;

/* loaded from: classes3.dex */
public final class P extends P0 implements Rr8 {
    private static final P zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private D zzg;

    static {
        P p = new P();
        zza = p;
        P0.s(P.class, p);
    }

    private P() {
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new P();
        }
        A a = null;
        if (i2 == 4) {
            return new O(a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
