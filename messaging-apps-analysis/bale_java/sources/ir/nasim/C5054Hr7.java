package ir.nasim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.Hr7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5054Hr7 extends Drawable {
    private final int a;
    private final Context b;
    private final int c;
    private final int d;
    private final int e;
    private final float f;
    private final float g;
    private int h;
    private final Drawable i;
    private final float j;
    private final float k;
    private final Paint l;
    private final Paint m;

    public /* synthetic */ C5054Hr7(int i, Context context, int i2, int i3, int i4, float f, float f2, int i5, ED1 ed1) {
        this(i, context, (i5 & 4) != 0 ? -1 : i2, (i5 & 8) != 0 ? -1 : i3, (i5 & 16) != 0 ? 60 : i4, (i5 & 32) != 0 ? 1.5f : f, (i5 & 64) != 0 ? 0.5f : f2);
    }

    public final void a(int i) {
        this.h = AbstractC23053wG5.m(i, 0, 100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        int iWidth = getBounds().width();
        int iHeight = getBounds().height();
        int i = (int) (24 * this.j);
        int i2 = getBounds().left + ((iWidth - i) / 2);
        int i3 = getBounds().top + ((iHeight - i) / 2);
        int i4 = i2 + i;
        this.i.setBounds(i2, i3, i4, i3 + i);
        this.i.draw(canvas);
        float f = i * this.g;
        float f2 = i4;
        float f3 = i3 + f;
        RectF rectF = new RectF(f2 - f, f3 - f, f2, f3);
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.l);
        float f4 = (this.h / 100.0f) * 360.0f;
        if (f4 > 0.0f) {
            canvas.drawArc(rectF, -90.0f, f4, false, this.m);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.l.setAlpha(i);
        this.m.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.l.setColorFilter(colorFilter);
        this.m.setColorFilter(colorFilter);
    }

    public C5054Hr7(int i, Context context, int i2, int i3, int i4, float f, float f2) {
        AbstractC13042fc3.i(context, "context");
        this.a = i;
        this.b = context;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = f;
        this.g = f2;
        Drawable drawableF = AbstractC4043Dl1.f(context, i);
        if (drawableF == null) {
            throw new IllegalArgumentException("Drawable resource not found".toString());
        }
        this.i = drawableF;
        float f3 = context.getResources().getDisplayMetrics().density;
        this.j = f3;
        float f4 = f * f3;
        this.k = f4;
        Paint paint = new Paint(1);
        paint.setColor(i3);
        paint.setAlpha(i4);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeWidth(f4);
        this.l = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(i2);
        paint2.setStyle(style);
        paint2.setStrokeWidth(f4);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.m = paint2;
    }
}
