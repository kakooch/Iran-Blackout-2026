package ir.nasim;

import ir.nasim.C13245fu;

/* renamed from: ir.nasim.fI6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12863fI6 implements C13245fu.a {
    private final InterfaceC25129zm7 a;
    private final long b;
    private final C4593Fu2 c;
    private final C3418Au2 d;
    private final C3657Bu2 e;
    private final AbstractC9998au2 f;
    private final String g;
    private final long h;
    private final C18413od0 i;
    private final C3590Bm7 j;
    private final IH3 k;
    private final long l;
    private final C24525yl7 m;
    private final C5566Jw6 n;
    private final C19620qf5 o;
    private final AbstractC18051o02 p;

    public /* synthetic */ C12863fI6(long j, long j2, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j3, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j4, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, C19620qf5 c19620qf5, AbstractC18051o02 abstractC18051o02, ED1 ed1) {
        this(j, j2, c4593Fu2, c3418Au2, c3657Bu2, abstractC9998au2, str, j3, c18413od0, c3590Bm7, ih3, j4, c24525yl7, c5566Jw6, c19620qf5, abstractC18051o02);
    }

    public final C12863fI6 a(long j, long j2, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j3, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j4, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, C19620qf5 c19620qf5, AbstractC18051o02 abstractC18051o02) {
        return new C12863fI6(C24381yX0.q(j, g()) ? this.a : InterfaceC25129zm7.a.b(j), j2, c4593Fu2, c3418Au2, c3657Bu2, abstractC9998au2, str, j3, c18413od0, c3590Bm7, ih3, j4, c24525yl7, c5566Jw6, c19620qf5, abstractC18051o02, (ED1) null);
    }

    public final float c() {
        return this.a.a();
    }

    public final long d() {
        return this.l;
    }

    public final C18413od0 e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12863fI6)) {
            return false;
        }
        C12863fI6 c12863fI6 = (C12863fI6) obj;
        return v(c12863fI6) && w(c12863fI6);
    }

    public final AbstractC12520el0 f() {
        return this.a.e();
    }

    public final long g() {
        return this.a.d();
    }

    public final AbstractC18051o02 h() {
        return this.p;
    }

    public int hashCode() {
        int iW = C24381yX0.w(g()) * 31;
        AbstractC12520el0 abstractC12520el0F = f();
        int iHashCode = (((((iW + (abstractC12520el0F != null ? abstractC12520el0F.hashCode() : 0)) * 31) + Float.hashCode(c())) * 31) + C13193fo7.i(this.b)) * 31;
        C4593Fu2 c4593Fu2 = this.c;
        int iHashCode2 = (iHashCode + (c4593Fu2 != null ? c4593Fu2.hashCode() : 0)) * 31;
        C3418Au2 c3418Au2 = this.d;
        int iG = (iHashCode2 + (c3418Au2 != null ? C3418Au2.g(c3418Au2.i()) : 0)) * 31;
        C3657Bu2 c3657Bu2 = this.e;
        int i = (iG + (c3657Bu2 != null ? C3657Bu2.i(c3657Bu2.m()) : 0)) * 31;
        AbstractC9998au2 abstractC9998au2 = this.f;
        int iHashCode3 = (i + (abstractC9998au2 != null ? abstractC9998au2.hashCode() : 0)) * 31;
        String str = this.g;
        int iHashCode4 = (((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + C13193fo7.i(this.h)) * 31;
        C18413od0 c18413od0 = this.i;
        int iF = (iHashCode4 + (c18413od0 != null ? C18413od0.f(c18413od0.h()) : 0)) * 31;
        C3590Bm7 c3590Bm7 = this.j;
        int iHashCode5 = (iF + (c3590Bm7 != null ? c3590Bm7.hashCode() : 0)) * 31;
        IH3 ih3 = this.k;
        int iHashCode6 = (((iHashCode5 + (ih3 != null ? ih3.hashCode() : 0)) * 31) + C24381yX0.w(this.l)) * 31;
        C24525yl7 c24525yl7 = this.m;
        int iHashCode7 = (iHashCode6 + (c24525yl7 != null ? c24525yl7.hashCode() : 0)) * 31;
        C5566Jw6 c5566Jw6 = this.n;
        int iHashCode8 = (iHashCode7 + (c5566Jw6 != null ? c5566Jw6.hashCode() : 0)) * 31;
        C19620qf5 c19620qf5 = this.o;
        int iHashCode9 = (iHashCode8 + (c19620qf5 != null ? c19620qf5.hashCode() : 0)) * 31;
        AbstractC18051o02 abstractC18051o02 = this.p;
        return iHashCode9 + (abstractC18051o02 != null ? abstractC18051o02.hashCode() : 0);
    }

    public final AbstractC9998au2 i() {
        return this.f;
    }

    public final String j() {
        return this.g;
    }

    public final long k() {
        return this.b;
    }

    public final C3418Au2 l() {
        return this.d;
    }

    public final C3657Bu2 m() {
        return this.e;
    }

    public final C4593Fu2 n() {
        return this.c;
    }

    public final long o() {
        return this.h;
    }

    public final IH3 p() {
        return this.k;
    }

    public final C19620qf5 q() {
        return this.o;
    }

    public final C5566Jw6 r() {
        return this.n;
    }

    public final C24525yl7 s() {
        return this.m;
    }

    public final InterfaceC25129zm7 t() {
        return this.a;
    }

    public String toString() {
        return "SpanStyle(color=" + ((Object) C24381yX0.x(g())) + ", brush=" + f() + ", alpha=" + c() + ", fontSize=" + ((Object) C13193fo7.j(this.b)) + ", fontWeight=" + this.c + ", fontStyle=" + this.d + ", fontSynthesis=" + this.e + ", fontFamily=" + this.f + ", fontFeatureSettings=" + this.g + ", letterSpacing=" + ((Object) C13193fo7.j(this.h)) + ", baselineShift=" + this.i + ", textGeometricTransform=" + this.j + ", localeList=" + this.k + ", background=" + ((Object) C24381yX0.x(this.l)) + ", textDecoration=" + this.m + ", shadow=" + this.n + ", platformStyle=" + this.o + ", drawStyle=" + this.p + ')';
    }

    public final C3590Bm7 u() {
        return this.j;
    }

    public final boolean v(C12863fI6 c12863fI6) {
        if (this == c12863fI6) {
            return true;
        }
        return C13193fo7.e(this.b, c12863fI6.b) && AbstractC13042fc3.d(this.c, c12863fI6.c) && AbstractC13042fc3.d(this.d, c12863fI6.d) && AbstractC13042fc3.d(this.e, c12863fI6.e) && AbstractC13042fc3.d(this.f, c12863fI6.f) && AbstractC13042fc3.d(this.g, c12863fI6.g) && C13193fo7.e(this.h, c12863fI6.h) && AbstractC13042fc3.d(this.i, c12863fI6.i) && AbstractC13042fc3.d(this.j, c12863fI6.j) && AbstractC13042fc3.d(this.k, c12863fI6.k) && C24381yX0.q(this.l, c12863fI6.l) && AbstractC13042fc3.d(this.o, c12863fI6.o);
    }

    public final boolean w(C12863fI6 c12863fI6) {
        return AbstractC13042fc3.d(this.a, c12863fI6.a) && AbstractC13042fc3.d(this.m, c12863fI6.m) && AbstractC13042fc3.d(this.n, c12863fI6.n) && AbstractC13042fc3.d(this.p, c12863fI6.p);
    }

    public final int x() {
        int i = C13193fo7.i(this.b) * 31;
        C4593Fu2 c4593Fu2 = this.c;
        int iHashCode = (i + (c4593Fu2 != null ? c4593Fu2.hashCode() : 0)) * 31;
        C3418Au2 c3418Au2 = this.d;
        int iG = (iHashCode + (c3418Au2 != null ? C3418Au2.g(c3418Au2.i()) : 0)) * 31;
        C3657Bu2 c3657Bu2 = this.e;
        int i2 = (iG + (c3657Bu2 != null ? C3657Bu2.i(c3657Bu2.m()) : 0)) * 31;
        AbstractC9998au2 abstractC9998au2 = this.f;
        int iHashCode2 = (i2 + (abstractC9998au2 != null ? abstractC9998au2.hashCode() : 0)) * 31;
        String str = this.g;
        int iHashCode3 = (((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + C13193fo7.i(this.h)) * 31;
        C18413od0 c18413od0 = this.i;
        int iF = (iHashCode3 + (c18413od0 != null ? C18413od0.f(c18413od0.h()) : 0)) * 31;
        C3590Bm7 c3590Bm7 = this.j;
        int iHashCode4 = (iF + (c3590Bm7 != null ? c3590Bm7.hashCode() : 0)) * 31;
        IH3 ih3 = this.k;
        int iHashCode5 = (((iHashCode4 + (ih3 != null ? ih3.hashCode() : 0)) * 31) + C24381yX0.w(this.l)) * 31;
        C19620qf5 c19620qf5 = this.o;
        return iHashCode5 + (c19620qf5 != null ? c19620qf5.hashCode() : 0);
    }

    public final C12863fI6 y(C12863fI6 c12863fI6) {
        return c12863fI6 == null ? this : AbstractC13481gI6.b(this, c12863fI6.a.d(), c12863fI6.a.e(), c12863fI6.a.a(), c12863fI6.b, c12863fI6.c, c12863fI6.d, c12863fI6.e, c12863fI6.f, c12863fI6.g, c12863fI6.h, c12863fI6.i, c12863fI6.j, c12863fI6.k, c12863fI6.l, c12863fI6.m, c12863fI6.n, c12863fI6.o, c12863fI6.p);
    }

    public /* synthetic */ C12863fI6(AbstractC12520el0 abstractC12520el0, float f, long j, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j2, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j3, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, C19620qf5 c19620qf5, AbstractC18051o02 abstractC18051o02, ED1 ed1) {
        this(abstractC12520el0, f, j, c4593Fu2, c3418Au2, c3657Bu2, abstractC9998au2, str, j2, c18413od0, c3590Bm7, ih3, j3, c24525yl7, c5566Jw6, c19620qf5, abstractC18051o02);
    }

    public /* synthetic */ C12863fI6(InterfaceC25129zm7 interfaceC25129zm7, long j, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j2, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j3, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, C19620qf5 c19620qf5, AbstractC18051o02 abstractC18051o02, ED1 ed1) {
        this(interfaceC25129zm7, j, c4593Fu2, c3418Au2, c3657Bu2, abstractC9998au2, str, j2, c18413od0, c3590Bm7, ih3, j3, c24525yl7, c5566Jw6, c19620qf5, abstractC18051o02);
    }

    private C12863fI6(InterfaceC25129zm7 interfaceC25129zm7, long j, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j2, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j3, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, C19620qf5 c19620qf5, AbstractC18051o02 abstractC18051o02) {
        this.a = interfaceC25129zm7;
        this.b = j;
        this.c = c4593Fu2;
        this.d = c3418Au2;
        this.e = c3657Bu2;
        this.f = abstractC9998au2;
        this.g = str;
        this.h = j2;
        this.i = c18413od0;
        this.j = c3590Bm7;
        this.k = ih3;
        this.l = j3;
        this.m = c24525yl7;
        this.n = c5566Jw6;
        this.o = c19620qf5;
        this.p = abstractC18051o02;
    }

    public /* synthetic */ C12863fI6(long j, long j2, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j3, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j4, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, C19620qf5 c19620qf5, AbstractC18051o02 abstractC18051o02, int i, ED1 ed1) {
        this((i & 1) != 0 ? C24381yX0.b.i() : j, (i & 2) != 0 ? C13193fo7.b.a() : j2, (i & 4) != 0 ? null : c4593Fu2, (i & 8) != 0 ? null : c3418Au2, (i & 16) != 0 ? null : c3657Bu2, (i & 32) != 0 ? null : abstractC9998au2, (i & 64) != 0 ? null : str, (i & 128) != 0 ? C13193fo7.b.a() : j3, (i & 256) != 0 ? null : c18413od0, (i & 512) != 0 ? null : c3590Bm7, (i & 1024) != 0 ? null : ih3, (i & 2048) != 0 ? C24381yX0.b.i() : j4, (i & 4096) != 0 ? null : c24525yl7, (i & 8192) != 0 ? null : c5566Jw6, (i & 16384) != 0 ? null : c19620qf5, (i & 32768) != 0 ? null : abstractC18051o02, (ED1) null);
    }

    private C12863fI6(long j, long j2, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j3, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j4, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, C19620qf5 c19620qf5, AbstractC18051o02 abstractC18051o02) {
        this(InterfaceC25129zm7.a.b(j), j2, c4593Fu2, c3418Au2, c3657Bu2, abstractC9998au2, str, j3, c18413od0, c3590Bm7, ih3, j4, c24525yl7, c5566Jw6, c19620qf5, abstractC18051o02, (ED1) null);
    }

    private C12863fI6(AbstractC12520el0 abstractC12520el0, float f, long j, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j2, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j3, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, C19620qf5 c19620qf5, AbstractC18051o02 abstractC18051o02) {
        this(InterfaceC25129zm7.a.a(abstractC12520el0, f), j, c4593Fu2, c3418Au2, c3657Bu2, abstractC9998au2, str, j2, c18413od0, c3590Bm7, ih3, j3, c24525yl7, c5566Jw6, c19620qf5, abstractC18051o02, (ED1) null);
    }
}
