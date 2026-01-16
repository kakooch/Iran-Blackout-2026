package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC17222mc1;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC9594aE;
import ir.nasim.HE5;

/* renamed from: androidx.appcompat.widget.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1919f {
    private final CompoundButton a;
    private ColorStateList b = null;
    private PorterDuff.Mode c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;

    C1919f(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    void a() {
        Drawable drawableA = AbstractC17222mc1.a(this.a);
        if (drawableA != null) {
            if (this.d || this.e) {
                Drawable drawableMutate = AbstractC21710u02.l(drawableA).mutate();
                if (this.d) {
                    AbstractC21710u02.i(drawableMutate, this.b);
                }
                if (this.e) {
                    AbstractC21710u02.j(drawableMutate, this.c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.a.getDrawableState());
                }
                this.a.setButtonDrawable(drawableMutate);
            }
        }
    }

    int b(int i) {
        return i;
    }

    ColorStateList c() {
        return this.b;
    }

    PorterDuff.Mode d() {
        return this.c;
    }

    void e(AttributeSet attributeSet, int i) {
        int iN;
        int iN2;
        C cV = C.v(this.a.getContext(), attributeSet, HE5.CompoundButton, i, 0);
        CompoundButton compoundButton = this.a;
        AbstractC12990fW7.n0(compoundButton, compoundButton.getContext(), HE5.CompoundButton, attributeSet, cV.r(), i, 0);
        try {
            if (cV.s(HE5.CompoundButton_buttonCompat) && (iN2 = cV.n(HE5.CompoundButton_buttonCompat, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.a;
                    compoundButton2.setButtonDrawable(AbstractC9594aE.b(compoundButton2.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (cV.s(HE5.CompoundButton_android_button) && (iN = cV.n(HE5.CompoundButton_android_button, 0)) != 0) {
                CompoundButton compoundButton3 = this.a;
                compoundButton3.setButtonDrawable(AbstractC9594aE.b(compoundButton3.getContext(), iN));
            }
            if (cV.s(HE5.CompoundButton_buttonTint)) {
                AbstractC17222mc1.c(this.a, cV.c(HE5.CompoundButton_buttonTint));
            }
            if (cV.s(HE5.CompoundButton_buttonTintMode)) {
                AbstractC17222mc1.d(this.a, r.e(cV.k(HE5.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            cV.w();
        }
    }

    void f() {
        if (this.f) {
            this.f = false;
        } else {
            this.f = true;
            a();
        }
    }

    void g(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.d = true;
        a();
    }

    void h(PorterDuff.Mode mode) {
        this.c = mode;
        this.e = true;
        a();
    }
}
