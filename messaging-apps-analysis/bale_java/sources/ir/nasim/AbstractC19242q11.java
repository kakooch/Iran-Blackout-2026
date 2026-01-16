package ir.nasim;

/* renamed from: ir.nasim.q11, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC19242q11 {
    private static final Object a = new Object();

    public static final int a(int i, int i2) {
        return i << (((i2 % 10) * 3) + 1);
    }

    public static final InterfaceC18060o11 b(InterfaceC22053ub1 interfaceC22053ub1, int i, boolean z, Object obj) {
        C18651p11 c18651p11;
        interfaceC22053ub1.F(Integer.rotateLeft(i, 1), a);
        Object objB = interfaceC22053ub1.B();
        if (objB == InterfaceC22053ub1.a.a()) {
            c18651p11 = new C18651p11(i, z, obj);
            interfaceC22053ub1.s(c18651p11);
        } else {
            AbstractC13042fc3.g(objB, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaImpl");
            c18651p11 = (C18651p11) objB;
            c18651p11.n(obj);
        }
        interfaceC22053ub1.T();
        return c18651p11;
    }

    public static final InterfaceC18060o11 c(int i, boolean z, Object obj) {
        return new C18651p11(i, z, obj);
    }

    public static final int d(int i) {
        return a(2, i);
    }

    public static final InterfaceC18060o11 e(int i, boolean z, Object obj, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1573003438, i2, -1, "androidx.compose.runtime.internal.rememberComposableLambda (ComposableLambda.kt:1366)");
        }
        Object objB = interfaceC22053ub1.B();
        if (objB == InterfaceC22053ub1.a.a()) {
            objB = new C18651p11(i, z, obj);
            interfaceC22053ub1.s(objB);
        }
        C18651p11 c18651p11 = (C18651p11) objB;
        c18651p11.n(obj);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c18651p11;
    }

    public static final boolean f(OJ5 oj5, OJ5 oj52) {
        if (oj5 != null) {
            if ((oj5 instanceof PJ5) && (oj52 instanceof PJ5)) {
                PJ5 pj5 = (PJ5) oj5;
                if (!pj5.u() || AbstractC13042fc3.d(oj5, oj52) || AbstractC13042fc3.d(pj5.i(), ((PJ5) oj52).i())) {
                }
            }
            return false;
        }
        return true;
    }

    public static final int g(int i) {
        return a(1, i);
    }
}
