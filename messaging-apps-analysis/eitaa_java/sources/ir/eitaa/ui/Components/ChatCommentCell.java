package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.StaticLayout;
import android.text.TextPaint;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.ui.Cells.BaseCell;

/* loaded from: classes3.dex */
public class ChatCommentCell extends BaseCell {
    private static TextPaint currentMessagePaint = new TextPaint(1);
    private static TextPaint currentNamePaint = new TextPaint(1);
    private AvatarDrawable avatarDrawable;
    private ImageReceiver avatarImage;
    private int avatarLeft;
    private int avatarTop;
    private int currentAccount;
    private MessageObject message;
    private StaticLayout messageLayout;
    private int messageLeft;
    private int messageTop;
    private StaticLayout nameLayout;
    private int nameLeft;
    private TLRPC$User user;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }

    public ChatCommentCell(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.avatarImage = new ImageReceiver(this);
        this.avatarDrawable = new AvatarDrawable();
        this.user = null;
        this.messageTop = AndroidUtilities.dp(40.0f);
        this.avatarTop = AndroidUtilities.dp(8.0f);
        this.avatarImage.setRoundRadius(AndroidUtilities.dp(16.0f));
        currentMessagePaint.setTextSize(AndroidUtilities.dp(12.0f));
        currentNamePaint.setTextSize(AndroidUtilities.dp(12.0f));
        currentNamePaint.setTypeface(Typeface.DEFAULT_BOLD);
        currentNamePaint.setColor(-1);
        currentMessagePaint.setColor(-1);
    }

    public void setMessageObject(MessageObject object) {
        this.message = object;
        update();
    }

    public void update() {
        TLRPC$Message tLRPC$Message = this.message.messageOwner;
        if (tLRPC$Message != null && tLRPC$Message.from_id.user_id > 0) {
            this.user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.message.messageOwner.from_id.user_id));
        }
        TLRPC$User tLRPC$User = this.user;
        if (tLRPC$User != null) {
            TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = tLRPC$User.photo;
            if (tLRPC$UserProfilePhoto != null) {
                TLRPC$FileLocation tLRPC$FileLocation = tLRPC$UserProfilePhoto.photo_small;
            }
            this.avatarDrawable.setInfo(tLRPC$User);
        } else {
            this.avatarDrawable.setInfo(this.message.messageOwner.from_id.user_id, null, null, null);
        }
        this.avatarImage.setImage(ImageLocation.getForUserOrChat(this.user, 1), "50_50", this.avatarDrawable, null, null, 0);
        requestLayout();
        invalidate();
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x027d  */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r24, int r25) {
        /*
            Method dump skipped, instructions count: 778
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatCommentCell.onMeasure(int, int):void");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.nameLayout != null) {
            canvas.save();
            canvas.translate(this.nameLeft, AndroidUtilities.dp(8.0f));
            this.nameLayout.draw(canvas);
            canvas.restore();
        }
        if (this.messageLayout != null) {
            canvas.save();
            canvas.translate(this.messageLeft, this.messageTop);
            try {
                this.messageLayout.draw(canvas);
            } catch (Exception e) {
                FileLog.e(e);
            }
            canvas.restore();
        }
        this.avatarImage.draw(canvas);
    }
}
