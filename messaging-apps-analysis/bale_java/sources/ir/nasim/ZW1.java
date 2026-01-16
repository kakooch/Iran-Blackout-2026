package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes2.dex */
public final class ZW1 {
    public final int a;
    public final int b;
    public final String c;

    private ZW1(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public static ZW1 a(EW4 ew4) {
        String str;
        ew4.T(2);
        int iF = ew4.F();
        int i = iF >> 1;
        int iF2 = ((ew4.F() >> 3) & 31) | ((iF & 1) << 5);
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = "avc3";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".0");
        sb.append(i);
        sb.append(iF2 >= 10 ? Separators.DOT : ".0");
        sb.append(iF2);
        return new ZW1(i, iF2, sb.toString());
    }
}
