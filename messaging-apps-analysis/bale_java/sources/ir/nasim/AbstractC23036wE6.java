package ir.nasim;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/* renamed from: ir.nasim.wE6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC23036wE6 {
    private static final long[] a = new long[0];

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n(int[] iArr, int i) {
        int i2 = i * 5;
        if (i2 >= iArr.length) {
            return iArr.length;
        }
        return Integer.bitCount(iArr[i2 + 1] >> 29) + iArr[i2 + 4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6669Om o(ArrayList arrayList, int i, int i2) {
        int iT = t(arrayList, i, i2);
        if (iT >= 0) {
            return (C6669Om) arrayList.get(iT);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(int[] iArr, int i) {
        return iArr[(i * 5) + 3];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(int[] iArr, int i, int i2, boolean z, boolean z2, boolean z3, int i3, int i4) {
        int i5 = i * 5;
        iArr[i5] = i2;
        iArr[i5 + 1] = ((z ? 1 : 0) << 30) | ((z2 ? 1 : 0) << 29) | ((z3 ? 1 : 0) << 28);
        iArr[i5 + 2] = i3;
        iArr[i5 + 3] = 0;
        iArr[i5 + 4] = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int r(ArrayList arrayList, int i, int i2) {
        int iT = t(arrayList, i, i2);
        return iT >= 0 ? iT : -(iT + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int s(int[] iArr, int i) {
        int i2 = i * 5;
        return iArr[i2 + 4] + Integer.bitCount(iArr[i2 + 1] >> 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int t(ArrayList arrayList, int i, int i2) {
        int size = arrayList.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i4 = (i3 + size) >>> 1;
            int iA = ((C6669Om) arrayList.get(i4)).a();
            if (iA < 0) {
                iA += i2;
            }
            int iK = AbstractC13042fc3.k(iA, i);
            if (iK < 0) {
                i3 = i4 + 1;
            } else {
                if (iK <= 0) {
                    return i4;
                }
                size = i4 - 1;
            }
        }
        return -(i3 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int u(int[] iArr, int i) {
        int i2 = i * 5;
        return iArr[i2 + 4] + Integer.bitCount(iArr[i2 + 1] >> 28);
    }

    public static final void v() {
        throw new ConcurrentModificationException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(int[] iArr, int i, boolean z) {
        int i2 = (i * 5) + 1;
        iArr[i2] = ((z ? 1 : 0) << 26) | (iArr[i2] & (-67108865));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(int[] iArr, int i, int i2) {
        iArr[(i * 5) + 3] = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(int[] iArr, int i, boolean z) {
        int i2 = (i * 5) + 1;
        iArr[i2] = ((z ? 1 : 0) << 27) | (iArr[i2] & (-134217729));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(int[] iArr, int i, int i2) {
        if (i2 >= 0) {
        }
        int i3 = (i * 5) + 1;
        iArr[i3] = i2 | (iArr[i3] & (-67108864));
    }
}
