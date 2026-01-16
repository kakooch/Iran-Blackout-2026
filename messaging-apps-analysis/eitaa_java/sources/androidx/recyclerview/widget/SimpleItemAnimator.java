package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {
    boolean mSupportsChangeAnimations = true;

    public abstract boolean animateAdd(RecyclerView.ViewHolder holder);

    public abstract boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, RecyclerView.ItemAnimator.ItemHolderInfo info, int fromLeft, int fromTop, int toLeft, int toTop);

    public abstract boolean animateMove(RecyclerView.ViewHolder holder, RecyclerView.ItemAnimator.ItemHolderInfo info, int fromX, int fromY, int toX, int toY);

    public abstract boolean animateRemove(RecyclerView.ViewHolder holder, RecyclerView.ItemAnimator.ItemHolderInfo info);

    public void onAddFinished(RecyclerView.ViewHolder item) {
    }

    public void onAddStarting(RecyclerView.ViewHolder item) {
    }

    public void onChangeFinished(RecyclerView.ViewHolder item, boolean oldItem) {
    }

    public void onChangeStarting(RecyclerView.ViewHolder item, boolean oldItem) {
    }

    public void onMoveFinished(RecyclerView.ViewHolder item) {
    }

    public void onMoveStarting(RecyclerView.ViewHolder item) {
    }

    public void onRemoveFinished(RecyclerView.ViewHolder item) {
    }

    public void onRemoveStarting(RecyclerView.ViewHolder item) {
    }

    public void setSupportsChangeAnimations(boolean supportsChangeAnimations) {
        this.mSupportsChangeAnimations = supportsChangeAnimations;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder) {
        return !this.mSupportsChangeAnimations || viewHolder.isInvalid();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateDisappearance(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo preLayoutInfo, RecyclerView.ItemAnimator.ItemHolderInfo postLayoutInfo) {
        int i = preLayoutInfo.left;
        int i2 = preLayoutInfo.top;
        View view = viewHolder.itemView;
        int left = postLayoutInfo == null ? view.getLeft() : postLayoutInfo.left;
        int top = postLayoutInfo == null ? view.getTop() : postLayoutInfo.top;
        if (!viewHolder.isRemoved() && (i != left || i2 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return animateMove(viewHolder, preLayoutInfo, i, i2, left, top);
        }
        return animateRemove(viewHolder, preLayoutInfo);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateAppearance(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo preLayoutInfo, RecyclerView.ItemAnimator.ItemHolderInfo postLayoutInfo) {
        int i;
        int i2;
        if (preLayoutInfo != null && ((i = preLayoutInfo.left) != (i2 = postLayoutInfo.left) || preLayoutInfo.top != postLayoutInfo.top)) {
            return animateMove(viewHolder, preLayoutInfo, i, preLayoutInfo.top, i2, postLayoutInfo.top);
        }
        return animateAdd(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animatePersistence(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo preInfo, RecyclerView.ItemAnimator.ItemHolderInfo postInfo) {
        int i = preInfo.left;
        int i2 = postInfo.left;
        if (i != i2 || preInfo.top != postInfo.top) {
            return animateMove(viewHolder, preInfo, i, preInfo.top, i2, postInfo.top);
        }
        dispatchMoveFinished(viewHolder);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, RecyclerView.ItemAnimator.ItemHolderInfo preInfo, RecyclerView.ItemAnimator.ItemHolderInfo postInfo) {
        int i;
        int i2;
        int i3 = preInfo.left;
        int i4 = preInfo.top;
        if (newHolder.shouldIgnore()) {
            i2 = preInfo.left;
            i = preInfo.top;
        } else {
            int i5 = postInfo.left;
            i = postInfo.top;
            i2 = i5;
        }
        return animateChange(oldHolder, newHolder, preInfo, i3, i4, i2, i);
    }

    public final void dispatchRemoveFinished(RecyclerView.ViewHolder item) {
        onRemoveFinished(item);
        dispatchAnimationFinished(item);
    }

    public final void dispatchMoveFinished(RecyclerView.ViewHolder item) {
        onMoveFinished(item);
        dispatchAnimationFinished(item);
    }

    public final void dispatchAddFinished(RecyclerView.ViewHolder item) {
        onAddFinished(item);
        dispatchAnimationFinished(item);
    }

    public final void dispatchChangeFinished(RecyclerView.ViewHolder item, boolean oldItem) {
        onChangeFinished(item, oldItem);
        dispatchAnimationFinished(item);
    }

    public final void dispatchRemoveStarting(RecyclerView.ViewHolder item) {
        onRemoveStarting(item);
    }

    public final void dispatchMoveStarting(RecyclerView.ViewHolder item) {
        onMoveStarting(item);
    }

    public final void dispatchAddStarting(RecyclerView.ViewHolder item) {
        onAddStarting(item);
    }

    public final void dispatchChangeStarting(RecyclerView.ViewHolder item, boolean oldItem) {
        onChangeStarting(item, oldItem);
    }
}
