package ir.resaneh1.iptv.fragment.home.parallax;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes3.dex */
public class AutoScrollRecyclerView extends RecyclerView {
    private boolean isStopAutoScroll;
    private int mCurrentSpeed;
    private boolean mInflate;
    private UniformSpeedInterpolator mInterpolator;
    private boolean mIsOpenAuto;
    private boolean mLoopEnabled;
    private boolean mPointTouch;
    private boolean mReady;
    private boolean mReverse;
    private int mSpeedDx;
    private int mSpeedDy;
    ParallaxClickListener parallaxClickListener;

    private void notifyLayoutManager() {
    }

    public void setCanTouch(boolean z) {
    }

    public AutoScrollRecyclerView(Context context) {
        this(context, null);
    }

    public AutoScrollRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoScrollRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentSpeed = 30;
        this.isStopAutoScroll = false;
        this.mInterpolator = new UniformSpeedInterpolator();
        this.mReady = false;
    }

    public void startAutoScroll() {
        this.isStopAutoScroll = false;
        openAutoScroll(this.mCurrentSpeed, this.mReverse);
    }

    public void openAutoScroll(int i, boolean z) {
        this.mReverse = z;
        this.mCurrentSpeed = i;
        this.mIsOpenAuto = true;
        notifyLayoutManager();
        startScroll();
    }

    public void setLoopEnabled(boolean z) {
        this.mLoopEnabled = z;
        if (getAdapter() != null) {
            getAdapter().notifyDataSetChanged();
            startScroll();
        }
    }

    public void setReverse(boolean z) {
        this.mReverse = z;
        notifyLayoutManager();
        startScroll();
    }

    public void pauseAutoScroll(boolean z) {
        this.isStopAutoScroll = z;
    }

    public boolean getReverse() {
        return this.mReverse;
    }

    private void startScroll() {
        if (this.mIsOpenAuto && getScrollState() != 2 && this.mInflate && this.mReady) {
            this.mSpeedDy = 0;
            this.mSpeedDx = 0;
            smoothScroll();
        }
    }

    private void smoothScroll() {
        if (this.isStopAutoScroll) {
            return;
        }
        int iAbs = Math.abs(this.mCurrentSpeed);
        if (this.mReverse) {
            iAbs = -iAbs;
        }
        smoothScrollBy(iAbs, iAbs, this.mInterpolator);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(generateAdapter(adapter));
        this.mReady = true;
    }

    public void setParallaxClickListener(ParallaxClickListener parallaxClickListener) {
        this.parallaxClickListener = parallaxClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.mPointTouch = true;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if ((action == 1 || action == 3) && this.mIsOpenAuto) {
            this.mPointTouch = false;
            smoothScroll();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        startScroll();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mInflate = true;
    }

    public void recyclerIsAddedProgrammatically() {
        this.mInflate = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i, int i2) {
        boolean z;
        if (this.mPointTouch) {
            this.mSpeedDx = 0;
            this.mSpeedDy = 0;
            return;
        }
        if (i == 0) {
            this.mSpeedDy += i2;
            z = true;
        } else {
            this.mSpeedDx += i;
            z = false;
        }
        if (z) {
            if (Math.abs(this.mSpeedDy) >= Math.abs(this.mCurrentSpeed)) {
                this.mSpeedDy = 0;
                smoothScroll();
                return;
            }
            return;
        }
        if (Math.abs(this.mSpeedDx) >= Math.abs(this.mCurrentSpeed)) {
            this.mSpeedDx = 0;
            smoothScroll();
        }
    }

    private NestingRecyclerViewAdapter generateAdapter(RecyclerView.Adapter adapter) {
        return new NestingRecyclerViewAdapter(this, adapter);
    }

    private static class UniformSpeedInterpolator implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f;
        }

        private UniformSpeedInterpolator() {
        }
    }

    private static class NestingRecyclerViewAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
        RecyclerView.Adapter<VH> mAdapter;
        private AutoScrollRecyclerView mRecyclerView;

        NestingRecyclerViewAdapter(AutoScrollRecyclerView autoScrollRecyclerView, RecyclerView.Adapter<VH> adapter) {
            this.mAdapter = adapter;
            this.mRecyclerView = autoScrollRecyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
            return (VH) this.mAdapter.onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
            super.registerAdapterDataObserver(adapterDataObserver);
            this.mAdapter.registerAdapterDataObserver(adapterDataObserver);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
            super.unregisterAdapterDataObserver(adapterDataObserver);
            this.mAdapter.unregisterAdapterDataObserver(adapterDataObserver);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(VH vh, int i) {
            this.mAdapter.onBindViewHolder(vh, generatePosition(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return getLoopEnable() ? ConnectionsManager.DEFAULT_DATACENTER_ID : this.mAdapter.getItemCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.mAdapter.getItemViewType(generatePosition(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return this.mAdapter.getItemId(generatePosition(i));
        }

        private int generatePosition(int i) {
            return getLoopEnable() ? getActualPosition(i) : i;
        }

        private int getActualPosition(int i) {
            int itemCount = this.mAdapter.getItemCount();
            return (i < itemCount || itemCount <= 0) ? i : i % itemCount;
        }

        private boolean getLoopEnable() {
            return this.mRecyclerView.mLoopEnabled;
        }
    }
}
