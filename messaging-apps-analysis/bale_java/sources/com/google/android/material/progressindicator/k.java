package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC16198ks;
import ir.nasim.AbstractC6966Pt;
import ir.nasim.AbstractC9564aA5;
import ir.nasim.WU3;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class k extends g {
    private static final int[] l = {533, 567, 850, 750};
    private static final int[] m = {1267, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 333, 0};
    private static final Property n = new c(Float.class, "animationFraction");
    private ObjectAnimator d;
    private ObjectAnimator e;
    private final Interpolator[] f;
    private final com.google.android.material.progressindicator.a g;
    private int h;
    private boolean i;
    private float j;
    AbstractC16198ks k;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            k kVar = k.this;
            kVar.h = (kVar.h + 1) % k.this.g.c.length;
            k.this.i = true;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            k.this.a();
            k kVar = k.this;
            AbstractC16198ks abstractC16198ks = kVar.k;
            if (abstractC16198ks != null) {
                abstractC16198ks.a(kVar.a);
            }
        }
    }

    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(k kVar) {
            return Float.valueOf(kVar.n());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, Float f) {
            kVar.r(f.floatValue());
        }
    }

    public k(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.h = 0;
        this.k = null;
        this.g = linearProgressIndicatorSpec;
        this.f = new Interpolator[]{AbstractC6966Pt.a(context, AbstractC9564aA5.linear_indeterminate_line1_head_interpolator), AbstractC6966Pt.a(context, AbstractC9564aA5.linear_indeterminate_line1_tail_interpolator), AbstractC6966Pt.a(context, AbstractC9564aA5.linear_indeterminate_line2_head_interpolator), AbstractC6966Pt.a(context, AbstractC9564aA5.linear_indeterminate_line2_tail_interpolator)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.j;
    }

    private void o() {
        if (this.d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<k, Float>) n, 0.0f, 1.0f);
            this.d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1800L);
            this.d.setInterpolator(null);
            this.d.setRepeatCount(-1);
            this.d.addListener(new a());
        }
        if (this.e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<k, Float>) n, 1.0f);
            this.e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(1800L);
            this.e.setInterpolator(null);
            this.e.addListener(new b());
        }
    }

    private void p() {
        if (this.i) {
            Arrays.fill(this.c, WU3.a(this.g.c[this.h], this.a.getAlpha()));
            this.i = false;
        }
    }

    private void s(int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            this.b[i2] = Math.max(0.0f, Math.min(1.0f, this.f[i2].getInterpolation(b(i, m[i2], l[i2]))));
        }
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
    public void d(AbstractC16198ks abstractC16198ks) {
        this.k = abstractC16198ks;
    }

    @Override // com.google.android.material.progressindicator.g
    public void f() {
        ObjectAnimator objectAnimator = this.e;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        a();
        if (this.a.isVisible()) {
            this.e.setFloatValues(this.j, 1.0f);
            this.e.setDuration((long) ((1.0f - this.j) * 1800.0f));
            this.e.start();
        }
    }

    @Override // com.google.android.material.progressindicator.g
    public void g() {
        o();
        q();
        this.d.start();
    }

    @Override // com.google.android.material.progressindicator.g
    public void h() {
        this.k = null;
    }

    void q() {
        this.h = 0;
        int iA = WU3.a(this.g.c[0], this.a.getAlpha());
        int[] iArr = this.c;
        iArr[0] = iA;
        iArr[1] = iA;
    }

    void r(float f) {
        this.j = f;
        s((int) (f * 1800.0f));
        p();
        this.a.invalidateSelf();
    }
}
