package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.text.StaticLayout;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.features.CallOut.helper.CallOutManager;
import ir.eitaa.helper.MxbHelper;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.tgnet.TLRPC$UserStatus;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.CheckBox2;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class ProfileSearchCell extends BaseCell {
    private AvatarDrawable avatarDrawable;
    private ImageReceiver avatarImage;
    ImageView callOutButton;
    CallOutManager.CallOutDelegate callOutDelegate;
    private TLRPC$Chat chat;
    CheckBox2 checkBox;
    private StaticLayout countLayout;
    private int countLeft;
    private int countTop;
    private int countWidth;
    private int currentAccount;
    private CharSequence currentName;
    private long dialog_id;
    private boolean drawCheck;
    private boolean drawCount;
    private boolean drawNameBot;
    private boolean drawNameBroadcast;
    private boolean drawNameGroup;
    private boolean drawNameLock;
    private TLRPC$EncryptedChat encryptedChat;
    private TLRPC$FileLocation lastAvatar;
    private String lastName;
    private int lastStatus;
    private int lastUnreadCount;
    ImageView mxbButton;
    MxbHelper.MxbDelegate mxbDelegate;
    private StaticLayout nameLayout;
    private int nameLeft;
    private int nameLockLeft;
    private int nameLockTop;
    private int nameTop;
    private int nameWidth;
    private RectF rect;
    private boolean savedMessages;
    boolean showMxb;
    private StaticLayout statusLayout;
    private int statusLeft;
    private CharSequence subLabel;
    private int sublabelOffsetX;
    private int sublabelOffsetY;
    public boolean useSeparator;
    private TLRPC$User user;

    public ProfileSearchCell(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.countTop = AndroidUtilities.dp(19.0f);
        this.rect = new RectF();
        this.showMxb = false;
        ImageReceiver imageReceiver = new ImageReceiver(this);
        this.avatarImage = imageReceiver;
        imageReceiver.setRoundRadius(AndroidUtilities.dp(23.0f));
        this.avatarDrawable = new AvatarDrawable();
        CheckBox2 checkBox2 = new CheckBox2(context, 21);
        this.checkBox = checkBox2;
        checkBox2.setColor(null, "windowBackgroundWhite", "checkboxCheck");
        this.checkBox.setDrawUnchecked(false);
        this.checkBox.setDrawBackgroundAsArc(3);
        addView(this.checkBox);
        int iDp = AndroidUtilities.dp(4.0f);
        ImageView imageView = new ImageView(getContext());
        this.mxbButton = imageView;
        imageView.setImageResource(R.drawable.matap_ic);
        this.mxbButton.setPadding(iDp, iDp, iDp, iDp);
        this.mxbButton.setBackgroundDrawable(Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor("chats_actionBackground"), 50)));
        this.mxbButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.ProfileSearchCell.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ProfileSearchCell profileSearchCell = ProfileSearchCell.this;
                MxbHelper.MxbDelegate mxbDelegate = profileSearchCell.mxbDelegate;
                if (mxbDelegate != null) {
                    mxbDelegate.onMxbPressed(profileSearchCell.user != null ? ProfileSearchCell.this.user.phone : "");
                }
            }
        });
        addView(this.mxbButton);
        ImageView imageView2 = new ImageView(context);
        this.callOutButton = imageView2;
        imageView2.setImageResource(R.drawable.calls_menu_phone);
        this.callOutButton.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
        this.callOutButton.setBackgroundDrawable(Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor("chats_actionBackground"), 50)));
        this.callOutButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionBackground"), PorterDuff.Mode.MULTIPLY));
        this.callOutButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.ProfileSearchCell.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ProfileSearchCell profileSearchCell = ProfileSearchCell.this;
                if (profileSearchCell.callOutDelegate == null || profileSearchCell.user == null || ProfileSearchCell.this.user.phone == null || ProfileSearchCell.this.user.phone.isEmpty()) {
                    return;
                }
                ProfileSearchCell profileSearchCell2 = ProfileSearchCell.this;
                profileSearchCell2.callOutDelegate.onCallOutPressed(CallOutManager.makeContactFromUser(profileSearchCell2.user));
            }
        });
        addView(this.callOutButton, LayoutHelper.createFrame(32, 32.0f, (LocaleController.isRTL ? 3 : 5) | 16, 16.0f, 0.0f, 16.0f, 0.0f));
    }

    public void setData(TLObject object, TLRPC$EncryptedChat ec, CharSequence n, CharSequence s, boolean needCount, boolean saved) {
        setData(object, ec, n, s, needCount, saved, false, false);
    }

    public void setData(TLObject object, TLRPC$EncryptedChat ec, CharSequence n, CharSequence s, boolean needCount, boolean saved, boolean showMxb, boolean showCallOut) {
        this.currentName = n;
        if (object instanceof TLRPC$User) {
            this.user = (TLRPC$User) object;
            this.chat = null;
        } else if (object instanceof TLRPC$Chat) {
            this.chat = (TLRPC$Chat) object;
            this.user = null;
        }
        this.encryptedChat = ec;
        this.subLabel = s;
        this.drawCount = needCount;
        this.savedMessages = saved;
        this.mxbButton.setVisibility(showMxb ? 0 : 4);
        this.showMxb = showMxb;
        this.callOutButton.setVisibility(showCallOut ? 0 : 4);
        update(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.avatarImage.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.avatarImage.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        CheckBox2 checkBox2 = this.checkBox;
        if (checkBox2 != null) {
            checkBox2.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(24.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(24.0f), 1073741824));
        }
        ImageView imageView = this.mxbButton;
        if (imageView != null) {
            imageView.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
        }
        ImageView imageView2 = this.callOutButton;
        if (imageView2 != null) {
            imageView2.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), AndroidUtilities.dp(60.0f) + (this.useSeparator ? 1 : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.user == null && this.chat == null && this.encryptedChat == null) {
            return;
        }
        if (this.checkBox != null) {
            int iDp = LocaleController.isRTL ? (right - left) - AndroidUtilities.dp(42.0f) : AndroidUtilities.dp(42.0f);
            int iDp2 = AndroidUtilities.dp(36.0f);
            CheckBox2 checkBox2 = this.checkBox;
            checkBox2.layout(iDp, iDp2, checkBox2.getMeasuredWidth() + iDp, this.checkBox.getMeasuredHeight() + iDp2);
        }
        int measuredWidth = 0;
        if (this.mxbButton != null) {
            int iDp3 = LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : getMeasuredWidth() - (this.mxbButton.getMeasuredWidth() + AndroidUtilities.dp(16.0f));
            int measuredHeight = (getMeasuredHeight() / 2) - (this.mxbButton.getMeasuredHeight() / 2);
            ImageView imageView = this.mxbButton;
            imageView.layout(iDp3, measuredHeight, imageView.getMeasuredWidth() + iDp3, this.mxbButton.getMeasuredHeight() + measuredHeight);
            if (this.showMxb) {
                measuredWidth = this.mxbButton.getMeasuredWidth() + AndroidUtilities.dp(16.0f);
            }
        }
        if (this.callOutButton != null) {
            int iDp4 = LocaleController.isRTL ? AndroidUtilities.dp(16.0f) + measuredWidth : (getMeasuredWidth() - (this.callOutButton.getMeasuredWidth() + AndroidUtilities.dp(16.0f))) - measuredWidth;
            int measuredHeight2 = (getMeasuredHeight() / 2) - (this.callOutButton.getMeasuredHeight() / 2);
            ImageView imageView2 = this.callOutButton;
            imageView2.layout(iDp4, measuredHeight2, imageView2.getMeasuredWidth() + iDp4, this.callOutButton.getMeasuredHeight() + measuredHeight2);
        }
        if (changed) {
            buildLayout();
        }
    }

    public TLRPC$User getUser() {
        return this.user;
    }

    public TLRPC$Chat getChat() {
        return this.chat;
    }

    public void setSublabelOffset(int x, int y) {
        this.sublabelOffsetX = x;
        this.sublabelOffsetY = y;
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void buildLayout() {
        /*
            Method dump skipped, instructions count: 1508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ProfileSearchCell.buildLayout():void");
    }

    public void update(int mask) {
        TLRPC$Dialog tLRPC$Dialog;
        String str;
        TLRPC$User tLRPC$User;
        TLRPC$FileLocation tLRPC$FileLocation;
        TLRPC$User tLRPC$User2 = this.user;
        if (tLRPC$User2 != null) {
            this.avatarDrawable.setInfo(tLRPC$User2);
            if (UserObject.isReplyUser(this.user)) {
                this.avatarDrawable.setAvatarType(12);
                this.avatarImage.setImage(null, null, this.avatarDrawable, null, null, 0);
            } else if (this.savedMessages) {
                this.avatarDrawable.setAvatarType(1);
                this.avatarImage.setImage(null, null, this.avatarDrawable, null, null, 0);
            } else {
                TLRPC$User tLRPC$User3 = this.user;
                TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = tLRPC$User3.photo;
                tLRPC$FileLocation = tLRPC$UserProfilePhoto != null ? tLRPC$UserProfilePhoto.photo_small : null;
                this.avatarImage.setImage(ImageLocation.getForUserOrChat(tLRPC$User3, 1), "50_50", ImageLocation.getForUserOrChat(this.user, 2), "50_50", this.avatarDrawable, this.user, 0);
            }
        } else {
            TLRPC$Chat tLRPC$Chat = this.chat;
            if (tLRPC$Chat != null) {
                TLRPC$ChatPhoto tLRPC$ChatPhoto = tLRPC$Chat.photo;
                tLRPC$FileLocation = tLRPC$ChatPhoto != null ? tLRPC$ChatPhoto.photo_small : null;
                this.avatarDrawable.setInfo(tLRPC$Chat);
                this.avatarImage.setImage(ImageLocation.getForUserOrChat(this.chat, 1), "50_50", ImageLocation.getForUserOrChat(this.chat, 2), "50_50", this.avatarDrawable, this.chat, 0);
            } else {
                this.avatarDrawable.setInfo(0L, null, null);
                this.avatarImage.setImage(null, null, this.avatarDrawable, null, null, 0);
            }
        }
        if (mask != 0) {
            boolean z = !(((MessagesController.UPDATE_MASK_AVATAR & mask) == 0 || this.user == null) && ((MessagesController.UPDATE_MASK_CHAT_AVATAR & mask) == 0 || this.chat == null)) && (((tLRPC$FileLocation = this.lastAvatar) != null && tLRPC$FileLocation == null) || ((tLRPC$FileLocation == null && tLRPC$FileLocation != null) || !(tLRPC$FileLocation == null || (tLRPC$FileLocation.volume_id == tLRPC$FileLocation.volume_id && tLRPC$FileLocation.local_id == tLRPC$FileLocation.local_id))));
            if (!z && (MessagesController.UPDATE_MASK_STATUS & mask) != 0 && (tLRPC$User = this.user) != null) {
                TLRPC$UserStatus tLRPC$UserStatus = tLRPC$User.status;
                if ((tLRPC$UserStatus != null ? tLRPC$UserStatus.expires : 0) != this.lastStatus) {
                    z = true;
                }
            }
            if ((!z && (MessagesController.UPDATE_MASK_NAME & mask) != 0 && this.user != null) || ((MessagesController.UPDATE_MASK_CHAT_NAME & mask) != 0 && this.chat != null)) {
                if (this.user != null) {
                    str = this.user.first_name + this.user.last_name;
                } else {
                    str = this.chat.title;
                }
                if (!str.equals(this.lastName)) {
                    z = true;
                }
            }
            if (!((z || !this.drawCount || (mask & MessagesController.UPDATE_MASK_READ_DIALOG_MESSAGE) == 0 || (tLRPC$Dialog = MessagesController.getInstance(this.currentAccount).dialogs_dict.get(this.dialog_id)) == null || tLRPC$Dialog.unread_count == this.lastUnreadCount) ? z : true)) {
                return;
            }
        }
        TLRPC$User tLRPC$User4 = this.user;
        if (tLRPC$User4 != null) {
            TLRPC$UserStatus tLRPC$UserStatus2 = tLRPC$User4.status;
            if (tLRPC$UserStatus2 != null) {
                this.lastStatus = tLRPC$UserStatus2.expires;
            } else {
                this.lastStatus = 0;
            }
            this.lastName = this.user.first_name + this.user.last_name;
        } else {
            TLRPC$Chat tLRPC$Chat2 = this.chat;
            if (tLRPC$Chat2 != null) {
                this.lastName = tLRPC$Chat2.title;
            }
        }
        this.lastAvatar = tLRPC$FileLocation;
        if (getMeasuredWidth() != 0 || getMeasuredHeight() != 0) {
            buildLayout();
        } else {
            requestLayout();
        }
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int lineRight;
        if (this.user == null && this.chat == null && this.encryptedChat == null) {
            return;
        }
        if (this.useSeparator) {
            if (LocaleController.isRTL) {
                canvas.drawLine(0.0f, getMeasuredHeight() - 1, getMeasuredWidth() - AndroidUtilities.dp(AndroidUtilities.leftBaseline), getMeasuredHeight() - 1, Theme.dividerPaint);
            } else {
                canvas.drawLine(AndroidUtilities.dp(AndroidUtilities.leftBaseline), getMeasuredHeight() - 1, getMeasuredWidth(), getMeasuredHeight() - 1, Theme.dividerPaint);
            }
        }
        if (this.drawNameLock) {
            BaseCell.setDrawableBounds(Theme.dialogs_lockDrawable, this.nameLockLeft, this.nameLockTop);
            Theme.dialogs_lockDrawable.draw(canvas);
        } else if (this.drawNameGroup) {
            BaseCell.setDrawableBounds(Theme.dialogs_groupDrawable, this.nameLockLeft, this.nameLockTop);
            Theme.dialogs_groupDrawable.draw(canvas);
        } else if (this.drawNameBroadcast) {
            TLRPC$Chat tLRPC$Chat = this.chat;
            if (tLRPC$Chat != null && tLRPC$Chat.isMediaContent) {
                BaseCell.setDrawableBounds(Theme.dialogs_MediaDrawable, this.nameLockLeft, this.nameLockTop);
                Theme.dialogs_MediaDrawable.draw(canvas);
            } else {
                BaseCell.setDrawableBounds(Theme.dialogs_broadcastDrawable, this.nameLockLeft, this.nameLockTop);
                Theme.dialogs_broadcastDrawable.draw(canvas);
            }
        } else if (this.drawNameBot) {
            BaseCell.setDrawableBounds(Theme.dialogs_botDrawable, this.nameLockLeft, this.nameLockTop);
            Theme.dialogs_botDrawable.draw(canvas);
        }
        if (this.nameLayout != null) {
            canvas.save();
            canvas.translate(this.nameLeft, this.nameTop);
            this.nameLayout.draw(canvas);
            canvas.restore();
            if (this.drawCheck) {
                if (!LocaleController.isRTL) {
                    lineRight = (int) (this.nameLeft + this.nameLayout.getLineRight(0) + AndroidUtilities.dp(6.0f));
                } else if (this.nameLayout.getLineLeft(0) == 0.0f) {
                    lineRight = (this.nameLeft - AndroidUtilities.dp(6.0f)) - Theme.dialogs_verifiedDrawable.getIntrinsicWidth();
                } else {
                    float lineWidth = this.nameLayout.getLineWidth(0);
                    double d = this.nameLeft + this.nameWidth;
                    double dCeil = Math.ceil(lineWidth);
                    Double.isNaN(d);
                    double dDp = AndroidUtilities.dp(6.0f);
                    Double.isNaN(dDp);
                    double d2 = (d - dCeil) - dDp;
                    double intrinsicWidth = Theme.dialogs_verifiedDrawable.getIntrinsicWidth();
                    Double.isNaN(intrinsicWidth);
                    lineRight = (int) (d2 - intrinsicWidth);
                }
                BaseCell.setDrawableBounds(Theme.dialogs_verifiedDrawable, lineRight, this.nameTop + AndroidUtilities.dp(3.0f));
                BaseCell.setDrawableBounds(Theme.dialogs_verifiedCheckDrawable, lineRight, this.nameTop + AndroidUtilities.dp(3.0f));
                Theme.dialogs_verifiedDrawable.draw(canvas);
                Theme.dialogs_verifiedCheckDrawable.draw(canvas);
            }
        }
        if (this.statusLayout != null) {
            canvas.save();
            canvas.translate(this.statusLeft + this.sublabelOffsetX, AndroidUtilities.dp(33.0f) + this.sublabelOffsetY);
            this.statusLayout.draw(canvas);
            canvas.restore();
        }
        if (this.countLayout != null) {
            this.rect.set(this.countLeft - AndroidUtilities.dp(5.5f), this.countTop, r0 + this.countWidth + AndroidUtilities.dp(11.0f), this.countTop + AndroidUtilities.dp(23.0f));
            RectF rectF = this.rect;
            float f = AndroidUtilities.density;
            canvas.drawRoundRect(rectF, f * 11.5f, f * 11.5f, MessagesController.getInstance(this.currentAccount).isDialogMuted(this.dialog_id) ? Theme.dialogs_countGrayPaint : Theme.dialogs_countPaint);
            canvas.save();
            canvas.translate(this.countLeft, this.countTop + AndroidUtilities.dp(4.0f));
            this.countLayout.draw(canvas);
            canvas.restore();
        }
        this.avatarImage.draw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        StringBuilder sb = new StringBuilder();
        StaticLayout staticLayout = this.nameLayout;
        if (staticLayout != null) {
            sb.append(staticLayout.getText());
        }
        if (this.statusLayout != null) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(this.statusLayout.getText());
        }
        info.setText(sb.toString());
    }

    public long getDialogId() {
        return this.dialog_id;
    }

    public void setChecked(boolean checked, boolean animated) {
        CheckBox2 checkBox2 = this.checkBox;
        if (checkBox2 == null) {
            return;
        }
        checkBox2.setChecked(checked, animated);
    }

    public void setMxbDelegate(MxbHelper.MxbDelegate mxbDelegate) {
        this.mxbDelegate = mxbDelegate;
    }

    public void setCallOutDelegate(CallOutManager.CallOutDelegate callOutDelegate) {
        this.callOutDelegate = callOutDelegate;
    }
}
