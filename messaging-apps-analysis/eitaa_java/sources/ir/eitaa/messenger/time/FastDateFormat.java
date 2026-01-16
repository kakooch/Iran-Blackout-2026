package ir.eitaa.messenger.time;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class FastDateFormat extends Format implements DateParser, DatePrinter {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final FormatCache<FastDateFormat> cache = new FormatCache<FastDateFormat>() { // from class: ir.eitaa.messenger.time.FastDateFormat.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.eitaa.messenger.time.FormatCache
        public FastDateFormat createInstance(final String pattern, final TimeZone timeZone, final Locale locale) {
            return new FastDateFormat(pattern, timeZone, locale);
        }
    };
    private static final long serialVersionUID = 2;
    private final FastDateParser parser;
    private final FastDatePrinter printer;

    public static FastDateFormat getInstance() {
        return (FastDateFormat) cache.getInstance();
    }

    public static FastDateFormat getInstance(final String pattern) {
        return (FastDateFormat) cache.getInstance(pattern, null, null);
    }

    public static FastDateFormat getInstance(final String pattern, final TimeZone timeZone) {
        return (FastDateFormat) cache.getInstance(pattern, timeZone, null);
    }

    public static FastDateFormat getInstance(final String pattern, final Locale locale) {
        return (FastDateFormat) cache.getInstance(pattern, null, locale);
    }

    public static FastDateFormat getInstance(final String pattern, final TimeZone timeZone, final Locale locale) {
        return (FastDateFormat) cache.getInstance(pattern, timeZone, locale);
    }

    public static FastDateFormat getDateInstance(final int style) {
        return (FastDateFormat) cache.getDateInstance(style, null, null);
    }

    public static FastDateFormat getDateInstance(final int style, final Locale locale) {
        return (FastDateFormat) cache.getDateInstance(style, null, locale);
    }

    public static FastDateFormat getDateInstance(final int style, final TimeZone timeZone) {
        return (FastDateFormat) cache.getDateInstance(style, timeZone, null);
    }

    public static FastDateFormat getDateInstance(final int style, final TimeZone timeZone, final Locale locale) {
        return (FastDateFormat) cache.getDateInstance(style, timeZone, locale);
    }

    public static FastDateFormat getTimeInstance(final int style) {
        return (FastDateFormat) cache.getTimeInstance(style, null, null);
    }

    public static FastDateFormat getTimeInstance(final int style, final Locale locale) {
        return (FastDateFormat) cache.getTimeInstance(style, null, locale);
    }

    public static FastDateFormat getTimeInstance(final int style, final TimeZone timeZone) {
        return (FastDateFormat) cache.getTimeInstance(style, timeZone, null);
    }

    public static FastDateFormat getTimeInstance(final int style, final TimeZone timeZone, final Locale locale) {
        return (FastDateFormat) cache.getTimeInstance(style, timeZone, locale);
    }

    public static FastDateFormat getDateTimeInstance(final int dateStyle, final int timeStyle) {
        return (FastDateFormat) cache.getDateTimeInstance(dateStyle, timeStyle, (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getDateTimeInstance(final int dateStyle, final int timeStyle, final Locale locale) {
        return (FastDateFormat) cache.getDateTimeInstance(dateStyle, timeStyle, (TimeZone) null, locale);
    }

    public static FastDateFormat getDateTimeInstance(final int dateStyle, final int timeStyle, final TimeZone timeZone) {
        return getDateTimeInstance(dateStyle, timeStyle, timeZone, null);
    }

    public static FastDateFormat getDateTimeInstance(final int dateStyle, final int timeStyle, final TimeZone timeZone, final Locale locale) {
        return (FastDateFormat) cache.getDateTimeInstance(dateStyle, timeStyle, timeZone, locale);
    }

    protected FastDateFormat(final String pattern, final TimeZone timeZone, final Locale locale) {
        this(pattern, timeZone, locale, null);
    }

    protected FastDateFormat(final String pattern, final TimeZone timeZone, final Locale locale, final Date centuryStart) {
        this.printer = new FastDatePrinter(pattern, timeZone, locale);
        this.parser = new FastDateParser(pattern, timeZone, locale, centuryStart);
    }

    @Override // java.text.Format, ir.eitaa.messenger.time.DatePrinter
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        return this.printer.format(obj, toAppendTo, pos);
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public String format(final long millis) {
        return this.printer.format(millis);
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public String format(final Date date) {
        return this.printer.format(date);
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public String format(final Calendar calendar) {
        return this.printer.format(calendar);
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public StringBuffer format(final long millis, final StringBuffer buf) {
        return this.printer.format(millis, buf);
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public StringBuffer format(final Date date, final StringBuffer buf) {
        return this.printer.format(date, buf);
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public StringBuffer format(final Calendar calendar, final StringBuffer buf) {
        return this.printer.format(calendar, buf);
    }

    @Override // ir.eitaa.messenger.time.DateParser
    public Date parse(final String source) throws ParseException {
        return this.parser.parse(source);
    }

    @Override // ir.eitaa.messenger.time.DateParser
    public Date parse(final String source, final ParsePosition pos) {
        return this.parser.parse(source, pos);
    }

    @Override // java.text.Format, ir.eitaa.messenger.time.DateParser
    public Object parseObject(final String source, final ParsePosition pos) {
        return this.parser.parseObject(source, pos);
    }

    @Override // ir.eitaa.messenger.time.DateParser, ir.eitaa.messenger.time.DatePrinter
    public String getPattern() {
        return this.printer.getPattern();
    }

    @Override // ir.eitaa.messenger.time.DateParser, ir.eitaa.messenger.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.printer.getTimeZone();
    }

    @Override // ir.eitaa.messenger.time.DateParser, ir.eitaa.messenger.time.DatePrinter
    public Locale getLocale() {
        return this.printer.getLocale();
    }

    public int getMaxLengthEstimate() {
        return this.printer.getMaxLengthEstimate();
    }

    public boolean equals(final Object obj) {
        if (obj instanceof FastDateFormat) {
            return this.printer.equals(((FastDateFormat) obj).printer);
        }
        return false;
    }

    public int hashCode() {
        return this.printer.hashCode();
    }

    public String toString() {
        return "FastDateFormat[" + this.printer.getPattern() + "," + this.printer.getLocale() + "," + this.printer.getTimeZone().getID() + "]";
    }

    protected StringBuffer applyRules(final Calendar calendar, final StringBuffer buf) {
        return this.printer.applyRules(calendar, buf);
    }
}
