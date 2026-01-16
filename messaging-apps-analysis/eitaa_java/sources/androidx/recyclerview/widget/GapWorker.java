package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal<>();
    static Comparator<Task> sTaskComparator = new AnonymousClass1();
    long mFrameIntervalNs;
    long mPostTimeNs;
    ArrayList<RecyclerView> mRecyclerViews = new ArrayList<>();
    private ArrayList<Task> mTasks = new ArrayList<>();

    GapWorker() {
    }

    static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        Task() {
        }

        public void clear() {
            this.immediate = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }
    }

    @SuppressLint({"VisibleForTests"})
    static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        int mCount;
        int[] mPrefetchArray;
        int mPrefetchDx;
        int mPrefetchDy;

        LayoutPrefetchRegistryImpl() {
        }

        void setPrefetchVector(int dx, int dy) {
            this.mPrefetchDx = dx;
            this.mPrefetchDy = dy;
        }

        void collectPrefetchPositionsFromView(RecyclerView view, boolean nested) {
            this.mCount = 0;
            int[] iArr = this.mPrefetchArray;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = view.mLayout;
            if (view.mAdapter == null || layoutManager == null || !layoutManager.isItemPrefetchEnabled()) {
                return;
            }
            if (nested) {
                if (!view.mAdapterHelper.hasPendingUpdates()) {
                    layoutManager.collectInitialPrefetchPositions(view.mAdapter.getItemCount(), this);
                }
            } else if (!view.hasPendingAdapterUpdates()) {
                layoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, view.mState, this);
            }
            int i = this.mCount;
            if (i > layoutManager.mPrefetchMaxCountObserved) {
                layoutManager.mPrefetchMaxCountObserved = i;
                layoutManager.mPrefetchMaxObservedInInitialPrefetch = nested;
                view.mRecycler.updateViewCacheSize();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int layoutPosition, int pixelDistance) {
            if (layoutPosition < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (pixelDistance < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i = this.mCount * 2;
            int[] iArr = this.mPrefetchArray;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.mPrefetchArray = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[i * 2];
                this.mPrefetchArray = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.mPrefetchArray;
            iArr4[i] = layoutPosition;
            iArr4[i + 1] = pixelDistance;
            this.mCount++;
        }

        boolean lastPrefetchIncludedPosition(int position) {
            if (this.mPrefetchArray != null) {
                int i = this.mCount * 2;
                for (int i2 = 0; i2 < i; i2 += 2) {
                    if (this.mPrefetchArray[i2] == position) {
                        return true;
                    }
                }
            }
            return false;
        }

        void clearPrefetchPositions() {
            int[] iArr = this.mPrefetchArray;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.mCount = 0;
        }
    }

    public void add(RecyclerView recyclerView) {
        this.mRecyclerViews.add(recyclerView);
    }

    public void remove(RecyclerView recyclerView) {
        this.mRecyclerViews.remove(recyclerView);
    }

    void postFromTraversal(RecyclerView recyclerView, int prefetchDx, int prefetchDy) {
        if (recyclerView.isAttachedToWindow() && this.mPostTimeNs == 0) {
            this.mPostTimeNs = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.setPrefetchVector(prefetchDx, prefetchDy);
    }

    /* renamed from: androidx.recyclerview.widget.GapWorker$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<Task>, j$.util.Comparator {
        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return a.E(this, Comparator.CC.comparing(function));
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        AnonymousClass1() {
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(Task lhs, Task rhs) {
            RecyclerView recyclerView = lhs.view;
            if ((recyclerView == null) != (rhs.view == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = lhs.immediate;
            if (z != rhs.immediate) {
                return z ? -1 : 1;
            }
            int i = rhs.viewVelocity - lhs.viewVelocity;
            if (i != 0) {
                return i;
            }
            int i2 = lhs.distanceToItem - rhs.distanceToItem;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    }

    private void buildTaskList() {
        Task task;
        int size = this.mRecyclerViews.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.mRecyclerViews.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.collectPrefetchPositionsFromView(recyclerView, false);
                i += recyclerView.mPrefetchRegistry.mCount;
            }
        }
        this.mTasks.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.mRecyclerViews.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.mPrefetchRegistry;
                int iAbs = Math.abs(layoutPrefetchRegistryImpl.mPrefetchDx) + Math.abs(layoutPrefetchRegistryImpl.mPrefetchDy);
                for (int i5 = 0; i5 < layoutPrefetchRegistryImpl.mCount * 2; i5 += 2) {
                    if (i3 >= this.mTasks.size()) {
                        task = new Task();
                        this.mTasks.add(task);
                    } else {
                        task = this.mTasks.get(i3);
                    }
                    int[] iArr = layoutPrefetchRegistryImpl.mPrefetchArray;
                    int i6 = iArr[i5 + 1];
                    task.immediate = i6 <= iAbs;
                    task.viewVelocity = iAbs;
                    task.distanceToItem = i6;
                    task.view = recyclerView2;
                    task.position = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.mTasks, sTaskComparator);
    }

    static boolean isPrefetchPositionAttached(RecyclerView view, int position) {
        int unfilteredChildCount = view.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view.mChildHelper.getUnfilteredChildAt(i));
            if (childViewHolderInt.mPosition == position && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView view, int position, long deadlineNs) {
        if (isPrefetchPositionAttached(view, position)) {
            return null;
        }
        RecyclerView.Recycler recycler = view.mRecycler;
        try {
            view.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder viewHolderTryGetViewHolderForPositionByDeadline = recycler.tryGetViewHolderForPositionByDeadline(position, false, deadlineNs);
            if (viewHolderTryGetViewHolderForPositionByDeadline != null) {
                if (viewHolderTryGetViewHolderForPositionByDeadline.isBound() && !viewHolderTryGetViewHolderForPositionByDeadline.isInvalid()) {
                    recycler.recycleView(viewHolderTryGetViewHolderForPositionByDeadline.itemView);
                } else {
                    recycler.addViewHolderToRecycledViewPool(viewHolderTryGetViewHolderForPositionByDeadline, false);
                }
            }
            return viewHolderTryGetViewHolderForPositionByDeadline;
        } finally {
            view.onExitLayoutOrScroll(false);
        }
    }

    private void prefetchInnerRecyclerViewWithDeadline(RecyclerView innerView, long deadlineNs) {
        if (innerView == null) {
            return;
        }
        if (innerView.mDataSetHasChangedAfterLayout && innerView.mChildHelper.getUnfilteredChildCount() != 0) {
            innerView.removeAndRecycleViews();
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = innerView.mPrefetchRegistry;
        layoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(innerView, true);
        if (layoutPrefetchRegistryImpl.mCount != 0) {
            try {
                TraceCompat.beginSection("RV Nested Prefetch");
                innerView.mState.prepareForNestedPrefetch(innerView.mAdapter);
                for (int i = 0; i < layoutPrefetchRegistryImpl.mCount * 2; i += 2) {
                    prefetchPositionWithDeadline(innerView, layoutPrefetchRegistryImpl.mPrefetchArray[i], deadlineNs);
                }
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    private void flushTaskWithDeadline(Task task, long deadlineNs) {
        RecyclerView.ViewHolder viewHolderPrefetchPositionWithDeadline = prefetchPositionWithDeadline(task.view, task.position, task.immediate ? Long.MAX_VALUE : deadlineNs);
        if (viewHolderPrefetchPositionWithDeadline == null || viewHolderPrefetchPositionWithDeadline.mNestedRecyclerView == null || !viewHolderPrefetchPositionWithDeadline.isBound() || viewHolderPrefetchPositionWithDeadline.isInvalid()) {
            return;
        }
        prefetchInnerRecyclerViewWithDeadline(viewHolderPrefetchPositionWithDeadline.mNestedRecyclerView.get(), deadlineNs);
    }

    private void flushTasksWithDeadline(long deadlineNs) {
        for (int i = 0; i < this.mTasks.size(); i++) {
            Task task = this.mTasks.get(i);
            if (task.view == null) {
                return;
            }
            flushTaskWithDeadline(task, deadlineNs);
            task.clear();
        }
    }

    void prefetch(long deadlineNs) {
        buildTaskList();
        flushTasksWithDeadline(deadlineNs);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (!this.mRecyclerViews.isEmpty()) {
                int size = this.mRecyclerViews.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.mRecyclerViews.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    prefetch(TimeUnit.MILLISECONDS.toNanos(jMax) + this.mFrameIntervalNs);
                }
            }
        } finally {
            this.mPostTimeNs = 0L;
            TraceCompat.endSection();
        }
    }
}
