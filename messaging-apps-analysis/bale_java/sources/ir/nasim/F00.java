package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public final class F00 {
    public static final a e = new a(null);
    private final long a;
    private final long b;
    private final long c;
    private final long d;

    public static final class a {
        private a() {
        }

        public final F00 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-23295148);
            G10 g10 = G10.a;
            F00 f00 = new F00(g10.a(interfaceC22053ub1, 6).z(), g10.a(interfaceC22053ub1, 6).F(), g10.a(interfaceC22053ub1, 6).x(), g10.a(interfaceC22053ub1, 6).B(), null);
            interfaceC22053ub1.Q();
            return f00;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ F00(long j, long j2, long j3, long j4, ED1 ed1) {
        this(j, j2, j3, j4);
    }

    public final long a() {
        return this.c;
    }

    public final long b() {
        return this.b;
    }

    public final long c() {
        return this.d;
    }

    public final long d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof F00)) {
            return false;
        }
        F00 f00 = (F00) obj;
        return C24381yX0.q(this.a, f00.a) && C24381yX0.q(this.b, f00.b) && C24381yX0.q(this.c, f00.c) && C24381yX0.q(this.d, f00.d);
    }

    public int hashCode() {
        return (((((C24381yX0.w(this.a) * 31) + C24381yX0.w(this.b)) * 31) + C24381yX0.w(this.c)) * 31) + C24381yX0.w(this.d);
    }

    public String toString() {
        return "BaleProfileItemColors(titleColor=" + C24381yX0.x(this.a) + ", enableValueColor=" + C24381yX0.x(this.b) + ", disableValueColor=" + C24381yX0.x(this.c) + ", iconColor=" + C24381yX0.x(this.d) + Separators.RPAREN;
    }

    private F00(long j, long j2, long j3, long j4) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
    }
}
