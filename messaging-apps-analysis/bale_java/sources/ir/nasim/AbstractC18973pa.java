package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import ir.nasim.B98;
import ir.nasim.O98;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.DrawerLayoutContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.pa, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC18973pa {
    public static final Interpolator A = new InterpolatorC12631ew1(0.19919472913616398d, 0.010644531250000006d, 0.27920937042459737d, 0.91025390625d);
    private boolean a;
    private final View b;
    private View c;
    private ViewGroup d;
    private View e;
    private boolean g;
    private boolean h;
    View m;
    ValueAnimator n;
    protected float q;
    boolean r;
    float s;
    float t;
    boolean u;
    boolean v;
    long w;
    private boolean z;
    private boolean f = false;
    private Runnable i = new a();
    int j = -1;
    int k = -1;
    int l = -1;
    C4347Et o = new C4347Et();
    ArrayList p = new ArrayList();
    ViewTreeObserver.OnPreDrawListener x = new b();
    private boolean y = true;

    /* renamed from: ir.nasim.pa$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator valueAnimator = AbstractC18973pa.this.n;
            if (valueAnimator == null || valueAnimator.isRunning()) {
                return;
            }
            AbstractC18973pa.this.n.start();
        }
    }

    /* renamed from: ir.nasim.pa$b */
    class b implements ViewTreeObserver.OnPreDrawListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            int height = AbstractC18973pa.this.b.getHeight();
            int iX = height - AbstractC18973pa.this.x();
            AbstractC18973pa abstractC18973pa = AbstractC18973pa.this;
            int i = abstractC18973pa.j;
            if (iX == i - abstractC18973pa.l || height == i || abstractC18973pa.n != null) {
                if (abstractC18973pa.n == null) {
                    abstractC18973pa.j = height;
                    abstractC18973pa.k = abstractC18973pa.d.getHeight();
                    AbstractC18973pa abstractC18973pa2 = AbstractC18973pa.this;
                    abstractC18973pa2.l = abstractC18973pa2.x();
                    AbstractC18973pa.this.f = false;
                }
                return true;
            }
            if (!abstractC18973pa.m() || Math.abs(AbstractC18973pa.this.j - height) < AbstractC21455b.F(20.0f)) {
                AbstractC18973pa abstractC18973pa3 = AbstractC18973pa.this;
                abstractC18973pa3.j = height;
                abstractC18973pa3.k = abstractC18973pa3.d.getHeight();
                AbstractC18973pa abstractC18973pa4 = AbstractC18973pa.this;
                abstractC18973pa4.l = abstractC18973pa4.x();
                AbstractC18973pa.this.f = false;
                return true;
            }
            AbstractC18973pa abstractC18973pa5 = AbstractC18973pa.this;
            if (abstractC18973pa5.j == -1 || abstractC18973pa5.k != abstractC18973pa5.d.getHeight()) {
                AbstractC18973pa abstractC18973pa6 = AbstractC18973pa.this;
                abstractC18973pa6.j = height;
                abstractC18973pa6.k = abstractC18973pa6.d.getHeight();
                AbstractC18973pa abstractC18973pa7 = AbstractC18973pa.this;
                abstractC18973pa7.l = abstractC18973pa7.x();
                return false;
            }
            AbstractC18973pa abstractC18973pa8 = AbstractC18973pa.this;
            abstractC18973pa8.v = Math.abs(height - abstractC18973pa8.d.getBottom()) > 200;
            AbstractC18973pa abstractC18973pa9 = AbstractC18973pa.this;
            abstractC18973pa9.h(abstractC18973pa9.j, height, abstractC18973pa9.v);
            AbstractC18973pa abstractC18973pa10 = AbstractC18973pa.this;
            abstractC18973pa10.j = height;
            abstractC18973pa10.k = abstractC18973pa10.d.getHeight();
            AbstractC18973pa abstractC18973pa11 = AbstractC18973pa.this;
            abstractC18973pa11.l = abstractC18973pa11.x();
            return false;
        }
    }

    /* renamed from: ir.nasim.pa$c */
    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (AbstractC18973pa.this.f) {
                return;
            }
            AbstractC18973pa.this.z();
        }
    }

    /* renamed from: ir.nasim.pa$d */
    class d extends B98.b {
        d(int i) {
            super(i);
        }

        @Override // ir.nasim.B98.b
        public void c(B98 b98) {
            if (!AbstractC18973pa.this.g || AbstractC21455b.i < 90.0f) {
                return;
            }
            AbstractC18973pa.this.z();
        }

        @Override // ir.nasim.B98.b
        public O98 e(O98 o98, List list) {
            B98 b98;
            if (AbstractC18973pa.this.g && AbstractC21455b.i >= 90.0f) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        b98 = null;
                        break;
                    }
                    b98 = (B98) it.next();
                    if ((b98.c() & O98.m.d()) != 0) {
                        break;
                    }
                }
                if (b98 != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    AbstractC18973pa abstractC18973pa = AbstractC18973pa.this;
                    if (jElapsedRealtime >= abstractC18973pa.w) {
                        abstractC18973pa.f = true;
                        AbstractC18973pa.this.A(b98.b());
                    }
                }
            }
            return o98;
        }
    }

    public AbstractC18973pa(View view, boolean z) {
        this.a = z;
        this.b = view;
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.na
            @Override // java.lang.Runnable
            public final void run() {
                this.a.o();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i, int i2, boolean z) {
        if (this.z) {
            this.z = false;
            return;
        }
        if (this.y) {
            y(i, i2, z);
            this.n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.oa
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.a.n(valueAnimator);
                }
            });
            int i3 = C22477vI7.f;
            this.n.addListener(new c());
            this.n.setDuration(250L);
            this.n.setInterpolator(A);
            this.o.a();
            if (!this.h) {
                this.n.start();
                this.w = -1L;
            } else {
                this.h = false;
                this.w = SystemClock.elapsedRealtime() + 100;
                AbstractC21455b.n1(this.i, 100L);
            }
        }
    }

    private View j(View view) {
        View view2 = this.c;
        if (view2 != null) {
            return view2;
        }
        while (view != null) {
            if (!(view.getParent() instanceof DrawerLayoutContainer)) {
                if (!(view.getParent() instanceof View)) {
                    break;
                }
                view = (View) view.getParent();
            } else {
                return view;
            }
        }
        return null;
    }

    private Activity k(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextThemeWrapper) {
            return k(((ContextThemeWrapper) context).getBaseContext());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(ValueAnimator valueAnimator) {
        if (this.f) {
            return;
        }
        A(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private void w() {
        if (this.e == null) {
            return;
        }
        AbstractC12990fW7.N0(this.e, new d(1));
    }

    public void A(float f) {
        if (this.u) {
            f = 1.0f - f;
        }
        float f2 = (int) ((this.s * f) + (this.t * (1.0f - f)));
        this.b.setTranslationY(f2);
        q(-f2, f, this.v);
    }

    public boolean i() {
        return this.g;
    }

    public void l(View view) {
        this.p.clear();
        while (view != null) {
            this.p.add(view);
            if (view == this.e) {
                return;
            } else {
                view = view.getParent() instanceof View ? (View) view.getParent() : null;
            }
        }
    }

    protected abstract boolean m();

    public void o() {
        p();
        Activity activityK = k(this.b.getContext());
        if (activityK != null) {
            this.d = (ViewGroup) ((ViewGroup) activityK.getWindow().getDecorView()).findViewById(android.R.id.content);
        }
        View viewJ = j(this.b);
        this.e = viewJ;
        if (viewJ != null) {
            this.m = viewJ;
            viewJ.getViewTreeObserver().addOnPreDrawListener(this.x);
        }
        if (this.a) {
            w();
        }
    }

    public void p() {
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        View view = this.m;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this.x);
            this.m = null;
        }
        View view2 = this.b;
        if (view2 == null || !this.a) {
            return;
        }
        AbstractC12990fW7.N0(view2, null);
    }

    protected void t(boolean z, int i, int i2) {
        s(z, i2);
    }

    public void u(FrameLayout frameLayout) {
        this.c = frameLayout;
    }

    public void v(int i) {
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            ((View) this.p.get(i2)).getLayoutParams().height = i;
            ((View) this.p.get(i2)).requestLayout();
        }
    }

    protected int x() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void y(int r7, int r8, boolean r9) {
        /*
            r6 = this;
            android.animation.ValueAnimator r0 = r6.n
            if (r0 == 0) goto L7
            r0.cancel()
        L7:
            int r0 = r6.x()
            android.view.View r1 = r6.b
            r6.l(r1)
            boolean r1 = r6.r
            r2 = 0
            if (r1 == 0) goto L27
            android.view.View r1 = r6.b
            android.view.ViewParent r1 = r1.getParent()
            boolean r3 = r1 instanceof android.view.View
            if (r3 == 0) goto L27
            android.view.View r1 = (android.view.View) r1
            int r1 = r1.getHeight()
            int r1 = r1 - r8
            goto L28
        L27:
            r1 = r2
        L28:
            int r1 = r1 + r8
            int r1 = java.lang.Math.max(r7, r1)
            r6.v(r1)
            android.view.View r1 = r6.e
            r1.requestLayout()
            r6.t(r9, r7, r8)
            int r1 = r8 - r7
            float r1 = (float) r1
            float r3 = java.lang.Math.abs(r1)
            r6.q = r3
            r3 = 1
            r6.g = r3
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            if (r8 <= r7) goto L5b
            float r7 = (float) r0
            float r1 = r1 - r7
            android.view.View r7 = r6.b
            float r8 = -r1
            r7.setTranslationY(r8)
            r6.q(r1, r4, r9)
            r6.s = r8
            r6.t = r5
            r6.u = r3
            goto L74
        L5b:
            android.view.View r7 = r6.b
            int r8 = r6.l
            float r8 = (float) r8
            r7.setTranslationY(r8)
            int r7 = r6.l
            int r7 = -r7
            float r7 = (float) r7
            r6.q(r7, r5, r9)
            int r7 = r6.l
            int r7 = -r7
            float r7 = (float) r7
            r6.t = r7
            r6.s = r1
            r6.u = r2
        L74:
            r7 = 2
            float[] r7 = new float[r7]
            r7 = {x0084: FILL_ARRAY_DATA , data: [0, 1065353216} // fill-array
            android.animation.ValueAnimator r7 = android.animation.ValueAnimator.ofFloat(r7)
            r6.n = r7
            r6.f = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18973pa.y(int, int, boolean):void");
    }

    public void z() {
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.g = false;
        this.f = false;
        this.o.b();
        this.n = null;
        v(-1);
        this.p.clear();
        this.e.requestLayout();
        boolean z = this.v;
        q(0.0f, z ? 1.0f : 0.0f, z);
        this.b.setTranslationY(0.0f);
        r();
    }

    protected void r() {
    }

    protected void s(boolean z, int i) {
    }

    protected void q(float f, float f2, boolean z) {
    }
}
