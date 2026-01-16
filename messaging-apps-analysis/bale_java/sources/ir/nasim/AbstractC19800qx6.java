package ir.nasim;

import android.graphics.Path;
import ir.nasim.AbstractC11911dl3;
import java.util.Collections;

/* renamed from: ir.nasim.qx6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC19800qx6 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("nm", "c", "o", "fillEnabled", "r", "hd");

    static C19209px6 a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        C18562os c18562os = null;
        String strT0 = null;
        C16789ls c16789lsC = null;
        boolean zE = false;
        boolean zE2 = false;
        int iR0 = 1;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(a);
            if (iL == 0) {
                strT0 = abstractC11911dl3.T0();
            } else if (iL == 1) {
                c16789lsC = AbstractC4338Es.c(abstractC11911dl3, c23677xK3);
            } else if (iL == 2) {
                c18562os = AbstractC4338Es.h(abstractC11911dl3, c23677xK3);
            } else if (iL == 3) {
                zE = abstractC11911dl3.e();
            } else if (iL == 4) {
                iR0 = abstractC11911dl3.r0();
            } else if (iL != 5) {
                abstractC11911dl3.m();
                abstractC11911dl3.R();
            } else {
                zE2 = abstractC11911dl3.e();
            }
        }
        if (c18562os == null) {
            c18562os = new C18562os(Collections.singletonList(new C24561yp3(100)));
        }
        return new C19209px6(strT0, zE, iR0 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, c16789lsC, c18562os, zE2);
    }
}
