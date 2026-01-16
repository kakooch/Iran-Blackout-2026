package ir.nasim;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* renamed from: ir.nasim.w62, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22956w62 extends ReplacementSpan {
    private final androidx.emoji2.text.m b;
    private final Paint.FontMetricsInt a = new Paint.FontMetricsInt();
    private short c = -1;
    private short d = -1;
    private float e = 1.0f;

    AbstractC22956w62(androidx.emoji2.text.m mVar) {
        AbstractC4980Hj5.h(mVar, "rasterizer cannot be null");
        this.b = mVar;
    }

    public final androidx.emoji2.text.m a() {
        return this.b;
    }

    final int b() {
        return this.c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.a);
        Paint.FontMetricsInt fontMetricsInt2 = this.a;
        this.e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.b.e();
        this.d = (short) (this.b.e() * this.e);
        short sI = (short) (this.b.i() * this.e);
        this.c = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
