package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Ay7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC3459Ay7 {

    /* renamed from: ir.nasim.Ay7$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final boolean a(InterfaceC12795fB1 interfaceC12795fB1) {
            AbstractC13042fc3.i(interfaceC12795fB1, "it");
            return interfaceC12795fB1 instanceof InterfaceC14592iA0;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((InterfaceC12795fB1) obj));
        }
    }

    /* renamed from: ir.nasim.Ay7$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        public final boolean a(InterfaceC12795fB1 interfaceC12795fB1) {
            AbstractC13042fc3.i(interfaceC12795fB1, "it");
            return !(interfaceC12795fB1 instanceof InterfaceC21426te1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((InterfaceC12795fB1) obj));
        }
    }

    /* renamed from: ir.nasim.Ay7$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC23384wp6 invoke(InterfaceC12795fB1 interfaceC12795fB1) {
            AbstractC13042fc3.i(interfaceC12795fB1, "it");
            List typeParameters = ((InterfaceC14592iA0) interfaceC12795fB1).getTypeParameters();
            AbstractC13042fc3.h(typeParameters, "it as CallableDescriptor).typeParameters");
            return AbstractC15401jX0.g0(typeParameters);
        }
    }

    public static final C9888aj5 a(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        MU0 mu0T = abstractC4099Dr3.K0().t();
        return b(abstractC4099Dr3, mu0T instanceof NU0 ? (NU0) mu0T : null, 0);
    }

    private static final C9888aj5 b(AbstractC4099Dr3 abstractC4099Dr3, NU0 nu0, int i) {
        if (nu0 == null || AbstractC14230ha2.r(nu0)) {
            return null;
        }
        int size = nu0.q().size() + i;
        if (nu0.A()) {
            List listSubList = abstractC4099Dr3.J0().subList(i, size);
            InterfaceC12795fB1 interfaceC12795fB1B = nu0.b();
            return new C9888aj5(nu0, listSubList, b(abstractC4099Dr3, interfaceC12795fB1B instanceof NU0 ? (NU0) interfaceC12795fB1B : null, size));
        }
        if (size != abstractC4099Dr3.J0().size()) {
            OI1.E(nu0);
        }
        return new C9888aj5(nu0, abstractC4099Dr3.J0().subList(i, abstractC4099Dr3.J0().size()), null);
    }

    private static final C19976rG0 c(InterfaceC22882vy7 interfaceC22882vy7, InterfaceC12795fB1 interfaceC12795fB1, int i) {
        return new C19976rG0(interfaceC22882vy7, interfaceC12795fB1, i);
    }

    public static final List d(NU0 nu0) {
        List listM;
        Object next;
        InterfaceC13882gy7 interfaceC13882gy7J;
        AbstractC13042fc3.i(nu0, "<this>");
        List listQ = nu0.q();
        AbstractC13042fc3.h(listQ, "declaredTypeParameters");
        if (!nu0.A() && !(nu0.b() instanceof InterfaceC14592iA0)) {
            return listQ;
        }
        List listK = AbstractC11342cq6.K(AbstractC11342cq6.w(AbstractC11342cq6.r(AbstractC11342cq6.I(PI1.m(nu0), a.e), b.e), c.e));
        Iterator it = PI1.m(nu0).iterator();
        while (true) {
            listM = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next instanceof InterfaceC21331tU0) {
                break;
            }
        }
        InterfaceC21331tU0 interfaceC21331tU0 = (InterfaceC21331tU0) next;
        if (interfaceC21331tU0 != null && (interfaceC13882gy7J = interfaceC21331tU0.j()) != null) {
            listM = interfaceC13882gy7J.getParameters();
        }
        if (listM == null) {
            listM = AbstractC10360bX0.m();
        }
        if (listK.isEmpty() && listM.isEmpty()) {
            List listQ2 = nu0.q();
            AbstractC13042fc3.h(listQ2, "declaredTypeParameters");
            return listQ2;
        }
        List<InterfaceC22882vy7> listR0 = AbstractC15401jX0.R0(listK, listM);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listR0, 10));
        for (InterfaceC22882vy7 interfaceC22882vy7 : listR0) {
            AbstractC13042fc3.h(interfaceC22882vy7, "it");
            arrayList.add(c(interfaceC22882vy7, nu0, listQ.size()));
        }
        return AbstractC15401jX0.R0(listQ, arrayList);
    }
}
