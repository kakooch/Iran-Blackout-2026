package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Rr8;

/* loaded from: classes3.dex */
public final class X extends P0 implements Rr8 {
    private static final X zza;
    private int zzd;
    private int zze = 1;
    private InterfaceC20943sr8 zzf = P0.m();

    static {
        X x = new X();
        zza = x;
        P0.s(X.class, x);
    }

    private X() {
    }

    public static V A() {
        return (V) zza.w();
    }

    static /* synthetic */ void C(X x, L l) {
        l.getClass();
        InterfaceC20943sr8 interfaceC20943sr8 = x.zzf;
        if (!interfaceC20943sr8.e()) {
            x.zzf = P0.n(interfaceC20943sr8);
        }
        x.zzf.add(l);
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzd", "zze", W.a, "zzf", L.class});
        }
        if (i2 == 3) {
            return new X();
        }
        A a = null;
        if (i2 == 4) {
            return new V(a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
