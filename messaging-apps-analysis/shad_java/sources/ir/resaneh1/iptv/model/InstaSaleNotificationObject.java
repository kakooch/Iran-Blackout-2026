package ir.resaneh1.iptv.model;

import android.text.SpannableString;
import android.view.View;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.Calendar;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class InstaSaleNotificationObject extends PresenterItem {
    public Long create_date;
    public String customer_id;
    public String customer_username;
    public String full_customer_thumbnail_url;
    public String full_post_thumbnail_url;
    public String id;
    public boolean is_read;
    public RubinoPostObject postObject;
    public String post_id;
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
        return PresenterItemType.instaSaleNotificationObject;
    }

    public String getPostImageUrl() {
        String str = this.full_post_thumbnail_url;
        return str != null ? str : BuildConfig.FLAVOR;
    }

    public String getUserImageUrl() {
        String str = this.full_customer_thumbnail_url;
        return str != null ? str : BuildConfig.FLAVOR;
    }

    public SpannableString getText() {
        String str = " " + this.customer_username + " برای پست شما";
        if (this.product_type != null) {
            str = str + " با ویژگی " + this.product_type;
        }
        if (this.product_count != null) {
            str = str + " به تعداد " + NumberUtils.toPersian(this.product_count);
        }
        String str2 = str + " مبلغ ";
        if (getProductCount() > 1) {
            str2 = str2 + "مجموعا ";
        }
        String str3 = str2 + NumberUtils.toPersian(this.sale_price) + " تومان پرداخت کرد";
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.model.InstaSaleNotificationObject.1
            boolean isLoading = false;

            {
                new InstaProfileObject(InstaSaleNotificationObject.this.customer_id);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.isLoading) {
                    return;
                }
                this.isLoading = true;
                new MainClickHandler().onMessengerUsernameClicked(InstaSaleNotificationObject.this.customer_username);
            }
        };
        int iIndexOf = str3.indexOf(this.customer_username);
        return SpanHelper.makeBoldLinkSpanWithColor(new SpannableString(str3), onClickListener, iIndexOf, this.customer_username.length() + iIndexOf, ApplicationLoader.applicationActivity.getResources().getColor(R.color.grey_900));
    }

    public InstaProfileObject getUserProfile() {
        InstaProfileObject instaProfileObject = new InstaProfileObject(this.customer_id);
        instaProfileObject.full_thumbnail_url = this.full_customer_thumbnail_url;
        instaProfileObject.username = this.customer_username;
        return instaProfileObject;
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
