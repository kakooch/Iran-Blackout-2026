package org.rbmain.ui.Components;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public class FillLastLinearLayoutManager extends LinearLayoutManager {
    private int additionalHeight;
    private boolean bind;
    private boolean canScrollVertically;
    private SparseArray<RecyclerView.ViewHolder> heights;
    private int lastItemHeight;
    private int listHeight;
    private RecyclerView listView;
    private int listWidth;
    private boolean skipFirstItem;

    public FillLastLinearLayoutManager(Context context, int i, boolean z, int i2, RecyclerView recyclerView) {
        super(context, i, z);
        this.heights = new SparseArray<>();
        this.lastItemHeight = -1;
        this.bind = true;
        this.canScrollVertically = true;
        this.listView = recyclerView;
        this.additionalHeight = i2;
    }

    public void setSkipFirstItem() {
        this.skipFirstItem = true;
    }

    public void setBind(boolean z) {
        this.bind = z;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.canScrollVertically;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void calcLastItemHeight() {
        RecyclerView.Adapter adapter;
        if (this.listHeight > 0 && (adapter = this.listView.getAdapter()) != null) {
            int itemCount = adapter.getItemCount() - 1;
            int measuredHeight = 0;
            for (int i = this.skipFirstItem; i < itemCount; i++) {
                int itemViewType = adapter.getItemViewType(i);
                RecyclerView.ViewHolder viewHolderCreateViewHolder = this.heights.get(itemViewType, null);
                if (viewHolderCreateViewHolder == null) {
                    viewHolderCreateViewHolder = adapter.createViewHolder(this.listView, itemViewType);
                    this.heights.put(itemViewType, viewHolderCreateViewHolder);
                    if (viewHolderCreateViewHolder.itemView.getLayoutParams() == null) {
                        viewHolderCreateViewHolder.itemView.setLayoutParams(generateDefaultLayoutParams());
                    }
                }
                if (this.bind) {
                    adapter.onBindViewHolder(viewHolderCreateViewHolder, i);
                }
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolderCreateViewHolder.itemView.getLayoutParams();
                viewHolderCreateViewHolder.itemView.measure(RecyclerView.LayoutManager.getChildMeasureSpec(this.listWidth, getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally()), RecyclerView.LayoutManager.getChildMeasureSpec(this.listHeight, getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically()));
                measuredHeight += viewHolderCreateViewHolder.itemView.getMeasuredHeight();
                if (measuredHeight >= this.listHeight) {
                    break;
                }
            }
            this.lastItemHeight = Math.max(0, ((this.listHeight - measuredHeight) - this.additionalHeight) - this.listView.getPaddingBottom());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        int i3 = this.listHeight;
        this.listWidth = View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        this.listHeight = size;
        if (i3 != size) {
            calcLastItemHeight();
        }
        super.onMeasure(recycler, state, i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.heights.clear();
        calcLastItemHeight();
        super.onAdapterChanged(adapter, adapter2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.heights.clear();
        calcLastItemHeight();
        super.onItemsChanged(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        calcLastItemHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        calcLastItemHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        calcLastItemHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        calcLastItemHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        calcLastItemHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(View view, int i, int i2) {
        if (this.listView.findContainingViewHolder(view).getAdapterPosition() == getItemCount() - 1) {
            ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).height = Math.max(this.lastItemHeight, 0);
        }
        super.measureChildWithMargins(view, 0, 0);
    }
}
