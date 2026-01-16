package ir.eitaa.messenger.time;

import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public class FastDatePrinter implements DatePrinter, Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    private static final long serialVersionUID = 1;
    private final Locale mLocale;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;

    private interface NumberRule extends Rule {
        void appendTo(StringBuffer buffer, int value);
    }

    private interface Rule {
        void appendTo(StringBuffer buffer, Calendar calendar);

        int estimateLength();
    }

    protected FastDatePrinter(final String pattern, final TimeZone timeZone, final Locale locale) {
        this.mPattern = pattern;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    private void init() {
        List<Rule> pattern = parsePattern();
        Rule[] ruleArr = (Rule[]) pattern.toArray(new Rule[pattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int iEstimateLength = 0;
        while (true) {
            length--;
            if (length >= 0) {
                iEstimateLength += this.mRules[length].estimateLength();
            } else {
                this.mMaxLengthEstimate = iEstimateLength;
                return;
            }
        }
    }

    protected List<Rule> parsePattern() {
        Rule ruleSelectNumberRule;
        Rule timeZoneNameRule;
        Rule timeZoneNameRule2;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.mPattern.length();
        int[] iArr = new int[1];
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            iArr[i] = i2;
            String token = parseToken(this.mPattern, iArr);
            int i3 = iArr[i];
            int length2 = token.length();
            if (length2 == 0) {
                return arrayList;
            }
            char cCharAt = token.charAt(i);
            if (cCharAt != 'y') {
                if (cCharAt != 'z') {
                    switch (cCharAt) {
                        case R.styleable.AppCompatTheme_buttonBarButtonStyle /* 39 */:
                            String strSubstring = token.substring(1);
                            if (strSubstring.length() == 1) {
                                timeZoneNameRule2 = new CharacterLiteral(strSubstring.charAt(0));
                                break;
                            } else {
                                timeZoneNameRule2 = new StringLiteral(strSubstring);
                                break;
                            }
                        case R.styleable.AppCompatTheme_popupMenuStyle /* 83 */:
                            ruleSelectNumberRule = selectNumberRule(14, length2);
                            break;
                        case R.styleable.AppCompatTheme_ratingBarStyleIndicator /* 87 */:
                            ruleSelectNumberRule = selectNumberRule(4, length2);
                            break;
                        case R.styleable.AppCompatTheme_seekBarStyle /* 90 */:
                            if (length2 == 1) {
                                ruleSelectNumberRule = TimeZoneNumberRule.INSTANCE_NO_COLON;
                            } else {
                                ruleSelectNumberRule = TimeZoneNumberRule.INSTANCE_COLON;
                            }
                            break;
                        case R.styleable.AppCompatTheme_textAppearanceListItem /* 97 */:
                            timeZoneNameRule2 = new TextField(9, amPmStrings);
                            break;
                        case R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /* 100 */:
                            timeZoneNameRule2 = selectNumberRule(5, length2);
                            break;
                        case R.styleable.AppCompatTheme_textColorAlertDialogListItem /* 104 */:
                            timeZoneNameRule2 = new TwelveHourField(selectNumberRule(10, length2));
                            break;
                        case R.styleable.AppCompatTheme_toolbarStyle /* 107 */:
                            timeZoneNameRule2 = new TwentyFourHourField(selectNumberRule(11, length2));
                            break;
                        case R.styleable.AppCompatTheme_tooltipFrameBackground /* 109 */:
                            timeZoneNameRule2 = selectNumberRule(12, length2);
                            break;
                        case R.styleable.AppCompatTheme_windowFixedHeightMinor /* 115 */:
                            timeZoneNameRule2 = selectNumberRule(13, length2);
                            break;
                        case R.styleable.AppCompatTheme_windowMinWidthMinor /* 119 */:
                            timeZoneNameRule2 = selectNumberRule(3, length2);
                            break;
                        default:
                            switch (cCharAt) {
                                case R.styleable.AppCompatTheme_editTextStyle /* 68 */:
                                    timeZoneNameRule2 = selectNumberRule(6, length2);
                                    break;
                                case R.styleable.AppCompatTheme_homeAsUpIndicator /* 69 */:
                                    timeZoneNameRule2 = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                                    break;
                                case R.styleable.AppCompatTheme_imageButtonStyle /* 70 */:
                                    timeZoneNameRule2 = selectNumberRule(8, length2);
                                    break;
                                case R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /* 71 */:
                                    timeZoneNameRule2 = new TextField(0, eras);
                                    break;
                                case 'H':
                                    timeZoneNameRule2 = selectNumberRule(11, length2);
                                    break;
                                default:
                                    switch (cCharAt) {
                                        case R.styleable.AppCompatTheme_listPreferredItemHeight /* 75 */:
                                            timeZoneNameRule2 = selectNumberRule(10, length2);
                                            break;
                                        case R.styleable.AppCompatTheme_listPreferredItemHeightLarge /* 76 */:
                                            if (length2 < 4) {
                                                if (length2 != 3) {
                                                    if (length2 == 2) {
                                                        timeZoneNameRule2 = TwoDigitMonthField.INSTANCE;
                                                        break;
                                                    } else {
                                                        timeZoneNameRule2 = UnpaddedMonthField.INSTANCE;
                                                        break;
                                                    }
                                                } else {
                                                    timeZoneNameRule2 = new TextField(2, shortMonths);
                                                    break;
                                                }
                                            } else {
                                                timeZoneNameRule2 = new TextField(2, months);
                                                break;
                                            }
                                        case R.styleable.AppCompatTheme_listPreferredItemHeightSmall /* 77 */:
                                            if (length2 < 4) {
                                                if (length2 != 3) {
                                                    if (length2 == 2) {
                                                        timeZoneNameRule2 = TwoDigitMonthField.INSTANCE;
                                                        break;
                                                    } else {
                                                        timeZoneNameRule2 = UnpaddedMonthField.INSTANCE;
                                                        break;
                                                    }
                                                } else {
                                                    timeZoneNameRule2 = new TextField(2, shortMonths);
                                                    break;
                                                }
                                            } else {
                                                timeZoneNameRule2 = new TextField(2, months);
                                                break;
                                            }
                                        default:
                                            throw new IllegalArgumentException("Illegal pattern component: " + token);
                                    }
                            }
                    }
                } else if (length2 >= 4) {
                    timeZoneNameRule2 = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 1);
                } else {
                    timeZoneNameRule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 0);
                    ruleSelectNumberRule = timeZoneNameRule;
                }
                ruleSelectNumberRule = timeZoneNameRule2;
            } else if (length2 == 2) {
                timeZoneNameRule = TwoDigitYearField.INSTANCE;
                ruleSelectNumberRule = timeZoneNameRule;
            } else {
                if (length2 < 4) {
                    length2 = 4;
                }
                ruleSelectNumberRule = selectNumberRule(1, length2);
            }
            arrayList.add(ruleSelectNumberRule);
            i2 = i3 + 1;
            i = 0;
        }
        return arrayList;
    }

    protected String parseToken(final String pattern, final int[] indexRef) {
        StringBuilder sb = new StringBuilder();
        int i = indexRef[0];
        int length = pattern.length();
        char cCharAt = pattern.charAt(i);
        if ((cCharAt >= 'A' && cCharAt <= 'Z') || (cCharAt >= 'a' && cCharAt <= 'z')) {
            sb.append(cCharAt);
            while (true) {
                int i2 = i + 1;
                if (i2 >= length || pattern.charAt(i2) != cCharAt) {
                    break;
                }
                sb.append(cCharAt);
                i = i2;
            }
        } else {
            sb.append('\'');
            boolean z = false;
            while (i < length) {
                char cCharAt2 = pattern.charAt(i);
                if (cCharAt2 != '\'') {
                    if (!z && ((cCharAt2 >= 'A' && cCharAt2 <= 'Z') || (cCharAt2 >= 'a' && cCharAt2 <= 'z'))) {
                        i--;
                        break;
                    }
                    sb.append(cCharAt2);
                } else {
                    int i3 = i + 1;
                    if (i3 >= length || pattern.charAt(i3) != '\'') {
                        z = !z;
                    } else {
                        sb.append(cCharAt2);
                        i = i3;
                    }
                }
                i++;
            }
        }
        indexRef[0] = i;
        return sb.toString();
    }

    protected NumberRule selectNumberRule(final int field, final int padding) {
        if (padding == 1) {
            return new UnpaddedNumberField(field);
        }
        if (padding == 2) {
            return new TwoDigitNumberField(field);
        }
        return new PaddedNumberField(field, padding);
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        if (obj instanceof Date) {
            return format((Date) obj, toAppendTo);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, toAppendTo);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), toAppendTo);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown class: ");
        sb.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public String format(final long millis) {
        GregorianCalendar gregorianCalendarNewCalendar = newCalendar();
        gregorianCalendarNewCalendar.setTimeInMillis(millis);
        if (LocaleController.isRTL) {
            return applyRulesToString(gregorianCalendarNewCalendar).replaceAll("0", "٠").replaceAll("1", "١").replaceAll("2", "٢").replaceAll("3", "٣").replaceAll("4", "٤").replaceAll("5", "٥").replaceAll("6", "٦").replaceAll("7", "٧").replaceAll("8", "٨").replaceAll("9", "٩");
        }
        return applyRulesToString(gregorianCalendarNewCalendar);
    }

    private String applyRulesToString(final Calendar c) {
        return applyRules(c, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    private GregorianCalendar newCalendar() {
        return new GregorianCalendar(this.mTimeZone, this.mLocale);
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public String format(final Date date) {
        GregorianCalendar gregorianCalendarNewCalendar = newCalendar();
        gregorianCalendarNewCalendar.setTime(date);
        return applyRulesToString(gregorianCalendarNewCalendar);
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public String format(final Calendar calendar) {
        return format(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public StringBuffer format(final long millis, final StringBuffer buf) {
        return format(new Date(millis), buf);
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public StringBuffer format(final Date date, final StringBuffer buf) {
        GregorianCalendar gregorianCalendarNewCalendar = newCalendar();
        gregorianCalendarNewCalendar.setTime(date);
        return applyRules(gregorianCalendarNewCalendar, buf);
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public StringBuffer format(final Calendar calendar, final StringBuffer buf) {
        return applyRules(calendar, buf);
    }

    protected StringBuffer applyRules(final Calendar calendar, final StringBuffer buf) {
        for (Rule rule : this.mRules) {
            rule.appendTo(buf, calendar);
        }
        return buf;
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public String getPattern() {
        return this.mPattern;
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    @Override // ir.eitaa.messenger.time.DatePrinter
    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public boolean equals(final Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        return this.mPattern.equals(fastDatePrinter.mPattern) && this.mTimeZone.equals(fastDatePrinter.mTimeZone) && this.mLocale.equals(fastDatePrinter.mLocale);
    }

    public int hashCode() {
        return this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    public String toString() {
        return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
    }

    private void readObject(final ObjectInputStream in) throws ClassNotFoundException, IOException {
        in.defaultReadObject();
        init();
    }

    private static class CharacterLiteral implements Rule {
        private final char mValue;

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 1;
        }

        CharacterLiteral(final char value) {
            this.mValue = value;
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public void appendTo(final StringBuffer buffer, final Calendar calendar) {
            buffer.append(this.mValue);
        }
    }

    private static class StringLiteral implements Rule {
        private final String mValue;

        StringLiteral(final String value) {
            this.mValue = value;
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mValue.length();
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public void appendTo(final StringBuffer buffer, final Calendar calendar) {
            buffer.append(this.mValue);
        }
    }

    private static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        TextField(final int field, final String[] values) {
            this.mField = field;
            this.mValues = values;
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public int estimateLength() {
            int length = this.mValues.length;
            int i = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i;
                }
                int length2 = this.mValues[length].length();
                if (length2 > i) {
                    i = length2;
                }
            }
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public void appendTo(final StringBuffer buffer, final Calendar calendar) {
            buffer.append(this.mValues[calendar.get(this.mField)]);
        }
    }

    private static class UnpaddedNumberField implements NumberRule {
        private final int mField;

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 4;
        }

        UnpaddedNumberField(final int field) {
            this.mField = field;
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public void appendTo(final StringBuffer buffer, final Calendar calendar) {
            appendTo(buffer, calendar.get(this.mField));
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.NumberRule
        public final void appendTo(final StringBuffer buffer, final int value) {
            if (value < 10) {
                buffer.append((char) (value + 48));
            } else if (value < 100) {
                buffer.append((char) ((value / 10) + 48));
                buffer.append((char) ((value % 10) + 48));
            } else {
                buffer.append(Integer.toString(value));
            }
        }
    }

    private static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        UnpaddedMonthField() {
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public void appendTo(final StringBuffer buffer, final Calendar calendar) {
            appendTo(buffer, calendar.get(2) + 1);
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.NumberRule
        public final void appendTo(final StringBuffer buffer, final int value) {
            if (value < 10) {
                buffer.append((char) (value + 48));
            } else {
                buffer.append((char) ((value / 10) + 48));
                buffer.append((char) ((value % 10) + 48));
            }
        }
    }

    private static class PaddedNumberField implements NumberRule {
        private final int mField;
        private final int mSize;

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 4;
        }

        PaddedNumberField(final int field, final int size) {
            if (size < 3) {
                throw new IllegalArgumentException();
            }
            this.mField = field;
            this.mSize = size;
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public void appendTo(final StringBuffer buffer, final Calendar calendar) {
            appendTo(buffer, calendar.get(this.mField));
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.NumberRule
        public final void appendTo(final StringBuffer buffer, final int value) {
            if (value < 100) {
                int i = this.mSize;
                while (true) {
                    i--;
                    if (i >= 2) {
                        buffer.append('0');
                    } else {
                        buffer.append((char) ((value / 10) + 48));
                        buffer.append((char) ((value % 10) + 48));
                        return;
                    }
                }
            } else {
                int length = value < 1000 ? 3 : Integer.toString(value).length();
                int i2 = this.mSize;
                while (true) {
                    i2--;
                    if (i2 >= length) {
                        buffer.append('0');
                    } else {
                        buffer.append(Integer.toString(value));
                        return;
                    }
                }
            }
        }
    }

    private static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        TwoDigitNumberField(final int field) {
            this.mField = field;
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public void appendTo(final StringBuffer buffer, final Calendar calendar) {
            appendTo(buffer, calendar.get(this.mField));
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.NumberRule
        public final void appendTo(final StringBuffer buffer, final int value) {
            if (value < 100) {
                buffer.append((char) ((value / 10) + 48));
                buffer.append((char) ((value % 10) + 48));
            } else {
                buffer.append(Integer.toString(value));
            }
        }
    }

    private static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        TwoDigitYearField() {
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public void appendTo(final StringBuffer buffer, final Calendar calendar) {
            appendTo(buffer, calendar.get(1) % 100);
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.NumberRule
        public final void appendTo(final StringBuffer buffer, final int value) {
            buffer.append((char) ((value / 10) + 48));
            buffer.append((char) ((value % 10) + 48));
        }
    }

    private static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        TwoDigitMonthField() {
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public void appendTo(final StringBuffer buffer, final Calendar calendar) {
            appendTo(buffer, calendar.get(2) + 1);
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.NumberRule
        public final void appendTo(final StringBuffer buffer, final int value) {
            buffer.append((char) ((value / 10) + 48));
            buffer.append((char) ((value % 10) + 48));
        }
    }

    private static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        TwelveHourField(final NumberRule rule) {
            this.mRule = rule;
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public void appendTo(final StringBuffer buffer, final Calendar calendar) {
            int leastMaximum = calendar.get(10);
            if (leastMaximum == 0) {
                leastMaximum = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(buffer, leastMaximum);
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.NumberRule
        public void appendTo(final StringBuffer buffer, final int value) {
            this.mRule.appendTo(buffer, value);
        }
    }

    private static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        TwentyFourHourField(final NumberRule rule) {
            this.mRule = rule;
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public void appendTo(final StringBuffer buffer, final Calendar calendar) {
            int maximum = calendar.get(11);
            if (maximum == 0) {
                maximum = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(buffer, maximum);
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.NumberRule
        public void appendTo(final StringBuffer buffer, final int value) {
            this.mRule.appendTo(buffer, value);
        }
    }

    static String getTimeZoneDisplay(final TimeZone tz, final boolean daylight, final int style, final Locale locale) {
        TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(tz, daylight, style, locale);
        ConcurrentMap<TimeZoneDisplayKey, String> concurrentMap = cTimeZoneDisplayCache;
        String str = concurrentMap.get(timeZoneDisplayKey);
        if (str != null) {
            return str;
        }
        String displayName = tz.getDisplayName(daylight, style, locale);
        String strPutIfAbsent = concurrentMap.putIfAbsent(timeZoneDisplayKey, displayName);
        return strPutIfAbsent != null ? strPutIfAbsent : displayName;
    }

    private static class TimeZoneNameRule implements Rule {
        private final String mDaylight;
        private final Locale mLocale;
        private final String mStandard;
        private final int mStyle;

        TimeZoneNameRule(final TimeZone timeZone, final Locale locale, final int style) {
            this.mLocale = locale;
            this.mStyle = style;
            this.mStandard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, style, locale);
            this.mDaylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, style, locale);
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public int estimateLength() {
            return Math.max(this.mStandard.length(), this.mDaylight.length());
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public void appendTo(final StringBuffer buffer, final Calendar calendar) {
            TimeZone timeZone = calendar.getTimeZone();
            if (timeZone.useDaylightTime() && calendar.get(16) != 0) {
                buffer.append(FastDatePrinter.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
            } else {
                buffer.append(FastDatePrinter.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
            }
        }
    }

    private static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        final boolean mColon;

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 5;
        }

        TimeZoneNumberRule(final boolean colon) {
            this.mColon = colon;
        }

        @Override // ir.eitaa.messenger.time.FastDatePrinter.Rule
        public void appendTo(final StringBuffer buffer, final Calendar calendar) {
            int i = calendar.get(15) + calendar.get(16);
            if (i < 0) {
                buffer.append('-');
                i = -i;
            } else {
                buffer.append('+');
            }
            int i2 = i / 3600000;
            buffer.append((char) ((i2 / 10) + 48));
            buffer.append((char) ((i2 % 10) + 48));
            if (this.mColon) {
                buffer.append(':');
            }
            int i3 = (i / 60000) - (i2 * 60);
            buffer.append((char) ((i3 / 10) + 48));
            buffer.append((char) ((i3 % 10) + 48));
        }
    }

    private static class TimeZoneDisplayKey {
        private final Locale mLocale;
        private final int mStyle;
        private final TimeZone mTimeZone;

        TimeZoneDisplayKey(final TimeZone timeZone, final boolean daylight, final int style, final Locale locale) {
            this.mTimeZone = timeZone;
            if (daylight) {
                this.mStyle = Integer.MIN_VALUE | style;
            } else {
                this.mStyle = style;
            }
            this.mLocale = locale;
        }

        public int hashCode() {
            return (((this.mStyle * 31) + this.mLocale.hashCode()) * 31) + this.mTimeZone.hashCode();
        }

        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            return this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) && this.mStyle == timeZoneDisplayKey.mStyle && this.mLocale.equals(timeZoneDisplayKey.mLocale);
        }
    }
}
