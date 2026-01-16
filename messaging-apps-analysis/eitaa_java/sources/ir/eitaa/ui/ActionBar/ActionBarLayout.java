package ir.eitaa.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
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
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import ir.eitaa.features.ChatLock.ChatLockHelper;
import ir.eitaa.features.ChatLock.LockedChatAction;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.Bulletin;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.GroupCallPip;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.LaunchActivity;
import ir.eitaa.ui.ProfileActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ActionBarLayout extends FrameLayout {
    private static Drawable headerShadowDrawable;
    private static Drawable layerShadowDrawable;
    private static Paint scrimPaint;
    private AccelerateDecelerateInterpolator accelerateDecelerateInterpolator;
    private ArrayList<int[]> animateEndColors;
    private int animateSetThemeAccentIdAfterAnimation;
    private Theme.ThemeInfo animateSetThemeAfterAnimation;
    private boolean animateSetThemeNightAfterAnimation;
    private ArrayList<int[]> animateStartColors;
    private boolean animateThemeAfterAnimation;
    protected boolean animationInProgress;
    private float animationProgress;
    public ThemeAnimationSettings.onAnimationProgress animationProgressListener;
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
    public ArrayList<BaseFragment> fragmentsStack;
    private boolean inActionMode;
    private boolean inBubbleMode;
    private boolean inPreviewMode;
    public float innerTranslationX;
    private long lastFrameTime;
    private View layoutToIgnore;
    private boolean maybeStartTracking;
    public Theme.MessageDrawable messageDrawableOutMediaStart;
    public Theme.MessageDrawable messageDrawableOutStart;
    private BaseFragment newFragment;
    private BaseFragment oldFragment;
    private Runnable onCloseAnimationEndRunnable;
    private Runnable onOpenAnimationEndRunnable;
    private Runnable overlayAction;
    protected Activity parentActivity;
    private ArrayList<ThemeDescription> presentingFragmentDescriptions;
    private ColorDrawable previewBackgroundDrawable;
    private boolean previewOpenAnimationInProgress;
    private boolean rebuildAfterAnimation;
    private boolean rebuildLastAfterAnimation;
    private Rect rect;
    private boolean removeActionBarExtraHeight;
    private boolean showLastAfterAnimation;
    StartColorsProvider startColorsProvider;
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

    public interface ActionBarLayoutDelegate {
        boolean needAddFragmentToStack(BaseFragment fragment, ActionBarLayout layout);

        boolean needCloseLastFragment(ActionBarLayout layout);

        boolean needPresentFragment(BaseFragment fragment, boolean removeLast, boolean forceWithoutAnimation, ActionBarLayout layout);

        boolean onPreIme();

        void onRebuildAllFragments(ActionBarLayout layout, boolean last);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    static /* synthetic */ float access$1116(ActionBarLayout actionBarLayout, float f) {
        float f2 = actionBarLayout.animationProgress + f;
        actionBarLayout.animationProgress = f2;
        return f2;
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
        protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
            int measuredHeight;
            int y;
            if (child instanceof ActionBar) {
                return super.drawChild(canvas, child, drawingTime);
            }
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = getChildAt(i);
                if (childAt == child || !(childAt instanceof ActionBar) || childAt.getVisibility() != 0) {
                    i++;
                } else if (((ActionBar) childAt).getCastShadows()) {
                    measuredHeight = childAt.getMeasuredHeight();
                    y = (int) childAt.getY();
                }
            }
            measuredHeight = 0;
            y = 0;
            boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
            if (measuredHeight != 0 && ActionBarLayout.headerShadowDrawable != null) {
                int i2 = y + measuredHeight;
                ActionBarLayout.headerShadowDrawable.setBounds(0, i2, getMeasuredWidth(), ActionBarLayout.headerShadowDrawable.getIntrinsicHeight() + i2);
                ActionBarLayout.headerShadowDrawable.draw(canvas);
            }
            return zDrawChild;
        }

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return Build.VERSION.SDK_INT >= 28;
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int measuredHeight;
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    measuredHeight = 0;
                    break;
                }
                View childAt = getChildAt(i);
                if (childAt instanceof ActionBar) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 0));
                    measuredHeight = childAt.getMeasuredHeight();
                    break;
                }
                i++;
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = getChildAt(i2);
                if (!(childAt2 instanceof ActionBar)) {
                    if (childAt2.getFitsSystemWindows()) {
                        measureChildWithMargins(childAt2, widthMeasureSpec, 0, heightMeasureSpec, 0);
                    } else {
                        measureChildWithMargins(childAt2, widthMeasureSpec, 0, heightMeasureSpec, measuredHeight);
                    }
                }
            }
            setMeasuredDimension(size, size2);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            int measuredHeight;
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    measuredHeight = 0;
                    break;
                }
                View childAt = getChildAt(i);
                if (childAt instanceof ActionBar) {
                    measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(0, 0, childAt.getMeasuredWidth(), measuredHeight);
                    break;
                }
                i++;
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = getChildAt(i2);
                if (!(childAt2 instanceof ActionBar)) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getFitsSystemWindows()) {
                        int i3 = layoutParams.leftMargin;
                        childAt2.layout(i3, layoutParams.topMargin, childAt2.getMeasuredWidth() + i3, layoutParams.topMargin + childAt2.getMeasuredHeight());
                    } else {
                        int i4 = layoutParams.leftMargin;
                        childAt2.layout(i4, layoutParams.topMargin + measuredHeight, childAt2.getMeasuredWidth() + i4, layoutParams.topMargin + measuredHeight + childAt2.getMeasuredHeight());
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
        public boolean dispatchTouchEvent(MotionEvent ev) {
            if ((!ActionBarLayout.this.inPreviewMode && !ActionBarLayout.this.transitionAnimationPreviewMode) || (ev.getActionMasked() != 0 && ev.getActionMasked() != 5)) {
                try {
                    if (ActionBarLayout.this.inPreviewMode && this == ActionBarLayout.this.containerView) {
                        return false;
                    }
                    return super.dispatchTouchEvent(ev);
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            }
            return false;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.fragmentPanTranslationOffset != 0) {
                if (this.backgroundColor != Theme.getColor("windowBackgroundWhite")) {
                    Paint paint = this.backgroundPaint;
                    int color = Theme.getColor("windowBackgroundWhite");
                    this.backgroundColor = color;
                    paint.setColor(color);
                }
                canvas.drawRect(0.0f, (getMeasuredHeight() - this.fragmentPanTranslationOffset) - 3, getMeasuredWidth(), getMeasuredHeight(), this.backgroundPaint);
            }
            super.onDraw(canvas);
        }

        public void setFragmentPanTranslationOffset(int fragmentPanTranslationOffset) {
            this.fragmentPanTranslationOffset = fragmentPanTranslationOffset;
            invalidate();
        }
    }

    public static class ThemeAnimationSettings {
        public final int accentId;
        public Runnable afterAnimationRunnable;
        public Runnable afterStartDescriptionsAddedRunnable;
        public onAnimationProgress animationProgress;
        public Runnable beforeAnimationRunnable;
        public final boolean instant;
        public final boolean nightTheme;
        public boolean onlyTopFragment;
        public Theme.ResourcesProvider resourcesProvider;
        public final Theme.ThemeInfo theme;
        public boolean applyTheme = true;
        public long duration = 200;

        public interface onAnimationProgress {
            void setProgress(float p);
        }

        public ThemeAnimationSettings(Theme.ThemeInfo theme, int accentId, boolean nightTheme, boolean instant) {
            this.theme = theme;
            this.accentId = accentId;
            this.nightTheme = nightTheme;
            this.instant = instant;
        }
    }

    public ActionBarLayout(Context context) {
        super(context);
        this.decelerateInterpolator = new DecelerateInterpolator(1.5f);
        this.accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        this.animateStartColors = new ArrayList<>();
        this.animateEndColors = new ArrayList<>();
        this.startColorsProvider = new StartColorsProvider();
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

    public void init(ArrayList<BaseFragment> stack) {
        this.fragmentsStack = stack;
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
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.fragmentsStack.isEmpty()) {
            return;
        }
        int size = this.fragmentsStack.size();
        for (int i = 0; i < size; i++) {
            BaseFragment baseFragment = this.fragmentsStack.get(i);
            baseFragment.onConfigurationChanged(newConfig);
            Dialog dialog = baseFragment.visibleDialog;
            if (dialog instanceof BottomSheet) {
                ((BottomSheet) dialog).onConfigurationChanged(newConfig);
            }
        }
    }

    public void drawHeaderShadow(Canvas canvas, int y) {
        drawHeaderShadow(canvas, 255, y);
    }

    public void setInBubbleMode(boolean value) {
        this.inBubbleMode = value;
    }

    public boolean isInBubbleMode() {
        return this.inBubbleMode;
    }

    public void drawHeaderShadow(Canvas canvas, int alpha, int y) {
        if (headerShadowDrawable != null) {
            if (Build.VERSION.SDK_INT < 19 || headerShadowDrawable.getAlpha() != alpha) {
                headerShadowDrawable.setAlpha(alpha);
            }
            headerShadowDrawable.setBounds(0, y, getMeasuredWidth(), headerShadowDrawable.getIntrinsicHeight() + y);
            headerShadowDrawable.draw(canvas);
        }
    }

    @Keep
    public void setInnerTranslationX(float value) {
        int navigationBarColor;
        int navigationBarColor2;
        this.innerTranslationX = value;
        invalidate();
        if (this.fragmentsStack.size() < 2 || this.containerView.getMeasuredWidth() <= 0) {
            return;
        }
        float measuredWidth = value / this.containerView.getMeasuredWidth();
        ArrayList<BaseFragment> arrayList = this.fragmentsStack;
        BaseFragment baseFragment = arrayList.get(arrayList.size() - 2);
        baseFragment.onSlideProgress(false, measuredWidth);
        BaseFragment baseFragment2 = this.fragmentsStack.get(r1.size() - 1);
        if (!baseFragment2.isBeginToShow() || (navigationBarColor = baseFragment2.getNavigationBarColor()) == (navigationBarColor2 = baseFragment.getNavigationBarColor())) {
            return;
        }
        baseFragment2.setNavigationBarColor(ColorUtils.blendARGB(navigationBarColor, navigationBarColor2, MathUtils.clamp(measuredWidth * 2.0f, 0.0f, 1.0f)));
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
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.animationInProgress || checkTransitionAnimation() || onTouchEvent(ev);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        onTouchEvent(null);
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        if (event != null && event.getKeyCode() == 4 && event.getAction() == 1) {
            ActionBarLayoutDelegate actionBarLayoutDelegate = this.delegate;
            return (actionBarLayoutDelegate != null && actionBarLayoutDelegate.onPreIme()) || super.dispatchKeyEventPreIme(event);
        }
        return super.dispatchKeyEventPreIme(event);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        LayoutContainer layoutContainer;
        DrawerLayoutContainer drawerLayoutContainer = this.drawerLayoutContainer;
        if (drawerLayoutContainer != null && drawerLayoutContainer.isDrawCurrentPreviewFragmentAbove() && (this.inPreviewMode || this.transitionAnimationPreviewMode || this.previewOpenAnimationInProgress)) {
            BaseFragment baseFragment = this.oldFragment;
            if (child == ((baseFragment == null || !baseFragment.inPreviewMode) ? this.containerView : this.containerViewBack)) {
                this.drawerLayoutContainer.invalidate();
                return false;
            }
        }
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingRight = ((int) this.innerTranslationX) + getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int paddingLeft2 = getPaddingLeft() + width;
        if (child == this.containerViewBack) {
            paddingLeft2 = AndroidUtilities.dp(1.0f) + paddingRight;
        } else if (child == this.containerView) {
            paddingLeft = paddingRight;
        }
        int iSave = canvas.save();
        if (!this.transitionAnimationInProgress && !this.inPreviewMode) {
            canvas.clipRect(paddingLeft, 0, paddingLeft2, getHeight());
        }
        if ((this.inPreviewMode || this.transitionAnimationPreviewMode) && child == (layoutContainer = this.containerView)) {
            drawPreviewDrawables(canvas, layoutContainer, child);
        }
        boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
        canvas.restoreToCount(iSave);
        if (paddingRight != 0) {
            if (child == this.containerView) {
                float fMax = Math.max(0.0f, Math.min((width - paddingRight) / AndroidUtilities.dp(20.0f), 1.0f));
                Drawable drawable = layerShadowDrawable;
                drawable.setBounds(paddingRight - drawable.getIntrinsicWidth(), child.getTop(), paddingRight, child.getBottom());
                layerShadowDrawable.setAlpha((int) (fMax * 255.0f));
                layerShadowDrawable.draw(canvas);
            } else if (child == this.containerViewBack) {
                float fMin = Math.min(0.8f, (width - paddingRight) / width);
                scrimPaint.setColor(((int) ((fMin >= 0.0f ? fMin : 0.0f) * 153.0f)) << 24);
                canvas.drawRect(paddingLeft, 0.0f, paddingLeft2, getHeight(), scrimPaint);
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

    public void drawCurrentPreviewFragment(Canvas canvas, Drawable foregroundDrawable) {
        if (this.inPreviewMode || this.transitionAnimationPreviewMode || this.previewOpenAnimationInProgress) {
            BaseFragment baseFragment = this.oldFragment;
            LayoutContainer layoutContainer = (baseFragment == null || !baseFragment.inPreviewMode) ? this.containerView : this.containerViewBack;
            drawPreviewDrawables(canvas, layoutContainer, null);
            if (layoutContainer.getAlpha() < 1.0f) {
                canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), (int) (layoutContainer.getAlpha() * 255.0f), 31);
            } else {
                canvas.save();
            }
            canvas.concat(layoutContainer.getMatrix());
            layoutContainer.draw(canvas);
            if (foregroundDrawable != null) {
                View childAt = layoutContainer.getChildAt(0);
                if (childAt != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    Rect rect = new Rect();
                    childAt.getLocalVisibleRect(rect);
                    rect.offset(marginLayoutParams.leftMargin, marginLayoutParams.topMargin);
                    rect.top += Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight - 1 : 0;
                    foregroundDrawable.setAlpha((int) (layoutContainer.getAlpha() * 255.0f));
                    foregroundDrawable.setBounds(rect);
                    foregroundDrawable.draw(canvas);
                }
            }
            canvas.restore();
        }
    }

    private void drawPreviewDrawables(Canvas canvas, ViewGroup containerView, View child) {
        if ((this.inPreviewMode || this.transitionAnimationPreviewMode) && child == containerView && !getLastFragment().wrapContentInPreviewMode) {
            if (containerView.getChildAt(0) != null) {
                this.previewBackgroundDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                this.previewBackgroundDrawable.draw(canvas);
                int measuredWidth = (getMeasuredWidth() - AndroidUtilities.dp(24.0f)) / 2;
                int top = (int) ((r0.getTop() + containerView.getTranslationY()) - AndroidUtilities.dp((Build.VERSION.SDK_INT < 21 ? 20 : 0) + 12));
                Theme.moveUpDrawable.setBounds(measuredWidth, top, AndroidUtilities.dp(24.0f) + measuredWidth, AndroidUtilities.dp(24.0f) + top);
                Theme.moveUpDrawable.draw(canvas);
            }
        }
    }

    public void setDelegate(ActionBarLayoutDelegate actionBarLayoutDelegate) {
        this.delegate = actionBarLayoutDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSlideAnimationEnd(final boolean backAnimation) throws InterruptedException {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        if (!backAnimation) {
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
            this.layoutToIgnore = this.containerView;
        } else {
            if (this.fragmentsStack.size() >= 2) {
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
            this.layoutToIgnore = null;
        }
        this.containerViewBack.setVisibility(4);
        this.startedTracking = false;
        this.animationInProgress = false;
        this.containerView.setTranslationX(0.0f);
        this.containerViewBack.setTranslationX(0.0f);
        setInnerTranslationX(0.0f);
    }

    private void prepareForMoving(MotionEvent ev) {
        this.maybeStartTracking = false;
        this.startedTracking = true;
        this.layoutToIgnore = this.containerViewBack;
        this.startedTrackingX = (int) ev.getX();
        this.containerViewBack.setVisibility(0);
        this.beginTrackingSent = false;
        BaseFragment baseFragment = this.fragmentsStack.get(r8.size() - 2);
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
            viewCreateView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        }
        baseFragment.onResume();
        if (this.themeAnimatorSet != null) {
            this.presentingFragmentDescriptions = baseFragment.getThemeDescriptions();
        }
        ArrayList<BaseFragment> arrayList = this.fragmentsStack;
        arrayList.get(arrayList.size() - 1).prepareFragmentToSlide(true, true);
        baseFragment.prepareFragmentToSlide(false, true);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Animator customSlideTransition;
        if (checkTransitionAnimation() || this.inActionMode || this.animationInProgress) {
            return false;
        }
        if (this.fragmentsStack.size() > 1) {
            if (ev != null && ev.getAction() == 0) {
                ArrayList<BaseFragment> arrayList = this.fragmentsStack;
                if (!arrayList.get(arrayList.size() - 1).isSwipeBackEnabled(ev)) {
                    this.maybeStartTracking = false;
                    this.startedTracking = false;
                    return false;
                }
                this.startedTrackingPointerId = ev.getPointerId(0);
                this.maybeStartTracking = true;
                this.startedTrackingX = (int) ev.getX();
                this.startedTrackingY = (int) ev.getY();
                VelocityTracker velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            } else if (ev != null && ev.getAction() == 2 && ev.getPointerId(0) == this.startedTrackingPointerId && !this.inPreviewMode) {
                if (this.velocityTracker == null) {
                    this.velocityTracker = VelocityTracker.obtain();
                }
                int iMax = Math.max(0, (int) (ev.getX() - this.startedTrackingX));
                int iAbs = Math.abs(((int) ev.getY()) - this.startedTrackingY);
                this.velocityTracker.addMovement(ev);
                if (!this.transitionAnimationInProgress && !this.inPreviewMode && this.maybeStartTracking && !this.startedTracking && iMax >= AndroidUtilities.getPixelsInCM(0.4f, true) && Math.abs(iMax) / 3 > iAbs) {
                    ArrayList<BaseFragment> arrayList2 = this.fragmentsStack;
                    if (arrayList2.get(arrayList2.size() - 1).canBeginSlide() && findScrollingChild(this, ev.getX(), ev.getY()) == null) {
                        prepareForMoving(ev);
                    } else {
                        this.maybeStartTracking = false;
                    }
                } else if (this.startedTracking) {
                    if (!this.beginTrackingSent) {
                        if (this.parentActivity.getCurrentFocus() != null) {
                            AndroidUtilities.hideKeyboard(this.parentActivity.getCurrentFocus());
                        }
                        ArrayList<BaseFragment> arrayList3 = this.fragmentsStack;
                        arrayList3.get(arrayList3.size() - 1).onBeginSlide();
                        this.beginTrackingSent = true;
                    }
                    float f = iMax;
                    this.containerView.setTranslationX(f);
                    setInnerTranslationX(f);
                }
            } else if (ev != null && ev.getPointerId(0) == this.startedTrackingPointerId && (ev.getAction() == 3 || ev.getAction() == 1 || ev.getAction() == 6)) {
                if (this.velocityTracker == null) {
                    this.velocityTracker = VelocityTracker.obtain();
                }
                this.velocityTracker.computeCurrentVelocity(1000);
                ArrayList<BaseFragment> arrayList4 = this.fragmentsStack;
                BaseFragment baseFragment = arrayList4.get(arrayList4.size() - 1);
                if (!this.inPreviewMode && !this.transitionAnimationPreviewMode && !this.startedTracking && baseFragment.isSwipeBackEnabled(ev)) {
                    float xVelocity = this.velocityTracker.getXVelocity();
                    float yVelocity = this.velocityTracker.getYVelocity();
                    if (xVelocity >= 3500.0f && xVelocity > Math.abs(yVelocity) && baseFragment.canBeginSlide()) {
                        prepareForMoving(ev);
                        if (!this.beginTrackingSent) {
                            if (((Activity) getContext()).getCurrentFocus() != null) {
                                AndroidUtilities.hideKeyboard(((Activity) getContext()).getCurrentFocus());
                            }
                            this.beginTrackingSent = true;
                        }
                    }
                }
                if (this.startedTracking) {
                    float x = this.containerView.getX();
                    AnimatorSet animatorSet = new AnimatorSet();
                    float xVelocity2 = this.velocityTracker.getXVelocity();
                    final boolean z = x < ((float) this.containerView.getMeasuredWidth()) / 3.0f && (xVelocity2 < 3500.0f || xVelocity2 < this.velocityTracker.getYVelocity());
                    if (!z) {
                        x = this.containerView.getMeasuredWidth() - x;
                        int iMax2 = Math.max((int) ((200.0f / this.containerView.getMeasuredWidth()) * x), 50);
                        long j = iMax2;
                        animatorSet.playTogether(ObjectAnimator.ofFloat(this.containerView, (Property<LayoutContainer, Float>) View.TRANSLATION_X, r10.getMeasuredWidth()).setDuration(j), ObjectAnimator.ofFloat(this, "innerTranslationX", this.containerView.getMeasuredWidth()).setDuration(j));
                    } else {
                        long jMax = Math.max((int) ((200.0f / this.containerView.getMeasuredWidth()) * x), 50);
                        animatorSet.playTogether(ObjectAnimator.ofFloat(this.containerView, (Property<LayoutContainer, Float>) View.TRANSLATION_X, 0.0f).setDuration(jMax), ObjectAnimator.ofFloat(this, "innerTranslationX", 0.0f).setDuration(jMax));
                    }
                    Animator customSlideTransition2 = baseFragment.getCustomSlideTransition(false, z, x);
                    if (customSlideTransition2 != null) {
                        animatorSet.playTogether(customSlideTransition2);
                    }
                    ArrayList<BaseFragment> arrayList5 = this.fragmentsStack;
                    BaseFragment baseFragment2 = arrayList5.get(arrayList5.size() - 2);
                    if (baseFragment2 != null && (customSlideTransition = baseFragment2.getCustomSlideTransition(false, z, x)) != null) {
                        animatorSet.playTogether(customSlideTransition);
                    }
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.ActionBarLayout.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) throws InterruptedException {
                            ActionBarLayout.this.onSlideAnimationEnd(z);
                        }
                    });
                    animatorSet.start();
                    this.animationInProgress = true;
                    this.layoutToIgnore = this.containerViewBack;
                } else {
                    this.maybeStartTracking = false;
                    this.startedTracking = false;
                    this.layoutToIgnore = null;
                }
                VelocityTracker velocityTracker2 = this.velocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.velocityTracker = null;
                }
            } else if (ev == null) {
                this.maybeStartTracking = false;
                this.startedTracking = false;
                this.layoutToIgnore = null;
                VelocityTracker velocityTracker3 = this.velocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.velocityTracker = null;
                }
            }
        }
        return this.startedTracking;
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
    public void onAnimationEndCheck(boolean byCheck) {
        onCloseAnimationEnd();
        onOpenAnimationEnd();
        Runnable runnable = this.waitingForKeyboardCloseRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.waitingForKeyboardCloseRunnable = null;
        }
        AnimatorSet animatorSet = this.currentAnimation;
        if (animatorSet != null) {
            if (byCheck) {
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
        this.containerView.setAlpha(1.0f);
        this.containerView.setScaleX(1.0f);
        this.containerView.setScaleY(1.0f);
        this.containerViewBack.setAlpha(1.0f);
        this.containerViewBack.setScaleX(1.0f);
        this.containerViewBack.setScaleY(1.0f);
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

    private void presentFragmentInternalRemoveOld(boolean removeLast, final BaseFragment fragment) throws InterruptedException {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        if (fragment == null) {
            return;
        }
        fragment.onBecomeFullyHidden();
        fragment.onPause();
        if (removeLast) {
            fragment.onFragmentDestroy();
            fragment.setParentLayout(null);
            this.fragmentsStack.remove(fragment);
        } else {
            View view = fragment.fragmentView;
            if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
                fragment.onRemoveFromParent();
                try {
                    viewGroup2.removeViewInLayout(fragment.fragmentView);
                } catch (Exception e) {
                    FileLog.e(e);
                    try {
                        viewGroup2.removeView(fragment.fragmentView);
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                }
            }
            ActionBar actionBar = fragment.actionBar;
            if (actionBar != null && actionBar.shouldAddToContainer() && (viewGroup = (ViewGroup) fragment.actionBar.getParent()) != null) {
                viewGroup.removeViewInLayout(fragment.actionBar);
            }
        }
        this.containerViewBack.setVisibility(4);
    }

    public boolean presentFragmentAsPreview(BaseFragment fragment) {
        return presentFragment(fragment, false, false, true, true);
    }

    public boolean presentFragmentAsPreview(BaseFragment fragment, boolean wrapContent) {
        return presentFragment(fragment, false, false, true, true, wrapContent);
    }

    public boolean presentFragment(BaseFragment fragment) {
        return presentFragment(fragment, false, false, true, false);
    }

    public boolean presentFragment(BaseFragment fragment, boolean removeLast) {
        return presentFragment(fragment, removeLast, false, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLayoutAnimation(final boolean open, final boolean first, final boolean preview) {
        if (first) {
            this.animationProgress = 0.0f;
            this.lastFrameTime = System.nanoTime() / 1000000;
        }
        Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.ActionBarLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (ActionBarLayout.this.animationRunnable != this) {
                    return;
                }
                ActionBarLayout.this.animationRunnable = null;
                if (first) {
                    ActionBarLayout.this.transitionAnimationStartTime = System.currentTimeMillis();
                }
                long jNanoTime = System.nanoTime() / 1000000;
                long j = jNanoTime - ActionBarLayout.this.lastFrameTime;
                if (j > 18) {
                    j = 18;
                }
                ActionBarLayout.this.lastFrameTime = jNanoTime;
                ActionBarLayout.access$1116(ActionBarLayout.this, j / 150.0f);
                if (ActionBarLayout.this.animationProgress > 1.0f) {
                    ActionBarLayout.this.animationProgress = 1.0f;
                }
                if (ActionBarLayout.this.newFragment != null) {
                    ActionBarLayout.this.newFragment.onTransitionAnimationProgress(true, ActionBarLayout.this.animationProgress);
                }
                if (ActionBarLayout.this.oldFragment != null) {
                    ActionBarLayout.this.oldFragment.onTransitionAnimationProgress(false, ActionBarLayout.this.animationProgress);
                }
                Integer numValueOf = ActionBarLayout.this.oldFragment != null ? Integer.valueOf(ActionBarLayout.this.oldFragment.getNavigationBarColor()) : null;
                Integer numValueOf2 = ActionBarLayout.this.newFragment != null ? Integer.valueOf(ActionBarLayout.this.newFragment.getNavigationBarColor()) : null;
                if (ActionBarLayout.this.newFragment != null && !ActionBarLayout.this.newFragment.inPreviewMode && numValueOf != null) {
                    ActionBarLayout.this.newFragment.setNavigationBarColor(ColorUtils.blendARGB(numValueOf.intValue(), numValueOf2.intValue(), MathUtils.clamp((ActionBarLayout.this.animationProgress * 2.0f) - (open ? 1.0f : 0.0f), 0.0f, 1.0f)));
                }
                float interpolation = ActionBarLayout.this.decelerateInterpolator.getInterpolation(ActionBarLayout.this.animationProgress);
                if (open) {
                    ActionBarLayout.this.containerView.setAlpha(interpolation);
                    if (preview) {
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
                    if (preview) {
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
                    ActionBarLayout.this.startLayoutAnimation(open, false, preview);
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

    public boolean presentFragment(final BaseFragment fragment, final boolean removeLast, boolean forceWithoutAnimation, boolean check, final boolean preview) {
        return presentFragment(fragment, removeLast, forceWithoutAnimation, check, preview, false);
    }

    public boolean presentFragment(final BaseFragment fragment, final boolean removeLast, boolean forceWithoutAnimation, boolean check, final boolean preview, final boolean wrapContent) {
        ActionBarLayoutDelegate actionBarLayoutDelegate;
        final BaseFragment baseFragment;
        if (fragment == null || checkTransitionAnimation() || !(((actionBarLayoutDelegate = this.delegate) == null || !check || actionBarLayoutDelegate.needPresentFragment(fragment, removeLast, forceWithoutAnimation, this)) && fragment.onFragmentCreate())) {
            return false;
        }
        if ((fragment instanceof ChatActivity) || ((fragment instanceof ProfileActivity) && !((ProfileActivity) fragment).isSettings())) {
            long j = fragment.arguments.getLong("chat_id", 0L);
            long j2 = fragment.arguments.getLong("user_id", 0L);
            long j3 = j != 0 ? j : j2;
            if (!ChatLockHelper.isChatUnlocked(Long.valueOf(j3))) {
                MessagesController messagesController = MessagesController.getInstance(UserConfig.selectedAccount);
                if (((j2 != 0 && messagesController.isLockedDialog(Long.valueOf(j2))) || (j != 0 && messagesController.isLockedDialog(Long.valueOf(-j)))) && (this.parentActivity instanceof LaunchActivity)) {
                    LockedChatAction lockedChatAction = new LockedChatAction();
                    lockedChatAction.dialogId = Long.valueOf(j3);
                    ((LaunchActivity) this.parentActivity).showPasscodeActivity(true, false, lockedChatAction, 0, 0, null, null);
                }
            }
        }
        fragment.setInPreviewMode(preview);
        fragment.wrapContentInPreviewMode = wrapContent;
        if (this.parentActivity.getCurrentFocus() != null && fragment.hideKeyboardOnShow() && !preview) {
            AndroidUtilities.hideKeyboard(this.parentActivity.getCurrentFocus());
        }
        boolean z = preview || (!forceWithoutAnimation && MessagesController.getGlobalMainSettings().getBoolean("view_animations", true));
        if (this.fragmentsStack.isEmpty()) {
            baseFragment = null;
        } else {
            ArrayList<BaseFragment> arrayList = this.fragmentsStack;
            baseFragment = arrayList.get(arrayList.size() - 1);
        }
        fragment.setParentLayout(this);
        View viewCreateView = fragment.fragmentView;
        if (viewCreateView == null) {
            viewCreateView = fragment.createView(this.parentActivity);
        } else {
            ViewGroup viewGroup = (ViewGroup) viewCreateView.getParent();
            if (viewGroup != null) {
                fragment.onRemoveFromParent();
                viewGroup.removeView(viewCreateView);
            }
        }
        this.containerViewBack.addView(viewCreateView);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewCreateView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        if (preview) {
            int previewHeight = fragment.getPreviewHeight();
            int i = Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0;
            if (wrapContent) {
                layoutParams.width = -2;
                layoutParams.height = -2;
            } else if (previewHeight > 0 && previewHeight < getMeasuredHeight() - i) {
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
        ActionBar actionBar = fragment.actionBar;
        if (actionBar != null && actionBar.shouldAddToContainer()) {
            if (this.removeActionBarExtraHeight) {
                fragment.actionBar.setOccupyStatusBar(false);
            }
            ViewGroup viewGroup2 = (ViewGroup) fragment.actionBar.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(fragment.actionBar);
            }
            this.containerViewBack.addView(fragment.actionBar);
            fragment.actionBar.setTitleOverlayText(this.titleOverlayText, this.titleOverlayTextId, this.overlayAction);
        }
        this.fragmentsStack.add(fragment);
        fragment.onResume();
        this.currentActionBar = fragment.actionBar;
        if (!fragment.hasOwnBackground && viewCreateView.getBackground() == null) {
            viewCreateView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        }
        LayoutContainer layoutContainer = this.containerView;
        LayoutContainer layoutContainer2 = this.containerViewBack;
        this.containerView = layoutContainer2;
        this.containerViewBack = layoutContainer;
        layoutContainer2.setVisibility(0);
        setInnerTranslationX(0.0f);
        this.containerView.setTranslationY(0.0f);
        this.containerView.setForegroundGravity(17);
        if (preview) {
            if (Build.VERSION.SDK_INT >= 21) {
                viewCreateView.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.ActionBar.ActionBarLayout.3
                    @Override // android.view.ViewOutlineProvider
                    @TargetApi(21)
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
        if (!z) {
            presentFragmentInternalRemoveOld(removeLast, baseFragment);
            View view = this.backgroundView;
            if (view != null) {
                view.setVisibility(0);
            }
        }
        if (this.themeAnimatorSet != null) {
            this.presentingFragmentDescriptions = fragment.getThemeDescriptions();
        }
        if (z || preview) {
            if (this.useAlphaAnimations && this.fragmentsStack.size() == 1) {
                presentFragmentInternalRemoveOld(removeLast, baseFragment);
                this.transitionAnimationStartTime = System.currentTimeMillis();
                this.transitionAnimationInProgress = true;
                this.layoutToIgnore = this.containerView;
                this.onOpenAnimationEndRunnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$ActionBarLayout$vkJIkCC3pzOp7_03K--M3Ujgyh8
                    @Override // java.lang.Runnable
                    public final void run() {
                        ActionBarLayout.lambda$presentFragment$0(baseFragment, fragment);
                    }
                };
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(ObjectAnimator.ofFloat(this, (Property<ActionBarLayout, Float>) View.ALPHA, 0.0f, 1.0f));
                View view2 = this.backgroundView;
                if (view2 != null) {
                    view2.setVisibility(0);
                    arrayList2.add(ObjectAnimator.ofFloat(this.backgroundView, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f));
                }
                if (baseFragment != null) {
                    baseFragment.onTransitionAnimationStart(false, false);
                }
                fragment.onTransitionAnimationStart(true, false);
                AnimatorSet animatorSet = new AnimatorSet();
                this.currentAnimation = animatorSet;
                animatorSet.playTogether(arrayList2);
                this.currentAnimation.setInterpolator(this.accelerateDecelerateInterpolator);
                this.currentAnimation.setDuration(200L);
                this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.ActionBarLayout.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        ActionBarLayout.this.onAnimationEndCheck(false);
                    }
                });
                this.currentAnimation.start();
            } else {
                this.transitionAnimationPreviewMode = preview;
                this.transitionAnimationStartTime = System.currentTimeMillis();
                this.transitionAnimationInProgress = true;
                this.layoutToIgnore = this.containerView;
                final BaseFragment baseFragment2 = baseFragment;
                this.onOpenAnimationEndRunnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$ActionBarLayout$Jsh9TBNtFXMFD1xeDBSh3wSjzaY
                    @Override // java.lang.Runnable
                    public final void run() throws InterruptedException {
                        this.f$0.lambda$presentFragment$1$ActionBarLayout(preview, removeLast, baseFragment2, fragment);
                    }
                };
                final boolean z2 = !fragment.needDelayOpenAnimation();
                if (z2) {
                    if (baseFragment != null) {
                        baseFragment.onTransitionAnimationStart(false, false);
                    }
                    fragment.onTransitionAnimationStart(true, false);
                }
                this.delayedAnimationResumed = false;
                this.oldFragment = baseFragment;
                this.newFragment = fragment;
                AnimatorSet animatorSetOnCustomTransitionAnimation = preview ? null : fragment.onCustomTransitionAnimation(true, new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$ActionBarLayout$pZgF8_X9H_VfvD2bh1WfY3Ena5s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$presentFragment$2$ActionBarLayout();
                    }
                });
                if (animatorSetOnCustomTransitionAnimation != null) {
                    if ((!preview && this.containerView.isKeyboardVisible) || (this.containerViewBack.isKeyboardVisible && baseFragment != null)) {
                        baseFragment.saveKeyboardPositionBeforeTransition();
                    }
                    this.currentAnimation = animatorSetOnCustomTransitionAnimation;
                } else {
                    this.containerView.setAlpha(0.0f);
                    if (preview) {
                        this.containerView.setTranslationX(0.0f);
                        this.containerView.setScaleX(0.9f);
                        this.containerView.setScaleY(0.9f);
                    } else {
                        this.containerView.setTranslationX(48.0f);
                        this.containerView.setScaleX(1.0f);
                        this.containerView.setScaleY(1.0f);
                    }
                    if (this.containerView.isKeyboardVisible || this.containerViewBack.isKeyboardVisible) {
                        if (baseFragment != null && !preview) {
                            baseFragment.saveKeyboardPositionBeforeTransition();
                        }
                        final BaseFragment baseFragment3 = baseFragment;
                        this.waitingForKeyboardCloseRunnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.ActionBarLayout.5
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ActionBarLayout.this.waitingForKeyboardCloseRunnable != this) {
                                    return;
                                }
                                ActionBarLayout.this.waitingForKeyboardCloseRunnable = null;
                                if (!z2) {
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
                                BaseFragment baseFragment4 = baseFragment3;
                                if (baseFragment4 != null) {
                                    baseFragment4.onTransitionAnimationStart(false, false);
                                }
                                fragment.onTransitionAnimationStart(true, false);
                                ActionBarLayout.this.startLayoutAnimation(true, true, preview);
                            }
                        };
                        if (fragment.needDelayOpenAnimation()) {
                            this.delayedOpenAnimationRunnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.ActionBarLayout.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (ActionBarLayout.this.delayedOpenAnimationRunnable != this) {
                                        return;
                                    }
                                    ActionBarLayout.this.delayedOpenAnimationRunnable = null;
                                    BaseFragment baseFragment4 = baseFragment;
                                    if (baseFragment4 != null) {
                                        baseFragment4.onTransitionAnimationStart(false, false);
                                    }
                                    fragment.onTransitionAnimationStart(true, false);
                                    ActionBarLayout.this.startLayoutAnimation(true, true, preview);
                                }
                            };
                        }
                        AndroidUtilities.runOnUIThread(this.waitingForKeyboardCloseRunnable, SharedConfig.smoothKeyboard ? 250L : 200L);
                    } else if (fragment.needDelayOpenAnimation()) {
                        Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.ActionBarLayout.7
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ActionBarLayout.this.delayedOpenAnimationRunnable != this) {
                                    return;
                                }
                                ActionBarLayout.this.delayedOpenAnimationRunnable = null;
                                fragment.onTransitionAnimationStart(true, false);
                                ActionBarLayout.this.startLayoutAnimation(true, true, preview);
                            }
                        };
                        this.delayedOpenAnimationRunnable = runnable;
                        AndroidUtilities.runOnUIThread(runnable, 200L);
                    } else {
                        startLayoutAnimation(true, true, preview);
                    }
                }
            }
        } else {
            View view3 = this.backgroundView;
            if (view3 != null) {
                view3.setAlpha(1.0f);
                this.backgroundView.setVisibility(0);
            }
            if (baseFragment != null) {
                baseFragment.onTransitionAnimationStart(false, false);
                baseFragment.onTransitionAnimationEnd(false, false);
            }
            fragment.onTransitionAnimationStart(true, false);
            fragment.onTransitionAnimationEnd(true, false);
            fragment.onBecomeFullyVisible();
        }
        return true;
    }

    static /* synthetic */ void lambda$presentFragment$0(BaseFragment baseFragment, BaseFragment baseFragment2) {
        if (baseFragment != null) {
            baseFragment.onTransitionAnimationEnd(false, false);
        }
        baseFragment2.onTransitionAnimationEnd(true, false);
        baseFragment2.onBecomeFullyVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$presentFragment$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$presentFragment$1$ActionBarLayout(boolean z, boolean z2, BaseFragment baseFragment, BaseFragment baseFragment2) throws InterruptedException {
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
    /* renamed from: lambda$presentFragment$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$presentFragment$2$ActionBarLayout() {
        onAnimationEndCheck(false);
    }

    public boolean addFragmentToStack(BaseFragment fragment) {
        return addFragmentToStack(fragment, -1);
    }

    public boolean addFragmentToStack(BaseFragment fragment, int position) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ActionBarLayoutDelegate actionBarLayoutDelegate = this.delegate;
        if ((actionBarLayoutDelegate != null && !actionBarLayoutDelegate.needAddFragmentToStack(fragment, this)) || !fragment.onFragmentCreate()) {
            return false;
        }
        fragment.setParentLayout(this);
        if (position == -1) {
            if (!this.fragmentsStack.isEmpty()) {
                ArrayList<BaseFragment> arrayList = this.fragmentsStack;
                BaseFragment baseFragment = arrayList.get(arrayList.size() - 1);
                baseFragment.onPause();
                ActionBar actionBar = baseFragment.actionBar;
                if (actionBar != null && actionBar.shouldAddToContainer() && (viewGroup2 = (ViewGroup) baseFragment.actionBar.getParent()) != null) {
                    viewGroup2.removeView(baseFragment.actionBar);
                }
                View view = baseFragment.fragmentView;
                if (view != null && (viewGroup = (ViewGroup) view.getParent()) != null) {
                    baseFragment.onRemoveFromParent();
                    viewGroup.removeView(baseFragment.fragmentView);
                }
            }
            this.fragmentsStack.add(fragment);
        } else {
            this.fragmentsStack.add(position, fragment);
        }
        return true;
    }

    private void closeLastFragmentInternalRemoveOld(BaseFragment fragment) throws InterruptedException {
        fragment.onPause();
        fragment.onFragmentDestroy();
        fragment.setParentLayout(null);
        this.fragmentsStack.remove(fragment);
        this.containerViewBack.setVisibility(4);
        this.containerViewBack.setTranslationY(0.0f);
        bringChildToFront(this.containerView);
    }

    public void movePreviewFragment(float dy) {
        if (!this.inPreviewMode || this.transitionAnimationPreviewMode) {
            return;
        }
        float translationY = this.containerView.getTranslationY();
        float f = -dy;
        if (f > 0.0f) {
            f = 0.0f;
        } else if (f < (-AndroidUtilities.dp(60.0f))) {
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
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.ActionBarLayout.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ActionBarLayout.this.previewOpenAnimationInProgress = false;
                    baseFragment2.onPreviewOpenAnimationEnd();
                }
            });
            animatorSet.start();
            performHapticFeedback(3);
            baseFragment2.setInPreviewMode(false);
            f = 0.0f;
        }
        if (translationY != f) {
            this.containerView.setTranslationY(f);
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

    public void closeLastFragment(boolean animated) {
        final BaseFragment baseFragment;
        ActionBarLayoutDelegate actionBarLayoutDelegate = this.delegate;
        if ((actionBarLayoutDelegate != null && !actionBarLayoutDelegate.needCloseLastFragment(this)) || checkTransitionAnimation() || this.fragmentsStack.isEmpty()) {
            return;
        }
        if (this.parentActivity.getCurrentFocus() != null) {
            AndroidUtilities.hideKeyboard(this.parentActivity.getCurrentFocus());
        }
        setInnerTranslationX(0.0f);
        boolean z = this.inPreviewMode || this.transitionAnimationPreviewMode || (animated && MessagesController.getGlobalMainSettings().getBoolean("view_animations", true));
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
                viewCreateView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            }
            if (!z) {
                closeLastFragmentInternalRemoveOld(baseFragment2);
            }
            if (z) {
                this.transitionAnimationStartTime = System.currentTimeMillis();
                this.transitionAnimationInProgress = true;
                this.layoutToIgnore = this.containerView;
                this.onCloseAnimationEndRunnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$ActionBarLayout$D4uLFxSQUMpJ1OeOJS0hE9kaSBw
                    @Override // java.lang.Runnable
                    public final void run() throws InterruptedException {
                        this.f$0.lambda$closeLastFragment$3$ActionBarLayout(baseFragment2, baseFragment);
                    }
                };
                if (!this.inPreviewMode && !this.transitionAnimationPreviewMode) {
                    animatorSetOnCustomTransitionAnimation = baseFragment2.onCustomTransitionAnimation(false, new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$ActionBarLayout$Kg2eJtTlqr3Xm86v1jRYC7gy7zU
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$closeLastFragment$4$ActionBarLayout();
                        }
                    });
                }
                if (animatorSetOnCustomTransitionAnimation == null) {
                    if (!this.inPreviewMode && (this.containerView.isKeyboardVisible || this.containerViewBack.isKeyboardVisible)) {
                        Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.ActionBarLayout.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ActionBarLayout.this.waitingForKeyboardCloseRunnable != this) {
                                    return;
                                }
                                ActionBarLayout.this.waitingForKeyboardCloseRunnable = null;
                                ActionBarLayout.this.startLayoutAnimation(false, true, false);
                            }
                        };
                        this.waitingForKeyboardCloseRunnable = runnable;
                        AndroidUtilities.runOnUIThread(runnable, 200L);
                        return;
                    }
                    startLayoutAnimation(false, true, this.inPreviewMode || this.transitionAnimationPreviewMode);
                    return;
                }
                this.currentAnimation = animatorSetOnCustomTransitionAnimation;
                if (Bulletin.getVisibleBulletin() == null || !Bulletin.getVisibleBulletin().isShowing()) {
                    return;
                }
                Bulletin.getVisibleBulletin().hide();
                return;
            }
            baseFragment2.onTransitionAnimationEnd(false, true);
            baseFragment.onTransitionAnimationEnd(true, true);
            baseFragment.onBecomeFullyVisible();
            return;
        }
        if (this.useAlphaAnimations) {
            this.transitionAnimationStartTime = System.currentTimeMillis();
            this.transitionAnimationInProgress = true;
            this.layoutToIgnore = this.containerView;
            this.onCloseAnimationEndRunnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$ActionBarLayout$Z6Xy0p18CSkgARAYn7fbCDKW34c
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    this.f$0.lambda$closeLastFragment$5$ActionBarLayout(baseFragment2);
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
            this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.ActionBarLayout.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    ActionBarLayout.this.transitionAnimationStartTime = System.currentTimeMillis();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ActionBarLayout.this.onAnimationEndCheck(false);
                }
            });
            this.currentAnimation.start();
            return;
        }
        removeFragmentFromStackInternal(baseFragment2);
        setVisibility(8);
        View view2 = this.backgroundView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$closeLastFragment$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$closeLastFragment$3$ActionBarLayout(BaseFragment baseFragment, BaseFragment baseFragment2) throws InterruptedException {
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
    /* renamed from: lambda$closeLastFragment$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$closeLastFragment$4$ActionBarLayout() {
        onAnimationEndCheck(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$closeLastFragment$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$closeLastFragment$5$ActionBarLayout(BaseFragment baseFragment) throws InterruptedException {
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
        viewCreateView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
    }

    private void removeFragmentFromStackInternal(BaseFragment fragment) throws InterruptedException {
        fragment.onPause();
        fragment.onFragmentDestroy();
        fragment.setParentLayout(null);
        this.fragmentsStack.remove(fragment);
    }

    public void removeFragmentFromStack(int num) throws InterruptedException {
        if (num >= this.fragmentsStack.size()) {
            return;
        }
        removeFragmentFromStackInternal(this.fragmentsStack.get(num));
    }

    public void removeFragmentFromStack(BaseFragment fragment) {
        if (this.useAlphaAnimations && this.fragmentsStack.size() == 1 && AndroidUtilities.isTablet()) {
            closeLastFragment(true);
            return;
        }
        if (this.delegate != null && this.fragmentsStack.size() == 1 && AndroidUtilities.isTablet()) {
            this.delegate.needCloseLastFragment(this);
        }
        removeFragmentFromStackInternal(fragment);
    }

    public void removeAllFragments() {
        while (this.fragmentsStack.size() > 0) {
            removeFragmentFromStackInternal(this.fragmentsStack.get(0));
        }
    }

    @Keep
    public void setThemeAnimationValue(float value) {
        this.themeAnimationValue = value;
        int size = this.themeAnimatorDescriptions.size();
        for (int i = 0; i < size; i++) {
            ArrayList<ThemeDescription> arrayList = this.themeAnimatorDescriptions.get(i);
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
                int iArgb = Color.argb(Math.min(255, (int) (Color.alpha(iArr[i2]) + ((iAlpha - r2) * value))), Math.min(255, (int) (iRed2 + ((iRed - iRed2) * value))), Math.min(255, (int) (iGreen2 + ((iGreen - iGreen2) * value))), Math.min(255, (int) (iBlue2 + ((iBlue - iBlue2) * value))));
                ThemeDescription themeDescription = arrayList.get(i2);
                themeDescription.setAnimatedColor(iArgb);
                themeDescription.setColor(iArgb, false, false);
                i2++;
                iArr = iArr;
                size = i3;
            }
        }
        int size3 = this.themeAnimatorDelegate.size();
        for (int i4 = 0; i4 < size3; i4++) {
            ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = this.themeAnimatorDelegate.get(i4);
            if (themeDescriptionDelegate != null) {
                themeDescriptionDelegate.didSetColor();
                themeDescriptionDelegate.onAnimationProgress(value);
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
        ThemeAnimationSettings.onAnimationProgress onanimationprogress = this.animationProgressListener;
        if (onanimationprogress != null) {
            onanimationprogress.setProgress(value);
        }
    }

    @Keep
    public float getThemeAnimationValue() {
        return this.themeAnimationValue;
    }

    private void addStartDescriptions(ArrayList<ThemeDescription> descriptions) {
        if (descriptions == null) {
            return;
        }
        this.themeAnimatorDescriptions.add(descriptions);
        int[] iArr = new int[descriptions.size()];
        this.animateStartColors.add(iArr);
        int size = descriptions.size();
        for (int i = 0; i < size; i++) {
            ThemeDescription themeDescription = descriptions.get(i);
            iArr[i] = themeDescription.getSetColor();
            ThemeDescription.ThemeDescriptionDelegate delegateDisabled = themeDescription.setDelegateDisabled();
            if (delegateDisabled != null && !this.themeAnimatorDelegate.contains(delegateDisabled)) {
                this.themeAnimatorDelegate.add(delegateDisabled);
            }
        }
    }

    private void addEndDescriptions(ArrayList<ThemeDescription> descriptions) {
        if (descriptions == null) {
            return;
        }
        int[] iArr = new int[descriptions.size()];
        this.animateEndColors.add(iArr);
        int size = descriptions.size();
        for (int i = 0; i < size; i++) {
            iArr[i] = descriptions.get(i).getSetColor();
        }
    }

    public void animateThemedValues(Theme.ThemeInfo theme, int accentId, boolean nightTheme, boolean instant) {
        animateThemedValues(new ThemeAnimationSettings(theme, accentId, nightTheme, instant));
        if (getLastFragment() != null) {
            getLastFragment().getActionBar().setBackgroundColor(Theme.getColor(Theme.getCurrentTheme().isDark() ? "actionBarDefault" : "profile_tabSelectedLine"));
        }
    }

    public void animateThemedValues(final ThemeAnimationSettings settings) {
        BaseFragment lastFragment;
        if (this.transitionAnimationInProgress || this.startedTracking) {
            this.animateThemeAfterAnimation = true;
            this.animateSetThemeAfterAnimation = settings.theme;
            this.animateSetThemeNightAfterAnimation = settings.nightTheme;
            this.animateSetThemeAccentIdAfterAnimation = settings.accentId;
            return;
        }
        AnimatorSet animatorSet = this.themeAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.themeAnimatorSet = null;
        }
        int i = settings.onlyTopFragment ? 1 : 2;
        boolean z = false;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                lastFragment = getLastFragment();
            } else if ((this.inPreviewMode || this.transitionAnimationPreviewMode) && this.fragmentsStack.size() > 1) {
                ArrayList<BaseFragment> arrayList = this.fragmentsStack;
                lastFragment = arrayList.get(arrayList.size() - 2);
            }
            if (lastFragment != null) {
                if (settings.resourcesProvider != null) {
                    if (this.messageDrawableOutStart == null) {
                        Theme.MessageDrawable messageDrawable = new Theme.MessageDrawable(0, true, false, this.startColorsProvider);
                        this.messageDrawableOutStart = messageDrawable;
                        messageDrawable.isCrossfadeBackground = true;
                        Theme.MessageDrawable messageDrawable2 = new Theme.MessageDrawable(1, true, false, this.startColorsProvider);
                        this.messageDrawableOutMediaStart = messageDrawable2;
                        messageDrawable2.isCrossfadeBackground = true;
                    }
                    this.startColorsProvider.saveColors(settings.resourcesProvider);
                }
                ArrayList<ThemeDescription> themeDescriptions = lastFragment.getThemeDescriptions();
                addStartDescriptions(themeDescriptions);
                Dialog dialog = lastFragment.visibleDialog;
                if (dialog instanceof BottomSheet) {
                    addStartDescriptions(((BottomSheet) dialog).getThemeDescriptions());
                } else if (dialog instanceof AlertDialog) {
                    addStartDescriptions(((AlertDialog) dialog).getThemeDescriptions());
                }
                if (i2 == 0) {
                    if (settings.applyTheme) {
                        int i3 = settings.accentId;
                        if (i3 != -1) {
                            settings.theme.setCurrentAccentId(i3);
                            Theme.saveThemeAccents(settings.theme, true, false, true, false);
                        }
                        Theme.applyTheme(settings.theme, settings.nightTheme);
                    }
                    Runnable runnable = settings.afterStartDescriptionsAddedRunnable;
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                addEndDescriptions(themeDescriptions);
                Dialog dialog2 = lastFragment.visibleDialog;
                if (dialog2 instanceof BottomSheet) {
                    addEndDescriptions(((BottomSheet) dialog2).getThemeDescriptions());
                } else if (dialog2 instanceof AlertDialog) {
                    addEndDescriptions(((AlertDialog) dialog2).getThemeDescriptions());
                }
                z = true;
            }
        }
        if (z) {
            int size = this.fragmentsStack.size() - ((this.inPreviewMode || this.transitionAnimationPreviewMode) ? 2 : 1);
            for (int i4 = 0; i4 < size; i4++) {
                BaseFragment baseFragment = this.fragmentsStack.get(i4);
                baseFragment.clearViews();
                baseFragment.setParentLayout(this);
            }
            if (settings.instant) {
                setThemeAnimationValue(1.0f);
                this.themeAnimatorDescriptions.clear();
                this.animateStartColors.clear();
                this.animateEndColors.clear();
                this.themeAnimatorDelegate.clear();
                this.presentingFragmentDescriptions = null;
                Runnable runnable2 = settings.afterAnimationRunnable;
                if (runnable2 != null) {
                    runnable2.run();
                    return;
                }
                return;
            }
            Theme.setAnimatingColor(true);
            Runnable runnable3 = settings.beforeAnimationRunnable;
            if (runnable3 != null) {
                runnable3.run();
            }
            ThemeAnimationSettings.onAnimationProgress onanimationprogress = settings.animationProgress;
            this.animationProgressListener = onanimationprogress;
            if (onanimationprogress != null) {
                onanimationprogress.setProgress(0.0f);
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.themeAnimatorSet = animatorSet2;
            animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.ActionBarLayout.11
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (animation.equals(ActionBarLayout.this.themeAnimatorSet)) {
                        ActionBarLayout.this.themeAnimatorDescriptions.clear();
                        ActionBarLayout.this.animateStartColors.clear();
                        ActionBarLayout.this.animateEndColors.clear();
                        ActionBarLayout.this.themeAnimatorDelegate.clear();
                        Theme.setAnimatingColor(false);
                        ActionBarLayout.this.presentingFragmentDescriptions = null;
                        ActionBarLayout.this.themeAnimatorSet = null;
                        Runnable runnable4 = settings.afterAnimationRunnable;
                        if (runnable4 != null) {
                            runnable4.run();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    if (animation.equals(ActionBarLayout.this.themeAnimatorSet)) {
                        ActionBarLayout.this.themeAnimatorDescriptions.clear();
                        ActionBarLayout.this.animateStartColors.clear();
                        ActionBarLayout.this.animateEndColors.clear();
                        ActionBarLayout.this.themeAnimatorDelegate.clear();
                        Theme.setAnimatingColor(false);
                        ActionBarLayout.this.presentingFragmentDescriptions = null;
                        ActionBarLayout.this.themeAnimatorSet = null;
                        Runnable runnable4 = settings.afterAnimationRunnable;
                        if (runnable4 != null) {
                            runnable4.run();
                        }
                    }
                }
            });
            this.themeAnimatorSet.playTogether(ObjectAnimator.ofFloat(this, "themeAnimationValue", 0.0f, 1.0f));
            this.themeAnimatorSet.setDuration(settings.duration);
            this.themeAnimatorSet.start();
        }
    }

    public void rebuildAllFragmentViews(boolean last, boolean showLastAfter) {
        if (this.transitionAnimationInProgress || this.startedTracking) {
            this.rebuildAfterAnimation = true;
            this.rebuildLastAfterAnimation = last;
            this.showLastAfterAnimation = showLastAfter;
            return;
        }
        int size = this.fragmentsStack.size();
        if (!last) {
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
            actionBarLayoutDelegate.onRebuildAllFragments(this, last);
        }
        if (showLastAfter) {
            showLastFragment();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        ActionBar actionBar;
        if (keyCode == 82 && !checkTransitionAnimation() && !this.startedTracking && (actionBar = this.currentActionBar) != null) {
            actionBar.onMenuButtonPressed();
        }
        return super.onKeyUp(keyCode, event);
    }

    public void onActionModeStarted(Object mode) {
        ActionBar actionBar = this.currentActionBar;
        if (actionBar != null) {
            actionBar.setVisibility(8);
        }
        this.inActionMode = true;
    }

    public void onActionModeFinished(Object mode) {
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
        this.layoutToIgnore = null;
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
        this.layoutToIgnore = null;
        this.transitionAnimationPreviewMode = false;
        this.transitionAnimationStartTime = 0L;
        this.newFragment = null;
        this.oldFragment = null;
        this.onOpenAnimationEndRunnable = null;
        runnable.run();
        checkNeedRebuild();
    }

    public void startActivityForResult(final Intent intent, final int requestCode) {
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
            this.parentActivity.startActivityForResult(intent, requestCode);
        }
    }

    public void setUseAlphaAnimations(boolean value) {
        this.useAlphaAnimations = value;
    }

    public void setBackgroundView(View view) {
        this.backgroundView = view;
    }

    public void setDrawerLayoutContainer(DrawerLayoutContainer layout) {
        this.drawerLayoutContainer = layout;
    }

    public DrawerLayoutContainer getDrawerLayoutContainer() {
        return this.drawerLayoutContainer;
    }

    public void setRemoveActionBarExtraHeight(boolean value) {
        this.removeActionBarExtraHeight = value;
    }

    public void setTitleOverlayText(String title, int titleId, Runnable action) {
        this.titleOverlayText = title;
        this.titleOverlayTextId = titleId;
        this.overlayAction = action;
        for (int i = 0; i < this.fragmentsStack.size(); i++) {
            ActionBar actionBar = this.fragmentsStack.get(i).actionBar;
            if (actionBar != null) {
                actionBar.setTitleOverlayText(this.titleOverlayText, this.titleOverlayTextId, action);
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

    public void setFragmentPanTranslationOffset(int offset) {
        LayoutContainer layoutContainer = this.containerView;
        if (layoutContainer != null) {
            layoutContainer.setFragmentPanTranslationOffset(offset);
        }
    }

    private View findScrollingChild(ViewGroup parent, float x, float y) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(this.rect);
                if (!this.rect.contains((int) x, (int) y)) {
                    continue;
                } else {
                    if (childAt.canScrollHorizontally(-1)) {
                        return childAt;
                    }
                    if (childAt instanceof ViewGroup) {
                        Rect rect = this.rect;
                        View viewFindScrollingChild = findScrollingChild((ViewGroup) childAt, x - rect.left, y - rect.top);
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

    private class StartColorsProvider implements Theme.ResourcesProvider {
        HashMap<String, Integer> colors;
        String[] keysToSave;

        @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
        public /* synthetic */ void applyServiceShaderMatrix(int i, int i2, float f, float f2) {
            Theme.applyServiceShaderMatrix(i, i2, f, f2);
        }

        @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
        public /* synthetic */ int getColorOrDefault(String str) {
            return Theme.ResourcesProvider.CC.$default$getColorOrDefault(this, str);
        }

        @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
        public /* synthetic */ Drawable getDrawable(String str) {
            return Theme.ResourcesProvider.CC.$default$getDrawable(this, str);
        }

        @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
        public /* synthetic */ Paint getPaint(String str) {
            return Theme.ResourcesProvider.CC.$default$getPaint(this, str);
        }

        @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
        public /* synthetic */ boolean hasGradientService() {
            return Theme.ResourcesProvider.CC.$default$hasGradientService(this);
        }

        @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
        public /* synthetic */ void setAnimatedColor(String str, int i) {
            Theme.ResourcesProvider.CC.$default$setAnimatedColor(this, str, i);
        }

        private StartColorsProvider() {
            this.colors = new HashMap<>();
            this.keysToSave = new String[]{"chat_outBubble", "chat_outBubbleGradient", "chat_outBubbleGradient2", "chat_outBubbleGradient3", "chat_outBubbleGradientAnimated", "chat_outBubbleShadow"};
        }

        @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
        public Integer getColor(String key) {
            return this.colors.get(key);
        }

        @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
        public Integer getCurrentColor(String key) {
            return this.colors.get(key);
        }

        public void saveColors(Theme.ResourcesProvider fragmentResourceProvider) {
            this.colors.clear();
            for (String str : this.keysToSave) {
                this.colors.put(str, fragmentResourceProvider.getCurrentColor(str));
            }
        }
    }
}
