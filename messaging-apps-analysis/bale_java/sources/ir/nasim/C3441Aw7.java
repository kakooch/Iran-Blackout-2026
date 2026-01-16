package ir.nasim;

import android.text.Layout;

/* renamed from: ir.nasim.Aw7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C3441Aw7 {
    private String a;
    private int b;
    private boolean c;
    private int d;
    private boolean e;
    private float k;
    private String l;
    private Layout.Alignment o;
    private Layout.Alignment p;
    private C5936Ll7 r;
    private int f = -1;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private int m = -1;
    private int n = -1;
    private int q = -1;
    private float s = Float.MAX_VALUE;

    private C3441Aw7 r(C3441Aw7 c3441Aw7, boolean z) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (c3441Aw7 != null) {
            if (!this.c && c3441Aw7.c) {
                w(c3441Aw7.b);
            }
            if (this.h == -1) {
                this.h = c3441Aw7.h;
            }
            if (this.i == -1) {
                this.i = c3441Aw7.i;
            }
            if (this.a == null && (str = c3441Aw7.a) != null) {
                this.a = str;
            }
            if (this.f == -1) {
                this.f = c3441Aw7.f;
            }
            if (this.g == -1) {
                this.g = c3441Aw7.g;
            }
            if (this.n == -1) {
                this.n = c3441Aw7.n;
            }
            if (this.o == null && (alignment2 = c3441Aw7.o) != null) {
                this.o = alignment2;
            }
            if (this.p == null && (alignment = c3441Aw7.p) != null) {
                this.p = alignment;
            }
            if (this.q == -1) {
                this.q = c3441Aw7.q;
            }
            if (this.j == -1) {
                this.j = c3441Aw7.j;
                this.k = c3441Aw7.k;
            }
            if (this.r == null) {
                this.r = c3441Aw7.r;
            }
            if (this.s == Float.MAX_VALUE) {
                this.s = c3441Aw7.s;
            }
            if (z && !this.e && c3441Aw7.e) {
                u(c3441Aw7.d);
            }
            if (z && this.m == -1 && (i = c3441Aw7.m) != -1) {
                this.m = i;
            }
        }
        return this;
    }

    public C3441Aw7 A(String str) {
        this.l = str;
        return this;
    }

    public C3441Aw7 B(boolean z) {
        this.i = z ? 1 : 0;
        return this;
    }

    public C3441Aw7 C(boolean z) {
        this.f = z ? 1 : 0;
        return this;
    }

    public C3441Aw7 D(Layout.Alignment alignment) {
        this.p = alignment;
        return this;
    }

    public C3441Aw7 E(int i) {
        this.n = i;
        return this;
    }

    public C3441Aw7 F(int i) {
        this.m = i;
        return this;
    }

    public C3441Aw7 G(float f) {
        this.s = f;
        return this;
    }

    public C3441Aw7 H(Layout.Alignment alignment) {
        this.o = alignment;
        return this;
    }

    public C3441Aw7 I(boolean z) {
        this.q = z ? 1 : 0;
        return this;
    }

    public C3441Aw7 J(C5936Ll7 c5936Ll7) {
        this.r = c5936Ll7;
        return this;
    }

    public C3441Aw7 K(boolean z) {
        this.g = z ? 1 : 0;
        return this;
    }

    public C3441Aw7 a(C3441Aw7 c3441Aw7) {
        return r(c3441Aw7, true);
    }

    public int b() {
        if (this.e) {
            return this.d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.c) {
            return this.b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public String d() {
        return this.a;
    }

    public float e() {
        return this.k;
    }

    public int f() {
        return this.j;
    }

    public String g() {
        return this.l;
    }

    public Layout.Alignment h() {
        return this.p;
    }

    public int i() {
        return this.n;
    }

    public int j() {
        return this.m;
    }

    public float k() {
        return this.s;
    }

    public int l() {
        int i = this.h;
        if (i == -1 && this.i == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.i == 1 ? 2 : 0);
    }

    public Layout.Alignment m() {
        return this.o;
    }

    public boolean n() {
        return this.q == 1;
    }

    public C5936Ll7 o() {
        return this.r;
    }

    public boolean p() {
        return this.e;
    }

    public boolean q() {
        return this.c;
    }

    public boolean s() {
        return this.f == 1;
    }

    public boolean t() {
        return this.g == 1;
    }

    public C3441Aw7 u(int i) {
        this.d = i;
        this.e = true;
        return this;
    }

    public C3441Aw7 v(boolean z) {
        this.h = z ? 1 : 0;
        return this;
    }

    public C3441Aw7 w(int i) {
        this.b = i;
        this.c = true;
        return this;
    }

    public C3441Aw7 x(String str) {
        this.a = str;
        return this;
    }

    public C3441Aw7 y(float f) {
        this.k = f;
        return this;
    }

    public C3441Aw7 z(int i) {
        this.j = i;
        return this;
    }
}
