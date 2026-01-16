package ir.eitaa.ui.DatePicker.util;

/* loaded from: classes3.dex */
public class PersianCalendarUtils {
    public static boolean isPersianLeapYear(int persianYear) {
        double dCeil = ceil(persianYear - 474, 2820.0d) + 474;
        Double.isNaN(dCeil);
        return ceil((dCeil + 38.0d) * 682.0d, 2816.0d) < 682;
    }

    public static long ceil(double double1, double double2) {
        return (long) (double1 - (double2 * Math.floor(double1 / double2)));
    }
}
