package ir.nasim;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* renamed from: ir.nasim.qd0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C19595qd0 extends MetricAffectingSpan {
    private final float a;

    public C19595qd0(float f) {
        this.a = f;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.baselineShift += (int) Math.ceil(textPaint.ascent() * this.a);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.baselineShift += (int) Math.ceil(textPaint.ascent() * this.a);
    }
}
