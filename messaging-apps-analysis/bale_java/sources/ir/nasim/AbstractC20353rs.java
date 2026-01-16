package ir.nasim;

import ir.nasim.AbstractC11911dl3;
import java.util.ArrayList;

/* renamed from: ir.nasim.rs, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC20353rs {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("k", "x", "y");

    public static C19744qs a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        ArrayList arrayList = new ArrayList();
        if (abstractC11911dl3.j() == AbstractC11911dl3.b.BEGIN_ARRAY) {
            abstractC11911dl3.b();
            while (abstractC11911dl3.d()) {
                arrayList.add(AbstractC17473n15.a(abstractC11911dl3, c23677xK3));
            }
            abstractC11911dl3.c();
            AbstractC3847Cp3.b(arrayList);
        } else {
            arrayList.add(new C24561yp3(AbstractC20878sl3.e(abstractC11911dl3, AbstractC16500lN7.e())));
        }
        return new C19744qs(arrayList);
    }

    static InterfaceC4104Ds b(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        abstractC11911dl3.B();
        C19744qs c19744qsA = null;
        C17380ms c17380msE = null;
        boolean z = false;
        C17380ms c17380msE2 = null;
        while (abstractC11911dl3.j() != AbstractC11911dl3.b.END_OBJECT) {
            int iL = abstractC11911dl3.l(a);
            if (iL == 0) {
                c19744qsA = a(abstractC11911dl3, c23677xK3);
            } else if (iL != 1) {
                if (iL != 2) {
                    abstractC11911dl3.m();
                    abstractC11911dl3.R();
                } else if (abstractC11911dl3.j() == AbstractC11911dl3.b.STRING) {
                    abstractC11911dl3.R();
                    z = true;
                } else {
                    c17380msE = AbstractC4338Es.e(abstractC11911dl3, c23677xK3);
                }
            } else if (abstractC11911dl3.j() == AbstractC11911dl3.b.STRING) {
                abstractC11911dl3.R();
                z = true;
            } else {
                c17380msE2 = AbstractC4338Es.e(abstractC11911dl3, c23677xK3);
            }
        }
        abstractC11911dl3.F();
        if (z) {
            c23677xK3.a("Lottie doesn't support expressions.");
        }
        return c19744qsA != null ? c19744qsA : new C22811vs(c17380msE2, c17380msE);
    }
}
