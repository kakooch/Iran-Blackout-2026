package ir.nasim;

/* renamed from: ir.nasim.fO4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C12915fO4 {
    private final long a;
    private final TS4 b;

    public /* synthetic */ C12915fO4(long j, TS4 ts4, ED1 ed1) {
        this(j, ts4);
    }

    public final TS4 a() {
        return this.b;
    }

    public final long b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C12915fO4.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type androidx.compose.foundation.OverscrollConfiguration");
        C12915fO4 c12915fO4 = (C12915fO4) obj;
        return C24381yX0.q(this.a, c12915fO4.a) && AbstractC13042fc3.d(this.b, c12915fO4.b);
    }

    public int hashCode() {
        return (C24381yX0.w(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "OverscrollConfiguration(glowColor=" + ((Object) C24381yX0.x(this.a)) + ", drawPadding=" + this.b + ')';
    }

    private C12915fO4(long j, TS4 ts4) {
        this.a = j;
        this.b = ts4;
    }

    public /* synthetic */ C12915fO4(long j, TS4 ts4, int i, ED1 ed1) {
        this((i & 1) != 0 ? DX0.d(4284900966L) : j, (i & 2) != 0 ? androidx.compose.foundation.layout.q.c(0.0f, 0.0f, 3, null) : ts4, null);
    }
}
