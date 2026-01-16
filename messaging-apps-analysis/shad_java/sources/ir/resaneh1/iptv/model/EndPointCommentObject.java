package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class EndPointCommentObject extends PresenterItem {
    public String catId;
    public String comment_id;
    public String comment_tag;
    public String content;
    public long dislike_count;
    public boolean isDisLiked;
    public boolean isLiked;
    public long like_count;
    public String objectId;
    public float rate;
    public EndPointCommentObject reply;
    public long time;
    public String user_avatar_url;
    public String user_title;

    public boolean isMyComment() {
        return false;
    }

    public EndPointCommentObject(String str, String str2, long j) {
        this.content = str;
        this.user_title = str2;
        this.time = j;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.endPointComment;
    }

    public String getPersianDate() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.time * 1000);
            return DateFormatUtils.getAgoTime(calendar.getTime());
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }
}
