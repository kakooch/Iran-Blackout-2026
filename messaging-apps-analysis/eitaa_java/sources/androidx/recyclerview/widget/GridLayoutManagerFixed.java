package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GridLayoutManagerFixed extends GridLayoutManager {
    private ArrayList<View> additionalViews;
    private boolean canScrollVertically;

    protected boolean hasSiblingChild(int position) {
        throw null;
    }

    public boolean shouldLayoutChildFromOpositeSide(View child) {
        throw null;
    }

    public GridLayoutManagerFixed(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
        this.additionalViews = new ArrayList<>(4);
        this.canScrollVertically = true;
    }

    public void setCanScrollVertically(boolean value) {
        this.canScrollVertically = value;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.canScrollVertically;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    protected void recycleViewsFromStart(RecyclerView.Recycler recycler, int scrollingOffset, int noRecycleSpace) {
        if (scrollingOffset < 0) {
            return;
        }
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (this.mOrientationHelper.getDecoratedEnd(childAt) > scrollingOffset || this.mOrientationHelper.getTransformedEndWithDecoration(childAt) > scrollingOffset) {
                    recycleChildren(recycler, 0, i);
                    return;
                }
            }
            return;
        }
        int i2 = childCount - 1;
        for (int i3 = i2; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            if (childAt2.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt2.getLayoutParams())).bottomMargin > scrollingOffset || childAt2.getTop() + childAt2.getHeight() > scrollingOffset) {
                recycleChildren(recycler, i2, i3);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager
    protected int[] calculateItemBorders(int[] cachedBorders, int spanCount, int totalSpace) {
        if (cachedBorders == null || cachedBorders.length != spanCount + 1 || cachedBorders[cachedBorders.length - 1] != totalSpace) {
            cachedBorders = new int[spanCount + 1];
        }
        cachedBorders[0] = 0;
        for (int i = 1; i <= spanCount; i++) {
            cachedBorders[i] = (int) Math.ceil((i / spanCount) * totalSpace);
        }
        return cachedBorders;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager
    protected void measureChild(View view, int otherDirParentSpecMode, boolean alreadyMeasured) {
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(this.mCachedBorders[layoutParams.mSpanSize], otherDirParentSpecMode, rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i, ((ViewGroup.MarginLayoutParams) layoutParams).height, true), alreadyMeasured);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018f A[PHI: r2
      0x018f: PHI (r2v15 int) = (r2v1 int), (r2v26 int) binds: [B:81:0x018d, B:76:0x0184] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v5 */
    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void layoutChunk(androidx.recyclerview.widget.RecyclerView.Recycler r25, androidx.recyclerview.widget.RecyclerView.State r26, androidx.recyclerview.widget.LinearLayoutManager.LayoutState r27, androidx.recyclerview.widget.LinearLayoutManager.LayoutChunkResult r28) {
        /*
            Method dump skipped, instructions count: 663
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManagerFixed.layoutChunk(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, androidx.recyclerview.widget.LinearLayoutManager$LayoutState, androidx.recyclerview.widget.LinearLayoutManager$LayoutChunkResult):void");
    }
}
