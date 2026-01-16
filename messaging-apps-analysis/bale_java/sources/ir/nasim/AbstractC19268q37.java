package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.InterfaceC4356Eu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.q37, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19268q37 {
    private static final C11922dm4 a;
    private static final C11922dm4 b;

    static {
        InterfaceC8507Wg4 interfaceC8507Wg4Q = AbstractC14230ha2.q();
        AbstractC13042fc3.h(interfaceC8507Wg4Q, "getErrorModule()");
        A72 a72 = new A72(interfaceC8507Wg4Q, PJ6.e);
        AU0 au0 = AU0.INTERFACE;
        C6432No4 c6432No4G = PJ6.g.g();
        JH6 jh6 = JH6.a;
        ON6 on6 = C14671iI3.e;
        C11922dm4 c11922dm4 = new C11922dm4(a72, au0, false, false, c6432No4G, jh6, on6);
        EnumC11067cg4 enumC11067cg4 = EnumC11067cg4.ABSTRACT;
        c11922dm4.L0(enumC11067cg4);
        RI1 ri1 = QI1.e;
        c11922dm4.N0(ri1);
        InterfaceC4356Eu.a aVar = InterfaceC4356Eu.W;
        InterfaceC4356Eu interfaceC4356EuB = aVar.b();
        KQ7 kq7 = KQ7.IN_VARIANCE;
        c11922dm4.M0(AbstractC9766aX0.e(C23472wy7.Q0(c11922dm4, interfaceC4356EuB, false, kq7, C6432No4.p(TokenNames.T), 0, on6)));
        c11922dm4.J0();
        a = c11922dm4;
        InterfaceC8507Wg4 interfaceC8507Wg4Q2 = AbstractC14230ha2.q();
        AbstractC13042fc3.h(interfaceC8507Wg4Q2, "getErrorModule()");
        C11922dm4 c11922dm42 = new C11922dm4(new A72(interfaceC8507Wg4Q2, PJ6.d), au0, false, false, PJ6.h.g(), jh6, on6);
        c11922dm42.L0(enumC11067cg4);
        c11922dm42.N0(ri1);
        c11922dm42.M0(AbstractC9766aX0.e(C23472wy7.Q0(c11922dm42, aVar.b(), false, kq7, C6432No4.p(TokenNames.T), 0, on6)));
        c11922dm42.J0();
        b = c11922dm42;
    }

    public static final boolean a(C9424Zw2 c9424Zw2, boolean z) {
        return z ? AbstractC13042fc3.d(c9424Zw2, PJ6.h) : AbstractC13042fc3.d(c9424Zw2, PJ6.g);
    }

    public static final XC6 b(AbstractC4099Dr3 abstractC4099Dr3, boolean z) {
        AbstractC13042fc3.i(abstractC4099Dr3, "suspendFunType");
        FB2.o(abstractC4099Dr3);
        AbstractC19738qr3 abstractC19738qr3E = AbstractC7731Sy7.e(abstractC4099Dr3);
        InterfaceC4356Eu annotations = abstractC4099Dr3.getAnnotations();
        AbstractC4099Dr3 abstractC4099Dr3H = FB2.h(abstractC4099Dr3);
        List listJ = FB2.j(abstractC4099Dr3);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listJ, 10));
        Iterator it = listJ.iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC3932Cy7) it.next()).getType());
        }
        C4567Fr3 c4567Fr3 = C4567Fr3.a;
        InterfaceC4356Eu interfaceC4356EuB = InterfaceC4356Eu.W.b();
        InterfaceC13882gy7 interfaceC13882gy7J = z ? b.j() : a.j();
        AbstractC13042fc3.h(interfaceC13882gy7J, "if (isReleaseCoroutines) FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE.typeConstructor\n                    else FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL.typeConstructor");
        List listS0 = AbstractC15401jX0.S0(arrayList, C4567Fr3.i(interfaceC4356EuB, interfaceC13882gy7J, AbstractC9766aX0.e(AbstractC7731Sy7.a(FB2.i(abstractC4099Dr3))), false, null, 16, null));
        XC6 xc6I = AbstractC7731Sy7.e(abstractC4099Dr3).I();
        AbstractC13042fc3.h(xc6I, "suspendFunType.builtIns.nullableAnyType");
        return FB2.b(abstractC19738qr3E, annotations, abstractC4099Dr3H, listS0, null, xc6I, false, 64, null).O0(abstractC4099Dr3.L0());
    }
}
