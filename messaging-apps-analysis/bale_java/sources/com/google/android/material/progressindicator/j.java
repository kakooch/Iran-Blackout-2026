package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import ir.nasim.AbstractC16198ks;
import ir.nasim.C21447tg2;
import ir.nasim.WU3;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class j extends g {
    private static final Property j = new b(Float.class, "animationFraction");
    private ObjectAnimator d;
    private C21447tg2 e;
    private final com.google.android.material.progressindicator.a f;
    private int g;
    private boolean h;
    private float i;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            j jVar = j.this;
            jVar.g = (jVar.g + 1) % j.this.f.c.length;
            j.this.h = true;
        }
    }

    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(j jVar) {
            return Float.valueOf(jVar.n());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(j jVar, Float f) {
            jVar.r(f.floatValue());
        }
    }

    public j(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.g = 1;
        this.f = linearProgressIndicatorSpec;
        this.e = new C21447tg2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.i;
    }

    private void o() {
        if (this.d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<j, Float>) j, 0.0f, 1.0f);
            this.d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(333L);
            this.d.setInterpolator(null);
            this.d.setRepeatCount(-1);
            this.d.addListener(new a());
        }
    }

    private void p() {
        if (!this.h || this.b[3] >= 1.0f) {
            return;
        }
        int[] iArr = this.c;
        iArr[2] = iArr[1];
        iArr[1] = iArr[0];
        iArr[0] = WU3.a(this.f.c[this.g], this.a.getAlpha());
        this.h = false;
    }

    private void s(int i) {
        this.b[0] = 0.0f;
        float fB = b(i, 0, 667);
        float[] fArr = this.b;
        float interpolation = this.e.getInterpolation(fB);
        fArr[2] = interpolation;
        fArr[1] = interpolation;
        float[] fArr2 = this.b;
        float interpolation2 = this.e.getInterpolation(fB + 0.49925038f);
        fArr2[4] = interpolation2;
        fArr2[3] = interpolation2;
        this.b[5] = 1.0f;
    }

    @Override // com.google.android.material.progressindicator.g
    public void a() {
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.g
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.g
    public void f() {
    }

    @Override // com.google.android.material.progressindicator.g
    public void g() {
        o();
        q();
        this.d.start();
    }

    @Override // com.google.android.material.progressindicator.g
    public void h() {
    }

    void q() {
        this.h = true;
        this.g = 1;
        Arrays.fill(this.c, WU3.a(this.f.c[0], this.a.getAlpha()));
    }

    void r(float f) {
        this.i = f;
        s((int) (f * 333.0f));
        p();
        this.a.invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.g
    public void d(AbstractC16198ks abstractC16198ks) {
    }
}
