package ir.nasim;

import ir.nasim.AbstractC11911dl3;

/* loaded from: classes2.dex */
abstract class NK5 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("nm", "p", "s", "r", "hd");

    static LK5 a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        String strT0 = null;
        InterfaceC4104Ds interfaceC4104DsB = null;
        C20944ss c20944ssI = null;
        C17380ms c17380msE = null;
        boolean zE = false;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(a);
            if (iL == 0) {
                strT0 = abstractC11911dl3.T0();
            } else if (iL == 1) {
                interfaceC4104DsB = AbstractC20353rs.b(abstractC11911dl3, c23677xK3);
            } else if (iL == 2) {
                c20944ssI = AbstractC4338Es.i(abstractC11911dl3, c23677xK3);
            } else if (iL == 3) {
                c17380msE = AbstractC4338Es.e(abstractC11911dl3, c23677xK3);
            } else if (iL != 4) {
                abstractC11911dl3.R();
            } else {
                zE = abstractC11911dl3.e();
            }
        }
        return new LK5(strT0, interfaceC4104DsB, c20944ssI, c17380msE, zE);
    }
}
