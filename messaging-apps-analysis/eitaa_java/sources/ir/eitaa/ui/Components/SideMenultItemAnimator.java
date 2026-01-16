package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import ir.eitaa.tgnet.ConnectionsManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class SideMenultItemAnimator extends SimpleItemAnimator {
    private static TimeInterpolator sDefaultInterpolator;
    private RecyclerListView parentRecyclerView;
    private boolean shouldClipChildren;
    private ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList<>();
    private ArrayList<MoveInfo> mPendingMoves = new ArrayList<>();
    private ArrayList<ChangeInfo> mPendingChanges = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList<>();
    ArrayList<ArrayList<MoveInfo>> mMovesList = new ArrayList<>();
    ArrayList<ArrayList<ChangeInfo>> mChangesList = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList<>();

    static /* synthetic */ int lambda$new$0(int i, int i2) {
        if (i2 == i - 1) {
            return 0;
        }
        return i2 >= 0 ? i2 + 1 : i2;
    }

    protected void onAllAnimationsDone() {
    }

    private static class MoveInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder holder;
        public int toX;
        public int toY;

        MoveInfo(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
            this.holder = holder;
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
        }
    }

    private static class ChangeInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder newHolder;
        public RecyclerView.ViewHolder oldHolder;
        public int toX;
        public int toY;

        private ChangeInfo(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder) {
            this.oldHolder = oldHolder;
            this.newHolder = newHolder;
        }

        ChangeInfo(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, int fromX, int fromY, int toX, int toY) {
            this(oldHolder, newHolder);
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
        }
    }

    public SideMenultItemAnimator(RecyclerListView view) {
        this.parentRecyclerView = view;
        view.setChildDrawingOrderCallback(new RecyclerView.ChildDrawingOrderCallback() { // from class: ir.eitaa.ui.Components.-$$Lambda$SideMenultItemAnimator$mI5Z8fOqI3PZtGv2f9xv-gZFEVA
            @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
            public final int onGetChildDrawingOrder(int i, int i2) {
                return SideMenultItemAnimator.lambda$new$0(i, i2);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        boolean z = !this.mPendingRemovals.isEmpty();
        boolean z2 = !this.mPendingMoves.isEmpty();
        boolean z3 = !this.mPendingChanges.isEmpty();
        boolean z4 = !this.mPendingAdditions.isEmpty();
        if (z || z2 || z4 || z3) {
            int size = this.mPendingRemovals.size();
            int measuredHeight = 0;
            for (int i = 0; i < size; i++) {
                measuredHeight += this.mPendingRemovals.get(i).itemView.getMeasuredHeight();
            }
            int size2 = this.mPendingRemovals.size();
            for (int i2 = 0; i2 < size2; i2++) {
                animateRemoveImpl(this.mPendingRemovals.get(i2), measuredHeight);
            }
            this.mPendingRemovals.clear();
            if (z2) {
                ArrayList<MoveInfo> arrayList = new ArrayList<>(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                Iterator<MoveInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    MoveInfo next = it.next();
                    animateMoveImpl(next.holder, next.fromX, next.fromY, next.toX, next.toY);
                }
                arrayList.clear();
                this.mMovesList.remove(arrayList);
            }
            if (z3) {
                ArrayList<ChangeInfo> arrayList2 = new ArrayList<>(this.mPendingChanges);
                this.mChangesList.add(arrayList2);
                this.mPendingChanges.clear();
                Iterator<ChangeInfo> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    animateChangeImpl(it2.next());
                }
                arrayList2.clear();
                this.mChangesList.remove(arrayList2);
            }
            if (z4) {
                ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>(this.mPendingAdditions);
                this.mAdditionsList.add(arrayList3);
                this.mPendingAdditions.clear();
                int size3 = arrayList3.size();
                int measuredHeight2 = 0;
                for (int i3 = 0; i3 < size3; i3++) {
                    measuredHeight2 += arrayList3.get(i3).itemView.getMeasuredHeight();
                }
                int size4 = arrayList3.size();
                for (int i4 = 0; i4 < size4; i4++) {
                    animateAddImpl(arrayList3.get(i4), i4, size4, measuredHeight2);
                }
                arrayList3.clear();
                this.mAdditionsList.remove(arrayList3);
            }
            this.parentRecyclerView.invalidateViews();
            this.parentRecyclerView.invalidate();
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(final RecyclerView.ViewHolder holder, RecyclerView.ItemAnimator.ItemHolderInfo info) {
        resetAnimation(holder);
        this.mPendingRemovals.add(holder);
        return true;
    }

    private void animateRemoveImpl(final RecyclerView.ViewHolder holder, int totalHeight) {
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = holder.itemView.animate();
        this.mRemoveAnimations.add(holder);
        viewPropertyAnimatorAnimate.setDuration(220L).translationY(-totalHeight).setInterpolator(CubicBezierInterpolator.EASE_OUT).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.SideMenultItemAnimator.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SideMenultItemAnimator.this.dispatchRemoveStarting(holder);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                SideMenultItemAnimator.this.dispatchRemoveFinished(holder);
                SideMenultItemAnimator.this.mRemoveAnimations.remove(holder);
                SideMenultItemAnimator.this.dispatchFinishedWhenDone();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(final RecyclerView.ViewHolder holder) {
        resetAnimation(holder);
        this.mPendingAdditions.add(holder);
        holder.itemView.setAlpha(0.0f);
        return true;
    }

    void animateAddImpl(final RecyclerView.ViewHolder holder, int num, int addCount, int totalHeight) {
        final View view = holder.itemView;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.mAddAnimations.add(holder);
        view.setAlpha(1.0f);
        view.setTranslationY(-totalHeight);
        viewPropertyAnimatorAnimate.translationY(0.0f).setDuration(220L).setInterpolator(CubicBezierInterpolator.EASE_OUT).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.SideMenultItemAnimator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SideMenultItemAnimator.this.dispatchAddStarting(holder);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setTranslationY(0.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                SideMenultItemAnimator.this.dispatchAddFinished(holder);
                SideMenultItemAnimator.this.mAddAnimations.remove(holder);
                SideMenultItemAnimator.this.dispatchFinishedWhenDone();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(final RecyclerView.ViewHolder holder, RecyclerView.ItemAnimator.ItemHolderInfo info, int fromX, int fromY, int toX, int toY) {
        View view = holder.itemView;
        int translationX = fromX + ((int) view.getTranslationX());
        int translationY = fromY + ((int) holder.itemView.getTranslationY());
        resetAnimation(holder);
        int i = toX - translationX;
        int i2 = toY - translationY;
        if (i == 0 && i2 == 0) {
            dispatchMoveFinished(holder);
            return false;
        }
        if (i != 0) {
            view.setTranslationX(-i);
        }
        if (i2 != 0) {
            view.setTranslationY(-i2);
        }
        this.mPendingMoves.add(new MoveInfo(holder, translationX, translationY, toX, toY));
        return true;
    }

    void animateMoveImpl(final RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        final View view = holder.itemView;
        final int i = toX - fromX;
        final int i2 = toY - fromY;
        if (i != 0) {
            view.animate().translationX(0.0f);
        }
        if (i2 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.mMoveAnimations.add(holder);
        viewPropertyAnimatorAnimate.setDuration(220L).setInterpolator(CubicBezierInterpolator.EASE_OUT).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.SideMenultItemAnimator.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SideMenultItemAnimator.this.dispatchMoveStarting(holder);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i2 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                SideMenultItemAnimator.this.dispatchMoveFinished(holder);
                SideMenultItemAnimator.this.mMoveAnimations.remove(holder);
                SideMenultItemAnimator.this.dispatchFinishedWhenDone();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, RecyclerView.ItemAnimator.ItemHolderInfo info, int fromX, int fromY, int toX, int toY) {
        if (oldHolder == newHolder) {
            return animateMove(oldHolder, null, fromX, fromY, toX, toY);
        }
        float translationX = oldHolder.itemView.getTranslationX();
        float translationY = oldHolder.itemView.getTranslationY();
        float alpha = oldHolder.itemView.getAlpha();
        resetAnimation(oldHolder);
        int i = (int) ((toX - fromX) - translationX);
        int i2 = (int) ((toY - fromY) - translationY);
        oldHolder.itemView.setTranslationX(translationX);
        oldHolder.itemView.setTranslationY(translationY);
        oldHolder.itemView.setAlpha(alpha);
        if (newHolder != null) {
            resetAnimation(newHolder);
            newHolder.itemView.setTranslationX(-i);
            newHolder.itemView.setTranslationY(-i2);
            newHolder.itemView.setAlpha(0.0f);
        }
        this.mPendingChanges.add(new ChangeInfo(oldHolder, newHolder, fromX, fromY, toX, toY));
        return true;
    }

    void animateChangeImpl(final ChangeInfo changeInfo) {
        RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
        final View view = viewHolder == null ? null : viewHolder.itemView;
        RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
        final View view2 = viewHolder2 != null ? viewHolder2.itemView : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.mChangeAnimations.add(changeInfo.oldHolder);
            duration.translationX(changeInfo.toX - changeInfo.fromX);
            duration.translationY(changeInfo.toY - changeInfo.fromY);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.SideMenultItemAnimator.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    SideMenultItemAnimator.this.dispatchChangeStarting(changeInfo.oldHolder, true);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    SideMenultItemAnimator.this.dispatchChangeFinished(changeInfo.oldHolder, true);
                    SideMenultItemAnimator.this.mChangeAnimations.remove(changeInfo.oldHolder);
                    SideMenultItemAnimator.this.dispatchFinishedWhenDone();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.mChangeAnimations.add(changeInfo.newHolder);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.SideMenultItemAnimator.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    SideMenultItemAnimator.this.dispatchChangeStarting(changeInfo.newHolder, false);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    SideMenultItemAnimator.this.dispatchChangeFinished(changeInfo.newHolder, false);
                    SideMenultItemAnimator.this.mChangeAnimations.remove(changeInfo.newHolder);
                    SideMenultItemAnimator.this.dispatchFinishedWhenDone();
                }
            }).start();
        }
    }

    private void endChangeAnimation(List<ChangeInfo> infoList, RecyclerView.ViewHolder item) {
        for (int size = infoList.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = infoList.get(size);
            if (endChangeAnimationIfNecessary(changeInfo, item) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                infoList.remove(changeInfo);
            }
        }
    }

    private void endChangeAnimationIfNecessary(ChangeInfo changeInfo) {
        RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
        if (viewHolder != null) {
            endChangeAnimationIfNecessary(changeInfo, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
        if (viewHolder2 != null) {
            endChangeAnimationIfNecessary(changeInfo, viewHolder2);
        }
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo changeInfo, RecyclerView.ViewHolder item) {
        boolean z = false;
        if (changeInfo.newHolder == item) {
            changeInfo.newHolder = null;
        } else {
            if (changeInfo.oldHolder != item) {
                return false;
            }
            changeInfo.oldHolder = null;
            z = true;
        }
        item.itemView.setAlpha(1.0f);
        item.itemView.setTranslationX(0.0f);
        item.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(item, z);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder item) {
        View view = item.itemView;
        view.animate().cancel();
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.mPendingMoves.get(size).holder == item) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(item);
                this.mPendingMoves.remove(size);
            }
        }
        endChangeAnimation(this.mPendingChanges, item);
        if (this.mPendingRemovals.remove(item)) {
            view.setTranslationY(0.0f);
            dispatchRemoveFinished(item);
        }
        if (this.mPendingAdditions.remove(item)) {
            view.setTranslationY(0.0f);
            dispatchAddFinished(item);
        }
        for (int size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
            ArrayList<ChangeInfo> arrayList = this.mChangesList.get(size2);
            endChangeAnimation(arrayList, item);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size2);
            }
        }
        for (int size3 = this.mMovesList.size() - 1; size3 >= 0; size3--) {
            ArrayList<MoveInfo> arrayList2 = this.mMovesList.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).holder == item) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(item);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.mMovesList.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.mAdditionsList.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.mAdditionsList.get(size5);
            if (arrayList3.remove(item)) {
                view.setTranslationY(0.0f);
                dispatchAddFinished(item);
                if (arrayList3.isEmpty()) {
                    this.mAdditionsList.remove(size5);
                }
            }
        }
        dispatchFinishedWhenDone();
    }

    private void resetAnimation(RecyclerView.ViewHolder holder) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        holder.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        return (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) ? false : true;
    }

    public boolean isAnimatingChild(View child) {
        if (!this.shouldClipChildren) {
            return false;
        }
        int size = this.mRemoveAnimations.size();
        for (int i = 0; i < size; i++) {
            if (this.mRemoveAnimations.get(i).itemView == child) {
                return true;
            }
        }
        int size2 = this.mAddAnimations.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.mAddAnimations.get(i2).itemView == child) {
                return true;
            }
        }
        return false;
    }

    public void setShouldClipChildren(boolean value) {
        this.shouldClipChildren = value;
    }

    public int getAnimationClipTop() {
        int i = 0;
        if (!this.shouldClipChildren) {
            return 0;
        }
        boolean zIsEmpty = this.mRemoveAnimations.isEmpty();
        int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
        if (!zIsEmpty) {
            int size = this.mRemoveAnimations.size();
            while (i < size) {
                iMin = Math.min(iMin, this.mRemoveAnimations.get(i).itemView.getTop());
                i++;
            }
            return iMin;
        }
        if (this.mAddAnimations.isEmpty()) {
            return 0;
        }
        int size2 = this.mAddAnimations.size();
        while (i < size2) {
            iMin = Math.min(iMin, this.mAddAnimations.get(i).itemView.getTop());
            i++;
        }
        return iMin;
    }

    void dispatchFinishedWhenDone() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
        onAllAnimationsDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = this.mPendingMoves.get(size);
            View view = moveInfo.holder.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(moveInfo.holder);
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.mPendingRemovals.get(size2));
            this.mPendingRemovals.remove(size2);
        }
        for (int size3 = this.mPendingAdditions.size() - 1; size3 >= 0; size3--) {
            RecyclerView.ViewHolder viewHolder = this.mPendingAdditions.get(size3);
            viewHolder.itemView.setTranslationY(0.0f);
            dispatchAddFinished(viewHolder);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; size4 >= 0; size4--) {
            endChangeAnimationIfNecessary(this.mPendingChanges.get(size4));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            for (int size5 = this.mMovesList.size() - 1; size5 >= 0; size5--) {
                ArrayList<MoveInfo> arrayList = this.mMovesList.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    MoveInfo moveInfo2 = arrayList.get(size6);
                    View view2 = moveInfo2.holder.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(moveInfo2.holder);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.mAdditionsList.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.ViewHolder> arrayList2 = this.mAdditionsList.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder2 = arrayList2.get(size8);
                    viewHolder2.itemView.setTranslationY(0.0f);
                    dispatchAddFinished(viewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.mAdditionsList.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.mChangesList.size() - 1; size9 >= 0; size9--) {
                ArrayList<ChangeInfo> arrayList3 = this.mChangesList.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    endChangeAnimationIfNecessary(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.mChangesList.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    void cancelAll(List<RecyclerView.ViewHolder> viewHolders) {
        for (int size = viewHolders.size() - 1; size >= 0; size--) {
            viewHolders.get(size).itemView.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> payloads) {
        return !payloads.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, payloads);
    }
}
