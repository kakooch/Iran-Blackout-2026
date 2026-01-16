package ir.nasim;

/* renamed from: ir.nasim.Sg5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7567Sg5 {
    private final C3419Au3 a;
    private final C17776nY2 b;
    private final C6855Pg5 c = new C6855Pg5();
    private final C18367oY2 d = new C18367oY2();
    private boolean e;

    public C7567Sg5(C3419Au3 c3419Au3) {
        this.a = c3419Au3;
        this.b = new C17776nY2(c3419Au3.s());
    }

    public final void a() {
        this.b.c();
    }

    public final int b(C7099Qg5 c7099Qg5, InterfaceC8058Ui5 interfaceC8058Ui5, boolean z) {
        boolean z2;
        if (this.e) {
            return AbstractC7804Tg5.a(false, false);
        }
        boolean z3 = true;
        try {
            this.e = true;
            C7286Rb3 c7286Rb3B = this.c.b(c7099Qg5, interfaceC8058Ui5);
            int iO = c7286Rb3B.b().o();
            for (int i = 0; i < iO; i++) {
                C6616Og5 c6616Og5 = (C6616Og5) c7286Rb3B.b().p(i);
                if (!c6616Og5.i() && !c6616Og5.l()) {
                }
                z2 = false;
                break;
            }
            z2 = true;
            int iO2 = c7286Rb3B.b().o();
            for (int i2 = 0; i2 < iO2; i2++) {
                C6616Og5 c6616Og52 = (C6616Og5) c7286Rb3B.b().p(i2);
                if (z2 || AbstractC3768Cg5.b(c6616Og52)) {
                    C3419Au3.I0(this.a, c6616Og52.h(), this.d, c6616Og52.n(), false, 8, null);
                    if (!this.d.isEmpty()) {
                        this.b.b(c6616Og52.f(), this.d, AbstractC3768Cg5.b(c6616Og52));
                        this.d.clear();
                    }
                }
            }
            boolean zD = this.b.d(c7286Rb3B, z);
            if (c7286Rb3B.d()) {
                z3 = false;
            } else {
                int iO3 = c7286Rb3B.b().o();
                for (int i3 = 0; i3 < iO3; i3++) {
                    C6616Og5 c6616Og53 = (C6616Og5) c7286Rb3B.b().p(i3);
                    if (AbstractC3768Cg5.k(c6616Og53) && c6616Og53.p()) {
                        break;
                    }
                }
                z3 = false;
            }
            int iA = AbstractC7804Tg5.a(zD, z3);
            this.e = false;
            return iA;
        } catch (Throwable th) {
            this.e = false;
            throw th;
        }
    }

    public final void c() {
        if (this.e) {
            return;
        }
        this.c.a();
        this.b.e();
    }
}
