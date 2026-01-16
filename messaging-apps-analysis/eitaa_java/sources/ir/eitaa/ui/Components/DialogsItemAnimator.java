package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.ui.Adapters.DialogsAdapter;
import ir.eitaa.ui.Cells.DialogCell;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class DialogsItemAnimator extends SimpleItemAnimator {
    private static TimeInterpolator sDefaultInterpolator = new DecelerateInterpolator();
    private int bottomClip;
    private final RecyclerListView listView;
    private DialogCell removingDialog;
    private int topClip;
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

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> payloads) {
        return false;
    }

    protected void onAllAnimationsDone() {
        throw null;
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

    public DialogsItemAnimator(RecyclerListView listView) {
        this.listView = listView;
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

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        boolean z = !this.mPendingRemovals.isEmpty();
        boolean z2 = !this.mPendingMoves.isEmpty();
        boolean z3 = !this.mPendingChanges.isEmpty();
        boolean z4 = !this.mPendingAdditions.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                animateRemoveImpl(it.next());
            }
            this.mPendingRemovals.clear();
            if (z2) {
                final ArrayList<MoveInfo> arrayList = new ArrayList<>(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$DialogsItemAnimator$ZZGUKSvhCEVLA26qUH-VmL4IRok
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$runPendingAnimations$0$DialogsItemAnimator(arrayList);
                    }
                }.run();
            }
            if (z3) {
                final ArrayList<ChangeInfo> arrayList2 = new ArrayList<>(this.mPendingChanges);
                this.mChangesList.add(arrayList2);
                this.mPendingChanges.clear();
                new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$DialogsItemAnimator$HyoErtGF1HQovJRxRm-_i28cGzI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$runPendingAnimations$1$DialogsItemAnimator(arrayList2);
                    }
                }.run();
            }
            if (z4) {
                final ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>(this.mPendingAdditions);
                this.mAdditionsList.add(arrayList3);
                this.mPendingAdditions.clear();
                new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$DialogsItemAnimator$3EDJ2FWVUYv5QVcuaVX69XbL2ak
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$runPendingAnimations$2$DialogsItemAnimator(arrayList3);
                    }
                }.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runPendingAnimations$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runPendingAnimations$0$DialogsItemAnimator(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MoveInfo moveInfo = (MoveInfo) it.next();
            animateMoveImpl(moveInfo.holder, null, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
        }
        arrayList.clear();
        this.mMovesList.remove(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runPendingAnimations$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runPendingAnimations$1$DialogsItemAnimator(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            animateChangeImpl((ChangeInfo) it.next());
        }
        arrayList.clear();
        this.mChangesList.remove(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runPendingAnimations$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runPendingAnimations$2$DialogsItemAnimator(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            animateAddImpl((RecyclerView.ViewHolder) it.next());
        }
        arrayList.clear();
        this.mAdditionsList.remove(arrayList);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(final RecyclerView.ViewHolder holder, RecyclerView.ItemAnimator.ItemHolderInfo info) {
        resetAnimation(holder);
        this.mPendingRemovals.add(holder);
        DialogCell dialogCell = null;
        for (int i = 0; i < this.listView.getChildCount(); i++) {
            View childAt = this.listView.getChildAt(i);
            if (childAt.getTop() > Integer.MIN_VALUE && (childAt instanceof DialogCell)) {
                dialogCell = (DialogCell) childAt;
            }
        }
        if (holder.itemView != dialogCell) {
            return true;
        }
        this.removingDialog = dialogCell;
        return true;
    }

    public void prepareForRemove() {
        this.topClip = ConnectionsManager.DEFAULT_DATACENTER_ID;
        this.bottomClip = ConnectionsManager.DEFAULT_DATACENTER_ID;
        this.removingDialog = null;
    }

    private void animateRemoveImpl(final RecyclerView.ViewHolder holder) {
        final View view = holder.itemView;
        this.mRemoveAnimations.add(holder);
        if (view instanceof DialogCell) {
            final DialogCell dialogCell = (DialogCell) view;
            DialogCell dialogCell2 = this.removingDialog;
            if (view == dialogCell2) {
                if (this.topClip != Integer.MAX_VALUE) {
                    int measuredHeight = dialogCell2.getMeasuredHeight();
                    int i = this.topClip;
                    this.bottomClip = measuredHeight - i;
                    this.removingDialog.setTopClip(i);
                    this.removingDialog.setBottomClip(this.bottomClip);
                } else if (this.bottomClip != Integer.MAX_VALUE) {
                    int measuredHeight2 = dialogCell2.getMeasuredHeight() - this.bottomClip;
                    this.topClip = measuredHeight2;
                    this.removingDialog.setTopClip(measuredHeight2);
                    this.removingDialog.setBottomClip(this.bottomClip);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    dialogCell.setElevation(-1.0f);
                    dialogCell.setOutlineProvider(null);
                }
                ObjectAnimator duration = ObjectAnimator.ofFloat(dialogCell, AnimationProperties.CLIP_DIALOG_CELL_PROGRESS, 1.0f).setDuration(180L);
                duration.setInterpolator(sDefaultInterpolator);
                duration.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.DialogsItemAnimator.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        DialogsItemAnimator.this.dispatchRemoveStarting(holder);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        animator.removeAllListeners();
                        dialogCell.setClipProgress(0.0f);
                        if (Build.VERSION.SDK_INT >= 21) {
                            dialogCell.setElevation(0.0f);
                        }
                        DialogsItemAnimator.this.dispatchRemoveFinished(holder);
                        DialogsItemAnimator.this.mRemoveAnimations.remove(holder);
                        DialogsItemAnimator.this.dispatchFinishedWhenDone();
                    }
                });
                duration.start();
                return;
            }
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(dialogCell, (Property<DialogCell, Float>) View.ALPHA, 1.0f).setDuration(180L);
            duration2.setInterpolator(sDefaultInterpolator);
            duration2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.DialogsItemAnimator.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    DialogsItemAnimator.this.dispatchRemoveStarting(holder);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    animator.removeAllListeners();
                    dialogCell.setClipProgress(0.0f);
                    if (Build.VERSION.SDK_INT >= 21) {
                        dialogCell.setElevation(0.0f);
                    }
                    DialogsItemAnimator.this.dispatchRemoveFinished(holder);
                    DialogsItemAnimator.this.mRemoveAnimations.remove(holder);
                    DialogsItemAnimator.this.dispatchFinishedWhenDone();
                }
            });
            duration2.start();
            return;
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        viewPropertyAnimatorAnimate.setDuration(180L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.DialogsItemAnimator.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DialogsItemAnimator.this.dispatchRemoveStarting(holder);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                DialogsItemAnimator.this.dispatchRemoveFinished(holder);
                DialogsItemAnimator.this.mRemoveAnimations.remove(holder);
                DialogsItemAnimator.this.dispatchFinishedWhenDone();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(final RecyclerView.ViewHolder holder) {
        resetAnimation(holder);
        View view = holder.itemView;
        if (!(view instanceof DialogCell)) {
            view.setAlpha(0.0f);
        }
        this.mPendingAdditions.add(holder);
        if (this.mPendingAdditions.size() > 2) {
            for (int i = 0; i < this.mPendingAdditions.size(); i++) {
                this.mPendingAdditions.get(i).itemView.setAlpha(0.0f);
                if (this.mPendingAdditions.get(i).itemView instanceof DialogCell) {
                    ((DialogCell) this.mPendingAdditions.get(i).itemView).setMoving(true);
                }
            }
        }
        return true;
    }

    void animateAddImpl(final RecyclerView.ViewHolder holder) {
        final View view = holder.itemView;
        this.mAddAnimations.add(holder);
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(180L).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.DialogsItemAnimator.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DialogsItemAnimator.this.dispatchAddStarting(holder);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                DialogsItemAnimator.this.dispatchAddFinished(holder);
                DialogsItemAnimator.this.mAddAnimations.remove(holder);
                DialogsItemAnimator.this.dispatchFinishedWhenDone();
                View view2 = holder.itemView;
                if (view2 instanceof DialogCell) {
                    ((DialogCell) view2).setMoving(false);
                }
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
        View view2 = holder.itemView;
        if (view2 instanceof DialogCell) {
            ((DialogCell) view2).setMoving(true);
        } else if (view2 instanceof DialogsAdapter.LastEmptyView) {
            ((DialogsAdapter.LastEmptyView) view2).moving = true;
        }
        this.mPendingMoves.add(new MoveInfo(holder, translationX, translationY, toX, toY));
        return true;
    }

    public void onListScroll(int dy) {
        if (!this.mPendingRemovals.isEmpty()) {
            int size = this.mPendingRemovals.size();
            for (int i = 0; i < size; i++) {
                View view = this.mPendingRemovals.get(i).itemView;
                view.setTranslationY(view.getTranslationY() + dy);
            }
        }
        if (this.mRemoveAnimations.isEmpty()) {
            return;
        }
        int size2 = this.mRemoveAnimations.size();
        for (int i2 = 0; i2 < size2; i2++) {
            View view2 = this.mRemoveAnimations.get(i2).itemView;
            view2.setTranslationY(view2.getTranslationY() + dy);
        }
    }

    void animateMoveImpl(final RecyclerView.ViewHolder holder, RecyclerView.ItemAnimator.ItemHolderInfo info, int fromX, int fromY, int toX, int toY) {
        final View view = holder.itemView;
        final int i = toX - fromX;
        final int i2 = toY - fromY;
        if (i != 0) {
            view.animate().translationX(0.0f);
        }
        if (i2 != 0) {
            view.animate().translationY(0.0f);
        }
        if (fromY > toY) {
            this.bottomClip = fromY - toY;
        } else {
            this.topClip = i2;
        }
        DialogCell dialogCell = this.removingDialog;
        if (dialogCell != null) {
            if (this.topClip != Integer.MAX_VALUE) {
                int measuredHeight = dialogCell.getMeasuredHeight();
                int i3 = this.topClip;
                this.bottomClip = measuredHeight - i3;
                this.removingDialog.setTopClip(i3);
                this.removingDialog.setBottomClip(this.bottomClip);
            } else if (this.bottomClip != Integer.MAX_VALUE) {
                int measuredHeight2 = dialogCell.getMeasuredHeight() - this.bottomClip;
                this.topClip = measuredHeight2;
                this.removingDialog.setTopClip(measuredHeight2);
                this.removingDialog.setBottomClip(this.bottomClip);
            }
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.mMoveAnimations.add(holder);
        viewPropertyAnimatorAnimate.setDuration(180L).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.DialogsItemAnimator.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DialogsItemAnimator.this.dispatchMoveStarting(holder);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i2 != 0) {
                    view.setTranslationY(0.0f);
                }
                View view2 = holder.itemView;
                if (view2 instanceof DialogCell) {
                    ((DialogCell) view2).setMoving(false);
                } else if (view2 instanceof DialogsAdapter.LastEmptyView) {
                    ((DialogsAdapter.LastEmptyView) view2).moving = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                DialogsItemAnimator.this.dispatchMoveFinished(holder);
                DialogsItemAnimator.this.mMoveAnimations.remove(holder);
                DialogsItemAnimator.this.dispatchFinishedWhenDone();
                View view2 = holder.itemView;
                if (view2 instanceof DialogCell) {
                    ((DialogCell) view2).setMoving(false);
                } else if (view2 instanceof DialogsAdapter.LastEmptyView) {
                    ((DialogsAdapter.LastEmptyView) view2).moving = false;
                }
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, RecyclerView.ItemAnimator.ItemHolderInfo info, int fromX, int fromY, int toX, int toY) {
        if (!(oldHolder.itemView instanceof DialogCell)) {
            return false;
        }
        resetAnimation(oldHolder);
        resetAnimation(newHolder);
        oldHolder.itemView.setAlpha(1.0f);
        newHolder.itemView.setAlpha(0.0f);
        newHolder.itemView.setTranslationX(0.0f);
        this.mPendingChanges.add(new ChangeInfo(oldHolder, newHolder, fromX, fromY, toX, toY));
        return true;
    }

    void animateChangeImpl(final ChangeInfo changeInfo) {
        final RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
        RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
        if (viewHolder == null || viewHolder2 == null) {
            return;
        }
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(180L);
        animatorSet.playTogether(ObjectAnimator.ofFloat(viewHolder.itemView, (Property<View, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(viewHolder2.itemView, (Property<View, Float>) View.ALPHA, 1.0f));
        this.mChangeAnimations.add(changeInfo.oldHolder);
        this.mChangeAnimations.add(changeInfo.newHolder);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.DialogsItemAnimator.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DialogsItemAnimator.this.dispatchChangeStarting(changeInfo.oldHolder, true);
                DialogsItemAnimator.this.dispatchChangeStarting(changeInfo.newHolder, false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewHolder.itemView.setAlpha(1.0f);
                animatorSet.removeAllListeners();
                DialogsItemAnimator.this.dispatchChangeFinished(changeInfo.oldHolder, true);
                DialogsItemAnimator.this.mChangeAnimations.remove(changeInfo.oldHolder);
                DialogsItemAnimator.this.dispatchFinishedWhenDone();
                DialogsItemAnimator.this.dispatchChangeFinished(changeInfo.newHolder, false);
                DialogsItemAnimator.this.mChangeAnimations.remove(changeInfo.newHolder);
                DialogsItemAnimator.this.dispatchFinishedWhenDone();
            }
        });
        animatorSet.start();
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
            if (view instanceof DialogCell) {
                ((DialogCell) view).setClipProgress(0.0f);
            } else {
                view.setAlpha(1.0f);
            }
            dispatchRemoveFinished(item);
        }
        if (this.mPendingAdditions.remove(item)) {
            if (view instanceof DialogCell) {
                ((DialogCell) view).setClipProgress(0.0f);
            } else {
                view.setAlpha(1.0f);
            }
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
                if (view instanceof DialogCell) {
                    ((DialogCell) view).setClipProgress(1.0f);
                } else {
                    view.setAlpha(1.0f);
                }
                dispatchAddFinished(item);
                if (arrayList3.isEmpty()) {
                    this.mAdditionsList.remove(size5);
                }
            }
        }
        this.mRemoveAnimations.remove(item);
        this.mAddAnimations.remove(item);
        this.mChangeAnimations.remove(item);
        this.mMoveAnimations.remove(item);
        dispatchFinishedWhenDone();
    }

    private void resetAnimation(RecyclerView.ViewHolder holder) {
        holder.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        return (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) ? false : true;
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
            RecyclerView.ViewHolder viewHolder = this.mPendingRemovals.get(size2);
            View view2 = viewHolder.itemView;
            view2.setTranslationY(0.0f);
            view2.setTranslationX(0.0f);
            dispatchRemoveFinished(viewHolder);
            this.mPendingRemovals.remove(size2);
        }
        int size3 = this.mPendingAdditions.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder2 = this.mPendingAdditions.get(size3);
            View view3 = viewHolder2.itemView;
            if (view3 instanceof DialogCell) {
                ((DialogCell) view3).setClipProgress(0.0f);
            } else {
                view3.setAlpha(1.0f);
            }
            dispatchAddFinished(viewHolder2);
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
                    View view4 = moveInfo2.holder.itemView;
                    view4.setTranslationY(0.0f);
                    view4.setTranslationX(0.0f);
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
                    RecyclerView.ViewHolder viewHolder3 = arrayList2.get(size8);
                    View view5 = viewHolder3.itemView;
                    if (view5 instanceof DialogCell) {
                        ((DialogCell) view5).setClipProgress(0.0f);
                    } else {
                        view5.setAlpha(1.0f);
                    }
                    dispatchAddFinished(viewHolder3);
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
}
