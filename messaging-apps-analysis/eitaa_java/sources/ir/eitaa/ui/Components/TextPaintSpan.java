package ir.eitaa.ui.Components;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes3.dex */
public class TextPaintSpan extends MetricAffectingSpan {
    private TextPaint textPaint;

    public TextPaintSpan(TextPaint paint) {
        this.textPaint = paint;
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint p) {
        p.setColor(this.textPaint.getColor());
        p.setTypeface(this.textPaint.getTypeface());
        p.setFlags(this.textPaint.getFlags());
        p.setTextSize(this.textPaint.getTextSize());
        TextPaint textPaint = this.textPaint;
        p.baselineShift = textPaint.baselineShift;
        p.bgColor = textPaint.bgColor;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint p) {
        p.setColor(this.textPaint.getColor());
        p.setTypeface(this.textPaint.getTypeface());
        p.setFlags(this.textPaint.getFlags());
        p.setTextSize(this.textPaint.getTextSize());
        TextPaint textPaint = this.textPaint;
        p.baselineShift = textPaint.baselineShift;
        p.bgColor = textPaint.bgColor;
    }
}
