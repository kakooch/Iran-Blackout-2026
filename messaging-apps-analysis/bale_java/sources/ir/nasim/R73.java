package ir.nasim;

import java.util.List;

/* loaded from: classes8.dex */
public abstract class R73 {
    private static final C9424Zw2 a = new C9424Zw2("kotlin.jvm.JvmInline");

    public static final boolean a(InterfaceC14592iA0 interfaceC14592iA0) {
        AbstractC13042fc3.i(interfaceC14592iA0, "<this>");
        if (interfaceC14592iA0 instanceof InterfaceC22266uw5) {
            InterfaceC20989sw5 interfaceC20989sw5V = ((InterfaceC22266uw5) interfaceC14592iA0).V();
            AbstractC13042fc3.h(interfaceC20989sw5V, "correspondingProperty");
            if (d(interfaceC20989sw5V)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(InterfaceC12795fB1 interfaceC12795fB1) {
        AbstractC13042fc3.i(interfaceC12795fB1, "<this>");
        if (interfaceC12795fB1 instanceof InterfaceC21331tU0) {
            InterfaceC21331tU0 interfaceC21331tU0 = (InterfaceC21331tU0) interfaceC12795fB1;
            if (interfaceC21331tU0.isInline() || interfaceC21331tU0.k0()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean c(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        MU0 mu0T = abstractC4099Dr3.K0().t();
        if (mu0T == null) {
            return false;
        }
        return b(mu0T);
    }

    public static final boolean d(FQ7 fq7) {
        AbstractC13042fc3.i(fq7, "<this>");
        if (fq7.Q() != null) {
            return false;
        }
        InterfaceC12795fB1 interfaceC12795fB1B = fq7.b();
        AbstractC13042fc3.h(interfaceC12795fB1B, "this.containingDeclaration");
        if (!b(interfaceC12795fB1B)) {
            return false;
        }
        InterfaceC24919zQ7 interfaceC24919zQ7F = f((InterfaceC21331tU0) interfaceC12795fB1B);
        return AbstractC13042fc3.d(interfaceC24919zQ7F == null ? null : interfaceC24919zQ7F.getName(), fq7.getName());
    }

    public static final AbstractC4099Dr3 e(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        InterfaceC24919zQ7 interfaceC24919zQ7G = g(abstractC4099Dr3);
        if (interfaceC24919zQ7G == null) {
            return null;
        }
        return C5585Jy7.f(abstractC4099Dr3).p(interfaceC24919zQ7G.getType(), KQ7.INVARIANT);
    }

    public static final InterfaceC24919zQ7 f(InterfaceC21331tU0 interfaceC21331tU0) {
        InterfaceC18329oU0 interfaceC18329oU0D;
        List listH;
        AbstractC13042fc3.i(interfaceC21331tU0, "<this>");
        if (!b(interfaceC21331tU0) || (interfaceC18329oU0D = interfaceC21331tU0.D()) == null || (listH = interfaceC18329oU0D.h()) == null) {
            return null;
        }
        return (InterfaceC24919zQ7) AbstractC15401jX0.X0(listH);
    }

    public static final InterfaceC24919zQ7 g(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        MU0 mu0T = abstractC4099Dr3.K0().t();
        if (!(mu0T instanceof InterfaceC21331tU0)) {
            mu0T = null;
        }
        InterfaceC21331tU0 interfaceC21331tU0 = (InterfaceC21331tU0) mu0T;
        if (interfaceC21331tU0 == null) {
            return null;
        }
        return f(interfaceC21331tU0);
    }
}
