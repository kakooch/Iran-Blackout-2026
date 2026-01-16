package ir.nasim;

import ir.nasim.AbstractC11911dl3;
import ir.nasim.C3449Ax6;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: ir.nasim.fK2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC12877fK2 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");
    private static final AbstractC11911dl3.a b = AbstractC11911dl3.a.a("p", "k");
    private static final AbstractC11911dl3.a c = AbstractC11911dl3.a.a("n", "v");

    static C11625dK2 a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        String str;
        C17971ns c17971ns;
        ArrayList arrayList = new ArrayList();
        float fF1 = 0.0f;
        String strT0 = null;
        EnumC13495gK2 enumC13495gK2 = null;
        C17971ns c17971nsG = null;
        C20944ss c20944ssI = null;
        C20944ss c20944ssI2 = null;
        C17380ms c17380msE = null;
        C3449Ax6.a aVar = null;
        C3449Ax6.b bVar = null;
        C17380ms c17380ms = null;
        boolean zE = false;
        C18562os c18562os = null;
        while (abstractC11911dl3.d()) {
            switch (abstractC11911dl3.l(a)) {
                case 0:
                    strT0 = abstractC11911dl3.T0();
                    continue;
                case 1:
                    str = strT0;
                    abstractC11911dl3.B();
                    int iR0 = -1;
                    while (abstractC11911dl3.d()) {
                        int iL = abstractC11911dl3.l(b);
                        if (iL != 0) {
                            c17971ns = c17971nsG;
                            if (iL != 1) {
                                abstractC11911dl3.m();
                                abstractC11911dl3.R();
                            } else {
                                c17971nsG = AbstractC4338Es.g(abstractC11911dl3, c23677xK3, iR0);
                            }
                        } else {
                            c17971ns = c17971nsG;
                            iR0 = abstractC11911dl3.r0();
                        }
                        c17971nsG = c17971ns;
                    }
                    abstractC11911dl3.F();
                    break;
                case 2:
                    c18562os = AbstractC4338Es.h(abstractC11911dl3, c23677xK3);
                    continue;
                case 3:
                    str = strT0;
                    enumC13495gK2 = abstractC11911dl3.r0() == 1 ? EnumC13495gK2.LINEAR : EnumC13495gK2.RADIAL;
                    break;
                case 4:
                    c20944ssI = AbstractC4338Es.i(abstractC11911dl3, c23677xK3);
                    continue;
                case 5:
                    c20944ssI2 = AbstractC4338Es.i(abstractC11911dl3, c23677xK3);
                    continue;
                case 6:
                    c17380msE = AbstractC4338Es.e(abstractC11911dl3, c23677xK3);
                    continue;
                case 7:
                    str = strT0;
                    aVar = C3449Ax6.a.values()[abstractC11911dl3.r0() - 1];
                    break;
                case 8:
                    str = strT0;
                    bVar = C3449Ax6.b.values()[abstractC11911dl3.r0() - 1];
                    break;
                case 9:
                    str = strT0;
                    fF1 = (float) abstractC11911dl3.f1();
                    break;
                case 10:
                    zE = abstractC11911dl3.e();
                    continue;
                case 11:
                    abstractC11911dl3.b();
                    while (abstractC11911dl3.d()) {
                        abstractC11911dl3.B();
                        String strT02 = null;
                        C17380ms c17380msE2 = null;
                        while (abstractC11911dl3.d()) {
                            int iL2 = abstractC11911dl3.l(c);
                            if (iL2 != 0) {
                                C17380ms c17380ms2 = c17380ms;
                                if (iL2 != 1) {
                                    abstractC11911dl3.m();
                                    abstractC11911dl3.R();
                                } else {
                                    c17380msE2 = AbstractC4338Es.e(abstractC11911dl3, c23677xK3);
                                }
                                c17380ms = c17380ms2;
                            } else {
                                strT02 = abstractC11911dl3.T0();
                            }
                        }
                        C17380ms c17380ms3 = c17380ms;
                        abstractC11911dl3.F();
                        if (strT02.equals("o")) {
                            c17380ms = c17380msE2;
                        } else {
                            if (strT02.equals("d") || strT02.equals("g")) {
                                c23677xK3.v(true);
                                arrayList.add(c17380msE2);
                            }
                            c17380ms = c17380ms3;
                        }
                    }
                    C17380ms c17380ms4 = c17380ms;
                    abstractC11911dl3.c();
                    if (arrayList.size() == 1) {
                        arrayList.add((C17380ms) arrayList.get(0));
                    }
                    c17380ms = c17380ms4;
                    continue;
                    break;
                default:
                    abstractC11911dl3.m();
                    abstractC11911dl3.R();
                    continue;
            }
            strT0 = str;
        }
        String str2 = strT0;
        if (c18562os == null) {
            c18562os = new C18562os(Collections.singletonList(new C24561yp3(100)));
        }
        return new C11625dK2(str2, enumC13495gK2, c17971nsG, c18562os, c20944ssI, c20944ssI2, c17380msE, aVar, bVar, fF1, arrayList, c17380ms, zE);
    }
}
