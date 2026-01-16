package androidx.lifecycle;

import androidx.lifecycle.j;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C6572Ob6;
import ir.nasim.InterfaceC18633oz3;

/* loaded from: classes2.dex */
public final class z implements n {
    private final C6572Ob6 a;

    public z(C6572Ob6 c6572Ob6) {
        AbstractC13042fc3.i(c6572Ob6, "provider");
        this.a = c6572Ob6;
    }

    @Override // androidx.lifecycle.n
    public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
        AbstractC13042fc3.i(interfaceC18633oz3, "source");
        AbstractC13042fc3.i(aVar, "event");
        if (aVar == j.a.ON_CREATE) {
            interfaceC18633oz3.getLifecycle().d(this);
            this.a.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + aVar).toString());
        }
    }
}
