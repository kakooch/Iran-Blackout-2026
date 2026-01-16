package androidx.viewpager2.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.u;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC24215yE5;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.InterfaceC18845pL6;
import ir.nasim.X2;

/* loaded from: classes2.dex */
public final class ViewPager2 extends ViewGroup {
    static boolean u = true;
    private final Rect a;
    private final Rect b;
    private androidx.viewpager2.widget.b c;
    int d;
    boolean e;
    private RecyclerView.j f;
    private LinearLayoutManager g;
    private int h;
    private Parcelable i;
    RecyclerView j;
    private u k;
    androidx.viewpager2.widget.e l;
    private androidx.viewpager2.widget.b m;
    private androidx.viewpager2.widget.c n;
    private androidx.viewpager2.widget.d o;
    private RecyclerView.m p;
    private boolean q;
    private boolean r;
    private int s;
    e t;

    class a extends g {
        a() {
            super(null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.j
        public void a() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.e = true;
            viewPager2.l.n();
        }
    }

    class b extends i {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void a(int i) {
            if (i == 0) {
                ViewPager2.this.s();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.d != i) {
                viewPager2.d = i;
                viewPager2.t.q();
            }
        }
    }

    class c extends i {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.j.requestFocus(2);
            }
        }
    }

    class d implements RecyclerView.q {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void b(View view) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void d(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }
    }

    private abstract class e {
        private e() {
        }

        boolean a() {
            return false;
        }

        boolean b(int i) {
            return false;
        }

        boolean c(int i, Bundle bundle) {
            return false;
        }

        boolean d() {
            return false;
        }

        void e(RecyclerView.h hVar) {
        }

        void f(RecyclerView.h hVar) {
        }

        String g() {
            throw new IllegalStateException("Not implemented.");
        }

        void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
        }

        void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        boolean k(int i) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean l(int i, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        void m() {
        }

        CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        void o(AccessibilityEvent accessibilityEvent) {
        }

        void p() {
        }

        void q() {
        }

        void r() {
        }

        void s() {
        }

        /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this();
        }

        void j(X2 x2) {
        }
    }

    class f extends e {
        f() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b(int i) {
            return (i == 8192 || i == 4096) && !ViewPager2.this.i();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean d() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void j(X2 x2) {
            if (ViewPager2.this.i()) {
                return;
            }
            x2.f0(X2.a.r);
            x2.f0(X2.a.q);
            x2.R0(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean k(int i) {
            if (b(i)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public CharSequence n() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    private static abstract class g extends RecyclerView.j {
        private g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public abstract void a();

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void b(int i, int i2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void c(int i, int i2, Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void d(int i, int i2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void e(int i, int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void f(int i, int i2) {
            a();
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    private class h extends LinearLayoutManager {
        h(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void P0(RecyclerView.v vVar, RecyclerView.z zVar, X2 x2) {
            super.P0(vVar, zVar, x2);
            ViewPager2.this.t.j(x2);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void Q1(RecyclerView.z zVar, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.Q1(zVar, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public boolean k1(RecyclerView.v vVar, RecyclerView.z zVar, int i, Bundle bundle) {
            return ViewPager2.this.t.b(i) ? ViewPager2.this.t.k(i) : super.k1(vVar, zVar, i, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public boolean v1(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    public static abstract class i {
        public void a(int i) {
        }

        public void b(int i, float f, int i2) {
        }

        public void c(int i) {
        }
    }

    class j extends e {
        private final InterfaceC10698c3 b;
        private final InterfaceC10698c3 c;
        private RecyclerView.j d;

        class a implements InterfaceC10698c3 {
            a() {
            }

            @Override // ir.nasim.InterfaceC10698c3
            public boolean a(View view, InterfaceC10698c3.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        class b implements InterfaceC10698c3 {
            b() {
            }

            @Override // ir.nasim.InterfaceC10698c3
            public boolean a(View view, InterfaceC10698c3.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        class c extends g {
            c() {
                super(null);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.j
            public void a() {
                j.this.w();
            }
        }

        j() {
            super(ViewPager2.this, null);
            this.b = new a();
            this.c = new b();
        }

        private void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            int itemCount2;
            if (ViewPager2.this.getAdapter() == null) {
                itemCount = 0;
                itemCount2 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                itemCount = ViewPager2.this.getAdapter().getItemCount();
                itemCount2 = 0;
            } else {
                itemCount2 = ViewPager2.this.getAdapter().getItemCount();
                itemCount = 0;
            }
            X2.g1(accessibilityNodeInfo).r0(X2.e.b(itemCount, itemCount2, false, 0));
        }

        private void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.h adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !ViewPager2.this.i()) {
                return;
            }
            if (ViewPager2.this.d > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (ViewPager2.this.d < itemCount - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean c(int i, Bundle bundle) {
            return i == 8192 || i == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void e(RecyclerView.h hVar) {
            w();
            if (hVar != null) {
                hVar.registerAdapterDataObserver(this.d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void f(RecyclerView.h hVar) {
            if (hVar != null) {
                hVar.unregisterAdapterDataObserver(this.d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
            AbstractC12990fW7.A0(recyclerView, 2);
            this.d = new c();
            if (AbstractC12990fW7.y(ViewPager2.this) == 0) {
                AbstractC12990fW7.A0(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            u(accessibilityNodeInfo);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean l(int i, Bundle bundle) {
            if (!c(i, bundle)) {
                throw new IllegalStateException();
            }
            v(i == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void m() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void o(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void p() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void q() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void r() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void s() {
            w();
        }

        void v(int i) {
            if (ViewPager2.this.i()) {
                ViewPager2.this.n(i, true);
            }
        }

        void w() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i = R.id.accessibilityActionPageLeft;
            AbstractC12990fW7.j0(viewPager2, R.id.accessibilityActionPageLeft);
            AbstractC12990fW7.j0(viewPager2, R.id.accessibilityActionPageRight);
            AbstractC12990fW7.j0(viewPager2, R.id.accessibilityActionPageUp);
            AbstractC12990fW7.j0(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.i()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.d < itemCount - 1) {
                    AbstractC12990fW7.l0(viewPager2, new X2.a(R.id.accessibilityActionPageDown, null), null, this.b);
                }
                if (ViewPager2.this.d > 0) {
                    AbstractC12990fW7.l0(viewPager2, new X2.a(R.id.accessibilityActionPageUp, null), null, this.c);
                    return;
                }
                return;
            }
            boolean zH = ViewPager2.this.h();
            int i2 = zH ? 16908360 : 16908361;
            if (zH) {
                i = 16908361;
            }
            if (ViewPager2.this.d < itemCount - 1) {
                AbstractC12990fW7.l0(viewPager2, new X2.a(i2, null), null, this.b);
            }
            if (ViewPager2.this.d > 0) {
                AbstractC12990fW7.l0(viewPager2, new X2.a(i, null), null, this.c);
            }
        }
    }

    public interface k {
        void a(View view, float f);
    }

    private class l extends u {
        l() {
        }

        @Override // androidx.recyclerview.widget.u, androidx.recyclerview.widget.y
        public View f(RecyclerView.p pVar) {
            if (ViewPager2.this.g()) {
                return null;
            }
            return super.f(pVar);
        }
    }

    private class m extends RecyclerView {
        m(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.t.d() ? ViewPager2.this.t.n() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.d);
            accessibilityEvent.setToIndex(ViewPager2.this.d);
            ViewPager2.this.t.o(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.i() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.i() && super.onTouchEvent(motionEvent);
        }
    }

    private static class n implements Runnable {
        private final int a;
        private final RecyclerView b;

        n(int i, RecyclerView recyclerView) {
            this.a = i;
            this.b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.smoothScrollToPosition(this.a);
        }
    }

    public ViewPager2(Context context) {
        super(context);
        this.a = new Rect();
        this.b = new Rect();
        this.c = new androidx.viewpager2.widget.b(3);
        this.e = false;
        this.f = new a();
        this.h = -1;
        this.p = null;
        this.q = false;
        this.r = true;
        this.s = -1;
        f(context, null);
    }

    private RecyclerView.q d() {
        return new d();
    }

    private void f(Context context, AttributeSet attributeSet) {
        this.t = u ? new j() : new f();
        m mVar = new m(context);
        this.j = mVar;
        mVar.setId(AbstractC12990fW7.k());
        this.j.setDescendantFocusability(131072);
        h hVar = new h(context);
        this.g = hVar;
        this.j.setLayoutManager(hVar);
        this.j.setScrollingTouchSlop(1);
        o(context, attributeSet);
        this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.j.addOnChildAttachStateChangeListener(d());
        androidx.viewpager2.widget.e eVar = new androidx.viewpager2.widget.e(this);
        this.l = eVar;
        this.n = new androidx.viewpager2.widget.c(this, eVar, this.j);
        l lVar = new l();
        this.k = lVar;
        lVar.b(this.j);
        this.j.addOnScrollListener(this.l);
        androidx.viewpager2.widget.b bVar = new androidx.viewpager2.widget.b(3);
        this.m = bVar;
        this.l.r(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.m.d(bVar2);
        this.m.d(cVar);
        this.t.h(this.m, this.j);
        this.m.d(this.c);
        androidx.viewpager2.widget.d dVar = new androidx.viewpager2.widget.d(this.g);
        this.o = dVar;
        this.m.d(dVar);
        RecyclerView recyclerView = this.j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void j(RecyclerView.h hVar) {
        if (hVar != null) {
            hVar.registerAdapterDataObserver(this.f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void m() {
        RecyclerView.h adapter;
        if (this.h == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.i;
        if (parcelable != null) {
            if (adapter instanceof InterfaceC18845pL6) {
                ((InterfaceC18845pL6) adapter).p(parcelable);
            }
            this.i = null;
        }
        int iMax = Math.max(0, Math.min(this.h, adapter.getItemCount() - 1));
        this.d = iMax;
        this.h = -1;
        this.j.scrollToPosition(iMax);
        this.t.m();
    }

    private void o(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC24215yE5.ViewPager2);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, AbstractC24215yE5.ViewPager2, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(AbstractC24215yE5.ViewPager2_android_orientation, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void q(RecyclerView.h hVar) {
        if (hVar != null) {
            hVar.unregisterAdapterDataObserver(this.f);
        }
    }

    public void a(RecyclerView.o oVar) {
        this.j.addItemDecoration(oVar);
    }

    public boolean b() {
        return this.n.b();
    }

    public boolean c() {
        return this.n.d();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        return this.j.canScrollHorizontally(i2);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i2) {
        return this.j.canScrollVertically(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).a;
            sparseArray.put(this.j.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        m();
    }

    public boolean e(float f2) {
        return this.n.e(f2);
    }

    public boolean g() {
        return this.n.f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return this.t.a() ? this.t.g() : super.getAccessibilityClassName();
    }

    public RecyclerView.h getAdapter() {
        return this.j.getAdapter();
    }

    public int getCurrentItem() {
        return this.d;
    }

    public int getItemDecorationCount() {
        return this.j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.s;
    }

    public int getOrientation() {
        return this.g.r2();
    }

    int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.l.h();
    }

    boolean h() {
        return this.g.a0() == 1;
    }

    public boolean i() {
        return this.r;
    }

    public void k(i iVar) {
        this.c.d(iVar);
    }

    public void l() {
        if (this.o.d() == null) {
            return;
        }
        double dG = this.l.g();
        int i2 = (int) dG;
        float f2 = (float) (dG - i2);
        this.o.b(i2, f2, Math.round(getPageSize() * f2));
    }

    void n(int i2, boolean z) {
        RecyclerView.h adapter = getAdapter();
        if (adapter == null) {
            if (this.h != -1) {
                this.h = Math.max(i2, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
        if (iMin == this.d && this.l.k()) {
            return;
        }
        int i3 = this.d;
        if (iMin == i3 && z) {
            return;
        }
        double dG = i3;
        this.d = iMin;
        this.t.q();
        if (!this.l.k()) {
            dG = this.l.g();
        }
        this.l.p(iMin, z);
        if (!z) {
            this.j.scrollToPosition(iMin);
            return;
        }
        double d2 = iMin;
        if (Math.abs(d2 - dG) <= 3.0d) {
            this.j.smoothScrollToPosition(iMin);
            return;
        }
        this.j.scrollToPosition(d2 > dG ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView = this.j;
        recyclerView.post(new n(iMin, recyclerView));
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.t.i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        this.a.left = getPaddingLeft();
        this.a.right = (i4 - i2) - getPaddingRight();
        this.a.top = getPaddingTop();
        this.a.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.a, this.b);
        RecyclerView recyclerView = this.j;
        Rect rect = this.b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.e) {
            s();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        measureChild(this.j, i2, i3);
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        int measuredState = this.j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.h = savedState.b;
        this.i = savedState.c;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.j.getId();
        int i2 = this.h;
        if (i2 == -1) {
            i2 = this.d;
        }
        savedState.b = i2;
        Parcelable parcelable = this.i;
        if (parcelable != null) {
            savedState.c = parcelable;
        } else {
            Object adapter = this.j.getAdapter();
            if (adapter instanceof InterfaceC18845pL6) {
                savedState.c = ((InterfaceC18845pL6) adapter).b();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    void p() {
        View viewF = this.k.f(this.g);
        if (viewF == null) {
            return;
        }
        int[] iArrC = this.k.c(this.g, viewF);
        int i2 = iArrC[0];
        if (i2 == 0 && iArrC[1] == 0) {
            return;
        }
        this.j.smoothScrollBy(i2, iArrC[1]);
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        return this.t.c(i2, bundle) ? this.t.l(i2, bundle) : super.performAccessibilityAction(i2, bundle);
    }

    public void r(i iVar) {
        this.c.e(iVar);
    }

    void s() {
        u uVar = this.k;
        if (uVar == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewF = uVar.f(this.g);
        if (viewF == null) {
            return;
        }
        int iI0 = this.g.i0(viewF);
        if (iI0 != this.d && getScrollState() == 0) {
            this.m.c(iI0);
        }
        this.e = false;
    }

    public void setAdapter(RecyclerView.h hVar) {
        RecyclerView.h adapter = this.j.getAdapter();
        this.t.f(adapter);
        q(adapter);
        this.j.setAdapter(hVar);
        this.d = 0;
        m();
        this.t.e(hVar);
        j(hVar);
    }

    public void setCurrentItem(int i2) {
        setCurrentItem(i2, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.t.p();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1 && i2 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.s = i2;
        this.j.requestLayout();
    }

    public void setOrientation(int i2) {
        this.g.F2(i2);
        this.t.r();
    }

    public void setPageTransformer(k kVar) {
        if (kVar != null) {
            if (!this.q) {
                this.p = this.j.getItemAnimator();
                this.q = true;
            }
            this.j.setItemAnimator(null);
        } else if (this.q) {
            this.j.setItemAnimator(this.p);
            this.p = null;
            this.q = false;
        }
        if (kVar == this.o.d()) {
            return;
        }
        this.o.e(kVar);
        l();
    }

    public void setUserInputEnabled(boolean z) {
        this.r = z;
        this.t.s();
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int a;
        int b;
        Parcelable c;

        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
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
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeParcelable(this.c, i);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void setCurrentItem(int i2, boolean z) {
        if (g()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        n(i2, z);
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Rect();
        this.b = new Rect();
        this.c = new androidx.viewpager2.widget.b(3);
        this.e = false;
        this.f = new a();
        this.h = -1;
        this.p = null;
        this.q = false;
        this.r = true;
        this.s = -1;
        f(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new Rect();
        this.b = new Rect();
        this.c = new androidx.viewpager2.widget.b(3);
        this.e = false;
        this.f = new a();
        this.h = -1;
        this.p = null;
        this.q = false;
        this.r = true;
        this.s = -1;
        f(context, attributeSet);
    }
}
