package ir.nasim;

import ir.nasim.C21830uC4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.Tv3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7939Tv3 extends AbstractC21988uU0 implements InterfaceC7811Th3 {
    public static final a x = new a(null);
    private static final Set y = AbstractC4597Fu6.i("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");
    private final C9182Yv3 i;
    private final InterfaceC7106Qh3 j;
    private final InterfaceC21331tU0 k;
    private final C9182Yv3 l;
    private final AU0 m;
    private final EnumC11067cg4 n;
    private final GY7 o;
    private final boolean p;
    private final b q;
    private final C8173Uv3 r;
    private final C21421td6 s;
    private final C14575i83 t;
    private final C10019aw3 u;
    private final InterfaceC4356Eu v;
    private final InterfaceC23016wC4 w;

    /* renamed from: ir.nasim.Tv3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Tv3$b */
    private final class b extends F0 {
        private final InterfaceC23016wC4 d;
        final /* synthetic */ C7939Tv3 e;

        /* renamed from: ir.nasim.Tv3$b$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C7939Tv3 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C7939Tv3 c7939Tv3) {
                super(0);
                this.e = c7939Tv3;
            }

            @Override // ir.nasim.SA2
            public final List invoke() {
                return AbstractC3459Ay7.d(this.e);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C7939Tv3 c7939Tv3) {
            super(c7939Tv3.l.e());
            AbstractC13042fc3.i(c7939Tv3, "this$0");
            this.e = c7939Tv3;
            this.d = c7939Tv3.l.e().c(new a(c7939Tv3));
        }

        private final AbstractC4099Dr3 v() {
            C9424Zw2 c9424Zw2B;
            ArrayList arrayList;
            C9424Zw2 c9424Zw2W = w();
            if (c9424Zw2W == null || c9424Zw2W.d() || !c9424Zw2W.i(PJ6.l)) {
                c9424Zw2W = null;
            }
            if (c9424Zw2W == null) {
                c9424Zw2B = C3756Cf2.a.b(PI1.i(this.e));
                if (c9424Zw2B == null) {
                    return null;
                }
            } else {
                c9424Zw2B = c9424Zw2W;
            }
            InterfaceC21331tU0 interfaceC21331tU0R = PI1.r(this.e.l.d(), c9424Zw2B, FA4.FROM_JAVA_LOADER);
            if (interfaceC21331tU0R == null) {
                return null;
            }
            int size = interfaceC21331tU0R.j().getParameters().size();
            List parameters = this.e.j().getParameters();
            AbstractC13042fc3.h(parameters, "getTypeConstructor().parameters");
            int size2 = parameters.size();
            if (size2 == size) {
                List list = parameters;
                arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new C4400Ey7(KQ7.INVARIANT, ((InterfaceC22882vy7) it.next()).p()));
                }
            } else {
                if (size2 != 1 || size <= 1 || c9424Zw2W != null) {
                    return null;
                }
                C4400Ey7 c4400Ey7 = new C4400Ey7(KQ7.INVARIANT, ((InterfaceC22882vy7) AbstractC15401jX0.V0(parameters)).p());
                C24411ya3 c24411ya3 = new C24411ya3(1, size);
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(c24411ya3, 10));
                Iterator it2 = c24411ya3.iterator();
                while (it2.hasNext()) {
                    ((AbstractC18386oa3) it2).b();
                    arrayList2.add(c4400Ey7);
                }
                arrayList = arrayList2;
            }
            C4567Fr3 c4567Fr3 = C4567Fr3.a;
            return C4567Fr3.g(InterfaceC4356Eu.W.b(), interfaceC21331tU0R, arrayList);
        }

        private final C9424Zw2 w() {
            InterfaceC4356Eu annotations = this.e.getAnnotations();
            C9424Zw2 c9424Zw2 = AbstractC24521yl3.o;
            AbstractC13042fc3.h(c9424Zw2, "PURELY_IMPLEMENTS_ANNOTATION");
            InterfaceC21651tu interfaceC21651tuZ = annotations.z(c9424Zw2);
            if (interfaceC21651tuZ == null) {
                return null;
            }
            Object objW0 = AbstractC15401jX0.W0(interfaceC21651tuZ.j().values());
            C9790aZ6 c9790aZ6 = objW0 instanceof C9790aZ6 ? (C9790aZ6) objW0 : null;
            String str = c9790aZ6 == null ? null : (String) c9790aZ6.b();
            if (str != null && AbstractC10644bx2.c(str)) {
                return new C9424Zw2(str);
            }
            return null;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public boolean e() {
            return true;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public List getParameters() {
            return (List) this.d.invoke();
        }

        @Override // ir.nasim.AbstractC12686f2
        protected Collection h() {
            Collection collectionB = this.e.O0().b();
            ArrayList arrayList = new ArrayList(collectionB.size());
            ArrayList arrayList2 = new ArrayList(0);
            AbstractC4099Dr3 abstractC4099Dr3V = v();
            Iterator it = collectionB.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                InterfaceC9056Yh3 interfaceC9056Yh3 = (InterfaceC9056Yh3) it.next();
                AbstractC4099Dr3 abstractC4099Dr3N = this.e.l.g().n(interfaceC9056Yh3, AbstractC8790Xi3.f(EnumC7263Qy7.SUPERTYPE, false, null, 3, null));
                if (this.e.l.a().p().b()) {
                    abstractC4099Dr3N = this.e.l.a().q().f(abstractC4099Dr3N, this.e.l);
                }
                if (abstractC4099Dr3N.K0().t() instanceof C21830uC4.b) {
                    arrayList2.add(interfaceC9056Yh3);
                }
                if (!AbstractC13042fc3.d(abstractC4099Dr3N.K0(), abstractC4099Dr3V != null ? abstractC4099Dr3V.K0() : null) && !AbstractC19738qr3.a0(abstractC4099Dr3N)) {
                    arrayList.add(abstractC4099Dr3N);
                }
            }
            InterfaceC21331tU0 interfaceC21331tU0 = this.e.k;
            YW0.a(arrayList, interfaceC21331tU0 != null ? AbstractC15914kO3.a(interfaceC21331tU0, this.e).c().p(interfaceC21331tU0.p(), KQ7.INVARIANT) : null);
            YW0.a(arrayList, abstractC4099Dr3V);
            if (!arrayList2.isEmpty()) {
                InterfaceC11005ca2 interfaceC11005ca2C = this.e.l.a().c();
                InterfaceC21331tU0 interfaceC21331tU0T = t();
                ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(((InterfaceC9056Yh3) ((InterfaceC6138Mi3) it2.next())).G());
                }
                interfaceC11005ca2C.b(interfaceC21331tU0T, arrayList3);
            }
            return arrayList.isEmpty() ^ true ? AbstractC15401jX0.m1(arrayList) : AbstractC9766aX0.e(this.e.l.d().n().i());
        }

        @Override // ir.nasim.AbstractC12686f2
        protected M17 l() {
            return this.e.l.a().u();
        }

        @Override // ir.nasim.AbstractC12686f2, ir.nasim.InterfaceC13882gy7
        public InterfaceC21331tU0 t() {
            return this.e;
        }

        public String toString() {
            String strH = this.e.getName().h();
            AbstractC13042fc3.h(strH, "name.asString()");
            return strH;
        }
    }

    /* renamed from: ir.nasim.Tv3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            List<InterfaceC7583Si3> typeParameters = C7939Tv3.this.O0().getTypeParameters();
            C7939Tv3 c7939Tv3 = C7939Tv3.this;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(typeParameters, 10));
            for (InterfaceC7583Si3 interfaceC7583Si3 : typeParameters) {
                InterfaceC22882vy7 interfaceC22882vy7A = c7939Tv3.l.f().a(interfaceC7583Si3);
                if (interfaceC22882vy7A == null) {
                    throw new AssertionError("Parameter " + interfaceC7583Si3 + " surely belongs to class " + c7939Tv3.O0() + ", so it must be resolved");
                }
                arrayList.add(interfaceC22882vy7A);
            }
            return arrayList;
        }
    }

    /* renamed from: ir.nasim.Tv3$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C8173Uv3 invoke(AbstractC5284Ir3 abstractC5284Ir3) {
            AbstractC13042fc3.i(abstractC5284Ir3, "it");
            C9182Yv3 c9182Yv3 = C7939Tv3.this.l;
            C7939Tv3 c7939Tv3 = C7939Tv3.this;
            return new C8173Uv3(c9182Yv3, c7939Tv3, c7939Tv3.O0(), C7939Tv3.this.k != null, C7939Tv3.this.r);
        }
    }

    public /* synthetic */ C7939Tv3(C9182Yv3 c9182Yv3, InterfaceC12795fB1 interfaceC12795fB1, InterfaceC7106Qh3 interfaceC7106Qh3, InterfaceC21331tU0 interfaceC21331tU0, int i, ED1 ed1) {
        this(c9182Yv3, interfaceC12795fB1, interfaceC7106Qh3, (i & 8) != 0 ? null : interfaceC21331tU0);
    }

    @Override // ir.nasim.NU0
    public boolean A() {
        return this.p;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public InterfaceC18329oU0 D() {
        return null;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean F0() {
        return false;
    }

    public final C7939Tv3 M0(InterfaceC3550Bi3 interfaceC3550Bi3, InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(interfaceC3550Bi3, "javaResolverCache");
        C9182Yv3 c9182Yv3 = this.l;
        C9182Yv3 c9182Yv3J = AbstractC4760Gl1.j(c9182Yv3, c9182Yv3.a().v(interfaceC3550Bi3));
        InterfaceC12795fB1 interfaceC12795fB1B = b();
        AbstractC13042fc3.h(interfaceC12795fB1B, "containingDeclaration");
        return new C7939Tv3(c9182Yv3J, interfaceC12795fB1B, this.j, interfaceC21331tU0);
    }

    @Override // ir.nasim.InterfaceC21331tU0
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public List k() {
        return (List) this.r.w0().invoke();
    }

    public final InterfaceC7106Qh3 O0() {
        return this.j;
    }

    @Override // ir.nasim.E0, ir.nasim.InterfaceC21331tU0
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public C8173Uv3 W() {
        return (C8173Uv3) super.W();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC6615Og4
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public C8173Uv3 M(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        return (C8173Uv3) this.s.c(abstractC5284Ir3);
    }

    @Override // ir.nasim.E0, ir.nasim.InterfaceC21331tU0
    public W24 U() {
        return this.t;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean Y() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean b0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public AU0 f() {
        return this.m;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean f0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        return this.v;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC16977mB1
    public RI1 getVisibility() {
        if (!AbstractC13042fc3.d(this.o, QI1.a) || this.j.j() != null) {
            return AbstractC22522vN7.b(this.o);
        }
        RI1 ri1 = AbstractC13129fi3.a;
        AbstractC13042fc3.h(ri1, "{\n            JavaDescriptorVisibilities.PACKAGE_VISIBILITY\n        }");
        return ri1;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean isInline() {
        return false;
    }

    @Override // ir.nasim.MU0
    public InterfaceC13882gy7 j() {
        return this.q;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean k0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean l0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public W24 m0() {
        return this.u;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public InterfaceC21331tU0 n0() {
        return null;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.NU0
    public List q() {
        return (List) this.w.invoke();
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC21058t24
    public EnumC11067cg4 r() {
        return this.n;
    }

    public String toString() {
        return AbstractC13042fc3.q("Lazy Java class ", PI1.j(this));
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public Collection y() {
        if (this.n != EnumC11067cg4.SEALED) {
            return AbstractC10360bX0.m();
        }
        C6637Oi3 c6637Oi3F = AbstractC8790Xi3.f(EnumC7263Qy7.COMMON, false, null, 3, null);
        Collection collectionD = this.j.D();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionD.iterator();
        while (it.hasNext()) {
            MU0 mu0T = this.l.g().n((InterfaceC9056Yh3) it.next(), c6637Oi3F).K0().t();
            InterfaceC21331tU0 interfaceC21331tU0 = mu0T instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) mu0T : null;
            if (interfaceC21331tU0 != null) {
                arrayList.add(interfaceC21331tU0);
            }
        }
        return arrayList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7939Tv3(C9182Yv3 c9182Yv3, InterfaceC12795fB1 interfaceC12795fB1, InterfaceC7106Qh3 interfaceC7106Qh3, InterfaceC21331tU0 interfaceC21331tU0) {
        EnumC11067cg4 enumC11067cg4A;
        super(c9182Yv3.e(), interfaceC12795fB1, interfaceC7106Qh3.getName(), c9182Yv3.a().s().a(interfaceC7106Qh3), false);
        AbstractC13042fc3.i(c9182Yv3, "outerContext");
        AbstractC13042fc3.i(interfaceC12795fB1, "containingDeclaration");
        AbstractC13042fc3.i(interfaceC7106Qh3, "jClass");
        this.i = c9182Yv3;
        this.j = interfaceC7106Qh3;
        this.k = interfaceC21331tU0;
        C9182Yv3 c9182Yv3D = AbstractC4760Gl1.d(c9182Yv3, this, interfaceC7106Qh3, 0, 4, null);
        this.l = c9182Yv3D;
        c9182Yv3D.a().g().a(interfaceC7106Qh3, this);
        interfaceC7106Qh3.M();
        this.m = interfaceC7106Qh3.n() ? AU0.ANNOTATION_CLASS : interfaceC7106Qh3.L() ? AU0.INTERFACE : interfaceC7106Qh3.v() ? AU0.ENUM_CLASS : AU0.CLASS;
        if (interfaceC7106Qh3.n() || interfaceC7106Qh3.v()) {
            enumC11067cg4A = EnumC11067cg4.FINAL;
        } else {
            enumC11067cg4A = EnumC11067cg4.a.a(false, interfaceC7106Qh3.y() || interfaceC7106Qh3.isAbstract() || interfaceC7106Qh3.L(), !interfaceC7106Qh3.isFinal());
        }
        this.n = enumC11067cg4A;
        this.o = interfaceC7106Qh3.getVisibility();
        this.p = (interfaceC7106Qh3.j() == null || interfaceC7106Qh3.i()) ? false : true;
        this.q = new b(this);
        C8173Uv3 c8173Uv3 = new C8173Uv3(c9182Yv3D, this, interfaceC7106Qh3, interfaceC21331tU0 != null, null, 16, null);
        this.r = c8173Uv3;
        this.s = C21421td6.e.a(this, c9182Yv3D.e(), c9182Yv3D.a().j().d(), new d());
        this.t = new C14575i83(c8173Uv3);
        this.u = new C10019aw3(c9182Yv3D, interfaceC7106Qh3, this);
        this.v = AbstractC7700Sv3.a(c9182Yv3D, interfaceC7106Qh3);
        this.w = c9182Yv3D.e().c(new c());
    }
}
