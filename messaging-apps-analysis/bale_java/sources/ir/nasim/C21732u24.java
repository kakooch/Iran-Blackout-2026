package ir.nasim;

import ir.nasim.AbstractC16253kx5;
import ir.nasim.AbstractC5031Hp2;
import ir.nasim.C10322bS7;
import ir.nasim.C13871gx5;
import ir.nasim.InterfaceC13485gJ1;
import ir.nasim.InterfaceC14592iA0;
import ir.nasim.InterfaceC15194jA0;
import ir.nasim.InterfaceC4356Eu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.u24, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21732u24 {
    private final WI1 a;
    private final C22837vu b;

    /* renamed from: ir.nasim.u24$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.l f;
        final /* synthetic */ EnumC11375cu g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.reflect.jvm.internal.impl.protobuf.l lVar, EnumC11375cu enumC11375cu) {
            super(0);
            this.f = lVar;
            this.g = enumC11375cu;
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            List listM1;
            C21732u24 c21732u24 = C21732u24.this;
            AbstractC16253kx5 abstractC16253kx5C = c21732u24.c(c21732u24.a.e());
            if (abstractC16253kx5C == null) {
                listM1 = null;
            } else {
                listM1 = AbstractC15401jX0.m1(C21732u24.this.a.c().d().e(abstractC16253kx5C, this.f, this.g));
            }
            return listM1 != null ? listM1 : AbstractC10360bX0.m();
        }
    }

    /* renamed from: ir.nasim.u24$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ boolean f;
        final /* synthetic */ C9193Yw5 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z, C9193Yw5 c9193Yw5) {
            super(0);
            this.f = z;
            this.g = c9193Yw5;
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            List listM1;
            C21732u24 c21732u24 = C21732u24.this;
            AbstractC16253kx5 abstractC16253kx5C = c21732u24.c(c21732u24.a.e());
            if (abstractC16253kx5C == null) {
                listM1 = null;
            } else {
                boolean z = this.f;
                C21732u24 c21732u242 = C21732u24.this;
                C9193Yw5 c9193Yw5 = this.g;
                listM1 = z ? AbstractC15401jX0.m1(c21732u242.a.c().d().d(abstractC16253kx5C, c9193Yw5)) : AbstractC15401jX0.m1(c21732u242.a.c().d().i(abstractC16253kx5C, c9193Yw5));
            }
            return listM1 != null ? listM1 : AbstractC10360bX0.m();
        }
    }

    /* renamed from: ir.nasim.u24$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.l f;
        final /* synthetic */ EnumC11375cu g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(kotlin.reflect.jvm.internal.impl.protobuf.l lVar, EnumC11375cu enumC11375cu) {
            super(0);
            this.f = lVar;
            this.g = enumC11375cu;
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            List listA;
            C21732u24 c21732u24 = C21732u24.this;
            AbstractC16253kx5 abstractC16253kx5C = c21732u24.c(c21732u24.a.e());
            if (abstractC16253kx5C == null) {
                listA = null;
            } else {
                listA = C21732u24.this.a.c().d().a(abstractC16253kx5C, this.f, this.g);
            }
            return listA != null ? listA : AbstractC10360bX0.m();
        }
    }

    /* renamed from: ir.nasim.u24$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C9193Yw5 f;
        final /* synthetic */ C16458lJ1 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C9193Yw5 c9193Yw5, C16458lJ1 c16458lJ1) {
            super(0);
            this.f = c9193Yw5;
            this.g = c16458lJ1;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC7068Qd1 invoke() {
            C21732u24 c21732u24 = C21732u24.this;
            AbstractC16253kx5 abstractC16253kx5C = c21732u24.c(c21732u24.a.e());
            AbstractC13042fc3.f(abstractC16253kx5C);
            InterfaceC17991nu interfaceC17991nuD = C21732u24.this.a.c().d();
            C9193Yw5 c9193Yw5 = this.f;
            AbstractC4099Dr3 returnType = this.g.getReturnType();
            AbstractC13042fc3.h(returnType, "property.returnType");
            return (AbstractC7068Qd1) interfaceC17991nuD.j(abstractC16253kx5C, c9193Yw5, returnType);
        }
    }

    /* renamed from: ir.nasim.u24$f */
    static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ AbstractC16253kx5 f;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.l g;
        final /* synthetic */ EnumC11375cu h;
        final /* synthetic */ int i;
        final /* synthetic */ C13280fx5 j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(AbstractC16253kx5 abstractC16253kx5, kotlin.reflect.jvm.internal.impl.protobuf.l lVar, EnumC11375cu enumC11375cu, int i, C13280fx5 c13280fx5) {
            super(0);
            this.f = abstractC16253kx5;
            this.g = lVar;
            this.h = enumC11375cu;
            this.i = i;
            this.j = c13280fx5;
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            return AbstractC15401jX0.m1(C21732u24.this.a.c().d().g(this.f, this.g, this.h, this.i, this.j));
        }
    }

    public C21732u24(WI1 wi1) {
        AbstractC13042fc3.i(wi1, "c");
        this.a = wi1;
        this.b = new C22837vu(wi1.c().p(), wi1.c().q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbstractC16253kx5 c(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 instanceof InterfaceC24340yS4) {
            return new AbstractC16253kx5.b(((InterfaceC24340yS4) interfaceC12795fB1).e(), this.a.g(), this.a.j(), this.a.d());
        }
        if (interfaceC12795fB1 instanceof C10851cJ1) {
            return ((C10851cJ1) interfaceC12795fB1).a1();
        }
        return null;
    }

    private final InterfaceC13485gJ1.a d(InterfaceC13485gJ1 interfaceC13485gJ1, C16264ky7 c16264ky7) {
        if (!s(interfaceC13485gJ1)) {
            return InterfaceC13485gJ1.a.COMPATIBLE;
        }
        g(c16264ky7);
        return c16264ky7.j() ? InterfaceC13485gJ1.a.INCOMPATIBLE : InterfaceC13485gJ1.a.COMPATIBLE;
    }

    private final InterfaceC13485gJ1.a e(ZI1 zi1, ZI5 zi5, Collection collection, Collection collection2, AbstractC4099Dr3 abstractC4099Dr3, boolean z) {
        InterfaceC13485gJ1.a aVar;
        if (!s(zi1)) {
            return InterfaceC13485gJ1.a.COMPATIBLE;
        }
        if (AbstractC13042fc3.d(PI1.e(zi1), AbstractC18677p37.a)) {
            return InterfaceC13485gJ1.a.COMPATIBLE;
        }
        Collection collection3 = collection;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collection3, 10));
        Iterator it = collection3.iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC24919zQ7) it.next()).getType());
        }
        List listR0 = AbstractC15401jX0.R0(arrayList, AbstractC10360bX0.q(zi5 == null ? null : zi5.getType()));
        if (AbstractC13042fc3.d(abstractC4099Dr3 != null ? Boolean.valueOf(f(abstractC4099Dr3)) : null, Boolean.TRUE)) {
            return InterfaceC13485gJ1.a.INCOMPATIBLE;
        }
        Collection collection4 = collection2;
        if (!(collection4 instanceof Collection) || !collection4.isEmpty()) {
            Iterator it2 = collection4.iterator();
            while (it2.hasNext()) {
                List upperBounds = ((InterfaceC22882vy7) it2.next()).getUpperBounds();
                AbstractC13042fc3.h(upperBounds, "typeParameter.upperBounds");
                List<AbstractC4099Dr3> list = upperBounds;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    for (AbstractC4099Dr3 abstractC4099Dr32 : list) {
                        AbstractC13042fc3.h(abstractC4099Dr32, "it");
                        if (f(abstractC4099Dr32)) {
                            return InterfaceC13485gJ1.a.INCOMPATIBLE;
                        }
                    }
                }
            }
        }
        List<AbstractC4099Dr3> list2 = listR0;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (AbstractC4099Dr3 abstractC4099Dr33 : list2) {
            AbstractC13042fc3.h(abstractC4099Dr33, "type");
            if (!FB2.o(abstractC4099Dr33) || abstractC4099Dr33.J0().size() > 3) {
                aVar = f(abstractC4099Dr33) ? InterfaceC13485gJ1.a.INCOMPATIBLE : InterfaceC13485gJ1.a.COMPATIBLE;
            } else {
                List listJ0 = abstractC4099Dr33.J0();
                if ((listJ0 instanceof Collection) && listJ0.isEmpty()) {
                    aVar = InterfaceC13485gJ1.a.NEEDS_WRAPPER;
                } else {
                    Iterator it3 = listJ0.iterator();
                    while (it3.hasNext()) {
                        AbstractC4099Dr3 type = ((InterfaceC3932Cy7) it3.next()).getType();
                        AbstractC13042fc3.h(type, "it.type");
                        if (f(type)) {
                            aVar = InterfaceC13485gJ1.a.INCOMPATIBLE;
                            break;
                        }
                    }
                    aVar = InterfaceC13485gJ1.a.NEEDS_WRAPPER;
                }
            }
            arrayList2.add(aVar);
        }
        InterfaceC13485gJ1.a aVar2 = (InterfaceC13485gJ1.a) AbstractC15401jX0.H0(arrayList2);
        if (aVar2 == null) {
            aVar2 = InterfaceC13485gJ1.a.COMPATIBLE;
        }
        return (InterfaceC13485gJ1.a) AbstractC18641p01.h(z ? InterfaceC13485gJ1.a.NEEDS_WRAPPER : InterfaceC13485gJ1.a.COMPATIBLE, aVar2);
    }

    private final boolean f(AbstractC4099Dr3 abstractC4099Dr3) {
        return AbstractC7731Sy7.b(abstractC4099Dr3, new AbstractC24632yw5() { // from class: ir.nasim.u24.a
            @Override // ir.nasim.InterfaceC4288Em3
            public Object get(Object obj) {
                return Boolean.valueOf(FB2.o((AbstractC4099Dr3) obj));
            }

            @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
            public String getName() {
                return "isSuspendFunctionType";
            }

            @Override // ir.nasim.AbstractC15785kA0
            public InterfaceC15551jm3 getOwner() {
                return AbstractC10882cM5.d(FB2.class, "deserialization");
            }

            @Override // ir.nasim.AbstractC15785kA0
            public String getSignature() {
                return "isSuspendFunctionType(Lorg/jetbrains/kotlin/types/KotlinType;)Z";
            }
        });
    }

    private final void g(C16264ky7 c16264ky7) {
        Iterator it = c16264ky7.k().iterator();
        while (it.hasNext()) {
            ((InterfaceC22882vy7) it.next()).getUpperBounds();
        }
    }

    private final InterfaceC4356Eu h(kotlin.reflect.jvm.internal.impl.protobuf.l lVar, int i, EnumC11375cu enumC11375cu) {
        return !AbstractC5031Hp2.b.d(i).booleanValue() ? InterfaceC4356Eu.W.b() : new C14605iB4(this.a.h(), new b(lVar, enumC11375cu));
    }

    private final ZI5 i() {
        InterfaceC12795fB1 interfaceC12795fB1E = this.a.e();
        InterfaceC21331tU0 interfaceC21331tU0 = interfaceC12795fB1E instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) interfaceC12795fB1E : null;
        if (interfaceC21331tU0 == null) {
            return null;
        }
        return interfaceC21331tU0.H0();
    }

    private final InterfaceC4356Eu j(C9193Yw5 c9193Yw5, boolean z) {
        return !AbstractC5031Hp2.b.d(c9193Yw5.W()).booleanValue() ? InterfaceC4356Eu.W.b() : new C14605iB4(this.a.h(), new c(z, c9193Yw5));
    }

    private final InterfaceC4356Eu k(kotlin.reflect.jvm.internal.impl.protobuf.l lVar, EnumC11375cu enumC11375cu) {
        return new YI1(this.a.h(), new d(lVar, enumC11375cu));
    }

    private final void l(C17049mJ1 c17049mJ1, ZI5 zi5, ZI5 zi52, List list, List list2, AbstractC4099Dr3 abstractC4099Dr3, EnumC11067cg4 enumC11067cg4, RI1 ri1, Map map, boolean z) {
        c17049mJ1.q1(zi5, zi52, list, list2, abstractC4099Dr3, enumC11067cg4, ri1, map, e(c17049mJ1, zi5, list2, list, abstractC4099Dr3, z));
    }

    private final int o(int i) {
        return (i & 63) + ((i >> 8) << 6);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List r(java.util.List r26, kotlin.reflect.jvm.internal.impl.protobuf.l r27, ir.nasim.EnumC11375cu r28) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21732u24.r(java.util.List, kotlin.reflect.jvm.internal.impl.protobuf.l, ir.nasim.cu):java.util.List");
    }

    private final boolean s(InterfaceC13485gJ1 interfaceC13485gJ1) {
        if (this.a.c().g().g()) {
            List<C10322bS7> listG0 = interfaceC13485gJ1.G0();
            if (!(listG0 instanceof Collection) || !listG0.isEmpty()) {
                for (C10322bS7 c10322bS7 : listG0) {
                    if (!AbstractC13042fc3.d(c10322bS7.b(), new C10322bS7.b(1, 3, 0, 4, null)) || c10322bS7.a() != C13871gx5.d.LANGUAGE_VERSION) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final InterfaceC18329oU0 m(C6765Ow5 c6765Ow5, boolean z) {
        C9641aJ1 c9641aJ1;
        InterfaceC13485gJ1.a aVarE;
        C16264ky7 c16264ky7I;
        AbstractC13042fc3.i(c6765Ow5, "proto");
        InterfaceC21331tU0 interfaceC21331tU0 = (InterfaceC21331tU0) this.a.e();
        int iN = c6765Ow5.N();
        EnumC11375cu enumC11375cu = EnumC11375cu.FUNCTION;
        C9641aJ1 c9641aJ12 = new C9641aJ1(interfaceC21331tU0, null, h(c6765Ow5, iN, enumC11375cu), z, InterfaceC15194jA0.a.DECLARATION, c6765Ow5, this.a.g(), this.a.j(), this.a.k(), this.a.d(), null, 1024, null);
        C21732u24 c21732u24F = WI1.b(this.a, c9641aJ12, AbstractC10360bX0.m(), null, null, null, null, 60, null).f();
        List listQ = c6765Ow5.Q();
        AbstractC13042fc3.h(listQ, "proto.valueParameterList");
        c9641aJ12.o1(c21732u24F.r(listQ, c6765Ow5, enumC11375cu), AbstractC19208px5.a(C18617ox5.a, (EnumC15071ix5) AbstractC5031Hp2.c.d(c6765Ow5.N())));
        c9641aJ12.f1(interfaceC21331tU0.p());
        c9641aJ12.X0(!AbstractC5031Hp2.m.d(c6765Ow5.N()).booleanValue());
        InterfaceC12795fB1 interfaceC12795fB1E = this.a.e();
        Boolean boolValueOf = null;
        C10851cJ1 c10851cJ1 = interfaceC12795fB1E instanceof C10851cJ1 ? (C10851cJ1) interfaceC12795fB1E : null;
        WI1 wi1V0 = c10851cJ1 == null ? null : c10851cJ1.V0();
        if (wi1V0 != null && (c16264ky7I = wi1V0.i()) != null) {
            boolValueOf = Boolean.valueOf(c16264ky7I.j());
        }
        if (AbstractC13042fc3.d(boolValueOf, Boolean.TRUE) && s(c9641aJ12)) {
            aVarE = InterfaceC13485gJ1.a.INCOMPATIBLE;
            c9641aJ1 = c9641aJ12;
        } else {
            Collection collectionH = c9641aJ12.h();
            AbstractC13042fc3.h(collectionH, "descriptor.valueParameters");
            Collection collection = collectionH;
            Collection typeParameters = c9641aJ12.getTypeParameters();
            AbstractC13042fc3.h(typeParameters, "descriptor.typeParameters");
            c9641aJ1 = c9641aJ12;
            aVarE = e(c9641aJ12, null, collection, typeParameters, c9641aJ12.getReturnType(), false);
        }
        c9641aJ1.t1(aVarE);
        return c9641aJ1;
    }

    public final JC6 n(C7950Tw5 c7950Tw5) {
        AbstractC4099Dr3 abstractC4099Dr3P;
        AbstractC13042fc3.i(c7950Tw5, "proto");
        int iY = c7950Tw5.p0() ? c7950Tw5.Y() : o(c7950Tw5.a0());
        EnumC11375cu enumC11375cu = EnumC11375cu.FUNCTION;
        InterfaceC4356Eu interfaceC4356EuH = h(c7950Tw5, iY, enumC11375cu);
        InterfaceC4356Eu interfaceC4356EuK = AbstractC3921Cx5.d(c7950Tw5) ? k(c7950Tw5, enumC11375cu) : InterfaceC4356Eu.W.b();
        C10938cS7 c10938cS7B = AbstractC13042fc3.d(PI1.i(this.a.e()).c(AbstractC7170Qo4.b(this.a.g(), c7950Tw5.Z())), AbstractC18677p37.a) ? C10938cS7.b.b() : this.a.k();
        InterfaceC12795fB1 interfaceC12795fB1E = this.a.e();
        C6432No4 c6432No4B = AbstractC7170Qo4.b(this.a.g(), c7950Tw5.Z());
        C18617ox5 c18617ox5 = C18617ox5.a;
        C17049mJ1 c17049mJ1 = new C17049mJ1(interfaceC12795fB1E, null, interfaceC4356EuH, c6432No4B, AbstractC19208px5.b(c18617ox5, (EnumC8184Uw5) AbstractC5031Hp2.n.d(iY)), c7950Tw5, this.a.g(), this.a.j(), c10938cS7B, this.a.d(), null, 1024, null);
        WI1 wi1 = this.a;
        List listI0 = c7950Tw5.i0();
        AbstractC13042fc3.h(listI0, "proto.typeParameterList");
        WI1 wi1B = WI1.b(wi1, c17049mJ1, listI0, null, null, null, null, 60, null);
        C10647bx5 c10647bx5G = AbstractC3921Cx5.g(c7950Tw5, this.a.j());
        ZI5 zi5F = null;
        if (c10647bx5G != null && (abstractC4099Dr3P = wi1B.i().p(c10647bx5G)) != null) {
            zi5F = AbstractC23657xI1.f(c17049mJ1, abstractC4099Dr3P, interfaceC4356EuK);
        }
        ZI5 zi5I = i();
        List listK = wi1B.i().k();
        C21732u24 c21732u24F = wi1B.f();
        List listM0 = c7950Tw5.m0();
        AbstractC13042fc3.h(listM0, "proto.valueParameterList");
        List listR = c21732u24F.r(listM0, c7950Tw5, enumC11375cu);
        AbstractC4099Dr3 abstractC4099Dr3P2 = wi1B.i().p(AbstractC3921Cx5.i(c7950Tw5, this.a.j()));
        EnumC11067cg4 enumC11067cg4B = c18617ox5.b((EnumC8418Vw5) AbstractC5031Hp2.d.d(iY));
        RI1 ri1A = AbstractC19208px5.a(c18617ox5, (EnumC15071ix5) AbstractC5031Hp2.c.d(iY));
        Map mapK = AbstractC20051rO3.k();
        AbstractC5031Hp2.b bVar = AbstractC5031Hp2.t;
        Boolean boolD = bVar.d(iY);
        AbstractC13042fc3.h(boolD, "IS_SUSPEND.get(flags)");
        l(c17049mJ1, zi5F, zi5I, listK, listR, abstractC4099Dr3P2, enumC11067cg4B, ri1A, mapK, boolD.booleanValue());
        Boolean boolD2 = AbstractC5031Hp2.o.d(iY);
        AbstractC13042fc3.h(boolD2, "IS_OPERATOR.get(flags)");
        c17049mJ1.e1(boolD2.booleanValue());
        Boolean boolD3 = AbstractC5031Hp2.p.d(iY);
        AbstractC13042fc3.h(boolD3, "IS_INFIX.get(flags)");
        c17049mJ1.b1(boolD3.booleanValue());
        Boolean boolD4 = AbstractC5031Hp2.s.d(iY);
        AbstractC13042fc3.h(boolD4, "IS_EXTERNAL_FUNCTION.get(flags)");
        c17049mJ1.W0(boolD4.booleanValue());
        Boolean boolD5 = AbstractC5031Hp2.q.d(iY);
        AbstractC13042fc3.h(boolD5, "IS_INLINE.get(flags)");
        c17049mJ1.d1(boolD5.booleanValue());
        Boolean boolD6 = AbstractC5031Hp2.r.d(iY);
        AbstractC13042fc3.h(boolD6, "IS_TAILREC.get(flags)");
        c17049mJ1.h1(boolD6.booleanValue());
        Boolean boolD7 = bVar.d(iY);
        AbstractC13042fc3.h(boolD7, "IS_SUSPEND.get(flags)");
        c17049mJ1.g1(boolD7.booleanValue());
        Boolean boolD8 = AbstractC5031Hp2.u.d(iY);
        AbstractC13042fc3.h(boolD8, "IS_EXPECT_FUNCTION.get(flags)");
        c17049mJ1.V0(boolD8.booleanValue());
        c17049mJ1.X0(!AbstractC5031Hp2.v.d(iY).booleanValue());
        XV4 xv4A = this.a.c().h().a(c7950Tw5, c17049mJ1, this.a.j(), wi1B.i());
        if (xv4A != null) {
            c17049mJ1.T0((InterfaceC14592iA0.a) xv4A.e(), xv4A.f());
        }
        return c17049mJ1;
    }

    public final InterfaceC20989sw5 p(C9193Yw5 c9193Yw5) {
        C9193Yw5 c9193Yw52;
        InterfaceC4356Eu interfaceC4356EuB;
        AbstractC4099Dr3 abstractC4099Dr3P;
        C16458lJ1 c16458lJ1;
        ZI5 zi5F;
        WI1 wi1;
        AbstractC5031Hp2.d dVar;
        AbstractC5031Hp2.d dVar2;
        C16458lJ1 c16458lJ12;
        C18617ox5 c18617ox5;
        C22862vw5 c22862vw5;
        C4380Ew5 c4380Ew5;
        C21732u24 c21732u24;
        C22862vw5 c22862vw5B;
        AbstractC13042fc3.i(c9193Yw5, "proto");
        int iW = c9193Yw5.l0() ? c9193Yw5.W() : o(c9193Yw5.Z());
        InterfaceC12795fB1 interfaceC12795fB1E = this.a.e();
        InterfaceC4356Eu interfaceC4356EuH = h(c9193Yw5, iW, EnumC11375cu.PROPERTY);
        C18617ox5 c18617ox52 = C18617ox5.a;
        AbstractC5031Hp2.d dVar3 = AbstractC5031Hp2.d;
        EnumC11067cg4 enumC11067cg4B = c18617ox52.b((EnumC8418Vw5) dVar3.d(iW));
        AbstractC5031Hp2.d dVar4 = AbstractC5031Hp2.c;
        RI1 ri1A = AbstractC19208px5.a(c18617ox52, (EnumC15071ix5) dVar4.d(iW));
        Boolean boolD = AbstractC5031Hp2.w.d(iW);
        AbstractC13042fc3.h(boolD, "IS_VAR.get(flags)");
        boolean zBooleanValue = boolD.booleanValue();
        C6432No4 c6432No4B = AbstractC7170Qo4.b(this.a.g(), c9193Yw5.Y());
        InterfaceC15194jA0.a aVarB = AbstractC19208px5.b(c18617ox52, (EnumC8184Uw5) AbstractC5031Hp2.n.d(iW));
        Boolean boolD2 = AbstractC5031Hp2.A.d(iW);
        AbstractC13042fc3.h(boolD2, "IS_LATEINIT.get(flags)");
        boolean zBooleanValue2 = boolD2.booleanValue();
        Boolean boolD3 = AbstractC5031Hp2.z.d(iW);
        AbstractC13042fc3.h(boolD3, "IS_CONST.get(flags)");
        boolean zBooleanValue3 = boolD3.booleanValue();
        Boolean boolD4 = AbstractC5031Hp2.C.d(iW);
        AbstractC13042fc3.h(boolD4, "IS_EXTERNAL_PROPERTY.get(flags)");
        boolean zBooleanValue4 = boolD4.booleanValue();
        Boolean boolD5 = AbstractC5031Hp2.D.d(iW);
        AbstractC13042fc3.h(boolD5, "IS_DELEGATED.get(flags)");
        boolean zBooleanValue5 = boolD5.booleanValue();
        Boolean boolD6 = AbstractC5031Hp2.E.d(iW);
        AbstractC13042fc3.h(boolD6, "IS_EXPECT_PROPERTY.get(flags)");
        C16458lJ1 c16458lJ13 = new C16458lJ1(interfaceC12795fB1E, null, interfaceC4356EuH, enumC11067cg4B, ri1A, zBooleanValue, c6432No4B, aVarB, zBooleanValue2, zBooleanValue3, zBooleanValue4, zBooleanValue5, boolD6.booleanValue(), c9193Yw5, this.a.g(), this.a.j(), this.a.k(), this.a.d());
        WI1 wi12 = this.a;
        List listJ0 = c9193Yw5.j0();
        AbstractC13042fc3.h(listJ0, "proto.typeParameterList");
        WI1 wi1B = WI1.b(wi12, c16458lJ13, listJ0, null, null, null, null, 60, null);
        Boolean boolD7 = AbstractC5031Hp2.x.d(iW);
        AbstractC13042fc3.h(boolD7, "HAS_GETTER.get(flags)");
        boolean zBooleanValue6 = boolD7.booleanValue();
        if (zBooleanValue6 && AbstractC3921Cx5.e(c9193Yw5)) {
            c9193Yw52 = c9193Yw5;
            interfaceC4356EuB = k(c9193Yw52, EnumC11375cu.PROPERTY_GETTER);
        } else {
            c9193Yw52 = c9193Yw5;
            interfaceC4356EuB = InterfaceC4356Eu.W.b();
        }
        AbstractC4099Dr3 abstractC4099Dr3P2 = wi1B.i().p(AbstractC3921Cx5.j(c9193Yw52, this.a.j()));
        List listK = wi1B.i().k();
        ZI5 zi5I = i();
        C10647bx5 c10647bx5H = AbstractC3921Cx5.h(c9193Yw52, this.a.j());
        if (c10647bx5H == null || (abstractC4099Dr3P = wi1B.i().p(c10647bx5H)) == null) {
            zi5F = null;
            c16458lJ1 = c16458lJ13;
        } else {
            c16458lJ1 = c16458lJ13;
            zi5F = AbstractC23657xI1.f(c16458lJ1, abstractC4099Dr3P, interfaceC4356EuB);
        }
        c16458lJ1.Y0(abstractC4099Dr3P2, listK, zi5I, zi5F);
        Boolean boolD8 = AbstractC5031Hp2.b.d(iW);
        AbstractC13042fc3.h(boolD8, "HAS_ANNOTATIONS.get(flags)");
        int iB = AbstractC5031Hp2.b(boolD8.booleanValue(), (EnumC15071ix5) dVar4.d(iW), (EnumC8418Vw5) dVar3.d(iW), false, false, false);
        if (zBooleanValue6) {
            int iX = c9193Yw5.m0() ? c9193Yw5.X() : iB;
            Boolean boolD9 = AbstractC5031Hp2.I.d(iX);
            AbstractC13042fc3.h(boolD9, "IS_NOT_DEFAULT.get(getterFlags)");
            boolean zBooleanValue7 = boolD9.booleanValue();
            Boolean boolD10 = AbstractC5031Hp2.J.d(iX);
            AbstractC13042fc3.h(boolD10, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean zBooleanValue8 = boolD10.booleanValue();
            Boolean boolD11 = AbstractC5031Hp2.K.d(iX);
            AbstractC13042fc3.h(boolD11, "IS_INLINE_ACCESSOR.get(getterFlags)");
            boolean zBooleanValue9 = boolD11.booleanValue();
            InterfaceC4356Eu interfaceC4356EuH2 = h(c9193Yw52, iX, EnumC11375cu.PROPERTY_GETTER);
            if (zBooleanValue7) {
                c18617ox5 = c18617ox52;
                dVar = dVar3;
                wi1 = wi1B;
                dVar2 = dVar4;
                c16458lJ12 = c16458lJ1;
                c22862vw5B = new C22862vw5(c16458lJ1, interfaceC4356EuH2, c18617ox52.b((EnumC8418Vw5) dVar3.d(iX)), AbstractC19208px5.a(c18617ox52, (EnumC15071ix5) dVar4.d(iX)), !zBooleanValue7, zBooleanValue8, zBooleanValue9, c16458lJ1.f(), null, JH6.a);
            } else {
                wi1 = wi1B;
                dVar = dVar3;
                dVar2 = dVar4;
                c16458lJ12 = c16458lJ1;
                c18617ox5 = c18617ox52;
                c22862vw5B = AbstractC23657xI1.b(c16458lJ12, interfaceC4356EuH2);
                AbstractC13042fc3.h(c22862vw5B, "{\n                DescriptorFactory.createDefaultGetter(property, annotations)\n            }");
            }
            c22862vw5B.O0(c16458lJ12.getReturnType());
            c22862vw5 = c22862vw5B;
        } else {
            wi1 = wi1B;
            dVar = dVar3;
            dVar2 = dVar4;
            c16458lJ12 = c16458lJ1;
            c18617ox5 = c18617ox52;
            c22862vw5 = null;
        }
        Boolean boolD12 = AbstractC5031Hp2.y.d(iW);
        AbstractC13042fc3.h(boolD12, "HAS_SETTER.get(flags)");
        if (boolD12.booleanValue()) {
            if (c9193Yw5.t0()) {
                iB = c9193Yw5.f0();
            }
            int i = iB;
            Boolean boolD13 = AbstractC5031Hp2.I.d(i);
            AbstractC13042fc3.h(boolD13, "IS_NOT_DEFAULT.get(setterFlags)");
            boolean zBooleanValue10 = boolD13.booleanValue();
            Boolean boolD14 = AbstractC5031Hp2.J.d(i);
            AbstractC13042fc3.h(boolD14, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean zBooleanValue11 = boolD14.booleanValue();
            Boolean boolD15 = AbstractC5031Hp2.K.d(i);
            AbstractC13042fc3.h(boolD15, "IS_INLINE_ACCESSOR.get(setterFlags)");
            boolean zBooleanValue12 = boolD15.booleanValue();
            EnumC11375cu enumC11375cu = EnumC11375cu.PROPERTY_SETTER;
            InterfaceC4356Eu interfaceC4356EuH3 = h(c9193Yw52, i, enumC11375cu);
            if (zBooleanValue10) {
                C18617ox5 c18617ox53 = c18617ox5;
                C4380Ew5 c4380Ew52 = new C4380Ew5(c16458lJ12, interfaceC4356EuH3, c18617ox53.b((EnumC8418Vw5) dVar.d(i)), AbstractC19208px5.a(c18617ox53, (EnumC15071ix5) dVar2.d(i)), !zBooleanValue10, zBooleanValue11, zBooleanValue12, c16458lJ12.f(), null, JH6.a);
                c4380Ew52.P0((InterfaceC24919zQ7) AbstractC15401jX0.V0(WI1.b(wi1, c4380Ew52, AbstractC10360bX0.m(), null, null, null, null, 60, null).f().r(AbstractC9766aX0.e(c9193Yw5.g0()), c9193Yw52, enumC11375cu)));
                c4380Ew5 = c4380Ew52;
            } else {
                C4380Ew5 c4380Ew5C = AbstractC23657xI1.c(c16458lJ12, interfaceC4356EuH3, InterfaceC4356Eu.W.b());
                AbstractC13042fc3.h(c4380Ew5C, "{\n                DescriptorFactory.createDefaultSetter(\n                    property, annotations,\n                    Annotations.EMPTY /* Otherwise the setter is not default, see DescriptorResolver.resolvePropertySetterDescriptor */\n                )\n            }");
                c4380Ew5 = c4380Ew5C;
            }
        } else {
            c4380Ew5 = null;
        }
        Boolean boolD16 = AbstractC5031Hp2.B.d(iW);
        AbstractC13042fc3.h(boolD16, "HAS_CONSTANT.get(flags)");
        if (boolD16.booleanValue()) {
            c21732u24 = this;
            c16458lJ12.J0(c21732u24.a.h().g(c21732u24.new e(c9193Yw52, c16458lJ12)));
        } else {
            c21732u24 = this;
        }
        c16458lJ12.b1(c22862vw5, c4380Ew5, new C3328Ak2(c21732u24.j(c9193Yw52, false), c16458lJ12), new C3328Ak2(c21732u24.j(c9193Yw52, true), c16458lJ12), c21732u24.d(c16458lJ12, wi1.i()));
        return c16458lJ12;
    }

    public final InterfaceC7722Sx7 q(C11410cx5 c11410cx5) {
        AbstractC13042fc3.i(c11410cx5, "proto");
        InterfaceC4356Eu.a aVar = InterfaceC4356Eu.W;
        List listU = c11410cx5.U();
        AbstractC13042fc3.h(listU, "proto.annotationList");
        List<C6266Mw5> list = listU;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (C6266Mw5 c6266Mw5 : list) {
            C22837vu c22837vu = this.b;
            AbstractC13042fc3.h(c6266Mw5, "it");
            arrayList.add(c22837vu.a(c6266Mw5, this.a.g()));
        }
        C17640nJ1 c17640nJ1 = new C17640nJ1(this.a.h(), this.a.e(), aVar.a(arrayList), AbstractC7170Qo4.b(this.a.g(), c11410cx5.a0()), AbstractC19208px5.a(C18617ox5.a, (EnumC15071ix5) AbstractC5031Hp2.c.d(c11410cx5.Z())), c11410cx5, this.a.g(), this.a.j(), this.a.k(), this.a.d());
        WI1 wi1 = this.a;
        List listE0 = c11410cx5.e0();
        AbstractC13042fc3.h(listE0, "proto.typeParameterList");
        WI1 wi1B = WI1.b(wi1, c17640nJ1, listE0, null, null, null, null, 60, null);
        c17640nJ1.P0(wi1B.i().k(), wi1B.i().l(AbstractC3921Cx5.n(c11410cx5, this.a.j()), false), wi1B.i().l(AbstractC3921Cx5.b(c11410cx5, this.a.j()), false), d(c17640nJ1, wi1B.i()));
        return c17640nJ1;
    }
}
