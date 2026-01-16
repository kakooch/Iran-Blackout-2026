package ir.nasim;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* renamed from: ir.nasim.Fx1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C4619Fx1 extends MetricAffectingSpan {
    private final Typeface a;

    public C4619Fx1(Typeface typeface) {
        this.a = typeface;
    }

    private static void a(Paint paint, Typeface typeface) {
        paint.setTypeface(typeface);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        a(textPaint, this.a);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint, this.a);
    }
}
