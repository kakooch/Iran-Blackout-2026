package ir.nasim;

import ir.nasim.AbstractC11911dl3;
import java.util.ArrayList;

/* renamed from: ir.nasim.Zt2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC9397Zt2 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("ch", "size", "w", "style", "fFamily", "data");
    private static final AbstractC11911dl3.a b = AbstractC11911dl3.a.a("shapes");

    static C9163Yt2 a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        ArrayList arrayList = new ArrayList();
        abstractC11911dl3.B();
        double dF1 = 0.0d;
        String strT0 = null;
        String strT02 = null;
        char cCharAt = 0;
        double dF12 = 0.0d;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(a);
            if (iL == 0) {
                cCharAt = abstractC11911dl3.T0().charAt(0);
            } else if (iL == 1) {
                dF12 = abstractC11911dl3.f1();
            } else if (iL == 2) {
                dF1 = abstractC11911dl3.f1();
            } else if (iL == 3) {
                strT0 = abstractC11911dl3.T0();
            } else if (iL == 4) {
                strT02 = abstractC11911dl3.T0();
            } else if (iL != 5) {
                abstractC11911dl3.m();
                abstractC11911dl3.R();
            } else {
                abstractC11911dl3.B();
                while (abstractC11911dl3.d()) {
                    if (abstractC11911dl3.l(b) != 0) {
                        abstractC11911dl3.m();
                        abstractC11911dl3.R();
                    } else {
                        abstractC11911dl3.b();
                        while (abstractC11911dl3.d()) {
                            arrayList.add((C20409rx6) AbstractC10524bl1.a(abstractC11911dl3, c23677xK3));
                        }
                        abstractC11911dl3.c();
                    }
                }
                abstractC11911dl3.F();
            }
        }
        abstractC11911dl3.F();
        return new C9163Yt2(arrayList, cCharAt, dF12, dF1, strT0, strT02);
    }
}
