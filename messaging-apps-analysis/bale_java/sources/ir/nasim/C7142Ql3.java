package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: ir.nasim.Ql3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7142Ql3 implements W24 {
    static final /* synthetic */ InterfaceC5239Im3[] f = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C7142Ql3.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    private final C9182Yv3 b;
    private final C8407Vv3 c;
    private final C8927Xv3 d;
    private final InterfaceC23016wC4 e;

    /* renamed from: ir.nasim.Ql3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final W24[] invoke() {
            Collection collectionValues = C7142Ql3.this.c.L0().values();
            C7142Ql3 c7142Ql3 = C7142Ql3.this;
            ArrayList arrayList = new ArrayList();
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                W24 w24D = c7142Ql3.b.a().b().d(c7142Ql3.c, (InterfaceC22805vr3) it.next());
                if (w24D != null) {
                    arrayList.add(w24D);
                }
            }
            Object[] array = AbstractC20801sd6.b(arrayList).toArray(new W24[0]);
            if (array != null) {
                return (W24[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public C7142Ql3(C9182Yv3 c9182Yv3, InterfaceC22715vi3 interfaceC22715vi3, C8407Vv3 c8407Vv3) {
        AbstractC13042fc3.i(c9182Yv3, "c");
        AbstractC13042fc3.i(interfaceC22715vi3, "jPackage");
        AbstractC13042fc3.i(c8407Vv3, "packageFragment");
        this.b = c9182Yv3;
        this.c = c8407Vv3;
        this.d = new C8927Xv3(c9182Yv3, interfaceC22715vi3, c8407Vv3);
        this.e = c9182Yv3.e().c(new a());
    }

    private final W24[] k() {
        return (W24[]) MN6.a(this.e, this, f[0]);
    }

    @Override // ir.nasim.W24
    public Set a() {
        W24[] w24ArrK = k();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (W24 w24 : w24ArrK) {
            AbstractC13610gX0.D(linkedHashSet, w24.a());
        }
        linkedHashSet.addAll(j().a());
        return linkedHashSet;
    }

    @Override // ir.nasim.W24
    public Collection b(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        l(c6432No4, ij3);
        C8927Xv3 c8927Xv3 = this.d;
        W24[] w24ArrK = k();
        Collection collectionB = c8927Xv3.b(c6432No4, ij3);
        int length = w24ArrK.length;
        int i = 0;
        while (i < length) {
            W24 w24 = w24ArrK[i];
            i++;
            collectionB = AbstractC20801sd6.a(collectionB, w24.b(c6432No4, ij3));
        }
        return collectionB == null ? AbstractC4597Fu6.d() : collectionB;
    }

    @Override // ir.nasim.W24
    public Set c() {
        W24[] w24ArrK = k();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (W24 w24 : w24ArrK) {
            AbstractC13610gX0.D(linkedHashSet, w24.c());
        }
        linkedHashSet.addAll(j().c());
        return linkedHashSet;
    }

    @Override // ir.nasim.W24
    public Collection d(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        l(c6432No4, ij3);
        C8927Xv3 c8927Xv3 = this.d;
        W24[] w24ArrK = k();
        Collection collectionD = c8927Xv3.d(c6432No4, ij3);
        int length = w24ArrK.length;
        int i = 0;
        while (i < length) {
            W24 w24 = w24ArrK[i];
            i++;
            collectionD = AbstractC20801sd6.a(collectionD, w24.d(c6432No4, ij3));
        }
        return collectionD == null ? AbstractC4597Fu6.d() : collectionD;
    }

    @Override // ir.nasim.InterfaceC22011uW5
    public MU0 e(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        l(c6432No4, ij3);
        InterfaceC21331tU0 interfaceC21331tU0P = this.d.e(c6432No4, ij3);
        if (interfaceC21331tU0P != null) {
            return interfaceC21331tU0P;
        }
        W24[] w24ArrK = k();
        int length = w24ArrK.length;
        MU0 mu0 = null;
        int i = 0;
        while (i < length) {
            W24 w24 = w24ArrK[i];
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
        C8927Xv3 c8927Xv3 = this.d;
        W24[] w24ArrK = k();
        Collection collectionF = c8927Xv3.f(c24841zI1, ua2);
        int length = w24ArrK.length;
        int i = 0;
        while (i < length) {
            W24 w24 = w24ArrK[i];
            i++;
            collectionF = AbstractC20801sd6.a(collectionF, w24.f(c24841zI1, ua2));
        }
        return collectionF == null ? AbstractC4597Fu6.d() : collectionF;
    }

    @Override // ir.nasim.W24
    public Set g() {
        Set setA = Y24.a(AbstractC10242bK.O(k()));
        if (setA == null) {
            return null;
        }
        setA.addAll(j().g());
        return setA;
    }

    public final C8927Xv3 j() {
        return this.d;
    }

    public void l(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        AbstractC21932uN7.b(this.b.a().k(), ij3, this.c, c6432No4);
    }
}
