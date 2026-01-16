package ir.nasim;

/* renamed from: ir.nasim.m11, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C16878m11 extends AbstractC23070wI4 {
    public SA2 d;

    public C16878m11(boolean z) {
        super(z);
    }

    @Override // ir.nasim.AbstractC23070wI4
    public void d() {
        l().invoke();
    }

    public final SA2 l() {
        SA2 sa2 = this.d;
        if (sa2 != null) {
            return sa2;
        }
        AbstractC13042fc3.y("onBackPressed");
        return null;
    }

    public final void m(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "<set-?>");
        this.d = sa2;
    }
}
