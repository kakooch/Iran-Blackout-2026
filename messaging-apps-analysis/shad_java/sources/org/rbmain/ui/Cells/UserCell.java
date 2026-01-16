package org.rbmain.ui.Cells;

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
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.CheckBox;
import org.rbmain.ui.Components.CheckBoxSquare;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.NotificationsSettingsActivity;

/* loaded from: classes4.dex */
public class UserCell extends FrameLayout {
    private TextView addButton;
    private TextView adminTextView;
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImageView;
    private CheckBox checkBox;
    private CheckBoxSquare checkBoxBig;
    private int currentAccount;
    private int currentDrawable;
    private int currentId;
    private CharSequence currentName;
    private Object currentObject;
    private CharSequence currentStatus;
    private ImageView imageView;
    private TLRPC$FileLocation lastAvatar;
    private String lastName;
    private int lastStatus;
    private SimpleTextView nameTextView;
    private boolean needDivider;
    private boolean selfAsSavedMessages;
    private int statusColor;
    private int statusOnlineColor;
    private SimpleTextView statusTextView;

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public UserCell(Context context, int i, int i2, boolean z) {
        this(context, i, i2, z, false);
    }

    public UserCell(Context context, int i, int i2, boolean z, boolean z2) {
        int iCeil;
        int i3;
        float f;
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        if (z2) {
            TextView textView = new TextView(context);
            this.addButton = textView;
            textView.setGravity(17);
            this.addButton.setTextColor(Theme.getColor(Theme.key_featuredStickers_buttonText));
            this.addButton.setTextSize(1, 14.0f);
            this.addButton.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.addButton.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor(Theme.key_featuredStickers_addButton), Theme.getColor(Theme.key_featuredStickers_addButtonPressed)));
            this.addButton.setText(LocaleController.getString("Add", R.string.Add));
            this.addButton.setPadding(AndroidUtilities.dp(17.0f), 0, AndroidUtilities.dp(17.0f), 0);
            View view = this.addButton;
            boolean z3 = LocaleController.isRTL;
            addView(view, LayoutHelper.createFrame(-2, 28.0f, (z3 ? 3 : 5) | 48, z3 ? 14.0f : 0.0f, 15.0f, z3 ? 0.0f : 14.0f, 0.0f));
            iCeil = (int) Math.ceil((this.addButton.getPaint().measureText(this.addButton.getText().toString()) + AndroidUtilities.dp(48.0f)) / AndroidUtilities.density);
        } else {
            iCeil = 0;
        }
        this.statusColor = Theme.getColor(Theme.key_windowBackgroundWhiteGrayText);
        this.statusOnlineColor = Theme.getColor(Theme.key_windowBackgroundWhiteBlueText);
        this.avatarDrawable = new AvatarDrawable();
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(24.0f));
        View view2 = this.avatarImageView;
        boolean z4 = LocaleController.isRTL;
        addView(view2, LayoutHelper.createFrame(46, 46.0f, (z4 ? 5 : 3) | 48, z4 ? 0.0f : i + 7, 6.0f, z4 ? i + 7 : 0.0f, 0.0f));
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.nameTextView = simpleTextView;
        simpleTextView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        this.nameTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.nameTextView.setTextSize(16);
        this.nameTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        View view3 = this.nameTextView;
        boolean z5 = LocaleController.isRTL;
        int i4 = (z5 ? 5 : 3) | 48;
        if (z5) {
            i3 = (i2 == 2 ? 18 : 0) + 28 + iCeil;
        } else {
            i3 = i + 64;
        }
        float f2 = i3;
        if (z5) {
            f = i + 64;
        } else {
            f = (i2 != 2 ? 0 : 18) + 28 + iCeil;
        }
        addView(view3, LayoutHelper.createFrame(-1, 20.0f, i4, f2, 10.0f, f, 0.0f));
        SimpleTextView simpleTextView2 = new SimpleTextView(context);
        this.statusTextView = simpleTextView2;
        simpleTextView2.setTextSize(15);
        this.statusTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        View view4 = this.statusTextView;
        boolean z6 = LocaleController.isRTL;
        addView(view4, LayoutHelper.createFrame(-1, 20.0f, (z6 ? 5 : 3) | 48, z6 ? iCeil + 28 : i + 64, 32.0f, z6 ? i + 64 : iCeil + 28, 0.0f));
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_windowBackgroundWhiteGrayIcon), PorterDuff.Mode.MULTIPLY));
        this.imageView.setVisibility(8);
        View view5 = this.imageView;
        boolean z7 = LocaleController.isRTL;
        addView(view5, LayoutHelper.createFrame(-2, -2.0f, (z7 ? 5 : 3) | 16, z7 ? 0.0f : 16.0f, 0.0f, z7 ? 16.0f : 0.0f, 0.0f));
        if (i2 == 2) {
            CheckBoxSquare checkBoxSquare = new CheckBoxSquare(context, false);
            this.checkBoxBig = checkBoxSquare;
            boolean z8 = LocaleController.isRTL;
            addView(checkBoxSquare, LayoutHelper.createFrame(18, 18.0f, (z8 ? 3 : 5) | 16, z8 ? 19.0f : 0.0f, 0.0f, z8 ? 0.0f : 19.0f, 0.0f));
        } else if (i2 == 1) {
            CheckBox checkBox = new CheckBox(context, R.drawable.round_check2);
            this.checkBox = checkBox;
            checkBox.setVisibility(4);
            this.checkBox.setColor(Theme.getColor(Theme.key_checkbox), Theme.getColor(Theme.key_checkboxCheck));
            View view6 = this.checkBox;
            boolean z9 = LocaleController.isRTL;
            addView(view6, LayoutHelper.createFrame(22, 22.0f, (z9 ? 5 : 3) | 48, z9 ? 0.0f : i + 37, 40.0f, z9 ? i + 37 : 0.0f, 0.0f));
        }
        if (z) {
            TextView textView2 = new TextView(context);
            this.adminTextView = textView2;
            textView2.setTextSize(1, 14.0f);
            this.adminTextView.setTextColor(Theme.getColor(Theme.key_profile_creatorIcon));
            View view7 = this.adminTextView;
            boolean z10 = LocaleController.isRTL;
            addView(view7, LayoutHelper.createFrame(-2, -2.0f, (z10 ? 3 : 5) | 48, z10 ? 23.0f : 0.0f, 10.0f, z10 ? 0.0f : 23.0f, 0.0f));
        }
        setFocusable(true);
    }

    public void setAvatarPadding(int i) {
        int i2;
        float f;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.avatarImageView.getLayoutParams();
        layoutParams.leftMargin = AndroidUtilities.dp(LocaleController.isRTL ? 0.0f : i + 7);
        layoutParams.rightMargin = AndroidUtilities.dp(LocaleController.isRTL ? i + 7 : 0.0f);
        this.avatarImageView.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nameTextView.getLayoutParams();
        if (LocaleController.isRTL) {
            i2 = (this.checkBoxBig != null ? 18 : 0) + 28;
        } else {
            i2 = i + 64;
        }
        layoutParams2.leftMargin = AndroidUtilities.dp(i2);
        if (LocaleController.isRTL) {
            f = i + 64;
        } else {
            f = (this.checkBoxBig == null ? 0 : 18) + 28;
        }
        layoutParams2.rightMargin = AndroidUtilities.dp(f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.statusTextView.getLayoutParams();
        layoutParams3.leftMargin = AndroidUtilities.dp(LocaleController.isRTL ? 28.0f : i + 64);
        layoutParams3.rightMargin = AndroidUtilities.dp(LocaleController.isRTL ? i + 64 : 28.0f);
        CheckBox checkBox = this.checkBox;
        if (checkBox != null) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) checkBox.getLayoutParams();
            layoutParams4.leftMargin = AndroidUtilities.dp(LocaleController.isRTL ? 0.0f : i + 37);
            layoutParams4.rightMargin = AndroidUtilities.dp(LocaleController.isRTL ? i + 37 : 0.0f);
        }
    }

    public void setAddButtonVisible(boolean z) {
        TextView textView = this.addButton;
        if (textView == null) {
            return;
        }
        textView.setVisibility(z ? 0 : 8);
    }

    public void setAdminRole(String str) {
        TextView textView = this.adminTextView;
        if (textView == null) {
            return;
        }
        textView.setVisibility(str != null ? 0 : 8);
        this.adminTextView.setText(str);
        if (str != null) {
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

    public void setData(Object obj, CharSequence charSequence, CharSequence charSequence2, int i) {
        setData(obj, null, charSequence, charSequence2, i, false);
    }

    public void setData(Object obj, CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
        setData(obj, null, charSequence, charSequence2, i, z);
    }

    public void setData(Object obj, TLRPC$EncryptedChat tLRPC$EncryptedChat, CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
        if (obj == null && charSequence == null && charSequence2 == null) {
            this.currentStatus = null;
            this.currentName = null;
            this.currentObject = null;
            this.nameTextView.setText(BuildConfig.FLAVOR);
            this.statusTextView.setText(BuildConfig.FLAVOR);
            this.avatarImageView.setImageDrawable(null);
            return;
        }
        this.currentStatus = charSequence2;
        this.currentName = charSequence;
        this.currentObject = obj;
        this.currentDrawable = i;
        this.needDivider = z;
        setWillNotDraw(!z);
        update(0);
    }

    public Object getCurrentObject() {
        return this.currentObject;
    }

    public void setException(NotificationsSettingsActivity.NotificationException notificationException, CharSequence charSequence, boolean z) {
        String string;
        TLRPC$User user;
        boolean z2 = notificationException.hasCustom;
        int i = notificationException.notify;
        int i2 = notificationException.muteUntil;
        if (i != 3 || i2 == Integer.MAX_VALUE) {
            boolean z3 = i == 0 || i == 1;
            if (z3 && z2) {
                string = LocaleController.getString("NotificationsCustom", R.string.NotificationsCustom);
            } else {
                string = z3 ? LocaleController.getString("NotificationsUnmuted", R.string.NotificationsUnmuted) : LocaleController.getString("NotificationsMuted", R.string.NotificationsMuted);
            }
        } else {
            int currentTime = i2 - ConnectionsManager.getInstance(this.currentAccount).getCurrentTime();
            if (currentTime > 0) {
                string = currentTime < 3600 ? LocaleController.formatString("WillUnmuteIn", R.string.WillUnmuteIn, LocaleController.formatPluralString("Minutes", currentTime / 60)) : currentTime < 86400 ? LocaleController.formatString("WillUnmuteIn", R.string.WillUnmuteIn, LocaleController.formatPluralString("Hours", (int) Math.ceil((currentTime / 60.0f) / 60.0f))) : currentTime < 31536000 ? LocaleController.formatString("WillUnmuteIn", R.string.WillUnmuteIn, LocaleController.formatPluralString("Days", (int) Math.ceil(((currentTime / 60.0f) / 60.0f) / 24.0f))) : null;
            } else if (z2) {
                string = LocaleController.getString("NotificationsCustom", R.string.NotificationsCustom);
            } else {
                string = LocaleController.getString("NotificationsUnmuted", R.string.NotificationsUnmuted);
            }
        }
        if (string == null) {
            string = LocaleController.getString("NotificationsOff", R.string.NotificationsOff);
        }
        String str = string;
        long j = notificationException.did;
        int i3 = (int) j;
        int i4 = (int) (j >> 32);
        if (i3 == 0) {
            TLRPC$EncryptedChat encryptedChat = MessagesController.getInstance(this.currentAccount).getEncryptedChat(Integer.valueOf(i4));
            if (encryptedChat == null || (user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(encryptedChat.user_id))) == null) {
                return;
            }
            setData(user, encryptedChat, charSequence, str, 0, false);
            return;
        }
        if (i3 > 0) {
            TLRPC$User user2 = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(i3));
            if (user2 != null) {
                setData(user2, null, charSequence, str, 0, z);
                return;
            }
            return;
        }
        TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(-i3));
        if (chat != null) {
            setData(chat, null, charSequence, str, 0, z);
        }
    }

    public void setNameTypeface(Typeface typeface) {
        this.nameTextView.setTypeface(typeface);
    }

    public void setCurrentId(int i) {
        this.currentId = i;
    }

    public void setChecked(boolean z, boolean z2) {
        CheckBox checkBox = this.checkBox;
        if (checkBox != null) {
            if (checkBox.getVisibility() != 0) {
                this.checkBox.setVisibility(0);
            }
            this.checkBox.setChecked(z, z2);
        } else {
            CheckBoxSquare checkBoxSquare = this.checkBoxBig;
            if (checkBoxSquare != null) {
                if (checkBoxSquare.getVisibility() != 0) {
                    this.checkBoxBig.setVisibility(0);
                }
                this.checkBoxBig.setChecked(z, z2);
            }
        }
    }

    public void setCheckDisabled(boolean z) {
        CheckBoxSquare checkBoxSquare = this.checkBoxBig;
        if (checkBoxSquare != null) {
            checkBoxSquare.setDisabled(z);
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
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bc  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [org.rbmain.tgnet.TLRPC$FileLocation] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void update(int r17) {
        /*
            Method dump skipped, instructions count: 820
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.UserCell.update(int):void");
    }

    public void setSelfAsSavedMessages(boolean z) {
        this.selfAsSavedMessages = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(68.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(68.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        CheckBoxSquare checkBoxSquare = this.checkBoxBig;
        if (checkBoxSquare != null && checkBoxSquare.getVisibility() == 0) {
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(this.checkBoxBig.isChecked());
            accessibilityNodeInfo.setClassName("android.widget.CheckBox");
            return;
        }
        CheckBox checkBox = this.checkBox;
        if (checkBox == null || checkBox.getVisibility() != 0) {
            return;
        }
        accessibilityNodeInfo.setCheckable(true);
        accessibilityNodeInfo.setChecked(this.checkBox.isChecked());
        accessibilityNodeInfo.setClassName("android.widget.CheckBox");
    }
}
