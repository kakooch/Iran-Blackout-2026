package ir.nasim;

import ir.nasim.AbstractC11911dl3;

/* renamed from: ir.nasim.Gh0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC4723Gh0 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("ef");
    private static final AbstractC11911dl3.a b = AbstractC11911dl3.a.a("ty", "v");

    private static C4474Fh0 a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        abstractC11911dl3.B();
        C4474Fh0 c4474Fh0 = null;
        while (true) {
            boolean z = false;
            while (abstractC11911dl3.d()) {
                int iL = abstractC11911dl3.l(b);
                if (iL != 0) {
                    if (iL != 1) {
                        abstractC11911dl3.m();
                        abstractC11911dl3.R();
                    } else if (z) {
                        c4474Fh0 = new C4474Fh0(AbstractC4338Es.e(abstractC11911dl3, c23677xK3));
                    } else {
                        abstractC11911dl3.R();
                    }
                } else if (abstractC11911dl3.r0() == 0) {
                    z = true;
                }
            }
            abstractC11911dl3.F();
            return c4474Fh0;
        }
    }

    static C4474Fh0 b(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        C4474Fh0 c4474Fh0 = null;
        while (abstractC11911dl3.d()) {
            if (abstractC11911dl3.l(a) != 0) {
                abstractC11911dl3.m();
                abstractC11911dl3.R();
            } else {
                abstractC11911dl3.b();
                while (abstractC11911dl3.d()) {
                    C4474Fh0 c4474Fh0A = a(abstractC11911dl3, c23677xK3);
                    if (c4474Fh0A != null) {
                        c4474Fh0 = c4474Fh0A;
                    }
                }
                abstractC11911dl3.c();
            }
        }
        return c4474Fh0;
    }
}
