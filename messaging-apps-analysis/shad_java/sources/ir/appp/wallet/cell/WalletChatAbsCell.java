package ir.appp.wallet.cell;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.appp.wallet.WalletController;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class WalletChatAbsCell extends FrameLayout {
    private AvatarDrawable avatarDrawable;
    private int imageHeight;
    private ImageReceiver imageReceiver;
    private int imageWidth;
    private TextView textView;

    public WalletChatAbsCell(Context context) {
        super(context);
        this.imageReceiver = new ImageReceiver(this);
        this.avatarDrawable = new AvatarDrawable();
        this.imageWidth = -1;
        this.imageHeight = -1;
        setWillNotDraw(false);
        this.imageReceiver.setRoundRadius(AndroidUtilities.dp(42.0f));
        this.imageWidth = 50;
        this.imageHeight = 50;
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        this.textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textView.setTextSize(1, 17.0f);
        addView(this.textView, LayoutHelper.createFrame(-2, -2.0f, 21, 8.0f, 16.0f, this.imageWidth + 16, 16.0f));
    }

    public void setData(ChatAbsObject chatAbsObject) {
        this.avatarDrawable.setInfo(WalletController.convertChatAbsToTlObject(chatAbsObject));
        this.imageReceiver.setImage(null, "50_50", this.avatarDrawable, null, null, 0);
        this.textView.setText(WalletController.getChatAbsTitle(chatAbsObject));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.imageReceiver.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.imageReceiver.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.imageWidth != -1 && this.imageHeight != -1) {
            this.imageReceiver.setImageCoords((getWidth() - AndroidUtilities.dp(this.imageWidth)) - AndroidUtilities.dp(8.0f), (getHeight() - AndroidUtilities.dp(this.imageHeight)) / 2, AndroidUtilities.dp(this.imageWidth), AndroidUtilities.dp(this.imageHeight));
        } else {
            this.imageReceiver.setImageCoords(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.imageReceiver.draw(canvas);
    }
}
