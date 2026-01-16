package com.google.android.gms.internal.measurement;

import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import ir.nasim.InterfaceC19152pr8;
import ir.nasim.InterfaceC20943sr8;
import ir.nasim.Rr8;
import java.util.List;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes3.dex */
public final class U extends P0 implements Rr8 {
    public static final /* synthetic */ int zza = 0;
    private static final U zzd;
    private long zzB;
    private int zzC;
    private boolean zzF;
    private int zzI;
    private int zzJ;
    private int zzK;
    private long zzM;
    private long zzN;
    private int zzQ;
    private X zzS;
    private long zzU;
    private long zzV;
    private int zzY;
    private boolean zzZ;
    private boolean zzab;
    private P zzac;
    private int zze;
    private int zzf;
    private int zzg;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private int zzs;
    private long zzw;
    private long zzx;
    private boolean zzz;
    private InterfaceC20943sr8 zzh = P0.m();
    private InterfaceC20943sr8 zzi = P0.m();
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";
    private String zzt = "";
    private String zzu = "";
    private String zzv = "";
    private String zzy = "";
    private String zzA = "";
    private String zzD = "";
    private String zzE = "";
    private InterfaceC20943sr8 zzG = P0.m();
    private String zzH = "";
    private String zzL = "";
    private String zzO = "";
    private String zzP = "";
    private String zzR = "";
    private InterfaceC19152pr8 zzT = P0.j();
    private String zzW = "";
    private String zzX = "";
    private String zzaa = "";
    private String zzad = "";
    private InterfaceC20943sr8 zzae = P0.m();
    private String zzaf = "";

    static {
        U u = new U();
        zzd = u;
        P0.s(U.class, u);
    }

    private U() {
    }

    static /* synthetic */ void D0(U u, String str) {
        str.getClass();
        u.zzf |= 8192;
        u.zzad = str;
    }

    static /* synthetic */ void E0(U u) {
        u.zzf &= -8193;
        u.zzad = zzd.zzad;
    }

    static /* synthetic */ void F0(U u, Iterable iterable) {
        InterfaceC20943sr8 interfaceC20943sr8 = u.zzae;
        if (!interfaceC20943sr8.e()) {
            u.zzae = P0.n(interfaceC20943sr8);
        }
        AbstractC2137o0.f(iterable, u.zzae);
    }

    static /* synthetic */ void H0(U u, String str) {
        str.getClass();
        u.zzf |= 16384;
        u.zzaf = str;
    }

    static /* synthetic */ void I0(U u, int i) {
        u.f1();
        u.zzh.remove(i);
    }

    static /* synthetic */ void J0(U u, int i, C2112d0 c2112d0) {
        c2112d0.getClass();
        u.g1();
        u.zzi.set(i, c2112d0);
    }

    static /* synthetic */ void K0(U u, C2112d0 c2112d0) {
        c2112d0.getClass();
        u.g1();
        u.zzi.add(c2112d0);
    }

    static /* synthetic */ void L0(U u, Iterable iterable) {
        u.g1();
        AbstractC2137o0.f(iterable, u.zzi);
    }

    static /* synthetic */ void M0(U u, int i) {
        u.g1();
        u.zzi.remove(i);
    }

    static /* synthetic */ void O0(U u, long j) {
        u.zze |= 2;
        u.zzj = j;
    }

    public static T O1() {
        return (T) zzd.w();
    }

    static /* synthetic */ void P(U u) {
        u.zze &= Integer.MAX_VALUE;
        u.zzO = zzd.zzO;
    }

    static /* synthetic */ void P0(U u, long j) {
        u.zze |= 4;
        u.zzk = j;
    }

    static /* synthetic */ void Q(U u, int i) {
        u.zzf |= 2;
        u.zzQ = i;
    }

    static /* synthetic */ void Q0(U u, long j) {
        u.zze |= 8;
        u.zzl = j;
    }

    static /* synthetic */ void R(U u, int i, J j) {
        j.getClass();
        u.f1();
        u.zzh.set(i, j);
    }

    static /* synthetic */ void R0(U u, long j) {
        u.zze |= 16;
        u.zzm = j;
    }

    static /* synthetic */ void S0(U u) {
        u.zze &= -17;
        u.zzm = 0L;
    }

    static /* synthetic */ void T(U u, String str) {
        str.getClass();
        u.zzf |= 4;
        u.zzR = str;
    }

    static /* synthetic */ void T0(U u, long j) {
        u.zze |= 32;
        u.zzn = j;
    }

    static /* synthetic */ void U(U u, X x) {
        x.getClass();
        u.zzS = x;
        u.zzf |= 8;
    }

    static /* synthetic */ void U0(U u) {
        u.zze &= -33;
        u.zzn = 0L;
    }

