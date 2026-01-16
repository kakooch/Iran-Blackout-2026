package ir.nasim;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.LineHeightSpan;

/* renamed from: ir.nasim.Em7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4292Em7 implements LineHeightSpan {
    private final Paint a;

    public C4292Em7(Paint paint) {
        AbstractC13042fc3.i(paint, "paint");
        this.a = paint;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        if (charSequence == null || fontMetricsInt == null) {
            return;
        }
        Rect rect = new Rect();
        this.a.getTextBounds(charSequence.toString(), i, i2, rect);
        fontMetricsInt.top = rect.top;
        fontMetricsInt.bottom = rect.bottom;
    }
}
