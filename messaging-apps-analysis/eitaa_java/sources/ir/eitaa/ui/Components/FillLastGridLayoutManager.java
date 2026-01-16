package ir.eitaa.ui.Components;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class FillLastGridLayoutManager extends GridLayoutManager {
    private int additionalHeight;
    private boolean bind;
    private boolean canScrollVertically;
    private SparseArray<RecyclerView.ViewHolder> heights;
    protected int lastItemHeight;
    private int listHeight;
    private RecyclerView listView;
    private int listWidth;

    protected boolean shouldCalcLastItemHeight() {
        return true;
    }

    public void setBind(boolean bind) {
        this.bind = bind;
    }

    public FillLastGridLayoutManager(Context context, int spanCount, int h, RecyclerView recyclerView) {
        super(context, spanCount);
        this.heights = new SparseArray<>();
        this.lastItemHeight = -1;
        this.bind = true;
        this.canScrollVertically = true;
        this.listView = recyclerView;
        this.additionalHeight = h;
    }

    public FillLastGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout, int h, RecyclerView recyclerView) {
        super(context, spanCount, orientation, reverseLayout);
        this.heights = new SparseArray<>();
        this.lastItemHeight = -1;
        this.bind = true;
        this.canScrollVertically = true;
        this.listView = recyclerView;
        this.additionalHeight = h;
    }

    protected void calcLastItemHeight() {
        RecyclerView.Adapter adapter;
        if (this.listHeight <= 0 || !shouldCalcLastItemHeight() || (adapter = this.listView.getAdapter()) == null) {
            return;
        }
        int spanCount = getSpanCount();
        int itemCount = adapter.getItemCount() - 1;
        GridLayoutManager.SpanSizeLookup spanSizeLookup = getSpanSizeLookup();
        int i = 0;
        boolean z = true;
        int measuredHeight = 0;
        for (int i2 = 0; i2 < itemCount; i2++) {
            int spanSize = spanSizeLookup.getSpanSize(i2);
            i += spanSize;
            if (spanSize == spanCount || i > spanCount) {
                i = spanSize;
                z = true;
            }
            if (z) {
                int itemViewType = adapter.getItemViewType(i2);
                RecyclerView.ViewHolder viewHolderCreateViewHolder = this.heights.get(itemViewType, null);
                if (viewHolderCreateViewHolder == null) {
                    viewHolderCreateViewHolder = adapter.createViewHolder(this.listView, itemViewType);
                    this.heights.put(itemViewType, viewHolderCreateViewHolder);
                    if (viewHolderCreateViewHolder.itemView.getLayoutParams() == null) {
                        viewHolderCreateViewHolder.itemView.setLayoutParams(generateDefaultLayoutParams());
                    }
                }
                if (this.bind) {
                    adapter.onBindViewHolder(viewHolderCreateViewHolder, i2);
                }
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolderCreateViewHolder.itemView.getLayoutParams();
                viewHolderCreateViewHolder.itemView.measure(RecyclerView.LayoutManager.getChildMeasureSpec(this.listWidth, getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally()), RecyclerView.LayoutManager.getChildMeasureSpec(this.listHeight, getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically()));
                measuredHeight += viewHolderCreateViewHolder.itemView.getMeasuredHeight();
                if (measuredHeight >= (this.listHeight - this.additionalHeight) - this.listView.getPaddingBottom()) {
                    break;
                } else {
                    z = false;
                }
            }
        }
        this.lastItemHeight = Math.max(0, ((this.listHeight - measuredHeight) - this.additionalHeight) - this.listView.getPaddingBottom());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
        int i = this.listHeight;
        this.listWidth = View.MeasureSpec.getSize(widthSpec);
        int size = View.MeasureSpec.getSize(heightSpec);
        this.listHeight = size;
        if (i != size) {
            calcLastItemHeight();
        }
        super.onMeasure(recycler, state, widthSpec, heightSpec);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter oldAdapter, RecyclerView.Adapter newAdapter) {
        this.heights.clear();
        calcLastItemHeight();
        super.onAdapterChanged(oldAdapter, newAdapter);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.heights.clear();
        calcLastItemHeight();
        super.onItemsChanged(recyclerView);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsAdded(recyclerView, positionStart, itemCount);
        calcLastItemHeight();
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsRemoved(recyclerView, positionStart, itemCount);
        calcLastItemHeight();
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int from, int to, int itemCount) {
        super.onItemsMoved(recyclerView, from, to, itemCount);
        calcLastItemHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsUpdated(recyclerView, positionStart, itemCount);
        calcLastItemHeight();
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int positionStart, int itemCount, Object payload) {
        super.onItemsUpdated(recyclerView, positionStart, itemCount, payload);
        calcLastItemHeight();
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager
    protected void measureChild(View view, int otherDirParentSpecMode, boolean alreadyMeasured) {
        if (this.listView.findContainingViewHolder(view).getAdapterPosition() == getItemCount() - 1) {
            ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).height = Math.max(this.lastItemHeight, 0);
        }
        super.measureChild(view, otherDirParentSpecMode, alreadyMeasured);
    }

    public void setCanScrollVertically(boolean value) {
        this.canScrollVertically = value;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.canScrollVertically;
    }
}
