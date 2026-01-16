package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.vz5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C22889vz5 {
    private static C4705Gf0 c(C21029sz5 c21029sz5, int i, int i2, int i3) {
        C5722Ko0 c5722Ko0A = c21029sz5.a();
        if (c5722Ko0A == null) {
            throw new IllegalStateException();
        }
        int iE = c5722Ko0A.e();
        int iD = c5722Ko0A.d();
        int i4 = i3 << 1;
        int i5 = iE + i4;
        int i6 = i4 + iD;
        int iMax = Math.max(i, i5);
        int iMax2 = Math.max(i2, i6);
        int iMin = Math.min(iMax / i5, iMax2 / i6);
        int i7 = (iMax - (iE * iMin)) / 2;
        int i8 = (iMax2 - (iD * iMin)) / 2;
        C4705Gf0 c4705Gf0 = new C4705Gf0(iMax, iMax2);
        int i9 = 0;
        while (i9 < iD) {
            int i10 = 0;
            int i11 = i7;
            while (i10 < iE) {
                if (c5722Ko0A.b(i10, i9) == 1) {
                    c4705Gf0.p(i11, i8, iMin, iMin);
                }
                i10++;
                i11 += iMin;
            }
            i9++;
            i8 += iMin;
        }
        return c4705Gf0;
    }

    public C4705Gf0 a(String str, EnumC9549a90 enumC9549a90, int i, int i2) {
        return b(str, enumC9549a90, i, i2, null);
    }

    public C4705Gf0 b(String str, EnumC9549a90 enumC9549a90, int i, int i2, Map map) throws NumberFormatException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (enumC9549a90 != EnumC9549a90.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(enumC9549a90)));
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        }
        X92 x92ValueOf = X92.L;
        int i3 = 4;
        if (map != null) {
            S72 s72 = S72.ERROR_CORRECTION;
            if (map.containsKey(s72)) {
                x92ValueOf = X92.valueOf(map.get(s72).toString());
            }
            S72 s722 = S72.MARGIN;
            if (map.containsKey(s722)) {
                i3 = Integer.parseInt(map.get(s722).toString());
            }
        }
        return c(Y72.n(str, x92ValueOf, map), i, i2, i3);
    }
}
