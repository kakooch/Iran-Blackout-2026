package ir.nasim;

/* renamed from: ir.nasim.Tb1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C7755Tb1 implements InterfaceC7518Sb1 {
    private final InterfaceC6806Pb1 a;

    public C7755Tb1(InterfaceC6806Pb1 interfaceC6806Pb1) {
        this.a = interfaceC6806Pb1;
    }

    private final C21850uE6 a() {
        InterfaceC6806Pb1 interfaceC6806Pb1 = this.a;
        AbstractC13042fc3.g(interfaceC6806Pb1, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
        return ((C8225Vb1) interfaceC6806Pb1).H();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C7755Tb1) && AbstractC13042fc3.d(this.a, ((C7755Tb1) obj).a);
    }

    @Override // ir.nasim.InterfaceC7518Sb1
    public Iterable f() {
        return a().f();
    }

    public int hashCode() {
        return this.a.hashCode() * 31;
    }
}
