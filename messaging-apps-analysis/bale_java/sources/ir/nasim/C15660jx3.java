package ir.nasim;

/* renamed from: ir.nasim.jx3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15660jx3 {
    private final InterfaceC17916nm4 a;
    private final InterfaceC17916nm4 b;
    private boolean c;
    private Object d;
    private final C3910Cw3 e;

    public C15660jx3(int i, int i2) {
        this.a = UG6.a(i);
        this.b = UG6.a(i2);
        this.e = new C3910Cw3(i, 30, 100);
    }

    private final void f(int i) {
        this.b.h(i);
    }

    private final void g(int i, int i2) {
        if (!(((float) i) >= 0.0f)) {
            P73.a("Index should be non-negative (" + i + ')');
        }
        e(i);
        this.e.j(i);
        f(i2);
    }

    public final int a() {
        return this.a.d();
    }

    public final C3910Cw3 b() {
        return this.e;
    }

    public final int c() {
        return this.b.d();
    }

    public final void d(int i, int i2) {
        g(i, i2);
        this.d = null;
    }

    public final void e(int i) {
        this.a.h(i);
    }

    public final void h(C11408cx3 c11408cx3) {
        C12051dx3 c12051dx3S = c11408cx3.s();
        this.d = c12051dx3S != null ? c12051dx3S.getKey() : null;
        if (this.c || c11408cx3.g() > 0) {
            this.c = true;
            int iU = c11408cx3.u();
            if (!(((float) iU) >= 0.0f)) {
                P73.c("scrollOffset should be non-negative");
            }
            C12051dx3 c12051dx3S2 = c11408cx3.s();
            g(c12051dx3S2 != null ? c12051dx3S2.getIndex() : 0, iU);
        }
    }

    public final void i(int i) {
        if (!(((float) i) >= 0.0f)) {
            P73.c("scrollOffset should be non-negative");
        }
        f(i);
    }

    public final int j(InterfaceC8182Uw3 interfaceC8182Uw3, int i) {
        int iA = AbstractC20987sw3.a(interfaceC8182Uw3, this.d, i);
        if (i != iA) {
            e(iA);
            this.e.j(i);
        }
        return iA;
    }
}
