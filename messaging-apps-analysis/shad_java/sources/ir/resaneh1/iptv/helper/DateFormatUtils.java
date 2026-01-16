package ir.resaneh1.iptv.helper;

import android.net.ParseException;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.logger.MyLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes3.dex */
public class DateFormatUtils {
    public static int getPersianDayOfMonth(long j) {
        return PersianCalendar.getPersianDayOfMonth(new Date(j));
    }

    public static String getClock(long j) {
        return NumberUtils.toPersian(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(j * 1000)));
    }

    public static int getHour(long j) {
        return Integer.parseInt(new SimpleDateFormat("HH", Locale.getDefault()).format(new Date(j)));
    }

    public static int getMinute(long j) {
        return Integer.parseInt(new SimpleDateFormat("mm", Locale.getDefault()).format(new Date(j)));
    }

    public static String getMonthKeyPersian(long j) {
        return PersianCalendar.getMonthName(getMonthPersian(j));
    }

    public static int getMonthPersian(long j) {
        return Integer.parseInt(PersianCalendar.getPersianDate4DigitYear(new Date(j)).substring(5, 7));
    }

    public static String getDateForOrders(long j) {
        return getClock(j) + " " + NumberUtils.toPersian(PersianCalendar.getPersianDate(new Date(j * 1000)));
    }

    public static String getAgoTimeRubino(Date date) {
        try {
            Long lValueOf = Long.valueOf((System.currentTimeMillis() - date.getTime()) / 1000);
            MyLog.e("timeDef", "timeDef " + lValueOf);
            if (lValueOf.longValue() < 1) {
                return "1s";
            }
            if (lValueOf.longValue() < 60) {
                return lValueOf + "s";
            }
            if (lValueOf.longValue() < 3600) {
                return (lValueOf.longValue() / 60) + "m";
            }
            if (lValueOf.longValue() < 86400) {
                return (lValueOf.longValue() / 3600) + "h";
            }
            if (lValueOf.longValue() < 604800) {
                return (lValueOf.longValue() / 86400) + "d";
            }
            return (lValueOf.longValue() / 604800) + "w";
        } catch (ParseException e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    public static String getAgoTime(Date date) {
        try {
            Long lValueOf = Long.valueOf((System.currentTimeMillis() - date.getTime()) / 1000);
            MyLog.e("timeDef", "timeDef " + lValueOf);
            if (lValueOf.longValue() < 60) {
                return LocaleController.getString("MomentAgo", R.string.MomentAgo);
            }
            if (lValueOf.longValue() < 3600) {
                return (lValueOf.longValue() / 60) + " " + LocaleController.getString("MinuteAgo", R.string.MinuteAgo);
            }
            if (lValueOf.longValue() < 86400) {
                return (lValueOf.longValue() / 3600) + " " + LocaleController.getString("HourAgo", R.string.HourAgo);
            }
            if (lValueOf.longValue() >= 86400 && lValueOf.longValue() < 172800) {
                return LocaleController.getString("Yesterday", R.string.Yesterday);
            }
            if (lValueOf.longValue() < 604800) {
                return (lValueOf.longValue() / 86400) + " " + LocaleController.getString("DayAgo", R.string.DayAgo);
            }
            return (lValueOf.longValue() / 604800) + " " + LocaleController.getString("WeekAgo", R.string.WeekAgo);
        } catch (ParseException e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }
}
