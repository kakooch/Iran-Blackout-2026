package ir.nasim;

/* renamed from: ir.nasim.Wm4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C8561Wm4 {
    private long a;
    private long b;
    private C4593Fu2 c;
    private C3418Au2 d;
    private C3657Bu2 e;
    private AbstractC9998au2 f;
    private String g;
    private long h;
    private C18413od0 i;
    private C3590Bm7 j;
    private IH3 k;
    private long l;
    private C24525yl7 m;
    private C5566Jw6 n;

    public /* synthetic */ C8561Wm4(long j, long j2, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j3, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j4, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, ED1 ed1) {
        this(j, j2, c4593Fu2, c3418Au2, c3657Bu2, abstractC9998au2, str, j3, c18413od0, c3590Bm7, ih3, j4, c24525yl7, c5566Jw6);
    }

    public final void a(long j) {
        this.l = j;
    }

    public final void b(C18413od0 c18413od0) {
        this.i = c18413od0;
    }

    public final void c(long j) {
        this.a = j;
    }

    public final void d(String str) {
        this.g = str;
    }

    public final void e(long j) {
        this.b = j;
    }

    public final void f(C3418Au2 c3418Au2) {
        this.d = c3418Au2;
    }

    public final void g(C3657Bu2 c3657Bu2) {
        this.e = c3657Bu2;
    }

    public final void h(C4593Fu2 c4593Fu2) {
        this.c = c4593Fu2;
    }

    public final void i(long j) {
        this.h = j;
    }

    public final void j(C5566Jw6 c5566Jw6) {
        this.n = c5566Jw6;
    }

    public final void k(C24525yl7 c24525yl7) {
        this.m = c24525yl7;
    }

    public final void l(C3590Bm7 c3590Bm7) {
        this.j = c3590Bm7;
    }

    public final C12863fI6 m() {
        return new C12863fI6(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, (C19620qf5) null, (AbstractC18051o02) null, 49152, (ED1) null);
    }

    private C8561Wm4(long j, long j2, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j3, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j4, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6) {
        this.a = j;
        this.b = j2;
        this.c = c4593Fu2;
        this.d = c3418Au2;
        this.e = c3657Bu2;
        this.f = abstractC9998au2;
        this.g = str;
        this.h = j3;
        this.i = c18413od0;
        this.j = c3590Bm7;
        this.k = ih3;
        this.l = j4;
        this.m = c24525yl7;
        this.n = c5566Jw6;
    }

    public /* synthetic */ C8561Wm4(long j, long j2, C4593Fu2 c4593Fu2, C3418Au2 c3418Au2, C3657Bu2 c3657Bu2, AbstractC9998au2 abstractC9998au2, String str, long j3, C18413od0 c18413od0, C3590Bm7 c3590Bm7, IH3 ih3, long j4, C24525yl7 c24525yl7, C5566Jw6 c5566Jw6, int i, ED1 ed1) {
        this((i & 1) != 0 ? C24381yX0.b.i() : j, (i & 2) != 0 ? C13193fo7.b.a() : j2, (i & 4) != 0 ? null : c4593Fu2, (i & 8) != 0 ? null : c3418Au2, (i & 16) != 0 ? null : c3657Bu2, (i & 32) != 0 ? null : abstractC9998au2, (i & 64) != 0 ? null : str, (i & 128) != 0 ? C13193fo7.b.a() : j3, (i & 256) != 0 ? null : c18413od0, (i & 512) != 0 ? null : c3590Bm7, (i & 1024) != 0 ? null : ih3, (i & 2048) != 0 ? C24381yX0.b.i() : j4, (i & 4096) != 0 ? null : c24525yl7, (i & 8192) != 0 ? null : c5566Jw6, null);
    }
}
