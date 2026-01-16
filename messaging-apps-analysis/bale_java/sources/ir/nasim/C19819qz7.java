package ir.nasim;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;

/* renamed from: ir.nasim.qz7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C19819qz7 extends MetricAffectingSpan {
    private Typeface a;
    private int b;
    private int c;
    private int d = -1;
    m.h e;

    public C19819qz7(Typeface typeface) {
        this.a = typeface;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        int i = this.d;
        if (i >= 0) {
            this.c = ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, this.e);
        }
        Typeface typeface = this.a;
        if (typeface != null) {
            textPaint.setTypeface(typeface);
        }
        int i2 = this.b;
        if (i2 != 0) {
            textPaint.setTextSize(i2);
        }
        int i3 = this.c;
        if (i3 != 0) {
            textPaint.setColor(i3);
        }
        textPaint.setFlags(textPaint.getFlags() | 128);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        Typeface typeface = this.a;
        if (typeface != null) {
            textPaint.setTypeface(typeface);
        }
        int i = this.b;
        if (i != 0) {
            textPaint.setTextSize(i);
        }
        textPaint.setFlags(textPaint.getFlags() | 128);
    }
}
