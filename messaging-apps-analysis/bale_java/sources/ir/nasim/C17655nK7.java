package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;

/* renamed from: ir.nasim.nK7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17655nK7 extends ReplacementSpan {
    public final C21231tK7 a;
    private final String b;
    private TextPaint c;

    public C17655nK7(C21231tK7 c21231tK7, int i) {
        AbstractC13042fc3.i(c21231tK7, "user");
        this.a = c21231tK7;
        TextPaint textPaint = new TextPaint(129);
        this.c = textPaint;
        textPaint.setTextSize(C22078ud6.e(16.0f));
        this.c.setTypeface(C6011Lu2.k());
        this.c.setColor(C5495Jo7.a.g0());
        this.b = TextUtils.ellipsize((CharSequence) c21231tK7.r().b(), this.c, i - C22078ud6.a(18.0f), TextUtils.TruncateAt.END).toString();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(charSequence, "charSequence");
        AbstractC13042fc3.i(paint, "paint");
        int iMeasureText = (int) this.c.measureText(this.b);
        Paint paint2 = new Paint();
        paint2.setColor(C5495Jo7.a.j0());
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawRoundRect(new RectF(C22078ud6.a(4.0f) + f, i4 - C22078ud6.a(20.0f), iMeasureText + f + C22078ud6.a(28.0f), C22078ud6.a(8.0f) + i4), C22078ud6.a(14.0f), C22078ud6.a(14.0f), paint2);
        canvas.drawText(this.b, f + C22078ud6.a(16.0f), i4, this.c);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        AbstractC13042fc3.i(paint, "paint");
        AbstractC13042fc3.i(charSequence, "charSequence");
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = -C22078ud6.a(24.0f);
            int iA = C22078ud6.a(13.0f);
            fontMetricsInt.descent = iA;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = iA;
        }
        return ((int) this.c.measureText(this.b)) + C22078ud6.a(32.0f);
    }
}
