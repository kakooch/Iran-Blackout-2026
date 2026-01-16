package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC24930zS0;
import ir.nasim.AbstractC9594aE;
import ir.nasim.HE5;

/* renamed from: androidx.appcompat.widget.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1918e {
    private final CheckedTextView a;
    private ColorStateList b = null;
    private PorterDuff.Mode c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;

    C1918e(CheckedTextView checkedTextView) {
        this.a = checkedTextView;
    }

    void a() {
        Drawable drawableA = AbstractC24930zS0.a(this.a);
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
                this.a.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    ColorStateList b() {
        return this.b;
    }

    PorterDuff.Mode c() {
        return this.c;
    }

    void d(AttributeSet attributeSet, int i) {
        int iN;
        int iN2;
        C cV = C.v(this.a.getContext(), attributeSet, HE5.CheckedTextView, i, 0);
        CheckedTextView checkedTextView = this.a;
        AbstractC12990fW7.n0(checkedTextView, checkedTextView.getContext(), HE5.CheckedTextView, attributeSet, cV.r(), i, 0);
        try {
            if (cV.s(HE5.CheckedTextView_checkMarkCompat) && (iN2 = cV.n(HE5.CheckedTextView_checkMarkCompat, 0)) != 0) {
                try {
                    CheckedTextView checkedTextView2 = this.a;
                    checkedTextView2.setCheckMarkDrawable(AbstractC9594aE.b(checkedTextView2.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (cV.s(HE5.CheckedTextView_android_checkMark) && (iN = cV.n(HE5.CheckedTextView_android_checkMark, 0)) != 0) {
                CheckedTextView checkedTextView3 = this.a;
                checkedTextView3.setCheckMarkDrawable(AbstractC9594aE.b(checkedTextView3.getContext(), iN));
            }
            if (cV.s(HE5.CheckedTextView_checkMarkTint)) {
                AbstractC24930zS0.b(this.a, cV.c(HE5.CheckedTextView_checkMarkTint));
            }
            if (cV.s(HE5.CheckedTextView_checkMarkTintMode)) {
                AbstractC24930zS0.c(this.a, r.e(cV.k(HE5.CheckedTextView_checkMarkTintMode, -1), null));
            }
        } finally {
            cV.w();
        }
    }

    void e() {
        if (this.f) {
            this.f = false;
        } else {
            this.f = true;
            a();
        }
    }

    void f(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.d = true;
        a();
    }

    void g(PorterDuff.Mode mode) {
        this.c = mode;
        this.e = true;
        a();
    }
}
