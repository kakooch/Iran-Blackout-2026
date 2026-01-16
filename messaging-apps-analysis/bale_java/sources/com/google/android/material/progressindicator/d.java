package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import ir.nasim.AbstractC13799gq2;
import ir.nasim.AbstractC16198ks;
import ir.nasim.C16463lJ6;
import ir.nasim.C17645nJ6;
import ir.nasim.WU3;

/* loaded from: classes3.dex */
public final class d extends e {
    private static final AbstractC13799gq2 u = new a("indicatorLevel");
    private f p;
    private final C17645nJ6 q;
    private final C16463lJ6 r;
    private float s;
    private boolean t;

    class a extends AbstractC13799gq2 {
        a(String str) {
            super(str);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(d dVar) {
            return dVar.x() * 10000.0f;
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(d dVar, float f) {
            dVar.z(f / 10000.0f);
        }
    }

    d(Context context, com.google.android.material.progressindicator.a aVar, f fVar) {
        super(context, aVar);
        this.t = false;
        y(fVar);
        C17645nJ6 c17645nJ6 = new C17645nJ6();
        this.q = c17645nJ6;
        c17645nJ6.d(1.0f);
        c17645nJ6.f(50.0f);
        C16463lJ6 c16463lJ6 = new C16463lJ6(this, u);
        this.r = c16463lJ6;
        c16463lJ6.A(c17645nJ6);
        m(1.0f);
    }

    public static d u(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new d(context, circularProgressIndicatorSpec, new b(circularProgressIndicatorSpec));
    }

    public static d v(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new d(context, linearProgressIndicatorSpec, new i(linearProgressIndicatorSpec));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float x() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(float f) {
        this.s = f;
        invalidateSelf();
    }

    void A(float f) {
        setLevel((int) (f * 10000.0f));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.p.g(canvas, g());
            this.p.c(canvas, this.m);
            this.p.b(canvas, this.m, 0.0f, x(), WU3.a(this.b.c[0], getAlpha()));
            canvas.restore();
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

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.r.B();
        z(getLevel() / 10000.0f);
    }

    @Override // com.google.android.material.progressindicator.e
    public /* bridge */ /* synthetic */ void l(AbstractC16198ks abstractC16198ks) {
        super.l(abstractC16198ks);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (this.t) {
            this.r.B();
            z(i / 10000.0f);
            return true;
        }
        this.r.p(x() * 10000.0f);
        this.r.v(i);
        return true;
    }

    @Override // com.google.android.material.progressindicator.e
    public /* bridge */ /* synthetic */ boolean p(boolean z, boolean z2, boolean z3) {
        return super.p(z, z2, z3);
    }

    @Override // com.google.android.material.progressindicator.e
    boolean q(boolean z, boolean z2, boolean z3) {
        boolean zQ = super.q(z, z2, z3);
        float fA = this.c.a(this.a.getContentResolver());
        if (fA == 0.0f) {
            this.t = true;
        } else {
            this.t = false;
            this.q.f(50.0f / fA);
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

    f w() {
        return this.p;
    }

    void y(f fVar) {
        this.p = fVar;
        fVar.f(this);
    }
}
