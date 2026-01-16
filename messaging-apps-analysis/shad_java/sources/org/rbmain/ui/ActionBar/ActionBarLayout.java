package org.rbmain.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Components.BackButtonMenu;
import org.rbmain.ui.Components.Bulletin;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.GroupCallPip;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.Point;

/* loaded from: classes4.dex */
public class ActionBarLayout extends FrameLayout {
    private static Drawable headerShadowDrawable;
    private static Drawable layerShadowDrawable;
    private static Paint scrimPaint;
    private AccelerateDecelerateInterpolator accelerateDecelerateInterpolator;
    private final AccelerateInterpolator alphaInterpolator;
    private ArrayList<int[]> animateEndColors;
    private int animateSetThemeAccentIdAfterAnimation;
    private Theme.ThemeInfo animateSetThemeAfterAnimation;
    private boolean animateSetThemeNightAfterAnimation;
    private ArrayList<int[]> animateStartColors;
    private boolean animateThemeAfterAnimation;
    protected boolean animationInProgress;
    private float animationProgress;
    private Runnable animationRunnable;
    private View backgroundView;
    private boolean beginTrackingSent;
    private LayoutContainer containerView;
    private LayoutContainer containerViewBack;
    private ActionBar currentActionBar;
    private AnimatorSet currentAnimation;
    private DecelerateInterpolator decelerateInterpolator;
    private boolean delayedAnimationResumed;
    private Runnable delayedOpenAnimationRunnable;
    private ActionBarLayoutDelegate delegate;
    private DrawerLayoutContainer drawerLayoutContainer;
    private float expandStartX;
    private float expandStartY;
    public ArrayList<BaseFragment> fragmentsStack;
    private FrameLayoutContainer frameLayoutContainer;
    private boolean inActionMode;
    private boolean inBubbleMode;
    private boolean inPreviewMode;
    private float innerScaleX;
    private float innerScaleY;
    public float innerTranslationX;
    private float innerTranslationY;
    private boolean isCollapseAnimationInProgress;
    private boolean isDraggingVertically;
    private long lastFrameTime;
    private boolean maybeStartTracking;
    private BaseFragment newFragment;
    private BaseFragment oldFragment;
    private Runnable onCloseAnimationEndRunnable;
    private Runnable onOpenAnimationEndRunnable;
    private Runnable overlayAction;
    protected Activity parentActivity;
    private ArrayList<ThemeDescription> presentingFragmentDescriptions;
    private ColorDrawable previewBackgroundDrawable;
    private boolean previewOpenAnimationInProgress;
    private List<BackButtonMenu.PulledDialog> pulledDialogs;
    private boolean rebuildAfterAnimation;
    private boolean rebuildLastAfterAnimation;
    private Rect rect;
    private boolean removeActionBarExtraHeight;
    private boolean showLastAfterAnimation;
    protected boolean startedTracking;
    private int startedTrackingPointerId;
    private int startedTrackingX;
    private int startedTrackingY;
    private float themeAnimationValue;
    private ArrayList<ThemeDescription.ThemeDescriptionDelegate> themeAnimatorDelegate;
    private ArrayList<ArrayList<ThemeDescription>> themeAnimatorDescriptions;
    private AnimatorSet themeAnimatorSet;
    private String titleOverlayText;
    private int titleOverlayTextId;
    private boolean transitionAnimationInProgress;
    private boolean transitionAnimationPreviewMode;
    private long transitionAnimationStartTime;
    private boolean useAlphaAnimations;
    private VelocityTracker velocityTracker;
    private Runnable waitingForKeyboardCloseRunnable;

    /* loaded from: classes.dex */
    public interface ActionBarLayoutDelegate {
        boolean needAddFragmentToStack(BaseFragment baseFragment, ActionBarLayout actionBarLayout);

        boolean needCloseLastFragment(ActionBarLayout actionBarLayout);

        boolean needPresentFragment(BaseFragment baseFragment, boolean z, boolean z2, ActionBarLayout actionBarLayout);

        boolean onPreIme();

        void onRebuildAllFragments(ActionBarLayout actionBarLayout, boolean z);
    }

    public enum BackButtonState {
        BACK,
        MENU
    }

    interface IBackButtonDrawable {
        BackButtonState getBackButtonState();
    }

    private float dragDownInterpolator(int i) {
        return i / 2.0f;
    }

    public ViewGroup getView() {
        return this;
    }

