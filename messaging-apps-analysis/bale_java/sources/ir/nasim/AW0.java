package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Arrays;
import java.util.Map;
import okhttp3.internal.http.StatusLine;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
public final class AW0 extends MK4 {
    private static final char[] c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    static final int[] d;
    private static final int e;
    private final StringBuilder a = new StringBuilder(20);
    private final int[] b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, StatusLine.HTTP_PERM_REDIRECT, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, SetRpcStruct$ComposedRpc.PIN_MESSAGE_FIELD_NUMBER, 306, 350};
        d = iArr;
        e = iArr[47];
    }

    private static void g(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        h(charSequence, length - 2, 20);
        h(charSequence, length - 1, 15);
    }

    private static void h(CharSequence charSequence, int i, int i2) throws ChecksumException {
        int iIndexOf = 0;
        int i3 = 1;
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i4)) * i3;
            i3++;
            if (i3 > i2) {
                i3 = 1;
            }
        }
        if (charSequence.charAt(i) != c[iIndexOf % 47]) {
            throw ChecksumException.a();
        }
    }

    private static String i(CharSequence charSequence) throws FormatException {
        int i;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt < 'a' || cCharAt > 'd') {
                sb.append(cCharAt);
            } else {
                if (i2 >= length - 1) {
                    throw FormatException.a();
                }
                i2++;
                char cCharAt2 = charSequence.charAt(i2);
                switch (cCharAt) {
                    case WKSRecord.Service.SWIFT_RVF /* 97 */:
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'Z') {
                            i = cCharAt2 - '@';
                            c2 = (char) i;
                            sb.append(c2);
                            break;
                        } else {
                            throw FormatException.a();
                        }
                        break;
                    case 'b':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                            i = cCharAt2 - '&';
                        } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                            i = cCharAt2 - 11;
                        } else if (cCharAt2 >= 'K' && cCharAt2 <= 'O') {
                            i = cCharAt2 + 16;
                        } else if (cCharAt2 >= 'P' && cCharAt2 <= 'S') {
                            i = cCharAt2 + '+';
                        } else if (cCharAt2 >= 'T' && cCharAt2 <= 'Z') {
                            c2 = 127;
                            sb.append(c2);
                            break;
                        } else {
                            throw FormatException.a();
                        }
                        c2 = (char) i;
                        sb.append(c2);
                        break;
                    case 'c':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                            i = cCharAt2 - ' ';
                            c2 = (char) i;
                            sb.append(c2);
                        } else {
                            if (cCharAt2 != 'Z') {
                                throw FormatException.a();
                            }
                            c2 = ':';
                            sb.append(c2);
                            break;
                        }
                    case 'd':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'Z') {
                            i = cCharAt2 + ' ';
                            c2 = (char) i;
                            sb.append(c2);
                            break;
                        } else {
                            throw FormatException.a();
                        }
                    default:
                        c2 = 0;
                        sb.append(c2);
                        break;
                }
            }
            i2++;
        }
        return sb.toString();
    }

    private int[] j(C3988Df0 c3988Df0) throws NotFoundException {
        int iN = c3988Df0.n();
        int iL = c3988Df0.l(0);
        Arrays.fill(this.b, 0);
        int[] iArr = this.b;
        int length = iArr.length;
        boolean z = false;
        int i = 0;
        int i2 = iL;
        while (iL < iN) {
            if (c3988Df0.i(iL) != z) {
                iArr[i] = iArr[i] + 1;
            } else {
                if (i != length - 1) {
                    i++;
                } else {
                    if (l(iArr) == e) {
                        return new int[]{i2, iL};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i3 = i - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i3);
                    iArr[i3] = 0;
                    iArr[i] = 0;
                    i--;
                }
                iArr[i] = 1;
                z = !z;
            }
            iL++;
        }
        throw NotFoundException.a();
    }

    private static char k(int i) throws NotFoundException {
        int i2 = 0;
        while (true) {
            int[] iArr = d;
            if (i2 >= iArr.length) {
                throw NotFoundException.a();
            }
            if (iArr[i2] == i) {
                return c[i2];
            }
            i2++;
        }
    }

    private static int l(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int iRound = Math.round((iArr[i4] * 9.0f) / i);
            if (iRound <= 0 || iRound > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                for (int i5 = 0; i5 < iRound; i5++) {
                    i3 = (i3 << 1) | 1;
                }
            } else {
                i3 <<= iRound;
            }
        }
        return i3;
    }

    @Override // ir.nasim.MK4
    public X06 b(int i, C3988Df0 c3988Df0, Map map) throws NotFoundException, ChecksumException {
        int iL = c3988Df0.l(j(c3988Df0)[1]);
        int iN = c3988Df0.n();
        int[] iArr = this.b;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.a;
        sb.setLength(0);
        while (true) {
            MK4.e(c3988Df0, iL, iArr);
            int iL2 = l(iArr);
            if (iL2 < 0) {
                throw NotFoundException.a();
            }
            char cK = k(iL2);
            sb.append(cK);
            int i2 = iL;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int iL3 = c3988Df0.l(i2);
            if (cK == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                if (iL3 == iN || !c3988Df0.i(iL3)) {
                    throw NotFoundException.a();
                }
                if (sb.length() < 2) {
                    throw NotFoundException.a();
                }
                g(sb);
                sb.setLength(sb.length() - 2);
                float f = i;
                return new X06(i(sb), null, new C12092e16[]{new C12092e16((r14[1] + r14[0]) / 2.0f, f), new C12092e16(iL + (i4 / 2.0f), f)}, EnumC9549a90.CODE_93);
            }
            iL = iL3;
        }
    }
}
