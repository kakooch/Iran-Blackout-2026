package com.google.android.gms.internal.measurement;

import ir.nasim.Rr8;

/* loaded from: classes3.dex */
public final class L extends P0 implements Rr8 {
    private static final L zza;
    private int zzd;
    private String zze = "";
    private long zzf;

    static {
        L l = new L();
        zza = l;
        P0.s(L.class, l);
    }

    private L() {
    }

    public static K A() {
        return (K) zza.w();
    }

    static /* synthetic */ void C(L l, String str) {
        str.getClass();
        l.zzd |= 1;
        l.zze = str;
    }

    static /* synthetic */ void D(L l, long j) {
        l.zzd |= 2;
        l.zzf = j;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new L();
        }
        A a = null;
        if (i2 == 4) {
            return new K(a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
