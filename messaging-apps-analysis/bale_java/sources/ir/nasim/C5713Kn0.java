package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.OvershootInterpolator;

/* renamed from: ir.nasim.Kn0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C5713Kn0 {
    private View a;
    private final float b;
    private ValueAnimator c;
    private boolean d;
    private float e;

    /* renamed from: ir.nasim.Kn0$a */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C5713Kn0.this.c = null;
            C5713Kn0.this.e = this.a ? 1.0f : 0.0f;
            C5713Kn0.this.f();
        }
    }

    public C5713Kn0(View view) {
        this.a = view;
        this.b = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        View view = this.a;
        if (view != null) {
            view.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(ValueAnimator valueAnimator) {
        this.e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        f();
    }

    public float e(float f) {
        return (1.0f - f) + (f * (1.0f - this.e));
    }

    public boolean g() {
        return this.d;
    }

    public void i(boolean z) {
        if (this.d != z) {
            this.d = z;
            ValueAnimator valueAnimator = this.c;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.e, z ? 1.0f : 0.0f);
            this.c = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Jn0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.a.h(valueAnimator2);
                }
            });
            this.c.addListener(new a(z));
            if (this.d) {
                this.c.setInterpolator(InterpolatorC12631ew1.f);
                this.c.setDuration((long) (this.b * 60.0f));
            } else {
                this.c.setInterpolator(new OvershootInterpolator(5.0f));
                this.c.setDuration((long) (this.b * 350.0f));
            }
            this.c.start();
        }
    }

    public C5713Kn0(View view, float f) {
        this.a = view;
        this.b = f;
    }
}
