package ir.nasim;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* renamed from: ir.nasim.gu2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13839gu2 extends MetricAffectingSpan {
    private final String a;

    public C13839gu2(String str) {
        this.a = str;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setFontFeatureSettings(this.a);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setFontFeatureSettings(this.a);
    }
}
