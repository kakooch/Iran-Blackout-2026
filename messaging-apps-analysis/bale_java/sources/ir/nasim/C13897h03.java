package ir.nasim;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* renamed from: ir.nasim.h03, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C13897h03 extends MK4 {
    private static final int[] b = {6, 8, 10, 12, 14};
    private static final int[] c = {1, 1, 1, 1};
    private static final int[][] d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    private static final int[][] e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    private int a = -1;

    private static int g(int[] iArr) throws NotFoundException {
        int length = e.length;
        float f = 0.38f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float fD = MK4.d(iArr, e[i2], 0.5f);
            if (fD < f) {
                i = i2;
                f = fD;
            } else if (fD == f) {
                i = -1;
            }
        }
        if (i >= 0) {
            return i % 10;
        }
        throw NotFoundException.a();
    }

    private int[] h(C3988Df0 c3988Df0) {
        int[] iArrK;
        c3988Df0.r();
        try {
            int iL = l(c3988Df0);
            try {
                iArrK = k(c3988Df0, iL, d[0]);
            } catch (NotFoundException unused) {
                iArrK = k(c3988Df0, iL, d[1]);
            }
            m(c3988Df0, iArrK[0]);
            int i = iArrK[0];
            iArrK[0] = c3988Df0.n() - iArrK[1];
            iArrK[1] = c3988Df0.n() - i;
            return iArrK;
        } finally {
            c3988Df0.r();
        }
    }

    private static void i(C3988Df0 c3988Df0, int i, int i2, StringBuilder sb) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i < i2) {
            MK4.e(c3988Df0, i, iArr);
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                iArr2[i3] = iArr[i4];
                iArr3[i3] = iArr[i4 + 1];
            }
            sb.append((char) (g(iArr2) + 48));
            sb.append((char) (g(iArr3) + 48));
            for (int i5 = 0; i5 < 10; i5++) {
                i += iArr[i5];
            }
        }
    }

    private int[] j(C3988Df0 c3988Df0) throws NotFoundException {
        int[] iArrK = k(c3988Df0, l(c3988Df0), c);
        int i = iArrK[1];
        int i2 = iArrK[0];
        this.a = (i - i2) / 4;
        m(c3988Df0, i2);
        return iArrK;
    }

    private static int[] k(C3988Df0 c3988Df0, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iN = c3988Df0.n();
        int i2 = i;
        boolean z = false;
        int i3 = 0;
        while (i < iN) {
            if (c3988Df0.i(i) != z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (MK4.d(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i2, i};
                    }
                    i2 += iArr2[0] + iArr2[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z = !z;
            }
            i++;
        }
        throw NotFoundException.a();
    }

    private static int l(C3988Df0 c3988Df0) throws NotFoundException {
        int iN = c3988Df0.n();
        int iL = c3988Df0.l(0);
        if (iL != iN) {
            return iL;
        }
        throw NotFoundException.a();
    }

    private void m(C3988Df0 c3988Df0, int i) throws NotFoundException {
        int i2 = this.a * 10;
        if (i2 >= i) {
            i2 = i;
        }
        for (int i3 = i - 1; i2 > 0 && i3 >= 0 && !c3988Df0.i(i3); i3--) {
            i2--;
        }
        if (i2 != 0) {
            throw NotFoundException.a();
        }
    }

    @Override // ir.nasim.MK4
    public X06 b(int i, C3988Df0 c3988Df0, Map map) throws NotFoundException, FormatException {
        boolean z;
        int[] iArrJ = j(c3988Df0);
        int[] iArrH = h(c3988Df0);
        StringBuilder sb = new StringBuilder(20);
        i(c3988Df0, iArrJ[1], iArrH[0], sb);
        String string = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(EnumC19932rB1.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = b;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length2) {
                z = false;
                break;
            }
            int i4 = iArr[i2];
            if (length == i4) {
                z = true;
                break;
            }
            if (i4 > i3) {
                i3 = i4;
            }
            i2++;
        }
        if (!z && length > i3) {
            z = true;
        }
        if (!z) {
            throw FormatException.a();
        }
        float f = i;
        return new X06(string, null, new C12092e16[]{new C12092e16(iArrJ[1], f), new C12092e16(iArrH[0], f)}, EnumC9549a90.ITF);
    }
}
