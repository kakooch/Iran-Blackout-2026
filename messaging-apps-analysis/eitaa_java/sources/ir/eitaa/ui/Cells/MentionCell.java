package ir.eitaa.ui.Cells;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class MentionCell extends LinearLayout {
    private AvatarDrawable avatarDrawable;
    private BackupImageView imageView;
    private TextView nameTextView;
    private TextView usernameTextView;

    public MentionCell(Context context) {
        super(context);
        setOrientation(0);
        AvatarDrawable avatarDrawable = new AvatarDrawable();
        this.avatarDrawable = avatarDrawable;
        avatarDrawable.setTextSize(AndroidUtilities.dp(12.0f));
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(14.0f));
        addView(this.imageView, LayoutHelper.createLinear(28, 28, 12.0f, 4.0f, 0.0f, 0.0f));
        TextView textView = new TextView(context);
        this.nameTextView = textView;
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.nameTextView.setTextSize(1, 15.0f);
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.nameTextView.setSingleLine(true);
        this.nameTextView.setGravity(3);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.nameTextView, LayoutHelper.createLinear(-2, -2, 16, 12, 0, 0, 0));
        TextView textView2 = new TextView(context);
        this.usernameTextView = textView2;
        textView2.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText3"));
        this.usernameTextView.setTextSize(1, 15.0f);
        this.usernameTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.usernameTextView.setSingleLine(true);
        this.usernameTextView.setGravity(3);
        this.usernameTextView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.usernameTextView, LayoutHelper.createLinear(-2, -2, 16, 12, 0, 8, 0));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(36.0f), 1073741824));
    }

    public void setUser(TLRPC$User user) {
        if (user == null) {
            this.nameTextView.setText("");
            this.usernameTextView.setText("");
            this.imageView.setImageDrawable(null);
            return;
        }
        this.avatarDrawable.setInfo(user);
        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = user.photo;
        if (tLRPC$UserProfilePhoto != null && tLRPC$UserProfilePhoto.photo_small != null) {
            this.imageView.setForUserOrChat(user, this.avatarDrawable);
        } else {
            this.imageView.setImageDrawable(this.avatarDrawable);
        }
        this.nameTextView.setText(UserObject.getUserName(user));
        if (user.username != null) {
            this.usernameTextView.setText("@" + user.username);
        } else {
            this.usernameTextView.setText("");
        }
        this.imageView.setVisibility(0);
        this.usernameTextView.setVisibility(0);
    }

    public void setChat(TLRPC$Chat chat) {
        if (chat == null) {
            this.nameTextView.setText("");
            this.usernameTextView.setText("");
            this.imageView.setImageDrawable(null);
            return;
        }
        this.avatarDrawable.setInfo(chat);
        TLRPC$ChatPhoto tLRPC$ChatPhoto = chat.photo;
        if (tLRPC$ChatPhoto != null && tLRPC$ChatPhoto.photo_small != null) {
            this.imageView.setForUserOrChat(chat, this.avatarDrawable);
        } else {
            this.imageView.setImageDrawable(this.avatarDrawable);
        }
        this.nameTextView.setText(chat.title);
        if (chat.username != null) {
            this.usernameTextView.setText("@" + chat.username);
        } else {
            this.usernameTextView.setText("");
        }
        this.imageView.setVisibility(0);
        this.usernameTextView.setVisibility(0);
    }

    public void setText(String text) {
        this.imageView.setVisibility(4);
        this.usernameTextView.setVisibility(4);
        this.nameTextView.setText(text);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        this.nameTextView.invalidate();
    }

    public void setEmojiSuggestion(MediaDataController.KeywordResult suggestion) {
        this.imageView.setVisibility(4);
        this.usernameTextView.setVisibility(4);
        StringBuilder sb = new StringBuilder(suggestion.emoji.length() + suggestion.keyword.length() + 4);
        sb.append(suggestion.emoji);
        sb.append("   :");
        sb.append(suggestion.keyword);
        TextView textView = this.nameTextView;
        textView.setText(Emoji.replaceEmoji(sb, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false));
    }

    public void setBotCommand(String command, String help, TLRPC$User user) {
        if (user != null) {
            this.imageView.setVisibility(0);
            this.avatarDrawable.setInfo(user);
            TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = user.photo;
            if (tLRPC$UserProfilePhoto != null && tLRPC$UserProfilePhoto.photo_small != null) {
                this.imageView.setForUserOrChat(user, this.avatarDrawable);
            } else {
                this.imageView.setImageDrawable(this.avatarDrawable);
            }
        } else {
            this.imageView.setVisibility(4);
        }
        this.usernameTextView.setVisibility(0);
        this.nameTextView.setText(command);
        TextView textView = this.usernameTextView;
        textView.setText(Emoji.replaceEmoji(help, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false));
    }

    public void setIsDarkTheme(boolean isDarkTheme) {
        if (isDarkTheme) {
            this.nameTextView.setTextColor(-1);
            this.usernameTextView.setTextColor(-4473925);
        } else {
            this.nameTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.usernameTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText3"));
        }
    }
}
