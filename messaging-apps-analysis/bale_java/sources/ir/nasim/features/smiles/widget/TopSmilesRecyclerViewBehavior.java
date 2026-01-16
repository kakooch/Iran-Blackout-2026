package ir.nasim.features.smiles.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.C20827sg2;
import ir.nasim.C6551Nz3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0015\n\u0002\b\u001c\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001c\u001a\u00020\r2\b\b\u0001\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ?\u0010#\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010$JW\u0010+\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0018¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b/\u00100J\u001d\u00102\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u0018¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u0018¢\u0006\u0004\b4\u0010.J)\u00106\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u00101\u001a\u00020\u00182\b\b\u0002\u00105\u001a\u00020\u0007¢\u0006\u0004\b6\u00107R\"\u0010=\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010.\"\u0004\b;\u0010<R\"\u0010A\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u00109\u001a\u0004\b?\u0010.\"\u0004\b@\u0010<R*\u0010D\u001a\u00020\u00182\u0006\u0010B\u001a\u00020\u00188\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bC\u00109\u001a\u0004\bD\u0010.\"\u0004\bE\u0010<R\u0016\u0010H\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010\u000eR\u0018\u0010K\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010R\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010MR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010U¨\u0006W"}, d2 = {"Lir/nasim/features/smiles/widget/TopSmilesRecyclerViewBehavior;", "Landroid/view/View;", TokenNames.V, "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "<init>", "()V", "child", "", "targetY", "", "duration", "Landroid/animation/TimeInterpolator;", "interpolator", "Lir/nasim/rB7;", TokenNames.F, "(Landroid/view/View;IJLandroid/animation/TimeInterpolator;)V", "dy", "Landroidx/recyclerview/widget/RecyclerView;", "rc", "G", "(Landroid/view/View;ILandroidx/recyclerview/widget/RecyclerView;)V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", "layoutDirection", "", "l", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;I)Z", "offset", TokenNames.L, "(ILandroid/view/View;)V", "coordinatorLayout", "directTargetChild", "target", "nestedScrollAxes", "type", "A", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;Landroid/view/View;II)Z", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "", "consumed", "t", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;IIIII[I)V", TokenNames.K, "()Z", "Q", "(Landroid/view/View;)V", "animate", TokenNames.R, "(Landroid/view/View;Z)V", "J", "targetTranslationY", "H", "(Landroid/view/View;ZI)V", "a", "Z", "getShowWhenListEnds", "P", "(Z)V", "showWhenListEnds", "b", "getScrollWithContent", "N", "scrollWithContent", "value", "c", "isSearchOpened", TokenNames.O, "", "d", "currentY", "e", "Landroid/view/View;", "theView", "f", TokenNames.I, "height", "g", "currentState", "h", "additionalHiddenOffsetY", "Landroid/view/ViewPropertyAnimator;", "i", "Landroid/view/ViewPropertyAnimator;", "currentAnimator", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class TopSmilesRecyclerViewBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a, reason: from kotlin metadata */
    private boolean showWhenListEnds;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean scrollWithContent;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean isSearchOpened;

    /* renamed from: d, reason: from kotlin metadata */
    private float currentY;

    /* renamed from: e, reason: from kotlin metadata */
    private View theView;

    /* renamed from: f, reason: from kotlin metadata */
    private int height;

    /* renamed from: g, reason: from kotlin metadata */
    private int currentState = 2;

    /* renamed from: h, reason: from kotlin metadata */
    private int additionalHiddenOffsetY;

    /* renamed from: i, reason: from kotlin metadata */
    private ViewPropertyAnimator currentAnimator;

    public static final class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            TopSmilesRecyclerViewBehavior.this.currentAnimator = null;
        }
    }

    public static final class b extends RecyclerView.t {
        final /* synthetic */ int a;
        final /* synthetic */ RecyclerView b;
        final /* synthetic */ float c;
        final /* synthetic */ TopSmilesRecyclerViewBehavior d;
        final /* synthetic */ View e;

        b(int i, RecyclerView recyclerView, float f, TopSmilesRecyclerViewBehavior topSmilesRecyclerViewBehavior, View view) {
            this.a = i;
            this.b = recyclerView;
            this.c = f;
            this.d = topSmilesRecyclerViewBehavior;
            this.e = view;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            if (i == 0) {
                if (this.a > 0 && this.b.computeVerticalScrollOffset() > Math.abs(this.c)) {
                    TopSmilesRecyclerViewBehavior.I(this.d, this.e, true, 0, 4, null);
                }
                this.b.removeOnScrollListener(this);
            }
        }
    }

    private final void F(View child, int targetY, long duration, TimeInterpolator interpolator) {
        this.currentAnimator = child.animate().translationY(targetY).setInterpolator(interpolator).setDuration(duration).setListener(new a());
    }

    private final void G(View child, int dy, RecyclerView rc) {
        RecyclerView.C cFindViewHolderForAdapterPosition;
        float f = (-this.height) + this.additionalHiddenOffsetY;
        rc.addOnScrollListener(new b(dy, rc, f, this, child));
        if (dy <= 0 || (cFindViewHolderForAdapterPosition = rc.findViewHolderForAdapterPosition(0)) == null || cFindViewHolderForAdapterPosition.a.getTop() < rc.getPaddingTop()) {
            float f2 = this.currentY - dy;
            this.currentY = f2;
            if (f2 > 0.0f) {
                this.currentY = 0.0f;
            } else {
                int i = this.height;
                if (f2 < (-i) * 3) {
                    this.currentY = (-i) * 3.0f;
                }
            }
            float fD = AbstractC23053wG5.d(f, this.currentY);
            this.currentState = fD == f ? 1 : 2;
            child.setTranslationY(fD);
        }
    }

    public static /* synthetic */ void I(TopSmilesRecyclerViewBehavior topSmilesRecyclerViewBehavior, View view, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            i = (-topSmilesRecyclerViewBehavior.height) + topSmilesRecyclerViewBehavior.additionalHiddenOffsetY;
        }
        topSmilesRecyclerViewBehavior.H(view, z, i);
    }

    public static /* synthetic */ void M(TopSmilesRecyclerViewBehavior topSmilesRecyclerViewBehavior, int i, View view, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            view = null;
        }
        topSmilesRecyclerViewBehavior.L(i, view);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean A(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes, int type) {
        AbstractC13042fc3.i(coordinatorLayout, "coordinatorLayout");
        AbstractC13042fc3.i(child, "child");
        AbstractC13042fc3.i(directTargetChild, "directTargetChild");
        AbstractC13042fc3.i(target, "target");
        return nestedScrollAxes == 2;
    }

    public final void H(View child, boolean animate, int targetTranslationY) {
        AbstractC13042fc3.i(child, "child");
        if (J()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
        if (viewPropertyAnimator != null) {
            AbstractC13042fc3.f(viewPropertyAnimator);
            viewPropertyAnimator.cancel();
            child.clearAnimation();
        }
        this.currentState = 1;
        if (animate) {
            F(child, targetTranslationY, 175L, new C20827sg2());
        } else {
            child.setTranslationY(targetTranslationY);
        }
        this.currentY = targetTranslationY;
    }

    public final boolean J() {
        return this.currentState == 1;
    }

    public final boolean K() {
        return this.currentState == 2;
    }

    public final void L(int offset, View child) {
        this.additionalHiddenOffsetY = offset;
        if (child == null || this.currentState != 1) {
            return;
        }
        child.setTranslationY(this.height - offset);
    }

    public final void N(boolean z) {
        this.scrollWithContent = z;
    }

    public final void O(boolean z) {
        View view = this.theView;
        if (view != null) {
            if (z) {
                I(this, view, false, 0, 4, null);
            } else {
                R(view, true);
            }
        }
        this.isSearchOpened = z;
    }

    public final void P(boolean z) {
        this.showWhenListEnds = z;
    }

    public final void Q(View child) {
        AbstractC13042fc3.i(child, "child");
        R(child, true);
    }

    public final void R(View child, boolean animate) {
        AbstractC13042fc3.i(child, "child");
        if (K()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
        if (viewPropertyAnimator != null) {
            AbstractC13042fc3.f(viewPropertyAnimator);
            viewPropertyAnimator.cancel();
            child.clearAnimation();
        }
        this.currentState = 2;
        if (animate) {
            F(child, 0, 225L, new C6551Nz3());
        } else {
            child.setTranslationY(0);
        }
        this.currentY = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(CoordinatorLayout parent, View child, int layoutDirection) {
        AbstractC13042fc3.i(parent, "parent");
        AbstractC13042fc3.i(child, "child");
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        this.height = child.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        this.theView = child;
        return super.l(parent, child, layoutDirection);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void t(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        AbstractC13042fc3.i(coordinatorLayout, "coordinatorLayout");
        AbstractC13042fc3.i(child, "child");
        AbstractC13042fc3.i(target, "target");
        AbstractC13042fc3.i(consumed, "consumed");
        if (this.isSearchOpened) {
            I(this, child, false, 0, 4, null);
            return;
        }
        if (this.showWhenListEnds && !target.canScrollVertically(1)) {
            R(child, true);
            return;
        }
        if (this.scrollWithContent) {
            RecyclerView recyclerView = target instanceof RecyclerView ? (RecyclerView) target : null;
            if (recyclerView != null) {
                G(child, dyConsumed, recyclerView);
            }
        } else if (dyConsumed > 0) {
            I(this, child, false, 0, 6, null);
        } else if (dyConsumed < 0) {
            Q(child);
        }
        super.t(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);
    }
}
