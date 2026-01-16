package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes3.dex */
public class TvEpisodeObjectAbs extends Abs {
    public TVChannelAbs channel;
    public TimeObject current_time;
    public String duration;
    public String name = BuildConfig.FLAVOR;
    public TimeObject start_time;
    public String status;
    public String tv_episode_id;

    public enum StatusType {
        playing,
        archive,
        future
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.tv_episode;
    }

    public StatusType getStatusType() throws NumberFormatException {
        int iTimeDifferenceInMinute = timeDifferenceInMinute(this.current_time.en_date, this.start_time.en_date);
        int i = Integer.parseInt(this.duration);
        MyLog.e("time Statuse", iTimeDifferenceInMinute + " " + i + this.current_time.en_date + " " + this.start_time.en_date);
        if (iTimeDifferenceInMinute > i) {
            return StatusType.archive;
        }
        if (iTimeDifferenceInMinute < 0) {
            return StatusType.future;
        }
        return StatusType.playing;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getTitle() {
        return this.name;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getId() {
        return this.tv_episode_id;
    }

    public int getProgressBarValue() {
        return timeDifferenceInMinute(this.current_time.en_date, this.start_time.en_date);
    }

    public String getStartTimeString() {
        return NumberUtils.toPersian(dateWithHoursToHHMM(this.start_time.en_date));
    }

    public static String dateWithHoursToHHMM(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(str);
            simpleDateFormat.applyPattern("HH:mm");
            return simpleDateFormat.format(date);
        } catch (ParseException unused) {
            return BuildConfig.FLAVOR;
        }
    }

    public static int timeDifferenceInMinute(String str, String str2) {
        double d;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            double time = simpleDateFormat.parse(str).getTime() - simpleDateFormat.parse(str2).getTime();
            Double.isNaN(time);
            d = time / 60000.0d;
        } catch (ParseException unused) {
            d = 0.0d;
        }
        return (int) d;
    }
}
