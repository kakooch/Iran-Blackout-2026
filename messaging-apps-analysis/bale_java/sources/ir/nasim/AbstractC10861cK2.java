package ir.nasim;

import android.graphics.Path;
import ir.nasim.AbstractC11911dl3;
import java.util.Collections;

/* renamed from: ir.nasim.cK2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC10861cK2 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("nm", "g", "o", "t", "s", "e", "r", "hd");
    private static final AbstractC11911dl3.a b = AbstractC11911dl3.a.a("p", "k");

    static C9651aK2 a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        C18562os c18562osH = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strT0 = null;
        EnumC13495gK2 enumC13495gK2 = null;
        C17971ns c17971nsG = null;
        C20944ss c20944ssI = null;
        C20944ss c20944ssI2 = null;
        boolean zE = false;
        while (abstractC11911dl3.d()) {
            switch (abstractC11911dl3.l(a)) {
                case 0:
                    strT0 = abstractC11911dl3.T0();
                    break;
                case 1:
                    abstractC11911dl3.B();
                    int iR0 = -1;
                    while (abstractC11911dl3.d()) {
                        int iL = abstractC11911dl3.l(b);
                        if (iL == 0) {
                            iR0 = abstractC11911dl3.r0();
                        } else if (iL != 1) {
                            abstractC11911dl3.m();
                            abstractC11911dl3.R();
                        } else {
                            c17971nsG = AbstractC4338Es.g(abstractC11911dl3, c23677xK3, iR0);
                        }
                    }
                    abstractC11911dl3.F();
                    break;
                case 2:
                    c18562osH = AbstractC4338Es.h(abstractC11911dl3, c23677xK3);
                    break;
                case 3:
                    enumC13495gK2 = abstractC11911dl3.r0() == 1 ? EnumC13495gK2.LINEAR : EnumC13495gK2.RADIAL;
                    break;
                case 4:
                    c20944ssI = AbstractC4338Es.i(abstractC11911dl3, c23677xK3);
                    break;
                case 5:
                    c20944ssI2 = AbstractC4338Es.i(abstractC11911dl3, c23677xK3);
                    break;
                case 6:
                    fillType = abstractC11911dl3.r0() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    zE = abstractC11911dl3.e();
                    break;
                default:
                    abstractC11911dl3.m();
                    abstractC11911dl3.R();
                    break;
            }
        }
        return new C9651aK2(strT0, enumC13495gK2, fillType, c17971nsG, c18562osH == null ? new C18562os(Collections.singletonList(new C24561yp3(100))) : c18562osH, c20944ssI, c20944ssI2, null, null, zE);
    }
}
