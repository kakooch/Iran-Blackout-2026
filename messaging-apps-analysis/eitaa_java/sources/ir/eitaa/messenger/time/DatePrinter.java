package ir.eitaa.messenger.time;

import java.text.FieldPosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public interface DatePrinter {
    String format(long millis);

    String format(Calendar calendar);

    String format(Date date);

    StringBuffer format(long millis, StringBuffer buf);

    StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos);

    StringBuffer format(Calendar calendar, StringBuffer buf);

    StringBuffer format(Date date, StringBuffer buf);

    Locale getLocale();

    String getPattern();

    TimeZone getTimeZone();
}
