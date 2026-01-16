package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import ir.nasim.WU3;

/* loaded from: classes3.dex */
final class b extends f {
    private int c;
    private float d;
    private float e;
    private float f;

    public b(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.c = 1;
    }

    private void h(Canvas canvas, Paint paint, float f, float f2, float f3) {
        canvas.save();
        canvas.rotate(f3);
        float f4 = this.f;
        float f5 = f / 2.0f;
        canvas.drawRoundRect(new RectF(f4 - f5, f2, f4 + f5, -f2), f2, f2, paint);
        canvas.restore();
    }

    private int i() {
        a aVar = this.a;
        return ((CircularProgressIndicatorSpec) aVar).g + (((CircularProgressIndicatorSpec) aVar).h * 2);
    }

    @Override // com.google.android.material.progressindicator.f
    public void a(Canvas canvas, float f) {
        a aVar = this.a;
        float f2 = (((CircularProgressIndicatorSpec) aVar).g / 2.0f) + ((CircularProgressIndicatorSpec) aVar).h;
        canvas.translate(f2, f2);
        canvas.rotate(-90.0f);
        float f3 = -f2;
        canvas.clipRect(f3, f3, f2, f2);
        this.c = ((CircularProgressIndicatorSpec) this.a).i == 0 ? 1 : -1;
        this.d = ((CircularProgressIndicatorSpec) r5).a * f;
        this.e = ((CircularProgressIndicatorSpec) r5).b * f;
        this.f = (((CircularProgressIndicatorSpec) r5).g - ((CircularProgressIndicatorSpec) r5).a) / 2.0f;
        if ((this.b.j() && ((CircularProgressIndicatorSpec) this.a).e == 2) || (this.b.i() && ((CircularProgressIndicatorSpec) this.a).f == 1)) {
            this.f += ((1.0f - f) * ((CircularProgressIndicatorSpec) this.a).a) / 2.0f;
        } else if ((this.b.j() && ((CircularProgressIndicatorSpec) this.a).e == 1) || (this.b.i() && ((CircularProgressIndicatorSpec) this.a).f == 2)) {
            this.f -= ((1.0f - f) * ((CircularProgressIndicatorSpec) this.a).a) / 2.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.f
    void b(Canvas canvas, Paint paint, float f, float f2, int i) {
        if (f == f2) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(this.d);
        int i2 = this.c;
        float f3 = f * 360.0f * i2;
        float f4 = (f2 >= f ? f2 - f : (1.0f + f2) - f) * 360.0f * i2;
        float f5 = this.f;
        canvas.drawArc(new RectF(-f5, -f5, f5, f5), f3, f4, false, paint);
        if (this.e <= 0.0f || Math.abs(f4) >= 360.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        h(canvas, paint, this.d, this.e, f3);
        h(canvas, paint, this.d, this.e, f3 + f4);
    }

    @Override // com.google.android.material.progressindicator.f
    void c(Canvas canvas, Paint paint) {
        int iA = WU3.a(((CircularProgressIndicatorSpec) this.a).d, this.b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(iA);
        paint.setStrokeWidth(this.d);
        float f = this.f;
        canvas.drawArc(new RectF(-f, -f, f, f), 0.0f, 360.0f, false, paint);
    }

    @Override // com.google.android.material.progressindicator.f
    public int d() {
        return i();
    }

    @Override // com.google.android.material.progressindicator.f
    public int e() {
        return i();
    }
}
