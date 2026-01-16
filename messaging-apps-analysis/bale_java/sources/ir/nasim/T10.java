package ir.nasim;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes6.dex */
public final class T10 extends MetricAffectingSpan {
    private final Typeface a;

    public T10(Typeface typeface) {
        this.a = typeface;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        AbstractC13042fc3.i(textPaint, "paint");
        textPaint.setTypeface(this.a);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        AbstractC13042fc3.i(textPaint, "paint");
        textPaint.setTypeface(this.a);
    }
}
