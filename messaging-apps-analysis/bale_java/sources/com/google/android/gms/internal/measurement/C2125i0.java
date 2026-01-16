package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Rr8;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.i0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2125i0 extends P0 implements Rr8 {
    private static final C2125i0 zza;
    private int zzd;
    private String zze = "";
    private InterfaceC20943sr8 zzf = P0.m();

    static {
        C2125i0 c2125i0 = new C2125i0();
        zza = c2125i0;
        P0.s(C2125i0.class, c2125i0);
    }

    private C2125i0() {
    }

    public final String B() {
        return this.zze;
    }

    public final List C() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzd", "zze", "zzf", C2135n0.class});
        }
        if (i2 == 3) {
            return new C2125i0();
        }
        AbstractC2115e0 abstractC2115e0 = null;
        if (i2 == 4) {
            return new C2123h0(abstractC2115e0);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
