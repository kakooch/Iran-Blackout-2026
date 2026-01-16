package ir.eitaa.ui.Components;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes3.dex */
public class TextPaintUrlSpan extends MetricAffectingSpan {
    private String currentUrl;
    private TextPaint textPaint;

    public TextPaintUrlSpan(TextPaint paint, String url) {
        this.textPaint = paint;
        this.currentUrl = url;
    }

    public String getUrl() {
        return this.currentUrl;
    }

    public TextPaint getTextPaint() {
        return this.textPaint;
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint p) {
        TextPaint textPaint = this.textPaint;
        if (textPaint != null) {
            p.setColor(textPaint.getColor());
            p.setTypeface(this.textPaint.getTypeface());
            p.setFlags(this.textPaint.getFlags());
            p.setTextSize(this.textPaint.getTextSize());
            TextPaint textPaint2 = this.textPaint;
            p.baselineShift = textPaint2.baselineShift;
            p.bgColor = textPaint2.bgColor;
        }
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint p) {
        TextPaint textPaint = this.textPaint;
        if (textPaint != null) {
            p.setColor(textPaint.getColor());
            p.setTypeface(this.textPaint.getTypeface());
            p.setFlags(this.textPaint.getFlags());
            p.setTextSize(this.textPaint.getTextSize());
            TextPaint textPaint2 = this.textPaint;
            p.baselineShift = textPaint2.baselineShift;
            p.bgColor = textPaint2.bgColor;
        }
    }
}
