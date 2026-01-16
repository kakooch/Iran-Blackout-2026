package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;

/* loaded from: classes8.dex */
public class G45 {
    private final String[] a = {"a", "l", "j", TokenNames.F, "Y", "H", "i", "s", "d", "g", "n", "m", "t", "w", "y", "z", "A", TokenNames.L, TokenNames.X, TokenNames.C, TokenNames.E, "P", "Q", TokenNames.R};
    private String b;
    private a c;
    private final String[] d;

    public enum a {
        ENGLISH,
        FARSI
    }

    public G45(String str, a aVar) {
        this.b = "l j F Y H:i:s";
        a aVar2 = a.ENGLISH;
        this.d = new String[]{"yyyy", "MM", "dd", "HH", "mm", "ss"};
        this.b = str;
        this.c = aVar;
    }

    public static String[] a(String[] strArr) {
        String[] strArr2 = {"۰", "۱", "۲", "٣", "۴", "۵", "۶", "۷", "۸", "٩"};
        String[] strArr3 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < strArr.length; i++) {
            String strReplaceAll = strArr[i];
            for (int i2 = 0; i2 < 10; i2++) {
                strReplaceAll = strReplaceAll.replaceAll(strArr3[i2], strArr2[i2]);
            }
            strArr[i] = strReplaceAll;
        }
        return strArr;
    }

    public static String c(E45 e45, String str) {
        return d(e45, str, a.ENGLISH);
    }

    public static String d(E45 e45, String str, a aVar) {
        String strSubstring;
        String str2 = str == null ? "l j F Y H:i:s" : str;
        String[] strArr = {"a", "l", "j", TokenNames.F, "Y", "H", "i", "s", "d", "g", "n", "m", "t", "w", "y", "z", "A", TokenNames.L, TokenNames.X, TokenNames.C, TokenNames.E, "P", "Q", TokenNames.R};
        if (("" + e45.L()).length() == 2) {
            strSubstring = "" + e45.L();
        } else {
            strSubstring = ("" + e45.L()).length() == 3 ? ("" + e45.L()).substring(2, 3) : ("" + e45.L()).substring(2, 4);
        }
        String str3 = strSubstring;
        String strM = e45.M();
        String strP = e45.p();
        String str4 = "" + e45.J();
        String strW = e45.W();
        String str5 = "" + e45.L();
        String strG = g("" + e45.z());
        String strG2 = g("" + e45.A());
        String strG3 = g("" + e45.I());
        String strG4 = g("" + e45.J());
        String str6 = "" + e45.u();
        String str7 = "" + e45.K();
        String strG5 = g("" + e45.K());
        StringBuilder sb = new StringBuilder();
        sb.append("");
        String str8 = str2;
        sb.append(e45.B());
        String[] strArr2 = {strM, strP, str4, strW, str5, strG, strG2, strG3, strG4, str6, str7, strG5, sb.toString(), "" + e45.r(), str3, "" + e45.w(), e45.N(), e45.Q() ? "1" : "0", e45.a(), e45.e(), e45.g(), e45.c(), e45.n(), e45.l()};
        if (aVar == a.FARSI) {
            a(strArr2);
        }
        String strReplace = str8;
        for (int i = 0; i < 24; i++) {
            strReplace = strReplace.replace(strArr[i], strArr2[i]);
        }
        return strReplace;
    }

    private String e(String str, String[] strArr, String[] strArr2) {
        for (int i = 0; i < strArr.length; i++) {
            str = str.replace(strArr[i], strArr2[i]);
        }
        return str;
    }

    private String f(String str) {
        if (str.length() >= 2) {
            return str;
        }
        return "0" + str;
    }

    public static String g(String str) {
        if (str.length() >= 2) {
            return str;
        }
        return "0" + str;
    }

    public String b(E45 e45) {
        String strSubstring;
        if (("" + e45.L()).length() == 2) {
            strSubstring = "" + e45.L();
        } else {
            if (("" + e45.L()).length() == 3) {
                strSubstring = ("" + e45.L()).substring(2, 3);
            } else {
                strSubstring = ("" + e45.L()).substring(2, 4);
            }
        }
        String str = strSubstring;
        String[] strArr = {e45.M(), e45.p(), "" + e45.J(), e45.W(), "" + e45.L(), f("" + e45.z()), f("" + e45.A()), f("" + e45.I()), f("" + e45.J()), "" + e45.u(), "" + e45.K(), f("" + e45.K()), "" + e45.B(), "" + e45.r(), str, "" + e45.w(), e45.N(), e45.Q() ? "1" : "0", e45.a(), e45.e(), e45.g(), e45.c(), e45.n(), e45.l()};
        if (this.c == a.FARSI) {
            a(strArr);
        }
        return e(this.b, this.a, strArr);
    }
}
