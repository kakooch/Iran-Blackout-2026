package ir.nasim;

import ir.nasim.C24381yX0;

/* renamed from: ir.nasim.r03, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19825r03 {
    public static final C19825r03 a = new C19825r03();

    private C19825r03() {
    }

    public final C19234q03 a(XX0 xx0, long j) {
        C19234q03 c19234q03F = xx0.f();
        if (c19234q03F != null) {
            return c19234q03F;
        }
        C24381yX0.a aVar = C24381yX0.b;
        C19234q03 c19234q03 = new C19234q03(aVar.h(), j, aVar.h(), C24381yX0.o(j, 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        xx0.X(c19234q03);
        return c19234q03;
    }

    public final C19234q03 b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(-1519621781);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1519621781, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:592)");
        }
        long jY = ((C24381yX0) interfaceC22053ub1.H(AbstractC21553tk1.a())).y();
        C19234q03 c19234q03A = a(C15386jV3.a.a(interfaceC22053ub1, 6), jY);
        if (C24381yX0.q(c19234q03A.e(), jY)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return c19234q03A;
        }
        C19234q03 c19234q03C = c19234q03A.c((5 & 1) != 0 ? c19234q03A.a : 0L, (5 & 2) != 0 ? c19234q03A.b : jY, (5 & 4) != 0 ? c19234q03A.c : 0L, (5 & 8) != 0 ? c19234q03A.d : C24381yX0.o(jY, 0.38f, 0.0f, 0.0f, 0.0f, 14, null));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
        return c19234q03C;
    }
}
