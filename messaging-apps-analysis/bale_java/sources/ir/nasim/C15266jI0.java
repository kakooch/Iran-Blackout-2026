package ir.nasim;

import ir.nasim.W24;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.jI0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15266jI0 implements W24 {
    public static final a d = new a(null);
    private final String b;
    private final W24[] c;

    /* renamed from: ir.nasim.jI0$a */
    public static final class a {
        private a() {
        }

        public final W24 a(String str, Iterable iterable) {
            AbstractC13042fc3.i(str, "debugName");
            AbstractC13042fc3.i(iterable, "scopes");
            CE6 ce6 = new CE6();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                W24 w24 = (W24) it.next();
                if (w24 != W24.b.b) {
                    if (w24 instanceof C15266jI0) {
                        AbstractC13610gX0.E(ce6, ((C15266jI0) w24).c);
                    } else {
                        ce6.add(w24);
                    }
                }
            }
            return b(str, ce6);
        }

        public final W24 b(String str, List list) {
            AbstractC13042fc3.i(str, "debugName");
            AbstractC13042fc3.i(list, "scopes");
            int size = list.size();
            if (size == 0) {
                return W24.b.b;
            }
            if (size == 1) {
                return (W24) list.get(0);
            }
            Object[] array = list.toArray(new W24[0]);
            if (array != null) {
                return new C15266jI0(str, (W24[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C15266jI0(String str, W24[] w24Arr, ED1 ed1) {
        this(str, w24Arr);
    }

    @Override // ir.nasim.W24
    public Set a() {
        W24[] w24Arr = this.c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (W24 w24 : w24Arr) {
            AbstractC13610gX0.D(linkedHashSet, w24.a());
        }
        return linkedHashSet;
    }

    @Override // ir.nasim.W24
    public Collection b(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        W24[] w24Arr = this.c;
        int length = w24Arr.length;
        if (length == 0) {
            return AbstractC10360bX0.m();
        }
        int i = 0;
        if (length == 1) {
            return w24Arr[0].b(c6432No4, ij3);
        }
        int length2 = w24Arr.length;
        Collection collectionA = null;
        while (i < length2) {
            W24 w24 = w24Arr[i];
            i++;
            collectionA = AbstractC20801sd6.a(collectionA, w24.b(c6432No4, ij3));
        }
        return collectionA == null ? AbstractC4597Fu6.d() : collectionA;
    }

    @Override // ir.nasim.W24
    public Set c() {
        W24[] w24Arr = this.c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (W24 w24 : w24Arr) {
            AbstractC13610gX0.D(linkedHashSet, w24.c());
        }
        return linkedHashSet;
    }

    @Override // ir.nasim.W24
    public Collection d(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        W24[] w24Arr = this.c;
        int length = w24Arr.length;
        if (length == 0) {
            return AbstractC10360bX0.m();
        }
        int i = 0;
        if (length == 1) {
            return w24Arr[0].d(c6432No4, ij3);
        }
        int length2 = w24Arr.length;
        Collection collectionA = null;
        while (i < length2) {
            W24 w24 = w24Arr[i];
            i++;
            collectionA = AbstractC20801sd6.a(collectionA, w24.d(c6432No4, ij3));
        }
        return collectionA == null ? AbstractC4597Fu6.d() : collectionA;
    }

    @Override // ir.nasim.InterfaceC22011uW5
    public MU0 e(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        W24[] w24Arr = this.c;
        int length = w24Arr.length;
        MU0 mu0 = null;
        int i = 0;
        while (i < length) {
            W24 w24 = w24Arr[i];
            i++;
            MU0 mu0E = w24.e(c6432No4, ij3);
            if (mu0E != null) {
                if (!(mu0E instanceof NU0) || !((NU0) mu0E).l0()) {
                    return mu0E;
                }
                if (mu0 == null) {
                    mu0 = mu0E;
                }
            }
        }
        return mu0;
    }

    @Override // ir.nasim.InterfaceC22011uW5
    public Collection f(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        AbstractC13042fc3.i(ua2, "nameFilter");
        W24[] w24Arr = this.c;
        int length = w24Arr.length;
        if (length == 0) {
            return AbstractC10360bX0.m();
        }
        int i = 0;
        if (length == 1) {
            return w24Arr[0].f(c24841zI1, ua2);
        }
        int length2 = w24Arr.length;
        Collection collectionA = null;
        while (i < length2) {
            W24 w24 = w24Arr[i];
            i++;
            collectionA = AbstractC20801sd6.a(collectionA, w24.f(c24841zI1, ua2));
        }
        return collectionA == null ? AbstractC4597Fu6.d() : collectionA;
    }

    @Override // ir.nasim.W24
    public Set g() {
        return Y24.a(AbstractC10242bK.O(this.c));
    }

    public String toString() {
        return this.b;
    }

    private C15266jI0(String str, W24[] w24Arr) {
        this.b = str;
        this.c = w24Arr;
    }
}
