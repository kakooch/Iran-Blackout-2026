package io.sentry;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;

/* renamed from: io.sentry.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3141l {
    public static long a(Date date) {
        return i(date.getTime());
    }

    public static double b(Date date) {
        return j(date.getTime());
    }

    public static BigDecimal c(Double d) {
        return BigDecimal.valueOf(d.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    public static Date d() {
        return Calendar.getInstance(io.sentry.vendor.gson.internal.bind.util.a.a).getTime();
    }

    public static Date e(long j) {
        Calendar calendar = Calendar.getInstance(io.sentry.vendor.gson.internal.bind.util.a.a);
        calendar.setTimeInMillis(j);
        return calendar.getTime();
    }

    public static Date f(String str) {
        try {
            return io.sentry.vendor.gson.internal.bind.util.a.f(str, new ParsePosition(0));
        } catch (ParseException unused) {
            throw new IllegalArgumentException("timestamp is not ISO format " + str);
        }
    }

    public static Date g(String str) {
        try {
            return e(new BigDecimal(str).setScale(3, RoundingMode.DOWN).movePointRight(3).longValue());
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException("timestamp is not millis format " + str);
        }
    }

    public static String h(Date date) {
        return io.sentry.vendor.gson.internal.bind.util.a.b(date, true);
    }

    public static long i(long j) {
        return j * 1000000;
    }

    public static double j(double d) {
        return d / 1000.0d;
    }

    public static Date k(long j) {
        return e(Double.valueOf(l(j)).longValue());
    }

    public static double l(double d) {
        return d / 1000000.0d;
    }

    public static double m(long j) {
        return j / 1.0E9d;
    }

    public static long n(long j) {
        return j * 1000000000;
    }

    public static Date o(AbstractC3124h2 abstractC3124h2) {
        if (abstractC3124h2 == null) {
            return null;
        }
        return p(abstractC3124h2);
    }

    public static Date p(AbstractC3124h2 abstractC3124h2) {
        return k(abstractC3124h2.p());
    }
}
