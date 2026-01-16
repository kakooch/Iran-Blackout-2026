package com.google.android.material.bottomsheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC22000uV3;
import ir.nasim.AbstractC23026wD5;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C10345bV3;
import ir.nasim.C11411cx6;
import ir.nasim.C22013uW7;
import ir.nasim.GE5;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.X2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int d0 = AbstractC21175tE5.Widget_Design_BottomSheet_Modal;
    private ValueAnimator A;
    int B;
    int C;
    int D;
    float E;
    int F;
    float G;
    boolean H;
    private boolean I;
    private boolean J;
    int K;
    int L;
    C22013uW7 M;
    private boolean N;
    private int O;
    private boolean P;
    private int Q;
    int R;
    int S;
    WeakReference T;
    WeakReference U;
    private final ArrayList V;
    private VelocityTracker W;
    int X;
    private int Y;
    boolean Z;
    private int a;
    private Map a0;
    private boolean b;
    private int b0;
    private boolean c;
    private final C22013uW7.c c0;
    private float d;
    private int e;
    private boolean f;
    private int g;
    private int h;
    private C10345bV3 i;
    private ColorStateList j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private C11411cx6 x;
    private boolean y;
    private final g z;

    class a implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ int b;

        a(View view, int i) {
            this.a = view;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.R0(this.a, this.b, false);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.i != null) {
                BottomSheetBehavior.this.i.c0(fFloatValue);
            }
        }
    }

    class c implements AbstractC10402bY7.e {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
        @Override // ir.nasim.AbstractC10402bY7.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ir.nasim.O98 a(android.view.View r11, ir.nasim.O98 r12, ir.nasim.AbstractC10402bY7.f r13) {
            /*
                r10 = this;
                int r0 = ir.nasim.O98.m.i()
                ir.nasim.L93 r0 = r12.f(r0)
                int r1 = ir.nasim.O98.m.f()
                ir.nasim.L93 r1 = r12.f(r1)
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r3 = r0.b
                com.google.android.material.bottomsheet.BottomSheetBehavior.N(r2, r3)
                boolean r2 = ir.nasim.AbstractC10402bY7.j(r11)
                int r3 = r11.getPaddingBottom()
                int r4 = r11.getPaddingLeft()
                int r5 = r11.getPaddingRight()
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.O(r6)
                if (r6 == 0) goto L41
                com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = r12.j()
                com.google.android.material.bottomsheet.BottomSheetBehavior.Q(r3, r6)
                int r3 = r13.d
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.P(r6)
                int r3 = r3 + r6
            L41:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.R(r6)
                if (r6 == 0) goto L53
                if (r2 == 0) goto L4e
                int r4 = r13.c
                goto L50
            L4e:
                int r4 = r13.a
            L50:
                int r6 = r0.a
                int r4 = r4 + r6
            L53:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.S(r6)
                if (r6 == 0) goto L66
                if (r2 == 0) goto L60
                int r13 = r13.a
                goto L62
            L60:
                int r13 = r13.c
            L62:
                int r2 = r0.c
                int r5 = r13 + r2
            L66:
                android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
                android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.T(r2)
                r6 = 0
                r7 = 1
                if (r2 == 0) goto L80
                int r2 = r13.leftMargin
                int r8 = r0.a
                if (r2 == r8) goto L80
                r13.leftMargin = r8
                r2 = r7
                goto L81
            L80:
                r2 = r6
            L81:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.U(r8)
                if (r8 == 0) goto L92
                int r8 = r13.rightMargin
                int r9 = r0.c
                if (r8 == r9) goto L92
                r13.rightMargin = r9
                r2 = r7
            L92:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.F(r8)
                if (r8 == 0) goto La3
                int r8 = r13.topMargin
                int r0 = r0.b
                if (r8 == r0) goto La3
                r13.topMargin = r0
                goto La4
            La3:
                r7 = r2
            La4:
                if (r7 == 0) goto La9
                r11.setLayoutParams(r13)
            La9:
                int r13 = r11.getPaddingTop()
                r11.setPadding(r4, r13, r5, r3)
                boolean r11 = r10.a
                if (r11 == 0) goto Lbb
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r13 = r1.d
                com.google.android.material.bottomsheet.BottomSheetBehavior.G(r11, r13)
            Lbb:
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.O(r11)
                if (r11 != 0) goto Lc7
                boolean r11 = r10.a
                if (r11 == 0) goto Lcc
            Lc7:
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                com.google.android.material.bottomsheet.BottomSheetBehavior.H(r11, r6)
            Lcc:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.c.a(android.view.View, ir.nasim.O98, ir.nasim.bY7$f):ir.nasim.O98");
        }
    }

    class d extends C22013uW7.c {
        private long a;

        d() {
        }

        private boolean n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.S + bottomSheetBehavior.h0()) / 2;
        }

        @Override // ir.nasim.C22013uW7.c
        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // ir.nasim.C22013uW7.c
        public int b(View view, int i, int i2) {
            int iH0 = BottomSheetBehavior.this.h0();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return AbstractC22000uV3.b(i, iH0, bottomSheetBehavior.H ? bottomSheetBehavior.S : bottomSheetBehavior.F);
        }

        @Override // ir.nasim.C22013uW7.c
        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.H ? bottomSheetBehavior.S : bottomSheetBehavior.F;
        }

        @Override // ir.nasim.C22013uW7.c
        public void j(int i) {
            if (i == 1 && BottomSheetBehavior.this.J) {
                BottomSheetBehavior.this.K0(1);
            }
        }

        @Override // ir.nasim.C22013uW7.c
        public void k(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.d0(i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
        @Override // ir.nasim.C22013uW7.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l(android.view.View r8, float r9, float r10) {
            /*
                Method dump skipped, instructions count: 302
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d.l(android.view.View, float, float):void");
        }

        @Override // ir.nasim.C22013uW7.c
        public boolean m(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.K;
            if (i2 == 1 || bottomSheetBehavior.Z) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.X == i) {
                WeakReference weakReference = bottomSheetBehavior.U;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.a = System.currentTimeMillis();
            WeakReference weakReference2 = BottomSheetBehavior.this.T;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    class e implements InterfaceC10698c3 {
        final /* synthetic */ int a;

        e(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC10698c3
        public boolean a(View view, InterfaceC10698c3.a aVar) {
            BottomSheetBehavior.this.J0(this.a);
            return true;
        }
    }

    public static abstract class f {
        void a(View view) {
        }

        public abstract void b(View view, float f);

        public abstract void c(View view, int i);
    }

    public BottomSheetBehavior() {
        this.a = 0;
        this.b = true;
        this.c = false;
        this.k = -1;
        this.l = -1;
        this.z = new g(this, null);
        this.E = 0.5f;
        this.G = -1.0f;
        this.J = true;
        this.K = 4;
        this.L = 4;
        this.V = new ArrayList();
        this.b0 = -1;
        this.c0 = new d();
    }

    private void L0(View view) {
        boolean z = (Build.VERSION.SDK_INT < 29 || n0() || this.f) ? false : true;
        if (this.o || this.p || this.q || this.s || this.t || this.u || z) {
            AbstractC10402bY7.c(view, new c(z));
        }
    }

    private boolean N0() {
        return this.M != null && (this.J || this.K == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(View view, int i, boolean z) {
        int iL0 = l0(i);
        C22013uW7 c22013uW7 = this.M;
        if (c22013uW7 == null || (!z ? c22013uW7.R(view, view.getLeft(), iL0) : c22013uW7.P(view.getLeft(), iL0))) {
            K0(i);
            return;
        }
        K0(2);
        T0(i);
        this.z.c(i);
    }

    private void S0() {
        View view;
        WeakReference weakReference = this.T;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        AbstractC12990fW7.j0(view, 524288);
        AbstractC12990fW7.j0(view, 262144);
        AbstractC12990fW7.j0(view, 1048576);
        int i = this.b0;
        if (i != -1) {
            AbstractC12990fW7.j0(view, i);
        }
        if (!this.b && this.K != 6) {
            this.b0 = V(view, AbstractC23026wD5.bottomsheet_action_expand_halfway, 6);
        }
        if (this.H && this.K != 5) {
            s0(view, X2.a.y, 5);
        }
        int i2 = this.K;
        if (i2 == 3) {
            s0(view, X2.a.x, this.b ? 4 : 6);
            return;
        }
        if (i2 == 4) {
            s0(view, X2.a.w, this.b ? 3 : 6);
        } else {
            if (i2 != 6) {
                return;
            }
            s0(view, X2.a.x, 4);
            s0(view, X2.a.w, 3);
        }
    }

    private void T0(int i) {
        ValueAnimator valueAnimator;
        if (i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.y != z) {
            this.y = z;
            if (this.i == null || (valueAnimator = this.A) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.A.reverse();
                return;
            }
            float f2 = z ? 0.0f : 1.0f;
            this.A.setFloatValues(1.0f - f2, f2);
            this.A.start();
        }
    }

    private void U0(boolean z) {
        Map map;
        WeakReference weakReference = this.T;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.a0 != null) {
                    return;
                } else {
                    this.a0 = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.T.get()) {
                    if (z) {
                        this.a0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.c) {
                            AbstractC12990fW7.A0(childAt, 4);
                        }
                    } else if (this.c && (map = this.a0) != null && map.containsKey(childAt)) {
                        AbstractC12990fW7.A0(childAt, ((Integer) this.a0.get(childAt)).intValue());
                    }
                }
            }
            if (!z) {
                this.a0 = null;
            } else if (this.c) {
                ((View) this.T.get()).sendAccessibilityEvent(8);
            }
        }
    }

    private int V(View view, int i, int i2) {
        return AbstractC12990fW7.c(view, view.getResources().getString(i), a0(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(boolean z) {
        View view;
        if (this.T != null) {
            X();
            if (this.K != 4 || (view = (View) this.T.get()) == null) {
                return;
            }
            if (z) {
                J0(4);
            } else {
                view.requestLayout();
            }
        }
    }

    private void X() {
        int iZ = Z();
        if (this.b) {
            this.F = Math.max(this.S - iZ, this.C);
        } else {
            this.F = this.S - iZ;
        }
    }

    private void Y() {
        this.D = (int) (this.S * (1.0f - this.E));
    }

    private int Z() {
        int i;
        return this.f ? Math.min(Math.max(this.g, this.S - ((this.R * 9) / 16)), this.Q) + this.v : (this.n || this.o || (i = this.m) <= 0) ? this.e + this.v : Math.max(this.e, i + this.h);
    }

    private InterfaceC10698c3 a0(int i) {
        return new e(i);
    }

    private void b0(Context context) {
        if (this.x == null) {
            return;
        }
        C10345bV3 c10345bV3 = new C10345bV3(this.x);
        this.i = c10345bV3;
        c10345bV3.Q(context);
        ColorStateList colorStateList = this.j;
        if (colorStateList != null) {
            this.i.b0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.i.setTint(typedValue.data);
    }

    private void c0() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.A = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.A.addUpdateListener(new b());
    }

    public static BottomSheetBehavior f0(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.e)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.e) layoutParams).f();
        if (behaviorF instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behaviorF;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    private int g0(int i, int i2, int i3, int i4) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), 1073741824);
        }
        if (size != 0) {
            i3 = Math.min(size, i3);
        }
        return View.MeasureSpec.makeMeasureSpec(i3, RecyclerView.UNDEFINED_DURATION);
    }

    private int l0(int i) {
        if (i == 3) {
            return h0();
        }
        if (i == 4) {
            return this.F;
        }
        if (i == 5) {
            return this.S;
        }
        if (i == 6) {
            return this.D;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i);
    }

    private float m0() {
        VelocityTracker velocityTracker = this.W;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, this.d);
        return this.W.getYVelocity(this.X);
    }

    private boolean p0(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && AbstractC12990fW7.S(view);
    }

    private void s0(View view, X2.a aVar, int i) {
        AbstractC12990fW7.l0(view, aVar, null, a0(i));
    }

    private void t0() {
        this.X = -1;
        VelocityTracker velocityTracker = this.W;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.W = null;
        }
    }

    private void u0(SavedState savedState) {
        int i = this.a;
        if (i == 0) {
            return;
        }
        if (i == -1 || (i & 1) == 1) {
            this.e = savedState.d;
        }
        if (i == -1 || (i & 2) == 2) {
            this.b = savedState.e;
        }
        if (i == -1 || (i & 4) == 4) {
            this.H = savedState.f;
        }
        if (i == -1 || (i & 8) == 8) {
            this.I = savedState.g;
        }
    }

    private void v0(View view, Runnable runnable) {
        if (p0(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        this.O = 0;
        this.P = false;
        return (i & 2) != 0;
    }

    public void A0(boolean z) {
        this.n = z;
    }

    public void B0(float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.E = f2;
        if (this.T != null) {
            Y();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a9  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.h0()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.K0(r0)
            return
        Lf:
            boolean r3 = r2.q0()
            if (r3 == 0) goto L24
            java.lang.ref.WeakReference r3 = r2.U
            if (r3 == 0) goto L23
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L23
            boolean r3 = r2.P
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            int r3 = r2.O
            r5 = 6
            if (r3 <= 0) goto L39
            boolean r3 = r2.b
            if (r3 == 0) goto L2f
            goto Laa
        L2f:
            int r3 = r4.getTop()
            int r6 = r2.D
            if (r3 <= r6) goto Laa
            goto La9
        L39:
            boolean r3 = r2.H
            if (r3 == 0) goto L49
            float r3 = r2.m0()
            boolean r3 = r2.O0(r4, r3)
            if (r3 == 0) goto L49
            r0 = 5
            goto Laa
        L49:
            int r3 = r2.O
            r6 = 4
            if (r3 != 0) goto L8e
            int r3 = r4.getTop()
            boolean r1 = r2.b
            if (r1 == 0) goto L68
            int r5 = r2.C
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.F
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L92
            goto Laa
        L68:
            int r1 = r2.D
            if (r3 >= r1) goto L7e
            int r1 = r2.F
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L77
            goto Laa
        L77:
            boolean r3 = r2.P0()
            if (r3 == 0) goto La9
            goto L92
        L7e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.F
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
            goto La9
        L8e:
            boolean r3 = r2.b
            if (r3 == 0) goto L94
        L92:
            r0 = r6
            goto Laa
        L94:
            int r3 = r4.getTop()
            int r0 = r2.D
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.F
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
        La9:
            r0 = r5
        Laa:
            r3 = 0
            r2.R0(r4, r0, r3)
            r2.P = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.C(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    public void C0(boolean z) {
        if (this.H != z) {
            this.H = z;
            if (!z && this.K == 5) {
                J0(4);
            }
            S0();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.K == 1 && actionMasked == 0) {
            return true;
        }
        if (N0()) {
            this.M.G(motionEvent);
        }
        if (actionMasked == 0) {
            t0();
        }
        if (this.W == null) {
            this.W = VelocityTracker.obtain();
        }
        this.W.addMovement(motionEvent);
        if (N0() && actionMasked == 2 && !this.N && Math.abs(this.Y - motionEvent.getY()) > this.M.A()) {
            this.M.c(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.N;
    }

    public void D0(int i) {
        this.l = i;
    }

    public void E0(int i) {
        this.k = i;
    }

    public void F0(int i) {
        G0(i, false);
    }

    public final void G0(int i, boolean z) {
        if (i == -1) {
            if (this.f) {
                return;
            } else {
                this.f = true;
            }
        } else {
            if (!this.f && this.e == i) {
                return;
            }
            this.f = false;
            this.e = Math.max(0, i);
        }
        V0(z);
    }

    public void H0(int i) {
        this.a = i;
    }

    public void I0(boolean z) {
        this.I = z;
    }

    public void J0(int i) {
        if (i == 1 || i == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (!this.H && i == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i);
            return;
        }
        int i2 = (i == 6 && this.b && l0(i) <= this.C) ? 3 : i;
        WeakReference weakReference = this.T;
        if (weakReference == null || weakReference.get() == null) {
            K0(i);
        } else {
            View view = (View) this.T.get();
            v0(view, new a(view, i2));
        }
    }

    void K0(int i) {
        View view;
        if (this.K == i) {
            return;
        }
        this.K = i;
        if (i == 4 || i == 3 || i == 6 || (this.H && i == 5)) {
            this.L = i;
        }
        WeakReference weakReference = this.T;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            U0(true);
        } else if (i == 6 || i == 5 || i == 4) {
            U0(false);
        }
        T0(i);
        for (int i2 = 0; i2 < this.V.size(); i2++) {
            ((f) this.V.get(i2)).c(view, i);
        }
        S0();
    }

    public boolean M0(long j, float f2) {
        return false;
    }

    boolean O0(View view, float f2) {
        if (this.I) {
            return true;
        }
        if (view.getTop() < this.F) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.F)) / ((float) Z()) > 0.5f;
    }

    public boolean P0() {
        return false;
    }

    public boolean Q0() {
        return true;
    }

    public void W(f fVar) {
        if (this.V.contains(fVar)) {
            return;
        }
        this.V.add(fVar);
    }

    void d0(int i) {
        float f2;
        float fH0;
        View view = (View) this.T.get();
        if (view == null || this.V.isEmpty()) {
            return;
        }
        int i2 = this.F;
        if (i > i2 || i2 == h0()) {
            int i3 = this.F;
            f2 = i3 - i;
            fH0 = this.S - i3;
        } else {
            int i4 = this.F;
            f2 = i4 - i;
            fH0 = i4 - h0();
        }
        float f3 = f2 / fH0;
        for (int i5 = 0; i5 < this.V.size(); i5++) {
            ((f) this.V.get(i5)).b(view, f3);
        }
    }

    View e0(View view) {
        if (AbstractC12990fW7.U(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewE0 = e0(viewGroup.getChildAt(i));
            if (viewE0 != null) {
                return viewE0;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void g(CoordinatorLayout.e eVar) {
        super.g(eVar);
        this.T = null;
        this.M = null;
    }

    public int h0() {
        if (this.b) {
            return this.C;
        }
        return Math.max(this.B, this.r ? 0 : this.w);
    }

    C10345bV3 i0() {
        return this.i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void j() {
        super.j();
        this.T = null;
        this.M = null;
    }

    public int j0() {
        if (this.f) {
            return -1;
        }
        return this.e;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        C22013uW7 c22013uW7;
        if (!view.isShown() || !this.J) {
            this.N = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            t0();
        }
        if (this.W == null) {
            this.W = VelocityTracker.obtain();
        }
        this.W.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.Y = (int) motionEvent.getY();
            if (this.K != 2) {
                WeakReference weakReference = this.U;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.F(view2, x, this.Y)) {
                    this.X = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.Z = true;
                }
            }
            this.N = this.X == -1 && !coordinatorLayout.F(view, x, this.Y);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.Z = false;
            this.X = -1;
            if (this.N) {
                this.N = false;
                return false;
            }
        }
        if (!this.N && (c22013uW7 = this.M) != null && c22013uW7.Q(motionEvent)) {
            return true;
        }
        WeakReference weakReference2 = this.U;
        View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
        return (actionMasked != 2 || view3 == null || this.N || this.K == 1 || coordinatorLayout.F(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.M == null || Math.abs(((float) this.Y) - motionEvent.getY()) <= ((float) this.M.A())) ? false : true;
    }

    public int k0() {
        return this.K;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (AbstractC12990fW7.x(coordinatorLayout) && !AbstractC12990fW7.x(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.T == null) {
            this.g = coordinatorLayout.getResources().getDimensionPixelSize(AbstractC12799fB5.design_bottom_sheet_peek_height_min);
            L0(view);
            this.T = new WeakReference(view);
            C10345bV3 c10345bV3 = this.i;
            if (c10345bV3 != null) {
                AbstractC12990fW7.t0(view, c10345bV3);
                C10345bV3 c10345bV32 = this.i;
                float fV = this.G;
                if (fV == -1.0f) {
                    fV = AbstractC12990fW7.v(view);
                }
                c10345bV32.a0(fV);
                boolean z = this.K == 3;
                this.y = z;
                this.i.c0(z ? 0.0f : 1.0f);
            } else {
                ColorStateList colorStateList = this.j;
                if (colorStateList != null) {
                    AbstractC12990fW7.u0(view, colorStateList);
                }
            }
            S0();
            if (AbstractC12990fW7.y(view) == 0) {
                AbstractC12990fW7.A0(view, 1);
            }
        }
        if (this.M == null) {
            this.M = C22013uW7.p(coordinatorLayout, this.c0);
        }
        int top = view.getTop();
        coordinatorLayout.M(view, i);
        this.R = coordinatorLayout.getWidth();
        this.S = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.Q = height;
        int i2 = this.S;
        int i3 = i2 - height;
        int i4 = this.w;
        if (i3 < i4) {
            if (this.r) {
                this.Q = i2;
            } else {
                this.Q = i2 - i4;
            }
        }
        this.C = Math.max(0, i2 - this.Q);
        Y();
        X();
        int i5 = this.K;
        if (i5 == 3) {
            AbstractC12990fW7.a0(view, h0());
        } else if (i5 == 6) {
            AbstractC12990fW7.a0(view, this.D);
        } else if (this.H && i5 == 5) {
            AbstractC12990fW7.a0(view, this.S);
        } else if (i5 == 4) {
            AbstractC12990fW7.a0(view, this.F);
        } else if (i5 == 1 || i5 == 2) {
            AbstractC12990fW7.a0(view, top - view.getTop());
        }
        this.U = new WeakReference(e0(view));
        for (int i6 = 0; i6 < this.V.size(); i6++) {
            ((f) this.V.get(i6)).a(view);
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(g0(i, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, this.k, marginLayoutParams.width), g0(i3, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, this.l, marginLayoutParams.height));
        return true;
    }

    public boolean n0() {
        return this.n;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, float f2, float f3) {
        WeakReference weakReference;
        if (q0() && (weakReference = this.U) != null && view2 == weakReference.get()) {
            return this.K != 3 || super.o(coordinatorLayout, view, view2, f2, f3);
        }
        return false;
    }

    public boolean o0() {
        return this.H;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        WeakReference weakReference = this.U;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (!q0() || view2 == view3) {
            int top = view.getTop();
            int i4 = top - i2;
            if (i2 > 0) {
                if (i4 < h0()) {
                    int iH0 = top - h0();
                    iArr[1] = iH0;
                    AbstractC12990fW7.a0(view, -iH0);
                    K0(3);
                } else {
                    if (!this.J) {
                        return;
                    }
                    iArr[1] = i2;
                    AbstractC12990fW7.a0(view, -i2);
                    K0(1);
                }
            } else if (i2 < 0 && !view2.canScrollVertically(-1)) {
                int i5 = this.F;
                if (i4 > i5 && !this.H) {
                    int i6 = top - i5;
                    iArr[1] = i6;
                    AbstractC12990fW7.a0(view, -i6);
                    K0(4);
                } else {
                    if (!this.J) {
                        return;
                    }
                    iArr[1] = i2;
                    AbstractC12990fW7.a0(view, -i2);
                    K0(1);
                }
            }
            d0(view.getTop());
            this.O = i2;
            this.P = true;
        }
    }

    public boolean q0() {
        return true;
    }

    public void r0(f fVar) {
        this.V.remove(fVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    public void w0(f fVar) {
        Log.w("BottomSheetBehavior", "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.V.clear();
        if (fVar != null) {
            this.V.add(fVar);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void x(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.x(coordinatorLayout, view, savedState.a());
        u0(savedState);
        int i = savedState.c;
        if (i == 1 || i == 2) {
            this.K = 4;
            this.L = 4;
        } else {
            this.K = i;
            this.L = i;
        }
    }

    public void x0(boolean z) {
        this.J = z;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable y(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.y(coordinatorLayout, view), this);
    }

    public void y0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.B = i;
    }

    public void z0(boolean z) {
        if (this.b == z) {
            return;
        }
        this.b = z;
        if (this.T != null) {
            X();
        }
        K0((this.b && this.K == 6) ? 3 : this.K);
        S0();
    }

    private class g {
        private int a;
        private boolean b;
        private final Runnable c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.b = false;
                C22013uW7 c22013uW7 = BottomSheetBehavior.this.M;
                if (c22013uW7 != null && c22013uW7.n(true)) {
                    g gVar = g.this;
                    gVar.c(gVar.a);
                    return;
                }
                g gVar2 = g.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.K == 2) {
                    bottomSheetBehavior.K0(gVar2.a);
                }
            }
        }

        private g() {
            this.c = new a();
        }

        void c(int i) {
            WeakReference weakReference = BottomSheetBehavior.this.T;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.a = i;
            if (this.b) {
                return;
            }
            AbstractC12990fW7.h0((View) BottomSheetBehavior.this.T.get(), this.c);
            this.b = true;
        }

        /* synthetic */ g(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        final int c;
        int d;
        boolean e;
        boolean f;
        boolean g;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt() == 1;
            this.f = parcel.readInt() == 1;
            this.g = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e ? 1 : 0);
            parcel.writeInt(this.f ? 1 : 0);
            parcel.writeInt(this.g ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
            super(parcelable);
            this.c = bottomSheetBehavior.K;
            this.d = bottomSheetBehavior.e;
            this.e = bottomSheetBehavior.b;
            this.f = bottomSheetBehavior.H;
            this.g = bottomSheetBehavior.I;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        this.a = 0;
        this.b = true;
        this.c = false;
        this.k = -1;
        this.l = -1;
        this.z = new g(this, null);
        this.E = 0.5f;
        this.G = -1.0f;
        this.J = true;
        this.K = 4;
        this.L = 4;
        this.V = new ArrayList();
        this.b0 = -1;
        this.c0 = new d();
        this.h = context.getResources().getDimensionPixelSize(AbstractC12799fB5.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, GE5.BottomSheetBehavior_Layout);
        if (typedArrayObtainStyledAttributes.hasValue(GE5.BottomSheetBehavior_Layout_backgroundTint)) {
            this.j = AbstractC9751aV3.a(context, typedArrayObtainStyledAttributes, GE5.BottomSheetBehavior_Layout_backgroundTint);
        }
        if (typedArrayObtainStyledAttributes.hasValue(GE5.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.x = C11411cx6.e(context, attributeSet, AbstractC12181eA5.bottomSheetStyle, d0).m();
        }
        b0(context);
        c0();
        this.G = typedArrayObtainStyledAttributes.getDimension(GE5.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(GE5.BottomSheetBehavior_Layout_android_maxWidth)) {
            E0(typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.BottomSheetBehavior_Layout_android_maxWidth, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(GE5.BottomSheetBehavior_Layout_android_maxHeight)) {
            D0(typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.BottomSheetBehavior_Layout_android_maxHeight, -1));
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(GE5.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && (i = typedValuePeekValue.data) == -1) {
            F0(i);
        } else {
            F0(typedArrayObtainStyledAttributes.getDimensionPixelSize(GE5.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        C0(typedArrayObtainStyledAttributes.getBoolean(GE5.BottomSheetBehavior_Layout_behavior_hideable, false));
        A0(typedArrayObtainStyledAttributes.getBoolean(GE5.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        z0(typedArrayObtainStyledAttributes.getBoolean(GE5.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        I0(typedArrayObtainStyledAttributes.getBoolean(GE5.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        x0(typedArrayObtainStyledAttributes.getBoolean(GE5.BottomSheetBehavior_Layout_behavior_draggable, true));
        H0(typedArrayObtainStyledAttributes.getInt(GE5.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        B0(typedArrayObtainStyledAttributes.getFloat(GE5.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(GE5.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            y0(typedValuePeekValue2.data);
        } else {
            y0(typedArrayObtainStyledAttributes.getDimensionPixelOffset(GE5.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        }
        this.o = typedArrayObtainStyledAttributes.getBoolean(GE5.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.p = typedArrayObtainStyledAttributes.getBoolean(GE5.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.q = typedArrayObtainStyledAttributes.getBoolean(GE5.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.r = typedArrayObtainStyledAttributes.getBoolean(GE5.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.s = typedArrayObtainStyledAttributes.getBoolean(GE5.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.t = typedArrayObtainStyledAttributes.getBoolean(GE5.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.u = typedArrayObtainStyledAttributes.getBoolean(GE5.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        this.d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
