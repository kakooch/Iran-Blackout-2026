package ir.nasim;

/* renamed from: ir.nasim.Kn1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5714Kn1 {
    public static int e = 1;
    public static int f = 2;
    protected C8826Xm3 a;
    protected boolean b;
    protected boolean c;
    private int d;

    public AbstractC5714Kn1(float[] fArr) {
        this(new C8826Xm3(5, 5, fArr));
    }

    public static void a(C8826Xm3 c8826Xm3, int[] iArr, int[] iArr2, int i, int i2, boolean z, int i3) {
        if (c8826Xm3.a() == 1) {
            b(c8826Xm3, iArr, iArr2, i, i2, z, i3);
        } else if (c8826Xm3.c() == 1) {
            d(c8826Xm3, iArr, iArr2, i, i2, z, i3);
        } else {
            c(c8826Xm3, iArr, iArr2, i, i2, z, i3);
        }
    }

    public static void b(C8826Xm3 c8826Xm3, int[] iArr, int[] iArr2, int i, int i2, boolean z, int i3) {
        int i4 = i;
        int i5 = i3;
        float[] fArrB = c8826Xm3.b(null);
        int iC = c8826Xm3.c() / 2;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i2) {
            int i8 = i6 * i4;
            int i9 = 0;
            while (i9 < i4) {
                int i10 = -iC;
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                float f5 = 0.0f;
                float f6 = 0.0f;
                while (i10 <= iC) {
                    float f7 = fArrB[iC + i10];
                    if (f7 != f2) {
                        int i11 = i9 + i10;
                        if (i11 < 0) {
                            if (i5 == e) {
                                i11 = 0;
                            } else if (i5 == f) {
                                i11 = (i9 + i4) % i4;
                            }
                        } else if (i11 >= i4) {
                            if (i5 == e) {
                                i11 = i4 - 1;
                            } else if (i5 == f) {
                                i11 = (i9 + i4) % i4;
                            }
                        }
                        int i12 = iArr[i11 + i8];
                        f3 += ((i12 >> 24) & 255) * f7;
                        f4 += ((i12 >> 16) & 255) * f7;
                        f5 += ((i12 >> 8) & 255) * f7;
                        f6 += f7 * (255 & i12);
                    }
                    i10++;
                    i4 = i;
                    f2 = 0.0f;
                }
                iArr2[i7] = (AbstractC20810se5.a((int) (f4 + 0.5d)) << 16) | ((z ? AbstractC20810se5.a((int) (f3 + 0.5d)) : 255) << 24) | (AbstractC20810se5.a((int) (f5 + 0.5d)) << 8) | AbstractC20810se5.a((int) (f6 + 0.5d));
                i9++;
                i4 = i;
                i5 = i3;
                i7++;
            }
            i6++;
            i4 = i;
            i5 = i3;
        }
    }

    public static void c(C8826Xm3 c8826Xm3, int[] iArr, int[] iArr2, int i, int i2, boolean z, int i3) {
        int i4;
        int i5;
        float[] fArr;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        float[] fArrB = c8826Xm3.b(null);
        int iA = c8826Xm3.a();
        int iC = c8826Xm3.c();
        int i9 = iA / 2;
        int i10 = iC / 2;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i7) {
            int i13 = 0;
            while (i13 < i6) {
                int i14 = -i9;
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                float f5 = 0.0f;
                while (i14 <= i9) {
                    int i15 = i11 + i14;
                    if (i15 < 0 || i15 >= i7) {
                        i4 = i12;
                        if (i8 == e) {
                            i5 = i11 * i6;
                        } else if (i8 == f) {
                            i5 = ((i15 + i7) % i7) * i6;
                        } else {
                            i14++;
                            i6 = i;
                            i7 = i2;
                            i8 = i3;
                            i12 = i4;
                            fArrB = fArrB;
                        }
                    } else {
                        i5 = i15 * i6;
                        i4 = i12;
                    }
                    int i16 = ((i14 + i9) * iC) + i10;
                    int i17 = -i10;
                    while (i17 <= i10) {
                        float f6 = fArrB[i16 + i17];
                        if (f6 != 0.0f) {
                            fArr = fArrB;
                            int i18 = i13 + i17;
                            if (i18 < 0 || i18 >= i6) {
                                if (i8 == e) {
                                    i18 = i13;
                                } else if (i8 == f) {
                                    i18 = (i13 + i6) % i6;
                                }
                            }
                            int i19 = iArr[i18 + i5];
                            f3 += ((i19 >> 24) & 255) * f6;
                            f4 += ((i19 >> 16) & 255) * f6;
                            f5 += ((i19 >> 8) & 255) * f6;
                            f2 += f6 * (i19 & 255);
                            i17++;
                            i6 = i;
                            i8 = i3;
                            fArrB = fArr;
                        } else {
                            fArr = fArrB;
                        }
                        i17++;
                        i6 = i;
                        i8 = i3;
                        fArrB = fArr;
                    }
                    i14++;
                    i6 = i;
                    i7 = i2;
                    i8 = i3;
                    i12 = i4;
                    fArrB = fArrB;
                }
                float[] fArr2 = fArrB;
                int i20 = i12;
                i12 = i20 + 1;
                iArr2[i20] = AbstractC20810se5.a((int) (f2 + 0.5d)) | ((z ? AbstractC20810se5.a((int) (f3 + 0.5d)) : 255) << 24) | (AbstractC20810se5.a((int) (f4 + 0.5d)) << 16) | (AbstractC20810se5.a((int) (f5 + 0.5d)) << 8);
                i13++;
                i6 = i;
                i7 = i2;
                i8 = i3;
                fArrB = fArr2;
            }
            i11++;
            i6 = i;
            i7 = i2;
            i8 = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0069 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(ir.nasim.C8826Xm3 r17, int[] r18, int[] r19, int r20, int r21, boolean r22, int r23) {
        /*
            Method dump skipped, instructions count: 178
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5714Kn1.d(ir.nasim.Xm3, int[], int[], int, int, boolean, int):void");
    }

    public int[] e(int[] iArr, int i, int i2) {
        int i3 = i * i2;
        int[] iArr2 = new int[i3];
        int[] iArr3 = new int[i3];
        if (this.c) {
            B23.a(iArr, 0, iArr.length);
        }
        a(this.a, iArr, iArr3, i, i2, this.b, this.d);
        if (this.c) {
            B23.b(iArr3, 0, i3);
        }
        return iArr3;
    }

    public AbstractC5714Kn1(C8826Xm3 c8826Xm3) {
        this.b = true;
        this.c = true;
        this.d = e;
        this.a = c8826Xm3;
    }
}
