package com.google.android.material.card;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import ir.nasim.AbstractC11317co1;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC24690z26;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C10345bV3;
import ir.nasim.C11411cx6;
import ir.nasim.C6271Mx1;
import ir.nasim.GE5;
import ir.nasim.O46;
import ir.nasim.WB5;
import ir.nasim.WU3;

/* loaded from: classes3.dex */
class a {
    private static final double u = Math.cos(Math.toRadians(45.0d));
    private static final Drawable v;
    private final MaterialCardView a;
    private final C10345bV3 c;
    private final C10345bV3 d;
    private int e;
    private int f;
    private int g;
    private int h;
    private Drawable i;
    private Drawable j;
    private ColorStateList k;
    private ColorStateList l;
    private C11411cx6 m;
    private ColorStateList n;
    private Drawable o;
    private LayerDrawable p;
    private C10345bV3 q;
    private C10345bV3 r;
    private boolean t;
    private final Rect b = new Rect();
    private boolean s = false;

    /* renamed from: com.google.android.material.card.a$a, reason: collision with other inner class name */
    class C0179a extends InsetDrawable {
        C0179a(Drawable drawable, int i, int i2, int i3, int i4) {
            super(drawable, i, i2, i3, i4);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    static {
        v = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public a(MaterialCardView materialCardView, AttributeSet attributeSet, int i, int i2) {
        this.a = materialCardView;
        C10345bV3 c10345bV3 = new C10345bV3(materialCardView.getContext(), attributeSet, i, i2);
        this.c = c10345bV3;
        c10345bV3.Q(materialCardView.getContext());
        c10345bV3.h0(-12303292);
        C11411cx6.b bVarV = c10345bV3.E().v();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, GE5.CardView, i, AbstractC21175tE5.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(GE5.CardView_cardCornerRadius)) {
            bVarV.o(typedArrayObtainStyledAttributes.getDimension(GE5.CardView_cardCornerRadius, 0.0f));
        }
        this.d = new C10345bV3();
        V(bVarV.m());
        typedArrayObtainStyledAttributes.recycle();
    }

    private Drawable B(Drawable drawable) {
        int iCeil;
        int iCeil2;
        if (this.a.getUseCompatPadding()) {
            iCeil2 = (int) Math.ceil(d());
            iCeil = (int) Math.ceil(c());
        } else {
            iCeil = 0;
            iCeil2 = 0;
        }
        return new C0179a(drawable, iCeil, iCeil2, iCeil, iCeil2);
    }

    private boolean E() {
        return (this.g & 80) == 80;
    }

    private boolean F() {
        return (this.g & 8388613) == 8388613;
    }

    private boolean Z() {
        return this.a.getPreventCornerOverlap() && !e();
    }

    private float a() {
        return Math.max(Math.max(b(this.m.q(), this.c.J()), b(this.m.s(), this.c.K())), Math.max(b(this.m.k(), this.c.t()), b(this.m.i(), this.c.s())));
    }

    private boolean a0() {
        return this.a.getPreventCornerOverlap() && e() && this.a.getUseCompatPadding();
    }

    private float b(AbstractC11317co1 abstractC11317co1, float f) {
        if (abstractC11317co1 instanceof O46) {
            return (float) ((1.0d - u) * f);
        }
        if (abstractC11317co1 instanceof C6271Mx1) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    private float c() {
        return this.a.getMaxCardElevation() + (a0() ? a() : 0.0f);
    }

    private float d() {
        return (this.a.getMaxCardElevation() * 1.5f) + (a0() ? a() : 0.0f);
    }

    private boolean e() {
        return this.c.T();
    }

    private void e0(Drawable drawable) {
        if (this.a.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) this.a.getForeground()).setDrawable(drawable);
        } else {
            this.a.setForeground(B(drawable));
        }
    }

