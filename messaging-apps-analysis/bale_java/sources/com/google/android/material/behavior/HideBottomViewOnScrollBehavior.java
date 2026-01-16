package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import ir.nasim.AbstractC6732Ot;

/* loaded from: classes3.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int a;
    private int b;
    private int c;
    private ViewPropertyAnimator d;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.a = 0;
        this.b = 2;
        this.c = 0;
    }

    private void F(View view, int i, long j, TimeInterpolator timeInterpolator) {
        this.d = view.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new a());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        return i == 2;
    }

    public boolean G() {
        return this.b == 1;
    }

    public boolean H() {
        return this.b == 2;
    }

    public void I(View view, int i) {
        this.c = i;
        if (this.b == 1) {
            view.setTranslationY(this.a + i);
        }
    }

    public void J(View view) {
        K(view, true);
    }

    public void K(View view, boolean z) {
        if (G()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.b = 1;
        int i = this.a + this.c;
        if (z) {
            F(view, i, 175L, AbstractC6732Ot.c);
        } else {
            view.setTranslationY(i);
        }
    }

    public void L(View view) {
        M(view, true);
    }

    public void M(View view, boolean z) {
        if (H()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.b = 2;
        if (z) {
            F(view, 0, 225L, AbstractC6732Ot.d);
        } else {
            view.setTranslationY(0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.a = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        return super.l(coordinatorLayout, view, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i2 > 0) {
            J(view);
        } else if (i2 < 0) {
            L(view);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = 2;
        this.c = 0;
    }
}
