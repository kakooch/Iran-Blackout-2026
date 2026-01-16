package ir.hamsaa.persiandatepicker.util;

/* loaded from: classes3.dex */
public class PersianCalendarUtils {
    public static boolean isPersianLeapYear(int i) {
        double dCeil = ceil(i - 474, 2820.0d) + 474;
        Double.isNaN(dCeil);
        return ceil((dCeil + 38.0d) * 682.0d, 2816.0d) < 682;
    }

    public static long ceil(double d, double d2) {
        return (long) (d - (d2 * Math.floor(d / d2)));
    }
}
