package io.appmetrica.analytics.billinginterface.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class Period {
    private static final Pattern a = Pattern.compile("P(\\d+)(\\S+)");
    public final int number;
    public final TimeUnit timeUnit;

    public enum TimeUnit {
        TIME_UNIT_UNKNOWN,
        DAY,
        WEEK,
        MONTH,
        YEAR
    }

    public Period(int i, TimeUnit timeUnit) {
        this.number = i;
        this.timeUnit = timeUnit;
    }

    public static Period parse(String str) {
        Matcher matcher = a.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        if (strGroup == null || strGroup2 == null) {
            return null;
        }
        try {
            int i = Integer.parseInt(strGroup);
            char cCharAt = strGroup2.charAt(0);
            return new Period(i, cCharAt != 'D' ? cCharAt != 'M' ? cCharAt != 'W' ? cCharAt != 'Y' ? TimeUnit.TIME_UNIT_UNKNOWN : TimeUnit.YEAR : TimeUnit.WEEK : TimeUnit.MONTH : TimeUnit.DAY);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Period period = (Period) obj;
        return this.number == period.number && this.timeUnit == period.timeUnit;
    }

    public int hashCode() {
        return this.timeUnit.hashCode() + (this.number * 31);
    }

    public String toString() {
        return "Period{number=" + this.number + "timeUnit=" + this.timeUnit + "}";
    }
}
