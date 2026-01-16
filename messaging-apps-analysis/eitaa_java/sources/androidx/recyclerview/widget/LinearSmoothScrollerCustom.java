package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes.dex */
public class LinearSmoothScrollerCustom extends RecyclerView.SmoothScroller {
    private final float MILLISECONDS_PER_PX;
    protected PointF mTargetVector;
    private int scrollPosition;
    protected final LinearInterpolator mLinearInterpolator = new LinearInterpolator();
    protected final DecelerateInterpolator mDecelerateInterpolator = new DecelerateInterpolator(1.5f);
    protected int mInterimTargetDx = 0;
    protected int mInterimTargetDy = 0;

    private int clampApplyScroll(int tmpDt, int dt) {
        int i = tmpDt - dt;
        if (tmpDt * i <= 0) {
            return 0;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void onStart() {
    }

    public LinearSmoothScrollerCustom(Context context, int position) {
        this.MILLISECONDS_PER_PX = 25.0f / context.getResources().getDisplayMetrics().densityDpi;
        this.scrollPosition = position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void onTargetFound(View targetView, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        int iCalculateDyToMakeVisible = calculateDyToMakeVisible(targetView);
        int iCalculateTimeForDeceleration = calculateTimeForDeceleration(iCalculateDyToMakeVisible);
        if (iCalculateTimeForDeceleration > 0) {
            action.update(0, -iCalculateDyToMakeVisible, Math.max(400, iCalculateTimeForDeceleration), this.mDecelerateInterpolator);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void onSeekTargetStep(int dx, int dy, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        if (getChildCount() == 0) {
            stop();
            return;
        }
        this.mInterimTargetDx = clampApplyScroll(this.mInterimTargetDx, dx);
        int iClampApplyScroll = clampApplyScroll(this.mInterimTargetDy, dy);
        this.mInterimTargetDy = iClampApplyScroll;
        if (this.mInterimTargetDx == 0 && iClampApplyScroll == 0) {
            updateActionForInterimTarget(action);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    protected void onStop() {
        this.mInterimTargetDy = 0;
        this.mInterimTargetDx = 0;
        this.mTargetVector = null;
    }

    protected int calculateTimeForDeceleration(int dx) {
        double dCalculateTimeForScrolling = calculateTimeForScrolling(dx);
        Double.isNaN(dCalculateTimeForScrolling);
        return (int) Math.ceil(dCalculateTimeForScrolling / 0.3356d);
    }

    protected int calculateTimeForScrolling(int dx) {
        return (int) Math.ceil(Math.abs(dx) * this.MILLISECONDS_PER_PX);
    }

    protected void updateActionForInterimTarget(RecyclerView.SmoothScroller.Action action) {
        PointF pointFComputeScrollVectorForPosition = computeScrollVectorForPosition(getTargetPosition());
        if (pointFComputeScrollVectorForPosition == null || (pointFComputeScrollVectorForPosition.x == 0.0f && pointFComputeScrollVectorForPosition.y == 0.0f)) {
            action.jumpTo(getTargetPosition());
            stop();
            return;
        }
        normalize(pointFComputeScrollVectorForPosition);
        this.mTargetVector = pointFComputeScrollVectorForPosition;
        this.mInterimTargetDx = (int) (pointFComputeScrollVectorForPosition.x * 10000.0f);
        this.mInterimTargetDy = (int) (pointFComputeScrollVectorForPosition.y * 10000.0f);
        action.update((int) (this.mInterimTargetDx * 1.2f), (int) (this.mInterimTargetDy * 1.2f), (int) (calculateTimeForScrolling(10000) * 1.2f), this.mLinearInterpolator);
    }

    public int calculateDyToMakeVisible(View view) {
        int paddingTop;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            int decoratedTop = layoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            int decoratedBottom = layoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            int height = (layoutManager.getHeight() - layoutManager.getPaddingBottom()) - layoutManager.getPaddingTop();
            int i = decoratedBottom - decoratedTop;
            int i2 = this.scrollPosition;
            if (i2 == 2) {
                paddingTop = layoutManager.getPaddingTop();
            } else if (i > height) {
                paddingTop = 0;
            } else if (i2 == 0) {
                paddingTop = (height - i) / 2;
            } else {
                paddingTop = layoutManager.getPaddingTop() - AndroidUtilities.dp(88.0f);
            }
            int i3 = i + paddingTop;
            int i4 = paddingTop - decoratedTop;
            if (i4 > 0) {
                return i4;
            }
            int i5 = i3 - decoratedBottom;
            if (i5 < 0) {
                return i5;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public PointF computeScrollVectorForPosition(int targetPosition) {
        Object layoutManager = getLayoutManager();
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(targetPosition);
        }
        return null;
    }
}
