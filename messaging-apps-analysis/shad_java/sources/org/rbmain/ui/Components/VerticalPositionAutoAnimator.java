package org.rbmain.ui.Components;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes5.dex */
public final class VerticalPositionAutoAnimator {
    private final AnimatorLayoutChangeListener animatorLayoutChangeListener;

    public static VerticalPositionAutoAnimator attach(View view) {
        return attach(view, 350.0f);
    }

    public static VerticalPositionAutoAnimator attach(View view, float f) {
        AnimatorLayoutChangeListener animatorLayoutChangeListener = new AnimatorLayoutChangeListener(view, f);
        view.addOnLayoutChangeListener(animatorLayoutChangeListener);
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

        public AnimatorLayoutChangeListener(View view, float f) {
            SpringAnimation springAnimation = new SpringAnimation(view, DynamicAnimation.TRANSLATION_Y, 0.0f);
            this.floatingButtonAnimator = springAnimation;
            springAnimation.getSpring().setDampingRatio(1.0f);
            springAnimation.getSpring().setStiffness(f);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            checkOrientation();
            if (i6 == 0 || i6 == i2 || this.ignoreNextLayout) {
                this.ignoreNextLayout = false;
                return;
            }
            this.floatingButtonAnimator.cancel();
            view.setTranslationY(i6 - i2);
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
