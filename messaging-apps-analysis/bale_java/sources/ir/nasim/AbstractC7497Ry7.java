package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Ry7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7497Ry7 {
    public static final XC6 a = AbstractC14230ha2.p("DONT_CARE");
    public static final XC6 b = AbstractC14230ha2.j("Cannot be inferred");
    public static final XC6 c = new a("NO_EXPECTED_TYPE");
    public static final XC6 d = new a("UNIT_EXPECTED_TYPE");

    /* renamed from: ir.nasim.Ry7$a */
    public static class a extends TG1 {
        private final String b;

        public a(String str) {
            this.b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static /* synthetic */ void W0(int r9) {
            /*
                r0 = 4
                r1 = 1
                if (r9 == r1) goto L9
                if (r9 == r0) goto L9
                java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto Lb
            L9:
                java.lang.String r2 = "@NotNull method %s.%s must not return null"
            Lb:
                r3 = 3
                r4 = 2
                if (r9 == r1) goto L13
                if (r9 == r0) goto L13
                r5 = r3
                goto L14
            L13:
                r5 = r4
            L14:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType"
                r7 = 0
                if (r9 == r1) goto L30
                if (r9 == r4) goto L2b
                if (r9 == r3) goto L26
                if (r9 == r0) goto L30
                java.lang.String r8 = "newAnnotations"
                r5[r7] = r8
                goto L32
            L26:
                java.lang.String r8 = "kotlinTypeRefiner"
                r5[r7] = r8
                goto L32
            L2b:
                java.lang.String r8 = "delegate"
                r5[r7] = r8
                goto L32
            L30:
                r5[r7] = r6
            L32:
                java.lang.String r7 = "refine"
                if (r9 == r1) goto L3e
                if (r9 == r0) goto L3b
                r5[r1] = r6
                goto L42
            L3b:
                r5[r1] = r7
                goto L42
            L3e:
                java.lang.String r6 = "toString"
                r5[r1] = r6
            L42:
                if (r9 == r1) goto L56
                if (r9 == r4) goto L52
                if (r9 == r3) goto L4f
                if (r9 == r0) goto L56
                java.lang.String r3 = "replaceAnnotations"
                r5[r4] = r3
                goto L56
            L4f:
                r5[r4] = r7
                goto L56
            L52:
                java.lang.String r3 = "replaceDelegate"
                r5[r4] = r3
            L56:
                java.lang.String r2 = java.lang.String.format(r2, r5)
                if (r9 == r1) goto L64
                if (r9 == r0) goto L64
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>(r2)
                goto L69
            L64:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                r9.<init>(r2)
            L69:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7497Ry7.a.W0(int):void");
        }

        @Override // ir.nasim.AbstractC18174oC7
        /* renamed from: R0, reason: merged with bridge method [inline-methods] */
        public XC6 O0(boolean z) {
            throw new IllegalStateException(this.b);
        }

        @Override // ir.nasim.AbstractC18174oC7
        /* renamed from: S0, reason: merged with bridge method [inline-methods] */
        public XC6 Q0(InterfaceC4356Eu interfaceC4356Eu) {
            if (interfaceC4356Eu == null) {
                W0(0);
            }
            throw new IllegalStateException(this.b);
        }

        @Override // ir.nasim.TG1
        protected XC6 T0() {
            throw new IllegalStateException(this.b);
        }

        @Override // ir.nasim.TG1
        public TG1 V0(XC6 xc6) {
            if (xc6 == null) {
                W0(2);
            }
            throw new IllegalStateException(this.b);
        }

        @Override // ir.nasim.TG1
        /* renamed from: X0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a U0(AbstractC5284Ir3 abstractC5284Ir3) {
            if (abstractC5284Ir3 == null) {
                W0(3);
            }
            return this;
        }

        @Override // ir.nasim.XC6
        public String toString() {
            String str = this.b;
            if (str == null) {
                W0(1);
            }
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void a(int r24) {
        /*
            Method dump skipped, instructions count: 776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7497Ry7.a(int):void");
    }

    public static boolean b(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(28);
        }
        if (abstractC4099Dr3.L0()) {
            return true;
        }
        return AbstractC7411Rp2.b(abstractC4099Dr3) && b(AbstractC7411Rp2.a(abstractC4099Dr3).T0());
    }

    public static boolean c(AbstractC4099Dr3 abstractC4099Dr3, UA2 ua2) {
        if (ua2 == null) {
            a(43);
        }
        return d(abstractC4099Dr3, ua2, null);
    }

    private static boolean d(AbstractC4099Dr3 abstractC4099Dr3, UA2 ua2, DE6 de6) {
        if (ua2 == null) {
            a(44);
        }
        if (abstractC4099Dr3 == null) {
            return false;
        }
        AbstractC18174oC7 abstractC18174oC7N0 = abstractC4099Dr3.N0();
        if (v(abstractC4099Dr3)) {
            return ((Boolean) ua2.invoke(abstractC18174oC7N0)).booleanValue();
        }
        if (de6 != null && de6.contains(abstractC4099Dr3)) {
            return false;
        }
        if (((Boolean) ua2.invoke(abstractC18174oC7N0)).booleanValue()) {
            return true;
        }
        if (de6 == null) {
            de6 = DE6.f();
        }
        de6.add(abstractC4099Dr3);
        AbstractC6200Mp2 abstractC6200Mp2 = abstractC18174oC7N0 instanceof AbstractC6200Mp2 ? (AbstractC6200Mp2) abstractC18174oC7N0 : null;
        if (abstractC6200Mp2 != null && (d(abstractC6200Mp2.S0(), ua2, de6) || d(abstractC6200Mp2.T0(), ua2, de6))) {
            return true;
        }
        if ((abstractC18174oC7N0 instanceof DG1) && d(((DG1) abstractC18174oC7N0).W0(), ua2, de6)) {
            return true;
        }
        InterfaceC13882gy7 interfaceC13882gy7K0 = abstractC4099Dr3.K0();
        if (interfaceC13882gy7K0 instanceof C7993Ub3) {
            Iterator it = ((C7993Ub3) interfaceC13882gy7K0).b().iterator();
            while (it.hasNext()) {
                if (d((AbstractC4099Dr3) it.next(), ua2, de6)) {
                    return true;
                }
            }
            return false;
        }
        for (InterfaceC3932Cy7 interfaceC3932Cy7 : abstractC4099Dr3.J0()) {
            if (!interfaceC3932Cy7.b() && d(interfaceC3932Cy7.getType(), ua2, de6)) {
                return true;
            }
        }
        return false;
    }

    public static AbstractC4099Dr3 e(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32, C5585Jy7 c5585Jy7) {
        if (abstractC4099Dr3 == null) {
            a(20);
        }
        if (abstractC4099Dr32 == null) {
            a(21);
        }
        if (c5585Jy7 == null) {
            a(22);
        }
        AbstractC4099Dr3 abstractC4099Dr3P = c5585Jy7.p(abstractC4099Dr32, KQ7.INVARIANT);
        if (abstractC4099Dr3P != null) {
            return q(abstractC4099Dr3P, abstractC4099Dr3.L0());
        }
        return null;
    }

    public static InterfaceC21331tU0 f(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(30);
        }
        MU0 mu0D = abstractC4099Dr3.K0().t();
        if (mu0D instanceof InterfaceC21331tU0) {
            return (InterfaceC21331tU0) mu0D;
        }
        return null;
    }

    public static List g(List list) {
        if (list == null) {
            a(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new C4400Ey7(((InterfaceC22882vy7) it.next()).p()));
        }
        List listM1 = AbstractC15401jX0.m1(arrayList);
        if (listM1 == null) {
            a(17);
        }
        return listM1;
    }

    public static List h(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(18);
        }
        C5585Jy7 c5585Jy7F = C5585Jy7.f(abstractC4099Dr3);
        Collection collectionB = abstractC4099Dr3.K0().b();
        ArrayList arrayList = new ArrayList(collectionB.size());
        Iterator it = collectionB.iterator();
        while (it.hasNext()) {
            AbstractC4099Dr3 abstractC4099Dr3E = e(abstractC4099Dr3, (AbstractC4099Dr3) it.next(), c5585Jy7F);
            if (abstractC4099Dr3E != null) {
                arrayList.add(abstractC4099Dr3E);
            }
        }
        return arrayList;
    }

    public static InterfaceC22882vy7 i(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(62);
        }
        if (abstractC4099Dr3.K0().t() instanceof InterfaceC22882vy7) {
            return (InterfaceC22882vy7) abstractC4099Dr3.K0().t();
        }
        return null;
    }

    public static boolean j(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(29);
        }
        if (abstractC4099Dr3.K0().t() instanceof InterfaceC21331tU0) {
            return false;
        }
        Iterator it = h(abstractC4099Dr3).iterator();
        while (it.hasNext()) {
            if (l((AbstractC4099Dr3) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(AbstractC4099Dr3 abstractC4099Dr3) {
        return abstractC4099Dr3 != null && abstractC4099Dr3.K0() == a.K0();
    }

    public static boolean l(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(27);
        }
        if (abstractC4099Dr3.L0()) {
            return true;
        }
        if (AbstractC7411Rp2.b(abstractC4099Dr3) && l(AbstractC7411Rp2.a(abstractC4099Dr3).T0())) {
            return true;
        }
        if (AbstractC24252yI6.c(abstractC4099Dr3)) {
            return false;
        }
        if (m(abstractC4099Dr3)) {
            return j(abstractC4099Dr3);
        }
        InterfaceC13882gy7 interfaceC13882gy7K0 = abstractC4099Dr3.K0();
        if (interfaceC13882gy7K0 instanceof C7993Ub3) {
            Iterator it = interfaceC13882gy7K0.b().iterator();
            while (it.hasNext()) {
                if (l((AbstractC4099Dr3) it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(59);
        }
        if (i(abstractC4099Dr3) != null) {
            return true;
        }
        abstractC4099Dr3.K0();
        return false;
    }

    public static AbstractC4099Dr3 n(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(2);
        }
        return p(abstractC4099Dr3, false);
    }

    public static AbstractC4099Dr3 o(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(1);
        }
        return p(abstractC4099Dr3, true);
    }

    public static AbstractC4099Dr3 p(AbstractC4099Dr3 abstractC4099Dr3, boolean z) {
        if (abstractC4099Dr3 == null) {
            a(3);
        }
        AbstractC18174oC7 abstractC18174oC7O0 = abstractC4099Dr3.N0().O0(z);
        if (abstractC18174oC7O0 == null) {
            a(4);
        }
        return abstractC18174oC7O0;
    }

    public static AbstractC4099Dr3 q(AbstractC4099Dr3 abstractC4099Dr3, boolean z) {
        if (abstractC4099Dr3 == null) {
            a(8);
        }
        if (z) {
            return o(abstractC4099Dr3);
        }
        if (abstractC4099Dr3 == null) {
            a(9);
        }
        return abstractC4099Dr3;
    }

    public static XC6 r(XC6 xc6, boolean z) {
        if (xc6 == null) {
            a(5);
        }
        if (!z) {
            if (xc6 == null) {
                a(7);
            }
            return xc6;
        }
        XC6 xc6O0 = xc6.O0(true);
        if (xc6O0 == null) {
            a(6);
        }
        return xc6O0;
    }

    public static InterfaceC3932Cy7 s(InterfaceC22882vy7 interfaceC22882vy7) {
        if (interfaceC22882vy7 == null) {
            a(45);
        }
        return new RJ6(interfaceC22882vy7);
    }

    public static XC6 t(MU0 mu0, W24 w24, UA2 ua2) {
        if (!AbstractC14230ha2.r(mu0)) {
            return u(mu0.j(), w24, ua2);
        }
        XC6 xc6J = AbstractC14230ha2.j("Unsubstituted type for " + mu0);
        if (xc6J == null) {
            a(11);
        }
        return xc6J;
    }

    public static XC6 u(InterfaceC13882gy7 interfaceC13882gy7, W24 w24, UA2 ua2) {
        if (interfaceC13882gy7 == null) {
            a(12);
        }
        if (w24 == null) {
            a(13);
        }
        if (ua2 == null) {
            a(14);
        }
        XC6 xc6K = C4567Fr3.k(InterfaceC4356Eu.W.b(), interfaceC13882gy7, g(interfaceC13882gy7.getParameters()), false, w24, ua2);
        if (xc6K == null) {
            a(15);
        }
        return xc6K;
    }

    public static boolean v(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(0);
        }
        return abstractC4099Dr3 == c || abstractC4099Dr3 == d;
    }
}
