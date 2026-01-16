package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.LineBackgroundSpan;

/* loaded from: classes5.dex */
public final class K46 implements LineBackgroundSpan {
    public static final a c = new a(null);
    private final int a;
    private final int b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public K46(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // android.text.style.LineBackgroundSpan
    public void drawBackground(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, int i8) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(paint, "paint");
        AbstractC13042fc3.i(charSequence, ParameterNames.TEXT);
        int color = paint.getColor();
        paint.setColor(this.a);
        canvas.drawRoundRect(new RectF(i, i3, i2, i5), AbstractC8943Xx1.c(this.b), AbstractC8943Xx1.c(this.b), paint);
        paint.setColor(color);
    }
}
