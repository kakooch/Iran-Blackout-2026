package ir.nasim;

/* renamed from: ir.nasim.Ka3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C5599Ka3 {
    static final C5599Ka3 f = new C5599Ka3();
    private final long a;
    private final Object b;
    private final C5599Ka3 c;
    private final C5599Ka3 d;
    private final int e;

    private C5599Ka3() {
        this.e = 0;
        this.a = 0L;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    private static C5599Ka3 c(long j, Object obj, C5599Ka3 c5599Ka3, C5599Ka3 c5599Ka32) {
        int i = c5599Ka3.e;
        int i2 = c5599Ka32.e;
        if (i + i2 > 1) {
            if (i >= i2 * 5) {
                C5599Ka3 c5599Ka33 = c5599Ka3.c;
                C5599Ka3 c5599Ka34 = c5599Ka3.d;
                if (c5599Ka34.e < c5599Ka33.e * 2) {
                    long j2 = c5599Ka3.a;
                    return new C5599Ka3(j2 + j, c5599Ka3.b, c5599Ka33, new C5599Ka3(-j2, obj, c5599Ka34.e(c5599Ka34.a + j2), c5599Ka32));
                }
                C5599Ka3 c5599Ka35 = c5599Ka34.c;
                C5599Ka3 c5599Ka36 = c5599Ka34.d;
                long j3 = c5599Ka34.a;
                long j4 = c5599Ka3.a + j3 + j;
                Object obj2 = c5599Ka34.b;
                C5599Ka3 c5599Ka37 = new C5599Ka3(-j3, c5599Ka3.b, c5599Ka33, c5599Ka35.e(c5599Ka35.a + j3));
                long j5 = c5599Ka3.a;
                long j6 = c5599Ka34.a;
                return new C5599Ka3(j4, obj2, c5599Ka37, new C5599Ka3((-j5) - j6, obj, c5599Ka36.e(c5599Ka36.a + j6 + j5), c5599Ka32));
            }
            if (i2 >= i * 5) {
                C5599Ka3 c5599Ka38 = c5599Ka32.c;
                C5599Ka3 c5599Ka39 = c5599Ka32.d;
                if (c5599Ka38.e < c5599Ka39.e * 2) {
                    long j7 = c5599Ka32.a;
                    return new C5599Ka3(j7 + j, c5599Ka32.b, new C5599Ka3(-j7, obj, c5599Ka3, c5599Ka38.e(c5599Ka38.a + j7)), c5599Ka39);
                }
                C5599Ka3 c5599Ka310 = c5599Ka38.c;
                C5599Ka3 c5599Ka311 = c5599Ka38.d;
                long j8 = c5599Ka38.a;
                long j9 = c5599Ka32.a;
                long j10 = j8 + j9 + j;
                Object obj3 = c5599Ka38.b;
                C5599Ka3 c5599Ka312 = new C5599Ka3((-j9) - j8, obj, c5599Ka3, c5599Ka310.e(c5599Ka310.a + j8 + j9));
                long j11 = c5599Ka38.a;
                return new C5599Ka3(j10, obj3, c5599Ka312, new C5599Ka3(-j11, c5599Ka32.b, c5599Ka311.e(c5599Ka311.a + j11), c5599Ka39));
            }
        }
        return new C5599Ka3(j, obj, c5599Ka3, c5599Ka32);
    }

    private C5599Ka3 d(C5599Ka3 c5599Ka3, C5599Ka3 c5599Ka32) {
        return (c5599Ka3 == this.c && c5599Ka32 == this.d) ? this : c(this.a, this.b, c5599Ka3, c5599Ka32);
    }

    private C5599Ka3 e(long j) {
        return (this.e == 0 || j == this.a) ? this : new C5599Ka3(j, this.b, this.c, this.d);
    }

    Object a(long j) {
        if (this.e == 0) {
            return null;
        }
        long j2 = this.a;
        return j < j2 ? this.c.a(j - j2) : j > j2 ? this.d.a(j - j2) : this.b;
    }

    C5599Ka3 b(long j, Object obj) {
        if (this.e == 0) {
            return new C5599Ka3(j, obj, this, this);
        }
        long j2 = this.a;
        return j < j2 ? d(this.c.b(j - j2, obj), this.d) : j > j2 ? d(this.c, this.d.b(j - j2, obj)) : obj == this.b ? this : new C5599Ka3(j, obj, this.c, this.d);
    }

    private C5599Ka3(long j, Object obj, C5599Ka3 c5599Ka3, C5599Ka3 c5599Ka32) {
        this.a = j;
        this.b = obj;
        this.c = c5599Ka3;
        this.d = c5599Ka32;
        this.e = c5599Ka3.e + 1 + c5599Ka32.e;
    }
}
