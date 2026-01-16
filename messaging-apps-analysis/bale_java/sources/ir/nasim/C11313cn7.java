package ir.nasim;

/* renamed from: ir.nasim.cn7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11313cn7 {
    private final C17660nL3 a;
    private C19715qp0 b;
    private C13774gn7 c;

    public C11313cn7(int i) {
        this.a = i != 1 ? new C17660nL3(i) : null;
    }

    public final C13774gn7 a(C13183fn7 c13183fn7) {
        C13774gn7 c13774gn7;
        C19715qp0 c19715qp0 = new C19715qp0(c13183fn7);
        C17660nL3 c17660nL3 = this.a;
        if (c17660nL3 != null) {
            c13774gn7 = (C13774gn7) c17660nL3.d(c19715qp0);
        } else {
            if (!AbstractC13042fc3.d(this.b, c19715qp0)) {
                return null;
            }
            c13774gn7 = this.c;
        }
        if (c13774gn7 == null || c13774gn7.w().j().a()) {
            return null;
        }
        return c13774gn7;
    }

    public final void b(C13183fn7 c13183fn7, C13774gn7 c13774gn7) {
        C17660nL3 c17660nL3 = this.a;
        if (c17660nL3 != null) {
            c17660nL3.f(new C19715qp0(c13183fn7), c13774gn7);
        } else {
            this.b = new C19715qp0(c13183fn7);
            this.c = c13774gn7;
        }
    }
}
