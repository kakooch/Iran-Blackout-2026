package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.ds7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C11984ds7 {
    public static final a e = new a(null);
    public static final int f = 0;
    private final long a;
    private final long b;
    private final long c;
    private final long d;

    /* renamed from: ir.nasim.ds7$a */
    public static final class a {
        private a() {
        }

        public final C11984ds7 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-1133882874);
            G10 g10 = G10.a;
            C11984ds7 c11984ds7 = new C11984ds7(g10.a(interfaceC22053ub1, 6).r(), g10.a(interfaceC22053ub1, 6).F(), g10.a(interfaceC22053ub1, 6).z(), g10.a(interfaceC22053ub1, 6).B(), null);
            interfaceC22053ub1.Q();
            return c11984ds7;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C11984ds7(long j, long j2, long j3, long j4, ED1 ed1) {
        this(j, j2, j3, j4);
    }

    public final C11984ds7 a(long j, long j2, long j3, long j4) {
        return new C11984ds7(j, j2, j3, j4, null);
    }

    public final long c() {
        return this.a;
    }

    public final long d() {
        return this.c;
    }

    public final long e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11984ds7)) {
            return false;
        }
        C11984ds7 c11984ds7 = (C11984ds7) obj;
        return C24381yX0.q(this.a, c11984ds7.a) && C24381yX0.q(this.b, c11984ds7.b) && C24381yX0.q(this.c, c11984ds7.c) && C24381yX0.q(this.d, c11984ds7.d);
    }

    public final long f() {
        return this.b;
    }

    public int hashCode() {
        return (((((C24381yX0.w(this.a) * 31) + C24381yX0.w(this.b)) * 31) + C24381yX0.w(this.c)) * 31) + C24381yX0.w(this.d);
    }

    public String toString() {
        return "TopAlignedListItemColors(containerColor=" + C24381yX0.x(this.a) + ", titleColor=" + C24381yX0.x(this.b) + ", descriptionColor=" + C24381yX0.x(this.c) + ", iconColor=" + C24381yX0.x(this.d) + Separators.RPAREN;
    }

    private C11984ds7(long j, long j2, long j3, long j4) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
    }
}
