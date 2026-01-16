package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.k;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15575jo7;
import ir.nasim.AbstractC16714lk4;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC23026wD5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC6732Ot;
import ir.nasim.AbstractC8375Vr7;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C5187Ig5;
import ir.nasim.DC5;
import ir.nasim.HB5;
import ir.nasim.WB5;
import ir.nasim.X2;

/* loaded from: classes3.dex */
public abstract class NavigationBarItemView extends FrameLayout implements k.a {
    private static final int[] D = {R.attr.state_checked};
    private static final d G;
    private static final d H;
    private int A;
    private com.google.android.material.badge.a B;
    private boolean a;
    private int b;
    private int c;
    private float d;
    private float e;
    private float f;
    private int g;
    private boolean h;
    private final FrameLayout i;
    private final View j;
    private final ImageView k;
    private final ViewGroup l;
    private final TextView m;
    private final TextView n;
    private int o;
    private g p;
    private ColorStateList q;
    private Drawable r;
    private Drawable s;
    private ValueAnimator t;
    private d u;
    private float v;
    private boolean w;
    private int x;
    private int y;
    private boolean z;

    class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws Resources.NotFoundException {
            if (NavigationBarItemView.this.k.getVisibility() == 0) {
                NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                navigationBarItemView.u(navigationBarItemView.k);
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            NavigationBarItemView.this.v(this.a);
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float a;

        c(float f) {
            this.a = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NavigationBarItemView.this.o(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.a);
        }
    }

    private static class d {
        private d() {
        }

        protected float a(float f, float f2) {
            return AbstractC6732Ot.b(0.0f, 1.0f, f2 == 0.0f ? 0.8f : 0.0f, f2 == 0.0f ? 1.0f : 0.2f, f);
        }

        protected float b(float f, float f2) {
            return AbstractC6732Ot.a(0.4f, 1.0f, f);
        }

        protected float c(float f, float f2) {
            return 1.0f;
        }

