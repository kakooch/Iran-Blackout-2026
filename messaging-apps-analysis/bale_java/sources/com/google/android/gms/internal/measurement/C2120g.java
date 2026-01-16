package com.google.android.gms.internal.measurement;

import ir.nasim.Rr8;

/* renamed from: com.google.android.gms.internal.measurement.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2120g extends P0 implements Rr8 {
    private static final C2120g zza;
    private int zzd;
    private C2136o zze;
    private C2126j zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        C2120g c2120g = new C2120g();
        zza = c2120g;
        P0.s(C2120g.class, c2120g);
    }

    private C2120g() {
    }

    public static C2120g B() {
        return zza;
    }

    static /* synthetic */ void F(C2120g c2120g, String str) {
        c2120g.zzd |= 8;
        c2120g.zzh = str;
    }

    public final C2126j C() {
        C2126j c2126j = this.zzf;
        return c2126j == null ? C2126j.B() : c2126j;
    }

    public final C2136o D() {
        C2136o c2136o = this.zze;
        return c2136o == null ? C2136o.C() : c2136o;
    }

    public final String E() {
        return this.zzh;
    }

    public final boolean G() {
        return this.zzg;
    }

    public final boolean H() {
        return (this.zzd & 4) != 0;
    }

    public final boolean I() {
        return (this.zzd & 2) != 0;
    }

    public final boolean J() {
        return (this.zzd & 8) != 0;
    }

    public final boolean K() {
        return (this.zzd & 1) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new C2120g();
        }
        AbstractC2102a abstractC2102a = null;
        if (i2 == 4) {
            return new C2117f(abstractC2102a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
