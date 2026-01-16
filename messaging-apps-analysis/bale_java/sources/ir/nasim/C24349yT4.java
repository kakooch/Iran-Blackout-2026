package ir.nasim;

/* renamed from: ir.nasim.yT4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C24349yT4 {
    private final GT4 a;
    private final InterfaceC17916nm4 b;
    private final InterfaceC14354hm4 c;
    private boolean d;
    private Object e;
    private final C3910Cw3 f;

    public C24349yT4(int i, float f, GT4 gt4) {
        this.a = gt4;
        this.b = UG6.a(i);
        this.c = AbstractC4326Eq5.a(f);
        this.f = new C3910Cw3(i, 30, 100);
    }

    private final void g(int i) {
        this.b.h(i);
    }

    private final void h(float f) {
        this.c.s(f);
    }

    private final void i(int i, float f) {
        g(i);
        this.f.j(i);
        h(f);
    }

    public final void a(int i) {
        h(c() + (this.a.J() == 0 ? 0.0f : i / this.a.J()));
    }

    public final int b() {
        return this.b.d();
    }

    public final float c() {
        return this.c.a();
    }

    public final C3910Cw3 d() {
        return this.f;
    }

    public final int e(C19506qT4 c19506qT4, int i) {
        int iA = AbstractC20987sw3.a(c19506qT4, this.e, i);
        if (i != iA) {
            g(iA);
            this.f.j(i);
        }
        return iA;
    }

    public final void f(int i, float f) {
        i(i, f);
        this.e = null;
    }

    public final void j(float f) {
        h(f);
    }

    public final void k(C21326tT4 c21326tT4) {
        C14806iW3 c14806iW3S = c21326tT4.s();
        this.e = c14806iW3S != null ? c14806iW3S.c() : null;
        if (this.d || (!c21326tT4.i().isEmpty())) {
            this.d = true;
            C14806iW3 c14806iW3S2 = c21326tT4.s();
            i(c14806iW3S2 != null ? c14806iW3S2.getIndex() : 0, c21326tT4.u());
        }
    }
}
