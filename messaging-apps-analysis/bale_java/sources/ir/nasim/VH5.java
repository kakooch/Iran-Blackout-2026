package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;

/* loaded from: classes5.dex */
public class VH5 extends ReplacementSpan {
    public static final a q = new a(null);
    public static final int r = 8;
    private static final int s = AbstractC8943Xx1.c(18);
    private static final int t = AbstractC8943Xx1.c(4);
    private static final int u = AbstractC8943Xx1.c(5);
    private static final int v = AbstractC8943Xx1.c(9);
    private static final int w = AbstractC8943Xx1.c(14);
    private static final int x = AbstractC8943Xx1.c(4);
    private static final int y = AbstractC8943Xx1.c(14);
    private final String a;
    private final Drawable b;
    private final int c;
    private final Integer d;
    private final int e;
    private final int f;
    private final Float g;
    private final float h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final int p;

    public static final class a {
        private a() {
        }

        public final int a() {
            return VH5.y;
        }

        public final int b() {
            return VH5.s;
        }

        public final int c() {
            return VH5.x;
        }

        public final int d() {
            return VH5.t;
        }

        public final int e() {
            return VH5.v;
        }

        public final int f() {
            return VH5.w;
        }

        public final int g() {
            return VH5.u;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ VH5(String str, Drawable drawable, int i, Integer num, int i2, int i3, Float f, float f2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, ED1 ed1) {
        this(str, (i11 & 2) != 0 ? null : drawable, i, num, i2, (i11 & 32) != 0 ? s : i3, (i11 & 64) != 0 ? null : f, (i11 & 128) != 0 ? y : f2, (i11 & 256) != 0 ? u : i4, (i11 & 512) != 0 ? u : i5, (i11 & 1024) != 0 ? t : i6, (i11 & 2048) != 0 ? t : i7, (i11 & 4096) != 0 ? v : i8, (i11 & 8192) != 0 ? v : i9, (i11 & 16384) != 0 ? x : i10);
    }

    private final int h(int i, int i2, Paint paint) {
        return (i + i2) / 2;
    }

    private final float n(Paint paint, int i) {
        String strV = this.a.length() == 0 ? XY6.v("1") : this.a;
        Rect rect = new Rect();
        paint.getTextBounds(strV, 0, strV.length(), rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        return (i + i3) - ((this.f - (i2 - i3)) / 2);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(paint, "paint");
        int iH = i4 != i5 ? i4 : h(i3, i5, paint);
        int size = getSize(paint, charSequence, i, i2, paint.getFontMetricsInt());
        float f2 = f + this.m;
        float fN = n(paint, iH);
        float f3 = this.f + fN;
        float fMeasureText = f2 + (this.a.length() == 0 ? 0.0f : paint.measureText(this.a) + this.o);
        float f4 = f + size;
        float f5 = fN - this.i;
        float f6 = f3 + this.j;
        i(canvas, paint, f, f4, f5, f6);
        l(canvas, f + 2.0f, f5 + 2.0f, f4 - 2.0f, f6 - 2.0f, paint);
        j(canvas, this.a, f2, iH, paint);
        k(canvas, fMeasureText, fN);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        AbstractC13042fc3.i(paint, "paint");
        u(fontMetricsInt);
        return (int) ((this.a.length() == 0 ? 0.0f : paint.measureText(this.a) + this.o) + this.f + this.m + this.n);
    }

    protected final void i(Canvas canvas, Paint paint, float f, float f2, float f3, float f4) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(paint, "paint");
        int color = paint.getColor();
        paint.setColor(this.c);
        paint.setStyle(Paint.Style.FILL);
        RectF rectF = new RectF(f, f3, f2, f4);
        float f5 = this.h;
        canvas.drawRoundRect(rectF, f5, f5, paint);
        paint.setColor(color);
    }

    protected final void j(Canvas canvas, String str, float f, float f2, Paint paint) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        AbstractC13042fc3.i(paint, "paint");
        int color = paint.getColor();
        paint.setColor(this.e);
        float textSize = paint.getTextSize();
        Float f3 = this.g;
        if (f3 != null) {
            paint.setTextSize(f3.floatValue());
        }
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(str, f, f2, paint);
        paint.setColor(color);
        paint.setTextSize(textSize);
    }

    protected final void k(Canvas canvas, float f, float f2) {
        AbstractC13042fc3.i(canvas, "canvas");
        int iSave = canvas.save();
        canvas.translate(f, f2);
        try {
            Drawable drawable = this.b;
            if (drawable != null) {
                int i = this.f;
                drawable.setBounds(0, 0, i, i);
            }
            Drawable drawable2 = this.b;
            if (drawable2 != null) {
                drawable2.draw(canvas);
            }
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            canvas.restoreToCount(iSave);
            throw th;
        }
    }

    protected final void l(Canvas canvas, float f, float f2, float f3, float f4, Paint paint) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(paint, "paint");
        if (this.d != null) {
            int color = paint.getColor();
            paint.setColor(this.d.intValue());
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(3.0f);
            RectF rectF = new RectF(f, f2, f3, f4);
            float f5 = this.h;
            canvas.drawRoundRect(rectF, f5, f5, paint);
            paint.setColor(color);
        }
    }

    protected final int m() {
        return this.f;
    }

    protected final int o() {
        return this.o;
    }

    protected final int p() {
        return this.k;
    }

    protected final int q() {
        return this.j;
    }

    protected final int r() {
        return this.n;
    }

    protected final int s() {
        return this.m;
    }

    protected final int t() {
        return this.i;
    }

    protected final void u(Paint.FontMetricsInt fontMetricsInt) {
        int i;
        int i2;
        if (fontMetricsInt != null && (i2 = (i = fontMetricsInt.descent) - fontMetricsInt.ascent) > 0) {
            float f = (this.p * 1.0f) / i2;
            int iD = AbstractC20723sV3.d(i * f);
            fontMetricsInt.descent = iD;
            fontMetricsInt.ascent = iD - this.p;
            int iD2 = AbstractC20723sV3.d(fontMetricsInt.bottom * f);
            fontMetricsInt.bottom = iD2;
            fontMetricsInt.top = iD2 - this.p;
        }
    }

    public VH5(String str, Drawable drawable, int i, Integer num, int i2, int i3, Float f, float f2, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        AbstractC13042fc3.i(str, "count");
        this.a = str;
        this.b = drawable;
        this.c = i;
        this.d = num;
        this.e = i2;
        this.f = i3;
        this.g = f;
        this.h = f2;
        this.i = i4;
        this.j = i5;
        this.k = i6;
        this.l = i7;
        this.m = i8;
        this.n = i9;
        this.o = i10;
        this.p = i3 + i4 + i5 + i6 + i7;
    }
}
