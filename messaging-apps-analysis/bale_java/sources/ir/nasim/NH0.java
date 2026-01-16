package ir.nasim;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes5.dex */
public final class NH0 extends MetricAffectingSpan {
    private final int a(TextPaint textPaint) {
        return (int) ((textPaint.ascent() + textPaint.descent()) / 2.0f);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        AbstractC13042fc3.i(textPaint, "textPaint");
        textPaint.baselineShift += a(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        AbstractC13042fc3.i(textPaint, "textPaint");
        textPaint.baselineShift += a(textPaint);
    }
}
