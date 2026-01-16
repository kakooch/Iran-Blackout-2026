package ir.resaneh1.iptv.helper;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/* loaded from: classes3.dex */
public class PersianCalendar implements Serializable {
    private static double len = 365.24219879d;
    private static double greg_len = 365.2425d;
    private static double greg_origin_from_jalali_base = 629964.0d;

    public static String getMonthName(int i) {
        switch (i) {
            case 1:
                return "فروردین";
            case 2:
                return "اردیبهشت";
            case 3:
                return "خرداد";
            case 4:
                return "تیر";
            case 5:
                return "مرداد";
            case 6:
                return "شهریور";
            case 7:
                return "مهر";
            case 8:
                return "آبان";
            case 9:
                return "آذر";
            case 10:
                return "دی";
            case 11:
                return "بهمن";
            case 12:
                return "اسفند";
            default:
                return BuildConfig.FLAVOR;
        }
    }

    public static String getPersianDate(int i, int i2, int i3) {
        double d = i - 1;
        double d2 = greg_len;
        Double.isNaN(d);
        double dCeil = Math.ceil(d * d2) + greg_origin_from_jalali_base + getGregDayOfYear(i, i2, i3);
        double dCeil2 = Math.ceil(dCeil / len) - 2346.0d;
        double d3 = len;
        double dFloor = Math.floor(((dCeil / d3) - Math.floor(dCeil / d3)) * 365.0d) + 1.0d;
        return String.format("%02d/%02d/%02d", Integer.valueOf(((int) dCeil2) % 100), Integer.valueOf((int) month(dFloor)), Integer.valueOf((int) dayOfMonth(dFloor)));
    }

    public static String getPersianDate4DigitYear(int i, int i2, int i3) {
        double d = i - 1;
        double d2 = greg_len;
        Double.isNaN(d);
        double dCeil = Math.ceil(d * d2) + greg_origin_from_jalali_base + getGregDayOfYear(i, i2, i3);
        double dCeil2 = Math.ceil(dCeil / len) - 2346.0d;
        double d3 = len;
        double dFloor = Math.floor(((dCeil / d3) - Math.floor(dCeil / d3)) * 365.0d) + 1.0d;
        int i4 = ((int) dCeil2) % 100;
        return String.format("%04d/%02d/%02d", Integer.valueOf((i < 2021 || i4 == 99) ? i4 + 1300 : i4 + 1400), Integer.valueOf((int) month(dFloor)), Integer.valueOf((int) dayOfMonth(dFloor)));
    }

    public static String getPersianDate(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        return getPersianDate(gregorianCalendar.get(1), gregorianCalendar.get(2) + 1, gregorianCalendar.get(5));
    }

    public static String getPersianDate4DigitYear(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        return getPersianDate4DigitYear(gregorianCalendar.get(1), gregorianCalendar.get(2) + 1, gregorianCalendar.get(5));
    }

    public static int getPersianDayOfMonth(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        int i = gregorianCalendar.get(1);
        int i2 = gregorianCalendar.get(2) + 1;
        int i3 = gregorianCalendar.get(5);
        double d = i - 1;
        double d2 = greg_len;
        Double.isNaN(d);
        double dCeil = Math.ceil(d * d2) + greg_origin_from_jalali_base + getGregDayOfYear(i, i2, i3);
        Math.ceil(dCeil / len);
        double d3 = len;
        return (int) dayOfMonth(Math.floor((((dCeil / d3) - Math.floor(dCeil / d3)) * 365.0d) + 1.0d));
    }

    private static double month(double d) {
        if (d < 186.0d) {
            return Math.ceil(d / 31.0d);
        }
        return Math.ceil((d - 186.0d) / 30.0d) + 6.0d;
    }

    private static double dayOfMonth(double d) {
        double d2;
        double d3;
        double dMonth = month(d);
        if (dMonth <= 6.0d) {
            d3 = 31.0d;
            d2 = dMonth - 1.0d;
        } else {
            d -= 186.0d;
            d2 = dMonth - 7.0d;
            d3 = 30.0d;
        }
        return d - (d2 * d3);
    }

    private static double getGregDayOfYear(double d, double d2, double d3) {
        int[] iArr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (d % 4.0d == 0.0d && d % 400.0d != 0.0d) {
            iArr[2] = 29;
        }
        int i = 0;
        for (int i2 = 0; i2 < d2; i2++) {
            i += iArr[i2];
        }
        double d4 = i;
        Double.isNaN(d4);
        return (d4 + d3) - 2.0d;
    }
}
