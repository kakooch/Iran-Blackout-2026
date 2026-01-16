package ir.nasim;

/* loaded from: classes3.dex */
public final class E22 extends AbstractC20538sA7 {
    private final int[] i = new int[4];

    @Override // ir.nasim.AbstractC20538sA7
    protected int k(C3988Df0 c3988Df0, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iN = c3988Df0.n();
        int i = iArr[1];
        for (int i2 = 0; i2 < 4 && i < iN; i2++) {
            sb.append((char) (AbstractC20538sA7.i(c3988Df0, iArr2, i, AbstractC20538sA7.g) + 48));
            for (int i3 : iArr2) {
                i += i3;
            }
        }
        int i4 = AbstractC20538sA7.m(c3988Df0, i, true, AbstractC20538sA7.e)[1];
        for (int i5 = 0; i5 < 4 && i4 < iN; i5++) {
            sb.append((char) (AbstractC20538sA7.i(c3988Df0, iArr2, i4, AbstractC20538sA7.g) + 48));
            for (int i6 : iArr2) {
                i4 += i6;
            }
        }
        return i4;
    }

    @Override // ir.nasim.AbstractC20538sA7
    EnumC9549a90 p() {
        return EnumC9549a90.EAN_8;
    }
}
