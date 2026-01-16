package ir.nasim;

/* renamed from: ir.nasim.nI1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17631nI1 {
    private final C16449lI1 a;
    private final C16449lI1 b;

    public C17631nI1(boolean z) {
        this.a = new C16449lI1(z);
        this.b = new C16449lI1(z);
    }

    public final void c(C3419Au3 c3419Au3, boolean z) {
        if (z) {
            this.a.a(c3419Au3);
            this.b.a(c3419Au3);
        } else {
            if (this.a.b(c3419Au3)) {
                return;
            }
            this.b.a(c3419Au3);
        }
    }

    public final boolean d(C3419Au3 c3419Au3) {
        return this.a.b(c3419Au3) || this.b.b(c3419Au3);
    }

    public final boolean e(C3419Au3 c3419Au3, boolean z) {
        boolean zB = this.a.b(c3419Au3);
        return z ? zB : zB || this.b.b(c3419Au3);
    }

    public final boolean f() {
        return this.b.c() && this.a.c();
    }

    public final boolean g(boolean z) {
        return (z ? this.a : this.b).c();
    }

    public final boolean h() {
        return !f();
    }

    public final boolean i(C3419Au3 c3419Au3) {
        return this.b.e(c3419Au3) || this.a.e(c3419Au3);
    }
}
