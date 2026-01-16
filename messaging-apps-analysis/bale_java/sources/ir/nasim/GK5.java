package ir.nasim;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class GK5 {
    public long[] a = new long[192];
    public long[] b = new long[192];
    public int c;

    private final void i(int i, int i2, long[] jArr) {
        int iMax = Math.max(i * 2, i2 + 3);
        long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
        AbstractC13042fc3.h(jArrCopyOf, "copyOf(...)");
        this.a = jArrCopyOf;
        long[] jArrCopyOf2 = Arrays.copyOf(this.b, iMax);
        AbstractC13042fc3.h(jArrCopyOf2, "copyOf(...)");
        this.b = jArrCopyOf2;
    }

    private final void k(long j, int i, int i2) {
        int i3;
        int i4;
        char c;
        char c2;
        long[] jArr = this.a;
        long[] jArr2 = this.b;
        int iC = c();
        jArr2[0] = j;
        int i5 = 1;
        while (i5 > 0) {
            i5--;
            long j2 = jArr2[i5];
            int i6 = 67108863;
            int i7 = ((int) j2) & 67108863;
            char c3 = 26;
            int i8 = ((int) (j2 >> 26)) & 67108863;
            char c4 = 511;
            int i9 = ((int) (j2 >> 52)) & 511;
            int i10 = i9 == 511 ? iC : i9 + i8;
            if (i8 < 0) {
                return;
            }
            while (i8 < jArr.length - 2 && i8 < i10) {
                int i11 = i8 + 2;
                long j3 = jArr[i11];
                if ((((int) (j3 >> c3)) & i6) == i7) {
                    long j4 = jArr[i8];
                    int i12 = i8 + 1;
                    long j5 = jArr[i12];
                    i3 = i7;
                    jArr[i8] = ((((int) j4) + i2) & 4294967295L) | ((((int) (j4 >> 32)) + i) << 32);
                    jArr[i12] = ((((int) j5) + i2) & 4294967295L) | ((((int) (j5 >> 32)) + i) << 32);
                    jArr[i11] = 2305843009213693952L | j3;
                    c2 = '4';
                    c = 511;
                    if ((((int) (j3 >> 52)) & 511) > 0) {
                        long j6 = (-4503599560261633L) & j3;
                        i4 = 67108863;
                        c3 = 26;
                        jArr2[i5] = j6 | (((i8 + 3) & 67108863) << 26);
                        i5++;
                    } else {
                        c3 = 26;
                        i4 = 67108863;
                    }
                } else {
                    i3 = i7;
                    i4 = i6;
                    c = c4;
                    c2 = '4';
                }
                i8 += 3;
                c4 = c;
                i6 = i4;
                i7 = i3;
            }
        }
    }

    public final void a() {
        long[] jArr = this.a;
        int i = this.c;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            int i3 = i2 + 2;
            jArr[i3] = jArr[i3] & (-2305843009213693953L);
        }
    }

    public final void b() {
        long[] jArr = this.a;
        int i = this.c;
        long[] jArr2 = this.b;
        int i2 = 0;
        for (int i3 = 0; i3 < jArr.length - 2 && i2 < jArr2.length - 2 && i3 < i; i3 += 3) {
            int i4 = i3 + 2;
            if (jArr[i4] != 2305843009213693951L) {
                jArr2[i2] = jArr[i3];
                jArr2[i2 + 1] = jArr[i3 + 1];
                jArr2[i2 + 2] = jArr[i4];
                i2 += 3;
            }
        }
        this.c = i2;
        this.a = jArr2;
        this.b = jArr;
    }

    public final int c() {
        return this.c / 3;
    }

    public final void d(int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2) {
        long[] jArr = this.a;
        int i7 = this.c;
        int i8 = i7 + 3;
        this.c = i8;
        int length = jArr.length;
        if (length <= i8) {
            i(length, i7, jArr);
        }
        long[] jArr2 = this.a;
        jArr2[i7] = (i2 << 32) | (i3 & 4294967295L);
        jArr2[i7 + 1] = (i4 << 32) | (i5 & 4294967295L);
        int i9 = i6 & 67108863;
        jArr2[i7 + 2] = ((z2 ? 1L : 0L) << 63) | ((z ? 1L : 0L) << 62) | (1 << 61) | (0 << 52) | (i9 << 26) | (i & 67108863);
        if (i6 < 0) {
            return;
        }
        for (int i10 = i7 - 3; i10 >= 0; i10 -= 3) {
            int i11 = i10 + 2;
            long j = jArr2[i11];
            if ((((int) j) & 67108863) == i9) {
                jArr2[i11] = (((i7 - i10) & 511) << 52) | ((-2301339409586323457L) & j);
                return;
            }
        }
    }

    public final void f(int i) {
        int i2 = i & 67108863;
        long[] jArr = this.a;
        int i3 = this.c;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            int i5 = i4 + 2;
            long j = jArr[i5];
            if ((((int) j) & 67108863) == i2) {
                jArr[i5] = 2305843009213693952L | j;
                return;
            }
        }
    }

    public final boolean g(int i, int i2, int i3, int i4, int i5) {
        int i6 = i & 67108863;
        long[] jArr = this.a;
        int i7 = this.c;
        for (int i8 = 0; i8 < jArr.length - 2 && i8 < i7; i8 += 3) {
            int i9 = i8 + 2;
            long j = jArr[i9];
            if ((((int) j) & 67108863) == i6) {
                long j2 = jArr[i8];
                jArr[i8] = (i3 & 4294967295L) | (i2 << 32);
                int i10 = i8;
                jArr[i8 + 1] = (i5 & 4294967295L) | (i4 << 32);
                jArr[i9] = 2305843009213693952L | j;
                int i11 = i2 - ((int) (j2 >> 32));
                int i12 = i3 - ((int) j2);
                if ((i11 != 0) | (i12 != 0)) {
                    k(((-4503599560261633L) & j) | (((i10 + 3) & 67108863) << 26), i11, i12);
                }
                return true;
            }
        }
        return false;
    }

    public final boolean h(int i) {
        int i2 = i & 67108863;
        long[] jArr = this.a;
        int i3 = this.c;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            int i5 = i4 + 2;
            if ((((int) jArr[i5]) & 67108863) == i2) {
                jArr[i4] = -1;
                jArr[i4 + 1] = -1;
                jArr[i5] = 2305843009213693951L;
                return true;
            }
        }
        return false;
    }

    public final boolean j(int i, int i2, int i3, int i4, int i5) {
        int i6 = i & 67108863;
        long[] jArr = this.a;
        int i7 = this.c;
        for (int i8 = 0; i8 < jArr.length - 2 && i8 < i7; i8 += 3) {
            int i9 = i8 + 2;
            long j = jArr[i9];
            if ((((int) j) & 67108863) == i6) {
                jArr[i8] = (i2 << 32) | (i3 & 4294967295L);
                jArr[i8 + 1] = (i4 << 32) | (i5 & 4294967295L);
                jArr[i9] = 2305843009213693952L | j;
                return true;
            }
        }
        return false;
    }

    public final boolean l(int i, InterfaceC16978mB2 interfaceC16978mB2) {
        int i2 = i & 67108863;
        long[] jArr = this.a;
        int i3 = this.c;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            if ((((int) jArr[i4 + 2]) & 67108863) == i2) {
                long j = jArr[i4];
                long j2 = jArr[i4 + 1];
                interfaceC16978mB2.e(Integer.valueOf((int) (j >> 32)), Integer.valueOf((int) j), Integer.valueOf((int) (j2 >> 32)), Integer.valueOf((int) j2));
                return true;
            }
        }
        return false;
    }
}
