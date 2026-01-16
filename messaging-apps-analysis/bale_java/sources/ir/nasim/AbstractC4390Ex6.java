package ir.nasim;

import ir.nasim.AbstractC11911dl3;
import ir.nasim.C4156Dx6;

/* renamed from: ir.nasim.Ex6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC4390Ex6 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("s", "e", "o", "nm", "m", "hd");

    static C4156Dx6 a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        String strT0 = null;
        C4156Dx6.a aVarJ = null;
        C17380ms c17380msF = null;
        C17380ms c17380msF2 = null;
        C17380ms c17380msF3 = null;
        boolean zE = false;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(a);
            if (iL == 0) {
                c17380msF = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, false);
            } else if (iL == 1) {
                c17380msF2 = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, false);
            } else if (iL == 2) {
                c17380msF3 = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, false);
            } else if (iL == 3) {
                strT0 = abstractC11911dl3.T0();
            } else if (iL == 4) {
                aVarJ = C4156Dx6.a.j(abstractC11911dl3.r0());
            } else if (iL != 5) {
                abstractC11911dl3.R();
            } else {
                zE = abstractC11911dl3.e();
            }
        }
        return new C4156Dx6(strT0, aVarJ, c17380msF, c17380msF2, c17380msF3, zE);
    }
}
