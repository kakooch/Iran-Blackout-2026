package ir.nasim;

/* loaded from: classes6.dex */
public final class VZ1 implements XK6 {
    private final float a;

    public VZ1(float f) {
        this.a = f;
    }

    @Override // ir.nasim.XK6
    public C17072mL6 a(InterfaceC18557or4 interfaceC18557or4, QV qv) {
        AbstractC13042fc3.i(interfaceC18557or4, "sample");
        AbstractC13042fc3.i(qv, "profile");
        return new C17072mL6(new C7230Qv1(qv.c()), qv.a((35 & 1) != 0 ? qv.a : 0L, (35 & 2) != 0 ? qv.b : qv.d() * this.a, (35 & 4) != 0 ? qv.c : 0.0d, (35 & 8) != 0 ? qv.d : 0.0d, (35 & 16) != 0 ? qv.e : 0.0d, (35 & 32) != 0 ? qv.f : null));
    }

    public String toString() {
        return "DrainState()";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VZ1(PV pv) {
        this(pv.c());
        AbstractC13042fc3.i(pv, "optimizerConfiguration");
    }
}
