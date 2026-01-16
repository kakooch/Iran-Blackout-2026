package ir.resaneh1.iptv.helper.datePicker;

/* loaded from: classes3.dex */
public class PersianCalendarUtils {
    public static long persianToJulian(long j, int i, int i2) {
        double d = j - 474;
        long jCeil = ((ceil(d, 2820.0d) + 474) - 1) * 365;
        double dCeil = ((ceil(d, 2820.0d) + 474) * 682) - 110;
        Double.isNaN(dCeil);
        long jFloor = jCeil + ((long) Math.floor(dCeil / 2816.0d)) + 1948320;
        Double.isNaN(d);
        return jFloor + (((long) Math.floor(d / 2820.0d)) * 1029983) + (i < 7 ? i * 31 : (i * 30) + 6) + i2;
    }

    public static boolean isPersianLeapYear(int i) {
        double dCeil = ceil(i - 474, 2820.0d) + 474;
        Double.isNaN(dCeil);
        return ceil((dCeil + 38.0d) * 682.0d, 2816.0d) < 682;
    }

    public static long julianToPersian(long j) {
        long jFloor;
        double d;
        double d2;
        double dPersianToJulian = j - persianToJulian(475L, 0, 1);
        long jCeil = ceil(dPersianToJulian, 1029983.0d);
        if (jCeil != 1029982) {
            double d3 = jCeil;
            Double.isNaN(d3);
            jFloor = (long) Math.floor(((d3 * 2816.0d) + 1031337.0d) / 1028522.0d);
        } else {
            jFloor = 2820;
        }
        Double.isNaN(dPersianToJulian);
        long jFloor2 = (((long) Math.floor(dPersianToJulian / 1029983.0d)) * 2820) + 474 + jFloor;
        long jPersianToJulian = (j + 1) - persianToJulian(jFloor2, 0, 1);
        if (jPersianToJulian > 186) {
            d = jPersianToJulian - 6;
            d2 = 30.0d;
        } else {
            d = jPersianToJulian;
            d2 = 31.0d;
        }
        Double.isNaN(d);
        return ((int) (j - (persianToJulian(jFloor2, (int) (Math.ceil(d / d2) - 1.0d), 1) - 1))) | (jFloor2 << 16) | (r2 << 8);
    }

    public static long ceil(double d, double d2) {
        return (long) (d - (d2 * Math.floor(d / d2)));
    }
}
