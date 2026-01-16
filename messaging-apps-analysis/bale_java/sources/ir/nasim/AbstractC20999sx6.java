package ir.nasim;

import ir.nasim.AbstractC11911dl3;
import java.util.ArrayList;

/* renamed from: ir.nasim.sx6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC20999sx6 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("nm", "hd", "it");

    static C20409rx6 a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        ArrayList arrayList = new ArrayList();
        String strT0 = null;
        boolean zE = false;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(a);
            if (iL == 0) {
                strT0 = abstractC11911dl3.T0();
            } else if (iL == 1) {
                zE = abstractC11911dl3.e();
            } else if (iL != 2) {
                abstractC11911dl3.R();
            } else {
                abstractC11911dl3.b();
                while (abstractC11911dl3.d()) {
                    InterfaceC9904al1 interfaceC9904al1A = AbstractC10524bl1.a(abstractC11911dl3, c23677xK3);
                    if (interfaceC9904al1A != null) {
                        arrayList.add(interfaceC9904al1A);
                    }
                }
                abstractC11911dl3.c();
            }
        }
        return new C20409rx6(strT0, arrayList, zE);
    }
}
