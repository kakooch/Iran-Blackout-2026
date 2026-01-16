package ir.resaneh1.iptv.helper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class BottomUpDragLayout extends FrameLayout {
    private View dragArrowImageView;
    private View mDescView;
    private final ViewDragHelper mDragHelper;
    private float mDragOffset;
    private int mDragRange;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mTop;

    public BottomUpDragLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomUpDragLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTop = -1;
        this.mDragHelper = ViewDragHelper.create(this, 1.0f, new DragHelperCallback());
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mDescView = findViewById(R.id.desc);
        this.dragArrowImageView = findViewById(R.id.dragArrowImageView);
    }

    public void maximize() {
        smoothSlideToTop();
    }

    public void minimize() {
        smoothSlideToBottom();
    }

    boolean smoothSlideToBottom() {
        int iDp = this.mDragRange - AndroidUtilities.dp(40.0f);
        ViewDragHelper viewDragHelper = this.mDragHelper;
        View view = this.mDescView;
        if (!viewDragHelper.smoothSlideViewTo(view, view.getLeft(), iDp)) {
            return false;
        }
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    boolean smoothSlideToTop() {
        AndroidUtilities.dp(56.0f);
        ViewDragHelper viewDragHelper = this.mDragHelper;
        View view = this.mDescView;
        if (!viewDragHelper.smoothSlideViewTo(view, view.getLeft(), 0)) {
            return false;
        }
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    private class DragHelperCallback extends ViewDragHelper.Callback {
        private DragHelperCallback() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            return view == BottomUpDragLayout.this.mDescView;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            BottomUpDragLayout.this.mTop = i2;
            BottomUpDragLayout.this.mDragOffset = i2 / (r1.mDragRange - AndroidUtilities.dp(40.0f));
            BottomUpDragLayout.this.dragArrowImageView.setRotation(BottomUpDragLayout.this.mDragOffset * 180.0f);
            BottomUpDragLayout.this.requestLayout();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            if (f2 > 0.0f || (f2 == 0.0f && BottomUpDragLayout.this.mDragOffset > 0.5f)) {
                BottomUpDragLayout.this.minimize();
            } else {
                BottomUpDragLayout.this.maximize();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            return BottomUpDragLayout.this.mDragRange;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            int paddingTop = BottomUpDragLayout.this.getPaddingTop();
            return Math.min(Math.max(i, paddingTop), BottomUpDragLayout.this.getHeight());
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean zIsViewUnder;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (motionEvent.getAction() == 0 && (motionEvent.getY() - this.mDescView.getY() <= 0.0f || motionEvent.getY() - this.mDescView.getY() >= AndroidUtilities.dp(40.0f))) {
            return false;
        }
        if (actionMasked != 0) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.mDragHelper.cancel();
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 2) {
                float fAbs = Math.abs(x - this.mInitialMotionX);
                float fAbs2 = Math.abs(y - this.mInitialMotionY);
                if (fAbs2 > this.mDragHelper.getTouchSlop() && fAbs > fAbs2) {
                    this.mDragHelper.cancel();
                    return false;
                }
            }
            zIsViewUnder = false;
        } else {
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
            zIsViewUnder = this.mDragHelper.isViewUnder(this.mDescView, (int) x, (int) y);
        }
        return this.mDragHelper.shouldInterceptTouchEvent(motionEvent) || zIsViewUnder;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && (motionEvent.getY() - this.mDescView.getY() <= 0.0f || motionEvent.getY() - this.mDescView.getY() >= AndroidUtilities.dp(40.0f))) {
            return false;
        }
        this.mDragHelper.processTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int i = (int) x;
        int i2 = (int) y;
        boolean zIsViewUnder = this.mDragHelper.isViewUnder(this.mDescView, i, i2);
        int i3 = action & 255;
        if (i3 == 0) {
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
        } else if (i3 == 1) {
            float f = x - this.mInitialMotionX;
            float f2 = y - this.mInitialMotionY;
            int touchSlop = this.mDragHelper.getTouchSlop();
            if ((f * f) + (f2 * f2) < touchSlop * touchSlop && zIsViewUnder) {
                if (this.mDragOffset == 0.0f) {
                    smoothSlideToBottom();
                } else {
                    smoothSlideToTop();
                }
            }
        }
        return (zIsViewUnder && isViewHit(this.mDescView, i, i2)) || isViewHit(this.mDescView, i, i2);
    }

    private boolean isViewHit(View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i3 = iArr2[0] + i;
        int i4 = iArr2[1] + i2;
        return i3 >= iArr[0] && i3 < iArr[0] + view.getWidth() && i4 >= iArr[1] && i4 < iArr[1] + view.getHeight();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        setMeasuredDimension(FrameLayout.resolveSizeAndState(View.MeasureSpec.getSize(i), i, 0), FrameLayout.resolveSizeAndState(View.MeasureSpec.getSize(i2), i2, 0));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mDragRange = getHeight();
        if (this.mTop < 0) {
            this.mTop = getHeight() - AndroidUtilities.dp(40.0f);
        }
        View view = this.mDescView;
        int i5 = this.mTop;
        view.layout(0, i5, i3, i4 + i5);
    }
}
