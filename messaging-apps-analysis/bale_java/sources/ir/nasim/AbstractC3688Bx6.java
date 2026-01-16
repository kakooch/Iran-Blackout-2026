package ir.nasim;

import ir.nasim.AbstractC11911dl3;
import ir.nasim.C3449Ax6;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: ir.nasim.Bx6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC3688Bx6 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d");
    private static final AbstractC11911dl3.a b = AbstractC11911dl3.a.a("n", "v");

    static C3449Ax6 a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        C17380ms c17380msE;
        ArrayList arrayList = new ArrayList();
        float fF1 = 0.0f;
        boolean zE = false;
        String strT0 = null;
        C17380ms c17380ms = null;
        C16789ls c16789lsC = null;
        C17380ms c17380msE2 = null;
        C18562os c18562os = null;
        C3449Ax6.a aVar = null;
        C3449Ax6.b bVar = null;
        while (abstractC11911dl3.d()) {
            switch (abstractC11911dl3.l(a)) {
                case 0:
                    strT0 = abstractC11911dl3.T0();
                    break;
                case 1:
                    c16789lsC = AbstractC4338Es.c(abstractC11911dl3, c23677xK3);
                    break;
                case 2:
                    c17380msE2 = AbstractC4338Es.e(abstractC11911dl3, c23677xK3);
                    break;
                case 3:
                    c18562os = AbstractC4338Es.h(abstractC11911dl3, c23677xK3);
                    break;
                case 4:
                    aVar = C3449Ax6.a.values()[abstractC11911dl3.r0() - 1];
                    break;
                case 5:
                    bVar = C3449Ax6.b.values()[abstractC11911dl3.r0() - 1];
                    break;
                case 6:
                    fF1 = (float) abstractC11911dl3.f1();
                    break;
                case 7:
                    zE = abstractC11911dl3.e();
                    break;
                case 8:
                    abstractC11911dl3.b();
                    while (abstractC11911dl3.d()) {
                        abstractC11911dl3.B();
                        String strT02 = null;
                        c17380msE = null;
                        while (abstractC11911dl3.d()) {
                            int iL = abstractC11911dl3.l(b);
                            if (iL == 0) {
                                strT02 = abstractC11911dl3.T0();
                            } else if (iL != 1) {
                                abstractC11911dl3.m();
                                abstractC11911dl3.R();
                            } else {
                                c17380msE = AbstractC4338Es.e(abstractC11911dl3, c23677xK3);
                            }
                        }
                        abstractC11911dl3.F();
                        strT02.hashCode();
                        switch (strT02) {
                            case "d":
                            case "g":
                                c23677xK3.v(true);
                                arrayList.add(c17380msE);
                                break;
                            case "o":
                                c17380ms = c17380msE;
                                break;
                        }
                    }
                    abstractC11911dl3.c();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add((C17380ms) arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    abstractC11911dl3.R();
                    break;
            }
        }
        if (c18562os == null) {
            c18562os = new C18562os(Collections.singletonList(new C24561yp3(100)));
        }
        if (aVar == null) {
            aVar = C3449Ax6.a.BUTT;
        }
        if (bVar == null) {
            bVar = C3449Ax6.b.MITER;
        }
        return new C3449Ax6(strT0, c17380ms, arrayList, c16789lsC, c18562os, c17380msE2, aVar, bVar, fF1, zE);
    }
}
