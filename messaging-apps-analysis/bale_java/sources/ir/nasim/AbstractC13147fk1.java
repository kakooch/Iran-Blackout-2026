package ir.nasim;

/* renamed from: ir.nasim.fk1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
abstract class AbstractC13147fk1 {
    static final boolean[] a = new boolean[0];
    static final int[] b = new int[0];
    static final Object[] c = new Object[0];

    static int a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else {
                if (i6 <= i2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }
}
