package ir.nasim;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Pi3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6871Pi3 {
    private final InterfaceC4018Di3 a;

    /* renamed from: ir.nasim.Pi3$a */
    private static class a {
        private final AbstractC4099Dr3 a;
        private final int b;
        private final boolean c;

        public a(AbstractC4099Dr3 abstractC4099Dr3, int i, boolean z) {
            AbstractC13042fc3.i(abstractC4099Dr3, "type");
            this.a = abstractC4099Dr3;
            this.b = i;
            this.c = z;
        }

        public final int a() {
            return this.b;
        }

        public AbstractC4099Dr3 b() {
            return this.a;
        }

        public final AbstractC4099Dr3 c() {
            AbstractC4099Dr3 abstractC4099Dr3B = b();
            if (d()) {
                return abstractC4099Dr3B;
            }
            return null;
        }

        public final boolean d() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.Pi3$b */
    private static final class b extends a {
        private final XC6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(XC6 xc6, int i, boolean z) {
            super(xc6, i, z);
            AbstractC13042fc3.i(xc6, "type");
            this.d = xc6;
        }

        @Override // ir.nasim.C6871Pi3.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public XC6 b() {
            return this.d;
        }
    }

    public C6871Pi3(InterfaceC4018Di3 interfaceC4018Di3) {
        AbstractC13042fc3.i(interfaceC4018Di3, "javaResolverSettings");
        this.a = interfaceC4018Di3;
    }

    private final AbstractC4099Dr3 a(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32) {
        AbstractC4099Dr3 abstractC4099Dr3A = AbstractC8692Wy7.a(abstractC4099Dr32);
        AbstractC4099Dr3 abstractC4099Dr3A2 = AbstractC8692Wy7.a(abstractC4099Dr3);
        if (abstractC4099Dr3A2 == null) {
            if (abstractC4099Dr3A == null) {
                return null;
            }
            abstractC4099Dr3A2 = abstractC4099Dr3A;
        }
        if (abstractC4099Dr3A == null) {
            return abstractC4099Dr3A2;
        }
        C4567Fr3 c4567Fr3 = C4567Fr3.a;
        return C4567Fr3.d(AbstractC7411Rp2.c(abstractC4099Dr3A2), AbstractC7411Rp2.d(abstractC4099Dr3A));
    }

    private final b c(XC6 xc6, UA2 ua2, int i, EnumC12655ey7 enumC12655ey7, boolean z) {
        InterfaceC3932Cy7 interfaceC3932Cy7D;
        if (!AbstractC13291fy7.a(enumC12655ey7) && xc6.J0().isEmpty()) {
            return new b(xc6, 1, false);
        }
        MU0 mu0T = xc6.K0().t();
        if (mu0T == null) {
            return new b(xc6, 1, false);
        }
        C8056Ui3 c8056Ui3 = (C8056Ui3) ua2.invoke(Integer.valueOf(i));
        Y82 y82E = AbstractC18037ny7.e(mu0T, c8056Ui3, enumC12655ey7);
        MU0 mu0 = (MU0) y82E.a();
        InterfaceC4356Eu interfaceC4356EuB = y82E.b();
        InterfaceC13882gy7 interfaceC13882gy7J = mu0.j();
        AbstractC13042fc3.h(interfaceC13882gy7J, "enhancedClassifier.typeConstructor");
        int iA = i + 1;
        boolean z2 = interfaceC4356EuB != null;
        List listJ0 = xc6.J0();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listJ0, 10));
        int i2 = 0;
        for (Object obj : listJ0) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                AbstractC10360bX0.w();
            }
            InterfaceC3932Cy7 interfaceC3932Cy7 = (InterfaceC3932Cy7) obj;
            if (interfaceC3932Cy7.b()) {
                C8056Ui3 c8056Ui32 = (C8056Ui3) ua2.invoke(Integer.valueOf(iA));
                int i4 = iA + 1;
                if (c8056Ui32.c() != EnumC14043hF4.NOT_NULL || z) {
                    interfaceC3932Cy7D = AbstractC7497Ry7.s((InterfaceC22882vy7) mu0.j().getParameters().get(i2));
                    AbstractC13042fc3.h(interfaceC3932Cy7D, "{\n                    TypeUtils.makeStarProjection(enhancedClassifier.typeConstructor.parameters[localArgIndex])\n                }");
                } else {
                    AbstractC4099Dr3 abstractC4099Dr3J = AbstractC7731Sy7.j(interfaceC3932Cy7.getType().N0());
                    KQ7 kq7C = interfaceC3932Cy7.c();
                    AbstractC13042fc3.h(kq7C, "arg.projectionKind");
                    interfaceC3932Cy7D = AbstractC7731Sy7.d(abstractC4099Dr3J, kq7C, (InterfaceC22882vy7) interfaceC13882gy7J.getParameters().get(i2));
                }
                iA = i4;
            } else {
                a aVarE = e(interfaceC3932Cy7.getType().N0(), ua2, iA);
                z2 = z2 || aVarE.d();
                iA += aVarE.a();
                AbstractC4099Dr3 abstractC4099Dr3B = aVarE.b();
                KQ7 kq7C2 = interfaceC3932Cy7.c();
                AbstractC13042fc3.h(kq7C2, "arg.projectionKind");
                interfaceC3932Cy7D = AbstractC7731Sy7.d(abstractC4099Dr3B, kq7C2, (InterfaceC22882vy7) interfaceC13882gy7J.getParameters().get(i2));
            }
            arrayList.add(interfaceC3932Cy7D);
            i2 = i3;
        }
        Y82 y82H = AbstractC18037ny7.h(xc6, c8056Ui3, enumC12655ey7);
        boolean zBooleanValue = ((Boolean) y82H.a()).booleanValue();
        InterfaceC4356Eu interfaceC4356EuB2 = y82H.b();
        int i5 = iA - i;
        if (!(z2 || interfaceC4356EuB2 != null)) {
            return new b(xc6, i5, false);
        }
        XC6 xc6I = C4567Fr3.i(AbstractC18037ny7.d(AbstractC10360bX0.r(xc6.getAnnotations(), interfaceC4356EuB, interfaceC4356EuB2)), interfaceC13882gy7J, arrayList, zBooleanValue, null, 16, null);
        AbstractC18174oC7 abstractC18174oC7D = xc6I;
        if (c8056Ui3.d()) {
            abstractC18174oC7D = f(xc6I);
        }
        if (interfaceC4356EuB2 != null && c8056Ui3.e()) {
            abstractC18174oC7D = AbstractC8692Wy7.d(xc6, abstractC18174oC7D);
        }
        return new b((XC6) abstractC18174oC7D, i5, true);
    }

    static /* synthetic */ b d(C6871Pi3 c6871Pi3, XC6 xc6, UA2 ua2, int i, EnumC12655ey7 enumC12655ey7, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        return c6871Pi3.c(xc6, ua2, i, enumC12655ey7, z);
    }

    private final a e(AbstractC18174oC7 abstractC18174oC7, UA2 ua2, int i) {
        AbstractC18174oC7 abstractC18174oC7D;
        if (AbstractC4816Gr3.a(abstractC18174oC7)) {
            return new a(abstractC18174oC7, 1, false);
        }
        if (!(abstractC18174oC7 instanceof AbstractC6200Mp2)) {
            if (abstractC18174oC7 instanceof XC6) {
                return d(this, (XC6) abstractC18174oC7, ua2, i, EnumC12655ey7.INFLEXIBLE, false, 8, null);
            }
            throw new NoWhenBranchMatchedException();
        }
        boolean z = abstractC18174oC7 instanceof EG5;
        AbstractC6200Mp2 abstractC6200Mp2 = (AbstractC6200Mp2) abstractC18174oC7;
        b bVarC = c(abstractC6200Mp2.S0(), ua2, i, EnumC12655ey7.FLEXIBLE_LOWER, z);
        b bVarC2 = c(abstractC6200Mp2.T0(), ua2, i, EnumC12655ey7.FLEXIBLE_UPPER, z);
        bVarC.a();
        bVarC2.a();
        boolean z2 = bVarC.d() || bVarC2.d();
        AbstractC4099Dr3 abstractC4099Dr3A = a(bVarC.b(), bVarC2.b());
        if (z2) {
            if (abstractC18174oC7 instanceof FG5) {
                abstractC18174oC7D = new FG5(bVarC.b(), bVarC2.b());
            } else {
                C4567Fr3 c4567Fr3 = C4567Fr3.a;
                abstractC18174oC7D = C4567Fr3.d(bVarC.b(), bVarC2.b());
            }
            abstractC18174oC7 = AbstractC8692Wy7.d(abstractC18174oC7D, abstractC4099Dr3A);
        }
        return new a(abstractC18174oC7, bVarC.a(), z2);
    }

    private final XC6 f(XC6 xc6) {
        return this.a.a() ? AbstractC24252yI6.h(xc6, true) : new C24196yC4(xc6);
    }

    public final AbstractC4099Dr3 b(AbstractC4099Dr3 abstractC4099Dr3, UA2 ua2) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        AbstractC13042fc3.i(ua2, "qualifiers");
        return e(abstractC4099Dr3.N0(), ua2, 0).c();
    }
}
