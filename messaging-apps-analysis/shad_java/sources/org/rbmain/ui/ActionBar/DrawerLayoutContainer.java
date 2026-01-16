package org.rbmain.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.Utilities;

/* loaded from: classes4.dex */
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
    private int imeHeight;
    private boolean inLayout;
    private boolean keyboardVisibility;
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
        setDescendantFocusability(MessagesController.UPDATE_MASK_CHAT_MUTE);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 21) {
            setFitsSystemWindows(true);
            setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: org.rbmain.ui.ActionBar.DrawerLayoutContainer$$ExternalSyntheticLambda0
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return this.f$0.lambda$new$0(view, windowInsets);
                }
            });
            setSystemUiVisibility(1280);
        }
        this.shadowLeft = getResources().getDrawable(R.drawable.menu_shadow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets lambda$new$0(View view, WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            boolean zIsVisible = windowInsets.isVisible(WindowInsets.Type.ime());
            int i2 = windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
            if (this.keyboardVisibility != zIsVisible || this.imeHeight != i2) {
                this.keyboardVisibility = zIsVisible;
                this.imeHeight = i2;
                requestLayout();
            }
        }
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

    private void dispatchChildInsets(View view, Object obj, int i) {
        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) obj;
        if (i == 3) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        } else if (i == 5) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        }
        view.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
    }

    private void applyMarginInsets(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i, boolean z) {
        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) obj;
        if (i == 3) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        } else if (i == 5) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        }
        marginLayoutParams.leftMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft();
        marginLayoutParams.topMargin = z ? 0 : windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop();
        marginLayoutParams.rightMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight();
        marginLayoutParams.bottomMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom();
    }

    public void setDrawerLayout(ViewGroup viewGroup) {
        this.drawerLayout = viewGroup;
        addView(viewGroup);
        this.drawerLayout.setVisibility(4);
        if (Build.VERSION.SDK_INT >= 21) {
            this.drawerLayout.setFitsSystemWindows(true);
        }
    }

    public void moveDrawerByX(float f) {
        setDrawerPosition(this.drawerPosition + f);
    }

    @Keep
    public void setDrawerPosition(float f) {
        if (this.drawerLayout == null) {
            return;
        }
        this.drawerPosition = f;
        if (f > r0.getMeasuredWidth()) {
            this.drawerPosition = this.drawerLayout.getMeasuredWidth();
        } else if (this.drawerPosition < 0.0f) {
            this.drawerPosition = 0.0f;
        }
        this.drawerLayout.setTranslationX(this.drawerPosition);
        int i = this.drawerPosition > 0.0f ? 0 : 4;
        if (this.drawerLayout.getVisibility() != i) {
            this.drawerLayout.setVisibility(i);
        }
        BaseFragment baseFragment = this.parentActionBarLayout.fragmentsStack.get(0);
        if (this.drawerPosition == this.drawerLayout.getMeasuredWidth()) {
            baseFragment.setProgressToDrawerOpened(1.0f);
        } else {
            float f2 = this.drawerPosition;
            if (f2 == 0.0f) {
                baseFragment.setProgressToDrawerOpened(0.0f);
            } else {
                baseFragment.setProgressToDrawerOpened(f2 / this.drawerLayout.getMeasuredWidth());
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

    public void openDrawer(boolean z) {
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
        if (z) {
            animatorSet.setDuration(Math.max((int) ((200.0f / this.drawerLayout.getMeasuredWidth()) * (this.drawerLayout.getMeasuredWidth() - this.drawerPosition)), 50));
        } else {
            animatorSet.setDuration(250L);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ActionBar.DrawerLayoutContainer.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DrawerLayoutContainer.this.onDrawerAnimationEnd(true);
            }
        });
        animatorSet.start();
        this.currentAnimation = animatorSet;
    }

    public void closeDrawer(boolean z) {
        if (this.drawerLayout == null) {
            return;
        }
        cancelCurrentAnimation();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, "drawerPosition", 0.0f));
        animatorSet.setInterpolator(new DecelerateInterpolator());
        if (z) {
            animatorSet.setDuration(Math.max((int) ((200.0f / this.drawerLayout.getMeasuredWidth()) * this.drawerPosition), 50));
        } else {
            animatorSet.setDuration(250L);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ActionBar.DrawerLayoutContainer.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DrawerLayoutContainer.this.onDrawerAnimationEnd(false);
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDrawerAnimationEnd(boolean z) {
        this.startedTracking = false;
        this.currentAnimation = null;
        this.drawerOpened = z;
        if (Build.VERSION.SDK_INT >= 19) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt != this.drawerLayout) {
                    childAt.setImportantForAccessibility(z ? 4 : 0);
                }
            }
        }
        sendAccessibilityEvent(32);
    }

    private void setScrimOpacity(float f) {
        this.scrimOpacity = f;
        invalidate();
    }

    private float getScrimOpacity() {
        return this.scrimOpacity;
    }

    public View getDrawerLayout() {
        return this.drawerLayout;
    }

    public void setParentActionBarLayout(ActionBarLayout actionBarLayout) {
        this.parentActionBarLayout = actionBarLayout;
    }

    public void closeDrawer() {
        if (this.drawerPosition != 0.0f) {
            setDrawerPosition(0.0f);
            onDrawerAnimationEnd(false);
        }
    }

    public void setAllowOpenDrawer(boolean z, boolean z2) {
        this.allowOpenDrawer = z;
        if (z || this.drawerPosition == 0.0f) {
            return;
        }
        if (!z2) {
            setDrawerPosition(0.0f);
            onDrawerAnimationEnd(false);
        } else {
            closeDrawer(true);
        }
    }

    public void setAllowOpenDrawerBySwipe(boolean z) {
        this.allowOpenDrawerBySwipe = z;
    }

    private void prepareForDrawerOpen(MotionEvent motionEvent) {
        this.maybeStartTracking = false;
        this.startedTracking = true;
        if (motionEvent != null) {
            this.startedTrackingX = (int) motionEvent.getX();
        }
        this.beginTrackingSent = false;
    }

    public boolean isDrawerOpened() {
        return this.drawerOpened;
    }

    public void setAllowDrawContent(boolean z) {
        if (this.allowDrawContent != z) {
            this.allowDrawContent = z;
            invalidate();
        }
    }

    public boolean isDrawCurrentPreviewFragmentAbove() {
        return this.drawCurrentPreviewFragmentAbove;
    }

    public void setDrawCurrentPreviewFragmentAbove(boolean z) {
        if (this.drawCurrentPreviewFragmentAbove != z) {
            this.drawCurrentPreviewFragmentAbove = z;
            if (z) {
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
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.drawCurrentPreviewFragmentAbove && this.parentActionBarLayout != null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 2) {
                float f = this.startY;
                if (f == 0.0f) {
                    this.startY = motionEvent.getY();
                    MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
                    super.dispatchTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                } else {
                    this.parentActionBarLayout.movePreviewFragment(f - motionEvent.getY());
                }
            } else if (actionMasked == 1 || actionMasked == 6 || actionMasked == 3) {
                this.parentActionBarLayout.finishPreviewFragment();
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
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
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ActionBar.DrawerLayoutContainer.onTouchEvent(android.view.MotionEvent):boolean");
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

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.parentActionBarLayout.checkTransitionAnimation() || onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (this.maybeStartTracking && !this.startedTracking) {
            onTouchEvent(null);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.inLayout = true;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
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
                        FirebaseCrashlytics.getInstance().recordException(e);
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
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(size, size2);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 21) {
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
            int i4 = size2 - AndroidUtilities.statusBarHeight;
            if (i4 > 0 && i4 < 4096) {
                AndroidUtilities.displaySize.y = i4;
            }
        }
        boolean z = this.lastInsets != null && i3 >= 21;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
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
                    childAt.measure(FrameLayout.getChildMeasureSpec(i, this.minDrawerMargin + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), FrameLayout.getChildMeasureSpec(i2, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                }
            }
        }
    }

    public void setBehindKeyboardColor(int i) {
        this.behindKeyboardColor = i;
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
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int iCeil;
        int i2 = 0;
        if (!this.allowDrawContent) {
            return false;
        }
        int height = getHeight();
        boolean z = view != this.drawerLayout;
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
                if (childAt != view && childAt.getVisibility() == 0 && childAt == this.drawerLayout && childAt.getHeight() >= height && (iCeil = ((int) Math.ceil(childAt.getX())) + childAt.getMeasuredWidth()) > i) {
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
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        if (this.scrimOpacity > 0.0f && z) {
            if (indexOfChild(view) == i2) {
                this.scrimPaint.setColor(((int) (this.scrimOpacity * 153.0f)) << 24);
                canvas.drawRect(i, 0.0f, width, getHeight(), this.scrimPaint);
            }
        } else if (this.shadowLeft != null) {
            float fMax = Math.max(0.0f, Math.min(this.drawerPosition / AndroidUtilities.dp(20.0f), 1.0f));
            if (fMax != 0.0f) {
                this.shadowLeft.setBounds((int) this.drawerPosition, view.getTop(), ((int) this.drawerPosition) + this.shadowLeft.getIntrinsicWidth(), view.getBottom());
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
    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        if (!this.drawerOpened || view == this.drawerLayout) {
            return super.onRequestSendAccessibilityEvent(view, accessibilityEvent);
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
            gradientDrawable.setStroke(AndroidUtilities.dp(1.0f), Theme.getColor(Theme.key_actionBarDefault));
            gradientDrawable.setCornerRadius(AndroidUtilities.dp(6.0f));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            this.bottomDrawable = gradientDrawable2;
            gradientDrawable2.setStroke(1, Theme.getColor(Theme.key_divider));
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
        protected void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            this.topDrawable.setBounds(rect);
            this.bottomDrawable.setBounds(rect);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.topDrawable.setAlpha(i);
            this.bottomDrawable.setAlpha(i);
        }
    }
}
