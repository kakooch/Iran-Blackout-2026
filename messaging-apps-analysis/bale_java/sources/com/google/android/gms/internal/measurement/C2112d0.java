package com.google.android.gms.internal.measurement;

import ir.nasim.Rr8;

/* renamed from: com.google.android.gms.internal.measurement.d0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2112d0 extends P0 implements Rr8 {
    private static final C2112d0 zza;
    private int zzd;
    private long zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private float zzi;
    private double zzj;

    static {
        C2112d0 c2112d0 = new C2112d0();
        zza = c2112d0;
        P0.s(C2112d0.class, c2112d0);
    }

    private C2112d0() {
    }

    public static C2109c0 D() {
        return (C2109c0) zza.w();
    }

    static /* synthetic */ void H(C2112d0 c2112d0, long j) {
        c2112d0.zzd |= 1;
        c2112d0.zze = j;
    }

    static /* synthetic */ void I(C2112d0 c2112d0, String str) {
        str.getClass();
        c2112d0.zzd |= 2;
        c2112d0.zzf = str;
    }

    static /* synthetic */ void J(C2112d0 c2112d0, String str) {
        str.getClass();
        c2112d0.zzd |= 4;
        c2112d0.zzg = str;
    }

    static /* synthetic */ void K(C2112d0 c2112d0) {
        c2112d0.zzd &= -5;
        c2112d0.zzg = zza.zzg;
    }

    static /* synthetic */ void L(C2112d0 c2112d0, long j) {
        c2112d0.zzd |= 8;
        c2112d0.zzh = j;
    }

    static /* synthetic */ void M(C2112d0 c2112d0) {
        c2112d0.zzd &= -9;
        c2112d0.zzh = 0L;
    }

    static /* synthetic */ void N(C2112d0 c2112d0, double d) {
        c2112d0.zzd |= 32;
        c2112d0.zzj = d;
    }

    static /* synthetic */ void O(C2112d0 c2112d0) {
        c2112d0.zzd &= -33;
        c2112d0.zzj = 0.0d;
    }

    public final double A() {
        return this.zzj;
    }

    public final long B() {
        return this.zzh;
    }

    public final long C() {
        return this.zze;
    }

    public final String F() {
        return this.zzf;
    }

    public final String G() {
        return this.zzg;
    }

    public final boolean P() {
        return (this.zzd & 32) != 0;
    }

    public final boolean Q() {
        return (this.zzd & 8) != 0;
    }

    public final boolean R() {
        return (this.zzd & 1) != 0;
    }

    public final boolean T() {
        return (this.zzd & 4) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new C2112d0();
        }
        A a = null;
        if (i2 == 4) {
            return new C2109c0(a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
