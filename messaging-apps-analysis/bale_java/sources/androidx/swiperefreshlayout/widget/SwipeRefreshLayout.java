package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC14617iC3;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.C15965kU0;
import ir.nasim.C5276Iq4;
import ir.nasim.C5978Lq4;
import ir.nasim.InterfaceC5042Hq4;
import ir.nasim.InterfaceC5510Jq4;
import ir.nasim.InterfaceC5744Kq4;

/* loaded from: classes2.dex */
public class SwipeRefreshLayout extends ViewGroup implements InterfaceC5744Kq4, InterfaceC5510Jq4, InterfaceC5042Hq4 {
    private static final String I0 = "SwipeRefreshLayout";
    private static final int[] J0 = {R.attr.enabled};
    int A;
    private Animation A0;
    int B;
    boolean B0;
    private int C0;
    C15965kU0 D;
    boolean D0;
    private boolean E0;
    private Animation.AnimationListener F0;
    private Animation G;
    private final Animation G0;
    private Animation H;
    private final Animation H0;
    private Animation J;
    private View a;
    j b;
    boolean c;
    private int d;
    private float e;
    private float f;
    private final C5978Lq4 g;
    private final C5276Iq4 h;
    private final int[] i;
    private final int[] j;
    private final int[] k;
    private boolean l;
    private int m;
    int n;
    private float o;
    private float p;
    private boolean q;
    private int r;
    boolean s;
    private boolean t;
    private final DecelerateInterpolator u;
    androidx.swiperefreshlayout.widget.a v;
    private int w;
    protected int x;
    float y;
    protected int z;
    private Animation z0;

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.c) {
                swipeRefreshLayout.n();
                return;
            }
            swipeRefreshLayout.D.setAlpha(255);
            SwipeRefreshLayout.this.D.start();
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            if (swipeRefreshLayout2.B0 && (jVar = swipeRefreshLayout2.b) != null) {
                jVar.H1();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
            swipeRefreshLayout3.n = swipeRefreshLayout3.v.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class b extends Animation {
        b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f);
        }
    }

    class c extends Animation {
        c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
        }
    }

    class d extends Animation {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        d(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.D.setAlpha((int) (this.a + ((this.b - r0) * f)));
        }
    }

    class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.s) {
                return;
            }
            swipeRefreshLayout.x(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class f extends Animation {
        f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int iAbs = !swipeRefreshLayout.D0 ? swipeRefreshLayout.A - Math.abs(swipeRefreshLayout.z) : swipeRefreshLayout.A;
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout2.x + ((int) ((iAbs - r1) * f))) - swipeRefreshLayout2.v.getTop());
            SwipeRefreshLayout.this.D.e(1.0f - f);
        }
    }

    class g extends Animation {
        g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.l(f);
        }
    }

    class h extends Animation {
        h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f2 = swipeRefreshLayout.y;
            swipeRefreshLayout.setAnimationProgress(f2 + ((-f2) * f));
            SwipeRefreshLayout.this.l(f);
        }
    }

    public interface i {
    }

    public interface j {
        void H1();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void a(int i2, Animation.AnimationListener animationListener) {
        this.x = i2;
        this.G0.reset();
        this.G0.setDuration(200L);
        this.G0.setInterpolator(this.u);
        if (animationListener != null) {
            this.v.b(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.G0);
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        if (this.s) {
            y(i2, animationListener);
            return;
        }
        this.x = i2;
        this.H0.reset();
        this.H0.setDuration(200L);
        this.H0.setInterpolator(this.u);
        if (animationListener != null) {
            this.v.b(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.H0);
    }

    private void d() {
        this.v = new androidx.swiperefreshlayout.widget.a(getContext());
        C15965kU0 c15965kU0 = new C15965kU0(getContext());
        this.D = c15965kU0;
        c15965kU0.l(1);
        this.v.setImageDrawable(this.D);
        this.v.setVisibility(8);
        addView(this.v);
    }

    private void f() {
        if (this.a == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.v)) {
                    this.a = childAt;
                    return;
                }
            }
        }
    }

    private void g(float f2) {
        if (f2 > this.e) {
            o(true, true);
            return;
        }
        this.c = false;
        this.D.j(0.0f, 0.0f);
        b(this.n, !this.s ? new e() : null);
        this.D.d(false);
    }

    private boolean i(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void j(float f2) {
        this.D.d(true);
        float fMin = Math.min(1.0f, Math.abs(f2 / this.e));
        float fMax = (((float) Math.max(fMin - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f2) - this.e;
        int i2 = this.B;
        if (i2 <= 0) {
            i2 = this.D0 ? this.A - this.z : this.A;
        }
        float f3 = i2;
        double dMax = Math.max(0.0f, Math.min(fAbs, f3 * 2.0f) / f3) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
        int i3 = this.z + ((int) ((f3 * fMin) + (f3 * fPow * 2.0f)));
        if (this.v.getVisibility() != 0) {
            this.v.setVisibility(0);
        }
        if (!this.s) {
            this.v.setScaleX(1.0f);
            this.v.setScaleY(1.0f);
        }
        if (this.s) {
            setAnimationProgress(Math.min(1.0f, f2 / this.e));
        }
        if (f2 < this.e) {
            if (this.D.getAlpha() > 76 && !i(this.J)) {
                w();
            }
        } else if (this.D.getAlpha() < 255 && !i(this.z0)) {
            u();
        }
        this.D.j(0.0f, Math.min(0.8f, fMax * 0.8f));
        this.D.e(Math.min(1.0f, fMax));
        this.D.g((((fMax * 0.4f) - 0.25f) + (fPow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.n);
    }

    private void m(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.r) {
            this.r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void o(boolean z, boolean z2) {
        if (this.c != z) {
            this.B0 = z2;
            f();
            this.c = z;
            if (z) {
                a(this.n, this.F0);
            } else {
                x(this.F0);
            }
        }
    }

    private Animation q(int i2, int i3) {
        d dVar = new d(i2, i3);
        dVar.setDuration(300L);
        this.v.b(null);
        this.v.clearAnimation();
        this.v.startAnimation(dVar);
        return dVar;
    }

    private void s(float f2) {
        float f3 = this.p;
        float f4 = f2 - f3;
        int i2 = this.d;
        if (f4 <= i2 || this.q) {
            return;
        }
        this.o = f3 + i2;
        this.q = true;
        this.D.setAlpha(76);
    }

    private void setColorViewAlpha(int i2) {
        this.v.getBackground().setAlpha(i2);
        this.D.setAlpha(i2);
    }

    private void u() {
        this.z0 = q(this.D.getAlpha(), 255);
    }

    private void w() {
        this.J = q(this.D.getAlpha(), 76);
    }

    private void y(int i2, Animation.AnimationListener animationListener) {
        this.x = i2;
        this.y = this.v.getScaleX();
        h hVar = new h();
        this.A0 = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.v.b(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.A0);
    }

    private void z(Animation.AnimationListener animationListener) {
        this.v.setVisibility(0);
        this.D.setAlpha(255);
        b bVar = new b();
        this.G = bVar;
        bVar.setDuration(this.m);
        if (animationListener != null) {
            this.v.b(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.G);
    }

    public boolean c() {
        View view = this.a;
        return view instanceof ListView ? AbstractC14617iC3.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.h.a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.h.b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.h.c(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.h.f(i2, i3, i4, i5, iArr);
    }

    public void e(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        if (i6 == 0) {
            this.h.e(i2, i3, i4, i5, iArr, i6, iArr2);
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.w;
        return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.g.a();
    }

    public int getProgressCircleDiameter() {
        return this.C0;
    }

    public int getProgressViewEndOffset() {
        return this.A;
    }

    public int getProgressViewStartOffset() {
        return this.z;
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void h(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.h.k();
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.h.m();
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void k(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    void l(float f2) {
        setTargetOffsetTopAndBottom((this.x + ((int) ((this.z - r0) * f2))) - this.v.getTop());
    }

    void n() {
        this.v.clearAnimation();
        this.D.stop();
        this.v.setVisibility(8);
        setColorViewAlpha(255);
        if (this.s) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.z - this.n);
        }
        this.n = this.v.getTop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0058  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            r4.f()
            int r0 = r5.getActionMasked()
            boolean r1 = r4.t
            r2 = 0
            if (r1 == 0) goto L10
            if (r0 != 0) goto L10
            r4.t = r2
        L10:
            boolean r1 = r4.isEnabled()
            if (r1 == 0) goto L81
            boolean r1 = r4.t
            if (r1 != 0) goto L81
            boolean r1 = r4.c()
            if (r1 != 0) goto L81
            boolean r1 = r4.c
            if (r1 != 0) goto L81
            boolean r1 = r4.l
            if (r1 == 0) goto L29
            goto L81
        L29:
            if (r0 == 0) goto L5d
            r1 = 1
            r3 = -1
            if (r0 == r1) goto L58
            r1 = 2
            if (r0 == r1) goto L3d
            r1 = 3
            if (r0 == r1) goto L58
            r1 = 6
            if (r0 == r1) goto L39
            goto L7e
        L39:
            r4.m(r5)
            goto L7e
        L3d:
            int r0 = r4.r
            if (r0 != r3) goto L49
            java.lang.String r5 = androidx.swiperefreshlayout.widget.SwipeRefreshLayout.I0
            java.lang.String r0 = "Got ACTION_MOVE event but don't have an active pointer id."
            android.util.Log.e(r5, r0)
            return r2
        L49:
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L50
            return r2
        L50:
            float r5 = r5.getY(r0)
            r4.s(r5)
            goto L7e
        L58:
            r4.q = r2
            r4.r = r3
            goto L7e
        L5d:
            int r0 = r4.z
            androidx.swiperefreshlayout.widget.a r1 = r4.v
            int r1 = r1.getTop()
            int r0 = r0 - r1
            r4.setTargetOffsetTopAndBottom(r0)
            int r0 = r5.getPointerId(r2)
            r4.r = r0
            r4.q = r2
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L78
            return r2
        L78:
            float r5 = r5.getY(r0)
            r4.p = r5
        L7e:
            boolean r5 = r4.q
            return r5
        L81:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.a == null) {
            f();
        }
        View view = this.a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.v.getMeasuredWidth();
        int measuredHeight2 = this.v.getMeasuredHeight();
        int i6 = measuredWidth / 2;
        int i7 = measuredWidth2 / 2;
        int i8 = this.n;
        this.v.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.a == null) {
            f();
        }
        View view = this.a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.v.measure(View.MeasureSpec.makeMeasureSpec(this.C0, 1073741824), View.MeasureSpec.makeMeasureSpec(this.C0, 1073741824));
        this.w = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.v) {
                this.w = i4;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.f;
            if (f2 > 0.0f) {
                float f3 = i3;
                if (f3 > f2) {
                    iArr[1] = (int) f2;
                    this.f = 0.0f;
                } else {
                    this.f = f2 - f3;
                    iArr[1] = i3;
                }
                j(this.f);
            }
        }
        if (this.D0 && i3 > 0 && this.f == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.v.setVisibility(8);
        }
        int[] iArr2 = this.i;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        r(view, i2, i3, i4, i5, 0, this.k);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.g.b(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.f = 0.0f;
        this.l = true;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.c);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (!isEnabled() || this.t || this.c || (i2 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.g.d(view);
        this.l = false;
        float f2 = this.f;
        if (f2 > 0.0f) {
            g(f2);
            this.f = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.t && actionMasked == 0) {
            this.t = false;
        }
        if (!isEnabled() || this.t || c() || this.c || this.l) {
            return false;
        }
        if (actionMasked == 0) {
            this.r = motionEvent.getPointerId(0);
            this.q = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.r);
                if (iFindPointerIndex < 0) {
                    Log.e(I0, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.q) {
                    float y = (motionEvent.getY(iFindPointerIndex) - this.o) * 0.5f;
                    this.q = false;
                    g(y);
                }
                this.r = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.r);
                if (iFindPointerIndex2 < 0) {
                    Log.e(I0, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = motionEvent.getY(iFindPointerIndex2);
                s(y2);
                if (this.q) {
                    float f2 = (y2 - this.o) * 0.5f;
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    j(f2);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(I0, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.r = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    m(motionEvent);
                }
            }
        }
        return true;
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void p(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    @Override // ir.nasim.InterfaceC5744Kq4
    public void r(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (i6 != 0) {
            return;
        }
        int i7 = iArr[1];
        e(i2, i3, i4, i5, this.j, i6, iArr);
        int i8 = i5 - (iArr[1] - i7);
        if ((i8 == 0 ? i5 + this.j[1] : i8) >= 0 || c()) {
            return;
        }
        float fAbs = this.f + Math.abs(r1);
        this.f = fAbs;
        j(fAbs);
        iArr[1] = iArr[1] + i8;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent;
        View view = this.a;
        if (view == null || AbstractC12990fW7.U(view)) {
            super.requestDisallowInterceptTouchEvent(z);
        } else {
            if (this.E0 || (parent = getParent()) == null) {
                return;
            }
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    void setAnimationProgress(float f2) {
        this.v.setScaleX(f2);
        this.v.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        f();
        this.D.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = AbstractC4043Dl1.c(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.e = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        n();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z) {
        this.E0 = z;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.h.n(z);
    }

    public void setOnChildScrollUpCallback(i iVar) {
    }

    public void setOnRefreshListener(j jVar) {
        this.b = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.v.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(int i2) {
        setProgressBackgroundColorSchemeColor(AbstractC4043Dl1.c(getContext(), i2));
    }

    public void setProgressViewEndTarget(boolean z, int i2) {
        this.A = i2;
        this.s = z;
        this.v.invalidate();
    }

    public void setProgressViewOffset(boolean z, int i2, int i3) {
        this.s = z;
        this.z = i2;
        this.A = i3;
        this.D0 = true;
        n();
        this.c = false;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.c == z) {
            o(z, false);
            return;
        }
        this.c = z;
        setTargetOffsetTopAndBottom((!this.D0 ? this.A + this.z : this.A) - this.n);
        this.B0 = false;
        z(this.F0);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.C0 = (int) (displayMetrics.density * 56.0f);
            } else {
                this.C0 = (int) (displayMetrics.density * 40.0f);
            }
            this.v.setImageDrawable(null);
            this.D.l(i2);
            this.v.setImageDrawable(this.D);
        }
    }

    public void setSlingshotDistance(int i2) {
        this.B = i2;
    }

    void setTargetOffsetTopAndBottom(int i2) {
        this.v.bringToFront();
        AbstractC12990fW7.a0(this.v, i2);
        this.n = this.v.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return this.h.p(i2);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.h.r();
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void t(View view, int i2, int i3, int i4, int i5, int i6) {
        r(view, i2, i3, i4, i5, i6, this.k);
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public boolean v(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            return onStartNestedScroll(view, view2, i2);
        }
        return false;
    }

    void x(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.H = cVar;
        cVar.setDuration(150L);
        this.v.b(animationListener);
        this.v.clearAnimation();
        this.v.startAnimation(this.H);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        final boolean a;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable, boolean z) {
            super(parcelable);
            this.a = z;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.a ? (byte) 1 : (byte) 0);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readByte() != 0;
        }
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        this.e = -1.0f;
        this.i = new int[2];
        this.j = new int[2];
        this.k = new int[2];
        this.r = -1;
        this.w = -1;
        this.F0 = new a();
        this.G0 = new f();
        this.H0 = new g();
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.m = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.u = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.C0 = (int) (displayMetrics.density * 40.0f);
        d();
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (displayMetrics.density * 64.0f);
        this.A = i2;
        this.e = i2;
        this.g = new C5978Lq4(this);
        this.h = new C5276Iq4(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.C0;
        this.n = i3;
        this.z = i3;
        l(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, J0);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }
}
