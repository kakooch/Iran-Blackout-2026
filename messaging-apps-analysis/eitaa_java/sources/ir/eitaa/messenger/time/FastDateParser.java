package ir.eitaa.messenger.time;

import ir.eitaa.messenger.R;
import j$.util.DesugarTimeZone;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class FastDateParser implements DateParser, Serializable {
    private static final long serialVersionUID = 2;
    private final int century;
    private transient String currentFormatField;
    private final Locale locale;
    private transient Strategy nextStrategy;
    private transient Pattern parsePattern;
    private final String pattern;
    private final int startYear;
    private transient Strategy[] strategies;
    private final TimeZone timeZone;
    static final Locale JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
    private static final Pattern formatPattern = Pattern.compile("D+|E+|F+|G+|H+|K+|M+|L+|S+|W+|Z+|a+|d+|h+|k+|m+|s+|w+|y+|z+|''|'[^']++(''[^']*+)*+'|[^'A-Za-z]++");
    private static final ConcurrentMap<Locale, Strategy>[] caches = new ConcurrentMap[17];
    private static final Strategy ABBREVIATED_YEAR_STRATEGY = new NumberStrategy(1) { // from class: ir.eitaa.messenger.time.FastDateParser.1
        @Override // ir.eitaa.messenger.time.FastDateParser.NumberStrategy, ir.eitaa.messenger.time.FastDateParser.Strategy
        void setCalendar(final FastDateParser parser, final Calendar cal, final String value) throws NumberFormatException {
            int iAdjustYear = Integer.parseInt(value);
            if (iAdjustYear < 100) {
                iAdjustYear = parser.adjustYear(iAdjustYear);
            }
            cal.set(1, iAdjustYear);
        }
    };
    private static final Strategy NUMBER_MONTH_STRATEGY = new NumberStrategy(2) { // from class: ir.eitaa.messenger.time.FastDateParser.2
        @Override // ir.eitaa.messenger.time.FastDateParser.NumberStrategy
        int modify(final int iValue) {
            return iValue - 1;
        }
    };
    private static final Strategy LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
    private static final Strategy WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
    private static final Strategy WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
    private static final Strategy DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
    private static final Strategy DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
    private static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
    private static final Strategy HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
    private static final Strategy MODULO_HOUR_OF_DAY_STRATEGY = new NumberStrategy(11) { // from class: ir.eitaa.messenger.time.FastDateParser.3
        @Override // ir.eitaa.messenger.time.FastDateParser.NumberStrategy
        int modify(final int iValue) {
            return iValue % 24;
        }
    };
    private static final Strategy MODULO_HOUR_STRATEGY = new NumberStrategy(10) { // from class: ir.eitaa.messenger.time.FastDateParser.4
        @Override // ir.eitaa.messenger.time.FastDateParser.NumberStrategy
        int modify(final int iValue) {
            return iValue % 12;
        }
    };
    private static final Strategy HOUR_STRATEGY = new NumberStrategy(10);
    private static final Strategy MINUTE_STRATEGY = new NumberStrategy(12);
    private static final Strategy SECOND_STRATEGY = new NumberStrategy(13);
    private static final Strategy MILLISECOND_STRATEGY = new NumberStrategy(14);

    protected FastDateParser(final String pattern, final TimeZone timeZone, final Locale locale) {
        this(pattern, timeZone, locale, null);
    }

    protected FastDateParser(final String pattern, final TimeZone timeZone, final Locale locale, final Date centuryStart) {
        int i;
        this.pattern = pattern;
        this.timeZone = timeZone;
        this.locale = locale;
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        if (centuryStart != null) {
            calendar.setTime(centuryStart);
            i = calendar.get(1);
        } else if (locale.equals(JAPANESE_IMPERIAL)) {
            i = 0;
        } else {
            calendar.setTime(new Date());
            i = calendar.get(1) - 80;
        }
        int i2 = (i / 100) * 100;
        this.century = i2;
        this.startYear = i - i2;
        init(calendar);
    }

    private void init(Calendar definingCalendar) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        Matcher matcher = formatPattern.matcher(this.pattern);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("Illegal pattern character '" + this.pattern.charAt(matcher.regionStart()) + "'");
        }
        String strGroup = matcher.group();
        this.currentFormatField = strGroup;
        Strategy strategy = getStrategy(strGroup, definingCalendar);
        while (true) {
            matcher.region(matcher.end(), matcher.regionEnd());
            if (!matcher.lookingAt()) {
                break;
            }
            String strGroup2 = matcher.group();
            this.nextStrategy = getStrategy(strGroup2, definingCalendar);
            if (strategy.addRegex(this, sb)) {
                arrayList.add(strategy);
            }
            this.currentFormatField = strGroup2;
            strategy = this.nextStrategy;
        }
        this.nextStrategy = null;
        if (matcher.regionStart() != matcher.regionEnd()) {
            throw new IllegalArgumentException("Failed to parse \"" + this.pattern + "\" ; gave up at index " + matcher.regionStart());
        }
        if (strategy.addRegex(this, sb)) {
            arrayList.add(strategy);
        }
        this.currentFormatField = null;
        this.strategies = (Strategy[]) arrayList.toArray(new Strategy[arrayList.size()]);
        this.parsePattern = Pattern.compile(sb.toString());
    }

    @Override // ir.eitaa.messenger.time.DateParser, ir.eitaa.messenger.time.DatePrinter
    public String getPattern() {
        return this.pattern;
    }

    @Override // ir.eitaa.messenger.time.DateParser, ir.eitaa.messenger.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    @Override // ir.eitaa.messenger.time.DateParser, ir.eitaa.messenger.time.DatePrinter
    public Locale getLocale() {
        return this.locale;
    }

    Pattern getParsePattern() {
        return this.parsePattern;
    }

    public boolean equals(final Object obj) {
        if (!(obj instanceof FastDateParser)) {
            return false;
        }
        FastDateParser fastDateParser = (FastDateParser) obj;
        return this.pattern.equals(fastDateParser.pattern) && this.timeZone.equals(fastDateParser.timeZone) && this.locale.equals(fastDateParser.locale);
    }

    public int hashCode() {
        return this.pattern.hashCode() + ((this.timeZone.hashCode() + (this.locale.hashCode() * 13)) * 13);
    }

    public String toString() {
        return "FastDateParser[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + "]";
    }

    private void readObject(final ObjectInputStream in) throws ClassNotFoundException, IOException {
        in.defaultReadObject();
        init(Calendar.getInstance(this.timeZone, this.locale));
    }

    @Override // ir.eitaa.messenger.time.DateParser
    public Object parseObject(final String source) throws ParseException {
        return parse(source);
    }

    @Override // ir.eitaa.messenger.time.DateParser
    public Date parse(final String source) throws ParseException {
        Date date = parse(source, new ParsePosition(0));
        if (date != null) {
            return date;
        }
        if (this.locale.equals(JAPANESE_IMPERIAL)) {
            throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\nUnparseable date: \"" + source + "\" does not match " + this.parsePattern.pattern(), 0);
        }
        throw new ParseException("Unparseable date: \"" + source + "\" does not match " + this.parsePattern.pattern(), 0);
    }

    @Override // ir.eitaa.messenger.time.DateParser
    public Object parseObject(final String source, final ParsePosition pos) {
        return parse(source, pos);
    }

    @Override // ir.eitaa.messenger.time.DateParser
    public Date parse(final String source, final ParsePosition pos) {
        int index = pos.getIndex();
        Matcher matcher = this.parsePattern.matcher(source.substring(index));
        if (!matcher.lookingAt()) {
            return null;
        }
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        calendar.clear();
        int i = 0;
        while (true) {
            Strategy[] strategyArr = this.strategies;
            if (i < strategyArr.length) {
                int i2 = i + 1;
                strategyArr[i].setCalendar(this, calendar, matcher.group(i2));
                i = i2;
            } else {
                pos.setIndex(index + matcher.end());
                return calendar.getTime();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static StringBuilder escapeRegex(final StringBuilder regex, final String value, final boolean unquote) {
        regex.append("\\Q");
        int i = 0;
        while (i < value.length()) {
            char cCharAt = value.charAt(i);
            if (cCharAt != '\'') {
                if (cCharAt == '\\' && (i = i + 1) != value.length()) {
                    regex.append(cCharAt);
                    cCharAt = value.charAt(i);
                    if (cCharAt == 'E') {
                        regex.append("E\\\\E\\");
                        cCharAt = 'Q';
                    }
                }
            } else if (unquote) {
                i++;
                if (i == value.length()) {
                    return regex;
                }
                cCharAt = value.charAt(i);
            } else {
                continue;
            }
            regex.append(cCharAt);
            i++;
        }
        regex.append("\\E");
        return regex;
    }

    private static String[] getDisplayNameArray(int field, boolean isLong, Locale locale) {
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        if (field == 0) {
            return dateFormatSymbols.getEras();
        }
        if (field == 2) {
            return isLong ? dateFormatSymbols.getMonths() : dateFormatSymbols.getShortMonths();
        }
        if (field == 7) {
            return isLong ? dateFormatSymbols.getWeekdays() : dateFormatSymbols.getShortWeekdays();
        }
        if (field != 9) {
            return null;
        }
        return dateFormatSymbols.getAmPmStrings();
    }

    private static void insertValuesInMap(Map<String, Integer> map, String[] values) {
        if (values == null) {
            return;
        }
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null && values[i].length() > 0) {
                map.put(values[i], Integer.valueOf(i));
            }
        }
    }

    private static Map<String, Integer> getDisplayNames(int field, Locale locale) {
        HashMap map = new HashMap();
        insertValuesInMap(map, getDisplayNameArray(field, false, locale));
        insertValuesInMap(map, getDisplayNameArray(field, true, locale));
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Integer> getDisplayNames(final int field, final Calendar definingCalendar, final Locale locale) {
        return getDisplayNames(field, locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int adjustYear(final int twoDigitYear) {
        int i = this.century + twoDigitYear;
        return twoDigitYear >= this.startYear ? i : i + 100;
    }

    boolean isNextNumber() {
        Strategy strategy = this.nextStrategy;
        return strategy != null && strategy.isNumber();
    }

    int getFieldWidth() {
        return this.currentFormatField.length();
    }

    private static abstract class Strategy {
        abstract boolean addRegex(FastDateParser parser, StringBuilder regex);

        boolean isNumber() {
            return false;
        }

        void setCalendar(final FastDateParser parser, final Calendar cal, final String value) {
        }

        private Strategy() {
        }
    }

    private Strategy getStrategy(final String formatField, final Calendar definingCalendar) {
        char cCharAt = formatField.charAt(0);
        if (cCharAt == 'y') {
            return formatField.length() > 2 ? LITERAL_YEAR_STRATEGY : ABBREVIATED_YEAR_STRATEGY;
        }
        if (cCharAt != 'z') {
            switch (cCharAt) {
                case R.styleable.AppCompatTheme_buttonBarButtonStyle /* 39 */:
                    if (formatField.length() > 2) {
                        return new CopyQuotedStrategy(formatField.substring(1, formatField.length() - 1));
                    }
                    break;
                case R.styleable.AppCompatTheme_popupMenuStyle /* 83 */:
                    return MILLISECOND_STRATEGY;
                case R.styleable.AppCompatTheme_ratingBarStyleIndicator /* 87 */:
                    return WEEK_OF_MONTH_STRATEGY;
                case R.styleable.AppCompatTheme_seekBarStyle /* 90 */:
                    break;
                case R.styleable.AppCompatTheme_textAppearanceListItem /* 97 */:
                    return getLocaleSpecificStrategy(9, definingCalendar);
                case R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /* 100 */:
                    return DAY_OF_MONTH_STRATEGY;
                case R.styleable.AppCompatTheme_textColorAlertDialogListItem /* 104 */:
                    return MODULO_HOUR_STRATEGY;
                case R.styleable.AppCompatTheme_toolbarStyle /* 107 */:
                    return HOUR_OF_DAY_STRATEGY;
                case R.styleable.AppCompatTheme_tooltipFrameBackground /* 109 */:
                    return MINUTE_STRATEGY;
                case R.styleable.AppCompatTheme_windowFixedHeightMinor /* 115 */:
                    return SECOND_STRATEGY;
                case R.styleable.AppCompatTheme_windowMinWidthMinor /* 119 */:
                    return WEEK_OF_YEAR_STRATEGY;
                default:
                    switch (cCharAt) {
                        case R.styleable.AppCompatTheme_editTextStyle /* 68 */:
                            return DAY_OF_YEAR_STRATEGY;
                        case R.styleable.AppCompatTheme_homeAsUpIndicator /* 69 */:
                            return getLocaleSpecificStrategy(7, definingCalendar);
                        case R.styleable.AppCompatTheme_imageButtonStyle /* 70 */:
                            return DAY_OF_WEEK_IN_MONTH_STRATEGY;
                        case R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /* 71 */:
                            return getLocaleSpecificStrategy(0, definingCalendar);
                        case 'H':
                            return MODULO_HOUR_OF_DAY_STRATEGY;
                        default:
                            switch (cCharAt) {
                                case R.styleable.AppCompatTheme_listPreferredItemHeight /* 75 */:
                                    return HOUR_STRATEGY;
                                case R.styleable.AppCompatTheme_listPreferredItemHeightLarge /* 76 */:
                                case R.styleable.AppCompatTheme_listPreferredItemHeightSmall /* 77 */:
                                    return formatField.length() >= 3 ? getLocaleSpecificStrategy(2, definingCalendar) : NUMBER_MONTH_STRATEGY;
                            }
                    }
            }
            return new CopyQuotedStrategy(formatField);
        }
        return getLocaleSpecificStrategy(15, definingCalendar);
    }

    private static ConcurrentMap<Locale, Strategy> getCache(final int field) {
        ConcurrentMap<Locale, Strategy> concurrentMap;
        ConcurrentMap<Locale, Strategy>[] concurrentMapArr = caches;
        synchronized (concurrentMapArr) {
            if (concurrentMapArr[field] == null) {
                concurrentMapArr[field] = new ConcurrentHashMap(3);
            }
            concurrentMap = concurrentMapArr[field];
        }
        return concurrentMap;
    }

    private Strategy getLocaleSpecificStrategy(final int field, final Calendar definingCalendar) {
        ConcurrentMap<Locale, Strategy> cache = getCache(field);
        Strategy textStrategy = cache.get(this.locale);
        if (textStrategy == null) {
            if (field == 15) {
                textStrategy = new TimeZoneStrategy(this.locale);
            } else {
                textStrategy = new TextStrategy(field, definingCalendar, this.locale);
            }
            Strategy strategyPutIfAbsent = cache.putIfAbsent(this.locale, textStrategy);
            if (strategyPutIfAbsent != null) {
                return strategyPutIfAbsent;
            }
        }
        return textStrategy;
    }

    private static class CopyQuotedStrategy extends Strategy {
        private final String formatField;

        CopyQuotedStrategy(final String formatField) {
            super();
            this.formatField = formatField;
        }

        @Override // ir.eitaa.messenger.time.FastDateParser.Strategy
        boolean isNumber() {
            char cCharAt = this.formatField.charAt(0);
            if (cCharAt == '\'') {
                cCharAt = this.formatField.charAt(1);
            }
            return Character.isDigit(cCharAt);
        }

        @Override // ir.eitaa.messenger.time.FastDateParser.Strategy
        boolean addRegex(final FastDateParser parser, final StringBuilder regex) {
            FastDateParser.escapeRegex(regex, this.formatField, true);
            return false;
        }
    }

    private static class TextStrategy extends Strategy {
        private final int field;
        private final Map<String, Integer> keyValues;

        TextStrategy(final int field, final Calendar definingCalendar, final Locale locale) {
            super();
            this.field = field;
            this.keyValues = FastDateParser.getDisplayNames(field, definingCalendar, locale);
        }

        @Override // ir.eitaa.messenger.time.FastDateParser.Strategy
        boolean addRegex(final FastDateParser parser, final StringBuilder regex) {
            regex.append('(');
            Iterator<String> it = this.keyValues.keySet().iterator();
            while (it.hasNext()) {
                FastDateParser.escapeRegex(regex, it.next(), false).append('|');
            }
            regex.setCharAt(regex.length() - 1, ')');
            return true;
        }

        @Override // ir.eitaa.messenger.time.FastDateParser.Strategy
        void setCalendar(final FastDateParser parser, final Calendar cal, final String value) {
            Integer num = this.keyValues.get(value);
            if (num == null) {
                StringBuilder sb = new StringBuilder(value);
                sb.append(" not in (");
                Iterator<String> it = this.keyValues.keySet().iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(' ');
                }
                sb.setCharAt(sb.length() - 1, ')');
                throw new IllegalArgumentException(sb.toString());
            }
            cal.set(this.field, num.intValue());
        }
    }

    private static class NumberStrategy extends Strategy {
        private final int field;

        @Override // ir.eitaa.messenger.time.FastDateParser.Strategy
        boolean isNumber() {
            return true;
        }

        int modify(final int iValue) {
            return iValue;
        }

        NumberStrategy(final int field) {
            super();
            this.field = field;
        }

        @Override // ir.eitaa.messenger.time.FastDateParser.Strategy
        boolean addRegex(final FastDateParser parser, final StringBuilder regex) {
            if (parser.isNextNumber()) {
                regex.append("(\\p{Nd}{");
                regex.append(parser.getFieldWidth());
                regex.append("}+)");
                return true;
            }
            regex.append("(\\p{Nd}++)");
            return true;
        }

        @Override // ir.eitaa.messenger.time.FastDateParser.Strategy
        void setCalendar(final FastDateParser parser, final Calendar cal, final String value) {
            cal.set(this.field, modify(Integer.parseInt(value)));
        }
    }

    private static class TimeZoneStrategy extends Strategy {
        private static final int ID = 0;
        private static final int LONG_DST = 3;
        private static final int LONG_STD = 1;
        private static final int SHORT_DST = 4;
        private static final int SHORT_STD = 2;
        private final SortedMap<String, TimeZone> tzNames;
        private final String validTimeZoneChars;

        TimeZoneStrategy(final Locale locale) {
            super();
            this.tzNames = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
                if (!strArr[0].startsWith("GMT")) {
                    TimeZone timeZone = DesugarTimeZone.getTimeZone(strArr[0]);
                    if (!this.tzNames.containsKey(strArr[1])) {
                        this.tzNames.put(strArr[1], timeZone);
                    }
                    if (!this.tzNames.containsKey(strArr[2])) {
                        this.tzNames.put(strArr[2], timeZone);
                    }
                    if (timeZone.useDaylightTime()) {
                        if (!this.tzNames.containsKey(strArr[3])) {
                            this.tzNames.put(strArr[3], timeZone);
                        }
                        if (!this.tzNames.containsKey(strArr[4])) {
                            this.tzNames.put(strArr[4], timeZone);
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("(GMT[+\\-]\\d{0,1}\\d{2}|[+\\-]\\d{2}:?\\d{2}|");
            Iterator<String> it = this.tzNames.keySet().iterator();
            while (it.hasNext()) {
                FastDateParser.escapeRegex(sb, it.next(), false).append('|');
            }
            sb.setCharAt(sb.length() - 1, ')');
            this.validTimeZoneChars = sb.toString();
        }

        @Override // ir.eitaa.messenger.time.FastDateParser.Strategy
        boolean addRegex(final FastDateParser parser, final StringBuilder regex) {
            regex.append(this.validTimeZoneChars);
            return true;
        }

        @Override // ir.eitaa.messenger.time.FastDateParser.Strategy
        void setCalendar(final FastDateParser parser, final Calendar cal, final String value) {
            TimeZone timeZone;
            if (value.charAt(0) == '+' || value.charAt(0) == '-') {
                timeZone = DesugarTimeZone.getTimeZone("GMT" + value);
            } else if (value.startsWith("GMT")) {
                timeZone = DesugarTimeZone.getTimeZone(value);
            } else {
                timeZone = this.tzNames.get(value);
                if (timeZone == null) {
                    throw new IllegalArgumentException(value + " is not a supported timezone name");
                }
            }
            cal.setTimeZone(timeZone);
        }
    }
}
