package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.StaticLayout;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatPhoto;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserProfilePhoto;
import org.rbmain.tgnet.TLRPC$UserStatus;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AvatarDrawable;

/* loaded from: classes4.dex */
public class ProfileSearchCell extends BaseCell {
    private AvatarDrawable avatarDrawable;
    private ImageReceiver avatarImage;
    private TLRPC$Chat chat;
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
    private StaticLayout nameLayout;
    private int nameLeft;
    private int nameLockLeft;
    private int nameLockTop;
    private int nameTop;
    private int nameWidth;
    private RectF rect;
    private boolean savedMessages;
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
        ImageReceiver imageReceiver = new ImageReceiver(this);
        this.avatarImage = imageReceiver;
        imageReceiver.setRoundRadius(AndroidUtilities.dp(23.0f));
        this.avatarDrawable = new AvatarDrawable();
    }

    public void setData(TLObject tLObject, TLRPC$EncryptedChat tLRPC$EncryptedChat, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2) {
        this.currentName = charSequence;
        if (tLObject instanceof TLRPC$User) {
            this.user = (TLRPC$User) tLObject;
            this.chat = null;
        } else if (tLObject instanceof TLRPC$Chat) {
            this.chat = (TLRPC$Chat) tLObject;
            this.user = null;
        }
        this.encryptedChat = tLRPC$EncryptedChat;
        this.subLabel = charSequence2;
        this.drawCount = z;
        this.savedMessages = z2;
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
        setMeasuredDimension(View.MeasureSpec.getSize(i), AndroidUtilities.dp(60.0f) + (this.useSeparator ? 1 : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!(this.user == null && this.chat == null && this.encryptedChat == null) && z) {
            buildLayout();
        }
    }

    public TLRPC$User getUser() {
        return this.user;
    }

    public TLRPC$Chat getChat() {
        return this.chat;
    }

    public void setSublabelOffset(int i, int i2) {
        this.sublabelOffsetX = i;
        this.sublabelOffsetY = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void buildLayout() {
        /*
            Method dump skipped, instructions count: 1498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ProfileSearchCell.buildLayout():void");
    }

    public void update(int i) {
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
                this.avatarImage.setForUserOrChat(tLRPC$User3, this.avatarDrawable);
            }
        } else {
            TLRPC$Chat tLRPC$Chat = this.chat;
            if (tLRPC$Chat != null) {
                TLRPC$ChatPhoto tLRPC$ChatPhoto = tLRPC$Chat.photo;
                tLRPC$FileLocation = tLRPC$ChatPhoto != null ? tLRPC$ChatPhoto.photo_small : null;
                this.avatarDrawable.setInfo(tLRPC$Chat);
                this.avatarImage.setForUserOrChat(this.chat, this.avatarDrawable);
            } else {
                this.avatarDrawable.setInfo(0L, null, null);
                this.avatarImage.setImage(null, null, this.avatarDrawable, null, null, 0);
            }
        }
        if (i != 0) {
            boolean z = !(((i & 2) == 0 || this.user == null) && ((i & 8) == 0 || this.chat == null)) && (((tLRPC$FileLocation = this.lastAvatar) != null && tLRPC$FileLocation == null) || ((tLRPC$FileLocation == null && tLRPC$FileLocation != null) || !(tLRPC$FileLocation == null || tLRPC$FileLocation == null || (tLRPC$FileLocation.volume_id == tLRPC$FileLocation.volume_id && tLRPC$FileLocation.local_id == tLRPC$FileLocation.local_id))));
            if (!z && (i & 4) != 0 && (tLRPC$User = this.user) != null) {
                TLRPC$UserStatus tLRPC$UserStatus = tLRPC$User.status;
                if ((tLRPC$UserStatus != null ? tLRPC$UserStatus.expires : 0) != this.lastStatus) {
                    z = true;
                }
            }
            if ((!z && (i & 1) != 0 && this.user != null) || ((i & 16) != 0 && this.chat != null)) {
                if (this.user != null) {
                    str = this.user.first_name + this.user.last_name;
                } else {
                    str = this.chat.title;
                }
                if (!str.equals(this.lastName)) {
                    z = true;
                }
            }
            if (!((z || !this.drawCount || (i & 256) == 0 || (tLRPC$Dialog = MessagesController.getInstance(this.currentAccount).dialogs_dict.get(this.dialog_id)) == null || tLRPC$Dialog.unread_count == this.lastUnreadCount) ? z : true)) {
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
            BaseCell.setDrawableBounds(Theme.dialogs_broadcastDrawable, this.nameLockLeft, this.nameLockTop);
            Theme.dialogs_broadcastDrawable.draw(canvas);
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
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
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
        accessibilityNodeInfo.setText(sb.toString());
    }
}
