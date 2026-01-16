package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIView.InsStoryAvatarView;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class ProfileOrHashtagCell extends FrameLayout {
    private static int type_hashtag = 1;
    private static int type_profile;
    private final ColorMatrix cm;
    public View container;
    public boolean controllClick;
    int currentAccount;
    public Rubino.HashtagObject currentHashtag;
    public RubinoProfileObject currentProfile;
    public TextView followOrUnblockButton;
    public TextView followingOrRequestedButton;
    private final Paint grayscalePaint;
    boolean hasButton;
    public ImageView imageViewHashtag;
    boolean isClickConsumed;
    private boolean isEnable;
    public Context mContext;
    View.OnClickListener onCancelRequestClick;
    View.OnClickListener onFollowClick;
    View.OnClickListener onUnblockClick;
    View.OnClickListener onUnfollowClick;
    View.OnClickListener onUserClickListener;
    public View textContainer;
    public TextView textView1;
    public TextView textView2;
    private int type;
    public InsStoryAvatarView userImageView;

    public ProfileOrHashtagCell(Context context, boolean z, boolean z2) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.hasButton = false;
        this.controllClick = true;
        this.isEnable = true;
        Paint paint = new Paint();
        this.grayscalePaint = paint;
        ColorMatrix colorMatrix = new ColorMatrix();
        this.cm = colorMatrix;
        this.onFollowClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileOrHashtagCell.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ProfileOrHashtagCell.this.isEnable) {
                    ProfileOrHashtagCell profileOrHashtagCell = ProfileOrHashtagCell.this;
                    if (profileOrHashtagCell.currentProfile == null || RubinoController.getInstance(profileOrHashtagCell.currentAccount).isProfileFollowed(ProfileOrHashtagCell.this.currentProfile)) {
                        return;
                    }
                    ProfileOrHashtagCell profileOrHashtagCell2 = ProfileOrHashtagCell.this;
                    profileOrHashtagCell2.isClickConsumed = true;
                    RubinoController.getInstance(profileOrHashtagCell2.currentAccount).doFollowUnfollowAction(ProfileOrHashtagCell.this.currentProfile, Rubino.FollowActionTypeEnum.Follow);
                }
            }
        };
        this.onUnfollowClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileOrHashtagCell.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ProfileOrHashtagCell.this.isEnable) {
                    ProfileOrHashtagCell profileOrHashtagCell = ProfileOrHashtagCell.this;
                    if (profileOrHashtagCell.currentProfile == null || !RubinoController.getInstance(profileOrHashtagCell.currentAccount).isProfileFollowed(ProfileOrHashtagCell.this.currentProfile)) {
                        return;
                    }
                    ProfileOrHashtagCell profileOrHashtagCell2 = ProfileOrHashtagCell.this;
                    profileOrHashtagCell2.isClickConsumed = true;
                    RubinoController.getInstance(profileOrHashtagCell2.currentAccount).doFollowUnfollowAction(ProfileOrHashtagCell.this.currentProfile, Rubino.FollowActionTypeEnum.Unfollow);
                }
            }
        };
        this.onUnblockClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileOrHashtagCell.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ProfileOrHashtagCell.this.isEnable) {
                    ProfileOrHashtagCell profileOrHashtagCell = ProfileOrHashtagCell.this;
                    if (profileOrHashtagCell.currentProfile == null || !RubinoController.getInstance(profileOrHashtagCell.currentAccount).isProfileBlocked(ProfileOrHashtagCell.this.currentProfile)) {
                        return;
                    }
                    ProfileOrHashtagCell profileOrHashtagCell2 = ProfileOrHashtagCell.this;
                    profileOrHashtagCell2.isClickConsumed = true;
                    RubinoController.getInstance(profileOrHashtagCell2.currentAccount).onBlockClick(ProfileOrHashtagCell.this.currentProfile, null);
                }
            }
        };
        this.onCancelRequestClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileOrHashtagCell.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ProfileOrHashtagCell.this.isEnable) {
                    ProfileOrHashtagCell profileOrHashtagCell = ProfileOrHashtagCell.this;
                    if (profileOrHashtagCell.currentProfile != null) {
                        profileOrHashtagCell.isClickConsumed = true;
                        RubinoController.getInstance(profileOrHashtagCell.currentAccount).unFollowClickWithDialogIfNeeded(ProfileOrHashtagCell.this.currentProfile, null);
                    }
                }
            }
        };
        this.onUserClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileOrHashtagCell.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ProfileOrHashtagCell.this.controllClick && ApplicationLoader.applicationActivity != null) {
                    if (ProfileOrHashtagCell.this.type != ProfileOrHashtagCell.type_profile || ProfileOrHashtagCell.this.currentProfile == null) {
                        if (ProfileOrHashtagCell.this.type != ProfileOrHashtagCell.type_hashtag || ProfileOrHashtagCell.this.currentHashtag == null) {
                            return;
                        }
                        new MainClickHandler().onInstaHashTagClicked(ProfileOrHashtagCell.this.currentHashtag.content);
                        return;
                    }
                    new MainClickHandler().onRubinoProfileClick(ProfileOrHashtagCell.this.currentProfile);
                }
            }
        };
        this.mContext = context;
        this.hasButton = z;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.rubino_profile_or_hashtag_row, (ViewGroup) null, false);
        addView(viewGroup);
        this.textView1 = (TextView) viewGroup.findViewById(R.id.textView1);
        this.textView2 = (TextView) viewGroup.findViewById(R.id.textView2);
        TextView textView = this.textView1;
        int i = Theme.key_rubinoBlackColor;
        textView.setTextColor(Theme.getColor(i));
        TextView textView2 = this.textView2;
        int i2 = Theme.key_rubinoGrayColor;
        textView2.setTextColor(Theme.getColor(i2));
        this.textContainer = viewGroup.findViewById(R.id.textContainer);
        this.userImageView = (InsStoryAvatarView) viewGroup.findViewById(R.id.imageViewUser);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.imageViewHashtag);
        this.imageViewHashtag = imageView;
        imageView.setColorFilter(Theme.getColor(i), PorterDuff.Mode.SRC_ATOP);
        ((GradientDrawable) this.imageViewHashtag.getBackground()).setStroke(AndroidUtilities.dp(0.65f), Theme.getColor(i2));
        this.followOrUnblockButton = (TextView) viewGroup.findViewById(R.id.followButton);
        TextView textView3 = (TextView) viewGroup.findViewById(R.id.followingButton);
        this.followingOrRequestedButton = textView3;
        textView3.setTextColor(Theme.getColor(i));
        GradientDrawable gradientDrawable = (GradientDrawable) ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.rubino_shape_white_border).mutate();
        gradientDrawable.setStroke(AndroidUtilities.dp(1.0f), Theme.getColor(Theme.key_rubinoFollowingBorderColor));
        this.followingOrRequestedButton.setBackground(gradientDrawable);
        this.followingOrRequestedButton.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
        this.container = viewGroup.findViewById(R.id.container);
        if (z2) {
            this.textView1.setTypeface(Theme.getRubinoTypeFaceMedium());
            this.textView2.setTypeface(Theme.getRubinoTypeFaceMedium());
        } else {
            this.textView1.setTypeface(Theme.getRubinoTypeFaceRegular());
            this.textView2.setTypeface(Theme.getRubinoTypeFaceRegular());
        }
        this.followOrUnblockButton.setTypeface(Theme.getRubinoTypeFaceBold());
        this.followingOrRequestedButton.setTypeface(Theme.getRubinoTypeFaceBold());
        this.container.setOnClickListener(this.onUserClickListener);
        this.userImageView.setOnClickListener(this.onUserClickListener);
        this.followOrUnblockButton.setOnClickListener(this.onFollowClick);
        if (z) {
            ((FrameLayout.LayoutParams) this.textContainer.getLayoutParams()).leftMargin = AndroidUtilities.dp(128.0f);
        } else {
            ((FrameLayout.LayoutParams) this.textContainer.getLayoutParams()).leftMargin = AndroidUtilities.dp(16.0f);
        }
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    public void setProfile(RubinoProfileObject rubinoProfileObject, int i) {
        this.type = type_profile;
        this.imageViewHashtag.setVisibility(8);
        this.currentProfile = rubinoProfileObject;
        setButtons();
        CharSequence charSequence = BuildConfig.FLAVOR;
        if (rubinoProfileObject != null) {
            TextView textView = this.textView1;
            CharSequence charSequence2 = rubinoProfileObject.usernameSpannableString;
            if (charSequence2 != null) {
                charSequence = charSequence2;
            }
            textView.setText(charSequence);
            this.textView2.setText(rubinoProfileObject.name);
            this.userImageView.setVisibility(0);
            GlideHelper.loadCircle(this.mContext, this.userImageView, rubinoProfileObject.full_thumbnail_url, R.drawable.placeholder_avatar_man);
            this.isEnable = rubinoProfileObject.isEnableForTag;
        } else {
            this.userImageView.setVisibility(4);
            this.textView1.setText(BuildConfig.FLAVOR);
            this.textView2.setText(BuildConfig.FLAVOR);
            this.isEnable = true;
        }
        setAlpha(this.isEnable ? 1.0f : 0.3f);
    }

    public void setHashtag(Rubino.HashtagObject hashtagObject, int i) {
        this.type = type_hashtag;
        this.isEnable = true;
        this.userImageView.setVisibility(8);
        this.hasButton = false;
        this.currentHashtag = hashtagObject;
        setButtons();
        if (hashtagObject != null) {
            this.textView1.setText("#" + this.currentHashtag.content);
            this.textView2.setText(this.currentHashtag.postCountString);
            this.imageViewHashtag.setVisibility(0);
        } else {
            this.imageViewHashtag.setVisibility(4);
            this.textView1.setText(BuildConfig.FLAVOR);
            this.textView2.setText(BuildConfig.FLAVOR);
        }
        setAlpha(this.isEnable ? 1.0f : 0.3f);
    }

    public void setButtons() {
        String str = AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id;
        if (this.type == type_hashtag || this.currentProfile.id.equals(str) || !this.hasButton) {
            this.followOrUnblockButton.setVisibility(8);
            this.followingOrRequestedButton.setVisibility(8);
            return;
        }
        this.followOrUnblockButton.setVisibility(8);
        this.followingOrRequestedButton.setVisibility(8);
        if (RubinoController.getInstance(this.currentAccount).isProfileBlocked(this.currentProfile)) {
            this.followOrUnblockButton.setVisibility(0);
            this.followOrUnblockButton.setText(LocaleController.getString(R.string.rubinoUnBlock));
            this.followOrUnblockButton.setOnClickListener(this.onUnblockClick);
        } else if (RubinoController.getInstance(this.currentAccount).isProfileFollowed(this.currentProfile)) {
            this.followingOrRequestedButton.setVisibility(0);
            this.followingOrRequestedButton.setText(LocaleController.getString(R.string.rubinoIsFollowed));
            this.followingOrRequestedButton.setOnClickListener(this.onUnfollowClick);
        } else if (RubinoController.getInstance(this.currentAccount).isProfileFollowRequested(this.currentProfile)) {
            this.followingOrRequestedButton.setVisibility(0);
            this.followingOrRequestedButton.setText(LocaleController.getString(R.string.rubinoIsRequested));
            this.followingOrRequestedButton.setOnClickListener(this.onCancelRequestClick);
        } else {
            this.followOrUnblockButton.setVisibility(0);
            this.followOrUnblockButton.setText(LocaleController.getString(R.string.rubinoFollowAction));
            this.followOrUnblockButton.setOnClickListener(this.onFollowClick);
        }
    }

    public boolean isEnable() {
        return this.isEnable;
    }
}
