package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class Q73 {
    private static final boolean a(InterfaceC21331tU0 interfaceC21331tU0) {
        return AbstractC13042fc3.d(PI1.i(interfaceC21331tU0), PJ6.i);
    }

    public static final boolean b(InterfaceC12795fB1 interfaceC12795fB1) {
        AbstractC13042fc3.i(interfaceC12795fB1, "<this>");
        return R73.b(interfaceC12795fB1) && !a((InterfaceC21331tU0) interfaceC12795fB1);
    }

    public static final boolean c(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        MU0 mu0T = abstractC4099Dr3.K0().t();
        return AbstractC13042fc3.d(mu0T == null ? null : Boolean.valueOf(b(mu0T)), Boolean.TRUE);
    }

    private static final boolean d(AbstractC4099Dr3 abstractC4099Dr3) {
        MU0 mu0T = abstractC4099Dr3.K0().t();
        InterfaceC22882vy7 interfaceC22882vy7 = mu0T instanceof InterfaceC22882vy7 ? (InterfaceC22882vy7) mu0T : null;
        if (interfaceC22882vy7 == null) {
            return false;
        }
        return e(AbstractC7731Sy7.f(interfaceC22882vy7));
    }

    private static final boolean e(AbstractC4099Dr3 abstractC4099Dr3) {
        return c(abstractC4099Dr3) || d(abstractC4099Dr3);
    }

    public static final boolean f(InterfaceC15194jA0 interfaceC15194jA0) {
        AbstractC13042fc3.i(interfaceC15194jA0, "descriptor");
        InterfaceC18329oU0 interfaceC18329oU0 = interfaceC15194jA0 instanceof InterfaceC18329oU0 ? (InterfaceC18329oU0) interfaceC15194jA0 : null;
        if (interfaceC18329oU0 == null || QI1.g(interfaceC18329oU0.getVisibility())) {
            return false;
        }
        InterfaceC21331tU0 interfaceC21331tU0E0 = interfaceC18329oU0.e0();
        AbstractC13042fc3.h(interfaceC21331tU0E0, "constructorDescriptor.constructedClass");
        if (R73.b(interfaceC21331tU0E0) || OI1.G(interfaceC18329oU0.e0())) {
            return false;
        }
        List listH = interfaceC18329oU0.h();
        AbstractC13042fc3.h(listH, "constructorDescriptor.valueParameters");
        List list = listH;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC4099Dr3 type = ((InterfaceC24919zQ7) it.next()).getType();
            AbstractC13042fc3.h(type, "it.type");
            if (e(type)) {
                return true;
            }
        }
        return false;
    }
}
