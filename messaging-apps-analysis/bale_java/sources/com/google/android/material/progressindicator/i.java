package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import ir.nasim.WU3;

/* loaded from: classes3.dex */
final class i extends f {
    private float c;
    private float d;
    private float e;

    public i(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.c = 300.0f;
    }

    @Override // com.google.android.material.progressindicator.f
    public void a(Canvas canvas, float f) {
        Rect clipBounds = canvas.getClipBounds();
        this.c = clipBounds.width();
        float f2 = ((LinearProgressIndicatorSpec) this.a).a;
        canvas.translate(clipBounds.left + (clipBounds.width() / 2.0f), clipBounds.top + (clipBounds.height() / 2.0f) + Math.max(0.0f, (clipBounds.height() - ((LinearProgressIndicatorSpec) this.a).a) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.a).i) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.b.j() && ((LinearProgressIndicatorSpec) this.a).e == 1) || (this.b.i() && ((LinearProgressIndicatorSpec) this.a).f == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.b.j() || this.b.i()) {
            canvas.translate(0.0f, (((LinearProgressIndicatorSpec) this.a).a * (f - 1.0f)) / 2.0f);
        }
        float f3 = this.c;
        canvas.clipRect((-f3) / 2.0f, (-f2) / 2.0f, f3 / 2.0f, f2 / 2.0f);
        a aVar = this.a;
        this.d = ((LinearProgressIndicatorSpec) aVar).a * f;
        this.e = ((LinearProgressIndicatorSpec) aVar).b * f;
    }

    @Override // com.google.android.material.progressindicator.f
    public void b(Canvas canvas, Paint paint, float f, float f2, int i) {
        if (f == f2) {
            return;
        }
        float f3 = this.c;
        float f4 = this.e;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i);
        float f5 = this.d;
        RectF rectF = new RectF(((-f3) / 2.0f) + (f * (f3 - (f4 * 2.0f))), (-f5) / 2.0f, ((-f3) / 2.0f) + (f2 * (f3 - (f4 * 2.0f))) + (f4 * 2.0f), f5 / 2.0f);
        float f6 = this.e;
        canvas.drawRoundRect(rectF, f6, f6, paint);
    }

    @Override // com.google.android.material.progressindicator.f
    void c(Canvas canvas, Paint paint) {
        int iA = WU3.a(((LinearProgressIndicatorSpec) this.a).d, this.b.getAlpha());
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(iA);
        float f = this.c;
        float f2 = this.d;
        RectF rectF = new RectF((-f) / 2.0f, (-f2) / 2.0f, f / 2.0f, f2 / 2.0f);
        float f3 = this.e;
        canvas.drawRoundRect(rectF, f3, f3, paint);
    }

    @Override // com.google.android.material.progressindicator.f
    public int d() {
        return ((LinearProgressIndicatorSpec) this.a).a;
    }

    @Override // com.google.android.material.progressindicator.f
    public int e() {
        return -1;
    }
}
