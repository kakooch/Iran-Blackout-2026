package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* renamed from: ir.nasim.rm0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C20294rm0 implements LeadingMarginSpan {
    private static final boolean f;
    private C23767xU3 a;
    private final Paint b = GG4.a();
    private final RectF c = GG4.c();
    private final Rect d = GG4.b();
    private final int e;

    static {
        int i = Build.VERSION.SDK_INT;
        f = 24 == i || 25 == i;
    }

    public C20294rm0(C23767xU3 c23767xU3, int i) {
        this.a = c23767xU3;
        this.e = i;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int iMin;
        int iMax;
        if (z && AbstractC5806Kx3.b(i6, charSequence, this)) {
            this.b.set(paint);
            this.a.c(this.b);
            int iSave = canvas.save();
            try {
                int iE = this.a.e();
                int iF = this.a.f((int) ((this.b.descent() - this.b.ascent()) + 0.5f));
                int i8 = (iE - iF) / 2;
                if (f) {
                    int width = i2 < 0 ? i - (layout.getWidth() - (iE * this.e)) : (iE * this.e) - i;
                    int i9 = i + (i8 * i2);
                    int i10 = (i2 * iF) + i9;
                    int i11 = i2 * width;
                    iMin = Math.min(i9, i10) + i11;
                    iMax = Math.max(i9, i10) + i11;
                } else {
                    if (i2 <= 0) {
                        i -= iE;
                    }
                    iMin = i + i8;
                    iMax = iMin + iF;
                }
                int iDescent = (i4 + ((int) (((this.b.descent() + this.b.ascent()) / 2.0f) + 0.5f))) - (iF / 2);
                int i12 = iF + iDescent;
                int i13 = this.e;
                if (i13 == 0 || i13 == 1) {
                    this.c.set(iMin, iDescent, iMax, i12);
                    this.b.setStyle(this.e == 0 ? Paint.Style.FILL : Paint.Style.STROKE);
                    canvas.drawOval(this.c, this.b);
                } else {
                    this.d.set(iMin, iDescent, iMax, i12);
                    this.b.setStyle(Paint.Style.FILL);
                    canvas.drawRect(this.d, this.b);
                }
                canvas.restoreToCount(iSave);
            } catch (Throwable th) {
                canvas.restoreToCount(iSave);
                throw th;
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return this.a.e();
    }
}
