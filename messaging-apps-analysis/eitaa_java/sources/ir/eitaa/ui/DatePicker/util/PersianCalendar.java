package ir.eitaa.ui.DatePicker.util;

import j$.C$r8$retargetLibraryMember$virtualDispatch$GregorianCalendar$toZonedDateTime$dispatchInterface;
import j$.time.ZonedDateTime;
import j$.util.DesugarGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class PersianCalendar extends GregorianCalendar implements C$r8$retargetLibraryMember$virtualDispatch$GregorianCalendar$toZonedDateTime$dispatchInterface {
    private static int[] gregorianDaysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static int[] persianDaysInMonth = {31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29};
    private String delimiter;
    private int persianDay;
    private int persianMonth;
    private int persianYear;

    @Override // java.util.GregorianCalendar, j$.C$r8$retargetLibraryMember$virtualDispatch$GregorianCalendar$toZonedDateTime$dispatchInterface
    public /* synthetic */ ZonedDateTime toZonedDateTime() {
        return DesugarGregorianCalendar.toZonedDateTime(this);
    }

    public PersianCalendar() {
        super(TimeZone.getDefault(), Locale.getDefault());
        this.delimiter = "/";
    }

    protected void calculatePersianDate() {
        YearMonthDay yearMonthDayGregorianToJalali = gregorianToJalali(new YearMonthDay(get(1), get(2), get(5)));
        this.persianYear = yearMonthDayGregorianToJalali.year;
        this.persianMonth = yearMonthDayGregorianToJalali.month;
        this.persianDay = yearMonthDayGregorianToJalali.day;
    }

    public void setPersianDate(int persianYear, int persianMonth, int persianDay) {
        int i = persianMonth + 1;
        this.persianYear = persianYear;
        this.persianMonth = i;
        this.persianDay = persianDay;
        YearMonthDay yearMonthDayPersianToGregorian = persianToGregorian(new YearMonthDay(persianYear, i - 1, persianDay));
        set(yearMonthDayPersianToGregorian.year, yearMonthDayPersianToGregorian.month, yearMonthDayPersianToGregorian.day);
    }

    public int getPersianYear() {
        return this.persianYear;
    }

    public int getPersianMonth() {
        return this.persianMonth;
    }

    public String getPersianMonthName() {
        return PersianCalendarConstants.persianMonthNames[this.persianMonth];
    }

    public int getPersianDay() {
        return this.persianDay;
    }

    public String getPersianWeekDayName() {
        int i = get(7);
        if (i == 1) {
            return PersianCalendarConstants.persianWeekDays[1];
        }
        if (i == 2) {
            return PersianCalendarConstants.persianWeekDays[2];
        }
        if (i == 3) {
            return PersianCalendarConstants.persianWeekDays[3];
        }
        if (i == 4) {
            return PersianCalendarConstants.persianWeekDays[4];
        }
        if (i == 5) {
            return PersianCalendarConstants.persianWeekDays[5];
        }
        if (i == 7) {
            return PersianCalendarConstants.persianWeekDays[0];
        }
        return PersianCalendarConstants.persianWeekDays[6];
    }

    public String getPersianLongDate() {
        return getPersianWeekDayName() + "  " + formatToMilitary(this.persianDay) + "  " + getPersianMonthName() + "  " + this.persianYear;
    }

    public String getPersianShortDate() {
        return "" + formatToMilitary(this.persianYear) + this.delimiter + formatToMilitary(getPersianMonth()) + this.delimiter + formatToMilitary(this.persianDay);
    }

    private String formatToMilitary(int i) {
        if (i >= 9) {
            return String.valueOf(i);
        }
        return "0" + i;
    }

    @Override // java.util.Calendar
    public String toString() {
        return super.toString().substring(0, r0.length() - 1) + ",PersianDate=" + getPersianShortDate() + "]";
    }

    @Override // java.util.GregorianCalendar, java.util.Calendar
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.GregorianCalendar, java.util.Calendar
    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.util.Calendar
    public void set(int field, int value) {
        super.set(field, value);
        calculatePersianDate();
    }

    @Override // java.util.Calendar
    public void setTimeInMillis(long millis) {
        super.setTimeInMillis(millis);
        calculatePersianDate();
    }

    @Override // java.util.GregorianCalendar, java.util.Calendar
    public void setTimeZone(TimeZone zone) {
        super.setTimeZone(zone);
        calculatePersianDate();
    }

    private static YearMonthDay gregorianToJalali(YearMonthDay gregorian) {
        if (gregorian.getMonth() > 11 || gregorian.getMonth() < -11) {
            throw new IllegalArgumentException();
        }
        gregorian.setYear(gregorian.getYear() - 1600);
        gregorian.setDay(gregorian.getDay() - 1);
        int year = (((gregorian.getYear() * 365) + ((int) Math.floor((gregorian.getYear() + 3) / 4))) - ((int) Math.floor((gregorian.getYear() + 99) / 100))) + ((int) Math.floor((gregorian.getYear() + 399) / 400));
        int i = 0;
        for (int i2 = 0; i2 < gregorian.getMonth(); i2++) {
            year += gregorianDaysInMonth[i2];
        }
        if (gregorian.getMonth() > 1 && ((gregorian.getYear() % 4 == 0 && gregorian.getYear() % 100 != 0) || gregorian.getYear() % 400 == 0)) {
            year++;
        }
        int day = (year + gregorian.getDay()) - 79;
        int iFloor = (int) Math.floor(day / 12053);
        int i3 = day % 12053;
        int iFloor2 = (iFloor * 33) + 979 + ((i3 / 1461) * 4);
        int i4 = i3 % 1461;
        if (i4 >= 366) {
            iFloor2 += (int) Math.floor(r0 / 365);
            i4 = (i4 - 1) % 365;
        }
        while (i < 11) {
            int[] iArr = persianDaysInMonth;
            if (i4 < iArr[i]) {
                break;
            }
            i4 -= iArr[i];
            i++;
        }
        return new YearMonthDay(iFloor2, i, i4 + 1);
    }

    private static YearMonthDay persianToGregorian(YearMonthDay persian) {
        boolean z;
        if (persian.getMonth() > 11 || persian.getMonth() < -11) {
            throw new IllegalArgumentException();
        }
        persian.setYear(persian.getYear() - 979);
        persian.setDay(persian.getDay() - 1);
        int year = (persian.getYear() * 365) + ((persian.getYear() / 33) * 8) + ((int) Math.floor(((persian.getYear() % 33) + 3) / 4));
        for (int i = 0; i < persian.getMonth(); i++) {
            year += persianDaysInMonth[i];
        }
        int day = year + persian.getDay() + 79;
        int iFloor = (((int) Math.floor(day / 146097)) * 400) + 1600;
        int i2 = day % 146097;
        if (i2 >= 36525) {
            iFloor += ((int) Math.floor(r0 / 36524)) * 100;
            i2 = (i2 - 1) % 36524;
            if (i2 >= 365) {
                i2++;
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        int iFloor2 = iFloor + (((int) Math.floor(i2 / 1461)) * 4);
        int i3 = i2 % 1461;
        if (i3 >= 366) {
            iFloor2 += (int) Math.floor(r0 / 365);
            i3 = (i3 - 1) % 365;
            z = false;
        }
        int i4 = 0;
        while (true) {
            int[] iArr = gregorianDaysInMonth;
            if (i3 < iArr[i4] + ((i4 == 1 && z) ? i4 : 0)) {
                return new YearMonthDay(iFloor2, i4, i3 + 1);
            }
            i3 -= iArr[i4] + ((i4 == 1 && z) ? i4 : 0);
            i4++;
        }
    }

    static class YearMonthDay {
        private int day;
        private int month;
        private int year;

        YearMonthDay(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int getYear() {
            return this.year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return this.month;
        }

        public int getDay() {
            return this.day;
        }

        public void setDay(int date) {
            this.day = date;
        }

        public String toString() {
            return getYear() + "/" + getMonth() + "/" + getDay();
        }
    }
}
