package androidx.lifecycle;

import androidx.lifecycle.j;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.IU1;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC18633oz3;

/* loaded from: classes2.dex */
public final class k {
    private final j a;
    private final j.b b;
    private final IU1 c;
    private final n d;

    public k(j jVar, j.b bVar, IU1 iu1, final InterfaceC13730gj3 interfaceC13730gj3) {
        AbstractC13042fc3.i(jVar, "lifecycle");
        AbstractC13042fc3.i(bVar, "minState");
        AbstractC13042fc3.i(iu1, "dispatchQueue");
        AbstractC13042fc3.i(interfaceC13730gj3, "parentJob");
        this.a = jVar;
        this.b = bVar;
        this.c = iu1;
        n nVar = new n() { // from class: ir.nasim.hz3
            @Override // androidx.lifecycle.n
            public final void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
                androidx.lifecycle.k.c(this.a, interfaceC13730gj3, interfaceC18633oz3, aVar);
            }
        };
        this.d = nVar;
        if (jVar.b() != j.b.DESTROYED) {
            jVar.a(nVar);
        } else {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(k kVar, InterfaceC13730gj3 interfaceC13730gj3, InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
        AbstractC13042fc3.i(kVar, "this$0");
        AbstractC13042fc3.i(interfaceC13730gj3, "$parentJob");
        AbstractC13042fc3.i(interfaceC18633oz3, "source");
        AbstractC13042fc3.i(aVar, "<anonymous parameter 1>");
        if (interfaceC18633oz3.getLifecycle().b() == j.b.DESTROYED) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            kVar.b();
        } else if (interfaceC18633oz3.getLifecycle().b().compareTo(kVar.b) < 0) {
            kVar.c.h();
        } else {
            kVar.c.i();
        }
    }

    public final void b() {
        this.a.d(this.d);
        this.c.g();
    }
}
