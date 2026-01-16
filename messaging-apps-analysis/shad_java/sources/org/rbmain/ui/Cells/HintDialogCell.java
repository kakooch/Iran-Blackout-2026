package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.DialogObject;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.CheckBox2;
import org.rbmain.ui.Components.CheckBoxBase;
import org.rbmain.ui.Components.CounterView;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes4.dex */
public class HintDialogCell extends FrameLayout {
    private AvatarDrawable avatarDrawable;
    private int backgroundColorKey;
    CheckBox2 checkBox;
    CounterView counterView;
    private int currentAccount;
    private TLRPC$User currentUser;
    private long dialogId;
    private final boolean drawCheckbox;
    private BackupImageView imageView;
    private int lastUnreadCount;
    private TextView nameTextView;
    float showOnlineProgress;
    boolean wasDraw;

    public HintDialogCell(Context context, boolean z) {
        super(context);
        this.avatarDrawable = new AvatarDrawable();
        new RectF();
        this.currentAccount = UserConfig.selectedAccount;
        this.backgroundColorKey = Theme.key_windowBackgroundWhite;
        this.drawCheckbox = z;
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(27.0f));
        addView(this.imageView, LayoutHelper.createFrame(54, 54.0f, 49, 0.0f, 7.0f, 0.0f, 0.0f));
        TextView textView = new TextView(this, context) { // from class: org.rbmain.ui.Cells.HintDialogCell.1
            @Override // android.widget.TextView
            public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
                super.setText(Emoji.replaceEmoji(charSequence, getPaint().getFontMetricsInt(), AndroidUtilities.dp(10.0f), false), bufferType);
            }
        };
        this.nameTextView = textView;
        NotificationCenter.listenEmojiLoading(textView);
        this.nameTextView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        this.nameTextView.setTextSize(1, 12.0f);
        this.nameTextView.setMaxLines(1);
        this.nameTextView.setGravity(49);
        this.nameTextView.setLines(1);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.nameTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 6.0f, 64.0f, 6.0f, 0.0f));
        CounterView counterView = new CounterView(context, null);
        this.counterView = counterView;
        addView(counterView, LayoutHelper.createFrame(-1, 28.0f, 48, 0.0f, 4.0f, 0.0f, 0.0f));
        this.counterView.setColors(Theme.key_chats_unreadCounterText, Theme.key_chats_unreadCounter);
        this.counterView.setGravity(5);
        if (z) {
            CheckBox2 checkBox2 = new CheckBox2(context, 21);
            this.checkBox = checkBox2;
            checkBox2.setColor(Theme.key_dialogRoundCheckBox, Theme.key_dialogBackground, Theme.key_dialogRoundCheckBoxCheck);
            this.checkBox.setDrawUnchecked(false);
            this.checkBox.setDrawBackgroundAsArc(4);
            this.checkBox.setProgressDelegate(new CheckBoxBase.ProgressDelegate() { // from class: org.rbmain.ui.Cells.HintDialogCell$$ExternalSyntheticLambda0
                @Override // org.rbmain.ui.Components.CheckBoxBase.ProgressDelegate
                public final void setProgress(float f) {
                    this.f$0.lambda$new$0(f);
                }
            });
            addView(this.checkBox, LayoutHelper.createFrame(24, 24.0f, 49, 19.0f, 42.0f, 0.0f, 0.0f));
            this.checkBox.setChecked(false, false);
            setWillNotDraw(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(float f) {
        float progress = 1.0f - (this.checkBox.getProgress() * 0.143f);
        this.imageView.setScaleX(progress);
        this.imageView.setScaleY(progress);
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(86.0f), 1073741824));
        this.counterView.counterDrawable.horizontalPadding = AndroidUtilities.dp(13.0f);
    }

    public void update(int i) {
        int i2;
        if ((i & 4) != 0 && this.currentUser != null) {
            this.currentUser = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(this.currentUser.id));
            this.imageView.invalidate();
            invalidate();
        }
        if (i != 0 && (i & 256) == 0 && (i & 2048) == 0) {
            return;
        }
        TLRPC$Dialog tLRPC$Dialog = MessagesController.getInstance(this.currentAccount).dialogs_dict.get(this.dialogId);
        if (tLRPC$Dialog != null && (i2 = tLRPC$Dialog.unread_count) != 0) {
            if (this.lastUnreadCount != i2) {
                this.lastUnreadCount = i2;
                this.counterView.setCount(i2, this.wasDraw);
                return;
            }
            return;
        }
        this.lastUnreadCount = 0;
        this.counterView.setCount(0, this.wasDraw);
    }

    public void update() {
        if (DialogObject.isUserDialog(this.dialogId)) {
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.dialogId));
            this.currentUser = user;
            this.avatarDrawable.setInfo(user);
        } else {
            this.avatarDrawable.setInfo(MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-this.dialogId)));
            this.currentUser = null;
        }
    }

    public void setDialog(long j, boolean z, CharSequence charSequence) {
        if (this.dialogId != j) {
            this.wasDraw = false;
            invalidate();
        }
        this.dialogId = j;
        if (DialogObject.isUserDialog(j)) {
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(j));
            this.currentUser = user;
            if (charSequence != null) {
                this.nameTextView.setText(charSequence);
            } else if (user != null) {
                this.nameTextView.setText(UserObject.getFirstName(user));
            } else {
                this.nameTextView.setText(BuildConfig.FLAVOR);
            }
            this.avatarDrawable.setInfo(this.currentUser);
            this.imageView.setForUserOrChat(this.currentUser, this.avatarDrawable);
        } else {
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-j));
            if (charSequence != null) {
                this.nameTextView.setText(charSequence);
            } else if (chat != null) {
                this.nameTextView.setText(chat.title);
            } else {
                this.nameTextView.setText(BuildConfig.FLAVOR);
            }
            this.avatarDrawable.setInfo(chat);
            this.currentUser = null;
            this.imageView.setForUserOrChat(chat, this.avatarDrawable);
        }
        if (z) {
            update(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean drawChild(android.graphics.Canvas r6, android.view.View r7, long r8) {
        /*
            r5 = this;
            boolean r8 = super.drawChild(r6, r7, r8)
            org.rbmain.ui.Components.BackupImageView r9 = r5.imageView
            if (r7 != r9) goto Lc6
            org.rbmain.tgnet.TLRPC$User r7 = r5.currentUser
            r9 = 1
            if (r7 == 0) goto L3b
            boolean r0 = r7.bot
            if (r0 != 0) goto L3b
            org.rbmain.tgnet.TLRPC$UserStatus r7 = r7.status
            if (r7 == 0) goto L23
            int r7 = r7.expires
            int r0 = r5.currentAccount
            org.rbmain.tgnet.ConnectionsManager r0 = org.rbmain.tgnet.ConnectionsManager.getInstance(r0)
            int r0 = r0.getCurrentTime()
            if (r7 > r0) goto L39
        L23:
            int r7 = r5.currentAccount
            org.rbmain.messenger.MessagesController r7 = org.rbmain.messenger.MessagesController.getInstance(r7)
            j$.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r7 = r7.onlinePrivacy
            org.rbmain.tgnet.TLRPC$User r0 = r5.currentUser
            int r0 = r0.id
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            boolean r7 = r7.containsKey(r0)
            if (r7 == 0) goto L3b
        L39:
            r7 = 1
            goto L3c
        L3b:
            r7 = 0
        L3c:
            boolean r0 = r5.wasDraw
            r1 = 1065353216(0x3f800000, float:1.0)
            r2 = 0
            if (r0 != 0) goto L4b
            if (r7 == 0) goto L48
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L49
        L48:
            r0 = 0
        L49:
            r5.showOnlineProgress = r0
        L4b:
            r0 = 1037726734(0x3dda740e, float:0.10666667)
            if (r7 == 0) goto L63
            float r3 = r5.showOnlineProgress
            int r4 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r4 == 0) goto L63
            float r3 = r3 + r0
            r5.showOnlineProgress = r3
            int r7 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r7 <= 0) goto L5f
            r5.showOnlineProgress = r1
        L5f:
            r5.invalidate()
            goto L77
        L63:
            if (r7 != 0) goto L77
            float r7 = r5.showOnlineProgress
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 == 0) goto L77
            float r7 = r7 - r0
            r5.showOnlineProgress = r7
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 >= 0) goto L74
            r5.showOnlineProgress = r2
        L74:
            r5.invalidate()
        L77:
            float r7 = r5.showOnlineProgress
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 == 0) goto Lc4
            r7 = 1112801280(0x42540000, float:53.0)
            int r7 = org.rbmain.messenger.AndroidUtilities.dp(r7)
            r0 = 1114374144(0x426c0000, float:59.0)
            int r0 = org.rbmain.messenger.AndroidUtilities.dp(r0)
            r6.save()
            float r1 = r5.showOnlineProgress
            float r0 = (float) r0
            float r7 = (float) r7
            r6.scale(r1, r1, r0, r7)
            android.graphics.Paint r1 = org.rbmain.ui.ActionBar.Theme.dialogs_onlineCirclePaint
            int r2 = r5.backgroundColorKey
            int r2 = org.rbmain.ui.ActionBar.Theme.getColor(r2)
            r1.setColor(r2)
            r1 = 1088421888(0x40e00000, float:7.0)
            int r1 = org.rbmain.messenger.AndroidUtilities.dp(r1)
            float r1 = (float) r1
            android.graphics.Paint r2 = org.rbmain.ui.ActionBar.Theme.dialogs_onlineCirclePaint
            r6.drawCircle(r0, r7, r1, r2)
            android.graphics.Paint r1 = org.rbmain.ui.ActionBar.Theme.dialogs_onlineCirclePaint
            int r2 = org.rbmain.ui.ActionBar.Theme.key_chats_onlineCircle
            int r2 = org.rbmain.ui.ActionBar.Theme.getColor(r2)
            r1.setColor(r2)
            r1 = 1084227584(0x40a00000, float:5.0)
            int r1 = org.rbmain.messenger.AndroidUtilities.dp(r1)
            float r1 = (float) r1
            android.graphics.Paint r2 = org.rbmain.ui.ActionBar.Theme.dialogs_onlineCirclePaint
            r6.drawCircle(r0, r7, r1, r2)
            r6.restore()
        Lc4:
            r5.wasDraw = r9
        Lc6:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.HintDialogCell.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.drawCheckbox) {
            int left = this.imageView.getLeft() + (this.imageView.getMeasuredWidth() / 2);
            int top = this.imageView.getTop() + (this.imageView.getMeasuredHeight() / 2);
            Theme.checkboxSquare_checkPaint.setColor(Theme.getColor(Theme.key_dialogRoundCheckBox));
            Theme.checkboxSquare_checkPaint.setAlpha((int) (this.checkBox.getProgress() * 255.0f));
            canvas.drawCircle(left, top, AndroidUtilities.dp(28.0f), Theme.checkboxSquare_checkPaint);
        }
    }

    public long getDialogId() {
        return this.dialogId;
    }
}
