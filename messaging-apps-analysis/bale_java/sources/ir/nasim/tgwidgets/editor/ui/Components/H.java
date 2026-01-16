package ir.nasim.tgwidgets.editor.ui.Components;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.G;

/* loaded from: classes7.dex */
public class H extends MetricAffectingSpan {
    private CharSequence a;
    private int b;
    private int c;
    private byte d;
    private G.a e;

    public H(CharSequence charSequence, int i, int i2, byte b, G.a aVar) {
        this.a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = b;
        this.e = aVar;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTextSize(AbstractC21455b.F(AbstractC8662Wx6.r0 - 1));
        byte b = this.d;
        if (b == 2) {
            textPaint.setColor(-1);
        } else if (b == 1) {
            textPaint.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Ia));
        } else {
            textPaint.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Ha));
        }
        G.a aVar = this.e;
        if (aVar != null) {
            aVar.a(textPaint);
        } else {
            textPaint.setTypeface(Typeface.MONOSPACE);
            textPaint.setUnderlineText(false);
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTextSize(AbstractC21455b.F(AbstractC8662Wx6.r0 - 1));
        textPaint.setFlags(textPaint.getFlags() | 128);
        G.a aVar = this.e;
        if (aVar != null) {
            aVar.a(textPaint);
        } else {
            textPaint.setTypeface(Typeface.MONOSPACE);
        }
    }
}
