package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class XY6 {
    public static final XY6 a = new XY6();

    private XY6() {
    }

    public static final String a(String str, char c) {
        return a.n(4, str, c);
    }

    public static final String b(String str, char c) {
        XY6 xy6 = a;
        return xy6.n(3, xy6.r(str), c);
    }

    public static /* synthetic */ String c(String str, char c, int i, Object obj) {
        if ((i & 2) != 0) {
            c = ',';
        }
        return b(str, c);
    }

    public static final String d(String str) {
        return e(c(str, (char) 0, 2, null));
    }

    public static final String e(String str) {
        if (str != null) {
            str = AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(str, "1", "۱", false, 4, null), "2", "۲", false, 4, null), "3", "۳", false, 4, null), "4", "۴", false, 4, null), "5", "۵", false, 4, null), "6", "۶", false, 4, null), "7", "۷", false, 4, null), "8", "۸", false, 4, null), "9", "۹", false, 4, null), "0", "۰", false, 4, null);
        }
        return str == null ? "" : str;
    }

    public static final String f(String str) {
        return (str == null || str.length() == 0) ? "" : e(new C20644sM5("\\b1\\b").k(str, "یک"));
    }

    public static final String g(Context context, String str) {
        AbstractC13042fc3.i(context, "context");
        return !context.getResources().getBoolean(AbstractC22999wA5.is_right_to_left) ? str == null ? "" : str : e(str);
    }

    public static final String h(String str) {
        if (str != null) {
            str = new C20644sM5("[۰٠]").k(new C20644sM5("[۹٩]").k(new C20644sM5("[۸٨]").k(new C20644sM5("[۷٧]").k(new C20644sM5("[۶٦]").k(new C20644sM5("[۵٥]").k(new C20644sM5("[۴٤]").k(new C20644sM5("[۳٣]").k(new C20644sM5("[۲٢]").k(new C20644sM5("[۱١]").k(str, "1"), "2"), "3"), "4"), "5"), "6"), "7"), "8"), "9"), "0");
        }
        return str == null ? "" : str;
    }

    public static final String i(int i) {
        if (i < 1000) {
            return "" + i;
        }
        int i2 = i / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        if (i2 < 1000) {
            String str = "" + i2;
            int i3 = i % AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
            if (i3 >= 100) {
                str = str + Separators.DOT + (i3 / 100);
            }
            return str + "k";
        }
        String str2 = "" + (i2 / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        int i4 = i % 1000000;
        if (i4 >= 100000) {
            str2 = str2 + Separators.DOT + (i4 / 100000);
        }
        return str2 + "m";
    }

    public static final String j(long j) {
        long j2 = j / 1000000000;
        if (j2 > 0) {
            String strValueOf = String.valueOf(j2);
            long j3 = j % 1000000000;
            if (j3 >= 100000000) {
                strValueOf = strValueOf + Separators.DOT + (j3 / 100000000);
            }
            return strValueOf + "g";
        }
        long j4 = j / 1000000;
        if (j4 > 0) {
            String strValueOf2 = String.valueOf(j4);
            long j5 = j % 1000000;
            if (j5 >= 100000) {
                strValueOf2 = strValueOf2 + Separators.DOT + (j5 / 100000);
            }
            return strValueOf2 + "m";
        }
        long j6 = j / 1000;
        if (j6 <= 0) {
            return String.valueOf(j);
        }
        String strValueOf3 = String.valueOf(j6);
        long j7 = j % 1000;
        if (j7 >= 100) {
            strValueOf3 = strValueOf3 + Separators.DOT + (j7 / 100);
        }
        return strValueOf3 + "k";
    }

    public static final String k(String str) {
        return AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(new C20644sM5("[^0-9]").k(h(str), ""), Separators.SP, "", false, 4, null), Separators.HT, "", false, 4, null), Separators.RETURN, "", false, 4, null);
    }

    public static final String l(String str) {
        AbstractC13042fc3.i(str, "key");
        return AbstractC20153rZ6.M(str, Separators.SP, "_", false, 4, null);
    }

    public static final boolean m(String str) {
        return str == null || str.length() == 0;
    }

    private final String n(int i, String str, char c) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        while (true) {
            length -= i;
            if (length <= 0) {
                String string = sb.toString();
                AbstractC13042fc3.h(string, "toString(...)");
                return string;
            }
            sb.insert(length, c);
        }
    }

    public static final String o(String str) {
        AbstractC13042fc3.i(str, "query");
        if (AbstractC20762sZ6.X(str, "ك", false, 2, null)) {
            str = AbstractC20153rZ6.M(str, "ك", "ک", false, 4, null);
        }
        String str2 = str;
        return AbstractC20762sZ6.X(str2, "ي", false, 2, null) ? AbstractC20153rZ6.M(str2, "ي", "ی", false, 4, null) : str2;
    }

    public static final String p(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (AbstractC20762sZ6.X(str, "://", false, 2, null)) {
            str = str.substring(AbstractC20762sZ6.l0(str, "://", 0, false, 6, null) + 3);
            AbstractC13042fc3.h(str, "substring(...)");
        }
        AbstractC13042fc3.f(str);
        if (AbstractC20762sZ6.X(str, Separators.SLASH, false, 2, null)) {
            str = str.substring(0, AbstractC20762sZ6.l0(str, Separators.SLASH, 0, false, 6, null));
            AbstractC13042fc3.h(str, "substring(...)");
        }
        if (!AbstractC20762sZ6.X(str, ":", false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, AbstractC20762sZ6.l0(str, ":", 0, false, 6, null));
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String q(String str) {
        String str2 = "";
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (Character.isDigit(cCharAt)) {
                    str2 = str2 + cCharAt;
                }
            }
        }
        return str2;
    }

    private final String r(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 < length) {
                if (str.charAt(i2) != '0' && str.charAt(i2) != 1776) {
                    i = i2;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (i == 0) {
            return str;
        }
        String strSubstring = str.substring(i);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String t(String str) {
        AbstractC13042fc3.i(str, "<this>");
        char[] charArray = str.toCharArray();
        AbstractC13042fc3.h(charArray, "toCharArray(...)");
        return AbstractC10242bK.C0(charArray, ", ", null, null, 0, null, null, 62, null);
    }

    public static final List u(String str, int i) {
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        ArrayList arrayList = new ArrayList();
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = AbstractC13042fc3.k(str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        String string = str.subSequence(i2, length + 1).toString();
        if (string.length() > 0) {
            int iCeil = (int) Math.ceil(string.length() / i);
            int i3 = 0;
            while (i3 < iCeil) {
                int i4 = i3 * i;
                i3++;
                CharSequence charSequence = new CharSequence[]{string.subSequence(i4, AbstractC23053wG5.i(i3 * i, string.length()))}[0];
                AbstractC13042fc3.g(charSequence, "null cannot be cast to non-null type kotlin.String");
                arrayList.add((String) charSequence);
            }
        }
        return arrayList;
    }

    public static final String v(String str) {
        AbstractC13042fc3.i(str, "<this>");
        return JF5.g() ? e(str) : str;
    }

    public final long s(long j) {
        long j2;
        long j3 = j / 1000000000;
        if (j3 > 0) {
            long j4 = j % 1000000000;
            j2 = (j3 * 1000000000) + (((j4 != 0 ? j4 / 100000000 : 0L) + 1) * 100000000);
            while (j2 % 6 != 0) {
                j2 += 100000000;
            }
        } else {
            long j5 = j / 1000000;
            if (j5 > 0) {
                long j6 = j % 1000000;
                j2 = (j5 * 1000000) + (((j6 != 0 ? j6 / 100000 : 0L) + 1) * 100000);
                while (j2 % 6 != 0) {
                    j2 += 100000;
                }
            } else {
                long j7 = j / 1000;
                if (j7 > 0) {
                    long j8 = j % 1000;
                    j2 = (j7 * 1000) + (((j8 != 0 ? j8 / 100 : 0L) + 1) * 100);
                    while (j2 % 6 != 0) {
                        j2 += 100;
                    }
                } else {
                    long j9 = 100;
                    long j10 = j % j9;
                    j2 = ((j / j9) * j9) + (((j10 != 0 ? j10 / 10 : 0L) + 1) * 10);
                    while (j2 % 6 != 0) {
                        j2 += 100;
                    }
                }
            }
        }
        return j2;
    }
}
