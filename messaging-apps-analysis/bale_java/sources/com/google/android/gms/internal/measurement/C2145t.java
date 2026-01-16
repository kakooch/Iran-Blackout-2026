package com.google.android.gms.internal.measurement;

import ir.nasim.Rr8;

/* renamed from: com.google.android.gms.internal.measurement.t, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2145t extends P0 implements Rr8 {
    private static final C2145t zza;
    private int zzd;
    private String zze = "";
    private boolean zzf;
    private boolean zzg;
    private int zzh;

    static {
        C2145t c2145t = new C2145t();
        zza = c2145t;
        P0.s(C2145t.class, c2145t);
    }

    private C2145t() {
    }

    static /* synthetic */ void D(C2145t c2145t, String str) {
        str.getClass();
        c2145t.zzd |= 1;
        c2145t.zze = str;
    }

    public final int A() {
        return this.zzh;
    }

    public final String C() {
        return this.zze;
    }

    public final boolean E() {
        return this.zzf;
    }

    public final boolean F() {
        return this.zzg;
    }

    public final boolean G() {
        return (this.zzd & 2) != 0;
    }

    public final boolean H() {
        return (this.zzd & 4) != 0;
    }

    public final boolean I() {
        return (this.zzd & 8) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new C2145t();
        }
        AbstractC2138p abstractC2138p = null;
        if (i2 == 4) {
            return new C2143s(abstractC2138p);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
