package ir.nasim;

/* loaded from: classes2.dex */
abstract class OH0 {
    public static final int b(int[] iArr, int i) {
        return iArr[i + c(iArr)];
    }

    private static final int c(int[] iArr) {
        return iArr.length / 2;
    }

    public static final void d(int[] iArr, int i, int i2) {
        iArr[i + c(iArr)] = i2;
    }

    public static int[] a(int[] iArr) {
        return iArr;
    }
}
