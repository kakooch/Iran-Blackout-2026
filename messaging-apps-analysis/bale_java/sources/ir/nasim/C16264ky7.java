package ir.nasim;

import ir.nasim.C10647bx5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.ky7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C16264ky7 {
    private final WI1 a;
    private final C16264ky7 b;
    private final String c;
    private final String d;
    private boolean e;
    private final UA2 f;
    private final UA2 g;
    private final Map h;

    /* renamed from: ir.nasim.ky7$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final MU0 a(int i) {
            return C16264ky7.this.d(i);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.ky7$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C10647bx5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C10647bx5 c10647bx5) {
            super(0);
            this.f = c10647bx5;
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            return C16264ky7.this.a.c().d().c(this.f, C16264ky7.this.a.g());
        }
    }

    /* renamed from: ir.nasim.ky7$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        c() {
            super(1);
        }

        public final MU0 a(int i) {
            return C16264ky7.this.f(i);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.ky7$d */
    /* synthetic */ class d extends DB2 implements UA2 {
        public static final d a = new d();

        d() {
            super(1);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(C24948zU0.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final C24948zU0 invoke(C24948zU0 c24948zU0) {
            AbstractC13042fc3.i(c24948zU0, "p0");
            return c24948zU0.g();
        }
    }

    /* renamed from: ir.nasim.ky7$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C10647bx5 invoke(C10647bx5 c10647bx5) {
            AbstractC13042fc3.i(c10647bx5, "it");
            return AbstractC3921Cx5.f(c10647bx5, C16264ky7.this.a.j());
        }
    }

    /* renamed from: ir.nasim.ky7$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
            super(1);
        }

        public final int a(C10647bx5 c10647bx5) {
            AbstractC13042fc3.i(c10647bx5, "it");
            return c10647bx5.Y();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Integer.valueOf(a((C10647bx5) obj));
        }
    }

    public C16264ky7(WI1 wi1, C16264ky7 c16264ky7, List list, String str, String str2, boolean z) {
        Map linkedHashMap;
        AbstractC13042fc3.i(wi1, "c");
        AbstractC13042fc3.i(list, "typeParameterProtos");
        AbstractC13042fc3.i(str, "debugName");
        AbstractC13042fc3.i(str2, "containerPresentableName");
        this.a = wi1;
        this.b = c16264ky7;
        this.c = str;
        this.d = str2;
        this.e = z;
        this.f = wi1.h().b(new a());
        this.g = wi1.h().b(new c());
        if (list.isEmpty()) {
            linkedHashMap = AbstractC20051rO3.k();
        } else {
            linkedHashMap = new LinkedHashMap();
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                C12053dx5 c12053dx5 = (C12053dx5) it.next();
                linkedHashMap.put(Integer.valueOf(c12053dx5.Q()), new C18231oJ1(this.a, c12053dx5, i));
                i++;
            }
        }
        this.h = linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MU0 d(int i) {
        C24948zU0 c24948zU0A = AbstractC7170Qo4.a(this.a.g(), i);
        return c24948zU0A.k() ? this.a.c().b(c24948zU0A) : AbstractC23370wo2.b(this.a.c().p(), c24948zU0A);
    }

    private final XC6 e(int i) {
        if (AbstractC7170Qo4.a(this.a.g(), i).k()) {
            return this.a.c().n().a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MU0 f(int i) {
        C24948zU0 c24948zU0A = AbstractC7170Qo4.a(this.a.g(), i);
        if (c24948zU0A.k()) {
            return null;
        }
        return AbstractC23370wo2.d(this.a.c().p(), c24948zU0A);
    }

    private final XC6 g(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32) {
        AbstractC19738qr3 abstractC19738qr3E = AbstractC7731Sy7.e(abstractC4099Dr3);
        InterfaceC4356Eu annotations = abstractC4099Dr3.getAnnotations();
        AbstractC4099Dr3 abstractC4099Dr3H = FB2.h(abstractC4099Dr3);
        List listL0 = AbstractC15401jX0.l0(FB2.j(abstractC4099Dr3), 1);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listL0, 10));
        Iterator it = listL0.iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC3932Cy7) it.next()).getType());
        }
        return FB2.a(abstractC19738qr3E, annotations, abstractC4099Dr3H, arrayList, null, abstractC4099Dr32, true).O0(abstractC4099Dr3.L0());
    }

    private final XC6 h(InterfaceC4356Eu interfaceC4356Eu, InterfaceC13882gy7 interfaceC13882gy7, List list, boolean z) {
        XC6 xc6I;
        int size;
        int size2 = interfaceC13882gy7.getParameters().size() - list.size();
        if (size2 != 0) {
            xc6I = null;
            if (size2 == 1 && (size = list.size() - 1) >= 0) {
                C4567Fr3 c4567Fr3 = C4567Fr3.a;
                InterfaceC13882gy7 interfaceC13882gy7J = interfaceC13882gy7.n().W(size).j();
                AbstractC13042fc3.h(interfaceC13882gy7J, "functionTypeConstructor.builtIns.getSuspendFunction(arity).typeConstructor");
                xc6I = C4567Fr3.i(interfaceC4356Eu, interfaceC13882gy7J, list, z, null, 16, null);
            }
        } else {
            xc6I = i(interfaceC4356Eu, interfaceC13882gy7, list, z);
        }
        if (xc6I != null) {
            return xc6I;
        }
        XC6 xc6N = AbstractC14230ha2.n(AbstractC13042fc3.q("Bad suspend function in metadata with constructor: ", interfaceC13882gy7), list);
        AbstractC13042fc3.h(xc6N, "createErrorTypeWithArguments(\n            \"Bad suspend function in metadata with constructor: $functionTypeConstructor\",\n            arguments\n        )");
        return xc6N;
    }

    private final XC6 i(InterfaceC4356Eu interfaceC4356Eu, InterfaceC13882gy7 interfaceC13882gy7, List list, boolean z) {
        XC6 xc6I = C4567Fr3.i(interfaceC4356Eu, interfaceC13882gy7, list, z, null, 16, null);
        if (FB2.n(xc6I)) {
            return o(xc6I);
        }
        return null;
    }

    private static final List m(C10647bx5 c10647bx5, C16264ky7 c16264ky7) {
        List listZ = c10647bx5.Z();
        AbstractC13042fc3.h(listZ, "argumentList");
        List list = listZ;
        C10647bx5 c10647bx5F = AbstractC3921Cx5.f(c10647bx5, c16264ky7.a.j());
        List listM = c10647bx5F == null ? null : m(c10647bx5F, c16264ky7);
        if (listM == null) {
            listM = AbstractC10360bX0.m();
        }
        return AbstractC15401jX0.R0(list, listM);
    }

    public static /* synthetic */ XC6 n(C16264ky7 c16264ky7, C10647bx5 c10647bx5, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return c16264ky7.l(c10647bx5, z);
    }

    private final XC6 o(AbstractC4099Dr3 abstractC4099Dr3) {
        boolean zG = this.a.c().g().g();
        InterfaceC3932Cy7 interfaceC3932Cy7 = (InterfaceC3932Cy7) AbstractC15401jX0.F0(FB2.j(abstractC4099Dr3));
        AbstractC4099Dr3 type = interfaceC3932Cy7 == null ? null : interfaceC3932Cy7.getType();
        if (type == null) {
            return null;
        }
        MU0 mu0T = type.K0().t();
        C9424Zw2 c9424Zw2I = mu0T == null ? null : PI1.i(mu0T);
        boolean z = true;
        if (type.J0().size() != 1 || (!AbstractC19268q37.a(c9424Zw2I, true) && !AbstractC19268q37.a(c9424Zw2I, false))) {
            return (XC6) abstractC4099Dr3;
        }
        AbstractC4099Dr3 type2 = ((InterfaceC3932Cy7) AbstractC15401jX0.V0(type.J0())).getType();
        AbstractC13042fc3.h(type2, "continuationArgumentType.arguments.single().type");
        InterfaceC12795fB1 interfaceC12795fB1E = this.a.e();
        if (!(interfaceC12795fB1E instanceof InterfaceC14592iA0)) {
            interfaceC12795fB1E = null;
        }
        InterfaceC14592iA0 interfaceC14592iA0 = (InterfaceC14592iA0) interfaceC12795fB1E;
        if (AbstractC13042fc3.d(interfaceC14592iA0 != null ? PI1.e(interfaceC14592iA0) : null, AbstractC18677p37.a)) {
            return g(abstractC4099Dr3, type2);
        }
        if (!this.e && (!zG || !AbstractC19268q37.a(c9424Zw2I, !zG))) {
            z = false;
        }
        this.e = z;
        return g(abstractC4099Dr3, type2);
    }

    private final InterfaceC3932Cy7 q(InterfaceC22882vy7 interfaceC22882vy7, C10647bx5.b bVar) {
        if (bVar.y() == C10647bx5.b.c.STAR) {
            return interfaceC22882vy7 == null ? new QJ6(this.a.c().p().n()) : new RJ6(interfaceC22882vy7);
        }
        C18617ox5 c18617ox5 = C18617ox5.a;
        C10647bx5.b.c cVarY = bVar.y();
        AbstractC13042fc3.h(cVarY, "typeArgumentProto.projection");
        KQ7 kq7C = c18617ox5.c(cVarY);
        C10647bx5 c10647bx5L = AbstractC3921Cx5.l(bVar, this.a.j());
        return c10647bx5L == null ? new C4400Ey7(AbstractC14230ha2.j("No type recorded")) : new C4400Ey7(kq7C, p(c10647bx5L));
    }

    private final InterfaceC13882gy7 r(C10647bx5 c10647bx5) {
        Object next;
        InterfaceC13882gy7 interfaceC13882gy7K;
        if (c10647bx5.q0()) {
            MU0 mu0S = (MU0) this.f.invoke(Integer.valueOf(c10647bx5.a0()));
            if (mu0S == null) {
                mu0S = s(this, c10647bx5, c10647bx5.a0());
            }
            InterfaceC13882gy7 interfaceC13882gy7J = mu0S.j();
            AbstractC13042fc3.h(interfaceC13882gy7J, "classifierDescriptors(proto.className) ?: notFoundClass(proto.className)).typeConstructor");
            return interfaceC13882gy7J;
        }
        if (c10647bx5.z0()) {
            InterfaceC13882gy7 interfaceC13882gy7T = t(c10647bx5.m0());
            if (interfaceC13882gy7T != null) {
                return interfaceC13882gy7T;
            }
            InterfaceC13882gy7 interfaceC13882gy7K2 = AbstractC14230ha2.k("Unknown type parameter " + c10647bx5.m0() + ". Please try recompiling module containing \"" + this.d + '\"');
            AbstractC13042fc3.h(interfaceC13882gy7K2, "createErrorTypeConstructor(\n                        \"Unknown type parameter ${proto.typeParameter}. Please try recompiling module containing \\\"$containerPresentableName\\\"\"\n                    )");
            return interfaceC13882gy7K2;
        }
        if (!c10647bx5.A0()) {
            if (!c10647bx5.y0()) {
                InterfaceC13882gy7 interfaceC13882gy7K3 = AbstractC14230ha2.k("Unknown type");
                AbstractC13042fc3.h(interfaceC13882gy7K3, "createErrorTypeConstructor(\"Unknown type\")");
                return interfaceC13882gy7K3;
            }
            MU0 mu0S2 = (MU0) this.g.invoke(Integer.valueOf(c10647bx5.l0()));
            if (mu0S2 == null) {
                mu0S2 = s(this, c10647bx5, c10647bx5.l0());
            }
            InterfaceC13882gy7 interfaceC13882gy7J2 = mu0S2.j();
            AbstractC13042fc3.h(interfaceC13882gy7J2, "typeAliasDescriptors(proto.typeAliasName) ?: notFoundClass(proto.typeAliasName)).typeConstructor");
            return interfaceC13882gy7J2;
        }
        InterfaceC12795fB1 interfaceC12795fB1E = this.a.e();
        String string = this.a.g().getString(c10647bx5.n0());
        Iterator it = k().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (AbstractC13042fc3.d(((InterfaceC22882vy7) next).getName().h(), string)) {
                break;
            }
        }
        InterfaceC22882vy7 interfaceC22882vy7 = (InterfaceC22882vy7) next;
        InterfaceC13882gy7 interfaceC13882gy7J3 = interfaceC22882vy7 != null ? interfaceC22882vy7.j() : null;
        if (interfaceC13882gy7J3 == null) {
            interfaceC13882gy7K = AbstractC14230ha2.k("Deserialized type parameter " + string + " in " + interfaceC12795fB1E);
        } else {
            interfaceC13882gy7K = interfaceC13882gy7J3;
        }
        AbstractC13042fc3.h(interfaceC13882gy7K, "{\n                val container = c.containingDeclaration\n                val name = c.nameResolver.getString(proto.typeParameterName)\n                val parameter = ownTypeParameters.find { it.name.asString() == name }\n                parameter?.typeConstructor ?: ErrorUtils.createErrorTypeConstructor(\"Deserialized type parameter $name in $container\")\n            }");
        return interfaceC13882gy7K;
    }

    private static final InterfaceC21331tU0 s(C16264ky7 c16264ky7, C10647bx5 c10647bx5, int i) {
        C24948zU0 c24948zU0A = AbstractC7170Qo4.a(c16264ky7.a.g(), i);
        List listL = AbstractC11342cq6.L(AbstractC11342cq6.C(AbstractC9962aq6.j(c10647bx5, c16264ky7.new e()), f.e));
        int iN = AbstractC11342cq6.n(AbstractC9962aq6.j(c24948zU0A, d.a));
        while (listL.size() < iN) {
            listL.add(0);
        }
        return c16264ky7.a.c().q().d(c24948zU0A, listL);
    }

    private final InterfaceC13882gy7 t(int i) {
        InterfaceC22882vy7 interfaceC22882vy7 = (InterfaceC22882vy7) this.h.get(Integer.valueOf(i));
        InterfaceC13882gy7 interfaceC13882gy7J = interfaceC22882vy7 == null ? null : interfaceC22882vy7.j();
        if (interfaceC13882gy7J != null) {
            return interfaceC13882gy7J;
        }
        C16264ky7 c16264ky7 = this.b;
        if (c16264ky7 == null) {
            return null;
        }
        return c16264ky7.t(i);
    }

    public final boolean j() {
        return this.e;
    }

    public final List k() {
        return AbstractC15401jX0.m1(this.h.values());
    }

    public final XC6 l(C10647bx5 c10647bx5, boolean z) {
        XC6 xc6I;
        XC6 xc6J;
        boolean z2 = true;
        AbstractC13042fc3.i(c10647bx5, "proto");
        XC6 xc6E = c10647bx5.q0() ? e(c10647bx5.a0()) : c10647bx5.y0() ? e(c10647bx5.l0()) : null;
        if (xc6E != null) {
            return xc6E;
        }
        InterfaceC13882gy7 interfaceC13882gy7R = r(c10647bx5);
        if (AbstractC14230ha2.r(interfaceC13882gy7R.t())) {
            XC6 xc6O = AbstractC14230ha2.o(interfaceC13882gy7R.toString(), interfaceC13882gy7R);
            AbstractC13042fc3.h(xc6O, "createErrorTypeWithCustomConstructor(constructor.toString(), constructor)");
            return xc6O;
        }
        YI1 yi1 = new YI1(this.a.h(), new b(c10647bx5));
        List listM = m(c10647bx5, this);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listM, 10));
        int i = 0;
        for (Object obj : listM) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            List parameters = interfaceC13882gy7R.getParameters();
            AbstractC13042fc3.h(parameters, "constructor.parameters");
            arrayList.add(q((InterfaceC22882vy7) AbstractC15401jX0.t0(parameters, i), (C10647bx5.b) obj));
            i = i2;
        }
        List listM1 = AbstractC15401jX0.m1(arrayList);
        MU0 mu0T = interfaceC13882gy7R.t();
        if (z && (mu0T instanceof InterfaceC7722Sx7)) {
            XC6 xc6B = C4567Fr3.b((InterfaceC7722Sx7) mu0T, listM1);
            if (!AbstractC4816Gr3.b(xc6B) && !c10647bx5.i0()) {
                z2 = false;
            }
            xc6I = xc6B.O0(z2).Q0(InterfaceC4356Eu.W.a(AbstractC15401jX0.P0(yi1, xc6B.getAnnotations())));
        } else {
            Boolean boolD = AbstractC5031Hp2.a.d(c10647bx5.e0());
            AbstractC13042fc3.h(boolD, "SUSPEND_TYPE.get(proto.flags)");
            if (boolD.booleanValue()) {
                xc6I = h(yi1, interfaceC13882gy7R, listM1, c10647bx5.i0());
            } else {
                C4567Fr3 c4567Fr3 = C4567Fr3.a;
                xc6I = C4567Fr3.i(yi1, interfaceC13882gy7R, listM1, c10647bx5.i0(), null, 16, null);
            }
        }
        C10647bx5 c10647bx5A = AbstractC3921Cx5.a(c10647bx5, this.a.j());
        if (c10647bx5A != null && (xc6J = AbstractC24252yI6.j(xc6I, l(c10647bx5A, false))) != null) {
            xc6I = xc6J;
        }
        return c10647bx5.q0() ? this.a.c().t().a(AbstractC7170Qo4.a(this.a.g(), c10647bx5.a0()), xc6I) : xc6I;
    }

    public final AbstractC4099Dr3 p(C10647bx5 c10647bx5) {
        AbstractC13042fc3.i(c10647bx5, "proto");
        if (!c10647bx5.s0()) {
            return l(c10647bx5, true);
        }
        String string = this.a.g().getString(c10647bx5.f0());
        XC6 xc6N = n(this, c10647bx5, false, 2, null);
        C10647bx5 c10647bx5C = AbstractC3921Cx5.c(c10647bx5, this.a.j());
        AbstractC13042fc3.f(c10647bx5C);
        return this.a.c().l().a(c10647bx5, string, xc6N, n(this, c10647bx5C, false, 2, null));
    }

    public String toString() {
        String str = this.c;
        C16264ky7 c16264ky7 = this.b;
        return AbstractC13042fc3.q(str, c16264ky7 == null ? "" : AbstractC13042fc3.q(". Child of ", c16264ky7.c));
    }

    public /* synthetic */ C16264ky7(WI1 wi1, C16264ky7 c16264ky7, List list, String str, String str2, boolean z, int i, ED1 ed1) {
        this(wi1, c16264ky7, list, str, str2, (i & 32) != 0 ? false : z);
    }
}
