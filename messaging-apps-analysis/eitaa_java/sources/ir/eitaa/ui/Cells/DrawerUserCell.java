package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationsController;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.GroupCreateCheckBox;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class DrawerUserCell extends FrameLayout {
    private int accountNumber;
    private AvatarDrawable avatarDrawable;
    private GroupCreateCheckBox checkBox;
    private BackupImageView imageView;
    private RectF rect;
    private TextView textView;

    public DrawerUserCell(Context context) {
        super(context);
        this.rect = new RectF();
        AvatarDrawable avatarDrawable = new AvatarDrawable();
        this.avatarDrawable = avatarDrawable;
        avatarDrawable.setTextSize(AndroidUtilities.dp(12.0f));
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(18.0f));
        addView(this.imageView, LayoutHelper.createFrame(36, 36.0f, 51, 14.0f, 6.0f, 0.0f, 0.0f));
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(Theme.getColor("chats_menuItemText"));
        this.textView.setTextSize(1, 15.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textView.setLines(1);
        this.textView.setMaxLines(1);
        this.textView.setSingleLine(true);
        this.textView.setGravity(19);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.textView, LayoutHelper.createFrame(-1, -1.0f, 51, 72.0f, 0.0f, 60.0f, 0.0f));
        GroupCreateCheckBox groupCreateCheckBox = new GroupCreateCheckBox(context);
        this.checkBox = groupCreateCheckBox;
        groupCreateCheckBox.setChecked(true, false);
        this.checkBox.setCheckScale(0.9f);
        this.checkBox.setInnerRadDiff(AndroidUtilities.dp(1.5f));
        this.checkBox.setColorKeysOverrides("chats_unreadCounterText", "chats_unreadCounter", "chats_menuBackground");
        addView(this.checkBox, LayoutHelper.createFrame(18, 18.0f, 51, 37.0f, 27.0f, 0.0f, 0.0f));
        setWillNotDraw(false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f), 1073741824));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.textView.setTextColor(Theme.getColor("chats_menuItemText"));
    }

    public void setAccount(int account) {
        this.accountNumber = account;
        TLRPC$User currentUser = UserConfig.getInstance(account).getCurrentUser();
        if (currentUser == null) {
            return;
        }
        this.avatarDrawable.setInfo(currentUser);
        this.textView.setText(ContactsController.formatName(currentUser.first_name, currentUser.last_name));
        this.imageView.getImageReceiver().setCurrentAccount(account);
        this.imageView.setForUserOrChat(currentUser, this.avatarDrawable);
        this.checkBox.setVisibility(account == UserConfig.selectedAccount ? 0 : 4);
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int mainUnreadCount;
        if (UserConfig.getActivatedAccountsCount() <= 1 || !NotificationsController.getInstance(this.accountNumber).showBadgeNumber || (mainUnreadCount = MessagesStorage.getInstance(this.accountNumber).getMainUnreadCount()) <= 0) {
            return;
        }
        String str = String.format("%d", Integer.valueOf(mainUnreadCount));
        int iDp = AndroidUtilities.dp(12.5f);
        int iCeil = (int) Math.ceil(Theme.dialogs_countTextPaint.measureText(str));
        this.rect.set(((getMeasuredWidth() - Math.max(AndroidUtilities.dp(10.0f), iCeil)) - AndroidUtilities.dp(25.0f)) - AndroidUtilities.dp(5.5f), iDp, r4 + r3 + AndroidUtilities.dp(14.0f), AndroidUtilities.dp(23.0f) + iDp);
        RectF rectF = this.rect;
        float f = AndroidUtilities.density;
        canvas.drawRoundRect(rectF, f * 11.5f, f * 11.5f, Theme.dialogs_countPaint);
        RectF rectF2 = this.rect;
        canvas.drawText(str, rectF2.left + ((rectF2.width() - iCeil) / 2.0f), iDp + AndroidUtilities.dp(16.0f), Theme.dialogs_countTextPaint);
    }
}
