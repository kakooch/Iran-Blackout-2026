package ir.nasim;

import com.google.zxing.NotFoundException;
import java.util.EnumMap;
import java.util.Map;

/* renamed from: ir.nasim.pA7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C18747pA7 {
    private final int[] a = new int[4];
    private final StringBuilder b = new StringBuilder();

    C18747pA7() {
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
        for (int i2 = 0; i2 < 2 && iM < iN; i2++) {
            int i3 = AbstractC20538sA7.i(c3988Df0, iArr2, iM, AbstractC20538sA7.h);
            sb.append((char) ((i3 % 10) + 48));
            for (int i4 : iArr2) {
                iM += i4;
            }
            if (i3 >= 10) {
                i |= 1 << (1 - i2);
            }
            if (i2 != 1) {
                iM = c3988Df0.m(c3988Df0.l(iM));
            }
        }
        if (sb.length() != 2) {
            throw NotFoundException.a();
        }
        if (Integer.parseInt(sb.toString()) % 4 == i) {
            return iM;
        }
        throw NotFoundException.a();
    }

    private static Map c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(EnumC11449d16.class);
        enumMap.put((EnumMap) EnumC11449d16.ISSUE_NUMBER, (EnumC11449d16) Integer.valueOf(str));
        return enumMap;
    }

    X06 b(int i, C3988Df0 c3988Df0, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.b;
        sb.setLength(0);
        int iA = a(c3988Df0, iArr, sb);
        String string = sb.toString();
        Map mapC = c(string);
        float f = i;
        X06 x06 = new X06(string, null, new C12092e16[]{new C12092e16((iArr[0] + iArr[1]) / 2.0f, f), new C12092e16(iA, f)}, EnumC9549a90.UPC_EAN_EXTENSION);
        if (mapC != null) {
            x06.g(mapC);
        }
        return x06;
    }
}