        public void d(float f, float f2, View view) {
            view.setScaleX(b(f, f2));
            view.setScaleY(c(f, f2));
            view.setAlpha(a(f, f2));
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    private static class e extends d {
        private e() {
            super(null);
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.d
        protected float c(float f, float f2) {
            return b(f, f2);
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        G = new d(aVar);
        H = new e(aVar);
    }

    public NavigationBarItemView(Context context) {
        super(context);
        this.a = false;
        this.o = -1;
        this.u = G;
        this.v = 0.0f;
        this.w = false;
        this.x = 0;
        this.y = 0;
        this.z = false;
        this.A = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.i = (FrameLayout) findViewById(WB5.navigation_bar_item_icon_container);
        this.j = findViewById(WB5.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(WB5.navigation_bar_item_icon_view);
        this.k = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(WB5.navigation_bar_item_labels_group);
        this.l = viewGroup;
        TextView textView = (TextView) findViewById(WB5.navigation_bar_item_small_label_view);
        this.m = textView;
        TextView textView2 = (TextView) findViewById(WB5.navigation_bar_item_large_label_view);
        this.n = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.b = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.c = viewGroup.getPaddingBottom();
        AbstractC12990fW7.A0(textView, 2);
        AbstractC12990fW7.A0(textView2, 2);
        setFocusable(true);
        g(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new a());
        }
    }

    private void g(float f, float f2) {
        this.d = f - f2;
        this.e = (f2 * 1.0f) / f;
        this.f = (f * 1.0f) / f2;
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.i;
        return frameLayout != null ? frameLayout : this.k;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i = 0;
        for (int i2 = 0; i2 < iIndexOfChild; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    private int getSuggestedIconHeight() {
        com.google.android.material.badge.a aVar = this.B;
        int minimumHeight = aVar != null ? aVar.getMinimumHeight() / 2 : 0;
        return Math.max(minimumHeight, ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin) + this.k.getMeasuredWidth() + minimumHeight;
    }

    private int getSuggestedIconWidth() {
        com.google.android.material.badge.a aVar = this.B;
        int minimumWidth = aVar == null ? 0 : aVar.getMinimumWidth() - this.B.i();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.k.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    private FrameLayout i(View view) {
        ImageView imageView = this.k;
        if (view == imageView && com.google.android.material.badge.b.a) {
            return (FrameLayout) imageView.getParent();
        }
        return null;
    }

    private boolean j() {
        return this.B != null;
    }

    private boolean k() {
        return this.z && this.g == 2;
    }

    private void l(float f) {
        if (!this.w || !this.a || !AbstractC12990fW7.S(this)) {
            o(f, f);
            return;
        }
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.t = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.v, f);
        this.t = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new c(f));
        this.t.setInterpolator(AbstractC16714lk4.e(getContext(), AbstractC12181eA5.motionEasingStandard, AbstractC6732Ot.b));
        this.t.setDuration(AbstractC16714lk4.d(getContext(), AbstractC12181eA5.motionDurationLong1, getResources().getInteger(DC5.material_motion_duration_long_1)));
        this.t.start();
    }

    private void m() {
        g gVar = this.p;
        if (gVar != null) {
            setChecked(gVar.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(float f, float f2) {
        View view = this.j;
        if (view != null) {
            this.u.d(f, f2, view);
        }
        this.v = f;
    }

    private static void p(TextView textView, int i) throws Resources.NotFoundException {
        AbstractC15575jo7.p(textView, i);
        int iH = AbstractC9751aV3.h(textView.getContext(), i, 0);
        if (iH != 0) {
            textView.setTextSize(0, iH);
        }
    }

    private static void q(View view, float f, float f2, int i) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(i);
    }

    private static void r(View view, int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    private void s(View view) throws Resources.NotFoundException {
        if (j() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.b.a(this.B, view, i(view));
        }
    }

    private void t(View view) {
        if (j()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                com.google.android.material.badge.b.d(this.B, view);
            }
            this.B = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(View view) throws Resources.NotFoundException {
        if (j()) {
            com.google.android.material.badge.b.e(this.B, view, i(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i) {
        if (this.j == null) {
            return;
        }
        int iMin = Math.min(this.x, i - (this.A * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.height = k() ? iMin : this.y;
        layoutParams.width = iMin;
        this.j.setLayoutParams(layoutParams);
    }

    private void w() {
        if (k()) {
            this.u = H;
        } else {
            this.u = G;
        }
    }

    private static void x(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void c(g gVar, int i) {
        this.p = gVar;
        setCheckable(gVar.isCheckable());
        setChecked(gVar.isChecked());
        setEnabled(gVar.isEnabled());
        setIcon(gVar.getIcon());
        setTitle(gVar.getTitle());
        setId(gVar.getItemId());
        if (!TextUtils.isEmpty(gVar.getContentDescription())) {
            setContentDescription(gVar.getContentDescription());
        }
        AbstractC8375Vr7.a(this, !TextUtils.isEmpty(gVar.getTooltipText()) ? gVar.getTooltipText() : gVar.getTitle());
        setVisibility(gVar.isVisible() ? 0 : 8);
        this.a = true;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean e() {
        return false;
    }

    public Drawable getActiveIndicatorDrawable() {
        View view = this.j;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    public com.google.android.material.badge.a getBadge() {
        return this.B;
    }

    protected int getItemBackgroundResId() {
        return HB5.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.p;
    }

    protected int getItemDefaultMarginResId() {
        return AbstractC12799fB5.mtrl_navigation_bar_item_default_margin;
    }

    protected abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.o;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.l.getLayoutParams();
        return getSuggestedIconHeight() + layoutParams.topMargin + this.l.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.l.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.l.getMeasuredWidth() + layoutParams.rightMargin);
    }

    void h() {
        n();
        this.p = null;
        this.v = 0.0f;
        this.a = false;
    }

    void n() {
        t(this.k);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        g gVar = this.p;
        if (gVar != null && gVar.isCheckable() && this.p.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, D);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        com.google.android.material.badge.a aVar = this.B;
        if (aVar != null && aVar.isVisible()) {
            CharSequence title = this.p.getTitle();
            if (!TextUtils.isEmpty(this.p.getContentDescription())) {
                title = this.p.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.B.g()));
        }
        X2 x2G1 = X2.g1(accessibilityNodeInfo);
        x2G1.s0(X2.f.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            x2G1.q0(false);
            x2G1.f0(X2.a.i);
        }
        x2G1.P0(getResources().getString(AbstractC23026wD5.item_view_role_description));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new b(i));
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        View view = this.j;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
    }

    public void setActiveIndicatorEnabled(boolean z) {
        this.w = z;
        View view = this.j;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i) {
        this.y = i;
        v(getWidth());
    }

    public void setActiveIndicatorMarginHorizontal(int i) {
        this.A = i;
        v(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z) {
        this.z = z;
    }

    public void setActiveIndicatorWidth(int i) {
        this.x = i;
        v(getWidth());
    }

    void setBadge(com.google.android.material.badge.a aVar) throws Resources.NotFoundException {
        if (this.B == aVar) {
            return;
        }
        if (j() && this.k != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            t(this.k);
        }
        this.B = aVar;
        ImageView imageView = this.k;
        if (imageView != null) {
            s(imageView);
        }
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        this.n.setPivotX(r0.getWidth() / 2);
        this.n.setPivotY(r0.getBaseline());
        this.m.setPivotX(r0.getWidth() / 2);
        this.m.setPivotY(r0.getBaseline());
        l(z ? 1.0f : 0.0f);
        int i = this.g;
        if (i != -1) {
            if (i == 0) {
                if (z) {
                    r(getIconOrContainer(), this.b, 49);
                    x(this.l, this.c);
                    this.n.setVisibility(0);
                } else {
                    r(getIconOrContainer(), this.b, 17);
                    x(this.l, 0);
                    this.n.setVisibility(4);
                }
                this.m.setVisibility(4);
            } else if (i == 1) {
                x(this.l, this.c);
                if (z) {
                    r(getIconOrContainer(), (int) (this.b + this.d), 49);
                    q(this.n, 1.0f, 1.0f, 0);
                    TextView textView = this.m;
                    float f = this.e;
                    q(textView, f, f, 4);
                } else {
                    r(getIconOrContainer(), this.b, 49);
                    TextView textView2 = this.n;
                    float f2 = this.f;
                    q(textView2, f2, f2, 4);
                    q(this.m, 1.0f, 1.0f, 0);
                }
            } else if (i == 2) {
                r(getIconOrContainer(), this.b, 17);
                this.n.setVisibility(8);
                this.m.setVisibility(8);
            }
        } else if (this.h) {
            if (z) {
                r(getIconOrContainer(), this.b, 49);
                x(this.l, this.c);
                this.n.setVisibility(0);
            } else {
                r(getIconOrContainer(), this.b, 17);
                x(this.l, 0);
                this.n.setVisibility(4);
            }
            this.m.setVisibility(4);
        } else {
            x(this.l, this.c);
            if (z) {
                r(getIconOrContainer(), (int) (this.b + this.d), 49);
                q(this.n, 1.0f, 1.0f, 0);
                TextView textView3 = this.m;
                float f3 = this.e;
                q(textView3, f3, f3, 4);
            } else {
                r(getIconOrContainer(), this.b, 49);
                TextView textView4 = this.n;
                float f4 = this.f;
                q(textView4, f4, f4, 4);
                q(this.m, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.m.setEnabled(z);
        this.n.setEnabled(z);
        this.k.setEnabled(z);
        if (z) {
            AbstractC12990fW7.G0(this, C5187Ig5.b(getContext(), 1002));
        } else {
            AbstractC12990fW7.G0(this, null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.r) {
            return;
        }
        this.r = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = AbstractC21710u02.l(drawable).mutate();
            this.s = drawable;
            ColorStateList colorStateList = this.q;
            if (colorStateList != null) {
                AbstractC21710u02.i(drawable, colorStateList);
            }
        }
        this.k.setImageDrawable(drawable);
    }

    public void setIconSize(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.k.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.q = colorStateList;
        if (this.p == null || (drawable = this.s) == null) {
            return;
        }
        AbstractC21710u02.i(drawable, colorStateList);
        this.s.invalidateSelf();
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : AbstractC4043Dl1.f(getContext(), i));
    }

    public void setItemPaddingBottom(int i) {
        if (this.c != i) {
            this.c = i;
            m();
        }
    }

    public void setItemPaddingTop(int i) {
        if (this.b != i) {
            this.b = i;
            m();
        }
    }

    public void setItemPosition(int i) {
        this.o = i;
    }

    public void setLabelVisibilityMode(int i) {
        if (this.g != i) {
            this.g = i;
            w();
            v(getWidth());
            m();
        }
    }

    public void setShifting(boolean z) {
        if (this.h != z) {
            this.h = z;
            m();
        }
    }

    public void setShortcut(boolean z, char c2) {
    }

    public void setTextAppearanceActive(int i) throws Resources.NotFoundException {
        p(this.n, i);
        g(this.m.getTextSize(), this.n.getTextSize());
    }

    public void setTextAppearanceInactive(int i) throws Resources.NotFoundException {
        p(this.m, i);
        g(this.m.getTextSize(), this.n.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.m.setTextColor(colorStateList);
            this.n.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.m.setText(charSequence);
        this.n.setText(charSequence);
        g gVar = this.p;
        if (gVar == null || TextUtils.isEmpty(gVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
        g gVar2 = this.p;
        if (gVar2 != null && !TextUtils.isEmpty(gVar2.getTooltipText())) {
            charSequence = this.p.getTooltipText();
        }
        AbstractC8375Vr7.a(this, charSequence);
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        AbstractC12990fW7.t0(this, drawable);
    }
}
