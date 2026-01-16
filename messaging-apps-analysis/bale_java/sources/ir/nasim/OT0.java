package ir.nasim;

import ir.nasim.InterfaceC22148uk6;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class OT0 {
    protected final InterfaceC4589Ft7 a;
    private final int b;
    private final int c;
    private final long d;
    private final int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long[] k;
    private int[] l;

    public OT0(int i, int i2, long j, int i3, InterfaceC4589Ft7 interfaceC4589Ft7) {
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        AbstractC20011rK.a(z);
        this.d = j;
        this.e = i3;
        this.a = interfaceC4589Ft7;
        this.b = d(i, i2 == 2 ? 1667497984 : 1651965952);
        this.c = i2 == 2 ? d(i, 1650720768) : -1;
        this.k = new long[512];
        this.l = new int[512];
    }

    private static int d(int i, int i2) {
        return (((i % 10) + 48) << 8) | ((i / 10) + 48) | i2;
    }

    private long e(int i) {
        return (this.d * i) / this.e;
    }

    private C23334wk6 h(int i) {
        return new C23334wk6(this.l[i] * g(), this.k[i]);
    }

    public void a() {
        this.h++;
    }

    public void b(long j) {
        if (this.j == this.l.length) {
            long[] jArr = this.k;
            this.k = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.l;
            this.l = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.k;
        int i = this.j;
        jArr2[i] = j;
        this.l[i] = this.i;
        this.j = i + 1;
    }

    public void c() {
        this.k = Arrays.copyOf(this.k, this.j);
        this.l = Arrays.copyOf(this.l, this.j);
    }

    public long f() {
        return e(this.h);
    }

    public long g() {
        return e(1);
    }

    public InterfaceC22148uk6.a i(long j) {
        int iG = (int) (j / g());
        int iH = AbstractC9683aN7.h(this.l, iG, true, true);
        if (this.l[iH] == iG) {
            return new InterfaceC22148uk6.a(h(iH));
        }
        C23334wk6 c23334wk6H = h(iH);
        int i = iH + 1;
        return i < this.k.length ? new InterfaceC22148uk6.a(c23334wk6H, h(i)) : new InterfaceC22148uk6.a(c23334wk6H);
    }

    public boolean j(int i) {
        return this.b == i || this.c == i;
    }

    public void k() {
        this.i++;
    }

    public boolean l() {
        return Arrays.binarySearch(this.l, this.h) >= 0;
    }

    public boolean m(InterfaceC9845af2 interfaceC9845af2) {
        int i = this.g;
        int iF = i - this.a.f(interfaceC9845af2, i, false);
        this.g = iF;
        boolean z = iF == 0;
        if (z) {
            if (this.f > 0) {
                this.a.b(f(), l() ? 1 : 0, this.f, 0, null);
            }
            a();
        }
        return z;
    }

    public void n(int i) {
        this.f = i;
        this.g = i;
    }

    public void o(long j) {
        if (this.j == 0) {
            this.h = 0;
        } else {
            this.h = this.l[AbstractC9683aN7.i(this.k, j, true, true)];
        }
    }
}
