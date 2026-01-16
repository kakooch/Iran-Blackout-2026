package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import ir.nasim.AbstractC16198ks;

/* loaded from: classes3.dex */
public final class h extends e {
    private f p;
    private g q;

    h(Context context, a aVar, f fVar, g gVar) {
        super(context, aVar);
        x(fVar);
        w(gVar);
    }

    public static h s(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new h(context, circularProgressIndicatorSpec, new b(circularProgressIndicatorSpec), new c(circularProgressIndicatorSpec));
    }

    public static h t(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new h(context, linearProgressIndicatorSpec, new i(linearProgressIndicatorSpec), linearProgressIndicatorSpec.g == 0 ? new j(linearProgressIndicatorSpec) : new k(context, linearProgressIndicatorSpec));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (getBounds().isEmpty() || !isVisible() || !canvas.getClipBounds(rect)) {
            return;
        }
        canvas.save();
        this.p.g(canvas, g());
        this.p.c(canvas, this.m);
        int i = 0;
        while (true) {
            g gVar = this.q;
            int[] iArr = gVar.c;
            if (i >= iArr.length) {
                canvas.restore();
                return;
            }
            f fVar = this.p;
            Paint paint = this.m;
            float[] fArr = gVar.b;
            int i2 = i * 2;
            fVar.b(canvas, paint, fArr[i2], fArr[i2 + 1], iArr[i]);
            i++;
        }
    }

    @Override // com.google.android.material.progressindicator.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.p.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.p.e();
    }

    @Override // com.google.android.material.progressindicator.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.e
    public /* bridge */ /* synthetic */ boolean h() {
        return super.h();
    }

    @Override // com.google.android.material.progressindicator.e
    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    @Override // com.google.android.material.progressindicator.e, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.e
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // com.google.android.material.progressindicator.e
    public /* bridge */ /* synthetic */ void l(AbstractC16198ks abstractC16198ks) {
        super.l(abstractC16198ks);
    }

    @Override // com.google.android.material.progressindicator.e
    public /* bridge */ /* synthetic */ boolean p(boolean z, boolean z2, boolean z3) {
        return super.p(z, z2, z3);
    }

    @Override // com.google.android.material.progressindicator.e
    boolean q(boolean z, boolean z2, boolean z3) {
        boolean zQ = super.q(z, z2, z3);
        if (!isRunning()) {
            this.q.a();
        }
        this.c.a(this.a.getContentResolver());
        if (z && z3) {
            this.q.g();
        }
        return zQ;
    }

    @Override // com.google.android.material.progressindicator.e
    public /* bridge */ /* synthetic */ boolean r(AbstractC16198ks abstractC16198ks) {
        return super.r(abstractC16198ks);
    }

    @Override // com.google.android.material.progressindicator.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // com.google.android.material.progressindicator.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.progressindicator.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    @Override // com.google.android.material.progressindicator.e, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.e, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    g u() {
        return this.q;
    }

    f v() {
        return this.p;
    }

    void w(g gVar) {
        this.q = gVar;
        gVar.e(this);
    }

    void x(f fVar) {
        this.p = fVar;
        fVar.f(this);
    }
}
