package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;

/* loaded from: classes3.dex */
public class ColoredImageSpan extends ReplacementSpan {
    Drawable drawable;
    int drawableColor;

    public ColoredImageSpan(Drawable drawable) {
        this.drawable = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i1, Paint.FontMetricsInt fontMetricsInt) {
        return this.drawable.getIntrinsicWidth();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        if (this.drawableColor != paint.getColor()) {
            this.drawableColor = paint.getColor();
            this.drawable.setColorFilter(new PorterDuffColorFilter(this.drawableColor, PorterDuff.Mode.MULTIPLY));
        }
        int intrinsicHeight = ((bottom - top) - this.drawable.getIntrinsicHeight()) / 2;
        canvas.save();
        canvas.translate(x, top + intrinsicHeight);
        this.drawable.draw(canvas);
        canvas.restore();
    }
}
