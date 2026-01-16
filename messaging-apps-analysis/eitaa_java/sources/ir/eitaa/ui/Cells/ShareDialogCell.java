package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserStatus;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.CheckBox2;
import ir.eitaa.ui.Components.CheckBoxBase;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class ShareDialogCell extends FrameLayout {
    private AvatarDrawable avatarDrawable;
    private CheckBox2 checkBox;
    private int currentAccount;
    private long currentDialog;
    private int currentType;
    private BackupImageView imageView;
    private long lastUpdateTime;
    private TextView nameTextView;
    private float onlineProgress;
    private final Theme.ResourcesProvider resourcesProvider;
    private TLRPC$User user;

    public ShareDialogCell(Context context, int type, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.avatarDrawable = new AvatarDrawable();
        this.currentAccount = UserConfig.selectedAccount;
        this.resourcesProvider = resourcesProvider;
        setWillNotDraw(false);
        this.currentType = type;
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(28.0f));
        if (type == 2) {
            addView(this.imageView, LayoutHelper.createFrame(48, 48.0f, 49, 0.0f, 7.0f, 0.0f, 0.0f));
        } else {
            addView(this.imageView, LayoutHelper.createFrame(56, 56.0f, 49, 0.0f, 7.0f, 0.0f, 0.0f));
        }
        TextView textView = new TextView(context);
        this.nameTextView = textView;
        textView.setTextColor(getThemedColor(type == 1 ? "voipgroup_nameText" : "dialogTextBlack"));
        this.nameTextView.setTextSize(1, 12.0f);
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.nameTextView.setMaxLines(2);
        this.nameTextView.setGravity(49);
        this.nameTextView.setLines(2);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.nameTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 6.0f, this.currentType == 2 ? 58.0f : 66.0f, 6.0f, 0.0f));
        CheckBox2 checkBox2 = new CheckBox2(context, 21, resourcesProvider);
        this.checkBox = checkBox2;
        checkBox2.setColor("dialogRoundCheckBox", type == 1 ? "voipgroup_inviteMembersBackground" : "dialogBackground", "dialogRoundCheckBoxCheck");
        this.checkBox.setDrawUnchecked(false);
        this.checkBox.setDrawBackgroundAsArc(4);
        this.checkBox.setProgressDelegate(new CheckBoxBase.ProgressDelegate() { // from class: ir.eitaa.ui.Cells.-$$Lambda$ShareDialogCell$OYr6lZmjJwRl_TbbK9Ds7cgZjcI
            @Override // ir.eitaa.ui.Components.CheckBoxBase.ProgressDelegate
            public final void setProgress(float f) {
                this.f$0.lambda$new$0$ShareDialogCell(f);
            }
        });
        addView(this.checkBox, LayoutHelper.createFrame(24, 24.0f, 49, 19.0f, this.currentType == 2 ? -40.0f : 42.0f, 0.0f, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ShareDialogCell(float f) {
        float progress = 1.0f - (this.checkBox.getProgress() * 0.143f);
        this.imageView.setScaleX(progress);
        this.imageView.setScaleY(progress);
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.currentType == 2 ? 95.0f : 103.0f), 1073741824));
    }

    public void setDialog(long uid, boolean checked, CharSequence name) {
        if (DialogObject.isUserDialog(uid)) {
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(uid));
            this.user = user;
            this.avatarDrawable.setInfo(user);
            if (this.currentType != 2 && UserObject.isReplyUser(this.user)) {
                this.nameTextView.setText(LocaleController.getString("RepliesTitle", R.string.RepliesTitle));
                this.avatarDrawable.setAvatarType(12);
                this.imageView.setImage((ImageLocation) null, (String) null, this.avatarDrawable, this.user);
            } else if (this.currentType != 2 && UserObject.isUserSelf(this.user)) {
                this.nameTextView.setText(LocaleController.getString("SavedMessages", R.string.SavedMessages));
                this.avatarDrawable.setAvatarType(1);
                this.imageView.setImage((ImageLocation) null, (String) null, this.avatarDrawable, this.user);
            } else {
                if (name != null) {
                    this.nameTextView.setText(name);
                } else {
                    TLRPC$User tLRPC$User = this.user;
                    if (tLRPC$User != null) {
                        this.nameTextView.setText(ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name));
                    } else {
                        this.nameTextView.setText("");
                    }
                }
                this.imageView.setForUserOrChat(this.user, this.avatarDrawable);
            }
        } else {
            this.user = null;
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-uid));
            if (name != null) {
                this.nameTextView.setText(name);
            } else if (chat != null) {
                this.nameTextView.setText(chat.title);
            } else {
                this.nameTextView.setText("");
            }
            this.avatarDrawable.setInfo(chat);
            this.imageView.setForUserOrChat(chat, this.avatarDrawable);
        }
        this.currentDialog = uid;
        this.checkBox.setChecked(checked, false);
    }

    public long getCurrentDialog() {
        return this.currentDialog;
    }

    public void setChecked(boolean checked, boolean animated) {
        this.checkBox.setChecked(checked, animated);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        TLRPC$User tLRPC$User;
        TLRPC$UserStatus tLRPC$UserStatus;
        boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
        if (child == this.imageView && this.currentType != 2 && (tLRPC$User = this.user) != null && !MessagesController.isSupportUser(tLRPC$User)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.lastUpdateTime;
            if (j > 17) {
                j = 17;
            }
            this.lastUpdateTime = jElapsedRealtime;
            TLRPC$User tLRPC$User2 = this.user;
            boolean z = (tLRPC$User2.self || tLRPC$User2.bot || (((tLRPC$UserStatus = tLRPC$User2.status) == null || tLRPC$UserStatus.expires <= ConnectionsManager.getInstance(this.currentAccount).getCurrentTime()) && !MessagesController.getInstance(this.currentAccount).onlinePrivacy.containsKey(Long.valueOf(this.user.id)))) ? false : true;
            if (z || this.onlineProgress != 0.0f) {
                int bottom = this.imageView.getBottom() - AndroidUtilities.dp(6.0f);
                int right = this.imageView.getRight() - AndroidUtilities.dp(10.0f);
                Theme.dialogs_onlineCirclePaint.setColor(getThemedColor(this.currentType == 1 ? "voipgroup_inviteMembersBackground" : "windowBackgroundWhite"));
                float f = right;
                float f2 = bottom;
                canvas.drawCircle(f, f2, AndroidUtilities.dp(7.0f) * this.onlineProgress, Theme.dialogs_onlineCirclePaint);
                Theme.dialogs_onlineCirclePaint.setColor(getThemedColor("chats_onlineCircle"));
                canvas.drawCircle(f, f2, AndroidUtilities.dp(5.0f) * this.onlineProgress, Theme.dialogs_onlineCirclePaint);
                if (z) {
                    float f3 = this.onlineProgress;
                    if (f3 < 1.0f) {
                        float f4 = f3 + (j / 150.0f);
                        this.onlineProgress = f4;
                        if (f4 > 1.0f) {
                            this.onlineProgress = 1.0f;
                        }
                        this.imageView.invalidate();
                        invalidate();
                    }
                } else {
                    float f5 = this.onlineProgress;
                    if (f5 > 0.0f) {
                        float f6 = f5 - (j / 150.0f);
                        this.onlineProgress = f6;
                        if (f6 < 0.0f) {
                            this.onlineProgress = 0.0f;
                        }
                        this.imageView.invalidate();
                        invalidate();
                    }
                }
            }
        }
        return zDrawChild;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int left = this.imageView.getLeft() + (this.imageView.getMeasuredWidth() / 2);
        int top = this.imageView.getTop() + (this.imageView.getMeasuredHeight() / 2);
        Theme.checkboxSquare_checkPaint.setColor(getThemedColor("dialogRoundCheckBox"));
        Theme.checkboxSquare_checkPaint.setAlpha((int) (this.checkBox.getProgress() * 255.0f));
        canvas.drawCircle(left, top, AndroidUtilities.dp(this.currentType == 2 ? 24.0f : 28.0f), Theme.checkboxSquare_checkPaint);
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
