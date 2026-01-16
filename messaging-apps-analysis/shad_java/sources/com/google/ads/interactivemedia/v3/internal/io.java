package com.google.ads.interactivemedia.v3.internal;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class io {
    private final int a;
    private final int b;
    private final float c;
    private final float d;
    private final float e;
    private final int f;
    private final int g;
    private final int h;
    private final short[] i;
    private short[] j;
    private int k;
    private short[] l;
    private int m;
    private short[] n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;

    public io(int i, int i2, float f, float f2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = f2;
        this.e = i / i3;
        this.f = i / 400;
        int i4 = i / 65;
        this.g = i4;
        int i5 = i4 + i4;
        this.h = i5;
        this.i = new short[i5];
        int i6 = i5 * i2;
        this.j = new short[i6];
        this.l = new short[i6];
        this.n = new short[i6];
    }

    private final short[] f(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.b;
        int i4 = length / i3;
        return i + i2 <= i4 ? sArr : Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    private final void g(short[] sArr, int i, int i2) {
        short[] sArrF = f(this.l, this.m, i2);
        this.l = sArrF;
        int i3 = this.b;
        System.arraycopy(sArr, i * i3, sArrF, this.m * i3, i3 * i2);
        this.m += i2;
    }

    private final void h(short[] sArr, int i, int i2) {
        int i3 = this.h / i2;
        int i4 = this.b;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.i[i7] = (short) (i8 / i5);
        }
    }

    private final int i(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.b;
        int i5 = 1;
        int i6 = 255;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int iAbs = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                iAbs += Math.abs(sArr[i4 + i9] - sArr[(i4 + i2) + i9]);
            }
            int i10 = iAbs * i7;
            int i11 = i5 * i2;
            if (i10 < i11) {
                i5 = iAbs;
            }
            if (i10 < i11) {
                i7 = i2;
            }
            int i12 = iAbs * i6;
            int i13 = i8 * i2;
            if (i12 > i13) {
                i8 = iAbs;
            }
            if (i12 > i13) {
                i6 = i2;
            }
            i2++;
        }
        this.u = i5 / i7;
        this.v = i8 / i6;
        return i7;
    }

    private static void k(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }

    public final void a(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i = this.b;
        int i2 = iRemaining / i;
        int i3 = i * i2;
        short[] sArrF = f(this.j, this.k, i2);
        this.j = sArrF;
        shortBuffer.get(sArrF, this.k * this.b, (i3 + i3) / 2);
        this.k += i2;
        j();
    }

    public final void b(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.b, this.m);
        shortBuffer.put(this.l, 0, this.b * iMin);
        int i = this.m - iMin;
        this.m = i;
        short[] sArr = this.l;
        int i2 = this.b;
        System.arraycopy(sArr, iMin * i2, sArr, 0, i * i2);
    }

    public final void c() {
        int i;
        int i2 = this.k;
        float f = this.c;
        float f2 = this.d;
        int i3 = this.m + ((int) ((((i2 / (f / f2)) + this.o) / (this.e * f2)) + 0.5f));
        short[] sArr = this.j;
        int i4 = this.h;
        this.j = f(sArr, i2, i4 + i4 + i2);
        int i5 = 0;
        while (true) {
            int i6 = this.h;
            i = i6 + i6;
            int i7 = this.b;
            if (i5 >= i * i7) {
                break;
            }
            this.j[(i7 * i2) + i5] = 0;
            i5++;
        }
        this.k += i;
        j();
        if (this.m > i3) {
            this.m = i3;
        }
        this.k = 0;
        this.r = 0;
        this.o = 0;
    }

    public final void d() {
        this.k = 0;
        this.m = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
    }

    public final int e() {
        int i = this.m * this.b;
        return i + i;
    }

    private final void j() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = this.m;
        float f = this.c;
        float f2 = this.d;
        float f3 = f / f2;
        float f4 = this.e * f2;
        double d = f3;
        float f5 = 1.0f;
        int i10 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            int i11 = this.k;
            if (i11 >= this.h) {
                int i12 = 0;
                while (true) {
                    int i13 = this.r;
                    if (i13 > 0) {
                        int iMin = Math.min(this.h, i13);
                        g(this.j, i12, iMin);
                        this.r -= iMin;
                        i12 += iMin;
                    } else {
                        short[] sArr = this.j;
                        int i14 = this.a;
                        int i15 = i14 > 4000 ? i14 / 4000 : 1;
                        if (this.b == i10 && i15 == i10) {
                            i = i(sArr, i12, this.f, this.g);
                        } else {
                            h(sArr, i12, i15);
                            int i16 = i(this.i, 0, this.f / i15, this.g / i15);
                            if (i15 != i10) {
                                int i17 = i16 * i15;
                                int i18 = i15 * 4;
                                int i19 = i17 - i18;
                                int i20 = i17 + i18;
                                int i21 = this.f;
                                if (i19 < i21) {
                                    i19 = i21;
                                }
                                int i22 = this.g;
                                if (i20 > i22) {
                                    i20 = i22;
                                }
                                if (this.b == i10) {
                                    i = i(sArr, i12, i19, i20);
                                } else {
                                    h(sArr, i12, i10);
                                    i = i(this.i, 0, i19, i20);
                                }
                            } else {
                                i = i16;
                            }
                        }
                        int i23 = this.u;
                        int i24 = (i23 == 0 || (i4 = this.s) == 0 || this.v > i23 * 3 || i23 + i23 <= this.t * 3) ? i : i4;
                        this.t = i23;
                        this.s = i;
                        if (d > 1.0d) {
                            short[] sArr2 = this.j;
                            if (f3 >= 2.0f) {
                                i3 = (int) (i24 / ((-1.0f) + f3));
                            } else {
                                this.r = (int) ((i24 * (2.0f - f3)) / ((-1.0f) + f3));
                                i3 = i24;
                            }
                            short[] sArrF = f(this.l, this.m, i3);
                            this.l = sArrF;
                            int i25 = i3;
                            k(i3, this.b, sArrF, this.m, sArr2, i12, sArr2, i12 + i24);
                            this.m += i25;
                            i12 += i24 + i25;
                        } else {
                            int i26 = i24;
                            short[] sArr3 = this.j;
                            if (f3 < 0.5f) {
                                i2 = (int) ((i26 * f3) / (f5 - f3));
                            } else {
                                this.r = (int) ((i26 * ((f3 + f3) - 1.0f)) / (f5 - f3));
                                i2 = i26;
                            }
                            int i27 = i26 + i2;
                            short[] sArrF2 = f(this.l, this.m, i27);
                            this.l = sArrF2;
                            int i28 = this.b;
                            System.arraycopy(sArr3, i12 * i28, sArrF2, this.m * i28, i28 * i26);
                            k(i2, this.b, this.l, this.m + i26, sArr3, i12 + i26, sArr3, i12);
                            this.m += i27;
                            i12 += i2;
                        }
                    }
                    if (this.h + i12 > i11) {
                        break;
                    }
                    f5 = 1.0f;
                    i10 = 1;
                }
                int i29 = this.k - i12;
                short[] sArr4 = this.j;
                int i30 = this.b;
                System.arraycopy(sArr4, i12 * i30, sArr4, 0, i30 * i29);
                this.k = i29;
                f5 = 1.0f;
            }
        } else {
            g(this.j, 0, this.k);
            this.k = 0;
        }
        if (f4 == f5 || this.m == i9) {
            return;
        }
        int i31 = this.a;
        int i32 = (int) (i31 / f4);
        while (true) {
            if (i32 <= 16384 && i31 <= 16384) {
                break;
            }
            i32 /= 2;
            i31 /= 2;
        }
        int i33 = this.m - i9;
        short[] sArrF3 = f(this.n, this.o, i33);
        this.n = sArrF3;
        short[] sArr5 = this.l;
        int i34 = this.b;
        System.arraycopy(sArr5, i9 * i34, sArrF3, this.o * i34, i34 * i33);
        this.m = i9;
        this.o += i33;
        int i35 = 0;
        while (true) {
            i5 = this.o;
            i6 = i5 - 1;
            if (i35 >= i6) {
                break;
            }
            while (true) {
                i7 = this.p + 1;
                i8 = this.q;
                if (i7 * i32 <= i8 * i31) {
                    break;
                }
                this.l = f(this.l, this.m, 1);
                int i36 = 0;
                while (true) {
                    int i37 = this.b;
                    if (i36 < i37) {
                        short[] sArr6 = this.l;
                        int i38 = this.m;
                        short[] sArr7 = this.n;
                        int i39 = (i35 * i37) + i36;
                        short s = sArr7[i39];
                        short s2 = sArr7[i39 + i37];
                        int i40 = this.q;
                        int i41 = this.p;
                        int i42 = (i41 + 1) * i32;
                        int i43 = i42 - (i40 * i31);
                        int i44 = i42 - (i41 * i32);
                        sArr6[(i38 * i37) + i36] = (short) (((s * i43) + ((i44 - i43) * s2)) / i44);
                        i36++;
                    }
                }
                this.q++;
                this.m++;
            }
            this.p = i7;
            if (i7 == i31) {
                this.p = 0;
                ary.q(i8 == i32);
                this.q = 0;
            }
            i35++;
        }
        if (i6 != 0) {
            short[] sArr8 = this.n;
            int i45 = this.b;
            System.arraycopy(sArr8, i6 * i45, sArr8, 0, (i5 - i6) * i45);
            this.o -= i6;
        }
    }
}
