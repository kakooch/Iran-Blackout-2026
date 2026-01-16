package ir.nasim;

import ir.nasim.AbstractC11911dl3;

/* renamed from: ir.nasim.zx6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC25236zx6 {
    static AbstractC11911dl3.a a = AbstractC11911dl3.a.a("nm", "ind", "ks", "hd");

    static C24642yx6 a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        String strT0 = null;
        int iR0 = 0;
        boolean zE = false;
        C22221us c22221usK = null;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(a);
            if (iL == 0) {
                strT0 = abstractC11911dl3.T0();
            } else if (iL == 1) {
                iR0 = abstractC11911dl3.r0();
            } else if (iL == 2) {
                c22221usK = AbstractC4338Es.k(abstractC11911dl3, c23677xK3);
            } else if (iL != 3) {
                abstractC11911dl3.R();
            } else {
                zE = abstractC11911dl3.e();
            }
        }
        return new C24642yx6(strT0, iR0, c22221usK, zE);
    }
}
