package ir.nasim;

/* renamed from: ir.nasim.pT4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C18915pT4 extends AbstractC17424mw3 {
    private final InterfaceC16978mB2 a;
    private final UA2 b;
    private final int c;
    private final InterfaceC8727Xb3 d;

    public C18915pT4(InterfaceC16978mB2 interfaceC16978mB2, UA2 ua2, int i) {
        this.a = interfaceC16978mB2;
        this.b = ua2;
        this.c = i;
        C19689qm4 c19689qm4 = new C19689qm4();
        c19689qm4.b(i, new C16551lT4(ua2, interfaceC16978mB2));
        this.d = c19689qm4;
    }

    @Override // ir.nasim.AbstractC17424mw3
    public InterfaceC8727Xb3 j() {
        return this.d;
    }
}
