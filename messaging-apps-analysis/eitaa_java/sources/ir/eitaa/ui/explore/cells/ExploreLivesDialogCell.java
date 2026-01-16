package ir.eitaa.ui.explore.cells;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
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
public class ExploreLivesDialogCell extends FrameLayout {
    private AvatarDrawable avatarDrawable;
    private ImageView avatarImageView;
    private int currentAccount;
    private long dialog_id;
    private ImageReceiver imageView;
    private TextView nameTextView;

    public ExploreLivesDialogCell(Context context) {
        super(context);
        this.avatarDrawable = new AvatarDrawable();
        this.currentAccount = UserConfig.selectedAccount;
        setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("listSelectorSDK21"), 2));
        ImageReceiver imageReceiver = new ImageReceiver(this);
        this.imageView = imageReceiver;
        imageReceiver.setRoundRadius(AndroidUtilities.dp(26.0f));
        this.imageView.getBitmap();
        ImageView imageView = new ImageView(context);
        this.avatarImageView = imageView;
        addView(imageView, LayoutHelper.createFrame(52, 52.0f, 21, 0.0f, 8.0f, 16.0f, 8.0f));
        TextView textView = new TextView(context);
        this.nameTextView = textView;
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.nameTextView.setTextSize(1, 16.0f);
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.nameTextView.setMaxLines(1);
        this.nameTextView.setGravity(21);
        this.nameTextView.setLines(1);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.nameTextView, LayoutHelper.createFrame(-1, -2.0f, 21, 16.0f, 0.0f, 84.0f, 0.0f));
    }

    public void setDialog(int uid, boolean counter, CharSequence name) {
        TLRPC$ChatPhoto tLRPC$ChatPhoto;
        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto;
        long j = uid;
        this.dialog_id = j;
        TLRPC$FileLocation tLRPC$FileLocation = null;
        if (uid > 0) {
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(j));
            if (name != null) {
                this.nameTextView.setText(name);
            } else if (user != null) {
                this.nameTextView.setText(ContactsController.formatName(user.first_name, user.last_name));
            } else {
                this.nameTextView.setText("");
            }
            this.avatarDrawable.setInfo(user);
            if (user != null && (tLRPC$UserProfilePhoto = user.photo) != null) {
                tLRPC$FileLocation = tLRPC$UserProfilePhoto.photo_small;
            }
        } else {
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-uid));
            if (name != null) {
                this.nameTextView.setText(name);
            } else if (chat != null) {
                this.nameTextView.setText(chat.title);
            } else {
                this.nameTextView.setText("");
            }
            this.avatarDrawable.setInfo(chat);
            if (chat != null && (tLRPC$ChatPhoto = chat.photo) != null) {
                tLRPC$FileLocation = tLRPC$ChatPhoto.photo_small;
            }
        }
        this.imageView.setImage(null, null, ImageLocation.getForLocal(tLRPC$FileLocation), "50_50", null, null, this.avatarDrawable, 0, null, null, 0);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(AndroidUtilities.dp(16.0f), getMeasuredHeight() - 1, getMeasuredWidth(), getMeasuredHeight(), Theme.dividerPaint);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
        this.imageView.setImageCoords(this.avatarImageView.getX(), this.avatarImageView.getY(), AndroidUtilities.dp(52.0f), AndroidUtilities.dp(52.0f));
        this.imageView.draw(canvas);
        return zDrawChild;
    }
}
