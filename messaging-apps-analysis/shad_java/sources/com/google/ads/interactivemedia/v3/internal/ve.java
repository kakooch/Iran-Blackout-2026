package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Random;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ve {
    private final Random a;
    private final int[] b;
    private final int[] c;

    public ve() {
        this(new Random());
    }

    public final int a() {
        return this.b.length;
    }

    public final int b(int i) {
        int i2 = this.c[i] + 1;
        int[] iArr = this.b;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    public final int c(int i) {
        int i2 = this.c[i] - 1;
        if (i2 >= 0) {
            return this.b[i2];
        }
        return -1;
    }

    public final int d() {
        int[] iArr = this.b;
        int length = iArr.length;
        if (length > 0) {
            return iArr[length - 1];
        }
        return -1;
    }

    public final int e() {
        int[] iArr = this.b;
        if (iArr.length > 0) {
            return iArr[0];
        }
        return -1;
    }

    public final ve f(int i, int i2) {
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2) {
            iArr[i4] = this.a.nextInt(this.b.length + 1);
            int i5 = i4 + 1;
            int iNextInt = this.a.nextInt(i5);
            iArr2[i4] = iArr2[iNextInt];
            iArr2[iNextInt] = i4 + i;
            i4 = i5;
        }
        Arrays.sort(iArr);
        int[] iArr3 = new int[this.b.length + i2];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int[] iArr4 = this.b;
            if (i3 >= iArr4.length + i2) {
                return new ve(iArr3, new Random(this.a.nextLong()));
            }
            if (i6 >= i2 || i7 != iArr[i6]) {
                int i8 = i7 + 1;
                int i9 = iArr4[i7];
                iArr3[i3] = i9;
                if (i9 >= i) {
                    iArr3[i3] = i9 + i2;
                }
                i7 = i8;
            } else {
                iArr3[i3] = iArr2[i6];
                i6++;
            }
            i3++;
        }
    }

    public final ve g(int i, int i2) {
        int i3 = i2 - i;
        int[] iArr = new int[this.b.length - i3];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int[] iArr2 = this.b;
            if (i4 >= iArr2.length) {
                return new ve(iArr, new Random(this.a.nextLong()));
            }
            int i6 = iArr2[i4];
            if (i6 < i || i6 >= i2) {
                int i7 = i4 - i5;
                if (i6 >= i) {
                    i6 -= i3;
                }
                iArr[i7] = i6;
            } else {
                i5++;
            }
            i4++;
        }
    }

    public final ve h() {
        return new ve(new Random(this.a.nextLong()));
    }

    private ve(Random random) {
        this(new int[0], random);
    }

    private ve(int[] iArr, Random random) {
        this.b = iArr;
        this.a = random;
        this.c = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            this.c[iArr[i]] = i;
        }
    }
}
