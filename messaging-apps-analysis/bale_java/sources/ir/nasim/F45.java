package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;

/* loaded from: classes6.dex */
public abstract class F45 {
    public static String a(D45 d45, String str) {
        String strSubstring;
        String str2 = str == null ? "l j F Y H:i:s" : str;
        String[] strArr = {"a", "l", "j", TokenNames.F, "Y", "H", "i", "s", "d", "g", "n", "m", "t", "w", "y", "z", "A", TokenNames.L, TokenNames.X, TokenNames.C, TokenNames.E};
        if (("" + d45.C()).length() == 2) {
            strSubstring = "" + d45.C();
        } else {
            strSubstring = ("" + d45.C()).length() == 3 ? ("" + d45.C()).substring(2, 3) : ("" + d45.C()).substring(2, 4);
        }
        String str3 = strSubstring;
        String strD = d45.D();
        String strM = d45.m();
        String str4 = "" + d45.A();
        String strM2 = d45.M();
        String str5 = "" + d45.C();
        String strB = b("" + d45.u());
        String strB2 = b("" + d45.v());
        String strB3 = b("" + d45.z());
        String strB4 = b("" + d45.A());
        String str6 = "" + d45.u();
        String str7 = "" + d45.B();
        String strB5 = b("" + d45.B());
        StringBuilder sb = new StringBuilder();
        sb.append("");
        String str8 = str2;
        sb.append(d45.w());
        String[] strArr2 = {strD, strM, str4, strM2, str5, strB, strB2, strB3, strB4, str6, str7, strB5, sb.toString(), "" + d45.o(), str3, "" + d45.r(), d45.F(), d45.I() ? "1" : "0", d45.a(), d45.c(), d45.e()};
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
