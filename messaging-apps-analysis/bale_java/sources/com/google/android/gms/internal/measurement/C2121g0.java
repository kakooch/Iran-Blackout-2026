package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Rr8;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.g0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2121g0 extends P0 implements Rr8 {
    private static final C2121g0 zza;
    private InterfaceC20943sr8 zzd = P0.m();

    static {
        C2121g0 c2121g0 = new C2121g0();
        zza = c2121g0;
        P0.s(C2121g0.class, c2121g0);
    }

    private C2121g0() {
    }

    public static C2121g0 C() {
        return zza;
    }

    public final int A() {
        return this.zzd.size();
    }

    public final List D() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", C2125i0.class});
        }
        if (i2 == 3) {
            return new C2121g0();
        }
        AbstractC2115e0 abstractC2115e0 = null;
        if (i2 == 4) {
            return new C2118f0(abstractC2115e0);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
