package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.features.CallOut.helper.CallOutManager;
import ir.eitaa.helper.MxbHelper;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.CheckBox;
import ir.eitaa.ui.Components.CheckBoxSquare;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.NotificationsSettingsActivity;

/* loaded from: classes3.dex */
public class UserCell extends FrameLayout {
    private TextView addButton;
    private TextView adminTextView;
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImageView;
    private ImageView callOutButton;
    private CallOutManager.CallOutDelegate callOutDelegate;
    private CheckBox checkBox;
    private CheckBoxSquare checkBoxBig;
    private int currentAccount;
    private int currentDrawable;
    private int currentId;
    private CharSequence currentName;
    private Object currentObject;
    private CharSequence currentStatus;
    private TLRPC$User currentUser;
    private TLRPC$EncryptedChat encryptedChat;
    private ImageView imageView;
    private TLRPC$FileLocation lastAvatar;
    private String lastName;
    private int lastStatus;
    private ImageView mxbButton;
    private MxbHelper.MxbDelegate mxbDelegate;
    private SimpleTextView nameTextView;
    private boolean needDivider;
    private boolean selfAsSavedMessages;
    private boolean showMxb;
    private int statusColor;
    private int statusOnlineColor;
    private SimpleTextView statusTextView;

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public UserCell(Context context, int padding, int checkbox, boolean admin) {
        this(context, padding, checkbox, admin, false, false, false);
    }

    public UserCell(Context context, int padding, int checkbox, boolean admin, boolean showMxb) {
        this(context, padding, checkbox, admin, false, showMxb, false);
    }

