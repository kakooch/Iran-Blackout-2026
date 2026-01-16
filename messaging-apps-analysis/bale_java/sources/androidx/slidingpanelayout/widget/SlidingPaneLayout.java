package androidx.slidingpanelayout.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.customview.view.AbsSavedState;
import androidx.slidingpanelayout.widget.a;
import androidx.transition.ChangeBounds;
import androidx.transition.r;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15109j15;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.C22013uW7;
import ir.nasim.C22317v2;
import ir.nasim.InterfaceC21132t98;
import ir.nasim.InterfaceC7920Tt2;
import ir.nasim.L93;
import ir.nasim.O98;
import ir.nasim.X2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class SlidingPaneLayout extends ViewGroup {
    private static boolean x;
    private int a;
    private int b;
    private Drawable c;
    private Drawable d;
    private boolean e;
    View f;
    float g;
    private float h;
    int i;
    boolean j;
    private int k;
    private float l;
    private float m;
    private final List n;
    final C22013uW7 o;
    boolean p;
    private boolean q;
    private final Rect r;
    final ArrayList s;
    private int t;
    InterfaceC7920Tt2 u;
    private a.InterfaceC0125a v;
    private androidx.slidingpanelayout.widget.a w;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean c;
        int d;

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
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c ? 1 : 0);
            parcel.writeInt(this.d);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = parcel.readInt() != 0;
            this.d = parcel.readInt();
        }
    }

    class a implements a.InterfaceC0125a {
        a() {
        }

        @Override // androidx.slidingpanelayout.widget.a.InterfaceC0125a
        public void a(InterfaceC7920Tt2 interfaceC7920Tt2) {
            SlidingPaneLayout.this.u = interfaceC7920Tt2;
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.b0(300L);
            changeBounds.e0(AbstractC15109j15.a(0.2f, 0.0f, 0.0f, 1.0f));
            r.a(SlidingPaneLayout.this, changeBounds);
            SlidingPaneLayout.this.requestLayout();
        }
    }

    class b extends C22317v2 {
        private final Rect d = new Rect();

        b() {
        }

        private void n(X2 x2, X2 x22) {
            Rect rect = this.d;
            x22.n(rect);
            x2.l0(rect);
            x2.e1(x22.Z());
            x2.J0(x22.z());
            x2.p0(x22.q());
            x2.t0(x22.t());
            x2.x0(x22.O());
            x2.q0(x22.M());
            x2.z0(x22.P());
            x2.A0(x22.Q());
            x2.h0(x22.J());
            x2.S0(x22.W());
            x2.G0(x22.T());
            x2.a(x22.k());
            x2.I0(x22.x());
        }

        @Override // ir.nasim.C22317v2
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
        }

        @Override // ir.nasim.C22317v2
        public void g(View view, X2 x2) {
            X2 x2C0 = X2.c0(x2);
            super.g(view, x2C0);
            n(x2, x2C0);
            x2C0.e0();
            x2.p0("androidx.slidingpanelayout.widget.SlidingPaneLayout");
            x2.U0(view);
            Object objG = AbstractC12990fW7.G(view);
            if (objG instanceof View) {
                x2.L0((View) objG);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!o(childAt) && childAt.getVisibility() == 0) {
                    AbstractC12990fW7.A0(childAt, 1);
                    x2.c(childAt);
                }
            }
        }

        @Override // ir.nasim.C22317v2
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (o(view)) {
                return false;
            }
            return super.i(viewGroup, view, accessibilityEvent);
        }

        public boolean o(View view) {
            return SlidingPaneLayout.this.j(view);
        }
    }

    private class c extends C22013uW7.c {
        c() {
        }

        private boolean n() {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.j || slidingPaneLayout.getLockMode() == 3) {
                return false;
            }
            if (SlidingPaneLayout.this.l() && SlidingPaneLayout.this.getLockMode() == 1) {
                return false;
            }
            return SlidingPaneLayout.this.l() || SlidingPaneLayout.this.getLockMode() != 2;
        }

        @Override // ir.nasim.C22013uW7.c
        public int a(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f.getLayoutParams();
            if (SlidingPaneLayout.this.k()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + SlidingPaneLayout.this.f.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.i);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.i + paddingLeft);
        }

        @Override // ir.nasim.C22013uW7.c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // ir.nasim.C22013uW7.c
        public int d(View view) {
            return SlidingPaneLayout.this.i;
        }

        @Override // ir.nasim.C22013uW7.c
        public void f(int i, int i2) {
            if (n()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.o.c(slidingPaneLayout.f, i2);
            }
        }

        @Override // ir.nasim.C22013uW7.c
        public void h(int i, int i2) {
            if (n()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.o.c(slidingPaneLayout.f, i2);
            }
        }

        @Override // ir.nasim.C22013uW7.c
        public void i(View view, int i) {
            SlidingPaneLayout.this.s();
        }

        @Override // ir.nasim.C22013uW7.c
        public void j(int i) {
            if (SlidingPaneLayout.this.o.B() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.g != 1.0f) {
                    slidingPaneLayout.e(slidingPaneLayout.f);
                    SlidingPaneLayout.this.p = true;
                } else {
                    slidingPaneLayout.v(slidingPaneLayout.f);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.d(slidingPaneLayout2.f);
                    SlidingPaneLayout.this.p = false;
                }
            }
        }

        @Override // ir.nasim.C22013uW7.c
        public void k(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.o(i);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // ir.nasim.C22013uW7.c
        public void l(View view, float f, float f2) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.k()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.g > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.i;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f.getWidth();
            } else {
                paddingLeft = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && SlidingPaneLayout.this.g > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.i;
                }
            }
            SlidingPaneLayout.this.o.P(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // ir.nasim.C22013uW7.c
        public boolean m(View view, int i) {
            if (n()) {
                return ((LayoutParams) view.getLayoutParams()).b;
            }
            return false;
        }
    }

    public interface d {
    }

    private static class e extends FrameLayout {
        e(View view) {
            super(view.getContext());
            addView(view);
        }

        @Override // android.view.View
        public boolean onGenericMotionEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    static {
        x = Build.VERSION.SDK_INT >= 29;
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    private boolean c(int i) {
        if (!this.e) {
            this.p = false;
        }
        if (!this.q && !t(1.0f, i)) {
            return false;
        }
        this.p = false;
        return true;
    }

    private static Activity g(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private L93 getSystemGestureInsets() {
        O98 o98H;
        if (!x || (o98H = AbstractC12990fW7.H(this)) == null) {
            return null;
        }
        return o98H.i();
    }

    private static Rect h(InterfaceC7920Tt2 interfaceC7920Tt2, View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        Rect rect = new Rect(i, iArr[1], view.getWidth() + i, iArr[1] + view.getWidth());
        Rect rect2 = new Rect(interfaceC7920Tt2.getBounds());
        boolean zIntersect = rect2.intersect(rect);
        if ((rect2.width() == 0 && rect2.height() == 0) || !zIntersect) {
            return null;
        }
        rect2.offset(-iArr[0], -iArr[1]);
        return rect2;
    }

    private static int i(View view) {
        return view instanceof e ? AbstractC12990fW7.C(((e) view).getChildAt(0)) : AbstractC12990fW7.C(view);
    }

    private static int n(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return (((ViewGroup.MarginLayoutParams) layoutParams).width != 0 || layoutParams.a <= 0.0f) ? View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824) : ViewGroup.getChildMeasureSpec(i, i2, ((ViewGroup.MarginLayoutParams) layoutParams).height);
    }

    private boolean q(int i) {
        if (!this.e) {
            this.p = true;
        }
        if (!this.q && !t(0.0f, i)) {
            return false;
        }
        this.p = true;
        return true;
    }

    private void r(float f) {
        boolean zK = k();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != this.f) {
                float f2 = 1.0f - this.h;
                int i2 = this.k;
                this.h = f;
                int i3 = ((int) (f2 * i2)) - ((int) ((1.0f - f) * i2));
                if (zK) {
                    i3 = -i3;
                }
                childAt.offsetLeftAndRight(i3);
            }
        }
    }

    private void setFoldingFeatureObserver(androidx.slidingpanelayout.widget.a aVar) {
        this.w = aVar;
        aVar.f(this.v);
    }

    private ArrayList u() {
        Rect rectH;
        InterfaceC7920Tt2 interfaceC7920Tt2 = this.u;
        if (interfaceC7920Tt2 == null || !interfaceC7920Tt2.b() || this.u.getBounds().left == 0 || this.u.getBounds().top != 0 || (rectH = h(this.u, this)) == null) {
            return null;
        }
        Rect rect = new Rect(getPaddingLeft(), getPaddingTop(), Math.max(getPaddingLeft(), rectH.left), getHeight() - getPaddingBottom());
        int width = getWidth() - getPaddingRight();
        return new ArrayList(Arrays.asList(rect, new Rect(Math.min(width, rectH.right), getPaddingTop(), width, getHeight() - getPaddingBottom())));
    }

    private static boolean w(View view) {
        return view.isOpaque();
    }

    public void a(d dVar) {
        this.n.add(dVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() == 1) {
            super.addView(new e(view), i, layoutParams);
        } else {
            super.addView(view, i, layoutParams);
        }
    }

    public boolean b() {
        return c(0);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.o.n(true)) {
            if (this.e) {
                AbstractC12990fW7.g0(this);
            } else {
                this.o.a();
            }
        }
    }

    void d(View view) {
        Iterator it = this.n.iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
        sendAccessibilityEvent(32);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i;
        int right;
        super.draw(canvas);
        Drawable drawable = k() ? this.d : this.c;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (k()) {
            right = childAt.getRight();
            i = intrinsicWidth + right;
        } else {
            int left = childAt.getLeft();
            int i2 = left - intrinsicWidth;
            i = left;
            right = i2;
        }
        drawable.setBounds(right, top, i, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (k() ^ l()) {
            this.o.N(1);
            L93 systemGestureInsets = getSystemGestureInsets();
            if (systemGestureInsets != null) {
                C22013uW7 c22013uW7 = this.o;
                c22013uW7.M(Math.max(c22013uW7.x(), systemGestureInsets.a));
            }
        } else {
            this.o.N(2);
            L93 systemGestureInsets2 = getSystemGestureInsets();
            if (systemGestureInsets2 != null) {
                C22013uW7 c22013uW72 = this.o;
                c22013uW72.M(Math.max(c22013uW72.x(), systemGestureInsets2.c));
            }
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iSave = canvas.save();
        if (this.e && !layoutParams.b && this.f != null) {
            canvas.getClipBounds(this.r);
            if (k()) {
                Rect rect = this.r;
                rect.left = Math.max(rect.left, this.f.getRight());
            } else {
                Rect rect2 = this.r;
                rect2.right = Math.min(rect2.right, this.f.getLeft());
            }
            canvas.clipRect(this.r);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    void e(View view) {
        Iterator it = this.n.iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
        sendAccessibilityEvent(32);
    }

    void f(View view) {
        Iterator it = this.n.iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Deprecated
    public int getCoveredFadeColor() {
        return this.b;
    }

    public final int getLockMode() {
        return this.t;
    }

    public int getParallaxDistance() {
        return this.k;
    }

    @Deprecated
    public int getSliderFadeColor() {
        return this.a;
    }

    boolean j(View view) {
        if (view == null) {
            return false;
        }
        return this.e && ((LayoutParams) view.getLayoutParams()).c && this.g > 0.0f;
    }

    boolean k() {
        return AbstractC12990fW7.A(this) == 1;
    }

    public boolean l() {
        return !this.e || this.g == 0.0f;
    }

    public boolean m() {
        return this.e;
    }

    void o(int i) {
        if (this.f == null) {
            this.g = 0.0f;
            return;
        }
        boolean zK = k();
        LayoutParams layoutParams = (LayoutParams) this.f.getLayoutParams();
        int width = this.f.getWidth();
        if (zK) {
            i = (getWidth() - i) - width;
        }
        float paddingRight = (i - ((zK ? getPaddingRight() : getPaddingLeft()) + (zK ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin))) / this.i;
        this.g = paddingRight;
        if (this.k != 0) {
            r(paddingRight);
        }
        f(this.f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Activity activityG;
        super.onAttachedToWindow();
        this.q = true;
        if (this.w == null || (activityG = g(getContext())) == null) {
            return;
        }
        this.w.e(activityG);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.q = true;
        androidx.slidingpanelayout.widget.a aVar = this.w;
        if (aVar != null) {
            aVar.g();
        }
        if (this.s.size() <= 0) {
            this.s.clear();
        } else {
            AbstractC18350oW3.a(this.s.get(0));
            throw null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.e && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.p = this.o.F(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.e || (this.j && actionMasked != 0)) {
            this.o.b();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.o.b();
            return false;
        }
        if (actionMasked == 0) {
            this.j = false;
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            this.l = x2;
            this.m = y;
            if (this.o.F(this.f, (int) x2, (int) y) && j(this.f)) {
                z = true;
            }
            return this.o.Q(motionEvent) || z;
        }
        if (actionMasked == 2) {
            float x3 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float fAbs = Math.abs(x3 - this.l);
            float fAbs2 = Math.abs(y2 - this.m);
            if (fAbs > this.o.A() && fAbs2 > fAbs) {
                this.o.b();
                this.j = true;
                return false;
            }
        }
        z = false;
        if (this.o.Q(motionEvent)) {
            return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean zK = k();
        int i10 = i3 - i;
        int paddingRight = zK ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = zK ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.q) {
            this.g = (this.e && this.p) ? 0.0f : 1.0f;
        }
        int i11 = paddingRight;
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() == 8) {
                i5 = i11;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.b) {
                    int i13 = i10 - paddingLeft;
                    int iMin = (Math.min(paddingRight, i13) - i11) - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    this.i = iMin;
                    int i14 = zK ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    layoutParams.c = ((i11 + i14) + iMin) + (measuredWidth / 2) > i13;
                    int i15 = (int) (iMin * this.g);
                    this.g = i15 / iMin;
                    i5 = i11 + i14 + i15;
                    i6 = 0;
                } else if (!this.e || (i7 = this.k) == 0) {
                    i5 = paddingRight;
                    i6 = 0;
                } else {
                    i6 = (int) ((1.0f - this.g) * i7);
                    i5 = paddingRight;
                }
                if (zK) {
                    i9 = (i10 - i5) + i6;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i5 - i6;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                InterfaceC7920Tt2 interfaceC7920Tt2 = this.u;
                paddingRight += childAt.getWidth() + Math.abs((interfaceC7920Tt2 != null && interfaceC7920Tt2.a() == InterfaceC7920Tt2.a.c && this.u.b()) ? this.u.getBounds().width() : 0);
            }
            i12++;
            i11 = i5;
        }
        if (this.q) {
            if (this.e && this.k != 0) {
                r(this.g);
            }
            v(this.f);
        }
        this.q = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0086 A[PHI: r15
      0x0086: PHI (r15v5 float) = (r15v1 float), (r15v6 float) binds: [B:19:0x007d, B:21:0x0082] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v12 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r21, int r22) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (savedState.c) {
            p();
        } else {
            b();
        }
        this.p = savedState.c;
        setLockMode(savedState.d);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = m() ? l() : this.p;
        savedState.d = this.t;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.q = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return super.onTouchEvent(motionEvent);
        }
        this.o.G(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            this.l = x2;
            this.m = y;
        } else if (actionMasked == 1 && j(this.f)) {
            float x3 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f = x3 - this.l;
            float f2 = y2 - this.m;
            int iA = this.o.A();
            if ((f * f) + (f2 * f2) < iA * iA && this.o.F(this.f, (int) x3, (int) y2)) {
                c(0);
            }
        }
        return true;
    }

    public boolean p() {
        return q(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view.getParent() instanceof e) {
            super.removeView((View) view.getParent());
        } else {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.e) {
            return;
        }
        this.p = view == this.f;
    }

    void s() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    @Deprecated
    public void setCoveredFadeColor(int i) {
        this.b = i;
    }

    public final void setLockMode(int i) {
        this.t = i;
    }

    @Deprecated
    public void setPanelSlideListener(d dVar) {
        if (dVar != null) {
            a(dVar);
        }
    }

    public void setParallaxDistance(int i) {
        this.k = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.c = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.d = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawableLeft(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(AbstractC4043Dl1.f(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(AbstractC4043Dl1.f(getContext(), i));
    }

    @Deprecated
    public void setSliderFadeColor(int i) {
        this.a = i;
    }

    boolean t(float f, int i) {
        int paddingLeft;
        if (!this.e) {
            return false;
        }
        boolean zK = k();
        LayoutParams layoutParams = (LayoutParams) this.f.getLayoutParams();
        if (zK) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + (f * this.i)) + this.f.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + (f * this.i));
        }
        C22013uW7 c22013uW7 = this.o;
        View view = this.f;
        if (!c22013uW7.R(view, paddingLeft, view.getTop())) {
            return false;
        }
        s();
        AbstractC12990fW7.g0(this);
        return true;
    }

    void v(View view) {
        int left;
        int right;
        int top;
        int bottom;
        View childAt;
        boolean z;
        View view2 = view;
        boolean zK = k();
        int width = zK ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zK ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !w(view)) {
            left = 0;
            right = 0;
            top = 0;
            bottom = 0;
        } else {
            left = view.getLeft();
            right = view.getRight();
            top = view.getTop();
            bottom = view.getBottom();
        }
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount && (childAt = getChildAt(i)) != view2) {
            if (childAt.getVisibility() == 8) {
                z = zK;
            } else {
                z = zK;
                childAt.setVisibility((Math.max(zK ? paddingLeft : width, childAt.getLeft()) < left || Math.max(paddingTop, childAt.getTop()) < top || Math.min(zK ? width : paddingLeft, childAt.getRight()) > right || Math.min(height, childAt.getBottom()) > bottom) ? 0 : 4);
            }
            i++;
            view2 = view;
            zK = z;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] d = {R.attr.layout_weight};
        public float a;
        boolean b;
        boolean c;

        public LayoutParams() {
            super(-1, -1);
            this.a = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d);
            this.a = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.g = 1.0f;
        this.n = new CopyOnWriteArrayList();
        this.q = true;
        this.r = new Rect();
        this.s = new ArrayList();
        this.v = new a();
        float f = context.getResources().getDisplayMetrics().density;
        setWillNotDraw(false);
        AbstractC12990fW7.p0(this, new b());
        AbstractC12990fW7.A0(this, 1);
        C22013uW7 c22013uW7O = C22013uW7.o(this, 0.5f, new c());
        this.o = c22013uW7O;
        c22013uW7O.O(f * 400.0f);
        setFoldingFeatureObserver(new androidx.slidingpanelayout.widget.a(InterfaceC21132t98.a(context), AbstractC4043Dl1.i(context)));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
