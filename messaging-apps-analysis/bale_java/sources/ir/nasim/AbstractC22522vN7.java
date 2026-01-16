package ir.nasim;

/* renamed from: ir.nasim.vN7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC22522vN7 {
    public static final AbstractC10496bi3 a(AbstractC4099Dr3 abstractC4099Dr3, String str) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC13042fc3.i(str, "value");
        MU0 mu0T = abstractC4099Dr3.K0().t();
        if (mu0T instanceof InterfaceC21331tU0) {
            InterfaceC21331tU0 interfaceC21331tU0 = (InterfaceC21331tU0) mu0T;
            if (interfaceC21331tU0.f() == AU0.ENUM_CLASS) {
                W24 w24U = interfaceC21331tU0.U();
                C6432No4 c6432No4P = C6432No4.p(str);
                AbstractC13042fc3.h(c6432No4P, "identifier(value)");
                MU0 mu0E = w24U.e(c6432No4P, FA4.FROM_BACKEND);
                if (!(mu0E instanceof InterfaceC21331tU0)) {
                    return null;
                }
                InterfaceC21331tU0 interfaceC21331tU02 = (InterfaceC21331tU0) mu0E;
                if (interfaceC21331tU02.f() == AU0.ENUM_ENTRY) {
                    return new I92(interfaceC21331tU02);
                }
                return null;
            }
        }
        AbstractC4099Dr3 abstractC4099Dr3J = AbstractC7731Sy7.j(abstractC4099Dr3);
        AF4 af4A = CF4.a(str);
        String strA = af4A.a();
        int iB = af4A.b();
        Object objValueOf = AbstractC19738qr3.d0(abstractC4099Dr3J) ? Boolean.valueOf(Boolean.parseBoolean(str)) : AbstractC19738qr3.g0(abstractC4099Dr3J) ? AbstractC22039uZ6.x1(str) : AbstractC19738qr3.f0(abstractC4099Dr3J) ? AbstractC19562qZ6.n(strA, iB) : AbstractC19738qr3.A0(abstractC4099Dr3J) ? AbstractC19562qZ6.s(strA, iB) : AbstractC19738qr3.p0(abstractC4099Dr3J) ? AbstractC19562qZ6.p(strA, iB) : AbstractC19738qr3.r0(abstractC4099Dr3J) ? AbstractC19562qZ6.r(strA, iB) : AbstractC19738qr3.n0(abstractC4099Dr3J) ? AbstractC18971pZ6.l(str) : AbstractC19738qr3.l0(abstractC4099Dr3J) ? AbstractC18971pZ6.k(str) : AbstractC19738qr3.C0(abstractC4099Dr3J) ? null : null;
        if (objValueOf != null) {
            return new C6330Nd1(objValueOf);
        }
        return null;
    }

    public static final RI1 b(GY7 gy7) {
        AbstractC13042fc3.i(gy7, "<this>");
        RI1 ri1G = AbstractC13129fi3.g(gy7);
        AbstractC13042fc3.h(ri1G, "toDescriptorVisibility(this)");
        return ri1G;
    }
}
