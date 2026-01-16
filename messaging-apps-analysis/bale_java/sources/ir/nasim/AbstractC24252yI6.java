package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: ir.nasim.yI6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC24252yI6 {
    public static final C13893h0 a(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC18174oC7 abstractC18174oC7N0 = abstractC4099Dr3.N0();
        if (abstractC18174oC7N0 instanceof C13893h0) {
            return (C13893h0) abstractC18174oC7N0;
        }
        return null;
    }

    public static final XC6 b(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        C13893h0 c13893h0A = a(abstractC4099Dr3);
        if (c13893h0A == null) {
            return null;
        }
        return c13893h0A.W0();
    }

    public static final boolean c(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        return abstractC4099Dr3.N0() instanceof DG1;
    }

    private static final C7993Ub3 d(C7993Ub3 c7993Ub3) {
        AbstractC4099Dr3 abstractC4099Dr3;
        Collection collectionB = c7993Ub3.b();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collectionB, 10));
        Iterator it = collectionB.iterator();
        boolean z = false;
        while (true) {
            abstractC4099Dr3 = null;
            if (!it.hasNext()) {
                break;
            }
            AbstractC4099Dr3 abstractC4099Dr3F = (AbstractC4099Dr3) it.next();
            if (AbstractC7497Ry7.l(abstractC4099Dr3F)) {
                abstractC4099Dr3F = f(abstractC4099Dr3F.N0(), false, 1, null);
                z = true;
            }
            arrayList.add(abstractC4099Dr3F);
        }
        if (!z) {
            return null;
        }
        AbstractC4099Dr3 abstractC4099Dr3H = c7993Ub3.h();
        if (abstractC4099Dr3H != null) {
            if (AbstractC7497Ry7.l(abstractC4099Dr3H)) {
                abstractC4099Dr3H = f(abstractC4099Dr3H.N0(), false, 1, null);
            }
            abstractC4099Dr3 = abstractC4099Dr3H;
        }
        return new C7993Ub3(arrayList).k(abstractC4099Dr3);
    }

    public static final AbstractC18174oC7 e(AbstractC18174oC7 abstractC18174oC7, boolean z) {
        AbstractC13042fc3.i(abstractC18174oC7, "<this>");
        DG1 dg1B = DG1.d.b(abstractC18174oC7, z);
        if (dg1B != null) {
            return dg1B;
        }
        XC6 xc6G = g(abstractC18174oC7);
        return xc6G == null ? abstractC18174oC7.O0(false) : xc6G;
    }

    public static /* synthetic */ AbstractC18174oC7 f(AbstractC18174oC7 abstractC18174oC7, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return e(abstractC18174oC7, z);
    }

    private static final XC6 g(AbstractC4099Dr3 abstractC4099Dr3) {
        C7993Ub3 c7993Ub3D;
        InterfaceC13882gy7 interfaceC13882gy7K0 = abstractC4099Dr3.K0();
        C7993Ub3 c7993Ub3 = interfaceC13882gy7K0 instanceof C7993Ub3 ? (C7993Ub3) interfaceC13882gy7K0 : null;
        if (c7993Ub3 == null || (c7993Ub3D = d(c7993Ub3)) == null) {
            return null;
        }
        return c7993Ub3D.g();
    }

    public static final XC6 h(XC6 xc6, boolean z) {
        AbstractC13042fc3.i(xc6, "<this>");
        DG1 dg1B = DG1.d.b(xc6, z);
        if (dg1B != null) {
            return dg1B;
        }
        XC6 xc6G = g(xc6);
        return xc6G == null ? xc6.O0(false) : xc6G;
    }

    public static /* synthetic */ XC6 i(XC6 xc6, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return h(xc6, z);
    }

    public static final XC6 j(XC6 xc6, XC6 xc62) {
        AbstractC13042fc3.i(xc6, "<this>");
        AbstractC13042fc3.i(xc62, "abbreviatedType");
        return AbstractC4816Gr3.a(xc6) ? xc6 : new C13893h0(xc6, xc62);
    }

    public static final C24002xs4 k(C24002xs4 c24002xs4) {
        AbstractC13042fc3.i(c24002xs4, "<this>");
        return new C24002xs4(c24002xs4.T0(), c24002xs4.K0(), c24002xs4.V0(), c24002xs4.getAnnotations(), c24002xs4.L0(), true);
    }
}
