package ir.resaneh1.iptv.model;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.rghapp.rubinoPostSlider.PostTagObject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenters.EditTextCostPresenter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.UserConfig;

/* loaded from: classes3.dex */
public class InstaPostObject extends PresenterItem {
    public float X1;
    public float X2;
    public float Y1;
    public float Y2;
    public boolean allow_show_comment;
    public String caption;
    public String comment_count;
    public String count_sale_unread;
    public Long create_date;
    public long duration;
    public ArrayList<InstaPostFileObject> file_list;
    public FileTypeEnum file_type;
    public String full_file_url;
    public String full_post_profile_thumbnail_url;
    public String full_snapshot_url;
    public String full_thumbnail_url;
    public int height;
    public String id;
    public boolean isBookmarked;
    public boolean isLiked;
    public boolean is_for_sale;
    public boolean is_multi_file;
    public String likes_count;
    private ArrayList<MediaObject> media;
    public InstaCommentObject most_liked_comment;
    public String post_profile_username;
    public String[] product_types;
    private InstaProfileObject profile;
    public String profile_id;
    public String sale_price;
    public String share_url;
    public String video_view_count;
    public int width;
    public String selectedProductType = BuildConfig.FLAVOR;
    public int selectedProductCount = 1;
    public boolean isProductTypesChange = false;
    public boolean isProfileFollowed = false;
    public int size = 1;
    private String shortCaption = BuildConfig.FLAVOR;
    protected int currentAccount = UserConfig.selectedAccount;

    public enum FileTypeEnum {
        Picture,
        Video
    }

