package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Rp2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7411Rp2 {
    public static final AbstractC6200Mp2 a(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        return (AbstractC6200Mp2) abstractC4099Dr3.N0();
    }

    public static final boolean b(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        return abstractC4099Dr3.N0() instanceof AbstractC6200Mp2;
    }

    public static final XC6 c(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC18174oC7 abstractC18174oC7N0 = abstractC4099Dr3.N0();
        if (abstractC18174oC7N0 instanceof AbstractC6200Mp2) {
            return ((AbstractC6200Mp2) abstractC18174oC7N0).S0();
        }
        if (abstractC18174oC7N0 instanceof XC6) {
            return (XC6) abstractC18174oC7N0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final XC6 d(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC18174oC7 abstractC18174oC7N0 = abstractC4099Dr3.N0();
        if (abstractC18174oC7N0 instanceof AbstractC6200Mp2) {
            return ((AbstractC6200Mp2) abstractC18174oC7N0).T0();
        }
        if (abstractC18174oC7N0 instanceof XC6) {
            return (XC6) abstractC18174oC7N0;
        }
        throw new NoWhenBranchMatchedException();
    }
}
