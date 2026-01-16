package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* loaded from: classes3.dex */
public class QL4 implements LeadingMarginSpan {
    private final C23767xU3 a;
    private final String b;
    private final String c;
    private final Paint d = GG4.a();
    private int e;

    public QL4(C23767xU3 c23767xU3, String str, String str2) {
        this.a = c23767xU3;
        this.c = str;
        this.b = str2;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if (z && AbstractC5806Kx3.b(i6, charSequence, this)) {
            this.d.set(paint);
            this.a.c(this.d);
            int iMeasureText = (int) (this.d.measureText(this.c) + 0.5f);
            int iE = this.a.e();
            if (iMeasureText > iE) {
                this.e = iMeasureText;
                iE = iMeasureText;
            } else {
                this.e = 0;
            }
            canvas.drawText(i2 == 1 ? this.c : this.b, i2 > 0 ? (i + (iE * i2)) - iMeasureText : i + (iE * i2) + (iE - iMeasureText), i4, this.d);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return Math.max(this.e, this.a.e());
    }
}
