package ir.nasim;

/* renamed from: ir.nasim.fy5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C13289fy5 {
    private boolean c;
    private boolean d;
    private boolean e;
    private final C5045Hq7 a = new C5045Hq7(0);
    private long f = -9223372036854775807L;
    private long g = -9223372036854775807L;
    private long h = -9223372036854775807L;
    private final EW4 b = new EW4();

    C13289fy5() {
    }

    private static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    private int b(InterfaceC9845af2 interfaceC9845af2) {
        this.b.P(AbstractC9683aN7.f);
        this.c = true;
        interfaceC9845af2.e();
        return 0;
    }

    private int f(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    private int h(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        int iMin = (int) Math.min(20000L, interfaceC9845af2.getLength());
        long j = 0;
        if (interfaceC9845af2.getPosition() != j) {
            c8292Vi5.a = j;
            return 1;
        }
        this.b.O(iMin);
        interfaceC9845af2.e();
        interfaceC9845af2.m(this.b.e(), 0, iMin);
        this.f = i(this.b);
        this.d = true;
        return 0;
    }

    private long i(EW4 ew4) {
        int iG = ew4.g();
        for (int iF = ew4.f(); iF < iG - 3; iF++) {
            if (f(ew4.e(), iF) == 442) {
                ew4.S(iF + 4);
                long jL = l(ew4);
                if (jL != -9223372036854775807L) {
                    return jL;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int j(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        long length = interfaceC9845af2.getLength();
        int iMin = (int) Math.min(20000L, length);
        long j = length - iMin;
        if (interfaceC9845af2.getPosition() != j) {
            c8292Vi5.a = j;
            return 1;
        }
        this.b.O(iMin);
        interfaceC9845af2.e();
        interfaceC9845af2.m(this.b.e(), 0, iMin);
        this.g = k(this.b);
        this.e = true;
        return 0;
    }

    private long k(EW4 ew4) {
        int iF = ew4.f();
        for (int iG = ew4.g() - 4; iG >= iF; iG--) {
            if (f(ew4.e(), iG) == 442) {
                ew4.S(iG + 4);
                long jL = l(ew4);
                if (jL != -9223372036854775807L) {
                    return jL;
                }
            }
        }
        return -9223372036854775807L;
    }

    public static long l(EW4 ew4) {
        int iF = ew4.f();
        if (ew4.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        ew4.j(bArr, 0, 9);
        ew4.S(iF);
        if (a(bArr)) {
            return m(bArr);
        }
        return -9223372036854775807L;
    }

    private static long m(byte[] bArr) {
        byte b = bArr[0];
        long j = (((b & 56) >> 3) << 30) | ((b & 3) << 28) | ((bArr[1] & 255) << 20);
        byte b2 = bArr[2];
        return j | (((b2 & 248) >> 3) << 15) | ((b2 & 3) << 13) | ((bArr[3] & 255) << 5) | ((bArr[4] & 248) >> 3);
    }

    public long c() {
        return this.h;
    }

    public C5045Hq7 d() {
        return this.a;
    }

    public boolean e() {
        return this.c;
    }

    public int g(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        if (!this.e) {
            return j(interfaceC9845af2, c8292Vi5);
        }
        if (this.g == -9223372036854775807L) {
            return b(interfaceC9845af2);
        }
        if (!this.d) {
            return h(interfaceC9845af2, c8292Vi5);
        }
        long j = this.f;
        if (j == -9223372036854775807L) {
            return b(interfaceC9845af2);
        }
        long jB = this.a.b(this.g) - this.a.b(j);
        this.h = jB;
        if (jB < 0) {
            AbstractC18815pI3.k("PsDurationReader", "Invalid duration: " + this.h + ". Using TIME_UNSET instead.");
            this.h = -9223372036854775807L;
        }
        return b(interfaceC9845af2);
    }
}
