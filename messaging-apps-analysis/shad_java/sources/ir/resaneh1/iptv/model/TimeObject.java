package ir.resaneh1.iptv.model;

import com.google.gson.annotations.SerializedName;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: classes3.dex */
public class TimeObject extends PresenterItem {

    @SerializedName("day_of_week")
    public String day_of_week;

    @SerializedName(alternate = {"fa_date"}, value = "fa_time")
    public String fa_date;

    @SerializedName(alternate = {"en_date"}, value = "en_time")
    public String en_date = BuildConfig.FLAVOR;
    public boolean isToday = false;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.time;
    }

    public boolean isToday(TimeObject timeObject) {
        return timeObject.fa_date.contains(this.fa_date);
    }

    public String getWeekDayString() {
        return getJalaiWeekDay(this.day_of_week);
    }

    public String getAgoTime() {
        try {
            Long lValueOf = Long.valueOf((System.currentTimeMillis() - new SimpleDateFormat("yyyy/MM/dd' 'HH:mm:ss").parse(this.en_date).getTime()) / 1000);
            MyLog.e("timeDef", "timeDef " + lValueOf);
            if (lValueOf.longValue() < 60) {
                return "چند لحظه پیش";
            }
            if (lValueOf.longValue() < 3600) {
                return (lValueOf.longValue() / 60) + " دقیقه پیش";
            }
            if (lValueOf.longValue() < 86400) {
                return (lValueOf.longValue() / 3600) + " ساعت پیش";
            }
            if (lValueOf.longValue() >= 86400 && lValueOf.longValue() < 172800) {
                return "دیروز";
            }
            if (lValueOf.longValue() >= 172800 && lValueOf.longValue() < 259200) {
                return "پریروز";
            }
            if (lValueOf.longValue() < 604800) {
                return (lValueOf.longValue() / 86400) + " روز پیش";
            }
            return (lValueOf.longValue() / 604800) + " هفته پیش";
        } catch (ParseException e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    static String getJalaiWeekDay(String str) {
        if (str == null) {
            return str;
        }
        String lowerCase = str.toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "saturday":
                return "شنبه";
            case "friday":
                return "جمعه";
            case "monday":
                return "دوشنبه";
            case "tuesday":
                return "سه شنبه";
            case "sunday":
                return "یک شنبه";
            case "wednesday":
                return "چهارشنبه";
            case "thursday":
                return "پنج شنبه";
            default:
                return str;
        }
    }
}
