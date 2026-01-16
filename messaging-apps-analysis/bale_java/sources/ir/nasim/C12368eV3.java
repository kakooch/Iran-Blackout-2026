package ir.nasim;

/* renamed from: ir.nasim.eV3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C12368eV3 {
    public static final C12368eV3 a = new C12368eV3();
    private static final float b = C17784nZ1.q(16);

    private C12368eV3() {
    }

    public final C11725dV3 a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2, int i3) {
        long j17;
        long jH;
        interfaceC22053ub1.W(2090954698);
        long jG = (i3 & 1) != 0 ? G10.a.a(interfaceC22053ub1, 6).G() : j;
        long jI = (i3 & 2) != 0 ? G10.a.a(interfaceC22053ub1, 6).I() : j2;
        long jH2 = (i3 & 4) != 0 ? C24381yX0.b.h() : j3;
        long jW = (i3 & 8) != 0 ? G10.a.a(interfaceC22053ub1, 6).w() : j4;
        long jW2 = (i3 & 16) != 0 ? G10.a.a(interfaceC22053ub1, 6).w() : j5;
        long jW3 = (i3 & 32) != 0 ? G10.a.a(interfaceC22053ub1, 6).w() : j6;
        long jW4 = (i3 & 64) != 0 ? G10.a.a(interfaceC22053ub1, 6).w() : j7;
        long jW5 = (i3 & 128) != 0 ? G10.a.a(interfaceC22053ub1, 6).w() : j8;
        if ((i3 & 256) != 0) {
            G10 g10 = G10.a;
            j17 = jW;
            jH = DX0.h(C24381yX0.o(g10.a(interfaceC22053ub1, 6).M(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), g10.a(interfaceC22053ub1, 6).M());
        } else {
            j17 = jW;
            jH = j9;
        }
        C11725dV3 c11725dV3 = new C11725dV3(jG, jI, jH2, j17, jW2, jW3, jW4, jW5, jH, (i3 & 512) != 0 ? DX0.h(C24381yX0.o(G10.a.a(interfaceC22053ub1, 6).w(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), C15386jV3.a.a(interfaceC22053ub1, C15386jV3.b).H()) : j10, (i3 & 1024) != 0 ? C24381yX0.b.h() : j11, (i3 & 2048) != 0 ? DX0.h(C24381yX0.o(G10.a.a(interfaceC22053ub1, 6).w(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), C15386jV3.a.a(interfaceC22053ub1, C15386jV3.b).H()) : j12, (i3 & 4096) != 0 ? DX0.h(C24381yX0.o(G10.a.a(interfaceC22053ub1, 6).w(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), C15386jV3.a.a(interfaceC22053ub1, C15386jV3.b).H()) : j13, (i3 & 8192) != 0 ? DX0.h(C24381yX0.o(G10.a.a(interfaceC22053ub1, 6).w(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), C15386jV3.a.a(interfaceC22053ub1, C15386jV3.b).H()) : j14, (i3 & 16384) != 0 ? DX0.h(C24381yX0.o(G10.a.a(interfaceC22053ub1, 6).w(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), C15386jV3.a.a(interfaceC22053ub1, C15386jV3.b).H()) : j15, (i3 & 32768) != 0 ? DX0.h(C24381yX0.o(G10.a.a(interfaceC22053ub1, 6).w(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), C15386jV3.a.a(interfaceC22053ub1, C15386jV3.b).H()) : j16, null);
        interfaceC22053ub1.Q();
        return c11725dV3;
    }
}
