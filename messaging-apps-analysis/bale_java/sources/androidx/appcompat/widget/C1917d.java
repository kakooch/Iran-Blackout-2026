package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.HE5;

/* renamed from: androidx.appcompat.widget.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1917d {
    private final View a;
    private A d;
    private A e;
    private A f;
    private int c = -1;
    private final g b = g.b();

    C1917d(View view) {
        this.a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f == null) {
            this.f = new A();
        }
        A a = this.f;
        a.a();
        ColorStateList colorStateListR = AbstractC12990fW7.r(this.a);
        if (colorStateListR != null) {
            a.d = true;
            a.a = colorStateListR;
        }
        PorterDuff.Mode modeS = AbstractC12990fW7.s(this.a);
        if (modeS != null) {
            a.c = true;
            a.b = modeS;
        }
        if (!a.d && !a.c) {
            return false;
        }
        g.i(drawable, a, this.a.getDrawableState());
        return true;
    }

    private boolean k() {
        return this.d != null;
    }

    void b() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            A a = this.e;
            if (a != null) {
                g.i(background, a, this.a.getDrawableState());
                return;
            }
            A a2 = this.d;
            if (a2 != null) {
                g.i(background, a2, this.a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        A a = this.e;
        if (a != null) {
            return a.a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        A a = this.e;
        if (a != null) {
            return a.b;
        }
        return null;
    }

    void e(AttributeSet attributeSet, int i) {
        C cV = C.v(this.a.getContext(), attributeSet, HE5.ViewBackgroundHelper, i, 0);
        View view = this.a;
        AbstractC12990fW7.n0(view, view.getContext(), HE5.ViewBackgroundHelper, attributeSet, cV.r(), i, 0);
        try {
            if (cV.s(HE5.ViewBackgroundHelper_android_background)) {
                this.c = cV.n(HE5.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListF = this.b.f(this.a.getContext(), this.c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            if (cV.s(HE5.ViewBackgroundHelper_backgroundTint)) {
                AbstractC12990fW7.u0(this.a, cV.c(HE5.ViewBackgroundHelper_backgroundTint));
            }
            if (cV.s(HE5.ViewBackgroundHelper_backgroundTintMode)) {
                AbstractC12990fW7.v0(this.a, r.e(cV.k(HE5.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            cV.w();
        } catch (Throwable th) {
            cV.w();
            throw th;
        }
    }

    void f(Drawable drawable) {
        this.c = -1;
        h(null);
        b();
    }

    void g(int i) {
        this.c = i;
        g gVar = this.b;
        h(gVar != null ? gVar.f(this.a.getContext(), i) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new A();
            }
            A a = this.d;
            a.a = colorStateList;
            a.d = true;
        } else {
            this.d = null;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new A();
        }
        A a = this.e;
        a.a = colorStateList;
        a.d = true;
        b();
    }

    void j(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new A();
        }
        A a = this.e;
        a.b = mode;
        a.c = true;
        b();
    }
}
