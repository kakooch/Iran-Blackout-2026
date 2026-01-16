package ir.nasim;

/* renamed from: ir.nasim.za3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C25005za3 {
    public static final a e = new a(null);
    private static final C25005za3 f = new C25005za3(0, 0, 0, 0);
    private final int a;
    private final int b;
    private final int c;
    private final int d;

    /* renamed from: ir.nasim.za3$a */
    public static final class a {
        private a() {
        }

        public final C25005za3 a() {
            return C25005za3.f;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C25005za3(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static /* synthetic */ C25005za3 c(C25005za3 c25005za3, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = c25005za3.a;
        }
        if ((i5 & 2) != 0) {
            i2 = c25005za3.b;
        }
        if ((i5 & 4) != 0) {
            i3 = c25005za3.c;
        }
        if ((i5 & 8) != 0) {
            i4 = c25005za3.d;
        }
        return c25005za3.b(i, i2, i3, i4);
    }

    public final C25005za3 b(int i, int i2, int i3, int i4) {
        return new C25005za3(i, i2, i3, i4);
    }

    public final int d() {
        return this.d;
    }

    public final long e() {
        return C22045ua3.f(((this.b + (f() / 2)) & 4294967295L) | ((this.a + (l() / 2)) << 32));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C25005za3)) {
            return false;
        }
        C25005za3 c25005za3 = (C25005za3) obj;
        return this.a == c25005za3.a && this.b == c25005za3.b && this.c == c25005za3.c && this.d == c25005za3.d;
    }

    public final int f() {
        return this.d - this.b;
    }

    public final int g() {
        return this.a;
    }

    public final int h() {
        return this.c;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
    }

    public final long i() {
        return C4414Fa3.c((f() & 4294967295L) | (l() << 32));
    }

    public final int j() {
        return this.b;
    }

    public final long k() {
        return C22045ua3.f((this.b & 4294967295L) | (this.a << 32));
    }

    public final int l() {
        return this.c - this.a;
    }

    public final boolean m() {
        return this.a >= this.c || this.b >= this.d;
    }

    public final C25005za3 n(int i, int i2) {
        return new C25005za3(this.a + i, this.b + i2, this.c + i, this.d + i2);
    }

    public String toString() {
        return "IntRect.fromLTRB(" + this.a + ", " + this.b + ", " + this.c + ", " + this.d + ')';
    }
}