    public String getShortCaption() {
        String str;
        int iCountLines = countLines(this.caption);
        if (iCountLines <= 5 && ((str = this.caption) == null || str.length() <= 150)) {
            this.shortCaption = BuildConfig.FLAVOR;
            return BuildConfig.FLAVOR;
        }
        try {
            String str2 = this.shortCaption;
            if (str2 == null || str2.isEmpty()) {
                if (iCountLines > 5) {
                    String strSubstring = this.caption;
                    for (int i = 0; i < 5; i++) {
                        int iIndexOf = strSubstring.indexOf("\n");
                        if (iIndexOf < 0) {
                            iIndexOf = strSubstring.indexOf("\r");
                        }
                        strSubstring = strSubstring.substring(iIndexOf + 1);
                    }
                    String str3 = this.caption;
                    this.shortCaption = str3.substring(0, str3.length() - strSubstring.length());
                } else {
                    this.shortCaption = this.caption.substring(0, Math.min(ImageReceiver.DEFAULT_CROSSFADE_DURATION, this.caption.length()));
                }
                int length = this.shortCaption.length();
                int i2 = 0;
                while (i2 < 10) {
                    char cCharAt = this.shortCaption.charAt((length - 1) - i2);
                    if (!SpanHelper.isLetter(cCharAt) && !SpanHelper.isPersianLetter(cCharAt)) {
                        break;
                    }
                    i2++;
                }
                this.shortCaption = this.shortCaption.substring(0, (length - 1) - i2);
            }
            return this.shortCaption;
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    private static int countLines(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return str.split("\r\n|\r|\n").length;
    }

    public class InstaPostFileObject {
        public int duration;
        public FileTypeEnum file_type;
        public String full_file_url;
        public String full_snapshot_url;
        public List<PostTagObject> postTagObjects;

        public InstaPostFileObject() {
        }
    }

    public int getSalePrice() {
        try {
            return Integer.parseInt(this.sale_price);
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean isMyPost() {
        return this.profile_id.equals(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
    }

    public int getLikeCount() throws NumberFormatException {
        String str = this.likes_count;
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            try {
                int i = Integer.parseInt(this.likes_count);
                if (i >= 0) {
                    return i;
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getViewCount() throws NumberFormatException {
        int i;
        String str = this.video_view_count;
        if (str == null || str.equals(BuildConfig.FLAVOR)) {
            return -1;
        }
        try {
            i = Integer.parseInt(this.video_view_count);
        } catch (Exception unused) {
        }
        if (i >= 0) {
            return i;
        }
        return 0;
    }

    public int getCommentCount() throws NumberFormatException {
        String str = this.comment_count;
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            try {
                int i = Integer.parseInt(this.comment_count);
                if (i >= 0) {
                    return i;
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getPresenterId() {
        return this.id;
    }

    public float getRatioWtoH() {
        try {
            return this.width / this.height;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public float getRatioHtoW() {
        try {
            return (this.height * 1.0f) / this.width;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.InstaPost;
    }

    public InstaProfileObject getProfile() {
        InstaProfileObject instaProfileObject = this.profile;
        if (instaProfileObject != null) {
            return instaProfileObject;
        }
        InstaProfileObject instaProfileObject2 = new InstaProfileObject();
        this.profile = instaProfileObject2;
        instaProfileObject2.id = this.profile_id;
        String str = this.full_post_profile_thumbnail_url;
        instaProfileObject2.full_thumbnail_url = str;
        instaProfileObject2.full_photo_url = str;
        instaProfileObject2.username = this.post_profile_username;
        return instaProfileObject2;
    }

    public void setProfile(InstaProfileObject instaProfileObject) {
        this.profile = instaProfileObject;
    }

    public ArrayList<MediaObject> getMedia() {
        ArrayList<InstaPostFileObject> arrayList;
        ArrayList<MediaObject> arrayList2 = this.media;
        if (arrayList2 != null) {
            return arrayList2;
        }
        ArrayList<MediaObject> arrayList3 = new ArrayList<>();
        this.media = arrayList3;
        FileTypeEnum fileTypeEnum = this.file_type;
        if (fileTypeEnum == FileTypeEnum.Picture || fileTypeEnum == null) {
            arrayList3.add(new MediaObject(this.full_file_url, this.full_thumbnail_url));
        } else if (fileTypeEnum == FileTypeEnum.Video) {
            MediaObject mediaObject = new MediaObject();
            mediaObject.setForVideo(this.id, this.profile_id, this.full_thumbnail_url, this.full_snapshot_url, this.full_file_url);
            this.media.add(mediaObject);
        }
        if (this.is_multi_file && (arrayList = this.file_list) != null) {
            Iterator<InstaPostFileObject> it = arrayList.iterator();
            while (it.hasNext()) {
                InstaPostFileObject next = it.next();
                FileTypeEnum fileTypeEnum2 = next.file_type;
                if (fileTypeEnum2 == FileTypeEnum.Picture || fileTypeEnum2 == null) {
                    this.media.add(new MediaObject(next.full_file_url, BuildConfig.FLAVOR));
                } else if (fileTypeEnum2 == FileTypeEnum.Video) {
                    MediaObject mediaObject2 = new MediaObject();
                    mediaObject2.setForVideo(this.id, this.profile_id, BuildConfig.FLAVOR, next.full_snapshot_url, next.full_file_url);
                    this.media.add(mediaObject2);
                }
            }
        }
        return this.media;
    }

    public int getIconByType() {
        return this.is_multi_file ? R.drawable.insta_multifile : this.file_type == FileTypeEnum.Video ? R.drawable.ic_video_insta : R.drawable.transparent;
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

    public SpannableString getCaptionSpan() {
        View.OnClickListener onClickListener = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.model.InstaPostObject.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        SpannableString spannableString = new SpannableString(this.post_profile_username + " \u061c" + this.caption);
        if (ApplicationLoader.applicationActivity != null) {
            SpanHelper.makeBoldLinkSpanWithColor(spannableString, onClickListener, 0, this.post_profile_username.length(), ApplicationLoader.applicationActivity.getResources().getColor(R.color.grey_900));
        }
        return spannableString;
    }

    public void setShortCaptionSpan(final TextView textView) {
        if (this.shortCaption != null && this.caption != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.model.InstaPostObject.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SpanHelper.parseMessageTextInstaLimitHashtag(textView, InstaPostObject.this.getCaptionSpan(), false);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            };
            SpannableString nameAndTextSpan = getNameAndTextSpan(this.shortCaption + "...نمایش بیشتر");
            int iIndexOf = nameAndTextSpan.toString().indexOf("...نمایش بیشتر");
            SpanHelper.parseMessageTextInstaLimitHashtag(textView, SpanHelper.makeLinkSpanWithColor(nameAndTextSpan, onClickListener, iIndexOf, iIndexOf + 14, R.color.grey_500), false);
            return;
        }
        textView.setText(BuildConfig.FLAVOR);
    }

    public SpannableString getNameAndTextSpan(String str) {
        View.OnClickListener onClickListener = new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.model.InstaPostObject.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        SpannableString spannableString = new SpannableString(this.post_profile_username + " \u061c" + str);
        if (ApplicationLoader.applicationActivity != null) {
            SpanHelper.makeBoldLinkSpanWithColor(spannableString, onClickListener, 0, this.post_profile_username.length(), ApplicationLoader.applicationActivity.getResources().getColor(R.color.grey_900));
        }
        return spannableString;
    }

    public SpannableString getLikeCountSpan() {
        String str = getLikeCount() == 1 ? "نفر پسندید" : "نفر پسندیدند";
        StringBuilder sb = new StringBuilder();
        sb.append(EditTextCostPresenter.setFormat(getLikeCount() + BuildConfig.FLAVOR));
        sb.append(" ");
        String persian = NumberUtils.toPersian(sb.toString());
        SpannableString spannableString = new SpannableString(persian + str);
        if (ApplicationLoader.applicationActivity != null) {
            SpanHelper.makeBoldLinkSpanWithColor(spannableString, null, 0, persian.length() + 3, ApplicationLoader.applicationActivity.getResources().getColor(R.color.grey_900));
        }
        return spannableString;
    }

    public SpannableString getViewCountSpan() {
        StringBuilder sb = new StringBuilder();
        sb.append(EditTextCostPresenter.setFormat(getViewCount() + BuildConfig.FLAVOR));
        sb.append(" ");
        String persian = NumberUtils.toPersian(sb.toString());
        SpannableString spannableString = new SpannableString(persian + " مشاهده ");
        if (ApplicationLoader.applicationActivity != null) {
            SpanHelper.makeBoldLinkSpanWithColor(spannableString, null, 0, persian.length(), ApplicationLoader.applicationActivity.getResources().getColor(R.color.grey_900));
        }
        return spannableString;
    }

    public SpannableString getCommentCountSpan() {
        if (getCommentCount() <= 0) {
            return new SpannableString("افزودن نظر...");
        }
        return new SpannableString("مشاهده ی " + NumberUtils.toPersian(EditTextCostPresenter.setFormat(getCommentCount() + BuildConfig.FLAVOR)) + " نظر...");
    }
}
