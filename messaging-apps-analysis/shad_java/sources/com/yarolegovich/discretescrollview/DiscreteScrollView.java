package com.yarolegovich.discretescrollview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager;
import com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class DiscreteScrollView extends RecyclerView {
    private static final int DEFAULT_ORIENTATION = DSVOrientation.HORIZONTAL.ordinal();
    private boolean isOverScrollEnabled;
    private DiscreteScrollLayoutManager layoutManager;
    private List<OnItemChangedListener> onItemChangedListeners;
    private List<ScrollStateChangeListener> scrollStateChangeListeners;

    public interface OnItemChangedListener<T extends RecyclerView.ViewHolder> {
        void onCurrentItemChanged(T t, int i);
    }

    public interface ScrollStateChangeListener<T extends RecyclerView.ViewHolder> {
        void onScroll(float f, int i, int i2, T t, T t2);

        void onScrollEnd(T t, int i);

        void onScrollStart(T t, int i);
    }

    public DiscreteScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        this.scrollStateChangeListeners = new ArrayList();
        this.onItemChangedListeners = new ArrayList();
        int i = DEFAULT_ORIENTATION;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.DiscreteScrollView);
            i = typedArrayObtainStyledAttributes.getInt(R$styleable.DiscreteScrollView_dsv_orientation, i);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.isOverScrollEnabled = getOverScrollMode() != 2;
        DiscreteScrollLayoutManager discreteScrollLayoutManager = new DiscreteScrollLayoutManager(getContext(), new ScrollStateListener(), DSVOrientation.values()[i]);
        this.layoutManager = discreteScrollLayoutManager;
        setLayoutManager(discreteScrollLayoutManager);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof DiscreteScrollLayoutManager) {
            super.setLayoutManager(layoutManager);
            return;
        }
        throw new IllegalArgumentException(getContext().getString(R$string.dsv_ex_msg_dont_set_lm));
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i, int i2) {
        boolean zFling = super.fling(i, i2);
        if (zFling) {
            this.layoutManager.onFling(i, i2);
        } else {
            this.layoutManager.returnToCurrentPosition();
        }
        return zFling;
    }

    public RecyclerView.ViewHolder getViewHolder(int i) {
        View viewFindViewByPosition = this.layoutManager.findViewByPosition(i);
        if (viewFindViewByPosition != null) {
            return getChildViewHolder(viewFindViewByPosition);
        }
        return null;
    }

    public int getCurrentItem() {
        return this.layoutManager.getCurrentPosition();
    }

    public void setItemTransformer(DiscreteScrollItemTransformer discreteScrollItemTransformer) {
        this.layoutManager.setItemTransformer(discreteScrollItemTransformer);
    }

    public void setItemTransitionTimeMillis(int i) {
        this.layoutManager.setTimeForItemSettle(i);
    }

    public void setSlideOnFling(boolean z) {
        this.layoutManager.setShouldSlideOnFling(z);
    }

    public void setSlideOnFlingThreshold(int i) {
        this.layoutManager.setSlideOnFlingThreshold(i);
    }

    public void setOrientation(DSVOrientation dSVOrientation) {
        this.layoutManager.setOrientation(dSVOrientation);
    }

    public void setOffscreenItems(int i) {
        this.layoutManager.setOffscreenItems(i);
    }

    public void setClampTransformProgressAfter(int i) {
        if (i <= 1) {
            throw new IllegalArgumentException("must be >= 1");
        }
        this.layoutManager.setTransformClampItemCount(i);
    }

    public void setOverScrollEnabled(boolean z) {
        this.isOverScrollEnabled = z;
        setOverScrollMode(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyScrollStart(RecyclerView.ViewHolder viewHolder, int i) {
        Iterator<ScrollStateChangeListener> it = this.scrollStateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollStart(viewHolder, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyScrollEnd(RecyclerView.ViewHolder viewHolder, int i) {
        Iterator<ScrollStateChangeListener> it = this.scrollStateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollEnd(viewHolder, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyScroll(float f, int i, int i2, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        Iterator<ScrollStateChangeListener> it = this.scrollStateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onScroll(f, i, i2, viewHolder, viewHolder2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCurrentItemChanged(RecyclerView.ViewHolder viewHolder, int i) {
        Iterator<OnItemChangedListener> it = this.onItemChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onCurrentItemChanged(viewHolder, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCurrentItemChanged() {
        if (this.onItemChangedListeners.isEmpty()) {
            return;
        }
        int currentPosition = this.layoutManager.getCurrentPosition();
        notifyCurrentItemChanged(getViewHolder(currentPosition), currentPosition);
    }

    private class ScrollStateListener implements DiscreteScrollLayoutManager.ScrollStateListener {
        private ScrollStateListener() {
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public void onIsBoundReachedFlagChange(boolean z) {
            if (DiscreteScrollView.this.isOverScrollEnabled) {
                DiscreteScrollView.this.setOverScrollMode(z ? 0 : 2);
            }
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public void onScrollStart() {
            int currentPosition;
            RecyclerView.ViewHolder viewHolder;
            if (DiscreteScrollView.this.scrollStateChangeListeners.isEmpty() || (viewHolder = DiscreteScrollView.this.getViewHolder((currentPosition = DiscreteScrollView.this.layoutManager.getCurrentPosition()))) == null) {
                return;
            }
            DiscreteScrollView.this.notifyScrollStart(viewHolder, currentPosition);
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public void onScrollEnd() {
            int currentPosition;
            RecyclerView.ViewHolder viewHolder;
            if ((DiscreteScrollView.this.onItemChangedListeners.isEmpty() && DiscreteScrollView.this.scrollStateChangeListeners.isEmpty()) || (viewHolder = DiscreteScrollView.this.getViewHolder((currentPosition = DiscreteScrollView.this.layoutManager.getCurrentPosition()))) == null) {
                return;
            }
            DiscreteScrollView.this.notifyScrollEnd(viewHolder, currentPosition);
            DiscreteScrollView.this.notifyCurrentItemChanged(viewHolder, currentPosition);
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public void onScroll(float f) {
            int currentItem;
            int nextPosition;
            if (DiscreteScrollView.this.scrollStateChangeListeners.isEmpty() || (currentItem = DiscreteScrollView.this.getCurrentItem()) == (nextPosition = DiscreteScrollView.this.layoutManager.getNextPosition())) {
                return;
            }
            DiscreteScrollView discreteScrollView = DiscreteScrollView.this;
            discreteScrollView.notifyScroll(f, currentItem, nextPosition, discreteScrollView.getViewHolder(currentItem), DiscreteScrollView.this.getViewHolder(nextPosition));
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public void onCurrentViewFirstLayout() {
            DiscreteScrollView.this.post(new Runnable() { // from class: com.yarolegovich.discretescrollview.DiscreteScrollView.ScrollStateListener.1
                @Override // java.lang.Runnable
                public void run() {
                    DiscreteScrollView.this.notifyCurrentItemChanged();
                }
            });
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public void onDataSetChangeChangedPosition() {
            DiscreteScrollView.this.notifyCurrentItemChanged();
        }
    }
}
