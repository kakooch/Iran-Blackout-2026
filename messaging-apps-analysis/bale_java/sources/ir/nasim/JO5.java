package ir.nasim;

import ir.nasim.AbstractC11911dl3;

/* loaded from: classes2.dex */
abstract class JO5 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("nm", "c", "o", "tr", "hd");

    static HO5 a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        String strT0 = null;
        C17380ms c17380msF = null;
        C17380ms c17380msF2 = null;
        C3636Bs c3636BsG = null;
        boolean zE = false;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(a);
            if (iL == 0) {
                strT0 = abstractC11911dl3.T0();
            } else if (iL == 1) {
                c17380msF = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, false);
            } else if (iL == 2) {
                c17380msF2 = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, false);
            } else if (iL == 3) {
                c3636BsG = AbstractC3870Cs.g(abstractC11911dl3, c23677xK3);
            } else if (iL != 4) {
                abstractC11911dl3.R();
            } else {
                zE = abstractC11911dl3.e();
            }
        }
        return new HO5(strT0, c17380msF, c17380msF2, c3636BsG, zE);
    }
}
