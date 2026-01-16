package ir.eitaa.ui.ActionBar;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.ChatListItemAnimator;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.SharedConfig;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AdjustPanLayoutHelper {
    public static final Interpolator keyboardInterpolator = ChatListItemAnimator.DEFAULT_INTERPOLATOR;
    private boolean animationInProgress;
    ValueAnimator animator;
    boolean checkHierarchyHeight;
    private ViewGroup contentView;
    protected float keyboardSize;
    private boolean needDelay;
    int notificationsIndex;
    private final View parent;
    View parentForListener;
    private View resizableView;
    private View resizableViewToSet;
    private Runnable delayedAnimationRunnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper.1
        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator valueAnimator = AdjustPanLayoutHelper.this.animator;
            if (valueAnimator == null || valueAnimator.isRunning()) {
                return;
            }
            AdjustPanLayoutHelper.this.animator.start();
        }
    };
    int previousHeight = -1;
    int previousContentHeight = -1;
    int previousStartOffset = -1;
    ArrayList<View> viewsToHeightSet = new ArrayList<>();
    ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper.2
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (SharedConfig.smoothKeyboard) {
                int height = AdjustPanLayoutHelper.this.parent.getHeight();
                int iStartOffset = height - AdjustPanLayoutHelper.this.startOffset();
                AdjustPanLayoutHelper adjustPanLayoutHelper = AdjustPanLayoutHelper.this;
                int i = adjustPanLayoutHelper.previousHeight;
                if (iStartOffset == i - adjustPanLayoutHelper.previousStartOffset || height == i || adjustPanLayoutHelper.animator != null) {
                    if (adjustPanLayoutHelper.animator == null) {
                        adjustPanLayoutHelper.previousHeight = height;
                        adjustPanLayoutHelper.previousContentHeight = adjustPanLayoutHelper.contentView.getHeight();
                        AdjustPanLayoutHelper adjustPanLayoutHelper2 = AdjustPanLayoutHelper.this;
                        adjustPanLayoutHelper2.previousStartOffset = adjustPanLayoutHelper2.startOffset();
                    }
                    return true;
                }
                if (!adjustPanLayoutHelper.heightAnimationEnabled() || Math.abs(AdjustPanLayoutHelper.this.previousHeight - height) < AndroidUtilities.dp(20.0f)) {
                    AdjustPanLayoutHelper adjustPanLayoutHelper3 = AdjustPanLayoutHelper.this;
                    adjustPanLayoutHelper3.previousHeight = height;
                    adjustPanLayoutHelper3.previousContentHeight = adjustPanLayoutHelper3.contentView.getHeight();
                    AdjustPanLayoutHelper adjustPanLayoutHelper4 = AdjustPanLayoutHelper.this;
                    adjustPanLayoutHelper4.previousStartOffset = adjustPanLayoutHelper4.startOffset();
                    return true;
                }
                AdjustPanLayoutHelper adjustPanLayoutHelper5 = AdjustPanLayoutHelper.this;
                if (adjustPanLayoutHelper5.previousHeight != -1 && adjustPanLayoutHelper5.previousContentHeight == adjustPanLayoutHelper5.contentView.getHeight()) {
                    boolean z = height < AdjustPanLayoutHelper.this.contentView.getBottom();
                    AdjustPanLayoutHelper adjustPanLayoutHelper6 = AdjustPanLayoutHelper.this;
                    adjustPanLayoutHelper6.animateHeight(adjustPanLayoutHelper6.previousHeight, height, z);
                    AdjustPanLayoutHelper adjustPanLayoutHelper7 = AdjustPanLayoutHelper.this;
                    adjustPanLayoutHelper7.previousHeight = height;
                    adjustPanLayoutHelper7.previousContentHeight = adjustPanLayoutHelper7.contentView.getHeight();
                    AdjustPanLayoutHelper adjustPanLayoutHelper8 = AdjustPanLayoutHelper.this;
                    adjustPanLayoutHelper8.previousStartOffset = adjustPanLayoutHelper8.startOffset();
                    return false;
                }
                AdjustPanLayoutHelper adjustPanLayoutHelper9 = AdjustPanLayoutHelper.this;
                adjustPanLayoutHelper9.previousHeight = height;
                adjustPanLayoutHelper9.previousContentHeight = adjustPanLayoutHelper9.contentView.getHeight();
                AdjustPanLayoutHelper adjustPanLayoutHelper10 = AdjustPanLayoutHelper.this;
                adjustPanLayoutHelper10.previousStartOffset = adjustPanLayoutHelper10.startOffset();
                return false;
            }
            AdjustPanLayoutHelper.this.onDetach();
            return true;
        }
    };

    protected boolean heightAnimationEnabled() {
        throw null;
    }

    protected void onPanTranslationUpdate(float y, float progress, boolean keyboardVisible) {
    }

    protected void onTransitionEnd() {
    }

    protected void onTransitionStart(boolean keyboardVisible, int contentHeight) {
    }

    protected int startOffset() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void animateHeight(int r6, int r7, final boolean r8) {
        /*
            r5 = this;
            android.animation.ValueAnimator r0 = r5.animator
            if (r0 == 0) goto L7
            r0.cancel()
        L7:
            int r0 = r5.startOffset()
            android.view.View r1 = r5.parent
            r5.getViewsToSetHeight(r1)
            boolean r1 = r5.checkHierarchyHeight
            r2 = 0
            if (r1 == 0) goto L27
            android.view.View r1 = r5.parent
            android.view.ViewParent r1 = r1.getParent()
            boolean r3 = r1 instanceof android.view.View
            if (r3 == 0) goto L27
            android.view.View r1 = (android.view.View) r1
            int r1 = r1.getHeight()
            int r1 = r1 - r7
            goto L28
        L27:
            r1 = 0
        L28:
            int r1 = r1 + r7
            int r1 = java.lang.Math.max(r6, r1)
            r5.setViewHeight(r1)
            android.view.View r1 = r5.resizableView
            r1.requestLayout()
            r5.onTransitionStart(r8, r7)
            int r1 = r7 - r6
            float r1 = (float) r1
            float r3 = java.lang.Math.abs(r1)
            r5.keyboardSize = r3
            r3 = 2
            r4 = 0
            if (r7 <= r6) goto L5f
            float r6 = (float) r0
            float r1 = r1 - r6
            android.view.View r6 = r5.parent
            float r7 = -r1
            r6.setTranslationY(r7)
            r6 = 1065353216(0x3f800000, float:1.0)
            r5.onPanTranslationUpdate(r1, r6, r8)
            float[] r6 = new float[r3]
            r6 = {x00c6: FILL_ARRAY_DATA , data: [1065353216, 0} // fill-array
            android.animation.ValueAnimator r6 = android.animation.ValueAnimator.ofFloat(r6)
            r5.animator = r6
            r1 = r7
            goto L7d
        L5f:
            android.view.View r6 = r5.parent
            int r7 = r5.previousStartOffset
            float r7 = (float) r7
            r6.setTranslationY(r7)
            int r6 = r5.previousStartOffset
            int r6 = -r6
            float r6 = (float) r6
            r5.onPanTranslationUpdate(r6, r4, r8)
            int r6 = r5.previousStartOffset
            int r6 = -r6
            float r4 = (float) r6
            float[] r6 = new float[r3]
            r6 = {x00ce: FILL_ARRAY_DATA , data: [0, 1065353216} // fill-array
            android.animation.ValueAnimator r6 = android.animation.ValueAnimator.ofFloat(r6)
            r5.animator = r6
        L7d:
            android.animation.ValueAnimator r6 = r5.animator
            ir.eitaa.ui.ActionBar.-$$Lambda$AdjustPanLayoutHelper$czQ7rUjkmwbPGH_jLRgzv83r3Ts r7 = new ir.eitaa.ui.ActionBar.-$$Lambda$AdjustPanLayoutHelper$czQ7rUjkmwbPGH_jLRgzv83r3Ts
            r7.<init>()
            r6.addUpdateListener(r7)
            r6 = 1
            r5.animationInProgress = r6
            int r6 = ir.eitaa.messenger.UserConfig.selectedAccount
            android.animation.ValueAnimator r7 = r5.animator
            ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper$3 r0 = new ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper$3
            r0.<init>()
            r7.addListener(r0)
            android.animation.ValueAnimator r7 = r5.animator
            r0 = 250(0xfa, double:1.235E-321)
            r7.setDuration(r0)
            android.animation.ValueAnimator r7 = r5.animator
            android.view.animation.Interpolator r8 = ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper.keyboardInterpolator
            r7.setInterpolator(r8)
            ir.eitaa.messenger.NotificationCenter r6 = ir.eitaa.messenger.NotificationCenter.getInstance(r6)
            int r7 = r5.notificationsIndex
            r8 = 0
            int r6 = r6.setAnimationInProgress(r7, r8)
            r5.notificationsIndex = r6
            boolean r6 = r5.needDelay
            if (r6 == 0) goto Lbf
            r5.needDelay = r2
            java.lang.Runnable r6 = r5.delayedAnimationRunnable
            r7 = 100
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r6, r7)
            goto Lc4
        Lbf:
            android.animation.ValueAnimator r6 = r5.animator
            r6.start()
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper.animateHeight(int, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$animateHeight$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$animateHeight$0$AdjustPanLayoutHelper(float f, float f2, boolean z, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f3 = (int) ((f * fFloatValue) + (f2 * (1.0f - fFloatValue)));
        this.parent.setTranslationY(f3);
        onPanTranslationUpdate(-f3, fFloatValue, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewHeight(int height) {
        for (int i = 0; i < this.viewsToHeightSet.size(); i++) {
            this.viewsToHeightSet.get(i).getLayoutParams().height = height;
            this.viewsToHeightSet.get(i).requestLayout();
        }
    }

    private void getViewsToSetHeight(View parent) {
        this.viewsToHeightSet.clear();
        while (parent != null) {
            this.viewsToHeightSet.add(parent);
            if (parent == this.resizableView) {
                return;
            } else {
                parent = parent.getParent() instanceof View ? (View) parent.getParent() : null;
            }
        }
    }

    public AdjustPanLayoutHelper(View parent) {
        this.parent = parent;
        onAttach();
    }

    public void onAttach() {
        if (SharedConfig.smoothKeyboard) {
            onDetach();
            Activity activity = getActivity(this.parent.getContext());
            if (activity != null) {
                this.contentView = (ViewGroup) ((ViewGroup) activity.getWindow().getDecorView()).findViewById(R.id.content);
            }
            View viewFindResizableView = findResizableView(this.parent);
            this.resizableView = viewFindResizableView;
            if (viewFindResizableView != null) {
                this.parentForListener = viewFindResizableView;
                viewFindResizableView.getViewTreeObserver().addOnPreDrawListener(this.onPreDrawListener);
            }
        }
    }

    private Activity getActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextThemeWrapper) {
            return getActivity(((ContextThemeWrapper) context).getBaseContext());
        }
        return null;
    }

    private View findResizableView(View parent) {
        View view = this.resizableViewToSet;
        if (view != null) {
            return view;
        }
        while (parent != null) {
            if (!(parent.getParent() instanceof DrawerLayoutContainer)) {
                if (!(parent.getParent() instanceof View)) {
                    break;
                }
                parent = (View) parent.getParent();
            } else {
                return parent;
            }
        }
        return null;
    }

    public void onDetach() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        View view = this.parentForListener;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this.onPreDrawListener);
            this.parentForListener = null;
        }
    }

    public void setResizableView(FrameLayout windowView) {
        this.resizableViewToSet = windowView;
    }

    public boolean animationInProgress() {
        return this.animationInProgress;
    }

    public void setCheckHierarchyHeight(boolean checkHierarchyHeight) {
        this.checkHierarchyHeight = checkHierarchyHeight;
    }

    public void delayAnimation() {
        this.needDelay = true;
    }

    public void runDelayedAnimation() {
        AndroidUtilities.cancelRunOnUIThread(this.delayedAnimationRunnable);
        this.delayedAnimationRunnable.run();
    }
}
