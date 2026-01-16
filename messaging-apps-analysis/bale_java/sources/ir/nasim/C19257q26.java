package ir.nasim;

/* renamed from: ir.nasim.q26, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19257q26 {
    private final long a;
    private final C17484n26 b;

    public /* synthetic */ C19257q26(long j, C17484n26 c17484n26, ED1 ed1) {
        this(j, c17484n26);
    }

    public final long a() {
        return this.a;
    }

    public final C17484n26 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19257q26)) {
            return false;
        }
        C19257q26 c19257q26 = (C19257q26) obj;
        return C24381yX0.q(this.a, c19257q26.a) && AbstractC13042fc3.d(this.b, c19257q26.b);
    }

    public int hashCode() {
        int iW = C24381yX0.w(this.a) * 31;
        C17484n26 c17484n26 = this.b;
        return iW + (c17484n26 != null ? c17484n26.hashCode() : 0);
    }

    public String toString() {
        return "RippleConfiguration(color=" + ((Object) C24381yX0.x(this.a)) + ", rippleAlpha=" + this.b + ')';
    }

    private C19257q26(long j, C17484n26 c17484n26) {
        this.a = j;
        this.b = c17484n26;
    }

    public /* synthetic */ C19257q26(long j, C17484n26 c17484n26, int i, ED1 ed1) {
        this((i & 1) != 0 ? C24381yX0.b.i() : j, (i & 2) != 0 ? null : c17484n26, null);
    }
}
