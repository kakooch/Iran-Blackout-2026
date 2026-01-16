package ir.nasim;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* renamed from: ir.nasim.zl7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C25119zl7 extends CharacterStyle {
    private final boolean a;
    private final boolean b;

    public C25119zl7(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(this.a);
        textPaint.setStrikeThruText(this.b);
    }
}
