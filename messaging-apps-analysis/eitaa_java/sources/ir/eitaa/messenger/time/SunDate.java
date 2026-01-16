package ir.eitaa.messenger.time;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class SunDate {
    private static final double DEGRAD = 0.017453292519943295d;
    private static final double INV360 = 0.002777777777777778d;
    private static final double RADEG = 57.29577951308232d;

    private static long days_since_2000_Jan_0(int y, int m, int d) {
        return ((((y * 367) - (((y + ((m + 9) / 12)) * 7) / 4)) + ((m * 275) / 9)) + d) - 730530;
    }

    private static double revolution(double x) {
        return x - (Math.floor(INV360 * x) * 360.0d);
    }

    private static double rev180(double x) {
        return x - (Math.floor((INV360 * x) + 0.5d) * 360.0d);
    }

    private static double GMST0(double d) {
        return revolution((d * 0.985647352d) + 818.9874d);
    }

    private static double sind(double x) {
        return Math.sin(x * DEGRAD);
    }

    private static double cosd(double x) {
        return Math.cos(x * DEGRAD);
    }

    private static double tand(double x) {
        return Math.tan(x * DEGRAD);
    }

    private static double acosd(double x) {
        return Math.acos(x) * RADEG;
    }

    private static double atan2d(double y, double x) {
        return Math.atan2(y, x) * RADEG;
    }

    private static void sunposAtDay(double p, double[] ot, double[] d) {
        double dRevolution = revolution((0.9856002585d * p) + 356.047d);
        double d2 = (4.70935E-5d * p) + 282.9404d;
        double d3 = 0.016709d - (p * 1.151E-9d);
        double dSind = (RADEG * d3 * sind(dRevolution) * ((cosd(dRevolution) * d3) + 1.0d)) + dRevolution;
        double dCosd = cosd(dSind) - d3;
        double dSqrt = Math.sqrt(1.0d - (d3 * d3)) * sind(dSind);
        d[0] = Math.sqrt((dCosd * dCosd) + (dSqrt * dSqrt));
        ot[0] = atan2d(dSqrt, dCosd) + d2;
        if (ot[0] >= 360.0d) {
            ot[0] = ot[0] - 360.0d;
        }
    }

    private static void sun_RA_decAtDay(double d, double[] RA, double[] dec, double[] r) {
        double[] dArr = new double[1];
        sunposAtDay(d, dArr, r);
        double dCosd = r[0] * cosd(dArr[0]);
        double dSind = r[0] * sind(dArr[0]);
        double d2 = 23.4393d - (d * 3.563E-7d);
        double dCosd2 = cosd(d2) * dSind;
        double dSind2 = dSind * sind(d2);
        RA[0] = atan2d(dCosd2, dCosd);
        dec[0] = atan2d(dSind2, Math.sqrt((dCosd * dCosd) + (dCosd2 * dCosd2)));
    }

    private static int sunRiseSetHelperForYear(int year, int month, int day, double lon, double lat, double altit, int upper_limb, double[] sun) {
        int i;
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        double[] dArr3 = new double[1];
        double dDays_since_2000_Jan_0 = days_since_2000_Jan_0(year, month, day);
        Double.isNaN(dDays_since_2000_Jan_0);
        double d = (dDays_since_2000_Jan_0 + 0.5d) - (lon / 360.0d);
        double dRevolution = revolution(GMST0(d) + 180.0d + lon);
        sun_RA_decAtDay(d, dArr, dArr2, dArr3);
        double dAcosd = 12.0d;
        double dRev180 = 12.0d - (rev180(dRevolution - dArr[0]) / 15.0d);
        double dSind = (sind(upper_limb != 0 ? altit - (0.2666d / dArr3[0]) : altit) - (sind(lat) * sind(dArr2[0]))) / (cosd(lat) * cosd(dArr2[0]));
        if (dSind >= 1.0d) {
            i = -1;
            dAcosd = 0.0d;
        } else if (dSind <= -1.0d) {
            i = 1;
        } else {
            dAcosd = acosd(dSind) / 15.0d;
            i = 0;
        }
        sun[0] = dRev180 - dAcosd;
        sun[1] = dRev180 + dAcosd;
        return i;
    }

    private static int sunRiseSetForYear(int year, int month, int day, double lon, double lat, double[] sun) {
        return sunRiseSetHelperForYear(year, month, day, lon, lat, -0.5833333333333334d, 1, sun);
    }

    public static int[] calculateSunriseSunset(double lat, double lon) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        double[] dArr = new double[2];
        sunRiseSetForYear(calendar.get(1), calendar.get(2) + 1, calendar.get(5), lon, lat, dArr);
        int offset = (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000) / 60;
        int i = ((int) (dArr[0] * 60.0d)) + offset;
        int i2 = ((int) (dArr[1] * 60.0d)) + offset;
        if (i < 0) {
            i += 1440;
        } else if (i > 1440) {
            i -= 1440;
        }
        if (i2 < 0 || i2 > 1440) {
            i2 += 1440;
        }
        return new int[]{i, i2};
    }
}
