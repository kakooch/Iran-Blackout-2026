package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import ir.nasim.AbstractC16198ks;
import ir.nasim.AbstractC6732Ot;
import ir.nasim.C8885Xt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
abstract class e extends Drawable implements Animatable {
    private static final Property o = new c(Float.class, "growFraction");
    final Context a;
    final com.google.android.material.progressindicator.a b;
    private ValueAnimator d;
    private ValueAnimator e;
    private boolean f;
    private boolean g;
    private float h;
    private List i;
    private AbstractC16198ks j;
    private boolean k;
    private float l;
    private int n;
    final Paint m = new Paint();
    C8885Xt c = new C8885Xt();

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            e.this.e();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            e.super.setVisible(false, false);
            e.this.d();
        }
    }

    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(e eVar) {
            return Float.valueOf(eVar.g());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, Float f) {
            eVar.m(f.floatValue());
        }
    }

    e(Context context, com.google.android.material.progressindicator.a aVar) {
        this.a = context;
        this.b = aVar;
        setAlpha(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        AbstractC16198ks abstractC16198ks = this.j;
        if (abstractC16198ks != null) {
            abstractC16198ks.a(this);
        }
        List list = this.i;
        if (list == null || this.k) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((AbstractC16198ks) it.next()).a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        AbstractC16198ks abstractC16198ks = this.j;
        if (abstractC16198ks != null) {
            abstractC16198ks.b(this);
        }
        List list = this.i;
        if (list == null || this.k) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((AbstractC16198ks) it.next()).b(this);
        }
    }

    private void f(ValueAnimator... valueAnimatorArr) {
        boolean z = this.k;
        this.k = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.k = z;
    }

    private void k() {
        if (this.d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<e, Float>) o, 0.0f, 1.0f);
            this.d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.d.setInterpolator(AbstractC6732Ot.b);
            o(this.d);
        }
        if (this.e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<e, Float>) o, 1.0f, 0.0f);
            this.e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(500L);
            this.e.setInterpolator(AbstractC6732Ot.b);
            n(this.e);
        }
    }

    private void n(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.e;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.e = valueAnimator;
        valueAnimator.addListener(new b());
    }

    private void o(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.d = valueAnimator;
        valueAnimator.addListener(new a());
    }

    float g() {
        if (this.b.b() || this.b.a()) {
            return (this.g || this.f) ? this.h : this.l;
        }
        return 1.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean h() {
        return p(false, false, false);
    }

    public boolean i() {
        ValueAnimator valueAnimator = this.e;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.g;
    }

    public boolean isRunning() {
        return j() || i();
    }

    public boolean j() {
        ValueAnimator valueAnimator = this.d;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f;
    }

    public void l(AbstractC16198ks abstractC16198ks) {
        if (this.i == null) {
            this.i = new ArrayList();
        }
        if (this.i.contains(abstractC16198ks)) {
            return;
        }
        this.i.add(abstractC16198ks);
    }

    void m(float f) {
        if (this.l != f) {
            this.l = f;
            invalidateSelf();
        }
    }

    public boolean p(boolean z, boolean z2, boolean z3) {
        return q(z, z2, z3 && this.c.a(this.a.getContentResolver()) > 0.0f);
    }

    boolean q(boolean z, boolean z2, boolean z3) {
        k();
        if (!isVisible() && !z) {
            return false;
        }
        ValueAnimator valueAnimator = z ? this.d : this.e;
        if (!z3) {
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                f(valueAnimator);
            }
            return super.setVisible(z, false);
        }
        if (z3 && valueAnimator.isRunning()) {
            return false;
        }
        boolean z4 = !z || super.setVisible(z, false);
        if (!(z ? this.b.b() : this.b.a())) {
            f(valueAnimator);
            return z4;
        }
        if (z2 || !valueAnimator.isPaused()) {
            valueAnimator.start();
        } else {
            valueAnimator.resume();
        }
        return z4;
    }

    public boolean r(AbstractC16198ks abstractC16198ks) {
        List list = this.i;
        if (list == null || !list.contains(abstractC16198ks)) {
            return false;
        }
        this.i.remove(abstractC16198ks);
        if (!this.i.isEmpty()) {
            return true;
        }
        this.i = null;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.n = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.m.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return p(z, z2, true);
    }

    public void start() {
        q(true, true, false);
    }

    public void stop() {
        q(false, true, false);
    }
}
