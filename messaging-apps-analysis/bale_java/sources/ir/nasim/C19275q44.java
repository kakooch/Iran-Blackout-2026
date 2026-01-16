package ir.nasim;

/* renamed from: ir.nasim.q44, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19275q44 {
    private final long a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;

    public /* synthetic */ C19275q44(long j, long j2, long j3, long j4, long j5, long j6, ED1 ed1) {
        this(j, j2, j3, j4, j5, j6);
    }

    public final long a(boolean z) {
        return z ? this.b : this.e;
    }

    public final long b(boolean z) {
        return z ? this.a : this.d;
    }

    public final long c(boolean z) {
        return z ? this.c : this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C19275q44)) {
            return false;
        }
        C19275q44 c19275q44 = (C19275q44) obj;
        return C24381yX0.q(this.a, c19275q44.a) && C24381yX0.q(this.b, c19275q44.b) && C24381yX0.q(this.c, c19275q44.c) && C24381yX0.q(this.d, c19275q44.d) && C24381yX0.q(this.e, c19275q44.e) && C24381yX0.q(this.f, c19275q44.f);
    }

    public int hashCode() {
        return (((((((((C24381yX0.w(this.a) * 31) + C24381yX0.w(this.b)) * 31) + C24381yX0.w(this.c)) * 31) + C24381yX0.w(this.d)) * 31) + C24381yX0.w(this.e)) * 31) + C24381yX0.w(this.f);
    }

    private C19275q44(long j, long j2, long j3, long j4, long j5, long j6) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
    }
}
