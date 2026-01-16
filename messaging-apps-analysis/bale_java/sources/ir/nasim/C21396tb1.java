package ir.nasim;

import ir.nasim.AbstractC21649tt7;

/* renamed from: ir.nasim.tb1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21396tb1 extends AbstractC10965cV7 {
    private InterfaceC11379cu3 a;
    private boolean b = b();
    private AbstractC21649tt7.e c = d();

    @Override // ir.nasim.AbstractC10965cV7
    public boolean b() {
        InterfaceC11379cu3 interfaceC11379cu3;
        InterfaceC11379cu3 interfaceC11379cu32;
        InterfaceC11379cu3 interfaceC11379cu33 = this.a;
        return interfaceC11379cu33 != null && interfaceC11379cu33.b() && ((interfaceC11379cu3 = this.a) == null || ((int) (interfaceC11379cu3.a() >> 32)) != 0) && ((interfaceC11379cu32 = this.a) == null || ((int) (interfaceC11379cu32.a() & 4294967295L)) != 0);
    }

    @Override // ir.nasim.AbstractC10965cV7
    public AbstractC21649tt7.e d() {
        InterfaceC11379cu3 interfaceC11379cu3 = this.a;
        int iA = interfaceC11379cu3 != null ? (int) (interfaceC11379cu3.a() >> 32) : 0;
        InterfaceC11379cu3 interfaceC11379cu32 = this.a;
        return new AbstractC21649tt7.e(iA, interfaceC11379cu32 != null ? (int) (interfaceC11379cu32.a() & 4294967295L) : 0);
    }

    public final void e() {
        if (this.a == null) {
            return;
        }
        this.a = null;
        c();
    }

    public final void f(InterfaceC11379cu3 interfaceC11379cu3) {
        AbstractC13042fc3.i(interfaceC11379cu3, "layoutCoordinates");
        this.a = interfaceC11379cu3;
        boolean zB = b();
        AbstractC21649tt7.e eVarD = d();
        if (this.b != zB || !AbstractC13042fc3.d(this.c, eVarD)) {
            c();
        }
        this.b = zB;
        this.c = eVarD;
    }
}
