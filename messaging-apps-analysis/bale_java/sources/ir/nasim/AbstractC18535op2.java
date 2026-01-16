package ir.nasim;

/* renamed from: ir.nasim.op2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC18535op2 {

    /* renamed from: ir.nasim.op2$b */
    public static final class b {
        public final long[] a;
        public final int[] b;
        public final int c;
        public final long[] d;
        public final int[] e;
        public final long f;

        private b(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
            this.a = jArr;
            this.b = iArr;
            this.c = i;
            this.d = jArr2;
            this.e = iArr2;
            this.f = j;
        }
    }

    public static b a(int i, long[] jArr, int[] iArr, long j) {
        int i2 = 8192 / i;
        int iL = 0;
        for (int i3 : iArr) {
            iL += AbstractC9683aN7.l(i3, i2);
        }
        long[] jArr2 = new long[iL];
        int[] iArr2 = new int[iL];
        long[] jArr3 = new long[iL];
        int[] iArr3 = new int[iL];
        int i4 = 0;
        int i5 = 0;
        int iMax = 0;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            int i7 = iArr[i6];
            long j2 = jArr[i6];
            while (i7 > 0) {
                int iMin = Math.min(i2, i7);
                jArr2[i5] = j2;
                int i8 = i * iMin;
                iArr2[i5] = i8;
                iMax = Math.max(iMax, i8);
                jArr3[i5] = i4 * j;
                iArr3[i5] = 1;
                j2 += iArr2[i5];
                i4 += iMin;
                i7 -= iMin;
                i5++;
            }
        }
        return new b(jArr2, iArr2, iMax, jArr3, iArr3, j * i4);
    }
}
