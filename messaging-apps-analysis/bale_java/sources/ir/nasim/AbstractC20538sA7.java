package ir.nasim;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.Arrays;
import java.util.Map;

/* renamed from: ir.nasim.sA7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC20538sA7 extends MK4 {
    static final int[] d = {1, 1, 1};
    static final int[] e = {1, 1, 1, 1, 1};
    static final int[] f = {1, 1, 1, 1, 1, 1};
    static final int[][] g;
    static final int[][] h;
    private final StringBuilder a = new StringBuilder(20);
    private final C19929rA7 b = new C19929rA7();
    private final F22 c = new F22();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        g = iArr;
        int[][] iArr2 = new int[20][];
        h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = g[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            h[i] = iArr4;
        }
    }

    protected AbstractC20538sA7() {
    }

    static boolean h(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        return q(charSequence.subSequence(0, i)) == Character.digit(charSequence.charAt(i), 10);
    }

    static int i(C3988Df0 c3988Df0, int[] iArr, int i, int[][] iArr2) throws NotFoundException {
        MK4.e(c3988Df0, i, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fD = MK4.d(iArr, iArr2[i3], 0.7f);
            if (fD < f2) {
                i2 = i3;
                f2 = fD;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.a();
    }

    static int[] m(C3988Df0 c3988Df0, int i, boolean z, int[] iArr) {
        return n(c3988Df0, i, z, iArr, new int[iArr.length]);
    }

    private static int[] n(C3988Df0 c3988Df0, int i, boolean z, int[] iArr, int[] iArr2) throws NotFoundException {
        int iN = c3988Df0.n();
        int iM = z ? c3988Df0.m(i) : c3988Df0.l(i);
        int length = iArr.length;
        boolean z2 = z;
        int i2 = 0;
        int i3 = iM;
        while (iM < iN) {
            if (c3988Df0.i(iM) != z2) {
                iArr2[i2] = iArr2[i2] + 1;
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else {
                    if (MK4.d(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i3, iM};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i4 = i2 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i2] = 0;
                    i2--;
                }
                iArr2[i2] = 1;
                z2 = !z2;
            }
            iM++;
        }
        throw NotFoundException.a();
    }

    static int[] o(C3988Df0 c3988Df0) throws NotFoundException {
        int[] iArr = new int[d.length];
        int[] iArrN = null;
        boolean zP = false;
        int i = 0;
        while (!zP) {
            int[] iArr2 = d;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrN = n(c3988Df0, i, false, iArr2, iArr);
            int i2 = iArrN[0];
            int i3 = iArrN[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                zP = c3988Df0.p(i4, i2, false);
            }
            i = i3;
        }
        return iArrN;
    }

    static int q(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            int iCharAt = charSequence.charAt(i2) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw FormatException.a();
            }
            i += iCharAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 2; i4 >= 0; i4 -= 2) {
            int iCharAt2 = charSequence.charAt(i4) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw FormatException.a();
            }
            i3 += iCharAt2;
        }
        return (1000 - i3) % 10;
    }

    @Override // ir.nasim.MK4
    public X06 b(int i, C3988Df0 c3988Df0, Map map) {
        return l(i, c3988Df0, o(c3988Df0), map);
    }

    boolean g(String str) {
        return h(str);
    }

    int[] j(C3988Df0 c3988Df0, int i) {
        return m(c3988Df0, i, false, d);
    }

    protected abstract int k(C3988Df0 c3988Df0, int[] iArr, StringBuilder sb);

    public X06 l(int i, C3988Df0 c3988Df0, int[] iArr, Map map) throws NotFoundException, ChecksumException, FormatException {
        int length;
        String strC;
        if (map != null) {
            AbstractC18350oW3.a(map.get(EnumC19932rB1.NEED_RESULT_POINT_CALLBACK));
        }
        StringBuilder sb = this.a;
        sb.setLength(0);
        int[] iArrJ = j(c3988Df0, k(c3988Df0, iArr, sb));
        int i2 = iArrJ[1];
        int i3 = (i2 - iArrJ[0]) + i2;
        if (i3 >= c3988Df0.n() || !c3988Df0.p(i2, i3, false)) {
            throw NotFoundException.a();
        }
        String string = sb.toString();
        if (string.length() < 8) {
            throw FormatException.a();
        }
        if (!g(string)) {
            throw ChecksumException.a();
        }
        EnumC9549a90 enumC9549a90P = p();
        float f2 = i;
        X06 x06 = new X06(string, null, new C12092e16[]{new C12092e16((iArr[1] + iArr[0]) / 2.0f, f2), new C12092e16((iArrJ[1] + iArrJ[0]) / 2.0f, f2)}, enumC9549a90P);
        try {
            X06 x06A = this.b.a(i, c3988Df0, iArrJ[1]);
            x06.h(EnumC11449d16.UPC_EAN_EXTENSION, x06A.f());
            x06.g(x06A.d());
            x06.a(x06A.e());
            length = x06A.f().length();
        } catch (ReaderException unused) {
            length = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(EnumC19932rB1.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            for (int i4 : iArr2) {
                if (length != i4) {
                }
            }
            throw NotFoundException.a();
        }
        if ((enumC9549a90P == EnumC9549a90.EAN_13 || enumC9549a90P == EnumC9549a90.UPC_A) && (strC = this.c.c(string)) != null) {
            x06.h(EnumC11449d16.POSSIBLE_COUNTRY, strC);
        }
        return x06;
    }

    abstract EnumC9549a90 p();
}
