package ir.nasim;

/* renamed from: ir.nasim.in4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14972in4 implements A98 {
    private final InterfaceC9102Ym4 b;

    public C14972in4(A98 a98) {
        this.b = AbstractC13472gH6.d(a98, null, 2, null);
    }

    @Override // ir.nasim.A98
    public int a(WH1 wh1) {
        return e().a(wh1);
    }

    @Override // ir.nasim.A98
    public int b(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        return e().b(wh1, enumC12613eu3);
    }

    @Override // ir.nasim.A98
    public int c(WH1 wh1) {
        return e().c(wh1);
    }

    @Override // ir.nasim.A98
    public int d(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        return e().d(wh1, enumC12613eu3);
    }

    public final A98 e() {
        return (A98) this.b.getValue();
    }

    public final void f(A98 a98) {
        this.b.setValue(a98);
    }
}
