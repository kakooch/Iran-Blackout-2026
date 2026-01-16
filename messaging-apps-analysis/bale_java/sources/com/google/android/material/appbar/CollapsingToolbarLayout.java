package com.google.android.material.appbar;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC17599nE5;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC20604sI1;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC22000uV3;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC6732Ot;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.FG4;
import ir.nasim.GE5;
import ir.nasim.I52;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.LW0;
import ir.nasim.O98;
import ir.nasim.WB5;

/* loaded from: classes3.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int G = AbstractC21175tE5.Widget_Design_CollapsingToolbar;
    private boolean A;
    private int B;
    private boolean D;
    private boolean a;
    private int b;
    private ViewGroup c;
    private View d;
    private View e;
    private int f;
    private int g;
    private int h;
    private int i;
    private final Rect j;
    final LW0 k;
    final I52 l;
    private boolean m;
    private boolean n;
    private Drawable o;
    Drawable p;
    private int q;
    private boolean r;
    private ValueAnimator s;
    private long t;
    private int u;
    private AppBarLayout.f v;
    int w;
    private int x;
    O98 y;
    private int z;

    class a implements InterfaceC22474vI4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC22474vI4
        public O98 b(View view, O98 o98) {
            return CollapsingToolbarLayout.this.n(o98);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    private class c implements AppBarLayout.f {
        c() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, int i) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.w = i;
            O98 o98 = collapsingToolbarLayout.y;
            int iM = o98 != null ? o98.m() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                com.google.android.material.appbar.a aVarJ = CollapsingToolbarLayout.j(childAt);
                int i3 = layoutParams.a;
                if (i3 == 1) {
                    aVarJ.f(AbstractC22000uV3.b(-i, 0, CollapsingToolbarLayout.this.h(childAt)));
                } else if (i3 == 2) {
                    aVarJ.f(Math.round((-i) * layoutParams.b));
                }
            }
            CollapsingToolbarLayout.this.t();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.p != null && iM > 0) {
                AbstractC12990fW7.g0(collapsingToolbarLayout2);
            }
            int height = (CollapsingToolbarLayout.this.getHeight() - AbstractC12990fW7.B(CollapsingToolbarLayout.this)) - iM;
            float f = height;
            CollapsingToolbarLayout.this.k.w0(Math.min(1.0f, (r0 - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger()) / f));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.k.j0(collapsingToolbarLayout3.w + height);
            CollapsingToolbarLayout.this.k.u0(Math.abs(i) / f);
        }
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    private void a(int i) {
        c();
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.s = valueAnimator2;
            valueAnimator2.setInterpolator(i > this.q ? AbstractC6732Ot.c : AbstractC6732Ot.d);
            this.s.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.s.cancel();
        }
        this.s.setDuration(this.t);
        this.s.setIntValues(this.q, i);
        this.s.start();
    }

    private void b(AppBarLayout appBarLayout) {
        if (k()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void c() {
        if (this.a) {
            ViewGroup viewGroup = null;
            this.c = null;
            this.d = null;
            int i = this.b;
            if (i != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i);
                this.c = viewGroup2;
                if (viewGroup2 != null) {
                    this.d = d(viewGroup2);
                }
            }
            if (this.c == null) {
                int childCount = getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i2);
                    if (l(childAt)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                    i2++;
                }
                this.c = viewGroup;
            }
            s();
            this.a = false;
        }
    }

    private View d(View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    private static int g(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private static CharSequence i(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    static com.google.android.material.appbar.a j(View view) {
        com.google.android.material.appbar.a aVar = (com.google.android.material.appbar.a) view.getTag(WB5.view_offset_helper);
        if (aVar != null) {
            return aVar;
        }
        com.google.android.material.appbar.a aVar2 = new com.google.android.material.appbar.a(view);
        view.setTag(WB5.view_offset_helper, aVar2);
        return aVar2;
    }

    private boolean k() {
        return this.x == 1;
    }

    private static boolean l(View view) {
        return (view instanceof Toolbar) || (view instanceof android.widget.Toolbar);
    }

    private boolean m(View view) {
        View view2 = this.d;
        if (view2 == null || view2 == this) {
            if (view != this.c) {
                return false;
            }
        } else if (view != view2) {
            return false;
        }
        return true;
    }

    private void o(boolean z) {
        int titleMarginStart;
        int titleMarginBottom;
        int titleMarginEnd;
        int titleMarginTop;
        View view = this.d;
        if (view == null) {
            view = this.c;
        }
        int iH = h(view);
        AbstractC20604sI1.a(this, this.e, this.j);
        ViewGroup viewGroup = this.c;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            titleMarginStart = toolbar.getTitleMarginStart();
            titleMarginEnd = toolbar.getTitleMarginEnd();
            titleMarginTop = toolbar.getTitleMarginTop();
            titleMarginBottom = toolbar.getTitleMarginBottom();
        } else if (viewGroup instanceof android.widget.Toolbar) {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            titleMarginStart = toolbar2.getTitleMarginStart();
            titleMarginEnd = toolbar2.getTitleMarginEnd();
            titleMarginTop = toolbar2.getTitleMarginTop();
            titleMarginBottom = toolbar2.getTitleMarginBottom();
        } else {
            titleMarginStart = 0;
            titleMarginBottom = 0;
            titleMarginEnd = 0;
            titleMarginTop = 0;
        }
        LW0 lw0 = this.k;
        Rect rect = this.j;
        int i = rect.left + (z ? titleMarginEnd : titleMarginStart);
        int i2 = rect.top + iH + titleMarginTop;
        int i3 = rect.right;
        if (!z) {
            titleMarginStart = titleMarginEnd;
        }
        lw0.b0(i, i2, i3 - titleMarginStart, (rect.bottom + iH) - titleMarginBottom);
    }

    private void p() {
        setContentDescription(getTitle());
    }

    private void q(Drawable drawable, int i, int i2) {
        r(drawable, this.c, i, i2);
    }

    private void r(Drawable drawable, View view, int i, int i2) {
        if (k() && view != null && this.m) {
            i2 = view.getBottom();
        }
        drawable.setBounds(0, 0, i, i2);
    }

    private void s() {
        View view;
        if (!this.m && (view = this.e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.e);
            }
        }
        if (!this.m || this.c == null) {
            return;
        }
        if (this.e == null) {
            this.e = new View(getContext());
        }
        if (this.e.getParent() == null) {
            this.c.addView(this.e, -1, -1);
        }
    }

    private void u(int i, int i2, int i3, int i4, boolean z) {
        View view;
        if (!this.m || (view = this.e) == null) {
            return;
        }
        boolean z2 = AbstractC12990fW7.S(view) && this.e.getVisibility() == 0;
        this.n = z2;
        if (z2 || z) {
            boolean z3 = AbstractC12990fW7.A(this) == 1;
            o(z3);
            this.k.k0(z3 ? this.h : this.f, this.j.top + this.g, (i3 - i) - (z3 ? this.f : this.h), (i4 - i2) - this.i);
            this.k.Z(z);
        }
    }

    private void v() {
        if (this.c != null && this.m && TextUtils.isEmpty(this.k.M())) {
            setTitle(i(this.c));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        c();
        if (this.c == null && (drawable = this.o) != null && this.q > 0) {
            drawable.mutate().setAlpha(this.q);
            this.o.draw(canvas);
        }
        if (this.m && this.n) {
            if (this.c == null || this.o == null || this.q <= 0 || !k() || this.k.D() >= this.k.E()) {
                this.k.l(canvas);
            } else {
                int iSave = canvas.save();
                canvas.clipRect(this.o.getBounds(), Region.Op.DIFFERENCE);
                this.k.l(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        if (this.p == null || this.q <= 0) {
            return;
        }
        O98 o98 = this.y;
        int iM = o98 != null ? o98.m() : 0;
        if (iM > 0) {
            this.p.setBounds(0, -this.w, getWidth(), iM - this.w);
            this.p.mutate().setAlpha(this.q);
            this.p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.o == null || this.q <= 0 || !m(view)) {
            z = false;
        } else {
            r(this.o, view, getWidth(), getHeight());
            this.o.mutate().setAlpha(this.q);
            this.o.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j) || z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.p;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.o;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        LW0 lw0 = this.k;
        if (lw0 != null) {
            state |= lw0.E0(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getCollapsedTitleGravity() {
        return this.k.q();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.k.u();
    }

    public Drawable getContentScrim() {
        return this.o;
    }

    public int getExpandedTitleGravity() {
        return this.k.A();
    }

    public int getExpandedTitleMarginBottom() {
        return this.i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f;
    }

    public int getExpandedTitleMarginTop() {
        return this.g;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.k.C();
    }

    public int getHyphenationFrequency() {
        return this.k.F();
    }

    public int getLineCount() {
        return this.k.G();
    }

    public float getLineSpacingAdd() {
        return this.k.H();
    }

    public float getLineSpacingMultiplier() {
        return this.k.I();
    }

    public int getMaxLines() {
        return this.k.J();
    }

    int getScrimAlpha() {
        return this.q;
    }

    public long getScrimAnimationDuration() {
        return this.t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i = this.u;
        if (i >= 0) {
            return i + this.z + this.B;
        }
        O98 o98 = this.y;
        int iM = o98 != null ? o98.m() : 0;
        int iB = AbstractC12990fW7.B(this);
        return iB > 0 ? Math.min((iB * 2) + iM, getHeight()) : getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.p;
    }

    public CharSequence getTitle() {
        if (this.m) {
            return this.k.M();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.x;
    }

    public TimeInterpolator getTitlePositionInterpolator() {
        return this.k.L();
    }

    final int h(View view) {
        return ((getHeight() - j(view).b()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    O98 n(O98 o98) {
        O98 o982 = AbstractC12990fW7.x(this) ? o98 : null;
        if (!FG4.a(this.y, o982)) {
            this.y = o982;
            requestLayout();
        }
        return o98.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            b(appBarLayout);
            AbstractC12990fW7.y0(this, AbstractC12990fW7.x(appBarLayout));
            if (this.v == null) {
                this.v = new c();
            }
            appBarLayout.d(this.v);
            AbstractC12990fW7.m0(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.k.V(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.f fVar = this.v;
        if (fVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).r(fVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        O98 o98 = this.y;
        if (o98 != null) {
            int iM = o98.m();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!AbstractC12990fW7.x(childAt) && childAt.getTop() < iM) {
                    AbstractC12990fW7.a0(childAt, iM);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            j(getChildAt(i6)).d();
        }
        u(i, i2, i3, i4, false);
        v();
        t();
        int childCount3 = getChildCount();
        for (int i7 = 0; i7 < childCount3; i7++) {
            j(getChildAt(i7)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        c();
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        O98 o98 = this.y;
        int iM = o98 != null ? o98.m() : 0;
        if ((mode == 0 || this.A) && iM > 0) {
            this.z = iM;
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iM, 1073741824));
        }
        if (this.D && this.k.J() > 1) {
            v();
            u(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int iY = this.k.y();
            if (iY > 1) {
                this.B = Math.round(this.k.z()) * (iY - 1);
                super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.B, 1073741824));
            }
        }
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            View view = this.d;
            if (view == null || view == this) {
                setMinimumHeight(g(viewGroup));
            } else {
                setMinimumHeight(g(view));
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = this.o;
        if (drawable != null) {
            q(drawable, i, i2);
        }
    }

    public void setCollapsedTitleGravity(int i) {
        this.k.g0(i);
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.k.d0(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.k.h0(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.o = drawableMutate;
            if (drawableMutate != null) {
                q(drawableMutate, getWidth(), getHeight());
                this.o.setCallback(this);
                this.o.setAlpha(this.q);
            }
            AbstractC12990fW7.g0(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(AbstractC4043Dl1.f(getContext(), i));
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleGravity(int i) {
        this.k.q0(i);
    }

    public void setExpandedTitleMargin(int i, int i2, int i3, int i4) {
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = i4;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.i = i;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.h = i;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f = i;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i) {
        this.g = i;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.k.n0(i);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.k.p0(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.k.s0(typeface);
    }

    public void setExtraMultilineHeightEnabled(boolean z) {
        this.D = z;
    }

    public void setForceApplySystemWindowInsetTop(boolean z) {
        this.A = z;
    }

    public void setHyphenationFrequency(int i) {
        this.k.x0(i);
    }

    public void setLineSpacingAdd(float f) {
        this.k.z0(f);
    }

    public void setLineSpacingMultiplier(float f) {
        this.k.A0(f);
    }

    public void setMaxLines(int i) {
        this.k.B0(i);
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z) {
        this.k.D0(z);
    }

    void setScrimAlpha(int i) {
        ViewGroup viewGroup;
        if (i != this.q) {
            if (this.o != null && (viewGroup = this.c) != null) {
                AbstractC12990fW7.g0(viewGroup);
            }
            this.q = i;
            AbstractC12990fW7.g0(this);
        }
    }

    public void setScrimAnimationDuration(long j) {
        this.t = j;
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.u != i) {
            this.u = i;
            t();
        }
    }

    public void setScrimsShown(boolean z) {
        setScrimsShown(z, AbstractC12990fW7.T(this) && !isInEditMode());
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.p.setState(getDrawableState());
                }
                AbstractC21710u02.g(this.p, AbstractC12990fW7.A(this));
                this.p.setVisible(getVisibility() == 0, false);
                this.p.setCallback(this);
                this.p.setAlpha(this.q);
            }
            AbstractC12990fW7.g0(this);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(AbstractC4043Dl1.f(getContext(), i));
    }

    public void setTitle(CharSequence charSequence) {
        this.k.F0(charSequence);
        p();
    }

    public void setTitleCollapseMode(int i) throws Resources.NotFoundException {
        this.x = i;
        boolean zK = k();
        this.k.v0(zK);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            b((AppBarLayout) parent);
        }
        if (zK && this.o == null) {
            setContentScrimColor(this.l.d(getResources().getDimension(AbstractC12799fB5.design_appbar_elevation)));
        }
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.m) {
            this.m = z;
            p();
            s();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(TimeInterpolator timeInterpolator) {
        this.k.C0(timeInterpolator);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.p;
        if (drawable != null && drawable.isVisible() != z) {
            this.p.setVisible(z, false);
        }
        Drawable drawable2 = this.o;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.o.setVisible(z, false);
    }

    final void t() {
        if (this.o == null && this.p == null) {
            return;
        }
        setScrimsShown(getHeight() + this.w < getScrimVisibleHeightTrigger());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o || drawable == this.p;
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.collapsingToolbarLayoutStyle);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.k.f0(colorStateList);
    }

    public void setScrimsShown(boolean z, boolean z2) {
        if (this.r != z) {
            if (z2) {
                a(z ? 255 : 0);
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.r = z;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        int i2 = G;
        super(AbstractC17750nV3.c(context, attributeSet, i, i2), attributeSet, i);
        this.a = true;
        this.j = new Rect();
        this.u = -1;
        this.z = 0;
        this.B = 0;
        Context context2 = getContext();
        LW0 lw0 = new LW0(this);
        this.k = lw0;
        lw0.G0(AbstractC6732Ot.e);
        lw0.D0(false);
        this.l = new I52(context2);
        TypedArray typedArrayH = AbstractC5729Ko7.h(context2, attributeSet, GE5.CollapsingToolbarLayout, i, i2, new int[0]);
        lw0.q0(typedArrayH.getInt(GE5.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        lw0.g0(typedArrayH.getInt(GE5.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayH.getDimensionPixelSize(GE5.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.i = dimensionPixelSize;
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        if (typedArrayH.hasValue(GE5.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f = typedArrayH.getDimensionPixelSize(GE5.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (typedArrayH.hasValue(GE5.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.h = typedArrayH.getDimensionPixelSize(GE5.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (typedArrayH.hasValue(GE5.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.g = typedArrayH.getDimensionPixelSize(GE5.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (typedArrayH.hasValue(GE5.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.i = typedArrayH.getDimensionPixelSize(GE5.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.m = typedArrayH.getBoolean(GE5.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(typedArrayH.getText(GE5.CollapsingToolbarLayout_title));
        lw0.n0(AbstractC21175tE5.TextAppearance_Design_CollapsingToolbar_Expanded);
        lw0.d0(AbstractC17599nE5.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (typedArrayH.hasValue(GE5.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            lw0.n0(typedArrayH.getResourceId(GE5.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (typedArrayH.hasValue(GE5.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            lw0.d0(typedArrayH.getResourceId(GE5.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        if (typedArrayH.hasValue(GE5.CollapsingToolbarLayout_expandedTitleTextColor)) {
            lw0.p0(AbstractC9751aV3.a(context2, typedArrayH, GE5.CollapsingToolbarLayout_expandedTitleTextColor));
        }
        if (typedArrayH.hasValue(GE5.CollapsingToolbarLayout_collapsedTitleTextColor)) {
            lw0.f0(AbstractC9751aV3.a(context2, typedArrayH, GE5.CollapsingToolbarLayout_collapsedTitleTextColor));
        }
        this.u = typedArrayH.getDimensionPixelSize(GE5.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        if (typedArrayH.hasValue(GE5.CollapsingToolbarLayout_maxLines)) {
            lw0.B0(typedArrayH.getInt(GE5.CollapsingToolbarLayout_maxLines, 1));
        }
        if (typedArrayH.hasValue(GE5.CollapsingToolbarLayout_titlePositionInterpolator)) {
            lw0.C0(AnimationUtils.loadInterpolator(context2, typedArrayH.getResourceId(GE5.CollapsingToolbarLayout_titlePositionInterpolator, 0)));
        }
        this.t = typedArrayH.getInt(GE5.CollapsingToolbarLayout_scrimAnimationDuration, SetRpcStruct$ComposedRpc.GET_JWT_TOKEN_FIELD_NUMBER);
        setContentScrim(typedArrayH.getDrawable(GE5.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayH.getDrawable(GE5.CollapsingToolbarLayout_statusBarScrim));
        setTitleCollapseMode(typedArrayH.getInt(GE5.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.b = typedArrayH.getResourceId(GE5.CollapsingToolbarLayout_toolbarId, -1);
        this.A = typedArrayH.getBoolean(GE5.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.D = typedArrayH.getBoolean(GE5.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        typedArrayH.recycle();
        setWillNotDraw(false);
        AbstractC12990fW7.E0(this, new a());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        int a;
        float b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            this.b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, GE5.CollapsingToolbarLayout_Layout);
            this.a = typedArrayObtainStyledAttributes.getInt(GE5.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(typedArrayObtainStyledAttributes.getFloat(GE5.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(float f) {
            this.b = f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = 0;
            this.b = 0.5f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
            this.b = 0.5f;
        }
    }
}
