package ir.eitaa.ui.explore.cells;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class HashtagCell extends AppCompatTextView {
    Drawable icon;
    Paint p;

    public HashtagCell(Context context) {
        super(context);
        this.p = new Paint();
        setTextColor(Theme.getColor("chats_actionBackground"));
        setTextSize(14.0f);
        setGravity(LocaleController.isRTL ? 5 : 3);
        setTypeface(AndroidUtilities.getFontFamily(false));
    }

    public void setText(String text, Boolean isEnd) throws Resources.NotFoundException {
        Drawable drawable = getContext().getResources().getDrawable(isEnd.booleanValue() ? R.drawable.ic_read_more : R.drawable.ic_tag);
        this.icon = drawable;
        drawable.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(Theme.getColor("chats_actionBackground"), BlendModeCompat.SRC_ATOP));
        boolean z = LocaleController.isRTL;
        setCompoundDrawablesWithIntrinsicBounds(z ? null : this.icon, (Drawable) null, z ? this.icon : null, (Drawable) null);
        setCompoundDrawablePadding(4);
        setPadding(22, 8, 22, 8);
        setText(text);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.p.setColor(Theme.getColor("chats_actionBackground"));
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setStrokeWidth(AndroidUtilities.dp(2.0f));
        RectF rectF = new RectF(this.p.getStrokeWidth(), this.p.getStrokeWidth(), getWidth() - this.p.getStrokeWidth(), getHeight() - this.p.getStrokeWidth());
        canvas.drawRoundRect(rectF, AndroidUtilities.dp(SharedConfig.bubbleRadius), AndroidUtilities.dp(SharedConfig.bubbleRadius), this.p);
        this.p.setColor(Theme.getColor("chat_inBubble"));
        this.p.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(rectF, AndroidUtilities.dp(SharedConfig.bubbleRadius), AndroidUtilities.dp(SharedConfig.bubbleRadius), this.p);
        super.onDraw(canvas);
    }
}
