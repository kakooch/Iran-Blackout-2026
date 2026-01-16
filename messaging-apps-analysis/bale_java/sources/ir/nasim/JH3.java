package ir.nasim;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class JH3 {
    private static final JH3 b = a(new Locale[0]);
    private final MH3 a;

    static class a {
        private static final Locale[] a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        private static boolean b(Locale locale) {
            for (Locale locale2 : a) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        static boolean c(Locale locale, Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String strA = AbstractC24401yZ2.a(locale);
            if (!strA.isEmpty()) {
                return strA.equals(AbstractC24401yZ2.a(locale2));
            }
            String country = locale.getCountry();
            return country.isEmpty() || country.equals(locale2.getCountry());
        }
    }

    static class b {
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private JH3(MH3 mh3) {
        this.a = mh3;
    }

    public static JH3 a(Locale... localeArr) {
        return i(b.a(localeArr));
    }

    public static JH3 b(String str) {
        if (str == null || str.isEmpty()) {
            return d();
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            localeArr[i] = a.a(strArrSplit[i]);
        }
        return a(localeArr);
    }

    public static JH3 d() {
        return b;
    }

    public static JH3 i(LocaleList localeList) {
        return new JH3(new NH3(localeList));
    }

    public Locale c(int i) {
        return this.a.get(i);
    }

    public boolean e() {
        return this.a.isEmpty();
    }

    public boolean equals(Object obj) {
        return (obj instanceof JH3) && this.a.equals(((JH3) obj).a);
    }

    public int f() {
        return this.a.size();
    }

    public String g() {
        return this.a.a();
    }

    public Object h() {
        return this.a.b();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
