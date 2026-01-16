package ir.nasim;

import java.util.Collection;

/* renamed from: ir.nasim.Ji3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5437Ji3 {
    public static final C5437Ji3 a = new C5437Ji3();

    private C5437Ji3() {
    }

    public static /* synthetic */ InterfaceC21331tU0 h(C5437Ji3 c5437Ji3, C9424Zw2 c9424Zw2, AbstractC19738qr3 abstractC19738qr3, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return c5437Ji3.g(c9424Zw2, abstractC19738qr3, num);
    }

    public final InterfaceC21331tU0 a(InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(interfaceC21331tU0, "mutable");
        C9424Zw2 c9424Zw2P = C5203Ii3.a.p(OI1.m(interfaceC21331tU0));
        if (c9424Zw2P != null) {
            InterfaceC21331tU0 interfaceC21331tU0O = PI1.g(interfaceC21331tU0).o(c9424Zw2P);
            AbstractC13042fc3.h(interfaceC21331tU0O, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return interfaceC21331tU0O;
        }
        throw new IllegalArgumentException("Given class " + interfaceC21331tU0 + " is not a mutable collection");
    }

    public final InterfaceC21331tU0 b(InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(interfaceC21331tU0, "readOnly");
        C9424Zw2 c9424Zw2Q = C5203Ii3.a.q(OI1.m(interfaceC21331tU0));
        if (c9424Zw2Q != null) {
            InterfaceC21331tU0 interfaceC21331tU0O = PI1.g(interfaceC21331tU0).o(c9424Zw2Q);
            AbstractC13042fc3.h(interfaceC21331tU0O, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
            return interfaceC21331tU0O;
        }
        throw new IllegalArgumentException("Given class " + interfaceC21331tU0 + " is not a read-only collection");
    }

    public final boolean c(InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(interfaceC21331tU0, "mutable");
        return C5203Ii3.a.l(OI1.m(interfaceC21331tU0));
    }

    public final boolean d(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "type");
        InterfaceC21331tU0 interfaceC21331tU0F = AbstractC7497Ry7.f(abstractC4099Dr3);
        return interfaceC21331tU0F != null && c(interfaceC21331tU0F);
    }

    public final boolean e(InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(interfaceC21331tU0, "readOnly");
        return C5203Ii3.a.m(OI1.m(interfaceC21331tU0));
    }

    public final boolean f(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "type");
        InterfaceC21331tU0 interfaceC21331tU0F = AbstractC7497Ry7.f(abstractC4099Dr3);
        return interfaceC21331tU0F != null && e(interfaceC21331tU0F);
    }

    public final InterfaceC21331tU0 g(C9424Zw2 c9424Zw2, AbstractC19738qr3 abstractC19738qr3, Integer num) {
        C24948zU0 c24948zU0N;
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(abstractC19738qr3, "builtIns");
        if (num == null || !AbstractC13042fc3.d(c9424Zw2, C5203Ii3.a.i())) {
            c24948zU0N = C5203Ii3.a.n(c9424Zw2);
        } else {
            PJ6 pj6 = PJ6.a;
            c24948zU0N = PJ6.a(num.intValue());
        }
        if (c24948zU0N != null) {
            return abstractC19738qr3.o(c24948zU0N.b());
        }
        return null;
    }

    public final Collection i(C9424Zw2 c9424Zw2, AbstractC19738qr3 abstractC19738qr3) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(abstractC19738qr3, "builtIns");
        InterfaceC21331tU0 interfaceC21331tU0H = h(this, c9424Zw2, abstractC19738qr3, null, 4, null);
        if (interfaceC21331tU0H == null) {
            return AbstractC4597Fu6.d();
        }
        C9424Zw2 c9424Zw2Q = C5203Ii3.a.q(PI1.j(interfaceC21331tU0H));
        if (c9424Zw2Q == null) {
            return AbstractC4363Eu6.c(interfaceC21331tU0H);
        }
        InterfaceC21331tU0 interfaceC21331tU0O = abstractC19738qr3.o(c9424Zw2Q);
        AbstractC13042fc3.h(interfaceC21331tU0O, "builtIns.getBuiltInClassByFqName(kotlinMutableAnalogFqName)");
        return AbstractC10360bX0.p(interfaceC21331tU0H, interfaceC21331tU0O);
    }
}
