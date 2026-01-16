package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Rr8;

/* loaded from: classes3.dex */
public final class r extends P0 implements Rr8 {
    private static final r zza;
    private int zzd;
    private String zze = "";
    private InterfaceC20943sr8 zzf = P0.m();
    private boolean zzg;

    static {
        r rVar = new r();
        zza = rVar;
        P0.s(r.class, rVar);
    }

    private r() {
    }

    public final String B() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzd", "zze", "zzf", C2153x.class, "zzg"});
        }
        if (i2 == 3) {
            return new r();
        }
        AbstractC2138p abstractC2138p = null;
        if (i2 == 4) {
            return new C2140q(abstractC2138p);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
