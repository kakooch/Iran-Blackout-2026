package ir.nasim.premium.ui.badge.tab;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.q;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC21139tA5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC8943Xx1;
import ir.nasim.C14325hj7;
import ir.nasim.ED1;
import ir.nasim.KB5;
import ir.nasim.OY0;
import ir.nasim.premium.ui.badge.tab.TabLayoutRecycler;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 N2\u00020\u0001:\u0001OB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010\u001bJG\u0010%\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\nH\u0016¢\u0006\u0004\b'\u0010\fR>\u00100\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010(2\u0010\u0010)\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010(8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00106\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u0010\u0018R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00102R\u0016\u0010B\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00102R\u0016\u0010D\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00102R\u0016\u0010F\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00102R\u0014\u0010I\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006P"}, d2 = {"Lir/nasim/premium/ui/badge/tab/TabLayoutRecycler;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "s0", "()V", "r0", "q0", "position", "Landroidx/recyclerview/widget/RecyclerView$C;", "o0", "(I)Landroidx/recyclerview/widget/RecyclerView$C;", "", "p0", "(I)Z", "v0", "m0", "(I)V", "delayedForItemAnimator", "t0", "(IZ)V", "Landroid/view/View;", "target", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "type", "", "consumed", "r", "(Landroid/view/View;IIIII[I)V", "onDetachedFromWindow", "Landroidx/recyclerview/widget/q;", "value", "z", "Landroidx/recyclerview/widget/q;", "getAdapter", "()Landroidx/recyclerview/widget/q;", "setAdapter", "(Landroidx/recyclerview/widget/q;)V", "adapter", "A", TokenNames.I, "getIndicatorWidth", "()I", "setIndicatorWidth", "indicatorWidth", "Landroidx/recyclerview/widget/RecyclerView;", "B", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/LinearLayoutManager;", "D", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "G", "currentSelectedPosition", "H", "pendingSelectedPosition", "J", "animatingSelectedPosition", "z0", "delayedPendingSelectedPosition", "A0", "Landroid/view/View;", "indicator", "Landroid/animation/ValueAnimator;", "B0", "Landroid/animation/ValueAnimator;", "indicatorAnimator", "C0", "a", "premium_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes.dex */
public final class TabLayoutRecycler extends CoordinatorLayout {
    public static final int D0 = 8;
    private static int E0 = -1;

    /* renamed from: A, reason: from kotlin metadata */
    private int indicatorWidth;

    /* renamed from: A0, reason: from kotlin metadata */
    private final View indicator;

    /* renamed from: B, reason: from kotlin metadata */
    private final RecyclerView recyclerView;

    /* renamed from: B0, reason: from kotlin metadata */
    private ValueAnimator indicatorAnimator;

    /* renamed from: D, reason: from kotlin metadata */
    private final LinearLayoutManager layoutManager;

    /* renamed from: G, reason: from kotlin metadata */
    private int currentSelectedPosition;

    /* renamed from: H, reason: from kotlin metadata */
    private int pendingSelectedPosition;

    /* renamed from: J, reason: from kotlin metadata */
    private int animatingSelectedPosition;

    /* renamed from: z, reason: from kotlin metadata */
    private q adapter;

    /* renamed from: z0, reason: from kotlin metadata */
    private int delayedPendingSelectedPosition;

    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            TabLayoutRecycler.this.pendingSelectedPosition = TabLayoutRecycler.E0;
            TabLayoutRecycler.this.animatingSelectedPosition = TabLayoutRecycler.E0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ int b;

        public c(int i) {
            this.b = i;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TabLayoutRecycler.this.currentSelectedPosition = this.b;
            TabLayoutRecycler.this.pendingSelectedPosition = TabLayoutRecycler.E0;
            TabLayoutRecycler.this.animatingSelectedPosition = TabLayoutRecycler.E0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static final class d implements Animator.AnimatorListener {
        final /* synthetic */ int b;

        public d(int i) {
            this.b = i;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TabLayoutRecycler.this.pendingSelectedPosition = this.b;
            TabLayoutRecycler.this.animatingSelectedPosition = this.b;
        }
    }

    public static final class e extends RecyclerView.t {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            if (i == 0) {
                TabLayoutRecycler tabLayoutRecycler = TabLayoutRecycler.this;
                tabLayoutRecycler.m0(tabLayoutRecycler.pendingSelectedPosition);
            }
            super.a(recyclerView, i);
        }
    }

    public static final class f extends h {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public void s(RecyclerView.C c) {
            AbstractC13042fc3.i(c, "viewHolder");
            super.s(c);
            if (c.K() == TabLayoutRecycler.this.delayedPendingSelectedPosition) {
                TabLayoutRecycler tabLayoutRecycler = TabLayoutRecycler.this;
                tabLayoutRecycler.v0(tabLayoutRecycler.delayedPendingSelectedPosition);
                TabLayoutRecycler.this.delayedPendingSelectedPosition = TabLayoutRecycler.E0;
            }
        }
    }

    public static final class g implements C14325hj7.b {
        final /* synthetic */ int b;

        g(int i) {
            this.b = i;
        }

        @Override // ir.nasim.C14325hj7.b
        public void a() {
        }

        @Override // ir.nasim.C14325hj7.b
        public void b() {
            TabLayoutRecycler.this.m0(this.b);
        }

