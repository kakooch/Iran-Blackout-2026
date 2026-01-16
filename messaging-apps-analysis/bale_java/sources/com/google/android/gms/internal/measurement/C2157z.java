package com.google.android.gms.internal.measurement;

import ir.nasim.Rr8;

/* renamed from: com.google.android.gms.internal.measurement.z, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2157z extends P0 implements Rr8 {
    private static final C2157z zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        C2157z c2157z = new C2157z();
        zza = c2157z;
        P0.s(C2157z.class, c2157z);
    }

    private C2157z() {
    }

    public final String B() {
        return this.zze;
    }

    public final String C() {
        return this.zzf;
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
            return new C2157z();
        }
        AbstractC2138p abstractC2138p = null;
        if (i2 == 4) {
            return new C2155y(abstractC2138p);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
