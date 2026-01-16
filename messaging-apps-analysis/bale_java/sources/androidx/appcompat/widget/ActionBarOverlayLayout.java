package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.j;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.AbstractC15808kC5;
import ir.nasim.C5978Lq4;
import ir.nasim.InterfaceC5510Jq4;
import ir.nasim.InterfaceC5744Kq4;
import ir.nasim.L93;
import ir.nasim.O98;
import ir.nasim.OB1;
import ir.nasim.PB1;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements OB1, InterfaceC5510Jq4, InterfaceC5744Kq4 {
    static final int[] J = {AbstractC15790kA5.actionBarSize, R.attr.windowContentOverlay};
    ViewPropertyAnimator A;
    final AnimatorListenerAdapter B;
    private final Runnable D;
    private final Runnable G;
    private final C5978Lq4 H;
    private int a;
    private int b;
    private ContentFrameLayout c;
    ActionBarContainer d;
    private PB1 e;
    private Drawable f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    boolean k;
    private int l;
    private int m;
    private final Rect n;
    private final Rect o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private O98 u;
    private O98 v;
    private O98 w;
    private O98 x;
    private d y;
    private OverScroller z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.k = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.k = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.o();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = actionBarOverlayLayout.d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.B);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.o();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = actionBarOverlayLayout.d.animate().translationY(-ActionBarOverlayLayout.this.d.getHeight()).setListener(ActionBarOverlayLayout.this.B);
        }
    }

    public interface d {
        void a();

        void b(int i);

        void c();

        void d(boolean z);

        void e();

        void f();
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    private void i() {
        o();
        this.G.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean j(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.LayoutParams) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = r0
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = r0
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = r0
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.j(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PB1 n(View view) {
        if (view instanceof PB1) {
            return (PB1) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void q(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(J);
        this.a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.g = context.getApplicationInfo().targetSdkVersion < 19;
        this.z = new OverScroller(context);
    }

    private void u() {
        o();
        postDelayed(this.G, 600L);
    }

    private void w() {
        o();
        postDelayed(this.D, 600L);
    }

    private void y() {
        o();
        this.D.run();
    }

    private boolean z(float f) {
        this.z.fling(0, 0, 0, (int) f, 0, 0, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
        return this.z.getFinalY() > this.d.getHeight();
    }

    @Override // ir.nasim.OB1
    public boolean a() {
        x();
        return this.e.a();
    }

    @Override // ir.nasim.OB1
    public boolean b() {
        x();
        return this.e.b();
    }

    @Override // ir.nasim.OB1
    public boolean c() {
        x();
        return this.e.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // ir.nasim.OB1
    public boolean d() {
        x();
        return this.e.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f == null || this.g) {
            return;
        }
        int bottom = this.d.getVisibility() == 0 ? (int) (this.d.getBottom() + this.d.getTranslationY() + 0.5f) : 0;
        this.f.setBounds(0, bottom, getWidth(), this.f.getIntrinsicHeight() + bottom);
        this.f.draw(canvas);
    }

    @Override // ir.nasim.OB1
    public boolean e() {
        x();
        return this.e.e();
    }

    @Override // ir.nasim.OB1
    public void f(int i) {
        x();
        if (i == 2) {
            this.e.m();
        } else if (i == 5) {
            this.e.t();
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // ir.nasim.OB1
    public void g() {
        x();
        this.e.o();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.H.a();
    }

    public CharSequence getTitle() {
        x();
        return this.e.getTitle();
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void h(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void k(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    void o() {
        removeCallbacks(this.D);
        removeCallbacks(this.G);
        ViewPropertyAnimator viewPropertyAnimator = this.A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        x();
        O98 o98A = O98.A(windowInsets, this);
        boolean zJ = j(this.d, new Rect(o98A.k(), o98A.m(), o98A.l(), o98A.j()), true, true, false, true);
        AbstractC12990fW7.f(this, o98A, this.n);
        Rect rect = this.n;
        O98 o98P = o98A.p(rect.left, rect.top, rect.right, rect.bottom);
        this.u = o98P;
        boolean z = true;
        if (!this.v.equals(o98P)) {
            this.v = this.u;
            zJ = true;
        }
        if (this.o.equals(this.n)) {
            z = zJ;
        } else {
            this.o.set(this.n);
        }
        if (z) {
            requestLayout();
        }
        return o98A.a().c().b().y();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        q(getContext());
        AbstractC12990fW7.m0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        x();
        measureChildWithMargins(this.d, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.d.getLayoutParams();
        int iMax = Math.max(0, this.d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int iMax2 = Math.max(0, this.d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.d.getMeasuredState());
        boolean z = (AbstractC12990fW7.L(this) & 256) != 0;
        if (z) {
            measuredHeight = this.a;
            if (this.i && this.d.getTabContainer() != null) {
                measuredHeight += this.a;
            }
        } else {
            measuredHeight = this.d.getVisibility() != 8 ? this.d.getMeasuredHeight() : 0;
        }
        this.p.set(this.n);
        O98 o98 = this.u;
        this.w = o98;
        if (this.h || z) {
            this.w = new O98.b(this.w).d(L93.b(o98.k(), this.w.m() + measuredHeight, this.w.l(), this.w.j())).a();
        } else {
            Rect rect = this.p;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.w = o98.p(0, measuredHeight, 0, 0);
        }
        j(this.c, this.p, true, true, true, true);
        if (!this.x.equals(this.w)) {
            O98 o982 = this.w;
            this.x = o982;
            AbstractC12990fW7.g(this.c, o982);
        }
        measureChildWithMargins(this.c, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int iMax4 = Math.max(iMax2, this.c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.j || !z) {
            return false;
        }
        if (z(f2)) {
            i();
        } else {
            y();
        }
        this.k = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.l + i2;
        this.l = i5;
        setActionBarHideOffset(i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.H.b(view, view2, i);
        this.l = getActionBarHideOffset();
        o();
        d dVar = this.y;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.d.getVisibility() != 0) {
            return false;
        }
        return this.j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.j && !this.k) {
            if (this.l <= this.d.getHeight()) {
                w();
            } else {
                u();
            }
        }
        d dVar = this.y;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        x();
        int i2 = this.m ^ i;
        this.m = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        d dVar = this.y;
        if (dVar != null) {
            dVar.d(!z2);
            if (z || !z2) {
                this.y.a();
            } else {
                this.y.e();
            }
        }
        if ((i2 & 256) == 0 || this.y == null) {
            return;
        }
        AbstractC12990fW7.m0(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.b = i;
        d dVar = this.y;
        if (dVar != null) {
            dVar.b(i);
        }
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void p(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    @Override // ir.nasim.InterfaceC5744Kq4
    public void r(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        t(view, i, i2, i3, i4, i5);
    }

    public boolean s() {
        return this.h;
    }

    public void setActionBarHideOffset(int i) {
        o();
        this.d.setTranslationY(-Math.max(0, Math.min(i, this.d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.y = dVar;
        if (getWindowToken() != null) {
            this.y.b(this.b);
            int i = this.m;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                AbstractC12990fW7.m0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.i = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.j) {
            this.j = z;
            if (z) {
                return;
            }
            o();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        x();
        this.e.setIcon(i);
    }

    public void setLogo(int i) {
        x();
        this.e.q(i);
    }

    @Override // ir.nasim.OB1
    public void setMenu(Menu menu, j.a aVar) {
        x();
        this.e.setMenu(menu, aVar);
    }

    @Override // ir.nasim.OB1
    public void setMenuPrepared() {
        x();
        this.e.setMenuPrepared();
    }

    public void setOverlayMode(boolean z) {
        this.h = z;
        this.g = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // ir.nasim.OB1
    public void setWindowCallback(Window.Callback callback) {
        x();
        this.e.setWindowCallback(callback);
    }

    @Override // ir.nasim.OB1
    public void setWindowTitle(CharSequence charSequence) {
        x();
        this.e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public void t(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // ir.nasim.InterfaceC5510Jq4
    public boolean v(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    void x() {
        if (this.c == null) {
            this.c = (ContentFrameLayout) findViewById(AbstractC15808kC5.action_bar_activity_content);
            this.d = (ActionBarContainer) findViewById(AbstractC15808kC5.action_bar_container);
            this.e = n(findViewById(AbstractC15808kC5.action_bar));
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.n = new Rect();
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        O98 o98 = O98.b;
        this.u = o98;
        this.v = o98;
        this.w = o98;
        this.x = o98;
        this.B = new a();
        this.D = new b();
        this.G = new c();
        q(context);
        this.H = new C5978Lq4(this);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        x();
        this.e.setIcon(drawable);
    }
}
