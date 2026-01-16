package ir.resaneh1.iptv.model;

import android.app.Dialog;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.ObjectInfo;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.RubinoShowMoreSpan;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class RubinoProfileObject {
    public String bio;
    public transient SpannableString bioSpannableString;
    public transient ObjectInfo channel;
    public Link chat_link;
    private transient ArrayList<Rubino.AlertItem> contactItems;
    public int count_purchase;
    public int count_sale_unread;
    public Long create_date;
    public transient int currentAccount;
    public String email;
    public transient String followerCountString;
    public int follower_count;
    public transient String followingCountString;
    public int following_count;
    public String full_photo_url;
    public String full_thumbnail_url;
    public boolean hasLinkItem;
    public String id;
    public transient boolean isAddProfile;
    public transient boolean isBlocked;
    public boolean isEnableForTag;
    public transient boolean isFollowed;
    public transient boolean isMyProfile;
    public transient boolean isRequested;
    public boolean is_default;
    public boolean is_message_allowed;
    public boolean is_mute;
    public boolean is_verified;
    public transient long lastUpdateTime;
    public String name;
    public int new_follow_request_count;
    public int new_general_count;
    public String phone;
    public transient String postCountString;
    public int post_count;
    public ProfileStatusEnum profile_status;
    public transient InstaFollowRequestObject request;
    public boolean sale_permission;
    private transient String shortBio;
    public transient SpannableString shortBioSpannableString;
    public String store_id;
    public TagPostEnum tag_post;
    public String username;
    public transient SpannableString usernameSpannableString;
    public String website;

    public enum ProfileStatusEnum {
        Public,
        Private
    }

    public enum TagPostEnum {
        Everyone,
        Following,
        NoOne
    }

    public enum UpdatedParameterEnum {
        username,
        name,
        bio,
        email,
        avatar,
        website,
        phone,
        status,
        is_message_allowed,
        is_mute,
        tag_post
    }

    public RubinoProfileObject() {
        this.id = BuildConfig.FLAVOR;
        this.isEnableForTag = true;
    }

    public RubinoProfileObject(String str) {
        this.id = BuildConfig.FLAVOR;
        this.isEnableForTag = true;
        this.id = str;
    }

    public RubinoProfileObject(boolean z) {
        this.id = BuildConfig.FLAVOR;
        this.isEnableForTag = true;
        this.isAddProfile = z;
    }

    public boolean hasPhone() {
        String str = this.phone;
        return (str == null || str.isEmpty()) ? false : true;
    }

    public boolean hasEmail() {
        String str = this.email;
        return (str == null || str.isEmpty()) ? false : true;
    }

    public boolean hasChannel() {
        return this.channel != null;
    }

    public boolean hasContact() {
        return hasPhone() || hasEmail() || hasChannel() || hasWebsite();
    }

    public void updateContactInfo() {
        this.contactItems = null;
        getContactInfoArray();
    }

    public ArrayList<Rubino.AlertItem> getContactInfoArray() {
        if (this.contactItems == null) {
            this.contactItems = new ArrayList<>();
            if (hasPhone()) {
                final Rubino.AlertTextValueItem alertTextValueItem = new Rubino.AlertTextValueItem(LocaleController.getString(R.string.rubinoPhone), this.phone);
                alertTextValueItem.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.model.RubinoProfileObject.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new MainClickHandler().callNumber(RubinoProfileObject.this.phone);
                        Dialog dialog = alertTextValueItem.parentDialog;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                    }
                };
                this.contactItems.add(alertTextValueItem);
            }
            if (hasEmail()) {
                final Rubino.AlertTextValueItem alertTextValueItem2 = new Rubino.AlertTextValueItem(LocaleController.getString(R.string.rubinoEmail), this.email);
                alertTextValueItem2.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.model.RubinoProfileObject.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new MainClickHandler().sendEmail(RubinoProfileObject.this.email);
                        Dialog dialog = alertTextValueItem2.parentDialog;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                    }
                };
                this.contactItems.add(alertTextValueItem2);
            }
            if (hasWebsite()) {
                final Rubino.AlertTextValueItem alertTextValueItem3 = new Rubino.AlertTextValueItem(LocaleController.getString(R.string.rubinoWebsite), this.website);
                alertTextValueItem3.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.model.RubinoProfileObject.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new MainClickHandler().openUrl(RubinoProfileObject.this.website);
                        Dialog dialog = alertTextValueItem3.parentDialog;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                    }
                };
                this.contactItems.add(alertTextValueItem3);
            }
            if (hasChannel()) {
                final Rubino.AlertTextValueItem alertTextValueItem4 = new Rubino.AlertTextValueItem(LocaleController.getString(R.string.rubinoChannel), "@" + this.channel.getUserName());
                alertTextValueItem4.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.model.RubinoProfileObject.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new MainClickHandler().openChat(RubinoProfileObject.this.channel);
                        Dialog dialog = alertTextValueItem4.parentDialog;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                    }
                };
                this.contactItems.add(alertTextValueItem4);
            }
        }
        return this.contactItems;
    }

    public boolean hasWebsite() {
        String str = this.website;
        return (str == null || str.isEmpty()) ? false : true;
    }

    public boolean hasThumbnail() {
        String str = this.full_thumbnail_url;
        return (str == null || str.isEmpty()) ? false : true;
    }

    public static RubinoProfileObject createFromOldObject(InstaProfileObject instaProfileObject) {
        if (instaProfileObject == null) {
            return null;
        }
        RubinoProfileObject rubinoProfileObject = new RubinoProfileObject();
        rubinoProfileObject.id = instaProfileObject.id;
        rubinoProfileObject.is_default = instaProfileObject.is_default;
        rubinoProfileObject.bio = instaProfileObject.bio;
        rubinoProfileObject.name = instaProfileObject.name;
        rubinoProfileObject.username = instaProfileObject.username;
        rubinoProfileObject.profile_status = instaProfileObject.profile_status == InstaProfileObject.ProfileStatusEnum.Private ? ProfileStatusEnum.Private : ProfileStatusEnum.Public;
        rubinoProfileObject.full_photo_url = instaProfileObject.full_photo_url;
        rubinoProfileObject.full_thumbnail_url = instaProfileObject.full_thumbnail_url;
        rubinoProfileObject.create_date = instaProfileObject.create_date;
        String str = instaProfileObject.follower_count;
        rubinoProfileObject.follower_count = str != null ? Integer.parseInt(str) : 0;
        rubinoProfileObject.following_count = instaProfileObject.follower_count != null ? Integer.parseInt(instaProfileObject.following_count) : 0;
        rubinoProfileObject.post_count = instaProfileObject.follower_count != null ? Integer.parseInt(instaProfileObject.post_count) : 0;
        rubinoProfileObject.email = instaProfileObject.email;
        String str2 = instaProfileObject.new_follow_request_count;
        rubinoProfileObject.new_follow_request_count = str2 != null ? Integer.parseInt(str2) : 0;
        String str3 = instaProfileObject.new_general_count;
        rubinoProfileObject.new_general_count = str3 != null ? Integer.parseInt(str3) : 0;
        rubinoProfileObject.is_mute = instaProfileObject.is_mute;
        rubinoProfileObject.chat_link = instaProfileObject.chat_link;
        rubinoProfileObject.is_verified = instaProfileObject.is_verified;
        rubinoProfileObject.phone = instaProfileObject.phone;
        rubinoProfileObject.website = instaProfileObject.website;
        rubinoProfileObject.sale_permission = instaProfileObject.sale_permission;
        rubinoProfileObject.count_sale_unread = instaProfileObject.count_sale_unread;
        rubinoProfileObject.count_purchase = instaProfileObject.count_purchase;
        rubinoProfileObject.is_message_allowed = instaProfileObject.is_message_allowed;
        rubinoProfileObject.isFollowed = instaProfileObject.isFollowed;
        rubinoProfileObject.isRequested = instaProfileObject.isRequested;
        rubinoProfileObject.isBlocked = instaProfileObject.isBlocked;
        rubinoProfileObject.isMyProfile = instaProfileObject.isMyProfile;
        rubinoProfileObject.isAddProfile = instaProfileObject.isAddProfile;
        rubinoProfileObject.tag_post = instaProfileObject.tag_post;
        return rubinoProfileObject;
    }

    public static InstaProfileObject convertToOldObject(RubinoProfileObject rubinoProfileObject) {
        if (rubinoProfileObject == null) {
            return null;
        }
        InstaProfileObject instaProfileObject = new InstaProfileObject();
        instaProfileObject.id = rubinoProfileObject.id;
        instaProfileObject.is_default = rubinoProfileObject.is_default;
        instaProfileObject.bio = rubinoProfileObject.bio;
        instaProfileObject.name = rubinoProfileObject.name;
        instaProfileObject.username = rubinoProfileObject.username;
        instaProfileObject.profile_status = rubinoProfileObject.profile_status == ProfileStatusEnum.Private ? InstaProfileObject.ProfileStatusEnum.Private : InstaProfileObject.ProfileStatusEnum.Public;
        instaProfileObject.full_photo_url = rubinoProfileObject.full_photo_url;
        instaProfileObject.full_thumbnail_url = rubinoProfileObject.full_thumbnail_url;
        instaProfileObject.create_date = rubinoProfileObject.create_date;
        instaProfileObject.follower_count = rubinoProfileObject.follower_count + BuildConfig.FLAVOR;
        instaProfileObject.following_count = rubinoProfileObject.following_count + BuildConfig.FLAVOR;
        instaProfileObject.post_count = rubinoProfileObject.post_count + BuildConfig.FLAVOR;
        instaProfileObject.email = rubinoProfileObject.email;
        instaProfileObject.new_follow_request_count = rubinoProfileObject.new_follow_request_count + BuildConfig.FLAVOR;
        instaProfileObject.new_general_count = rubinoProfileObject.new_general_count + BuildConfig.FLAVOR;
        instaProfileObject.is_mute = rubinoProfileObject.is_mute;
        instaProfileObject.chat_link = rubinoProfileObject.chat_link;
        instaProfileObject.is_verified = rubinoProfileObject.is_verified;
        instaProfileObject.phone = rubinoProfileObject.phone;
        instaProfileObject.website = rubinoProfileObject.website;
        instaProfileObject.sale_permission = rubinoProfileObject.sale_permission;
        instaProfileObject.count_sale_unread = rubinoProfileObject.count_sale_unread;
        instaProfileObject.count_purchase = rubinoProfileObject.count_purchase;
        instaProfileObject.is_message_allowed = rubinoProfileObject.is_message_allowed;
        instaProfileObject.isFollowed = rubinoProfileObject.isFollowed;
        instaProfileObject.isRequested = rubinoProfileObject.isRequested;
        instaProfileObject.isBlocked = rubinoProfileObject.isBlocked;
        instaProfileObject.isMyProfile = rubinoProfileObject.isMyProfile;
        instaProfileObject.isAddProfile = rubinoProfileObject.isAddProfile;
        instaProfileObject.tag_post = rubinoProfileObject.tag_post;
        return instaProfileObject;
    }

    public boolean isPage() {
        return !isDefault();
    }

    public boolean isPrivate() {
        return this.profile_status != ProfileStatusEnum.Public;
    }

    public boolean isDefault() {
        if (this.is_default) {
            return true;
        }
        if (!AppRubinoPreferences.getInstance(this.currentAccount).getRubinoDefaultProfileObject().id.equals(this.id)) {
            return false;
        }
        this.is_default = true;
        return true;
    }

    public void createShortBioSpan() {
        this.shortBio = BuildConfig.FLAVOR;
        String str = this.bio;
        if (str != null) {
            int iCountLines = AndroidUtilities.countLines(str);
            if (iCountLines <= 5 && this.bio.length() <= 150) {
                this.shortBio = BuildConfig.FLAVOR;
                return;
            }
            try {
                if (iCountLines > 5) {
                    String strSubstring = this.bio;
                    for (int i = 0; i < 5; i++) {
                        int iIndexOf = strSubstring.indexOf("\n");
                        if (iIndexOf < 0) {
                            iIndexOf = strSubstring.indexOf("\r");
                        }
                        strSubstring = strSubstring.substring(iIndexOf + 1);
                    }
                    String str2 = this.bio;
                    this.shortBio = str2.substring(0, str2.length() - strSubstring.length());
                } else {
                    this.shortBio = this.bio.substring(0, Math.min(ImageReceiver.DEFAULT_CROSSFADE_DURATION, this.bio.length()));
                }
                int length = this.shortBio.length();
                int i2 = 0;
                while (i2 < 10) {
                    char cCharAt = this.shortBio.charAt((length - 1) - i2);
                    if (!SpanHelper.isLetter(cCharAt) && !SpanHelper.isPersianLetter(cCharAt)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                this.shortBio = this.shortBio.substring(0, (length - 1) - i2);
                String string = LocaleController.getString(R.string.rubinoShowMore);
                SpannableString spannableString = new SpannableString(this.shortBio + string);
                this.shortBioSpannableString = spannableString;
                Rubino.addMentionAndHashtags(spannableString);
                int iIndexOf2 = this.shortBioSpannableString.toString().indexOf(string);
                this.shortBioSpannableString.setSpan(new RubinoShowMoreSpan(Theme.getColor(Theme.key_rubinoGrayColor)), iIndexOf2, string.length() + iIndexOf2, 33);
            } catch (Exception unused) {
                this.shortBio = BuildConfig.FLAVOR;
            }
        }
    }

    public void createBioSpan() {
        String str = this.bio;
        if (str == null || str.isEmpty()) {
            return;
        }
        SpannableString spannableString = new SpannableString(this.bio);
        Rubino.addMentionAndHashtags(spannableString);
        this.bioSpannableString = spannableString;
    }

    public void createUsernameSpan() {
        if (this.username == null) {
            return;
        }
        RubinoProfileObject instantProfileInfoFromMapIfExist = RubinoController.getInstance(this.currentAccount).getInstantProfileInfoFromMapIfExist(this.id);
        boolean z = this.is_verified || (instantProfileInfoFromMapIfExist != null && instantProfileInfoFromMapIfExist.is_verified);
        boolean z2 = this.sale_permission || (instantProfileInfoFromMapIfExist != null && instantProfileInfoFromMapIfExist.sale_permission);
        if (z || z2) {
            this.usernameSpannableString = new SpannableString(this.username + "  ");
            ImageSpan imageSpanVerifyOrSale = RubinoController.getInstance(this.currentAccount).getImageSpanVerifyOrSale(z, z2, 16, 0);
            if (imageSpanVerifyOrSale != null) {
                int length = this.username.length() + 1;
                this.usernameSpannableString.setSpan(imageSpanVerifyOrSale, length, length + 1, 17);
                return;
            }
            return;
        }
        this.usernameSpannableString = new SpannableString(this.username);
    }

    public void createCountString() {
        int i = this.post_count;
        this.postCountString = i >= 0 ? NumberUtils.toCuteStringWithKOrMEnglish(i) : "0";
        int i2 = this.follower_count;
        this.followerCountString = i2 >= 0 ? NumberUtils.toCuteStringWithKOrMEnglish(i2) : "0";
        int i3 = this.following_count;
        this.followingCountString = i3 >= 0 ? NumberUtils.toCuteStringWithKOrMEnglish(i3) : "0";
    }

    public void makeData(int i) {
        this.currentAccount = i;
        createCountString();
        createBioSpan();
        createUsernameSpan();
        createShortBioSpan();
    }

    public String getName() {
        String str = this.name;
        return (str == null && this.username == null) ? BuildConfig.FLAVOR : str == null ? this.username : str;
    }

    public String getUsername() {
        if (this.username == null) {
            this.username = BuildConfig.FLAVOR;
        }
        return this.username.toLowerCase();
    }

    public boolean isMyCurrentProfile() {
        try {
            return AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id.equals(this.id);
        } catch (Exception unused) {
            return false;
        }
    }
}
