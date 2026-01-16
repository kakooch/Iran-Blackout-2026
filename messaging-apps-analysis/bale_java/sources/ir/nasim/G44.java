package ir.nasim;

import ir.nasim.AbstractC11911dl3;
import ir.nasim.E44;

/* loaded from: classes2.dex */
abstract class G44 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("nm", "mm", "hd");

    static E44 a(AbstractC11911dl3 abstractC11911dl3) {
        String strT0 = null;
        boolean zE = false;
        E44.a aVarJ = null;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(a);
            if (iL == 0) {
                strT0 = abstractC11911dl3.T0();
            } else if (iL == 1) {
                aVarJ = E44.a.j(abstractC11911dl3.r0());
            } else if (iL != 2) {
                abstractC11911dl3.m();
                abstractC11911dl3.R();
            } else {
                zE = abstractC11911dl3.e();
            }
        }
        return new E44(strT0, aVarJ, zE);
    }
}
