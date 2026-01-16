package ir.nasim;

import ir.nasim.InterfaceC11938do1;

/* loaded from: classes8.dex */
public abstract class M0 implements InterfaceC11938do1.c {
    private final UA2 a;
    private final InterfaceC11938do1.c b;

    public M0(InterfaceC11938do1.c cVar, UA2 ua2) {
        AbstractC13042fc3.i(cVar, "baseKey");
        AbstractC13042fc3.i(ua2, "safeCast");
        this.a = ua2;
        this.b = cVar instanceof M0 ? ((M0) cVar).b : cVar;
    }

    public final boolean a(InterfaceC11938do1.c cVar) {
        AbstractC13042fc3.i(cVar, "key");
        return cVar == this || this.b == cVar;
    }

    public final InterfaceC11938do1.b b(InterfaceC11938do1.b bVar) {
        AbstractC13042fc3.i(bVar, "element");
        return (InterfaceC11938do1.b) this.a.invoke(bVar);
    }
}
