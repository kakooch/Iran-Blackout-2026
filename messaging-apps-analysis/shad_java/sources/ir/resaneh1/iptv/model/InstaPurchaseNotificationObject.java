package ir.resaneh1.iptv.model;

import android.text.SpannableString;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class InstaPurchaseNotificationObject extends PresenterItem {
    public Long create_date;
    public String full_post_profile_url;
    public String full_post_thumbnail_url;
    public String id;
    public RubinoPostObject postObject;
    public String post_id;
    public String post_profile_id;
    public String product_count;
    public String product_type;
    public String profile_id;
    public int sale_price;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getPresenterId() {
        return this.id;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.instaPurchaseNotificationObject;
    }

    public String getPostImageUrl() {
        String str = this.full_post_thumbnail_url;
        return str != null ? str : BuildConfig.FLAVOR;
    }

    public SpannableString getText() {
        String str = " شما برای این پست";
        if (this.product_type != null) {
            str = " شما برای این پست با ویژگی " + this.product_type;
        }
        if (this.product_count != null) {
            str = str + " به تعداد " + NumberUtils.toPersian(this.product_count);
        }
        String str2 = str + " مبلغ ";
        if (getProductCount() > 1) {
            str2 = str2 + "مجموعا ";
        }
        return new SpannableString(str2 + NumberUtils.toPersian(this.sale_price) + " تومان پرداخت کردید");
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

    public RubinoPostObject getPostObject(int i) {
        RubinoPostObject rubinoPostObject = this.postObject;
        if (rubinoPostObject != null) {
            return rubinoPostObject;
        }
        this.postObject = new RubinoPostObject();
        Rubino.PostObjectFromServer postObjectFromServer = new Rubino.PostObjectFromServer();
        postObjectFromServer.id = this.post_id;
        postObjectFromServer.profile_id = this.profile_id;
        postObjectFromServer.full_thumbnail_url = this.full_post_thumbnail_url;
        this.postObject.setPost(postObjectFromServer, i);
        return this.postObject;
    }

    public String getUserImageUrl() {
        String str = this.full_post_profile_url;
        return str != null ? str : BuildConfig.FLAVOR;
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
