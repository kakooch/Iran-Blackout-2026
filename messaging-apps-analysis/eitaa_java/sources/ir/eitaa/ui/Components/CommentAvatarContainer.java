package ir.eitaa.ui.Components;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class CommentAvatarContainer extends FrameLayout {
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImageView;
    TLRPC$Chat chat;
    private SimpleTextView subtitleTextView;
    private SimpleTextView titleTextView;
    TLRPC$User user;

    public CommentAvatarContainer(Context context) {
        super(context);
        this.avatarDrawable = new AvatarDrawable();
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(21.0f));
        addView(this.avatarImageView);
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.titleTextView = simpleTextView;
        simpleTextView.setTextColor(Theme.getColor("actionBarDefaultTitle"));
        this.titleTextView.setTextSize(18);
        this.titleTextView.setGravity(3);
        this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.titleTextView.setLeftDrawableTopPadding(-AndroidUtilities.dp(1.3f));
        addView(this.titleTextView);
        SimpleTextView simpleTextView2 = new SimpleTextView(context);
        this.subtitleTextView = simpleTextView2;
        simpleTextView2.setTextColor(Theme.getColor("actionBarDefaultSubtitle"));
        this.subtitleTextView.setTextSize(14);
        this.subtitleTextView.setGravity(3);
        this.subtitleTextView.setLeftDrawable(R.drawable.msg_views);
        addView(this.subtitleTextView);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int iDp = size - AndroidUtilities.dp(124.0f);
        this.avatarImageView.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(42.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(42.0f), 1073741824));
        this.titleTextView.measure(View.MeasureSpec.makeMeasureSpec(iDp, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(24.0f), Integer.MIN_VALUE));
        this.subtitleTextView.measure(View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(25.0f) + ((int) this.subtitleTextView.getPaint().measureText(((Object) this.subtitleTextView.getText()) + "")), iDp), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), Integer.MIN_VALUE));
        setMeasuredDimension(size, View.MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int currentActionBarHeight = ((ActionBar.getCurrentActionBarHeight() - AndroidUtilities.dp(42.0f)) / 2) + (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0);
        this.avatarImageView.layout(AndroidUtilities.dp(8.0f), currentActionBarHeight, AndroidUtilities.dp(50.0f), AndroidUtilities.dp(42.0f) + currentActionBarHeight);
        this.titleTextView.layout(AndroidUtilities.dp(62.0f), AndroidUtilities.dp(1.3f) + currentActionBarHeight, AndroidUtilities.dp(62.0f) + this.titleTextView.getMeasuredWidth(), this.titleTextView.getTextHeight() + currentActionBarHeight + AndroidUtilities.dp(1.3f));
        this.subtitleTextView.layout(AndroidUtilities.dp(62.0f), AndroidUtilities.dp(24.0f) + currentActionBarHeight, AndroidUtilities.dp(62.0f) + this.subtitleTextView.getMeasuredWidth(), currentActionBarHeight + this.subtitleTextView.getTextHeight() + AndroidUtilities.dp(24.0f));
    }

    public void setTitle(CharSequence value) {
        this.titleTextView.setText(value);
    }

    public void setChat(TLRPC$Chat chat) {
        this.chat = chat;
    }

    public void setUser(TLRPC$User user) {
        this.user = user;
    }

    public void setSubtitle(CharSequence value) {
        if (value == null || value.length() == 0) {
            this.subtitleTextView.setLeftDrawable(0);
        } else {
            this.subtitleTextView.setLeftDrawable(R.drawable.msg_views);
        }
        this.subtitleTextView.setText(value);
        requestLayout();
    }

    public SimpleTextView getTitleTextView() {
        return this.titleTextView;
    }

    public SimpleTextView getSubtitleTextView() {
        return this.subtitleTextView;
    }

    public void setChatAvatar(TLRPC$Chat chat) {
        TLRPC$ChatPhoto tLRPC$ChatPhoto = chat.photo;
        TLRPC$FileLocation tLRPC$FileLocation = tLRPC$ChatPhoto != null ? tLRPC$ChatPhoto.photo_small : null;
        this.avatarDrawable.setInfo(chat);
        BackupImageView backupImageView = this.avatarImageView;
        if (backupImageView != null) {
            backupImageView.setImage(ImageLocation.getForLocal(tLRPC$FileLocation), (String) null, (String) null, this.avatarDrawable, (Object) null);
        }
    }

    public void setUserAvatar(TLRPC$User user) {
        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = user.photo;
        TLRPC$FileLocation tLRPC$FileLocation = tLRPC$UserProfilePhoto != null ? tLRPC$UserProfilePhoto.photo_small : null;
        this.avatarDrawable.setInfo(user);
        BackupImageView backupImageView = this.avatarImageView;
        if (backupImageView != null) {
            backupImageView.setImage(ImageLocation.getForLocal(tLRPC$FileLocation), (String) null, (String) null, this.avatarDrawable, (Object) null);
        }
    }
}
