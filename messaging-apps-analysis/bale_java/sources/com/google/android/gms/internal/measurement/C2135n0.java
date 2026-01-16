package com.google.android.gms.internal.measurement;

import ir.nasim.Fo8;
import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Rr8;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.n0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2135n0 extends P0 implements Rr8 {
    private static final C2135n0 zza;
    private int zzd;
    private int zze;
    private InterfaceC20943sr8 zzf = P0.m();
    private String zzg = "";
    private String zzh = "";
    private boolean zzi;
    private double zzj;

    static {
        C2135n0 c2135n0 = new C2135n0();
        zza = c2135n0;
        P0.s(C2135n0.class, c2135n0);
    }

    private C2135n0() {
    }

    public final double A() {
        return this.zzj;
    }

    public final String C() {
        return this.zzg;
    }

    public final String D() {
        return this.zzh;
    }

    public final List E() {
        return this.zzf;
    }

    public final boolean F() {
        return this.zzi;
    }

    public final boolean G() {
        return (this.zzd & 8) != 0;
    }

    public final boolean H() {
        return (this.zzd & 16) != 0;
    }

    public final boolean I() {
        return (this.zzd & 4) != 0;
    }

    public final int J() {
        int iA = Fo8.a(this.zze);
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
            return P0.p(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zzd", "zze", C2133m0.a, "zzf", C2135n0.class, "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new C2135n0();
        }
        AbstractC2115e0 abstractC2115e0 = null;
        if (i2 == 4) {
            return new C2131l0(abstractC2115e0);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
