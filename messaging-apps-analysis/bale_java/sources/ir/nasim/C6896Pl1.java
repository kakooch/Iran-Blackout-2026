package ir.nasim;

/* renamed from: ir.nasim.Pl1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6896Pl1 {
    private final long a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;

    public /* synthetic */ C6896Pl1(long j, long j2, long j3, long j4, long j5, ED1 ed1) {
        this(j, j2, j3, j4, j5);
    }

    public final long a() {
        return this.a;
    }

    public final long b() {
        return this.e;
    }

    public final long c() {
        return this.d;
    }

    public final long d() {
        return this.c;
    }

    public final long e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C6896Pl1)) {
            return false;
        }
        C6896Pl1 c6896Pl1 = (C6896Pl1) obj;
        return C24381yX0.q(this.a, c6896Pl1.a) && C24381yX0.q(this.b, c6896Pl1.b) && C24381yX0.q(this.c, c6896Pl1.c) && C24381yX0.q(this.d, c6896Pl1.d) && C24381yX0.q(this.e, c6896Pl1.e);
    }

    public int hashCode() {
        return (((((((C24381yX0.w(this.a) * 31) + C24381yX0.w(this.b)) * 31) + C24381yX0.w(this.c)) * 31) + C24381yX0.w(this.d)) * 31) + C24381yX0.w(this.e);
    }

    public String toString() {
        return "ContextMenuColors(backgroundColor=" + ((Object) C24381yX0.x(this.a)) + ", textColor=" + ((Object) C24381yX0.x(this.b)) + ", iconColor=" + ((Object) C24381yX0.x(this.c)) + ", disabledTextColor=" + ((Object) C24381yX0.x(this.d)) + ", disabledIconColor=" + ((Object) C24381yX0.x(this.e)) + ')';
    }

    private C6896Pl1(long j, long j2, long j3, long j4, long j5) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
    }
}
