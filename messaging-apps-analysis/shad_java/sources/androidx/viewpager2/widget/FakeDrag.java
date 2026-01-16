package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
final class FakeDrag {
    private final ScrollEventAdapter mScrollEventAdapter;

    FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.mScrollEventAdapter = scrollEventAdapter;
    }

    boolean isFakeDragging() {
        return this.mScrollEventAdapter.isFakeDragging();
    }
}
