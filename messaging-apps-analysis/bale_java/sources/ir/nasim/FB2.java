package ir.nasim;

import ir.nasim.EnumC24185yB2;
import ir.nasim.PJ6;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class FB2 {
    public static final XC6 a(AbstractC19738qr3 abstractC19738qr3, InterfaceC4356Eu interfaceC4356Eu, AbstractC4099Dr3 abstractC4099Dr3, List list, List list2, AbstractC4099Dr3 abstractC4099Dr32, boolean z) {
        AbstractC13042fc3.i(abstractC19738qr3, "builtIns");
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(list, "parameterTypes");
        AbstractC13042fc3.i(abstractC4099Dr32, "returnType");
        List listE = e(abstractC4099Dr3, list, list2, abstractC4099Dr32, abstractC19738qr3);
        int size = list.size();
        if (abstractC4099Dr3 != null) {
            size++;
        }
        InterfaceC21331tU0 interfaceC21331tU0D = d(abstractC19738qr3, size, z);
        if (abstractC4099Dr3 != null) {
            interfaceC4356Eu = q(interfaceC4356Eu, abstractC19738qr3);
        }
        return C4567Fr3.g(interfaceC4356Eu, interfaceC21331tU0D, listE);
    }

    public static /* synthetic */ XC6 b(AbstractC19738qr3 abstractC19738qr3, InterfaceC4356Eu interfaceC4356Eu, AbstractC4099Dr3 abstractC4099Dr3, List list, List list2, AbstractC4099Dr3 abstractC4099Dr32, boolean z, int i, Object obj) {
        if ((i & 64) != 0) {
            z = false;
        }
        return a(abstractC19738qr3, interfaceC4356Eu, abstractC4099Dr3, list, list2, abstractC4099Dr32, z);
    }

    public static final C6432No4 c(AbstractC4099Dr3 abstractC4099Dr3) {
        String str;
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        InterfaceC21651tu interfaceC21651tuZ = abstractC4099Dr3.getAnnotations().z(PJ6.a.D);
        if (interfaceC21651tuZ == null) {
            return null;
        }
        Object objW0 = AbstractC15401jX0.W0(interfaceC21651tuZ.j().values());
        C9790aZ6 c9790aZ6 = objW0 instanceof C9790aZ6 ? (C9790aZ6) objW0 : null;
        if (c9790aZ6 == null || (str = (String) c9790aZ6.b()) == null || !C6432No4.r(str)) {
            str = null;
        }
        if (str == null) {
            return null;
        }
        return C6432No4.p(str);
    }

    public static final InterfaceC21331tU0 d(AbstractC19738qr3 abstractC19738qr3, int i, boolean z) {
        AbstractC13042fc3.i(abstractC19738qr3, "builtIns");
        InterfaceC21331tU0 interfaceC21331tU0W = z ? abstractC19738qr3.W(i) : abstractC19738qr3.C(i);
        AbstractC13042fc3.h(interfaceC21331tU0W, "if (isSuspendFunction) builtIns.getSuspendFunction(parameterCount) else builtIns.getFunction(parameterCount)");
        return interfaceC21331tU0W;
    }

    public static final List e(AbstractC4099Dr3 abstractC4099Dr3, List list, List list2, AbstractC4099Dr3 abstractC4099Dr32, AbstractC19738qr3 abstractC19738qr3) {
        C6432No4 c6432No4;
        AbstractC13042fc3.i(list, "parameterTypes");
        AbstractC13042fc3.i(abstractC4099Dr32, "returnType");
        AbstractC13042fc3.i(abstractC19738qr3, "builtIns");
        int i = 0;
        ArrayList arrayList = new ArrayList(list.size() + (abstractC4099Dr3 != null ? 1 : 0) + 1);
        YW0.a(arrayList, abstractC4099Dr3 == null ? null : AbstractC7731Sy7.a(abstractC4099Dr3));
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            AbstractC4099Dr3 abstractC4099Dr3L = (AbstractC4099Dr3) obj;
            if (list2 == null || (c6432No4 = (C6432No4) list2.get(i)) == null || c6432No4.q()) {
                c6432No4 = null;
            }
            if (c6432No4 != null) {
                C9424Zw2 c9424Zw2 = PJ6.a.D;
                C6432No4 c6432No4P = C6432No4.p("name");
                String strH = c6432No4.h();
                AbstractC13042fc3.h(strH, "name.asString()");
                abstractC4099Dr3L = AbstractC7731Sy7.l(abstractC4099Dr3L, InterfaceC4356Eu.W.a(AbstractC15401jX0.Q0(abstractC4099Dr3L.getAnnotations(), new C11296cm0(abstractC19738qr3, c9424Zw2, AbstractC19460qO3.g(AbstractC4616Fw7.a(c6432No4P, new C9790aZ6(strH)))))));
            }
            arrayList.add(AbstractC7731Sy7.a(abstractC4099Dr3L));
            i = i2;
        }
        arrayList.add(AbstractC7731Sy7.a(abstractC4099Dr32));
        return arrayList;
    }

    public static final EnumC24185yB2 f(InterfaceC12795fB1 interfaceC12795fB1) {
        AbstractC13042fc3.i(interfaceC12795fB1, "<this>");
        if ((interfaceC12795fB1 instanceof InterfaceC21331tU0) && AbstractC19738qr3.I0(interfaceC12795fB1)) {
            return g(PI1.j(interfaceC12795fB1));
        }
        return null;
    }

    private static final EnumC24185yB2 g(C10027ax2 c10027ax2) {
        if (!c10027ax2.f() || c10027ax2.e()) {
            return null;
        }
        EnumC24185yB2.a aVar = EnumC24185yB2.c;
        String strH = c10027ax2.i().h();
        AbstractC13042fc3.h(strH, "shortName().asString()");
        C9424Zw2 c9424Zw2E = c10027ax2.l().e();
        AbstractC13042fc3.h(c9424Zw2E, "toSafe().parent()");
        return aVar.b(strH, c9424Zw2E);
    }

    public static final AbstractC4099Dr3 h(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        m(abstractC4099Dr3);
        if (p(abstractC4099Dr3)) {
            return ((InterfaceC3932Cy7) AbstractC15401jX0.q0(abstractC4099Dr3.J0())).getType();
        }
        return null;
    }

    public static final AbstractC4099Dr3 i(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        m(abstractC4099Dr3);
        AbstractC4099Dr3 type = ((InterfaceC3932Cy7) AbstractC15401jX0.C0(abstractC4099Dr3.J0())).getType();
        AbstractC13042fc3.h(type, "arguments.last().type");
        return type;
    }

    public static final List j(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        m(abstractC4099Dr3);
        return abstractC4099Dr3.J0().subList(k(abstractC4099Dr3) ? 1 : 0, r0.size() - 1);
    }

    public static final boolean k(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        return m(abstractC4099Dr3) && p(abstractC4099Dr3);
    }

    public static final boolean l(InterfaceC12795fB1 interfaceC12795fB1) {
        AbstractC13042fc3.i(interfaceC12795fB1, "<this>");
        EnumC24185yB2 enumC24185yB2F = f(interfaceC12795fB1);
        return enumC24185yB2F == EnumC24185yB2.d || enumC24185yB2F == EnumC24185yB2.e;
    }

    public static final boolean m(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        MU0 mu0T = abstractC4099Dr3.K0().t();
        return AbstractC13042fc3.d(mu0T == null ? null : Boolean.valueOf(l(mu0T)), Boolean.TRUE);
    }

    public static final boolean n(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        MU0 mu0T = abstractC4099Dr3.K0().t();
        return (mu0T == null ? null : f(mu0T)) == EnumC24185yB2.d;
    }

    public static final boolean o(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        MU0 mu0T = abstractC4099Dr3.K0().t();
        return (mu0T == null ? null : f(mu0T)) == EnumC24185yB2.e;
    }

    private static final boolean p(AbstractC4099Dr3 abstractC4099Dr3) {
        return abstractC4099Dr3.getAnnotations().z(PJ6.a.C) != null;
    }

    public static final InterfaceC4356Eu q(InterfaceC4356Eu interfaceC4356Eu, AbstractC19738qr3 abstractC19738qr3) {
        AbstractC13042fc3.i(interfaceC4356Eu, "<this>");
        AbstractC13042fc3.i(abstractC19738qr3, "builtIns");
        C9424Zw2 c9424Zw2 = PJ6.a.C;
        return interfaceC4356Eu.M1(c9424Zw2) ? interfaceC4356Eu : InterfaceC4356Eu.W.a(AbstractC15401jX0.Q0(interfaceC4356Eu, new C11296cm0(abstractC19738qr3, c9424Zw2, AbstractC20051rO3.k())));
    }
}
