package com.google.android.gms.internal.measurement;

import ir.nasim.Rr8;

/* loaded from: classes3.dex */
public final class F extends P0 implements Rr8 {
    private static final F zza;
    private int zzd;
    private int zze;
    private Z zzf;
    private Z zzg;
    private boolean zzh;

    static {
        F f = new F();
        zza = f;
        P0.s(F.class, f);
    }

    private F() {
    }

    public static E B() {
        return (E) zza.w();
    }

    static /* synthetic */ void F(F f, int i) {
        f.zzd |= 1;
        f.zze = i;
    }

    static /* synthetic */ void G(F f, Z z) {
        z.getClass();
        f.zzf = z;
        f.zzd |= 2;
    }

    static /* synthetic */ void H(F f, Z z) {
        f.zzg = z;
        f.zzd |= 4;
    }

    static /* synthetic */ void I(F f, boolean z) {
        f.zzd |= 8;
        f.zzh = z;
    }

    public final int A() {
        return this.zze;
    }

    public final Z D() {
        Z z = this.zzf;
        return z == null ? Z.H() : z;
    }

    public final Z E() {
        Z z = this.zzg;
        return z == null ? Z.H() : z;
    }

    public final boolean J() {
        return this.zzh;
    }

    public final boolean K() {
        return (this.zzd & 1) != 0;
    }

    public final boolean L() {
        return (this.zzd & 8) != 0;
    }

    public final boolean M() {
        return (this.zzd & 4) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new F();
        }
        A a = null;
        if (i2 == 4) {
            return new E(a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
