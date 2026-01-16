package ir.nasim;

/* renamed from: ir.nasim.lI1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16449lI1 {
    private final boolean a;
    private C3348Am4 b;
    private final C10023aw7 c = new C10023aw7(AbstractC17040mI1.a);

    public C16449lI1(boolean z) {
        this.a = z;
    }

    private final C3348Am4 f() {
        if (this.b == null) {
            this.b = AbstractC21866uG4.b();
        }
        C3348Am4 c3348Am4 = this.b;
        AbstractC13042fc3.f(c3348Am4);
        return c3348Am4;
    }

    public final void a(C3419Au3 c3419Au3) {
        if (!c3419Au3.b()) {
            M73.b("DepthSortedSet.add called on an unattached node");
        }
        if (this.a) {
            C3348Am4 c3348Am4F = f();
            int iE = c3348Am4F.e(c3419Au3, Integer.MAX_VALUE);
            if (iE == Integer.MAX_VALUE) {
                c3348Am4F.u(c3419Au3, c3419Au3.U());
            } else {
                if (!(iE == c3419Au3.U())) {
                    M73.b("invalid node depth");
                }
            }
        }
        this.c.add(c3419Au3);
    }

    public final boolean b(C3419Au3 c3419Au3) {
        boolean zContains = this.c.contains(c3419Au3);
        if (this.a) {
            if (!(zContains == f().a(c3419Au3))) {
                M73.b("inconsistency in TreeSet");
            }
        }
        return zContains;
    }

    public final boolean c() {
        return this.c.isEmpty();
    }

    public final C3419Au3 d() {
        C3419Au3 c3419Au3 = (C3419Au3) this.c.first();
        e(c3419Au3);
        return c3419Au3;
    }

    public final boolean e(C3419Au3 c3419Au3) {
        if (!c3419Au3.b()) {
            M73.b("DepthSortedSet.remove called on an unattached node");
        }
        boolean zRemove = this.c.remove(c3419Au3);
        if (this.a) {
            C3348Am4 c3348Am4F = f();
            if (c3348Am4F.a(c3419Au3)) {
                int iC = c3348Am4F.c(c3419Au3);
                c3348Am4F.r(c3419Au3);
                if (!(iC == (zRemove ? c3419Au3.U() : Integer.MAX_VALUE))) {
                    M73.b("invalid node depth");
                }
            }
        }
        return zRemove;
    }

    public String toString() {
        return this.c.toString();
    }
}
