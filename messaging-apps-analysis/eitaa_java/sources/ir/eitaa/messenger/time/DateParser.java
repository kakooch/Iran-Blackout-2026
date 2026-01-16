package ir.eitaa.messenger.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public interface DateParser {
    Locale getLocale();

    String getPattern();

    TimeZone getTimeZone();

    Date parse(String source) throws ParseException;

    Date parse(String source, ParsePosition pos);

    Object parseObject(String source) throws ParseException;

    Object parseObject(String source, ParsePosition pos);
}
