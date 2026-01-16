package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class EB1 {
    private static final String[] b = {"CTRL_PS", Separators.SP, "A", "B", TokenNames.C, "D", TokenNames.E, TokenNames.F, "G", "H", TokenNames.I, "J", TokenNames.K, TokenNames.L, TokenNames.M, "N", TokenNames.O, "P", "Q", TokenNames.R, TokenNames.S, TokenNames.T, TokenNames.U, TokenNames.V, "W", TokenNames.X, "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] c = {"CTRL_PS", Separators.SP, "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] d = {"CTRL_PS", Separators.SP, "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", Separators.HT, Separators.RETURN, "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", Separators.AT, "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] e = {"", "\r", Separators.NEWLINE, ". ", ", ", ": ", "!", Separators.DOUBLE_QUOTE, Separators.POUND, "$", Separators.PERCENT, Separators.AND, Separators.QUOTE, Separators.LPAREN, Separators.RPAREN, Separators.STAR, "+", ",", "-", Separators.DOT, Separators.SLASH, ":", Separators.SEMICOLON, Separators.LESS_THAN, Separators.EQUALS, Separators.GREATER_THAN, Separators.QUESTION, "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] f = {"CTRL_PS", Separators.SP, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", Separators.DOT, "CTRL_UL", "CTRL_US"};
    private FV a;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private enum b {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = h(zArr, i << 3);
        }
        return bArr;
    }

    private boolean[] b(boolean[] zArr) throws FormatException {
        int i;
        UE2 ue2;
        if (this.a.d() <= 2) {
            ue2 = UE2.j;
            i = 6;
        } else {
            i = 8;
            if (this.a.d() <= 8) {
                ue2 = UE2.n;
            } else if (this.a.d() <= 22) {
                ue2 = UE2.i;
                i = 10;
            } else {
                ue2 = UE2.h;
                i = 12;
            }
        }
        int iC = this.a.c();
        int length = zArr.length / i;
        if (length < iC) {
            throw FormatException.a();
        }
        int length2 = zArr.length % i;
        int[] iArr = new int[length];
        int i2 = 0;
        while (i2 < length) {
            iArr[i2] = i(zArr, length2, i);
            i2++;
            length2 += i;
        }
        try {
            new YK5(ue2).a(iArr, length - iC);
            int i3 = 1 << i;
            int i4 = i3 - 1;
            int i5 = 0;
            for (int i6 = 0; i6 < iC; i6++) {
                int i7 = iArr[i6];
                if (i7 == 0 || i7 == i4) {
                    throw FormatException.a();
                }
                if (i7 == 1 || i7 == i3 - 2) {
                    i5++;
                }
            }
            boolean[] zArr2 = new boolean[(iC * i) - i5];
            int i8 = 0;
            for (int i9 = 0; i9 < iC; i9++) {
                int i10 = iArr[i9];
                if (i10 == 1 || i10 == i3 - 2) {
                    Arrays.fill(zArr2, i8, (i8 + i) - 1, i10 > 1);
                    i8 += i - 1;
                } else {
                    int i11 = i - 1;
                    while (i11 >= 0) {
                        int i12 = i8 + 1;
                        zArr2[i8] = ((1 << i11) & i10) != 0;
                        i11--;
                        i8 = i12;
                    }
                }
            }
            return zArr2;
        } catch (ReedSolomonException e2) {
            throw FormatException.b(e2);
        }
    }

    private boolean[] d(C4705Gf0 c4705Gf0) {
        boolean zE = this.a.e();
        int iD = this.a.d();
        int i = (zE ? 11 : 14) + (iD << 2);
        int[] iArr = new int[i];
        boolean[] zArr = new boolean[j(iD, zE)];
        int i2 = 2;
        if (zE) {
            for (int i3 = 0; i3 < i; i3++) {
                iArr[i3] = i3;
            }
        } else {
            int i4 = i / 2;
            int i5 = ((i + 1) + (((i4 - 1) / 15) * 2)) / 2;
            for (int i6 = 0; i6 < i4; i6++) {
                iArr[(i4 - i6) - 1] = (i5 - r12) - 1;
                iArr[i4 + i6] = (i6 / 15) + i6 + i5 + 1;
            }
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < iD) {
            int i9 = ((iD - i7) << i2) + (zE ? 9 : 12);
            int i10 = i7 << 1;
            int i11 = (i - 1) - i10;
            int i12 = 0;
            while (i12 < i9) {
                int i13 = i12 << 1;
                int i14 = 0;
                while (i14 < i2) {
                    int i15 = i10 + i14;
                    int i16 = i10 + i12;
                    zArr[i8 + i13 + i14] = c4705Gf0.e(iArr[i15], iArr[i16]);
                    int i17 = iArr[i16];
                    int i18 = i11 - i14;
                    zArr[(i9 * 2) + i8 + i13 + i14] = c4705Gf0.e(i17, iArr[i18]);
                    int i19 = i11 - i12;
                    zArr[(i9 * 4) + i8 + i13 + i14] = c4705Gf0.e(iArr[i18], iArr[i19]);
                    zArr[(i9 * 6) + i8 + i13 + i14] = c4705Gf0.e(iArr[i19], iArr[i15]);
                    i14++;
                    iD = iD;
                    zE = zE;
                    i2 = 2;
                }
                i12++;
                i2 = 2;
            }
            i8 += i9 << 3;
            i7++;
            i2 = 2;
        }
        return zArr;
    }

    private static String e(b bVar, int i) {
        int i2 = a.a[bVar.ordinal()];
        if (i2 == 1) {
            return b[i];
        }
        if (i2 == 2) {
            return c[i];
        }
        if (i2 == 3) {
            return d[i];
        }
        if (i2 == 4) {
            return e[i];
        }
        if (i2 == 5) {
            return f[i];
        }
        throw new IllegalStateException("Bad table");
    }

    private static String f(boolean[] zArr) {
        int length = zArr.length;
        b bVar = b.UPPER;
        StringBuilder sb = new StringBuilder(20);
        b bVarG = bVar;
        int i = 0;
        while (i < length) {
            if (bVar != b.BINARY) {
                int i2 = bVar == b.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                int i3 = i(zArr, i, i2);
                i += i2;
                String strE = e(bVar, i3);
                if (strE.startsWith("CTRL_")) {
                    bVarG = g(strE.charAt(5));
                    if (strE.charAt(6) != 'L') {
                        bVarG = bVar;
                        bVar = bVarG;
                    }
                } else {
                    sb.append(strE);
                }
                bVar = bVarG;
            } else {
                if (length - i < 5) {
                    break;
                }
                int i4 = i(zArr, i, 5);
                int i5 = i + 5;
                if (i4 == 0) {
                    if (length - i5 < 11) {
                        break;
                    }
                    i4 = i(zArr, i5, 11) + 31;
                    i5 = i + 16;
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= i4) {
                        i = i5;
                        break;
                    }
                    if (length - i5 < 8) {
                        i = length;
                        break;
                    }
                    sb.append((char) i(zArr, i5, 8));
                    i5 += 8;
                    i6++;
                }
                bVar = bVarG;
            }
        }
        return sb.toString();
    }

    private static b g(char c2) {
        return c2 != 'B' ? c2 != 'D' ? c2 != 'P' ? c2 != 'L' ? c2 != 'M' ? b.UPPER : b.MIXED : b.LOWER : b.PUNCT : b.DIGIT : b.BINARY;
    }

    private static byte h(boolean[] zArr, int i) {
        int length = zArr.length - i;
        return (byte) (length >= 8 ? i(zArr, i, 8) : i(zArr, i, length) << (8 - length));
    }

    private static int i(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static int j(int i, boolean z) {
        return ((z ? 88 : SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) + (i << 4)) * i;
    }

    public LB1 c(FV fv) throws FormatException {
        this.a = fv;
        boolean[] zArrB = b(d(fv.a()));
        LB1 lb1 = new LB1(a(zArrB), f(zArrB), null, null);
        lb1.l(zArrB.length);
        return lb1;
    }
}
