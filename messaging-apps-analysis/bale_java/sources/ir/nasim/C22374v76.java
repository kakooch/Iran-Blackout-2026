package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.v76, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C22374v76 implements InterfaceC11005ca2 {
    public static final C22374v76 b = new C22374v76();

    private C22374v76() {
    }

    @Override // ir.nasim.InterfaceC11005ca2
    public void a(InterfaceC15194jA0 interfaceC15194jA0) {
        AbstractC13042fc3.i(interfaceC15194jA0, "descriptor");
        throw new IllegalStateException(AbstractC13042fc3.q("Cannot infer visibility for ", interfaceC15194jA0));
    }

    @Override // ir.nasim.InterfaceC11005ca2
    public void b(InterfaceC21331tU0 interfaceC21331tU0, List list) {
        AbstractC13042fc3.i(interfaceC21331tU0, "descriptor");
        AbstractC13042fc3.i(list, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + interfaceC21331tU0.getName() + ", unresolved classes " + list);
    }
}
