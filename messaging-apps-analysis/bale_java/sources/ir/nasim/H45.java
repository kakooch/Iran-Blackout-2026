package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;

/* loaded from: classes5.dex */
public abstract class H45 {
    public static String a(C45 c45, String str) {
        String strSubstring;
        String str2 = str == null ? "l j F Y H:i:s" : str;
        String[] strArr = {"a", "l", "j", TokenNames.F, "Y", "H", "i", "s", "d", "g", "n", "m", "t", "w", "y", "z", "A", TokenNames.L, TokenNames.X, TokenNames.C, TokenNames.E};
        if (("" + c45.y()).length() == 2) {
            strSubstring = "" + c45.y();
        } else {
            strSubstring = ("" + c45.y()).length() == 3 ? ("" + c45.y()).substring(2, 3) : ("" + c45.y()).substring(2, 4);
        }
        String str3 = strSubstring;
        String strZ = c45.z();
        String strJ = c45.j();
        String str4 = "" + c45.w();
        String strH = c45.H();
        String str5 = "" + c45.y();
        String strB = b("" + c45.r());
        String strB2 = b("" + c45.s());
        String strB3 = b("" + c45.v());
        String strB4 = b("" + c45.w());
        String str6 = "" + c45.r();
        String str7 = "" + c45.x();
        String strB5 = b("" + c45.x());
        StringBuilder sb = new StringBuilder();
        sb.append("");
        String str8 = str2;
        sb.append(c45.t());
        String[] strArr2 = {strZ, strJ, str4, strH, str5, strB, strB2, strB3, strB4, str6, str7, strB5, sb.toString(), "" + c45.l(), str3, "" + c45.o(), c45.A(), c45.D() ? "1" : "0", c45.a(), c45.c(), c45.e()};
        String strReplace = str8;
        for (int i = 0; i < 21; i++) {
            strReplace = strReplace.replace(strArr[i], strArr2[i]);
        }
        return strReplace;
    }

    public static String b(String str) {
        if (str.length() >= 2) {
            return str;
        }
        return "0" + str;
    }
}
