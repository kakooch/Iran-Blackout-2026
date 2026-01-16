package ir.nasim;

/* loaded from: classes.dex */
public final class LG0 {
    private final long a;
    private final long b;
    private final long c;
    private final long d;

    public /* synthetic */ LG0(long j, long j2, long j3, long j4, ED1 ed1) {
        this(j, j2, j3, j4);
    }

    public final long a(boolean z) {
        return z ? this.a : this.c;
    }

    public final long b(boolean z) {
        return z ? this.b : this.d;
    }

    public final LG0 c(long j, long j2, long j3, long j4) {
        return new LG0(j != 16 ? j : this.a, j2 != 16 ? j2 : this.b, j3 != 16 ? j3 : this.c, j4 != 16 ? j4 : this.d, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LG0)) {
            return false;
        }
        LG0 lg0 = (LG0) obj;
        return C24381yX0.q(this.a, lg0.a) && C24381yX0.q(this.b, lg0.b) && C24381yX0.q(this.c, lg0.c) && C24381yX0.q(this.d, lg0.d);
    }

    public int hashCode() {
        return (((((C24381yX0.w(this.a) * 31) + C24381yX0.w(this.b)) * 31) + C24381yX0.w(this.c)) * 31) + C24381yX0.w(this.d);
    }

    private LG0(long j, long j2, long j3, long j4) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
    }
}
