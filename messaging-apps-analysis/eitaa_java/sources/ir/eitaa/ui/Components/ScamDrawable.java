package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;

/* loaded from: classes3.dex */
public class ScamDrawable extends Drawable {
    private int currentType;
    private String text;
    private TextPaint textPaint;
    private int textWidth;
    private RectF rect = new RectF();
    private Paint paint = new Paint(1);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public ScamDrawable(int textSize, int type) {
        TextPaint textPaint = new TextPaint(1);
        this.textPaint = textPaint;
        this.currentType = type;
        textPaint.setTextSize(AndroidUtilities.dp(textSize));
        this.textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(AndroidUtilities.dp(1.0f));
        if (type == 0) {
            this.text = LocaleController.getString("TrustyMessage", R.string.TrustyMessage);
        } else if (type == 1) {
            this.text = LocaleController.getString("FakeMessage", R.string.FakeMessage);
        } else if (type == 2) {
            this.text = LocaleController.getString("ShopMessage", R.string.ShopMessage);
        }
        this.textWidth = (int) Math.ceil(this.textPaint.measureText(this.text));
    }

    public void checkText() {
        String string;
        int i = this.currentType;
        if (i == 0) {
            string = LocaleController.getString("TrustyMessage", R.string.TrustyMessage);
        } else if (i == 1) {
            string = LocaleController.getString("FakeMessage", R.string.FakeMessage);
        } else {
            string = i == 2 ? LocaleController.getString("ShopMessage", R.string.ShopMessage) : "";
        }
        if (string.equals(this.text)) {
            return;
        }
        this.text = string;
        this.textWidth = (int) Math.ceil(this.textPaint.measureText(string));
    }

    public void setColor(int color) {
        this.textPaint.setColor(color);
        this.paint.setColor(color);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.textWidth + AndroidUtilities.dp(10.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return AndroidUtilities.dp(16.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.rect.set(getBounds());
        canvas.drawRoundRect(this.rect, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), this.paint);
        canvas.drawText(this.text, this.rect.left + AndroidUtilities.dp(5.0f), this.rect.top + AndroidUtilities.dp(12.0f), this.textPaint);
    }
}
