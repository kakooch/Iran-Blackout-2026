package ir.eitaa.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.Utilities;

/* loaded from: classes3.dex */
public class DrawerLayoutContainer extends FrameLayout {
    private boolean allowDrawContent;
    private boolean allowOpenDrawer;
    private boolean allowOpenDrawerBySwipe;
    private Paint backgroundPaint;
    private boolean beginTrackingSent;
    private int behindKeyboardColor;
    private AnimatorSet currentAnimation;
    private boolean drawCurrentPreviewFragmentAbove;
    private ViewGroup drawerLayout;
    private boolean drawerOpened;
    private float drawerPosition;
    private boolean firstLayout;
    private boolean hasCutout;
    private boolean inLayout;
    private Object lastInsets;
    private boolean maybeStartTracking;
    private int minDrawerMargin;
    private ActionBarLayout parentActionBarLayout;
    private BitmapDrawable previewBlurDrawable;
    private PreviewForegroundDrawable previewForegroundDrawable;
    private Rect rect;
    private float scrimOpacity;
    private Paint scrimPaint;
    private Drawable shadowLeft;
    private float startY;
    private boolean startedTracking;
    private int startedTrackingPointerId;
    private int startedTrackingX;
    private int startedTrackingY;
    private VelocityTracker velocityTracker;

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public DrawerLayoutContainer(Context context) {
        super(context);
        this.rect = new Rect();
        this.scrimPaint = new Paint();
        this.backgroundPaint = new Paint();
        this.allowOpenDrawerBySwipe = true;
        this.allowDrawContent = true;
        this.firstLayout = true;
        this.minDrawerMargin = (int) ((AndroidUtilities.density * 64.0f) + 0.5f);
        setDescendantFocusability(262144);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 21) {
            setFitsSystemWindows(true);
            setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$DrawerLayoutContainer$EcftEGu8sJy-GNGnzVHNN7ihvKU
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return this.f$0.lambda$new$0$DrawerLayoutContainer(view, windowInsets);
                }
            });
            setSystemUiVisibility(1280);
        }
        this.shadowLeft = getResources().getDrawable(R.drawable.menu_shadow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ WindowInsets lambda$new$0$DrawerLayoutContainer(View view, WindowInsets windowInsets) {
        DrawerLayoutContainer drawerLayoutContainer = (DrawerLayoutContainer) view;
        if (AndroidUtilities.statusBarHeight != windowInsets.getSystemWindowInsetTop()) {
            drawerLayoutContainer.requestLayout();
        }
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        if ((systemWindowInsetTop != 0 || AndroidUtilities.isInMultiwindow || this.firstLayout) && AndroidUtilities.statusBarHeight != systemWindowInsetTop) {
            AndroidUtilities.statusBarHeight = systemWindowInsetTop;
        }
        boolean z = false;
        this.firstLayout = false;
        this.lastInsets = windowInsets;
        drawerLayoutContainer.setWillNotDraw(windowInsets.getSystemWindowInsetTop() <= 0 && getBackground() == null);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null && displayCutout.getBoundingRects().size() != 0) {
                z = true;
            }
            this.hasCutout = z;
        }
        invalidate();
        if (i >= 30) {
            return WindowInsets.CONSUMED;
        }
        return windowInsets.consumeSystemWindowInsets();
    }

    @SuppressLint({"NewApi"})
    private void dispatchChildInsets(View child, Object insets, int drawerGravity) {
        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) insets;
        if (drawerGravity == 3) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        } else if (drawerGravity == 5) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        }
        child.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
    }

    @SuppressLint({"NewApi"})
    private void applyMarginInsets(ViewGroup.MarginLayoutParams lp, Object insets, int drawerGravity, boolean topOnly) {
        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) insets;
        if (drawerGravity == 3) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        } else if (drawerGravity == 5) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        }
        lp.leftMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft();
        lp.topMargin = topOnly ? 0 : windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop();
        lp.rightMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight();
        lp.bottomMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom();
    }

    public void setDrawerLayout(ViewGroup layout) {
        this.drawerLayout = layout;
        addView(layout);
        this.drawerLayout.setVisibility(4);
        if (Build.VERSION.SDK_INT >= 21) {
            this.drawerLayout.setFitsSystemWindows(true);
        }
    }

    public void moveDrawerByX(float dx) {
        setDrawerPosition(this.drawerPosition + dx);
    }

    @Keep
    public void setDrawerPosition(float value) {
        if (this.drawerLayout == null) {
            return;
        }
        this.drawerPosition = value;
        if (value > r0.getMeasuredWidth()) {
            this.drawerPosition = this.drawerLayout.getMeasuredWidth();
        } else if (this.drawerPosition < 0.0f) {
            this.drawerPosition = 0.0f;
        }
        this.drawerLayout.setTranslationX(this.drawerPosition);
        int i = this.drawerPosition > 0.0f ? 0 : 4;
        if (this.drawerLayout.getVisibility() != i) {
            this.drawerLayout.setVisibility(i);
        }
        if (!this.parentActionBarLayout.fragmentsStack.isEmpty()) {
            BaseFragment baseFragment = this.parentActionBarLayout.fragmentsStack.get(0);
            if (this.drawerPosition == this.drawerLayout.getMeasuredWidth()) {
                baseFragment.setProgressToDrawerOpened(1.0f);
            } else {
                float f = this.drawerPosition;
                if (f == 0.0f) {
                    baseFragment.setProgressToDrawerOpened(0.0f);
                } else {
                    baseFragment.setProgressToDrawerOpened(f / this.drawerLayout.getMeasuredWidth());
                }
            }
        }
        setScrimOpacity(this.drawerPosition / this.drawerLayout.getMeasuredWidth());
    }

    @Keep
    public float getDrawerPosition() {
        return this.drawerPosition;
    }

    public void cancelCurrentAnimation() {
        AnimatorSet animatorSet = this.currentAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.currentAnimation = null;
        }
    }

    public void openDrawer(boolean fast) {
        ActionBarLayout actionBarLayout;
        Activity activity;
        if (!this.allowOpenDrawer || this.drawerLayout == null) {
            return;
        }
        if (AndroidUtilities.isTablet() && (actionBarLayout = this.parentActionBarLayout) != null && (activity = actionBarLayout.parentActivity) != null) {
            AndroidUtilities.hideKeyboard(activity.getCurrentFocus());
        }
        cancelCurrentAnimation();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, "drawerPosition", this.drawerLayout.getMeasuredWidth()));
        animatorSet.setInterpolator(new DecelerateInterpolator());
        if (fast) {
            animatorSet.setDuration(Math.max((int) ((200.0f / this.drawerLayout.getMeasuredWidth()) * (this.drawerLayout.getMeasuredWidth() - this.drawerPosition)), 50));
        } else {
            animatorSet.setDuration(250L);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.DrawerLayoutContainer.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DrawerLayoutContainer.this.onDrawerAnimationEnd(true);
            }
        });
        animatorSet.start();
        this.currentAnimation = animatorSet;
    }

    public void closeDrawer(boolean fast) {
        if (this.drawerLayout == null) {
            return;
        }
        cancelCurrentAnimation();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, "drawerPosition", 0.0f));
        animatorSet.setInterpolator(new DecelerateInterpolator());
        if (fast) {
            animatorSet.setDuration(Math.max((int) ((200.0f / this.drawerLayout.getMeasuredWidth()) * this.drawerPosition), 50));
        } else {
            animatorSet.setDuration(250L);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.DrawerLayoutContainer.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DrawerLayoutContainer.this.onDrawerAnimationEnd(false);
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDrawerAnimationEnd(boolean opened) {
        this.startedTracking = false;
        this.currentAnimation = null;
        this.drawerOpened = opened;
        if (Build.VERSION.SDK_INT >= 19) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt != this.drawerLayout) {
                    childAt.setImportantForAccessibility(opened ? 4 : 0);
                }
            }
        }
        sendAccessibilityEvent(32);
    }

    private void setScrimOpacity(float value) {
        this.scrimOpacity = value;
        invalidate();
    }

    private float getScrimOpacity() {
        return this.scrimOpacity;
    }

    public View getDrawerLayout() {
        return this.drawerLayout;
    }

    public void setParentActionBarLayout(ActionBarLayout layout) {
        this.parentActionBarLayout = layout;
    }

    public void closeDrawer() {
        if (this.drawerPosition != 0.0f) {
            setDrawerPosition(0.0f);
            onDrawerAnimationEnd(false);
        }
    }

    public void setAllowOpenDrawer(boolean value, boolean animated) {
        this.allowOpenDrawer = value;
        if (value || this.drawerPosition == 0.0f) {
            return;
        }
        if (!animated) {
            setDrawerPosition(0.0f);
            onDrawerAnimationEnd(false);
        } else {
            closeDrawer(true);
        }
    }

    public void setAllowOpenDrawerBySwipe(boolean value) {
        this.allowOpenDrawerBySwipe = value;
    }

    private void prepareForDrawerOpen(MotionEvent ev) {
        this.maybeStartTracking = false;
        this.startedTracking = true;
        if (ev != null) {
            this.startedTrackingX = (int) ev.getX();
        }
        this.beginTrackingSent = false;
    }

    public boolean isDrawerOpened() {
        return this.drawerOpened;
    }

    public void setAllowDrawContent(boolean value) {
        if (this.allowDrawContent != value) {
            this.allowDrawContent = value;
            invalidate();
        }
    }

    public boolean isDrawCurrentPreviewFragmentAbove() {
        return this.drawCurrentPreviewFragmentAbove;
    }

    public void setDrawCurrentPreviewFragmentAbove(boolean drawCurrentPreviewFragmentAbove) {
        if (this.drawCurrentPreviewFragmentAbove != drawCurrentPreviewFragmentAbove) {
            this.drawCurrentPreviewFragmentAbove = drawCurrentPreviewFragmentAbove;
            if (drawCurrentPreviewFragmentAbove) {
                createBlurDrawable();
                this.previewForegroundDrawable = new PreviewForegroundDrawable();
            } else {
                this.startY = 0.0f;
                this.previewBlurDrawable = null;
                this.previewForegroundDrawable = null;
            }
            invalidate();
        }
    }

    private void createBlurDrawable() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i = (int) (measuredWidth / 6.0f);
        int i2 = (int) (measuredHeight / 6.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.scale(0.16666667f, 0.16666667f);
        draw(canvas);
        Utilities.stackBlurBitmap(bitmapCreateBitmap, Math.max(7, Math.max(i, i2) / 180));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
        this.previewBlurDrawable = bitmapDrawable;
        bitmapDrawable.setBounds(0, 0, measuredWidth, measuredHeight);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (this.drawCurrentPreviewFragmentAbove && this.parentActionBarLayout != null) {
            int actionMasked = ev.getActionMasked();
            if (actionMasked == 2) {
                float f = this.startY;
                if (f == 0.0f) {
                    this.startY = ev.getY();
                    MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
                    super.dispatchTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                } else {
                    this.parentActionBarLayout.movePreviewFragment(f - ev.getY());
                }
            } else if (actionMasked == 1 || actionMasked == 6 || actionMasked == 3) {
                this.parentActionBarLayout.finishPreviewFragment();
            }
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    /* JADX WARN: Removed duplicated region for block: B:98:0x019f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.DrawerLayoutContainer.onTouchEvent(android.view.MotionEvent):boolean");
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

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.parentActionBarLayout.checkTransitionAnimation() || onTouchEvent(ev);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (this.maybeStartTracking && !this.startedTracking) {
            onTouchEvent(null);
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.inLayout = true;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                if (BuildVars.DEBUG_VERSION) {
                    if (this.drawerLayout != childAt) {
                        childAt.layout(layoutParams.leftMargin, layoutParams.topMargin + getPaddingTop(), layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight() + getPaddingTop());
                    } else {
                        childAt.layout(-childAt.getMeasuredWidth(), layoutParams.topMargin + getPaddingTop(), 0, layoutParams.topMargin + childAt.getMeasuredHeight() + getPaddingTop());
                    }
                } else {
                    try {
                        if (this.drawerLayout != childAt) {
                            childAt.layout(layoutParams.leftMargin, layoutParams.topMargin + getPaddingTop(), layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight() + getPaddingTop());
                        } else {
                            childAt.layout(-childAt.getMeasuredWidth(), layoutParams.topMargin + getPaddingTop(), 0, layoutParams.topMargin + childAt.getMeasuredHeight() + getPaddingTop());
                        }
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                }
            }
        }
        this.inLayout = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.inLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    @SuppressLint({"NewApi"})
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(size, size2);
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            this.inLayout = true;
            if (size2 == AndroidUtilities.displaySize.y + AndroidUtilities.statusBarHeight) {
                if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    setPadding(0, AndroidUtilities.statusBarHeight, 0, 0);
                }
                size2 = AndroidUtilities.displaySize.y;
            } else if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                setPadding(0, 0, 0, 0);
            }
            this.inLayout = false;
        } else {
            int i2 = size2 - AndroidUtilities.statusBarHeight;
            if (i2 > 0 && i2 < 4096) {
                AndroidUtilities.displaySize.y = i2;
            }
        }
        boolean z = this.lastInsets != null && i >= 21;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                if (z) {
                    if (childAt.getFitsSystemWindows()) {
                        dispatchChildInsets(childAt, this.lastInsets, layoutParams.gravity);
                    } else if (childAt.getTag() == null) {
                        applyMarginInsets(layoutParams, this.lastInsets, layoutParams.gravity, Build.VERSION.SDK_INT >= 21);
                    }
                }
                if (this.drawerLayout != childAt) {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824);
                    int iMakeMeasureSpec2 = layoutParams.height;
                    if (iMakeMeasureSpec2 <= 0) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824);
                    }
                    childAt.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    childAt.setPadding(0, 0, 0, 0);
                    childAt.measure(FrameLayout.getChildMeasureSpec(widthMeasureSpec, this.minDrawerMargin + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), FrameLayout.getChildMeasureSpec(heightMeasureSpec, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                }
            }
        }
    }

    public void setBehindKeyboardColor(int color) {
        this.behindKeyboardColor = color;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        ActionBarLayout actionBarLayout;
        super.dispatchDraw(canvas);
        if (!this.drawCurrentPreviewFragmentAbove || (actionBarLayout = this.parentActionBarLayout) == null) {
            return;
        }
        BitmapDrawable bitmapDrawable = this.previewBlurDrawable;
        if (bitmapDrawable != null) {
            bitmapDrawable.setAlpha((int) (actionBarLayout.getCurrentPreviewFragmentAlpha() * 255.0f));
            this.previewBlurDrawable.draw(canvas);
        }
        this.parentActionBarLayout.drawCurrentPreviewFragment(canvas, Build.VERSION.SDK_INT >= 21 ? this.previewForegroundDrawable : null);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        int i;
        int iCeil;
        int i2 = 0;
        if (!this.allowDrawContent) {
            return false;
        }
        int height = getHeight();
        boolean z = child != this.drawerLayout;
        int width = getWidth();
        int iSave = canvas.save();
        if (z) {
            int childCount = getChildCount();
            i = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && childAt != this.drawerLayout) {
                    i3 = i4;
                }
                if (childAt != child && childAt.getVisibility() == 0 && childAt == this.drawerLayout && childAt.getHeight() >= height && (iCeil = ((int) Math.ceil(childAt.getX())) + childAt.getMeasuredWidth()) > i) {
                    i = iCeil;
                }
            }
            if (i != 0) {
                canvas.clipRect(i - AndroidUtilities.dp(1.0f), 0, width, getHeight());
            }
            i2 = i3;
        } else {
            i = 0;
        }
        boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
        canvas.restoreToCount(iSave);
        if (this.scrimOpacity > 0.0f && z) {
            if (indexOfChild(child) == i2) {
                this.scrimPaint.setColor(((int) (this.scrimOpacity * 153.0f)) << 24);
                canvas.drawRect(i, 0.0f, width, getHeight(), this.scrimPaint);
            }
        } else if (this.shadowLeft != null) {
            float fMax = Math.max(0.0f, Math.min(this.drawerPosition / AndroidUtilities.dp(20.0f), 1.0f));
            if (fMax != 0.0f) {
                this.shadowLeft.setBounds((int) this.drawerPosition, child.getTop(), ((int) this.drawerPosition) + this.shadowLeft.getIntrinsicWidth(), child.getBottom());
                this.shadowLeft.setAlpha((int) (fMax * 255.0f));
                this.shadowLeft.draw(canvas);
            }
        }
        return zDrawChild;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Object obj;
        if (Build.VERSION.SDK_INT < 21 || (obj = this.lastInsets) == null) {
            return;
        }
        WindowInsets windowInsets = (WindowInsets) obj;
        if (windowInsets.getSystemWindowInsetBottom() > 0) {
            this.backgroundPaint.setColor(this.behindKeyboardColor);
            canvas.drawRect(0.0f, getMeasuredHeight() - r1, getMeasuredWidth(), getMeasuredHeight(), this.backgroundPaint);
        }
        if (this.hasCutout) {
            this.backgroundPaint.setColor(-16777216);
            int systemWindowInsetLeft = windowInsets.getSystemWindowInsetLeft();
            if (systemWindowInsetLeft != 0) {
                canvas.drawRect(0.0f, 0.0f, systemWindowInsetLeft, getMeasuredHeight(), this.backgroundPaint);
            }
            int systemWindowInsetRight = windowInsets.getSystemWindowInsetRight();
            if (systemWindowInsetRight != 0) {
                canvas.drawRect(systemWindowInsetRight, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.backgroundPaint);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        if (!this.drawerOpened || child == this.drawerLayout) {
            return super.onRequestSendAccessibilityEvent(child, event);
        }
        return false;
    }

    private static class PreviewForegroundDrawable extends Drawable {
        private final GradientDrawable bottomDrawable;
        private final GradientDrawable topDrawable;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        public PreviewForegroundDrawable() {
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.topDrawable = gradientDrawable;
            gradientDrawable.setStroke(AndroidUtilities.dp(1.0f), Theme.getColor("actionBarDefault"));
            gradientDrawable.setCornerRadius(AndroidUtilities.dp(6.0f));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            this.bottomDrawable = gradientDrawable2;
            gradientDrawable2.setStroke(1, Theme.getColor("divider"));
            gradientDrawable2.setCornerRadius(AndroidUtilities.dp(6.0f));
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            canvas.save();
            int i = bounds.left;
            int i2 = bounds.top;
            canvas.clipRect(i, i2, bounds.right, ActionBar.getCurrentActionBarHeight() + i2);
            this.topDrawable.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.clipRect(bounds.left, bounds.top + ActionBar.getCurrentActionBarHeight(), bounds.right, bounds.bottom);
            this.bottomDrawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect bounds) {
            super.onBoundsChange(bounds);
            this.topDrawable.setBounds(bounds);
            this.bottomDrawable.setBounds(bounds);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.topDrawable.setAlpha(i);
            this.bottomDrawable.setAlpha(i);
        }
    }
}
