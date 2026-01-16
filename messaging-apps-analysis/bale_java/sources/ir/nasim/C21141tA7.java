package ir.nasim;

import com.google.zxing.NotFoundException;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.tA7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C21141tA7 extends AbstractC20538sA7 {
    private static final int[] j = {1, 1, 1, 1, 1, 1};
    static final int[][] k = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] i = new int[4];

    public static String r(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case Type.TLSA /* 52 */:
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    private static void s(StringBuilder sb, int i) throws NotFoundException {
        for (int i2 = 0; i2 <= 1; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (i == k[i2][i3]) {
                    sb.insert(0, (char) (i2 + 48));
                    sb.append((char) (i3 + 48));
                    return;
                }
            }
        }
        throw NotFoundException.a();
    }

    @Override // ir.nasim.AbstractC20538sA7
    protected boolean g(String str) {
        return super.g(r(str));
    }

    @Override // ir.nasim.AbstractC20538sA7
    protected int[] j(C3988Df0 c3988Df0, int i) {
        return AbstractC20538sA7.m(c3988Df0, i, true, j);
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
        s(sb, i2);
        return i;
    }

    @Override // ir.nasim.AbstractC20538sA7
    EnumC9549a90 p() {
        return EnumC9549a90.UPC_E;
    }
}
