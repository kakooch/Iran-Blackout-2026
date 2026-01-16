package com.google.android.gms.internal.measurement;

import ir.nasim.Rr8;

/* renamed from: com.google.android.gms.internal.measurement.x, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2153x extends P0 implements Rr8 {
    private static final C2153x zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        C2153x c2153x = new C2153x();
        zza = c2153x;
        P0.s(C2153x.class, c2153x);
    }

    private C2153x() {
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new C2153x();
        }
        AbstractC2138p abstractC2138p = null;
        if (i2 == 4) {
            return new C2151w(abstractC2138p);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
