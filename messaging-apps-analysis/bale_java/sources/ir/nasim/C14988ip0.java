package ir.nasim;

/* renamed from: ir.nasim.ip0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14988ip0 implements WH1 {
    private InterfaceC8548Wl0 a = C13966h72.a;
    private C16869m02 b;
    private InterfaceC23919xk1 c;
    private SA2 d;

    public final C16869m02 b() {
        return this.b;
    }

    public final long d() {
        return this.a.d();
    }

    @Override // ir.nasim.WH1
    public float getDensity() {
        return this.a.getDensity().getDensity();
    }

    public final EnumC12613eu3 getLayoutDirection() {
        return this.a.getLayoutDirection();
    }

    public final C16869m02 h(UA2 ua2) {
        C16869m02 c16869m02 = new C16869m02(ua2);
        this.b = c16869m02;
        return c16869m02;
    }

    public final void o(InterfaceC8548Wl0 interfaceC8548Wl0) {
        this.a = interfaceC8548Wl0;
    }

    public final void p(InterfaceC23919xk1 interfaceC23919xk1) {
        this.c = interfaceC23919xk1;
    }

    public final void t(C16869m02 c16869m02) {
        this.b = c16869m02;
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float t1() {
        return this.a.getDensity().t1();
    }

    public final void u(SA2 sa2) {
        this.d = sa2;
    }
}
