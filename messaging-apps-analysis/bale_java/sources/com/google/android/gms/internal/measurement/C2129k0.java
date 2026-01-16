package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Rr8;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.k0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2129k0 extends P0 implements Rr8 {
    private static final C2129k0 zza;
    private int zzd;
    private InterfaceC20943sr8 zze = P0.m();
    private C2121g0 zzf;

    static {
        C2129k0 c2129k0 = new C2129k0();
        zza = c2129k0;
        P0.s(C2129k0.class, c2129k0);
    }

    private C2129k0() {
    }

    public final C2121g0 A() {
        C2121g0 c2121g0 = this.zzf;
        return c2121g0 == null ? C2121g0.C() : c2121g0;
    }

    public final List C() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzd", "zze", C2135n0.class, "zzf"});
        }
        if (i2 == 3) {
            return new C2129k0();
        }
        AbstractC2115e0 abstractC2115e0 = null;
        if (i2 == 4) {
            return new C2127j0(abstractC2115e0);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
