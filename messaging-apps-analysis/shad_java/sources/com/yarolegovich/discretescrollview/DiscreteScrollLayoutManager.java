package com.yarolegovich.discretescrollview;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer;
import java.util.Locale;

/* loaded from: classes3.dex */
class DiscreteScrollLayoutManager extends RecyclerView.LayoutManager {
    protected int childHalfHeight;
    protected int childHalfWidth;
    private Context context;
    protected int currentScrollState;
    private boolean dataSetChangeShiftedPosition;
    protected int extraLayoutSpace;
    protected boolean isFirstOrEmptyLayout;
    private DiscreteScrollItemTransformer itemTransformer;
    private int offscreenItems;
    private DSVOrientation.Helper orientationHelper;
    protected int pendingScroll;
    private final ScrollStateListener scrollStateListener;
    protected int scrollToChangeCurrent;
    protected int scrolled;
    private int viewHeight;
    private int viewWidth;
    private int timeForItemSettle = 300;
    protected int pendingPosition = -1;
    protected int currentPosition = -1;
    private int flingThreshold = 2100;
    private boolean shouldSlideOnFling = false;
    protected Point recyclerCenter = new Point();
    protected Point currentViewCenter = new Point();
    protected Point viewCenterIterator = new Point();
    protected SparseArray<View> detachedCache = new SparseArray<>();
    private RecyclerViewProxy recyclerViewProxy = new RecyclerViewProxy(this);
    private int transformClampItemCount = 1;

    public interface InitialPositionProvider {
        int getInitialPosition();
    }

    public interface ScrollStateListener {
        void onCurrentViewFirstLayout();

        void onDataSetChangeChangedPosition();

        void onIsBoundReachedFlagChange(boolean z);

        void onScroll(float f);

        void onScrollEnd();

        void onScrollStart();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public DiscreteScrollLayoutManager(Context context, ScrollStateListener scrollStateListener, DSVOrientation dSVOrientation) {
        this.context = context;
        this.scrollStateListener = scrollStateListener;
        this.orientationHelper = dSVOrientation.createHelper();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() == 0) {
            this.recyclerViewProxy.removeAndRecycleAllViews(recycler);
            this.pendingPosition = -1;
            this.currentPosition = -1;
            this.pendingScroll = 0;
            this.scrolled = 0;
            return;
        }
        ensureValidPosition(state);
        updateRecyclerDimensions(state);
        if (!this.isFirstOrEmptyLayout) {
            boolean z = this.recyclerViewProxy.getChildCount() == 0;
            this.isFirstOrEmptyLayout = z;
            if (z) {
                initChildDimensions(recycler);
            }
        }
        this.recyclerViewProxy.detachAndScrapAttachedViews(recycler);
        fill(recycler);
        applyItemTransformToChildren();
    }

