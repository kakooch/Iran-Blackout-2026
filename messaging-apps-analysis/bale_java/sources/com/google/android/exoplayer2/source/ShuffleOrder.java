package com.google.android.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

/* loaded from: classes2.dex */
public interface ShuffleOrder {

    public static class DefaultShuffleOrder implements ShuffleOrder {
        private final Random a;
        private final int[] b;
        private final int[] c;

        public DefaultShuffleOrder(int i) {
            this(i, new Random());
        }

        private static int[] h(int i, Random random) {
            int[] iArr = new int[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = i2 + 1;
                int iNextInt = random.nextInt(i3);
                iArr[i2] = iArr[iNextInt];
                iArr[iNextInt] = i2;
                i2 = i3;
            }
            return iArr;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder a(int i, int i2) {
            int i3 = i2 - i;
            int[] iArr = new int[this.b.length - i3];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.b;
                if (i4 >= iArr2.length) {
                    return new DefaultShuffleOrder(iArr, new Random(this.a.nextLong()));
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

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int b(int i) {
            int i2 = this.c[i] - 1;
            if (i2 >= 0) {
                return this.b[i2];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int c(int i) {
            int i2 = this.c[i] + 1;
            int[] iArr = this.b;
            if (i2 < iArr.length) {
                return iArr[i2];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int d() {
            int[] iArr = this.b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder e() {
            return new DefaultShuffleOrder(0, new Random(this.a.nextLong()));
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int f() {
            int[] iArr = this.b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder g(int i, int i2) {
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
                    return new DefaultShuffleOrder(iArr3, new Random(this.a.nextLong()));
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

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            return this.b.length;
        }

        private DefaultShuffleOrder(int i, Random random) {
            this(h(i, random), random);
        }

        private DefaultShuffleOrder(int[] iArr, Random random) {
            this.b = iArr;
            this.a = random;
            this.c = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.c[iArr[i]] = i;
            }
        }
    }

    public static final class UnshuffledShuffleOrder implements ShuffleOrder {
        private final int a;

        public UnshuffledShuffleOrder(int i) {
            this.a = i;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder a(int i, int i2) {
            return new UnshuffledShuffleOrder((this.a - i2) + i);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int b(int i) {
            int i2 = i - 1;
            if (i2 >= 0) {
                return i2;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int c(int i) {
            int i2 = i + 1;
            if (i2 < this.a) {
                return i2;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int d() {
            int i = this.a;
            if (i > 0) {
                return i - 1;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder e() {
            return new UnshuffledShuffleOrder(0);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int f() {
            return this.a > 0 ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder g(int i, int i2) {
            return new UnshuffledShuffleOrder(this.a + i2);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            return this.a;
        }
    }

    ShuffleOrder a(int i, int i2);

    int b(int i);

    int c(int i);

    int d();

    ShuffleOrder e();

    int f();

    ShuffleOrder g(int i, int i2);

    int getLength();
}
