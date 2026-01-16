package org.rbmain.ui.Components;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;

/* loaded from: classes5.dex */
public class ColoredImageSpan extends ReplacementSpan {
    Drawable drawable;
    int drawableColor;

    public ColoredImageSpan(Drawable drawable) {
        this.drawable = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return this.drawable.getIntrinsicWidth();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (this.drawableColor != paint.getColor()) {
            this.drawableColor = paint.getColor();
            this.drawable.setColorFilter(new PorterDuffColorFilter(this.drawableColor, PorterDuff.Mode.MULTIPLY));
        }
        int intrinsicHeight = ((i5 - i3) - this.drawable.getIntrinsicHeight()) / 2;
        canvas.save();
        canvas.translate(f, i3 + intrinsicHeight);
        this.drawable.draw(canvas);
        canvas.restore();
    }
}
