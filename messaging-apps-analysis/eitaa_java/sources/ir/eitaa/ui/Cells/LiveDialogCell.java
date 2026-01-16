package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
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
public class LiveDialogCell extends FrameLayout {
    private int animTime;
    private AvatarDrawable avatarDrawable;
    private int currentAccount;
    private long dialog_id;
    private ImageReceiver imageView;
    private TextPaint liveTextPaint;
    private RectF liveTextRect;
    private TextView nameTextView;
    private RadialGradient radialShader;
    private RectF rect;
    private long t;

    public LiveDialogCell(Context context) {
        super(context);
        this.avatarDrawable = new AvatarDrawable();
        this.currentAccount = UserConfig.selectedAccount;
        this.rect = new RectF();
        this.radialShader = new RadialGradient(AndroidUtilities.dp(26.0f), AndroidUtilities.dp(26.0f), AndroidUtilities.dp(20.0f), 16777215, 872415231, Shader.TileMode.MIRROR);
        this.t = 0L;
        this.animTime = 0;
        ImageReceiver imageReceiver = new ImageReceiver(this);
        this.imageView = imageReceiver;
        imageReceiver.setRoundRadius(AndroidUtilities.dp(26.0f));
        addView(new ImageView(context), LayoutHelper.createFrame(52, 52.0f, 49, 0.0f, 7.0f, 0.0f, 0.0f));
        TextView textView = new TextView(context);
        this.nameTextView = textView;
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.nameTextView.setTextSize(1, 12.0f);
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.nameTextView.setMaxLines(2);
        this.nameTextView.setGravity(49);
        this.nameTextView.setLines(2);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.nameTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 6.0f, 64.0f, 6.0f, 0.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(100.0f), 1073741824));
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

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
        int width = (getWidth() - AndroidUtilities.dp(52.0f)) / 2;
        int iDp = AndroidUtilities.dp(7.0f);
        canvas.save();
        float f = width;
        float f2 = iDp;
        canvas.translate(f, f2);
        Paint.Style style = Theme.avatar_backgroundPaint.getStyle();
        Theme.avatar_backgroundPaint.setStyle(Paint.Style.FILL);
        Theme.avatar_backgroundPaint.setColor(-13158601);
        canvas.drawCircle(AndroidUtilities.dp(26.0f), AndroidUtilities.dp(26.0f), AndroidUtilities.dp(24.0f), Theme.avatar_backgroundPaint);
        Theme.avatar_backgroundPaint.setStyle(Paint.Style.STROKE);
        Theme.avatar_backgroundPaint.setStrokeWidth(AndroidUtilities.dp(1.0f));
        Theme.avatar_backgroundPaint.setColor(-1674199);
        canvas.drawCircle(AndroidUtilities.dp(26.0f), AndroidUtilities.dp(26.0f), AndroidUtilities.dp(26.0f), Theme.avatar_backgroundPaint);
        long jCurrentTimeMillis = System.currentTimeMillis() - this.t;
        this.t = System.currentTimeMillis();
        if (jCurrentTimeMillis > 16) {
            jCurrentTimeMillis = 16;
        }
        int i = (int) (this.animTime + jCurrentTimeMillis);
        this.animTime = i;
        if (i > 1000) {
            this.animTime = 0;
        }
        float fDp = ((int) ((AndroidUtilities.dp(23.0f) * this.animTime) / 1000.0f)) + 1;
        RadialGradient radialGradient = new RadialGradient(AndroidUtilities.dp(26.0f), AndroidUtilities.dp(26.0f), fDp, 16777215, 872415231, Shader.TileMode.MIRROR);
        this.radialShader = radialGradient;
        Theme.avatar_backgroundPaint.setShader(radialGradient);
        canvas.drawCircle(AndroidUtilities.dp(26.0f), AndroidUtilities.dp(26.0f), fDp, Theme.avatar_backgroundPaint);
        Theme.avatar_backgroundPaint.setShader(null);
        if (this.liveTextPaint == null) {
            TextPaint textPaint = new TextPaint(1);
            this.liveTextPaint = textPaint;
            textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
            this.liveTextPaint.setTextSize(AndroidUtilities.dp(6.0f));
            this.liveTextPaint.setColor(-1);
        }
        Theme.avatar_backgroundPaint.setStyle(style);
        canvas.restore();
        canvas.save();
        canvas.translate(f, f2);
        float fMeasureText = this.liveTextPaint.measureText(LocaleController.getString("ChatLiveStream", R.string.ChatLiveStream));
        if (this.liveTextRect == null) {
            this.liveTextRect = new RectF();
        }
        float f3 = fMeasureText / 2.0f;
        this.liveTextRect.set(AndroidUtilities.dp(24.0f) - f3, AndroidUtilities.dp(47.0f), AndroidUtilities.dp(28.0f) + f3, AndroidUtilities.dp(57.0f));
        Theme.avatar_backgroundPaint.setColor(-1);
        canvas.drawRoundRect(this.liveTextRect, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), Theme.avatar_backgroundPaint);
        this.liveTextRect.set(AndroidUtilities.dp(25.0f) - f3, AndroidUtilities.dp(48.0f), AndroidUtilities.dp(27.0f) + f3, AndroidUtilities.dp(56.0f));
        Theme.avatar_backgroundPaint.setColor(-1674199);
        canvas.drawRoundRect(this.liveTextRect, AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), Theme.avatar_backgroundPaint);
        canvas.drawText(LocaleController.getString("ChatLiveStream", R.string.ChatLiveStream), AndroidUtilities.dp(26.0f) - f3, AndroidUtilities.dp(55.0f), this.liveTextPaint);
        Theme.avatar_backgroundPaint.setStyle(style);
        canvas.restore();
        postInvalidate();
        this.imageView.setImageCoords(width + AndroidUtilities.dp(10.0f), iDp + AndroidUtilities.dp(10.0f), AndroidUtilities.dp(32.0f), AndroidUtilities.dp(32.0f));
        this.imageView.draw(canvas);
        return zDrawChild;
    }
}
