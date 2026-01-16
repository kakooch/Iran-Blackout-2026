package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC19743qr8;
import ir.nasim.Rr8;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.b0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2106b0 extends P0 implements Rr8 {
    private static final C2106b0 zza;
    private int zzd;
    private int zze;
    private InterfaceC19743qr8 zzf = P0.k();

    static {
        C2106b0 c2106b0 = new C2106b0();
        zza = c2106b0;
        P0.s(C2106b0.class, c2106b0);
    }

    private C2106b0() {
    }

    public static C2103a0 D() {
        return (C2103a0) zza.w();
    }

    static /* synthetic */ void G(C2106b0 c2106b0, int i) {
        c2106b0.zzd |= 1;
        c2106b0.zze = i;
    }

    static /* synthetic */ void H(C2106b0 c2106b0, Iterable iterable) {
        InterfaceC19743qr8 interfaceC19743qr8 = c2106b0.zzf;
        if (!interfaceC19743qr8.e()) {
            c2106b0.zzf = P0.l(interfaceC19743qr8);
        }
        AbstractC2137o0.f(iterable, c2106b0.zzf);
    }

    public final int A() {
        return this.zzf.size();
    }

    public final int B() {
        return this.zze;
    }

    public final long C(int i) {
        return this.zzf.zza(i);
    }

    public final List F() {
        return this.zzf;
    }

    public final boolean I() {
        return (this.zzd & 1) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new C2106b0();
        }
        A a = null;
        if (i2 == 4) {
            return new C2103a0(a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
