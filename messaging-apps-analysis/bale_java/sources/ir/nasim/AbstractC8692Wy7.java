package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Wy7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC8692Wy7 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final AbstractC4099Dr3 a(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        if (abstractC4099Dr3 instanceof InterfaceC8438Vy7) {
            return ((InterfaceC8438Vy7) abstractC4099Dr3).i0();
        }
        return null;
    }

    public static final AbstractC18174oC7 b(AbstractC18174oC7 abstractC18174oC7, AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC18174oC7, "<this>");
        AbstractC13042fc3.i(abstractC4099Dr3, "origin");
        return d(abstractC18174oC7, a(abstractC4099Dr3));
    }

    public static final AbstractC4099Dr3 c(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC4099Dr3 abstractC4099Dr3A = a(abstractC4099Dr3);
        return abstractC4099Dr3A == null ? abstractC4099Dr3 : abstractC4099Dr3A;
    }

    public static final AbstractC18174oC7 d(AbstractC18174oC7 abstractC18174oC7, AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC18174oC7, "<this>");
        if (abstractC4099Dr3 == null) {
            return abstractC18174oC7;
        }
        if (abstractC18174oC7 instanceof XC6) {
            return new C9592aD6((XC6) abstractC18174oC7, abstractC4099Dr3);
        }
        if (abstractC18174oC7 instanceof AbstractC6200Mp2) {
            return new C7177Qp2((AbstractC6200Mp2) abstractC18174oC7, abstractC4099Dr3);
        }
        throw new NoWhenBranchMatchedException();
    }
}