    static /* synthetic */ void V(U u, Iterable iterable) {
        InterfaceC19152pr8 interfaceC19152pr8 = u.zzT;
        if (!interfaceC19152pr8.e()) {
            int size = interfaceC19152pr8.size();
            u.zzT = interfaceC19152pr8.K(size == 0 ? 10 : size + size);
        }
        AbstractC2137o0.f(iterable, u.zzT);
    }

    static /* synthetic */ void V0(U u, String str) {
        u.zze |= 64;
        u.zzo = ConstantDeviceInfo.APP_PLATFORM;
    }

    static /* synthetic */ void W(U u, J j) {
        j.getClass();
        u.f1();
        u.zzh.add(j);
    }

    static /* synthetic */ void W0(U u, String str) {
        str.getClass();
        u.zze |= 128;
        u.zzp = str;
    }

    static /* synthetic */ void X(U u, long j) {
        u.zzf |= 16;
        u.zzU = j;
    }

    static /* synthetic */ void X0(U u) {
        u.zze &= -129;
        u.zzp = zzd.zzp;
    }

    static /* synthetic */ void Y(U u, long j) {
        u.zzf |= 32;
        u.zzV = j;
    }

    static /* synthetic */ void Y0(U u, String str) {
        str.getClass();
        u.zze |= 256;
        u.zzq = str;
    }

    static /* synthetic */ void Z(U u, String str) {
        u.zzf |= 128;
        u.zzX = str;
    }

    static /* synthetic */ void Z0(U u) {
        u.zze &= -257;
        u.zzq = zzd.zzq;
    }

    static /* synthetic */ void a0(U u, Iterable iterable) {
        u.f1();
        AbstractC2137o0.f(iterable, u.zzh);
    }

    static /* synthetic */ void a1(U u, String str) {
        str.getClass();
        u.zze |= 512;
        u.zzr = str;
    }

    static /* synthetic */ void b1(U u, int i) {
        u.zze |= 1024;
        u.zzs = i;
    }

    static /* synthetic */ void c0(U u, String str) {
        str.getClass();
        u.zze |= 8192;
        u.zzv = str;
    }

    static /* synthetic */ void c1(U u, String str) {
        str.getClass();
        u.zze |= 2048;
        u.zzt = str;
    }

    static /* synthetic */ void d0(U u, long j) {
        u.zze |= 16384;
        u.zzw = j;
    }

    static /* synthetic */ void d1(U u, String str) {
        str.getClass();
        u.zze |= 4096;
        u.zzu = str;
    }

    static /* synthetic */ void e0(U u, long j) {
        u.zze |= 32768;
        u.zzx = 74029L;
    }

    static /* synthetic */ void f0(U u, String str) {
        str.getClass();
        u.zze |= 65536;
        u.zzy = str;
    }

    private final void f1() {
        InterfaceC20943sr8 interfaceC20943sr8 = this.zzh;
        if (interfaceC20943sr8.e()) {
            return;
        }
        this.zzh = P0.n(interfaceC20943sr8);
    }

    static /* synthetic */ void g0(U u) {
        u.zze &= -65537;
        u.zzy = zzd.zzy;
    }

    private final void g1() {
        InterfaceC20943sr8 interfaceC20943sr8 = this.zzi;
        if (interfaceC20943sr8.e()) {
            return;
        }
        this.zzi = P0.n(interfaceC20943sr8);
    }

    static /* synthetic */ void h0(U u, boolean z) {
        u.zze |= 131072;
        u.zzz = z;
    }

    static /* synthetic */ void i0(U u) {
        u.zze &= -131073;
        u.zzz = false;
    }

    static /* synthetic */ void j0(U u, String str) {
        str.getClass();
        u.zze |= 262144;
        u.zzA = str;
    }

    static /* synthetic */ void k0(U u) {
        u.zze &= -262145;
        u.zzA = zzd.zzA;
    }

    static /* synthetic */ void l0(U u, long j) {
        u.zze |= 524288;
        u.zzB = j;
    }

    static /* synthetic */ void m0(U u, int i) {
        u.zze |= 1048576;
        u.zzC = i;
    }

    static /* synthetic */ void n0(U u, String str) {
        u.zze |= 2097152;
        u.zzD = str;
    }

    static /* synthetic */ void o0(U u) {
        u.zze &= -2097153;
        u.zzD = zzd.zzD;
    }

    static /* synthetic */ void p0(U u, String str) {
        str.getClass();
        u.zze |= 4194304;
        u.zzE = str;
    }

    static /* synthetic */ void q0(U u, boolean z) {
        u.zze |= 8388608;
        u.zzF = z;
    }

    static /* synthetic */ void r0(U u, Iterable iterable) {
        InterfaceC20943sr8 interfaceC20943sr8 = u.zzG;
        if (!interfaceC20943sr8.e()) {
            u.zzG = P0.n(interfaceC20943sr8);
        }
        AbstractC2137o0.f(iterable, u.zzG);
    }

    static /* synthetic */ void t0(U u, String str) {
        str.getClass();
        u.zze |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        u.zzH = str;
    }

