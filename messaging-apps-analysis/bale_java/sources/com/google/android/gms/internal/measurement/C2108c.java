package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Rr8;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2108c extends P0 implements Rr8 {
    private static final C2108c zza;
    private int zzd;
    private int zze;
    private InterfaceC20943sr8 zzf = P0.m();
    private InterfaceC20943sr8 zzg = P0.m();
    private boolean zzh;
    private boolean zzi;

    static {
        C2108c c2108c = new C2108c();
        zza = c2108c;
        P0.s(C2108c.class, c2108c);
    }

    private C2108c() {
    }

    static /* synthetic */ void I(C2108c c2108c, int i, C2130l c2130l) {
        c2130l.getClass();
        InterfaceC20943sr8 interfaceC20943sr8 = c2108c.zzf;
        if (!interfaceC20943sr8.e()) {
            c2108c.zzf = P0.n(interfaceC20943sr8);
        }
        c2108c.zzf.set(i, c2130l);
    }

    static /* synthetic */ void J(C2108c c2108c, int i, C2114e c2114e) {
        c2114e.getClass();
        InterfaceC20943sr8 interfaceC20943sr8 = c2108c.zzg;
        if (!interfaceC20943sr8.e()) {
            c2108c.zzg = P0.n(interfaceC20943sr8);
        }
        c2108c.zzg.set(i, c2114e);
    }

    public final int A() {
        return this.zze;
    }

    public final int B() {
        return this.zzg.size();
    }

    public final int C() {
        return this.zzf.size();
    }

    public final C2114e E(int i) {
        return (C2114e) this.zzg.get(i);
    }

    public final C2130l F(int i) {
        return (C2130l) this.zzf.get(i);
    }

    public final List G() {
        return this.zzg;
    }

    public final List H() {
        return this.zzf;
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
            return P0.p(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzd", "zze", "zzf", C2130l.class, "zzg", C2114e.class, "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new C2108c();
        }
        AbstractC2102a abstractC2102a = null;
        if (i2 == 4) {
            return new C2105b(abstractC2102a);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
