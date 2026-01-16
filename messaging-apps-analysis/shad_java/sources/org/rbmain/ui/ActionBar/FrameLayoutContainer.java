package org.rbmain.ui.ActionBar;

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
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.Utilities;

/* loaded from: classes4.dex */
public class FrameLayoutContainer extends FrameLayout {
    private boolean allowDrawContent;
    private Paint backgroundPaint;
    private int behindKeyboardColor;
    private boolean drawCurrentPreviewFragmentAbove;
    private ViewGroup drawerLayout;
    private boolean drawerOpened;
    private float drawerPosition;
    private boolean hasCutout;
    private boolean inLayout;
    private Object lastInsets;
    private boolean maybeStartTracking;
    private int minDrawerMargin;
    private ActionBarLayout parentActionBarLayout;
    private BitmapDrawable previewBlurDrawable;
    private PreviewForegroundDrawable previewForegroundDrawable;
    private float scrimOpacity;
    private Paint scrimPaint;
    private Drawable shadowLeft;
    private float startY;
    private boolean startedTracking;
    private int startedTrackingPointerId;
    private VelocityTracker velocityTracker;

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public FrameLayoutContainer(Context context) {
        super(context);
        new Rect();
        this.scrimPaint = new Paint();
        this.backgroundPaint = new Paint();
        this.allowDrawContent = true;
        this.minDrawerMargin = (int) ((AndroidUtilities.density * 64.0f) + 0.5f);
        setDescendantFocusability(MessagesController.UPDATE_MASK_CHAT_MUTE);
        setFocusableInTouchMode(true);
    }

    public void setParentActionBarLayout(ActionBarLayout actionBarLayout) {
        this.parentActionBarLayout = actionBarLayout;
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

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.parentActionBarLayout.checkTransitionAnimation()) {
            return false;
        }
        if (motionEvent == null || (motionEvent.getPointerId(0) == this.startedTrackingPointerId && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1 || motionEvent.getAction() == 6))) {
            this.startedTracking = false;
            this.maybeStartTracking = false;
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.velocityTracker = null;
            }
        }
        return this.startedTracking;
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
        if (Build.VERSION.SDK_INT < 21) {
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
        }
        Object obj = this.lastInsets;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
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
