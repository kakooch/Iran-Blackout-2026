package ir.resaneh1.iptv.helper;

import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.logger.MyLog;

/* loaded from: classes3.dex */
public class CubeLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnabled;
    private final float mShrinkAmount;

    public CubeLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        this.mShrinkAmount = ((float) Math.sqrt(2.0d)) / 2.0f;
        this.isScrollEnabled = true;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(this, recyclerView.getContext()) { // from class: ir.resaneh1.iptv.helper.CubeLayoutManager.1
            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i2) {
                return super.computeScrollVectorForPosition(i2);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 55.0f / displayMetrics.densityDpi;
            }
        };
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getOrientation() != 0) {
            return 0;
        }
        int iScrollHorizontallyBy = super.scrollHorizontallyBy(i, recycler, state);
        float width = getWidth() / 2.0f;
        float width2 = getWidth();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            float decoratedRight = (getDecoratedRight(childAt) + getDecoratedLeft(childAt)) / 2.0f;
            Math.min(width * 2.0f, Math.abs(width - decoratedRight));
            MyLog.e("testLinearLayout", "size " + (childAt.getWidth() / childAt.getHeight()));
            if (Build.VERSION.SDK_INT < 17) {
                childAt.setPivotY(childAt.getHeight() / 2);
            }
            float f = (decoratedRight - width) / width2;
            if (f < -1.0f) {
                childAt.setAlpha(0.0f);
            } else if (f <= 0.0f) {
                childAt.setAlpha(1.0f);
                childAt.setPivotX(childAt.getWidth());
                childAt.setRotationY((((float) Math.pow(Math.abs(f), 1.7d)) * (-90.0f)) / 1.2f);
            } else if (f <= 1.0f) {
                childAt.setAlpha(1.0f);
                childAt.setPivotX(0.0f);
                childAt.setRotationY((((float) Math.pow(f, 1.7d)) * 90.0f) / 1.2f);
            } else {
                childAt.setAlpha(0.0f);
            }
            MyLog.e("testLinearLayout", f + BuildConfig.FLAVOR);
        }
        MyLog.e("cubeLayoutManager", "scrolled " + iScrollHorizontallyBy);
        return iScrollHorizontallyBy;
    }

    public void setScrollEnabled(boolean z) {
        this.isScrollEnabled = z;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return super.canScrollHorizontally() && this.isScrollEnabled;
    }
}
