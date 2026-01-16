package ir.nasim;

import ir.nasim.AbstractC11911dl3;

/* loaded from: classes2.dex */
public abstract class S46 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("nm", "r", "hd");

    static Q46 a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        boolean zE = false;
        String strT0 = null;
        C17380ms c17380msF = null;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(a);
            if (iL == 0) {
                strT0 = abstractC11911dl3.T0();
            } else if (iL == 1) {
                c17380msF = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, true);
            } else if (iL != 2) {
                abstractC11911dl3.R();
            } else {
                zE = abstractC11911dl3.e();
            }
        }
        if (zE) {
            return null;
        }
        return new Q46(strT0, c17380msF);
    }
}
