package ir.nasim;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* renamed from: ir.nasim.s00, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20431s00 implements LineHeightSpan {
    private final int a;

    public C20431s00(int i) {
        this.a = i;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        int i5;
        int i6;
        if (fontMetricsInt == null || (i6 = (i5 = fontMetricsInt.descent) - fontMetricsInt.ascent) <= 0) {
            return;
        }
        int iD = AbstractC20723sV3.d(i5 * ((this.a * 1.0f) / i6));
        fontMetricsInt.descent = iD;
        fontMetricsInt.ascent = iD - this.a;
    }
}
