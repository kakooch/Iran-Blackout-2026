package ir.nasim;

import ir.nasim.AbstractC11911dl3;
import java.util.Collections;

/* renamed from: ir.nasim.ys, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC24587ys {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("s", "a");
    private static final AbstractC11911dl3.a b = AbstractC11911dl3.a.a("s", "e", "o", "r");
    private static final AbstractC11911dl3.a c = AbstractC11911dl3.a.a("fc", "sc", "sw", "t", "o");

    public static C23997xs a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        abstractC11911dl3.B();
        C3397As c3397AsC = null;
        C25181zs c25181zsB = null;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(a);
            if (iL == 0) {
                c25181zsB = b(abstractC11911dl3, c23677xK3);
            } else if (iL != 1) {
                abstractC11911dl3.m();
                abstractC11911dl3.R();
            } else {
                c3397AsC = c(abstractC11911dl3, c23677xK3);
            }
        }
        abstractC11911dl3.F();
        return new C23997xs(c3397AsC, c25181zsB);
    }

    private static C25181zs b(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        abstractC11911dl3.B();
        C18562os c18562os = null;
        C18562os c18562osH = null;
        C18562os c18562osH2 = null;
        EnumC5720Kn7 enumC5720Kn7 = null;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(b);
            if (iL == 0) {
                c18562os = AbstractC4338Es.h(abstractC11911dl3, c23677xK3);
            } else if (iL == 1) {
                c18562osH = AbstractC4338Es.h(abstractC11911dl3, c23677xK3);
            } else if (iL == 2) {
                c18562osH2 = AbstractC4338Es.h(abstractC11911dl3, c23677xK3);
            } else if (iL != 3) {
                abstractC11911dl3.m();
                abstractC11911dl3.R();
            } else {
                int iR0 = abstractC11911dl3.r0();
                if (iR0 == 1 || iR0 == 2) {
                    enumC5720Kn7 = iR0 == 1 ? EnumC5720Kn7.PERCENT : EnumC5720Kn7.INDEX;
                } else {
                    c23677xK3.a("Unsupported text range units: " + iR0);
                    enumC5720Kn7 = EnumC5720Kn7.INDEX;
                }
            }
        }
        abstractC11911dl3.F();
        if (c18562os == null && c18562osH != null) {
            c18562os = new C18562os(Collections.singletonList(new C24561yp3(0)));
        }
        return new C25181zs(c18562os, c18562osH, c18562osH2, enumC5720Kn7);
    }

    private static C3397As c(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        abstractC11911dl3.B();
        C16789ls c16789lsC = null;
        C16789ls c16789lsC2 = null;
        C17380ms c17380msE = null;
        C17380ms c17380msE2 = null;
        C18562os c18562osH = null;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(c);
            if (iL == 0) {
                c16789lsC = AbstractC4338Es.c(abstractC11911dl3, c23677xK3);
            } else if (iL == 1) {
                c16789lsC2 = AbstractC4338Es.c(abstractC11911dl3, c23677xK3);
            } else if (iL == 2) {
                c17380msE = AbstractC4338Es.e(abstractC11911dl3, c23677xK3);
            } else if (iL == 3) {
                c17380msE2 = AbstractC4338Es.e(abstractC11911dl3, c23677xK3);
            } else if (iL != 4) {
                abstractC11911dl3.m();
                abstractC11911dl3.R();
            } else {
                c18562osH = AbstractC4338Es.h(abstractC11911dl3, c23677xK3);
            }
        }
        abstractC11911dl3.F();
        return new C3397As(c16789lsC, c16789lsC2, c17380msE, c17380msE2, c18562osH);
    }
}
