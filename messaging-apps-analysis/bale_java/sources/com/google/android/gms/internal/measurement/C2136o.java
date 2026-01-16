package com.google.android.gms.internal.measurement;

import ir.nasim.AbstractC19112pn8;
import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Rr8;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2136o extends P0 implements Rr8 {
    private static final C2136o zza;
    private int zzd;
    private int zze;
    private boolean zzg;
    private String zzf = "";
    private InterfaceC20943sr8 zzh = P0.m();

    static {
        C2136o c2136o = new C2136o();
        zza = c2136o;
        P0.s(C2136o.class, c2136o);
    }

    private C2136o() {
    }

    public static C2136o C() {
        return zza;
    }

    public final int A() {
        return this.zzh.size();
    }

    public final String D() {
        return this.zzf;
    }

    public final List E() {
        return this.zzh;
    }

    public final boolean F() {
        return this.zzg;
    }

    public final boolean G() {
        return (this.zzd & 4) != 0;
    }

    public final boolean H() {
        return (this.zzd & 2) != 0;
    }

    public final boolean I() {
        return (this.zzd & 1) != 0;
    }

    public final int J() {
        int iA = AbstractC19112pn8.a(this.zze);
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
            return P0.p(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzd", "zze", C2134n.a, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new C2136o();
        }
        AbstractC2102a abstractC2102a = null;
        if (i2 == 4) {
            return new C2132m(abstractC2102a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
