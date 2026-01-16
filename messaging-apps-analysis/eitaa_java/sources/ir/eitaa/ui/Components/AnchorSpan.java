package ir.eitaa.ui.Components;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes3.dex */
public class AnchorSpan extends MetricAffectingSpan {
    private String name;

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint p) {
    }

    public AnchorSpan(String n) {
        this.name = n.toLowerCase();
    }

    public String getName() {
        return this.name;
    }
}
