package ir.nasim;

import ir.nasim.EY7;
import ir.nasim.InterfaceC9282Zg4;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

/* loaded from: classes8.dex */
public abstract class QI1 {
    public static final RI1 a;
    public static final RI1 b;
    public static final RI1 c;
    public static final RI1 d;
    public static final RI1 e;
    public static final RI1 f;
    public static final RI1 g;
    public static final RI1 h;
    public static final RI1 i;
    public static final Set j;
    private static final Map k;
    public static final RI1 l;
    private static final InterfaceC10239bJ5 m;
    public static final InterfaceC10239bJ5 n;
    public static final InterfaceC10239bJ5 o;
    private static final InterfaceC9282Zg4 p;
    private static final Map q;

    static class a implements InterfaceC10239bJ5 {
        a() {
        }

        @Override // ir.nasim.InterfaceC10239bJ5
        public AbstractC4099Dr3 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    static class b implements InterfaceC10239bJ5 {
        b() {
        }

        @Override // ir.nasim.InterfaceC10239bJ5
        public AbstractC4099Dr3 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    static class c implements InterfaceC10239bJ5 {
        c() {
        }

        @Override // ir.nasim.InterfaceC10239bJ5
        public AbstractC4099Dr3 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    static class d extends OG1 {
        d(GY7 gy7) {
            super(gy7);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "what";
            } else if (i != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i == 1 || i == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(InterfaceC12795fB1 interfaceC12795fB1) {
            if (interfaceC12795fB1 == null) {
                g(0);
            }
            return OI1.j(interfaceC12795fB1) != KH6.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [ir.nasim.fB1, ir.nasim.mB1] */
        /* JADX WARN: Type inference failed for: r5v1, types: [ir.nasim.fB1] */
        /* JADX WARN: Type inference failed for: r5v2, types: [ir.nasim.fB1] */
        /* JADX WARN: Type inference failed for: r5v4, types: [ir.nasim.fB1] */
        @Override // ir.nasim.RI1
        public boolean e(InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC16977mB1 interfaceC16977mB1, InterfaceC12795fB1 interfaceC12795fB1) {
            if (interfaceC16977mB1 == 0) {
                g(1);
            }
            if (interfaceC12795fB1 == null) {
                g(2);
            }
            if (OI1.J(interfaceC16977mB1) && h(interfaceC12795fB1)) {
                return QI1.f(interfaceC16977mB1, interfaceC12795fB1);
            }
            if (interfaceC16977mB1 instanceof InterfaceC21426te1) {
                NU0 nu0B = ((InterfaceC21426te1) interfaceC16977mB1).b();
                if (OI1.G(nu0B) && OI1.J(nu0B) && (interfaceC12795fB1 instanceof InterfaceC21426te1) && OI1.J(interfaceC12795fB1.b()) && QI1.f(interfaceC16977mB1, interfaceC12795fB1)) {
                    return true;
                }
            }
            while (interfaceC16977mB1 != 0) {
                interfaceC16977mB1 = interfaceC16977mB1.b();
                if (((interfaceC16977mB1 instanceof InterfaceC21331tU0) && !OI1.x(interfaceC16977mB1)) || (interfaceC16977mB1 instanceof InterfaceC24340yS4)) {
                    break;
                }
            }
            if (interfaceC16977mB1 == 0) {
                return false;
            }
            while (interfaceC12795fB1 != null) {
                if (interfaceC16977mB1 == interfaceC12795fB1) {
                    return true;
                }
                if (interfaceC12795fB1 instanceof InterfaceC24340yS4) {
                    return (interfaceC16977mB1 instanceof InterfaceC24340yS4) && interfaceC16977mB1.e().equals(((InterfaceC24340yS4) interfaceC12795fB1).e()) && OI1.b(interfaceC12795fB1, interfaceC16977mB1);
                }
                interfaceC12795fB1 = interfaceC12795fB1.b();
            }
            return false;
        }
    }

    static class e extends OG1 {
        e(GY7 gy7) {
            super(gy7);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.RI1
        public boolean e(InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC16977mB1 interfaceC16977mB1, InterfaceC12795fB1 interfaceC12795fB1) {
            InterfaceC12795fB1 interfaceC12795fB1Q;
            if (interfaceC16977mB1 == null) {
                g(0);
            }
            if (interfaceC12795fB1 == null) {
                g(1);
            }
            if (QI1.a.e(interfaceC10239bJ5, interfaceC16977mB1, interfaceC12795fB1)) {
                if (interfaceC10239bJ5 == QI1.n) {
                    return true;
                }
                if (interfaceC10239bJ5 != QI1.m && (interfaceC12795fB1Q = OI1.q(interfaceC16977mB1, InterfaceC21331tU0.class)) != null && (interfaceC10239bJ5 instanceof InterfaceC6446No7)) {
                    return ((InterfaceC6446No7) interfaceC10239bJ5).s().a().equals(interfaceC12795fB1Q.a());
                }
            }
            return false;
        }
    }

    static class f extends OG1 {
        f(GY7 gy7) {
            super(gy7);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "from";
            } else if (i == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i == 2 || i == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC16977mB1 interfaceC16977mB1, InterfaceC21331tU0 interfaceC21331tU0) {
            if (interfaceC16977mB1 == null) {
                g(2);
            }
            if (interfaceC21331tU0 == null) {
                g(3);
            }
            if (interfaceC10239bJ5 == QI1.o) {
                return false;
            }
            if (!(interfaceC16977mB1 instanceof InterfaceC15194jA0) || (interfaceC16977mB1 instanceof InterfaceC21426te1) || interfaceC10239bJ5 == QI1.n) {
                return true;
            }
            if (interfaceC10239bJ5 == QI1.m || interfaceC10239bJ5 == null) {
                return false;
            }
            AbstractC4099Dr3 type = interfaceC10239bJ5.getType();
            return OI1.I(type, interfaceC21331tU0) || AbstractC21730u22.a(type);
        }

        @Override // ir.nasim.RI1
        public boolean e(InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC16977mB1 interfaceC16977mB1, InterfaceC12795fB1 interfaceC12795fB1) {
            InterfaceC21331tU0 interfaceC21331tU0;
            if (interfaceC16977mB1 == null) {
                g(0);
            }
            if (interfaceC12795fB1 == null) {
                g(1);
            }
            InterfaceC21331tU0 interfaceC21331tU02 = (InterfaceC21331tU0) OI1.q(interfaceC16977mB1, InterfaceC21331tU0.class);
            InterfaceC21331tU0 interfaceC21331tU03 = (InterfaceC21331tU0) OI1.r(interfaceC12795fB1, InterfaceC21331tU0.class, false);
            if (interfaceC21331tU03 == null) {
                return false;
            }
            if (interfaceC21331tU02 != null && OI1.x(interfaceC21331tU02) && (interfaceC21331tU0 = (InterfaceC21331tU0) OI1.q(interfaceC21331tU02, InterfaceC21331tU0.class)) != null && OI1.H(interfaceC21331tU03, interfaceC21331tU0)) {
                return true;
            }
            InterfaceC16977mB1 interfaceC16977mB1M = OI1.M(interfaceC16977mB1);
            InterfaceC21331tU0 interfaceC21331tU04 = (InterfaceC21331tU0) OI1.q(interfaceC16977mB1M, InterfaceC21331tU0.class);
            if (interfaceC21331tU04 == null) {
                return false;
            }
            if (OI1.H(interfaceC21331tU03, interfaceC21331tU04) && h(interfaceC10239bJ5, interfaceC16977mB1M, interfaceC21331tU03)) {
                return true;
            }
            return e(interfaceC10239bJ5, interfaceC16977mB1, interfaceC21331tU03.b());
        }
    }

    static class g extends OG1 {
        g(GY7 gy7) {
            super(gy7);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.RI1
        public boolean e(InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC16977mB1 interfaceC16977mB1, InterfaceC12795fB1 interfaceC12795fB1) {
            if (interfaceC16977mB1 == null) {
                g(0);
            }
            if (interfaceC12795fB1 == null) {
                g(1);
            }
            if (OI1.g(interfaceC12795fB1).z(OI1.g(interfaceC16977mB1))) {
                return QI1.p.a(interfaceC16977mB1, interfaceC12795fB1);
            }
            return false;
        }
    }

    static class h extends OG1 {
        h(GY7 gy7) {
            super(gy7);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.RI1
        public boolean e(InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC16977mB1 interfaceC16977mB1, InterfaceC12795fB1 interfaceC12795fB1) {
            if (interfaceC16977mB1 == null) {
                g(0);
            }
            if (interfaceC12795fB1 == null) {
                g(1);
            }
            return true;
        }
    }

    static class i extends OG1 {
        i(GY7 gy7) {
            super(gy7);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.RI1
        public boolean e(InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC16977mB1 interfaceC16977mB1, InterfaceC12795fB1 interfaceC12795fB1) {
            if (interfaceC16977mB1 == null) {
                g(0);
            }
            if (interfaceC12795fB1 == null) {
                g(1);
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    }

    static class j extends OG1 {
        j(GY7 gy7) {
            super(gy7);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.RI1
        public boolean e(InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC16977mB1 interfaceC16977mB1, InterfaceC12795fB1 interfaceC12795fB1) {
            if (interfaceC16977mB1 == null) {
                g(0);
            }
            if (interfaceC12795fB1 == null) {
                g(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }
    }

    static class k extends OG1 {
        k(GY7 gy7) {
            super(gy7);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.RI1
        public boolean e(InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC16977mB1 interfaceC16977mB1, InterfaceC12795fB1 interfaceC12795fB1) {
            if (interfaceC16977mB1 == null) {
                g(0);
            }
            if (interfaceC12795fB1 == null) {
                g(1);
            }
            return false;
        }
    }

    static class l extends OG1 {
        l(GY7 gy7) {
            super(gy7);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ir.nasim.RI1
        public boolean e(InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC16977mB1 interfaceC16977mB1, InterfaceC12795fB1 interfaceC12795fB1) {
            if (interfaceC16977mB1 == null) {
                g(0);
            }
            if (interfaceC12795fB1 == null) {
                g(1);
            }
            return false;
        }
    }

    static {
        d dVar = new d(EY7.e.c);
        a = dVar;
        e eVar = new e(EY7.f.c);
        b = eVar;
        f fVar = new f(EY7.g.c);
        c = fVar;
        g gVar = new g(EY7.b.c);
        d = gVar;
        h hVar = new h(EY7.h.c);
        e = hVar;
        i iVar = new i(EY7.d.c);
        f = iVar;
        j jVar = new j(EY7.a.c);
        g = jVar;
        k kVar = new k(EY7.c.c);
        h = kVar;
        l lVar = new l(EY7.i.c);
        i = lVar;
        j = Collections.unmodifiableSet(AbstractC4597Fu6.i(dVar, eVar, gVar, iVar));
        HashMap mapE = YW0.e(4);
        mapE.put(eVar, 0);
        mapE.put(dVar, 0);
        mapE.put(gVar, 1);
        mapE.put(fVar, 1);
        mapE.put(hVar, 2);
        k = Collections.unmodifiableMap(mapE);
        l = hVar;
        m = new a();
        n = new b();
        o = new c();
        Iterator it = ServiceLoader.load(InterfaceC9282Zg4.class, InterfaceC9282Zg4.class.getClassLoader()).iterator();
        p = it.hasNext() ? (InterfaceC9282Zg4) it.next() : InterfaceC9282Zg4.a.a;
        q = new HashMap();
        i(dVar);
        i(eVar);
        i(fVar);
        i(gVar);
        i(hVar);
        i(iVar);
        i(jVar);
        i(kVar);
        i(lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void a(int r8) {
        /*
            r0 = 16
            if (r8 == r0) goto L7
            java.lang.String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L9
        L7:
            java.lang.String r1 = "@NotNull method %s.%s must not return null"
        L9:
            r2 = 3
            r3 = 2
            if (r8 == r0) goto Lf
            r4 = r2
            goto L10
        Lf:
            r4 = r3
        L10:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities"
            r6 = 1
            r7 = 0
            if (r8 == r6) goto L3a
            if (r8 == r2) goto L3a
            r2 = 5
            if (r8 == r2) goto L3a
            r2 = 7
            if (r8 == r2) goto L3a
            switch(r8) {
                case 9: goto L3a;
                case 10: goto L35;
                case 11: goto L30;
                case 12: goto L35;
                case 13: goto L30;
                case 14: goto L2b;
                case 15: goto L2b;
                case 16: goto L28;
                default: goto L23;
            }
        L23:
            java.lang.String r2 = "what"
            r4[r7] = r2
            goto L3e
        L28:
            r4[r7] = r5
            goto L3e
        L2b:
            java.lang.String r2 = "visibility"
            r4[r7] = r2
            goto L3e
        L30:
            java.lang.String r2 = "second"
            r4[r7] = r2
            goto L3e
        L35:
            java.lang.String r2 = "first"
            r4[r7] = r2
            goto L3e
        L3a:
            java.lang.String r2 = "from"
            r4[r7] = r2
        L3e:
            java.lang.String r2 = "toDescriptorVisibility"
            if (r8 == r0) goto L45
            r4[r6] = r5
            goto L47
        L45:
            r4[r6] = r2
        L47:
            switch(r8) {
                case 2: goto L70;
                case 3: goto L70;
                case 4: goto L6b;
                case 5: goto L6b;
                case 6: goto L66;
                case 7: goto L66;
                case 8: goto L61;
                case 9: goto L61;
                case 10: goto L5c;
                case 11: goto L5c;
                case 12: goto L57;
                case 13: goto L57;
                case 14: goto L52;
                case 15: goto L4f;
                case 16: goto L74;
                default: goto L4a;
            }
        L4a:
            java.lang.String r2 = "isVisible"
            r4[r3] = r2
            goto L74
        L4f:
            r4[r3] = r2
            goto L74
        L52:
            java.lang.String r2 = "isPrivate"
            r4[r3] = r2
            goto L74
        L57:
            java.lang.String r2 = "compare"
            r4[r3] = r2
            goto L74
        L5c:
            java.lang.String r2 = "compareLocal"
            r4[r3] = r2
            goto L74
        L61:
            java.lang.String r2 = "findInvisibleMember"
            r4[r3] = r2
            goto L74
        L66:
            java.lang.String r2 = "inSameFile"
            r4[r3] = r2
            goto L74
        L6b:
            java.lang.String r2 = "isVisibleWithAnyReceiver"
            r4[r3] = r2
            goto L74
        L70:
            java.lang.String r2 = "isVisibleIgnoringReceiver"
            r4[r3] = r2
        L74:
            java.lang.String r1 = java.lang.String.format(r1, r4)
            if (r8 == r0) goto L80
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r1)
            goto L85
        L80:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
        L85:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.QI1.a(int):void");
    }

    public static Integer d(RI1 ri1, RI1 ri12) {
        if (ri1 == null) {
            a(12);
        }
        if (ri12 == null) {
            a(13);
        }
        Integer numA = ri1.a(ri12);
        if (numA != null) {
            return numA;
        }
        Integer numA2 = ri12.a(ri1);
        if (numA2 != null) {
            return Integer.valueOf(-numA2.intValue());
        }
        return null;
    }

    public static InterfaceC16977mB1 e(InterfaceC10239bJ5 interfaceC10239bJ5, InterfaceC16977mB1 interfaceC16977mB1, InterfaceC12795fB1 interfaceC12795fB1) {
        InterfaceC16977mB1 interfaceC16977mB1E;
        if (interfaceC16977mB1 == null) {
            a(8);
        }
        if (interfaceC12795fB1 == null) {
            a(9);
        }
        for (InterfaceC16977mB1 interfaceC16977mB12 = (InterfaceC16977mB1) interfaceC16977mB1.a(); interfaceC16977mB12 != null && interfaceC16977mB12.getVisibility() != f; interfaceC16977mB12 = (InterfaceC16977mB1) OI1.q(interfaceC16977mB12, InterfaceC16977mB1.class)) {
            if (!interfaceC16977mB12.getVisibility().e(interfaceC10239bJ5, interfaceC16977mB12, interfaceC12795fB1)) {
                return interfaceC16977mB12;
            }
        }
        if (!(interfaceC16977mB1 instanceof InterfaceC7254Qx7) || (interfaceC16977mB1E = e(interfaceC10239bJ5, ((InterfaceC7254Qx7) interfaceC16977mB1).T(), interfaceC12795fB1)) == null) {
            return null;
        }
        return interfaceC16977mB1E;
    }

    public static boolean f(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC12795fB1 interfaceC12795fB12) {
        if (interfaceC12795fB1 == null) {
            a(6);
        }
        if (interfaceC12795fB12 == null) {
            a(7);
        }
        KH6 kh6J = OI1.j(interfaceC12795fB12);
        if (kh6J != KH6.a) {
            return kh6J.equals(OI1.j(interfaceC12795fB1));
        }
        return false;
    }

    public static boolean g(RI1 ri1) {
        if (ri1 == null) {
            a(14);
        }
        return ri1 == a || ri1 == b;
    }

    public static boolean h(InterfaceC16977mB1 interfaceC16977mB1, InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC16977mB1 == null) {
            a(2);
        }
        if (interfaceC12795fB1 == null) {
            a(3);
        }
        return e(n, interfaceC16977mB1, interfaceC12795fB1) == null;
    }

    private static void i(RI1 ri1) {
        q.put(ri1.b(), ri1);
    }

    public static RI1 j(GY7 gy7) {
        if (gy7 == null) {
            a(15);
        }
        RI1 ri1 = (RI1) q.get(gy7);
        if (ri1 != null) {
            return ri1;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + gy7);
    }
}
