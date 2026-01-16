package ir.nasim;

import ir.nasim.DT1;

/* loaded from: classes2.dex */
public final class HT1 implements DT1.a, DT1 {
    private final UA2 b;
    private C17784nZ1 c;
    private Object d;
    private C17784nZ1 e;
    private Object f;

    public HT1(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "baseDimension");
        this.b = ua2;
    }

    public final C17784nZ1 a() {
        return this.e;
    }

    public final Object b() {
        return this.f;
    }

    public final C17784nZ1 c() {
        return this.c;
    }

    public final Object d() {
        return this.d;
    }

    public final ET1 e(TK6 tk6) {
        AbstractC13042fc3.i(tk6, "state");
        ET1 et1 = (ET1) this.b.invoke(tk6);
        if (d() != null) {
            et1.l(d());
        } else if (c() != null) {
            C17784nZ1 c17784nZ1C = c();
            AbstractC13042fc3.f(c17784nZ1C);
            et1.k(tk6.d(c17784nZ1C));
        }
        if (b() != null) {
            et1.j(b());
        } else if (a() != null) {
            C17784nZ1 c17784nZ1A = a();
            AbstractC13042fc3.f(c17784nZ1A);
            et1.i(tk6.d(c17784nZ1A));
        }
        return et1;
    }
}
