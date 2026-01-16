package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.i83, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C14575i83 extends X24 {
    private final W24 b;

    public C14575i83(W24 w24) {
        AbstractC13042fc3.i(w24, "workerScope");
        this.b = w24;
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Set a() {
        return this.b.a();
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Set c() {
        return this.b.c();
    }

    @Override // ir.nasim.X24, ir.nasim.InterfaceC22011uW5
    public MU0 e(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        MU0 mu0E = this.b.e(c6432No4, ij3);
        if (mu0E == null) {
            return null;
        }
        InterfaceC21331tU0 interfaceC21331tU0 = mu0E instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) mu0E : null;
        if (interfaceC21331tU0 != null) {
            return interfaceC21331tU0;
        }
        if (mu0E instanceof InterfaceC7722Sx7) {
            return (InterfaceC7722Sx7) mu0E;
        }
        return null;
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Set g() {
        return this.b.g();
    }

    @Override // ir.nasim.X24, ir.nasim.InterfaceC22011uW5
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public List f(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        AbstractC13042fc3.i(ua2, "nameFilter");
        C24841zI1 c24841zI1P = c24841zI1.p(C24841zI1.c.d());
        if (c24841zI1P == null) {
            return AbstractC10360bX0.m();
        }
        Collection collectionF = this.b.f(c24841zI1P, ua2);
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionF) {
            if (obj instanceof NU0) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public String toString() {
        return AbstractC13042fc3.q("Classes from ", this.b);
    }
}
