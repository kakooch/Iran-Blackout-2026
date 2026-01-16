package ir.resaneh1.iptv.model;

import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.rghapp.components.RubinoUsernameSpan;
import ir.appp.rghapp.rubinoPostSlider.PhotoSlideObject;
import ir.appp.rghapp.rubinoPostSlider.PhotoViewerObject;
import ir.appp.rghapp.rubinoPostSlider.PostTagObject;
import ir.appp.rghapp.rubinoPostSlider.PostTagType;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.RubinoShowMoreSpan;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.presenters.EditTextCostPresenter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class RubinoPostObject {
    public SpannableString captionSpannableString;
    public SpannableString commentCountSpannableString;
    public transient int currentAccount;
    public boolean isAddCommentAnimationEnded;
    public boolean isBookmarked;
    public boolean isLiked;
    public boolean isMoreCaptionClicked;
    public boolean isMyPost;
    public SpannableString likeCountSpannableString;
    public transient RubinoCommentObject mostLikeComment;
    public transient PhotoSlideObject photoSlideObject;
    public int position;
    public Rubino.PostObjectFromServer post;
    public transient RubinoProfileObject profile;
    public StaticLayout shopStaticLayout;
    public SpannableString shortCaptionInStorySpannableString;
    public SpannableString shortCaptionSpannableString;
    public transient long updateTime;
    public SpannableString viewCountSpannableString;
    public float viewHWRatio;
    public int viewPagerHeight;
    public String shortCaption = BuildConfig.FLAVOR;
    public String selectedProductType = BuildConfig.FLAVOR;
    public int selectedProductCount = 1;
    public boolean isProductTypesChange = false;
    public ArrayList<RubinoCommentObject> myComments = new ArrayList<>();

    public void setPost(Rubino.PostObjectFromServer postObjectFromServer, int i) {
        this.post = postObjectFromServer;
        this.currentAccount = i;
        createProfile();
        setIsMyPost();
        calculateSize();
        createMedia();
        createCaptionSpan();
        createShortCaptionSpan();
        createShortCaptionInStorySpan();
        createLikeCountSpan();
        createViewCountSpan();
        createCommentCountSpan();
        createMostLikedCommentInfo();
        createShopStaticLayout();
    }

    private void createShopStaticLayout() {
        Rubino.PostObjectFromServer postObjectFromServer = this.post;
        if (!postObjectFromServer.is_for_sale || postObjectFromServer.sale_price <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(NumberUtils.setCommaFormat(this.post.sale_price + BuildConfig.FLAVOR));
        sb.append(" T");
        String string = sb.toString();
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(AndroidUtilities.density * 12.0f);
        textPaint.setTypeface(Theme.getRubinoTypeFaceMedium());
        textPaint.setColor(-1);
        float fMeasureText = textPaint.measureText(string);
        if (Build.VERSION.SDK_INT >= 23) {
            this.shopStaticLayout = StaticLayout.Builder.obtain(string, 0, string.length(), textPaint, (int) fMeasureText).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(false).build();
        } else {
            this.shopStaticLayout = new StaticLayout(string, textPaint, (int) fMeasureText, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }
    }

    private void createMostLikedCommentInfo() {
        Rubino.PostObjectFromServer postObjectFromServer = this.post;
        if (postObjectFromServer == null || postObjectFromServer.most_liked_comment == null) {
            return;
        }
        RubinoCommentObject rubinoCommentObject = new RubinoCommentObject();
        this.mostLikeComment = rubinoCommentObject;
        rubinoCommentObject.setComment(this.post.most_liked_comment, this.currentAccount);
    }

    private void calculateSize() {
        int i;
        Rubino.PostObjectFromServer postObjectFromServer = this.post;
        int i2 = postObjectFromServer.width;
        if (i2 > 0 && (i = postObjectFromServer.height) > 0) {
            float f = i / i2;
            if (f > 1.3333334f) {
                f = 1.3333334f;
            }
            if (f < 0.5625f) {
                f = 0.5625f;
            }
            this.viewHWRatio = f;
        } else {
            this.viewHWRatio = 1.0f;
        }
        this.viewPagerHeight = (int) (this.viewHWRatio * DimensionHelper.getInstaPostMaxWidth(ApplicationLoader.applicationActivity));
    }

    private void setIsMyPost() {
        String str;
        Rubino.PostObjectFromServer postObjectFromServer = this.post;
        this.isMyPost = (postObjectFromServer == null || (str = postObjectFromServer.profile_id) == null || !str.equals(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)) ? false : true;
    }

    public void createProfile() {
        if (this.post == null || this.profile != null) {
            return;
        }
        RubinoProfileObject rubinoProfileObject = new RubinoProfileObject();
        this.profile = rubinoProfileObject;
        Rubino.PostObjectFromServer postObjectFromServer = this.post;
        rubinoProfileObject.id = postObjectFromServer.profile_id;
        String str = postObjectFromServer.full_post_profile_thumbnail_url;
        rubinoProfileObject.full_thumbnail_url = str;
        rubinoProfileObject.full_photo_url = str;
        String str2 = postObjectFromServer.post_profile_username;
        rubinoProfileObject.username = str2 != null ? str2.toLowerCase() : null;
        RubinoProfileObject rubinoProfileObject2 = this.profile;
        rubinoProfileObject2.store_id = this.post.profile_store_id;
        if (rubinoProfileObject2.username != null) {
            rubinoProfileObject2.createUsernameSpan();
        }
    }

    public void createMedia() {
        int i;
        ArrayList<Rubino.PostFileObject> arrayList;
        ArrayList arrayList2 = new ArrayList();
        PhotoSlideObject photoSlideObject = new PhotoSlideObject(arrayList2);
        this.photoSlideObject = photoSlideObject;
        photoSlideObject.reqCellHeight = this.viewPagerHeight;
        Rubino.PostObjectFromServer postObjectFromServer = this.post;
        if (postObjectFromServer == null) {
            return;
        }
        Rubino.FileTypeEnum fileTypeEnum = postObjectFromServer.file_type;
        if (fileTypeEnum == null || fileTypeEnum == Rubino.FileTypeEnum.Picture) {
            PhotoViewerObject photoViewerObject = new PhotoViewerObject();
            Rubino.PostObjectFromServer postObjectFromServer2 = this.post;
            photoViewerObject.setForPicture(postObjectFromServer2.id, postObjectFromServer2.full_file_url);
            arrayList2.add(photoViewerObject);
        } else if (fileTypeEnum == Rubino.FileTypeEnum.Video) {
            PhotoViewerObject photoViewerObject2 = new PhotoViewerObject();
            photoViewerObject2.size = 400000000;
            Rubino.PostObjectFromServer postObjectFromServer3 = this.post;
            photoViewerObject2.setForVideo(postObjectFromServer3.id, postObjectFromServer3.full_snapshot_url, postObjectFromServer3.full_file_url, postObjectFromServer3.width, postObjectFromServer3.height, (int) postObjectFromServer3.duration, postObjectFromServer3.show_type);
            arrayList2.add(photoViewerObject2);
        }
        Rubino.PostObjectFromServer postObjectFromServer4 = this.post;
        if (postObjectFromServer4.is_multi_file && (arrayList = postObjectFromServer4.file_list) != null) {
            Iterator<Rubino.PostFileObject> it = arrayList.iterator();
            while (it.hasNext()) {
                Rubino.PostFileObject next = it.next();
                Rubino.FileTypeEnum fileTypeEnum2 = next.file_type;
                if (fileTypeEnum2 == Rubino.FileTypeEnum.Picture || fileTypeEnum2 == null) {
                    PhotoViewerObject photoViewerObject3 = new PhotoViewerObject();
                    photoViewerObject3.setForPicture(this.post.id, next.full_file_url);
                    arrayList2.add(photoViewerObject3);
                } else if (fileTypeEnum2 == Rubino.FileTypeEnum.Video) {
                    PhotoViewerObject photoViewerObject4 = new PhotoViewerObject();
                    photoViewerObject4.size = 400000000;
                    Rubino.PostObjectFromServer postObjectFromServer5 = this.post;
                    photoViewerObject4.setForVideo(postObjectFromServer5.id, next.full_snapshot_url, next.full_file_url, postObjectFromServer5.width, postObjectFromServer5.height, next.duration, postObjectFromServer5.show_type);
                    arrayList2.add(photoViewerObject4);
                }
            }
        }
        ArrayList<Rubino.TagProfileObject> arrayList3 = this.post.tagged_profiles;
        if (arrayList3 == null || arrayList3.isEmpty()) {
            return;
        }
        Iterator<Rubino.TagProfileObject> it2 = this.post.tagged_profiles.iterator();
        while (it2.hasNext()) {
            Rubino.TagProfileObject next2 = it2.next();
            if (next2 != null && (i = next2.file_index) >= 0 && i < arrayList2.size()) {
                PhotoViewerObject photoViewerObject5 = (PhotoViewerObject) arrayList2.get(next2.file_index);
                if (photoViewerObject5.postTags == null) {
                    photoViewerObject5.postTags = new ArrayList();
                }
                PostTagObject postTagObject = new PostTagObject();
                Rubino.GeneralPosition generalPosition = next2.position;
                if (generalPosition != null) {
                    postTagObject.yPositionPercent = generalPosition.y;
                    postTagObject.xPositionPercent = generalPosition.x;
                }
                postTagObject.profileId = next2.profile_id;
                postTagObject.profileObject = RubinoController.getInstance(this.currentAccount).getTaggedRubinoProfileObject(next2.profile_id);
                postTagObject.tagType = PostTagType.USER;
                photoViewerObject5.postTags.add(postTagObject);
            }
        }
    }

    public String getPersianCreateDateString() {
        try {
            if (this.post == null) {
                return BuildConfig.FLAVOR;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.post.create_date.longValue() * 1000);
            return NumberUtils.toPersian(DateFormatUtils.getAgoTime(calendar.getTime()));
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    public void createCaptionSpan() {
        String str;
        Rubino.PostObjectFromServer postObjectFromServer = this.post;
        if (postObjectFromServer == null || (str = postObjectFromServer.caption) == null || str.length() <= 0) {
            return;
        }
        this.captionSpannableString = getNameAndTextWithHashtagSpan(this.post.caption);
    }

    public void createShortCaptionInStorySpan() {
        String strSubstring;
        String strSubstring2;
        String str;
        Rubino.PostObjectFromServer postObjectFromServer = this.post;
        if (postObjectFromServer != null) {
            int iCountLines = AndroidUtilities.countLines(postObjectFromServer.caption);
            if (iCountLines <= 2 && ((str = this.post.caption) == null || str.length() <= 50)) {
                this.shortCaptionInStorySpannableString = null;
                return;
            }
            String str2 = BuildConfig.FLAVOR;
            try {
                if (iCountLines > 2) {
                    String strSubstring3 = this.post.caption;
                    for (int i = 0; i < 2; i++) {
                        int iIndexOf = strSubstring3.indexOf("\n");
                        if (iIndexOf < 0) {
                            iIndexOf = strSubstring3.indexOf("\r");
                        }
                        strSubstring3 = strSubstring3.substring(iIndexOf + 1);
                    }
                    String str3 = this.post.caption;
                    strSubstring2 = str3.substring(0, str3.length() - strSubstring3.length());
                } else {
                    strSubstring2 = this.post.caption.substring(0, Math.min(50, this.post.caption.length()));
                }
                str2 = strSubstring2;
                int length = str2.length();
                int i2 = 0;
                while (i2 < 10) {
                    char cCharAt = str2.charAt((length - 1) - i2);
                    if (!SpanHelper.isLetter(cCharAt) && !SpanHelper.isPersianLetter(cCharAt)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                strSubstring = str2.substring(0, (length - 1) - i2);
            } catch (Exception unused) {
                this.shortCaptionInStorySpannableString = null;
                strSubstring = str2;
            }
            if (strSubstring.length() > 0) {
                String string = LocaleController.getString(R.string.rubinoShowMore);
                SpannableString nameAndTextWithHashtagSpan = getNameAndTextWithHashtagSpan(strSubstring + string);
                this.shortCaptionInStorySpannableString = nameAndTextWithHashtagSpan;
                int iLastIndexOf = nameAndTextWithHashtagSpan.toString().lastIndexOf(string);
                this.shortCaptionInStorySpannableString.setSpan(new RubinoShowMoreSpan(Theme.getColor(Theme.key_rubinoGrayColor)), iLastIndexOf, string.length() + iLastIndexOf, 33);
                return;
            }
            this.shortCaptionInStorySpannableString = null;
        }
    }

    public void createShortCaptionSpan() {
        String str;
        this.shortCaption = BuildConfig.FLAVOR;
        Rubino.PostObjectFromServer postObjectFromServer = this.post;
        if (postObjectFromServer != null) {
            int iCountLines = AndroidUtilities.countLines(postObjectFromServer.caption);
            if (iCountLines <= 5 && ((str = this.post.caption) == null || str.length() <= 150)) {
                this.shortCaption = BuildConfig.FLAVOR;
                return;
            }
            try {
                if (iCountLines > 5) {
                    String strSubstring = this.post.caption;
                    for (int i = 0; i < 5; i++) {
                        int iIndexOf = strSubstring.indexOf("\n");
                        if (iIndexOf < 0) {
                            iIndexOf = strSubstring.indexOf("\r");
                        }
                        strSubstring = strSubstring.substring(iIndexOf + 1);
                    }
                    String str2 = this.post.caption;
                    this.shortCaption = str2.substring(0, str2.length() - strSubstring.length());
                } else {
                    this.shortCaption = this.post.caption.substring(0, Math.min(ImageReceiver.DEFAULT_CROSSFADE_DURATION, this.post.caption.length()));
                }
                int length = this.shortCaption.length();
                int i2 = 0;
                while (i2 < 10) {
                    char cCharAt = this.shortCaption.charAt((length - 1) - i2);
                    if (!SpanHelper.isLetter(cCharAt) && !SpanHelper.isPersianLetter(cCharAt)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                this.shortCaption = this.shortCaption.substring(0, (length - 1) - i2);
                String string = LocaleController.getString(R.string.rubinoShowMore);
                SpannableString nameAndTextWithHashtagSpan = getNameAndTextWithHashtagSpan(this.shortCaption + string);
                this.shortCaptionSpannableString = nameAndTextWithHashtagSpan;
                int iLastIndexOf = nameAndTextWithHashtagSpan.toString().lastIndexOf(string);
                this.shortCaptionSpannableString.setSpan(new RubinoShowMoreSpan(Theme.getColor(Theme.key_rubinoGrayColor)), iLastIndexOf, string.length() + iLastIndexOf, 33);
            } catch (Exception unused) {
                this.shortCaption = BuildConfig.FLAVOR;
            }
        }
    }

    private SpannableString getNameAndTextWithHashtagSpan(String str) {
        String str2;
        RubinoProfileObject rubinoProfileObject = this.profile;
        if (rubinoProfileObject != null && rubinoProfileObject.usernameSpannableString == null) {
            rubinoProfileObject.createUsernameSpan();
        }
        RubinoProfileObject rubinoProfileObject2 = this.profile;
        String str3 = BuildConfig.FLAVOR;
        if (rubinoProfileObject2 != null && (str2 = rubinoProfileObject2.username) != null) {
            str3 = str2;
        }
        SpannableString spannableString = new SpannableString(TextUtils.concat(str3, " " + str));
        if (ApplicationLoader.applicationActivity != null) {
            spannableString.setSpan(new RubinoUsernameSpan(Theme.getColor(Theme.key_rubinoBlackColor), str3), 0, str3.length(), 17);
        }
        Rubino.addMentionAndHashtags(spannableString);
        return spannableString;
    }

    public void createLikeCountSpan() {
        if (this.post != null) {
            String string = LocaleController.getString(R.string.rubinoLike);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(NumberUtils.setCommaFormat(this.post.likes_count + BuildConfig.FLAVOR));
            sb2.append(" ");
            sb.append(NumberUtils.toPersian(sb2.toString()));
            sb.append(string);
            this.likeCountSpannableString = new SpannableString(sb.toString());
        }
    }

    public void createViewCountSpan() {
        if (this.post != null) {
            String string = LocaleController.getString(R.string.rubinoView);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(NumberUtils.setCommaFormat(this.post.video_view_count + BuildConfig.FLAVOR));
            sb2.append(" ");
            sb.append(NumberUtils.toPersian(sb2.toString()));
            sb.append(string);
            this.viewCountSpannableString = new SpannableString(sb.toString());
        }
    }

    public void createCommentCountSpan() {
        Rubino.PostObjectFromServer postObjectFromServer = this.post;
        if (postObjectFromServer == null || postObjectFromServer.comment_count <= 0) {
            return;
        }
        this.commentCountSpannableString = new SpannableString(LocaleController.getString(R.string.rubinoCommentView) + " " + NumberUtils.toPersian(EditTextCostPresenter.setFormat(this.post.comment_count + BuildConfig.FLAVOR)) + " " + LocaleController.getString(R.string.rubinoComment) + "...");
    }

    public RubinoProfileObject getProfileTryFromMap() {
        RubinoProfileObject rubinoProfileObject = RubinoController.getInstance(this.currentAccount).profileMap.get(this.post.profile_id);
        if (rubinoProfileObject != null) {
            this.profile = rubinoProfileObject;
            return rubinoProfileObject;
        }
        return this.profile;
    }

    public String getMainPhotoUrl() {
        Rubino.PostObjectFromServer postObjectFromServer = this.post;
        if (postObjectFromServer.file_type == Rubino.FileTypeEnum.Picture) {
            return postObjectFromServer.full_file_url;
        }
        return postObjectFromServer.full_snapshot_url;
    }
}
