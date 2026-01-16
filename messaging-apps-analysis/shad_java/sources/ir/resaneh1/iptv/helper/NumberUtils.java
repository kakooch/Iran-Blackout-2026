package ir.resaneh1.iptv.helper;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.presenters.EditTextCostPresenter;
import java.util.Locale;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes3.dex */
public class NumberUtils {
    public static int decrementIfPossibe(int i) {
        int i2 = i - 1;
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    public static long decrementIfPossibe(long j) {
        long j2 = j - 1;
        if (j2 < 0) {
            return 0L;
        }
        return j2;
    }

    public static int incrementIfPossibe(int i) {
        return i + 1;
    }

    public static long incrementIfPossibe(long j) {
        return j + 1;
    }

    public static String toPersian(int i) {
        return toPersian(i + BuildConfig.FLAVOR);
    }

    public static String toPersian(long j) {
        return toPersian(j + BuildConfig.FLAVOR);
    }

    public static String toPersian(String str) {
        String[] strArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] strArr2 = {"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"};
        if (str == null) {
            return BuildConfig.FLAVOR;
        }
        for (int i = 0; i < 10; i++) {
            if (LocaleController.getInstance().getCurrentLocale().getLanguage().equals("fa")) {
                str = str.replace(strArr[i], strArr2[i]);
            } else {
                str = str.replace(strArr2[i], strArr[i]);
            }
        }
        return str;
    }

    public static String toCuteStringWithKOrM(String str) throws NumberFormatException {
        try {
            int i = Integer.parseInt(str);
            if (i < 0) {
                i = 0;
            }
            return toCuteStringWithKOrM(i);
        } catch (Exception unused) {
            return str;
        }
    }

    public static String toCuteStringWithKOrM(int i) {
        if (i > 1000000) {
            return toPersian(String.format(Locale.getDefault(), "%.1f", Float.valueOf(i / 1000000.0f)) + "M");
        }
        if (i > 1000) {
            return toPersian(String.format(Locale.getDefault(), "%.1f", Float.valueOf(i / 1000.0f)) + "K");
        }
        return toPersian(i + BuildConfig.FLAVOR);
    }

    public static String toCuteStringWithKOrMEnglish(int i) {
        if (i > 1000000) {
            return String.format(Locale.US, "%.1f", Float.valueOf(i / 1000000.0f)) + "M";
        }
        if (i > 1000) {
            return String.format(Locale.US, "%.1f", Float.valueOf(i / 1000.0f)) + "K";
        }
        return i + BuildConfig.FLAVOR;
    }

    public static String toEnglish(String str) {
        String[] strArr = {"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"};
        String[] strArr2 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        if (str == null) {
            return BuildConfig.FLAVOR;
        }
        for (int i = 0; i < 10; i++) {
            str = str.replace(strArr[i], strArr2[i]);
        }
        return str;
    }

    public static String incrementIfPossibe(String str) {
        try {
            return (Integer.parseInt(str) + 1) + BuildConfig.FLAVOR;
        } catch (Exception unused) {
            return str;
        }
    }

    public static String decrementIfPossibe(String str) {
        try {
            int i = Integer.parseInt(str) - 1;
            if (i < 0) {
                i = 0;
            }
            return i + BuildConfig.FLAVOR;
        } catch (Exception unused) {
            return str;
        }
    }

    public static String getPriceString(long j) {
        if (j <= 0) {
            return "۰";
        }
        return getPriceString(j + BuildConfig.FLAVOR);
    }

    public static String getPriceString(String str) {
        if (str.contains(".")) {
            return toPersian(EditTextCostPresenter.setFormat(str.substring(0, str.indexOf(".")))) + toPersian(str.substring(str.indexOf(".")));
        }
        return toPersian(EditTextCostPresenter.setFormat(str));
    }

    public static String getPriceStringWithToman(long j, boolean z) {
        if (j <= 0) {
            return LocaleController.getString("free", R.string.free);
        }
        return getPriceStringWithToman(j + BuildConfig.FLAVOR, z);
    }

    public static String getPriceStringWithToman(String str, boolean z) {
        if (str.equals("0")) {
            return LocaleController.getString("free", R.string.free);
        }
        String priceString = getPriceString(str);
        if (z) {
            return priceString + " " + LocaleController.getString("toman_alias", R.string.toman_alias);
        }
        return priceString + " " + LocaleController.getString("Toman", R.string.Toman);
    }

    public static String setCommaFormat(String str) {
        return setCommaFormat(str, ",");
    }

    public static String setCommaFormat(String str, CharSequence charSequence) {
        String strSubstring = BuildConfig.FLAVOR;
        String strReplace = str.replace(charSequence, BuildConfig.FLAVOR).replace(charSequence, BuildConfig.FLAVOR);
        int i = 0;
        for (int length = strReplace.length() - 1; length >= 0; length--) {
            strSubstring = strSubstring + strReplace.charAt(length);
            i++;
            if (i == 3) {
                strSubstring = strSubstring + ((Object) charSequence);
                i = 0;
            }
        }
        if (strSubstring.length() > 3 && strSubstring.charAt(strSubstring.length() - 1) == charSequence.charAt(0)) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        return new StringBuilder(strSubstring).reverse().toString();
    }
}
