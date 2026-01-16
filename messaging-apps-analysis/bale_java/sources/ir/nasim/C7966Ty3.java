package ir.nasim;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* renamed from: ir.nasim.Ty3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7966Ty3 extends MetricAffectingSpan {
    private final float a;

    public C7966Ty3(float f) {
        this.a = f;
    }

    private final void a(TextPaint textPaint) {
        float textSize = textPaint.getTextSize() * textPaint.getTextScaleX();
        if (textSize == 0.0f) {
            return;
        }
        textPaint.setLetterSpacing(this.a / textSize);
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
