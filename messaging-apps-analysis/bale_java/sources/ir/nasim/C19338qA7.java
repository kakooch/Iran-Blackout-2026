package ir.nasim;

import com.google.zxing.NotFoundException;
import java.util.EnumMap;
import java.util.Map;

/* renamed from: ir.nasim.qA7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C19338qA7 {
    private static final int[] c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    private final int[] a = new int[4];
    private final StringBuilder b = new StringBuilder();

    C19338qA7() {
    }

    private int a(C3988Df0 c3988Df0, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iN = c3988Df0.n();
        int iM = iArr[1];
        int i = 0;
        for (int i2 = 0; i2 < 5 && iM < iN; i2++) {
            int i3 = AbstractC20538sA7.i(c3988Df0, iArr2, iM, AbstractC20538sA7.h);
            sb.append((char) ((i3 % 10) + 48));
            for (int i4 : iArr2) {
                iM += i4;
            }
            if (i3 >= 10) {
                i |= 1 << (4 - i2);
            }
            if (i2 != 4) {
                iM = c3988Df0.m(c3988Df0.l(iM));
            }
        }
        if (sb.length() != 5) {
            throw NotFoundException.a();
        }
        if (d(sb.toString()) == c(i)) {
            return iM;
        }
        throw NotFoundException.a();
    }

    private static int c(int i) throws NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == c[i2]) {
                return i2;
            }
        }
        throw NotFoundException.a();
    }

    private static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i = length - 2; i >= 0; i -= 2) {
            iCharAt += charSequence.charAt(i) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            iCharAt2 += charSequence.charAt(i2) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String e(java.lang.String r5) throws java.lang.NumberFormatException {
        /*
            r0 = 0
            char r1 = r5.charAt(r0)
            r2 = 48
            r3 = 1
            if (r1 == r2) goto L4d
            r2 = 53
            if (r1 == r2) goto L4a
            r2 = 57
            java.lang.String r4 = ""
            if (r1 == r2) goto L15
            goto L4f
        L15:
            int r1 = r5.hashCode()
            r2 = -1
            switch(r1) {
                case 54118329: goto L35;
                case 54395376: goto L2a;
                case 54395377: goto L1f;
                default: goto L1d;
            }
        L1d:
            r0 = r2
            goto L3e
        L1f:
            java.lang.String r0 = "99991"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L28
            goto L1d
        L28:
            r0 = 2
            goto L3e
        L2a:
            java.lang.String r0 = "99990"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L33
            goto L1d
        L33:
            r0 = r3
            goto L3e
        L35:
            java.lang.String r1 = "90000"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L3e
            goto L1d
        L3e:
            switch(r0) {
                case 0: goto L48;
                case 1: goto L45;
                case 2: goto L42;
                default: goto L41;
            }
        L41:
            goto L4f
        L42:
            java.lang.String r5 = "0.00"
            return r5
        L45:
            java.lang.String r5 = "Used"
            return r5
        L48:
            r5 = 0
            return r5
        L4a:
            java.lang.String r4 = "$"
            goto L4f
        L4d:
            java.lang.String r4 = "£"
        L4f:
            java.lang.String r5 = r5.substring(r3)
            int r5 = java.lang.Integer.parseInt(r5)
            int r0 = r5 / 100
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r5 = r5 % 100
            r1 = 10
            if (r5 >= r1) goto L6e
            java.lang.String r1 = "0"
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r5 = r1.concat(r5)
            goto L72
        L6e:
            java.lang.String r5 = java.lang.String.valueOf(r5)
        L72:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r0)
            r0 = 46
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19338qA7.e(java.lang.String):java.lang.String");
    }

    private static Map f(String str) {
        String strE;
        if (str.length() != 5 || (strE = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(EnumC11449d16.class);
        enumMap.put((EnumMap) EnumC11449d16.SUGGESTED_PRICE, (EnumC11449d16) strE);
        return enumMap;
    }

    X06 b(int i, C3988Df0 c3988Df0, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.b;
        sb.setLength(0);
        int iA = a(c3988Df0, iArr, sb);
        String string = sb.toString();
        Map mapF = f(string);
        float f = i;
        X06 x06 = new X06(string, null, new C12092e16[]{new C12092e16((iArr[0] + iArr[1]) / 2.0f, f), new C12092e16(iA, f)}, EnumC9549a90.UPC_EAN_EXTENSION);
        if (mapF != null) {
            x06.g(mapF);
        }
        return x06;
    }
}
