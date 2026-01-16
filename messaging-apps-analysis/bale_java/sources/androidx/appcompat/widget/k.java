package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC14525i33;
import ir.nasim.AbstractC9594aE;
import ir.nasim.HE5;

/* loaded from: classes.dex */
public class k {
    private final ImageView a;
    private A b;
    private A c;
    private A d;
    private int e = 0;

    public k(ImageView imageView) {
        this.a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new A();
        }
        A a = this.d;
        a.a();
        ColorStateList colorStateListA = AbstractC14525i33.a(this.a);
        if (colorStateListA != null) {
            a.d = true;
            a.a = colorStateListA;
        }
        PorterDuff.Mode modeB = AbstractC14525i33.b(this.a);
        if (modeB != null) {
            a.c = true;
            a.b = modeB;
        }
        if (!a.d && !a.c) {
            return false;
        }
        g.i(drawable, a, this.a.getDrawableState());
        return true;
    }

    private boolean l() {
        return this.b != null;
    }

    void b() {
        if (this.a.getDrawable() != null) {
            this.a.getDrawable().setLevel(this.e);
        }
    }

    void c() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            r.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            A a = this.c;
            if (a != null) {
                g.i(drawable, a, this.a.getDrawableState());
                return;
            }
            A a2 = this.b;
            if (a2 != null) {
                g.i(drawable, a2, this.a.getDrawableState());
            }
        }
    }

    ColorStateList d() {
        A a = this.c;
        if (a != null) {
            return a.a;
        }
        return null;
    }

    PorterDuff.Mode e() {
        A a = this.c;
        if (a != null) {
            return a.b;
        }
        return null;
    }

    boolean f() {
        return !(this.a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i) {
        int iN;
        C cV = C.v(this.a.getContext(), attributeSet, HE5.AppCompatImageView, i, 0);
        ImageView imageView = this.a;
        AbstractC12990fW7.n0(imageView, imageView.getContext(), HE5.AppCompatImageView, attributeSet, cV.r(), i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null && (iN = cV.n(HE5.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = AbstractC9594aE.b(this.a.getContext(), iN)) != null) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                r.b(drawable);
            }
            if (cV.s(HE5.AppCompatImageView_tint)) {
                AbstractC14525i33.c(this.a, cV.c(HE5.AppCompatImageView_tint));
            }
            if (cV.s(HE5.AppCompatImageView_tintMode)) {
                AbstractC14525i33.d(this.a, r.e(cV.k(HE5.AppCompatImageView_tintMode, -1), null));
            }
            cV.w();
        } catch (Throwable th) {
            cV.w();
            throw th;
        }
    }

    void h(Drawable drawable) {
        this.e = drawable.getLevel();
    }

    public void i(int i) {
        if (i != 0) {
            Drawable drawableB = AbstractC9594aE.b(this.a.getContext(), i);
            if (drawableB != null) {
                r.b(drawableB);
            }
            this.a.setImageDrawable(drawableB);
        } else {
            this.a.setImageDrawable(null);
        }
        c();
    }

    void j(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new A();
        }
        A a = this.c;
        a.a = colorStateList;
        a.d = true;
        c();
    }

    void k(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new A();
        }
        A a = this.c;
        a.b = mode;
        a.c = true;
        c();
    }
}
