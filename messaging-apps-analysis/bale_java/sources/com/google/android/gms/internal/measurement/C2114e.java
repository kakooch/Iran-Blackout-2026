package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Rr8;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2114e extends P0 implements Rr8 {
    private static final C2114e zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private InterfaceC20943sr8 zzg = P0.m();
    private boolean zzh;
    private C2126j zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        C2114e c2114e = new C2114e();
        zza = c2114e;
        P0.s(C2114e.class, c2114e);
    }

    private C2114e() {
    }

    public static C2111d C() {
        return (C2111d) zza.w();
    }

    static /* synthetic */ void I(C2114e c2114e, String str) {
        c2114e.zzd |= 2;
        c2114e.zzf = str;
    }

    static /* synthetic */ void J(C2114e c2114e, int i, C2120g c2120g) {
        c2120g.getClass();
        InterfaceC20943sr8 interfaceC20943sr8 = c2114e.zzg;
        if (!interfaceC20943sr8.e()) {
            c2114e.zzg = P0.n(interfaceC20943sr8);
        }
        c2114e.zzg.set(i, c2120g);
    }

    public final int A() {
        return this.zzg.size();
    }

    public final int B() {
        return this.zze;
    }

    public final C2120g E(int i) {
        return (C2120g) this.zzg.get(i);
    }

    public final C2126j F() {
        C2126j c2126j = this.zzi;
        return c2126j == null ? C2126j.B() : c2126j;
    }

    public final String G() {
        return this.zzf;
    }

    public final List H() {
        return this.zzg;
    }

    public final boolean K() {
        return this.zzj;
    }

    public final boolean L() {
        return this.zzk;
    }

    public final boolean M() {
        return this.zzl;
    }

    public final boolean N() {
        return (this.zzd & 8) != 0;
    }

    public final boolean O() {
        return (this.zzd & 1) != 0;
    }

    public final boolean P() {
        return (this.zzd & 64) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", C2120g.class, "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new C2114e();
        }
        AbstractC2102a abstractC2102a = null;
        if (i2 == 4) {
            return new C2111d(abstractC2102a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
