package ir.nasim;

import okhttp3.internal.http2.Http2Connection;

/* renamed from: ir.nasim.Zn7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9348Zn7 {
    public static final a d = new a(null);
    private static final C9348Zn7 e = new C9348Zn7(0, 0, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, 0, 0, 0, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16777215, (ED1) null);
    private final C12863fI6 a;
    private final C15396jW4 b;
    private final C23283wf5 c;

    /* renamed from: ir.nasim.Zn7$a */
    public static final class a {
        private a() {
        }

        public final C9348Zn7 a() {
            return C9348Zn7.e;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C9348Zn7(long j, long j2, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j3, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j4, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, AbstractC18051o02 abstractC18051o02, int i, int i2, long j5, C5477Jm7 c5477Jm7, C23283wf5 c23283wf5, C4888Gz3 c4888Gz3, int i3, int i4, C22179un7 c22179un7, ED1 ed1) {
        this(j, j2, c4593Fu2, c3418Au2, c3657Bu2, abstractC9998au2, str, j3, c18413od0, c3590Bm7, ih3, j4, c24525yl7, c5566Jw6, abstractC18051o02, i, i2, j5, c5477Jm7, c23283wf5, c4888Gz3, i3, i4, c22179un7);
    }

    public final C24525yl7 A() {
        return this.a.s();
    }

    public final int B() {
        return this.b.i();
    }

    public final C3590Bm7 C() {
        return this.a.u();
    }

    public final C5477Jm7 D() {
        return this.b.j();
    }

    public final C22179un7 E() {
        return this.b.k();
    }

    public final boolean F(C9348Zn7 c9348Zn7) {
        return this == c9348Zn7 || this.a.w(c9348Zn7.a);
    }

    public final boolean G(C9348Zn7 c9348Zn7) {
        return this == c9348Zn7 || (AbstractC13042fc3.d(this.b, c9348Zn7.b) && this.a.v(c9348Zn7.a));
    }

    public final int H() {
        int iX = ((this.a.x() * 31) + this.b.hashCode()) * 31;
        C23283wf5 c23283wf5 = this.c;
        return iX + (c23283wf5 != null ? c23283wf5.hashCode() : 0);
    }

    public final C9348Zn7 I(C15396jW4 c15396jW4) {
        return new C9348Zn7(N(), M().l(c15396jW4));
    }

    public final C9348Zn7 J(C9348Zn7 c9348Zn7) {
        return (c9348Zn7 == null || AbstractC13042fc3.d(c9348Zn7, e)) ? this : new C9348Zn7(N().y(c9348Zn7.N()), M().l(c9348Zn7.M()));
    }

    public final C9348Zn7 K(long j, long j2, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j3, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j4, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, AbstractC18051o02 abstractC18051o02, int i, int i2, long j5, C5477Jm7 c5477Jm7, C4888Gz3 c4888Gz3, int i3, int i4, C23283wf5 c23283wf5, C22179un7 c22179un7) {
        C12863fI6 c12863fI6B = AbstractC13481gI6.b(this.a, j, null, Float.NaN, j2, c4593Fu2, c3418Au2, c3657Bu2, abstractC9998au2, str, j3, c18413od0, c3590Bm7, ih3, j4, c24525yl7, c5566Jw6, c23283wf5 != null ? c23283wf5.b() : null, abstractC18051o02);
        C15396jW4 c15396jW4A = AbstractC15987kW4.a(this.b, i, i2, j5, c5477Jm7, c23283wf5 != null ? c23283wf5.a() : null, c4888Gz3, i3, i4, c22179un7);
        return (this.a == c12863fI6B && this.b == c15396jW4A) ? this : new C9348Zn7(c12863fI6B, c15396jW4A);
    }

    public final C15396jW4 M() {
        return this.b;
    }

    public final C12863fI6 N() {
        return this.a;
    }

    public final C9348Zn7 b(long j, long j2, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j3, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j4, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, AbstractC18051o02 abstractC18051o02, int i, int i2, long j5, C5477Jm7 c5477Jm7, C23283wf5 c23283wf5, C4888Gz3 c4888Gz3, int i3, int i4, C22179un7 c22179un7) {
        return new C9348Zn7(new C12863fI6(C24381yX0.q(j, this.a.g()) ? this.a.t() : InterfaceC25129zm7.a.b(j), j2, c4593Fu2, c3418Au2, c3657Bu2, abstractC9998au2, str, j3, c18413od0, c3590Bm7, ih3, j4, c24525yl7, c5566Jw6, c23283wf5 != null ? c23283wf5.b() : null, abstractC18051o02, (ED1) null), new C15396jW4(i, i2, j5, c5477Jm7, c23283wf5 != null ? c23283wf5.a() : null, c4888Gz3, i3, i4, c22179un7, null), c23283wf5);
    }

    public final float d() {
        return this.a.c();
    }

    public final long e() {
        return this.a.d();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9348Zn7)) {
            return false;
        }
        C9348Zn7 c9348Zn7 = (C9348Zn7) obj;
        return AbstractC13042fc3.d(this.a, c9348Zn7.a) && AbstractC13042fc3.d(this.b, c9348Zn7.b) && AbstractC13042fc3.d(this.c, c9348Zn7.c);
    }

    public final C18413od0 f() {
        return this.a.e();
    }

    public final AbstractC12520el0 g() {
        return this.a.f();
    }

    public final long h() {
        return this.a.g();
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        C23283wf5 c23283wf5 = this.c;
        return iHashCode + (c23283wf5 != null ? c23283wf5.hashCode() : 0);
    }

    public final AbstractC18051o02 i() {
        return this.a.h();
    }

    public final AbstractC9998au2 j() {
        return this.a.i();
    }

    public final String k() {
        return this.a.j();
    }

    public final long l() {
        return this.a.k();
    }

    public final C3418Au2 m() {
        return this.a.l();
    }

    public final C3657Bu2 n() {
        return this.a.m();
    }

    public final C4593Fu2 o() {
        return this.a.n();
    }

    public final int p() {
        return this.b.c();
    }

    public final long q() {
        return this.a.o();
    }

    public final int r() {
        return this.b.d();
    }

    public final long s() {
        return this.b.e();
    }

    public final C4888Gz3 t() {
        return this.b.f();
    }

    public String toString() {
        return "TextStyle(color=" + ((Object) C24381yX0.x(h())) + ", brush=" + g() + ", alpha=" + d() + ", fontSize=" + ((Object) C13193fo7.j(l())) + ", fontWeight=" + o() + ", fontStyle=" + m() + ", fontSynthesis=" + n() + ", fontFamily=" + j() + ", fontFeatureSettings=" + k() + ", letterSpacing=" + ((Object) C13193fo7.j(q())) + ", baselineShift=" + f() + ", textGeometricTransform=" + C() + ", localeList=" + u() + ", background=" + ((Object) C24381yX0.x(e())) + ", textDecoration=" + A() + ", shadow=" + x() + ", drawStyle=" + i() + ", textAlign=" + ((Object) C6399Nk7.m(z())) + ", textDirection=" + ((Object) C4049Dl7.l(B())) + ", lineHeight=" + ((Object) C13193fo7.j(s())) + ", textIndent=" + D() + ", platformStyle=" + this.c + ", lineHeightStyle=" + t() + ", lineBreak=" + ((Object) C4171Dz3.k(r())) + ", hyphens=" + ((Object) C23811xZ2.i(p())) + ", textMotion=" + E() + ')';
    }

    public final IH3 u() {
        return this.a.p();
    }

    public final C15396jW4 v() {
        return this.b;
    }

    public final C23283wf5 w() {
        return this.c;
    }

    public final C5566Jw6 x() {
        return this.a.r();
    }

    public final C12863fI6 y() {
        return this.a;
    }

    public final int z() {
        return this.b.h();
    }

    public /* synthetic */ C9348Zn7(AbstractC12520el0 abstractC12520el0, float f, long j, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j2, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j3, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, AbstractC18051o02 abstractC18051o02, int i, int i2, long j4, C5477Jm7 c5477Jm7, C23283wf5 c23283wf5, C4888Gz3 c4888Gz3, int i3, int i4, C22179un7 c22179un7, ED1 ed1) {
        this(abstractC12520el0, f, j, c4593Fu2, c3418Au2, c3657Bu2, abstractC9998au2, str, j2, c18413od0, c3590Bm7, ih3, j3, c24525yl7, c5566Jw6, abstractC18051o02, i, i2, j4, c5477Jm7, c23283wf5, c4888Gz3, i3, i4, c22179un7);
    }

    public C9348Zn7(C12863fI6 c12863fI6, C15396jW4 c15396jW4, C23283wf5 c23283wf5) {
        this.a = c12863fI6;
        this.b = c15396jW4;
        this.c = c23283wf5;
    }

    public C9348Zn7(C12863fI6 c12863fI6, C15396jW4 c15396jW4) {
        this(c12863fI6, c15396jW4, AbstractC10560bo7.b(c12863fI6.q(), c15396jW4.g()));
    }

    public /* synthetic */ C9348Zn7(long j, long j2, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j3, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j4, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, AbstractC18051o02 abstractC18051o02, int i, int i2, long j5, C5477Jm7 c5477Jm7, C23283wf5 c23283wf5, C4888Gz3 c4888Gz3, int i3, int i4, C22179un7 c22179un7, int i5, ED1 ed1) {
        this((i5 & 1) != 0 ? C24381yX0.b.i() : j, (i5 & 2) != 0 ? C13193fo7.b.a() : j2, (i5 & 4) != 0 ? null : c4593Fu2, (i5 & 8) != 0 ? null : c3418Au2, (i5 & 16) != 0 ? null : c3657Bu2, (i5 & 32) != 0 ? null : abstractC9998au2, (i5 & 64) != 0 ? null : str, (i5 & 128) != 0 ? C13193fo7.b.a() : j3, (i5 & 256) != 0 ? null : c18413od0, (i5 & 512) != 0 ? null : c3590Bm7, (i5 & 1024) != 0 ? null : ih3, (i5 & 2048) != 0 ? C24381yX0.b.i() : j4, (i5 & 4096) != 0 ? null : c24525yl7, (i5 & 8192) != 0 ? null : c5566Jw6, (i5 & 16384) != 0 ? null : abstractC18051o02, (i5 & 32768) != 0 ? C6399Nk7.b.g() : i, (i5 & 65536) != 0 ? C4049Dl7.b.f() : i2, (i5 & 131072) != 0 ? C13193fo7.b.a() : j5, (i5 & 262144) != 0 ? null : c5477Jm7, (i5 & 524288) != 0 ? null : c23283wf5, (i5 & 1048576) != 0 ? null : c4888Gz3, (i5 & 2097152) != 0 ? C4171Dz3.b.b() : i3, (i5 & 4194304) != 0 ? C23811xZ2.b.c() : i4, (i5 & 8388608) != 0 ? null : c22179un7, (ED1) null);
    }

    private C9348Zn7(long j, long j2, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j3, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j4, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, AbstractC18051o02 abstractC18051o02, int i, int i2, long j5, C5477Jm7 c5477Jm7, C23283wf5 c23283wf5, C4888Gz3 c4888Gz3, int i3, int i4, C22179un7 c22179un7) {
        this(new C12863fI6(j, j2, c4593Fu2, c3418Au2, c3657Bu2, abstractC9998au2, str, j3, c18413od0, c3590Bm7, ih3, j4, c24525yl7, c5566Jw6, c23283wf5 != null ? c23283wf5.b() : null, abstractC18051o02, (ED1) null), new C15396jW4(i, i2, j5, c5477Jm7, c23283wf5 != null ? c23283wf5.a() : null, c4888Gz3, i3, i4, c22179un7, null), c23283wf5);
    }

    public /* synthetic */ C9348Zn7(AbstractC12520el0 abstractC12520el0, float f, long j, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j2, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j3, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, AbstractC18051o02 abstractC18051o02, int i, int i2, long j4, C5477Jm7 c5477Jm7, C23283wf5 c23283wf5, C4888Gz3 c4888Gz3, int i3, int i4, C22179un7 c22179un7, int i5, ED1 ed1) {
        this(abstractC12520el0, (i5 & 2) != 0 ? Float.NaN : f, (i5 & 4) != 0 ? C13193fo7.b.a() : j, (i5 & 8) != 0 ? null : c4593Fu2, (i5 & 16) != 0 ? null : c3418Au2, (i5 & 32) != 0 ? null : c3657Bu2, (i5 & 64) != 0 ? null : abstractC9998au2, (i5 & 128) != 0 ? null : str, (i5 & 256) != 0 ? C13193fo7.b.a() : j2, (i5 & 512) != 0 ? null : c18413od0, (i5 & 1024) != 0 ? null : c3590Bm7, (i5 & 2048) != 0 ? null : ih3, (i5 & 4096) != 0 ? C24381yX0.b.i() : j3, (i5 & 8192) != 0 ? null : c24525yl7, (i5 & 16384) != 0 ? null : c5566Jw6, (32768 & i5) != 0 ? null : abstractC18051o02, (65536 & i5) != 0 ? C6399Nk7.b.g() : i, (131072 & i5) != 0 ? C4049Dl7.b.f() : i2, (262144 & i5) != 0 ? C13193fo7.b.a() : j4, (524288 & i5) != 0 ? null : c5477Jm7, (1048576 & i5) != 0 ? null : c23283wf5, (2097152 & i5) != 0 ? null : c4888Gz3, (4194304 & i5) != 0 ? C4171Dz3.b.b() : i3, (8388608 & i5) != 0 ? C23811xZ2.b.c() : i4, (i5 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? null : c22179un7, (ED1) null);
    }

    private C9348Zn7(AbstractC12520el0 abstractC12520el0, float f, long j, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j2, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j3, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, AbstractC18051o02 abstractC18051o02, int i, int i2, long j4, C5477Jm7 c5477Jm7, C23283wf5 c23283wf5, C4888Gz3 c4888Gz3, int i3, int i4, C22179un7 c22179un7) {
        this(new C12863fI6(abstractC12520el0, f, j, c4593Fu2, c3418Au2, c3657Bu2, abstractC9998au2, str, j2, c18413od0, c3590Bm7, ih3, j3, c24525yl7, c5566Jw6, c23283wf5 != null ? c23283wf5.b() : null, abstractC18051o02, (ED1) null), new C15396jW4(i, i2, j4, c5477Jm7, c23283wf5 != null ? c23283wf5.a() : null, c4888Gz3, i3, i4, c22179un7, null), c23283wf5);
    }
}
