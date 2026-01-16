package ir.nasim;

/* renamed from: ir.nasim.Am6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3350Am6 {
    private final long a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;
    private final long i;
    private final long j;
    private final long k;
    private final long l;
    private final long m;

    public /* synthetic */ C3350Am6(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, ED1 ed1) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13);
    }

    public final long a(boolean z, boolean z2) {
        return !z ? z2 ? this.j : this.e : !z2 ? this.a : this.i;
    }

    public final C3350Am6 b(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13) {
        return new C3350Am6(j != 16 ? j : this.a, j2 != 16 ? j2 : this.b, j3 != 16 ? j3 : this.c, j4 != 16 ? j4 : this.d, j5 != 16 ? j5 : this.e, j6 != 16 ? j6 : this.f, j7 != 16 ? j7 : this.g, j8 != 16 ? j8 : this.h, j9 != 16 ? j9 : this.i, j10 != 16 ? j10 : this.j, j11 != 16 ? j11 : this.k, j12 != 16 ? j12 : this.l, j13 != 16 ? j13 : this.m, null);
    }

    public final long d(boolean z, boolean z2) {
        return !z ? this.f : !z2 ? this.b : this.k;
    }

    public final long e(boolean z, boolean z2) {
        return !z ? this.g : !z2 ? this.c : this.l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C3350Am6)) {
            return false;
        }
        C3350Am6 c3350Am6 = (C3350Am6) obj;
        return C24381yX0.q(this.a, c3350Am6.a) && C24381yX0.q(this.b, c3350Am6.b) && C24381yX0.q(this.c, c3350Am6.c) && C24381yX0.q(this.d, c3350Am6.d) && C24381yX0.q(this.e, c3350Am6.e) && C24381yX0.q(this.f, c3350Am6.f) && C24381yX0.q(this.g, c3350Am6.g) && C24381yX0.q(this.h, c3350Am6.h) && C24381yX0.q(this.i, c3350Am6.i) && C24381yX0.q(this.j, c3350Am6.j) && C24381yX0.q(this.k, c3350Am6.k) && C24381yX0.q(this.l, c3350Am6.l) && C24381yX0.q(this.m, c3350Am6.m);
    }

    public final long f(boolean z, boolean z2) {
        return !z ? this.h : !z2 ? this.d : this.m;
    }

    public int hashCode() {
        return (((((((((((((((((((((((C24381yX0.w(this.a) * 31) + C24381yX0.w(this.b)) * 31) + C24381yX0.w(this.c)) * 31) + C24381yX0.w(this.d)) * 31) + C24381yX0.w(this.e)) * 31) + C24381yX0.w(this.f)) * 31) + C24381yX0.w(this.g)) * 31) + C24381yX0.w(this.h)) * 31) + C24381yX0.w(this.i)) * 31) + C24381yX0.w(this.j)) * 31) + C24381yX0.w(this.k)) * 31) + C24381yX0.w(this.l)) * 31) + C24381yX0.w(this.m);
    }

    private C3350Am6(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
        this.g = j7;
        this.h = j8;
        this.i = j9;
        this.j = j10;
        this.k = j11;
        this.l = j12;
        this.m = j13;
    }
}
