package ir.nasim;

import ir.nasim.AbstractC11911dl3;

/* renamed from: ir.nasim.nu2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC17994nu2 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("fFamily", "fName", "fStyle", "ascent");

    static C8388Vt2 a(AbstractC11911dl3 abstractC11911dl3) {
        abstractC11911dl3.B();
        String strT0 = null;
        String strT02 = null;
        float fF1 = 0.0f;
        String strT03 = null;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(a);
            if (iL == 0) {
                strT0 = abstractC11911dl3.T0();
            } else if (iL == 1) {
                strT03 = abstractC11911dl3.T0();
            } else if (iL == 2) {
                strT02 = abstractC11911dl3.T0();
            } else if (iL != 3) {
                abstractC11911dl3.m();
                abstractC11911dl3.R();
            } else {
                fF1 = (float) abstractC11911dl3.f1();
            }
        }
        abstractC11911dl3.F();
        return new C8388Vt2(strT0, strT03, strT02, fF1);
    }
}
