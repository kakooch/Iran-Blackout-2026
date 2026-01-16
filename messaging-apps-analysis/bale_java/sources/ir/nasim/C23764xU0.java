package ir.nasim;

import ir.nasim.C10938cS7;
import ir.nasim.PJ6;
import java.util.Iterator;
import java.util.Set;

/* renamed from: ir.nasim.xU0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23764xU0 {
    public static final b c = new b(null);
    private static final Set d = AbstractC4363Eu6.c(C24948zU0.m(PJ6.a.d.l()));
    private final TI1 a;
    private final UA2 b;

    /* renamed from: ir.nasim.xU0$a */
    private static final class a {
        private final C24948zU0 a;
        private final C19511qU0 b;

        public a(C24948zU0 c24948zU0, C19511qU0 c19511qU0) {
            AbstractC13042fc3.i(c24948zU0, "classId");
            this.a = c24948zU0;
            this.b = c19511qU0;
        }

        public final C19511qU0 a() {
            return this.b;
        }

        public final C24948zU0 b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* renamed from: ir.nasim.xU0$b */
    public static final class b {
        private b() {
        }

        public final Set a() {
            return C23764xU0.d;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.xU0$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC21331tU0 invoke(a aVar) {
            AbstractC13042fc3.i(aVar, "key");
            return C23764xU0.this.c(aVar);
        }
    }

    public C23764xU0(TI1 ti1) {
        AbstractC13042fc3.i(ti1, "components");
        this.a = ti1;
        this.b = ti1.u().b(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC21331tU0 c(a aVar) {
        Object next;
        WI1 wi1A;
        C24948zU0 c24948zU0B = aVar.b();
        Iterator it = this.a.k().iterator();
        while (it.hasNext()) {
            InterfaceC21331tU0 interfaceC21331tU0A = ((InterfaceC22578vU0) it.next()).a(c24948zU0B);
            if (interfaceC21331tU0A != null) {
                return interfaceC21331tU0A;
            }
        }
        if (c.a().contains(c24948zU0B)) {
            return null;
        }
        C19511qU0 c19511qU0A = aVar.a();
        if (c19511qU0A == null && (c19511qU0A = this.a.e().a(c24948zU0B)) == null) {
            return null;
        }
        InterfaceC6692Oo4 interfaceC6692Oo4A = c19511qU0A.a();
        C6526Nw5 c6526Nw5B = c19511qU0A.b();
        AbstractC7310Re0 abstractC7310Re0C = c19511qU0A.c();
        JH6 jh6D = c19511qU0A.d();
        C24948zU0 c24948zU0G = c24948zU0B.g();
        if (c24948zU0G != null) {
            InterfaceC21331tU0 interfaceC21331tU0E = e(this, c24948zU0G, null, 2, null);
            C10851cJ1 c10851cJ1 = interfaceC21331tU0E instanceof C10851cJ1 ? (C10851cJ1) interfaceC21331tU0E : null;
            if (c10851cJ1 == null) {
                return null;
            }
            C6432No4 c6432No4J = c24948zU0B.j();
            AbstractC13042fc3.h(c6432No4J, "classId.shortClassName");
            if (!c10851cJ1.b1(c6432No4J)) {
                return null;
            }
            wi1A = c10851cJ1.V0();
        } else {
            AS4 as4R = this.a.r();
            C9424Zw2 c9424Zw2H = c24948zU0B.h();
            AbstractC13042fc3.h(c9424Zw2H, "classId.packageFqName");
            Iterator it2 = CS4.b(as4R, c9424Zw2H).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                InterfaceC24340yS4 interfaceC24340yS4 = (InterfaceC24340yS4) next;
                if (!(interfaceC24340yS4 instanceof AbstractC14678iJ1)) {
                    break;
                }
                C6432No4 c6432No4J2 = c24948zU0B.j();
                AbstractC13042fc3.h(c6432No4J2, "classId.shortClassName");
                if (((AbstractC14678iJ1) interfaceC24340yS4).J0(c6432No4J2)) {
                    break;
                }
            }
            InterfaceC24340yS4 interfaceC24340yS42 = (InterfaceC24340yS4) next;
            if (interfaceC24340yS42 == null) {
                return null;
            }
            TI1 ti1 = this.a;
            C12644ex5 c12644ex5L0 = c6526Nw5B.L0();
            AbstractC13042fc3.h(c12644ex5L0, "classProto.typeTable");
            C7029Py7 c7029Py7 = new C7029Py7(c12644ex5L0);
            C10938cS7.a aVar2 = C10938cS7.b;
            C14464hx5 c14464hx5N0 = c6526Nw5B.N0();
            AbstractC13042fc3.h(c14464hx5N0, "classProto.versionRequirementTable");
            wi1A = ti1.a(interfaceC24340yS42, interfaceC6692Oo4A, c7029Py7, aVar2.a(c14464hx5N0), abstractC7310Re0C, null);
        }
        return new C10851cJ1(wi1A, c6526Nw5B, interfaceC6692Oo4A, abstractC7310Re0C, jh6D);
    }

    public static /* synthetic */ InterfaceC21331tU0 e(C23764xU0 c23764xU0, C24948zU0 c24948zU0, C19511qU0 c19511qU0, int i, Object obj) {
        if ((i & 2) != 0) {
            c19511qU0 = null;
        }
        return c23764xU0.d(c24948zU0, c19511qU0);
    }

    public final InterfaceC21331tU0 d(C24948zU0 c24948zU0, C19511qU0 c19511qU0) {
        AbstractC13042fc3.i(c24948zU0, "classId");
        return (InterfaceC21331tU0) this.b.invoke(new a(c24948zU0, c19511qU0));
    }
}