        @Override // ir.nasim.C14325hj7.b
        public void f() {
            TabLayoutRecycler.this.pendingSelectedPosition = this.b;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabLayoutRecycler(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(int position) {
        View view;
        ValueAnimator valueAnimator;
        if (position == this.currentSelectedPosition) {
            return;
        }
        if (position != this.animatingSelectedPosition && (valueAnimator = this.indicatorAnimator) != null) {
            valueAnimator.cancel();
        }
        this.animatingSelectedPosition = position;
        RecyclerView.C cO0 = o0(position);
        if (cO0 == null || (view = cO0.a) == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.indicator.getX(), view.getX());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Qi7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TabLayoutRecycler.n0(this.a, valueAnimator2);
            }
        });
        valueAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        valueAnimatorOfFloat.setDuration(200L);
        AbstractC13042fc3.f(valueAnimatorOfFloat);
        valueAnimatorOfFloat.addListener(new d(position));
        valueAnimatorOfFloat.addListener(new b());
        valueAnimatorOfFloat.addListener(new c(position));
        valueAnimatorOfFloat.start();
        this.indicatorAnimator = valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(TabLayoutRecycler tabLayoutRecycler, ValueAnimator valueAnimator) {
        AbstractC13042fc3.i(tabLayoutRecycler, "this$0");
        AbstractC13042fc3.i(valueAnimator, "it");
        View view = tabLayoutRecycler.indicator;
        Object animatedValue = valueAnimator.getAnimatedValue();
        AbstractC13042fc3.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setX(((Float) animatedValue).floatValue());
    }

    private final RecyclerView.C o0(int position) {
        return this.recyclerView.findViewHolderForAdapterPosition(position);
    }

    private final boolean p0(int position) {
        if (position < 0) {
            return false;
        }
        q qVar = this.adapter;
        return position < (qVar != null ? qVar.getItemCount() : 0);
    }

    private final void q0() {
        if (this.indicator.isAttachedToWindow()) {
            return;
        }
        View view = this.indicator;
        view.setBackground(AbstractC4043Dl1.f(view.getContext(), KB5.smiles_emoji_tab_indicator));
        Context context = this.indicator.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        view.setBackgroundTintList(ColorStateList.valueOf(OY0.b(context, AbstractC21139tA5.colorPrimary)));
        CoordinatorLayout.e eVar = new CoordinatorLayout.e(this.indicatorWidth, AbstractC8943Xx1.c(2));
        eVar.c = 8388691;
        eVar.o(new CoordinatorLayout.Behavior<View>() { // from class: ir.nasim.premium.ui.badge.tab.TabLayoutRecycler$initIndicator$1$params$1$1
            @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
            public boolean A(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes, int type) {
                AbstractC13042fc3.i(coordinatorLayout, "coordinatorLayout");
                AbstractC13042fc3.i(child, "child");
                AbstractC13042fc3.i(directTargetChild, "directTargetChild");
                AbstractC13042fc3.i(target, "target");
                return nestedScrollAxes == 1;
            }
        });
        addView(view, eVar);
        RecyclerView.C cO0 = o0(0);
        View view2 = cO0 != null ? cO0.a : null;
        view.setX(view2 != null ? view2.getX() : 0.0f);
        view.setY(this.recyclerView.getY() + this.recyclerView.getMeasuredHeight());
    }

    private final void r0() {
        if (this.recyclerView.isAttachedToWindow()) {
            return;
        }
        RecyclerView recyclerView = this.recyclerView;
        recyclerView.setPadding(AbstractC8943Xx1.c(5), 0, AbstractC8943Xx1.c(5), 0);
        recyclerView.setClipToPadding(false);
        addView(recyclerView, new CoordinatorLayout.e(-1, -1));
        if (!recyclerView.isInEditMode()) {
            recyclerView.setNestedScrollingEnabled(true);
            recyclerView.setLayoutManager(this.layoutManager);
            recyclerView.setAdapter(this.adapter);
            recyclerView.setHasFixedSize(false);
            recyclerView.setNestedScrollingEnabled(true);
            recyclerView.addOnScrollListener(new e());
        }
        recyclerView.setItemAnimator(new f());
    }

    private final void s0() {
        r0();
        q0();
    }

    public static /* synthetic */ void u0(TabLayoutRecycler tabLayoutRecycler, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        tabLayoutRecycler.t0(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean v0(int position) {
        if (!p0(position)) {
            return false;
        }
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        C14325hj7 c14325hj7 = new C14325hj7(context, C14325hj7.c.e, 0.0f, 4, null);
        c14325hj7.p(position);
        c14325hj7.y(this.indicatorWidth);
        c14325hj7.x(new g(position));
        this.layoutManager.M1(c14325hj7);
        return true;
    }

    public final q getAdapter() {
        return this.adapter;
    }

    public final int getIndicatorWidth() {
        return this.indicatorWidth;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.indicatorAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int i = E0;
        this.pendingSelectedPosition = i;
        this.delayedPendingSelectedPosition = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, ir.nasim.InterfaceC5744Kq4
    public void r(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        AbstractC13042fc3.i(target, "target");
        AbstractC13042fc3.i(consumed, "consumed");
        View view = this.indicator;
        view.setX(view.getX() - dxConsumed);
        super.r(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);
    }

    public final void setAdapter(q qVar) {
        this.adapter = qVar;
        if (qVar != null) {
            s0();
        }
    }

    public final void setIndicatorWidth(int i) {
        this.indicatorWidth = i;
    }

    public final void t0(int position, boolean delayedForItemAnimator) {
        if (delayedForItemAnimator) {
            this.delayedPendingSelectedPosition = position;
        } else {
            v0(position);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabLayoutRecycler(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ TabLayoutRecycler(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabLayoutRecycler(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.indicatorWidth = 40;
        this.recyclerView = new RecyclerView(context);
        this.layoutManager = new LinearLayoutManager(context, 0, false);
        int i2 = E0;
        this.currentSelectedPosition = i2;
        this.pendingSelectedPosition = i2;
        this.animatingSelectedPosition = i2;
        this.delayedPendingSelectedPosition = i2;
        this.indicator = new View(context);
        if (isInEditMode()) {
            s0();
        }
    }
}
