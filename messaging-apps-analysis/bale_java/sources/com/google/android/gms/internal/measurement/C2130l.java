package com.google.android.gms.internal.measurement;

import ir.nasim.Rr8;

/* renamed from: com.google.android.gms.internal.measurement.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2130l extends P0 implements Rr8 {
    private static final C2130l zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private C2120g zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        C2130l c2130l = new C2130l();
        zza = c2130l;
        P0.s(C2130l.class, c2130l);
    }

    private C2130l() {
    }

    public static C2128k C() {
        return (C2128k) zza.w();
    }

    static /* synthetic */ void F(C2130l c2130l, String str) {
        c2130l.zzd |= 2;
        c2130l.zzf = str;
    }

    public final int A() {
        return this.zze;
    }

    public final C2120g B() {
        C2120g c2120g = this.zzg;
        return c2120g == null ? C2120g.B() : c2120g;
    }

    public final String E() {
        return this.zzf;
    }

    public final boolean G() {
        return this.zzh;
    }

    public final boolean H() {
        return this.zzi;
    }

    public final boolean I() {
        return this.zzj;
    }

    public final boolean J() {
        return (this.zzd & 1) != 0;
    }

    public final boolean K() {
        return (this.zzd & 32) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new C2130l();
        }
        AbstractC2102a abstractC2102a = null;
        if (i2 == 4) {
            return new C2128k(abstractC2102a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
