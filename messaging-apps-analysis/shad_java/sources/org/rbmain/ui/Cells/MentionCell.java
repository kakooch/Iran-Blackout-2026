package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatPhoto;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserProfilePhoto;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AnimatedEmojiDrawable;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes4.dex */
public class MentionCell extends LinearLayout {
    private boolean attached;
    private AvatarDrawable avatarDrawable;
    private Drawable emojiDrawable;
    private BackupImageView imageView;
    private TextView nameTextView;
    private boolean needsDivider;
    private Theme.ResourcesProvider resourcesProvider;
    private TextView usernameTextView;

    public MentionCell(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.needsDivider = false;
        this.resourcesProvider = resourcesProvider;
        setOrientation(0);
        AvatarDrawable avatarDrawable = new AvatarDrawable();
        this.avatarDrawable = avatarDrawable;
        avatarDrawable.setTextSize(AndroidUtilities.dp(18.0f));
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(14.0f));
        addView(this.imageView, LayoutHelper.createLinear(28, 28, 12.0f, 4.0f, 0.0f, 0.0f));
        TextView textView = new TextView(this, context) { // from class: org.rbmain.ui.Cells.MentionCell.1
            @Override // android.widget.TextView
            public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
                super.setText(Emoji.replaceEmoji(charSequence, getPaint().getFontMetricsInt(), false), bufferType);
            }
        };
        this.nameTextView = textView;
        NotificationCenter.listenEmojiLoading(textView);
        this.nameTextView.setTextColor(getThemedColor(Theme.key_windowBackgroundWhiteBlackText));
        this.nameTextView.setTextSize(1, 15.0f);
        this.nameTextView.setSingleLine(true);
        this.nameTextView.setGravity(3);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.nameTextView, LayoutHelper.createLinear(-2, -2, 16, 12, 0, 0, 0));
        TextView textView2 = new TextView(context);
        this.usernameTextView = textView2;
        textView2.setTextColor(getThemedColor(Theme.key_windowBackgroundWhiteGrayText3));
        this.usernameTextView.setTextSize(1, 15.0f);
        this.usernameTextView.setSingleLine(true);
        this.usernameTextView.setGravity(3);
        this.usernameTextView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.usernameTextView, LayoutHelper.createLinear(-2, -2, 16, 12, 0, 8, 0));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(36.0f), 1073741824));
    }

    public void setUser(TLRPC$User tLRPC$User) {
        resetEmojiSuggestion();
        if (tLRPC$User == null) {
            this.nameTextView.setText(BuildConfig.FLAVOR);
            this.usernameTextView.setText(BuildConfig.FLAVOR);
            this.imageView.setImageDrawable(null);
            return;
        }
        this.avatarDrawable.setInfo(tLRPC$User);
        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = tLRPC$User.photo;
        if (tLRPC$UserProfilePhoto != null && tLRPC$UserProfilePhoto.photo_small != null) {
            this.imageView.setForUserOrChat(tLRPC$User, this.avatarDrawable);
        } else {
            this.imageView.setImageDrawable(this.avatarDrawable);
        }
        this.nameTextView.setText(UserObject.getUserName(tLRPC$User));
        if (UserObject.getPublicUsername(tLRPC$User) != null) {
            this.usernameTextView.setText("@" + UserObject.getPublicUsername(tLRPC$User));
        } else {
            this.usernameTextView.setText(BuildConfig.FLAVOR);
        }
        this.imageView.setVisibility(0);
        this.usernameTextView.setVisibility(0);
    }

    public void setDivider(boolean z) {
        if (z != this.needsDivider) {
            this.needsDivider = z;
            setWillNotDraw(!z);
            invalidate();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.needsDivider) {
            canvas.drawLine(AndroidUtilities.dp(52.0f), getHeight() - 1, getWidth() - AndroidUtilities.dp(8.0f), getHeight() - 1, Theme.dividerPaint);
        }
    }

    public void setChat(TLRPC$Chat tLRPC$Chat) {
        resetEmojiSuggestion();
        if (tLRPC$Chat == null) {
            this.nameTextView.setText(BuildConfig.FLAVOR);
            this.usernameTextView.setText(BuildConfig.FLAVOR);
            this.imageView.setImageDrawable(null);
            return;
        }
        this.avatarDrawable.setInfo(tLRPC$Chat);
        TLRPC$ChatPhoto tLRPC$ChatPhoto = tLRPC$Chat.photo;
        if (tLRPC$ChatPhoto != null && tLRPC$ChatPhoto.photo_small != null) {
            this.imageView.setForUserOrChat(tLRPC$Chat, this.avatarDrawable);
        } else {
            this.imageView.setImageDrawable(this.avatarDrawable);
        }
        this.nameTextView.setText(tLRPC$Chat.title);
        String publicUsername = ChatObject.getPublicUsername(tLRPC$Chat);
        if (publicUsername != null) {
            this.usernameTextView.setText("@" + publicUsername);
        } else {
            this.usernameTextView.setText(BuildConfig.FLAVOR);
        }
        this.imageView.setVisibility(0);
        this.usernameTextView.setVisibility(0);
    }

    public void setText(String str) {
        resetEmojiSuggestion();
        this.imageView.setVisibility(4);
        this.usernameTextView.setVisibility(4);
        this.nameTextView.setText(str);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        this.nameTextView.invalidate();
    }

    public void resetEmojiSuggestion() {
        this.nameTextView.setPadding(0, 0, 0, 0);
        Drawable drawable = this.emojiDrawable;
        if (drawable != null) {
            if (drawable instanceof AnimatedEmojiDrawable) {
                ((AnimatedEmojiDrawable) drawable).removeView(this);
            }
            this.emojiDrawable = null;
            invalidate();
        }
    }

    public void setEmojiSuggestion(MediaDataController.KeywordResult keywordResult) {
        this.imageView.setVisibility(4);
        this.usernameTextView.setVisibility(4);
        String str = keywordResult.emoji;
        if (str != null && str.startsWith("animated_")) {
            try {
                Drawable drawable = this.emojiDrawable;
                if (drawable instanceof AnimatedEmojiDrawable) {
                    ((AnimatedEmojiDrawable) drawable).removeView(this);
                    this.emojiDrawable = null;
                }
                AnimatedEmojiDrawable animatedEmojiDrawableMake = AnimatedEmojiDrawable.make(UserConfig.selectedAccount, 0, Long.parseLong(keywordResult.emoji.substring(9)));
                this.emojiDrawable = animatedEmojiDrawableMake;
                if (this.attached) {
                    animatedEmojiDrawableMake.addView(this);
                }
            } catch (Exception unused) {
                this.emojiDrawable = Emoji.getEmojiDrawable(keywordResult.emoji);
            }
        } else {
            this.emojiDrawable = Emoji.getEmojiDrawable(keywordResult.emoji);
        }
        if (this.emojiDrawable == null) {
            this.nameTextView.setPadding(0, 0, 0, 0);
            TextView textView = this.nameTextView;
            StringBuilder sb = new StringBuilder();
            sb.append(keywordResult.emoji);
            sb.append(":  ");
            sb.append(keywordResult.keyword);
            textView.setText(sb);
            return;
        }
        this.nameTextView.setPadding(AndroidUtilities.dp(22.0f), 0, 0, 0);
        TextView textView2 = this.nameTextView;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(":  ");
        sb2.append(keywordResult.keyword);
        textView2.setText(sb2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Drawable drawable = this.emojiDrawable;
        if (drawable != null) {
            int iDp = AndroidUtilities.dp(drawable instanceof AnimatedEmojiDrawable ? 24.0f : 20.0f);
            int iDp2 = AndroidUtilities.dp(this.emojiDrawable instanceof AnimatedEmojiDrawable ? -2.0f : 0.0f);
            this.emojiDrawable.setBounds(this.nameTextView.getLeft() + iDp2, ((this.nameTextView.getTop() + this.nameTextView.getBottom()) - iDp) / 2, this.nameTextView.getLeft() + iDp2 + iDp, ((this.nameTextView.getTop() + this.nameTextView.getBottom()) + iDp) / 2);
            Drawable drawable2 = this.emojiDrawable;
            if (drawable2 instanceof AnimatedEmojiDrawable) {
                ((AnimatedEmojiDrawable) drawable2).setTime(System.currentTimeMillis());
            }
            this.emojiDrawable.draw(canvas);
        }
    }

    public void setBotCommand(String str, String str2, TLRPC$User tLRPC$User) {
        resetEmojiSuggestion();
        if (tLRPC$User != null) {
            this.imageView.setVisibility(0);
            this.avatarDrawable.setInfo(tLRPC$User);
            TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = tLRPC$User.photo;
            if (tLRPC$UserProfilePhoto != null && tLRPC$UserProfilePhoto.photo_small != null) {
                this.imageView.setForUserOrChat(tLRPC$User, this.avatarDrawable);
            } else {
                this.imageView.setImageDrawable(this.avatarDrawable);
            }
        } else {
            this.imageView.setVisibility(4);
        }
        this.usernameTextView.setVisibility(0);
        this.nameTextView.setText(str);
        TextView textView = this.usernameTextView;
        textView.setText(Emoji.replaceEmoji(str2, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false));
    }

    public void setIsDarkTheme(boolean z) {
        if (z) {
            this.nameTextView.setTextColor(-1);
            this.usernameTextView.setTextColor(-4473925);
        } else {
            this.nameTextView.setTextColor(getThemedColor(Theme.key_windowBackgroundWhiteBlackText));
            this.usernameTextView.setTextColor(getThemedColor(Theme.key_windowBackgroundWhiteGrayText3));
        }
    }

    private int getThemedColor(int i) {
        return Theme.getColor(i, this.resourcesProvider);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attached = false;
        Drawable drawable = this.emojiDrawable;
        if (drawable instanceof AnimatedEmojiDrawable) {
            ((AnimatedEmojiDrawable) drawable).removeView(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attached = true;
        Drawable drawable = this.emojiDrawable;
        if (drawable instanceof AnimatedEmojiDrawable) {
            ((AnimatedEmojiDrawable) drawable).addView(this);
        }
    }
}
