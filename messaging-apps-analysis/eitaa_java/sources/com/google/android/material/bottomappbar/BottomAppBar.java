package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private Animator attachAnimator;
    private int fabAlignmentMode;
    AnimatorListenerAdapter fabAnimationListener;
    private boolean fabAttached;
    private final int fabOffsetEndMode;
    private boolean hideOnScroll;
    private final MaterialShapeDrawable materialShapeDrawable;
    private Animator menuAnimator;
    private Animator modeAnimator;

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public void setFabAlignmentMode(int i) {
        maybeAnimateModeChange(i);
        maybeAnimateMenuView(i, this.fabAttached);
        this.fabAlignmentMode = i;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.materialShapeDrawable, colorStateList);
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    public float getFabCradleMargin() {
        throw null;
    }

    public void setFabCradleMargin(float f) {
        if (f != getFabCradleMargin()) {
            throw null;
        }
    }

    public float getFabCradleRoundedCornerRadius() {
        throw null;
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            throw null;
        }
    }

    public float getCradleVerticalOffset() {
        throw null;
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            throw null;
        }
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    public void setHideOnScroll(boolean z) {
        this.hideOnScroll = z;
    }

    void setFabDiameter(int i) {
        throw null;
    }

    private void maybeAnimateModeChange(int i) {
        if (this.fabAlignmentMode == i || !ViewCompat.isLaidOut(this)) {
            return;
        }
        Animator animator = this.modeAnimator;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        createCradleTranslationAnimation(i, arrayList);
        createFabTranslationXAnimation(i, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.modeAnimator = animatorSet;
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                BottomAppBar.this.modeAnimator = null;
            }
        });
        this.modeAnimator.start();
    }

    private void createCradleTranslationAnimation(int i, List<Animator> list) {
        if (this.fabAttached) {
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton findDependentFab() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if (view instanceof FloatingActionButton) {
                return (FloatingActionButton) view;
            }
        }
        return null;
    }

    private boolean isVisibleFab() {
        FloatingActionButton floatingActionButtonFindDependentFab = findDependentFab();
        return floatingActionButtonFindDependentFab != null && floatingActionButtonFindDependentFab.isOrWillBeShown();
    }

    private void createFabTranslationXAnimation(int i, List<Animator> list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(findDependentFab(), "translationX", getFabTranslationX(i));
        objectAnimatorOfFloat.setDuration(300L);
        list.add(objectAnimatorOfFloat);
    }

    private void maybeAnimateMenuView(int i, boolean z) {
        if (ViewCompat.isLaidOut(this)) {
            Animator animator = this.menuAnimator;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!isVisibleFab()) {
                i = 0;
                z = false;
            }
            createMenuViewTranslationAnimation(i, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.menuAnimator = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    BottomAppBar.this.menuAnimator = null;
                }
            });
            this.menuAnimator.start();
        }
    }

    private void createMenuViewTranslationAnimation(final int i, final boolean z, List<Animator> list) {
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator animatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if ((!this.fabAttached && (!z || !isVisibleFab())) || (this.fabAlignmentMode != 1 && i != 1)) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomappbar.BottomAppBar.4
                public boolean cancelled;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.cancelled = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.cancelled) {
                        return;
                    }
                    BottomAppBar.this.translateActionMenuView(actionMenuView, i, z);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    private float getFabTranslationY(boolean z) {
        FloatingActionButton floatingActionButtonFindDependentFab = findDependentFab();
        if (floatingActionButtonFindDependentFab == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        floatingActionButtonFindDependentFab.getContentRect(rect);
        float fHeight = rect.height();
        if (fHeight == 0.0f) {
            fHeight = floatingActionButtonFindDependentFab.getMeasuredHeight();
        }
        float height = floatingActionButtonFindDependentFab.getHeight() - rect.bottom;
        float height2 = floatingActionButtonFindDependentFab.getHeight() - rect.height();
        float f = (-getCradleVerticalOffset()) + (fHeight / 2.0f) + height;
        float paddingBottom = height2 - floatingActionButtonFindDependentFab.getPaddingBottom();
        float f2 = -getMeasuredHeight();
        if (!z) {
            f = paddingBottom;
        }
        return f2 + f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationY() {
        return getFabTranslationY(this.fabAttached);
    }

    private int getFabTranslationX(int i) {
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        if (i == 1) {
            return ((getMeasuredWidth() / 2) - this.fabOffsetEndMode) * (z ? -1 : 1);
        }
        return 0;
    }

    private float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translateActionMenuView(ActionMenuView actionMenuView, int i, boolean z) {
        boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
        int iMax = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & 8388615) == 8388611) {
                iMax = Math.max(iMax, z2 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i == 1 && z) ? iMax - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft()) : 0.0f);
    }

    private void cancelAnimations() {
        Animator animator = this.attachAnimator;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.menuAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.modeAnimator;
        if (animator3 != null) {
            animator3.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAnimationRunning() {
        Animator animator;
        Animator animator2;
        Animator animator3 = this.attachAnimator;
        return (animator3 != null && animator3.isRunning()) || ((animator = this.menuAnimator) != null && animator.isRunning()) || ((animator2 = this.modeAnimator) != null && animator2.isRunning());
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) throws NoSuchFieldException {
        super.onLayout(z, i, i2, i3, i4);
        cancelAnimations();
        setCutoutState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCutoutState() {
        getFabTranslationX();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFabAnimationListeners(FloatingActionButton floatingActionButton) {
        removeFabAnimationListeners(floatingActionButton);
        floatingActionButton.addOnHideAnimationListener(this.fabAnimationListener);
        floatingActionButton.addOnShowAnimationListener(this.fabAnimationListener);
    }

    private void removeFabAnimationListeners(FloatingActionButton floatingActionButton) {
        floatingActionButton.removeOnHideAnimationListener(this.fabAnimationListener);
        floatingActionButton.removeOnShowAnimationListener(this.fabAnimationListener);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        private final Rect fabContentRect;

        public Behavior() {
            this.fabContentRect = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.fabContentRect = new Rect();
        }

        private boolean updateFabPositionAndVisibility(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
            ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).anchorGravity = 17;
            bottomAppBar.addFabAnimationListeners(floatingActionButton);
            return true;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            FloatingActionButton floatingActionButtonFindDependentFab = bottomAppBar.findDependentFab();
            if (floatingActionButtonFindDependentFab != null) {
                updateFabPositionAndVisibility(floatingActionButtonFindDependentFab, bottomAppBar);
                floatingActionButtonFindDependentFab.getMeasuredContentRect(this.fabContentRect);
                bottomAppBar.setFabDiameter(this.fabContentRect.height());
            }
            if (!bottomAppBar.isAnimationRunning()) {
                bottomAppBar.setCutoutState();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i);
            return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) bottomAppBar, i);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) bottomAppBar, view, view2, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public void slideUp(BottomAppBar bottomAppBar) {
            super.slideUp((Behavior) bottomAppBar);
            FloatingActionButton floatingActionButtonFindDependentFab = bottomAppBar.findDependentFab();
            if (floatingActionButtonFindDependentFab != null) {
                floatingActionButtonFindDependentFab.clearAnimation();
                floatingActionButtonFindDependentFab.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setDuration(225L);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public void slideDown(BottomAppBar bottomAppBar) {
            super.slideDown((Behavior) bottomAppBar);
            FloatingActionButton floatingActionButtonFindDependentFab = bottomAppBar.findDependentFab();
            if (floatingActionButtonFindDependentFab != null) {
                floatingActionButtonFindDependentFab.getContentRect(this.fabContentRect);
                float measuredHeight = floatingActionButtonFindDependentFab.getMeasuredHeight() - this.fabContentRect.height();
                floatingActionButtonFindDependentFab.clearAnimation();
                floatingActionButtonFindDependentFab.animate().translationY((-floatingActionButtonFindDependentFab.getPaddingBottom()) + measuredHeight).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setDuration(175L);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.fabAlignmentMode = this.fabAlignmentMode;
        savedState.fabAttached = this.fabAttached;
        return savedState;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.fabAlignmentMode = savedState.fabAlignmentMode;
        this.fabAttached = savedState.fabAttached;
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomappbar.BottomAppBar.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int fabAlignmentMode;
        boolean fabAttached;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.fabAlignmentMode = parcel.readInt();
            this.fabAttached = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.fabAlignmentMode);
            parcel.writeInt(this.fabAttached ? 1 : 0);
        }
    }
}
