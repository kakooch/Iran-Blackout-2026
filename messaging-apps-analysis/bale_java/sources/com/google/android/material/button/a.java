package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC24690z26;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C10345bV3;
import ir.nasim.C11411cx6;
import ir.nasim.C21060t26;
import ir.nasim.GE5;
import ir.nasim.InterfaceC4873Gx6;
import ir.nasim.WU3;

/* loaded from: classes3.dex */
class a {
    private static final boolean t = true;
    private static final boolean u = false;
    private final MaterialButton a;
    private C11411cx6 b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private PorterDuff.Mode i;
    private ColorStateList j;
    private ColorStateList k;
    private ColorStateList l;
    private Drawable m;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q;
    private LayerDrawable r;
    private int s;

    a(MaterialButton materialButton, C11411cx6 c11411cx6) {
        this.a = materialButton;
        this.b = c11411cx6;
    }

    private void E(int i, int i2) {
        int iF = AbstractC12990fW7.F(this.a);
        int paddingTop = this.a.getPaddingTop();
        int iE = AbstractC12990fW7.E(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        int i3 = this.e;
        int i4 = this.f;
        this.f = i2;
        this.e = i;
        if (!this.o) {
            F();
        }
        AbstractC12990fW7.F0(this.a, iF, (paddingTop + i) - i3, iE, (paddingBottom + i2) - i4);
    }

    private void F() {
        this.a.setInternalBackground(a());
        C10345bV3 c10345bV3F = f();
        if (c10345bV3F != null) {
            c10345bV3F.a0(this.s);
        }
    }

    private void G(C11411cx6 c11411cx6) {
        if (u && !this.o) {
            int iF = AbstractC12990fW7.F(this.a);
            int paddingTop = this.a.getPaddingTop();
            int iE = AbstractC12990fW7.E(this.a);
            int paddingBottom = this.a.getPaddingBottom();
            F();
            AbstractC12990fW7.F0(this.a, iF, paddingTop, iE, paddingBottom);
            return;
        }
        if (f() != null) {
            f().setShapeAppearanceModel(c11411cx6);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(c11411cx6);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(c11411cx6);
        }
    }

    private void H() {
        C10345bV3 c10345bV3F = f();
        C10345bV3 c10345bV3N = n();
        if (c10345bV3F != null) {
            c10345bV3F.k0(this.h, this.k);
            if (c10345bV3N != null) {
                c10345bV3N.j0(this.h, this.n ? WU3.d(this.a, AbstractC12181eA5.colorSurface) : 0);
            }
        }
    }

    private InsetDrawable I(Drawable drawable) {
        return new InsetDrawable(drawable, this.c, this.e, this.d, this.f);
    }

    private Drawable a() {
        C10345bV3 c10345bV3 = new C10345bV3(this.b);
        c10345bV3.Q(this.a.getContext());
        AbstractC21710u02.i(c10345bV3, this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            AbstractC21710u02.j(c10345bV3, mode);
        }
        c10345bV3.k0(this.h, this.k);
        C10345bV3 c10345bV32 = new C10345bV3(this.b);
        c10345bV32.setTint(0);
        c10345bV32.j0(this.h, this.n ? WU3.d(this.a, AbstractC12181eA5.colorSurface) : 0);
        if (t) {
            C10345bV3 c10345bV33 = new C10345bV3(this.b);
            this.m = c10345bV33;
            AbstractC21710u02.h(c10345bV33, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(AbstractC24690z26.d(this.l), I(new LayerDrawable(new Drawable[]{c10345bV32, c10345bV3})), this.m);
            this.r = rippleDrawable;
            return rippleDrawable;
        }
        C21060t26 c21060t26 = new C21060t26(this.b);
        this.m = c21060t26;
        AbstractC21710u02.i(c21060t26, AbstractC24690z26.d(this.l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{c10345bV32, c10345bV3, this.m});
        this.r = layerDrawable;
        return I(layerDrawable);
    }

    private C10345bV3 g(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return t ? (C10345bV3) ((LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0) : (C10345bV3) this.r.getDrawable(!z ? 1 : 0);
    }

    private C10345bV3 n() {
        return g(true);
    }

    void A(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            H();
        }
    }

    void B(int i) {
        if (this.h != i) {
            this.h = i;
            H();
        }
    }

    void C(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            if (f() != null) {
                AbstractC21710u02.i(f(), this.j);
            }
        }
    }

    void D(PorterDuff.Mode mode) {
        if (this.i != mode) {
            this.i = mode;
            if (f() == null || this.i == null) {
                return;
            }
            AbstractC21710u02.j(f(), this.i);
        }
    }

    int b() {
        return this.g;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.e;
    }

    public InterfaceC4873Gx6 e() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.r.getNumberOfLayers() > 2 ? (InterfaceC4873Gx6) this.r.getDrawable(2) : (InterfaceC4873Gx6) this.r.getDrawable(1);
    }

    C10345bV3 f() {
        return g(false);
    }

    ColorStateList h() {
        return this.l;
    }

    C11411cx6 i() {
        return this.b;
    }

    ColorStateList j() {
        return this.k;
    }

    int k() {
        return this.h;
    }

    ColorStateList l() {
        return this.j;
    }

    PorterDuff.Mode m() {
        return this.i;
    }

    boolean o() {
        return this.o;
    }

    boolean p() {
        return this.q;
    }

    void q(TypedArray typedArray) {
        this.c = typedArray.getDimensionPixelOffset(GE5.MaterialButton_android_insetLeft, 0);
        this.d = typedArray.getDimensionPixelOffset(GE5.MaterialButton_android_insetRight, 0);
        this.e = typedArray.getDimensionPixelOffset(GE5.MaterialButton_android_insetTop, 0);
        this.f = typedArray.getDimensionPixelOffset(GE5.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(GE5.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(GE5.MaterialButton_cornerRadius, -1);
            this.g = dimensionPixelSize;
            y(this.b.w(dimensionPixelSize));
            this.p = true;
        }
        this.h = typedArray.getDimensionPixelSize(GE5.MaterialButton_strokeWidth, 0);
        this.i = AbstractC10402bY7.k(typedArray.getInt(GE5.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.j = AbstractC9751aV3.a(this.a.getContext(), typedArray, GE5.MaterialButton_backgroundTint);
        this.k = AbstractC9751aV3.a(this.a.getContext(), typedArray, GE5.MaterialButton_strokeColor);
        this.l = AbstractC9751aV3.a(this.a.getContext(), typedArray, GE5.MaterialButton_rippleColor);
        this.q = typedArray.getBoolean(GE5.MaterialButton_android_checkable, false);
        this.s = typedArray.getDimensionPixelSize(GE5.MaterialButton_elevation, 0);
        int iF = AbstractC12990fW7.F(this.a);
        int paddingTop = this.a.getPaddingTop();
        int iE = AbstractC12990fW7.E(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        if (typedArray.hasValue(GE5.MaterialButton_android_background)) {
            s();
        } else {
            F();
        }
        AbstractC12990fW7.F0(this.a, iF + this.c, paddingTop + this.e, iE + this.d, paddingBottom + this.f);
    }

    void r(int i) {
        if (f() != null) {
            f().setTint(i);
        }
    }

    void s() {
        this.o = true;
        this.a.setSupportBackgroundTintList(this.j);
        this.a.setSupportBackgroundTintMode(this.i);
    }

    void t(boolean z) {
        this.q = z;
    }

    void u(int i) {
        if (this.p && this.g == i) {
            return;
        }
        this.g = i;
        this.p = true;
        y(this.b.w(i));
    }

    public void v(int i) {
        E(this.e, i);
    }

    public void w(int i) {
        E(i, this.f);
    }

    void x(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            boolean z = t;
            if (z && (this.a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.a.getBackground()).setColor(AbstractC24690z26.d(colorStateList));
            } else {
                if (z || !(this.a.getBackground() instanceof C21060t26)) {
                    return;
                }
                ((C21060t26) this.a.getBackground()).setTintList(AbstractC24690z26.d(colorStateList));
            }
        }
    }

    void y(C11411cx6 c11411cx6) {
        this.b = c11411cx6;
        G(c11411cx6);
    }

    void z(boolean z) {
        this.n = z;
        H();
    }
}
