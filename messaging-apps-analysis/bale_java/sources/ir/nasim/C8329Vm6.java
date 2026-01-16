package ir.nasim;

import ir.nasim.C19701qn6;

/* renamed from: ir.nasim.Vm6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8329Vm6 {
    public static final int g = C13774gn7.g;
    private final long a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final C13774gn7 f;

    public C8329Vm6(long j, int i, int i2, int i3, int i4, C13774gn7 c13774gn7) {
        this.a = j;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = c13774gn7;
    }

    private final AW5 b() {
        return AbstractC4300En6.b(this.f, this.d);
    }

    private final AW5 j() {
        return AbstractC4300En6.b(this.f, this.c);
    }

    public final C19701qn6.a a(int i) {
        return new C19701qn6.a(AbstractC4300En6.b(this.f, i), i, this.a);
    }

    public final String c() {
        return this.f.l().j().k();
    }

    public final EnumC5309Iu1 d() {
        int i = this.c;
        int i2 = this.d;
        return i < i2 ? EnumC5309Iu1.b : i > i2 ? EnumC5309Iu1.a : EnumC5309Iu1.c;
    }

    public final int e() {
        return this.d;
    }

    public final int f() {
        return this.e;
    }

    public final int g() {
        return this.c;
    }

    public final long h() {
        return this.a;
    }

    public final int i() {
        return this.b;
    }

    public final C13774gn7 k() {
        return this.f;
    }

    public final int l() {
        return c().length();
    }

    public final boolean m(C8329Vm6 c8329Vm6) {
        return (this.a == c8329Vm6.a && this.c == c8329Vm6.c && this.d == c8329Vm6.d) ? false : true;
    }

    public String toString() {
        return "SelectionInfo(id=" + this.a + ", range=(" + this.c + '-' + j() + ',' + this.d + '-' + b() + "), prevOffset=" + this.e + ')';
    }
}