    private Drawable f() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        C10345bV3 c10345bV3H = h();
        this.q = c10345bV3H;
        c10345bV3H.b0(this.k);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.q);
        return stateListDrawable;
    }

    private Drawable g() {
        if (!AbstractC24690z26.a) {
            return f();
        }
        this.r = h();
        return new RippleDrawable(this.k, null, this.r);
    }

    private void g0() {
        Drawable drawable;
        if (AbstractC24690z26.a && (drawable = this.o) != null) {
            ((RippleDrawable) drawable).setColor(this.k);
            return;
        }
        C10345bV3 c10345bV3 = this.q;
        if (c10345bV3 != null) {
            c10345bV3.b0(this.k);
        }
    }

    private C10345bV3 h() {
        return new C10345bV3(this.m);
    }

    private Drawable r() {
        if (this.o == null) {
            this.o = g();
        }
        if (this.p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.o, this.d, this.j});
            this.p = layerDrawable;
            layerDrawable.setId(2, WB5.mtrl_card_checked_layer_id);
        }
        return this.p;
    }

    private float t() {
        if (this.a.getPreventCornerOverlap() && this.a.getUseCompatPadding()) {
            return (float) ((1.0d - u) * this.a.getCardViewRadius());
        }
        return 0.0f;
    }

    Rect A() {
        return this.b;
    }

    boolean C() {
        return this.s;
    }

    boolean D() {
        return this.t;
    }

    void G(TypedArray typedArray) {
        ColorStateList colorStateListA = AbstractC9751aV3.a(this.a.getContext(), typedArray, GE5.MaterialCardView_strokeColor);
        this.n = colorStateListA;
        if (colorStateListA == null) {
            this.n = ColorStateList.valueOf(-1);
        }
        this.h = typedArray.getDimensionPixelSize(GE5.MaterialCardView_strokeWidth, 0);
        boolean z = typedArray.getBoolean(GE5.MaterialCardView_android_checkable, false);
        this.t = z;
        this.a.setLongClickable(z);
        this.l = AbstractC9751aV3.a(this.a.getContext(), typedArray, GE5.MaterialCardView_checkedIconTint);
        N(AbstractC9751aV3.e(this.a.getContext(), typedArray, GE5.MaterialCardView_checkedIcon));
        Q(typedArray.getDimensionPixelSize(GE5.MaterialCardView_checkedIconSize, 0));
        P(typedArray.getDimensionPixelSize(GE5.MaterialCardView_checkedIconMargin, 0));
        this.g = typedArray.getInteger(GE5.MaterialCardView_checkedIconGravity, 8388661);
        ColorStateList colorStateListA2 = AbstractC9751aV3.a(this.a.getContext(), typedArray, GE5.MaterialCardView_rippleColor);
        this.k = colorStateListA2;
        if (colorStateListA2 == null) {
            this.k = ColorStateList.valueOf(WU3.d(this.a, AbstractC12181eA5.colorControlHighlight));
        }
        K(AbstractC9751aV3.a(this.a.getContext(), typedArray, GE5.MaterialCardView_cardForegroundColor));
        g0();
        d0();
        h0();
        this.a.setBackgroundInternal(B(this.c));
        Drawable drawableR = this.a.isClickable() ? r() : this.d;
        this.i = drawableR;
        this.a.setForeground(B(drawableR));
    }

    void H(int i, int i2) {
        int iCeil;
        int iCeil2;
        int i3;
        int i4;
        if (this.p != null) {
            if (this.a.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(d() * 2.0f);
                iCeil2 = (int) Math.ceil(c() * 2.0f);
            } else {
                iCeil = 0;
                iCeil2 = 0;
            }
            int i5 = F() ? ((i - this.e) - this.f) - iCeil2 : this.e;
            int i6 = E() ? this.e : ((i2 - this.e) - this.f) - iCeil;
            int i7 = F() ? this.e : ((i - this.e) - this.f) - iCeil2;
            int i8 = E() ? ((i2 - this.e) - this.f) - iCeil : this.e;
            if (AbstractC12990fW7.A(this.a) == 1) {
                i4 = i7;
                i3 = i5;
            } else {
                i3 = i7;
                i4 = i5;
            }
            this.p.setLayerInset(2, i4, i8, i3, i6);
        }
    }

    void I(boolean z) {
        this.s = z;
    }

    void J(ColorStateList colorStateList) {
        this.c.b0(colorStateList);
    }

    void K(ColorStateList colorStateList) {
        C10345bV3 c10345bV3 = this.d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        c10345bV3.b0(colorStateList);
    }

    void L(boolean z) {
        this.t = z;
    }

    public void M(boolean z) {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.setAlpha(z ? 255 : 0);
        }
    }

    void N(Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = AbstractC21710u02.l(drawable).mutate();
            this.j = drawableMutate;
            AbstractC21710u02.i(drawableMutate, this.l);
            M(this.a.isChecked());
        } else {
            this.j = v;
        }
        LayerDrawable layerDrawable = this.p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(WB5.mtrl_card_checked_layer_id, this.j);
        }
    }

    void O(int i) {
        this.g = i;
        H(this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
    }

    void P(int i) {
        this.e = i;
    }

    void Q(int i) {
        this.f = i;
    }

    void R(ColorStateList colorStateList) {
        this.l = colorStateList;
        Drawable drawable = this.j;
        if (drawable != null) {
            AbstractC21710u02.i(drawable, colorStateList);
        }
    }

    void S(float f) {
        V(this.m.w(f));
        this.i.invalidateSelf();
        if (a0() || Z()) {
            c0();
        }
        if (a0()) {
            f0();
        }
    }

    void T(float f) {
        this.c.c0(f);
        C10345bV3 c10345bV3 = this.d;
        if (c10345bV3 != null) {
            c10345bV3.c0(f);
        }
        C10345bV3 c10345bV32 = this.r;
        if (c10345bV32 != null) {
            c10345bV32.c0(f);
        }
    }

    void U(ColorStateList colorStateList) {
        this.k = colorStateList;
        g0();
    }

    void V(C11411cx6 c11411cx6) {
        this.m = c11411cx6;
        this.c.setShapeAppearanceModel(c11411cx6);
        this.c.g0(!r0.T());
        C10345bV3 c10345bV3 = this.d;
        if (c10345bV3 != null) {
            c10345bV3.setShapeAppearanceModel(c11411cx6);
        }
        C10345bV3 c10345bV32 = this.r;
        if (c10345bV32 != null) {
            c10345bV32.setShapeAppearanceModel(c11411cx6);
        }
        C10345bV3 c10345bV33 = this.q;
        if (c10345bV33 != null) {
            c10345bV33.setShapeAppearanceModel(c11411cx6);
        }
    }

    void W(ColorStateList colorStateList) {
        if (this.n == colorStateList) {
            return;
        }
        this.n = colorStateList;
        h0();
    }

    void X(int i) {
        if (i == this.h) {
            return;
        }
        this.h = i;
        h0();
    }

    void Y(int i, int i2, int i3, int i4) {
        this.b.set(i, i2, i3, i4);
        c0();
    }

    void b0() {
        Drawable drawable = this.i;
        Drawable drawableR = this.a.isClickable() ? r() : this.d;
        this.i = drawableR;
        if (drawable != drawableR) {
            e0(drawableR);
        }
    }

    void c0() {
        int iA = (int) (((Z() || a0()) ? a() : 0.0f) - t());
        MaterialCardView materialCardView = this.a;
        Rect rect = this.b;
        materialCardView.j(rect.left + iA, rect.top + iA, rect.right + iA, rect.bottom + iA);
    }

    void d0() {
        this.c.a0(this.a.getCardElevation());
    }

    void f0() {
        if (!C()) {
            this.a.setBackgroundInternal(B(this.c));
        }
        this.a.setForeground(B(this.i));
    }

    void h0() {
        this.d.k0(this.h, this.n);
    }

    void i() {
        Drawable drawable = this.o;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i = bounds.bottom;
            this.o.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
            this.o.setBounds(bounds.left, bounds.top, bounds.right, i);
        }
    }

    C10345bV3 j() {
        return this.c;
    }

    ColorStateList k() {
        return this.c.x();
    }

    ColorStateList l() {
        return this.d.x();
    }

    Drawable m() {
        return this.j;
    }

    int n() {
        return this.g;
    }

    int o() {
        return this.e;
    }

    int p() {
        return this.f;
    }

    ColorStateList q() {
        return this.l;
    }

    float s() {
        return this.c.J();
    }

    float u() {
        return this.c.y();
    }

    ColorStateList v() {
        return this.k;
    }

    C11411cx6 w() {
        return this.m;
    }

    int x() {
        ColorStateList colorStateList = this.n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    ColorStateList y() {
        return this.n;
    }

    int z() {
        return this.h;
    }
}
