package com.google.android.gms.internal.measurement;

import ir.nasim.Rr8;

/* loaded from: classes3.dex */
public final class H extends P0 implements Rr8 {
    private static final H zza;
    private int zzd;
    private int zze;
    private long zzf;

    static {
        H h = new H();
        zza = h;
        P0.s(H.class, h);
    }

    private H() {
    }

    public static G C() {
        return (G) zza.w();
    }

    static /* synthetic */ void E(H h, int i) {
        h.zzd |= 1;
        h.zze = i;
    }

    static /* synthetic */ void F(H h, long j) {
        h.zzd |= 2;
        h.zzf = j;
    }

    public final int A() {
        return this.zze;
    }

    public final long B() {
        return this.zzf;
    }

    public final boolean G() {
        return (this.zzd & 2) != 0;
    }

    public final boolean H() {
        return (this.zzd & 1) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new H();
        }
        A a = null;
        if (i2 == 4) {
            return new G(a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
