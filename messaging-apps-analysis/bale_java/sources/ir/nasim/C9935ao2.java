package ir.nasim;

import ir.nasim.C24381yX0;

/* renamed from: ir.nasim.ao2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C9935ao2 {
    public static final C9935ao2 a = new C9935ao2();
    private static final float b;
    private static final float c;
    public static final int d = 0;

    static {
        C10555bo2 c10555bo2 = C10555bo2.a;
        b = c10555bo2.a();
        c = c10555bo2.t();
    }

    private C9935ao2() {
    }

    public final C10493bi0 a(boolean z, boolean z2, long j, long j2, long j3, long j4, float f, float f2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        long jO;
        long jF = (i2 & 4) != 0 ? ZX0.f(C10555bo2.a.r(), interfaceC22053ub1, 6) : j;
        long jH = (i2 & 8) != 0 ? C24381yX0.b.h() : j2;
        if ((i2 & 16) != 0) {
            C10555bo2 c10555bo2 = C10555bo2.a;
            jO = C24381yX0.o(ZX0.f(c10555bo2.k(), interfaceC22053ub1, 6), c10555bo2.l(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jO = j3;
        }
        long jH2 = (i2 & 32) != 0 ? C24381yX0.b.h() : j4;
        float fS = (i2 & 64) != 0 ? C10555bo2.a.s() : f;
        float fP = (i2 & 128) != 0 ? C10555bo2.a.p() : f2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1138342447, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipBorder (Chip.kt:1415)");
        }
        if (!z) {
            jF = z2 ? jH2 : jO;
        } else if (z2) {
            jF = jH;
        }
        if (z2) {
            fS = fP;
        }
        C10493bi0 c10493bi0A = AbstractC11256ci0.a(fS, jF);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c10493bi0A;
    }

    public final C3350Am6 b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1743772077, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1273)");
        }
        C3350Am6 c3350Am6D = d(C15386jV3.a.a(interfaceC22053ub1, 6));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c3350Am6D;
    }

    public final C3589Bm6 c(float f, float f2, float f3, float f4, float f5, float f6, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 1) != 0) {
            f = C10555bo2.a.h();
        }
        if ((i2 & 2) != 0) {
            f2 = C10555bo2.a.q();
        }
        float f7 = f2;
        if ((i2 & 4) != 0) {
            f3 = C10555bo2.a.n();
        }
        float f8 = f3;
        if ((i2 & 8) != 0) {
            f4 = C10555bo2.a.o();
        }
        float f9 = f4;
        if ((i2 & 16) != 0) {
            f5 = C10555bo2.a.g();
        }
        float f10 = f5;
        float f11 = (i2 & 32) != 0 ? f : f6;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-757972185, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipElevation (Chip.kt:1378)");
        }
        C3589Bm6 c3589Bm6 = new C3589Bm6(f, f7, f8, f9, f10, f11, null);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c3589Bm6;
    }

    public final C3350Am6 d(XX0 xx0) {
        C3350Am6 c3350Am6E = xx0.e();
        if (c3350Am6E != null) {
            return c3350Am6E;
        }
        C24381yX0.a aVar = C24381yX0.b;
        long jH = aVar.h();
        C10555bo2 c10555bo2 = C10555bo2.a;
        C3350Am6 c3350Am6 = new C3350Am6(jH, ZX0.d(xx0, c10555bo2.x()), ZX0.d(xx0, c10555bo2.y()), ZX0.d(xx0, c10555bo2.y()), aVar.h(), C24381yX0.o(ZX0.d(xx0, c10555bo2.c()), c10555bo2.d(), 0.0f, 0.0f, 0.0f, 14, null), C24381yX0.o(ZX0.d(xx0, c10555bo2.e()), c10555bo2.f(), 0.0f, 0.0f, 0.0f, 14, null), C24381yX0.o(ZX0.d(xx0, c10555bo2.e()), c10555bo2.f(), 0.0f, 0.0f, 0.0f, 14, null), ZX0.d(xx0, c10555bo2.m()), C24381yX0.o(ZX0.d(xx0, c10555bo2.i()), c10555bo2.j(), 0.0f, 0.0f, 0.0f, 14, null), ZX0.d(xx0, c10555bo2.v()), ZX0.d(xx0, c10555bo2.w()), ZX0.d(xx0, c10555bo2.w()), null);
        xx0.W(c3350Am6);
        return c3350Am6;
    }

    public final float e() {
        return b;
    }

    public final InterfaceC10031ax6 f(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1598643637, i, -1, "androidx.compose.material3.FilterChipDefaults.<get-shape> (Chip.kt:1547)");
        }
        InterfaceC10031ax6 interfaceC10031ax6D = AbstractC5809Kx6.d(C10555bo2.a.b(), interfaceC22053ub1, 6);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC10031ax6D;
    }
}
