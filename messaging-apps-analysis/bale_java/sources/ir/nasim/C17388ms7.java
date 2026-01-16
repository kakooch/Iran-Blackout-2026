package ir.nasim;

/* renamed from: ir.nasim.ms7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C17388ms7 {
    private final long a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;

    public /* synthetic */ C17388ms7(long j, long j2, long j3, long j4, long j5, ED1 ed1) {
        this(j, j2, j3, j4, j5);
    }

    public final long a(float f) {
        return DX0.i(this.a, this.b, T22.c().a(f));
    }

    public final C17388ms7 b(long j, long j2, long j3, long j4, long j5) {
        return new C17388ms7(j != 16 ? j : this.a, j2 != 16 ? j2 : this.b, j3 != 16 ? j3 : this.c, j4 != 16 ? j4 : this.d, j5 != 16 ? j5 : this.e, null);
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C17388ms7)) {
            return false;
        }
        C17388ms7 c17388ms7 = (C17388ms7) obj;
        return C24381yX0.q(this.a, c17388ms7.a) && C24381yX0.q(this.b, c17388ms7.b) && C24381yX0.q(this.c, c17388ms7.c) && C24381yX0.q(this.d, c17388ms7.d) && C24381yX0.q(this.e, c17388ms7.e);
    }

    public final long f() {
        return this.d;
    }

    public int hashCode() {
        return (((((((C24381yX0.w(this.a) * 31) + C24381yX0.w(this.b)) * 31) + C24381yX0.w(this.c)) * 31) + C24381yX0.w(this.d)) * 31) + C24381yX0.w(this.e);
    }

    private C17388ms7(long j, long j2, long j3, long j4, long j5) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
    }
}
