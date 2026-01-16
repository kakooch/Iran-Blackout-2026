package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.gn7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13774gn7 {
    public static final int g = 8;
    private final C13183fn7 a;
    private final C24522yl4 b;
    private final long c;
    private final float d;
    private final float e;
    private final List f;

    public /* synthetic */ C13774gn7(C13183fn7 c13183fn7, C24522yl4 c24522yl4, long j, ED1 ed1) {
        this(c13183fn7, c24522yl4, j);
    }

    public static /* synthetic */ C13774gn7 b(C13774gn7 c13774gn7, C13183fn7 c13183fn7, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            c13183fn7 = c13774gn7.a;
        }
        if ((i & 2) != 0) {
            j = c13774gn7.c;
        }
        return c13774gn7.a(c13183fn7, j);
    }

    public static /* synthetic */ int p(C13774gn7 c13774gn7, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return c13774gn7.o(i, z);
    }

    public final List A() {
        return this.f;
    }

    public final long B() {
        return this.c;
    }

    public final long C(int i) {
        return this.b.E(i);
    }

    public final boolean D(int i) {
        return this.b.F(i);
    }

    public final C13774gn7 a(C13183fn7 c13183fn7, long j) {
        return new C13774gn7(c13183fn7, this.b, j, null);
    }

    public final AW5 c(int i) {
        return this.b.c(i);
    }

    public final CK5 d(int i) {
        return this.b.d(i);
    }

    public final CK5 e(int i) {
        return this.b.e(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13774gn7)) {
            return false;
        }
        C13774gn7 c13774gn7 = (C13774gn7) obj;
        return AbstractC13042fc3.d(this.a, c13774gn7.a) && AbstractC13042fc3.d(this.b, c13774gn7.b) && C4414Fa3.e(this.c, c13774gn7.c) && this.d == c13774gn7.d && this.e == c13774gn7.e && AbstractC13042fc3.d(this.f, c13774gn7.f);
    }

    public final boolean f() {
        return this.b.f() || ((float) ((int) (this.c & 4294967295L))) < this.b.h();
    }

    public final boolean g() {
        return ((float) ((int) (this.c >> 32))) < this.b.D();
    }

    public final float h() {
        return this.d;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + C4414Fa3.h(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + this.f.hashCode();
    }

    public final boolean i() {
        return g() || f();
    }

    public final float j(int i, boolean z) {
        return this.b.i(i, z);
    }

    public final float k() {
        return this.e;
    }

    public final C13183fn7 l() {
        return this.a;
    }

    public final float m(int i) {
        return this.b.l(i);
    }

    public final int n() {
        return this.b.m();
    }

    public final int o(int i, boolean z) {
        return this.b.n(i, z);
    }

    public final int q(int i) {
        return this.b.p(i);
    }

    public final int r(float f) {
        return this.b.q(f);
    }

    public final float s(int i) {
        return this.b.s(i);
    }

    public final float t(int i) {
        return this.b.t(i);
    }

    public String toString() {
        return "TextLayoutResult(layoutInput=" + this.a + ", multiParagraph=" + this.b + ", size=" + ((Object) C4414Fa3.i(this.c)) + ", firstBaseline=" + this.d + ", lastBaseline=" + this.e + ", placeholderRects=" + this.f + ')';
    }

    public final int u(int i) {
        return this.b.u(i);
    }

    public final float v(int i) {
        return this.b.v(i);
    }

    public final C24522yl4 w() {
        return this.b;
    }

    public final int x(long j) {
        return this.b.x(j);
    }

    public final AW5 y(int i) {
        return this.b.y(i);
    }

    public final V05 z(int i, int i2) {
        return this.b.A(i, i2);
    }

    private C13774gn7(C13183fn7 c13183fn7, C24522yl4 c24522yl4, long j) {
        this.a = c13183fn7;
        this.b = c24522yl4;
        this.c = j;
        this.d = c24522yl4.g();
        this.e = c24522yl4.k();
        this.f = c24522yl4.B();
    }
}
