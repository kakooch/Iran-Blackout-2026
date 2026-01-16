package ir.nasim;

import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.Vg4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8273Vg4 implements InterfaceC8039Ug4 {
    private final List a;
    private final Set b;
    private final List c;
    private final Set d;

    public C8273Vg4(List list, Set set, List list2, Set set2) {
        AbstractC13042fc3.i(list, "allDependencies");
        AbstractC13042fc3.i(set, "modulesWhoseInternalsAreVisible");
        AbstractC13042fc3.i(list2, "directExpectedByDependencies");
        AbstractC13042fc3.i(set2, "allExpectedByDependencies");
        this.a = list;
        this.b = set;
        this.c = list2;
        this.d = set2;
    }

    @Override // ir.nasim.InterfaceC8039Ug4
    public List a() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC8039Ug4
    public List b() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC8039Ug4
    public Set c() {
        return this.b;
    }
}
