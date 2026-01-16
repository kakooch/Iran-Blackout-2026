package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import androidx.transition.Transition;
import ir.nasim.TB5;

/* loaded from: classes2.dex */
abstract class v {

    private static class a extends AnimatorListenerAdapter implements Transition.f {
        private final View a;
        private final View b;
        private final int c;
        private final int d;
        private int[] e;
        private float f;
        private float g;
        private final float h;
        private final float i;

        a(View view, View view2, int i, int i2, float f, float f2) {
            this.b = view;
            this.a = view2;
            this.c = i - Math.round(view.getTranslationX());
            this.d = i2 - Math.round(view.getTranslationY());
            this.h = f;
            this.i = f2;
            int[] iArr = (int[]) view2.getTag(TB5.transition_position);
            this.e = iArr;
            if (iArr != null) {
                view2.setTag(TB5.transition_position, null);
            }
        }

        @Override // androidx.transition.Transition.f
        public void a(Transition transition) {
        }

        @Override // androidx.transition.Transition.f
        public void b(Transition transition) {
        }

        @Override // androidx.transition.Transition.f
        public void c(Transition transition) {
        }

        @Override // androidx.transition.Transition.f
        public void d(Transition transition) {
            this.b.setTranslationX(this.h);
            this.b.setTranslationY(this.i);
            transition.W(this);
        }

        @Override // androidx.transition.Transition.f
        public void e(Transition transition) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.e == null) {
                this.e = new int[2];
            }
            this.e[0] = Math.round(this.c + this.b.getTranslationX());
            this.e[1] = Math.round(this.d + this.b.getTranslationY());
            this.a.setTag(TB5.transition_position, this.e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f = this.b.getTranslationX();
            this.g = this.b.getTranslationY();
            this.b.setTranslationX(this.h);
            this.b.setTranslationY(this.i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.b.setTranslationX(this.f);
            this.b.setTranslationY(this.g);
        }
    }

    static Animator a(View view, t tVar, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator, Transition transition) {
        float f5;
        float f6;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) tVar.b.getTag(TB5.transition_position)) != null) {
            f5 = (r7[0] - i) + translationX;
            f6 = (r7[1] - i2) + translationY;
        } else {
            f5 = f;
            f6 = f2;
        }
        int iRound = Math.round(f5 - translationX) + i;
        int iRound2 = i2 + Math.round(f6 - translationY);
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        if (f5 == f3 && f6 == f4) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f5, f3), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f6, f4));
        a aVar = new a(view, tVar.b, iRound, iRound2, translationX, translationY);
        transition.b(aVar);
        objectAnimatorOfPropertyValuesHolder.addListener(aVar);
        AbstractC1978a.a(objectAnimatorOfPropertyValuesHolder, aVar);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(timeInterpolator);
        return objectAnimatorOfPropertyValuesHolder;
    }
}
