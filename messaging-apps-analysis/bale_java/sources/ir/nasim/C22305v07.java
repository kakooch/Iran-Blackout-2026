package ir.nasim;

import ir.nasim.InterfaceC22011uW5;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.v07, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C22305v07 implements W24 {
    private final W24 b;
    private final C5585Jy7 c;
    private Map d;
    private final InterfaceC9173Yu3 e;

    /* renamed from: ir.nasim.v07$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Collection invoke() {
            C22305v07 c22305v07 = C22305v07.this;
            return c22305v07.l(InterfaceC22011uW5.a.a(c22305v07.b, null, null, 3, null));
        }
    }

    public C22305v07(W24 w24, C5585Jy7 c5585Jy7) {
        AbstractC13042fc3.i(w24, "workerScope");
        AbstractC13042fc3.i(c5585Jy7, "givenSubstitutor");
        this.b = w24;
        AbstractC5117Hy7 abstractC5117Hy7J = c5585Jy7.j();
        AbstractC13042fc3.h(abstractC5117Hy7J, "givenSubstitutor.substitution");
        this.c = AbstractC18794pG0.f(abstractC5117Hy7J, false, 1, null).c();
        this.e = AbstractC13269fw3.a(new a());
    }

    private final Collection j() {
        return (Collection) this.e.getValue();
    }

    private final InterfaceC12795fB1 k(InterfaceC12795fB1 interfaceC12795fB1) {
        if (this.c.k()) {
            return interfaceC12795fB1;
        }
        if (this.d == null) {
            this.d = new HashMap();
        }
        Map map = this.d;
        AbstractC13042fc3.f(map);
        Object objC = map.get(interfaceC12795fB1);
        if (objC == null) {
            if (!(interfaceC12795fB1 instanceof InterfaceC19829r07)) {
                throw new IllegalStateException(AbstractC13042fc3.q("Unknown descriptor in scope: ", interfaceC12795fB1).toString());
            }
            objC = ((InterfaceC19829r07) interfaceC12795fB1).c(this.c);
            if (objC == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + interfaceC12795fB1 + " substitution fails");
            }
            map.put(interfaceC12795fB1, objC);
        }
        return (InterfaceC12795fB1) objC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection l(Collection collection) {
        if (this.c.k() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet linkedHashSetG = YW0.g(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSetG.add(k((InterfaceC12795fB1) it.next()));
        }
        return linkedHashSetG;
    }

    @Override // ir.nasim.W24
    public Set a() {
        return this.b.a();
    }

    @Override // ir.nasim.W24
    public Collection b(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return l(this.b.b(c6432No4, ij3));
    }

    @Override // ir.nasim.W24
    public Set c() {
        return this.b.c();
    }

    @Override // ir.nasim.W24
    public Collection d(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return l(this.b.d(c6432No4, ij3));
    }

    @Override // ir.nasim.InterfaceC22011uW5
    public MU0 e(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        MU0 mu0E = this.b.e(c6432No4, ij3);
        if (mu0E == null) {
            return null;
        }
        return (MU0) k(mu0E);
    }

    @Override // ir.nasim.InterfaceC22011uW5
    public Collection f(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        AbstractC13042fc3.i(ua2, "nameFilter");
        return j();
    }

    @Override // ir.nasim.W24
    public Set g() {
        return this.b.g();
    }
}
