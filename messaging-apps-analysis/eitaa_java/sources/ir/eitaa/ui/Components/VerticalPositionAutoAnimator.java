package ir.eitaa.ui.Components;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public final class VerticalPositionAutoAnimator {
    private final AnimatorLayoutChangeListener animatorLayoutChangeListener;

    public static VerticalPositionAutoAnimator attach(View floatingButtonView) {
        return attach(floatingButtonView, 350.0f);
    }

    public static VerticalPositionAutoAnimator attach(View floatingButtonView, float springStiffness) {
        AnimatorLayoutChangeListener animatorLayoutChangeListener = new AnimatorLayoutChangeListener(floatingButtonView, springStiffness);
        floatingButtonView.addOnLayoutChangeListener(animatorLayoutChangeListener);
        return new VerticalPositionAutoAnimator(animatorLayoutChangeListener);
    }

    private VerticalPositionAutoAnimator(AnimatorLayoutChangeListener animatorLayoutChangeListener) {
        this.animatorLayoutChangeListener = animatorLayoutChangeListener;
    }

    public void ignoreNextLayout() {
        this.animatorLayoutChangeListener.ignoreNextLayout = true;
    }

    private static class AnimatorLayoutChangeListener implements View.OnLayoutChangeListener {
        private final SpringAnimation floatingButtonAnimator;
        private boolean ignoreNextLayout;
        private Boolean orientation;

        public AnimatorLayoutChangeListener(View view, float springStiffness) {
            SpringAnimation springAnimation = new SpringAnimation(view, DynamicAnimation.TRANSLATION_Y, 0.0f);
            this.floatingButtonAnimator = springAnimation;
            springAnimation.getSpring().setDampingRatio(1.0f);
            springAnimation.getSpring().setStiffness(springStiffness);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            checkOrientation();
            if (oldTop == 0 || oldTop == top || this.ignoreNextLayout) {
                this.ignoreNextLayout = false;
                return;
            }
            this.floatingButtonAnimator.cancel();
            v.setTranslationY(oldTop - top);
            this.floatingButtonAnimator.start();
        }

        private void checkOrientation() {
            android.graphics.Point point = AndroidUtilities.displaySize;
            boolean z = point.x > point.y;
            Boolean bool = this.orientation;
            if (bool == null || bool.booleanValue() != z) {
                this.orientation = Boolean.valueOf(z);
                this.ignoreNextLayout = true;
            }
        }
    }
}
