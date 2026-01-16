package ir.nasim;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* renamed from: ir.nasim.Fz3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4654Fz3 implements LineHeightSpan {
    private final float a;

    public C4654Fz3(float f) {
        this.a = f;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        if (AbstractC5356Iz3.a(fontMetricsInt) <= 0) {
            return;
        }
        int iCeil = (int) Math.ceil(fontMetricsInt.descent * ((r4 * 1.0f) / r3));
        fontMetricsInt.descent = iCeil;
        fontMetricsInt.ascent = iCeil - ((int) Math.ceil(this.a));
    }
}
