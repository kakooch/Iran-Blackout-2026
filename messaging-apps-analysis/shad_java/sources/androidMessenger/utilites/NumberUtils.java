package androidMessenger.utilites;

import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes.dex */
public class NumberUtils {
    public static String toPersian(int i) {
        return toPersian(i + BuildConfig.FLAVOR);
    }

    public static String toPersian(String str) {
        String[] strArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] strArr2 = {"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"};
        if (str == null) {
            return BuildConfig.FLAVOR;
        }
        for (int i = 0; i < 10; i++) {
            str = str.replace(strArr[i], strArr2[i]);
        }
        return str;
    }
}
