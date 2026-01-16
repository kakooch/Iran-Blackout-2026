package ir.nasim;

import com.google.zxing.NotFoundException;

/* loaded from: classes3.dex */
public final class D22 extends AbstractC20538sA7 {
    static final int[] j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] i = new int[4];

    private static void r(StringBuilder sb, int i) throws NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == j[i2]) {
                sb.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw NotFoundException.a();
    }

    @Override // ir.nasim.AbstractC20538sA7
    protected int k(C3988Df0 c3988Df0, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iN = c3988Df0.n();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 6 && i < iN; i3++) {
            int i4 = AbstractC20538sA7.i(c3988Df0, iArr2, i, AbstractC20538sA7.h);
            sb.append((char) ((i4 % 10) + 48));
            for (int i5 : iArr2) {
                i += i5;
            }
            if (i4 >= 10) {
                i2 |= 1 << (5 - i3);
            }
        }
        r(sb, i2);
        int i6 = AbstractC20538sA7.m(c3988Df0, i, true, AbstractC20538sA7.e)[1];
        for (int i7 = 0; i7 < 6 && i6 < iN; i7++) {
            sb.append((char) (AbstractC20538sA7.i(c3988Df0, iArr2, i6, AbstractC20538sA7.g) + 48));
            for (int i8 : iArr2) {
                i6 += i8;
            }
        }
        return i6;
    }

    @Override // ir.nasim.AbstractC20538sA7
    EnumC9549a90 p() {
        return EnumC9549a90.EAN_13;
    }
}
