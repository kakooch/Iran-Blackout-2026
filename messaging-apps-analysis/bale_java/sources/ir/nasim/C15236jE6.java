package ir.nasim;

/* renamed from: ir.nasim.jE6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15236jE6 {
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

    public /* synthetic */ C15236jE6(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, ED1 ed1) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10);
    }

    public final C15236jE6 a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        return new C15236jE6(j != 16 ? j : this.a, j2 != 16 ? j2 : this.b, j3 != 16 ? j3 : this.c, j4 != 16 ? j4 : this.d, j5 != 16 ? j5 : this.e, j6 != 16 ? j6 : this.f, j7 != 16 ? j7 : this.g, j8 != 16 ? j8 : this.h, j9 != 16 ? j9 : this.i, j10 != 16 ? j10 : this.j, null);
    }

    public final long b(boolean z) {
        return z ? this.a : this.f;
    }

    public final long c(boolean z, boolean z2) {
        return z ? z2 ? this.c : this.e : z2 ? this.h : this.j;
    }

    public final long d(boolean z, boolean z2) {
        return z ? z2 ? this.b : this.d : z2 ? this.g : this.i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C15236jE6)) {
            return false;
        }
        C15236jE6 c15236jE6 = (C15236jE6) obj;
        return C24381yX0.q(this.a, c15236jE6.a) && C24381yX0.q(this.b, c15236jE6.b) && C24381yX0.q(this.c, c15236jE6.c) && C24381yX0.q(this.d, c15236jE6.d) && C24381yX0.q(this.e, c15236jE6.e) && C24381yX0.q(this.f, c15236jE6.f) && C24381yX0.q(this.g, c15236jE6.g) && C24381yX0.q(this.h, c15236jE6.h) && C24381yX0.q(this.i, c15236jE6.i) && C24381yX0.q(this.j, c15236jE6.j);
    }

    public int hashCode() {
        return (((((((((((((((((C24381yX0.w(this.a) * 31) + C24381yX0.w(this.b)) * 31) + C24381yX0.w(this.c)) * 31) + C24381yX0.w(this.d)) * 31) + C24381yX0.w(this.e)) * 31) + C24381yX0.w(this.f)) * 31) + C24381yX0.w(this.g)) * 31) + C24381yX0.w(this.h)) * 31) + C24381yX0.w(this.i)) * 31) + C24381yX0.w(this.j);
    }

    private C15236jE6(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
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
    }
}
