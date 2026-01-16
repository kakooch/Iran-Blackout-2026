package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC19743qr8;
import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Rr8;
import java.util.List;

/* loaded from: classes3.dex */
public final class Z extends P0 implements Rr8 {
    private static final Z zza;
    private InterfaceC19743qr8 zzd = P0.k();
    private InterfaceC19743qr8 zze = P0.k();
    private InterfaceC20943sr8 zzf = P0.m();
    private InterfaceC20943sr8 zzg = P0.m();

    static {
        Z z = new Z();
        zza = z;
        P0.s(Z.class, z);
    }

    private Z() {
    }

    public static Y F() {
        return (Y) zza.w();
    }

    public static Z H() {
        return zza;
    }

    static /* synthetic */ void N(Z z, Iterable iterable) {
        InterfaceC19743qr8 interfaceC19743qr8 = z.zzd;
        if (!interfaceC19743qr8.e()) {
            z.zzd = P0.l(interfaceC19743qr8);
        }
        AbstractC2137o0.f(iterable, z.zzd);
    }

    static /* synthetic */ void P(Z z, Iterable iterable) {
        InterfaceC19743qr8 interfaceC19743qr8 = z.zze;
        if (!interfaceC19743qr8.e()) {
            z.zze = P0.l(interfaceC19743qr8);
        }
        AbstractC2137o0.f(iterable, z.zze);
    }

    static /* synthetic */ void R(Z z, Iterable iterable) {
        z.Y();
        AbstractC2137o0.f(iterable, z.zzf);
    }

    static /* synthetic */ void U(Z z, int i) {
        z.Y();
        z.zzf.remove(i);
    }

    static /* synthetic */ void V(Z z, Iterable iterable) {
        z.Z();
        AbstractC2137o0.f(iterable, z.zzg);
    }

    static /* synthetic */ void X(Z z, int i) {
        z.Z();
        z.zzg.remove(i);
    }

    private final void Y() {
        InterfaceC20943sr8 interfaceC20943sr8 = this.zzf;
        if (interfaceC20943sr8.e()) {
            return;
        }
        this.zzf = P0.n(interfaceC20943sr8);
    }

    private final void Z() {
        InterfaceC20943sr8 interfaceC20943sr8 = this.zzg;
        if (interfaceC20943sr8.e()) {
            return;
        }
        this.zzg = P0.n(interfaceC20943sr8);
    }

    public final int A() {
        return this.zzf.size();
    }

    public final int B() {
        return this.zze.size();
    }

    public final int C() {
        return this.zzg.size();
    }

    public final int D() {
        return this.zzd.size();
    }

    public final H E(int i) {
        return (H) this.zzf.get(i);
    }

    public final C2106b0 I(int i) {
        return (C2106b0) this.zzg.get(i);
    }

    public final List J() {
        return this.zzf;
    }

    public final List K() {
        return this.zze;
    }

    public final List L() {
        return this.zzg;
    }

    public final List M() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzd", "zze", "zzf", H.class, "zzg", C2106b0.class});
        }
        if (i2 == 3) {
            return new Z();
        }
        A a = null;
        if (i2 == 4) {
            return new Y(a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
