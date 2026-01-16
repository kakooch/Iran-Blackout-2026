package ir.nasim;

/* loaded from: classes2.dex */
public final class M42 {
    public static final a f = new a(null);
    public static final int g = 8;
    private final QW4 a;
    private int b;
    private int c;
    private int d;
    private int e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ M42(C13245fu c13245fu, long j, ED1 ed1) {
        this(c13245fu, j);
    }

    private final void q(int i) {
        if (!(i >= 0)) {
            N73.a("Cannot set selectionEnd to a negative value: " + i);
        }
        this.c = i;
    }

    private final void r(int i) {
        if (!(i >= 0)) {
            N73.a("Cannot set selectionStart to a negative value: " + i);
        }
        this.b = i;
    }

    public final void a() {
        this.d = -1;
        this.e = -1;
    }

    public final void b(int i, int i2) {
        long jB = AbstractC4535Fn7.b(i, i2);
        this.a.c(i, i2, "");
        long jA = N42.a(AbstractC4535Fn7.b(this.b, this.c), jB);
        r(C4301En7.l(jA));
        q(C4301En7.k(jA));
        if (l()) {
            long jA2 = N42.a(AbstractC4535Fn7.b(this.d, this.e), jB);
            if (C4301En7.h(jA2)) {
                a();
            } else {
                this.d = C4301En7.l(jA2);
                this.e = C4301En7.k(jA2);
            }
        }
    }

    public final char c(int i) {
        return this.a.a(i);
    }

    public final C4301En7 d() {
        if (l()) {
            return C4301En7.b(AbstractC4535Fn7.b(this.d, this.e));
        }
        return null;
    }

    public final int e() {
        return this.e;
    }

    public final int f() {
        return this.d;
    }

    public final int g() {
        int i = this.b;
        int i2 = this.c;
        if (i == i2) {
            return i2;
        }
        return -1;
    }

    public final int h() {
        return this.a.b();
    }

    public final long i() {
        return AbstractC4535Fn7.b(this.b, this.c);
    }

    public final int j() {
        return this.c;
    }

    public final int k() {
        return this.b;
    }

    public final boolean l() {
        return this.d != -1;
    }

    public final void m(int i, int i2, String str) {
        if (i < 0 || i > this.a.b()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.a.b());
        }
        if (i2 < 0 || i2 > this.a.b()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.a.b());
        }
        if (i <= i2) {
            this.a.c(i, i2, str);
            r(str.length() + i);
            q(i + str.length());
            this.d = -1;
            this.e = -1;
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + i + " > " + i2);
    }

    public final void n(int i, int i2) {
        if (i < 0 || i > this.a.b()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.a.b());
        }
        if (i2 < 0 || i2 > this.a.b()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.a.b());
        }
        if (i < i2) {
            this.d = i;
            this.e = i2;
            return;
        }
        throw new IllegalArgumentException("Do not set reversed or empty range: " + i + " > " + i2);
    }

    public final void o(int i) {
        p(i, i);
    }

    public final void p(int i, int i2) {
        if (i < 0 || i > this.a.b()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.a.b());
        }
        if (i2 < 0 || i2 > this.a.b()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.a.b());
        }
        if (i <= i2) {
            r(i);
            q(i2);
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + i + " > " + i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final C13245fu s() {
        return new C13245fu(toString(), null, 2, 0 == true ? 1 : 0);
    }

    public String toString() {
        return this.a.toString();
    }

    private M42(C13245fu c13245fu, long j) {
        this.a = new QW4(c13245fu.k());
        this.b = C4301En7.l(j);
        this.c = C4301En7.k(j);
        this.d = -1;
        this.e = -1;
        int iL = C4301En7.l(j);
        int iK = C4301En7.k(j);
        if (iL < 0 || iL > c13245fu.length()) {
            throw new IndexOutOfBoundsException("start (" + iL + ") offset is outside of text region " + c13245fu.length());
        }
        if (iK < 0 || iK > c13245fu.length()) {
            throw new IndexOutOfBoundsException("end (" + iK + ") offset is outside of text region " + c13245fu.length());
        }
        if (iL <= iK) {
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + iL + " > " + iK);
    }
}
