package ir.nasim;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* renamed from: ir.nasim.Nw6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6527Nw6 extends CharacterStyle {
    private final int a;
    private final float b;
    private final float c;
    private final float d;

    public C6527Nw6(int i, float f, float f2, float f3) {
        this.a = i;
        this.b = f;
        this.c = f2;
        this.d = f3;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setShadowLayer(this.d, this.b, this.c, this.a);
    }
}
