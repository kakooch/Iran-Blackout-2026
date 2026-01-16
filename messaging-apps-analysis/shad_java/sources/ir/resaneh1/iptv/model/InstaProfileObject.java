package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class InstaProfileObject extends PresenterItem {
    public String bio;
    public Link chat_link;
    public int count_purchase;
    public int count_sale_unread;
    public Long create_date;
    public String email;
    public String follower_count;
    public String following_count;
    public String full_photo_url;
    public String full_thumbnail_url;
    public boolean hasStory;
    public String id;
    public boolean isAddProfile;
    public boolean isBlocked;
    public boolean isFollowed;
    public boolean isMyProfile;
    public boolean isRequested;
    public boolean is_default;
    public boolean is_message_allowed;
    public boolean is_mute;
    public boolean is_verified;
    public String name;
    public String new_follow_request_count;
    public String new_general_count;
    public String phone;
    public String post_count;
    public ProfileStatusEnum profile_status;
    public InstaFollowRequestObject request;
    public boolean sale_permission;
    public RubinoProfileObject.TagPostEnum tag_post;
    public String username;
    public String website;

    public enum ProfileStatusEnum {
        Public,
        Private
    }

    public InstaProfileObject() {
        this.id = BuildConfig.FLAVOR;
    }

    public InstaProfileObject(String str) {
        this.id = BuildConfig.FLAVOR;
        this.id = str;
    }

    public InstaProfileObject(boolean z) {
        this.id = BuildConfig.FLAVOR;
        this.isAddProfile = z;
    }

    public boolean isPage() {
        return !this.is_default;
    }

    public boolean isPrivate() {
        return this.profile_status != ProfileStatusEnum.Public;
    }

    public boolean isDefault() {
        return this.is_default;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getPresenterId() {
        return this.id;
    }

    public String getName() {
        String str = this.name;
        return (str == null && this.username == null) ? BuildConfig.FLAVOR : str == null ? this.username : str;
    }

    public String getUsername() {
        if (this.username == null) {
            this.username = BuildConfig.FLAVOR;
        }
        return this.username;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getSearchAbleName() {
        return getName() + " " + this.username;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        if (this.isAddProfile) {
            return PresenterItemType.instaAddProfile;
        }
        return PresenterItemType.instaProfile;
    }

    public Long getFollowerCount() {
        try {
            return Long.valueOf(Long.parseLong(this.follower_count));
        } catch (Exception unused) {
            return 0L;
        }
    }

    public Long getFollowingCount() {
        try {
            return Long.valueOf(Long.parseLong(this.following_count));
        } catch (Exception unused) {
            return 0L;
        }
    }

    public int getNewFollowRequestNum() {
        String str = this.new_follow_request_count;
        if (str != null) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getNewEventNum() {
        String str = this.new_general_count;
        if (str != null) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
            }
        }
        return 0;
    }
}
