package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.gov.nist.core.Separators;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.ScrollingView;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.A;
import androidx.recyclerview.widget.B;
import androidx.recyclerview.widget.C1975a;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.v;
import ir.nasim.AbstractC11280ck4;
import ir.nasim.AbstractC11547dB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC18580ot7;
import ir.nasim.AbstractC19927rA5;
import ir.nasim.AbstractC20736sW7;
import ir.nasim.AbstractC22913w2;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.C22317v2;
import ir.nasim.C5276Iq4;
import ir.nasim.InterfaceC5042Hq4;
import ir.nasim.X2;
import ir.nasim.XE5;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, InterfaceC5042Hq4 {
    static final Interpolator A1;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_TYPE = -1;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;
    private static final int[] s1 = {R.attr.nestedScrollingEnabled};
    static final boolean t1 = false;
    static final boolean u1 = true;
    static final boolean v1 = true;
    static final boolean w1 = true;
    private static final boolean x1 = false;
    private static final boolean y1 = false;
    private static final Class[] z1;
    private int A;
    private int A0;
    boolean B;
    private l B0;
    private EdgeEffect C0;
    private final AccessibilityManager D;
    private EdgeEffect D0;
    private EdgeEffect E0;
    private EdgeEffect F0;
    private List G;
    m G0;
    boolean H;
    private int H0;
    private int I0;
    boolean J;
    private VelocityTracker J0;
    private int K0;
    private int L0;
    private int M0;
    private int N0;
    private int O0;
    private r P0;
    private final int Q0;
    private final int R0;
    private float S0;
    private float T0;
    private boolean U0;
    final B V0;
    androidx.recyclerview.widget.k W0;
    k.b X0;
    final z Y0;
    private t Z0;
    private final x a;
    private List a1;
    final v b;
    boolean b1;
    SavedState c;
    boolean c1;
    C1975a d;
    private m.b d1;
    androidx.recyclerview.widget.e e;
    boolean e1;
    final androidx.recyclerview.widget.B f;
    androidx.recyclerview.widget.v f1;
    boolean g;
    private k g1;
    final Runnable h;
    private final int[] h1;
    final Rect i;
    private C5276Iq4 i1;
    private final Rect j;
    private final int[] j1;
    final RectF k;
    private final int[] k1;
    h l;
    final int[] l1;
    p m;
    final List m1;
    w n;
    private Runnable n1;
    final List o;
    private boolean o1;
    final ArrayList p;
    private int p1;
    private final ArrayList q;
    private int q1;
    private s r;
    private final B.b r1;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    private int w;
    boolean x;
    boolean y;
    private boolean z;
    private int z0;

    public static abstract class A {
    }

    class B implements Runnable {
        private int a;
        private int b;
        OverScroller c;
        Interpolator d;
        private boolean e;
        private boolean f;

        B() {
            Interpolator interpolator = RecyclerView.A1;
            this.d = interpolator;
            this.e = false;
            this.f = false;
            this.c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i, int i2) {
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z) {
                iAbs = iAbs2;
            }
            return Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        }

        private void c() {
            RecyclerView.this.removeCallbacks(this);
            AbstractC12990fW7.h0(RecyclerView.this, this);
        }

        public void b(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.b = 0;
            this.a = 0;
            Interpolator interpolator = this.d;
            Interpolator interpolator2 = RecyclerView.A1;
            if (interpolator != interpolator2) {
                this.d = interpolator2;
                this.c = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.c.fling(0, 0, i, i2, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
            d();
        }

        void d() {
            if (this.e) {
                this.f = true;
            } else {
                c();
            }
        }

        public void e(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = a(i, i2);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.A1;
            }
            if (this.d != interpolator) {
                this.d = interpolator;
                this.c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.b = 0;
            this.a = 0;
            RecyclerView.this.setScrollState(2);
            this.c.startScroll(0, 0, i, i2, i4);
            d();
        }

        public void f() {
            RecyclerView.this.removeCallbacks(this);
            this.c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.m == null) {
                f();
                return;
            }
            this.f = false;
            this.e = true;
            recyclerView.v();
            OverScroller overScroller = this.c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.a;
                int i4 = currY - this.b;
                this.a = currX;
                this.b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.l1;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i3, i4, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.l1;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.u(i3, i4);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.l != null) {
                    int[] iArr3 = recyclerView3.l1;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.N0(i3, i4, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.l1;
                    i2 = iArr4[0];
                    i = iArr4[1];
                    i3 -= i2;
                    i4 -= i;
                    y yVar = recyclerView4.m.g;
                    if (yVar != null && !yVar.g() && yVar.h()) {
                        int iB = RecyclerView.this.Y0.b();
                        if (iB == 0) {
                            yVar.r();
                        } else if (yVar.f() >= iB) {
                            yVar.p(iB - 1);
                            yVar.j(i2, i);
                        } else {
                            yVar.j(i2, i);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.p.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.l1;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i2, i, i3, i4, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.l1;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (i2 != 0 || i != 0) {
                    recyclerView6.H(i2, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                y yVar2 = RecyclerView.this.m.g;
                if ((yVar2 == null || !yVar2.g()) && z) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.b(i7, currVelocity);
                    }
                    if (RecyclerView.w1) {
                        RecyclerView.this.X0.b();
                    }
                } else {
                    d();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.k kVar = recyclerView7.W0;
                    if (kVar != null) {
                        kVar.f(recyclerView7, i2, i);
                    }
                }
            }
            y yVar3 = RecyclerView.this.m.g;
            if (yVar3 != null && yVar3.g()) {
                yVar3.j(0, 0);
            }
            this.e = false;
            if (this.f) {
                c();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.stopNestedScroll(1);
            }
        }
    }

    public static abstract class C {
        private static final List t = Collections.emptyList();
        public final View a;
        WeakReference b;
        int j;
        RecyclerView r;
        h s;
        int c = -1;
        int d = -1;
        long e = -1;
        int f = -1;
        int g = -1;
        C h = null;
        C i = null;
        List k = null;
        List l = null;
        private int m = 0;
        v n = null;
        boolean o = false;
        private int p = 0;
        int q = -1;

        public C(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.a = view;
        }

        private void E() {
            if (this.k == null) {
                ArrayList arrayList = new ArrayList();
                this.k = arrayList;
                this.l = Collections.unmodifiableList(arrayList);
            }
        }

        void A() {
            List list = this.k;
            if (list != null) {
                list.clear();
            }
            this.j &= -1025;
        }

        void A0() {
            this.n.J(this);
        }

        void B() {
            this.j &= -33;
        }

        boolean B0() {
            return (this.j & 32) != 0;
        }

        void D() {
            this.j &= -257;
        }

        boolean G() {
            return (this.j & 16) == 0 && AbstractC12990fW7.Q(this.a);
        }

        void H(int i, int i2, boolean z) {
            s(8);
            i0(i2, z);
            this.c = i;
        }

        public final int I() {
            RecyclerView recyclerView = this.r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.V(this);
        }

        public final int J() {
            return K();
        }

        public final int K() {
            RecyclerView recyclerView;
            h adapter;
            int iV;
            if (this.s == null || (recyclerView = this.r) == null || (adapter = recyclerView.getAdapter()) == null || (iV = this.r.V(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.s, this, iV);
        }

        public final long L() {
            return this.e;
        }

        public final int M() {
            return this.f;
        }

        public final int N() {
            int i = this.g;
            return i == -1 ? this.c : i;
        }

        public final int O() {
            return this.d;
        }

        List Q() {
            if ((this.j & 1024) != 0) {
                return t;
            }
            List list = this.k;
            return (list == null || list.size() == 0) ? t : this.l;
        }

        boolean R(int i) {
            return (i & this.j) != 0;
        }

        boolean S() {
            return (this.j & 512) != 0 || X();
        }

        boolean U() {
            return (this.a.getParent() == null || this.a.getParent() == this.r) ? false : true;
        }

        boolean V() {
            return (this.j & 1) != 0;
        }

        boolean X() {
            return (this.j & 4) != 0;
        }

        public final boolean Z() {
            return (this.j & 16) == 0 && !AbstractC12990fW7.Q(this.a);
        }

        boolean a0() {
            return (this.j & 8) != 0;
        }

        boolean b0() {
            return this.n != null;
        }

        boolean d0() {
            return (this.j & 256) != 0;
        }

        boolean e0() {
            return (this.j & 2) != 0;
        }

        boolean h0() {
            return (this.j & 2) != 0;
        }

        void i0(int i, boolean z) {
            if (this.d == -1) {
                this.d = this.c;
            }
            if (this.g == -1) {
                this.g = this.c;
            }
            if (z) {
                this.g += i;
            }
            this.c += i;
            if (this.a.getLayoutParams() != null) {
                ((LayoutParams) this.a.getLayoutParams()).c = true;
            }
        }

        void j0(RecyclerView recyclerView) {
            int i = this.q;
            if (i != -1) {
                this.p = i;
            } else {
                this.p = AbstractC12990fW7.y(this.a);
            }
            recyclerView.P0(this, 4);
        }

        void l0(RecyclerView recyclerView) {
            recyclerView.P0(this, this.p);
            this.p = 0;
        }

        void m0() {
            this.j = 0;
            this.c = -1;
            this.d = -1;
            this.e = -1L;
            this.g = -1;
            this.m = 0;
            this.h = null;
            this.i = null;
            A();
            this.p = 0;
            this.q = -1;
            RecyclerView.r(this);
        }

        void o0() {
            if (this.d == -1) {
                this.d = this.c;
            }
        }

        void r(Object obj) {
            if (obj == null) {
                s(1024);
            } else if ((1024 & this.j) == 0) {
                E();
                this.k.add(obj);
            }
        }

        void s(int i) {
            this.j = i | this.j;
        }

        void t0(int i, int i2) {
            this.j = (i & i2) | (this.j & (~i2));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.c + " id=" + this.e + ", oldPos=" + this.d + ", pLpos:" + this.g);
            if (b0()) {
                sb.append(" scrap ");
                sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (X()) {
                sb.append(" invalid");
            }
            if (!V()) {
                sb.append(" unbound");
            }
            if (h0()) {
                sb.append(" update");
            }
            if (a0()) {
                sb.append(" removed");
            }
            if (y0()) {
                sb.append(" ignored");
            }
            if (d0()) {
                sb.append(" tmpDetached");
            }
            if (!Z()) {
                sb.append(" not recyclable(" + this.m + Separators.RPAREN);
            }
            if (S()) {
                sb.append(" undefined adapter position");
            }
            if (this.a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void u0(boolean z) {
            int i = this.m;
            int i2 = z ? i - 1 : i + 1;
            this.m = i2;
            if (i2 < 0) {
                this.m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i2 == 1) {
                this.j |= 16;
            } else if (z && i2 == 0) {
                this.j &= -17;
            }
        }

        void v0(v vVar, boolean z) {
            this.n = vVar;
            this.o = z;
        }

        boolean w0() {
            return (this.j & 16) != 0;
        }

        void y() {
            this.d = -1;
            this.g = -1;
        }

        boolean y0() {
            return (this.j & 128) != 0;
        }

        void z0() {
            this.j &= -129;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$a, reason: case insensitive filesystem */
    class RunnableC1972a implements Runnable {
        RunnableC1972a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.v || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.s) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.y) {
                recyclerView2.x = true;
            } else {
                recyclerView2.v();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$b, reason: case insensitive filesystem */
    class RunnableC1973b implements Runnable {
        RunnableC1973b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar = RecyclerView.this.G0;
            if (mVar != null) {
                mVar.v();
            }
            RecyclerView.this.e1 = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$c, reason: case insensitive filesystem */
    class InterpolatorC1974c implements Interpolator {
        InterpolatorC1974c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    class d implements B.b {
        d() {
        }

        @Override // androidx.recyclerview.widget.B.b
        public void a(C c, m.c cVar, m.c cVar2) {
            RecyclerView.this.l(c, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.B.b
        public void b(C c) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.m.p1(c.a, recyclerView.b);
        }

        @Override // androidx.recyclerview.widget.B.b
        public void c(C c, m.c cVar, m.c cVar2) {
            RecyclerView.this.b.J(c);
            RecyclerView.this.n(c, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.B.b
        public void d(C c, m.c cVar, m.c cVar2) {
            c.u0(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.H) {
                if (recyclerView.G0.b(c, c, cVar, cVar2)) {
                    RecyclerView.this.w0();
                }
            } else if (recyclerView.G0.d(c, cVar, cVar2)) {
                RecyclerView.this.w0();
            }
        }
    }

    class e implements e.b {
        e() {
        }

        @Override // androidx.recyclerview.widget.e.b
        public View a(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        @Override // androidx.recyclerview.widget.e.b
        public void b(View view) {
            C cX = RecyclerView.X(view);
            if (cX != null) {
                cX.j0(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.e.b
        public int c() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.e.b
        public C d(View view) {
            return RecyclerView.X(view);
        }

        @Override // androidx.recyclerview.widget.e.b
        public void e(int i) {
            C cX;
            View viewA = a(i);
            if (viewA != null && (cX = RecyclerView.X(viewA)) != null) {
                if (cX.d0() && !cX.y0()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + cX + RecyclerView.this.O());
                }
                cX.s(256);
            }
            RecyclerView.this.detachViewFromParent(i);
        }

        @Override // androidx.recyclerview.widget.e.b
        public void f(View view, int i) {
            RecyclerView.this.addView(view, i);
            RecyclerView.this.z(view);
        }

        @Override // androidx.recyclerview.widget.e.b
        public void g() {
            int iC = c();
            for (int i = 0; i < iC; i++) {
                View viewA = a(i);
                RecyclerView.this.A(viewA);
                viewA.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.e.b
        public int h(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.e.b
        public void i(View view) {
            C cX = RecyclerView.X(view);
            if (cX != null) {
                cX.l0(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.e.b
        public void j(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.A(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }

        @Override // androidx.recyclerview.widget.e.b
        public void k(View view, int i, ViewGroup.LayoutParams layoutParams) {
            C cX = RecyclerView.X(view);
            if (cX != null) {
                if (!cX.d0() && !cX.y0()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + cX + RecyclerView.this.O());
                }
                cX.D();
            }
            RecyclerView.this.attachViewToParent(view, i, layoutParams);
        }
    }

    class f implements C1975a.InterfaceC0110a {
        f() {
        }

        @Override // androidx.recyclerview.widget.C1975a.InterfaceC0110a
        public void a(int i, int i2) {
            RecyclerView.this.q0(i, i2);
            RecyclerView.this.b1 = true;
        }

        @Override // androidx.recyclerview.widget.C1975a.InterfaceC0110a
        public void b(C1975a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.C1975a.InterfaceC0110a
        public void c(C1975a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.C1975a.InterfaceC0110a
        public void d(int i, int i2) {
            RecyclerView.this.r0(i, i2, false);
            RecyclerView.this.b1 = true;
        }

        @Override // androidx.recyclerview.widget.C1975a.InterfaceC0110a
        public void e(int i, int i2, Object obj) {
            RecyclerView.this.V0(i, i2, obj);
            RecyclerView.this.c1 = true;
        }

        @Override // androidx.recyclerview.widget.C1975a.InterfaceC0110a
        public C f(int i) {
            C cU = RecyclerView.this.U(i, true);
            if (cU == null || RecyclerView.this.e.n(cU.a)) {
                return null;
            }
            return cU;
        }

        @Override // androidx.recyclerview.widget.C1975a.InterfaceC0110a
        public void g(int i, int i2) {
            RecyclerView.this.p0(i, i2);
            RecyclerView.this.b1 = true;
        }

        @Override // androidx.recyclerview.widget.C1975a.InterfaceC0110a
        public void h(int i, int i2) {
            RecyclerView.this.r0(i, i2, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.b1 = true;
            recyclerView.Y0.d += i2;
        }

        void i(C1975a.b bVar) {
            int i = bVar.a;
            if (i == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.m.U0(recyclerView, bVar.b, bVar.d);
                return;
            }
            if (i == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.m.X0(recyclerView2, bVar.b, bVar.d);
            } else if (i == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.m.Z0(recyclerView3, bVar.b, bVar.d, bVar.c);
            } else {
                if (i != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.m.W0(recyclerView4, bVar.b, bVar.d, 1);
            }
        }
    }

    static /* synthetic */ class g {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.a.values().length];
            a = iArr;
            try {
                iArr[h.a.PREVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.a.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static abstract class h {
        private final i a = new i();
        private boolean b = false;
        private a c = a.ALLOW;

        public enum a {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public final void bindViewHolder(C c, int i) {
            boolean z = c.s == null;
            if (z) {
                c.c = i;
                if (hasStableIds()) {
                    c.e = getItemId(i);
                }
                c.t0(1, 519);
                AbstractC18580ot7.a("RV OnBindView");
            }
            c.s = this;
            onBindViewHolder(c, i, c.Q());
            if (z) {
                c.A();
                ViewGroup.LayoutParams layoutParams = c.a.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).c = true;
                }
                AbstractC18580ot7.b();
            }
        }

        public final C createViewHolder(ViewGroup viewGroup, int i) {
            try {
                AbstractC18580ot7.a("RV CreateView");
                C cOnCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (cOnCreateViewHolder.a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                cOnCreateViewHolder.f = i;
                return cOnCreateViewHolder;
            } finally {
                AbstractC18580ot7.b();
            }
        }

        public int findRelativeAdapterPositionIn(h hVar, C c, int i) {
            if (hVar == this) {
                return i;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final a getStateRestorationPolicy() {
            return this.c;
        }

        public final boolean hasObservers() {
            return this.a.a();
        }

        public final boolean hasStableIds() {
            return this.b;
        }

        public final void notifyDataSetChanged() {
            this.a.b();
        }

        public final void notifyItemChanged(int i) {
            this.a.d(i, 1);
        }

        public final void notifyItemInserted(int i) {
            this.a.f(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.a.c(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.a.d(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.a.f(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.a.g(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.a.g(i, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(C c, int i);

        public void onBindViewHolder(C c, int i, List<Object> list) {
            onBindViewHolder(c, i);
        }

        public abstract C onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(C c) {
            return false;
        }

        public void onViewAttachedToWindow(C c) {
        }

        public void onViewDetachedFromWindow(C c) {
        }

        public void onViewRecycled(C c) {
        }

        public void registerAdapterDataObserver(j jVar) {
            this.a.registerObserver(jVar);
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.b = z;
        }

        public void setStateRestorationPolicy(a aVar) {
            this.c = aVar;
            this.a.h();
        }

        public void unregisterAdapterDataObserver(j jVar) {
            this.a.unregisterObserver(jVar);
        }

        boolean y() {
            int i = g.a[this.c.ordinal()];
            if (i != 1) {
                return i != 2 || getItemCount() > 0;
            }
            return false;
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.a.e(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.a.e(i, i2, obj);
        }
    }

    static class i extends Observable {
        i() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).e(i, i2, 1);
            }
        }

        public void d(int i, int i2) {
            e(i, i2, null);
        }

        public void e(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).c(i, i2, obj);
            }
        }

        public void f(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).d(i, i2);
            }
        }

        public void g(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).f(i, i2);
            }
        }

        public void h() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((j) ((Observable) this).mObservers.get(size)).g();
            }
        }
    }

    public static abstract class j {
        public void a() {
        }

        public void b(int i, int i2) {
        }

        public void c(int i, int i2, Object obj) {
            b(i, i2);
        }

        public void d(int i, int i2) {
        }

        public void e(int i, int i2, int i3) {
        }

        public void f(int i, int i2) {
        }

        public void g() {
        }
    }

    public interface k {
        int a(int i, int i2);
    }

    public static class l {
        protected EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class m {
        private b a = null;
        private ArrayList b = new ArrayList();
        private long c = 120;
        private long d = 120;
        private long e = 250;
        private long f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(C c);
        }

        public static class c {
            public int a;
            public int b;
            public int c;
            public int d;

            public c a(C c) {
                return b(c, 0);
            }

            public c b(C c, int i) {
                View view = c.a;
                this.a = view.getLeft();
                this.b = view.getTop();
                this.c = view.getRight();
                this.d = view.getBottom();
                return this;
            }
        }

        static int e(C c2) {
            int i = c2.j;
            int i2 = i & 14;
            if (c2.X()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i2;
            }
            int iO = c2.O();
            int I = c2.I();
            return (iO == -1 || I == -1 || iO == I) ? i2 : i2 | 2048;
        }

        public void A(long j) {
            this.d = j;
        }

        public abstract boolean a(C c2, c cVar, c cVar2);

        public abstract boolean b(C c2, C c3, c cVar, c cVar2);

        public abstract boolean c(C c2, c cVar, c cVar2);

        public abstract boolean d(C c2, c cVar, c cVar2);

        public abstract boolean f(C c2);

        public boolean g(C c2, List list) {
            return f(c2);
        }

        public final void h(C c2) {
            s(c2);
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(c2);
            }
        }

        public final void i() {
            if (this.b.size() <= 0) {
                this.b.clear();
            } else {
                AbstractC18350oW3.a(this.b.get(0));
                throw null;
            }
        }

        public abstract void j(C c2);

        public abstract void k();

        public long l() {
            return this.c;
        }

        public long m() {
            return this.f;
        }

        public long n() {
            return this.e;
        }

        public long o() {
            return this.d;
        }

        public abstract boolean p();

        public final boolean q(a aVar) {
            boolean zP = p();
            if (aVar != null) {
                if (zP) {
                    this.b.add(aVar);
                } else {
                    aVar.a();
                }
            }
            return zP;
        }

        public c r() {
            return new c();
        }

        public void s(C c2) {
        }

        public c t(z zVar, C c2) {
            return r().a(c2);
        }

        public c u(z zVar, C c2, int i, List list) {
            return r().a(c2);
        }

        public abstract void v();

        public void w(long j) {
            this.c = j;
        }

        public void x(long j) {
            this.f = j;
        }

        void y(b bVar) {
            this.a = bVar;
        }

        public void z(long j) {
            this.e = j;
        }
    }

    private class n implements m.b {
        n() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m.b
        public void a(C c) {
            c.u0(true);
            if (c.h != null && c.i == null) {
                c.h = null;
            }
            c.i = null;
            if (c.w0() || RecyclerView.this.F0(c.a) || !c.d0()) {
                return;
            }
            RecyclerView.this.removeDetachedView(c.a, false);
        }
    }

    public static abstract class o {
        public void f(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void g(Rect rect, View view, RecyclerView recyclerView, z zVar) {
            f(rect, ((LayoutParams) view.getLayoutParams()).a(), recyclerView);
        }

        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, z zVar) {
            h(canvas, recyclerView);
        }

        public void j(Canvas canvas, RecyclerView recyclerView) {
        }

        public void k(Canvas canvas, RecyclerView recyclerView, z zVar) {
            j(canvas, recyclerView);
        }
    }

    public interface q {
        void b(View view);

        void d(View view);
    }

    public static abstract class r {
        public abstract boolean a(int i, int i2);
    }

    public interface s {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean c(RecyclerView recyclerView, MotionEvent motionEvent);

        void e(boolean z);
    }

    public static abstract class t {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class u {
        SparseArray a = new SparseArray();
        private int b = 0;

        static class a {
            final ArrayList a = new ArrayList();
            int b = 5;
            long c = 0;
            long d = 0;

            a() {
            }
        }

        private a g(int i) {
            a aVar = (a) this.a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.a.put(i, aVar2);
            return aVar2;
        }

        void a() {
            this.b++;
        }

        public void b() {
            for (int i = 0; i < this.a.size(); i++) {
                ((a) this.a.valueAt(i)).a.clear();
            }
        }

        void c() {
            this.b--;
        }

        void d(int i, long j) {
            a aVarG = g(i);
            aVarG.d = j(aVarG.d, j);
        }

        void e(int i, long j) {
            a aVarG = g(i);
            aVarG.c = j(aVarG.c, j);
        }

        public C f(int i) {
            a aVar = (a) this.a.get(i);
            if (aVar == null || aVar.a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = aVar.a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((C) arrayList.get(size)).U()) {
                    return (C) arrayList.remove(size);
                }
            }
            return null;
        }

        void h(h hVar, h hVar2, boolean z) {
            if (hVar != null) {
                c();
            }
            if (!z && this.b == 0) {
                b();
            }
            if (hVar2 != null) {
                a();
            }
        }

        public void i(C c) {
            int iM = c.M();
            ArrayList arrayList = g(iM).a;
            if (((a) this.a.get(iM)).b <= arrayList.size()) {
                return;
            }
            c.m0();
            arrayList.add(c);
        }

        long j(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        public void k(int i, int i2) {
            a aVarG = g(i);
            aVarG.b = i2;
            ArrayList arrayList = aVarG.a;
            while (arrayList.size() > i2) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        boolean l(int i, long j, long j2) {
            long j3 = g(i).d;
            return j3 == 0 || j + j3 < j2;
        }

        boolean m(int i, long j, long j2) {
            long j3 = g(i).c;
            return j3 == 0 || j + j3 < j2;
        }
    }

    public final class v {
        final ArrayList a;
        ArrayList b;
        final ArrayList c;
        private final List d;
        private int e;
        int f;
        u g;

        public v() {
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            this.b = null;
            this.c = new ArrayList();
            this.d = Collections.unmodifiableList(arrayList);
            this.e = 2;
            this.f = 2;
        }

        private boolean H(C c, int i, int i2, long j) {
            c.s = null;
            c.r = RecyclerView.this;
            int iM = c.M();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.g.l(iM, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.l.bindViewHolder(c, i);
            this.g.d(c.M(), RecyclerView.this.getNanoTime() - nanoTime);
            b(c);
            if (!RecyclerView.this.Y0.e()) {
                return true;
            }
            c.g = i2;
            return true;
        }

        private void b(C c) {
            if (RecyclerView.this.j0()) {
                View view = c.a;
                if (AbstractC12990fW7.y(view) == 0) {
                    AbstractC12990fW7.A0(view, 1);
                }
                androidx.recyclerview.widget.v vVar = RecyclerView.this.f1;
                if (vVar == null) {
                    return;
                }
                C22317v2 c22317v2N = vVar.n();
                if (c22317v2N instanceof v.a) {
                    ((v.a) c22317v2N).o(view);
                }
                AbstractC12990fW7.p0(view, c22317v2N);
            }
        }

        private void q(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        private void r(C c) {
            View view = c.a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        void A(int i) {
            a((C) this.c.get(i), true);
            this.c.remove(i);
        }

        public void B(View view) {
            C cX = RecyclerView.X(view);
            if (cX.d0()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (cX.b0()) {
                cX.A0();
            } else if (cX.B0()) {
                cX.B();
            }
            C(cX);
            if (RecyclerView.this.G0 == null || cX.Z()) {
                return;
            }
            RecyclerView.this.G0.j(cX);
        }

        void C(C c) {
            boolean z;
            boolean z2 = true;
            if (c.b0() || c.a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(c.b0());
                sb.append(" isAttached:");
                sb.append(c.a.getParent() != null);
                sb.append(RecyclerView.this.O());
                throw new IllegalArgumentException(sb.toString());
            }
            if (c.d0()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c + RecyclerView.this.O());
            }
            if (c.y0()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.O());
            }
            boolean zG = c.G();
            h hVar = RecyclerView.this.l;
            if ((hVar != null && zG && hVar.onFailedToRecycleView(c)) || c.Z()) {
                if (this.f <= 0 || c.R(526)) {
                    z = false;
                } else {
                    int size = this.c.size();
                    if (size >= this.f && size > 0) {
                        A(0);
                        size--;
                    }
                    if (RecyclerView.w1 && size > 0 && !RecyclerView.this.X0.d(c.c)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!RecyclerView.this.X0.d(((C) this.c.get(i)).c)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.c.add(size, c);
                    z = true;
                }
                if (z) {
                    z2 = false;
                } else {
                    a(c, true);
                }
                z = z;
            } else {
                z2 = false;
            }
            RecyclerView.this.f.q(c);
            if (z || z2 || !zG) {
                return;
            }
            c.s = null;
            c.r = null;
        }

        void D(View view) {
            C cX = RecyclerView.X(view);
            if (!cX.R(12) && cX.e0() && !RecyclerView.this.p(cX)) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                cX.v0(this, true);
                this.b.add(cX);
                return;
            }
            if (!cX.X() || cX.a0() || RecyclerView.this.l.hasStableIds()) {
                cX.v0(this, false);
                this.a.add(cX);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.O());
            }
        }

        void E(u uVar) {
            u uVar2 = this.g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.g = uVar;
            if (uVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.g.a();
        }

        void F(A a) {
        }

        public void G(int i) {
            this.e = i;
            K();
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00f5 A[PHI: r1 r4
          0x00f5: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$C) = (r1v11 androidx.recyclerview.widget.RecyclerView$C), (r1v30 androidx.recyclerview.widget.RecyclerView$C) binds: [B:28:0x005d, B:45:0x00ad] A[DONT_GENERATE, DONT_INLINE]
          0x00f5: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:45:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x014e  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x017a  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01aa  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01b8  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01d4 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x01d7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        androidx.recyclerview.widget.RecyclerView.C I(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 531
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.v.I(int, boolean, long):androidx.recyclerview.widget.RecyclerView$C");
        }

        void J(C c) {
            if (c.o) {
                this.b.remove(c);
            } else {
                this.a.remove(c);
            }
            c.n = null;
            c.o = false;
            c.B();
        }

        void K() {
            p pVar = RecyclerView.this.m;
            this.f = this.e + (pVar != null ? pVar.m : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.f; size--) {
                A(size);
            }
        }

        boolean L(C c) {
            if (c.a0()) {
                return RecyclerView.this.Y0.e();
            }
            int i = c.c;
            if (i >= 0 && i < RecyclerView.this.l.getItemCount()) {
                if (RecyclerView.this.Y0.e() || RecyclerView.this.l.getItemViewType(c.c) == c.M()) {
                    return !RecyclerView.this.l.hasStableIds() || c.L() == RecyclerView.this.l.getItemId(c.c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c + RecyclerView.this.O());
        }

        void M(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                C c = (C) this.c.get(size);
                if (c != null && (i3 = c.c) >= i && i3 < i4) {
                    c.s(2);
                    A(size);
                }
            }
        }

        void a(C c, boolean z) {
            RecyclerView.r(c);
            View view = c.a;
            androidx.recyclerview.widget.v vVar = RecyclerView.this.f1;
            if (vVar != null) {
                C22317v2 c22317v2N = vVar.n();
                AbstractC12990fW7.p0(view, c22317v2N instanceof v.a ? ((v.a) c22317v2N).n(view) : null);
            }
            if (z) {
                g(c);
            }
            c.s = null;
            c.r = null;
            i().i(c);
        }

        public void c() {
            this.a.clear();
            z();
        }

        void d() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                ((C) this.c.get(i)).y();
            }
            int size2 = this.a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((C) this.a.get(i2)).y();
            }
            ArrayList arrayList = this.b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    ((C) this.b.get(i3)).y();
                }
            }
        }

        void e() {
            this.a.clear();
            ArrayList arrayList = this.b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i) {
            if (i >= 0 && i < RecyclerView.this.Y0.b()) {
                return !RecyclerView.this.Y0.e() ? i : RecyclerView.this.d.m(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.Y0.b() + RecyclerView.this.O());
        }

        void g(C c) {
            w wVar = RecyclerView.this.n;
            if (wVar != null) {
                wVar.a(c);
            }
            int size = RecyclerView.this.o.size();
            for (int i = 0; i < size; i++) {
                ((w) RecyclerView.this.o.get(i)).a(c);
            }
            h hVar = RecyclerView.this.l;
            if (hVar != null) {
                hVar.onViewRecycled(c);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.Y0 != null) {
                recyclerView.f.q(c);
            }
        }

        C h(int i) {
            int size;
            int iM;
            ArrayList arrayList = this.b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    C c = (C) this.b.get(i2);
                    if (!c.B0() && c.N() == i) {
                        c.s(32);
                        return c;
                    }
                }
                if (RecyclerView.this.l.hasStableIds() && (iM = RecyclerView.this.d.m(i)) > 0 && iM < RecyclerView.this.l.getItemCount()) {
                    long itemId = RecyclerView.this.l.getItemId(iM);
                    for (int i3 = 0; i3 < size; i3++) {
                        C c2 = (C) this.b.get(i3);
                        if (!c2.B0() && c2.L() == itemId) {
                            c2.s(32);
                            return c2;
                        }
                    }
                }
            }
            return null;
        }

        u i() {
            if (this.g == null) {
                this.g = new u();
            }
            return this.g;
        }

        int j() {
            return this.a.size();
        }

        public List k() {
            return this.d;
        }

        C l(long j, int i, boolean z) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                C c = (C) this.a.get(size);
                if (c.L() == j && !c.B0()) {
                    if (i == c.M()) {
                        c.s(32);
                        if (c.a0() && !RecyclerView.this.Y0.e()) {
                            c.t0(2, 14);
                        }
                        return c;
                    }
                    if (!z) {
                        this.a.remove(size);
                        RecyclerView.this.removeDetachedView(c.a, false);
                        y(c.a);
                    }
                }
            }
            int size2 = this.c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                C c2 = (C) this.c.get(size2);
                if (c2.L() == j && !c2.U()) {
                    if (i == c2.M()) {
                        if (!z) {
                            this.c.remove(size2);
                        }
                        return c2;
                    }
                    if (!z) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        C m(int i, boolean z) {
            View viewE;
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                C c = (C) this.a.get(i2);
                if (!c.B0() && c.N() == i && !c.X() && (RecyclerView.this.Y0.h || !c.a0())) {
                    c.s(32);
                    return c;
                }
            }
            if (z || (viewE = RecyclerView.this.e.e(i)) == null) {
                int size2 = this.c.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    C c2 = (C) this.c.get(i3);
                    if (!c2.X() && c2.N() == i && !c2.U()) {
                        if (!z) {
                            this.c.remove(i3);
                        }
                        return c2;
                    }
                }
                return null;
            }
            C cX = RecyclerView.X(viewE);
            RecyclerView.this.e.s(viewE);
            int iM = RecyclerView.this.e.m(viewE);
            if (iM != -1) {
                RecyclerView.this.e.d(iM);
                D(viewE);
                cX.s(8224);
                return cX;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + cX + RecyclerView.this.O());
        }

        View n(int i) {
            return ((C) this.a.get(i)).a;
        }

        public View o(int i) {
            return p(i, false);
        }

        View p(int i, boolean z) {
            return I(i, z, Long.MAX_VALUE).a;
        }

        void s() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) ((C) this.c.get(i)).a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.c = true;
                }
            }
        }

        void t() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                C c = (C) this.c.get(i);
                if (c != null) {
                    c.s(6);
                    c.r(null);
                }
            }
            h hVar = RecyclerView.this.l;
            if (hVar == null || !hVar.hasStableIds()) {
                z();
            }
        }

        void u(int i, int i2) {
            int size = this.c.size();
            for (int i3 = 0; i3 < size; i3++) {
                C c = (C) this.c.get(i3);
                if (c != null && c.c >= i) {
                    c.i0(i2, false);
                }
            }
        }

        void v(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.c.size();
            for (int i7 = 0; i7 < size; i7++) {
                C c = (C) this.c.get(i7);
                if (c != null && (i6 = c.c) >= i5 && i6 <= i4) {
                    if (i6 == i) {
                        c.i0(i2 - i, false);
                    } else {
                        c.i0(i3, false);
                    }
                }
            }
        }

        void w(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                C c = (C) this.c.get(size);
                if (c != null) {
                    int i4 = c.c;
                    if (i4 >= i3) {
                        c.i0(-i2, z);
                    } else if (i4 >= i) {
                        c.s(8);
                        A(size);
                    }
                }
            }
        }

        void x(h hVar, h hVar2, boolean z) {
            c();
            i().h(hVar, hVar2, z);
        }

        void y(View view) {
            C cX = RecyclerView.X(view);
            cX.n = null;
            cX.o = false;
            cX.B();
            C(cX);
        }

        void z() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.c.clear();
            if (RecyclerView.w1) {
                RecyclerView.this.X0.b();
            }
        }
    }

    public interface w {
        void a(C c);
    }

    private class x extends j {
        x() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void a() {
            RecyclerView.this.o(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.Y0.g = true;
            recyclerView.z0(true);
            if (RecyclerView.this.d.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void c(int i, int i2, Object obj) {
            RecyclerView.this.o(null);
            if (RecyclerView.this.d.r(i, i2, obj)) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void d(int i, int i2) {
            RecyclerView.this.o(null);
            if (RecyclerView.this.d.s(i, i2)) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void e(int i, int i2, int i3) {
            RecyclerView.this.o(null);
            if (RecyclerView.this.d.t(i, i2, i3)) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void f(int i, int i2) {
            RecyclerView.this.o(null);
            if (RecyclerView.this.d.u(i, i2)) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void g() {
            h hVar;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.c == null || (hVar = recyclerView.l) == null || !hVar.y()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        void h() {
            if (RecyclerView.v1) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.t && recyclerView.s) {
                    AbstractC12990fW7.h0(recyclerView, recyclerView.h);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.B = true;
            recyclerView2.requestLayout();
        }
    }

    public static abstract class y {
        private RecyclerView b;
        private p c;
        private boolean d;
        private boolean e;
        private View f;
        private boolean h;
        private int a = -1;
        private final a g = new a(0, 0);

        public static class a {
            private int a;
            private int b;
            private int c;
            private int d;
            private Interpolator e;
            private boolean f;
            private int g;

            public a(int i, int i2) {
                this(i, i2, RecyclerView.UNDEFINED_DURATION, null);
            }

            private void e() {
                if (this.e != null && this.c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean a() {
                return this.d >= 0;
            }

            public void b(int i) {
                this.d = i;
            }

            void c(RecyclerView recyclerView) {
                int i = this.d;
                if (i >= 0) {
                    this.d = -1;
                    recyclerView.l0(i);
                    this.f = false;
                } else {
                    if (!this.f) {
                        this.g = 0;
                        return;
                    }
                    e();
                    recyclerView.V0.e(this.a, this.b, this.c, this.e);
                    int i2 = this.g + 1;
                    this.g = i2;
                    if (i2 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f = false;
                }
            }

            public void d(int i, int i2, int i3, Interpolator interpolator) {
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.e = interpolator;
                this.f = true;
            }

            public a(int i, int i2, int i3, Interpolator interpolator) {
                this.d = -1;
                this.f = false;
                this.g = 0;
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.e = interpolator;
            }
        }

        public interface b {
            PointF a(int i);
        }

        public PointF a(int i) {
            Object objE = e();
            if (objE instanceof b) {
                return ((b) objE).a(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i) {
            return this.b.m.D(i);
        }

        public int c() {
            return this.b.m.K();
        }

        public int d(View view) {
            return this.b.getChildLayoutPosition(view);
        }

        public p e() {
            return this.c;
        }

        public int f() {
            return this.a;
        }

        public boolean g() {
            return this.d;
        }

        public boolean h() {
            return this.e;
        }

        protected void i(PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        void j(int i, int i2) {
            PointF pointFA;
            RecyclerView recyclerView = this.b;
            if (this.a == -1 || recyclerView == null) {
                r();
            }
            if (this.d && this.f == null && this.c != null && (pointFA = a(this.a)) != null) {
                float f = pointFA.x;
                if (f != 0.0f || pointFA.y != 0.0f) {
                    recyclerView.N0((int) Math.signum(f), (int) Math.signum(pointFA.y), null);
                }
            }
            this.d = false;
            View view = this.f;
            if (view != null) {
                if (d(view) == this.a) {
                    o(this.f, recyclerView.Y0, this.g);
                    this.g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                l(i, i2, recyclerView.Y0, this.g);
                boolean zA = this.g.a();
                this.g.c(recyclerView);
                if (zA && this.e) {
                    this.d = true;
                    recyclerView.V0.d();
                }
            }
        }

        protected void k(View view) {
            if (d(view) == f()) {
                this.f = view;
            }
        }

        protected abstract void l(int i, int i2, z zVar, a aVar);

        protected abstract void m();

        protected abstract void n();

        protected abstract void o(View view, z zVar, a aVar);

        public void p(int i) {
            this.a = i;
        }

        void q(RecyclerView recyclerView, p pVar) {
            recyclerView.V0.f();
            if (this.h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.b = recyclerView;
            this.c = pVar;
            int i = this.a;
            if (i == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.Y0.a = i;
            this.e = true;
            this.d = true;
            this.f = b(f());
            m();
            this.b.V0.d();
            this.h = true;
        }

        protected final void r() {
            if (this.e) {
                this.e = false;
                n();
                this.b.Y0.a = -1;
                this.f = null;
                this.a = -1;
                this.d = false;
                this.c.i1(this);
                this.c = null;
                this.b = null;
            }
        }
    }

    public static class z {
        private SparseArray b;
        int m;
        long n;
        int o;
        int p;
        int q;
        int a = -1;
        int c = 0;
        int d = 0;
        int e = 1;
        int f = 0;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        boolean l = false;

        void a(int i) {
            if ((this.e & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.e));
        }

        public int b() {
            return this.h ? this.c - this.d : this.f;
        }

        public int c() {
            return this.a;
        }

        public boolean d() {
            return this.a != -1;
        }

        public boolean e() {
            return this.h;
        }

        void f(h hVar) {
            this.e = 1;
            this.f = hVar.getItemCount();
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public boolean g() {
            return this.l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.a + ", mData=" + this.b + ", mItemCount=" + this.f + ", mIsMeasuring=" + this.j + ", mPreviousLayoutItemCount=" + this.c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.d + ", mStructureChanged=" + this.g + ", mInPreLayout=" + this.h + ", mRunSimpleAnimations=" + this.k + ", mRunPredictiveAnimations=" + this.l + '}';
        }
    }

    static {
        Class cls = Integer.TYPE;
        z1 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        A1 = new InterpolatorC1974c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A0(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.L()
            android.widget.EdgeEffect r1 = r6.C0
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            ir.nasim.Y22.c(r1, r4, r9)
        L1f:
            r9 = r3
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.M()
            android.widget.EdgeEffect r1 = r6.E0
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            ir.nasim.Y22.c(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.N()
            android.widget.EdgeEffect r9 = r6.D0
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            ir.nasim.Y22.c(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.K()
            android.widget.EdgeEffect r9 = r6.F0
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            ir.nasim.Y22.c(r9, r1, r2)
            goto L72
        L71:
            r3 = r9
        L72:
            if (r3 != 0) goto L7c
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            ir.nasim.AbstractC12990fW7.g0(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.A0(float, float, float, float):void");
    }

    private void B() {
        int i2 = this.A;
        this.A = 0;
        if (i2 == 0 || !j0()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        AbstractC22913w2.c(accessibilityEventObtain, i2);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    private void C0() {
        View viewFindViewById;
        if (!this.U0 || this.l == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!y1 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.e.n(focusedChild)) {
                    return;
                }
            } else if (this.e.g() == 0) {
                requestFocus();
                return;
            }
        }
        View viewT = null;
        C cFindViewHolderForItemId = (this.Y0.n == -1 || !this.l.hasStableIds()) ? null : findViewHolderForItemId(this.Y0.n);
        if (cFindViewHolderForItemId != null && !this.e.n(cFindViewHolderForItemId.a) && cFindViewHolderForItemId.a.hasFocusable()) {
            viewT = cFindViewHolderForItemId.a;
        } else if (this.e.g() > 0) {
            viewT = T();
        }
        if (viewT != null) {
            int i2 = this.Y0.o;
            if (i2 != -1 && (viewFindViewById = viewT.findViewById(i2)) != null && viewFindViewById.isFocusable()) {
                viewT = viewFindViewById;
            }
            viewT.requestFocus();
        }
    }

    private void D() {
        this.Y0.a(1);
        P(this.Y0);
        this.Y0.j = false;
        S0();
        this.f.f();
        s0();
        y0();
        K0();
        z zVar = this.Y0;
        zVar.i = zVar.k && this.c1;
        this.c1 = false;
        this.b1 = false;
        zVar.h = zVar.l;
        zVar.f = this.l.getItemCount();
        R(this.h1);
        if (this.Y0.k) {
            int iG = this.e.g();
            for (int i2 = 0; i2 < iG; i2++) {
                C cX = X(this.e.f(i2));
                if (!cX.y0() && (!cX.X() || this.l.hasStableIds())) {
                    this.f.e(cX, this.G0.u(this.Y0, cX, m.e(cX), cX.Q()));
                    if (this.Y0.i && cX.e0() && !cX.a0() && !cX.y0() && !cX.X()) {
                        this.f.c(W(cX), cX);
                    }
                }
            }
        }
        if (this.Y0.l) {
            L0();
            z zVar2 = this.Y0;
            boolean z2 = zVar2.g;
            zVar2.g = false;
            this.m.a1(this.b, zVar2);
            this.Y0.g = z2;
            for (int i3 = 0; i3 < this.e.g(); i3++) {
                C cX2 = X(this.e.f(i3));
                if (!cX2.y0() && !this.f.i(cX2)) {
                    int iE = m.e(cX2);
                    boolean zR = cX2.R(8192);
                    if (!zR) {
                        iE |= 4096;
                    }
                    m.c cVarU = this.G0.u(this.Y0, cX2, iE, cX2.Q());
                    if (zR) {
                        B0(cX2, cVarU);
                    } else {
                        this.f.a(cX2, cVarU);
                    }
                }
            }
            s();
        } else {
            s();
        }
        t0();
        T0(false);
        this.Y0.e = 2;
    }

    private void D0() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.C0;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.C0.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.D0;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.D0.isFinished();
        }
        EdgeEffect edgeEffect3 = this.E0;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.E0.isFinished();
        }
        EdgeEffect edgeEffect4 = this.F0;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.F0.isFinished();
        }
        if (zIsFinished) {
            AbstractC12990fW7.g0(this);
        }
    }

    private void E() {
        S0();
        s0();
        this.Y0.a(6);
        this.d.j();
        this.Y0.f = this.l.getItemCount();
        this.Y0.d = 0;
        if (this.c != null && this.l.y()) {
            Parcelable parcelable = this.c.c;
            if (parcelable != null) {
                this.m.f1(parcelable);
            }
            this.c = null;
        }
        z zVar = this.Y0;
        zVar.h = false;
        this.m.a1(this.b, zVar);
        z zVar2 = this.Y0;
        zVar2.g = false;
        zVar2.k = zVar2.k && this.G0 != null;
        zVar2.e = 4;
        t0();
        T0(false);
    }

    private void F() {
        this.Y0.a(4);
        S0();
        s0();
        z zVar = this.Y0;
        zVar.e = 1;
        if (zVar.k) {
            for (int iG = this.e.g() - 1; iG >= 0; iG--) {
                C cX = X(this.e.f(iG));
                if (!cX.y0()) {
                    long jW = W(cX);
                    m.c cVarT = this.G0.t(this.Y0, cX);
                    C cG = this.f.g(jW);
                    if (cG == null || cG.y0()) {
                        this.f.d(cX, cVarT);
                    } else {
                        boolean zH = this.f.h(cG);
                        boolean zH2 = this.f.h(cX);
                        if (zH && cG == cX) {
                            this.f.d(cX, cVarT);
                        } else {
                            m.c cVarN = this.f.n(cG);
                            this.f.d(cX, cVarT);
                            m.c cVarM = this.f.m(cX);
                            if (cVarN == null) {
                                c0(jW, cX, cG);
                            } else {
                                m(cG, cX, cVarN, cVarM, zH, zH2);
                            }
                        }
                    }
                }
            }
            this.f.o(this.r1);
        }
        this.m.o1(this.b);
        z zVar2 = this.Y0;
        zVar2.c = zVar2.f;
        this.H = false;
        this.J = false;
        zVar2.k = false;
        zVar2.l = false;
        this.m.h = false;
        ArrayList arrayList = this.b.b;
        if (arrayList != null) {
            arrayList.clear();
        }
        p pVar = this.m;
        if (pVar.n) {
            pVar.m = 0;
            pVar.n = false;
            this.b.K();
        }
        this.m.b1(this.Y0);
        t0();
        T0(false);
        this.f.f();
        int[] iArr = this.h1;
        if (y(iArr[0], iArr[1])) {
            H(0, 0);
        }
        C0();
        I0();
    }

    private void H0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.c) {
                Rect rect = layoutParams2.b;
                Rect rect2 = this.i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.i);
            offsetRectIntoDescendantCoords(view, this.i);
        }
        this.m.v1(this, view, this.i, !this.v, view2 == null);
    }

    private void I0() {
        z zVar = this.Y0;
        zVar.n = -1L;
        zVar.m = -1;
        zVar.o = -1;
    }

    private boolean J(MotionEvent motionEvent) {
        s sVar = this.r;
        if (sVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return Q(motionEvent);
        }
        sVar.a(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.r = null;
        }
        return true;
    }

    private void J0() {
        VelocityTracker velocityTracker = this.J0;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        D0();
    }

    private void K0() {
        View focusedChild = (this.U0 && hasFocus() && this.l != null) ? getFocusedChild() : null;
        C cFindContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (cFindContainingViewHolder == null) {
            I0();
            return;
        }
        this.Y0.n = this.l.hasStableIds() ? cFindContainingViewHolder.L() : -1L;
        this.Y0.m = this.H ? -1 : cFindContainingViewHolder.a0() ? cFindContainingViewHolder.d : cFindContainingViewHolder.I();
        this.Y0.o = Z(cFindContainingViewHolder.a);
    }

    private void O0(h hVar, boolean z2, boolean z3) {
        h hVar2 = this.l;
        if (hVar2 != null) {
            hVar2.unregisterAdapterDataObserver(this.a);
            this.l.onDetachedFromRecyclerView(this);
        }
        if (!z2 || z3) {
            E0();
        }
        this.d.y();
        h hVar3 = this.l;
        this.l = hVar;
        if (hVar != null) {
            hVar.registerAdapterDataObserver(this.a);
            hVar.onAttachedToRecyclerView(this);
        }
        p pVar = this.m;
        if (pVar != null) {
            pVar.H0(hVar3, this.l);
        }
        this.b.x(hVar3, this.l, z2);
        this.Y0.g = true;
    }

    private boolean Q(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = (s) this.q.get(i2);
            if (sVar.c(this, motionEvent) && action != 3) {
                this.r = sVar;
                return true;
            }
        }
        return false;
    }

    private void R(int[] iArr) {
        int iG = this.e.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = UNDEFINED_DURATION;
        for (int i4 = 0; i4 < iG; i4++) {
            C cX = X(this.e.f(i4));
            if (!cX.y0()) {
                int iN = cX.N();
                if (iN < i2) {
                    i2 = iN;
                }
                if (iN > i3) {
                    i3 = iN;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    static RecyclerView S(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewS = S(viewGroup.getChildAt(i2));
            if (recyclerViewS != null) {
                return recyclerViewS;
            }
        }
        return null;
    }

    private View T() {
        C cFindViewHolderForAdapterPosition;
        z zVar = this.Y0;
        int i2 = zVar.m;
        if (i2 == -1) {
            i2 = 0;
        }
        int iB = zVar.b();
        for (int i3 = i2; i3 < iB; i3++) {
            C cFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i3);
            if (cFindViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (cFindViewHolderForAdapterPosition2.a.hasFocusable()) {
                return cFindViewHolderForAdapterPosition2.a;
            }
        }
        int iMin = Math.min(iB, i2);
        do {
            iMin--;
            if (iMin < 0 || (cFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin)) == null) {
                return null;
            }
        } while (!cFindViewHolderForAdapterPosition.a.hasFocusable());
        return cFindViewHolderForAdapterPosition.a;
    }

    private void U0() {
        this.V0.f();
        p pVar = this.m;
        if (pVar != null) {
            pVar.O1();
        }
    }

    static C X(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).a;
    }

    static void Y(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private int Z(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String a0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(Separators.DOT)) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private void c0(long j2, C c, C c2) {
        int iG = this.e.g();
        for (int i2 = 0; i2 < iG; i2++) {
            C cX = X(this.e.f(i2));
            if (cX != c && W(cX) == j2) {
                h hVar = this.l;
                if (hVar == null || !hVar.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + cX + " \n View Holder 2:" + c + O());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + cX + " \n View Holder 2:" + c + O());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c2 + " cannot be found but it is necessary for " + c + O());
    }

    private boolean d0() {
        int iG = this.e.g();
        for (int i2 = 0; i2 < iG; i2++) {
            C cX = X(this.e.f(i2));
            if (cX != null && !cX.y0() && cX.e0()) {
                return true;
            }
        }
        return false;
    }

    private void f0() {
        if (AbstractC12990fW7.z(this) == 0) {
            AbstractC12990fW7.C0(this, 8);
        }
    }

    private void g0() {
        this.e = new androidx.recyclerview.widget.e(new e());
    }

    private C5276Iq4 getScrollingChildHelper() {
        if (this.i1 == null) {
            this.i1 = new C5276Iq4(this);
        }
        return this.i1;
    }

    private void k(C c) {
        View view = c.a;
        boolean z2 = view.getParent() == this;
        this.b.J(getChildViewHolder(view));
        if (c.d0()) {
            this.e.c(view, -1, view.getLayoutParams(), true);
        } else if (z2) {
            this.e.k(view);
        } else {
            this.e.b(view, true);
        }
    }

    private boolean k0(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || view2 == view || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.i.set(0, 0, view.getWidth(), view.getHeight());
        this.j.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.i);
        offsetDescendantRectToMyCoords(view2, this.j);
        char c = 65535;
        int i4 = this.m.a0() == 1 ? -1 : 1;
        Rect rect = this.i;
        int i5 = rect.left;
        Rect rect2 = this.j;
        int i6 = rect2.left;
        if ((i5 < i6 || rect.right <= i6) && rect.right < rect2.right) {
            i3 = 1;
        } else {
            int i7 = rect.right;
            int i8 = rect2.right;
            i3 = ((i7 > i8 || i5 >= i8) && i5 > i6) ? -1 : 0;
        }
        int i9 = rect.top;
        int i10 = rect2.top;
        if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
            c = 1;
        } else {
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            if ((i11 <= i12 && i9 < i12) || i9 <= i10) {
                c = 0;
            }
        }
        if (i2 == 1) {
            return c < 0 || (c == 0 && i3 * i4 < 0);
        }
        if (i2 == 2) {
            return c > 0 || (c == 0 && i3 * i4 > 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return c < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return c > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + O());
    }

    private void m(C c, C c2, m.c cVar, m.c cVar2, boolean z2, boolean z3) {
        c.u0(false);
        if (z2) {
            k(c);
        }
        if (c != c2) {
            if (z3) {
                k(c2);
            }
            c.h = c2;
            k(c);
            this.b.J(c);
            c2.u0(false);
            c2.i = c;
        }
        if (this.G0.b(c, c2, cVar, cVar2)) {
            w0();
        }
    }

    private void o0(int i2, int i3, MotionEvent motionEvent, int i4) {
        p pVar = this.m;
        if (pVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.y) {
            return;
        }
        int[] iArr = this.l1;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean zL = pVar.l();
        boolean zM = this.m.m();
        startNestedScroll(zM ? (zL ? 1 : 0) | 2 : zL ? 1 : 0, i4);
        if (dispatchNestedPreScroll(zL ? i2 : 0, zM ? i3 : 0, this.l1, this.j1, i4)) {
            int[] iArr2 = this.l1;
            i2 -= iArr2[0];
            i3 -= iArr2[1];
        }
        M0(zL ? i2 : 0, zM ? i3 : 0, motionEvent, i4);
        androidx.recyclerview.widget.k kVar = this.W0;
        if (kVar != null && (i2 != 0 || i3 != 0)) {
            kVar.f(this, i2, i3);
        }
        stopNestedScroll(i4);
    }

    private void q() {
        J0();
        setScrollState(0);
    }

    static void r(C c) {
        WeakReference weakReference = c.b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == c.a) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            c.b = null;
        }
    }

    private void v0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.I0) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.I0 = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.M0 = x2;
            this.K0 = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.N0 = y2;
            this.L0 = y2;
        }
    }

    private void w(Context context, String str, AttributeSet attributeSet, int i2, int i3) throws NoSuchMethodException, SecurityException {
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strA0 = a0(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(strA0, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(p.class);
                try {
                    constructor = clsAsSubclass.getConstructor(z1);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    objArr = null;
                    try {
                        constructor = clsAsSubclass.getConstructor(null);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strA0, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((p) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strA0, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strA0, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strA0, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strA0, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strA0, e8);
            }
        }
    }

    private boolean x0() {
        return this.G0 != null && this.m.P1();
    }

    private boolean y(int i2, int i3) {
        R(this.h1);
        int[] iArr = this.h1;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    private void y0() {
        boolean z2;
        if (this.H) {
            this.d.y();
            if (this.J) {
                this.m.V0(this);
            }
        }
        if (x0()) {
            this.d.w();
        } else {
            this.d.j();
        }
        boolean z3 = this.b1 || this.c1;
        this.Y0.k = this.v && this.G0 != null && ((z2 = this.H) || z3 || this.m.h) && (!z2 || this.l.hasStableIds());
        z zVar = this.Y0;
        zVar.l = zVar.k && z3 && !this.H && x0();
    }

    void A(View view) {
        C cX = X(view);
        onChildDetachedFromWindow(view);
        h hVar = this.l;
        if (hVar != null && cX != null) {
            hVar.onViewDetachedFromWindow(cX);
        }
        List list = this.G;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((q) this.G.get(size)).b(view);
            }
        }
    }

    void B0(C c, m.c cVar) {
        c.t0(0, 8192);
        if (this.Y0.i && c.e0() && !c.a0() && !c.y0()) {
            this.f.c(W(c), c);
        }
        this.f.e(c, cVar);
    }

    void C() {
        if (this.l == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.m == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.Y0.j = false;
        boolean z2 = this.o1 && !(this.p1 == getWidth() && this.q1 == getHeight());
        this.p1 = 0;
        this.q1 = 0;
        this.o1 = false;
        if (this.Y0.e == 1) {
            D();
            this.m.C1(this);
            E();
        } else if (this.d.q() || z2 || this.m.p0() != getWidth() || this.m.X() != getHeight()) {
            this.m.C1(this);
            E();
        } else {
            this.m.C1(this);
        }
        F();
    }

    void E0() {
        m mVar = this.G0;
        if (mVar != null) {
            mVar.k();
        }
        p pVar = this.m;
        if (pVar != null) {
            pVar.n1(this.b);
            this.m.o1(this.b);
        }
        this.b.c();
    }

    boolean F0(View view) {
        S0();
        boolean zR = this.e.r(view);
        if (zR) {
            C cX = X(view);
            this.b.J(cX);
            this.b.C(cX);
        }
        T0(!zR);
        return zR;
    }

    void G(int i2) {
        p pVar = this.m;
        if (pVar != null) {
            pVar.h1(i2);
        }
        onScrollStateChanged(i2);
        t tVar = this.Z0;
        if (tVar != null) {
            tVar.a(this, i2);
        }
        List list = this.a1;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((t) this.a1.get(size)).a(this, i2);
            }
        }
    }

    void G0() {
        C c;
        int iG = this.e.g();
        for (int i2 = 0; i2 < iG; i2++) {
            View viewF = this.e.f(i2);
            C childViewHolder = getChildViewHolder(viewF);
            if (childViewHolder != null && (c = childViewHolder.i) != null) {
                View view = c.a;
                int left = viewF.getLeft();
                int top = viewF.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    void H(int i2, int i3) {
        this.A0++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        onScrolled(i2, i3);
        t tVar = this.Z0;
        if (tVar != null) {
            tVar.b(this, i2, i3);
        }
        List list = this.a1;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((t) this.a1.get(size)).b(this, i2, i3);
            }
        }
        this.A0--;
    }

    void I() {
        int i2;
        for (int size = this.m1.size() - 1; size >= 0; size--) {
            C c = (C) this.m1.get(size);
            if (c.a.getParent() == this && !c.y0() && (i2 = c.q) != -1) {
                AbstractC12990fW7.A0(c.a, i2);
                c.q = -1;
            }
        }
        this.m1.clear();
    }

    void K() {
        if (this.F0 != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.B0.a(this, 3);
        this.F0 = edgeEffectA;
        if (this.g) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void L() {
        if (this.C0 != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.B0.a(this, 0);
        this.C0 = edgeEffectA;
        if (this.g) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void L0() {
        int iJ = this.e.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            C cX = X(this.e.i(i2));
            if (!cX.y0()) {
                cX.o0();
            }
        }
    }

    void M() {
        if (this.E0 != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.B0.a(this, 2);
        this.E0 = edgeEffectA;
        if (this.g) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    boolean M0(int i2, int i3, MotionEvent motionEvent, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        v();
        if (this.l != null) {
            int[] iArr = this.l1;
            iArr[0] = 0;
            iArr[1] = 0;
            N0(i2, i3, iArr);
            int[] iArr2 = this.l1;
            int i9 = iArr2[0];
            int i10 = iArr2[1];
            i5 = i10;
            i6 = i9;
            i7 = i2 - i9;
            i8 = i3 - i10;
        } else {
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
        }
        if (!this.p.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.l1;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i6, i5, i7, i8, this.j1, i4, iArr3);
        int[] iArr4 = this.l1;
        int i11 = iArr4[0];
        int i12 = i7 - i11;
        int i13 = iArr4[1];
        int i14 = i8 - i13;
        boolean z2 = (i11 == 0 && i13 == 0) ? false : true;
        int i15 = this.M0;
        int[] iArr5 = this.j1;
        int i16 = iArr5[0];
        this.M0 = i15 - i16;
        int i17 = this.N0;
        int i18 = iArr5[1];
        this.N0 = i17 - i18;
        int[] iArr6 = this.k1;
        iArr6[0] = iArr6[0] + i16;
        iArr6[1] = iArr6[1] + i18;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !AbstractC11280ck4.a(motionEvent, 8194)) {
                A0(motionEvent.getX(), i12, motionEvent.getY(), i14);
            }
            u(i2, i3);
        }
        if (i6 != 0 || i5 != 0) {
            H(i6, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z2 && i6 == 0 && i5 == 0) ? false : true;
    }

    void N() {
        if (this.D0 != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.B0.a(this, 1);
        this.D0 = edgeEffectA;
        if (this.g) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void N0(int i2, int i3, int[] iArr) {
        S0();
        s0();
        AbstractC18580ot7.a("RV Scroll");
        P(this.Y0);
        int iZ1 = i2 != 0 ? this.m.z1(i2, this.b, this.Y0) : 0;
        int iB1 = i3 != 0 ? this.m.B1(i3, this.b, this.Y0) : 0;
        AbstractC18580ot7.b();
        G0();
        t0();
        T0(false);
        if (iArr != null) {
            iArr[0] = iZ1;
            iArr[1] = iB1;
        }
    }

    String O() {
        return Separators.SP + super.toString() + ", adapter:" + this.l + ", layout:" + this.m + ", context:" + getContext();
    }

    final void P(z zVar) {
        if (getScrollState() != 2) {
            zVar.p = 0;
            zVar.q = 0;
        } else {
            OverScroller overScroller = this.V0.c;
            zVar.p = overScroller.getFinalX() - overScroller.getCurrX();
            zVar.q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    boolean P0(C c, int i2) {
        if (!isComputingLayout()) {
            AbstractC12990fW7.A0(c.a, i2);
            return true;
        }
        c.q = i2;
        this.m1.add(c);
        return false;
    }

    boolean Q0(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int iB = accessibilityEvent != null ? AbstractC22913w2.b(accessibilityEvent) : 0;
        this.A |= iB != 0 ? iB : 0;
        return true;
    }

    void R0(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        p pVar = this.m;
        if (pVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.y) {
            return;
        }
        if (!pVar.l()) {
            i2 = 0;
        }
        if (!this.m.m()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (i4 != Integer.MIN_VALUE && i4 <= 0) {
            scrollBy(i2, i3);
            return;
        }
        if (z2) {
            int i5 = i2 != 0 ? 1 : 0;
            if (i3 != 0) {
                i5 |= 2;
            }
            startNestedScroll(i5, 1);
        }
        this.V0.e(i2, i3, i4, interpolator);
    }

    void S0() {
        int i2 = this.w + 1;
        this.w = i2;
        if (i2 != 1 || this.y) {
            return;
        }
        this.x = false;
    }

    void T0(boolean z2) {
        if (this.w < 1) {
            this.w = 1;
        }
        if (!z2 && !this.y) {
            this.x = false;
        }
        if (this.w == 1) {
            if (z2 && this.x && !this.y && this.m != null && this.l != null) {
                C();
            }
            if (!this.y) {
                this.x = false;
            }
        }
        this.w--;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.recyclerview.widget.RecyclerView.C U(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.e r0 = r5.e
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.e r3 = r5.e
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$C r3 = X(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.a0()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.N()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.e r1 = r5.e
            android.view.View r4 = r3.a
            boolean r1 = r1.n(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.U(int, boolean):androidx.recyclerview.widget.RecyclerView$C");
    }

    int V(C c) {
        if (c.R(524) || !c.V()) {
            return -1;
        }
        return this.d.e(c.c);
    }

    void V0(int i2, int i3, Object obj) {
        int i4;
        int iJ = this.e.j();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < iJ; i6++) {
            View viewI = this.e.i(i6);
            C cX = X(viewI);
            if (cX != null && !cX.y0() && (i4 = cX.c) >= i2 && i4 < i5) {
                cX.s(2);
                cX.r(obj);
                ((LayoutParams) viewI.getLayoutParams()).c = true;
            }
        }
        this.b.M(i2, i3);
    }

    long W(C c) {
        return this.l.hasStableIds() ? c.L() : c.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        p pVar = this.m;
        if (pVar == null || !pVar.I0(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void addItemDecoration(o oVar, int i2) {
        p pVar = this.m;
        if (pVar != null) {
            pVar.h("Cannot add item decoration during a scroll  or layout");
        }
        if (this.p.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.p.add(oVar);
        } else {
            this.p.add(i2, oVar);
        }
        m0();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(q qVar) {
        if (this.G == null) {
            this.G = new ArrayList();
        }
        this.G.add(qVar);
    }

    public void addOnItemTouchListener(s sVar) {
        this.q.add(sVar);
    }

    public void addOnScrollListener(t tVar) {
        if (this.a1 == null) {
            this.a1 = new ArrayList();
        }
        this.a1.add(tVar);
    }

    public void addRecyclerListener(w wVar) {
        AbstractC4980Hj5.b(wVar != null, "'listener' arg cannot be null.");
        this.o.add(wVar);
    }

    void b(int i2, int i3) {
        if (i2 < 0) {
            L();
            if (this.C0.isFinished()) {
                this.C0.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            M();
            if (this.E0.isFinished()) {
                this.E0.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            N();
            if (this.D0.isFinished()) {
                this.D0.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            K();
            if (this.F0.isFinished()) {
                this.F0.onAbsorb(i3);
            }
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        AbstractC12990fW7.g0(this);
    }

    Rect b0(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.c) {
            return layoutParams.b;
        }
        if (this.Y0.e() && (layoutParams.b() || layoutParams.d())) {
            return layoutParams.b;
        }
        Rect rect = layoutParams.b;
        rect.set(0, 0, 0, 0);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.i.set(0, 0, 0, 0);
            ((o) this.p.get(i2)).g(this.i, view, this, this.Y0);
            int i3 = rect.left;
            Rect rect2 = this.i;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.c = false;
        return rect;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.m.n((LayoutParams) layoutParams);
    }

    public void clearOnChildAttachStateChangeListeners() {
        List list = this.G;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List list = this.a1;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        p pVar = this.m;
        if (pVar != null && pVar.l()) {
            return this.m.r(this.Y0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        p pVar = this.m;
        if (pVar != null && pVar.l()) {
            return this.m.s(this.Y0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        p pVar = this.m;
        if (pVar != null && pVar.l()) {
            return this.m.t(this.Y0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        p pVar = this.m;
        if (pVar != null && pVar.m()) {
            return this.m.u(this.Y0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        p pVar = this.m;
        if (pVar != null && pVar.m()) {
            return this.m.v(this.Y0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        p pVar = this.m;
        if (pVar != null && pVar.m()) {
            return this.m.w(this.Y0);
        }
        return 0;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().f(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        int size = this.p.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            ((o) this.p.get(i2)).k(canvas, this, this.Y0);
        }
        EdgeEffect edgeEffect = this.C0;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.C0;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.D0;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.D0;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.E0;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.E0;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.F0;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.g) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.F0;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(iSave4);
        }
        if ((z2 || this.G0 == null || this.p.size() <= 0 || !this.G0.p()) ? z2 : true) {
            AbstractC12990fW7.g0(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    void e0() {
        this.d = new C1975a(new f());
    }

    public View findChildViewUnder(float f2, float f3) {
        for (int iG = this.e.g() - 1; iG >= 0; iG--) {
            View viewF = this.e.f(iG);
            float translationX = viewF.getTranslationX();
            float translationY = viewF.getTranslationY();
            if (f2 >= viewF.getLeft() + translationX && f2 <= viewF.getRight() + translationX && f3 >= viewF.getTop() + translationY && f3 <= viewF.getBottom() + translationY) {
                return viewF;
            }
        }
        return null;
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public C findContainingViewHolder(View view) {
        View viewFindContainingItemView = findContainingItemView(view);
        if (viewFindContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(viewFindContainingItemView);
    }

    public C findViewHolderForAdapterPosition(int i2) {
        C c = null;
        if (this.H) {
            return null;
        }
        int iJ = this.e.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            C cX = X(this.e.i(i3));
            if (cX != null && !cX.a0() && V(cX) == i2) {
                if (!this.e.n(cX.a)) {
                    return cX;
                }
                c = cX;
            }
        }
        return c;
    }

    public C findViewHolderForItemId(long j2) {
        h hVar = this.l;
        C c = null;
        if (hVar != null && hVar.hasStableIds()) {
            int iJ = this.e.j();
            for (int i2 = 0; i2 < iJ; i2++) {
                C cX = X(this.e.i(i2));
                if (cX != null && !cX.a0() && cX.L() == j2) {
                    if (!this.e.n(cX.a)) {
                        return cX;
                    }
                    c = cX;
                }
            }
        }
        return c;
    }

    public C findViewHolderForLayoutPosition(int i2) {
        return U(i2, false);
    }

    @Deprecated
    public C findViewHolderForPosition(int i2) {
        return U(i2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean fling(int i2, int i3) {
        p pVar = this.m;
        if (pVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.y) {
            return false;
        }
        int iL = pVar.l();
        boolean zM = this.m.m();
        if (iL == 0 || Math.abs(i2) < this.Q0) {
            i2 = 0;
        }
        if (!zM || Math.abs(i3) < this.Q0) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f2 = i2;
        float f3 = i3;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z2 = iL != 0 || zM;
            dispatchNestedFling(f2, f3, z2);
            r rVar = this.P0;
            if (rVar != null && rVar.a(i2, i3)) {
                return true;
            }
            if (z2) {
                if (zM) {
                    iL = (iL == true ? 1 : 0) | 2;
                }
                startNestedScroll(iL, 1);
                int i4 = this.R0;
                int iMax = Math.max(-i4, Math.min(i2, i4));
                int i5 = this.R0;
                this.V0.b(iMax, Math.max(-i5, Math.min(i3, i5)));
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View viewM0;
        boolean z2;
        View viewT0 = this.m.T0(view, i2);
        if (viewT0 != null) {
            return viewT0;
        }
        boolean z3 = (this.l == null || this.m == null || isComputingLayout() || this.y) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z3 && (i2 == 2 || i2 == 1)) {
            if (this.m.m()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = focusFinder.findNextFocus(this, view, i3) == null;
                if (x1) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.m.l()) {
                int i4 = (this.m.a0() == 1) ^ (i2 == 2) ? 66 : 17;
                boolean z4 = focusFinder.findNextFocus(this, view, i4) == null;
                if (x1) {
                    i2 = i4;
                }
                z2 = z4;
            }
            if (z2) {
                v();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                S0();
                this.m.M0(view, i2, this.b, this.Y0);
                T0(false);
            }
            viewM0 = focusFinder.findNextFocus(this, view, i2);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (viewFindNextFocus == null && z3) {
                v();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                S0();
                viewM0 = this.m.M0(view, i2, this.b, this.Y0);
                T0(false);
            } else {
                viewM0 = viewFindNextFocus;
            }
        }
        if (viewM0 == null || viewM0.hasFocusable()) {
            return k0(view, viewM0, i2) ? viewM0 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        H0(viewM0, null);
        return view;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        p pVar = this.m;
        if (pVar != null) {
            return pVar.E();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + O());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        p pVar = this.m;
        if (pVar != null) {
            return pVar.F(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + O());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public h getAdapter() {
        return this.l;
    }

    @Override // android.view.View
    public int getBaseline() {
        p pVar = this.m;
        return pVar != null ? pVar.H() : super.getBaseline();
    }

    public int getChildAdapterPosition(View view) {
        C cX = X(view);
        if (cX != null) {
            return cX.I();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        k kVar = this.g1;
        return kVar == null ? super.getChildDrawingOrder(i2, i3) : kVar.a(i2, i3);
    }

    public long getChildItemId(View view) {
        C cX;
        h hVar = this.l;
        if (hVar == null || !hVar.hasStableIds() || (cX = X(view)) == null) {
            return -1L;
        }
        return cX.L();
    }

    public int getChildLayoutPosition(View view) {
        C cX = X(view);
        if (cX != null) {
            return cX.N();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public C getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return X(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.g;
    }

    public androidx.recyclerview.widget.v getCompatAccessibilityDelegate() {
        return this.f1;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        Y(view, rect);
    }

    public l getEdgeEffectFactory() {
        return this.B0;
    }

    public m getItemAnimator() {
        return this.G0;
    }

    public o getItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            return (o) this.p.get(i2);
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.p.size();
    }

    public p getLayoutManager() {
        return this.m;
    }

    public int getMaxFlingVelocity() {
        return this.R0;
    }

    public int getMinFlingVelocity() {
        return this.Q0;
    }

    long getNanoTime() {
        if (w1) {
            return System.nanoTime();
        }
        return 0L;
    }

    public r getOnFlingListener() {
        return this.P0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.U0;
    }

    public u getRecycledViewPool() {
        return this.b.i();
    }

    public int getScrollState() {
        return this.H0;
    }

    void h0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.j(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(AbstractC11547dB5.fastscroll_default_thickness), resources.getDimensionPixelSize(AbstractC11547dB5.fastscroll_minimum_range), resources.getDimensionPixelOffset(AbstractC11547dB5.fastscroll_margin));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + O());
        }
    }

    public boolean hasFixedSize() {
        return this.t;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.v || this.H || this.d.p();
    }

    void i0() {
        this.F0 = null;
        this.D0 = null;
        this.E0 = null;
        this.C0 = null;
    }

    public void invalidateItemDecorations() {
        if (this.p.size() == 0) {
            return;
        }
        p pVar = this.m;
        if (pVar != null) {
            pVar.h("Cannot invalidate item decorations during a scroll or layout");
        }
        m0();
        requestLayout();
    }

    public boolean isAnimating() {
        m mVar = this.G0;
        return mVar != null && mVar.p();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.s;
    }

    public boolean isComputingLayout() {
        return this.z0 > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.y;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    boolean j0() {
        AccessibilityManager accessibilityManager = this.D;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    void l(C c, m.c cVar, m.c cVar2) {
        c.u0(false);
        if (this.G0.a(c, cVar, cVar2)) {
            w0();
        }
    }

    void l0(int i2) {
        if (this.m == null) {
            return;
        }
        setScrollState(2);
        this.m.A1(i2);
        awakenScrollBars();
    }

    void m0() {
        int iJ = this.e.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            ((LayoutParams) this.e.i(i2).getLayoutParams()).c = true;
        }
        this.b.s();
    }

    void n(C c, m.c cVar, m.c cVar2) {
        k(c);
        c.u0(false);
        if (this.G0.c(c, cVar, cVar2)) {
            w0();
        }
    }

    void n0() {
        int iJ = this.e.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            C cX = X(this.e.i(i2));
            if (cX != null && !cX.y0()) {
                cX.s(6);
            }
        }
        m0();
        this.b.t();
    }

    public void nestedScrollBy(int i2, int i3) {
        o0(i2, i3, null, 1);
    }

    void o(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + O());
        }
        if (this.A0 > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + O()));
        }
    }

    public void offsetChildrenHorizontal(int i2) {
        int iG = this.e.g();
        for (int i3 = 0; i3 < iG; i3++) {
            this.e.f(i3).offsetLeftAndRight(i2);
        }
    }

    public void offsetChildrenVertical(int i2) {
        int iG = this.e.g();
        for (int i3 = 0; i3 < iG; i3++) {
            this.e.f(i3).offsetTopAndBottom(i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.z0 = r0
            r1 = 1
            r5.s = r1
            boolean r2 = r5.v
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r5.v = r1
            androidx.recyclerview.widget.RecyclerView$p r1 = r5.m
            if (r1 == 0) goto L1e
            r1.A(r5)
        L1e:
            r5.e1 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.w1
            if (r0 == 0) goto L61
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.k.e
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.k r1 = (androidx.recyclerview.widget.k) r1
            r5.W0 = r1
            if (r1 != 0) goto L5c
            androidx.recyclerview.widget.k r1 = new androidx.recyclerview.widget.k
            r1.<init>()
            r5.W0 = r1
            android.view.Display r1 = ir.nasim.AbstractC12990fW7.u(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L4e
            if (r1 == 0) goto L4e
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L4e
            goto L50
        L4e:
            r1 = 1114636288(0x42700000, float:60.0)
        L50:
            androidx.recyclerview.widget.k r2 = r5.W0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.c = r3
            r0.set(r2)
        L5c:
            androidx.recyclerview.widget.k r0 = r5.W0
            r0.a(r5)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.k kVar;
        super.onDetachedFromWindow();
        m mVar = this.G0;
        if (mVar != null) {
            mVar.k();
        }
        stopScroll();
        this.s = false;
        p pVar = this.m;
        if (pVar != null) {
            pVar.B(this, this.b);
        }
        this.m1.clear();
        removeCallbacks(this.n1);
        this.f.j();
        if (!w1 || (kVar = this.W0) == null) {
            return;
        }
        kVar.j(this);
        this.W0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((o) this.p.get(i2)).i(canvas, this, this.Y0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$p r0 = r5.m
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.y
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L78
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$p r0 = r5.m
            boolean r0 = r0.m()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$p r3 = r5.m
            boolean r3 = r3.l()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$p r3 = r5.m
            boolean r3 = r3.m()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$p r3 = r5.m
            boolean r3 = r3.l()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L78
        L6c:
            float r2 = r5.S0
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.T0
            float r0 = r0 * r3
            int r0 = (int) r0
            r3 = 1
            r5.o0(r2, r0, r6, r3)
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.y) {
            return false;
        }
        this.r = null;
        if (Q(motionEvent)) {
            q();
            return true;
        }
        p pVar = this.m;
        if (pVar == null) {
            return false;
        }
        boolean zL = pVar.l();
        boolean zM = this.m.m();
        if (this.J0 == null) {
            this.J0 = VelocityTracker.obtain();
        }
        this.J0.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.z) {
                this.z = false;
            }
            this.I0 = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.M0 = x2;
            this.K0 = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.N0 = y2;
            this.L0 = y2;
            if (this.H0 == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.k1;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = zL;
            if (zM) {
                i2 = (zL ? 1 : 0) | 2;
            }
            startNestedScroll(i2, 0);
        } else if (actionMasked == 1) {
            this.J0.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.I0);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.I0 + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.H0 != 1) {
                int i3 = x3 - this.K0;
                int i4 = y3 - this.L0;
                if (zL == 0 || Math.abs(i3) <= this.O0) {
                    z2 = false;
                } else {
                    this.M0 = x3;
                    z2 = true;
                }
                if (zM && Math.abs(i4) > this.O0) {
                    this.N0 = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            q();
        } else if (actionMasked == 5) {
            this.I0 = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.M0 = x4;
            this.K0 = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.N0 = y4;
            this.L0 = y4;
        } else if (actionMasked == 6) {
            v0(motionEvent);
        }
        return this.H0 == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        AbstractC18580ot7.a("RV OnLayout");
        C();
        AbstractC18580ot7.b();
        this.v = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        p pVar = this.m;
        if (pVar == null) {
            x(i2, i3);
            return;
        }
        boolean z2 = false;
        if (pVar.u0()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.m.c1(this.b, this.Y0, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            this.o1 = z2;
            if (z2 || this.l == null) {
                return;
            }
            if (this.Y0.e == 1) {
                D();
            }
            this.m.D1(i2, i3);
            this.Y0.j = true;
            E();
            this.m.G1(i2, i3);
            if (this.m.J1()) {
                this.m.D1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.Y0.j = true;
                E();
                this.m.G1(i2, i3);
            }
            this.p1 = getMeasuredWidth();
            this.q1 = getMeasuredHeight();
            return;
        }
        if (this.t) {
            this.m.c1(this.b, this.Y0, i2, i3);
            return;
        }
        if (this.B) {
            S0();
            s0();
            y0();
            t0();
            z zVar = this.Y0;
            if (zVar.l) {
                zVar.h = true;
            } else {
                this.d.j();
                this.Y0.h = false;
            }
            this.B = false;
            T0(false);
        } else if (this.Y0.l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        h hVar = this.l;
        if (hVar != null) {
            this.Y0.f = hVar.getItemCount();
        } else {
            this.Y0.f = 0;
        }
        S0();
        this.m.c1(this.b, this.Y0, i2, i3);
        T0(false);
        this.Y0.h = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.c = savedState;
        super.onRestoreInstanceState(savedState.a());
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.c;
        if (savedState2 != null) {
            savedState.b(savedState2);
        } else {
            p pVar = this.m;
            if (pVar != null) {
                savedState.c = pVar.g1();
            } else {
                savedState.c = null;
            }
        }
        return savedState;
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onScrolled(int i2, int i3) {
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        i0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00df A[PHI: r0
      0x00df: PHI (r0v36 int) = (r0v26 int), (r0v40 int) binds: [B:41:0x00c8, B:45:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    boolean p(C c) {
        m mVar = this.G0;
        return mVar == null || mVar.g(c, c.Q());
    }

    void p0(int i2, int i3) {
        int iJ = this.e.j();
        for (int i4 = 0; i4 < iJ; i4++) {
            C cX = X(this.e.i(i4));
            if (cX != null && !cX.y0() && cX.c >= i2) {
                cX.i0(i3, false);
                this.Y0.g = true;
            }
        }
        this.b.u(i2, i3);
        requestLayout();
    }

    void q0(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int iJ = this.e.j();
        if (i2 < i3) {
            i6 = -1;
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i8 = 0; i8 < iJ; i8++) {
            C cX = X(this.e.i(i8));
            if (cX != null && (i7 = cX.c) >= i5 && i7 <= i4) {
                if (i7 == i2) {
                    cX.i0(i3 - i2, false);
                } else {
                    cX.i0(i6, false);
                }
                this.Y0.g = true;
            }
        }
        this.b.v(i2, i3);
        requestLayout();
    }

    void r0(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int iJ = this.e.j();
        for (int i5 = 0; i5 < iJ; i5++) {
            C cX = X(this.e.i(i5));
            if (cX != null && !cX.y0()) {
                int i6 = cX.c;
                if (i6 >= i4) {
                    cX.i0(-i3, z2);
                    this.Y0.g = true;
                } else if (i6 >= i2) {
                    cX.H(i2 - 1, -i3, z2);
                    this.Y0.g = true;
                }
            }
        }
        this.b.w(i2, i3, z2);
        requestLayout();
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z2) {
        C cX = X(view);
        if (cX != null) {
            if (cX.d0()) {
                cX.D();
            } else if (!cX.y0()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + cX + O());
            }
        }
        view.clearAnimation();
        A(view);
        super.removeDetachedView(view, z2);
    }

    public void removeItemDecoration(o oVar) {
        p pVar = this.m;
        if (pVar != null) {
            pVar.h("Cannot remove item decoration during a scroll  or layout");
        }
        this.p.remove(oVar);
        if (this.p.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        m0();
        requestLayout();
    }

    public void removeItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i2));
            return;
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(q qVar) {
        List list = this.G;
        if (list == null) {
            return;
        }
        list.remove(qVar);
    }

    public void removeOnItemTouchListener(s sVar) {
        this.q.remove(sVar);
        if (this.r == sVar) {
            this.r = null;
        }
    }

    public void removeOnScrollListener(t tVar) {
        List list = this.a1;
        if (list != null) {
            list.remove(tVar);
        }
    }

    public void removeRecyclerListener(w wVar) {
        this.o.remove(wVar);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.m.e1(this, this.Y0, view, view2) && view2 != null) {
            H0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.m.u1(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((s) this.q.get(i2)).e(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.w != 0 || this.y) {
            this.x = true;
        } else {
            super.requestLayout();
        }
    }

    void s() {
        int iJ = this.e.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            C cX = X(this.e.i(i2));
            if (!cX.y0()) {
                cX.y();
            }
        }
        this.b.d();
    }

    void s0() {
        this.z0++;
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        p pVar = this.m;
        if (pVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.y) {
            return;
        }
        boolean zL = pVar.l();
        boolean zM = this.m.m();
        if (zL || zM) {
            if (!zL) {
                i2 = 0;
            }
            if (!zM) {
                i3 = 0;
            }
            M0(i2, i3, null, 0);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i2) {
        if (this.y) {
            return;
        }
        stopScroll();
        p pVar = this.m;
        if (pVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            pVar.A1(i2);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (Q0(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.v vVar) {
        this.f1 = vVar;
        AbstractC12990fW7.p0(this, vVar);
    }

    public void setAdapter(h hVar) {
        setLayoutFrozen(false);
        O0(hVar, false, true);
        z0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(k kVar) {
        if (kVar == this.g1) {
            return;
        }
        setChildrenDrawingOrderEnabled(kVar != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.g) {
            i0();
        }
        this.g = z2;
        super.setClipToPadding(z2);
        if (this.v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(l lVar) {
        AbstractC4980Hj5.g(lVar);
        this.B0 = lVar;
        i0();
    }

    public void setHasFixedSize(boolean z2) {
        this.t = z2;
    }

    public void setItemAnimator(m mVar) {
        m mVar2 = this.G0;
        if (mVar2 != null) {
            mVar2.k();
            this.G0.y(null);
        }
        this.G0 = mVar;
        if (mVar != null) {
            mVar.y(this.d1);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.b.G(i2);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(p pVar) {
        if (pVar == this.m) {
            return;
        }
        stopScroll();
        if (this.m != null) {
            m mVar = this.G0;
            if (mVar != null) {
                mVar.k();
            }
            this.m.n1(this.b);
            this.m.o1(this.b);
            this.b.c();
            if (this.s) {
                this.m.B(this, this.b);
            }
            this.m.H1(null);
            this.m = null;
        } else {
            this.b.c();
        }
        this.e.o();
        this.m = pVar;
        if (pVar != null) {
            if (pVar.b != null) {
                throw new IllegalArgumentException("LayoutManager " + pVar + " is already attached to a RecyclerView:" + pVar.b.O());
            }
            pVar.H1(this);
            if (this.s) {
                this.m.A(this);
            }
        }
        this.b.K();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().n(z2);
    }

    public void setOnFlingListener(r rVar) {
        this.P0 = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.Z0 = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.U0 = z2;
    }

    public void setRecycledViewPool(u uVar) {
        this.b.E(uVar);
    }

    @Deprecated
    public void setRecyclerListener(w wVar) {
        this.n = wVar;
    }

    void setScrollState(int i2) {
        if (i2 == this.H0) {
            return;
        }
        this.H0 = i2;
        if (i2 != 2) {
            U0();
        }
        G(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 == 1) {
                this.O0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
        }
        this.O0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(A a) {
        this.b.F(a);
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, null);
    }

    public void smoothScrollToPosition(int i2) {
        if (this.y) {
            return;
        }
        p pVar = this.m;
        if (pVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            pVar.L1(this, this.Y0, i2);
        }
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().p(i2);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().r();
    }

    public void stopScroll() {
        setScrollState(0);
        U0();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.y) {
            o("Do not suppressLayout in layout or scroll");
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.y = true;
                this.z = true;
                stopScroll();
                return;
            }
            this.y = false;
            if (this.x && this.m != null && this.l != null) {
                requestLayout();
            }
            this.x = false;
        }
    }

    public void swapAdapter(h hVar, boolean z2) {
        setLayoutFrozen(false);
        O0(hVar, true, z2);
        z0(true);
        requestLayout();
    }

    void t0() {
        u0(true);
    }

    void u(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.C0;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.C0.onRelease();
            zIsFinished = this.C0.isFinished();
        }
        EdgeEffect edgeEffect2 = this.E0;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.E0.onRelease();
            zIsFinished |= this.E0.isFinished();
        }
        EdgeEffect edgeEffect3 = this.D0;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.D0.onRelease();
            zIsFinished |= this.D0.isFinished();
        }
        EdgeEffect edgeEffect4 = this.F0;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.F0.onRelease();
            zIsFinished |= this.F0.isFinished();
        }
        if (zIsFinished) {
            AbstractC12990fW7.g0(this);
        }
    }

    void u0(boolean z2) {
        int i2 = this.z0 - 1;
        this.z0 = i2;
        if (i2 < 1) {
            this.z0 = 0;
            if (z2) {
                B();
                I();
            }
        }
    }

    void v() {
        if (!this.v || this.H) {
            AbstractC18580ot7.a("RV FullInvalidate");
            C();
            AbstractC18580ot7.b();
            return;
        }
        if (this.d.p()) {
            if (!this.d.o(4) || this.d.o(11)) {
                if (this.d.p()) {
                    AbstractC18580ot7.a("RV FullInvalidate");
                    C();
                    AbstractC18580ot7.b();
                    return;
                }
                return;
            }
            AbstractC18580ot7.a("RV PartialInvalidate");
            S0();
            s0();
            this.d.w();
            if (!this.x) {
                if (d0()) {
                    C();
                } else {
                    this.d.i();
                }
            }
            T0(true);
            t0();
            AbstractC18580ot7.b();
        }
    }

    void w0() {
        if (this.e1 || !this.s) {
            return;
        }
        AbstractC12990fW7.h0(this, this.n1);
        this.e1 = true;
    }

    void x(int i2, int i3) {
        setMeasuredDimension(p.o(i2, getPaddingLeft() + getPaddingRight(), AbstractC12990fW7.C(this)), p.o(i3, getPaddingTop() + getPaddingBottom(), AbstractC12990fW7.B(this)));
    }

    void z(View view) {
        C cX = X(view);
        onChildAttachedToWindow(view);
        h hVar = this.l;
        if (hVar != null && cX != null) {
            hVar.onViewAttachedToWindow(cX);
        }
        List list = this.G;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((q) this.G.get(size)).d(view);
            }
        }
    }

    void z0(boolean z2) {
        this.J = z2 | this.J;
        this.H = true;
        n0();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC19927rA5.recyclerViewStyle);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().d(i2, i3, iArr, iArr2, i4);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().g(i2, i3, i4, i5, iArr, i6);
    }

    public boolean hasNestedScrollingParent(int i2) {
        return getScrollingChildHelper().l(i2);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator) {
        smoothScrollBy(i2, i3, interpolator, UNDEFINED_DURATION);
    }

    public boolean startNestedScroll(int i2, int i3) {
        return getScrollingChildHelper().q(i2, i3);
    }

    public void stopNestedScroll(int i2) {
        getScrollingChildHelper().s(i2);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        Parcelable c;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
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

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = parcel.readParcelable(classLoader == null ? p.class.getClassLoader() : classLoader);
        }

        void b(SavedState savedState) {
            this.c = savedState.c;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.c, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) throws NoSuchMethodException, SecurityException {
        super(context, attributeSet, i2);
        this.a = new x();
        this.b = new v();
        this.f = new androidx.recyclerview.widget.B();
        this.h = new RunnableC1972a();
        this.i = new Rect();
        this.j = new Rect();
        this.k = new RectF();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.w = 0;
        this.H = false;
        this.J = false;
        this.z0 = 0;
        this.A0 = 0;
        this.B0 = new l();
        this.G0 = new androidx.recyclerview.widget.h();
        this.H0 = 0;
        this.I0 = -1;
        this.S0 = Float.MIN_VALUE;
        this.T0 = Float.MIN_VALUE;
        this.U0 = true;
        this.V0 = new B();
        this.X0 = w1 ? new k.b() : null;
        this.Y0 = new z();
        this.b1 = false;
        this.c1 = false;
        this.d1 = new n();
        this.e1 = false;
        this.h1 = new int[2];
        this.j1 = new int[2];
        this.k1 = new int[2];
        this.l1 = new int[2];
        this.m1 = new ArrayList();
        this.n1 = new RunnableC1973b();
        this.p1 = 0;
        this.q1 = 0;
        this.r1 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.O0 = viewConfiguration.getScaledTouchSlop();
        this.S0 = AbstractC20736sW7.f(viewConfiguration, context);
        this.T0 = AbstractC20736sW7.j(viewConfiguration, context);
        this.Q0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.R0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.G0.y(this.d1);
        e0();
        g0();
        f0();
        if (AbstractC12990fW7.y(this) == 0) {
            AbstractC12990fW7.A0(this, 1);
        }
        this.D = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.v(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, XE5.RecyclerView, i2, 0);
        AbstractC12990fW7.n0(this, context, XE5.RecyclerView, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        String string = typedArrayObtainStyledAttributes.getString(XE5.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(XE5.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.g = typedArrayObtainStyledAttributes.getBoolean(XE5.RecyclerView_android_clipToPadding, true);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(XE5.RecyclerView_fastScrollEnabled, false);
        this.u = z2;
        if (z2) {
            h0((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(XE5.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(XE5.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(XE5.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(XE5.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        typedArrayObtainStyledAttributes.recycle();
        w(context, string, attributeSet, i2, 0);
        int[] iArr = s1;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        AbstractC12990fW7.n0(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i2, 0);
        boolean z3 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z3);
    }

    public final void dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4) {
        R0(i2, i3, interpolator, i4, false);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        C a;
        final Rect b;
        boolean c;
        boolean d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public int a() {
            return this.a.N();
        }

        public boolean b() {
            return this.a.e0();
        }

        public boolean c() {
            return this.a.a0();
        }

        public boolean d() {
            return this.a.X();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        p pVar = this.m;
        if (pVar != null) {
            return pVar.G(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + O());
    }

    public void addItemDecoration(o oVar) {
        addItemDecoration(oVar, -1);
    }

    public static abstract class p {
        androidx.recyclerview.widget.e a;
        RecyclerView b;
        private final A.b c;
        private final A.b d;
        androidx.recyclerview.widget.A e;
        androidx.recyclerview.widget.A f;
        y g;
        boolean h;
        boolean i;
        boolean j;
        private boolean k;
        private boolean l;
        int m;
        boolean n;
        private int o;
        private int p;
        private int q;
        private int r;

        class a implements A.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.A.b
            public View a(int i) {
                return p.this.J(i);
            }

            @Override // androidx.recyclerview.widget.A.b
            public int b(View view) {
                return p.this.R(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.A.b
            public int c() {
                return p.this.f0();
            }

            @Override // androidx.recyclerview.widget.A.b
            public int d() {
                return p.this.p0() - p.this.g0();
            }

            @Override // androidx.recyclerview.widget.A.b
            public int e(View view) {
                return p.this.U(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
            }
        }

        class b implements A.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.A.b
            public View a(int i) {
                return p.this.J(i);
            }

            @Override // androidx.recyclerview.widget.A.b
            public int b(View view) {
                return p.this.V(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.A.b
            public int c() {
                return p.this.h0();
            }

            @Override // androidx.recyclerview.widget.A.b
            public int d() {
                return p.this.X() - p.this.e0();
            }

            @Override // androidx.recyclerview.widget.A.b
            public int e(View view) {
                return p.this.P(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
            }
        }

        public interface c {
            void a(int i, int i2);
        }

        public static class d {
            public int a;
            public int b;
            public boolean c;
            public boolean d;
        }

        public p() {
            a aVar = new a();
            this.c = aVar;
            b bVar = new b();
            this.d = bVar;
            this.e = new androidx.recyclerview.widget.A(aVar);
            this.f = new androidx.recyclerview.widget.A(bVar);
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = true;
            this.l = true;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int L(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1d
                if (r7 < 0) goto L12
            L10:
                r5 = r3
                goto L30
            L12:
                if (r7 != r1) goto L1a
                if (r5 == r2) goto L22
                if (r5 == 0) goto L1a
                if (r5 == r3) goto L22
            L1a:
                r5 = r6
                r7 = r5
                goto L30
            L1d:
                if (r7 < 0) goto L20
                goto L10
            L20:
                if (r7 != r1) goto L24
            L22:
                r7 = r4
                goto L30
            L24:
                if (r7 != r0) goto L1a
                if (r5 == r2) goto L2e
                if (r5 != r3) goto L2b
                goto L2e
            L2b:
                r7 = r4
                r5 = r6
                goto L30
            L2e:
                r7 = r4
                r5 = r2
            L30:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p.L(int, int, int, int, boolean):int");
        }

        private int[] M(View view, Rect rect) {
            int iF0 = f0();
            int iH0 = h0();
            int iP0 = p0() - g0();
            int iX = X() - e0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - iF0;
            int iMin = Math.min(0, i);
            int i2 = top - iH0;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - iP0;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - iX);
            if (a0() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            return new int[]{iMax, iMin2};
        }

        private void g(View view, int i, boolean z) {
            C cX = RecyclerView.X(view);
            if (z || cX.a0()) {
                this.b.f.b(cX);
            } else {
                this.b.f.p(cX);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (cX.B0() || cX.b0()) {
                if (cX.b0()) {
                    cX.A0();
                } else {
                    cX.B();
                }
                this.a.c(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.b) {
                int iM = this.a.m(view);
                if (i == -1) {
                    i = this.a.g();
                }
                if (iM == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.b.indexOfChild(view) + this.b.O());
                }
                if (iM != i) {
                    this.b.m.E0(iM, i);
                }
            } else {
                this.a.a(view, i, false);
                layoutParams.c = true;
                y yVar = this.g;
                if (yVar != null && yVar.h()) {
                    this.g.k(view);
                }
            }
            if (layoutParams.d) {
                cX.a.invalidate();
                layoutParams.d = false;
            }
        }

        public static d j0(Context context, AttributeSet attributeSet, int i, int i2) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, XE5.RecyclerView, i, i2);
            dVar.a = typedArrayObtainStyledAttributes.getInt(XE5.RecyclerView_android_orientation, 1);
            dVar.b = typedArrayObtainStyledAttributes.getInt(XE5.RecyclerView_spanCount, 1);
            dVar.c = typedArrayObtainStyledAttributes.getBoolean(XE5.RecyclerView_reverseLayout, false);
            dVar.d = typedArrayObtainStyledAttributes.getBoolean(XE5.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        public static int o(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
        }

        private boolean v0(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iF0 = f0();
            int iH0 = h0();
            int iP0 = p0() - g0();
            int iX = X() - e0();
            Rect rect = this.b.i;
            Q(focusedChild, rect);
            return rect.left - i < iP0 && rect.right - i > iF0 && rect.top - i2 < iX && rect.bottom - i2 > iH0;
        }

        private static boolean y0(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        private void y1(v vVar, int i, View view) {
            C cX = RecyclerView.X(view);
            if (cX.y0()) {
                return;
            }
            if (cX.X() && !cX.a0() && !this.b.l.hasStableIds()) {
                t1(i);
                vVar.C(cX);
            } else {
                y(i);
                vVar.D(view);
                this.b.f.k(cX);
            }
        }

        private void z(int i, View view) {
            this.a.d(i);
        }

        void A(RecyclerView recyclerView) {
            this.i = true;
            J0(recyclerView);
        }

        public boolean A0(View view, boolean z, boolean z2) {
            boolean z3 = this.e.b(view, 24579) && this.f.b(view, 24579);
            return z ? z3 : !z3;
        }

        public abstract void A1(int i);

        void B(RecyclerView recyclerView, v vVar) {
            this.i = false;
            L0(recyclerView, vVar);
        }

        public void B0(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).b;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public abstract int B1(int i, v vVar, z zVar);

        public View C(View view) {
            View viewFindContainingItemView;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || (viewFindContainingItemView = recyclerView.findContainingItemView(view)) == null || this.a.n(viewFindContainingItemView)) {
                return null;
            }
            return viewFindContainingItemView;
        }

        public void C0(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.b;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        void C1(RecyclerView recyclerView) {
            D1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public View D(int i) {
            int iK = K();
            for (int i2 = 0; i2 < iK; i2++) {
                View viewJ = J(i2);
                C cX = RecyclerView.X(viewJ);
                if (cX != null && cX.N() == i && !cX.y0() && (this.b.Y0.e() || !cX.a0())) {
                    return viewJ;
                }
            }
            return null;
        }

        public void D0(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rectB0 = this.b.b0(view);
            int i3 = i + rectB0.left + rectB0.right;
            int i4 = i2 + rectB0.top + rectB0.bottom;
            int iL = L(p0(), q0(), f0() + g0() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, l());
            int iL2 = L(X(), Y(), h0() + e0() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, m());
            if (I1(view, iL, iL2, layoutParams)) {
                view.measure(iL, iL2);
            }
        }

        void D1(int i, int i2) {
            this.q = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.o = mode;
            if (mode == 0 && !RecyclerView.u1) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.p = mode2;
            if (mode2 != 0 || RecyclerView.u1) {
                return;
            }
            this.r = 0;
        }

        public abstract LayoutParams E();

        public void E0(int i, int i2) {
            View viewJ = J(i);
            if (viewJ != null) {
                y(i);
                i(viewJ, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.b.toString());
            }
        }

        public void E1(int i, int i2) {
            this.b.setMeasuredDimension(i, i2);
        }

        public LayoutParams F(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void F0(int i) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void F1(Rect rect, int i, int i2) {
            E1(o(i, rect.width() + f0() + g0(), d0()), o(i2, rect.height() + h0() + e0(), c0()));
        }

        public LayoutParams G(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        public void G0(int i) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        void G1(int i, int i2) {
            int iK = K();
            if (iK == 0) {
                this.b.x(i, i2);
                return;
            }
            int i3 = RecyclerView.UNDEFINED_DURATION;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < iK; i7++) {
                View viewJ = J(i7);
                Rect rect = this.b.i;
                Q(viewJ, rect);
                int i8 = rect.left;
                if (i8 < i6) {
                    i6 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i4) {
                    i4 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i5) {
                    i5 = i11;
                }
            }
            this.b.i.set(i6, i4, i3, i5);
            F1(this.b.i, i, i2);
        }

        public int H() {
            return -1;
        }

        public void H0(h hVar, h hVar2) {
        }

        void H1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.b = null;
                this.a = null;
                this.q = 0;
                this.r = 0;
            } else {
                this.b = recyclerView;
                this.a = recyclerView.e;
                this.q = recyclerView.getWidth();
                this.r = recyclerView.getHeight();
            }
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public int I(View view) {
            return ((LayoutParams) view.getLayoutParams()).b.bottom;
        }

        public boolean I0(RecyclerView recyclerView, ArrayList arrayList, int i, int i2) {
            return false;
        }

        boolean I1(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.k && y0(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && y0(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public View J(int i) {
            androidx.recyclerview.widget.e eVar = this.a;
            if (eVar != null) {
                return eVar.f(i);
            }
            return null;
        }

        public void J0(RecyclerView recyclerView) {
        }

        boolean J1() {
            return false;
        }

        public int K() {
            androidx.recyclerview.widget.e eVar = this.a;
            if (eVar != null) {
                return eVar.g();
            }
            return 0;
        }

        public void K0(RecyclerView recyclerView) {
        }

        boolean K1(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.k && y0(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && y0(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public void L0(RecyclerView recyclerView, v vVar) {
            K0(recyclerView);
        }

        public abstract void L1(RecyclerView recyclerView, z zVar, int i);

        public abstract View M0(View view, int i, v vVar, z zVar);

        public void M1(y yVar) {
            y yVar2 = this.g;
            if (yVar2 != null && yVar != yVar2 && yVar2.h()) {
                this.g.r();
            }
            this.g = yVar;
            yVar.q(this.b, this);
        }

        public boolean N() {
            RecyclerView recyclerView = this.b;
            return recyclerView != null && recyclerView.g;
        }

        public void N0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.b;
            O0(recyclerView.b, recyclerView.Y0, accessibilityEvent);
        }

        public void N1(View view) {
            C cX = RecyclerView.X(view);
            cX.z0();
            cX.m0();
            cX.s(4);
        }

        public int O(v vVar, z zVar) {
            return -1;
        }

        public void O0(v vVar, z zVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.b.canScrollVertically(-1) && !this.b.canScrollHorizontally(-1) && !this.b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            h hVar = this.b.l;
            if (hVar != null) {
                accessibilityEvent.setItemCount(hVar.getItemCount());
            }
        }

        void O1() {
            y yVar = this.g;
            if (yVar != null) {
                yVar.r();
            }
        }

        public int P(View view) {
            return view.getBottom() + I(view);
        }

        public void P0(v vVar, z zVar, X2 x2) {
            if (this.b.canScrollVertically(-1) || this.b.canScrollHorizontally(-1)) {
                x2.a(8192);
                x2.R0(true);
            }
            if (this.b.canScrollVertically(1) || this.b.canScrollHorizontally(1)) {
                x2.a(4096);
                x2.R0(true);
            }
            x2.r0(X2.e.b(l0(vVar, zVar), O(vVar, zVar), x0(vVar, zVar), m0(vVar, zVar)));
        }

        public abstract boolean P1();

        public void Q(View view, Rect rect) {
            RecyclerView.Y(view, rect);
        }

        void Q0(X2 x2) {
            RecyclerView recyclerView = this.b;
            P0(recyclerView.b, recyclerView.Y0, x2);
        }

        public int R(View view) {
            return view.getLeft() - b0(view);
        }

        void R0(View view, X2 x2) {
            C cX = RecyclerView.X(view);
            if (cX == null || cX.a0() || this.a.n(cX.a)) {
                return;
            }
            RecyclerView recyclerView = this.b;
            S0(recyclerView.b, recyclerView.Y0, view, x2);
        }

        public int S(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int T(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public View T0(View view, int i) {
            return null;
        }

        public int U(View view) {
            return view.getRight() + k0(view);
        }

        public void U0(RecyclerView recyclerView, int i, int i2) {
        }

        public int V(View view) {
            return view.getTop() - n0(view);
        }

        public void V0(RecyclerView recyclerView) {
        }

        public View W() {
            View focusedChild;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void W0(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public int X() {
            return this.r;
        }

        public void X0(RecyclerView recyclerView, int i, int i2) {
        }

        public int Y() {
            return this.p;
        }

        public void Y0(RecyclerView recyclerView, int i, int i2) {
        }

        public int Z() {
            RecyclerView recyclerView = this.b;
            h adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void Z0(RecyclerView recyclerView, int i, int i2, Object obj) {
            Y0(recyclerView, i, i2);
        }

        public int a0() {
            return AbstractC12990fW7.A(this.b);
        }

        public abstract void a1(v vVar, z zVar);

        public int b0(View view) {
            return ((LayoutParams) view.getLayoutParams()).b.left;
        }

        public void b1(z zVar) {
        }

        public void c(View view) {
            d(view, -1);
        }

        public int c0() {
            return AbstractC12990fW7.B(this.b);
        }

        public void c1(v vVar, z zVar, int i, int i2) {
            this.b.x(i, i2);
        }

        public void d(View view, int i) {
            g(view, i, true);
        }

        public int d0() {
            return AbstractC12990fW7.C(this.b);
        }

        public boolean d1(RecyclerView recyclerView, View view, View view2) {
            return z0() || recyclerView.isComputingLayout();
        }

        public void e(View view) {
            f(view, -1);
        }

        public int e0() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public boolean e1(RecyclerView recyclerView, z zVar, View view, View view2) {
            return d1(recyclerView, view, view2);
        }

        public void f(View view, int i) {
            g(view, i, false);
        }

        public int f0() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public abstract void f1(Parcelable parcelable);

        public int g0() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public abstract Parcelable g1();

        public void h(String str) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.o(str);
            }
        }

        public int h0() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public void h1(int i) {
        }

        public void i(View view, int i) {
            j(view, i, (LayoutParams) view.getLayoutParams());
        }

        public int i0(View view) {
            return ((LayoutParams) view.getLayoutParams()).a();
        }

        void i1(y yVar) {
            if (this.g == yVar) {
                this.g = null;
            }
        }

        public void j(View view, int i, LayoutParams layoutParams) {
            C cX = RecyclerView.X(view);
            if (cX.a0()) {
                this.b.f.b(cX);
            } else {
                this.b.f.p(cX);
            }
            this.a.c(view, i, layoutParams, cX.a0());
        }

        boolean j1(int i, Bundle bundle) {
            RecyclerView recyclerView = this.b;
            return k1(recyclerView.b, recyclerView.Y0, i, bundle);
        }

        public void k(View view, Rect rect) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.b0(view));
            }
        }

        public int k0(View view) {
            return ((LayoutParams) view.getLayoutParams()).b.right;
        }

        public boolean k1(v vVar, z zVar, int i, Bundle bundle) {
            int iX;
            int iP0;
            int i2;
            int i3;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null) {
                return false;
            }
            if (i == 4096) {
                iX = recyclerView.canScrollVertically(1) ? (X() - h0()) - e0() : 0;
                if (this.b.canScrollHorizontally(1)) {
                    iP0 = (p0() - f0()) - g0();
                    i2 = iX;
                    i3 = iP0;
                }
                i2 = iX;
                i3 = 0;
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                iX = recyclerView.canScrollVertically(-1) ? -((X() - h0()) - e0()) : 0;
                if (this.b.canScrollHorizontally(-1)) {
                    iP0 = -((p0() - f0()) - g0());
                    i2 = iX;
                    i3 = iP0;
                }
                i2 = iX;
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.b.R0(i3, i2, null, RecyclerView.UNDEFINED_DURATION, true);
            return true;
        }

        public abstract boolean l();

        public int l0(v vVar, z zVar) {
            return -1;
        }

        boolean l1(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.b;
            return m1(recyclerView.b, recyclerView.Y0, view, i, bundle);
        }

        public abstract boolean m();

        public int m0(v vVar, z zVar) {
            return 0;
        }

        public boolean m1(v vVar, z zVar, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean n(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public int n0(View view) {
            return ((LayoutParams) view.getLayoutParams()).b.top;
        }

        public void n1(v vVar) {
            for (int iK = K() - 1; iK >= 0; iK--) {
                if (!RecyclerView.X(J(iK)).y0()) {
                    q1(iK, vVar);
                }
            }
        }

        public void o0(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.b.k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        void o1(v vVar) {
            int iJ = vVar.j();
            for (int i = iJ - 1; i >= 0; i--) {
                View viewN = vVar.n(i);
                C cX = RecyclerView.X(viewN);
                if (!cX.y0()) {
                    cX.u0(false);
                    if (cX.d0()) {
                        this.b.removeDetachedView(viewN, false);
                    }
                    m mVar = this.b.G0;
                    if (mVar != null) {
                        mVar.j(cX);
                    }
                    cX.u0(true);
                    vVar.y(viewN);
                }
            }
            vVar.e();
            if (iJ > 0) {
                this.b.invalidate();
            }
        }

        public void p(int i, int i2, z zVar, c cVar) {
        }

        public int p0() {
            return this.q;
        }

        public void p1(View view, v vVar) {
            s1(view);
            vVar.B(view);
        }

        public void q(int i, c cVar) {
        }

        public int q0() {
            return this.o;
        }

        public void q1(int i, v vVar) {
            View viewJ = J(i);
            t1(i);
            vVar.B(viewJ);
        }

        public abstract int r(z zVar);

        boolean r0() {
            int iK = K();
            for (int i = 0; i < iK; i++) {
                ViewGroup.LayoutParams layoutParams = J(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean r1(Runnable runnable) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public abstract int s(z zVar);

        public void s0(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.b;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.b.O());
            }
            C cX = RecyclerView.X(view);
            cX.s(128);
            this.b.f.q(cX);
        }

        public void s1(View view) {
            this.a.p(view);
        }

        public abstract int t(z zVar);

        public boolean t0() {
            return this.i;
        }

        public void t1(int i) {
            if (J(i) != null) {
                this.a.q(i);
            }
        }

        public abstract int u(z zVar);

        public boolean u0() {
            return this.j;
        }

        public boolean u1(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return v1(recyclerView, view, rect, z, false);
        }

        public abstract int v(z zVar);

        public boolean v1(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrM = M(view, rect);
            int i = iArrM[0];
            int i2 = iArrM[1];
            if ((z2 && !v0(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        public abstract int w(z zVar);

        public final boolean w0() {
            return this.l;
        }

        public void w1() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void x(v vVar) {
            for (int iK = K() - 1; iK >= 0; iK--) {
                y1(vVar, iK, J(iK));
            }
        }

        public boolean x0(v vVar, z zVar) {
            return false;
        }

        public void x1() {
            this.h = true;
        }

        public void y(int i) {
            z(i, J(i));
        }

        public boolean z0() {
            y yVar = this.g;
            return yVar != null && yVar.h();
        }

        public abstract int z1(int i, v vVar, z zVar);

        public void S0(v vVar, z zVar, View view, X2 x2) {
        }
    }
}
