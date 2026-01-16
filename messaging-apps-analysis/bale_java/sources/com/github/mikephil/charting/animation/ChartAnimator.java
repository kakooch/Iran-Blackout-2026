package com.github.mikephil.charting.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.github.mikephil.charting.animation.Easing;

/* loaded from: classes2.dex */
public class ChartAnimator {
    private ValueAnimator.AnimatorUpdateListener a;
    protected float mPhaseY = 1.0f;
    protected float mPhaseX = 1.0f;

    public ChartAnimator() {
    }

    private ObjectAnimator a(int i, Easing.EasingFunction easingFunction) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "phaseX", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(easingFunction);
        objectAnimatorOfFloat.setDuration(i);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator b(int i, Easing.EasingFunction easingFunction) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "phaseY", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(easingFunction);
        objectAnimatorOfFloat.setDuration(i);
        return objectAnimatorOfFloat;
    }

    public void animateX(int i) {
        animateX(i, Easing.Linear);
    }

    public void animateXY(int i, int i2) {
        Easing.EasingFunction easingFunction = Easing.Linear;
        animateXY(i, i2, easingFunction, easingFunction);
    }

    public void animateY(int i) {
        animateY(i, Easing.Linear);
    }

    public float getPhaseX() {
        return this.mPhaseX;
    }

    public float getPhaseY() {
        return this.mPhaseY;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006 A[PHI: r0
      0x0006: PHI (r0v2 float) = (r0v0 float), (r0v1 float) binds: [B:3:0x0004, B:6:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setPhaseX(float r3) {
        /*
            r2 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto L8
        L6:
            r3 = r0
            goto Le
        L8:
            r0 = 0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto Le
            goto L6
        Le:
            r2.mPhaseX = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.animation.ChartAnimator.setPhaseX(float):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006 A[PHI: r0
      0x0006: PHI (r0v2 float) = (r0v0 float), (r0v1 float) binds: [B:3:0x0004, B:6:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setPhaseY(float r3) {
        /*
            r2 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto L8
        L6:
            r3 = r0
            goto Le
        L8:
            r0 = 0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto Le
            goto L6
        Le:
            r2.mPhaseY = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.animation.ChartAnimator.setPhaseY(float):void");
    }

    public void animateX(int i, Easing.EasingFunction easingFunction) {
        ObjectAnimator objectAnimatorA = a(i, easingFunction);
        objectAnimatorA.addUpdateListener(this.a);
        objectAnimatorA.start();
    }

    public void animateXY(int i, int i2, Easing.EasingFunction easingFunction) {
        ObjectAnimator objectAnimatorA = a(i, easingFunction);
        ObjectAnimator objectAnimatorB = b(i2, easingFunction);
        if (i > i2) {
            objectAnimatorA.addUpdateListener(this.a);
        } else {
            objectAnimatorB.addUpdateListener(this.a);
        }
        objectAnimatorA.start();
        objectAnimatorB.start();
    }

    public void animateY(int i, Easing.EasingFunction easingFunction) {
        ObjectAnimator objectAnimatorB = b(i, easingFunction);
        objectAnimatorB.addUpdateListener(this.a);
        objectAnimatorB.start();
    }

    public ChartAnimator(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.a = animatorUpdateListener;
    }

    public void animateXY(int i, int i2, Easing.EasingFunction easingFunction, Easing.EasingFunction easingFunction2) {
        ObjectAnimator objectAnimatorA = a(i, easingFunction);
        ObjectAnimator objectAnimatorB = b(i2, easingFunction2);
        if (i > i2) {
            objectAnimatorA.addUpdateListener(this.a);
        } else {
            objectAnimatorB.addUpdateListener(this.a);
        }
        objectAnimatorA.start();
        objectAnimatorB.start();
    }
}
