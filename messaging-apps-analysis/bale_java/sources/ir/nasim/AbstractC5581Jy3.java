package ir.nasim;

/* renamed from: ir.nasim.Jy3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5581Jy3 implements InterfaceC22097uf5 {
    private a a;

    /* renamed from: ir.nasim.Jy3$a */
    public interface a {
        C6542Ny3 K1();

        InterfaceC20600sH6 getSoftwareKeyboardController();

        InterfaceC18354oW7 getViewConfiguration();

        InterfaceC13730gj3 h0(InterfaceC14603iB2 interfaceC14603iB2);

        C19101pm7 h1();

        InterfaceC11379cu3 u0();
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public final void g() {
        InterfaceC20600sH6 softwareKeyboardController;
        a aVar = this.a;
        if (aVar == null || (softwareKeyboardController = aVar.getSoftwareKeyboardController()) == null) {
            return;
        }
        softwareKeyboardController.b();
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public final void h() {
        InterfaceC20600sH6 softwareKeyboardController;
        a aVar = this.a;
        if (aVar == null || (softwareKeyboardController = aVar.getSoftwareKeyboardController()) == null) {
            return;
        }
        softwareKeyboardController.a();
    }

    protected final a i() {
        return this.a;
    }

    public final void j(a aVar) {
        if (!(this.a == null)) {
            P73.c("Expected textInputModifierNode to be null");
        }
        this.a = aVar;
    }

    public abstract void k();

    public final void l(a aVar) {
        if (!(this.a == aVar)) {
            P73.c("Expected textInputModifierNode to be " + aVar + " but was " + this.a);
        }
        this.a = null;
    }
}
