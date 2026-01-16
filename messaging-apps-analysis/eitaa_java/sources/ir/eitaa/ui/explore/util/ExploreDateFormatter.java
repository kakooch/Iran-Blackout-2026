package ir.eitaa.ui.explore.util;

import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class ExploreDateFormatter {
    private int DAY;
    private int HOUR;
    private int MINUTE;
    private int MONTH;
    private int SECOND = 1;
    private int YEAR;

    public ExploreDateFormatter() {
        int i = 1 * 60;
        this.MINUTE = i;
        int i2 = i * 60;
        this.HOUR = i2;
        int i3 = i2 * 24;
        this.DAY = i3;
        int i4 = i3 * 30;
        this.MONTH = i4;
        this.YEAR = i4 * 12;
    }

    private Long currentDate() {
        return Long.valueOf(Calendar.getInstance().getTimeInMillis());
    }

    public String toTimeAgo(Long time) {
        Long lValueOf = Long.valueOf((currentDate().longValue() - time.longValue()) / 1000);
        if (lValueOf.longValue() < this.MINUTE) {
            return LocaleController.getString("JustNow", R.string.JustNow);
        }
        if (lValueOf.longValue() < this.MINUTE * 2) {
            return LocaleController.getString("AMinuteAgo", R.string.AMinuteAgo);
        }
        if (lValueOf.longValue() < this.MINUTE * 60) {
            return (lValueOf.longValue() / this.MINUTE) + " " + LocaleController.getString("MinutesAgo", R.string.MinutesAgo);
        }
        if (lValueOf.longValue() < this.HOUR * 2) {
            return LocaleController.getString("AnHourAgo", R.string.AnHourAgo);
        }
        if (lValueOf.longValue() < this.HOUR * 24) {
            return (lValueOf.longValue() / this.HOUR) + " " + LocaleController.getString(" HoursAgo", R.string.HoursAgo);
        }
        if (lValueOf.longValue() < this.DAY * 2) {
            return LocaleController.getString("YesterdayExplore", R.string.YesterdayExplore);
        }
        if (lValueOf.longValue() < this.DAY * 30) {
            return (lValueOf.longValue() / this.DAY) + " " + LocaleController.getString(" DaysAgo", R.string.DaysAgo);
        }
        if (lValueOf.longValue() < this.MONTH * 2) {
            return LocaleController.getString("AMonthAgo", R.string.AMonthAgo);
        }
        if (lValueOf.longValue() < this.MONTH * 12) {
            return (lValueOf.longValue() / this.MONTH) + " " + LocaleController.getString("MonthsAgo", R.string.MonthsAgo);
        }
        if (lValueOf.longValue() < this.YEAR * 2) {
            return LocaleController.getString("AYearAgo", R.string.AYearAgo);
        }
        return (lValueOf.longValue() / this.YEAR) + " " + LocaleController.getString("YearsAgo", R.string.YearsAgo);
    }
}
