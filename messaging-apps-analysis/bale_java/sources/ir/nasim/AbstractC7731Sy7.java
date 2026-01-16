package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Sy7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7731Sy7 {

    /* renamed from: ir.nasim.Sy7$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final boolean a(AbstractC18174oC7 abstractC18174oC7) {
            AbstractC13042fc3.i(abstractC18174oC7, "it");
            MU0 mu0D = abstractC18174oC7.K0().t();
            if (mu0D == null) {
                return false;
            }
            return AbstractC7731Sy7.h(mu0D);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((AbstractC18174oC7) obj));
        }
    }

    /* renamed from: ir.nasim.Sy7$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        public final boolean a(AbstractC18174oC7 abstractC18174oC7) {
            AbstractC13042fc3.i(abstractC18174oC7, "it");
            MU0 mu0D = abstractC18174oC7.K0().t();
            if (mu0D == null) {
                return false;
            }
            return (mu0D instanceof InterfaceC7722Sx7) || (mu0D instanceof InterfaceC22882vy7);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((AbstractC18174oC7) obj));
        }
    }

    public static final InterfaceC3932Cy7 a(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        return new C4400Ey7(abstractC4099Dr3);
    }

    public static final boolean b(AbstractC4099Dr3 abstractC4099Dr3, UA2 ua2) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC13042fc3.i(ua2, "predicate");
        return AbstractC7497Ry7.c(abstractC4099Dr3, ua2);
    }

    public static final boolean c(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        return b(abstractC4099Dr3, a.e);
    }

    public static final InterfaceC3932Cy7 d(AbstractC4099Dr3 abstractC4099Dr3, KQ7 kq7, InterfaceC22882vy7 interfaceC22882vy7) {
        AbstractC13042fc3.i(abstractC4099Dr3, "type");
        AbstractC13042fc3.i(kq7, "projectionKind");
        if ((interfaceC22882vy7 == null ? null : interfaceC22882vy7.m()) == kq7) {
            kq7 = KQ7.INVARIANT;
        }
        return new C4400Ey7(kq7, abstractC4099Dr3);
    }

    public static final AbstractC19738qr3 e(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC19738qr3 abstractC19738qr3N = abstractC4099Dr3.K0().n();
        AbstractC13042fc3.h(abstractC19738qr3N, "constructor.builtIns");
        return abstractC19738qr3N;
    }

    public static final AbstractC4099Dr3 f(InterfaceC22882vy7 interfaceC22882vy7) {
        Object obj;
        AbstractC13042fc3.i(interfaceC22882vy7, "<this>");
        List upperBounds = interfaceC22882vy7.getUpperBounds();
        AbstractC13042fc3.h(upperBounds, "upperBounds");
        upperBounds.isEmpty();
        List upperBounds2 = interfaceC22882vy7.getUpperBounds();
        AbstractC13042fc3.h(upperBounds2, "upperBounds");
        Iterator it = upperBounds2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MU0 mu0D = ((AbstractC4099Dr3) next).K0().t();
            InterfaceC21331tU0 interfaceC21331tU0 = mu0D instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) mu0D : null;
            if (interfaceC21331tU0 != null && interfaceC21331tU0.f() != AU0.INTERFACE && interfaceC21331tU0.f() != AU0.ANNOTATION_CLASS) {
                obj = next;
                break;
            }
        }
        AbstractC4099Dr3 abstractC4099Dr3 = (AbstractC4099Dr3) obj;
        if (abstractC4099Dr3 != null) {
            return abstractC4099Dr3;
        }
        List upperBounds3 = interfaceC22882vy7.getUpperBounds();
        AbstractC13042fc3.h(upperBounds3, "upperBounds");
        Object objQ0 = AbstractC15401jX0.q0(upperBounds3);
        AbstractC13042fc3.h(objQ0, "upperBounds.first()");
        return (AbstractC4099Dr3) objQ0;
    }

    public static final boolean g(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC13042fc3.i(abstractC4099Dr32, "superType");
        return InterfaceC4333Er3.a.b(abstractC4099Dr3, abstractC4099Dr32);
    }

    public static final boolean h(MU0 mu0) {
        AbstractC13042fc3.i(mu0, "<this>");
        return (mu0 instanceof InterfaceC22882vy7) && (((InterfaceC22882vy7) mu0).b() instanceof InterfaceC7722Sx7);
    }

    public static final boolean i(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        return AbstractC7497Ry7.m(abstractC4099Dr3);
    }

    public static final AbstractC4099Dr3 j(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC4099Dr3 abstractC4099Dr3N = AbstractC7497Ry7.n(abstractC4099Dr3);
        AbstractC13042fc3.h(abstractC4099Dr3N, "makeNotNullable(this)");
        return abstractC4099Dr3N;
    }

    public static final AbstractC4099Dr3 k(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC4099Dr3 abstractC4099Dr3O = AbstractC7497Ry7.o(abstractC4099Dr3);
        AbstractC13042fc3.h(abstractC4099Dr3O, "makeNullable(this)");
        return abstractC4099Dr3O;
    }

    public static final AbstractC4099Dr3 l(AbstractC4099Dr3 abstractC4099Dr3, InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        return (abstractC4099Dr3.getAnnotations().isEmpty() && interfaceC4356Eu.isEmpty()) ? abstractC4099Dr3 : abstractC4099Dr3.N0().Q0(interfaceC4356Eu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [ir.nasim.oC7] */
    public static final AbstractC4099Dr3 m(AbstractC4099Dr3 abstractC4099Dr3) {
        XC6 xc6F;
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC18174oC7 abstractC18174oC7N0 = abstractC4099Dr3.N0();
        if (abstractC18174oC7N0 instanceof AbstractC6200Mp2) {
            C4567Fr3 c4567Fr3 = C4567Fr3.a;
            AbstractC6200Mp2 abstractC6200Mp2 = (AbstractC6200Mp2) abstractC18174oC7N0;
            XC6 xc6S0 = abstractC6200Mp2.S0();
            if (!xc6S0.K0().getParameters().isEmpty() && xc6S0.K0().t() != null) {
                List parameters = xc6S0.K0().getParameters();
                AbstractC13042fc3.h(parameters, "constructor.parameters");
                List list = parameters;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new RJ6((InterfaceC22882vy7) it.next()));
                }
                xc6S0 = AbstractC5351Iy7.f(xc6S0, arrayList, null, 2, null);
            }
            XC6 xc6T0 = abstractC6200Mp2.T0();
            if (!xc6T0.K0().getParameters().isEmpty() && xc6T0.K0().t() != null) {
                List parameters2 = xc6T0.K0().getParameters();
                AbstractC13042fc3.h(parameters2, "constructor.parameters");
                List list2 = parameters2;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new RJ6((InterfaceC22882vy7) it2.next()));
                }
                xc6T0 = AbstractC5351Iy7.f(xc6T0, arrayList2, null, 2, null);
            }
            xc6F = C4567Fr3.d(xc6S0, xc6T0);
        } else {
            if (!(abstractC18174oC7N0 instanceof XC6)) {
                throw new NoWhenBranchMatchedException();
            }
            XC6 xc6 = (XC6) abstractC18174oC7N0;
            boolean zIsEmpty = xc6.K0().getParameters().isEmpty();
            xc6F = xc6;
            if (!zIsEmpty) {
                MU0 mu0D = xc6.K0().t();
                xc6F = xc6;
                if (mu0D != null) {
                    List parameters3 = xc6.K0().getParameters();
                    AbstractC13042fc3.h(parameters3, "constructor.parameters");
                    List list3 = parameters3;
                    ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(list3, 10));
                    Iterator it3 = list3.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(new RJ6((InterfaceC22882vy7) it3.next()));
                    }
                    xc6F = AbstractC5351Iy7.f(xc6, arrayList3, null, 2, null);
                }
            }
        }
        return AbstractC8692Wy7.b(xc6F, abstractC18174oC7N0);
    }

    public static final boolean n(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        return b(abstractC4099Dr3, b.e);
    }
}
