package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.iu4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15041iu4 implements InterfaceC14434hu4 {
    private final AbstractC5284Ir3 c;
    private final C11663dO4 d;

    public C15041iu4(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        this.c = abstractC5284Ir3;
        C11663dO4 c11663dO4P = C11663dO4.p(d());
        AbstractC13042fc3.h(c11663dO4P, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.d = c11663dO4P;
    }

    @Override // ir.nasim.InterfaceC14434hu4
    public C11663dO4 a() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC4333Er3
    public boolean b(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32) {
        AbstractC13042fc3.i(abstractC4099Dr3, "subtype");
        AbstractC13042fc3.i(abstractC4099Dr32, "supertype");
        return f(new IU0(true, false, false, d(), 6, null), abstractC4099Dr3.N0(), abstractC4099Dr32.N0());
    }

    @Override // ir.nasim.InterfaceC4333Er3
    public boolean c(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32) {
        AbstractC13042fc3.i(abstractC4099Dr3, "a");
        AbstractC13042fc3.i(abstractC4099Dr32, "b");
        return e(new IU0(false, false, false, d(), 6, null), abstractC4099Dr3.N0(), abstractC4099Dr32.N0());
    }

    @Override // ir.nasim.InterfaceC14434hu4
    public AbstractC5284Ir3 d() {
        return this.c;
    }

    public final boolean e(IU0 iu0, AbstractC18174oC7 abstractC18174oC7, AbstractC18174oC7 abstractC18174oC72) {
        AbstractC13042fc3.i(iu0, "<this>");
        AbstractC13042fc3.i(abstractC18174oC7, "a");
        AbstractC13042fc3.i(abstractC18174oC72, "b");
        return C11452d2.a.i(iu0, abstractC18174oC7, abstractC18174oC72);
    }

    public final boolean f(IU0 iu0, AbstractC18174oC7 abstractC18174oC7, AbstractC18174oC7 abstractC18174oC72) {
        AbstractC13042fc3.i(iu0, "<this>");
        AbstractC13042fc3.i(abstractC18174oC7, "subType");
        AbstractC13042fc3.i(abstractC18174oC72, "superType");
        return C11452d2.o(C11452d2.a, iu0, abstractC18174oC7, abstractC18174oC72, false, 8, null);
    }

    public final XC6 g(XC6 xc6) {
        AbstractC4099Dr3 type;
        AbstractC13042fc3.i(xc6, "type");
        InterfaceC13882gy7 interfaceC13882gy7K0 = xc6.K0();
        C7993Ub3 c7993Ub3K = null;
        abstractC18174oC7N0 = null;
        AbstractC18174oC7 abstractC18174oC7N0 = null;
        if (!(interfaceC13882gy7K0 instanceof C18203oG0)) {
            if (!(interfaceC13882gy7K0 instanceof C7993Ub3) || !xc6.L0()) {
                return xc6;
            }
            C7993Ub3 c7993Ub3 = (C7993Ub3) interfaceC13882gy7K0;
            Collection collectionB = c7993Ub3.b();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collectionB, 10));
            Iterator it = collectionB.iterator();
            boolean z = false;
            while (it.hasNext()) {
                arrayList.add(AbstractC7731Sy7.k((AbstractC4099Dr3) it.next()));
                z = true;
            }
            if (z) {
                AbstractC4099Dr3 abstractC4099Dr3H = c7993Ub3.h();
                c7993Ub3K = new C7993Ub3(arrayList).k(abstractC4099Dr3H != null ? AbstractC7731Sy7.k(abstractC4099Dr3H) : null);
            }
            if (c7993Ub3K != null) {
                c7993Ub3 = c7993Ub3K;
            }
            return c7993Ub3.g();
        }
        C18203oG0 c18203oG0 = (C18203oG0) interfaceC13882gy7K0;
        InterfaceC3932Cy7 interfaceC3932Cy7C = c18203oG0.c();
        if (interfaceC3932Cy7C.c() != KQ7.IN_VARIANCE) {
            interfaceC3932Cy7C = null;
        }
        if (interfaceC3932Cy7C != null && (type = interfaceC3932Cy7C.getType()) != null) {
            abstractC18174oC7N0 = type.N0();
        }
        AbstractC18174oC7 abstractC18174oC7 = abstractC18174oC7N0;
        if (c18203oG0.g() == null) {
            InterfaceC3932Cy7 interfaceC3932Cy7C2 = c18203oG0.c();
            Collection collectionB2 = c18203oG0.b();
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(collectionB2, 10));
            Iterator it2 = collectionB2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((AbstractC4099Dr3) it2.next()).N0());
            }
            c18203oG0.i(new C24592ys4(interfaceC3932Cy7C2, arrayList2, null, 4, null));
        }
        EnumC15839kG0 enumC15839kG0 = EnumC15839kG0.FOR_SUBTYPING;
        C24592ys4 c24592ys4G = c18203oG0.g();
        AbstractC13042fc3.f(c24592ys4G);
        return new C24002xs4(enumC15839kG0, c24592ys4G, abstractC18174oC7, xc6.getAnnotations(), xc6.L0(), false, 32, null);
    }

    public AbstractC18174oC7 h(AbstractC18174oC7 abstractC18174oC7) {
        AbstractC18174oC7 abstractC18174oC7D;
        AbstractC13042fc3.i(abstractC18174oC7, "type");
        if (abstractC18174oC7 instanceof XC6) {
            abstractC18174oC7D = g((XC6) abstractC18174oC7);
        } else {
            if (!(abstractC18174oC7 instanceof AbstractC6200Mp2)) {
                throw new NoWhenBranchMatchedException();
            }
            AbstractC6200Mp2 abstractC6200Mp2 = (AbstractC6200Mp2) abstractC18174oC7;
            XC6 xc6G = g(abstractC6200Mp2.S0());
            XC6 xc6G2 = g(abstractC6200Mp2.T0());
            abstractC18174oC7D = (xc6G == abstractC6200Mp2.S0() && xc6G2 == abstractC6200Mp2.T0()) ? abstractC18174oC7 : C4567Fr3.d(xc6G, xc6G2);
        }
        return AbstractC8692Wy7.b(abstractC18174oC7D, abstractC18174oC7);
    }
}
