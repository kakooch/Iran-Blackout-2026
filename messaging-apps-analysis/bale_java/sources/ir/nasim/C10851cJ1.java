package ir.nasim;

import ir.nasim.AbstractC16253kx5;
import ir.nasim.C10938cS7;
import ir.nasim.C21830uC4;
import ir.nasim.C6526Nw5;
import ir.nasim.InterfaceC22011uW5;
import ir.nasim.M17;
import ir.nasim.W24;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.cJ1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C10851cJ1 extends E0 implements InterfaceC12795fB1 {
    private final C6526Nw5 f;
    private final AbstractC7310Re0 g;
    private final JH6 h;
    private final C24948zU0 i;
    private final EnumC11067cg4 j;
    private final RI1 k;
    private final AU0 l;
    private final WI1 m;
    private final X24 n;
    private final b o;
    private final C21421td6 p;
    private final c q;
    private final InterfaceC12795fB1 r;
    private final InterfaceC20580sF4 s;
    private final InterfaceC23016wC4 t;
    private final InterfaceC20580sF4 u;
    private final InterfaceC23016wC4 v;
    private final AbstractC16253kx5.a w;
    private final InterfaceC4356Eu x;

    /* renamed from: ir.nasim.cJ1$a */
    private final class a extends AbstractC14076hJ1 {
        private final AbstractC5284Ir3 g;
        private final InterfaceC23016wC4 h;
        private final InterfaceC23016wC4 i;
        final /* synthetic */ C10851cJ1 j;

        /* renamed from: ir.nasim.cJ1$a$a, reason: collision with other inner class name */
        static final class C0933a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ List e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0933a(List list) {
                super(0);
                this.e = list;
            }

            @Override // ir.nasim.SA2
            public final List invoke() {
                return this.e;
            }
        }

        /* renamed from: ir.nasim.cJ1$a$b */
        static final class b extends AbstractC8614Ws3 implements SA2 {
            b() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection invoke() {
                return a.this.k(C24841zI1.o, W24.a.a(), FA4.WHEN_GET_ALL_DESCRIPTORS);
            }
        }

        /* renamed from: ir.nasim.cJ1$a$c */
        public static final class c extends AbstractC16980mB4 {
            final /* synthetic */ List a;

            c(List list) {
                this.a = list;
            }

            @Override // ir.nasim.AbstractC10899cO4
            public void a(InterfaceC15194jA0 interfaceC15194jA0) {
                AbstractC13042fc3.i(interfaceC15194jA0, "fakeOverride");
                C11663dO4.N(interfaceC15194jA0, null);
                this.a.add(interfaceC15194jA0);
            }

            @Override // ir.nasim.AbstractC16980mB4
            protected void e(InterfaceC15194jA0 interfaceC15194jA0, InterfaceC15194jA0 interfaceC15194jA02) {
                AbstractC13042fc3.i(interfaceC15194jA0, "fromSuper");
                AbstractC13042fc3.i(interfaceC15194jA02, "fromCurrent");
            }
        }

        /* renamed from: ir.nasim.cJ1$a$d */
        static final class d extends AbstractC8614Ws3 implements SA2 {
            d() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection invoke() {
                return a.this.g.f(a.this.C());
            }
        }

        public a(C10851cJ1 c10851cJ1, AbstractC5284Ir3 abstractC5284Ir3) {
            AbstractC13042fc3.i(c10851cJ1, "this$0");
            AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
            this.j = c10851cJ1;
            WI1 wi1V0 = c10851cJ1.V0();
            List listV0 = c10851cJ1.W0().v0();
            AbstractC13042fc3.h(listV0, "classProto.functionList");
            List listZ0 = c10851cJ1.W0().z0();
            AbstractC13042fc3.h(listZ0, "classProto.propertyList");
            List listH0 = c10851cJ1.W0().H0();
            AbstractC13042fc3.h(listH0, "classProto.typeAliasList");
            List listW0 = c10851cJ1.W0().w0();
            AbstractC13042fc3.h(listW0, "classProto.nestedClassNameList");
            List list = listW0;
            InterfaceC6692Oo4 interfaceC6692Oo4G = c10851cJ1.V0().g();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC7170Qo4.b(interfaceC6692Oo4G, ((Number) it.next()).intValue()));
            }
            super(wi1V0, listV0, listZ0, listH0, new C0933a(arrayList));
            this.g = abstractC5284Ir3;
            this.h = q().h().c(new b());
            this.i = q().h().c(new d());
        }

        private final void B(C6432No4 c6432No4, Collection collection, List list) {
            q().c().m().a().y(c6432No4, collection, new ArrayList(list), C(), new c(list));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C10851cJ1 C() {
            return this.j;
        }

        public void D(C6432No4 c6432No4, IJ3 ij3) {
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(ij3, "location");
            AbstractC21932uN7.a(q().c().o(), ij3, C(), c6432No4);
        }

        @Override // ir.nasim.AbstractC14076hJ1, ir.nasim.X24, ir.nasim.W24
        public Collection b(C6432No4 c6432No4, IJ3 ij3) {
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(ij3, "location");
            D(c6432No4, ij3);
            return super.b(c6432No4, ij3);
        }

        @Override // ir.nasim.AbstractC14076hJ1, ir.nasim.X24, ir.nasim.W24
        public Collection d(C6432No4 c6432No4, IJ3 ij3) {
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(ij3, "location");
            D(c6432No4, ij3);
            return super.d(c6432No4, ij3);
        }

        @Override // ir.nasim.AbstractC14076hJ1, ir.nasim.X24, ir.nasim.InterfaceC22011uW5
        public MU0 e(C6432No4 c6432No4, IJ3 ij3) {
            InterfaceC21331tU0 interfaceC21331tU0F;
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(ij3, "location");
            D(c6432No4, ij3);
            c cVar = C().q;
            return (cVar == null || (interfaceC21331tU0F = cVar.f(c6432No4)) == null) ? super.e(c6432No4, ij3) : interfaceC21331tU0F;
        }

        @Override // ir.nasim.X24, ir.nasim.InterfaceC22011uW5
        public Collection f(C24841zI1 c24841zI1, UA2 ua2) {
            AbstractC13042fc3.i(c24841zI1, "kindFilter");
            AbstractC13042fc3.i(ua2, "nameFilter");
            return (Collection) this.h.invoke();
        }

        @Override // ir.nasim.AbstractC14076hJ1
        protected void j(Collection collection, UA2 ua2) {
            AbstractC13042fc3.i(collection, "result");
            AbstractC13042fc3.i(ua2, "nameFilter");
            c cVar = C().q;
            List listD = cVar == null ? null : cVar.d();
            if (listD == null) {
                listD = AbstractC10360bX0.m();
            }
            collection.addAll(listD);
        }

        @Override // ir.nasim.AbstractC14076hJ1
        protected void l(C6432No4 c6432No4, List list) {
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(list, "functions");
            ArrayList arrayList = new ArrayList();
            Iterator it = ((Collection) this.i.invoke()).iterator();
            while (it.hasNext()) {
                arrayList.addAll(((AbstractC4099Dr3) it.next()).o().d(c6432No4, FA4.FOR_ALREADY_TRACKED));
            }
            list.addAll(q().c().c().e(c6432No4, this.j));
            B(c6432No4, arrayList, list);
        }

        @Override // ir.nasim.AbstractC14076hJ1
        protected void m(C6432No4 c6432No4, List list) {
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(list, "descriptors");
            ArrayList arrayList = new ArrayList();
            Iterator it = ((Collection) this.i.invoke()).iterator();
            while (it.hasNext()) {
                arrayList.addAll(((AbstractC4099Dr3) it.next()).o().b(c6432No4, FA4.FOR_ALREADY_TRACKED));
            }
            B(c6432No4, arrayList, list);
        }

        @Override // ir.nasim.AbstractC14076hJ1
        protected C24948zU0 n(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "name");
            C24948zU0 c24948zU0D = this.j.i.d(c6432No4);
            AbstractC13042fc3.h(c24948zU0D, "classId.createNestedClassId(name)");
            return c24948zU0D;
        }

        @Override // ir.nasim.AbstractC14076hJ1
        protected Set t() {
            List listB = C().o.b();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = listB.iterator();
            while (it.hasNext()) {
                Set setG = ((AbstractC4099Dr3) it.next()).o().g();
                if (setG == null) {
                    return null;
                }
                AbstractC13610gX0.D(linkedHashSet, setG);
            }
            return linkedHashSet;
        }

        @Override // ir.nasim.AbstractC14076hJ1
        protected Set u() {
            List listB = C().o.b();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = listB.iterator();
            while (it.hasNext()) {
                AbstractC13610gX0.D(linkedHashSet, ((AbstractC4099Dr3) it.next()).o().a());
            }
            linkedHashSet.addAll(q().c().c().d(this.j));
            return linkedHashSet;
        }

        @Override // ir.nasim.AbstractC14076hJ1
        protected Set v() {
            List listB = C().o.b();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = listB.iterator();
            while (it.hasNext()) {
                AbstractC13610gX0.D(linkedHashSet, ((AbstractC4099Dr3) it.next()).o().c());
            }
            return linkedHashSet;
        }

        @Override // ir.nasim.AbstractC14076hJ1
        protected boolean y(JC6 jc6) {
            AbstractC13042fc3.i(jc6, "function");
            return q().c().s().c(this.j, jc6);
        }
    }

    /* renamed from: ir.nasim.cJ1$b */
    private final class b extends F0 {
        private final InterfaceC23016wC4 d;
        final /* synthetic */ C10851cJ1 e;

        /* renamed from: ir.nasim.cJ1$b$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C10851cJ1 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C10851cJ1 c10851cJ1) {
                super(0);
                this.e = c10851cJ1;
            }

            @Override // ir.nasim.SA2
            public final List invoke() {
                return AbstractC3459Ay7.d(this.e);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C10851cJ1 c10851cJ1) {
            super(c10851cJ1.V0().h());
            AbstractC13042fc3.i(c10851cJ1, "this$0");
            this.e = c10851cJ1;
            this.d = c10851cJ1.V0().h().c(new a(c10851cJ1));
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
            C9424Zw2 c9424Zw2B;
            List listK = AbstractC3921Cx5.k(this.e.W0(), this.e.V0().j());
            C10851cJ1 c10851cJ1 = this.e;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listK, 10));
            Iterator it = listK.iterator();
            while (it.hasNext()) {
                arrayList.add(c10851cJ1.V0().i().p((C10647bx5) it.next()));
            }
            List listR0 = AbstractC15401jX0.R0(arrayList, this.e.V0().c().c().b(this.e));
            ArrayList<C21830uC4.b> arrayList2 = new ArrayList();
            Iterator it2 = listR0.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                MU0 mu0T = ((AbstractC4099Dr3) it2.next()).K0().t();
                C21830uC4.b bVar = mu0T instanceof C21830uC4.b ? (C21830uC4.b) mu0T : null;
                if (bVar != null) {
                    arrayList2.add(bVar);
                }
            }
            if (!arrayList2.isEmpty()) {
                InterfaceC11005ca2 interfaceC11005ca2I = this.e.V0().c().i();
                C10851cJ1 c10851cJ12 = this.e;
                ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
                for (C21830uC4.b bVar2 : arrayList2) {
                    C24948zU0 c24948zU0H = PI1.h(bVar2);
                    String strB = (c24948zU0H == null || (c9424Zw2B = c24948zU0H.b()) == null) ? null : c9424Zw2B.b();
                    if (strB == null) {
                        strB = bVar2.getName().h();
                    }
                    arrayList3.add(strB);
                }
                interfaceC11005ca2I.b(c10851cJ12, arrayList3);
            }
            return AbstractC15401jX0.m1(listR0);
        }

        @Override // ir.nasim.AbstractC12686f2
        protected M17 l() {
            return M17.a.a;
        }

        public String toString() {
            String string = this.e.getName().toString();
            AbstractC13042fc3.h(string, "name.toString()");
            return string;
        }

        @Override // ir.nasim.F0
        /* renamed from: v, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public C10851cJ1 t() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.cJ1$c */
    private final class c {
        private final Map a;
        private final J34 b;
        private final InterfaceC23016wC4 c;
        final /* synthetic */ C10851cJ1 d;

        /* renamed from: ir.nasim.cJ1$c$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C10851cJ1 f;

            /* renamed from: ir.nasim.cJ1$c$a$a, reason: collision with other inner class name */
            static final class C0934a extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ C10851cJ1 e;
                final /* synthetic */ C7477Rw5 f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0934a(C10851cJ1 c10851cJ1, C7477Rw5 c7477Rw5) {
                    super(0);
                    this.e = c10851cJ1;
                    this.f = c7477Rw5;
                }

                @Override // ir.nasim.SA2
                public final List invoke() {
                    return AbstractC15401jX0.m1(this.e.V0().c().d().b(this.e.a1(), this.f));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C10851cJ1 c10851cJ1) {
                super(1);
                this.f = c10851cJ1;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC21331tU0 invoke(C6432No4 c6432No4) {
                AbstractC13042fc3.i(c6432No4, "name");
                C7477Rw5 c7477Rw5 = (C7477Rw5) c.this.a.get(c6432No4);
                if (c7477Rw5 == null) {
                    return null;
                }
                C10851cJ1 c10851cJ1 = this.f;
                return J92.K0(c10851cJ1.V0().h(), c10851cJ1, c6432No4, c.this.c, new YI1(c10851cJ1.V0().h(), new C0934a(c10851cJ1, c7477Rw5)), JH6.a);
            }
        }

        /* renamed from: ir.nasim.cJ1$c$b */
        static final class b extends AbstractC8614Ws3 implements SA2 {
            b() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set invoke() {
                return c.this.e();
            }
        }

        public c(C10851cJ1 c10851cJ1) {
            AbstractC13042fc3.i(c10851cJ1, "this$0");
            this.d = c10851cJ1;
            List listQ0 = c10851cJ1.W0().q0();
            AbstractC13042fc3.h(listQ0, "classProto.enumEntryList");
            List list = listQ0;
            LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(list, 10)), 16));
            for (Object obj : list) {
                linkedHashMap.put(AbstractC7170Qo4.b(c10851cJ1.V0().g(), ((C7477Rw5) obj).J()), obj);
            }
            this.a = linkedHashMap;
            this.b = this.d.V0().h().b(new a(this.d));
            this.c = this.d.V0().h().c(new b());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set e() {
            HashSet hashSet = new HashSet();
            Iterator it = this.d.j().b().iterator();
            while (it.hasNext()) {
                for (InterfaceC12795fB1 interfaceC12795fB1 : InterfaceC22011uW5.a.a(((AbstractC4099Dr3) it.next()).o(), null, null, 3, null)) {
                    if ((interfaceC12795fB1 instanceof JC6) || (interfaceC12795fB1 instanceof InterfaceC20989sw5)) {
                        hashSet.add(interfaceC12795fB1.getName());
                    }
                }
            }
            List listV0 = this.d.W0().v0();
            AbstractC13042fc3.h(listV0, "classProto.functionList");
            C10851cJ1 c10851cJ1 = this.d;
            Iterator it2 = listV0.iterator();
            while (it2.hasNext()) {
                hashSet.add(AbstractC7170Qo4.b(c10851cJ1.V0().g(), ((C7950Tw5) it2.next()).Z()));
            }
            List listZ0 = this.d.W0().z0();
            AbstractC13042fc3.h(listZ0, "classProto.propertyList");
            C10851cJ1 c10851cJ12 = this.d;
            Iterator it3 = listZ0.iterator();
            while (it3.hasNext()) {
                hashSet.add(AbstractC7170Qo4.b(c10851cJ12.V0().g(), ((C9193Yw5) it3.next()).Y()));
            }
            return AbstractC4846Gu6.l(hashSet, hashSet);
        }

        public final Collection d() {
            Set setKeySet = this.a.keySet();
            ArrayList arrayList = new ArrayList();
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                InterfaceC21331tU0 interfaceC21331tU0F = f((C6432No4) it.next());
                if (interfaceC21331tU0F != null) {
                    arrayList.add(interfaceC21331tU0F);
                }
            }
            return arrayList;
        }

        public final InterfaceC21331tU0 f(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "name");
            return (InterfaceC21331tU0) this.b.invoke(c6432No4);
        }
    }

    /* renamed from: ir.nasim.cJ1$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            return AbstractC15401jX0.m1(C10851cJ1.this.V0().c().d().f(C10851cJ1.this.a1()));
        }
    }

    /* renamed from: ir.nasim.cJ1$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC21331tU0 invoke() {
            return C10851cJ1.this.Q0();
        }
    }

    /* renamed from: ir.nasim.cJ1$f */
    static final class f extends AbstractC8614Ws3 implements SA2 {
        f() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection invoke() {
            return C10851cJ1.this.R0();
        }
    }

    /* renamed from: ir.nasim.cJ1$g */
    /* synthetic */ class g extends DB2 implements UA2 {
        g(C10851cJ1 c10851cJ1) {
            super(1, c10851cJ1);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "<init>";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(a.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final a invoke(AbstractC5284Ir3 abstractC5284Ir3) {
            AbstractC13042fc3.i(abstractC5284Ir3, "p0");
            return new a((C10851cJ1) this.receiver, abstractC5284Ir3);
        }
    }

    /* renamed from: ir.nasim.cJ1$h */
    static final class h extends AbstractC8614Ws3 implements SA2 {
        h() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC18329oU0 invoke() {
            return C10851cJ1.this.S0();
        }
    }

    /* renamed from: ir.nasim.cJ1$i */
    static final class i extends AbstractC8614Ws3 implements SA2 {
        i() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection invoke() {
            return C10851cJ1.this.U0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10851cJ1(WI1 wi1, C6526Nw5 c6526Nw5, InterfaceC6692Oo4 interfaceC6692Oo4, AbstractC7310Re0 abstractC7310Re0, JH6 jh6) {
        super(wi1.h(), AbstractC7170Qo4.a(interfaceC6692Oo4, c6526Nw5.s0()).j());
        AbstractC13042fc3.i(wi1, "outerContext");
        AbstractC13042fc3.i(c6526Nw5, "classProto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(abstractC7310Re0, "metadataVersion");
        AbstractC13042fc3.i(jh6, "sourceElement");
        this.f = c6526Nw5;
        this.g = abstractC7310Re0;
        this.h = jh6;
        this.i = AbstractC7170Qo4.a(interfaceC6692Oo4, c6526Nw5.s0());
        C18617ox5 c18617ox5 = C18617ox5.a;
        this.j = c18617ox5.b((EnumC8418Vw5) AbstractC5031Hp2.d.d(c6526Nw5.r0()));
        this.k = AbstractC19208px5.a(c18617ox5, (EnumC15071ix5) AbstractC5031Hp2.c.d(c6526Nw5.r0()));
        AU0 au0A = c18617ox5.a((C6526Nw5.c) AbstractC5031Hp2.e.d(c6526Nw5.r0()));
        this.l = au0A;
        List listK0 = c6526Nw5.K0();
        AbstractC13042fc3.h(listK0, "classProto.typeParameterList");
        C12644ex5 c12644ex5L0 = c6526Nw5.L0();
        AbstractC13042fc3.h(c12644ex5L0, "classProto.typeTable");
        C7029Py7 c7029Py7 = new C7029Py7(c12644ex5L0);
        C10938cS7.a aVar = C10938cS7.b;
        C14464hx5 c14464hx5N0 = c6526Nw5.N0();
        AbstractC13042fc3.h(c14464hx5N0, "classProto.versionRequirementTable");
        WI1 wi1A = wi1.a(this, listK0, interfaceC6692Oo4, c7029Py7, aVar.a(c14464hx5N0), abstractC7310Re0);
        this.m = wi1A;
        AU0 au0 = AU0.ENUM_CLASS;
        this.n = au0A == au0 ? new C18263oM6(wi1A.h(), this) : W24.b.b;
        this.o = new b(this);
        this.p = C21421td6.e.a(this, wi1A.h(), wi1A.c().m().d(), new g(this));
        this.q = au0A == au0 ? new c(this) : null;
        InterfaceC12795fB1 interfaceC12795fB1E = wi1.e();
        this.r = interfaceC12795fB1E;
        this.s = wi1A.h().g(new h());
        this.t = wi1A.h().c(new f());
        this.u = wi1A.h().g(new e());
        this.v = wi1A.h().c(new i());
        InterfaceC6692Oo4 interfaceC6692Oo4G = wi1A.g();
        C7029Py7 c7029Py7J = wi1A.j();
        C10851cJ1 c10851cJ1 = interfaceC12795fB1E instanceof C10851cJ1 ? (C10851cJ1) interfaceC12795fB1E : null;
        this.w = new AbstractC16253kx5.a(c6526Nw5, interfaceC6692Oo4G, c7029Py7J, jh6, c10851cJ1 != null ? c10851cJ1.w : null);
        this.x = !AbstractC5031Hp2.b.d(c6526Nw5.r0()).booleanValue() ? InterfaceC4356Eu.W.b() : new C14605iB4(wi1A.h(), new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC21331tU0 Q0() {
        if (!this.f.O0()) {
            return null;
        }
        MU0 mu0E = X0().e(AbstractC7170Qo4.b(this.m.g(), this.f.i0()), FA4.FROM_DESERIALIZATION);
        if (mu0E instanceof InterfaceC21331tU0) {
            return (InterfaceC21331tU0) mu0E;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection R0() {
        return AbstractC15401jX0.R0(AbstractC15401jX0.R0(T0(), AbstractC10360bX0.q(D())), this.m.c().c().a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC18329oU0 S0() {
        Object next;
        if (this.l.a()) {
            C18920pU0 c18920pU0I = AbstractC23657xI1.i(this, JH6.a);
            c18920pU0I.f1(p());
            return c18920pU0I;
        }
        List listL0 = this.f.l0();
        AbstractC13042fc3.h(listL0, "classProto.constructorList");
        Iterator it = listL0.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!AbstractC5031Hp2.l.d(((C6765Ow5) next).N()).booleanValue()) {
                break;
            }
        }
        C6765Ow5 c6765Ow5 = (C6765Ow5) next;
        if (c6765Ow5 == null) {
            return null;
        }
        return V0().f().m(c6765Ow5, true);
    }

    private final List T0() {
        List listL0 = this.f.l0();
        AbstractC13042fc3.h(listL0, "classProto.constructorList");
        ArrayList<C6765Ow5> arrayList = new ArrayList();
        for (Object obj : listL0) {
            Boolean boolD = AbstractC5031Hp2.l.d(((C6765Ow5) obj).N());
            AbstractC13042fc3.h(boolD, "IS_SECONDARY.get(it.flags)");
            if (boolD.booleanValue()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
        for (C6765Ow5 c6765Ow5 : arrayList) {
            C21732u24 c21732u24F = V0().f();
            AbstractC13042fc3.h(c6765Ow5, "it");
            arrayList2.add(c21732u24F.m(c6765Ow5, false));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection U0() {
        if (this.j != EnumC11067cg4.SEALED) {
            return AbstractC10360bX0.m();
        }
        List<Integer> listA0 = this.f.A0();
        AbstractC13042fc3.h(listA0, "fqNames");
        if (!(!listA0.isEmpty())) {
            return C15383jV0.a.a(this, false);
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : listA0) {
            TI1 ti1C = V0().c();
            InterfaceC6692Oo4 interfaceC6692Oo4G = V0().g();
            AbstractC13042fc3.h(num, "index");
            InterfaceC21331tU0 interfaceC21331tU0B = ti1C.b(AbstractC7170Qo4.a(interfaceC6692Oo4G, num.intValue()));
            if (interfaceC21331tU0B != null) {
                arrayList.add(interfaceC21331tU0B);
            }
        }
        return arrayList;
    }

    private final a X0() {
        return (a) this.p.c(this.m.c().m().d());
    }

    @Override // ir.nasim.NU0
    public boolean A() {
        Boolean boolD = AbstractC5031Hp2.f.d(this.f.r0());
        AbstractC13042fc3.h(boolD, "IS_INNER.get(classProto.flags)");
        return boolD.booleanValue();
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public InterfaceC18329oU0 D() {
        return (InterfaceC18329oU0) this.s.invoke();
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean F0() {
        Boolean boolD = AbstractC5031Hp2.g.d(this.f.r0());
        AbstractC13042fc3.h(boolD, "IS_DATA.get(classProto.flags)");
        return boolD.booleanValue();
    }

    @Override // ir.nasim.AbstractC6615Og4
    protected W24 M(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        return this.p.c(abstractC5284Ir3);
    }

    public final WI1 V0() {
        return this.m;
    }

    public final C6526Nw5 W0() {
        return this.f;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean Y() {
        return false;
    }

    public final AbstractC7310Re0 Y0() {
        return this.g;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public X24 m0() {
        return this.n;
    }

    public final AbstractC16253kx5.a a1() {
        return this.w;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC14004hB1, ir.nasim.InterfaceC12795fB1
    public InterfaceC12795fB1 b() {
        return this.r;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean b0() {
        return AbstractC5031Hp2.e.d(this.f.r0()) == C6526Nw5.c.COMPANION_OBJECT;
    }

    public final boolean b1(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "name");
        return X0().r().contains(c6432No4);
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public AU0 f() {
        return this.l;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean f0() {
        Boolean boolD = AbstractC5031Hp2.k.d(this.f.r0());
        AbstractC13042fc3.h(boolD, "IS_FUN_INTERFACE.get(classProto.flags)");
        return boolD.booleanValue();
    }

    @Override // ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        return this.x;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC16977mB1
    public RI1 getVisibility() {
        return this.k;
    }

    @Override // ir.nasim.InterfaceC16386lB1
    public JH6 i() {
        return this.h;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean isExternal() {
        Boolean boolD = AbstractC5031Hp2.h.d(this.f.r0());
        AbstractC13042fc3.h(boolD, "IS_EXTERNAL_CLASS.get(classProto.flags)");
        return boolD.booleanValue();
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean isInline() {
        Boolean boolD = AbstractC5031Hp2.j.d(this.f.r0());
        AbstractC13042fc3.h(boolD, "IS_INLINE_CLASS.get(classProto.flags)");
        return boolD.booleanValue() && this.g.e(1, 4, 1);
    }

    @Override // ir.nasim.MU0
    public InterfaceC13882gy7 j() {
        return this.o;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public Collection k() {
        return (Collection) this.t.invoke();
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean k0() {
        Boolean boolD = AbstractC5031Hp2.j.d(this.f.r0());
        AbstractC13042fc3.h(boolD, "IS_INLINE_CLASS.get(classProto.flags)");
        return boolD.booleanValue() && this.g.c(1, 4, 2);
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean l0() {
        Boolean boolD = AbstractC5031Hp2.i.d(this.f.r0());
        AbstractC13042fc3.h(boolD, "IS_EXPECT_CLASS.get(classProto.flags)");
        return boolD.booleanValue();
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public InterfaceC21331tU0 n0() {
        return (InterfaceC21331tU0) this.u.invoke();
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.NU0
    public List q() {
        return this.m.i().k();
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC21058t24
    public EnumC11067cg4 r() {
        return this.j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("deserialized ");
        sb.append(l0() ? "expect " : "");
        sb.append("class ");
        sb.append(getName());
        return sb.toString();
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public Collection y() {
        return (Collection) this.v.invoke();
    }
}
