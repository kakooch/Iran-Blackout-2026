package ir.nasim;

/* renamed from: ir.nasim.Ct4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3884Ct4 implements InterfaceC7857Tm2 {
    private final UA2 a;

    public C3884Ct4(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onDetach");
        this.a = ua2;
    }

    @Override // ir.nasim.InterfaceC7857Tm2
    public void a(boolean z) {
        this.a.invoke(Boolean.valueOf(z));
    }

    @Override // ir.nasim.InterfaceC7857Tm2
    public void b() {
        this.a.invoke(Boolean.FALSE);
    }
}
