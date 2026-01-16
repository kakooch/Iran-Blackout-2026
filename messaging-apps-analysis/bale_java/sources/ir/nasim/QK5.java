package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.QK5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes6.dex */
public final class QK5 {
    public static final a h = new a(null);
    public static final int i = 8;
    private final RecyclerView a;
    private final LinearLayoutManager b;
    private SparseArray c;
    private boolean d;
    private int e;
    private ValueAnimator f;
    private final HashMap g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public interface b {
    }

    public static final class c implements View.OnLayoutChangeListener {
        final /* synthetic */ RecyclerView.h b;
        final /* synthetic */ ArrayList c;
        final /* synthetic */ boolean d;

        public static final class a extends AnimatorListenerAdapter {
            final /* synthetic */ QK5 a;
            final /* synthetic */ ArrayList b;
            final /* synthetic */ ArrayList c;

            a(QK5 qk5, ArrayList arrayList, ArrayList arrayList2) {
                this.a = qk5;
                this.b = arrayList;
                this.c = arrayList2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AbstractC13042fc3.i(animator, "animation");
                if (this.a.f == null) {
                    return;
                }
                this.a.d = false;
                Iterator it = this.b.iterator();
                AbstractC13042fc3.h(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    AbstractC13042fc3.h(next, "next(...)");
                    View view = (View) next;
                    view.setTranslationY(0.0f);
                    this.a.b.N1(view);
                    this.a.a.removeView(view);
                }
                this.a.a.setVerticalScrollBarEnabled(true);
                int childCount = this.a.a.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    this.a.a.getChildAt(i).setTranslationY(0.0f);
                }
                Iterator it2 = this.c.iterator();
                AbstractC13042fc3.h(it2, "iterator(...)");
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    AbstractC13042fc3.h(next2, "next(...)");
                    ((View) next2).setTranslationY(0.0f);
                }
                this.a.j().clear();
                this.a.f = null;
            }
        }

        c(RecyclerView.h hVar, ArrayList arrayList, boolean z) {
            this.b = hVar;
            this.c = arrayList;
            this.d = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ArrayList arrayList, QK5 qk5, boolean z, int i, ArrayList arrayList2, ValueAnimator valueAnimator) {
            AbstractC13042fc3.i(arrayList, "$oldViews");
            AbstractC13042fc3.i(qk5, "this$0");
            AbstractC13042fc3.i(arrayList2, "$incomingViews");
            AbstractC13042fc3.i(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            AbstractC13042fc3.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float fFloatValue = ((Float) animatedValue).floatValue();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = arrayList.get(i2);
                AbstractC13042fc3.h(obj, "get(...)");
                View view = (View) obj;
                float y = view.getY();
                if (view.getY() + view.getMeasuredHeight() >= 0.0f && y <= qk5.a.getMeasuredHeight()) {
                    if (z) {
                        view.setTranslationY((-i) * fFloatValue);
                    } else {
                        view.setTranslationY(i * fFloatValue);
                    }
                }
            }
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                Object obj2 = arrayList2.get(i3);
                AbstractC13042fc3.h(obj2, "get(...)");
                View view2 = (View) obj2;
                if (z) {
                    view2.setTranslationY(i * (1.0f - fFloatValue));
                } else {
                    view2.setTranslationY((-i) * (1.0f - fFloatValue));
                }
            }
            qk5.a.invalidate();
            QK5.e(qk5);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int height;
            long jMin;
            View view2;
            AbstractC13042fc3.i(view, "v");
            final ArrayList arrayList = new ArrayList();
            QK5.this.a.stopScroll();
            int childCount = QK5.this.a.getChildCount();
            int top = 0;
            int bottom = 0;
            int i9 = 0;
            boolean z = false;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = QK5.this.a.getChildAt(i10);
                arrayList.add(childAt);
                if (childAt.getTop() < top) {
                    top = childAt.getTop();
                }
                if (childAt.getBottom() > bottom) {
                    bottom = childAt.getBottom();
                }
                RecyclerView.h hVar = this.b;
                if (hVar != null && hVar.hasStableIds()) {
                    long itemId = this.b.getItemId(QK5.this.a.getChildAdapterPosition(childAt));
                    if (QK5.this.g.containsKey(Long.valueOf(itemId)) && (view2 = (View) QK5.this.g.get(Long.valueOf(itemId))) != null) {
                        this.c.remove(view2);
                        int top2 = childAt.getTop() - view2.getTop();
                        if (top2 != 0) {
                            i9 = top2;
                        }
                        z = true;
                    }
                }
            }
            QK5.this.g.clear();
            Iterator it = this.c.iterator();
            AbstractC13042fc3.h(it, "iterator(...)");
            int i11 = Integer.MAX_VALUE;
            int height2 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                AbstractC13042fc3.h(next, "next(...)");
                View view3 = (View) next;
                int bottom2 = view3.getBottom();
                int top3 = view3.getTop();
                if (bottom2 > height2) {
                    height2 = bottom2;
                }
                if (top3 < i11) {
                    i11 = top3;
                }
                if (view3.getParent() == null) {
                    QK5.this.a.addView(view3);
                    QK5.this.b.s0(view3);
                }
            }
            int i12 = i11 != Integer.MAX_VALUE ? i11 : 0;
            if (this.c.isEmpty()) {
                height = (int) Math.abs(i9);
            } else {
                if (!this.d) {
                    height2 = QK5.this.a.getHeight() - i12;
                }
                height = (this.d ? -top : bottom - QK5.this.a.getHeight()) + height2;
            }
            ValueAnimator valueAnimator = QK5.this.f;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                valueAnimator.cancel();
            }
            QK5 qk5 = QK5.this;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            final ArrayList arrayList2 = this.c;
            final QK5 qk52 = QK5.this;
            final boolean z2 = this.d;
            final int i13 = height;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.RK5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    QK5.c.b(arrayList2, qk52, z2, i13, arrayList, valueAnimator2);
                }
            });
            valueAnimatorOfFloat.addListener(new a(qk52, arrayList2, arrayList));
            qk5.f = valueAnimatorOfFloat;
            QK5.this.a.removeOnLayoutChangeListener(this);
            if (z) {
                jMin = 600;
            } else {
                long measuredHeight = (long) (((height / QK5.this.a.getMeasuredHeight()) + 1.0f) * 200);
                if (measuredHeight < 300) {
                    measuredHeight = 300;
                }
                jMin = (long) Math.min(measuredHeight, 1300.0d);
            }
            ValueAnimator valueAnimator2 = QK5.this.f;
            if (valueAnimator2 != null) {
                valueAnimator2.setDuration(jMin);
                valueAnimator2.setInterpolator(InterpolatorC12631ew1.h);
                valueAnimator2.start();
            }
        }
    }

    public QK5(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        AbstractC13042fc3.i(linearLayoutManager, "layoutManager");
        this.a = recyclerView;
        this.b = linearLayoutManager;
        this.c = new SparseArray();
        this.g = new HashMap();
    }

    public static final /* synthetic */ b e(QK5 qk5) {
        qk5.getClass();
        return null;
    }

    private final void i() {
        this.a.setVerticalScrollBarEnabled(true);
        this.d = false;
        this.f = null;
        int childCount = this.a.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.a.getChildAt(i2).setTranslationY(0.0f);
        }
    }

    public final void h() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        i();
    }

    public final SparseArray j() {
        return this.c;
    }

    public final void k(int i2, int i3) {
        if (this.d) {
            return;
        }
        RecyclerView.m itemAnimator = this.a.getItemAnimator();
        if (itemAnimator == null || !itemAnimator.p()) {
            if (this.e == -1) {
                this.b.E2(i2, i3);
                return;
            }
            int childCount = this.a.getChildCount();
            if (childCount == 0) {
                this.b.E2(i2, i3);
                return;
            }
            boolean z = this.e == 0;
            ArrayList arrayList = new ArrayList();
            this.c.clear();
            RecyclerView.h adapter = this.a.getAdapter();
            this.g.clear();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = this.a.getChildAt(i4);
                arrayList.add(childAt);
                this.c.put(this.b.i0(childAt), childAt);
                if (adapter != null && adapter.hasStableIds()) {
                    this.g.put(Long.valueOf(this.a.getChildItemId(childAt)), childAt);
                }
            }
            this.b.E2(i2, i3);
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            this.a.stopScroll();
            this.a.setVerticalScrollBarEnabled(false);
            this.d = true;
            this.a.addOnLayoutChangeListener(new c(adapter, arrayList, z));
        }
    }

    public final void l(int i2) {
        this.e = i2;
    }
}
