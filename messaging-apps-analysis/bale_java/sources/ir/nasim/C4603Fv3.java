package ir.nasim;

/* renamed from: ir.nasim.Fv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4603Fv3 {
    private final InterfaceC17916nm4 a;
    private final InterfaceC17916nm4 b;
    private boolean c;
    private Object d;
    private final C3910Cw3 e;

    public C4603Fv3(int i, int i2) {
        this.a = UG6.a(i);
        this.b = UG6.a(i2);
        this.e = new C3910Cw3(i, 90, 200);
    }

    private final void e(int i) {
        this.a.h(i);
    }

    private final void f(int i) {
        this.b.h(i);
    }

    private final void g(int i, int i2) {
        if (!(((float) i) >= 0.0f)) {
            P73.a("Index should be non-negative");
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

    public final void h(C23441wv3 c23441wv3) {
        C24031xv3[] c24031xv3ArrB;
        C24031xv3 c24031xv3;
        C24031xv3[] c24031xv3ArrB2;
        C24031xv3 c24031xv32;
        C25215zv3 c25215zv3R = c23441wv3.r();
        this.d = (c25215zv3R == null || (c24031xv3ArrB2 = c25215zv3R.b()) == null || (c24031xv32 = (C24031xv3) AbstractC10242bK.e0(c24031xv3ArrB2)) == null) ? null : c24031xv32.getKey();
        if (this.c || c23441wv3.g() > 0) {
            this.c = true;
            int iS = c23441wv3.s();
            int index = 0;
            if (!(((float) iS) >= 0.0f)) {
                P73.c("scrollOffset should be non-negative (" + iS + ')');
            }
            C25215zv3 c25215zv3R2 = c23441wv3.r();
            if (c25215zv3R2 != null && (c24031xv3ArrB = c25215zv3R2.b()) != null && (c24031xv3 = (C24031xv3) AbstractC10242bK.e0(c24031xv3ArrB)) != null) {
                index = c24031xv3.getIndex();
            }
            g(index, iS);
        }
    }

    public final void i(int i) {
        if (!(((float) i) >= 0.0f)) {
            P73.c("scrollOffset should be non-negative");
        }
        f(i);
    }

    public final int j(InterfaceC17414mv3 interfaceC17414mv3, int i) {
        int iA = AbstractC20987sw3.a(interfaceC17414mv3, this.d, i);
        if (i != iA) {
            e(iA);
            this.e.j(i);
        }
        return iA;
    }
}
