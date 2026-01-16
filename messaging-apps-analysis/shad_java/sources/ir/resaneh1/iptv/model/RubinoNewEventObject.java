package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.InstaPostObject;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;
import java.util.Calendar;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes3.dex */
public class RubinoNewEventObject extends PresenterItem {
    public String comment_id;
    public int count_owners;
    public Long create_date;
    public String full_post_thumbnail_url;
    public String id;
    public boolean is_new;
    public NotifEnum model;
    public ArrayList<RubinoProfileObject> owners;
    public RubinoPostObject postObject;
    public String post_id;
    public String post_profile_id;
    public InstaPostObject.FileTypeEnum post_type;
    public String product_count;
    public String product_type;
    public String profile_id;
    public String request_id;
    public int sale_price;

    public enum NotifEnum {
        LikePost,
        LikeComment,
        CommentPost,
        CommentReply,
        Request,
        FollowingYou,
        YouFollowing,
        Sale,
        Purchase,
        StopLive,
        StartLive
    }

    public RubinoPostObject getPostObject(int i) {
        RubinoPostObject rubinoPostObject = this.postObject;
        if (rubinoPostObject != null) {
            return rubinoPostObject;
        }
        this.postObject = new RubinoPostObject();
        Rubino.PostObjectFromServer postObjectFromServer = new Rubino.PostObjectFromServer();
        postObjectFromServer.id = this.post_id;
        postObjectFromServer.profile_id = this.post_profile_id;
        postObjectFromServer.full_thumbnail_url = this.full_post_thumbnail_url;
        postObjectFromServer.file_type = this.post_type == InstaPostObject.FileTypeEnum.Picture ? Rubino.FileTypeEnum.Picture : Rubino.FileTypeEnum.Video;
        this.postObject.setPost(postObjectFromServer, i);
        return this.postObject;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getPresenterId() {
        return this.id;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.text.SpannableString getText() {
        /*
            Method dump skipped, instructions count: 878
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.model.RubinoNewEventObject.getText():android.text.SpannableString");
    }

    private Boolean isFarsi() {
        return Boolean.valueOf(LocaleController.getInstance().getCurrentLocale().getLanguage().equals("fa"));
    }

    private String createSaleSentences(String str, String str2) {
        if (str2 == null || str == null) {
            return BuildConfig.FLAVOR;
        }
        if (isFarsi().booleanValue()) {
            String str3 = BuildConfig.FLAVOR + " " + str2 + " " + LocaleController.getString("event_your_sale", R.string.event_your_sale);
            if (this.product_type != null) {
                str3 = str3 + LocaleController.getString("event_with_feature", R.string.event_with_feature) + " " + this.product_type + " ";
            }
            if (getProductCount() > 0) {
                str3 = str3 + LocaleController.getString("event_with_count", R.string.event_with_count) + NumberUtils.toPersian(this.product_count) + " ";
            }
            if (getProductCount() > 1) {
                str3 = str3 + LocaleController.getString("event_total_amount_of", R.string.event_total_amount_of);
            }
            return str3 + " مبلغ " + NumberUtils.toPersian(this.sale_price) + " " + LocaleController.getString("event_toman_payed", R.string.event_toman_payed) + " " + str;
        }
        String str4 = BuildConfig.FLAVOR + str2 + " " + str + " ";
        if (getProductCount() > 1) {
            str4 = str4 + LocaleController.getString("event_total_amount_of", R.string.event_total_amount_of);
        }
        String str5 = str4 + " " + NumberUtils.toPersian(this.sale_price) + " " + LocaleController.getString("event_toman_payed", R.string.event_toman_payed) + " ";
        if (getProductCount() > 0) {
            str5 = str5 + LocaleController.getString("event_with_count", R.string.event_with_count) + " " + NumberUtils.toPersian(this.product_count) + " ";
        }
        if (this.product_type != null) {
            str5 = str5 + LocaleController.getString("event_with_feature", R.string.event_with_feature) + " " + this.product_type;
        }
        return str5 + " " + LocaleController.getString("event_your_sale", R.string.event_your_sale);
    }

    private String createSentences(String str, String str2, String str3) {
        if (str2 == null || str3 == null) {
            return BuildConfig.FLAVOR;
        }
        if (str == null) {
            return createSemiSentences(str2, str3);
        }
        if (isFarsi().booleanValue()) {
            return BuildConfig.FLAVOR + " " + str3 + " " + str2 + " " + str + ".";
        }
        return BuildConfig.FLAVOR + " " + str3 + " " + str + " " + str2 + ".";
    }

    private String createSemiSentences(String str, String str2) {
        if (isFarsi().booleanValue()) {
            return BuildConfig.FLAVOR + " " + str2 + " " + str + " .";
        }
        return BuildConfig.FLAVOR + " " + str + " " + str2 + " .";
    }

    public RubinoProfileObject getUserProfile() {
        ArrayList<RubinoProfileObject> arrayList = this.owners;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return this.owners.get(r0.size() - 1);
    }

    public String getUserImageUrl() {
        ArrayList<RubinoProfileObject> arrayList = this.owners;
        if (arrayList == null || arrayList.size() <= 0) {
            return BuildConfig.FLAVOR;
        }
        return this.owners.get(r0.size() - 1).full_thumbnail_url;
    }

    public String getUserImageUrl2() {
        ArrayList<RubinoProfileObject> arrayList = this.owners;
        if (arrayList == null || arrayList.size() <= 1) {
            return BuildConfig.FLAVOR;
        }
        return this.owners.get(r0.size() - 2).full_thumbnail_url;
    }

    public String getPostImageUrl() {
        String str = this.full_post_thumbnail_url;
        return str != null ? str : BuildConfig.FLAVOR;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        NotifEnum notifEnum = this.model;
        if (notifEnum == NotifEnum.LikePost) {
            return PresenterItemType.instaNotifLikePost;
        }
        if (notifEnum == NotifEnum.LikeComment) {
            return PresenterItemType.instaNotifLikeComment;
        }
        if (notifEnum == NotifEnum.CommentPost) {
            return PresenterItemType.instaNotifCommentPost;
        }
        if (notifEnum == NotifEnum.CommentReply) {
            return PresenterItemType.instaNotifCommentReply;
        }
        if (notifEnum == NotifEnum.FollowingYou) {
            return PresenterItemType.instaNotifFollowing;
        }
        if (notifEnum == NotifEnum.Request) {
            return PresenterItemType.instaNotifRequest;
        }
        if (notifEnum == NotifEnum.YouFollowing) {
            return PresenterItemType.instaNotifYouFollowing;
        }
        if (notifEnum == NotifEnum.Sale) {
            return PresenterItemType.instaNotifSale;
        }
        if (notifEnum == NotifEnum.Purchase) {
            return PresenterItemType.instaNotifPurchase;
        }
        return PresenterItemType.instaNotifUnKnow;
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

    public int getProductCount() {
        String str = this.product_count;
        if (str == null) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }
}
