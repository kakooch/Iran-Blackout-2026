package com.google.android.gms.internal.measurement;

import ir.nasim.AbstractC17339mn8;
import ir.nasim.Rr8;

/* renamed from: com.google.android.gms.internal.measurement.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2126j extends P0 implements Rr8 {
    private static final C2126j zza;
    private int zzd;
    private int zze;
    private boolean zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        C2126j c2126j = new C2126j();
        zza = c2126j;
        P0.s(C2126j.class, c2126j);
    }

    private C2126j() {
    }

    public static C2126j B() {
        return zza;
    }

    public final String C() {
        return this.zzg;
    }

    public final String D() {
        return this.zzi;
    }

    public final String E() {
        return this.zzh;
    }

    public final boolean F() {
        return this.zzf;
    }

    public final boolean G() {
        return (this.zzd & 1) != 0;
    }

    public final boolean H() {
        return (this.zzd & 4) != 0;
    }

    public final boolean I() {
        return (this.zzd & 2) != 0;
    }

    public final boolean J() {
        return (this.zzd & 16) != 0;
    }

    public final boolean K() {
        return (this.zzd & 8) != 0;
    }

    public final int L() {
        int iA = AbstractC17339mn8.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzd", "zze", C2124i.a, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new C2126j();
        }
        AbstractC2102a abstractC2102a = null;
        if (i2 == 4) {
            return new C2122h(abstractC2102a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
