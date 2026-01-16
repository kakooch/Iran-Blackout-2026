package ir.eitaa.messenger.time;

import java.util.Locale;

/* loaded from: classes.dex */
public class PersianDateFormatter {
    private static String[] dayNames = {"یک\u200cشنبه", "دوشنبه", "سه\u200cشنبه", "چهارشنبه", "پنج\u200cشنبه", "جمعه", "شنبه"};
    private static String[] monthNames = {"فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند"};

    public static String getMonthName(int month) {
        return monthNames[month - 1];
    }

    public static String getDayName(int day) {
        return dayNames[day];
    }

    public static String getChatPersianDate(int weekDay, int day, int month) {
        return String.format(Locale.getDefault(), "%s %d %s", getDayName(weekDay), Integer.valueOf(day), getMonthName(month));
    }

    public static String getChatPersianFullDate(int day, int month, int year) {
        return String.format(Locale.getDefault(), "%d %s %d", Integer.valueOf(day), getMonthName(month), Integer.valueOf(year));
    }

    public static String getPersianFormatterYear(int day, int month, int year) {
        return String.format(Locale.getDefault(), "%d/%d/%d", Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
    }

    public static String getPersianFormatterMonth(int day, int month) {
        return String.format(Locale.getDefault(), "%d %s", Integer.valueOf(day), getMonthName(month));
    }

    public static String getPersianFormatterMonthYear(int year, int month) {
        return String.format(Locale.getDefault(), "%s %d", getMonthName(month), Integer.valueOf(year));
    }

    public static String getPersianFullDate(int weekDay, int day, int month, int year, String clock) {
        return String.format(Locale.getDefault(), "%s %d %s %d ساعت %s", getDayName(weekDay), Integer.valueOf(day), getMonthName(month), Integer.valueOf(year), clock);
    }
}
