package ir.nasim;

import ir.nasim.InterfaceC8429Vx7;
import ir.nasim.W24;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Tx7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7961Tx7 {
    public static final a c = new a(null);
    private static final C7961Tx7 d = new C7961Tx7(InterfaceC8429Vx7.a.a, false);
    private final InterfaceC8429Vx7 a;
    private final boolean b;

    /* renamed from: ir.nasim.Tx7$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i, InterfaceC7722Sx7 interfaceC7722Sx7) {
            if (i > 100) {
                throw new AssertionError(AbstractC13042fc3.q("Too deep recursion while expanding type alias ", interfaceC7722Sx7.getName()));
            }
        }

        public final void c(InterfaceC8429Vx7 interfaceC8429Vx7, AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32, InterfaceC22882vy7 interfaceC22882vy7, C5585Jy7 c5585Jy7) {
            AbstractC13042fc3.i(interfaceC8429Vx7, "reportStrategy");
            AbstractC13042fc3.i(abstractC4099Dr3, "unsubstitutedArgument");
            AbstractC13042fc3.i(abstractC4099Dr32, "typeArgument");
            AbstractC13042fc3.i(interfaceC22882vy7, "typeParameterDescriptor");
            AbstractC13042fc3.i(c5585Jy7, "substitutor");
            Iterator it = interfaceC22882vy7.getUpperBounds().iterator();
            while (it.hasNext()) {
                AbstractC4099Dr3 abstractC4099Dr3N = c5585Jy7.n((AbstractC4099Dr3) it.next(), KQ7.INVARIANT);
                AbstractC13042fc3.h(abstractC4099Dr3N, "substitutor.safeSubstitute(bound, Variance.INVARIANT)");
                if (!InterfaceC4333Er3.a.b(abstractC4099Dr32, abstractC4099Dr3N)) {
                    interfaceC8429Vx7.b(abstractC4099Dr3N, abstractC4099Dr3, abstractC4099Dr32, interfaceC22882vy7);
                }
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C7961Tx7(InterfaceC8429Vx7 interfaceC8429Vx7, boolean z) {
        AbstractC13042fc3.i(interfaceC8429Vx7, "reportStrategy");
        this.a = interfaceC8429Vx7;
        this.b = z;
    }

    private final void a(InterfaceC4356Eu interfaceC4356Eu, InterfaceC4356Eu interfaceC4356Eu2) {
        HashSet hashSet = new HashSet();
        Iterator it = interfaceC4356Eu.iterator();
        while (it.hasNext()) {
            hashSet.add(((InterfaceC21651tu) it.next()).e());
        }
        Iterator it2 = interfaceC4356Eu2.iterator();
        while (it2.hasNext()) {
            InterfaceC21651tu interfaceC21651tu = (InterfaceC21651tu) it2.next();
            if (hashSet.contains(interfaceC21651tu.e())) {
                this.a.a(interfaceC21651tu);
            }
        }
    }

    private final void b(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32) {
        C5585Jy7 c5585Jy7F = C5585Jy7.f(abstractC4099Dr32);
        AbstractC13042fc3.h(c5585Jy7F, "create(substitutedType)");
        int i = 0;
        for (Object obj : abstractC4099Dr32.J0()) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            InterfaceC3932Cy7 interfaceC3932Cy7 = (InterfaceC3932Cy7) obj;
            if (!interfaceC3932Cy7.b()) {
                AbstractC4099Dr3 type = interfaceC3932Cy7.getType();
                AbstractC13042fc3.h(type, "substitutedArgument.type");
                if (!AbstractC7731Sy7.c(type)) {
                    InterfaceC3932Cy7 interfaceC3932Cy72 = (InterfaceC3932Cy7) abstractC4099Dr3.J0().get(i);
                    InterfaceC22882vy7 interfaceC22882vy7 = (InterfaceC22882vy7) abstractC4099Dr3.K0().getParameters().get(i);
                    if (this.b) {
                        a aVar = c;
                        InterfaceC8429Vx7 interfaceC8429Vx7 = this.a;
                        AbstractC4099Dr3 type2 = interfaceC3932Cy72.getType();
                        AbstractC13042fc3.h(type2, "unsubstitutedArgument.type");
                        AbstractC4099Dr3 type3 = interfaceC3932Cy7.getType();
                        AbstractC13042fc3.h(type3, "substitutedArgument.type");
                        AbstractC13042fc3.h(interfaceC22882vy7, "typeParameter");
                        aVar.c(interfaceC8429Vx7, type2, type3, interfaceC22882vy7, c5585Jy7F);
                    }
                }
            }
            i = i2;
        }
    }

    private final XC6 c(XC6 xc6, InterfaceC4356Eu interfaceC4356Eu) {
        return AbstractC4816Gr3.a(xc6) ? xc6 : AbstractC5351Iy7.f(xc6, null, g(xc6, interfaceC4356Eu), 1, null);
    }

    private final XC6 d(XC6 xc6, AbstractC4099Dr3 abstractC4099Dr3) {
        XC6 xc6R = AbstractC7497Ry7.r(xc6, abstractC4099Dr3.L0());
        AbstractC13042fc3.h(xc6R, "makeNullableIfNeeded(this, fromType.isMarkedNullable)");
        return xc6R;
    }

    private final XC6 e(XC6 xc6, AbstractC4099Dr3 abstractC4099Dr3) {
        return c(d(xc6, abstractC4099Dr3), abstractC4099Dr3.getAnnotations());
    }

    private final XC6 f(C8195Ux7 c8195Ux7, InterfaceC4356Eu interfaceC4356Eu, boolean z) {
        C4567Fr3 c4567Fr3 = C4567Fr3.a;
        InterfaceC13882gy7 interfaceC13882gy7J = c8195Ux7.b().j();
        AbstractC13042fc3.h(interfaceC13882gy7J, "descriptor.typeConstructor");
        return C4567Fr3.j(interfaceC4356Eu, interfaceC13882gy7J, c8195Ux7.a(), z, W24.b.b);
    }

    private final InterfaceC4356Eu g(AbstractC4099Dr3 abstractC4099Dr3, InterfaceC4356Eu interfaceC4356Eu) {
        return AbstractC4816Gr3.a(abstractC4099Dr3) ? abstractC4099Dr3.getAnnotations() : AbstractC4839Gu.a(interfaceC4356Eu, abstractC4099Dr3.getAnnotations());
    }

    private final InterfaceC3932Cy7 i(InterfaceC3932Cy7 interfaceC3932Cy7, C8195Ux7 c8195Ux7, int i) {
        AbstractC18174oC7 abstractC18174oC7N0 = interfaceC3932Cy7.getType().N0();
        if (AbstractC21730u22.a(abstractC18174oC7N0)) {
            return interfaceC3932Cy7;
        }
        XC6 xc6A = AbstractC5351Iy7.a(abstractC18174oC7N0);
        if (AbstractC4816Gr3.a(xc6A) || !AbstractC7731Sy7.n(xc6A)) {
            return interfaceC3932Cy7;
        }
        InterfaceC13882gy7 interfaceC13882gy7K0 = xc6A.K0();
        MU0 mu0T = interfaceC13882gy7K0.t();
        interfaceC13882gy7K0.getParameters().size();
        xc6A.J0().size();
        if (mu0T instanceof InterfaceC22882vy7) {
            return interfaceC3932Cy7;
        }
        if (!(mu0T instanceof InterfaceC7722Sx7)) {
            XC6 xc6L = l(xc6A, c8195Ux7, i);
            b(xc6A, xc6L);
            return new C4400Ey7(interfaceC3932Cy7.c(), xc6L);
        }
        InterfaceC7722Sx7 interfaceC7722Sx7 = (InterfaceC7722Sx7) mu0T;
        if (c8195Ux7.d(interfaceC7722Sx7)) {
            this.a.d(interfaceC7722Sx7);
            return new C4400Ey7(KQ7.INVARIANT, AbstractC14230ha2.j(AbstractC13042fc3.q("Recursive type alias: ", interfaceC7722Sx7.getName())));
        }
        List listJ0 = xc6A.J0();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listJ0, 10));
        int i2 = 0;
        for (Object obj : listJ0) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                AbstractC10360bX0.w();
            }
            arrayList.add(k((InterfaceC3932Cy7) obj, c8195Ux7, (InterfaceC22882vy7) interfaceC13882gy7K0.getParameters().get(i2), i + 1));
            i2 = i3;
        }
        XC6 xc6J = j(C8195Ux7.e.a(c8195Ux7, interfaceC7722Sx7, arrayList), xc6A.getAnnotations(), xc6A.L0(), i + 1, false);
        XC6 xc6L2 = l(xc6A, c8195Ux7, i);
        if (!AbstractC21730u22.a(xc6J)) {
            xc6J = AbstractC24252yI6.j(xc6J, xc6L2);
        }
        return new C4400Ey7(interfaceC3932Cy7.c(), xc6J);
    }

    private final XC6 j(C8195Ux7 c8195Ux7, InterfaceC4356Eu interfaceC4356Eu, boolean z, int i, boolean z2) {
        InterfaceC3932Cy7 interfaceC3932Cy7K = k(new C4400Ey7(KQ7.INVARIANT, c8195Ux7.b().t0()), c8195Ux7, null, i);
        AbstractC4099Dr3 type = interfaceC3932Cy7K.getType();
        AbstractC13042fc3.h(type, "expandedProjection.type");
        XC6 xc6A = AbstractC5351Iy7.a(type);
        if (AbstractC4816Gr3.a(xc6A)) {
            return xc6A;
        }
        interfaceC3932Cy7K.c();
        a(xc6A.getAnnotations(), interfaceC4356Eu);
        XC6 xc6R = AbstractC7497Ry7.r(c(xc6A, interfaceC4356Eu), z);
        AbstractC13042fc3.h(xc6R, "expandedType.combineAnnotations(annotations).let { TypeUtils.makeNullableIfNeeded(it, isNullable) }");
        return z2 ? AbstractC24252yI6.j(xc6R, f(c8195Ux7, interfaceC4356Eu, z)) : xc6R;
    }

    private final InterfaceC3932Cy7 k(InterfaceC3932Cy7 interfaceC3932Cy7, C8195Ux7 c8195Ux7, InterfaceC22882vy7 interfaceC22882vy7, int i) {
        KQ7 kq7;
        KQ7 kq72;
        c.b(i, c8195Ux7.b());
        if (interfaceC3932Cy7.b()) {
            AbstractC13042fc3.f(interfaceC22882vy7);
            InterfaceC3932Cy7 interfaceC3932Cy7S = AbstractC7497Ry7.s(interfaceC22882vy7);
            AbstractC13042fc3.h(interfaceC3932Cy7S, "makeStarProjection(typeParameterDescriptor!!)");
            return interfaceC3932Cy7S;
        }
        AbstractC4099Dr3 type = interfaceC3932Cy7.getType();
        AbstractC13042fc3.h(type, "underlyingProjection.type");
        InterfaceC3932Cy7 interfaceC3932Cy7C = c8195Ux7.c(type.K0());
        if (interfaceC3932Cy7C == null) {
            return i(interfaceC3932Cy7, c8195Ux7, i);
        }
        if (interfaceC3932Cy7C.b()) {
            AbstractC13042fc3.f(interfaceC22882vy7);
            InterfaceC3932Cy7 interfaceC3932Cy7S2 = AbstractC7497Ry7.s(interfaceC22882vy7);
            AbstractC13042fc3.h(interfaceC3932Cy7S2, "makeStarProjection(typeParameterDescriptor!!)");
            return interfaceC3932Cy7S2;
        }
        AbstractC18174oC7 abstractC18174oC7N0 = interfaceC3932Cy7C.getType().N0();
        KQ7 kq7C = interfaceC3932Cy7C.c();
        AbstractC13042fc3.h(kq7C, "argument.projectionKind");
        KQ7 kq7C2 = interfaceC3932Cy7.c();
        AbstractC13042fc3.h(kq7C2, "underlyingProjection.projectionKind");
        if (kq7C2 != kq7C && kq7C2 != (kq72 = KQ7.INVARIANT)) {
            if (kq7C == kq72) {
                kq7C = kq7C2;
            } else {
                this.a.c(c8195Ux7.b(), interfaceC22882vy7, abstractC18174oC7N0);
            }
        }
        KQ7 kq7M = interfaceC22882vy7 == null ? null : interfaceC22882vy7.m();
        if (kq7M == null) {
            kq7M = KQ7.INVARIANT;
        }
        AbstractC13042fc3.h(kq7M, "typeParameterDescriptor?.variance ?: Variance.INVARIANT");
        if (kq7M != kq7C && kq7M != (kq7 = KQ7.INVARIANT)) {
            if (kq7C == kq7) {
                kq7C = kq7;
            } else {
                this.a.c(c8195Ux7.b(), interfaceC22882vy7, abstractC18174oC7N0);
            }
        }
        a(type.getAnnotations(), abstractC18174oC7N0.getAnnotations());
        return new C4400Ey7(kq7C, e(AbstractC5351Iy7.a(abstractC18174oC7N0), type));
    }

    private final XC6 l(XC6 xc6, C8195Ux7 c8195Ux7, int i) {
        InterfaceC13882gy7 interfaceC13882gy7K0 = xc6.K0();
        List listJ0 = xc6.J0();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listJ0, 10));
        int i2 = 0;
        for (Object obj : listJ0) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                AbstractC10360bX0.w();
            }
            InterfaceC3932Cy7 interfaceC3932Cy7 = (InterfaceC3932Cy7) obj;
            InterfaceC3932Cy7 interfaceC3932Cy7K = k(interfaceC3932Cy7, c8195Ux7, (InterfaceC22882vy7) interfaceC13882gy7K0.getParameters().get(i2), i + 1);
            if (!interfaceC3932Cy7K.b()) {
                interfaceC3932Cy7K = new C4400Ey7(interfaceC3932Cy7K.c(), AbstractC7497Ry7.q(interfaceC3932Cy7K.getType(), interfaceC3932Cy7.getType().L0()));
            }
            arrayList.add(interfaceC3932Cy7K);
            i2 = i3;
        }
        return AbstractC5351Iy7.f(xc6, arrayList, null, 2, null);
    }

    public final XC6 h(C8195Ux7 c8195Ux7, InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(c8195Ux7, "typeAliasExpansion");
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        return j(c8195Ux7, interfaceC4356Eu, false, 0, true);
    }
}
