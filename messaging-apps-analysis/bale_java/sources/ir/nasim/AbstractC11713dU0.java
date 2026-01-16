package ir.nasim;

import ir.nasim.AbstractC11911dl3;

/* renamed from: ir.nasim.dU0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC11713dU0 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("nm", "p", "s", "hd", "d");

    static C10949cU0 a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3, int i) {
        boolean z = i == 3;
        boolean zE = false;
        String strT0 = null;
        InterfaceC4104Ds interfaceC4104DsB = null;
        C20944ss c20944ssI = null;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(a);
            if (iL == 0) {
                strT0 = abstractC11911dl3.T0();
            } else if (iL == 1) {
                interfaceC4104DsB = AbstractC20353rs.b(abstractC11911dl3, c23677xK3);
            } else if (iL == 2) {
                c20944ssI = AbstractC4338Es.i(abstractC11911dl3, c23677xK3);
            } else if (iL == 3) {
                zE = abstractC11911dl3.e();
            } else if (iL != 4) {
                abstractC11911dl3.m();
                abstractC11911dl3.R();
            } else {
                z = abstractC11911dl3.r0() == 3;
            }
        }
        return new C10949cU0(strT0, interfaceC4104DsB, c20944ssI, z, zE);
    }
}
