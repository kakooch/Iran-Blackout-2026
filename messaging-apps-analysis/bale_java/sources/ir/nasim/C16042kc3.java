package ir.nasim;

/* renamed from: ir.nasim.kc3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16042kc3 {
    private final C3419Au3 a;
    private final InterfaceC9102Ym4 b;

    public C16042kc3(C3419Au3 c3419Au3, InterfaceC10970cW3 interfaceC10970cW3) {
        this.a = c3419Au3;
        this.b = AbstractC13472gH6.d(interfaceC10970cW3, null, 2, null);
    }

    private final InterfaceC10970cW3 a() {
        return (InterfaceC10970cW3) this.b.getValue();
    }

    private final void j(InterfaceC10970cW3 interfaceC10970cW3) {
        this.b.setValue(interfaceC10970cW3);
    }

    public final int b(int i) {
        return a().i(this.a.w0(), this.a.Q(), i);
    }

    public final int c(int i) {
        return a().d(this.a.w0(), this.a.Q(), i);
    }

    public final int d(int i) {
        return a().i(this.a.w0(), this.a.P(), i);
    }

    public final int e(int i) {
        return a().d(this.a.w0(), this.a.P(), i);
    }

    public final int f(int i) {
        return a().a(this.a.w0(), this.a.Q(), i);
    }

    public final int g(int i) {
        return a().h(this.a.w0(), this.a.Q(), i);
    }

    public final int h(int i) {
        return a().a(this.a.w0(), this.a.P(), i);
    }

    public final int i(int i) {
        return a().h(this.a.w0(), this.a.P(), i);
    }

    public final void k(InterfaceC10970cW3 interfaceC10970cW3) {
        j(interfaceC10970cW3);
    }
}
