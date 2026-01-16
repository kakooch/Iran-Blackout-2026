package ir.nasim;

/* renamed from: ir.nasim.xG6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC23644xG6 {
    public static final void a(int[] iArr, C4897Ha3 c4897Ha3) {
        int iMin;
        int i = iArr[0];
        int i2 = iArr[1];
        if (c(iArr)) {
            iMin = Math.min(iArr[2] - iArr[0], iArr[3] - iArr[1]);
            i += ((iArr[4] != 0 ? 1 : 0) | (d(iArr) ? 1 : 0)) ^ 1;
            i2 += ((!d(iArr) ? 1 : 0) | (iArr[4] != 0 ? 1 : 0)) ^ 1;
        } else {
            iMin = iArr[2] - iArr[0];
        }
        c4897Ha3.g(i, i2, iMin);
    }

    private static final boolean c(int[] iArr) {
        return iArr[3] - iArr[1] != iArr[2] - iArr[0];
    }

    private static final boolean d(int[] iArr) {
        return iArr[3] - iArr[1] > iArr[2] - iArr[0];
    }

    public static int[] b(int[] iArr) {
        return iArr;
    }
}
