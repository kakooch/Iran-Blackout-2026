package ir.nasim;

/* renamed from: ir.nasim.mJ6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC17054mJ6 {
    public static final long a(double d, double d2, double d3, double d4, double d5) {
        double dSqrt = 2.0d * d2 * Math.sqrt(d);
        double d6 = (dSqrt * dSqrt) - (4.0d * d);
        double dSqrt2 = d6 < 0.0d ? 0.0d : Math.sqrt(d6);
        double d7 = -dSqrt;
        return d((d7 + dSqrt2) * 0.5d, (d6 < 0.0d ? Math.sqrt(Math.abs(d6)) : 0.0d) * 0.5d, (d7 - dSqrt2) * 0.5d, d2, d3, d4, d5);
    }

    public static final long b(float f, float f2, float f3, float f4, float f5) {
        if (f2 == 0.0f) {
            return 9223372036854L;
        }
        return a(f, f2, f3, f4, f5);
    }

    private static final double c(double d, double d2, double d3, double d4) {
        double d5 = d4;
        double d6 = d * d2;
        double d7 = d3 - d6;
        double dLog = Math.log(Math.abs(d5 / d2)) / d;
        double dLog2 = Math.log(Math.abs(d5 / d7));
        int i = 0;
        double dLog3 = dLog2;
        for (int i2 = 0; i2 < 6; i2++) {
            dLog3 = dLog2 - Math.log(Math.abs(dLog3 / d));
        }
        double d8 = dLog3 / d;
        if (!((Double.doubleToRawLongBits(dLog) & Long.MAX_VALUE) < 9218868437227405312L)) {
            dLog = d8;
        } else if (!(!((Double.doubleToRawLongBits(d8) & Long.MAX_VALUE) < 9218868437227405312L))) {
            dLog = Math.max(dLog, d8);
        }
        double d9 = (-(d6 + d7)) / (d * d7);
        double d10 = d * d9;
        double dExp = (Math.exp(d10) * d2) + (d7 * d9 * Math.exp(d10));
        if (Double.isNaN(d9) || d9 <= 0.0d) {
            d5 = -d5;
        } else if (d9 <= 0.0d || (-dExp) >= d5) {
            dLog = (-(2.0d / d)) - (d2 / d7);
        } else {
            if (d7 < 0.0d && d2 > 0.0d) {
                dLog = 0.0d;
            }
            d5 = -d5;
        }
        double dAbs = Double.MAX_VALUE;
        while (dAbs > 0.001d && i < 100) {
            i++;
            double d11 = d * dLog;
            double d12 = d5;
            double dExp2 = dLog - ((((d2 + (d7 * dLog)) * Math.exp(d11)) + d5) / ((((1 + d11) * d7) + d6) * Math.exp(d11)));
            dAbs = Math.abs(dLog - dExp2);
            dLog = dExp2;
            d5 = d12;
        }
        return dLog;
    }

    private static final long d(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d5;
        if (d6 == 0.0d && d8 == 0.0d) {
            return 0L;
        }
        if (d6 < 0.0d) {
            d8 = -d8;
        }
        double dAbs = Math.abs(d6);
        return (long) ((d4 > 1.0d ? e(d, d3, dAbs, d8, d7) : d4 < 1.0d ? g(d, d2, dAbs, d8, d7) : c(d, dAbs, d8, d7)) * 1000.0d);
    }

    private static final double e(double d, double d2, double d3, double d4, double d5) {
        double dLog;
        double d6;
        double d7 = d - d2;
        double d8 = ((d * d3) - d4) / d7;
        double d9 = d3 - d8;
        double dLog2 = Math.log(Math.abs(d5 / d9)) / d;
        double dLog3 = Math.log(Math.abs(d5 / d8)) / d2;
        if (!((Double.doubleToRawLongBits(dLog2) & Long.MAX_VALUE) < 9218868437227405312L)) {
            dLog = dLog3;
        } else {
            if (!(!((Double.doubleToRawLongBits(dLog3) & Long.MAX_VALUE) < 9218868437227405312L))) {
                dLog2 = Math.max(dLog2, dLog3);
            }
            dLog = dLog2;
        }
        double d10 = d9 * d;
        double dLog4 = Math.log(d10 / ((-d8) * d2)) / (d2 - d);
        if (Double.isNaN(dLog4) || dLog4 <= 0.0d) {
            d6 = -d5;
        } else if (dLog4 <= 0.0d || (-f(d9, d, dLog4, d8, d2)) >= d5) {
            dLog = Math.log((-((d8 * d2) * d2)) / (d10 * d)) / d7;
            d6 = d5;
        } else {
            if (d8 > 0.0d && d9 < 0.0d) {
                dLog = 0.0d;
            }
            d6 = -d5;
        }
        double d11 = d8 * d2;
        if (Math.abs((Math.exp(d * dLog) * d10) + (Math.exp(d2 * dLog) * d11)) < 1.0E-4d) {
            return dLog;
        }
        double d12 = Double.MAX_VALUE;
        int i = 0;
        while (d12 > 0.001d && i < 100) {
            i++;
            double d13 = d * dLog;
            double d14 = d2 * dLog;
            double dExp = dLog - ((((Math.exp(d13) * d9) + (Math.exp(d14) * d8)) + d6) / ((Math.exp(d13) * d10) + (Math.exp(d14) * d11)));
            double dAbs = Math.abs(dLog - dExp);
            dLog = dExp;
            d12 = dAbs;
        }
        return dLog;
    }

    private static final double f(double d, double d2, double d3, double d4, double d5) {
        return (d * Math.exp(d2 * d3)) + (d4 * Math.exp(d5 * d3));
    }

    private static final double g(double d, double d2, double d3, double d4, double d5) {
        double d6 = (d4 - (d * d3)) / d2;
        return Math.log(d5 / Math.sqrt((d3 * d3) + (d6 * d6))) / d;
    }
}
