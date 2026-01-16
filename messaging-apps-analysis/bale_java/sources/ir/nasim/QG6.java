package ir.nasim;

/* loaded from: classes.dex */
public final class QG6 {
    private int a;
    private long[] b = SG6.b(16);
    private int[] c = new int[16];
    private int[] d;
    private int e;

    public QG6() {
        int[] iArr = new int[16];
        int i = 0;
        while (i < 16) {
            int i2 = i + 1;
            iArr[i] = i2;
            i = i2;
        }
        this.d = iArr;
    }

    private final int b() {
        int length = this.d.length;
        if (this.e >= length) {
            int i = length * 2;
            int[] iArr = new int[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = i2 + 1;
                iArr[i2] = i3;
                i2 = i3;
            }
            AbstractC9648aK.o(this.d, iArr, 0, 0, 0, 14, null);
            this.d = iArr;
        }
        int i4 = this.e;
        this.e = this.d[i4];
        return i4;
    }

    private final void c(int i) {
        int length = this.b.length;
        if (i <= length) {
            return;
        }
        int i2 = length * 2;
        long[] jArrB = SG6.b(i2);
        int[] iArr = new int[i2];
        AbstractC9648aK.p(this.b, jArrB, 0, 0, 0, 12, null);
        AbstractC9648aK.o(this.c, iArr, 0, 0, 0, 14, null);
        this.b = jArrB;
        this.c = iArr;
    }

    private final void d(int i) {
        this.d[i] = this.e;
        this.e = i;
    }

    private final void g(int i) {
        long[] jArr = this.b;
        int i2 = this.a >> 1;
        while (i < i2) {
            int i3 = (i + 1) << 1;
            int i4 = i3 - 1;
            if (i3 < this.a) {
                long j = jArr[i3];
                if (j < jArr[i4]) {
                    if (j >= jArr[i]) {
                        return;
                    }
                    i(i3, i);
                    i = i3;
                }
            }
            if (jArr[i4] >= jArr[i]) {
                return;
            }
            i(i4, i);
            i = i4;
        }
    }

    private final void h(int i) {
        long[] jArr = this.b;
        long j = jArr[i];
        while (i > 0) {
            int i2 = ((i + 1) >> 1) - 1;
            if (jArr[i2] <= j) {
                return;
            }
            i(i2, i);
            i = i2;
        }
    }

    private final void i(int i, int i2) {
        long[] jArr = this.b;
        int[] iArr = this.c;
        int[] iArr2 = this.d;
        long j = jArr[i];
        jArr[i] = jArr[i2];
        jArr[i2] = j;
        int i3 = iArr[i];
        int i4 = iArr[i2];
        iArr[i] = i4;
        iArr[i2] = i3;
        iArr2[i4] = i;
        iArr2[i3] = i2;
    }

    public final int a(long j) {
        c(this.a + 1);
        int i = this.a;
        this.a = i + 1;
        int iB = b();
        this.b[i] = j;
        this.c[i] = iB;
        this.d[iB] = i;
        h(i);
        return iB;
    }

    public final long e(long j) {
        return this.a > 0 ? this.b[0] : j;
    }

    public final void f(int i) {
        int i2 = this.d[i];
        i(i2, this.a - 1);
        this.a--;
        h(i2);
        g(i2);
        d(i);
    }
}
