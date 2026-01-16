package ir.nasim;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* renamed from: ir.nasim.eE6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C12218eE6 extends MetricAffectingSpan {
    private final float a;

    public C12218eE6(float f) {
        this.a = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTextSkewX(this.a + textPaint.getTextSkewX());
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTextSkewX(this.a + textPaint.getTextSkewX());
    }
}