    public boolean hasIntegratedBlurInPreview() {
        return false;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    static /* synthetic */ float access$1816(ActionBarLayout actionBarLayout, float f) {
        float f2 = actionBarLayout.animationProgress + f;
        actionBarLayout.animationProgress = f2;
        return f2;
    }

    public void onUserLeaveHint() {
        if (this.fragmentsStack.isEmpty()) {
            return;
        }
        this.fragmentsStack.get(r0.size() - 1).onUserLeaveHint();
    }

    public class LayoutContainer extends FrameLayout {
        private int backgroundColor;
        private Paint backgroundPaint;
        private int fragmentPanTranslationOffset;
        private boolean isKeyboardVisible;
        private Rect rect;

        public LayoutContainer(Context context) {
            super(context);
            this.rect = new Rect();
            this.backgroundPaint = new Paint();
            setWillNotDraw(false);
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            int measuredHeight;
            int y;
            int paddingLeft;
            int i;
            if (view instanceof ActionBar) {
                return super.drawChild(canvas, view, j);
            }
            int childCount = getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i2);
                if (childAt == view || !(childAt instanceof ActionBar) || childAt.getVisibility() != 0) {
                    i2++;
                } else if (((ActionBar) childAt).getCastShadows()) {
                    measuredHeight = childAt.getMeasuredHeight();
                    y = (int) childAt.getY();
                }
            }
            measuredHeight = 0;
            y = 0;
            if (measuredHeight != 0 && ActionBarLayout.headerShadowDrawable != null) {
                int i3 = y + measuredHeight;
                ActionBarLayout.headerShadowDrawable.setBounds(0, i3, getMeasuredWidth(), ActionBarLayout.headerShadowDrawable.getIntrinsicHeight() + i3);
                ActionBarLayout.headerShadowDrawable.draw(canvas);
            }
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            float f = ActionBarLayout.this.innerTranslationX;
            if (f > 0.0f) {
                paddingLeft = ((int) f) + getPaddingRight();
            } else {
                paddingLeft = f < 0.0f ? (int) (f - getPaddingLeft()) : 0;
            }
            int paddingLeft2 = getPaddingLeft();
            int paddingLeft3 = getPaddingLeft() + width;
            int paddingBottom = ((int) ActionBarLayout.this.innerTranslationY) + getPaddingBottom();
            int paddingTop = getPaddingTop();
            int paddingTop2 = getPaddingTop() + height;
            if (view == ActionBarLayout.this.containerViewBack) {
                if (paddingLeft > 0) {
                    paddingLeft3 = paddingLeft;
                } else if (paddingLeft < 0) {
                    paddingLeft2 = width - Math.abs(paddingLeft);
                }
                paddingTop2 = paddingBottom;
            } else if (view == ActionBarLayout.this.containerView) {
                if (paddingLeft > 0) {
                    paddingLeft2 = paddingLeft;
                } else {
                    paddingLeft3 = width - Math.abs(paddingLeft);
                }
                paddingTop = paddingBottom;
            }
            int iSave = canvas.save();
            if (ActionBarLayout.this.transitionAnimationInProgress || ActionBarLayout.this.inPreviewMode) {
                i = height;
            } else if (ActionBarLayout.this.isDraggingVertically) {
                if (view == ActionBarLayout.this.containerView) {
                    canvas.scale(ActionBarLayout.this.innerScaleX, ActionBarLayout.this.innerScaleY, ActionBarLayout.this.containerView.getMeasuredWidth() / 2.0f, ActionBarLayout.this.containerView.getMeasuredHeight() / 2.0f);
                } else if (view == ActionBarLayout.this.containerViewBack) {
                    canvas.clipRect(0, 0, getWidth(), getHeight());
                }
                i = height;
            } else if ((paddingLeft == 0 || paddingBottom == 0) && !ActionBarLayout.this.isCollapseAnimationInProgress) {
                i = height;
                if (paddingLeft != 0) {
                    canvas.clipRect(paddingLeft2, 0, paddingLeft3, getHeight());
                } else if (paddingBottom != 0) {
                    canvas.clipRect(0, paddingTop, getWidth(), paddingTop2);
                }
            } else if (view == ActionBarLayout.this.containerView) {
                i = height;
                canvas.scale(ActionBarLayout.this.innerScaleX, ActionBarLayout.this.innerScaleY, (ActionBarLayout.this.containerView.getMeasuredWidth() / 2.0f) + paddingLeft, (ActionBarLayout.this.containerView.getMeasuredHeight() / 2.0f) + paddingBottom);
            } else {
                i = height;
                if (view == ActionBarLayout.this.containerViewBack) {
                    canvas.clipRect(0, 0, getWidth(), getHeight());
                }
            }
            boolean zDrawChild = super.drawChild(canvas, view, j);
            canvas.restoreToCount(iSave);
            if (ActionBarLayout.this.isDraggingVertically || ActionBarLayout.this.isCollapseAnimationInProgress) {
                if (view == ActionBarLayout.this.containerViewBack) {
                    float fMin = Math.min(0.8f, ActionBarLayout.this.innerScaleY);
                    if (fMin < 0.0f) {
                        fMin = 0.0f;
                    }
                    ActionBarLayout.scrimPaint.setColor(((int) (fMin * 153.0f)) << 24);
                    canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), ActionBarLayout.scrimPaint);
                }
            } else if (paddingLeft != 0) {
                int iAbs = Math.abs(paddingLeft);
                if (view != ActionBarLayout.this.containerView) {
                    if (view == ActionBarLayout.this.containerViewBack) {
                        float fMin2 = Math.min(0.8f, (width - iAbs) / width);
                        ActionBarLayout.scrimPaint.setColor(((int) ((fMin2 < 0.0f ? 0.0f : fMin2) * 153.0f)) << 24);
                        canvas.drawRect(paddingLeft2, 0.0f, paddingLeft3, getHeight(), ActionBarLayout.scrimPaint);
                    }
                } else {
                    int i4 = width - iAbs;
                    float fMax = Math.max(0.0f, Math.min(i4 / AndroidUtilities.dp(20.0f), 1.0f));
                    if (paddingLeft < 0) {
                        ActionBarLayout.layerShadowDrawable.setBounds(i4, view.getTop(), width + iAbs + ActionBarLayout.layerShadowDrawable.getIntrinsicWidth(), view.getBottom());
                    } else {
                        ActionBarLayout.layerShadowDrawable.setBounds(iAbs - ActionBarLayout.layerShadowDrawable.getIntrinsicWidth(), view.getTop(), iAbs, view.getBottom());
                    }
                    ActionBarLayout.layerShadowDrawable.setAlpha((int) (fMax * 255.0f));
                    ActionBarLayout.layerShadowDrawable.draw(canvas);
                }
            } else if (paddingBottom != 0) {
                if (view != ActionBarLayout.this.containerView) {
                    if (view == ActionBarLayout.this.containerViewBack) {
                        float fMin3 = Math.min(0.8f, (i - paddingBottom) / i);
                        ActionBarLayout.scrimPaint.setColor(((int) ((fMin3 < 0.0f ? 0.0f : fMin3) * 153.0f)) << 24);
                        canvas.drawRect(0.0f, paddingTop, getWidth(), paddingTop2, ActionBarLayout.scrimPaint);
                    }
                } else {
                    float fMax2 = Math.max(0.0f, Math.min((i - paddingBottom) / AndroidUtilities.dp(20.0f), 1.0f));
                    ActionBarLayout.layerShadowDrawable.setBounds(view.getLeft(), paddingBottom - ActionBarLayout.layerShadowDrawable.getIntrinsicHeight(), view.getRight(), paddingBottom);
                    ActionBarLayout.layerShadowDrawable.setAlpha((int) (fMax2 * 255.0f));
                    ActionBarLayout.layerShadowDrawable.draw(canvas);
                }
            }
            return zDrawChild;
        }

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return Build.VERSION.SDK_INT >= 28;
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int measuredHeight;
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int childCount = getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    measuredHeight = 0;
                    break;
                }
                View childAt = getChildAt(i3);
                if (childAt instanceof ActionBar) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 0));
                    measuredHeight = childAt.getMeasuredHeight();
                    break;
                }
                i3++;
            }
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (!(childAt2 instanceof ActionBar)) {
                    if (childAt2.getFitsSystemWindows()) {
                        measureChildWithMargins(childAt2, i, 0, i2, 0);
                    } else {
                        measureChildWithMargins(childAt2, i, 0, i2, measuredHeight);
                    }
                }
            }
            setMeasuredDimension(size, size2);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int measuredHeight;
            int childCount = getChildCount();
            int i5 = 0;
            while (true) {
                if (i5 >= childCount) {
                    measuredHeight = 0;
                    break;
                }
                View childAt = getChildAt(i5);
                if (childAt instanceof ActionBar) {
                    measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(0, 0, childAt.getMeasuredWidth(), measuredHeight);
                    break;
                }
                i5++;
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt2 = getChildAt(i6);
                if (!(childAt2 instanceof ActionBar)) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getFitsSystemWindows()) {
                        int i7 = layoutParams.leftMargin;
                        childAt2.layout(i7, layoutParams.topMargin, childAt2.getMeasuredWidth() + i7, layoutParams.topMargin + childAt2.getMeasuredHeight());
                    } else {
                        int i8 = layoutParams.leftMargin;
                        childAt2.layout(i8, layoutParams.topMargin + measuredHeight, childAt2.getMeasuredWidth() + i8, layoutParams.topMargin + measuredHeight + childAt2.getMeasuredHeight());
                    }
                }
            }
            View rootView = getRootView();
            getWindowVisibleDisplayFrame(this.rect);
            int height = (rootView.getHeight() - (this.rect.top != 0 ? AndroidUtilities.statusBarHeight : 0)) - AndroidUtilities.getViewInset(rootView);
            Rect rect = this.rect;
            this.isKeyboardVisible = height - (rect.bottom - rect.top) > 0;
            if (ActionBarLayout.this.waitingForKeyboardCloseRunnable == null || ActionBarLayout.this.containerView.isKeyboardVisible || ActionBarLayout.this.containerViewBack.isKeyboardVisible) {
                return;
            }
            AndroidUtilities.cancelRunOnUIThread(ActionBarLayout.this.waitingForKeyboardCloseRunnable);
            ActionBarLayout.this.waitingForKeyboardCloseRunnable.run();
            ActionBarLayout.this.waitingForKeyboardCloseRunnable = null;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if ((!ActionBarLayout.this.inPreviewMode && !ActionBarLayout.this.transitionAnimationPreviewMode) || (motionEvent.getActionMasked() != 0 && motionEvent.getActionMasked() != 5)) {
                try {
                    if (ActionBarLayout.this.inPreviewMode && this == ActionBarLayout.this.containerView) {
                        return false;
                    }
                    return super.dispatchTouchEvent(motionEvent);
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            }
            return false;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.fragmentPanTranslationOffset != 0) {
                int i = Theme.key_windowBackgroundWhite;
                if (this.backgroundColor != Theme.getColor(i)) {
                    Paint paint = this.backgroundPaint;
                    int color = Theme.getColor(i);
                    this.backgroundColor = color;
                    paint.setColor(color);
                }
                canvas.drawRect(0.0f, (getMeasuredHeight() - this.fragmentPanTranslationOffset) - 3, getMeasuredWidth(), getMeasuredHeight(), this.backgroundPaint);
            }
            super.onDraw(canvas);
        }

        public void setFragmentPanTranslationOffset(int i) {
            this.fragmentPanTranslationOffset = i;
            invalidate();
        }
    }

    public ActionBarLayout(Context context) {
        super(context);
        this.isDraggingVertically = false;
        this.innerScaleX = 1.0f;
        this.innerScaleY = 1.0f;
        this.isCollapseAnimationInProgress = false;
        this.alphaInterpolator = new AccelerateInterpolator(1.5f);
        this.decelerateInterpolator = new DecelerateInterpolator(1.5f);
        this.accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        this.animateStartColors = new ArrayList<>();
        this.animateEndColors = new ArrayList<>();
        this.themeAnimatorDescriptions = new ArrayList<>();
        this.themeAnimatorDelegate = new ArrayList<>();
        this.rect = new Rect();
        this.parentActivity = (Activity) context;
        if (layerShadowDrawable == null) {
            layerShadowDrawable = getResources().getDrawable(R.drawable.layer_shadow);
            headerShadowDrawable = getResources().getDrawable(R.drawable.header_shadow).mutate();
            scrimPaint = new Paint();
        }
    }

    public void init(ArrayList<BaseFragment> arrayList) {
        this.fragmentsStack = arrayList;
        LayoutContainer layoutContainer = new LayoutContainer(this.parentActivity);
        this.containerViewBack = layoutContainer;
        addView(layoutContainer);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.containerViewBack.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 51;
        this.containerViewBack.setLayoutParams(layoutParams);
        LayoutContainer layoutContainer2 = new LayoutContainer(this.parentActivity);
        this.containerView = layoutContainer2;
        addView(layoutContainer2);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.containerView.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.gravity = 51;
        this.containerView.setLayoutParams(layoutParams2);
        Iterator<BaseFragment> it = this.fragmentsStack.iterator();
        while (it.hasNext()) {
            it.next().setParentLayout(this);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.fragmentsStack.isEmpty()) {
            return;
        }
        int size = this.fragmentsStack.size();
        for (int i = 0; i < size; i++) {
            BaseFragment baseFragment = this.fragmentsStack.get(i);
            baseFragment.onConfigurationChanged(configuration);
            Dialog dialog = baseFragment.visibleDialog;
            if (dialog instanceof BottomSheet) {
                ((BottomSheet) dialog).onConfigurationChanged(configuration);
            }
        }
    }

    public void drawHeaderShadow(Canvas canvas, int i) {
        drawHeaderShadow(canvas, 255, i);
    }

    public void setInBubbleMode(boolean z) {
        this.inBubbleMode = z;
    }

    public boolean isInBubbleMode() {
        return this.inBubbleMode;
    }

    public void drawHeaderShadow(Canvas canvas, int i, int i2) {
        Drawable drawable = headerShadowDrawable;
        if (drawable != null) {
            drawable.setAlpha(i);
            headerShadowDrawable.setBounds(0, i2, getMeasuredWidth(), headerShadowDrawable.getIntrinsicHeight() + i2);
            headerShadowDrawable.draw(canvas);
        }
    }

    @Keep
    public void setInnerTranslationX(float f) {
        this.innerTranslationX = f;
        invalidate();
        if (this.fragmentsStack.size() >= 2) {
            ArrayList<BaseFragment> arrayList = this.fragmentsStack;
            arrayList.get(arrayList.size() - 2).onSlideProgress(false, f / this.containerView.getMeasuredWidth());
        }
    }

    @Keep
    public void setInnerTranslationY(float f) {
        this.innerTranslationY = f;
        invalidate();
    }

    @Keep
    public float getInnerTranslationY() {
        return this.innerTranslationY;
    }

    @Keep
    public float getInnerTranslationX() {
        return this.innerTranslationX;
    }

    public void dismissDialogs() {
        if (this.fragmentsStack.isEmpty()) {
            return;
        }
        this.fragmentsStack.get(r0.size() - 1).dismissCurrentDialog();
    }

    public void onResume() {
        if (this.transitionAnimationInProgress) {
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.currentAnimation = null;
            }
            Runnable runnable = this.animationRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.animationRunnable = null;
            }
            Runnable runnable2 = this.waitingForKeyboardCloseRunnable;
            if (runnable2 != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable2);
                this.waitingForKeyboardCloseRunnable = null;
            }
            if (this.onCloseAnimationEndRunnable != null) {
                onCloseAnimationEnd();
            } else if (this.onOpenAnimationEndRunnable != null) {
                onOpenAnimationEnd();
            }
        }
        if (this.fragmentsStack.isEmpty()) {
            return;
        }
        this.fragmentsStack.get(r0.size() - 1).onResume();
    }

    public void onPause() {
        if (this.fragmentsStack.isEmpty()) {
            return;
        }
        this.fragmentsStack.get(r0.size() - 1).onPause();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.animationInProgress || checkTransitionAnimation() || onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        onTouchEvent(null);
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent != null && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            ActionBarLayoutDelegate actionBarLayoutDelegate = this.delegate;
            return (actionBarLayoutDelegate != null && actionBarLayoutDelegate.onPreIme()) || super.dispatchKeyEventPreIme(keyEvent);
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        LayoutContainer layoutContainer;
        DrawerLayoutContainer drawerLayoutContainer = this.drawerLayoutContainer;
        if (drawerLayoutContainer != null && drawerLayoutContainer.isDrawCurrentPreviewFragmentAbove() && (this.inPreviewMode || this.transitionAnimationPreviewMode || this.previewOpenAnimationInProgress)) {
            BaseFragment baseFragment = this.oldFragment;
            if (view == ((baseFragment == null || !baseFragment.inPreviewMode) ? this.containerView : this.containerViewBack)) {
                this.drawerLayoutContainer.invalidate();
                return false;
            }
        }
        FrameLayoutContainer frameLayoutContainer = this.frameLayoutContainer;
        if (frameLayoutContainer != null && frameLayoutContainer.isDrawCurrentPreviewFragmentAbove() && (this.inPreviewMode || this.transitionAnimationPreviewMode || this.previewOpenAnimationInProgress)) {
            BaseFragment baseFragment2 = this.oldFragment;
            if (view == ((baseFragment2 == null || !baseFragment2.inPreviewMode) ? this.containerView : this.containerViewBack)) {
                this.frameLayoutContainer.invalidate();
                return false;
            }
        }
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingRight = ((int) this.innerTranslationX) + getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int paddingLeft2 = getPaddingLeft() + width;
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int paddingBottom = ((int) this.innerTranslationY) + getPaddingBottom();
        int paddingTop = getPaddingTop();
        int paddingTop2 = getPaddingTop() + height;
        if (view == this.containerViewBack) {
            paddingLeft2 = AndroidUtilities.dp(1.0f) + paddingRight;
            paddingTop2 = paddingBottom;
        } else if (view == this.containerView) {
            paddingLeft = paddingRight;
            paddingTop = paddingBottom;
        }
        int iSave = canvas.save();
        if (this.transitionAnimationInProgress || this.inPreviewMode) {
            i = height;
        } else if (this.isDraggingVertically) {
            if (view == this.containerView) {
                canvas.scale(this.innerScaleX, this.innerScaleY, r14.getMeasuredWidth() / 2.0f, this.containerView.getMeasuredHeight() / 2.0f);
            } else if (view == this.containerViewBack) {
                canvas.clipRect(0, 0, getWidth(), getHeight());
            }
            i = height;
        } else if ((paddingRight == 0 || paddingBottom == 0) && !this.isCollapseAnimationInProgress) {
            i = height;
            if (paddingRight != 0) {
                canvas.clipRect(paddingLeft, 0, paddingLeft2, getHeight());
            } else if (paddingBottom != 0) {
                canvas.clipRect(0, paddingTop, getWidth(), paddingTop2);
            }
        } else {
            if (view == this.containerView) {
                i = height;
                canvas.scale(this.innerScaleX, this.innerScaleY, (r13.getMeasuredWidth() / 2.0f) + paddingRight, (this.containerView.getMeasuredHeight() / 2.0f) + paddingBottom);
            } else {
                i = height;
                if (view == this.containerViewBack) {
                    canvas.clipRect(0, 0, getWidth(), getHeight());
                }
            }
        }
        if ((this.inPreviewMode || this.transitionAnimationPreviewMode) && view == (layoutContainer = this.containerView)) {
            drawPreviewDrawables(canvas, layoutContainer);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        if (this.isDraggingVertically || this.isCollapseAnimationInProgress) {
            if (view == this.containerViewBack) {
                float fMin = Math.min(0.8f, this.innerScaleY);
                scrimPaint.setColor(((int) ((fMin >= 0.0f ? fMin : 0.0f) * 153.0f)) << 24);
                canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), scrimPaint);
            }
        } else if (paddingRight != 0) {
            if (view == this.containerView) {
                float fMax = Math.max(0.0f, Math.min((width - paddingRight) / AndroidUtilities.dp(20.0f), 1.0f));
                Drawable drawable = layerShadowDrawable;
                drawable.setBounds(paddingRight - drawable.getIntrinsicWidth(), view.getTop(), paddingRight, view.getBottom());
                layerShadowDrawable.setAlpha((int) (fMax * 255.0f));
                layerShadowDrawable.draw(canvas);
            } else if (view == this.containerViewBack) {
                float fMin2 = Math.min(0.8f, (width - paddingRight) / width);
                scrimPaint.setColor(((int) ((fMin2 >= 0.0f ? fMin2 : 0.0f) * 153.0f)) << 24);
                canvas.drawRect(paddingLeft, 0.0f, paddingLeft2, getHeight(), scrimPaint);
            }
        } else if (paddingBottom != 0) {
            if (view == this.containerView) {
                float fMax2 = Math.max(0.0f, Math.min((i - paddingBottom) / AndroidUtilities.dp(20.0f), 1.0f));
                layerShadowDrawable.setBounds(view.getLeft(), paddingBottom - layerShadowDrawable.getIntrinsicHeight(), view.getRight(), paddingBottom);
                layerShadowDrawable.setAlpha((int) (fMax2 * 255.0f));
                layerShadowDrawable.draw(canvas);
            } else if (view == this.containerViewBack) {
                float fMin3 = Math.min(0.8f, (i - paddingBottom) / i);
                scrimPaint.setColor(((int) ((fMin3 >= 0.0f ? fMin3 : 0.0f) * 153.0f)) << 24);
                canvas.drawRect(0.0f, paddingTop, getWidth(), paddingTop2, scrimPaint);
            }
        }
        return zDrawChild;
    }

    public float getCurrentPreviewFragmentAlpha() {
        if (!this.inPreviewMode && !this.transitionAnimationPreviewMode && !this.previewOpenAnimationInProgress) {
            return 0.0f;
        }
        BaseFragment baseFragment = this.oldFragment;
        return ((baseFragment == null || !baseFragment.inPreviewMode) ? this.containerView : this.containerViewBack).getAlpha();
    }

    public void drawCurrentPreviewFragment(Canvas canvas, Drawable drawable) {
        if (this.inPreviewMode || this.transitionAnimationPreviewMode || this.previewOpenAnimationInProgress) {
            BaseFragment baseFragment = this.oldFragment;
            LayoutContainer layoutContainer = (baseFragment == null || !baseFragment.inPreviewMode) ? this.containerView : this.containerViewBack;
            drawPreviewDrawables(canvas, layoutContainer);
            if (layoutContainer.getAlpha() < 1.0f) {
                canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), (int) (layoutContainer.getAlpha() * 255.0f), 31);
            } else {
                canvas.save();
            }
            canvas.concat(layoutContainer.getMatrix());
            layoutContainer.draw(canvas);
            if (drawable != null) {
                View childAt = layoutContainer.getChildAt(0);
                if (childAt != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    Rect rect = new Rect();
                    childAt.getLocalVisibleRect(rect);
                    rect.offset(marginLayoutParams.leftMargin, marginLayoutParams.topMargin);
                    rect.top += Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight - 1 : 0;
                    drawable.setAlpha((int) (layoutContainer.getAlpha() * 255.0f));
                    drawable.setBounds(rect);
                    drawable.draw(canvas);
                }
            }
            canvas.restore();
        }
    }

    private void drawPreviewDrawables(Canvas canvas, ViewGroup viewGroup) {
        if (viewGroup.getChildAt(0) != null) {
            this.previewBackgroundDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.previewBackgroundDrawable.draw(canvas);
            int measuredWidth = (getMeasuredWidth() - AndroidUtilities.dp(24.0f)) / 2;
            int top = (int) ((r1.getTop() + viewGroup.getTranslationY()) - AndroidUtilities.dp((Build.VERSION.SDK_INT < 21 ? 20 : 0) + 12));
            Theme.moveUpDrawable.setBounds(measuredWidth, top, AndroidUtilities.dp(24.0f) + measuredWidth, AndroidUtilities.dp(24.0f) + top);
            Theme.moveUpDrawable.draw(canvas);
        }
    }

    public void setDelegate(ActionBarLayoutDelegate actionBarLayoutDelegate) {
        this.delegate = actionBarLayoutDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSlideAnimationEnd(boolean z, boolean z2) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        if (!z2) {
            if (this.fragmentsStack.size() < 2) {
                return;
            }
            ArrayList<BaseFragment> arrayList = this.fragmentsStack;
            BaseFragment baseFragment = arrayList.get(arrayList.size() - 1);
            baseFragment.prepareFragmentToSlide(true, false);
            baseFragment.onPause();
            baseFragment.onFragmentDestroy();
            baseFragment.setParentLayout(null);
            ArrayList<BaseFragment> arrayList2 = this.fragmentsStack;
            arrayList2.remove(arrayList2.size() - 1);
            LayoutContainer layoutContainer = this.containerView;
            LayoutContainer layoutContainer2 = this.containerViewBack;
            this.containerView = layoutContainer2;
            this.containerViewBack = layoutContainer;
            bringChildToFront(layoutContainer2);
            ArrayList<BaseFragment> arrayList3 = this.fragmentsStack;
            BaseFragment baseFragment2 = arrayList3.get(arrayList3.size() - 1);
            this.currentActionBar = baseFragment2.actionBar;
            baseFragment2.onResume();
            baseFragment2.onBecomeFullyVisible();
            baseFragment2.prepareFragmentToSlide(false, false);
        } else if (this.fragmentsStack.size() >= 2) {
            ArrayList<BaseFragment> arrayList4 = this.fragmentsStack;
            arrayList4.get(arrayList4.size() - 1).prepareFragmentToSlide(true, false);
            ArrayList<BaseFragment> arrayList5 = this.fragmentsStack;
            BaseFragment baseFragment3 = arrayList5.get(arrayList5.size() - 2);
            baseFragment3.prepareFragmentToSlide(false, false);
            baseFragment3.onPause();
            View view = baseFragment3.fragmentView;
            if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
                baseFragment3.onRemoveFromParent();
                viewGroup2.removeViewInLayout(baseFragment3.fragmentView);
            }
            ActionBar actionBar = baseFragment3.actionBar;
            if (actionBar != null && actionBar.shouldAddToContainer() && (viewGroup = (ViewGroup) baseFragment3.actionBar.getParent()) != null) {
                viewGroup.removeViewInLayout(baseFragment3.actionBar);
            }
        }
        this.containerViewBack.setVisibility(4);
        this.startedTracking = false;
        this.animationInProgress = false;
        if (z) {
            this.containerView.setTranslationX(0.0f);
            this.containerViewBack.setTranslationX(0.0f);
            setInnerTranslationX(0.0f);
            return;
        }
        this.containerView.setTranslationY(0.0f);
        this.containerView.setTranslationX(0.0f);
        this.containerView.setAlpha(1.0f);
        this.containerView.setScaleX(1.0f);
        this.containerView.setScaleY(1.0f);
        this.containerViewBack.setScaleY(1.0f);
        this.containerViewBack.setScaleX(1.0f);
        this.containerViewBack.setAlpha(1.0f);
        this.containerViewBack.setTranslationX(0.0f);
        this.containerViewBack.setTranslationY(0.0f);
        setInnerTranslationY(0.0f);
        setInnerTranslationX(0.0f);
        setInnerScaleX(1.0f);
        setInnerScaleY(1.0f);
        this.innerScaleX = 1.0f;
        this.innerScaleY = 1.0f;
        invalidate();
    }

    @Keep
    public void setInnerScaleX(float f) {
        this.innerScaleX = f;
        invalidate();
    }

    @Keep
    public void setInnerScaleY(float f) {
        this.innerScaleY = f;
        invalidate();
    }

    private void prepareForMoving(MotionEvent motionEvent) {
        prepareForMoving(motionEvent, true);
    }

    private void prepareForMoving(MotionEvent motionEvent, boolean z) {
        this.maybeStartTracking = false;
        this.startedTracking = true;
        this.containerViewBack.setVisibility(0);
        this.beginTrackingSent = false;
        if (z) {
            this.startedTrackingX = (int) motionEvent.getX();
        } else {
            this.startedTrackingY = (int) motionEvent.getY();
        }
        BaseFragment baseFragment = this.fragmentsStack.get(r7.size() - 2);
        View viewCreateView = baseFragment.fragmentView;
        if (viewCreateView == null) {
            viewCreateView = baseFragment.createView(this.parentActivity);
        }
        ViewGroup viewGroup = (ViewGroup) viewCreateView.getParent();
        if (viewGroup != null) {
            baseFragment.onRemoveFromParent();
            viewGroup.removeView(viewCreateView);
        }
        this.containerViewBack.addView(viewCreateView);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewCreateView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        viewCreateView.setLayoutParams(layoutParams);
        ActionBar actionBar = baseFragment.actionBar;
        if (actionBar != null && actionBar.shouldAddToContainer()) {
            ViewGroup viewGroup2 = (ViewGroup) baseFragment.actionBar.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(baseFragment.actionBar);
            }
            if (this.removeActionBarExtraHeight) {
                baseFragment.actionBar.setOccupyStatusBar(false);
            }
            this.containerViewBack.addView(baseFragment.actionBar);
            baseFragment.actionBar.setTitleOverlayText(this.titleOverlayText, this.titleOverlayTextId, this.overlayAction);
        }
        if (!baseFragment.hasOwnBackground && viewCreateView.getBackground() == null) {
            viewCreateView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        }
        baseFragment.onResume();
        if (this.themeAnimatorSet != null) {
            this.presentingFragmentDescriptions = baseFragment.getThemeDescriptions();
        }
        ArrayList<BaseFragment> arrayList = this.fragmentsStack;
        arrayList.get(arrayList.size() - 1).prepareFragmentToSlide(true, true);
        baseFragment.prepareFragmentToSlide(false, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01c2  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 758
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ActionBar.ActionBarLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void onActionMoveSwipeDown(MotionEvent motionEvent, BaseFragment baseFragment) {
        if (this.fragmentsStack.size() <= 1) {
            return;
        }
        int iAbs = Math.abs(((int) motionEvent.getY()) - this.startedTrackingY);
        int iMax = Math.max(0, (int) (motionEvent.getX() - this.startedTrackingX));
        if (this.maybeStartTracking && !this.startedTracking && iAbs >= AndroidUtilities.getPixelsInCM(0.4f, false) && Math.abs(iAbs) / 3 > iMax) {
            prepareForMoving(motionEvent, false);
            return;
        }
        if (this.startedTracking) {
            if (!this.beginTrackingSent) {
                if (this.parentActivity.getCurrentFocus() != null) {
                    AndroidUtilities.hideKeyboard(this.parentActivity.getCurrentFocus());
                }
                baseFragment.onBeginSlide();
                this.beginTrackingSent = true;
            }
            float fDragDownInterpolator = dragDownInterpolator(iAbs);
            this.containerView.setTranslationY(fDragDownInterpolator);
            if (baseFragment.dismissAnimationType == ActionBarAnimationType.COLLAPSE) {
                this.isDraggingVertically = true;
                float screenHeight = 1.0f - ((fDragDownInterpolator / AndroidUtilities.getScreenHeight()) * 0.2f);
                this.innerScaleX = screenHeight;
                this.innerScaleY = screenHeight;
            }
            setInnerTranslationY(fDragDownInterpolator);
        }
    }

    private void onStartedTrackingSwipeDown(final BaseFragment baseFragment) {
        boolean z;
        if (this.fragmentsStack.size() <= 1) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        float xVelocity = this.velocityTracker.getXVelocity();
        float yVelocity = this.velocityTracker.getYVelocity();
        final boolean z2 = this.containerView.getY() < ((float) AndroidUtilities.dp(56.0f)) && (yVelocity < 3500.0f || yVelocity < xVelocity);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        Point dismissOriginPoint = baseFragment.getDismissOriginPoint();
        float f = dismissOriginPoint.x;
        float measuredHeight = dismissOriginPoint.y - (this.containerView.getMeasuredHeight() / 2.0f);
        float f2 = this.innerTranslationY;
        float f3 = measuredHeight - f2;
        float measuredWidth = (f - (this.containerView.getMeasuredWidth() / 2.0f)) - this.innerTranslationX;
        if (!z2) {
            if (baseFragment.dismissAnimationType == ActionBarAnimationType.COLLAPSE) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.containerView, "translationY", f2, f2 + f3);
                LayoutContainer layoutContainer = this.containerView;
                float f4 = this.innerTranslationX;
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(layoutContainer, "translationX", f4, f4 + measuredWidth);
                float f5 = this.innerTranslationX;
                ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this, "innerTranslationX", f5, measuredWidth + f5);
                float f6 = this.innerTranslationY;
                ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this, "innerTranslationY", f6, f3 + f6);
                ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this, "innerScaleX", this.innerScaleX, 0.05f);
                ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this, "innerScaleY", this.innerScaleY, 0.05f);
                ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.containerView, "alpha", 0.0f);
                objectAnimatorOfFloat.setInterpolator(decelerateInterpolator);
                objectAnimatorOfFloat2.setInterpolator(decelerateInterpolator);
                objectAnimatorOfFloat3.setInterpolator(decelerateInterpolator);
                objectAnimatorOfFloat4.setInterpolator(decelerateInterpolator);
                objectAnimatorOfFloat5.setInterpolator(decelerateInterpolator);
                objectAnimatorOfFloat6.setInterpolator(decelerateInterpolator);
                objectAnimatorOfFloat7.setInterpolator(this.alphaInterpolator);
                animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat, objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat5, objectAnimatorOfFloat6, objectAnimatorOfFloat7);
                animatorSet.setDuration(300L);
                z = true;
            } else {
                z = true;
                animatorSet.playTogether(ObjectAnimator.ofFloat(this.containerView, "translationY", r5.getMeasuredHeight()), ObjectAnimator.ofFloat(this, "innerTranslationY", this.containerView.getMeasuredHeight()));
            }
        } else {
            z = true;
            animatorSet.setDuration(200L);
            if (baseFragment.dismissAnimationType == ActionBarAnimationType.COLLAPSE) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(this.containerView, "translationY", 0.0f), ObjectAnimator.ofFloat(this, "innerScaleX", 1.0f), ObjectAnimator.ofFloat(this, "innerScaleY", 1.0f), ObjectAnimator.ofFloat(this, "innerTranslationY", 0.0f));
            } else {
                animatorSet.playTogether(ObjectAnimator.ofFloat(this.containerView, "translationY", 0.0f), ObjectAnimator.ofFloat(this, "innerTranslationY", 0.0f));
            }
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (baseFragment.dismissAnimationType == ActionBarAnimationType.COLLAPSE) {
                    ActionBarLayout.this.isCollapseAnimationInProgress = true;
                    ActionBarLayout.this.isDraggingVertically = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (baseFragment.dismissAnimationType == ActionBarAnimationType.COLLAPSE) {
                    ActionBarLayout.this.isCollapseAnimationInProgress = false;
                }
                ActionBarLayout.this.onSlideAnimationEnd(false, z2);
            }
        });
        animatorSet.start();
        this.animationInProgress = z;
    }

    public void onBackPressed() {
        if (this.transitionAnimationPreviewMode || this.startedTracking || checkTransitionAnimation() || this.fragmentsStack.isEmpty() || GroupCallPip.onBackPressed()) {
            return;
        }
        ActionBar actionBar = this.currentActionBar;
        if (actionBar != null && !actionBar.isActionModeShowed()) {
            ActionBar actionBar2 = this.currentActionBar;
            if (actionBar2.isSearchFieldVisible) {
                actionBar2.closeSearchField();
                return;
            }
        }
        ArrayList<BaseFragment> arrayList = this.fragmentsStack;
        if (!arrayList.get(arrayList.size() - 1).onBackPressed() || this.fragmentsStack.isEmpty()) {
            return;
        }
        closeLastFragment(true);
    }

    public void onLowMemory() {
        Iterator<BaseFragment> it = this.fragmentsStack.iterator();
        while (it.hasNext()) {
            it.next().onLowMemory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAnimationEndCheck(boolean z) {
        onCloseAnimationEnd();
        onOpenAnimationEnd();
        Runnable runnable = this.waitingForKeyboardCloseRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.waitingForKeyboardCloseRunnable = null;
        }
        AnimatorSet animatorSet = this.currentAnimation;
        if (animatorSet != null) {
            if (z) {
                animatorSet.cancel();
            }
            this.currentAnimation = null;
        }
        Runnable runnable2 = this.animationRunnable;
        if (runnable2 != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable2);
            this.animationRunnable = null;
        }
        setAlpha(1.0f);
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        this.containerView.setAlpha(1.0f);
        this.containerView.setScaleX(1.0f);
        this.containerView.setScaleY(1.0f);
        this.containerView.setTranslationX(0.0f);
        this.containerView.setTranslationY(0.0f);
        this.containerViewBack.setAlpha(1.0f);
        this.containerViewBack.setScaleX(1.0f);
        this.containerViewBack.setScaleY(1.0f);
        this.containerViewBack.setTranslationY(0.0f);
        this.containerViewBack.setTranslationX(0.0f);
    }

    public BaseFragment getLastFragment() {
        if (this.fragmentsStack.isEmpty()) {
            return null;
        }
        return this.fragmentsStack.get(r0.size() - 1);
    }

    public boolean checkTransitionAnimation() {
        if (this.transitionAnimationPreviewMode) {
            return false;
        }
        if (this.transitionAnimationInProgress && this.transitionAnimationStartTime < System.currentTimeMillis() - 1500) {
            onAnimationEndCheck(true);
        }
        return this.transitionAnimationInProgress;
    }

    public boolean isPreviewOpenAnimationInProgress() {
        return this.previewOpenAnimationInProgress;
    }

    public boolean isTransitionAnimationInProgress() {
        return this.transitionAnimationInProgress || this.animationInProgress;
    }

    private void presentFragmentInternalRemoveOld(boolean z, BaseFragment baseFragment) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        if (baseFragment == null) {
            return;
        }
        baseFragment.onBecomeFullyHidden();
        baseFragment.onPause();
        if (z) {
            baseFragment.onFragmentDestroy();
            baseFragment.setParentLayout(null);
            this.fragmentsStack.remove(baseFragment);
        } else {
            View view = baseFragment.fragmentView;
            if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
                baseFragment.onRemoveFromParent();
                try {
                    viewGroup2.removeViewInLayout(baseFragment.fragmentView);
                } catch (Exception e) {
                    FileLog.e(e);
                    try {
                        viewGroup2.removeView(baseFragment.fragmentView);
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                }
            }
            ActionBar actionBar = baseFragment.actionBar;
            if (actionBar != null && actionBar.shouldAddToContainer() && (viewGroup = (ViewGroup) baseFragment.actionBar.getParent()) != null) {
                viewGroup.removeViewInLayout(baseFragment.actionBar);
            }
        }
        this.containerViewBack.setVisibility(4);
    }

    public boolean presentFragmentAsPreview(BaseFragment baseFragment) {
        return presentFragment(baseFragment, false, false, true, true);
    }

    public boolean presentFragment(BaseFragment baseFragment) {
        return presentFragment(baseFragment, false, false, true, false);
    }

    public boolean presentFragment(BaseFragment baseFragment, boolean z) {
        return presentFragment(baseFragment, z, false, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLayoutAnimation(final boolean z, final boolean z2, final boolean z3) {
        if (z2) {
            this.animationProgress = 0.0f;
            this.lastFrameTime = System.nanoTime() / 1000000;
        }
        Runnable runnable = new Runnable() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout.3
            @Override // java.lang.Runnable
            public void run() {
                if (ActionBarLayout.this.animationRunnable != this) {
                    return;
                }
                ActionBarLayout.this.animationRunnable = null;
                if (z2) {
                    ActionBarLayout.this.transitionAnimationStartTime = System.currentTimeMillis();
                }
                long jNanoTime = System.nanoTime() / 1000000;
                long j = jNanoTime - ActionBarLayout.this.lastFrameTime;
                if (j > 18) {
                    j = 18;
                }
                ActionBarLayout.this.lastFrameTime = jNanoTime;
                ActionBarLayout.access$1816(ActionBarLayout.this, j / 150.0f);
                if (ActionBarLayout.this.animationProgress > 1.0f) {
                    ActionBarLayout.this.animationProgress = 1.0f;
                }
                if (ActionBarLayout.this.newFragment != null) {
                    ActionBarLayout.this.newFragment.onTransitionAnimationProgress(true, ActionBarLayout.this.animationProgress);
                }
                if (ActionBarLayout.this.oldFragment != null) {
                    ActionBarLayout.this.oldFragment.onTransitionAnimationProgress(false, ActionBarLayout.this.animationProgress);
                }
                float interpolation = ActionBarLayout.this.decelerateInterpolator.getInterpolation(ActionBarLayout.this.animationProgress);
                if (z) {
                    ActionBarLayout.this.containerView.setAlpha(interpolation);
                    if (z3) {
                        float f = (0.1f * interpolation) + 0.9f;
                        ActionBarLayout.this.containerView.setScaleX(f);
                        ActionBarLayout.this.containerView.setScaleY(f);
                        ActionBarLayout.this.previewBackgroundDrawable.setAlpha((int) (46.0f * interpolation));
                        Theme.moveUpDrawable.setAlpha((int) (interpolation * 255.0f));
                        ActionBarLayout.this.containerView.invalidate();
                        ActionBarLayout.this.invalidate();
                    } else {
                        ActionBarLayout.this.containerView.setTranslationX(AndroidUtilities.dp(48.0f) * (1.0f - interpolation));
                    }
                } else {
                    float f2 = 1.0f - interpolation;
                    ActionBarLayout.this.containerViewBack.setAlpha(f2);
                    if (z3) {
                        float f3 = (0.1f * f2) + 0.9f;
                        ActionBarLayout.this.containerViewBack.setScaleX(f3);
                        ActionBarLayout.this.containerViewBack.setScaleY(f3);
                        ActionBarLayout.this.previewBackgroundDrawable.setAlpha((int) (46.0f * f2));
                        Theme.moveUpDrawable.setAlpha((int) (f2 * 255.0f));
                        ActionBarLayout.this.containerView.invalidate();
                        ActionBarLayout.this.invalidate();
                    } else {
                        ActionBarLayout.this.containerViewBack.setTranslationX(AndroidUtilities.dp(48.0f) * interpolation);
                    }
                }
                if (ActionBarLayout.this.animationProgress < 1.0f) {
                    ActionBarLayout.this.startLayoutAnimation(z, false, z3);
                } else {
                    ActionBarLayout.this.onAnimationEndCheck(false);
                }
            }
        };
        this.animationRunnable = runnable;
        AndroidUtilities.runOnUIThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLayoutAnimationSwipeDown(boolean z, boolean z2, boolean z3, ActionBarAnimationType actionBarAnimationType, float f) {
        startLayoutAnimationSwipeDown(z, z2, z3, actionBarAnimationType, f, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLayoutAnimationSwipeDown(final boolean z, final boolean z2, final boolean z3, final ActionBarAnimationType actionBarAnimationType, final float f, final Point point) {
        if (z2) {
            this.animationProgress = 0.0f;
            this.lastFrameTime = System.nanoTime() / 1000000;
        }
        Runnable runnable = new Runnable() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout.4
            @Override // java.lang.Runnable
            public void run() {
                if (ActionBarLayout.this.animationRunnable != this) {
                    return;
                }
                ActionBarLayout.this.animationRunnable = null;
                if (z2) {
                    ActionBarLayout.this.transitionAnimationStartTime = System.currentTimeMillis();
                }
                long jNanoTime = System.nanoTime() / 1000000;
                long j = jNanoTime - ActionBarLayout.this.lastFrameTime;
                if (j > 18) {
                    j = 18;
                }
                ActionBarLayout.this.lastFrameTime = jNanoTime;
                ActionBarLayout.access$1816(ActionBarLayout.this, j / f);
                if (ActionBarLayout.this.animationProgress > 1.0f) {
                    ActionBarLayout.this.animationProgress = 1.0f;
                }
                float interpolation = ActionBarLayout.this.decelerateInterpolator.getInterpolation(ActionBarLayout.this.animationProgress);
                if (!z) {
                    float f2 = 1.0f - interpolation;
                    ActionBarLayout.this.containerViewBack.setAlpha(f2);
                    if (z3) {
                        float f3 = (0.1f * f2) + 0.9f;
                        ActionBarLayout.this.containerViewBack.setScaleX(f3);
                        ActionBarLayout.this.containerViewBack.setScaleY(f3);
                        ActionBarLayout.this.previewBackgroundDrawable.setAlpha((int) (128.0f * f2));
                        Theme.moveUpDrawable.setAlpha((int) (f2 * 255.0f));
                        ActionBarLayout.this.containerView.invalidate();
                        ActionBarLayout.this.invalidate();
                    } else {
                        ActionBarAnimationType actionBarAnimationType2 = actionBarAnimationType;
                        if (actionBarAnimationType2 != ActionBarAnimationType.ALPHA) {
                            if (actionBarAnimationType2 == ActionBarAnimationType.COLLAPSE) {
                                ActionBarLayout.this.containerViewBack.setScaleY(f2);
                                ActionBarLayout.this.containerViewBack.setScaleX(f2);
                                if (point != null) {
                                    ActionBarLayout.this.containerViewBack.setTranslationX(point.x * interpolation);
                                    ActionBarLayout.this.containerViewBack.setTranslationY(point.y * interpolation);
                                }
                            } else if (actionBarAnimationType2 == ActionBarAnimationType.LTR) {
                                ActionBarLayout.this.containerViewBack.setTranslationX(AndroidUtilities.dp(48.0f) * interpolation);
                            } else if (actionBarAnimationType2 == ActionBarAnimationType.RTL) {
                                ActionBarLayout.this.containerViewBack.setTranslationX(AndroidUtilities.dp(-48.0f) * interpolation);
                            } else if (actionBarAnimationType2 == ActionBarAnimationType.UTZ || actionBarAnimationType2 == ActionBarAnimationType.ZTU) {
                                ActionBarLayout.this.containerViewBack.setTranslationY(AndroidUtilities.displayMetrics.heightPixels * interpolation);
                            } else {
                                ActionBarLayout.this.containerViewBack.setTranslationY(AndroidUtilities.dp(48.0f) * interpolation);
                            }
                        }
                    }
                } else {
                    ActionBarAnimationType actionBarAnimationType3 = actionBarAnimationType;
                    ActionBarAnimationType actionBarAnimationType4 = ActionBarAnimationType.EXPAND;
                    ActionBarLayout.this.containerView.setAlpha(actionBarAnimationType3 != actionBarAnimationType4 ? interpolation : 0.5f + interpolation);
                    if (z3) {
                        float f4 = (0.1f * interpolation) + 0.9f;
                        ActionBarLayout.this.containerView.setScaleX(f4);
                        ActionBarLayout.this.containerView.setScaleY(f4);
                        ActionBarLayout.this.previewBackgroundDrawable.setAlpha((int) (128.0f * interpolation));
                        Theme.moveUpDrawable.setAlpha((int) (interpolation * 255.0f));
                        ActionBarLayout.this.containerView.invalidate();
                        ActionBarLayout.this.invalidate();
                    } else {
                        ActionBarAnimationType actionBarAnimationType5 = actionBarAnimationType;
                        if (actionBarAnimationType5 != ActionBarAnimationType.ALPHA) {
                            if (actionBarAnimationType5 == actionBarAnimationType4) {
                                ActionBarLayout.this.containerView.setScaleY(interpolation);
                                ActionBarLayout.this.containerView.setScaleX(interpolation);
                                float f5 = 1.0f - interpolation;
                                ActionBarLayout.this.containerView.setTranslationX(ActionBarLayout.this.expandStartX * f5);
                                ActionBarLayout.this.containerView.setTranslationY(ActionBarLayout.this.expandStartY * f5);
                            } else if (actionBarAnimationType5 == ActionBarAnimationType.RTL) {
                                ActionBarLayout.this.containerView.setTranslationX(AndroidUtilities.dp(48.0f) * (1.0f - interpolation));
                            } else if (actionBarAnimationType5 == ActionBarAnimationType.LTR) {
                                ActionBarLayout.this.containerView.setTranslationX(AndroidUtilities.dp(-48.0f) * (1.0f - interpolation));
                            } else if (actionBarAnimationType5 == ActionBarAnimationType.UTZ || actionBarAnimationType5 == ActionBarAnimationType.ZTU) {
                                ActionBarLayout.this.containerView.setTranslationY(AndroidUtilities.displayMetrics.heightPixels * (1.0f - interpolation));
                            } else {
                                ActionBarLayout.this.containerView.setTranslationY(AndroidUtilities.dp(48.0f) * (1.0f - interpolation));
                            }
                        }
                    }
                }
                if (ActionBarLayout.this.animationProgress < 1.0f) {
                    ActionBarLayout.this.startLayoutAnimationSwipeDown(z, false, z3, actionBarAnimationType, f, point);
                } else {
                    ActionBarLayout.this.onAnimationEndCheck(false);
                }
            }
        };
        this.animationRunnable = runnable;
        AndroidUtilities.runOnUIThread(runnable);
    }

    public void resumeDelayedFragmentAnimation() {
        this.delayedAnimationResumed = true;
        Runnable runnable = this.delayedOpenAnimationRunnable;
        if (runnable == null || this.waitingForKeyboardCloseRunnable != null) {
            return;
        }
        AndroidUtilities.cancelRunOnUIThread(runnable);
        this.delayedOpenAnimationRunnable.run();
        this.delayedOpenAnimationRunnable = null;
    }

    public boolean isInPreviewMode() {
        return this.inPreviewMode || this.transitionAnimationPreviewMode;
    }

    public boolean presentFragment(final BaseFragment baseFragment, final boolean z, boolean z2, boolean z3, final boolean z4) {
        ActionBarLayoutDelegate actionBarLayoutDelegate;
        final BaseFragment baseFragment2;
        if (baseFragment == null || checkTransitionAnimation() || !(((actionBarLayoutDelegate = this.delegate) == null || !z3 || actionBarLayoutDelegate.needPresentFragment(baseFragment, z, z2, this)) && baseFragment.onFragmentCreate())) {
            return false;
        }
        baseFragment.setInPreviewMode(z4);
        if (this.parentActivity.getCurrentFocus() != null && baseFragment.hideKeyboardOnShow()) {
            AndroidUtilities.hideKeyboard(this.parentActivity.getCurrentFocus());
        }
        boolean z5 = z4 || (!z2 && MessagesController.getGlobalMainSettings().getBoolean("view_animations", true));
        if (this.fragmentsStack.isEmpty()) {
            baseFragment2 = null;
        } else {
            ArrayList<BaseFragment> arrayList = this.fragmentsStack;
            baseFragment2 = arrayList.get(arrayList.size() - 1);
        }
        baseFragment.setParentLayout(this);
        View viewCreateView = baseFragment.fragmentView;
        if (viewCreateView == null) {
            viewCreateView = baseFragment.createView(this.parentActivity);
        } else {
            ViewGroup viewGroup = (ViewGroup) viewCreateView.getParent();
            if (viewGroup != null) {
                baseFragment.onRemoveFromParent();
                viewGroup.removeView(viewCreateView);
            }
        }
        this.containerViewBack.addView(viewCreateView);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewCreateView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        if (z4) {
            int previewHeight = baseFragment.getPreviewHeight();
            int i = Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0;
            if (previewHeight > 0 && previewHeight < getMeasuredHeight() - i) {
                layoutParams.height = previewHeight;
                layoutParams.topMargin = i + (((getMeasuredHeight() - i) - previewHeight) / 2);
            } else {
                int iDp = AndroidUtilities.dp(46.0f);
                layoutParams.bottomMargin = iDp;
                layoutParams.topMargin = iDp;
                layoutParams.topMargin = iDp + AndroidUtilities.statusBarHeight;
            }
            int iDp2 = AndroidUtilities.dp(8.0f);
            layoutParams.leftMargin = iDp2;
            layoutParams.rightMargin = iDp2;
        } else {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
        }
        viewCreateView.setLayoutParams(layoutParams);
        ActionBar actionBar = baseFragment.actionBar;
        if (actionBar != null && actionBar.shouldAddToContainer()) {
            if (this.removeActionBarExtraHeight) {
                baseFragment.actionBar.setOccupyStatusBar(false);
            }
            ViewGroup viewGroup2 = (ViewGroup) baseFragment.actionBar.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(baseFragment.actionBar);
            }
            this.containerViewBack.addView(baseFragment.actionBar);
            baseFragment.actionBar.setTitleOverlayText(this.titleOverlayText, this.titleOverlayTextId, this.overlayAction);
        }
        this.fragmentsStack.add(baseFragment);
        baseFragment.onResume();
        this.currentActionBar = baseFragment.actionBar;
        if (!baseFragment.hasOwnBackground && viewCreateView.getBackground() == null) {
            viewCreateView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        }
        LayoutContainer layoutContainer = this.containerView;
        LayoutContainer layoutContainer2 = this.containerViewBack;
        this.containerView = layoutContainer2;
        this.containerViewBack = layoutContainer;
        layoutContainer2.setVisibility(0);
        setInnerTranslationX(0.0f);
        setInnerTranslationY(0.0f);
        if (z4) {
            if (Build.VERSION.SDK_INT >= 21) {
                viewCreateView.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.ActionBar.ActionBarLayout.5
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, AndroidUtilities.statusBarHeight, view.getMeasuredWidth(), view.getMeasuredHeight(), AndroidUtilities.dp(6.0f));
                    }
                });
                viewCreateView.setClipToOutline(true);
                viewCreateView.setElevation(AndroidUtilities.dp(4.0f));
            }
            if (this.previewBackgroundDrawable == null) {
                this.previewBackgroundDrawable = new ColorDrawable(771751936);
            }
            this.previewBackgroundDrawable.setAlpha(0);
            Theme.moveUpDrawable.setAlpha(0);
        }
        bringChildToFront(this.containerView);
        if (!z5) {
            presentFragmentInternalRemoveOld(z, baseFragment2);
            View view = this.backgroundView;
            if (view != null) {
                view.setVisibility(0);
            }
        }
        if (this.themeAnimatorSet != null) {
            this.presentingFragmentDescriptions = baseFragment.getThemeDescriptions();
        }
        if (z5 || z4) {
            if (this.useAlphaAnimations && this.fragmentsStack.size() == 1) {
                presentFragmentInternalRemoveOld(z, baseFragment2);
                this.transitionAnimationStartTime = System.currentTimeMillis();
                this.transitionAnimationInProgress = true;
                this.onOpenAnimationEndRunnable = new Runnable() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        ActionBarLayout.lambda$presentFragment$0(baseFragment2, baseFragment);
                    }
                };
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(ObjectAnimator.ofFloat(this, (Property<ActionBarLayout, Float>) View.ALPHA, 0.0f, 1.0f));
                View view2 = this.backgroundView;
                if (view2 != null) {
                    view2.setVisibility(0);
                    arrayList2.add(ObjectAnimator.ofFloat(this.backgroundView, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f));
                }
                if (baseFragment2 != null) {
                    baseFragment2.onTransitionAnimationStart(false, false);
                }
                baseFragment.onTransitionAnimationStart(true, false);
                AnimatorSet animatorSet = new AnimatorSet();
                this.currentAnimation = animatorSet;
                animatorSet.playTogether(arrayList2);
                this.currentAnimation.setInterpolator(this.accelerateDecelerateInterpolator);
                this.currentAnimation.setDuration(200L);
                this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ActionBarLayout.this.onAnimationEndCheck(false);
                    }
                });
                this.currentAnimation.start();
            } else {
                this.transitionAnimationPreviewMode = z4;
                this.transitionAnimationStartTime = System.currentTimeMillis();
                this.transitionAnimationInProgress = true;
                final BaseFragment baseFragment3 = baseFragment2;
                this.onOpenAnimationEndRunnable = new Runnable() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$presentFragment$1(z4, z, baseFragment3, baseFragment);
                    }
                };
                final boolean z6 = !baseFragment.needDelayOpenAnimation();
                if (z6) {
                    if (baseFragment2 != null) {
                        baseFragment2.onTransitionAnimationStart(false, false);
                    }
                    baseFragment.onTransitionAnimationStart(true, false);
                }
                this.delayedAnimationResumed = false;
                this.oldFragment = baseFragment2;
                this.newFragment = baseFragment;
                AnimatorSet animatorSetOnCustomTransitionAnimation = z4 ? null : baseFragment.onCustomTransitionAnimation(true, new Runnable() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$presentFragment$2();
                    }
                });
                if (animatorSetOnCustomTransitionAnimation != null) {
                    if (this.containerView.isKeyboardVisible || (this.containerViewBack.isKeyboardVisible && baseFragment2 != null)) {
                        baseFragment2.saveKeyboardPositionBeforeTransition();
                    }
                    this.currentAnimation = animatorSetOnCustomTransitionAnimation;
                } else {
                    this.containerView.setAlpha(0.0f);
                    if (z4) {
                        this.containerView.setTranslationX(0.0f);
                        this.containerView.setScaleX(0.9f);
                        this.containerView.setScaleY(0.9f);
                    } else {
                        this.containerView.setTranslationX(48.0f);
                        this.containerView.setScaleX(1.0f);
                        this.containerView.setScaleY(1.0f);
                    }
                    if (this.containerView.isKeyboardVisible || this.containerViewBack.isKeyboardVisible) {
                        if (baseFragment2 != null) {
                            baseFragment2.saveKeyboardPositionBeforeTransition();
                        }
                        final BaseFragment baseFragment4 = baseFragment2;
                        this.waitingForKeyboardCloseRunnable = new Runnable() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout.7
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ActionBarLayout.this.waitingForKeyboardCloseRunnable != this) {
                                    return;
                                }
                                ActionBarLayout.this.waitingForKeyboardCloseRunnable = null;
                                if (!z6) {
                                    if (ActionBarLayout.this.delayedOpenAnimationRunnable != null) {
                                        AndroidUtilities.cancelRunOnUIThread(ActionBarLayout.this.delayedOpenAnimationRunnable);
                                        if (ActionBarLayout.this.delayedAnimationResumed) {
                                            ActionBarLayout.this.delayedOpenAnimationRunnable.run();
                                            return;
                                        } else {
                                            AndroidUtilities.runOnUIThread(ActionBarLayout.this.delayedOpenAnimationRunnable, 200L);
                                            return;
                                        }
                                    }
                                    return;
                                }
                                BaseFragment baseFragment5 = baseFragment4;
                                if (baseFragment5 != null) {
                                    baseFragment5.onTransitionAnimationStart(false, false);
                                }
                                baseFragment.onTransitionAnimationStart(true, false);
                                if (baseFragment.isSwipeDownEnabled()) {
                                    ActionBarLayout.this.applyPreTransitionAnimationConfiguration(baseFragment);
                                    ActionBarLayout actionBarLayout = ActionBarLayout.this;
                                    boolean z7 = z4;
                                    BaseFragment baseFragment6 = baseFragment;
                                    actionBarLayout.startLayoutAnimationSwipeDown(true, true, z7, baseFragment6.presentAnimationType, baseFragment6.fragmentAnimationDuration);
                                    return;
                                }
                                ActionBarLayout.this.startLayoutAnimation(true, true, z4);
                            }
                        };
                        if (baseFragment.needDelayOpenAnimation()) {
                            this.delayedOpenAnimationRunnable = new Runnable() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (ActionBarLayout.this.delayedOpenAnimationRunnable != this) {
                                        return;
                                    }
                                    ActionBarLayout.this.delayedOpenAnimationRunnable = null;
                                    BaseFragment baseFragment5 = baseFragment2;
                                    if (baseFragment5 != null) {
                                        baseFragment5.onTransitionAnimationStart(false, false);
                                    }
                                    baseFragment.onTransitionAnimationStart(true, false);
                                    if (baseFragment.isSwipeDownEnabled()) {
                                        ActionBarLayout.this.applyPreTransitionAnimationConfiguration(baseFragment);
                                        ActionBarLayout actionBarLayout = ActionBarLayout.this;
                                        boolean z7 = z4;
                                        BaseFragment baseFragment6 = baseFragment;
                                        actionBarLayout.startLayoutAnimationSwipeDown(true, true, z7, baseFragment6.presentAnimationType, baseFragment6.fragmentAnimationDuration);
                                        return;
                                    }
                                    ActionBarLayout.this.startLayoutAnimation(true, true, z4);
                                }
                            };
                        }
                        AndroidUtilities.runOnUIThread(this.waitingForKeyboardCloseRunnable, SharedConfig.smoothKeyboard ? 250L : 200L);
                    } else if (baseFragment.needDelayOpenAnimation()) {
                        Runnable runnable = new Runnable() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ActionBarLayout.this.delayedOpenAnimationRunnable != this) {
                                    return;
                                }
                                ActionBarLayout.this.delayedOpenAnimationRunnable = null;
                                baseFragment.onTransitionAnimationStart(true, false);
                                if (baseFragment.isSwipeDownEnabled()) {
                                    ActionBarLayout.this.applyPreTransitionAnimationConfiguration(baseFragment);
                                    ActionBarLayout actionBarLayout = ActionBarLayout.this;
                                    boolean z7 = z4;
                                    BaseFragment baseFragment5 = baseFragment;
                                    actionBarLayout.startLayoutAnimationSwipeDown(true, true, z7, baseFragment5.presentAnimationType, baseFragment5.fragmentAnimationDuration);
                                    return;
                                }
                                ActionBarLayout.this.startLayoutAnimation(true, true, z4);
                            }
                        };
                        this.delayedOpenAnimationRunnable = runnable;
                        AndroidUtilities.runOnUIThread(runnable, 200L);
                    } else if (baseFragment.isSwipeDownEnabled()) {
                        applyPreTransitionAnimationConfiguration(baseFragment);
                        startLayoutAnimationSwipeDown(true, true, z4, baseFragment.presentAnimationType, baseFragment.fragmentAnimationDuration);
                    } else {
                        startLayoutAnimation(true, true, z4);
                    }
                }
            }
        } else {
            View view3 = this.backgroundView;
            if (view3 != null) {
                view3.setAlpha(1.0f);
                this.backgroundView.setVisibility(0);
            }
            if (baseFragment2 != null) {
                baseFragment2.onTransitionAnimationStart(false, false);
                baseFragment2.onTransitionAnimationEnd(false, false);
            }
            baseFragment.onTransitionAnimationStart(true, false);
            baseFragment.onTransitionAnimationEnd(true, false);
            baseFragment.onBecomeFullyVisible();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$presentFragment$0(BaseFragment baseFragment, BaseFragment baseFragment2) {
        if (baseFragment != null) {
            baseFragment.onTransitionAnimationEnd(false, false);
        }
        baseFragment2.onTransitionAnimationEnd(true, false);
        baseFragment2.onBecomeFullyVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$presentFragment$1(boolean z, boolean z2, BaseFragment baseFragment, BaseFragment baseFragment2) {
        if (z) {
            this.inPreviewMode = true;
            this.transitionAnimationPreviewMode = false;
            this.containerView.setScaleX(1.0f);
            this.containerView.setScaleY(1.0f);
        } else {
            presentFragmentInternalRemoveOld(z2, baseFragment);
            this.containerView.setTranslationX(0.0f);
        }
        if (baseFragment != null) {
            baseFragment.onTransitionAnimationEnd(false, false);
        }
        baseFragment2.onTransitionAnimationEnd(true, false);
        baseFragment2.onBecomeFullyVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$presentFragment$2() {
        onAnimationEndCheck(false);
    }

    public boolean addFragmentToStack(BaseFragment baseFragment) {
        return addFragmentToStack(baseFragment, -1);
    }

    public boolean addFragmentToStack(BaseFragment baseFragment, int i) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ActionBarLayoutDelegate actionBarLayoutDelegate = this.delegate;
        if ((actionBarLayoutDelegate != null && !actionBarLayoutDelegate.needAddFragmentToStack(baseFragment, this)) || !baseFragment.onFragmentCreate()) {
            return false;
        }
        baseFragment.setParentLayout(this);
        if (i == -1) {
            if (!this.fragmentsStack.isEmpty()) {
                ArrayList<BaseFragment> arrayList = this.fragmentsStack;
                BaseFragment baseFragment2 = arrayList.get(arrayList.size() - 1);
                baseFragment2.onPause();
                ActionBar actionBar = baseFragment2.actionBar;
                if (actionBar != null && actionBar.shouldAddToContainer() && (viewGroup2 = (ViewGroup) baseFragment2.actionBar.getParent()) != null) {
                    viewGroup2.removeView(baseFragment2.actionBar);
                }
                View view = baseFragment2.fragmentView;
                if (view != null && (viewGroup = (ViewGroup) view.getParent()) != null) {
                    baseFragment2.onRemoveFromParent();
                    viewGroup.removeView(baseFragment2.fragmentView);
                }
            }
            this.fragmentsStack.add(baseFragment);
        } else {
            this.fragmentsStack.add(i, baseFragment);
        }
        return true;
    }

    private void closeLastFragmentInternalRemoveOld(BaseFragment baseFragment) {
        baseFragment.onPause();
        baseFragment.onFragmentDestroy();
        baseFragment.setParentLayout(null);
        this.fragmentsStack.remove(baseFragment);
        this.containerViewBack.setVisibility(4);
        this.containerViewBack.setTranslationY(0.0f);
        bringChildToFront(this.containerView);
    }

    public void movePreviewFragment(float f) {
        if (!this.inPreviewMode || this.transitionAnimationPreviewMode) {
            return;
        }
        float translationY = this.containerView.getTranslationY();
        float f2 = -f;
        if (f2 > 0.0f) {
            f2 = 0.0f;
        } else if (f2 < (-AndroidUtilities.dp(60.0f))) {
            this.previewOpenAnimationInProgress = true;
            this.inPreviewMode = false;
            ArrayList<BaseFragment> arrayList = this.fragmentsStack;
            BaseFragment baseFragment = arrayList.get(arrayList.size() - 2);
            ArrayList<BaseFragment> arrayList2 = this.fragmentsStack;
            final BaseFragment baseFragment2 = arrayList2.get(arrayList2.size() - 1);
            if (Build.VERSION.SDK_INT >= 21) {
                baseFragment2.fragmentView.setOutlineProvider(null);
                baseFragment2.fragmentView.setClipToOutline(false);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) baseFragment2.fragmentView.getLayoutParams();
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.height = -1;
            baseFragment2.fragmentView.setLayoutParams(layoutParams);
            presentFragmentInternalRemoveOld(false, baseFragment);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(baseFragment2.fragmentView, (Property<View, Float>) View.SCALE_X, 1.0f, 1.05f, 1.0f), ObjectAnimator.ofFloat(baseFragment2.fragmentView, (Property<View, Float>) View.SCALE_Y, 1.0f, 1.05f, 1.0f));
            animatorSet.setDuration(200L);
            animatorSet.setInterpolator(new CubicBezierInterpolator(0.42d, 0.0d, 0.58d, 1.0d));
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ActionBarLayout.this.previewOpenAnimationInProgress = false;
                    baseFragment2.onPreviewOpenAnimationEnd();
                }
            });
            animatorSet.start();
            performHapticFeedback(3);
            baseFragment2.setInPreviewMode(false);
            f2 = 0.0f;
        }
        if (translationY != f2) {
            this.containerView.setTranslationY(f2);
            invalidate();
        }
    }

    public void finishPreviewFragment() {
        if (this.inPreviewMode || this.transitionAnimationPreviewMode) {
            Runnable runnable = this.delayedOpenAnimationRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.delayedOpenAnimationRunnable = null;
            }
            closeLastFragment(true);
        }
    }

    public void closeLastFragment(boolean z) {
        final BaseFragment baseFragment;
        ActionBarLayoutDelegate actionBarLayoutDelegate = this.delegate;
        if ((actionBarLayoutDelegate != null && !actionBarLayoutDelegate.needCloseLastFragment(this)) || checkTransitionAnimation() || this.fragmentsStack.isEmpty()) {
            return;
        }
        if (this.parentActivity.getCurrentFocus() != null) {
            AndroidUtilities.hideKeyboard(this.parentActivity.getCurrentFocus());
        }
        setInnerTranslationX(0.0f);
        setInnerTranslationY(0.0f);
        boolean z2 = this.inPreviewMode || this.transitionAnimationPreviewMode || (z && MessagesController.getGlobalMainSettings().getBoolean("view_animations", true));
        ArrayList<BaseFragment> arrayList = this.fragmentsStack;
        final BaseFragment baseFragment2 = arrayList.get(arrayList.size() - 1);
        AnimatorSet animatorSetOnCustomTransitionAnimation = null;
        if (this.fragmentsStack.size() > 1) {
            ArrayList<BaseFragment> arrayList2 = this.fragmentsStack;
            baseFragment = arrayList2.get(arrayList2.size() - 2);
        } else {
            baseFragment = null;
        }
        if (baseFragment != null) {
            LayoutContainer layoutContainer = this.containerView;
            this.containerView = this.containerViewBack;
            this.containerViewBack = layoutContainer;
            baseFragment.setParentLayout(this);
            View viewCreateView = baseFragment.fragmentView;
            if (viewCreateView == null) {
                viewCreateView = baseFragment.createView(this.parentActivity);
            }
            if (!this.inPreviewMode) {
                this.containerView.setVisibility(0);
                ViewGroup viewGroup = (ViewGroup) viewCreateView.getParent();
                if (viewGroup != null) {
                    baseFragment.onRemoveFromParent();
                    try {
                        viewGroup.removeView(viewCreateView);
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                }
                this.containerView.addView(viewCreateView);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewCreateView.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                viewCreateView.setLayoutParams(layoutParams);
                ActionBar actionBar = baseFragment.actionBar;
                if (actionBar != null && actionBar.shouldAddToContainer()) {
                    if (this.removeActionBarExtraHeight) {
                        baseFragment.actionBar.setOccupyStatusBar(false);
                    }
                    ViewGroup viewGroup2 = (ViewGroup) baseFragment.actionBar.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(baseFragment.actionBar);
                    }
                    this.containerView.addView(baseFragment.actionBar);
                    baseFragment.actionBar.setTitleOverlayText(this.titleOverlayText, this.titleOverlayTextId, this.overlayAction);
                }
            }
            this.newFragment = baseFragment;
            this.oldFragment = baseFragment2;
            baseFragment.onTransitionAnimationStart(true, true);
            baseFragment2.onTransitionAnimationStart(false, true);
            baseFragment.onResume();
            if (this.themeAnimatorSet != null) {
                this.presentingFragmentDescriptions = baseFragment.getThemeDescriptions();
            }
            this.currentActionBar = baseFragment.actionBar;
            if (!baseFragment.hasOwnBackground && viewCreateView.getBackground() == null) {
                viewCreateView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            }
            if (!z2) {
                closeLastFragmentInternalRemoveOld(baseFragment2);
            }
            if (z2) {
                this.transitionAnimationStartTime = System.currentTimeMillis();
                this.transitionAnimationInProgress = true;
                this.onCloseAnimationEndRunnable = new Runnable() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$closeLastFragment$3(baseFragment2, baseFragment);
                    }
                };
                if (!this.inPreviewMode && !this.transitionAnimationPreviewMode) {
                    animatorSetOnCustomTransitionAnimation = baseFragment2.onCustomTransitionAnimation(false, new Runnable() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$closeLastFragment$4();
                        }
                    });
                }
                if (animatorSetOnCustomTransitionAnimation == null) {
                    if (this.containerView.isKeyboardVisible || this.containerViewBack.isKeyboardVisible) {
                        Runnable runnable = new Runnable() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout.11
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ActionBarLayout.this.waitingForKeyboardCloseRunnable != this) {
                                    return;
                                }
                                ActionBarLayout.this.waitingForKeyboardCloseRunnable = null;
                                if (!baseFragment2.isSwipeDownEnabled()) {
                                    ActionBarLayout.this.startLayoutAnimation(false, true, false);
                                    return;
                                }
                                ActionBarLayout actionBarLayout = ActionBarLayout.this;
                                BaseFragment baseFragment3 = baseFragment2;
                                actionBarLayout.startLayoutAnimationSwipeDown(false, true, false, baseFragment3.dismissAnimationType, baseFragment3.fragmentAnimationDuration, actionBarLayout.calculateOriginPoint(baseFragment3, false));
                            }
                        };
                        this.waitingForKeyboardCloseRunnable = runnable;
                        AndroidUtilities.runOnUIThread(runnable, 200L);
                    } else if (baseFragment2.isSwipeDownEnabled()) {
                        startLayoutAnimationSwipeDown(false, true, this.inPreviewMode || this.transitionAnimationPreviewMode, baseFragment2.dismissAnimationType, baseFragment2.fragmentAnimationDuration, calculateOriginPoint(baseFragment2, false));
                    } else {
                        startLayoutAnimation(false, true, this.inPreviewMode || this.transitionAnimationPreviewMode);
                    }
                } else {
                    this.currentAnimation = animatorSetOnCustomTransitionAnimation;
                    if (Bulletin.getVisibleBulletin() != null && Bulletin.getVisibleBulletin().isShowing()) {
                        Bulletin.getVisibleBulletin().hide();
                    }
                }
            } else {
                baseFragment2.onTransitionAnimationEnd(false, true);
                baseFragment.onTransitionAnimationEnd(true, true);
                baseFragment.onBecomeFullyVisible();
            }
        } else if (this.useAlphaAnimations) {
            this.transitionAnimationStartTime = System.currentTimeMillis();
            this.transitionAnimationInProgress = true;
            this.onCloseAnimationEndRunnable = new Runnable() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$closeLastFragment$5(baseFragment2);
                }
            };
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(ObjectAnimator.ofFloat(this, (Property<ActionBarLayout, Float>) View.ALPHA, 1.0f, 0.0f));
            View view = this.backgroundView;
            if (view != null) {
                arrayList3.add(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f));
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.currentAnimation = animatorSet;
            animatorSet.playTogether(arrayList3);
            this.currentAnimation.setInterpolator(this.accelerateDecelerateInterpolator);
            this.currentAnimation.setDuration(200L);
            this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout.12
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ActionBarLayout.this.transitionAnimationStartTime = System.currentTimeMillis();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ActionBarLayout.this.onAnimationEndCheck(false);
                }
            });
            this.currentAnimation.start();
        } else {
            removeFragmentFromStackInternal(baseFragment2);
            setVisibility(8);
            View view2 = this.backgroundView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        baseFragment2.onFragmentClosed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeLastFragment$3(BaseFragment baseFragment, BaseFragment baseFragment2) {
        if (this.inPreviewMode || this.transitionAnimationPreviewMode) {
            this.containerViewBack.setScaleX(1.0f);
            this.containerViewBack.setScaleY(1.0f);
            this.inPreviewMode = false;
            this.transitionAnimationPreviewMode = false;
        } else {
            this.containerViewBack.setTranslationX(0.0f);
        }
        closeLastFragmentInternalRemoveOld(baseFragment);
        baseFragment.onTransitionAnimationEnd(false, true);
        baseFragment2.onTransitionAnimationEnd(true, true);
        baseFragment2.onBecomeFullyVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeLastFragment$4() {
        onAnimationEndCheck(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeLastFragment$5(BaseFragment baseFragment) {
        removeFragmentFromStackInternal(baseFragment);
        setVisibility(8);
        View view = this.backgroundView;
        if (view != null) {
            view.setVisibility(8);
        }
        DrawerLayoutContainer drawerLayoutContainer = this.drawerLayoutContainer;
        if (drawerLayoutContainer != null) {
            drawerLayoutContainer.setAllowOpenDrawer(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyPreTransitionAnimationConfiguration(BaseFragment baseFragment) {
        ActionBarAnimationType actionBarAnimationType = baseFragment.presentAnimationType;
        if (actionBarAnimationType == ActionBarAnimationType.EXPAND) {
            Point pointCalculateOriginPoint = calculateOriginPoint(baseFragment, true);
            float f = pointCalculateOriginPoint.x;
            this.expandStartX = f;
            this.expandStartY = pointCalculateOriginPoint.y;
            this.containerView.setTranslationX(f);
            this.containerView.setTranslationY(this.expandStartY);
            this.containerView.setScaleX(0.0f);
            this.containerView.setScaleY(0.0f);
            return;
        }
        if (actionBarAnimationType == ActionBarAnimationType.ALPHA) {
            this.containerView.setAlpha(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Point calculateOriginPoint(BaseFragment baseFragment, boolean z) {
        if (z) {
            return new Point(baseFragment.fragmentPresentOriginX - (this.containerView.getMeasuredWidth() / 2.0f), baseFragment.fragmentPresentOriginY - (this.containerView.getMeasuredHeight() / 2.0f));
        }
        Point dismissOriginPoint = baseFragment.getDismissOriginPoint();
        dismissOriginPoint.x -= this.containerView.getMeasuredWidth() / 2.0f;
        dismissOriginPoint.y -= this.containerView.getMeasuredHeight() / 2.0f;
        return dismissOriginPoint;
    }

    public void showLastFragment() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        if (this.fragmentsStack.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.fragmentsStack.size() - 1; i++) {
            BaseFragment baseFragment = this.fragmentsStack.get(i);
            ActionBar actionBar = baseFragment.actionBar;
            if (actionBar != null && actionBar.shouldAddToContainer() && (viewGroup2 = (ViewGroup) baseFragment.actionBar.getParent()) != null) {
                viewGroup2.removeView(baseFragment.actionBar);
            }
            View view = baseFragment.fragmentView;
            if (view != null && (viewGroup = (ViewGroup) view.getParent()) != null) {
                baseFragment.onPause();
                baseFragment.onRemoveFromParent();
                viewGroup.removeView(baseFragment.fragmentView);
            }
        }
        BaseFragment baseFragment2 = this.fragmentsStack.get(r1.size() - 1);
        baseFragment2.setParentLayout(this);
        View viewCreateView = baseFragment2.fragmentView;
        if (viewCreateView == null) {
            viewCreateView = baseFragment2.createView(this.parentActivity);
        } else {
            ViewGroup viewGroup3 = (ViewGroup) viewCreateView.getParent();
            if (viewGroup3 != null) {
                baseFragment2.onRemoveFromParent();
                viewGroup3.removeView(viewCreateView);
            }
        }
        this.containerView.addView(viewCreateView, LayoutHelper.createFrame(-1, -1.0f));
        ActionBar actionBar2 = baseFragment2.actionBar;
        if (actionBar2 != null && actionBar2.shouldAddToContainer()) {
            if (this.removeActionBarExtraHeight) {
                baseFragment2.actionBar.setOccupyStatusBar(false);
            }
            ViewGroup viewGroup4 = (ViewGroup) baseFragment2.actionBar.getParent();
            if (viewGroup4 != null) {
                viewGroup4.removeView(baseFragment2.actionBar);
            }
            this.containerView.addView(baseFragment2.actionBar);
            baseFragment2.actionBar.setTitleOverlayText(this.titleOverlayText, this.titleOverlayTextId, this.overlayAction);
        }
        baseFragment2.onResume();
        this.currentActionBar = baseFragment2.actionBar;
        if (baseFragment2.hasOwnBackground || viewCreateView.getBackground() != null) {
            return;
        }
        viewCreateView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
    }

    private void removeFragmentFromStackInternal(BaseFragment baseFragment) {
        baseFragment.onPause();
        baseFragment.onFragmentDestroy();
        baseFragment.setParentLayout(null);
        this.fragmentsStack.remove(baseFragment);
    }

    public void removeFragmentFromStack(int i) {
        if (i >= this.fragmentsStack.size()) {
            return;
        }
        removeFragmentFromStackInternal(this.fragmentsStack.get(i));
    }

    public void removeFragmentFromStack(BaseFragment baseFragment) {
        if (this.useAlphaAnimations && this.fragmentsStack.size() == 1 && AndroidUtilities.isTablet()) {
            closeLastFragment(true);
            return;
        }
        if (this.delegate != null && this.fragmentsStack.size() == 1 && AndroidUtilities.isTablet()) {
            this.delegate.needCloseLastFragment(this);
        }
        removeFragmentFromStackInternal(baseFragment);
    }

    public void removeAllFragments() {
        while (this.fragmentsStack.size() > 0) {
            removeFragmentFromStackInternal(this.fragmentsStack.get(0));
        }
    }

    @Keep
    public void setThemeAnimationValue(float f) {
        this.themeAnimationValue = f;
        int size = this.themeAnimatorDescriptions.size();
        int i = 0;
        while (i < size) {
            ArrayList<ThemeDescription> arrayList = this.themeAnimatorDescriptions.get(i);
            if (i < this.animateStartColors.size() && i < this.animateEndColors.size()) {
                int[] iArr = this.animateStartColors.get(i);
                int[] iArr2 = this.animateEndColors.get(i);
                int size2 = arrayList.size();
                int i2 = 0;
                while (i2 < size2) {
                    int iRed = Color.red(iArr2[i2]);
                    int iGreen = Color.green(iArr2[i2]);
                    int iBlue = Color.blue(iArr2[i2]);
                    int iAlpha = Color.alpha(iArr2[i2]);
                    int iRed2 = Color.red(iArr[i2]);
                    int iGreen2 = Color.green(iArr[i2]);
                    int iBlue2 = Color.blue(iArr[i2]);
                    int i3 = size;
                    int iArgb = Color.argb(Math.min(255, (int) (Color.alpha(iArr[i2]) + ((iAlpha - r2) * f))), Math.min(255, (int) (iRed2 + ((iRed - iRed2) * f))), Math.min(255, (int) (iGreen2 + ((iGreen - iGreen2) * f))), Math.min(255, (int) (iBlue2 + ((iBlue - iBlue2) * f))));
                    ThemeDescription themeDescription = arrayList.get(i2);
                    Theme.setAnimatedColor(themeDescription.getCurrentKey(), iArgb);
                    themeDescription.setColor(iArgb, false, false);
                    i2++;
                    iArr = iArr;
                    size = i3;
                }
            }
            i++;
            size = size;
        }
        int size3 = this.themeAnimatorDelegate.size();
        for (int i4 = 0; i4 < size3; i4++) {
            ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = this.themeAnimatorDelegate.get(i4);
            if (themeDescriptionDelegate != null) {
                themeDescriptionDelegate.didSetColor();
            }
        }
        ArrayList<ThemeDescription> arrayList2 = this.presentingFragmentDescriptions;
        if (arrayList2 != null) {
            int size4 = arrayList2.size();
            for (int i5 = 0; i5 < size4; i5++) {
                ThemeDescription themeDescription2 = this.presentingFragmentDescriptions.get(i5);
                themeDescription2.setColor(Theme.getColor(themeDescription2.getCurrentKey()), false, false);
            }
        }
    }

    @Keep
    public float getThemeAnimationValue() {
        return this.themeAnimationValue;
    }

    private void addStartDescriptions(ArrayList<ThemeDescription> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.themeAnimatorDescriptions.add(arrayList);
        int[] iArr = new int[arrayList.size()];
        this.animateStartColors.add(iArr);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ThemeDescription themeDescription = arrayList.get(i);
            iArr[i] = themeDescription.getSetColor();
            ThemeDescription.ThemeDescriptionDelegate delegateDisabled = themeDescription.setDelegateDisabled();
            if (delegateDisabled != null && !this.themeAnimatorDelegate.contains(delegateDisabled)) {
                this.themeAnimatorDelegate.add(delegateDisabled);
            }
        }
    }

    private void addEndDescriptions(ArrayList<ThemeDescription> arrayList) {
        if (arrayList == null) {
            return;
        }
        int[] iArr = new int[arrayList.size()];
        this.animateEndColors.add(iArr);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            iArr[i] = arrayList.get(i).getSetColor();
        }
    }

    public void animateThemedValues(Theme.ThemeInfo themeInfo, int i, boolean z, boolean z2) {
        BaseFragment lastFragment;
        if (this.transitionAnimationInProgress || this.startedTracking) {
            this.animateThemeAfterAnimation = true;
            this.animateSetThemeAfterAnimation = themeInfo;
            this.animateSetThemeNightAfterAnimation = z;
            this.animateSetThemeAccentIdAfterAnimation = i;
            return;
        }
        AnimatorSet animatorSet = this.themeAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.themeAnimatorSet = null;
        }
        boolean z3 = false;
        for (int i2 = 0; i2 < 2; i2++) {
            if (i2 == 0) {
                lastFragment = getLastFragment();
            } else if ((this.inPreviewMode || this.transitionAnimationPreviewMode) && this.fragmentsStack.size() > 1) {
                ArrayList<BaseFragment> arrayList = this.fragmentsStack;
                lastFragment = arrayList.get(arrayList.size() - 2);
            }
            if (lastFragment != null) {
                ArrayList<ThemeDescription> themeDescriptions = lastFragment.getThemeDescriptions();
                addStartDescriptions(themeDescriptions);
                Dialog dialog = lastFragment.visibleDialog;
                if (dialog instanceof BottomSheet) {
                    addStartDescriptions(((BottomSheet) dialog).getThemeDescriptions());
                } else if (dialog instanceof AlertDialog) {
                    addStartDescriptions(((AlertDialog) dialog).getThemeDescriptions());
                }
                if (i2 == 0) {
                    if (i != -1) {
                        themeInfo.setCurrentAccentId(i);
                        Theme.saveThemeAccents(themeInfo, true, false, true, false);
                    }
                    Theme.applyTheme(themeInfo, z);
                }
                addEndDescriptions(themeDescriptions);
                Dialog dialog2 = lastFragment.visibleDialog;
                if (dialog2 instanceof BottomSheet) {
                    addEndDescriptions(((BottomSheet) dialog2).getThemeDescriptions());
                } else if (dialog2 instanceof AlertDialog) {
                    addEndDescriptions(((AlertDialog) dialog2).getThemeDescriptions());
                }
                z3 = true;
            }
        }
        if (z3) {
            int size = this.fragmentsStack.size() - ((this.inPreviewMode || this.transitionAnimationPreviewMode) ? 2 : 1);
            for (int i3 = 0; i3 < size; i3++) {
                BaseFragment baseFragment = this.fragmentsStack.get(i3);
                baseFragment.clearViews();
                baseFragment.setParentLayout(this);
            }
            if (z2) {
                setThemeAnimationValue(1.0f);
                this.themeAnimatorDescriptions.clear();
                this.animateStartColors.clear();
                this.animateEndColors.clear();
                this.themeAnimatorDelegate.clear();
                this.presentingFragmentDescriptions = null;
                return;
            }
            Theme.setAnimatingColor(true);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.themeAnimatorSet = animatorSet2;
            animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout.13
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (animator.equals(ActionBarLayout.this.themeAnimatorSet)) {
                        ActionBarLayout.this.themeAnimatorDescriptions.clear();
                        ActionBarLayout.this.animateStartColors.clear();
                        ActionBarLayout.this.animateEndColors.clear();
                        ActionBarLayout.this.themeAnimatorDelegate.clear();
                        Theme.setAnimatingColor(false);
                        ActionBarLayout.this.presentingFragmentDescriptions = null;
                        ActionBarLayout.this.themeAnimatorSet = null;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (animator.equals(ActionBarLayout.this.themeAnimatorSet)) {
                        ActionBarLayout.this.themeAnimatorDescriptions.clear();
                        ActionBarLayout.this.animateStartColors.clear();
                        ActionBarLayout.this.animateEndColors.clear();
                        ActionBarLayout.this.themeAnimatorDelegate.clear();
                        Theme.setAnimatingColor(false);
                        ActionBarLayout.this.presentingFragmentDescriptions = null;
                        ActionBarLayout.this.themeAnimatorSet = null;
                    }
                }
            });
            this.themeAnimatorSet.playTogether(ObjectAnimator.ofFloat(this, "themeAnimationValue", 0.0f, 1.0f));
            this.themeAnimatorSet.setDuration(200L);
            this.themeAnimatorSet.start();
        }
    }

    public void rebuildAllFragmentViews(boolean z, boolean z2) {
        if (this.transitionAnimationInProgress || this.startedTracking) {
            this.rebuildAfterAnimation = true;
            this.rebuildLastAfterAnimation = z;
            this.showLastAfterAnimation = z2;
            return;
        }
        int size = this.fragmentsStack.size();
        if (!z) {
            size--;
        }
        if (this.inPreviewMode) {
            size--;
        }
        for (int i = 0; i < size; i++) {
            this.fragmentsStack.get(i).clearViews();
            this.fragmentsStack.get(i).setParentLayout(this);
        }
        ActionBarLayoutDelegate actionBarLayoutDelegate = this.delegate;
        if (actionBarLayoutDelegate != null) {
            actionBarLayoutDelegate.onRebuildAllFragments(this, z);
        }
        if (z2) {
            showLastFragment();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        ActionBar actionBar;
        if (i == 82 && !checkTransitionAnimation() && !this.startedTracking && (actionBar = this.currentActionBar) != null) {
            actionBar.onMenuButtonPressed();
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onActionModeStarted(Object obj) {
        ActionBar actionBar = this.currentActionBar;
        if (actionBar != null) {
            actionBar.setVisibility(8);
        }
        this.inActionMode = true;
    }

    public void onActionModeFinished(Object obj) {
        ActionBar actionBar = this.currentActionBar;
        if (actionBar != null) {
            actionBar.setVisibility(0);
        }
        this.inActionMode = false;
    }

    private void onCloseAnimationEnd() {
        Runnable runnable;
        if (!this.transitionAnimationInProgress || (runnable = this.onCloseAnimationEndRunnable) == null) {
            return;
        }
        this.transitionAnimationInProgress = false;
        this.transitionAnimationPreviewMode = false;
        this.transitionAnimationStartTime = 0L;
        this.newFragment = null;
        this.oldFragment = null;
        this.onCloseAnimationEndRunnable = null;
        runnable.run();
        checkNeedRebuild();
        checkNeedRebuild();
    }

    private void checkNeedRebuild() {
        if (this.rebuildAfterAnimation) {
            rebuildAllFragmentViews(this.rebuildLastAfterAnimation, this.showLastAfterAnimation);
            this.rebuildAfterAnimation = false;
        } else if (this.animateThemeAfterAnimation) {
            animateThemedValues(this.animateSetThemeAfterAnimation, this.animateSetThemeAccentIdAfterAnimation, this.animateSetThemeNightAfterAnimation, false);
            this.animateSetThemeAfterAnimation = null;
            this.animateThemeAfterAnimation = false;
        }
    }

    private void onOpenAnimationEnd() {
        Runnable runnable;
        if (!this.transitionAnimationInProgress || (runnable = this.onOpenAnimationEndRunnable) == null) {
            return;
        }
        this.transitionAnimationInProgress = false;
        this.transitionAnimationPreviewMode = false;
        this.transitionAnimationStartTime = 0L;
        this.newFragment = null;
        this.oldFragment = null;
        this.onOpenAnimationEndRunnable = null;
        runnable.run();
        checkNeedRebuild();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.parentActivity == null) {
            return;
        }
        if (this.transitionAnimationInProgress) {
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.currentAnimation = null;
            }
            if (this.onCloseAnimationEndRunnable != null) {
                onCloseAnimationEnd();
            } else if (this.onOpenAnimationEndRunnable != null) {
                onOpenAnimationEnd();
            }
            this.containerView.invalidate();
        }
        if (intent != null) {
            this.parentActivity.startActivityForResult(intent, i);
        }
    }

    public void setUseAlphaAnimations(boolean z) {
        this.useAlphaAnimations = z;
    }

    public void setBackgroundView(View view) {
        this.backgroundView = view;
    }

    public void setDrawerLayoutContainer(DrawerLayoutContainer drawerLayoutContainer) {
        this.drawerLayoutContainer = drawerLayoutContainer;
    }

    public DrawerLayoutContainer getDrawerLayoutContainer() {
        return this.drawerLayoutContainer;
    }

    public void setFrameLayoutContainer(FrameLayoutContainer frameLayoutContainer) {
        this.frameLayoutContainer = frameLayoutContainer;
    }

    public FrameLayoutContainer getFrameLayoutContainer() {
        return this.frameLayoutContainer;
    }

    public void setRemoveActionBarExtraHeight(boolean z) {
        this.removeActionBarExtraHeight = z;
    }

    public void setTitleOverlayText(String str, int i, Runnable runnable) {
        this.titleOverlayText = str;
        this.titleOverlayTextId = i;
        this.overlayAction = runnable;
        for (int i2 = 0; i2 < this.fragmentsStack.size(); i2++) {
            ActionBar actionBar = this.fragmentsStack.get(i2).actionBar;
            if (actionBar != null) {
                actionBar.setTitleOverlayText(this.titleOverlayText, this.titleOverlayTextId, runnable);
            }
        }
    }

    public boolean extendActionMode(Menu menu) {
        if (!this.fragmentsStack.isEmpty()) {
            ArrayList<BaseFragment> arrayList = this.fragmentsStack;
            if (arrayList.get(arrayList.size() - 1).extendActionMode(menu)) {
                return true;
            }
        }
        return false;
    }

    public void setFragmentPanTranslationOffset(int i) {
        LayoutContainer layoutContainer = this.containerView;
        if (layoutContainer != null) {
            layoutContainer.setFragmentPanTranslationOffset(i);
        }
    }

    private View findScrollingChild(ViewGroup viewGroup, float f, float f2) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(this.rect);
                if (!this.rect.contains((int) f, (int) f2)) {
                    continue;
                } else {
                    if (childAt.canScrollHorizontally(-1)) {
                        return childAt;
                    }
                    if (childAt instanceof ViewGroup) {
                        Rect rect = this.rect;
                        View viewFindScrollingChild = findScrollingChild((ViewGroup) childAt, f - rect.left, f2 - rect.top);
                        if (viewFindScrollingChild != null) {
                            return viewFindScrollingChild;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public void callOnTransitionAnimationEnd(BaseFragment baseFragment, boolean z, boolean z2) {
        if (baseFragment == null) {
            return;
        }
        baseFragment.onTransitionAnimationEnd(z, z2);
    }

    public List<BaseFragment> getFragmentStack() {
        return this.fragmentsStack;
    }

    public void expandPreviewFragment() {
        this.previewOpenAnimationInProgress = true;
        this.inPreviewMode = false;
        ArrayList<BaseFragment> arrayList = this.fragmentsStack;
        BaseFragment baseFragment = arrayList.get(arrayList.size() - 2);
        ArrayList<BaseFragment> arrayList2 = this.fragmentsStack;
        final BaseFragment baseFragment2 = arrayList2.get(arrayList2.size() - 1);
        if (Build.VERSION.SDK_INT >= 21) {
            baseFragment2.fragmentView.setOutlineProvider(null);
            baseFragment2.fragmentView.setClipToOutline(false);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) baseFragment2.fragmentView.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        layoutParams.height = -1;
        baseFragment2.fragmentView.setLayoutParams(layoutParams);
        presentFragmentInternalRemoveOld(false, baseFragment);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(baseFragment2.fragmentView, (Property<View, Float>) View.SCALE_X, 1.0f, 1.05f, 1.0f), ObjectAnimator.ofFloat(baseFragment2.fragmentView, (Property<View, Float>) View.SCALE_Y, 1.0f, 1.05f, 1.0f));
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(new CubicBezierInterpolator(0.42d, 0.0d, 0.58d, 1.0d));
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ActionBar.ActionBarLayout.14
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ActionBarLayout.this.previewOpenAnimationInProgress = false;
                baseFragment2.onPreviewOpenAnimationEnd();
            }
        });
        animatorSet.start();
        performHapticFeedback(3);
        baseFragment2.setInPreviewMode(false);
        baseFragment2.setInMenuMode(false);
    }

    public static class ThemeAnimationSettings {
        public Runnable afterStartDescriptionsAddedRunnable;

        public ThemeAnimationSettings(Theme.ThemeInfo themeInfo, int i, boolean z, boolean z2) {
        }
    }

    public List<BackButtonMenu.PulledDialog> getPulledDialogs() {
        return this.pulledDialogs;
    }

    public void setPulledDialogs(List<BackButtonMenu.PulledDialog> list) {
        this.pulledDialogs = list;
    }
}
