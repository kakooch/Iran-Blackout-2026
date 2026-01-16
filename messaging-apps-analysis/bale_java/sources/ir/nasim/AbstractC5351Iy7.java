package ir.nasim;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Iy7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5351Iy7 {
    public static final XC6 a(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC18174oC7 abstractC18174oC7N0 = abstractC4099Dr3.N0();
        XC6 xc6 = abstractC18174oC7N0 instanceof XC6 ? (XC6) abstractC18174oC7N0 : null;
        if (xc6 != null) {
            return xc6;
        }
        throw new IllegalStateException(AbstractC13042fc3.q("This is should be simple type: ", abstractC4099Dr3).toString());
    }

    public static final AbstractC4099Dr3 b(AbstractC4099Dr3 abstractC4099Dr3, List list, InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC13042fc3.i(list, "newArguments");
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        return e(abstractC4099Dr3, list, interfaceC4356Eu, null, 4, null);
    }

    public static final AbstractC4099Dr3 c(AbstractC4099Dr3 abstractC4099Dr3, List list, InterfaceC4356Eu interfaceC4356Eu, List list2) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC13042fc3.i(list, "newArguments");
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        AbstractC13042fc3.i(list2, "newArgumentsForUpperBound");
        if ((list.isEmpty() || list == abstractC4099Dr3.J0()) && interfaceC4356Eu == abstractC4099Dr3.getAnnotations()) {
            return abstractC4099Dr3;
        }
        AbstractC18174oC7 abstractC18174oC7N0 = abstractC4099Dr3.N0();
        if (abstractC18174oC7N0 instanceof AbstractC6200Mp2) {
            C4567Fr3 c4567Fr3 = C4567Fr3.a;
            AbstractC6200Mp2 abstractC6200Mp2 = (AbstractC6200Mp2) abstractC18174oC7N0;
            return C4567Fr3.d(d(abstractC6200Mp2.S0(), list, interfaceC4356Eu), d(abstractC6200Mp2.T0(), list2, interfaceC4356Eu));
        }
        if (abstractC18174oC7N0 instanceof XC6) {
            return d((XC6) abstractC18174oC7N0, list, interfaceC4356Eu);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final XC6 d(XC6 xc6, List list, InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(xc6, "<this>");
        AbstractC13042fc3.i(list, "newArguments");
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        if (list.isEmpty() && interfaceC4356Eu == xc6.getAnnotations()) {
            return xc6;
        }
        if (list.isEmpty()) {
            return xc6.Q0(interfaceC4356Eu);
        }
        C4567Fr3 c4567Fr3 = C4567Fr3.a;
        return C4567Fr3.i(interfaceC4356Eu, xc6.K0(), list, xc6.L0(), null, 16, null);
    }

    public static /* synthetic */ AbstractC4099Dr3 e(AbstractC4099Dr3 abstractC4099Dr3, List list, InterfaceC4356Eu interfaceC4356Eu, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = abstractC4099Dr3.J0();
        }
        if ((i & 2) != 0) {
            interfaceC4356Eu = abstractC4099Dr3.getAnnotations();
        }
        if ((i & 4) != 0) {
            list2 = list;
        }
        return c(abstractC4099Dr3, list, interfaceC4356Eu, list2);
    }

    public static /* synthetic */ XC6 f(XC6 xc6, List list, InterfaceC4356Eu interfaceC4356Eu, int i, Object obj) {
        if ((i & 1) != 0) {
            list = xc6.J0();
        }
        if ((i & 2) != 0) {
            interfaceC4356Eu = xc6.getAnnotations();
        }
        return d(xc6, list, interfaceC4356Eu);
    }
}
