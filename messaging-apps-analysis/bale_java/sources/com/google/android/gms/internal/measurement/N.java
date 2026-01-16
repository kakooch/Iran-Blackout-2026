package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Rr8;
import java.util.List;

/* loaded from: classes3.dex */
public final class N extends P0 implements Rr8 {
    private static final N zza;
    private int zzd;
    private long zzg;
    private float zzh;
    private double zzi;
    private String zze = "";
    private String zzf = "";
    private InterfaceC20943sr8 zzj = P0.m();

    static {
        N n = new N();
        zza = n;
        P0.s(N.class, n);
    }

    private N() {
    }

    public static M E() {
        return (M) zza.w();
    }

    static /* synthetic */ void J(N n, String str) {
        str.getClass();
        n.zzd |= 1;
        n.zze = str;
    }

    static /* synthetic */ void K(N n, String str) {
        str.getClass();
        n.zzd |= 2;
        n.zzf = str;
    }

    static /* synthetic */ void L(N n) {
        n.zzd &= -3;
        n.zzf = zza.zzf;
    }

    static /* synthetic */ void M(N n, long j) {
        n.zzd |= 4;
        n.zzg = j;
    }

    static /* synthetic */ void N(N n) {
        n.zzd &= -5;
        n.zzg = 0L;
    }

    static /* synthetic */ void O(N n, double d) {
        n.zzd |= 16;
        n.zzi = d;
    }

    static /* synthetic */ void P(N n) {
        n.zzd &= -17;
        n.zzi = 0.0d;
    }

    static /* synthetic */ void Q(N n, N n2) {
        n2.getClass();
        n.Z();
        n.zzj.add(n2);
    }

    static /* synthetic */ void R(N n, Iterable iterable) {
        n.Z();
        AbstractC2137o0.f(iterable, n.zzj);
    }

    private final void Z() {
        InterfaceC20943sr8 interfaceC20943sr8 = this.zzj;
        if (interfaceC20943sr8.e()) {
            return;
        }
        this.zzj = P0.n(interfaceC20943sr8);
    }

    public final double A() {
        return this.zzi;
    }

    public final float B() {
        return this.zzh;
    }

    public final int C() {
        return this.zzj.size();
    }

    public final long D() {
        return this.zzg;
    }

    public final String G() {
        return this.zze;
    }

    public final String H() {
        return this.zzf;
    }

    public final List I() {
        return this.zzj;
    }

    public final boolean U() {
        return (this.zzd & 16) != 0;
    }

    public final boolean V() {
        return (this.zzd & 8) != 0;
    }

    public final boolean W() {
        return (this.zzd & 4) != 0;
    }

    public final boolean X() {
        return (this.zzd & 1) != 0;
    }

    public final boolean Y() {
        return (this.zzd & 2) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", N.class});
        }
        if (i2 == 3) {
            return new N();
        }
        A a = null;
        if (i2 == 4) {
            return new M(a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
