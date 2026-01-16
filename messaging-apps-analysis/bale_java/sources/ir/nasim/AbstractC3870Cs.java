package ir.nasim;

import android.graphics.PointF;
import ir.nasim.AbstractC11911dl3;

/* renamed from: ir.nasim.Cs, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC3870Cs {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");
    private static final AbstractC11911dl3.a b = AbstractC11911dl3.a.a("k");

    private static boolean a(C19744qs c19744qs) {
        return c19744qs == null || (c19744qs.i() && ((PointF) ((C24561yp3) c19744qs.k().get(0)).b).equals(0.0f, 0.0f));
    }

    private static boolean b(InterfaceC4104Ds interfaceC4104Ds) {
        return interfaceC4104Ds == null || (!(interfaceC4104Ds instanceof C22811vs) && interfaceC4104Ds.i() && ((PointF) ((C24561yp3) interfaceC4104Ds.k().get(0)).b).equals(0.0f, 0.0f));
    }

    private static boolean c(C17380ms c17380ms) {
        return c17380ms == null || (c17380ms.i() && ((Float) ((C24561yp3) c17380ms.k().get(0)).b).floatValue() == 0.0f);
    }

    private static boolean d(C21631ts c21631ts) {
        return c21631ts == null || (c21631ts.i() && ((C19591qc6) ((C24561yp3) c21631ts.k().get(0)).b).a(1.0f, 1.0f));
    }

    private static boolean e(C17380ms c17380ms) {
        return c17380ms == null || (c17380ms.i() && ((Float) ((C24561yp3) c17380ms.k().get(0)).b).floatValue() == 0.0f);
    }

    private static boolean f(C17380ms c17380ms) {
        return c17380ms == null || (c17380ms.i() && ((Float) ((C24561yp3) c17380ms.k().get(0)).b).floatValue() == 0.0f);
    }

    public static C3636Bs g(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        boolean z;
        boolean z2 = false;
        boolean z3 = abstractC11911dl3.j() == AbstractC11911dl3.b.BEGIN_OBJECT;
        if (z3) {
            abstractC11911dl3.B();
        }
        C17380ms c17380ms = null;
        C19744qs c19744qsA = null;
        InterfaceC4104Ds interfaceC4104DsB = null;
        C21631ts c21631tsJ = null;
        C17380ms c17380msF = null;
        C17380ms c17380msF2 = null;
        C18562os c18562osH = null;
        C17380ms c17380msF3 = null;
        C17380ms c17380msF4 = null;
        while (abstractC11911dl3.d()) {
            switch (abstractC11911dl3.l(a)) {
                case 0:
                    boolean z4 = z2;
                    abstractC11911dl3.B();
                    while (abstractC11911dl3.d()) {
                        if (abstractC11911dl3.l(b) != 0) {
                            abstractC11911dl3.m();
                            abstractC11911dl3.R();
                        } else {
                            c19744qsA = AbstractC20353rs.a(abstractC11911dl3, c23677xK3);
                        }
                    }
                    abstractC11911dl3.F();
                    z2 = z4;
                    continue;
                case 1:
                    interfaceC4104DsB = AbstractC20353rs.b(abstractC11911dl3, c23677xK3);
                    continue;
                case 2:
                    c21631tsJ = AbstractC4338Es.j(abstractC11911dl3, c23677xK3);
                    continue;
                case 3:
                    c23677xK3.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    c18562osH = AbstractC4338Es.h(abstractC11911dl3, c23677xK3);
                    continue;
                case 6:
                    c17380msF3 = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, z2);
                    continue;
                case 7:
                    c17380msF4 = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, z2);
                    continue;
                case 8:
                    c17380msF = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, z2);
                    continue;
                case 9:
                    c17380msF2 = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, z2);
                    continue;
                default:
                    abstractC11911dl3.m();
                    abstractC11911dl3.R();
                    continue;
            }
            C17380ms c17380msF5 = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, z2);
            if (c17380msF5.k().isEmpty()) {
                c17380msF5.k().add(new C24561yp3(c23677xK3, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(c23677xK3.f())));
            } else {
                if (((C24561yp3) c17380msF5.k().get(0)).b == null) {
                    z = false;
                    c17380msF5.k().set(0, new C24561yp3(c23677xK3, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(c23677xK3.f())));
                }
                z2 = z;
                c17380ms = c17380msF5;
            }
            z = false;
            z2 = z;
            c17380ms = c17380msF5;
        }
        if (z3) {
            abstractC11911dl3.F();
        }
        C19744qs c19744qs = a(c19744qsA) ? null : c19744qsA;
        InterfaceC4104Ds interfaceC4104Ds = b(interfaceC4104DsB) ? null : interfaceC4104DsB;
        C17380ms c17380ms2 = c(c17380ms) ? null : c17380ms;
        if (d(c21631tsJ)) {
            c21631tsJ = null;
        }
        return new C3636Bs(c19744qs, interfaceC4104Ds, c21631tsJ, c17380ms2, c18562osH, c17380msF3, c17380msF4, f(c17380msF) ? null : c17380msF, e(c17380msF2) ? null : c17380msF2);
    }
}
