package ir.eitaa.messenger.time;

import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import java.util.Date;

/* loaded from: classes.dex */
public class JalaliCalendar {
    public int day;
    public int dayInYear;
    public int month;
    final String[] monthsName = new String[12];
    public int weekDay;
    public int year;

    public JalaliCalendar(long unix) {
        Date date = new Date(unix);
        int year = date.getYear() + 1900;
        int month = date.getMonth() + 1;
        int date2 = date.getDate();
        this.weekDay = date.getDay();
        int[] iArr = {0, 31, 59, 90, R.styleable.AppCompatTheme_windowNoTitle, 151, 181, 212, 243, 273, 304, 334};
        int[] iArr2 = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
        int i = year % 4;
        if (i != 0) {
            int i2 = iArr[month - 1] + date2;
            this.day = i2;
            if (i2 > 79) {
                int i3 = i2 - 79;
                this.day = i3;
                if (i3 <= 186) {
                    if (i3 % 31 == 0) {
                        this.month = i3 / 31;
                        this.day = 31;
                    } else {
                        this.month = (i3 / 31) + 1;
                        this.day = i3 % 31;
                    }
                    this.year = year - 621;
                } else {
                    int i4 = i3 - 186;
                    this.day = i4;
                    if (i4 % 30 == 0) {
                        this.month = (i4 / 30) + 6;
                        this.day = 30;
                    } else {
                        this.month = (i4 / 30) + 7;
                        this.day = i4 % 30;
                    }
                    this.year = year - 621;
                }
            } else {
                int i5 = i2 + ((year <= 1996 || i != 1) ? 10 : 11);
                this.day = i5;
                if (i5 % 30 == 0) {
                    this.month = (i5 / 30) + 9;
                    this.day = 30;
                } else {
                    this.month = (i5 / 30) + 10;
                    this.day = i5 % 30;
                }
                this.year = year - 622;
            }
        } else {
            int i6 = iArr2[month - 1] + date2;
            this.day = i6;
            int i7 = year < 1996 ? 80 : 79;
            if (i6 > i7) {
                int i8 = i6 - i7;
                this.day = i8;
                if (i8 <= 186) {
                    if (i8 % 31 == 0) {
                        this.month = i8 / 31;
                        this.day = 31;
                    } else {
                        this.month = (i8 / 31) + 1;
                        this.day = i8 % 31;
                    }
                    this.year = year - 621;
                } else {
                    int i9 = i8 - 186;
                    this.day = i9;
                    if (i9 % 30 == 0) {
                        this.month = (i9 / 30) + 6;
                        this.day = 30;
                    } else {
                        this.month = (i9 / 30) + 7;
                        this.day = i9 % 30;
                    }
                    this.year = year - 621;
                }
            } else {
                int i10 = i6 + 10;
                this.day = i10;
                if (i10 % 30 == 0) {
                    this.month = (i10 / 30) + 9;
                    this.day = 30;
                } else {
                    this.month = (i10 / 30) + 10;
                    this.day = i10 % 30;
                }
                this.year = year - 622;
            }
        }
        int i11 = this.month;
        if (i11 > 6) {
            this.dayInYear = (((i11 - 1) - 6) * 30) + 186 + this.day;
        } else {
            this.dayInYear = ((i11 - 1) * 31) + this.day;
        }
    }

    public String getMonthName(int month) {
        this.monthsName[0] = LocaleController.getString("Farvardin", R.string.Farvardin);
        this.monthsName[1] = LocaleController.getString("Ordibehesht", R.string.Ordibehesht);
        this.monthsName[2] = LocaleController.getString("Khordad", R.string.Khordad);
        this.monthsName[3] = LocaleController.getString("Tir", R.string.Tir);
        this.monthsName[4] = LocaleController.getString("Mordad", R.string.Mordad);
        this.monthsName[5] = LocaleController.getString("Shahrivar", R.string.Shahrivar);
        this.monthsName[6] = LocaleController.getString("Mehr", R.string.Mehr);
        this.monthsName[7] = LocaleController.getString("Aban", R.string.Aban);
        this.monthsName[8] = LocaleController.getString("Azar", R.string.Azar);
        this.monthsName[9] = LocaleController.getString("Dey", R.string.Dey);
        this.monthsName[10] = LocaleController.getString("Bahman", R.string.Bahman);
        this.monthsName[11] = LocaleController.getString("Esfand", R.string.Esfand);
        return this.monthsName[month - 1];
    }
}