    public UserCell(Context context, int padding, int checkbox, boolean admin, boolean needAddButton, boolean showMxb, boolean showCallOut) {
        int measuredWidth;
        int i;
        float f;
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.currentUser = null;
        this.showMxb = showMxb;
        if (needAddButton) {
            TextView textView = new TextView(context);
            this.addButton = textView;
            textView.setGravity(17);
            this.addButton.setTextColor(Theme.getColor("featuredStickers_buttonText"));
            this.addButton.setTextSize(1, 14.0f);
            this.addButton.setTypeface(AndroidUtilities.getFontFamily(true));
            this.addButton.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed")));
            this.addButton.setText(LocaleController.getString("Add", R.string.Add));
            this.addButton.setPadding(AndroidUtilities.dp(17.0f), 0, AndroidUtilities.dp(17.0f), 0);
            View view = this.addButton;
            boolean z = LocaleController.isRTL;
            addView(view, LayoutHelper.createFrame(-2, 28.0f, (z ? 3 : 5) | 48, z ? 14.0f : 0.0f, 15.0f, z ? 0.0f : 14.0f, 0.0f));
            measuredWidth = (int) Math.ceil((this.addButton.getPaint().measureText(this.addButton.getText().toString()) + AndroidUtilities.dp(48.0f)) / AndroidUtilities.density);
        } else {
            measuredWidth = 0;
        }
        if (showCallOut) {
            int iDp = AndroidUtilities.dp(4.0f);
            ImageView imageView = new ImageView(context);
            this.callOutButton = imageView;
            imageView.setImageResource(R.drawable.calls_menu_phone);
            this.callOutButton.setPadding(iDp, iDp, iDp, iDp);
            this.callOutButton.setBackgroundDrawable(Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor("chats_actionBackground"), 50)));
            this.callOutButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionBackground"), PorterDuff.Mode.MULTIPLY));
            this.callOutButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.UserCell.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (UserCell.this.callOutDelegate == null || UserCell.this.currentUser == null || UserCell.this.currentUser.phone == null || UserCell.this.currentUser.phone.isEmpty()) {
                        return;
                    }
                    UserCell.this.callOutDelegate.onCallOutPressed(CallOutManager.makeContactFromUser(UserCell.this.currentUser));
                }
            });
            View view2 = this.callOutButton;
            boolean z2 = LocaleController.isRTL;
            addView(view2, LayoutHelper.createFrame(32, 32.0f, (z2 ? 3 : 5) | 16, ((showMxb && z2) ? 48 : 0) + 16, 0.0f, ((!showMxb || z2) ? 0 : 48) + 16, 0.0f));
            measuredWidth += this.callOutButton.getMeasuredWidth();
        }
        this.statusColor = Theme.getColor("windowBackgroundWhiteGrayText");
        this.statusOnlineColor = Theme.getColor("windowBackgroundWhiteBlueText");
        this.avatarDrawable = new AvatarDrawable();
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(24.0f));
        View view3 = this.avatarImageView;
        boolean z3 = LocaleController.isRTL;
        addView(view3, LayoutHelper.createFrame(46, 46.0f, (z3 ? 5 : 3) | 48, z3 ? 0.0f : padding + 7, 6.0f, z3 ? padding + 7 : 0.0f, 0.0f));
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.nameTextView = simpleTextView;
        simpleTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.nameTextView.setTextSize(16);
        this.nameTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        View view4 = this.nameTextView;
        boolean z4 = LocaleController.isRTL;
        int i2 = (z4 ? 5 : 3) | 48;
        if (z4) {
            i = (checkbox == 2 ? 18 : 0) + 28 + measuredWidth;
        } else {
            i = padding + 64;
        }
        float f2 = i;
        if (z4) {
            f = padding + 64;
        } else {
            f = (checkbox == 2 ? 18 : 0) + 28 + measuredWidth;
        }
        addView(view4, LayoutHelper.createFrame(-1, 24.0f, i2, f2, 10.0f, f, 0.0f));
        SimpleTextView simpleTextView2 = new SimpleTextView(context);
        this.statusTextView = simpleTextView2;
        simpleTextView2.setTextSize(15);
        this.statusTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.statusTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        View view5 = this.statusTextView;
        boolean z5 = LocaleController.isRTL;
        addView(view5, LayoutHelper.createFrame(-1, 24.0f, (z5 ? 5 : 3) | 48, z5 ? measuredWidth + 28 : padding + 64, 32.0f, z5 ? padding + 64 : measuredWidth + 28, 0.0f));
        ImageView imageView2 = new ImageView(context);
        this.imageView = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        this.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteGrayIcon"), PorterDuff.Mode.MULTIPLY));
        this.imageView.setVisibility(8);
        View view6 = this.imageView;
        boolean z6 = LocaleController.isRTL;
        addView(view6, LayoutHelper.createFrame(-2, -2.0f, (z6 ? 5 : 3) | 16, z6 ? 0.0f : 16.0f, 0.0f, z6 ? 16.0f : 0.0f, 0.0f));
        if (checkbox == 2) {
            CheckBoxSquare checkBoxSquare = new CheckBoxSquare(context, false);
            this.checkBoxBig = checkBoxSquare;
            boolean z7 = LocaleController.isRTL;
            addView(checkBoxSquare, LayoutHelper.createFrame(18, 18.0f, (z7 ? 3 : 5) | 16, z7 ? 19.0f : 0.0f, 0.0f, z7 ? 0.0f : 19.0f, 0.0f));
        } else if (checkbox == 1) {
            CheckBox checkBox = new CheckBox(context, R.drawable.round_check2);
            this.checkBox = checkBox;
            checkBox.setVisibility(4);
            this.checkBox.setColor(Theme.getColor("checkbox"), Theme.getColor("checkboxCheck"));
            View view7 = this.checkBox;
            boolean z8 = LocaleController.isRTL;
            addView(view7, LayoutHelper.createFrame(22, 22.0f, (z8 ? 5 : 3) | 48, z8 ? 0.0f : padding + 37, 40.0f, z8 ? padding + 37 : 0.0f, 0.0f));
        }
        if (admin) {
            TextView textView2 = new TextView(context);
            this.adminTextView = textView2;
            textView2.setTextSize(1, 14.0f);
            this.adminTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.adminTextView.setTextColor(Theme.getColor("profile_creatorIcon"));
            View view8 = this.adminTextView;
            boolean z9 = LocaleController.isRTL;
            addView(view8, LayoutHelper.createFrame(-2, -2.0f, (z9 ? 3 : 5) | 48, z9 ? 23.0f : 0.0f, 10.0f, z9 ? 0.0f : 23.0f, 0.0f));
        }
        if (showMxb) {
            int iDp2 = AndroidUtilities.dp(4.0f);
            ImageView imageView3 = new ImageView(context);
            this.mxbButton = imageView3;
            imageView3.setImageResource(R.drawable.matap_ic);
            this.mxbButton.setPadding(iDp2, iDp2, iDp2, iDp2);
            this.mxbButton.setBackgroundDrawable(Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor("chats_actionBackground"), 50)));
            this.mxbButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.UserCell.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (UserCell.this.mxbDelegate == null || UserCell.this.currentUser == null || UserCell.this.currentUser.phone == null || UserCell.this.currentUser.phone.isEmpty()) {
                        return;
                    }
                    UserCell.this.mxbDelegate.onMxbPressed(UserCell.this.currentUser.phone);
                }
            });
            addView(this.mxbButton, LayoutHelper.createFrame(32, 32.0f, (LocaleController.isRTL ? 3 : 5) | 16, 16.0f, 0.0f, 16.0f, 0.0f));
        }
        setFocusable(true);
    }

    public void setAvatarPadding(int padding) {
        int i;
        float f;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.avatarImageView.getLayoutParams();
        layoutParams.leftMargin = AndroidUtilities.dp(LocaleController.isRTL ? 0.0f : padding + 7);
        layoutParams.rightMargin = AndroidUtilities.dp(LocaleController.isRTL ? padding + 7 : 0.0f);
        this.avatarImageView.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nameTextView.getLayoutParams();
        if (LocaleController.isRTL) {
            i = (this.checkBoxBig != null ? 18 : 0) + 28;
        } else {
            i = padding + 64;
        }
        layoutParams2.leftMargin = AndroidUtilities.dp(i);
        if (LocaleController.isRTL) {
            f = padding + 64;
        } else {
            f = (this.checkBoxBig == null ? 0 : 18) + 28;
        }
        layoutParams2.rightMargin = AndroidUtilities.dp(f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.statusTextView.getLayoutParams();
        layoutParams3.leftMargin = AndroidUtilities.dp(LocaleController.isRTL ? 28.0f : padding + 64);
        layoutParams3.rightMargin = AndroidUtilities.dp(LocaleController.isRTL ? padding + 64 : 28.0f);
        CheckBox checkBox = this.checkBox;
        if (checkBox != null) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) checkBox.getLayoutParams();
            layoutParams4.leftMargin = AndroidUtilities.dp(LocaleController.isRTL ? 0.0f : padding + 37);
            layoutParams4.rightMargin = AndroidUtilities.dp(LocaleController.isRTL ? padding + 37 : 0.0f);
        }
    }

    public void setAddButtonVisible(boolean value) {
        TextView textView = this.addButton;
        if (textView == null) {
            return;
        }
        textView.setVisibility(value ? 0 : 8);
    }

    public void setAdminRole(String role) {
        TextView textView = this.adminTextView;
        if (textView == null) {
            return;
        }
        textView.setVisibility(role != null ? 0 : 8);
        this.adminTextView.setText(role);
        if (role != null) {
            CharSequence text = this.adminTextView.getText();
            int iCeil = (int) Math.ceil(this.adminTextView.getPaint().measureText(text, 0, text.length()));
            this.nameTextView.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(6.0f) + iCeil : 0, 0, !LocaleController.isRTL ? iCeil + AndroidUtilities.dp(6.0f) : 0, 0);
            return;
        }
        this.nameTextView.setPadding(0, 0, 0, 0);
    }

    public CharSequence getName() {
        return this.nameTextView.getText();
    }

    public void setData(Object object, CharSequence name, CharSequence status, int resId) {
        setData(object, null, name, status, resId, false);
    }

    public void setData(Object object, CharSequence name, CharSequence status, int resId, boolean divider) {
        setData(object, null, name, status, resId, divider);
    }

    public void setData(Object object, TLRPC$EncryptedChat ec, CharSequence name, CharSequence status, int resId, boolean divider) {
        if (object == null && name == null && status == null) {
            this.currentStatus = null;
            this.currentName = null;
            this.currentObject = null;
            this.nameTextView.setText("");
            this.statusTextView.setText("");
            this.avatarImageView.setImageDrawable(null);
            return;
        }
        this.encryptedChat = ec;
        this.currentStatus = status;
        this.currentName = name;
        this.currentObject = object;
        this.currentDrawable = resId;
        this.needDivider = divider;
        setWillNotDraw(!divider);
        update(0);
    }

    public Object getCurrentObject() {
        return this.currentObject;
    }

    public void setException(NotificationsSettingsActivity.NotificationException exception, CharSequence name, boolean divider) {
        String string;
        TLRPC$User user;
        boolean z = exception.hasCustom;
        int i = exception.notify;
        int i2 = exception.muteUntil;
        boolean z2 = false;
        if (i != 3 || i2 == Integer.MAX_VALUE) {
            if (i == 0 || i == 1) {
                z2 = true;
            }
            if (z2 && z) {
                string = LocaleController.getString("NotificationsCustom", R.string.NotificationsCustom);
            } else {
                string = z2 ? LocaleController.getString("NotificationsUnmuted", R.string.NotificationsUnmuted) : LocaleController.getString("NotificationsMuted", R.string.NotificationsMuted);
            }
        } else {
            int currentTime = i2 - ConnectionsManager.getInstance(this.currentAccount).getCurrentTime();
            if (currentTime > 0) {
                string = currentTime < 3600 ? LocaleController.formatString("WillUnmuteIn", R.string.WillUnmuteIn, LocaleController.formatPluralString("Minutes", currentTime / 60)) : currentTime < 86400 ? LocaleController.formatString("WillUnmuteIn", R.string.WillUnmuteIn, LocaleController.formatPluralString("Hours", (int) Math.ceil((currentTime / 60.0f) / 60.0f))) : currentTime < 31536000 ? LocaleController.formatString("WillUnmuteIn", R.string.WillUnmuteIn, LocaleController.formatPluralString("Days", (int) Math.ceil(((currentTime / 60.0f) / 60.0f) / 24.0f))) : null;
            } else if (z) {
                string = LocaleController.getString("NotificationsCustom", R.string.NotificationsCustom);
            } else {
                string = LocaleController.getString("NotificationsUnmuted", R.string.NotificationsUnmuted);
            }
        }
        if (string == null) {
            string = LocaleController.getString("NotificationsOff", R.string.NotificationsOff);
        }
        String str = string;
        if (DialogObject.isEncryptedDialog(exception.did)) {
            TLRPC$EncryptedChat encryptedChat = MessagesController.getInstance(this.currentAccount).getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(exception.did)));
            if (encryptedChat == null || (user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(encryptedChat.user_id))) == null) {
                return;
            }
            setData(user, encryptedChat, name, str, 0, false);
            return;
        }
        if (DialogObject.isUserDialog(exception.did)) {
            TLRPC$User user2 = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(exception.did));
            if (user2 != null) {
                setData(user2, null, name, str, 0, divider);
                return;
            }
            return;
        }
        TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-exception.did));
        if (chat != null) {
            setData(chat, null, name, str, 0, divider);
        }
    }

    public void setNameTypeface(Typeface typeface) {
        this.nameTextView.setTypeface(typeface);
    }

    public void setCurrentId(int id) {
        this.currentId = id;
    }

    public void setChecked(boolean checked, boolean animated) {
        CheckBox checkBox = this.checkBox;
        if (checkBox != null) {
            if (checkBox.getVisibility() != 0) {
                this.checkBox.setVisibility(0);
            }
            this.checkBox.setChecked(checked, animated);
        } else {
            CheckBoxSquare checkBoxSquare = this.checkBoxBig;
            if (checkBoxSquare != null) {
                if (checkBoxSquare.getVisibility() != 0) {
                    this.checkBoxBig.setVisibility(0);
                }
                this.checkBoxBig.setChecked(checked, animated);
            }
        }
    }

    public void setCheckDisabled(boolean disabled) {
        CheckBoxSquare checkBoxSquare = this.checkBoxBig;
        if (checkBoxSquare != null) {
            checkBoxSquare.setDisabled(disabled);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(58.0f) + (this.needDivider ? 1 : 0), 1073741824));
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        CheckBoxSquare checkBoxSquare = this.checkBoxBig;
        if (checkBoxSquare != null) {
            checkBoxSquare.invalidate();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void update(int r18) {
        /*
            Method dump skipped, instructions count: 940
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.UserCell.update(int):void");
    }

    public void setSelfAsSavedMessages(boolean value) {
        this.selfAsSavedMessages = value;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(68.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(68.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        CheckBoxSquare checkBoxSquare = this.checkBoxBig;
        if (checkBoxSquare != null && checkBoxSquare.getVisibility() == 0) {
            info.setCheckable(true);
            info.setChecked(this.checkBoxBig.isChecked());
            info.setClassName("android.widget.CheckBox");
            return;
        }
        CheckBox checkBox = this.checkBox;
        if (checkBox == null || checkBox.getVisibility() != 0) {
            return;
        }
        info.setCheckable(true);
        info.setChecked(this.checkBox.isChecked());
        info.setClassName("android.widget.CheckBox");
    }

    public void setMxbDelegate(MxbHelper.MxbDelegate mxbDelegate) {
        this.mxbDelegate = mxbDelegate;
    }

    public void setCallOutDelegate(CallOutManager.CallOutDelegate callOutDelegate) {
        this.callOutDelegate = callOutDelegate;
    }
}