    private void ensureValidPosition(RecyclerView.State state) {
        int i = this.currentPosition;
        if (i == -1 || i >= state.getItemCount()) {
            this.currentPosition = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        if (this.isFirstOrEmptyLayout) {
            this.scrollStateListener.onCurrentViewFirstLayout();
            this.isFirstOrEmptyLayout = false;
        } else if (this.dataSetChangeShiftedPosition) {
            this.scrollStateListener.onDataSetChangeChangedPosition();
            this.dataSetChangeShiftedPosition = false;
        }
    }

    protected void initChildDimensions(RecyclerView.Recycler recycler) {
        View measuredChildForAdapterPosition = this.recyclerViewProxy.getMeasuredChildForAdapterPosition(0, recycler);
        int measuredWidthWithMargin = this.recyclerViewProxy.getMeasuredWidthWithMargin(measuredChildForAdapterPosition);
        int measuredHeightWithMargin = this.recyclerViewProxy.getMeasuredHeightWithMargin(measuredChildForAdapterPosition);
        this.childHalfWidth = measuredWidthWithMargin / 2;
        this.childHalfHeight = measuredHeightWithMargin / 2;
        int distanceToChangeCurrent = this.orientationHelper.getDistanceToChangeCurrent(measuredWidthWithMargin, measuredHeightWithMargin);
        this.scrollToChangeCurrent = distanceToChangeCurrent;
        this.extraLayoutSpace = distanceToChangeCurrent * this.offscreenItems;
        this.recyclerViewProxy.detachAndScrapView(measuredChildForAdapterPosition, recycler);
    }

    protected void updateRecyclerDimensions(RecyclerView.State state) {
        if ((state.isMeasuring() || (this.recyclerViewProxy.getWidth() == this.viewWidth && this.recyclerViewProxy.getHeight() == this.viewHeight)) ? false : true) {
            this.viewWidth = this.recyclerViewProxy.getWidth();
            this.viewHeight = this.recyclerViewProxy.getHeight();
            this.recyclerViewProxy.removeAllViews();
        }
        this.recyclerCenter.set(this.recyclerViewProxy.getWidth() / 2, this.recyclerViewProxy.getHeight() / 2);
    }

    protected void fill(RecyclerView.Recycler recycler) {
        cacheAndDetachAttachedViews();
        this.orientationHelper.setCurrentViewCenter(this.recyclerCenter, this.scrolled, this.currentViewCenter);
        int viewEnd = this.orientationHelper.getViewEnd(this.recyclerViewProxy.getWidth(), this.recyclerViewProxy.getHeight());
        if (isViewVisible(this.currentViewCenter, viewEnd)) {
            layoutView(recycler, this.currentPosition, this.currentViewCenter);
        }
        layoutViews(recycler, Direction.START, viewEnd);
        layoutViews(recycler, Direction.END, viewEnd);
        recycleDetachedViewsAndClearCache(recycler);
    }

    private void layoutViews(RecyclerView.Recycler recycler, Direction direction, int i) {
        int iApplyTo = direction.applyTo(1);
        int i2 = this.pendingPosition;
        boolean z = i2 == -1 || !direction.sameAs(i2 - this.currentPosition);
        Point point = this.viewCenterIterator;
        Point point2 = this.currentViewCenter;
        point.set(point2.x, point2.y);
        int i3 = this.currentPosition;
        while (true) {
            i3 += iApplyTo;
            if (!isInBounds(i3)) {
                return;
            }
            if (i3 == this.pendingPosition) {
                z = true;
            }
            this.orientationHelper.shiftViewCenter(direction, this.scrollToChangeCurrent, this.viewCenterIterator);
            if (isViewVisible(this.viewCenterIterator, i)) {
                layoutView(recycler, i3, this.viewCenterIterator);
            } else if (z) {
                return;
            }
        }
    }

    protected void layoutView(RecyclerView.Recycler recycler, int i, Point point) {
        if (i < 0) {
            return;
        }
        View view = this.detachedCache.get(i);
        if (view == null) {
            View measuredChildForAdapterPosition = this.recyclerViewProxy.getMeasuredChildForAdapterPosition(i, recycler);
            RecyclerViewProxy recyclerViewProxy = this.recyclerViewProxy;
            int i2 = point.x;
            int i3 = this.childHalfWidth;
            int i4 = point.y;
            int i5 = this.childHalfHeight;
            recyclerViewProxy.layoutDecoratedWithMargins(measuredChildForAdapterPosition, i2 - i3, i4 - i5, i2 + i3, i4 + i5);
            return;
        }
        this.recyclerViewProxy.attachView(view);
        this.detachedCache.remove(i);
    }

    protected void cacheAndDetachAttachedViews() {
        this.detachedCache.clear();
        for (int i = 0; i < this.recyclerViewProxy.getChildCount(); i++) {
            View childAt = this.recyclerViewProxy.getChildAt(i);
            this.detachedCache.put(this.recyclerViewProxy.getPosition(childAt), childAt);
        }
        for (int i2 = 0; i2 < this.detachedCache.size(); i2++) {
            this.recyclerViewProxy.detachView(this.detachedCache.valueAt(i2));
        }
    }

    protected void recycleDetachedViewsAndClearCache(RecyclerView.Recycler recycler) {
        for (int i = 0; i < this.detachedCache.size(); i++) {
            this.recyclerViewProxy.recycleView(this.detachedCache.valueAt(i), recycler);
        }
        this.detachedCache.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        int iMin = this.currentPosition;
        if (iMin == -1) {
            iMin = 0;
        } else if (iMin >= i) {
            iMin = Math.min(iMin + i2, this.recyclerViewProxy.getItemCount() - 1);
        }
        onNewPosition(iMin);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        int iMax = this.currentPosition;
        if (this.recyclerViewProxy.getItemCount() == 0) {
            iMax = -1;
        } else {
            int i3 = this.currentPosition;
            if (i3 >= i) {
                if (i3 < i + i2) {
                    this.currentPosition = -1;
                }
                iMax = Math.max(0, this.currentPosition - i2);
            }
        }
        onNewPosition(iMax);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.currentPosition = Math.min(Math.max(0, this.currentPosition), this.recyclerViewProxy.getItemCount() - 1);
        this.dataSetChangeShiftedPosition = true;
    }

    private void onNewPosition(int i) {
        if (this.currentPosition != i) {
            this.currentPosition = i;
            this.dataSetChangeShiftedPosition = true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i, recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i, recycler);
    }

    protected int scrollBy(int i, RecyclerView.Recycler recycler) {
        Direction directionFromDelta;
        int iCalculateAllowedScrollIn;
        if (this.recyclerViewProxy.getChildCount() == 0 || (iCalculateAllowedScrollIn = calculateAllowedScrollIn((directionFromDelta = Direction.fromDelta(i)))) <= 0) {
            return 0;
        }
        int iApplyTo = directionFromDelta.applyTo(Math.min(iCalculateAllowedScrollIn, Math.abs(i)));
        this.scrolled += iApplyTo;
        int i2 = this.pendingScroll;
        if (i2 != 0) {
            this.pendingScroll = i2 - iApplyTo;
        }
        this.orientationHelper.offsetChildren(-iApplyTo, this.recyclerViewProxy);
        if (this.orientationHelper.hasNewBecomeVisible(this)) {
            fill(recycler);
        }
        notifyScroll();
        applyItemTransformToChildren();
        return iApplyTo;
    }

    protected void applyItemTransformToChildren() {
        if (this.itemTransformer != null) {
            int i = this.scrollToChangeCurrent * this.transformClampItemCount;
            for (int i2 = 0; i2 < this.recyclerViewProxy.getChildCount(); i2++) {
                View childAt = this.recyclerViewProxy.getChildAt(i2);
                this.itemTransformer.transformItem(childAt, getCenterRelativePositionOf(childAt, i));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        if (this.currentPosition == i) {
            return;
        }
        this.currentPosition = i;
        this.recyclerViewProxy.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        if (this.currentPosition == i || this.pendingPosition != -1) {
            return;
        }
        checkTargetPosition(state, i);
        if (this.currentPosition == -1) {
            this.currentPosition = i;
        } else {
            startSmoothPendingScroll(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.orientationHelper.canScrollHorizontally();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.orientationHelper.canScrollVertically();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        int i2 = this.currentScrollState;
        if (i2 == 0 && i2 != i) {
            this.scrollStateListener.onScrollStart();
        }
        if (i == 0) {
            if (!onScrollEnd()) {
                return;
            } else {
                this.scrollStateListener.onScrollEnd();
            }
        } else if (i == 1) {
            onDragStart();
        }
        this.currentScrollState = i;
    }

    private boolean onScrollEnd() {
        int i = this.pendingPosition;
        if (i != -1) {
            this.currentPosition = i;
            this.pendingPosition = -1;
            this.scrolled = 0;
        }
        Direction directionFromDelta = Direction.fromDelta(this.scrolled);
        if (Math.abs(this.scrolled) == this.scrollToChangeCurrent) {
            this.currentPosition += directionFromDelta.applyTo(1);
            this.scrolled = 0;
        }
        if (isAnotherItemCloserThanCurrent()) {
            this.pendingScroll = getHowMuchIsLeftToScroll(this.scrolled);
        } else {
            this.pendingScroll = -this.scrolled;
        }
        if (this.pendingScroll == 0) {
            return true;
        }
        startSmoothPendingScroll();
        return false;
    }

    private void onDragStart() {
        int iAbs = Math.abs(this.scrolled);
        int i = this.scrollToChangeCurrent;
        if (iAbs > i) {
            int i2 = this.scrolled;
            int i3 = i2 / i;
            this.currentPosition += i3;
            this.scrolled = i2 - (i3 * i);
        }
        if (isAnotherItemCloserThanCurrent()) {
            this.currentPosition += Direction.fromDelta(this.scrolled).applyTo(1);
            this.scrolled = -getHowMuchIsLeftToScroll(this.scrolled);
        }
        this.pendingPosition = -1;
        this.pendingScroll = 0;
    }

    public void onFling(int i, int i2) {
        int flingVelocity = this.orientationHelper.getFlingVelocity(i, i2);
        int iCheckNewOnFlingPositionIsInBounds = checkNewOnFlingPositionIsInBounds(this.currentPosition + Direction.fromDelta(flingVelocity).applyTo(this.shouldSlideOnFling ? Math.abs(flingVelocity / this.flingThreshold) : 1));
        if ((flingVelocity * this.scrolled >= 0) && isInBounds(iCheckNewOnFlingPositionIsInBounds)) {
            startSmoothPendingScroll(iCheckNewOnFlingPositionIsInBounds);
        } else {
            returnToCurrentPosition();
        }
    }

    public void returnToCurrentPosition() {
        int i = -this.scrolled;
        this.pendingScroll = i;
        if (i != 0) {
            startSmoothPendingScroll();
        }
    }

    protected int calculateAllowedScrollIn(Direction direction) {
        int iAbs;
        boolean z;
        int i = this.pendingScroll;
        if (i != 0) {
            return Math.abs(i);
        }
        boolean z2 = false;
        iAbs = 0;
        int iAbs2 = 0;
        z2 = false;
        boolean z3 = direction.applyTo(this.scrolled) > 0;
        if (direction == Direction.START && this.currentPosition == 0) {
            int i2 = this.scrolled;
            z = i2 == 0;
            if (!z) {
                iAbs2 = Math.abs(i2);
            }
        } else if (direction == Direction.END && this.currentPosition == this.recyclerViewProxy.getItemCount() - 1) {
            int i3 = this.scrolled;
            z = i3 == 0;
            if (!z) {
                iAbs2 = Math.abs(i3);
            }
        } else {
            if (z3) {
                iAbs = this.scrollToChangeCurrent - Math.abs(this.scrolled);
            } else {
                iAbs = this.scrollToChangeCurrent + Math.abs(this.scrolled);
            }
            this.scrollStateListener.onIsBoundReachedFlagChange(z2);
            return iAbs;
        }
        iAbs = iAbs2;
        z2 = z;
        this.scrollStateListener.onIsBoundReachedFlagChange(z2);
        return iAbs;
    }

    private void startSmoothPendingScroll() {
        DiscreteLinearSmoothScroller discreteLinearSmoothScroller = new DiscreteLinearSmoothScroller(this.context);
        discreteLinearSmoothScroller.setTargetPosition(this.currentPosition);
        this.recyclerViewProxy.startSmoothScroll(discreteLinearSmoothScroller);
    }

    private void startSmoothPendingScroll(int i) {
        int i2 = this.currentPosition;
        if (i2 == i) {
            return;
        }
        this.pendingScroll = -this.scrolled;
        this.pendingScroll += Direction.fromDelta(i - i2).applyTo(Math.abs(i - this.currentPosition) * this.scrollToChangeCurrent);
        this.pendingPosition = i;
        startSmoothPendingScroll();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        int iComputeScrollExtent = computeScrollExtent(state);
        return (this.currentPosition * iComputeScrollExtent) + ((int) ((this.scrolled / this.scrollToChangeCurrent) * iComputeScrollExtent));
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getItemCount() == 0) {
            return 0;
        }
        return (int) (computeScrollRange(state) / getItemCount());
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getItemCount() == 0) {
            return 0;
        }
        return this.scrollToChangeCurrent * (getItemCount() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.pendingPosition = -1;
        this.pendingScroll = 0;
        this.scrolled = 0;
        if (adapter2 instanceof InitialPositionProvider) {
            this.currentPosition = ((InitialPositionProvider) adapter2).getInitialPosition();
        } else {
            this.currentPosition = 0;
        }
        this.recyclerViewProxy.removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        int i = this.pendingPosition;
        if (i != -1) {
            this.currentPosition = i;
        }
        bundle.putInt("extra_position", this.currentPosition);
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        this.currentPosition = ((Bundle) parcelable).getInt("extra_position");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getNextPosition() {
        int i = this.scrolled;
        if (i == 0) {
            return this.currentPosition;
        }
        int i2 = this.pendingPosition;
        return i2 != -1 ? i2 : this.currentPosition + Direction.fromDelta(i).applyTo(1);
    }

    public void setItemTransformer(DiscreteScrollItemTransformer discreteScrollItemTransformer) {
        this.itemTransformer = discreteScrollItemTransformer;
    }

    public void setTimeForItemSettle(int i) {
        this.timeForItemSettle = i;
    }

    public void setOffscreenItems(int i) {
        this.offscreenItems = i;
        this.extraLayoutSpace = this.scrollToChangeCurrent * i;
        this.recyclerViewProxy.requestLayout();
    }

    public void setTransformClampItemCount(int i) {
        this.transformClampItemCount = i;
        applyItemTransformToChildren();
    }

    public void setOrientation(DSVOrientation dSVOrientation) {
        this.orientationHelper = dSVOrientation.createHelper();
        this.recyclerViewProxy.removeAllViews();
        this.recyclerViewProxy.requestLayout();
    }

    public void setShouldSlideOnFling(boolean z) {
        this.shouldSlideOnFling = z;
    }

    public void setSlideOnFlingThreshold(int i) {
        this.flingThreshold = i;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (this.recyclerViewProxy.getChildCount() > 0) {
            AccessibilityRecordCompat accessibilityRecordCompatAsRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            accessibilityRecordCompatAsRecord.setFromIndex(getPosition(getFirstChild()));
            accessibilityRecordCompatAsRecord.setToIndex(getPosition(getLastChild()));
        }
    }

    private float getCenterRelativePositionOf(View view, int i) {
        return Math.min(Math.max(-1.0f, this.orientationHelper.getDistanceFromCenter(this.recyclerCenter, getDecoratedLeft(view) + this.childHalfWidth, getDecoratedTop(view) + this.childHalfHeight) / i), 1.0f);
    }

    private int checkNewOnFlingPositionIsInBounds(int i) {
        int itemCount = this.recyclerViewProxy.getItemCount();
        int i2 = this.currentPosition;
        if (i2 != 0 && i < 0) {
            return 0;
        }
        int i3 = itemCount - 1;
        return (i2 == i3 || i < itemCount) ? i : i3;
    }

    private int getHowMuchIsLeftToScroll(int i) {
        return Direction.fromDelta(i).applyTo(this.scrollToChangeCurrent - Math.abs(this.scrolled));
    }

    private boolean isAnotherItemCloserThanCurrent() {
        return ((float) Math.abs(this.scrolled)) >= ((float) this.scrollToChangeCurrent) * 0.6f;
    }

    public View getFirstChild() {
        return this.recyclerViewProxy.getChildAt(0);
    }

    public View getLastChild() {
        return this.recyclerViewProxy.getChildAt(r0.getChildCount() - 1);
    }

    public int getExtraLayoutSpace() {
        return this.extraLayoutSpace;
    }

    private void notifyScroll() {
        this.scrollStateListener.onScroll(-Math.min(Math.max(-1.0f, this.scrolled / (this.pendingPosition != -1 ? Math.abs(this.scrolled + this.pendingScroll) : this.scrollToChangeCurrent)), 1.0f));
    }

    private boolean isInBounds(int i) {
        return i >= 0 && i < this.recyclerViewProxy.getItemCount();
    }

    private boolean isViewVisible(Point point, int i) {
        return this.orientationHelper.isViewVisible(point, this.childHalfWidth, this.childHalfHeight, i, this.extraLayoutSpace);
    }

    private void checkTargetPosition(RecyclerView.State state, int i) {
        if (i < 0 || i >= state.getItemCount()) {
            throw new IllegalArgumentException(String.format(Locale.US, "target position out of bounds: position=%d, itemCount=%d", Integer.valueOf(i), Integer.valueOf(state.getItemCount())));
        }
    }

    private class DiscreteLinearSmoothScroller extends LinearSmoothScroller {
        public DiscreteLinearSmoothScroller(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(View view, int i) {
            return DiscreteScrollLayoutManager.this.orientationHelper.getPendingDx(-DiscreteScrollLayoutManager.this.pendingScroll);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDyToMakeVisible(View view, int i) {
            return DiscreteScrollLayoutManager.this.orientationHelper.getPendingDy(-DiscreteScrollLayoutManager.this.pendingScroll);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected int calculateTimeForScrolling(int i) {
            return (int) (Math.max(0.01f, Math.min(Math.abs(i), DiscreteScrollLayoutManager.this.scrollToChangeCurrent) / DiscreteScrollLayoutManager.this.scrollToChangeCurrent) * DiscreteScrollLayoutManager.this.timeForItemSettle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int i) {
            return new PointF(DiscreteScrollLayoutManager.this.orientationHelper.getPendingDx(DiscreteScrollLayoutManager.this.pendingScroll), DiscreteScrollLayoutManager.this.orientationHelper.getPendingDy(DiscreteScrollLayoutManager.this.pendingScroll));
        }
    }
}
