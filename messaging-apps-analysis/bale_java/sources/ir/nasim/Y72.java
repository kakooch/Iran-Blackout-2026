package ir.nasim;

import com.google.zxing.WriterException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class Y72 {
    private static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC12474eg4.values().length];
            a = iArr;
            try {
                iArr[EnumC12474eg4.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC12474eg4.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC12474eg4.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumC12474eg4.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static void a(String str, C3988Df0 c3988Df0, String str2) throws WriterException, UnsupportedEncodingException {
        try {
            for (byte b : str.getBytes(str2)) {
                c3988Df0.d(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    static void b(CharSequence charSequence, C3988Df0 c3988Df0) throws WriterException {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iP = p(charSequence.charAt(i));
            if (iP == -1) {
                throw new WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int iP2 = p(charSequence.charAt(i2));
                if (iP2 == -1) {
                    throw new WriterException();
                }
                c3988Df0.d((iP * 45) + iP2, 11);
                i += 2;
            } else {
                c3988Df0.d(iP, 6);
                i = i2;
            }
        }
    }

    static void c(String str, EnumC12474eg4 enumC12474eg4, C3988Df0 c3988Df0, String str2) throws WriterException, UnsupportedEncodingException {
        int i = a.a[enumC12474eg4.ordinal()];
        if (i == 1) {
            h(str, c3988Df0);
            return;
        }
        if (i == 2) {
            b(str, c3988Df0);
        } else if (i == 3) {
            a(str, c3988Df0, str2);
        } else {
            if (i != 4) {
                throw new WriterException("Invalid mode: ".concat(String.valueOf(enumC12474eg4)));
            }
            e(str, c3988Df0);
        }
    }

    private static void d(EnumC14686iK0 enumC14686iK0, C3988Df0 c3988Df0) {
        c3988Df0.d(EnumC12474eg4.ECI.j(), 4);
        c3988Df0.d(enumC14686iK0.p(), 8);
    }

    static void e(String str, C3988Df0 c3988Df0) throws WriterException, UnsupportedEncodingException {
        int i;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = ((bytes[i2] & 255) << 8) | (bytes[i2 + 1] & 255);
                int i4 = 33088;
                if (i3 >= 33088 && i3 <= 40956) {
                    i = i3 - i4;
                } else if (i3 < 57408 || i3 > 60351) {
                    i = -1;
                } else {
                    i4 = 49472;
                    i = i3 - i4;
                }
                if (i == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                c3988Df0.d(((i >> 8) * 192) + (i & 255), 13);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    static void f(int i, YR7 yr7, EnumC12474eg4 enumC12474eg4, C3988Df0 c3988Df0) throws WriterException {
        int iP = enumC12474eg4.p(yr7);
        int i2 = 1 << iP;
        if (i < i2) {
            c3988Df0.d(i, iP);
            return;
        }
        throw new WriterException(i + " is bigger than " + (i2 - 1));
    }

    static void g(EnumC12474eg4 enumC12474eg4, C3988Df0 c3988Df0) {
        c3988Df0.d(enumC12474eg4.j(), 4);
    }

    static void h(CharSequence charSequence, C3988Df0 c3988Df0) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iCharAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                c3988Df0.d((iCharAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    c3988Df0.d((iCharAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    c3988Df0.d(iCharAt, 4);
                }
            }
        }
    }

    private static int i(EnumC12474eg4 enumC12474eg4, C3988Df0 c3988Df0, C3988Df0 c3988Df02, YR7 yr7) {
        return c3988Df0.n() + enumC12474eg4.p(yr7) + c3988Df02.n();
    }

    private static int j(C5722Ko0 c5722Ko0) {
        return HU3.a(c5722Ko0) + HU3.c(c5722Ko0) + HU3.d(c5722Ko0) + HU3.e(c5722Ko0);
    }

    private static int k(C3988Df0 c3988Df0, X92 x92, YR7 yr7, C5722Ko0 c5722Ko0) throws WriterException {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            GV3.a(c3988Df0, x92, yr7, i3, c5722Ko0);
            int iJ = j(c5722Ko0);
            if (iJ < i) {
                i2 = i3;
                i = iJ;
            }
        }
        return i2;
    }

    private static EnumC12474eg4 l(String str, String str2) {
        if ("Shift_JIS".equals(str2) && s(str)) {
            return EnumC12474eg4.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (p(cCharAt) == -1) {
                    return EnumC12474eg4.BYTE;
                }
                z = true;
            }
        }
        return z ? EnumC12474eg4.ALPHANUMERIC : z2 ? EnumC12474eg4.NUMERIC : EnumC12474eg4.BYTE;
    }

    private static YR7 m(int i, X92 x92) throws WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            YR7 yr7I = YR7.i(i2);
            if (v(i, yr7I, x92)) {
                return yr7I;
            }
        }
        throw new WriterException("Data too big");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.nasim.C21029sz5 n(java.lang.String r6, ir.nasim.X92 r7, java.util.Map r8) throws com.google.zxing.WriterException, java.io.UnsupportedEncodingException {
        /*
            if (r8 == 0) goto Lc
            ir.nasim.S72 r0 = ir.nasim.S72.CHARACTER_SET
            boolean r0 = r8.containsKey(r0)
            if (r0 == 0) goto Lc
            r0 = 1
            goto Ld
        Lc:
            r0 = 0
        Ld:
            if (r0 == 0) goto L1a
            ir.nasim.S72 r1 = ir.nasim.S72.CHARACTER_SET
            java.lang.Object r1 = r8.get(r1)
            java.lang.String r1 = r1.toString()
            goto L1c
        L1a:
            java.lang.String r1 = "ISO-8859-1"
        L1c:
            ir.nasim.eg4 r2 = l(r6, r1)
            ir.nasim.Df0 r3 = new ir.nasim.Df0
            r3.<init>()
            ir.nasim.eg4 r4 = ir.nasim.EnumC12474eg4.BYTE
            if (r2 != r4) goto L34
            if (r0 == 0) goto L34
            ir.nasim.iK0 r0 = ir.nasim.EnumC14686iK0.a(r1)
            if (r0 == 0) goto L34
            d(r0, r3)
        L34:
            if (r8 == 0) goto L55
            ir.nasim.S72 r0 = ir.nasim.S72.GS1_FORMAT
            boolean r5 = r8.containsKey(r0)
            if (r5 == 0) goto L55
            java.lang.Object r0 = r8.get(r0)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L55
            ir.nasim.eg4 r0 = ir.nasim.EnumC12474eg4.FNC1_FIRST_POSITION
            g(r0, r3)
        L55:
            g(r2, r3)
            ir.nasim.Df0 r0 = new ir.nasim.Df0
            r0.<init>()
            c(r6, r2, r0, r1)
            if (r8 == 0) goto L8d
            ir.nasim.S72 r1 = ir.nasim.S72.QR_VERSION
            boolean r5 = r8.containsKey(r1)
            if (r5 == 0) goto L8d
            java.lang.Object r8 = r8.get(r1)
            java.lang.String r8 = r8.toString()
            int r8 = java.lang.Integer.parseInt(r8)
            ir.nasim.YR7 r8 = ir.nasim.YR7.i(r8)
            int r1 = i(r2, r3, r0, r8)
            boolean r1 = v(r1, r8, r7)
            if (r1 == 0) goto L85
            goto L91
        L85:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Data too big for requested version"
            r6.<init>(r7)
            throw r6
        L8d:
            ir.nasim.YR7 r8 = t(r7, r2, r3, r0)
        L91:
            ir.nasim.Df0 r1 = new ir.nasim.Df0
            r1.<init>()
            r1.c(r3)
            if (r2 != r4) goto La0
            int r6 = r0.o()
            goto La4
        La0:
            int r6 = r6.length()
        La4:
            f(r6, r8, r2, r1)
            r1.c(r0)
            ir.nasim.YR7$b r6 = r8.f(r7)
            int r0 = r8.h()
            int r3 = r6.d()
            int r0 = r0 - r3
            u(r0, r1)
            int r3 = r8.h()
            int r6 = r6.c()
            ir.nasim.Df0 r6 = r(r1, r3, r0, r6)
            ir.nasim.sz5 r0 = new ir.nasim.sz5
            r0.<init>()
            r0.c(r7)
            r0.f(r2)
            r0.g(r8)
            int r1 = r8.e()
            ir.nasim.Ko0 r2 = new ir.nasim.Ko0
            r2.<init>(r1, r1)
            int r1 = k(r6, r7, r8, r2)
            r0.d(r1)
            ir.nasim.GV3.a(r6, r7, r8, r1, r2)
            r0.e(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Y72.n(java.lang.String, ir.nasim.X92, java.util.Map):ir.nasim.sz5");
    }

    static byte[] o(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new ZK5(UE2.l).b(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    static int p(int i) {
        int[] iArr = a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    static void q(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 >= i3) {
            throw new WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        if (i11 != i12) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i3 != i6 + i5) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i4 < i6) {
            iArr[0] = i9;
            iArr2[0] = i11;
        } else {
            iArr[0] = i10;
            iArr2[0] = i12;
        }
    }

    static C3988Df0 r(C3988Df0 c3988Df0, int i, int i2, int i3) throws WriterException {
        if (c3988Df0.o() != i2) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        int iMax = 0;
        int iMax2 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            q(i, i2, i3, i5, iArr, iArr2);
            int i6 = iArr[0];
            byte[] bArr = new byte[i6];
            c3988Df0.u(i4 << 3, bArr, 0, i6);
            byte[] bArrO = o(bArr, iArr2[0]);
            arrayList.add(new C14298hh0(bArr, bArrO));
            iMax = Math.max(iMax, i6);
            iMax2 = Math.max(iMax2, bArrO.length);
            i4 += iArr[0];
        }
        if (i2 != i4) {
            throw new WriterException("Data bytes does not match offset");
        }
        C3988Df0 c3988Df02 = new C3988Df0();
        for (int i7 = 0; i7 < iMax; i7++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] bArrA = ((C14298hh0) it.next()).a();
                if (i7 < bArrA.length) {
                    c3988Df02.d(bArrA[i7], 8);
                }
            }
        }
        for (int i8 = 0; i8 < iMax2; i8++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] bArrB = ((C14298hh0) it2.next()).b();
                if (i8 < bArrB.length) {
                    c3988Df02.d(bArrB[i8], 8);
                }
            }
        }
        if (i == c3988Df02.o()) {
            return c3988Df02;
        }
        throw new WriterException("Interleaving error: " + i + " and " + c3988Df02.o() + " differ.");
    }

    private static boolean s(String str) throws UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static YR7 t(X92 x92, EnumC12474eg4 enumC12474eg4, C3988Df0 c3988Df0, C3988Df0 c3988Df02) {
        return m(i(enumC12474eg4, c3988Df0, c3988Df02, m(i(enumC12474eg4, c3988Df0, c3988Df02, YR7.i(1)), x92)), x92);
    }

    static void u(int i, C3988Df0 c3988Df0) throws WriterException {
        int i2 = i << 3;
        if (c3988Df0.n() > i2) {
            throw new WriterException("data bits cannot fit in the QR Code" + c3988Df0.n() + " > " + i2);
        }
        for (int i3 = 0; i3 < 4 && c3988Df0.n() < i2; i3++) {
            c3988Df0.b(false);
        }
        int iN = c3988Df0.n() & 7;
        if (iN > 0) {
            while (iN < 8) {
                c3988Df0.b(false);
                iN++;
            }
        }
        int iO = i - c3988Df0.o();
        for (int i4 = 0; i4 < iO; i4++) {
            c3988Df0.d((i4 & 1) == 0 ? 236 : 17, 8);
        }
        if (c3988Df0.n() != i2) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    private static boolean v(int i, YR7 yr7, X92 x92) {
        return yr7.h() - yr7.f(x92).d() >= (i + 7) / 8;
    }
}
