package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIView.InsStoryAvatarView;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.model.StoryListOfAProfileObject;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class StoryProfileCell extends FrameLayout {
    private int currentAccount;
    public StoryListOfAProfileObject currentStoryProfile;
    public InsStoryAvatarView imageView;
    public Context mContext;
    public TextView textView1;

    public StoryProfileCell(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.mContext = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.stroy_profile_cell_2, (ViewGroup) null, false);
        addView(viewGroup);
        this.textView1 = (TextView) viewGroup.findViewById(R.id.textView1);
        this.imageView = (InsStoryAvatarView) viewGroup.findViewById(R.id.imageView);
        viewGroup.findViewById(R.id.linearLayout);
        this.textView1.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textView1.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
    }

    public void setProfile(StoryListOfAProfileObject storyListOfAProfileObject) {
        this.currentStoryProfile = storyListOfAProfileObject;
        bindData();
    }

    public void bindData() {
        if (this.currentStoryProfile.getProfileTryFromMap().hasThumbnail()) {
            GlideHelper.loadCircle(this.mContext, this.imageView, this.currentStoryProfile.getProfileTryFromMap().full_thumbnail_url, R.drawable.rubino_grey_avatar_placeholder);
        } else {
            this.imageView.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.placeholder_avatar_man));
        }
        setStoryNameText();
        setStoryStatus();
    }

    private void setStoryNameText() {
        this.textView1.setText(this.currentStoryProfile.getProfileTryFromMap().getUsername());
        if (this.currentStoryProfile.getProfileTryFromMap().is_verified || this.currentStoryProfile.getProfileTryFromMap().sale_permission) {
            this.textView1.setCompoundDrawablePadding(AndroidUtilities.dp(2.0f));
            if (this.currentStoryProfile.getProfileTryFromMap().sale_permission) {
                this.textView1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sale_permission_small, 0);
                return;
            } else {
                this.textView1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_insta_verified_small, 0);
                return;
            }
        }
        this.textView1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    public void setStoryStatus() {
        this.textView1.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
        StoryController.ProfileStoryStatusEnum profileStoriesStatus = StoryController.getInstance(this.currentAccount).getProfileStoriesStatus(this.currentStoryProfile.profileObject.id);
        boolean z = profileStoriesStatus == StoryController.ProfileStoryStatusEnum.NotSeenStory || profileStoriesStatus == StoryController.ProfileStoryStatusEnum.SeenStory;
        StoryListOfAProfileObject storyListOfAProfileObject = this.currentStoryProfile;
        boolean z2 = storyListOfAProfileObject.isLive;
        boolean zEquals = storyListOfAProfileObject.profileObject.id.equals(StoryController.getInstance(this.currentAccount).currentLoadingProfileId);
        String str = this.currentStoryProfile.profileObject.id;
        if (str == null || !str.equals(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)) {
            if (z2) {
                this.imageView.setStatus(InsStoryAvatarView.Status.LIVE);
            } else if (profileStoriesStatus == StoryController.ProfileStoryStatusEnum.SeenStory) {
                this.imageView.setStatus(InsStoryAvatarView.Status.CLICKED);
                this.textView1.setTextColor(Theme.getColor(Theme.key_rubinoGrayColor));
            } else {
                this.imageView.setStatus(InsStoryAvatarView.Status.UNCLICKED);
            }
        } else if (z || z2) {
            setStoryNameText();
            StoryController.ProfileStorySendingStatusEnum myProfileStorySendingStatus = StoryController.getInstance(this.currentAccount).getMyProfileStorySendingStatus();
            if (z2) {
                this.imageView.setStatus(InsStoryAvatarView.Status.LIVE);
            } else if (myProfileStorySendingStatus == StoryController.ProfileStorySendingStatusEnum.ERRORSENDING) {
                this.imageView.setStatus(InsStoryAvatarView.Status.ERRORSENDING);
            } else if (myProfileStorySendingStatus == StoryController.ProfileStorySendingStatusEnum.SENDINGSTORY) {
                this.imageView.setStatus(InsStoryAvatarView.Status.SENDINGSTORY);
            } else {
                this.imageView.setStatus(InsStoryAvatarView.Status.CLICKED);
                this.textView1.setTextColor(Theme.getColor(Theme.key_rubinoGrayColor));
            }
        } else {
            this.imageView.setStatus(InsStoryAvatarView.Status.ADDSTORY);
            this.textView1.setText(LocaleController.getString(R.string.rubinoYourStory));
        }
        if (!zEquals || z2) {
            return;
        }
        this.imageView.setStatus(InsStoryAvatarView.Status.LOADING);
    }
}