    static /* synthetic */ void u0(U u, int i) {
        u.zze |= 33554432;
        u.zzI = i;
    }

    static /* synthetic */ void v0(U u, int i) {
        u.zze |= 1;
        u.zzg = 1;
    }

    static /* synthetic */ void w0(U u) {
        u.zze &= -268435457;
        u.zzL = zzd.zzL;
    }

    static /* synthetic */ void y0(U u, long j) {
        u.zze |= 536870912;
        u.zzM = j;
    }

    public final String A() {
        return this.zzv;
    }

    public final boolean A0() {
        return this.zzF;
    }

    public final int A1() {
        return this.zzQ;
    }

    public final String B() {
        return this.zzX;
    }

    public final boolean B0() {
        return (this.zze & 33554432) != 0;
    }

    public final int B1() {
        return this.zzs;
    }

    public final String C() {
        return this.zzq;
    }

    public final boolean C0() {
        return (this.zze & 1048576) != 0;
    }

    public final int C1() {
        return this.zzi.size();
    }

    public final String D() {
        return this.zzO;
    }

    public final long D1() {
        return this.zzM;
    }

    public final String E() {
        return this.zzH;
    }

    public final long E1() {
        return this.zzB;
    }

    public final String F() {
        return this.zzE;
    }

    public final long F1() {
        return this.zzU;
    }

    public final String G() {
        return this.zzD;
    }

    public final long G1() {
        return this.zzl;
    }

    public final String H() {
        return this.zzp;
    }

    public final long H1() {
        return this.zzw;
    }

    public final String I() {
        return this.zzo;
    }

    public final long I1() {
        return this.zzn;
    }

    public final String J() {
        return this.zzy;
    }

    public final long J1() {
        return this.zzm;
    }

    public final String K() {
        return this.zzad;
    }

    public final long K1() {
        return this.zzk;
    }

    public final String L() {
        return this.zzr;
    }

    public final long L1() {
        return this.zzj;
    }

    public final List M() {
        return this.zzG;
    }

    public final long M1() {
        return this.zzx;
    }

    public final List N() {
        return this.zzh;
    }

    public final J N1(int i) {
        return (J) this.zzh.get(i);
    }

    public final List O() {
        return this.zzi;
    }

    public final C2112d0 Q1(int i) {
        return (C2112d0) this.zzi.get(i);
    }

    public final String R1() {
        return this.zzR;
    }

    public final String S1() {
        return this.zzu;
    }

    public final String T1() {
        return this.zzA;
    }

    public final String U1() {
        return this.zzt;
    }

    public final int b0() {
        return this.zzI;
    }

    public final int e1() {
        return this.zzC;
    }

    public final boolean h1() {
        return (this.zze & 536870912) != 0;
    }

    public final boolean i1() {
        return (this.zzf & 128) != 0;
    }

    public final boolean j1() {
        return (this.zze & 524288) != 0;
    }

    public final boolean k1() {
        return (this.zzf & 16) != 0;
    }

    public final boolean l1() {
        return (this.zze & 8) != 0;
    }

    public final boolean m1() {
        return (this.zze & 16384) != 0;
    }

    public final boolean n1() {
        return (this.zze & 131072) != 0;
    }

    public final boolean o1() {
        return (this.zze & 32) != 0;
    }

    public final boolean p1() {
        return (this.zze & 16) != 0;
    }

    public final boolean q1() {
        return (this.zze & 1) != 0;
    }

    public final boolean r1() {
        return (this.zzf & 2) != 0;
    }

    public final boolean s1() {
        return (this.zze & 8388608) != 0;
    }

    public final boolean t1() {
        return (this.zzf & 8192) != 0;
    }

    public final boolean u1() {
        return (this.zze & 4) != 0;
    }

    public final boolean v1() {
        return (this.zze & 1024) != 0;
    }

    public final boolean w1() {
        return (this.zze & 2) != 0;
    }

    public final boolean x1() {
        return (this.zze & 32768) != 0;
    }

    public final int y1() {
        return this.zzh.size();
    }

    @Override // com.google.android.gms.internal.measurement.P0
    protected final Object z(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return P0.p(zzd, "\u00014\u0000\u0002\u0001A4\u0000\u0005\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5ဌ(7ဇ)9ဈ*:ဇ+;ဉ,?ဈ-@\u001aAဈ.", new Object[]{"zze", "zzf", "zzg", "zzh", J.class, "zzi", C2112d0.class, "zzj", "zzk", "zzl", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzm", "zzF", "zzG", F.class, "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", "zzY", B.a, "zzZ", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf"});
        }
        if (i2 == 3) {
            return new U();
        }
        A a = null;
        if (i2 == 4) {
            return new T(a);
        }
        if (i2 != 5) {
            return null;
        }
        return zzd;
    }

    public final boolean z0() {
        return this.zzz;
    }

    public final int z1() {
        return this.zzg;
    }
}
