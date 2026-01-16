package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Rr8;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.v, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2149v extends P0 implements Rr8 {
    private static final C2149v zza;
    private int zzd;
    private long zze;
    private int zzg;
    private boolean zzl;
    private String zzf = "";
    private InterfaceC20943sr8 zzh = P0.m();
    private InterfaceC20943sr8 zzi = P0.m();
    private InterfaceC20943sr8 zzj = P0.m();
    private String zzk = "";
    private InterfaceC20943sr8 zzm = P0.m();
    private InterfaceC20943sr8 zzn = P0.m();
    private String zzo = "";

    static {
        C2149v c2149v = new C2149v();
        zza = c2149v;
        P0.s(C2149v.class, c2149v);
    }

    private C2149v() {
    }

    public static C2147u E() {
        return (C2147u) zza.w();
    }

    public static C2149v G() {
        return zza;
    }

    static /* synthetic */ void N(C2149v c2149v, int i, C2145t c2145t) {
        c2145t.getClass();
        InterfaceC20943sr8 interfaceC20943sr8 = c2149v.zzi;
        if (!interfaceC20943sr8.e()) {
            c2149v.zzi = P0.n(interfaceC20943sr8);
        }
        c2149v.zzi.set(i, c2145t);
    }

    public final int A() {
        return this.zzm.size();
    }

    public final int B() {
        return this.zzi.size();
    }

    public final long C() {
        return this.zze;
    }

    public final C2145t D(int i) {
        return (C2145t) this.zzi.get(i);
    }

    public final String H() {
        return this.zzf;
    }

    public final String I() {
        return this.zzo;
    }

    public final List J() {
        return this.zzj;
    }

    public final List K() {
        return this.zzn;
    }

    public final List L() {
        return this.zzm;
    }

    public final List M() {
        return this.zzh;
    }

    public final boolean P() {
        return this.zzl;
    }

    public final boolean Q() {
        return (this.zzd & 2) != 0;
    }

    public final boolean R() {
        return (this.zzd & 1) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zza, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", C2157z.class, "zzi", C2145t.class, "zzj", C2108c.class, "zzk", "zzl", "zzm", C2129k0.class, "zzn", r.class, "zzo"});
        }
        if (i2 == 3) {
            return new C2149v();
        }
        AbstractC2138p abstractC2138p = null;
        if (i2 == 4) {
            return new C2147u(abstractC2138p);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
