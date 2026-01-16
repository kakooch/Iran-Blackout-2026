package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.C;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import ir.nasim.AbstractC10961cV3;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.AbstractC17750nV3;
import ir.nasim.AbstractC18504om1;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC24690z26;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC9594aE;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C10345bV3;
import ir.nasim.C11411cx6;
import ir.nasim.C12054dx6;
import ir.nasim.C15592jq4;
import ir.nasim.GE5;
import ir.nasim.O98;
import ir.nasim.X17;
import ir.nasim.YK2;

/* loaded from: classes3.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] r = {R.attr.state_checked};
    private static final int[] s = {-16842910};
    private static final int t = AbstractC21175tE5.Widget_Design_NavigationView;
    private final C15592jq4 f;
    private final com.google.android.material.internal.a g;
    private final int h;
    private final int[] i;
    private MenuInflater j;
    private ViewTreeObserver.OnGlobalLayoutListener k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private Path p;
    private final RectF q;

    class a implements e.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(e eVar, MenuItem menuItem) {
            NavigationView.this.getClass();
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(e eVar) {
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.i);
            boolean z = NavigationView.this.i[1] == 0;
            NavigationView.this.g.C(z);
            NavigationView navigationView2 = NavigationView.this;
            navigationView2.setDrawTopInsetForeground(z && navigationView2.k());
            Activity activityA = AbstractC18504om1.a(NavigationView.this.getContext());
            if (activityA != null) {
                boolean z2 = activityA.findViewById(R.id.content).getHeight() == NavigationView.this.getHeight();
                boolean z3 = Color.alpha(activityA.getWindow().getNavigationBarColor()) != 0;
                NavigationView navigationView3 = NavigationView.this;
                navigationView3.setDrawBottomInsetForeground(z2 && z3 && navigationView3.j());
            }
        }
    }

    public interface c {
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    private ColorStateList d(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListA = AbstractC9594aE.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(AbstractC15790kA5.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateListA.getDefaultColor();
        int[] iArr = s;
        return new ColorStateList(new int[][]{iArr, r, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    private Drawable e(C c2) {
        return f(c2, AbstractC9751aV3.b(getContext(), c2, GE5.NavigationView_itemShapeFillColor));
    }

    private Drawable f(C c2, ColorStateList colorStateList) {
        C10345bV3 c10345bV3 = new C10345bV3(C11411cx6.b(getContext(), c2.n(GE5.NavigationView_itemShapeAppearance, 0), c2.n(GE5.NavigationView_itemShapeAppearanceOverlay, 0)).m());
        c10345bV3.b0(colorStateList);
        return new InsetDrawable((Drawable) c10345bV3, c2.f(GE5.NavigationView_itemShapeInsetStart, 0), c2.f(GE5.NavigationView_itemShapeInsetTop, 0), c2.f(GE5.NavigationView_itemShapeInsetEnd, 0), c2.f(GE5.NavigationView_itemShapeInsetBottom, 0));
    }

    private boolean g(C c2) {
        return c2.s(GE5.NavigationView_itemShapeAppearance) || c2.s(GE5.NavigationView_itemShapeAppearanceOverlay);
    }

    private MenuInflater getMenuInflater() {
        if (this.j == null) {
            this.j = new X17(getContext());
        }
        return this.j;
    }

    private void l(int i, int i2) {
        if (!(getParent() instanceof DrawerLayout) || this.o <= 0 || !(getBackground() instanceof C10345bV3)) {
            this.p = null;
            this.q.setEmpty();
            return;
        }
        C10345bV3 c10345bV3 = (C10345bV3) getBackground();
        C11411cx6.b bVarV = c10345bV3.E().v();
        if (YK2.b(this.n, AbstractC12990fW7.A(this)) == 3) {
            bVarV.M(this.o);
            bVarV.B(this.o);
        } else {
            bVarV.H(this.o);
            bVarV.w(this.o);
        }
        c10345bV3.setShapeAppearanceModel(bVarV.m());
        if (this.p == null) {
            this.p = new Path();
        }
        this.p.reset();
        this.q.set(0.0f, 0.0f, i, i2);
        C12054dx6.k().d(c10345bV3.E(), c10345bV3.y(), this.q, this.p);
        invalidate();
    }

    private void m() {
        this.k = new b();
        getViewTreeObserver().addOnGlobalLayoutListener(this.k);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    protected void a(O98 o98) {
        this.g.m(o98);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.p == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.clipPath(this.p);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    public MenuItem getCheckedItem() {
        return this.g.n();
    }

    public int getDividerInsetEnd() {
        return this.g.o();
    }

    public int getDividerInsetStart() {
        return this.g.p();
    }

    public int getHeaderCount() {
        return this.g.q();
    }

    public Drawable getItemBackground() {
        return this.g.r();
    }

    public int getItemHorizontalPadding() {
        return this.g.s();
    }

    public int getItemIconPadding() {
        return this.g.t();
    }

    public ColorStateList getItemIconTintList() {
        return this.g.w();
    }

    public int getItemMaxLines() {
        return this.g.u();
    }

    public ColorStateList getItemTextColor() {
        return this.g.v();
    }

    public int getItemVerticalPadding() {
        return this.g.x();
    }

    public Menu getMenu() {
        return this.f;
    }

    public int getSubheaderInsetEnd() {
        return this.g.z();
    }

    public int getSubheaderInsetStart() {
        return this.g.A();
    }

    public View h(int i) {
        return this.g.B(i);
    }

    public void i(int i) {
        this.g.V(true);
        getMenuInflater().inflate(i, this.f);
        this.g.V(false);
        this.g.i(false);
    }

    public boolean j() {
        return this.m;
    }

    public boolean k() {
        return this.l;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC10961cV3.e(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.k);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.h), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f.S(savedState.c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.c = bundle;
        this.f.U(bundle);
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        l(i, i2);
    }

    public void setBottomInsetScrimEnabled(boolean z) {
        this.m = z;
    }

    public void setCheckedItem(int i) {
        MenuItem menuItemFindItem = this.f.findItem(i);
        if (menuItemFindItem != null) {
            this.g.D((g) menuItemFindItem);
        }
    }

    public void setDividerInsetEnd(int i) {
        this.g.E(i);
    }

    public void setDividerInsetStart(int i) {
        this.g.F(i);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        AbstractC10961cV3.d(this, f);
    }

    public void setItemBackground(Drawable drawable) {
        this.g.H(drawable);
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(AbstractC4043Dl1.f(getContext(), i));
    }

    public void setItemHorizontalPadding(int i) {
        this.g.J(i);
    }

    public void setItemHorizontalPaddingResource(int i) {
        this.g.J(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconPadding(int i) {
        this.g.K(i);
    }

    public void setItemIconPaddingResource(int i) {
        this.g.K(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconSize(int i) {
        this.g.L(i);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.g.M(colorStateList);
    }

    public void setItemMaxLines(int i) {
        this.g.N(i);
    }

    public void setItemTextAppearance(int i) {
        this.g.O(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.g.P(colorStateList);
    }

    public void setItemVerticalPadding(int i) {
        this.g.Q(i);
    }

    public void setItemVerticalPaddingResource(int i) {
        this.g.Q(getResources().getDimensionPixelSize(i));
    }

    public void setNavigationItemSelectedListener(c cVar) {
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        com.google.android.material.internal.a aVar = this.g;
        if (aVar != null) {
            aVar.R(i);
        }
    }

    public void setSubheaderInsetEnd(int i) {
        this.g.T(i);
    }

    public void setSubheaderInsetStart(int i) {
        this.g.T(i);
    }

    public void setTopInsetScrimEnabled(boolean z) {
        this.l = z;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public Bundle c;

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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.c);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC12181eA5.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateListD;
        int i2 = t;
        super(AbstractC17750nV3.c(context, attributeSet, i, i2), attributeSet, i);
        com.google.android.material.internal.a aVar = new com.google.android.material.internal.a();
        this.g = aVar;
        this.i = new int[2];
        this.l = true;
        this.m = true;
        this.n = 0;
        this.o = 0;
        this.q = new RectF();
        Context context2 = getContext();
        C15592jq4 c15592jq4 = new C15592jq4(context2);
        this.f = c15592jq4;
        C cI = AbstractC5729Ko7.i(context2, attributeSet, GE5.NavigationView, i, i2, new int[0]);
        if (cI.s(GE5.NavigationView_android_background)) {
            AbstractC12990fW7.t0(this, cI.g(GE5.NavigationView_android_background));
        }
        this.o = cI.f(GE5.NavigationView_drawerLayoutCornerSize, 0);
        this.n = cI.k(GE5.NavigationView_android_layout_gravity, 0);
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            C11411cx6 c11411cx6M = C11411cx6.e(context2, attributeSet, i, i2).m();
            Drawable background = getBackground();
            C10345bV3 c10345bV3 = new C10345bV3(c11411cx6M);
            if (background instanceof ColorDrawable) {
                c10345bV3.b0(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            c10345bV3.Q(context2);
            AbstractC12990fW7.t0(this, c10345bV3);
        }
        if (cI.s(GE5.NavigationView_elevation)) {
            setElevation(cI.f(GE5.NavigationView_elevation, 0));
        }
        setFitsSystemWindows(cI.a(GE5.NavigationView_android_fitsSystemWindows, false));
        this.h = cI.f(GE5.NavigationView_android_maxWidth, 0);
        ColorStateList colorStateListC = cI.s(GE5.NavigationView_subheaderColor) ? cI.c(GE5.NavigationView_subheaderColor) : null;
        int iN = cI.s(GE5.NavigationView_subheaderTextAppearance) ? cI.n(GE5.NavigationView_subheaderTextAppearance, 0) : 0;
        if (iN == 0 && colorStateListC == null) {
            colorStateListC = d(R.attr.textColorSecondary);
        }
        if (cI.s(GE5.NavigationView_itemIconTint)) {
            colorStateListD = cI.c(GE5.NavigationView_itemIconTint);
        } else {
            colorStateListD = d(R.attr.textColorSecondary);
        }
        int iN2 = cI.s(GE5.NavigationView_itemTextAppearance) ? cI.n(GE5.NavigationView_itemTextAppearance, 0) : 0;
        if (cI.s(GE5.NavigationView_itemIconSize)) {
            setItemIconSize(cI.f(GE5.NavigationView_itemIconSize, 0));
        }
        ColorStateList colorStateListC2 = cI.s(GE5.NavigationView_itemTextColor) ? cI.c(GE5.NavigationView_itemTextColor) : null;
        if (iN2 == 0 && colorStateListC2 == null) {
            colorStateListC2 = d(R.attr.textColorPrimary);
        }
        Drawable drawableG = cI.g(GE5.NavigationView_itemBackground);
        if (drawableG == null && g(cI)) {
            drawableG = e(cI);
            ColorStateList colorStateListB = AbstractC9751aV3.b(context2, cI, GE5.NavigationView_itemRippleColor);
            if (colorStateListB != null) {
                aVar.I(new RippleDrawable(AbstractC24690z26.d(colorStateListB), null, f(cI, null)));
            }
        }
        if (cI.s(GE5.NavigationView_itemHorizontalPadding)) {
            setItemHorizontalPadding(cI.f(GE5.NavigationView_itemHorizontalPadding, 0));
        }
        if (cI.s(GE5.NavigationView_itemVerticalPadding)) {
            setItemVerticalPadding(cI.f(GE5.NavigationView_itemVerticalPadding, 0));
        }
        setDividerInsetStart(cI.f(GE5.NavigationView_dividerInsetStart, 0));
        setDividerInsetEnd(cI.f(GE5.NavigationView_dividerInsetEnd, 0));
        setSubheaderInsetStart(cI.f(GE5.NavigationView_subheaderInsetStart, 0));
        setSubheaderInsetEnd(cI.f(GE5.NavigationView_subheaderInsetEnd, 0));
        setTopInsetScrimEnabled(cI.a(GE5.NavigationView_topInsetScrimEnabled, this.l));
        setBottomInsetScrimEnabled(cI.a(GE5.NavigationView_bottomInsetScrimEnabled, this.m));
        int iF = cI.f(GE5.NavigationView_itemIconPadding, 0);
        setItemMaxLines(cI.k(GE5.NavigationView_itemMaxLines, 1));
        c15592jq4.V(new a());
        aVar.G(1);
        aVar.l(context2, c15592jq4);
        if (iN != 0) {
            aVar.U(iN);
        }
        aVar.S(colorStateListC);
        aVar.M(colorStateListD);
        aVar.R(getOverScrollMode());
        if (iN2 != 0) {
            aVar.O(iN2);
        }
        aVar.P(colorStateListC2);
        aVar.H(drawableG);
        aVar.K(iF);
        c15592jq4.b(aVar);
        addView((View) aVar.y(this));
        if (cI.s(GE5.NavigationView_menu)) {
            i(cI.n(GE5.NavigationView_menu, 0));
        }
        if (cI.s(GE5.NavigationView_headerLayout)) {
            h(cI.n(GE5.NavigationView_headerLayout, 0));
        }
        cI.w();
        m();
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.f.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.g.D((g) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
