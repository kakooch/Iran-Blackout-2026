package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Property;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class RecyclerItemsEnterAnimator {
    boolean alwaysCheckItemsAlpha;
    boolean invalidateAlpha;
    private final RecyclerListView listView;
    private final SparseArray<Float> listAlphaItems = new SparseArray<>();
    HashSet<View> ignoreView = new HashSet<>();
    ArrayList<AnimatorSet> currentAnimations = new ArrayList<>();
    ArrayList<ViewTreeObserver.OnPreDrawListener> preDrawListeners = new ArrayList<>();

    public RecyclerItemsEnterAnimator(RecyclerListView listView, boolean alwaysCheckItemsAlpha) {
        this.listView = listView;
        this.alwaysCheckItemsAlpha = alwaysCheckItemsAlpha;
    }

    public void dispatchDraw() {
        if (this.invalidateAlpha || this.alwaysCheckItemsAlpha) {
            for (int i = 0; i < this.listView.getChildCount(); i++) {
                View childAt = this.listView.getChildAt(i);
                int childAdapterPosition = this.listView.getChildAdapterPosition(childAt);
                if (childAdapterPosition >= 0 && !this.ignoreView.contains(childAt)) {
                    Float f = this.listAlphaItems.get(childAdapterPosition, null);
                    if (f == null) {
                        childAt.setAlpha(1.0f);
                    } else {
                        childAt.setAlpha(f.floatValue());
                    }
                }
            }
            this.invalidateAlpha = false;
        }
    }

    public void showItemsAnimated(int from) {
        int childCount = this.listView.getChildCount();
        final View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = this.listView.getChildAt(i);
            if (this.listView.getChildAdapterPosition(childAt) >= 0 && (childAt instanceof FlickerLoadingView)) {
                view = childAt;
            }
        }
        final RecyclerView.LayoutManager layoutManager = this.listView.getLayoutManager();
        if (view != null && layoutManager != null) {
            this.listView.removeView(view);
            this.ignoreView.add(view);
            this.listView.addView(view);
            layoutManager.ignoreView(view);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, view.getAlpha(), 0.0f);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.RecyclerItemsEnterAnimator.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    view.setAlpha(1.0f);
                    layoutManager.stopIgnoringView(view);
                    RecyclerItemsEnterAnimator.this.ignoreView.remove(view);
                    RecyclerItemsEnterAnimator.this.listView.removeView(view);
                }
            });
            objectAnimatorOfFloat.start();
            from--;
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(view, from);
        this.preDrawListeners.add(anonymousClass2);
        this.listView.getViewTreeObserver().addOnPreDrawListener(anonymousClass2);
    }

    /* renamed from: ir.eitaa.ui.Components.RecyclerItemsEnterAnimator$2, reason: invalid class name */
    class AnonymousClass2 implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ int val$finalFrom;
        final /* synthetic */ View val$finalProgressView;

        AnonymousClass2(final View val$finalProgressView, final int val$finalFrom) {
            this.val$finalProgressView = val$finalProgressView;
            this.val$finalFrom = val$finalFrom;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            RecyclerItemsEnterAnimator.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
            RecyclerItemsEnterAnimator.this.preDrawListeners.remove(this);
            int childCount = RecyclerItemsEnterAnimator.this.listView.getChildCount();
            final AnimatorSet animatorSet = new AnimatorSet();
            for (int i = 0; i < childCount; i++) {
                View childAt = RecyclerItemsEnterAnimator.this.listView.getChildAt(i);
                final int childAdapterPosition = RecyclerItemsEnterAnimator.this.listView.getChildAdapterPosition(childAt);
                if (childAt != this.val$finalProgressView && childAdapterPosition >= this.val$finalFrom - 1 && RecyclerItemsEnterAnimator.this.listAlphaItems.get(childAdapterPosition, null) == null) {
                    RecyclerItemsEnterAnimator.this.listAlphaItems.put(childAdapterPosition, Float.valueOf(0.0f));
                    RecyclerItemsEnterAnimator recyclerItemsEnterAnimator = RecyclerItemsEnterAnimator.this;
                    recyclerItemsEnterAnimator.invalidateAlpha = true;
                    recyclerItemsEnterAnimator.listView.invalidate();
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$RecyclerItemsEnterAnimator$2$9Tfxa66EwDQ_TCEGpcro9Kj9Nv8
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.f$0.lambda$onPreDraw$0$RecyclerItemsEnterAnimator$2(childAdapterPosition, valueAnimator);
                        }
                    });
                    valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.RecyclerItemsEnterAnimator.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            RecyclerItemsEnterAnimator.this.listAlphaItems.remove(childAdapterPosition);
                            RecyclerItemsEnterAnimator recyclerItemsEnterAnimator2 = RecyclerItemsEnterAnimator.this;
                            recyclerItemsEnterAnimator2.invalidateAlpha = true;
                            recyclerItemsEnterAnimator2.listView.invalidate();
                        }
                    });
                    valueAnimatorOfFloat.setStartDelay((int) ((Math.min(RecyclerItemsEnterAnimator.this.listView.getMeasuredHeight(), Math.max(0, childAt.getTop())) / RecyclerItemsEnterAnimator.this.listView.getMeasuredHeight()) * 100.0f));
                    valueAnimatorOfFloat.setDuration(200L);
                    animatorSet.playTogether(valueAnimatorOfFloat);
                }
            }
            RecyclerItemsEnterAnimator.this.currentAnimations.add(animatorSet);
            animatorSet.start();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.RecyclerItemsEnterAnimator.2.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    RecyclerItemsEnterAnimator.this.currentAnimations.remove(animatorSet);
                    if (RecyclerItemsEnterAnimator.this.currentAnimations.isEmpty()) {
                        RecyclerItemsEnterAnimator.this.listAlphaItems.clear();
                        RecyclerItemsEnterAnimator recyclerItemsEnterAnimator2 = RecyclerItemsEnterAnimator.this;
                        recyclerItemsEnterAnimator2.invalidateAlpha = true;
                        recyclerItemsEnterAnimator2.listView.invalidate();
                    }
                }
            });
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onPreDraw$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onPreDraw$0$RecyclerItemsEnterAnimator$2(int i, ValueAnimator valueAnimator) {
            RecyclerItemsEnterAnimator.this.listAlphaItems.put(i, (Float) valueAnimator.getAnimatedValue());
            RecyclerItemsEnterAnimator recyclerItemsEnterAnimator = RecyclerItemsEnterAnimator.this;
            recyclerItemsEnterAnimator.invalidateAlpha = true;
            recyclerItemsEnterAnimator.listView.invalidate();
        }
    }

    public void onDetached() {
        cancel();
    }

    public void cancel() {
        if (!this.currentAnimations.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.currentAnimations);
            for (int i = 0; i < arrayList.size(); i++) {
                ((AnimatorSet) arrayList.get(i)).end();
                ((AnimatorSet) arrayList.get(i)).cancel();
            }
        }
        this.currentAnimations.clear();
        for (int i2 = 0; i2 < this.preDrawListeners.size(); i2++) {
            this.listView.getViewTreeObserver().removeOnPreDrawListener(this.preDrawListeners.get(i2));
        }
        this.preDrawListeners.clear();
        this.listAlphaItems.clear();
        this.listView.invalidate();
        this.invalidateAlpha = true;
    }
}
