package ir.nasim;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* renamed from: ir.nasim.lU0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C16556lU0 extends Drawable {
    private static final C21447tg2 h = new C21447tg2();
    private float a;
    private float b;
    private long c = -1;
    private float[] d = new float[2];
    private final Paint e;
    private float f;
    private final RectF g;

    public C16556lU0(float f, float f2, int i) {
        this.a = AbstractC21455b.F(18.0f);
        this.b = AbstractC21455b.F(2.25f);
        Paint paint = new Paint();
        this.e = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.g = new RectF();
        this.a = f;
        this.b = f2;
        b(i);
    }

    public static void a(float f, float[] fArr) {
        float f2 = (1520.0f * f) / 5400.0f;
        fArr[0] = Math.max(0.0f, f2 - 20.0f);
        fArr[1] = f2;
        for (int i = 0; i < 4; i++) {
            float f3 = fArr[1];
            C21447tg2 c21447tg2 = h;
            fArr[1] = f3 + (c21447tg2.getInterpolation((f - (i * 1350)) / 667.0f) * 250.0f);
            fArr[0] = fArr[0] + (c21447tg2.getInterpolation((f - (r5 + 667)) / 667.0f) * 250.0f);
        }
    }

    private void c() {
        a((SystemClock.elapsedRealtime() - this.c) % 5400, this.d);
    }

    public void b(int i) {
        this.e.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.c < 0) {
            this.c = SystemClock.elapsedRealtime();
        }
        c();
        RectF rectF = this.g;
        float f = this.f;
        float[] fArr = this.d;
        float f2 = fArr[0];
        canvas.drawArc(rectF, f + f2, fArr[1] - f2, false, this.e);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.e.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        RectF rectF = this.g;
        float f = i;
        float f2 = i3 - i;
        float f3 = this.b;
        float f4 = this.a;
        float f5 = i2;
        float f6 = i4 - i2;
        rectF.set((((f2 - (f3 / 2.0f)) - f4) / 2.0f) + f, (((f6 - (f3 / 2.0f)) - f4) / 2.0f) + f5, f + (((f2 + (f3 / 2.0f)) + f4) / 2.0f), f5 + (((f6 + (f3 / 2.0f)) + f4) / 2.0f));
        super.setBounds(i, i2, i3, i4);
        this.e.setStrokeWidth(this.b);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
