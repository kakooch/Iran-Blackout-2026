package ir.nasim;

/* renamed from: ir.nasim.iV3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC14797iV3 {
    private static final float a(long j, long j2, long j3) {
        float f = 0.2f;
        float f2 = 0.4f;
        float f3 = 0.4f;
        for (int i = 0; i < 7; i++) {
            float fC = (c(j, f2, j2, j3) / 4.5f) - 1.0f;
            if (0.0f <= fC && fC <= 0.01f) {
                break;
            }
            if (fC < 0.0f) {
                f3 = f2;
            } else {
                f = f2;
            }
            f2 = (f3 + f) / 2.0f;
        }
        return f2;
    }

    public static final float b(long j, long j2) {
        float fJ = DX0.j(j) + 0.05f;
        float fJ2 = DX0.j(j2) + 0.05f;
        return Math.max(fJ, fJ2) / Math.min(fJ, fJ2);
    }

    private static final float c(long j, float f, long j2, long j3) {
        long jH = DX0.h(C24381yX0.o(j, f, 0.0f, 0.0f, 0.0f, 14, null), j3);
        return b(DX0.h(j2, jH), jH);
    }

    public static final long d(long j, long j2, long j3) {
        return C24381yX0.o(j, c(j, 0.4f, j2, j3) >= 4.5f ? 0.4f : c(j, 0.2f, j2, j3) < 4.5f ? 0.2f : a(j, j2, j3), 0.0f, 0.0f, 0.0f, 14, null);
    }

    public static final C6426Nn7 e(UY0 uy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-721696685, i, -1, "androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)");
        }
        long j = uy0.j();
        long jC = uy0.c();
        interfaceC22053ub1.W(1102762852);
        long jA = VY0.a(uy0, jC);
        if (jA == 16) {
            jA = ((C24381yX0) interfaceC22053ub1.H(AbstractC20866sk1.a())).y();
        }
        long j2 = jA;
        interfaceC22053ub1.Q();
        long jO = C24381yX0.o(j2, C16120kk1.a.d(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null);
        boolean zF = interfaceC22053ub1.f(j) | interfaceC22053ub1.f(jC) | interfaceC22053ub1.f(jO);
        Object objB = interfaceC22053ub1.B();
        if (zF || objB == InterfaceC22053ub1.a.a()) {
            objB = new C6426Nn7(uy0.j(), d(j, jO, jC), null);
            interfaceC22053ub1.s(objB);
        }
        C6426Nn7 c6426Nn7 = (C6426Nn7) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c6426Nn7;
    }
}
