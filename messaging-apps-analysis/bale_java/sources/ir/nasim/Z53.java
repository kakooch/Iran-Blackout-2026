package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* loaded from: classes2.dex */
public final class Z53 implements LeadingMarginSpan {
    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int lineForOffset;
        if (layout == null || paint == null || (lineForOffset = layout.getLineForOffset(i6)) != layout.getLineCount() - 1 || !AbstractC15565jn7.m(layout, lineForOffset)) {
            return;
        }
        float fA = AbstractC9522a63.a(layout, lineForOffset, paint) + AbstractC9522a63.c(layout, lineForOffset, paint);
        if (fA == 0.0f) {
            return;
        }
        AbstractC13042fc3.f(canvas);
        canvas.translate(fA, 0.0f);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return 0;
    }
}
