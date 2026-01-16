package com.google.android.exoplayer2.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import ir.nasim.AbstractC12190eB5;
import ir.nasim.VB5;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class w {
    private boolean A;
    private boolean B;
    private final StyledPlayerControlView a;
    private final View b;
    private final ViewGroup c;
    private final ViewGroup d;
    private final ViewGroup e;
    private final ViewGroup f;
    private final ViewGroup g;
    private final ViewGroup h;
    private final ViewGroup i;
    private final View j;
    private final View k;
    private final AnimatorSet l;
    private final AnimatorSet m;
    private final AnimatorSet n;
    private final AnimatorSet o;
    private final AnimatorSet p;
    private final ValueAnimator q;
    private final ValueAnimator r;
    private final Runnable s = new Runnable() { // from class: com.google.android.exoplayer2.ui.j
        @Override // java.lang.Runnable
        public final void run() {
            this.a.c0();
        }
    };
    private final Runnable t = new Runnable() { // from class: com.google.android.exoplayer2.ui.p
        @Override // java.lang.Runnable
        public final void run() {
            this.a.D();
        }
    };
    private final Runnable u = new Runnable() { // from class: com.google.android.exoplayer2.ui.q
        @Override // java.lang.Runnable
        public final void run() {
            this.a.H();
        }
    };
    private final Runnable v = new Runnable() { // from class: com.google.android.exoplayer2.ui.r
        @Override // java.lang.Runnable
        public final void run() {
            this.a.G();
        }
    };
    private final Runnable w = new Runnable() { // from class: com.google.android.exoplayer2.ui.s
        @Override // java.lang.Runnable
        public final void run() {
            this.a.E();
        }
    };
    private final View.OnLayoutChangeListener x = new View.OnLayoutChangeListener() { // from class: com.google.android.exoplayer2.ui.t
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.a.R(view, i2, i3, i4, i5, i6, i7, i8, i9);
        }
    };
    private boolean C = true;
    private int z = 0;
    private final List y = new ArrayList();

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (w.this.b != null) {
                w.this.b.setVisibility(4);
            }
            if (w.this.c != null) {
                w.this.c.setVisibility(4);
            }
            if (w.this.e != null) {
                w.this.e.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!(w.this.j instanceof DefaultTimeBar) || w.this.A) {
                return;
            }
            ((DefaultTimeBar) w.this.j).g(250L);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (w.this.b != null) {
                w.this.b.setVisibility(0);
            }
            if (w.this.c != null) {
                w.this.c.setVisibility(0);
            }
            if (w.this.e != null) {
                w.this.e.setVisibility(w.this.A ? 0 : 4);
            }
            if (!(w.this.j instanceof DefaultTimeBar) || w.this.A) {
                return;
            }
            ((DefaultTimeBar) w.this.j).t(250L);
        }
    }

    class c extends AnimatorListenerAdapter {
        final /* synthetic */ StyledPlayerControlView a;

        c(StyledPlayerControlView styledPlayerControlView) {
            this.a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            w.this.Z(1);
            if (w.this.B) {
                this.a.post(w.this.s);
                w.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            w.this.Z(3);
        }
    }

    class d extends AnimatorListenerAdapter {
        final /* synthetic */ StyledPlayerControlView a;

        d(StyledPlayerControlView styledPlayerControlView) {
            this.a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            w.this.Z(2);
            if (w.this.B) {
                this.a.post(w.this.s);
                w.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            w.this.Z(3);
        }
    }

    class e extends AnimatorListenerAdapter {
        final /* synthetic */ StyledPlayerControlView a;

        e(StyledPlayerControlView styledPlayerControlView) {
            this.a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            w.this.Z(2);
            if (w.this.B) {
                this.a.post(w.this.s);
                w.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            w.this.Z(3);
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            w.this.Z(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            w.this.Z(4);
        }
    }

    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            w.this.Z(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            w.this.Z(4);
        }
    }

    class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (w.this.f != null) {
                w.this.f.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (w.this.h != null) {
                w.this.h.setVisibility(0);
                w.this.h.setTranslationX(w.this.h.getWidth());
                w.this.h.scrollTo(w.this.h.getWidth(), 0);
            }
        }
    }

    class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (w.this.h != null) {
                w.this.h.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (w.this.f != null) {
                w.this.f.setVisibility(0);
            }
        }
    }

    public w(StyledPlayerControlView styledPlayerControlView) throws Resources.NotFoundException {
        this.a = styledPlayerControlView;
        this.b = styledPlayerControlView.findViewById(VB5.exo_controls_background);
        this.c = (ViewGroup) styledPlayerControlView.findViewById(VB5.exo_center_controls);
        this.e = (ViewGroup) styledPlayerControlView.findViewById(VB5.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) styledPlayerControlView.findViewById(VB5.exo_bottom_bar);
        this.d = viewGroup;
        this.i = (ViewGroup) styledPlayerControlView.findViewById(VB5.exo_time);
        View viewFindViewById = styledPlayerControlView.findViewById(VB5.exo_progress);
        this.j = viewFindViewById;
        this.f = (ViewGroup) styledPlayerControlView.findViewById(VB5.exo_basic_controls);
        this.g = (ViewGroup) styledPlayerControlView.findViewById(VB5.exo_extra_controls);
        this.h = (ViewGroup) styledPlayerControlView.findViewById(VB5.exo_extra_controls_scroll_view);
        View viewFindViewById2 = styledPlayerControlView.findViewById(VB5.exo_overflow_show);
        this.k = viewFindViewById2;
        View viewFindViewById3 = styledPlayerControlView.findViewById(VB5.exo_overflow_hide);
        if (viewFindViewById2 != null && viewFindViewById3 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.T(view);
                }
            });
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.T(view);
                }
            });
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.v
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.J(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new a());
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.K(valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addListener(new b());
        Resources resources = styledPlayerControlView.getResources();
        float dimension = resources.getDimension(AbstractC12190eB5.exo_styled_bottom_bar_height) - resources.getDimension(AbstractC12190eB5.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(AbstractC12190eB5.exo_styled_bottom_bar_height);
        AnimatorSet animatorSet = new AnimatorSet();
        this.l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new c(styledPlayerControlView));
        animatorSet.play(valueAnimatorOfFloat).with(N(0.0f, dimension, viewFindViewById)).with(N(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new d(styledPlayerControlView));
        animatorSet2.play(N(dimension, dimension2, viewFindViewById)).with(N(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new e(styledPlayerControlView));
        animatorSet3.play(valueAnimatorOfFloat).with(N(0.0f, dimension2, viewFindViewById)).with(N(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new f());
        animatorSet4.play(valueAnimatorOfFloat2).with(N(dimension, 0.0f, viewFindViewById)).with(N(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new g());
        animatorSet5.play(valueAnimatorOfFloat2).with(N(dimension2, 0.0f, viewFindViewById)).with(N(dimension2, 0.0f, viewGroup));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.q = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.setDuration(250L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.n
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.L(valueAnimator);
            }
        });
        valueAnimatorOfFloat3.addListener(new h());
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.r = valueAnimatorOfFloat4;
        valueAnimatorOfFloat4.setDuration(250L);
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.o
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.M(valueAnimator);
            }
        });
        valueAnimatorOfFloat4.addListener(new i());
    }

    private static int B(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.n.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        Z(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        this.l.start();
        U(this.u, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.m.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = this.e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = this.e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private static ObjectAnimator N(float f2, float f3, View view) {
        return ObjectAnimator.ofFloat(view, "translationY", f2, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean zE0 = e0();
        if (this.A != zE0) {
            this.A = zE0;
            view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.l
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.a.d0();
                }
            });
        }
        boolean z = i4 - i2 != i8 - i6;
        if (this.A || !z) {
            return;
        }
        view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.m
            @Override // java.lang.Runnable
            public final void run() {
                this.a.S();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        int i2;
        if (this.f == null || this.g == null) {
            return;
        }
        int width = (this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight();
        while (true) {
            if (this.g.getChildCount() <= 1) {
                break;
            }
            int childCount = this.g.getChildCount() - 2;
            View childAt = this.g.getChildAt(childCount);
            this.g.removeViewAt(childCount);
            this.f.addView(childAt, 0);
        }
        View view = this.k;
        if (view != null) {
            view.setVisibility(8);
        }
        int iB = B(this.i);
        int childCount2 = this.f.getChildCount() - 1;
        for (int i3 = 0; i3 < childCount2; i3++) {
            iB += B(this.f.getChildAt(i3));
        }
        if (iB <= width) {
            ViewGroup viewGroup = this.h;
            if (viewGroup == null || viewGroup.getVisibility() != 0 || this.r.isStarted()) {
                return;
            }
            this.q.cancel();
            this.r.start();
            return;
        }
        View view2 = this.k;
        if (view2 != null) {
            view2.setVisibility(0);
            iB += B(this.k);
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < childCount2; i4++) {
            View childAt2 = this.f.getChildAt(i4);
            iB -= B(childAt2);
            arrayList.add(childAt2);
            if (iB <= width) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f.removeViews(0, arrayList.size());
        for (i2 = 0; i2 < arrayList.size(); i2++) {
            this.g.addView((View) arrayList.get(i2), this.g.getChildCount() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(View view) {
        W();
        if (view.getId() == VB5.exo_overflow_show) {
            this.q.start();
        } else if (view.getId() == VB5.exo_overflow_hide) {
            this.r.start();
        }
    }

    private void U(Runnable runnable, long j) {
        if (j >= 0) {
            this.a.postDelayed(runnable, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i2) {
        int i3 = this.z;
        this.z = i2;
        if (i2 == 2) {
            this.a.setVisibility(8);
        } else if (i3 == 2) {
            this.a.setVisibility(0);
        }
        if (i3 != i2) {
            this.a.i0();
        }
    }

    private boolean a0(View view) {
        int id = view.getId();
        return id == VB5.exo_bottom_bar || id == VB5.exo_prev || id == VB5.exo_next || id == VB5.exo_rew || id == VB5.exo_rew_with_amount || id == VB5.exo_ffwd || id == VB5.exo_ffwd_with_amount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        if (!this.C) {
            Z(0);
            W();
            return;
        }
        int i2 = this.z;
        if (i2 == 1) {
            this.o.start();
        } else if (i2 == 2) {
            this.p.start();
        } else if (i2 == 3) {
            this.B = true;
        } else if (i2 == 4) {
            return;
        }
        W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() throws Resources.NotFoundException {
        ViewGroup viewGroup = this.e;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.A ? 0 : 4);
        }
        if (this.j != null) {
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(AbstractC12190eB5.exo_styled_progress_margin_bottom);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
            if (marginLayoutParams != null) {
                if (this.A) {
                    dimensionPixelSize = 0;
                }
                marginLayoutParams.bottomMargin = dimensionPixelSize;
                this.j.setLayoutParams(marginLayoutParams);
            }
            View view = this.j;
            if (view instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                if (this.A) {
                    defaultTimeBar.h(true);
                } else {
                    int i2 = this.z;
                    if (i2 == 1) {
                        defaultTimeBar.h(false);
                    } else if (i2 != 3) {
                        defaultTimeBar.s();
                    }
                }
            }
        }
        for (View view2 : this.y) {
            view2.setVisibility((this.A && a0(view2)) ? 4 : 0);
        }
    }

    private boolean e0() {
        int width = (this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight();
        int height = (this.a.getHeight() - this.a.getPaddingBottom()) - this.a.getPaddingTop();
        int iB = B(this.c);
        ViewGroup viewGroup = this.c;
        int paddingLeft = iB - (viewGroup != null ? viewGroup.getPaddingLeft() + this.c.getPaddingRight() : 0);
        int iZ = z(this.c);
        ViewGroup viewGroup2 = this.c;
        return width <= Math.max(paddingLeft, B(this.i) + B(this.k)) || height <= (iZ - (viewGroup2 != null ? viewGroup2.getPaddingTop() + this.c.getPaddingBottom() : 0)) + (z(this.d) * 2);
    }

    private void y(float f2) {
        if (this.h != null) {
            this.h.setTranslationX((int) (r0.getWidth() * (1.0f - f2)));
        }
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setAlpha(1.0f - f2);
        }
        ViewGroup viewGroup2 = this.f;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f2);
        }
    }

    private static int z(View view) {
        if (view == null) {
            return 0;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return height;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public boolean A(View view) {
        return view != null && this.y.contains(view);
    }

    public void C() {
        int i2 = this.z;
        if (i2 == 3 || i2 == 2) {
            return;
        }
        V();
        if (!this.C) {
            E();
        } else if (this.z == 1) {
            H();
        } else {
            D();
        }
    }

    public void F() {
        int i2 = this.z;
        if (i2 == 3 || i2 == 2) {
            return;
        }
        V();
        E();
    }

    public boolean I() {
        return this.z == 0 && this.a.h0();
    }

    public void O() {
        this.a.addOnLayoutChangeListener(this.x);
    }

    public void P() {
        this.a.removeOnLayoutChangeListener(this.x);
    }

    public void Q(boolean z, int i2, int i3, int i4, int i5) {
        View view = this.b;
        if (view != null) {
            view.layout(0, 0, i4 - i2, i5 - i3);
        }
    }

    public void V() {
        this.a.removeCallbacks(this.w);
        this.a.removeCallbacks(this.t);
        this.a.removeCallbacks(this.v);
        this.a.removeCallbacks(this.u);
    }

    public void W() {
        if (this.z == 3) {
            return;
        }
        V();
        int showTimeoutMs = this.a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                U(this.w, showTimeoutMs);
            } else if (this.z == 1) {
                U(this.u, 2000L);
            } else {
                U(this.v, showTimeoutMs);
            }
        }
    }

    public void X(boolean z) {
        this.C = z;
    }

    public void Y(View view, boolean z) {
        if (view == null) {
            return;
        }
        if (!z) {
            view.setVisibility(8);
            this.y.remove(view);
            return;
        }
        if (this.A && a0(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        this.y.add(view);
    }

    public void b0() {
        if (!this.a.h0()) {
            this.a.setVisibility(0);
            this.a.s0();
            this.a.n0();
        }
        c0();
    }
}
