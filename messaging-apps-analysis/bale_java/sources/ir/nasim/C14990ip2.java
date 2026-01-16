package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.ip2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C14990ip2 {
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
    private final long n;
    private final long o;
    private final long p;
    private final long q;
    private final long r;
    private final long s;
    private final long t;
    private final long u;
    private final long v;
    private final long w;
    private final long x;

    public /* synthetic */ C14990ip2(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, ED1 ed1) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24);
    }

    public final long a() {
        return this.l;
    }

    public final long b() {
        return this.s;
    }

    public final long c() {
        return this.u;
    }

    public final long d() {
        return this.k;
    }

    public final long e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14990ip2)) {
            return false;
        }
        C14990ip2 c14990ip2 = (C14990ip2) obj;
        return C24381yX0.q(this.a, c14990ip2.a) && C24381yX0.q(this.b, c14990ip2.b) && C24381yX0.q(this.c, c14990ip2.c) && C24381yX0.q(this.d, c14990ip2.d) && C24381yX0.q(this.e, c14990ip2.e) && C24381yX0.q(this.f, c14990ip2.f) && C24381yX0.q(this.g, c14990ip2.g) && C24381yX0.q(this.h, c14990ip2.h) && C24381yX0.q(this.i, c14990ip2.i) && C24381yX0.q(this.j, c14990ip2.j) && C24381yX0.q(this.k, c14990ip2.k) && C24381yX0.q(this.l, c14990ip2.l) && C24381yX0.q(this.m, c14990ip2.m) && C24381yX0.q(this.n, c14990ip2.n) && C24381yX0.q(this.o, c14990ip2.o) && C24381yX0.q(this.p, c14990ip2.p) && C24381yX0.q(this.q, c14990ip2.q) && C24381yX0.q(this.r, c14990ip2.r) && C24381yX0.q(this.s, c14990ip2.s) && C24381yX0.q(this.t, c14990ip2.t) && C24381yX0.q(this.u, c14990ip2.u) && C24381yX0.q(this.v, c14990ip2.v) && C24381yX0.q(this.w, c14990ip2.w) && C24381yX0.q(this.x, c14990ip2.x);
    }

    public final long f() {
        return this.i;
    }

    public final long g() {
        return this.d;
    }

    public final long h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((C24381yX0.w(this.a) * 31) + C24381yX0.w(this.b)) * 31) + C24381yX0.w(this.c)) * 31) + C24381yX0.w(this.d)) * 31) + C24381yX0.w(this.e)) * 31) + C24381yX0.w(this.f)) * 31) + C24381yX0.w(this.g)) * 31) + C24381yX0.w(this.h)) * 31) + C24381yX0.w(this.i)) * 31) + C24381yX0.w(this.j)) * 31) + C24381yX0.w(this.k)) * 31) + C24381yX0.w(this.l)) * 31) + C24381yX0.w(this.m)) * 31) + C24381yX0.w(this.n)) * 31) + C24381yX0.w(this.o)) * 31) + C24381yX0.w(this.p)) * 31) + C24381yX0.w(this.q)) * 31) + C24381yX0.w(this.r)) * 31) + C24381yX0.w(this.s)) * 31) + C24381yX0.w(this.t)) * 31) + C24381yX0.w(this.u)) * 31) + C24381yX0.w(this.v)) * 31) + C24381yX0.w(this.w)) * 31) + C24381yX0.w(this.x);
    }

    public final long i() {
        return this.o;
    }

    public final long j() {
        return this.w;
    }

    public final long k() {
        return this.x;
    }

    public final long l() {
        return this.a;
    }

    public String toString() {
        return "FixedColors(primary=" + C24381yX0.x(this.a) + ", n500=" + C24381yX0.x(this.b) + ", n400=" + C24381yX0.x(this.c) + ", n300=" + C24381yX0.x(this.d) + ", n200=" + C24381yX0.x(this.e) + ", n100=" + C24381yX0.x(this.f) + ", n50=" + C24381yX0.x(this.g) + ", n40=" + C24381yX0.x(this.h) + ", n30=" + C24381yX0.x(this.i) + ", n20=" + C24381yX0.x(this.j) + ", n10=" + C24381yX0.x(this.k) + ", background=" + C24381yX0.x(this.l) + ", overlayBg=" + C24381yX0.x(this.m) + ", surface=" + C24381yX0.x(this.n) + ", onBackground=" + C24381yX0.x(this.o) + ", highBrightness=" + C24381yX0.x(this.p) + ", middleBrightness=" + C24381yX0.x(this.q) + ", lowBrightness=" + C24381yX0.x(this.r) + ", error=" + C24381yX0.x(this.s) + ", success=" + C24381yX0.x(this.t) + ", link=" + C24381yX0.x(this.u) + ", alert=" + C24381yX0.x(this.v) + ", premium1=" + C24381yX0.x(this.w) + ", premium2=" + C24381yX0.x(this.x) + Separators.RPAREN;
    }

    private C14990ip2(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24) {
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
        this.n = j14;
        this.o = j15;
        this.p = j16;
        this.q = j17;
        this.r = j18;
        this.s = j19;
        this.t = j20;
        this.u = j21;
        this.v = j22;
        this.w = j23;
        this.x = j24;
    }
}
