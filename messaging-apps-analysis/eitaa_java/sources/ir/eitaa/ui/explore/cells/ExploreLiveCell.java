package ir.eitaa.ui.explore.cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class ExploreLiveCell extends FrameLayout {
    private AvatarDrawable avatarDrawable;
    private int currentAccount;
    private long dialog_id;
    private ImageReceiver imageView;

    public ExploreLiveCell(Context context) {
        super(context);
        this.avatarDrawable = new AvatarDrawable();
        this.currentAccount = UserConfig.selectedAccount;
        ImageReceiver imageReceiver = new ImageReceiver(this);
        this.imageView = imageReceiver;
        imageReceiver.setRoundRadius(AndroidUtilities.dp(26.0f));
        addView(new ImageView(context), LayoutHelper.createFrame(52, 52.0f, 49, 0.0f, 7.0f, 0.0f, 0.0f));
    }

    public void setDialog(int uid, boolean counter, CharSequence name) {
        TLRPC$ChatPhoto tLRPC$ChatPhoto;
        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto;
        long j = uid;
        this.dialog_id = j;
        TLRPC$FileLocation tLRPC$FileLocation = null;
        if (uid > 0) {
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(j));
            this.avatarDrawable.setInfo(user);
            if (user != null && (tLRPC$UserProfilePhoto = user.photo) != null) {
                tLRPC$FileLocation = tLRPC$UserProfilePhoto.photo_small;
            }
        } else {
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-uid));
            this.avatarDrawable.setInfo(chat);
            if (chat != null && (tLRPC$ChatPhoto = chat.photo) != null) {
                tLRPC$FileLocation = tLRPC$ChatPhoto.photo_small;
            }
        }
        this.imageView.setImage(null, null, ImageLocation.getForLocal(tLRPC$FileLocation), "50_50", null, null, this.avatarDrawable, 0, null, null, 0);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
        Paint.Style style = Theme.avatar_backgroundPaint.getStyle();
        Theme.avatar_backgroundPaint.setColor(Theme.getColor("avatar_backgroundBlue"));
        Theme.avatar_backgroundPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(20.0f), AndroidUtilities.dp(19.0f), Theme.avatar_backgroundPaint);
        this.imageView.setImageCoords(AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), AndroidUtilities.dp(38.0f), AndroidUtilities.dp(38.0f));
        this.imageView.draw(canvas);
        Theme.avatar_backgroundPaint.setStyle(Paint.Style.STROKE);
        Theme.avatar_backgroundPaint.setStrokeWidth(AndroidUtilities.dp(1.0f));
        Theme.avatar_backgroundPaint.setColor(Theme.getColor("chats_actionBackground"));
        canvas.drawCircle(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(20.0f), AndroidUtilities.dp(19.0f), Theme.avatar_backgroundPaint);
        Theme.avatar_backgroundPaint.setStyle(style);
        return zDrawChild;
    }
}
