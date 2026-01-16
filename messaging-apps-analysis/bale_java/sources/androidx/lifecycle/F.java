package androidx.lifecycle;

import androidx.lifecycle.G;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C14819iX7;
import ir.nasim.InterfaceC11299cm3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.VW7;

/* loaded from: classes2.dex */
public final class F implements InterfaceC9173Yu3 {
    private final InterfaceC11299cm3 a;
    private final SA2 b;
    private final SA2 c;
    private final SA2 d;
    private VW7 e;

    public F(InterfaceC11299cm3 interfaceC11299cm3, SA2 sa2, SA2 sa22, SA2 sa23) {
        AbstractC13042fc3.i(interfaceC11299cm3, "viewModelClass");
        AbstractC13042fc3.i(sa2, "storeProducer");
        AbstractC13042fc3.i(sa22, "factoryProducer");
        AbstractC13042fc3.i(sa23, "extrasProducer");
        this.a = interfaceC11299cm3;
        this.b = sa2;
        this.c = sa22;
        this.d = sa23;
    }

    @Override // ir.nasim.InterfaceC9173Yu3
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public VW7 getValue() {
        VW7 vw7 = this.e;
        if (vw7 != null) {
            return vw7;
        }
        VW7 vw7A = G.b.a((C14819iX7) this.b.invoke(), (G.c) this.c.invoke(), (AbstractC20375ru1) this.d.invoke()).a(this.a);
        this.e = vw7A;
        return vw7A;
    }

    @Override // ir.nasim.InterfaceC9173Yu3
    public boolean isInitialized() {
        return this.e != null;
    }
}
