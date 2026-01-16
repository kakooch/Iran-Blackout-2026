package ir.nasim;

import ir.nasim.AbstractC11911dl3;
import ir.nasim.C16104ki5;

/* renamed from: ir.nasim.li5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC16695li5 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd", "d");

    static C16104ki5 a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3, int i) {
        boolean zE = false;
        boolean z = i == 3;
        String strT0 = null;
        C16104ki5.a aVarJ = null;
        C17380ms c17380msF = null;
        InterfaceC4104Ds interfaceC4104DsB = null;
        C17380ms c17380msF2 = null;
        C17380ms c17380msE = null;
        C17380ms c17380msE2 = null;
        C17380ms c17380msF3 = null;
        C17380ms c17380msF4 = null;
        while (abstractC11911dl3.d()) {
            switch (abstractC11911dl3.l(a)) {
                case 0:
                    strT0 = abstractC11911dl3.T0();
                    break;
                case 1:
                    aVarJ = C16104ki5.a.j(abstractC11911dl3.r0());
                    break;
                case 2:
                    c17380msF = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, false);
                    break;
                case 3:
                    interfaceC4104DsB = AbstractC20353rs.b(abstractC11911dl3, c23677xK3);
                    break;
                case 4:
                    c17380msF2 = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, false);
                    break;
                case 5:
                    c17380msE2 = AbstractC4338Es.e(abstractC11911dl3, c23677xK3);
                    break;
                case 6:
                    c17380msF4 = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, false);
                    break;
                case 7:
                    c17380msE = AbstractC4338Es.e(abstractC11911dl3, c23677xK3);
                    break;
                case 8:
                    c17380msF3 = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, false);
                    break;
                case 9:
                    zE = abstractC11911dl3.e();
                    break;
                case 10:
                    if (abstractC11911dl3.r0() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                default:
                    abstractC11911dl3.m();
                    abstractC11911dl3.R();
                    break;
            }
        }
        return new C16104ki5(strT0, aVarJ, c17380msF, interfaceC4104DsB, c17380msF2, c17380msE, c17380msE2, c17380msF3, c17380msF4, zE, z);
    }
}
