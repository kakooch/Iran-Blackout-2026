package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* renamed from: ir.nasim.vl7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22749vl7 extends ReplacementSpan {
    private final int a;
    private final float b;

    public C22749vl7(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(paint, "paint");
        if (charSequence == null) {
            return;
        }
        int color = paint.getColor();
        paint.setColor(this.a);
        canvas.drawText(charSequence, i, i2, f, ((((i3 + i5) / 2.0f) + (i4 * 2)) / 3.0f) + this.b, paint);
        paint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        AbstractC13042fc3.i(paint, "paint");
        return (int) paint.measureText(charSequence, i, i2);
    }
}
