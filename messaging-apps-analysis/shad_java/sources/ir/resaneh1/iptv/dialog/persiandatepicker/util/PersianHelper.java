package ir.resaneh1.iptv.dialog.persiandatepicker.util;

import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public class PersianHelper {
    private static char[] persianNumbers = {1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785};

    public static String toPersianNumber(String str) throws NumberFormatException {
        boolean zIsEmpty = str.isEmpty();
        String str2 = BuildConfig.FLAVOR;
        if (zIsEmpty) {
            return BuildConfig.FLAVOR;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ('0' <= cCharAt && cCharAt <= '9') {
                str2 = str2 + persianNumbers[Integer.parseInt(String.valueOf(cCharAt))];
            } else if (cCharAt == 1643) {
                str2 = str2 + (char) 1548;
            } else {
                str2 = str2 + cCharAt;
            }
        }
        return str2;
    }
}
