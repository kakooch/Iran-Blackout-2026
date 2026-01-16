package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC16198ks;
import ir.nasim.C21447tg2;
import ir.nasim.C23074wJ;
import ir.nasim.WU3;

/* loaded from: classes3.dex */
final class c extends g {
    private static final int[] l = {0, 1350, 2700, 4050};
    private static final int[] m = {667, 2017, 3367, 4717};
    private static final int[] n = {AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 2350, 3700, 5050};
    private static final Property o = new C0186c(Float.class, "animationFraction");
    private static final Property p = new d(Float.class, "completeEndFraction");
    private ObjectAnimator d;
    private ObjectAnimator e;
    private final C21447tg2 f;
    private final com.google.android.material.progressindicator.a g;
    private int h;
    private float i;
    private float j;
    AbstractC16198ks k;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            c cVar = c.this;
            cVar.h = (cVar.h + 4) % c.this.g.c.length;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c.this.a();
            c cVar = c.this;
            AbstractC16198ks abstractC16198ks = cVar.k;
            if (abstractC16198ks != null) {
                abstractC16198ks.a(cVar.a);
            }
        }
    }

    /* renamed from: com.google.android.material.progressindicator.c$c, reason: collision with other inner class name */
    class C0186c extends Property {
        C0186c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(c cVar) {
            return Float.valueOf(cVar.o());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, Float f) {
            cVar.t(f.floatValue());
        }
    }

    class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(c cVar) {
            return Float.valueOf(cVar.p());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, Float f) {
            cVar.u(f.floatValue());
        }
    }

    public c(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.h = 0;
        this.k = null;
        this.g = circularProgressIndicatorSpec;
        this.f = new C21447tg2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float o() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p() {
        return this.j;
    }

    private void q() {
        if (this.d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<c, Float>) o, 0.0f, 1.0f);
            this.d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(5400L);
            this.d.setInterpolator(null);
            this.d.setRepeatCount(-1);
            this.d.addListener(new a());
        }
        if (this.e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<c, Float>) p, 0.0f, 1.0f);
            this.e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(333L);
            this.e.setInterpolator(this.f);
            this.e.addListener(new b());
        }
    }

    private void r(int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            float fB = b(i, n[i2], 333);
            if (fB >= 0.0f && fB <= 1.0f) {
                int i3 = i2 + this.h;
                int[] iArr = this.g.c;
                int length = i3 % iArr.length;
                int length2 = (length + 1) % iArr.length;
                this.c[0] = C23074wJ.b().evaluate(this.f.getInterpolation(fB), Integer.valueOf(WU3.a(iArr[length], this.a.getAlpha())), Integer.valueOf(WU3.a(this.g.c[length2], this.a.getAlpha()))).intValue();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float f) {
        this.j = f;
    }

    private void v(int i) {
        float[] fArr = this.b;
        float f = this.i;
        fArr[0] = (f * 1520.0f) - 20.0f;
        fArr[1] = f * 1520.0f;
        for (int i2 = 0; i2 < 4; i2++) {
            float fB = b(i, l[i2], 667);
            float[] fArr2 = this.b;
            fArr2[1] = fArr2[1] + (this.f.getInterpolation(fB) * 250.0f);
            float fB2 = b(i, m[i2], 667);
            float[] fArr3 = this.b;
            fArr3[0] = fArr3[0] + (this.f.getInterpolation(fB2) * 250.0f);
        }
        float[] fArr4 = this.b;
        float f2 = fArr4[0];
        float f3 = fArr4[1];
        float f4 = f2 + ((f3 - f2) * this.j);
        fArr4[0] = f4;
        fArr4[0] = f4 / 360.0f;
        fArr4[1] = f3 / 360.0f;
    }

    @Override // com.google.android.material.progressindicator.g
    void a() {
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.g
    public void c() {
        s();
    }

    @Override // com.google.android.material.progressindicator.g
    public void d(AbstractC16198ks abstractC16198ks) {
        this.k = abstractC16198ks;
    }

    @Override // com.google.android.material.progressindicator.g
    void f() {
        ObjectAnimator objectAnimator = this.e;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        if (this.a.isVisible()) {
            this.e.start();
        } else {
            a();
        }
    }

    @Override // com.google.android.material.progressindicator.g
    void g() {
        q();
        s();
        this.d.start();
    }

    @Override // com.google.android.material.progressindicator.g
    public void h() {
        this.k = null;
    }

    void s() {
        this.h = 0;
        this.c[0] = WU3.a(this.g.c[0], this.a.getAlpha());
        this.j = 0.0f;
    }

    void t(float f) {
        this.i = f;
        int i = (int) (f * 5400.0f);
        v(i);
        r(i);
        this.a.invalidateSelf();
    }
}
