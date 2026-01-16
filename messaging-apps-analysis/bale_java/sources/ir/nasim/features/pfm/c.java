package ir.nasim.features.pfm;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC18751pB2;
import ir.nasim.InterfaceC22409vB2;
import ir.nasim.QG4;
import ir.nasim.UA2;

/* loaded from: classes6.dex */
final /* synthetic */ class c implements QG4, InterfaceC22409vB2 {
    private final /* synthetic */ UA2 a;

    c(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "function");
        this.a = ua2;
    }

    @Override // ir.nasim.QG4
    public final /* synthetic */ void a(Object obj) {
        this.a.invoke(obj);
    }

    @Override // ir.nasim.InterfaceC22409vB2
    public final InterfaceC18751pB2 b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof QG4) && (obj instanceof InterfaceC22409vB2)) {
            return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
        }
        return false;
    }

    public final int hashCode() {
        return b().hashCode();
    }
}
