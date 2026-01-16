package ir.nasim;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* renamed from: ir.nasim.Sy3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7727Sy3 extends MetricAffectingSpan {
    private final float a;

    public C7727Sy3(float f) {
        this.a = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setLetterSpacing(this.a);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setLetterSpacing(this.a);
    }
}
