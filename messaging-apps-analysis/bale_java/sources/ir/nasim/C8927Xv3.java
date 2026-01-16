package ir.nasim;

import ir.nasim.C21625tr3;
import ir.nasim.C24841zI1;
import ir.nasim.InterfaceC17568nB1;
import ir.nasim.InterfaceC20347rr3;
import ir.nasim.InterfaceC8047Uh3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Xv3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8927Xv3 extends AbstractC10636bw3 {
    private final InterfaceC22715vi3 n;
    private final C8407Vv3 o;
    private final InterfaceC20580sF4 p;
    private final J34 q;

    /* renamed from: ir.nasim.Xv3$a */
    private static final class a {
        private final C6432No4 a;
        private final InterfaceC7106Qh3 b;

        public a(C6432No4 c6432No4, InterfaceC7106Qh3 interfaceC7106Qh3) {
            AbstractC13042fc3.i(c6432No4, "name");
            this.a = c6432No4;
            this.b = interfaceC7106Qh3;
        }

        public final InterfaceC7106Qh3 a() {
            return this.b;
        }

        public final C6432No4 b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* renamed from: ir.nasim.Xv3$b */
    private static abstract class b {

        /* renamed from: ir.nasim.Xv3$b$a */
        public static final class a extends b {
            private final InterfaceC21331tU0 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC21331tU0 interfaceC21331tU0) {
                super(null);
                AbstractC13042fc3.i(interfaceC21331tU0, "descriptor");
                this.a = interfaceC21331tU0;
            }

            public final InterfaceC21331tU0 a() {
                return this.a;
            }
        }

        /* renamed from: ir.nasim.Xv3$b$b, reason: collision with other inner class name */
        public static final class C0779b extends b {
            public static final C0779b a = new C0779b();

            private C0779b() {
                super(null);
            }
        }

        /* renamed from: ir.nasim.Xv3$b$c */
        public static final class c extends b {
            public static final c a = new c();

            private c() {
                super(null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Xv3$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C9182Yv3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C9182Yv3 c9182Yv3) {
            super(1);
            this.f = c9182Yv3;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC21331tU0 invoke(a aVar) {
            AbstractC13042fc3.i(aVar, "request");
            C24948zU0 c24948zU0 = new C24948zU0(C8927Xv3.this.C().e(), aVar.b());
            InterfaceC20347rr3.a aVarA = aVar.a() != null ? this.f.a().i().a(aVar.a()) : this.f.a().i().b(c24948zU0);
            InterfaceC22805vr3 interfaceC22805vr3A = aVarA == null ? null : aVarA.a();
            C24948zU0 c24948zU0F = interfaceC22805vr3A == null ? null : interfaceC22805vr3A.f();
            if (c24948zU0F != null && (c24948zU0F.l() || c24948zU0F.k())) {
                return null;
            }
            b bVarR = C8927Xv3.this.R(interfaceC22805vr3A);
            if (bVarR instanceof b.a) {
                return ((b.a) bVarR).a();
            }
            if (bVarR instanceof b.c) {
                return null;
            }
            if (!(bVarR instanceof b.C0779b)) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC7106Qh3 interfaceC7106Qh3A = aVar.a();
            if (interfaceC7106Qh3A == null) {
                InterfaceC8047Uh3 interfaceC8047Uh3D = this.f.a().d();
                if (aVarA != null) {
                    AbstractC18350oW3.a(null);
                }
                interfaceC7106Qh3A = interfaceC8047Uh3D.b(new InterfaceC8047Uh3.a(c24948zU0, null, null, 4, null));
            }
            InterfaceC7106Qh3 interfaceC7106Qh3 = interfaceC7106Qh3A;
            if ((interfaceC7106Qh3 == null ? null : interfaceC7106Qh3.M()) != EnumC23477wz3.BINARY) {
                C9424Zw2 c9424Zw2E = interfaceC7106Qh3 == null ? null : interfaceC7106Qh3.e();
                if (c9424Zw2E == null || c9424Zw2E.d() || !AbstractC13042fc3.d(c9424Zw2E.e(), C8927Xv3.this.C().e())) {
                    return null;
                }
                C7939Tv3 c7939Tv3 = new C7939Tv3(this.f, C8927Xv3.this.C(), interfaceC7106Qh3, null, 8, null);
                this.f.a().e().a(c7939Tv3);
                return c7939Tv3;
            }
            throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + interfaceC7106Qh3 + "\nClassId: " + c24948zU0 + "\nfindKotlinClass(JavaClass) = " + AbstractC20938sr3.b(this.f.a().i(), interfaceC7106Qh3) + "\nfindKotlinClass(ClassId) = " + AbstractC20938sr3.a(this.f.a().i(), c24948zU0) + '\n');
        }
    }

    /* renamed from: ir.nasim.Xv3$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C9182Yv3 e;
        final /* synthetic */ C8927Xv3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C9182Yv3 c9182Yv3, C8927Xv3 c8927Xv3) {
            super(0);
            this.e = c9182Yv3;
            this.f = c8927Xv3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set invoke() {
            return this.e.a().d().c(this.f.C().e());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8927Xv3(C9182Yv3 c9182Yv3, InterfaceC22715vi3 interfaceC22715vi3, C8407Vv3 c8407Vv3) {
        super(c9182Yv3);
        AbstractC13042fc3.i(c9182Yv3, "c");
        AbstractC13042fc3.i(interfaceC22715vi3, "jPackage");
        AbstractC13042fc3.i(c8407Vv3, "ownerDescriptor");
        this.n = interfaceC22715vi3;
        this.o = c8407Vv3;
        this.p = c9182Yv3.e().g(new d(c9182Yv3, this));
        this.q = c9182Yv3.e().b(new c(c9182Yv3));
    }

    private final InterfaceC21331tU0 N(C6432No4 c6432No4, InterfaceC7106Qh3 interfaceC7106Qh3) {
        if (!AbstractC23662xI6.b(c6432No4)) {
            return null;
        }
        Set set = (Set) this.p.invoke();
        if (interfaceC7106Qh3 != null || set == null || set.contains(c6432No4.h())) {
            return (InterfaceC21331tU0) this.q.invoke(new a(c6432No4, interfaceC7106Qh3));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b R(InterfaceC22805vr3 interfaceC22805vr3) {
        if (interfaceC22805vr3 == null) {
            return b.C0779b.a;
        }
        if (interfaceC22805vr3.c().c() != C21625tr3.a.CLASS) {
            return b.c.a;
        }
        InterfaceC21331tU0 interfaceC21331tU0M = w().a().b().m(interfaceC22805vr3);
        return interfaceC21331tU0M != null ? new b.a(interfaceC21331tU0M) : b.C0779b.a;
    }

    public final InterfaceC21331tU0 O(InterfaceC7106Qh3 interfaceC7106Qh3) {
        AbstractC13042fc3.i(interfaceC7106Qh3, "javaClass");
        return N(interfaceC7106Qh3.getName(), interfaceC7106Qh3);
    }

    @Override // ir.nasim.X24, ir.nasim.InterfaceC22011uW5
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public InterfaceC21331tU0 e(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return N(c6432No4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC9416Zv3
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public C8407Vv3 C() {
        return this.o;
    }

    @Override // ir.nasim.AbstractC9416Zv3, ir.nasim.X24, ir.nasim.W24
    public Collection b(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.AbstractC9416Zv3, ir.nasim.X24, ir.nasim.InterfaceC22011uW5
    public Collection f(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        AbstractC13042fc3.i(ua2, "nameFilter");
        C24841zI1.a aVar = C24841zI1.c;
        if (!c24841zI1.a(aVar.f() | aVar.d())) {
            return AbstractC10360bX0.m();
        }
        Iterable iterable = (Iterable) v().invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            InterfaceC12795fB1 interfaceC12795fB1 = (InterfaceC12795fB1) obj;
            if (interfaceC12795fB1 instanceof InterfaceC21331tU0) {
                C6432No4 name = ((InterfaceC21331tU0) interfaceC12795fB1).getName();
                AbstractC13042fc3.h(name, "it.name");
                if (((Boolean) ua2.invoke(name)).booleanValue()) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected Set l(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        if (!c24841zI1.a(C24841zI1.c.f())) {
            return AbstractC4597Fu6.d();
        }
        Set set = (Set) this.p.invoke();
        if (set != null) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(C6432No4.p((String) it.next()));
            }
            return hashSet;
        }
        InterfaceC22715vi3 interfaceC22715vi3 = this.n;
        if (ua2 == null) {
            ua2 = IB2.a();
        }
        Collection<InterfaceC7106Qh3> collectionF = interfaceC22715vi3.F(ua2);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (InterfaceC7106Qh3 interfaceC7106Qh3 : collectionF) {
            C6432No4 name = interfaceC7106Qh3.M() == EnumC23477wz3.SOURCE ? null : interfaceC7106Qh3.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected Set n(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        return AbstractC4597Fu6.d();
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected InterfaceC17568nB1 p() {
        return InterfaceC17568nB1.a.a;
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected void r(Collection collection, C6432No4 c6432No4) {
        AbstractC13042fc3.i(collection, "result");
        AbstractC13042fc3.i(c6432No4, "name");
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected Set t(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        return AbstractC4597Fu6.d();
    }
}
