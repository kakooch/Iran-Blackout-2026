package ir.resaneh1.iptv.fragment.rubino;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.rbmain.ui.Components.CubicBezierInterpolator;

/* loaded from: classes3.dex */
public class RecyclerAnimationScrollHelper {
    private AnimationCallback animationCallback;
    private ValueAnimator animator;
    private LinearLayoutManager layoutManager;
    private RecyclerListViewEdited recyclerView;
    private int scrollDirection;
    private ScrollListener scrollListener;
    public SparseArray<View> positionToOldView = new SparseArray<>();
    private HashMap<Long, View> oldStableIds = new HashMap<>();

    public static class AnimationCallback {
    }

    public interface ScrollListener {
        void onScroll();
    }

    public RecyclerAnimationScrollHelper(RecyclerListViewEdited recyclerListViewEdited, LinearLayoutManager linearLayoutManager) {
        this.recyclerView = recyclerListViewEdited;
        this.layoutManager = linearLayoutManager;
    }

    public void scrollToPosition(int i, int i2, boolean z, boolean z2) {
        RecyclerListViewEdited recyclerListViewEdited = this.recyclerView;
        if (recyclerListViewEdited.scrollAnimationRunning) {
            return;
        }
        if (recyclerListViewEdited.getItemAnimator() == null || !this.recyclerView.getItemAnimator().isRunning()) {
            if (!z2 || this.scrollDirection == -1) {
                this.layoutManager.scrollToPositionWithOffset(i, i2, z);
                return;
            }
            int childCount = this.recyclerView.getChildCount();
            if (childCount == 0) {
                this.layoutManager.scrollToPositionWithOffset(i, i2, z);
                return;
            }
            boolean z3 = this.scrollDirection == 0;
            this.recyclerView.setScrollEnabled(false);
            ArrayList arrayList = new ArrayList();
            this.positionToOldView.clear();
            RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
            this.oldStableIds.clear();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.recyclerView.getChildAt(i3);
                arrayList.add(childAt);
                int position = this.layoutManager.getPosition(childAt);
                this.positionToOldView.put(position, childAt);
                if (adapter != null && adapter.hasStableIds()) {
                    this.oldStableIds.put(Long.valueOf(adapter.getItemId(position)), childAt);
                }
            }
            this.recyclerView.prepareForFastScroll();
            AnimatableAdapter animatableAdapter = adapter instanceof AnimatableAdapter ? (AnimatableAdapter) adapter : null;
            this.layoutManager.scrollToPositionWithOffset(i, i2, z);
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            this.recyclerView.stopScroll();
            this.recyclerView.setVerticalScrollBarEnabled(false);
            this.recyclerView.scrollAnimationRunning = true;
            if (animatableAdapter != null) {
                animatableAdapter.onAnimationStart();
            }
            this.recyclerView.addOnLayoutChangeListener(new AnonymousClass1(adapter, arrayList, z3, animatableAdapter));
        }
    }

    /* renamed from: ir.resaneh1.iptv.fragment.rubino.RecyclerAnimationScrollHelper$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnLayoutChangeListener {
        final /* synthetic */ RecyclerView.Adapter val$adapter;
        final /* synthetic */ AnimatableAdapter val$finalAnimatableAdapter;
        final /* synthetic */ ArrayList val$oldViews;
        final /* synthetic */ boolean val$scrollDown;

        AnonymousClass1(RecyclerView.Adapter adapter, ArrayList arrayList, boolean z, AnimatableAdapter animatableAdapter) {
            this.val$adapter = adapter;
            this.val$oldViews = arrayList;
            this.val$scrollDown = z;
            this.val$finalAnimatableAdapter = animatableAdapter;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int height;
            View view2;
            final ArrayList arrayList = new ArrayList();
            RecyclerAnimationScrollHelper.this.recyclerView.stopScroll();
            int childCount = RecyclerAnimationScrollHelper.this.recyclerView.getChildCount();
            int height2 = 0;
            int top = 0;
            int bottom = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = RecyclerAnimationScrollHelper.this.recyclerView.getChildAt(i10);
                arrayList.add(childAt);
                if (childAt.getTop() < top) {
                    top = childAt.getTop();
                }
                if (childAt.getBottom() > bottom) {
                    bottom = childAt.getBottom();
                }
                RecyclerView.Adapter adapter = this.val$adapter;
                if (adapter != null && adapter.hasStableIds()) {
                    long itemId = this.val$adapter.getItemId(RecyclerAnimationScrollHelper.this.recyclerView.getChildAdapterPosition(childAt));
                    if (RecyclerAnimationScrollHelper.this.oldStableIds.containsKey(Long.valueOf(itemId)) && (view2 = (View) RecyclerAnimationScrollHelper.this.oldStableIds.get(Long.valueOf(itemId))) != null) {
                        this.val$oldViews.remove(view2);
                        int top2 = childAt.getTop() - view2.getTop();
                        if (top2 != 0) {
                            i9 = top2;
                        }
                    }
                }
            }
            RecyclerAnimationScrollHelper.this.oldStableIds.clear();
            Iterator it = this.val$oldViews.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                View view3 = (View) it.next();
                int bottom2 = view3.getBottom();
                int top3 = view3.getTop();
                if (bottom2 > height2) {
                    height2 = bottom2;
                }
                if (top3 < i11) {
                    i11 = top3;
                }
                if (view3.getParent() == null) {
                    RecyclerAnimationScrollHelper.this.recyclerView.addView(view3);
                    RecyclerAnimationScrollHelper.this.layoutManager.ignoreView(view3);
                }
            }
            if (this.val$oldViews.isEmpty()) {
                height = Math.abs(i9);
            } else {
                if (!this.val$scrollDown) {
                    height2 = RecyclerAnimationScrollHelper.this.recyclerView.getHeight() - i11;
                }
                height = (this.val$scrollDown ? -top : bottom - RecyclerAnimationScrollHelper.this.recyclerView.getHeight()) + height2;
            }
            final int i12 = height;
            if (RecyclerAnimationScrollHelper.this.animator != null) {
                RecyclerAnimationScrollHelper.this.animator.removeAllListeners();
                RecyclerAnimationScrollHelper.this.animator.cancel();
            }
            RecyclerAnimationScrollHelper.this.animator = ValueAnimator.ofFloat(0.0f, 1.0f);
            ValueAnimator valueAnimator = RecyclerAnimationScrollHelper.this.animator;
            final ArrayList arrayList2 = this.val$oldViews;
            final boolean z = this.val$scrollDown;
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RecyclerAnimationScrollHelper$1$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f$0.lambda$onLayoutChange$0(arrayList2, z, i12, arrayList, valueAnimator2);
                }
            });
            RecyclerAnimationScrollHelper.this.animator.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.RecyclerAnimationScrollHelper.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (RecyclerAnimationScrollHelper.this.animator == null) {
                        return;
                    }
                    RecyclerAnimationScrollHelper.this.recyclerView.scrollAnimationRunning = false;
                    Iterator it2 = AnonymousClass1.this.val$oldViews.iterator();
                    while (it2.hasNext()) {
                        View view4 = (View) it2.next();
                        view4.setTranslationY(0.0f);
                        RecyclerAnimationScrollHelper.this.layoutManager.stopIgnoringView(view4);
                        RecyclerAnimationScrollHelper.this.recyclerView.removeView(view4);
                    }
                    RecyclerAnimationScrollHelper.this.recyclerView.setVerticalScrollBarEnabled(true);
                    int childCount2 = RecyclerAnimationScrollHelper.this.recyclerView.getChildCount();
                    for (int i13 = 0; i13 < childCount2; i13++) {
                        RecyclerAnimationScrollHelper.this.recyclerView.getChildAt(i13).setTranslationY(0.0f);
                    }
                    AnimatableAdapter animatableAdapter = AnonymousClass1.this.val$finalAnimatableAdapter;
                    if (animatableAdapter != null) {
                        animatableAdapter.onAnimationEnd();
                    }
                    AnimationCallback unused = RecyclerAnimationScrollHelper.this.animationCallback;
                    RecyclerAnimationScrollHelper.this.positionToOldView.clear();
                    RecyclerAnimationScrollHelper.this.animator = null;
                }
            });
            RecyclerAnimationScrollHelper.this.recyclerView.removeOnLayoutChangeListener(this);
            long measuredHeight = (long) (((i12 / RecyclerAnimationScrollHelper.this.recyclerView.getMeasuredHeight()) + 1.0f) * 200.0f);
            if (measuredHeight < 80) {
                measuredHeight = 80;
            }
            RecyclerAnimationScrollHelper.this.animator.setDuration(Math.min(measuredHeight, 1300L));
            RecyclerAnimationScrollHelper.this.animator.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
            RecyclerAnimationScrollHelper.this.animator.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLayoutChange$0(ArrayList arrayList, boolean z, int i, ArrayList arrayList2, ValueAnimator valueAnimator) {
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

    public void setScrollDirection(int i) {
        this.scrollDirection = i;
    }

    public static abstract class AnimatableAdapter extends RecyclerListViewEdited.SelectionAdapter {
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
        public void notifyItemRangeInserted(int i, int i2) {
            if (!this.animationRunning) {
                super.notifyItemRangeInserted(i, i2);
            } else {
                this.rangeInserted.add(Integer.valueOf(i));
                this.rangeInserted.add(Integer.valueOf(i2));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRemoved(int i) {
            if (!this.animationRunning) {
                super.notifyItemRemoved(i);
            } else {
                this.rangeRemoved.add(Integer.valueOf(i));
                this.rangeRemoved.add(1);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeRemoved(int i, int i2) {
            if (!this.animationRunning) {
                super.notifyItemRangeRemoved(i, i2);
            } else {
                this.rangeRemoved.add(Integer.valueOf(i));
                this.rangeRemoved.add(Integer.valueOf(i2));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemChanged(int i) {
            if (this.animationRunning) {
                return;
            }
            super.notifyItemChanged(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeChanged(int i, int i2) {
            if (this.animationRunning) {
                return;
            }
            super.notifyItemRangeChanged(i, i2);
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
