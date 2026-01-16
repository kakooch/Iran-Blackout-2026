package ir.nasim;

import ir.nasim.AbstractC7955Tx1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.aw3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C10019aw3 extends AbstractC10636bw3 {
    private final InterfaceC7106Qh3 n;
    private final C7939Tv3 o;

    /* renamed from: ir.nasim.aw3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final boolean a(InterfaceC19648qi3 interfaceC19648qi3) {
            AbstractC13042fc3.i(interfaceC19648qi3, "it");
            return interfaceC19648qi3.i();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((InterfaceC19648qi3) obj));
        }
    }

    /* renamed from: ir.nasim.aw3$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C6432No4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C6432No4 c6432No4) {
            super(1);
            this.e = c6432No4;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection invoke(W24 w24) {
            AbstractC13042fc3.i(w24, "it");
            return w24.b(this.e, FA4.WHEN_GET_SUPER_MEMBERS);
        }
    }

    /* renamed from: ir.nasim.aw3$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection invoke(W24 w24) {
            AbstractC13042fc3.i(w24, "it");
            return w24.c();
        }
    }

    /* renamed from: ir.nasim.aw3$d */
    static final class d implements AbstractC7955Tx1.c {
        public static final d a = new d();

        /* renamed from: ir.nasim.aw3$d$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC21331tU0 invoke(AbstractC4099Dr3 abstractC4099Dr3) {
                MU0 mu0T = abstractC4099Dr3.K0().t();
                if (mu0T instanceof InterfaceC21331tU0) {
                    return (InterfaceC21331tU0) mu0T;
                }
                return null;
            }
        }

        d() {
        }

        @Override // ir.nasim.AbstractC7955Tx1.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable a(InterfaceC21331tU0 interfaceC21331tU0) {
            Collection collectionB = interfaceC21331tU0.j().b();
            AbstractC13042fc3.h(collectionB, "it.typeConstructor.supertypes");
            return AbstractC11342cq6.l(AbstractC11342cq6.E(AbstractC15401jX0.g0(collectionB), a.e));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10019aw3(C9182Yv3 c9182Yv3, InterfaceC7106Qh3 interfaceC7106Qh3, C7939Tv3 c7939Tv3) {
        super(c9182Yv3);
        AbstractC13042fc3.i(c9182Yv3, "c");
        AbstractC13042fc3.i(interfaceC7106Qh3, "jClass");
        AbstractC13042fc3.i(c7939Tv3, "ownerDescriptor");
        this.n = interfaceC7106Qh3;
        this.o = c7939Tv3;
    }

    private final Set N(InterfaceC21331tU0 interfaceC21331tU0, Set set, UA2 ua2) {
        AbstractC7955Tx1.b(AbstractC9766aX0.e(interfaceC21331tU0), d.a, new e(interfaceC21331tU0, set, ua2));
        return set;
    }

    private final InterfaceC20989sw5 P(InterfaceC20989sw5 interfaceC20989sw5) {
        if (interfaceC20989sw5.f().a()) {
            return interfaceC20989sw5;
        }
        Collection collectionD = interfaceC20989sw5.d();
        AbstractC13042fc3.h(collectionD, "this.overriddenDescriptors");
        Collection<InterfaceC20989sw5> collection = collectionD;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collection, 10));
        for (InterfaceC20989sw5 interfaceC20989sw52 : collection) {
            AbstractC13042fc3.h(interfaceC20989sw52, "it");
            arrayList.add(P(interfaceC20989sw52));
        }
        return (InterfaceC20989sw5) AbstractC15401jX0.V0(AbstractC15401jX0.j0(arrayList));
    }

    private final Set Q(C6432No4 c6432No4, InterfaceC21331tU0 interfaceC21331tU0) {
        C10019aw3 c10019aw3C = AbstractC14118hN7.c(interfaceC21331tU0);
        return c10019aw3C == null ? AbstractC4597Fu6.d() : AbstractC15401jX0.r1(c10019aw3C.d(c6432No4, FA4.WHEN_GET_SUPER_MEMBERS));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC9416Zv3
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public C20711sU0 p() {
        return new C20711sU0(this.n, a.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC9416Zv3
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public C7939Tv3 C() {
        return this.o;
    }

    @Override // ir.nasim.X24, ir.nasim.InterfaceC22011uW5
    public MU0 e(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return null;
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected Set l(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        return AbstractC4597Fu6.d();
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected Set n(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        Set setQ1 = AbstractC15401jX0.q1(((InterfaceC17568nB1) y().invoke()).a());
        C10019aw3 c10019aw3C = AbstractC14118hN7.c(C());
        Set setA = c10019aw3C == null ? null : c10019aw3C.a();
        if (setA == null) {
            setA = AbstractC4597Fu6.d();
        }
        setQ1.addAll(setA);
        if (this.n.v()) {
            setQ1.addAll(AbstractC10360bX0.p(PJ6.c, PJ6.b));
        }
        return setQ1;
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected void r(Collection collection, C6432No4 c6432No4) {
        AbstractC13042fc3.i(collection, "result");
        AbstractC13042fc3.i(c6432No4, "name");
        Collection collectionE = KI1.e(c6432No4, Q(c6432No4, C()), collection, C(), w().a().c(), w().a().j().a());
        AbstractC13042fc3.h(collectionE, "resolveOverridesForStaticMembers(\n            name,\n            functionsFromSupertypes,\n            result,\n            ownerDescriptor,\n            c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        collection.addAll(collectionE);
        if (this.n.v()) {
            if (AbstractC13042fc3.d(c6432No4, PJ6.c)) {
                JC6 jc6D = AbstractC23657xI1.d(C());
                AbstractC13042fc3.h(jc6D, "createEnumValueOfMethod(ownerDescriptor)");
                collection.add(jc6D);
            } else if (AbstractC13042fc3.d(c6432No4, PJ6.b)) {
                JC6 jc6E = AbstractC23657xI1.e(C());
                AbstractC13042fc3.h(jc6E, "createEnumValuesMethod(ownerDescriptor)");
                collection.add(jc6E);
            }
        }
    }

    @Override // ir.nasim.AbstractC10636bw3, ir.nasim.AbstractC9416Zv3
    protected void s(C6432No4 c6432No4, Collection collection) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(collection, "result");
        Set setN = N(C(), new LinkedHashSet(), new b(c6432No4));
        if (!collection.isEmpty()) {
            Collection collectionE = KI1.e(c6432No4, setN, collection, C(), w().a().c(), w().a().j().a());
            AbstractC13042fc3.h(collectionE, "resolveOverridesForStaticMembers(\n                    name,\n                    propertiesFromSupertypes,\n                    result,\n                    ownerDescriptor,\n                    c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            collection.addAll(collectionE);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : setN) {
            InterfaceC20989sw5 interfaceC20989sw5P = P((InterfaceC20989sw5) obj);
            Object arrayList = linkedHashMap.get(interfaceC20989sw5P);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(interfaceC20989sw5P, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Collection collectionE2 = KI1.e(c6432No4, (Collection) ((Map.Entry) it.next()).getValue(), collection, C(), w().a().c(), w().a().j().a());
            AbstractC13042fc3.h(collectionE2, "resolveOverridesForStaticMembers(\n                    name, it.value, result, ownerDescriptor, c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            AbstractC13610gX0.D(arrayList2, collectionE2);
        }
        collection.addAll(arrayList2);
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected Set t(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        Set setQ1 = AbstractC15401jX0.q1(((InterfaceC17568nB1) y().invoke()).e());
        N(C(), setQ1, c.e);
        return setQ1;
    }

    /* renamed from: ir.nasim.aw3$e */
    public static final class e extends AbstractC7955Tx1.b {
        final /* synthetic */ InterfaceC21331tU0 a;
        final /* synthetic */ Set b;
        final /* synthetic */ UA2 c;

        e(InterfaceC21331tU0 interfaceC21331tU0, Set set, UA2 ua2) {
            this.a = interfaceC21331tU0;
            this.b = set;
            this.c = ua2;
        }

        @Override // ir.nasim.AbstractC7955Tx1.d
        public /* bridge */ /* synthetic */ Object a() {
            e();
            return C19938rB7.a;
        }

        @Override // ir.nasim.AbstractC7955Tx1.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean c(InterfaceC21331tU0 interfaceC21331tU0) {
            AbstractC13042fc3.i(interfaceC21331tU0, "current");
            if (interfaceC21331tU0 == this.a) {
                return true;
            }
            W24 w24M0 = interfaceC21331tU0.m0();
            AbstractC13042fc3.h(w24M0, "current.staticScope");
            if (!(w24M0 instanceof AbstractC10636bw3)) {
                return true;
            }
            this.b.addAll((Collection) this.c.invoke(w24M0));
            return false;
        }

        public void e() {
        }
    }
}
