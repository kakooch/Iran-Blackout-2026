package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes3.dex */
public class WU2 extends MetricAffectingSpan implements LeadingMarginSpan {
    private final C23767xU3 a;
    private final Rect b = GG4.b();
    private final Paint c = GG4.a();
    private final int d;

    public WU2(C23767xU3 c23767xU3, int i) {
        this.a = c23767xU3;
        this.d = i;
    }

    private void a(TextPaint textPaint) {
        this.a.b(textPaint, this.d);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int width;
        int i8 = this.d;
        if ((i8 == 1 || i8 == 2) && AbstractC5806Kx3.a(i7, charSequence, this)) {
            this.c.set(paint);
            this.a.a(this.c);
            float strokeWidth = this.c.getStrokeWidth();
            if (strokeWidth > 0.0f) {
                int i9 = (int) ((i5 - strokeWidth) + 0.5f);
                if (i2 > 0) {
                    width = canvas.getWidth();
                } else {
                    width = i;
                    i -= canvas.getWidth();
                }
                this.b.set(i, i9, width, i5);
                canvas.drawRect(this.b, this.c);
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return 0;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
