package ir.nasim;

/* renamed from: ir.nasim.Mk0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C6153Mk0 implements InterfaceC5920Lk0, InterfaceC5452Jk0 {
    private final WH1 a;
    private final long b;
    private final /* synthetic */ androidx.compose.foundation.layout.h c;

    public /* synthetic */ C6153Mk0(WH1 wh1, long j, ED1 ed1) {
        this(wh1, j);
    }

    @Override // ir.nasim.InterfaceC5920Lk0
    public long d() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC5452Jk0
    public androidx.compose.ui.e e(androidx.compose.ui.e eVar) {
        return this.c.e(eVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6153Mk0)) {
            return false;
        }
        C6153Mk0 c6153Mk0 = (C6153Mk0) obj;
        return AbstractC13042fc3.d(this.a, c6153Mk0.a) && C17833ne1.f(this.b, c6153Mk0.b);
    }

    @Override // ir.nasim.InterfaceC5452Jk0
    public androidx.compose.ui.e h(androidx.compose.ui.e eVar, InterfaceC12529em interfaceC12529em) {
        return this.c.h(eVar, interfaceC12529em);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + C17833ne1.o(this.b);
    }

    public String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.a + ", constraints=" + ((Object) C17833ne1.q(this.b)) + ')';
    }

    private C6153Mk0(WH1 wh1, long j) {
        this.a = wh1;
        this.b = j;
        this.c = androidx.compose.foundation.layout.h.a;
    }
}
