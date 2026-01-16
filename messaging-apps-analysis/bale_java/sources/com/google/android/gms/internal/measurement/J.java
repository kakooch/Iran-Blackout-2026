package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Rr8;
import java.util.List;

/* loaded from: classes3.dex */
public final class J extends P0 implements Rr8 {
    private static final J zza;
    private int zzd;
    private InterfaceC20943sr8 zze = P0.m();
    private String zzf = "";
    private long zzg;
    private long zzh;
    private int zzi;

    static {
        J j = new J();
        zza = j;
        P0.s(J.class, j);
    }

    private J() {
    }

    public static I E() {
        return (I) zza.w();
    }

    static /* synthetic */ void J(J j, int i, N n) {
        n.getClass();
        j.V();
        j.zze.set(i, n);
    }

    static /* synthetic */ void K(J j, N n) {
        n.getClass();
        j.V();
        j.zze.add(n);
    }

    static /* synthetic */ void L(J j, Iterable iterable) {
        j.V();
        AbstractC2137o0.f(iterable, j.zze);
    }

    static /* synthetic */ void N(J j, int i) {
        j.V();
        j.zze.remove(i);
    }

    static /* synthetic */ void O(J j, String str) {
        str.getClass();
        j.zzd |= 1;
        j.zzf = str;
    }

    static /* synthetic */ void P(J j, long j2) {
        j.zzd |= 2;
        j.zzg = j2;
    }

    static /* synthetic */ void Q(J j, long j2) {
        j.zzd |= 4;
        j.zzh = j2;
    }

    private final void V() {
        InterfaceC20943sr8 interfaceC20943sr8 = this.zze;
        if (interfaceC20943sr8.e()) {
            return;
        }
        this.zze = P0.n(interfaceC20943sr8);
    }

    public final int A() {
        return this.zzi;
    }

    public final int B() {
        return this.zze.size();
    }

    public final long C() {
        return this.zzh;
    }

    public final long D() {
        return this.zzg;
    }

    public final N G(int i) {
        return (N) this.zze.get(i);
    }

    public final String H() {
        return this.zzf;
    }

    public final List I() {
        return this.zze;
    }

    public final boolean R() {
        return (this.zzd & 8) != 0;
    }

    public final boolean T() {
        return (this.zzd & 4) != 0;
    }

    public final boolean U() {
        return (this.zzd & 2) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzd", "zze", N.class, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new J();
        }
        A a = null;
        if (i2 == 4) {
            return new I(a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
