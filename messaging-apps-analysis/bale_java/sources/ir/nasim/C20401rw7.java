package ir.nasim;

/* renamed from: ir.nasim.rw7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C20401rw7 {
    private final int a;
    private boolean d;
    private boolean e;
    private boolean f;
    private final C5045Hq7 b = new C5045Hq7(0);
    private long g = -9223372036854775807L;
    private long h = -9223372036854775807L;
    private long i = -9223372036854775807L;
    private final EW4 c = new EW4();

    C20401rw7(int i) {
        this.a = i;
    }

    private int a(InterfaceC9845af2 interfaceC9845af2) {
        this.c.P(AbstractC9683aN7.f);
        this.d = true;
        interfaceC9845af2.e();
        return 0;
    }

    private int f(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5, int i) {
        int iMin = (int) Math.min(this.a, interfaceC9845af2.getLength());
        long j = 0;
        if (interfaceC9845af2.getPosition() != j) {
            c8292Vi5.a = j;
            return 1;
        }
        this.c.O(iMin);
        interfaceC9845af2.e();
        interfaceC9845af2.m(this.c.e(), 0, iMin);
        this.g = g(this.c, i);
        this.e = true;
        return 0;
    }

    private long g(EW4 ew4, int i) {
        int iG = ew4.g();
        for (int iF = ew4.f(); iF < iG; iF++) {
            if (ew4.e()[iF] == 71) {
                long jC = AbstractC22864vw7.c(ew4, iF, i);
                if (jC != -9223372036854775807L) {
                    return jC;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int h(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5, int i) {
        long length = interfaceC9845af2.getLength();
        int iMin = (int) Math.min(this.a, length);
        long j = length - iMin;
        if (interfaceC9845af2.getPosition() != j) {
            c8292Vi5.a = j;
            return 1;
        }
        this.c.O(iMin);
        interfaceC9845af2.e();
        interfaceC9845af2.m(this.c.e(), 0, iMin);
        this.h = i(this.c, i);
        this.f = true;
        return 0;
    }

    private long i(EW4 ew4, int i) {
        int iF = ew4.f();
        int iG = ew4.g();
        for (int i2 = iG - 188; i2 >= iF; i2--) {
            if (AbstractC22864vw7.b(ew4.e(), iF, iG, i2)) {
                long jC = AbstractC22864vw7.c(ew4, i2, i);
                if (jC != -9223372036854775807L) {
                    return jC;
                }
            }
        }
        return -9223372036854775807L;
    }

    public long b() {
        return this.i;
    }

    public C5045Hq7 c() {
        return this.b;
    }

    public boolean d() {
        return this.d;
    }

    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5, int i) {
        if (i <= 0) {
            return a(interfaceC9845af2);
        }
        if (!this.f) {
            return h(interfaceC9845af2, c8292Vi5, i);
        }
        if (this.h == -9223372036854775807L) {
            return a(interfaceC9845af2);
        }
        if (!this.e) {
            return f(interfaceC9845af2, c8292Vi5, i);
        }
        long j = this.g;
        if (j == -9223372036854775807L) {
            return a(interfaceC9845af2);
        }
        long jB = this.b.b(this.h) - this.b.b(j);
        this.i = jB;
        if (jB < 0) {
            AbstractC18815pI3.k("TsDurationReader", "Invalid duration: " + this.i + ". Using TIME_UNSET instead.");
            this.i = -9223372036854775807L;
        }
        return a(interfaceC9845af2);
    }
}
