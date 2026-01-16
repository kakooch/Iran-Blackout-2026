package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.ui.Cells.ChatMessageCell;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class RecyclerAnimationScrollHelper {
    private AnimationCallback animationCallback;
    private ValueAnimator animator;
    private LinearLayoutManager layoutManager;
    private RecyclerListView recyclerView;
    private int scrollDirection;
    private ScrollListener scrollListener;
    public SparseArray<View> positionToOldView = new SparseArray<>();
    private HashMap<Long, View> oldStableIds = new HashMap<>();

    public static class AnimationCallback {
        public void onEndAnimation() {
            throw null;
        }

        public void onStartAnimation() {
        }

        public void recycleView(View view) {
            throw null;
        }
    }

    public interface ScrollListener {
        void onScroll();
    }

    public RecyclerAnimationScrollHelper(RecyclerListView recyclerView, LinearLayoutManager layoutManager) {
        this.recyclerView = recyclerView;
        this.layoutManager = layoutManager;
    }

    public void scrollToPosition(int position, int offset, final boolean bottom, boolean smooth) {
        RecyclerListView recyclerListView = this.recyclerView;
        if (recyclerListView.fastScrollAnimationRunning) {
            return;
        }
        if (recyclerListView.getItemAnimator() == null || !this.recyclerView.getItemAnimator().isRunning()) {
            if (!smooth || this.scrollDirection == -1) {
                this.layoutManager.scrollToPositionWithOffset(position, offset, bottom);
                return;
            }
            int childCount = this.recyclerView.getChildCount();
            if (childCount == 0 || !MessagesController.getGlobalMainSettings().getBoolean("view_animations", true)) {
                this.layoutManager.scrollToPositionWithOffset(position, offset, bottom);
                return;
            }
            boolean z = this.scrollDirection == 0;
            this.recyclerView.setScrollEnabled(false);
            ArrayList arrayList = new ArrayList();
            this.positionToOldView.clear();
            RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
            this.oldStableIds.clear();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.recyclerView.getChildAt(i);
                arrayList.add(childAt);
                this.positionToOldView.put(this.layoutManager.getPosition(childAt), childAt);
                if (adapter != null && adapter.hasStableIds()) {
                    this.oldStableIds.put(Long.valueOf(((RecyclerView.LayoutParams) childAt.getLayoutParams()).mViewHolder.getItemId()), childAt);
                }
                if (childAt instanceof ChatMessageCell) {
                    ((ChatMessageCell) childAt).setAnimationRunning(true, true);
                }
            }
            this.recyclerView.prepareForFastScroll();
            AnimatableAdapter animatableAdapter = adapter instanceof AnimatableAdapter ? (AnimatableAdapter) adapter : null;
            this.layoutManager.scrollToPositionWithOffset(position, offset, bottom);
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            this.recyclerView.stopScroll();
            this.recyclerView.setVerticalScrollBarEnabled(false);
            AnimationCallback animationCallback = this.animationCallback;
            if (animationCallback != null) {
                animationCallback.onStartAnimation();
            }
            this.recyclerView.fastScrollAnimationRunning = true;
            if (animatableAdapter != null) {
                animatableAdapter.onAnimationStart();
            }
            this.recyclerView.addOnLayoutChangeListener(new AnonymousClass1(adapter, arrayList, z, animatableAdapter));
        }
    }

    /* renamed from: ir.eitaa.ui.Components.RecyclerAnimationScrollHelper$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnLayoutChangeListener {
        final /* synthetic */ RecyclerView.Adapter val$adapter;
        final /* synthetic */ AnimatableAdapter val$finalAnimatableAdapter;
        final /* synthetic */ ArrayList val$oldViews;
        final /* synthetic */ boolean val$scrollDown;

        AnonymousClass1(final RecyclerView.Adapter val$adapter, final ArrayList val$oldViews, final boolean val$scrollDown, final AnimatableAdapter val$finalAnimatableAdapter) {
            this.val$adapter = val$adapter;
            this.val$oldViews = val$oldViews;
            this.val$scrollDown = val$scrollDown;
            this.val$finalAnimatableAdapter = val$finalAnimatableAdapter;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View v, int l, int t, int r, int b, int ol, int ot, int or, int ob) {
            int height;
            long jMin;
            View view;
            final ArrayList arrayList = new ArrayList();
            RecyclerAnimationScrollHelper.this.recyclerView.stopScroll();
            int childCount = RecyclerAnimationScrollHelper.this.recyclerView.getChildCount();
            int top = 0;
            int bottom = 0;
            int i = 0;
            boolean z = false;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = RecyclerAnimationScrollHelper.this.recyclerView.getChildAt(i2);
                arrayList.add(childAt);
                if (childAt.getTop() < top) {
                    top = childAt.getTop();
                }
                if (childAt.getBottom() > bottom) {
                    bottom = childAt.getBottom();
                }
                if (childAt instanceof ChatMessageCell) {
                    ((ChatMessageCell) childAt).setAnimationRunning(true, false);
                }
                RecyclerView.Adapter adapter = this.val$adapter;
                if (adapter != null && adapter.hasStableIds()) {
                    long itemId = this.val$adapter.getItemId(RecyclerAnimationScrollHelper.this.recyclerView.getChildAdapterPosition(childAt));
                    if (RecyclerAnimationScrollHelper.this.oldStableIds.containsKey(Long.valueOf(itemId)) && (view = (View) RecyclerAnimationScrollHelper.this.oldStableIds.get(Long.valueOf(itemId))) != null) {
                        if (view instanceof ChatMessageCell) {
                            ((ChatMessageCell) view).setAnimationRunning(false, false);
                        }
                        this.val$oldViews.remove(view);
                        if (RecyclerAnimationScrollHelper.this.animationCallback != null) {
                            RecyclerAnimationScrollHelper.this.animationCallback.recycleView(view);
                        }
                        int top2 = childAt.getTop() - view.getTop();
                        if (top2 != 0) {
                            i = top2;
                        }
                        z = true;
                    }
                }
            }
            RecyclerAnimationScrollHelper.this.oldStableIds.clear();
            Iterator it = this.val$oldViews.iterator();
            int i3 = ConnectionsManager.DEFAULT_DATACENTER_ID;
            int height2 = 0;
            while (it.hasNext()) {
                View view2 = (View) it.next();
                int bottom2 = view2.getBottom();
                int top3 = view2.getTop();
                if (bottom2 > height2) {
                    height2 = bottom2;
                }
                if (top3 < i3) {
                    i3 = top3;
                }
                if (view2.getParent() == null) {
                    RecyclerAnimationScrollHelper.this.recyclerView.addView(view2);
                    RecyclerAnimationScrollHelper.this.layoutManager.ignoreView(view2);
                }
                if (view2 instanceof ChatMessageCell) {
                    ((ChatMessageCell) view2).setAnimationRunning(true, true);
                }
            }
            int i4 = i3 != Integer.MAX_VALUE ? i3 : 0;
            if (this.val$oldViews.isEmpty()) {
                height = Math.abs(i);
            } else {
                if (!this.val$scrollDown) {
                    height2 = RecyclerAnimationScrollHelper.this.recyclerView.getHeight() - i4;
                }
                height = (this.val$scrollDown ? -top : bottom - RecyclerAnimationScrollHelper.this.recyclerView.getHeight()) + height2;
            }
            final int i5 = height;
            if (RecyclerAnimationScrollHelper.this.animator != null) {
                RecyclerAnimationScrollHelper.this.animator.removeAllListeners();
                RecyclerAnimationScrollHelper.this.animator.cancel();
            }
            RecyclerAnimationScrollHelper.this.animator = ValueAnimator.ofFloat(0.0f, 1.0f);
            ValueAnimator valueAnimator = RecyclerAnimationScrollHelper.this.animator;
            final ArrayList arrayList2 = this.val$oldViews;
            final boolean z2 = this.val$scrollDown;
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$RecyclerAnimationScrollHelper$1$LqGGyu0N4X-FlNfVzUXAFZdzjzE
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f$0.lambda$onLayoutChange$0$RecyclerAnimationScrollHelper$1(arrayList2, z2, i5, arrayList, valueAnimator2);
                }
            });
            RecyclerAnimationScrollHelper.this.animator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.RecyclerAnimationScrollHelper.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (RecyclerAnimationScrollHelper.this.animator == null) {
                        return;
                    }
                    RecyclerAnimationScrollHelper.this.recyclerView.fastScrollAnimationRunning = false;
                    Iterator it2 = AnonymousClass1.this.val$oldViews.iterator();
                    while (it2.hasNext()) {
                        View view3 = (View) it2.next();
                        if (view3 instanceof ChatMessageCell) {
                            ((ChatMessageCell) view3).setAnimationRunning(false, true);
                        }
                        view3.setTranslationY(0.0f);
                        RecyclerAnimationScrollHelper.this.layoutManager.stopIgnoringView(view3);
                        RecyclerAnimationScrollHelper.this.recyclerView.removeView(view3);
                        if (RecyclerAnimationScrollHelper.this.animationCallback != null) {
                            RecyclerAnimationScrollHelper.this.animationCallback.recycleView(view3);
                        }
                    }
                    RecyclerAnimationScrollHelper.this.recyclerView.setScrollEnabled(true);
                    RecyclerAnimationScrollHelper.this.recyclerView.setVerticalScrollBarEnabled(true);
                    if (BuildVars.DEBUG_VERSION) {
                        if (RecyclerAnimationScrollHelper.this.recyclerView.mChildHelper.getChildCount() == RecyclerAnimationScrollHelper.this.recyclerView.getChildCount()) {
                            if (RecyclerAnimationScrollHelper.this.recyclerView.mChildHelper.getHiddenChildCount() != 0) {
                                throw new RuntimeException("hidden child count must be 0");
                            }
                        } else {
                            throw new RuntimeException("views count in child helper must be quals views count in recycler view");
                        }
                    }
                    int childCount2 = RecyclerAnimationScrollHelper.this.recyclerView.getChildCount();
                    for (int i6 = 0; i6 < childCount2; i6++) {
                        View childAt2 = RecyclerAnimationScrollHelper.this.recyclerView.getChildAt(i6);
                        if (childAt2 instanceof ChatMessageCell) {
                            ((ChatMessageCell) childAt2).setAnimationRunning(false, false);
                        }
                        childAt2.setTranslationY(0.0f);
                    }
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        View view4 = (View) it3.next();
                        if (view4 instanceof ChatMessageCell) {
                            ((ChatMessageCell) view4).setAnimationRunning(false, false);
                        }
                        view4.setTranslationY(0.0f);
                    }
                    AnimatableAdapter animatableAdapter = AnonymousClass1.this.val$finalAnimatableAdapter;
                    if (animatableAdapter != null) {
                        animatableAdapter.onAnimationEnd();
                    }
                    if (RecyclerAnimationScrollHelper.this.animationCallback != null) {
                        RecyclerAnimationScrollHelper.this.animationCallback.onEndAnimation();
                    }
                    RecyclerAnimationScrollHelper.this.positionToOldView.clear();
                    RecyclerAnimationScrollHelper.this.animator = null;
                }
            });
            RecyclerAnimationScrollHelper.this.recyclerView.removeOnLayoutChangeListener(this);
            if (z) {
                jMin = 600;
            } else {
                long measuredHeight = (long) (((i5 / RecyclerAnimationScrollHelper.this.recyclerView.getMeasuredHeight()) + 1.0f) * 200.0f);
                if (measuredHeight < 300) {
                    measuredHeight = 300;
                }
                jMin = Math.min(measuredHeight, 1300L);
            }
            RecyclerAnimationScrollHelper.this.animator.setDuration(jMin);
            RecyclerAnimationScrollHelper.this.animator.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
            RecyclerAnimationScrollHelper.this.animator.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onLayoutChange$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onLayoutChange$0$RecyclerAnimationScrollHelper$1(ArrayList arrayList, boolean z, int i, ArrayList arrayList2, ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) arrayList.get(i2);
                float y = view.getY();
                if (view.getY() + view.getMeasuredHeight() >= 0.0f && y <= RecyclerAnimationScrollHelper.this.recyclerView.getMeasuredHeight()) {
                    if (z) {
                        view.setTranslationY((-i) * fFloatValue);
                    } else {
                        view.setTranslationY(i * fFloatValue);
                    }
                }
            }
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                View view2 = (View) arrayList2.get(i3);
                if (z) {
                    view2.setTranslationY(i * (1.0f - fFloatValue));
                } else {
                    view2.setTranslationY((-i) * (1.0f - fFloatValue));
                }
            }
            RecyclerAnimationScrollHelper.this.recyclerView.invalidate();
            if (RecyclerAnimationScrollHelper.this.scrollListener != null) {
                RecyclerAnimationScrollHelper.this.scrollListener.onScroll();
            }
        }
    }

    public void cancel() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        clear();
    }

    private void clear() {
        this.recyclerView.setVerticalScrollBarEnabled(true);
        RecyclerListView recyclerListView = this.recyclerView;
        recyclerListView.fastScrollAnimationRunning = false;
        RecyclerView.Adapter adapter = recyclerListView.getAdapter();
        if (adapter instanceof AnimatableAdapter) {
            ((AnimatableAdapter) adapter).onAnimationEnd();
        }
        this.animator = null;
        int childCount = this.recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.recyclerView.getChildAt(i);
            childAt.setTranslationY(0.0f);
            if (childAt instanceof ChatMessageCell) {
                ((ChatMessageCell) childAt).setAnimationRunning(false, false);
            }
        }
    }

    public void setScrollDirection(int scrollDirection) {
        this.scrollDirection = scrollDirection;
    }

    public void setScrollListener(ScrollListener listener) {
        this.scrollListener = listener;
    }

    public void setAnimationCallback(AnimationCallback animationCallback) {
        this.animationCallback = animationCallback;
    }

    public int getScrollDirection() {
        return this.scrollDirection;
    }

    public static abstract class AnimatableAdapter extends RecyclerListView.SelectionAdapter {
        public boolean animationRunning;
        private ArrayList<Integer> rangeInserted = new ArrayList<>();
        private ArrayList<Integer> rangeRemoved = new ArrayList<>();
        private boolean shouldNotifyDataSetChanged;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            if (!this.animationRunning) {
                super.notifyDataSetChanged();
            } else {
                this.shouldNotifyDataSetChanged = true;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemInserted(int position) {
            if (!this.animationRunning) {
                super.notifyItemInserted(position);
            } else {
                this.rangeInserted.add(Integer.valueOf(position));
                this.rangeInserted.add(1);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeInserted(int positionStart, int itemCount) {
            if (!this.animationRunning) {
                super.notifyItemRangeInserted(positionStart, itemCount);
            } else {
                this.rangeInserted.add(Integer.valueOf(positionStart));
                this.rangeInserted.add(Integer.valueOf(itemCount));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRemoved(int position) {
            if (!this.animationRunning) {
                super.notifyItemRemoved(position);
            } else {
                this.rangeRemoved.add(Integer.valueOf(position));
                this.rangeRemoved.add(1);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeRemoved(int positionStart, int itemCount) {
            if (!this.animationRunning) {
                super.notifyItemRangeRemoved(positionStart, itemCount);
            } else {
                this.rangeRemoved.add(Integer.valueOf(positionStart));
                this.rangeRemoved.add(Integer.valueOf(itemCount));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemChanged(int position) {
            if (this.animationRunning) {
                return;
            }
            super.notifyItemChanged(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeChanged(int positionStart, int itemCount) {
            if (this.animationRunning) {
                return;
            }
            super.notifyItemRangeChanged(positionStart, itemCount);
        }

        public void onAnimationStart() {
            this.animationRunning = true;
            this.shouldNotifyDataSetChanged = false;
            this.rangeInserted.clear();
            this.rangeRemoved.clear();
        }

        public void onAnimationEnd() {
            this.animationRunning = false;
            if (!this.shouldNotifyDataSetChanged && this.rangeInserted.isEmpty() && this.rangeRemoved.isEmpty()) {
                return;
            }
            notifyDataSetChanged();
        }
    }
}
