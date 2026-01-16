package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Rr8;
import java.util.List;

/* loaded from: classes3.dex */
public final class S extends P0 implements Rr8 {
    private static final S zza;
    private InterfaceC20943sr8 zzd = P0.m();

    static {
        S s = new S();
        zza = s;
        P0.s(S.class, s);
    }

    private S() {
    }

    public static Q A() {
        return (Q) zza.w();
    }

    static /* synthetic */ void E(S s, U u) {
        u.getClass();
        InterfaceC20943sr8 interfaceC20943sr8 = s.zzd;
        if (!interfaceC20943sr8.e()) {
            s.zzd = P0.n(interfaceC20943sr8);
        }
        s.zzd.add(u);
    }

    public final U C(int i) {
        return (U) this.zzd.get(0);
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
            return P0.p(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", U.class});
        }
        if (i2 == 3) {
            return new S();
        }
        A a = null;
        if (i2 == 4) {
            return new Q(a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
