package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class AccountSelectCell extends FrameLayout {
    private int accountNumber;
    private AvatarDrawable avatarDrawable;
    private ImageView checkImageView;
    private BackupImageView imageView;
    private TextView infoTextView;
    private TextView textView;

    public AccountSelectCell(Context context, boolean hasInfo) {
        super(context);
        AvatarDrawable avatarDrawable = new AvatarDrawable();
        this.avatarDrawable = avatarDrawable;
        avatarDrawable.setTextSize(AndroidUtilities.dp(12.0f));
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(18.0f));
        addView(this.imageView, LayoutHelper.createFrame(36, 36.0f, 51, 10.0f, 10.0f, 0.0f, 0.0f));
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextSize(1, 15.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textView.setLines(1);
        this.textView.setMaxLines(1);
        this.textView.setSingleLine(true);
        this.textView.setGravity(19);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        if (hasInfo) {
            addView(this.textView, LayoutHelper.createFrame(-2, -2.0f, 51, 61.0f, 7.0f, 8.0f, 0.0f));
            this.textView.setTextColor(Theme.getColor("voipgroup_nameText"));
            this.textView.setText(LocaleController.getString("VoipGroupDisplayAs", R.string.VoipGroupDisplayAs));
            TextView textView2 = new TextView(context);
            this.infoTextView = textView2;
            textView2.setTextColor(Theme.getColor("voipgroup_lastSeenText"));
            this.infoTextView.setTextSize(1, 15.0f);
            this.infoTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.infoTextView.setLines(1);
            this.infoTextView.setMaxLines(1);
            this.infoTextView.setSingleLine(true);
            this.infoTextView.setMaxWidth(AndroidUtilities.dp(320.0f));
            this.infoTextView.setGravity(51);
            this.infoTextView.setEllipsize(TextUtils.TruncateAt.END);
            addView(this.infoTextView, LayoutHelper.createFrame(-2, -2.0f, 51, 61.0f, 27.0f, 8.0f, 0.0f));
            return;
        }
        addView(this.textView, LayoutHelper.createFrame(-1, -1.0f, 51, 61.0f, 0.0f, 56.0f, 0.0f));
        this.textView.setTextColor(Theme.getColor("actionBarDefaultSubmenuItem"));
        ImageView imageView = new ImageView(context);
        this.checkImageView = imageView;
        imageView.setImageResource(R.drawable.account_check);
        this.checkImageView.setScaleType(ImageView.ScaleType.CENTER);
        this.checkImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_menuItemCheck"), PorterDuff.Mode.MULTIPLY));
        addView(this.checkImageView, LayoutHelper.createFrame(40, -1.0f, 53, 0.0f, 0.0f, 6.0f, 0.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.checkImageView != null || (this.infoTextView != null && getLayoutParams().width != -2)) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(56.0f), 1073741824));
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(56.0f), 1073741824));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.infoTextView == null) {
            this.textView.setTextColor(Theme.getColor("chats_menuItemText"));
        }
    }

    public void setObject(TLObject object) {
        if (object instanceof TLRPC$User) {
            TLRPC$User tLRPC$User = (TLRPC$User) object;
            this.avatarDrawable.setInfo(tLRPC$User);
            this.infoTextView.setText(ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name));
            this.imageView.setForUserOrChat(tLRPC$User, this.avatarDrawable);
            return;
        }
        TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) object;
        this.avatarDrawable.setInfo(tLRPC$Chat);
        this.infoTextView.setText(tLRPC$Chat.title);
        this.imageView.setForUserOrChat(tLRPC$Chat, this.avatarDrawable);
    }

    public void setAccount(int account, boolean check) {
        this.accountNumber = account;
        TLRPC$User currentUser = UserConfig.getInstance(account).getCurrentUser();
        this.avatarDrawable.setInfo(currentUser);
        this.textView.setText(ContactsController.formatName(currentUser.first_name, currentUser.last_name));
        this.imageView.getImageReceiver().setCurrentAccount(account);
        this.imageView.setForUserOrChat(currentUser, this.avatarDrawable);
        this.checkImageView.setVisibility((check && account == UserConfig.selectedAccount) ? 0 : 4);
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }
}
