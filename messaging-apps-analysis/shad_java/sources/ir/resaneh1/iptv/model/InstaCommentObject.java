package ir.resaneh1.iptv.model;

import android.text.SpannableString;
import android.view.View;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.Calendar;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class InstaCommentObject extends PresenterItem {
    public String content;
    public Long create_date;
    public InstaCommentObject first_child_comment;
    public String full_profile_thumbnail_url;
    public String id;
    public String likes_count;
    public InstaCommentObject parentComment;
    public String parent_id;
    public String post_id;
    public InstaProfileObject profile;
    public String profile_id;
    public String profile_username;
    public int reply_count;
    public boolean isReply = false;
    public boolean isLiked = false;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getPresenterId() {
        return this.id;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.instaComment;
    }

    public InstaProfileObject getProfile() {
        InstaProfileObject instaProfileObject = this.profile;
        if (instaProfileObject != null) {
            return instaProfileObject;
        }
        InstaProfileObject instaProfileObject2 = new InstaProfileObject();
        this.profile = instaProfileObject2;
        instaProfileObject2.id = this.profile_id;
        instaProfileObject2.username = this.profile_username;
        String str = this.full_profile_thumbnail_url;
        instaProfileObject2.full_thumbnail_url = str;
        instaProfileObject2.full_photo_url = str;
        return instaProfileObject2;
    }

    public void setProfile(InstaProfileObject instaProfileObject) {
        this.profile = instaProfileObject;
    }

    public String getPersianDate() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.create_date.longValue() * 1000);
            return DateFormatUtils.getAgoTime(calendar.getTime());
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    public int getLikeCount() {
        String str = this.likes_count;
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            try {
                return Integer.parseInt(this.likes_count);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public SpannableString getBodySpan() {
        View.OnClickListener onClickListener = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.model.InstaCommentObject.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        SpannableString spannableString = new SpannableString(this.profile_username + " \u061c" + this.content);
        if (ApplicationLoader.applicationActivity != null) {
            SpanHelper.makeBoldLinkSpanWithColor(spannableString, onClickListener, 0, this.profile_username.length(), ApplicationLoader.applicationActivity.getResources().getColor(R.color.grey_900));
        }
        return spannableString;
    }
}
