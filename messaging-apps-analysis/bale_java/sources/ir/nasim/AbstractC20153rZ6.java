package ir.nasim;

import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Comparator;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.rZ6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20153rZ6 extends AbstractC19562qZ6 {
    public static String A(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "<this>");
        return new String(bArr, C12275eL0.b);
    }

    public static boolean B(String str, String str2, boolean z) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "suffix");
        return !z ? str.endsWith(str2) : G(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean C(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return B(str, str2, z);
    }

    public static boolean D(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean E(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return D(str, str2, z);
    }

    public static Comparator F(DY6 dy6) {
        AbstractC13042fc3.i(dy6, "<this>");
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        AbstractC13042fc3.h(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    public static boolean G(String str, int i, String str2, int i2, int i3, boolean z) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "other");
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }

    public static /* synthetic */ boolean H(String str, int i, String str2, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            z = false;
        }
        return G(str, i, str2, i2, i3, z);
    }

    public static String I(CharSequence charSequence, int i) {
        AbstractC13042fc3.i(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        }
        if (i == 0) {
            return "";
        }
        int i2 = 1;
        if (i == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i];
            for (int i3 = 0; i3 < i; i3++) {
                cArr[i3] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i);
        if (1 <= i) {
            while (true) {
                sb.append(charSequence);
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        String string = sb.toString();
        AbstractC13042fc3.f(string);
        return string;
    }

    public static final String J(String str, char c, char c2, boolean z) {
        AbstractC13042fc3.i(str, "<this>");
        if (!z) {
            String strReplace = str.replace(c, c2);
            AbstractC13042fc3.h(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (AbstractC11632dL0.h(cCharAt, c, z)) {
                cCharAt = c2;
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public static String K(String str, String str2, String str3, boolean z) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "oldValue");
        AbstractC13042fc3.i(str3, "newValue");
        int i = 0;
        int iH0 = AbstractC20762sZ6.h0(str, str2, 0, z);
        if (iH0 < 0) {
            return str;
        }
        int length = str2.length();
        int iE = AbstractC23053wG5.e(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i, iH0);
            sb.append(str3);
            i = iH0 + length;
            if (iH0 >= str.length()) {
                break;
            }
            iH0 = AbstractC20762sZ6.h0(str, str2, iH0 + iE, z);
        } while (iH0 > 0);
        sb.append((CharSequence) str, i, str.length());
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String L(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return J(str, c, c2, z);
    }

    public static /* synthetic */ String M(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return K(str, str2, str3, z);
    }

    public static final String N(String str, String str2, String str3, boolean z) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "oldValue");
        AbstractC13042fc3.i(str3, "newValue");
        int iL0 = AbstractC20762sZ6.l0(str, str2, 0, z, 2, null);
        return iL0 < 0 ? str : AbstractC20762sZ6.H0(str, iL0, str2.length() + iL0, str3).toString();
    }

    public static /* synthetic */ String O(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return N(str, str2, str3, z);
    }

    public static boolean P(String str, String str2, int i, boolean z) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "prefix");
        return !z ? str.startsWith(str2, i) : G(str, i, str2, 0, str2.length(), z);
    }

    public static boolean Q(String str, String str2, boolean z) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "prefix");
        return !z ? str.startsWith(str2) : G(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean R(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return P(str, str2, i, z);
    }

    public static /* synthetic */ boolean S(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return Q(str, str2, z);
    }

    public static String t(String str) {
        AbstractC13042fc3.i(str, "<this>");
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        return u(str, locale);
    }

    public static final String u(String str, Locale locale) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(locale, CommonUrlParts.LOCALE);
        if (str.length() <= 0) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if (!Character.isLowerCase(cCharAt)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char titleCase = Character.toTitleCase(cCharAt);
        if (titleCase != Character.toUpperCase(cCharAt)) {
            sb.append(titleCase);
        } else {
            String strSubstring = str.substring(0, 1);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            AbstractC13042fc3.g(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strSubstring.toUpperCase(locale);
            AbstractC13042fc3.h(upperCase, "toUpperCase(...)");
            sb.append(upperCase);
        }
        String strSubstring2 = str.substring(1);
        AbstractC13042fc3.h(strSubstring2, "substring(...)");
        sb.append(strSubstring2);
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public static int v(String str, String str2, boolean z) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "other");
        return z ? str.compareToIgnoreCase(str2) : str.compareTo(str2);
    }

    public static String w(char[] cArr) {
        AbstractC13042fc3.i(cArr, "<this>");
        return new String(cArr);
    }

    public static String x(char[] cArr, int i, int i2) {
        AbstractC13042fc3.i(cArr, "<this>");
        AbstractC11442d1.Companion.a(i, i2, cArr.length);
        return new String(cArr, i, i2 - i);
    }

    public static boolean y(CharSequence charSequence, CharSequence charSequence2) {
        return (!(charSequence instanceof String) || charSequence2 == null) ? AbstractC20762sZ6.Y(charSequence, charSequence2) : ((String) charSequence).contentEquals(charSequence2);
    }

    public static String z(String str) {
        AbstractC13042fc3.i(str, "<this>");
        if (str.length() <= 0 || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        AbstractC13042fc3.g(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase();
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        sb.append(lowerCase);
        String strSubstring2 = str.substring(1);
        AbstractC13042fc3.h(strSubstring2, "substring(...)");
        sb.append(strSubstring2);
        return sb.toString();
    }
}
