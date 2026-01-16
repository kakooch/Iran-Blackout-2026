package ir.resaneh1.iptv.helper;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class CenterZoomLayoutManager extends LinearLayoutManager {
    public CenterZoomLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        CenterZoomSmoothScroller centerZoomSmoothScroller = new CenterZoomSmoothScroller(recyclerView.getContext());
        centerZoomSmoothScroller.setTargetPosition(i);
        startSmoothScroll(centerZoomSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getOrientation() != 1) {
            return 0;
        }
        int iScrollVerticallyBy = super.scrollVerticallyBy(i, recycler, state);
        float height = getHeight() / 2.0f;
        float f = 0.95f * height;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            float fMin = (((-0.25f) * (Math.min(f, Math.abs(height - ((getDecoratedBottom(childAt) + getDecoratedTop(childAt)) / 2.0f))) - 0.0f)) / (f - 0.0f)) + 1.0f;
            childAt.setScaleX(fMin);
            childAt.setScaleY(fMin);
        }
        return iScrollVerticallyBy;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getOrientation() != 0) {
            return 0;
        }
        int iScrollHorizontallyBy = super.scrollHorizontallyBy(i, recycler, state);
        float width = getWidth() / 2.0f;
        float f = 0.95f * width;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            float fMin = (((-0.25f) * (Math.min(f, Math.abs(width - ((getDecoratedRight(childAt) + getDecoratedLeft(childAt)) / 2.0f))) - 0.0f)) / (f - 0.0f)) + 1.0f;
            childAt.setScaleX(fMin);
            childAt.setScaleY(fMin);
        }
        return iScrollHorizontallyBy;
    }
}
