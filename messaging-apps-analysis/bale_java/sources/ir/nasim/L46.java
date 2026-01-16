package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

/* loaded from: classes5.dex */
public final class L46 extends ReplacementSpan {
    private final int a;
    private final int b;
    private final int c;
    private final int d;

    public L46(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(paint, "paint");
        if (charSequence == null) {
            return;
        }
        float fMeasureText = paint.measureText(charSequence, i, i2);
        paint.getFontMetrics();
        float f2 = i4;
        RectF rectF = new RectF(f, (paint.getFontMetrics().ascent + f2) - this.d, fMeasureText + f + (this.c * 2), paint.getFontMetrics().descent + f2 + this.d);
        paint.setColor(this.a);
        float f3 = i5 - i3;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        paint.setColor(this.b);
        canvas.drawText(charSequence, i, i2, this.c + f, f2, paint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        AbstractC13042fc3.i(paint, "paint");
        return ((int) paint.measureText(charSequence, i, i2)) + (this.c * 2);
    }
}
