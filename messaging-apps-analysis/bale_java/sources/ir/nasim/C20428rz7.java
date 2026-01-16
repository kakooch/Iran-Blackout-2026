package ir.nasim;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* renamed from: ir.nasim.rz7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20428rz7 extends MetricAffectingSpan {
    private final Typeface a;

    public C20428rz7(Typeface typeface) {
        this.a = typeface;
    }

    private final void a(Paint paint) {
        paint.setTypeface(this.a);
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
