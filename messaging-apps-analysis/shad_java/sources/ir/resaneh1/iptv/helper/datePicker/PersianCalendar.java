package ir.resaneh1.iptv.helper.datePicker;

import io.github.inflationx.calligraphy3.BuildConfig;
import j$.retarget.C$r8$retargetLibraryMember$virtualDispatch$GregorianCalendar$toZonedDateTime$dispatchInterface;
import j$.time.ZonedDateTime;
import j$.util.DesugarGregorianCalendar;
import j$.util.DesugarTimeZone;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class PersianCalendar extends GregorianCalendar implements C$r8$retargetLibraryMember$virtualDispatch$GregorianCalendar$toZonedDateTime$dispatchInterface {
    private String delimiter = "/";
    private int persianDay;
    private int persianMonth;
    private int persianYear;

    @Override // java.util.GregorianCalendar, j$.retarget.C$r8$retargetLibraryMember$virtualDispatch$GregorianCalendar$toZonedDateTime$dispatchInterface
    public /* synthetic */ ZonedDateTime toZonedDateTime() {
        return DesugarGregorianCalendar.toZonedDateTime(this);
    }

    public PersianCalendar(long j) {
        setTimeInMillis(j);
    }

    public PersianCalendar() {
        setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
    }

    private long convertToMilis(long j) {
        return ((j * 86400000) - 210866803200000L) + PersianCalendarUtils.ceil(getTimeInMillis() - (-210866803200000L), 8.64E7d);
    }

    protected void calculatePersianDate() {
        long jJulianToPersian = PersianCalendarUtils.julianToPersian(((long) Math.floor(getTimeInMillis() - (-210866803200000L))) / 86400000);
        long j = jJulianToPersian >> 16;
        int i = ((int) (65280 & jJulianToPersian)) >> 8;
        int i2 = (int) (jJulianToPersian & 255);
        if (j <= 0) {
            j--;
        }
        this.persianYear = (int) j;
        this.persianMonth = i;
        this.persianDay = i2;
    }

    public void setPersianDate(int i, int i2, int i3) {
        this.persianYear = i;
        this.persianMonth = i2;
        this.persianDay = i3;
        if (i <= 0) {
            i++;
        }
        setTimeInMillis(convertToMilis(PersianCalendarUtils.persianToJulian(i, i2 - 1, i3)));
    }

    public int getPersianYear() {
        return this.persianYear;
    }

    public int getPersianMonth() {
        return this.persianMonth + 1;
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
        return getPersianWeekDayName() + "  " + this.persianDay + "  " + getPersianMonthName() + "  " + this.persianYear;
    }

    public String getPersianShortDate() {
        return BuildConfig.FLAVOR + formatToMilitary(this.persianYear) + this.delimiter + formatToMilitary(getPersianMonth()) + this.delimiter + formatToMilitary(this.persianDay);
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
    public void set(int i, int i2) {
        super.set(i, i2);
        calculatePersianDate();
    }

    @Override // java.util.Calendar
    public void setTimeInMillis(long j) {
        super.setTimeInMillis(j);
        calculatePersianDate();
    }

    @Override // java.util.GregorianCalendar, java.util.Calendar
    public void setTimeZone(TimeZone timeZone) {
        super.setTimeZone(timeZone);
        calculatePersianDate();
    }
}
