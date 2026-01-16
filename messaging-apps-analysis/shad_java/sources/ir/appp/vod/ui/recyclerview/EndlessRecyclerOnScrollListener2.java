package ir.appp.vod.ui.recyclerview;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EndlessRecyclerOnScrollListener2.kt */
/* loaded from: classes3.dex */
public abstract class EndlessRecyclerOnScrollListener2 extends RecyclerView.OnScrollListener {
    private int currentPage;
    private boolean needCancel;
    private int previousItemCount;
    private long totalPages;
    private boolean loading = true;
    private int offsetToLoadMore = 3;

    public abstract void onLoadMore(int i);

    public final void setTotalPages(long j) {
        this.totalPages = j;
    }

    public final void cancel() {
        this.needCancel = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) throws Exception {
        LinearLayoutManager linearLayoutManager;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                throw new Exception("unknown layout manager");
            }
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            if (layoutManager2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            }
            linearLayoutManager = (GridLayoutManager) layoutManager2;
        }
        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter);
        int itemCount = adapter.getItemCount();
        if (iFindLastVisibleItemPosition >= (itemCount - 2) - this.offsetToLoadMore && !this.loading) {
            int i3 = this.currentPage;
            if (i3 < this.totalPages) {
                int i4 = i3 + 1;
                this.currentPage = i4;
                onLoadMore(i4);
                this.loading = true;
            }
        }
        if (itemCount > this.previousItemCount) {
            this.previousItemCount = itemCount;
            this.loading = false;
        }
        if (!this.needCancel || iFindLastVisibleItemPosition - 2 > 0) {
            return;
        }
        this.loading = false;
        this.needCancel = false;
    }
}
